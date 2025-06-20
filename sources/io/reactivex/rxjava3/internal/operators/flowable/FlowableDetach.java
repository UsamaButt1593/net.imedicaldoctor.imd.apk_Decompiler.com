package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.EmptyComponent;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableDetach<T> extends AbstractFlowableWithUpstream<T, T> {

    static final class DetachSubscriber<T> implements FlowableSubscriber<T>, Subscription {
        Subscription X;
        Subscriber<? super T> s;

        DetachSubscriber(Subscriber<? super T> subscriber) {
            this.s = subscriber;
        }

        public void cancel() {
            Subscription subscription = this.X;
            this.X = EmptyComponent.INSTANCE;
            this.s = EmptyComponent.e();
            subscription.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X, subscription)) {
                this.X = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            Subscriber<? super T> subscriber = this.s;
            this.X = EmptyComponent.INSTANCE;
            this.s = EmptyComponent.e();
            subscriber.onComplete();
        }

        public void onError(Throwable th) {
            Subscriber<? super T> subscriber = this.s;
            this.X = EmptyComponent.INSTANCE;
            this.s = EmptyComponent.e();
            subscriber.onError(th);
        }

        public void onNext(T t) {
            this.s.onNext(t);
        }

        public void request(long j2) {
            this.X.request(j2);
        }
    }

    public FlowableDetach(Flowable<T> flowable) {
        super(flowable);
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new DetachSubscriber(subscriber));
    }
}
