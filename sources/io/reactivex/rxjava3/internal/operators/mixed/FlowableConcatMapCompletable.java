package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapCompletable<T> extends Completable {
    final Function<? super T, ? extends CompletableSource> X;
    final ErrorMode Y;
    final int Z;
    final Flowable<T> s;

    static final class ConcatMapCompletableObserver<T> extends AtomicInteger implements FlowableSubscriber<T>, Disposable {
        private static final long f3 = 3610901111000061034L;
        final Function<? super T, ? extends CompletableSource> X;
        final ConcatMapInnerObserver X2 = new ConcatMapInnerObserver(this);
        final ErrorMode Y;
        final int Y2;
        final AtomicThrowable Z = new AtomicThrowable();
        final SimplePlainQueue<T> Z2;
        Subscription a3;
        volatile boolean b3;
        volatile boolean c3;
        volatile boolean d3;
        int e3;
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
                this.s.b();
            }

            public void onError(Throwable th) {
                this.s.c(th);
            }
        }

        ConcatMapCompletableObserver(CompletableObserver completableObserver, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i2) {
            this.s = completableObserver;
            this.X = function;
            this.Y = errorMode;
            this.Y2 = i2;
            this.Z2 = new SpscArrayQueue(i2);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                while (!this.d3) {
                    if (!this.b3) {
                        if (this.Y != ErrorMode.BOUNDARY || this.Z.get() == null) {
                            boolean z = this.c3;
                            T poll = this.Z2.poll();
                            boolean z2 = poll == null;
                            if (z && z2) {
                                this.Z.f(this.s);
                                return;
                            } else if (!z2) {
                                int i2 = this.Y2;
                                int i3 = i2 - (i2 >> 1);
                                int i4 = this.e3 + 1;
                                if (i4 == i3) {
                                    this.e3 = 0;
                                    this.a3.request((long) i3);
                                } else {
                                    this.e3 = i4;
                                }
                                try {
                                    Object apply = this.X.apply(poll);
                                    Objects.requireNonNull(apply, "The mapper returned a null CompletableSource");
                                    CompletableSource completableSource = (CompletableSource) apply;
                                    this.b3 = true;
                                    completableSource.a(this.X2);
                                } catch (Throwable th) {
                                    Exceptions.b(th);
                                    this.Z2.clear();
                                    this.a3.cancel();
                                    this.Z.d(th);
                                    this.Z.f(this.s);
                                    return;
                                }
                            }
                        } else {
                            this.Z2.clear();
                            this.Z.f(this.s);
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

        /* access modifiers changed from: package-private */
        public void b() {
            this.b3 = false;
            a();
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            if (!this.Z.d(th)) {
                return;
            }
            if (this.Y == ErrorMode.IMMEDIATE) {
                this.a3.cancel();
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

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.a3, subscription)) {
                this.a3 = subscription;
                this.s.b(this);
                subscription.request((long) this.Y2);
            }
        }

        public void m() {
            this.d3 = true;
            this.a3.cancel();
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
            if (this.Z2.offer(t)) {
                a();
                return;
            }
            this.a3.cancel();
            onError(new MissingBackpressureException("Queue full?!"));
        }
    }

    public FlowableConcatMapCompletable(Flowable<T> flowable, Function<? super T, ? extends CompletableSource> function, ErrorMode errorMode, int i2) {
        this.s = flowable;
        this.X = function;
        this.Y = errorMode;
        this.Z = i2;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        this.s.J6(new ConcatMapCompletableObserver(completableObserver, this.X, this.Y, this.Z));
    }
}
