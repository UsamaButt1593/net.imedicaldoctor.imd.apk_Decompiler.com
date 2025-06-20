package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.queue.SpscLinkedArrayQueue;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableConcatMapCompletable<T> extends Completable {
    final Function<? super T, ? extends CompletableSource> X;
    final ErrorMode Y;
    final int Z;
    final Observable<T> s;

    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements Observer<T>, Disposable {
        private static final long e3 = 3610901111000061034L;
        final Function<? super T, ? extends CompletableSource> X;
        final ConcatMapInnerObserver X2 = new ConcatMapInnerObserver(this);
        final ErrorMode Y;
        final int Y2;
        final AtomicThrowable Z = new AtomicThrowable();
        SimpleQueue<T> Z2;
        Disposable a3;
        volatile boolean b3;
        volatile boolean c3;
        volatile boolean d3;
        final CompletableObserver s;

        static final class ConcatMapInnerObserver extends AtomicReference<Disposable> implements CompletableObserver {
            private static final long X = 5638352172918776687L;
            final ConcatMapCompletableObserver<?> s;

            ConcatMapInnerObserver(ConcatMapCompletableObserver<?> concatMapCompletableObserver) {
                this.s = concatMapCompletableObserver;
            }

            /* access modifiers changed from: package-private */
            public void a() {
                DisposableHelper.a(this);
            }

            public void b(Disposable disposable) {
                DisposableHelper.c(this, disposable);
            }

            public void onComplete() {
                this.s.c();
            }

            public void onError(Throwable th) {
                this.s.d(th);
            }
        }

        ConcatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i2) {
            this.s = completableObserver;
            this.X = function;
            this.Y = errorMode;
            this.Y2 = i2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            boolean z;
            CompletableSource completableSource;
            if (getAndIncrement() == 0) {
                AtomicThrowable atomicThrowable = this.Z;
                ErrorMode errorMode = this.Y;
                while (!this.d3) {
                    if (!this.b3) {
                        if (errorMode != ErrorMode.BOUNDARY || atomicThrowable.get() == null) {
                            boolean z2 = this.c3;
                            try {
                                T poll = this.Z2.poll();
                                if (poll != null) {
                                    Object apply = this.X.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                                    completableSource = (CompletableSource) apply;
                                    z = false;
                                } else {
                                    completableSource = null;
                                    z = true;
                                }
                                if (z2 && z) {
                                    this.d3 = true;
                                    atomicThrowable.f(this.s);
                                    return;
                                } else if (!z) {
                                    this.b3 = true;
                                    completableSource.a(this.X2);
                                }
                            } catch (Throwable th) {
                                Exceptions.b(th);
                                this.d3 = true;
                                this.Z2.clear();
                                this.a3.m();
                                atomicThrowable.d(th);
                                atomicThrowable.f(this.s);
                                return;
                            }
                        } else {
                            this.d3 = true;
                            this.Z2.clear();
                            atomicThrowable.f(this.s);
                            return;
                        }
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                }
                this.Z2.clear();
            }
        }

        public void b(Disposable disposable) {
            if (DisposableHelper.j(this.a3, disposable)) {
                this.a3 = disposable;
                if (disposable instanceof QueueDisposable) {
                    QueueDisposable queueDisposable = (QueueDisposable) disposable;
                    int r = queueDisposable.r(3);
                    if (r == 1) {
                        this.Z2 = queueDisposable;
                        this.c3 = true;
                        this.s.b(this);
                        a();
                        return;
                    } else if (r == 2) {
                        this.Z2 = queueDisposable;
                        this.s.b(this);
                        return;
                    }
                }
                this.Z2 = new SpscLinkedArrayQueue(this.Y2);
                this.s.b(this);
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.b3 = false;
            a();
        }

        /* access modifiers changed from: package-private */
        public void d(Throwable th) {
            if (!this.Z.d(th)) {
                return;
            }
            if (this.Y == ErrorMode.IMMEDIATE) {
                this.d3 = true;
                this.a3.m();
                this.Z.f(this.s);
                if (getAndIncrement() == 0) {
                    this.Z2.clear();
                    return;
                }
                return;
            }
            this.b3 = false;
            a();
        }

        public boolean g() {
            return this.d3;
        }

        public void m() {
            this.d3 = true;
            this.a3.m();
            this.X2.a();
            this.Z.e();
            if (getAndIncrement() == 0) {
                this.Z2.clear();
            }
        }

        public void onComplete() {
            this.c3 = true;
            a();
        }

        public void onError(Throwable th) {
            if (!this.Z.d(th)) {
                return;
            }
            if (this.Y == ErrorMode.IMMEDIATE) {
                this.d3 = true;
                this.X2.a();
                this.Z.f(this.s);
                if (getAndIncrement() == 0) {
                    this.Z2.clear();
                    return;
                }
                return;
            }
            this.c3 = true;
            a();
        }

        public void onNext(T t) {
            if (t != null) {
                this.Z2.offer(t);
            }
            a();
        }
    }

    public ObservableConcatMapCompletable(Observable<T> observable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i2) {
        this.s = observable;
        this.X = function;
        this.Y = errorMode;
        this.Z = i2;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        if (!ScalarXMapZHelper.a(this.s, this.X, completableObserver)) {
            this.s.a(new ConcatMapCompletableObserver(completableObserver, this.X, this.Y, this.Z));
        }
    }
}
