package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.fuseable.SimplePlainQueue;
import io.reactivex.rxjava3.internal.queue.SpscArrayQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableConcatMapMaybe<T, R> extends Flowable<R> {
    final Flowable<T> X;
    final int X2;
    final Function<? super T, ? extends MaybeSource<? extends R>> Y;
    final ErrorMode Z;

    static final class ConcatMapMaybeSubscriber<T, R> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long i3 = -9140123220065488293L;
        static final int j3 = 0;
        static final int k3 = 1;
        static final int l3 = 2;
        final Function<? super T, ? extends MaybeSource<? extends R>> X;
        final AtomicThrowable X2 = new AtomicThrowable();
        final int Y;
        final ConcatMapMaybeObserver<R> Y2 = new ConcatMapMaybeObserver<>(this);
        final AtomicLong Z = new AtomicLong();
        final SimplePlainQueue<T> Z2;
        final ErrorMode a3;
        Subscription b3;
        volatile boolean c3;
        volatile boolean d3;
        long e3;
        int f3;
        R g3;
        volatile int h3;
        final Subscriber<? super R> s;

        static final class ConcatMapMaybeObserver<R> extends AtomicReference<Disposable> implements MaybeObserver<R> {
            private static final long X = -3051469169682093892L;
            final ConcatMapMaybeSubscriber<?, R> s;

            ConcatMapMaybeObserver(ConcatMapMaybeSubscriber<?, R> concatMapMaybeSubscriber) {
                this.s = concatMapMaybeSubscriber;
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

            public void onComplete() {
                this.s.b();
            }

            public void onError(Throwable th) {
                this.s.c(th);
            }
        }

        ConcatMapMaybeSubscriber(Subscriber<? super R> subscriber, Function<? super T, ? extends MaybeSource<? extends R>> function, int i2, ErrorMode errorMode) {
            this.s = subscriber;
            this.X = function;
            this.Y = i2;
            this.a3 = errorMode;
            this.Z2 = new SpscArrayQueue(i2);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (getAndIncrement() == 0) {
                Subscriber<? super R> subscriber = this.s;
                ErrorMode errorMode = this.a3;
                SimplePlainQueue<T> simplePlainQueue = this.Z2;
                AtomicThrowable atomicThrowable = this.X2;
                AtomicLong atomicLong = this.Z;
                int i2 = this.Y;
                int i4 = i2 - (i2 >> 1);
                int i5 = 1;
                while (true) {
                    if (this.d3) {
                        simplePlainQueue.clear();
                        this.g3 = null;
                    } else {
                        int i6 = this.h3;
                        if (atomicThrowable.get() == null || !(errorMode == ErrorMode.IMMEDIATE || (errorMode == ErrorMode.BOUNDARY && i6 == 0))) {
                            if (i6 == 0) {
                                boolean z = this.c3;
                                T poll = simplePlainQueue.poll();
                                boolean z2 = poll == null;
                                if (z && z2) {
                                    atomicThrowable.k(subscriber);
                                    return;
                                } else if (!z2) {
                                    int i7 = this.f3 + 1;
                                    if (i7 == i4) {
                                        this.f3 = 0;
                                        this.b3.request((long) i4);
                                    } else {
                                        this.f3 = i7;
                                    }
                                    try {
                                        Object apply = this.X.apply(poll);
                                        Objects.requireNonNull(apply, "The mapper returned a null MaybeSource");
                                        MaybeSource maybeSource = (MaybeSource) apply;
                                        this.h3 = 1;
                                        maybeSource.d(this.Y2);
                                    } catch (Throwable th) {
                                        Exceptions.b(th);
                                        this.b3.cancel();
                                        simplePlainQueue.clear();
                                        atomicThrowable.d(th);
                                    }
                                }
                            } else if (i6 == 2) {
                                long j2 = this.e3;
                                if (j2 != atomicLong.get()) {
                                    R r = this.g3;
                                    this.g3 = null;
                                    subscriber.onNext(r);
                                    this.e3 = j2 + 1;
                                    this.h3 = 0;
                                }
                            }
                        }
                    }
                    i5 = addAndGet(-i5);
                    if (i5 == 0) {
                        return;
                    }
                }
                simplePlainQueue.clear();
                this.g3 = null;
                atomicThrowable.k(subscriber);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.h3 = 0;
            a();
        }

        /* access modifiers changed from: package-private */
        public void c(Throwable th) {
            if (this.X2.d(th)) {
                if (this.a3 != ErrorMode.END) {
                    this.b3.cancel();
                }
                this.h3 = 0;
                a();
            }
        }

        public void cancel() {
            this.d3 = true;
            this.b3.cancel();
            this.Y2.c();
            this.X2.e();
            if (getAndIncrement() == 0) {
                this.Z2.clear();
                this.g3 = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void d(R r) {
            this.g3 = r;
            this.h3 = 2;
            a();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.b3, subscription)) {
                this.b3 = subscription;
                this.s.h(this);
                subscription.request((long) this.Y);
            }
        }

        public void onComplete() {
            this.c3 = true;
            a();
        }

        public void onError(Throwable th) {
            if (this.X2.d(th)) {
                if (this.a3 == ErrorMode.IMMEDIATE) {
                    this.Y2.c();
                }
                this.c3 = true;
                a();
            }
        }

        public void onNext(T t) {
            if (!this.Z2.offer(t)) {
                this.b3.cancel();
                onError(new MissingBackpressureException("queue full?!"));
                return;
            }
            a();
        }

        public void request(long j2) {
            BackpressureHelper.a(this.Z, j2);
            a();
        }
    }

    public FlowableConcatMapMaybe(Flowable<T> flowable, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i2) {
        this.X = flowable;
        this.Y = function;
        this.Z = errorMode;
        this.X2 = i2;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        this.X.J6(new ConcatMapMaybeSubscriber(subscriber, this.Y, this.X2, this.Z));
    }
}
