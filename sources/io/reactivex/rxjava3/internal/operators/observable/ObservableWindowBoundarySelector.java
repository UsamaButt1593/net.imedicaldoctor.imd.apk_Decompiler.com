package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.MpscLinkedQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import io.reactivex.rxjava3.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableWindowBoundarySelector<T, B, V> extends AbstractObservableWithUpstream<T, Observable<T>> {
    final ObservableSource<B> X;
    final Function<? super B, ? extends ObservableSource<V>> Y;
    final int Z;

    static final class WindowBoundaryMainObserver<T, B, V> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long k3 = 8646217640096099753L;
        final ObservableSource<B> X;
        final CompositeDisposable X2;
        final Function<? super B, ? extends ObservableSource<V>> Y;
        final WindowStartObserver<B> Y2;
        final int Z;
        final List<UnicastSubject<T>> Z2;
        final SimplePlainQueue<Object> a3 = new MpscLinkedQueue();
        final AtomicLong b3;
        final AtomicBoolean c3;
        final AtomicLong d3;
        long e3;
        volatile boolean f3;
        volatile boolean g3;
        volatile boolean h3;
        final AtomicThrowable i3;
        Disposable j3;
        final Observer<? super Observable<T>> s;

        static final class WindowEndObserverIntercept<T, V> extends Observable<T> implements Observer<V>, Disposable {
            final UnicastSubject<T> X;
            final AtomicReference<Disposable> Y = new AtomicReference<>();
            final AtomicBoolean Z = new AtomicBoolean();
            final WindowBoundaryMainObserver<T, ?, V> s;

            WindowEndObserverIntercept(WindowBoundaryMainObserver<T, ?, V> windowBoundaryMainObserver, UnicastSubject<T> unicastSubject) {
                this.s = windowBoundaryMainObserver;
                this.X = unicastSubject;
            }

            /* access modifiers changed from: package-private */
            public boolean D8() {
                return !this.Z.get() && this.Z.compareAndSet(false, true);
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this.Y, disposable);
            }

            public boolean g() {
                return this.Y.get() == DisposableHelper.DISPOSED;
            }

            /* access modifiers changed from: protected */
            public void g6(Observer<? super T> observer) {
                this.X.a(observer);
                this.Z.set(true);
            }

            public void m() {
                DisposableHelper.a(this.Y);
            }

            public void onComplete() {
                this.s.a(this);
            }

            public void onError(Throwable th) {
                if (g()) {
                    RxJavaPlugins.Y(th);
                } else {
                    this.s.c(th);
                }
            }

            public void onNext(V v) {
                if (DisposableHelper.a(this.Y)) {
                    this.s.a(this);
                }
            }
        }

        static final class WindowStartItem<B> {

            /* renamed from: a  reason: collision with root package name */
            final B f28415a;

            WindowStartItem(B b2) {
                this.f28415a = b2;
            }
        }

        static final class WindowStartObserver<B> extends AtomicReference<Disposable> implements Observer<B> {
            private static final long X = -3326496781427702834L;
            final WindowBoundaryMainObserver<?, B, ?> s;

            WindowStartObserver(WindowBoundaryMainObserver<?, B, ?> windowBoundaryMainObserver) {
                this.s = windowBoundaryMainObserver;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                DisposableHelper.a(this);
            }

            public void b(Disposable disposable) {
                DisposableHelper.h(this, disposable);
            }

            public void onComplete() {
                this.s.f();
            }

            public void onError(Throwable th) {
                this.s.h(th);
            }

            public void onNext(B b2) {
                this.s.e(b2);
            }
        }

        WindowBoundaryMainObserver(Observer<? super Observable<T>> observer, ObservableSource<B> observableSource, Function<? super B, ? extends ObservableSource<V>> function, int i2) {
            this.s = observer;
            this.X = observableSource;
            this.Y = function;
            this.Z = i2;
            this.X2 = new CompositeDisposable();
            this.Z2 = new ArrayList();
            this.b3 = new AtomicLong(1);
            this.c3 = new AtomicBoolean();
            this.i3 = new AtomicThrowable();
            this.Y2 = new WindowStartObserver<>(this);
            this.d3 = new AtomicLong();
        }

        /* access modifiers changed from: package-private */
        public void a(WindowEndObserverIntercept<T, V> windowEndObserverIntercept) {
            this.a3.offer(windowEndObserverIntercept);
            d();
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.j3, disposable)) {
                this.j3 = disposable;
                this.s.b(this);
                this.X.a(this.Y2);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            this.j3.m();
            this.Y2.a();
            this.X2.m();
            if (this.i3.d(th)) {
                this.g3 = true;
                d();
            }
        }

        /* access modifiers changed from: package-private */
        public void d() {
            if (getAndIncrement() == 0) {
                Observer<? super Observable<T>> observer = this.s;
                SimplePlainQueue<Object> simplePlainQueue = this.a3;
                List<UnicastSubject<T>> list = this.Z2;
                int i2 = 1;
                while (true) {
                    if (this.f3) {
                        simplePlainQueue.clear();
                        list.clear();
                    } else {
                        boolean z = this.g3;
                        Object poll = simplePlainQueue.poll();
                        boolean z2 = poll == null;
                        if (!z || (!z2 && this.i3.get() == null)) {
                            if (!z2) {
                                if (poll instanceof WindowStartItem) {
                                    if (!this.c3.get()) {
                                        try {
                                            Object apply = this.Y.apply(((WindowStartItem) poll).f28415a);
                                            Objects.requireNonNull(apply, "The closingIndicator returned a null ObservableSource");
                                            ObservableSource observableSource = (ObservableSource) apply;
                                            this.b3.getAndIncrement();
                                            UnicastSubject K8 = UnicastSubject.K8(this.Z, this);
                                            WindowEndObserverIntercept windowEndObserverIntercept = new WindowEndObserverIntercept(this, K8);
                                            observer.onNext(windowEndObserverIntercept);
                                            if (windowEndObserverIntercept.D8()) {
                                                K8.onComplete();
                                            } else {
                                                list.add(K8);
                                                this.X2.b(windowEndObserverIntercept);
                                                observableSource.a(windowEndObserverIntercept);
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.b(th);
                                            this.j3.m();
                                            this.Y2.a();
                                            this.X2.m();
                                            Exceptions.b(th);
                                            this.i3.d(th);
                                            this.g3 = true;
                                        }
                                    }
                                } else if (poll instanceof WindowEndObserverIntercept) {
                                    UnicastSubject<T> unicastSubject = ((WindowEndObserverIntercept) poll).X;
                                    list.remove(unicastSubject);
                                    this.X2.c((Disposable) poll);
                                    unicastSubject.onComplete();
                                } else {
                                    for (UnicastSubject<T> onNext : list) {
                                        onNext.onNext(poll);
                                    }
                                }
                            } else if (this.h3 && list.size() == 0) {
                                this.j3.m();
                                this.Y2.a();
                                this.X2.m();
                            }
                        }
                        i(observer);
                        this.f3 = true;
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void e(B b2) {
            this.a3.offer(new WindowStartItem(b2));
            d();
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.h3 = true;
            d();
        }

        public boolean g() {
            return this.c3.get();
        }

        /* access modifiers changed from: package-private */
        public void h(Throwable th) {
            this.j3.m();
            this.X2.m();
            if (this.i3.d(th)) {
                this.g3 = true;
                d();
            }
        }

        /* access modifiers changed from: package-private */
        public void i(Observer<?> observer) {
            Throwable b2 = this.i3.b();
            if (b2 == null) {
                for (UnicastSubject<T> onComplete : this.Z2) {
                    onComplete.onComplete();
                }
                observer.onComplete();
            } else if (b2 != ExceptionHelper.f28479a) {
                for (UnicastSubject<T> onError : this.Z2) {
                    onError.onError(b2);
                }
                observer.onError(b2);
            }
        }

        public void m() {
            if (!this.c3.compareAndSet(false, true)) {
                return;
            }
            if (this.b3.decrementAndGet() == 0) {
                this.j3.m();
                this.Y2.a();
                this.X2.m();
                this.i3.e();
                this.f3 = true;
                d();
                return;
            }
            this.Y2.a();
        }

        public void onComplete() {
            this.Y2.a();
            this.X2.m();
            this.g3 = true;
            d();
        }

        public void onError(Throwable th) {
            this.Y2.a();
            this.X2.m();
            if (this.i3.d(th)) {
                this.g3 = true;
                d();
            }
        }

        public void onNext(T t) {
            this.a3.offer(t);
            d();
        }

        public void run() {
            if (this.b3.decrementAndGet() == 0) {
                this.j3.m();
                this.Y2.a();
                this.X2.m();
                this.i3.e();
                this.f3 = true;
                d();
            }
        }
    }

    public ObservableWindowBoundarySelector(ObservableSource<T> observableSource, ObservableSource<B> observableSource2, Function<? super B, ? extends ObservableSource<V>> function, int i2) {
        super(observableSource);
        this.X = observableSource2;
        this.Y = function;
        this.Z = i2;
    }

    public void g6(Observer<? super Observable<T>> observer) {
        this.s.a(new WindowBoundaryMainObserver(observer, this.X, this.Y, this.Z));
    }
}
