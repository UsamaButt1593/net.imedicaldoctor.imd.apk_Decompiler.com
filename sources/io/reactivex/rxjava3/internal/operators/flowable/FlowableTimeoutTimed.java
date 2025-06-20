package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.SequentialDisposable;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeoutTimed<T> extends AbstractFlowableWithUpstream<T, T> {
    final Scheduler X2;
    final long Y;
    final Publisher<? extends T> Y2;
    final TimeUnit Z;

    static final class FallbackSubscriber<T> implements FlowableSubscriber<T> {
        final SubscriptionArbiter X;
        final Subscriber<? super T> s;

        FallbackSubscriber(Subscriber<? super T> subscriber, SubscriptionArbiter subscriptionArbiter) {
            this.s = subscriber;
            this.X = subscriptionArbiter;
        }

        public void h(Subscription subscription) {
            this.X.i(subscription);
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }
    }

    static final class TimeoutFallbackSubscriber<T> extends SubscriptionArbiter implements FlowableSubscriber<T>, TimeoutSupport {
        private static final long l3 = 3764492702657003550L;
        final Subscriber<? super T> c3;
        final long d3;
        final TimeUnit e3;
        final Scheduler.Worker f3;
        final SequentialDisposable g3 = new SequentialDisposable();
        final AtomicReference<Subscription> h3 = new AtomicReference<>();
        final AtomicLong i3 = new AtomicLong();
        long j3;
        Publisher<? extends T> k3;

        TimeoutFallbackSubscriber(Subscriber<? super T> subscriber, long j2, TimeUnit timeUnit, Scheduler.Worker worker, Publisher<? extends T> publisher) {
            super(true);
            this.c3 = subscriber;
            this.d3 = j2;
            this.e3 = timeUnit;
            this.f3 = worker;
            this.k3 = publisher;
        }

        public void a(long j2) {
            if (this.i3.compareAndSet(j2, Long.MAX_VALUE)) {
                SubscriptionHelper.a(this.h3);
                long j4 = this.j3;
                if (j4 != 0) {
                    g(j4);
                }
                Publisher<? extends T> publisher = this.k3;
                this.k3 = null;
                publisher.e(new FallbackSubscriber(this.c3, this));
                this.f3.m();
            }
        }

        public void cancel() {
            super.cancel();
            this.f3.m();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.i(this.h3, subscription)) {
                i(subscription);
            }
        }

        /* access modifiers changed from: package-private */
        public void j(long j2) {
            this.g3.a(this.f3.c(new TimeoutTask(j2, this), this.d3, this.e3));
        }

        public void onComplete() {
            if (this.i3.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.g3.m();
                this.c3.onComplete();
                this.f3.m();
            }
        }

        public void onError(Throwable th) {
            if (this.i3.getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.g3.m();
                this.c3.onError(th);
                this.f3.m();
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            long j2 = this.i3.get();
            if (j2 != Long.MAX_VALUE) {
                long j4 = j2 + 1;
                if (this.i3.compareAndSet(j2, j4)) {
                    ((Disposable) this.g3.get()).m();
                    this.j3++;
                    this.c3.onNext(t);
                    j(j4);
                }
            }
        }
    }

    static final class TimeoutSubscriber<T> extends AtomicLong implements FlowableSubscriber<T>, Subscription, TimeoutSupport {
        private static final long a3 = 3764492702657003550L;
        final long X;
        final SequentialDisposable X2 = new SequentialDisposable();
        final TimeUnit Y;
        final AtomicReference<Subscription> Y2 = new AtomicReference<>();
        final Scheduler.Worker Z;
        final AtomicLong Z2 = new AtomicLong();
        final Subscriber<? super T> s;

        TimeoutSubscriber(Subscriber<? super T> subscriber, long j2, TimeUnit timeUnit, Scheduler.Worker worker) {
            this.s = subscriber;
            this.X = j2;
            this.Y = timeUnit;
            this.Z = worker;
        }

        public void a(long j2) {
            if (compareAndSet(j2, Long.MAX_VALUE)) {
                SubscriptionHelper.a(this.Y2);
                this.s.onError(new TimeoutException(ExceptionHelper.h(this.X, this.Y)));
                this.Z.m();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(long j2) {
            this.X2.a(this.Z.c(new TimeoutTask(j2, this), this.X, this.Y));
        }

        public void cancel() {
            SubscriptionHelper.a(this.Y2);
            this.Z.m();
        }

        public void h(Subscription subscription) {
            SubscriptionHelper.c(this.Y2, this.Z2, subscription);
        }

        public void onComplete() {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.X2.m();
                this.s.onComplete();
                this.Z.m();
            }
        }

        public void onError(Throwable th) {
            if (getAndSet(Long.MAX_VALUE) != Long.MAX_VALUE) {
                this.X2.m();
                this.s.onError(th);
                this.Z.m();
                return;
            }
            RxJavaPlugins.Y(th);
        }

        public void onNext(T t) {
            long j2 = get();
            if (j2 != Long.MAX_VALUE) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    ((Disposable) this.X2.get()).m();
                    this.s.onNext(t);
                    b(j3);
                }
            }
        }

        public void request(long j2) {
            SubscriptionHelper.b(this.Y2, this.Z2, j2);
        }
    }

    interface TimeoutSupport {
        void a(long j2);
    }

    static final class TimeoutTask implements Runnable {
        final long X;
        final TimeoutSupport s;

        TimeoutTask(long j2, TimeoutSupport timeoutSupport) {
            this.X = j2;
            this.s = timeoutSupport;
        }

        public void run() {
            this.s.a(this.X);
        }
    }

    public FlowableTimeoutTimed(Flowable<T> flowable, long j2, TimeUnit timeUnit, Scheduler scheduler, Publisher<? extends T> publisher) {
        super(flowable);
        this.Y = j2;
        this.Z = timeUnit;
        this.X2 = scheduler;
        this.Y2 = publisher;
    }

    /* JADX WARNING: type inference failed for: r0v2, types: [io.reactivex.rxjava3.core.FlowableSubscriber] */
    /* JADX WARNING: type inference failed for: r3v4, types: [io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeoutTimed$TimeoutFallbackSubscriber] */
    /* JADX WARNING: type inference failed for: r3v5, types: [io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeoutTimed$TimeoutSubscriber] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void K6(org.reactivestreams.Subscriber<? super T> r11) {
        /*
            r10 = this;
            org.reactivestreams.Publisher<? extends T> r0 = r10.Y2
            r1 = 0
            if (r0 != 0) goto L_0x0023
            io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeoutTimed$TimeoutSubscriber r0 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeoutTimed$TimeoutSubscriber
            long r5 = r10.Y
            java.util.concurrent.TimeUnit r7 = r10.Z
            io.reactivex.rxjava3.core.Scheduler r3 = r10.X2
            io.reactivex.rxjava3.core.Scheduler$Worker r8 = r3.d()
            r3 = r0
            r4 = r11
            r3.<init>(r4, r5, r7, r8)
            r11.h(r0)
            r0.b(r1)
        L_0x001d:
            io.reactivex.rxjava3.core.Flowable<T> r11 = r10.X
            r11.J6(r0)
            goto L_0x003d
        L_0x0023:
            io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeoutTimed$TimeoutFallbackSubscriber r0 = new io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeoutTimed$TimeoutFallbackSubscriber
            long r5 = r10.Y
            java.util.concurrent.TimeUnit r7 = r10.Z
            io.reactivex.rxjava3.core.Scheduler r3 = r10.X2
            io.reactivex.rxjava3.core.Scheduler$Worker r8 = r3.d()
            org.reactivestreams.Publisher<? extends T> r9 = r10.Y2
            r3 = r0
            r4 = r11
            r3.<init>(r4, r5, r7, r8, r9)
            r11.h(r0)
            r0.j(r1)
            goto L_0x001d
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.flowable.FlowableTimeoutTimed.K6(org.reactivestreams.Subscriber):void");
    }
}
