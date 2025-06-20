package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.exceptions.MissingBackpressureException;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableThrottleLatest<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler X2;
    final long Y;
    final boolean Y2;
    final TimeUnit Z;

    static final class ThrottleLatestSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription, Runnable {
        private static final long h3 = -8296689127439125014L;
        final long X;
        final boolean X2;
        final TimeUnit Y;
        final AtomicReference<T> Y2 = new AtomicReference<>();
        final Scheduler.Worker Z;
        final AtomicLong Z2 = new AtomicLong();
        Subscription a3;
        volatile boolean b3;
        Throwable c3;
        volatile boolean d3;
        volatile boolean e3;
        long f3;
        boolean g3;
        final Subscriber<? super T> s;

        ThrottleLatestSubscriber(Subscriber<? super T> subscriber, long j2, TimeUnit timeUnit, Scheduler.Worker worker, boolean z) {
            this.s = subscriber;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = worker;
            this.X2 = z;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            Throwable missingBackpressureException;
            if (getAndIncrement() == 0) {
                AtomicReference<T> atomicReference = this.Y2;
                AtomicLong atomicLong = this.Z2;
                Subscriber<? super T> subscriber = this.s;
                int i2 = 1;
                while (!this.d3) {
                    boolean z = this.b3;
                    if (!z || this.c3 == null) {
                        boolean z2 = atomicReference.get() == null;
                        if (z) {
                            if (z2 || !this.X2) {
                                atomicReference.lazySet((Object) null);
                            } else {
                                T andSet = atomicReference.getAndSet((Object) null);
                                long j2 = this.f3;
                                if (j2 != atomicLong.get()) {
                                    this.f3 = j2 + 1;
                                    subscriber.onNext(andSet);
                                } else {
                                    missingBackpressureException = new MissingBackpressureException("Could not emit final value due to lack of requests");
                                }
                            }
                            subscriber.onComplete();
                            this.Z.m();
                            return;
                        }
                        if (z2) {
                            if (this.e3) {
                                this.g3 = false;
                                this.e3 = false;
                            }
                        } else if (!this.g3 || this.e3) {
                            T andSet2 = atomicReference.getAndSet((Object) null);
                            long j3 = this.f3;
                            if (j3 != atomicLong.get()) {
                                subscriber.onNext(andSet2);
                                this.f3 = j3 + 1;
                                this.e3 = false;
                                this.g3 = true;
                                this.Z.c(this, this.X, this.Y);
                            } else {
                                this.a3.cancel();
                                missingBackpressureException = new MissingBackpressureException("Could not emit value due to lack of requests");
                            }
                        }
                        i2 = addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    } else {
                        atomicReference.lazySet((Object) null);
                        missingBackpressureException = this.c3;
                    }
                    subscriber.onError(missingBackpressureException);
                    this.Z.m();
                    return;
                }
                atomicReference.lazySet((Object) null);
            }
        }

        public void cancel() {
            this.d3 = true;
            this.a3.cancel();
            this.Z.m();
            if (getAndIncrement() == 0) {
                this.Y2.lazySet((Object) null);
            }
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.a3, subscription)) {
                this.a3 = subscription;
                this.s.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            this.b3 = true;
            a();
        }

        public void onError(Throwable th) {
            this.c3 = th;
            this.b3 = true;
            a();
        }

        public void onNext(T t) {
            this.Y2.set(t);
            a();
        }

        public void request(long j2) {
            if (SubscriptionHelper.k(j2)) {
                BackpressureHelper.a(this.Z2, j2);
            }
        }

        public void run() {
            this.e3 = true;
            a();
        }
    }

    public FlowableThrottleLatest(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler, boolean z) {
        super(flowable);
        this.Y = j2;
        this.Z = timeUnit;
        this.X2 = scheduler;
        this.Y2 = z;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new ThrottleLatestSubscriber(subscriber, this.Y, this.Z, this.X2.d(), this.Y2));
    }
}
