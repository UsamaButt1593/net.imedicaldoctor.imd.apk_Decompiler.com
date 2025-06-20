package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableJoin<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AbstractObservableWithUpstream<TLeft, R> {
    final ObservableSource<? extends TRight> X;
    final BiFunction<? super TLeft, ? super TRight, ? extends R> X2;
    final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> Y;
    final Function<? super TRight, ? extends ObservableSource<TRightEnd>> Z;

    static final class JoinDisposable<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements Disposable, ObservableGroupJoin.JoinSupport {
        private static final long g3 = -6071216598687999801L;
        static final Integer h3 = 1;
        static final Integer i3 = 2;
        static final Integer j3 = 3;
        static final Integer k3 = 4;
        final SpscLinkedArrayQueue<Object> X = new SpscLinkedArrayQueue<>(Observable.U());
        final Map<Integer, TRight> X2 = new LinkedHashMap();
        final CompositeDisposable Y = new CompositeDisposable();
        final AtomicReference<Throwable> Y2 = new AtomicReference<>();
        final Map<Integer, TLeft> Z = new LinkedHashMap();
        final Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> Z2;
        final Function<? super TRight, ? extends ObservableSource<TRightEnd>> a3;
        final BiFunction<? super TLeft, ? super TRight, ? extends R> b3;
        final AtomicInteger c3;
        int d3;
        int e3;
        volatile boolean f3;
        final Observer<? super R> s;

        JoinDisposable(Observer<? super R> observer, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
            this.s = observer;
            this.Z2 = function;
            this.a3 = function2;
            this.b3 = biFunction;
            this.c3 = new AtomicInteger(2);
        }

        public void a(Throwable th) {
            if (ExceptionHelper.a(this.Y2, th)) {
                h();
            } else {
                RxJavaPlugins.Y(th);
            }
        }

        public void b(boolean z, Object obj) {
            synchronized (this) {
                try {
                    this.X.q(z ? h3 : i3, obj);
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            h();
        }

        public void c(Throwable th) {
            if (ExceptionHelper.a(this.Y2, th)) {
                this.c3.decrementAndGet();
                h();
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void d(boolean z, ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver) {
            synchronized (this) {
                try {
                    this.X.q(z ? j3 : k3, leftRightEndObserver);
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
            h();
        }

        public void e(ObservableGroupJoin.LeftRightObserver leftRightObserver) {
            this.Y.c(leftRightObserver);
            this.c3.decrementAndGet();
            h();
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.Y.m();
        }

        public boolean g() {
            return this.f3;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            if (getAndIncrement() == 0) {
                SpscLinkedArrayQueue<Object> spscLinkedArrayQueue = this.X;
                Observer<? super R> observer = this.s;
                int i2 = 1;
                while (!this.f3) {
                    if (this.Y2.get() != null) {
                        spscLinkedArrayQueue.clear();
                        f();
                        i(observer);
                        return;
                    }
                    boolean z = this.c3.get() == 0;
                    Integer num = (Integer) spscLinkedArrayQueue.poll();
                    boolean z2 = num == null;
                    if (z && z2) {
                        this.Z.clear();
                        this.X2.clear();
                        this.Y.m();
                        observer.onComplete();
                        return;
                    } else if (z2) {
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        Object poll = spscLinkedArrayQueue.poll();
                        if (num == h3) {
                            int i4 = this.d3;
                            this.d3 = i4 + 1;
                            this.Z.put(Integer.valueOf(i4), poll);
                            try {
                                Object apply = this.Z2.apply(poll);
                                Objects.requireNonNull(apply, "The leftEnd returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver = new ObservableGroupJoin.LeftRightEndObserver(this, true, i4);
                                this.Y.b(leftRightEndObserver);
                                observableSource.a(leftRightEndObserver);
                                if (this.Y2.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    f();
                                    i(observer);
                                    return;
                                }
                                for (TRight apply2 : this.X2.values()) {
                                    try {
                                        Object apply3 = this.b3.apply(poll, apply2);
                                        Objects.requireNonNull(apply3, "The resultSelector returned a null value");
                                        observer.onNext(apply3);
                                    } catch (Throwable th) {
                                        j(th, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            } catch (Throwable th2) {
                                j(th2, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else if (num == i3) {
                            int i5 = this.e3;
                            this.e3 = i5 + 1;
                            this.X2.put(Integer.valueOf(i5), poll);
                            try {
                                Object apply4 = this.a3.apply(poll);
                                Objects.requireNonNull(apply4, "The rightEnd returned a null ObservableSource");
                                ObservableSource observableSource2 = (ObservableSource) apply4;
                                ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver2 = new ObservableGroupJoin.LeftRightEndObserver(this, false, i5);
                                this.Y.b(leftRightEndObserver2);
                                observableSource2.a(leftRightEndObserver2);
                                if (this.Y2.get() != null) {
                                    spscLinkedArrayQueue.clear();
                                    f();
                                    i(observer);
                                    return;
                                }
                                for (TLeft apply5 : this.Z.values()) {
                                    try {
                                        Object apply6 = this.b3.apply(apply5, poll);
                                        Objects.requireNonNull(apply6, "The resultSelector returned a null value");
                                        observer.onNext(apply6);
                                    } catch (Throwable th3) {
                                        j(th3, observer, spscLinkedArrayQueue);
                                        return;
                                    }
                                }
                            } catch (Throwable th4) {
                                j(th4, observer, spscLinkedArrayQueue);
                                return;
                            }
                        } else {
                            ObservableGroupJoin.LeftRightEndObserver leftRightEndObserver3 = (ObservableGroupJoin.LeftRightEndObserver) poll;
                            (num == j3 ? this.Z : this.X2).remove(Integer.valueOf(leftRightEndObserver3.Y));
                            this.Y.a(leftRightEndObserver3);
                        }
                    }
                }
                spscLinkedArrayQueue.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void i(Observer<?> observer) {
            Throwable f2 = ExceptionHelper.f(this.Y2);
            this.Z.clear();
            this.X2.clear();
            observer.onError(f2);
        }

        /* access modifiers changed from: package-private */
        public void j(Throwable th, Observer<?> observer, SpscLinkedArrayQueue<?> spscLinkedArrayQueue) {
            Exceptions.b(th);
            ExceptionHelper.a(this.Y2, th);
            spscLinkedArrayQueue.clear();
            f();
            i(observer);
        }

        public void m() {
            if (!this.f3) {
                this.f3 = true;
                f();
                if (getAndIncrement() == 0) {
                    this.X.clear();
                }
            }
        }
    }

    public ObservableJoin(ObservableSource<TLeft> observableSource, ObservableSource<? extends TRight> observableSource2, Function<? super TLeft, ? extends ObservableSource<TLeftEnd>> function, Function<? super TRight, ? extends ObservableSource<TRightEnd>> function2, BiFunction<? super TLeft, ? super TRight, ? extends R> biFunction) {
        super(observableSource);
        this.X = observableSource2;
        this.Y = function;
        this.Z = function2;
        this.X2 = biFunction;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super R> observer) {
        JoinDisposable joinDisposable = new JoinDisposable(observer, this.Y, this.Z, this.X2);
        observer.b(joinDisposable);
        ObservableGroupJoin.LeftRightObserver leftRightObserver = new ObservableGroupJoin.LeftRightObserver(joinDisposable, true);
        joinDisposable.Y.b(leftRightObserver);
        ObservableGroupJoin.LeftRightObserver leftRightObserver2 = new ObservableGroupJoin.LeftRightObserver(joinDisposable, false);
        joinDisposable.Y.b(leftRightObserver2);
        this.s.a(leftRightObserver);
        this.X.a(leftRightObserver2);
    }
}
