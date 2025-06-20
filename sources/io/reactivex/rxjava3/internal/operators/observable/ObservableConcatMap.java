package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import io.reactivex.rxjava3.observers.SerializedObserver;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMap<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super T, ? extends ObservableSource<? extends U>> X;
    final int Y;
    final ErrorMode Z;

    static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long f3 = -6951100001833242599L;
        final Function<? super T, ? extends ObservableSource<? extends R>> X;
        final DelayErrorInnerObserver<R> X2;
        final int Y;
        final boolean Y2;
        final AtomicThrowable Z = new AtomicThrowable();
        SimpleQueue<T> Z2;
        Disposable a3;
        volatile boolean b3;
        volatile boolean c3;
        volatile boolean d3;
        int e3;
        final Observer<? super R> s;

        static final class DelayErrorInnerObserver<R> extends AtomicReference<Disposable> implements Observer<R> {
            private static final long Y = 2620149119579502636L;
            final ConcatMapDelayErrorObserver<?, R> X;
            final Observer<? super R> s;

            DelayErrorInnerObserver(Observer<? super R> observer, ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver) {
                this.s = observer;
                this.X = concatMapDelayErrorObserver;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                DisposableHelper.a(this);
            }

            public void b(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            public void onComplete() {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.X;
                concatMapDelayErrorObserver.b3 = false;
                concatMapDelayErrorObserver.a();
            }

            public void onError(Throwable th) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.X;
                if (concatMapDelayErrorObserver.Z.d(th)) {
                    if (!concatMapDelayErrorObserver.Y2) {
                        concatMapDelayErrorObserver.a3.m();
                    }
                    concatMapDelayErrorObserver.b3 = false;
                    concatMapDelayErrorObserver.a();
                }
            }

            public void onNext(R r) {
                this.s.onNext(r);
            }
        }

        ConcatMapDelayErrorObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z) {
            this.s = observer;
            this.X = function;
            this.Y = i2;
            this.Y2 = z;
            this.X2 = new DelayErrorInnerObserver<>(observer, this);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.s;
                SimpleQueue<T> simpleQueue = this.Z2;
                AtomicThrowable atomicThrowable = this.Z;
                while (true) {
                    if (!this.b3) {
                        if (!this.d3) {
                            if (!this.Y2 && ((Throwable) atomicThrowable.get()) != null) {
                                simpleQueue.clear();
                                break;
                            }
                            boolean z = this.c3;
                            try {
                                T poll = simpleQueue.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    break;
                                } else if (!z2) {
                                    try {
                                        Object apply = this.X.apply(poll);
                                        Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                        ObservableSource observableSource = (ObservableSource) apply;
                                        if (observableSource instanceof Supplier) {
                                            try {
                                                Object obj = ((Supplier) observableSource).get();
                                                if (obj != null && !this.d3) {
                                                    observer.onNext(obj);
                                                }
                                            } catch (Throwable th) {
                                                Exceptions.b(th);
                                                atomicThrowable.d(th);
                                            }
                                        } else {
                                            this.b3 = true;
                                            observableSource.a(this.X2);
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.b(th2);
                                        this.d3 = true;
                                        this.a3.m();
                                        simpleQueue.clear();
                                        atomicThrowable.d(th2);
                                    }
                                }
                            } catch (Throwable th3) {
                                Exceptions.b(th3);
                                this.d3 = true;
                                this.a3.m();
                                atomicThrowable.d(th3);
                            }
                        } else {
                            simpleQueue.clear();
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.d3 = true;
                atomicThrowable.i(observer);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.a3, disposable)) {
                this.a3 = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int r = queueDisposable.r(3);
                    if (r == 1) {
                        this.e3 = r;
                        this.Z2 = queueDisposable;
                        this.c3 = true;
                        this.s.b(this);
                        a();
                        return;
                    } else if (r == 2) {
                        this.e3 = r;
                        this.Z2 = queueDisposable;
                        this.s.b(this);
                        return;
                    }
                }
                this.Z2 = new SpscLinkedArrayQueue(this.Y);
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.d3;
        }

        public void m() {
            this.d3 = true;
            this.a3.m();
            this.X2.a();
            this.Z.e();
        }

        public void onComplete() {
            this.c3 = true;
            a();
        }

        public void onError(Throwable th) {
            if (this.Z.d(th)) {
                this.c3 = true;
                a();
            }
        }

        public void onNext(T t) {
            if (this.e3 == 0) {
                this.Z2.offer(t);
            }
            a();
        }
    }

    static final class SourceObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long d3 = 8828587559905699186L;
        final Function<? super T, ? extends ObservableSource<? extends U>> X;
        SimpleQueue<T> X2;
        final InnerObserver<U> Y;
        Disposable Y2;
        final int Z;
        volatile boolean Z2;
        volatile boolean a3;
        volatile boolean b3;
        int c3;
        final Observer<? super U> s;

        static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
            private static final long Y = -7449079488798789337L;
            final SourceObserver<?, ?> X;
            final Observer<? super U> s;

            InnerObserver(Observer<? super U> observer, SourceObserver<?, ?> sourceObserver) {
                this.s = observer;
                this.X = sourceObserver;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                DisposableHelper.a(this);
            }

            public void b(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            public void onComplete() {
                this.X.c();
            }

            public void onError(Throwable th) {
                this.X.m();
                this.s.onError(th);
            }

            public void onNext(U u) {
                this.s.onNext(u);
            }
        }

        SourceObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, int i2) {
            this.s = observer;
            this.X = function;
            this.Z = i2;
            this.Y = new InnerObserver<>(observer, this);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                while (!this.a3) {
                    if (!this.Z2) {
                        boolean z = this.b3;
                        try {
                            T poll = this.X2.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.a3 = true;
                                this.s.onComplete();
                                return;
                            } else if (!z2) {
                                try {
                                    Object apply = this.X.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                    ObservableSource observableSource = (ObservableSource) apply;
                                    this.Z2 = true;
                                    observableSource.a(this.Y);
                                } catch (Throwable th) {
                                    Exceptions.b(th);
                                    m();
                                    this.X2.clear();
                                    this.s.onError(th);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            Exceptions.b(th2);
                            m();
                            this.X2.clear();
                            this.s.onError(th2);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.X2.clear();
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Y2, disposable)) {
                this.Y2 = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int r = queueDisposable.r(3);
                    if (r == 1) {
                        this.c3 = r;
                        this.X2 = queueDisposable;
                        this.b3 = true;
                        this.s.b(this);
                        a();
                        return;
                    } else if (r == 2) {
                        this.c3 = r;
                        this.X2 = queueDisposable;
                        this.s.b(this);
                        return;
                    }
                }
                this.X2 = new SpscLinkedArrayQueue(this.Z);
                this.s.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.Z2 = false;
            a();
        }

        public boolean g() {
            return this.a3;
        }

        public void m() {
            this.a3 = true;
            this.Y.a();
            this.Y2.m();
            if (getAndIncrement() == 0) {
                this.X2.clear();
            }
        }

        public void onComplete() {
            if (!this.b3) {
                this.b3 = true;
                a();
            }
        }

        public void onError(Throwable th) {
            if (this.b3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.b3 = true;
            m();
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.b3) {
                if (this.c3 == 0) {
                    this.X2.offer(t);
                }
                a();
            }
        }
    }

    public ObservableConcatMap(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i2, ErrorMode errorMode) {
        super(observableSource);
        this.X = function;
        this.Z = errorMode;
        this.Y = Math.max(8, i2);
    }

    public void g6(Observer<? super U> observer) {
        if (!ObservableScalarXMap.b(this.s, observer, this.X)) {
            if (this.Z == ErrorMode.IMMEDIATE) {
                this.s.a(new SourceObserver(new SerializedObserver(observer), this.X, this.Y));
            } else {
                this.s.a(new ConcatMapDelayErrorObserver(observer, this.X, this.Y, this.Z == ErrorMode.END));
            }
        }
    }
}
