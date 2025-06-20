package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.schedulers.Timed;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableTimeInterval<T> extends AbstractFlowableWithUpstream<T, Timed<T>> {
    final Scheduler Y;
    final TimeUnit Z;

    static final class TimeIntervalSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        final TimeUnit X;
        long X2;
        final Scheduler Y;
        Subscription Z;
        final Subscriber<? super Timed<T>> s;

        TimeIntervalSubscriber(Subscriber<? super Timed<T>> subscriber, TimeUnit timeUnit, Scheduler scheduler) {
            this.s = subscriber;
            this.Y = scheduler;
            this.X = timeUnit;
        }

        public void cancel() {
            this.Z.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Z, subscription)) {
                this.X2 = this.Y.e(this.X);
                this.Z = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            long e2 = this.Y.e(this.X);
            long j2 = this.X2;
            this.X2 = e2;
            this.s.onNext(new Timed(t, e2 - j2, this.X));
        }

        public void request(long j2) {
            this.Z.request(j2);
        }
    }

    public FlowableTimeInterval(Flowable<T> flowable, TimeUnit timeUnit, Scheduler scheduler) {
        super(flowable);
        this.Y = scheduler;
        this.Z = timeUnit;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super Timed<T>> subscriber) {
        this.X.J6(new TimeIntervalSubscriber(subscriber, this.Z, this.Y));
    }
}
