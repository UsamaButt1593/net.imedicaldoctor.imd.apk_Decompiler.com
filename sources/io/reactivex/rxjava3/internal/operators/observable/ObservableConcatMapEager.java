package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.observers.InnerQueuedObserver;
import io.reactivex.rxjava3.internal.observers.InnerQueuedObserverSupport;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableConcatMapEager<T, R> extends AbstractObservableWithUpstream<T, R> {
    final Function<? super T, ? extends ObservableSource<? extends R>> X;
    final int X2;
    final ErrorMode Y;
    final int Z;

    static final class ConcatMapEagerMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable, InnerQueuedObserverSupport<R> {
        private static final long h3 = 8080567949447303262L;
        final Function<? super T, ? extends ObservableSource<? extends R>> X;
        final ErrorMode X2;
        final int Y;
        final AtomicThrowable Y2 = new AtomicThrowable();
        final int Z;
        final ArrayDeque<InnerQueuedObserver<R>> Z2 = new ArrayDeque<>();
        SimpleQueue<T> a3;
        Disposable b3;
        volatile boolean c3;
        int d3;
        volatile boolean e3;
        InnerQueuedObserver<R> f3;
        int g3;
        final Observer<? super R> s;

        ConcatMapEagerMainObserver(Observer<? super R> observer, Function<? super T, ? extends ObservableSource<? extends R>> function, int i2, int i3, ErrorMode errorMode) {
            this.s = observer;
            this.X = function;
            this.Y = i2;
            this.Z = i3;
            this.X2 = errorMode;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
            if (r0 != null) goto L_0x0004;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
            r0.m();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0007, code lost:
            r0 = r1.Z2.poll();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x000f, code lost:
            if (r0 != null) goto L_0x0004;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0011, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a() {
            /*
                r1 = this;
                io.reactivex.rxjava3.internal.observers.InnerQueuedObserver<R> r0 = r1.f3
                if (r0 == 0) goto L_0x0007
            L_0x0004:
                r0.m()
            L_0x0007:
                java.util.ArrayDeque<io.reactivex.rxjava3.internal.observers.InnerQueuedObserver<R>> r0 = r1.Z2
                java.lang.Object r0 = r0.poll()
                io.reactivex.rxjava3.internal.observers.InnerQueuedObserver r0 = (io.reactivex.rxjava3.internal.observers.InnerQueuedObserver) r0
                if (r0 != 0) goto L_0x0004
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableConcatMapEager.ConcatMapEagerMainObserver.a():void");
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.b3, disposable)) {
                this.b3 = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int r = queueDisposable.r(3);
                    if (r == 1) {
                        this.d3 = r;
                        this.a3 = queueDisposable;
                        this.c3 = true;
                        this.s.b(this);
                        d();
                        return;
                    } else if (r == 2) {
                        this.d3 = r;
                        this.a3 = queueDisposable;
                        this.s.b(this);
                        return;
                    }
                }
                this.a3 = new SpscLinkedArrayQueue(this.Z);
                this.s.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (getAndIncrement() == 0) {
                do {
                    this.a3.clear();
                    a();
                } while (decrementAndGet() != 0);
            }
        }

        public void d() {
            if (getAndIncrement() == 0) {
                SimpleQueue<T> simpleQueue = this.a3;
                ArrayDeque<InnerQueuedObserver<R>> arrayDeque = this.Z2;
                Observer<? super R> observer = this.s;
                ErrorMode errorMode = this.X2;
                int i2 = 1;
                while (true) {
                    int i3 = this.g3;
                    while (true) {
                        if (i3 == this.Y) {
                            break;
                        } else if (this.e3) {
                            simpleQueue.clear();
                            a();
                            return;
                        } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.Y2.get()) == null) {
                            try {
                                T poll = simpleQueue.poll();
                                if (poll == null) {
                                    break;
                                }
                                Object apply = this.X.apply(poll);
                                Objects.requireNonNull(apply, "The mapper returned a null ObservableSource");
                                ObservableSource observableSource = (ObservableSource) apply;
                                InnerQueuedObserver innerQueuedObserver = new InnerQueuedObserver(this, this.Z);
                                arrayDeque.offer(innerQueuedObserver);
                                observableSource.a(innerQueuedObserver);
                                i3++;
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                this.b3.m();
                                simpleQueue.clear();
                                a();
                                this.Y2.d(th);
                                this.Y2.i(this.s);
                                return;
                            }
                        } else {
                            simpleQueue.clear();
                            a();
                            this.Y2.i(this.s);
                            return;
                        }
                    }
                    this.g3 = i3;
                    if (this.e3) {
                        simpleQueue.clear();
                        a();
                        return;
                    } else if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.Y2.get()) == null) {
                        InnerQueuedObserver<R> innerQueuedObserver2 = this.f3;
                        if (innerQueuedObserver2 == null) {
                            if (errorMode != ErrorMode.BOUNDARY || ((Throwable) this.Y2.get()) == null) {
                                boolean z = this.c3;
                                InnerQueuedObserver<R> poll2 = arrayDeque.poll();
                                boolean z2 = poll2 == null;
                                if (!z || !z2) {
                                    if (!z2) {
                                        this.f3 = poll2;
                                    }
                                    innerQueuedObserver2 = poll2;
                                } else if (((Throwable) this.Y2.get()) != null) {
                                    simpleQueue.clear();
                                    a();
                                    this.Y2.i(observer);
                                    return;
                                } else {
                                    observer.onComplete();
                                    return;
                                }
                            } else {
                                simpleQueue.clear();
                                a();
                                this.Y2.i(observer);
                                return;
                            }
                        }
                        if (innerQueuedObserver2 != null) {
                            SimpleQueue<R> c2 = innerQueuedObserver2.c();
                            while (!this.e3) {
                                boolean a2 = innerQueuedObserver2.a();
                                if (errorMode != ErrorMode.IMMEDIATE || ((Throwable) this.Y2.get()) == null) {
                                    try {
                                        R poll3 = c2.poll();
                                        boolean z3 = poll3 == null;
                                        if (a2 && z3) {
                                            this.f3 = null;
                                            this.g3--;
                                        } else if (!z3) {
                                            observer.onNext(poll3);
                                        }
                                    } catch (Throwable th2) {
                                        Exceptions.b(th2);
                                        this.Y2.d(th2);
                                    }
                                } else {
                                    simpleQueue.clear();
                                    a();
                                    this.Y2.i(observer);
                                    return;
                                }
                            }
                            simpleQueue.clear();
                            a();
                            return;
                        }
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        simpleQueue.clear();
                        a();
                        this.Y2.i(this.s);
                        return;
                    }
                }
            }
        }

        public void e(InnerQueuedObserver<R> innerQueuedObserver, R r) {
            innerQueuedObserver.c().offer(r);
            d();
        }

        public void f(InnerQueuedObserver<R> innerQueuedObserver) {
            innerQueuedObserver.d();
            d();
        }

        public boolean g() {
            return this.e3;
        }

        public void h(InnerQueuedObserver<R> innerQueuedObserver, Throwable th) {
            if (this.Y2.d(th)) {
                if (this.X2 == ErrorMode.IMMEDIATE) {
                    this.b3.m();
                }
                innerQueuedObserver.d();
                d();
            }
        }

        public void m() {
            if (!this.e3) {
                this.e3 = true;
                this.b3.m();
                this.Y2.e();
                c();
            }
        }

        public void onComplete() {
            this.c3 = true;
            d();
        }

        public void onError(Throwable th) {
            if (this.Y2.d(th)) {
                this.c3 = true;
                d();
            }
        }

        public void onNext(T t) {
            if (this.d3 == 0) {
                this.a3.offer(t);
            }
            d();
        }
    }

    public ObservableConcatMapEager(ObservableSource<T> observableSource, Function<? super T, ? extends ObservableSource<? extends R>> function, ErrorMode errorMode, int i2, int i3) {
        super(observableSource);
        this.X = function;
        this.Y = errorMode;
        this.Z = i2;
        this.X2 = i3;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super R> observer) {
        this.s.a(new ConcatMapEagerMainObserver(observer, this.X, this.Z, this.X2, this.Y));
    }
}
