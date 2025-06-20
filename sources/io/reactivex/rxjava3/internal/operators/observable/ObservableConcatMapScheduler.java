package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Scheduler;
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

public final class ObservableConcatMapScheduler<T, U> extends AbstractObservableWithUpstream<T, U> {
    final Function<? super T, ? extends ObservableSource<? extends U>> X;
    final Scheduler X2;
    final int Y;
    final ErrorMode Z;

    static final class ConcatMapDelayErrorObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long g3 = -6951100001833242599L;
        final Function<? super T, ? extends ObservableSource<? extends R>> X;
        final DelayErrorInnerObserver<R> X2;
        final int Y;
        final boolean Y2;
        final AtomicThrowable Z = new AtomicThrowable();
        final Scheduler.Worker Z2;
        SimpleQueue<T> a3;
        Disposable b3;
        volatile boolean c3;
        volatile boolean d3;
        volatile boolean e3;
        int f3;
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
                concatMapDelayErrorObserver.c3 = false;
                concatMapDelayErrorObserver.a();
            }

            public void onError(Throwable th) {
                ConcatMapDelayErrorObserver<?, R> concatMapDelayErrorObserver = this.X;
                if (concatMapDelayErrorObserver.Z.d(th)) {
                    if (!concatMapDelayErrorObserver.Y2) {
                        concatMapDelayErrorObserver.b3.m();
                    }
                    concatMapDelayErrorObserver.c3 = false;
                    concatMapDelayErrorObserver.a();
                }
            }

            public void onNext(R r) {
                this.s.onNext(r);
            }
        }

        ConcatMapDelayErrorObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, boolean z, Scheduler.Worker worker) {
            this.s = observer;
            this.X = function;
            this.Y = i2;
            this.Y2 = z;
            this.X2 = new DelayErrorInnerObserver<>(observer, this);
            this.Z2 = worker;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                this.Z2.b(this);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.b3, disposable)) {
                this.b3 = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int r = queueDisposable.r(3);
                    if (r == 1) {
                        this.f3 = r;
                        this.a3 = queueDisposable;
                        this.d3 = true;
                        this.s.b(this);
                        a();
                        return;
                    } else if (r == 2) {
                        this.f3 = r;
                        this.a3 = queueDisposable;
                        this.s.b(this);
                        return;
                    }
                }
                this.a3 = new SpscLinkedArrayQueue(this.Y);
                this.s.b(this);
            }
        }

        public boolean g() {
            return this.e3;
        }

        public void m() {
            this.e3 = true;
            this.b3.m();
            this.X2.a();
            this.Z2.m();
            this.Z.e();
        }

        public void onComplete() {
            this.d3 = true;
            a();
        }

        public void onError(Throwable th) {
            if (this.Z.d(th)) {
                this.d3 = true;
                a();
            }
        }

        public void onNext(T t) {
            if (this.f3 == 0) {
                this.a3.offer(t);
            }
            a();
        }

        public void run() {
            Observer<? super R> observer = this.s;
            SimpleQueue<T> simpleQueue = this.a3;
            AtomicThrowable atomicThrowable = this.Z;
            while (true) {
                if (!this.c3) {
                    if (!this.e3) {
                        if (!this.Y2 && ((Throwable) atomicThrowable.get()) != null) {
                            simpleQueue.clear();
                            break;
                        }
                        boolean z = this.d3;
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
                                            if (obj != null && !this.e3) {
                                                observer.onNext(obj);
                                            }
                                        } catch (Throwable th) {
                                            Exceptions.b(th);
                                            atomicThrowable.d(th);
                                        }
                                    } else {
                                        this.c3 = true;
                                        observableSource.a(this.X2);
                                    }
                                } catch (Throwable th2) {
                                    Exceptions.b(th2);
                                    this.e3 = true;
                                    this.b3.m();
                                    simpleQueue.clear();
                                    atomicThrowable.d(th2);
                                }
                            }
                        } catch (Throwable th3) {
                            Exceptions.b(th3);
                            this.e3 = true;
                            this.b3.m();
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
            this.e3 = true;
            atomicThrowable.i(observer);
            this.Z2.m();
        }
    }

    static final class ConcatMapObserver<T, U> extends AtomicInteger implements Observer<T>, Disposable, Runnable {
        private static final long e3 = 8828587559905699186L;
        final Function<? super T, ? extends ObservableSource<? extends U>> X;
        final Scheduler.Worker X2;
        final InnerObserver<U> Y;
        SimpleQueue<T> Y2;
        final int Z;
        Disposable Z2;
        volatile boolean a3;
        volatile boolean b3;
        volatile boolean c3;
        int d3;
        final Observer<? super U> s;

        static final class InnerObserver<U> extends AtomicReference<Disposable> implements Observer<U> {
            private static final long Y = -7449079488798789337L;
            final ConcatMapObserver<?, ?> X;
            final Observer<? super U> s;

            InnerObserver(Observer<? super U> observer, ConcatMapObserver<?, ?> concatMapObserver) {
                this.s = observer;
                this.X = concatMapObserver;
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

        ConcatMapObserver(Observer<? super U> observer, Function<? super T, ? extends ObservableSource<? extends U>> function, int i2, Scheduler.Worker worker) {
            this.s = observer;
            this.X = function;
            this.Z = i2;
            this.Y = new InnerObserver<>(observer, this);
            this.X2 = worker;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                this.X2.b(this);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z2, disposable)) {
                this.Z2 = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int r = queueDisposable.r(3);
                    if (r == 1) {
                        this.d3 = r;
                        this.Y2 = queueDisposable;
                        this.c3 = true;
                        this.s.b(this);
                        a();
                        return;
                    } else if (r == 2) {
                        this.d3 = r;
                        this.Y2 = queueDisposable;
                        this.s.b(this);
                        return;
                    }
                }
                this.Y2 = new SpscLinkedArrayQueue(this.Z);
                this.s.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.a3 = false;
            a();
        }

        public boolean g() {
            return this.b3;
        }

        public void m() {
            this.b3 = true;
            this.Y.a();
            this.Z2.m();
            this.X2.m();
            if (getAndIncrement() == 0) {
                this.Y2.clear();
            }
        }

        public void onComplete() {
            if (!this.c3) {
                this.c3 = true;
                a();
            }
        }

        public void onError(Throwable th) {
            if (this.c3) {
                RxJavaPlugins.Y(th);
                return;
            }
            this.c3 = true;
            m();
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (!this.c3) {
                if (this.d3 == 0) {
                    this.Y2.offer(t);
                }
                a();
            }
        }

        public void run() {
            while (!this.b3) {
                if (!this.a3) {
                    boolean z = this.c3;
                    try {
                        T poll = this.Y2.poll();
                        boolean z2 = poll == null;
                        if (z && z2) {
                            this.b3 = true;
                            this.s.onComplete();
                            this.X2.m();
                            return;
                        } else if (!z2) {
                            try {
                                Object apply = this.X.apply(poll);
                                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                this.a3 = true;
                                observableSource.a(this.Y);
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                m();
                                this.Y2.clear();
                                this.s.onError(th);
                                this.X2.m();
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        Exceptions.b(th2);
                        m();
                        this.Y2.clear();
                        this.s.onError(th2);
                        this.X2.m();
                        return;
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            }
            this.Y2.clear();
        }
    }

    public ObservableConcatMapScheduler(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends U>> function, int i2, ErrorMode errorMode, Scheduler scheduler) {
        super(observableSource);
        this.X = function;
        this.Z = errorMode;
        this.Y = Math.max(8, i2);
        this.X2 = scheduler;
    }

    public void g6(Observer<? super U> observer) {
        if (this.Z == ErrorMode.IMMEDIATE) {
            this.s.a(new ConcatMapObserver(new SerializedObserver(observer), this.X, this.Y, this.X2.d()));
        } else {
            this.s.a(new ConcatMapDelayErrorObserver(observer, this.X, this.Y, this.Z == ErrorMode.END, this.X2.d()));
        }
    }
}
