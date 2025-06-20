package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableHide<T> extends AbstractFlowableWithUpstream<T, T> {

    static final class HideSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        Subscription X;
        final Subscriber<? super T> s;

        HideSubscriber(Subscriber<? super T> subscriber) {
            this.s = subscriber;
        }

        public void cancel() {
            this.X.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X, subscription)) {
                this.X = subscription;
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
            this.s.onNext(t);
        }

        public void request(long j2) {
            this.X.request(j2);
        }
    }

    public FlowableHide(Flowable<T> flowable) {
        super(flowable);
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new HideSubscriber(subscriber));
    }
}
