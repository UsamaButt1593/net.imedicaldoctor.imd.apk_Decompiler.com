package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapSingle<T, R> extends Observable<R> {
    final Function<? super T, ? extends SingleSource<? extends R>> X;
    final ErrorMode Y;
    final int Z;
    final ObservableSource<T> s;

    static final class ConcatMapSingleMainObserver<T, R> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long e3 = -9140123220065488293L;
        static final int f3 = 0;
        static final int g3 = 1;
        static final int h3 = 2;
        final Function<? super T, ? extends SingleSource<? extends R>> X;
        final SimplePlainQueue<T> X2;
        final AtomicThrowable Y = new AtomicThrowable();
        final ErrorMode Y2;
        final ConcatMapSingleObserver<R> Z = new ConcatMapSingleObserver<>(this);
        Disposable Z2;
        volatile boolean a3;
        volatile boolean b3;
        R c3;
        volatile int d3;
        final Observer<? super R> s;

        static final class ConcatMapSingleObserver<R> extends AtomicReference<Disposable> implements SingleObserver<R> {
            private static final long X = -3051469169682093892L;
            final ConcatMapSingleMainObserver<?, R> s;

            ConcatMapSingleObserver(ConcatMapSingleMainObserver<?, R> concatMapSingleMainObserver) {
                this.s = concatMapSingleMainObserver;
            }

            public void a(R r) {
                this.s.d(r);
            }

            public void b(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            /* access modifiers changed from: package-private */
            public void c() {
                DisposableHelper.a(this);
            }

            public void onError(Throwable th) {
                this.s.c(th);
            }
        }

        ConcatMapSingleMainObserver(Observer<? super R> observer, Function<? super T, ? extends SingleSource<? extends R>> function, int i2, ErrorMode errorMode) {
            this.s = observer;
            this.X = function;
            this.Y2 = errorMode;
            this.X2 = new SpscLinkedArrayQueue(i2);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                Observer<? super R> observer = this.s;
                ErrorMode errorMode = this.Y2;
                SimplePlainQueue<T> simplePlainQueue = this.X2;
                AtomicThrowable atomicThrowable = this.Y;
                int i2 = 1;
                while (true) {
                    if (this.b3) {
                        simplePlainQueue.clear();
                        this.c3 = null;
                    } else {
                        int i3 = this.d3;
                        if (atomicThrowable.get() == null || !(errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i3 == 0))) {
                            boolean z = false;
                            if (i3 == 0) {
                                boolean z2 = this.a3;
                                T poll = simplePlainQueue.poll();
                                if (poll == null) {
                                    z = true;
                                }
                                if (z2 && z) {
                                    atomicThrowable.i(observer);
                                    return;
                                } else if (!z) {
                                    try {
                                        Object apply = this.X.apply(poll);
                                        Objects.requireNonNull(apply, "The mapper returned a null SingleSource");
                                        SingleSource singleSource = (SingleSource) apply;
                                        this.d3 = 1;
                                        singleSource.e(this.Z);
                                    } catch (Throwable th) {
                                        Exceptions.b(th);
                                        this.Z2.m();
                                        simplePlainQueue.clear();
                                        atomicThrowable.d(th);
                                    }
                                }
                            } else if (i3 == 2) {
                                R r = this.c3;
                                this.c3 = null;
                                observer.onNext(r);
                                this.d3 = 0;
                            }
                        }
                    }
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
                this.c3 = null;
                atomicThrowable.i(observer);
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.Z2, disposable)) {
                this.Z2 = disposable;
                this.s.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            if (this.Y.d(th)) {
                if (this.Y2 != ErrorMode.END) {
                    this.Z2.m();
                }
                this.d3 = 0;
                a();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(R r) {
            this.c3 = r;
            this.d3 = 2;
            a();
        }

        public boolean g() {
            return this.b3;
        }

        public void m() {
            this.b3 = true;
            this.Z2.m();
            this.Z.c();
            this.Y.e();
            if (getAndIncrement() == 0) {
                this.X2.clear();
                this.c3 = null;
            }
        }

        public void onComplete() {
            this.a3 = true;
            a();
        }

        public void onError(Throwable th) {
            if (this.Y.d(th)) {
                if (this.Y2 == ErrorMode.IMMEDIATE) {
                    this.Z.c();
                }
                this.a3 = true;
                a();
            }
        }

        public void onNext(T t) {
            this.X2.offer(t);
            a();
        }
    }

    public ObservableConcatMapSingle(ObservableSource<T> observableSource, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i2) {
        this.s = observableSource;
        this.X = function;
        this.Y = errorMode;
        this.Z = i2;
    }

    /* access modifiers changed from: protected */
    public void g6(Observer<? super R> observer) {
        if (!ScalarXMapZHelper.c(this.s, this.X, observer)) {
            this.s.a(new ConcatMapSingleMainObserver(observer, this.X, this.Z, this.Y));
        }
    }
}
