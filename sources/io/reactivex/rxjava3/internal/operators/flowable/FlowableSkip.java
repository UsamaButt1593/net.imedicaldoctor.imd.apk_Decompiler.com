package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkip<T> extends AbstractFlowableWithUpstream<T, T> {
    final long Y;

    static final class SkipSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        long X;
        Subscription Y;
        final Subscriber<? super T> s;

        SkipSubscriber(Subscriber<? super T> subscriber, long j2) {
            this.s = subscriber;
            this.X = j2;
        }

        public void cancel() {
            this.Y.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y, subscription)) {
                long j2 = this.X;
                this.Y = subscription;
                this.s.h(this);
                subscription.request(j2);
            }
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            long j2 = this.X;
            if (j2 != 0) {
                this.X = j2 - 1;
            } else {
                this.s.onNext(t);
            }
        }

        public void request(long j2) {
            this.Y.request(j2);
        }
    }

    public FlowableSkip(Flowable<T> flowable, long j2) {
        super(flowable);
        this.Y = j2;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new SkipSubscriber(subscriber, this.Y));
    }
}
