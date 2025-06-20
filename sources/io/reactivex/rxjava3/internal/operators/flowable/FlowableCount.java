package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableCount<T> extends AbstractFlowableWithUpstream<T, Long> {

    static final class CountSubscriber extends DeferredScalarSubscription<Long> implements FlowableSubscriber<Object> {
        private static final long h3 = 4973004223787171406L;
        Subscription f3;
        long g3;

        CountSubscriber(Subscriber<? super Long> subscriber) {
            super(subscriber);
        }

        public void cancel() {
            super.cancel();
            this.f3.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.f3, subscription)) {
                this.f3 = subscription;
                this.X.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public void onComplete() {
            f(Long.valueOf(this.g3));
        }

        public void onError(Throwable th) {
            this.X.onError(th);
        }

        public void onNext(Object obj) {
            this.g3++;
        }
    }

    public FlowableCount(Flowable<T> flowable) {
        super(flowable);
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super Long> subscriber) {
        this.X.J6(new CountSubscriber(subscriber));
    }
}
