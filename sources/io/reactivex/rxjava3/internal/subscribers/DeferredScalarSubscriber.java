package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class DeferredScalarSubscriber<T, R> extends DeferredScalarSubscription<R> implements FlowableSubscriber<T> {
    private static final long h3 = 2984505488220891551L;
    protected Subscription f3;
    protected boolean g3;

    public DeferredScalarSubscriber(Subscriber<? super R> subscriber) {
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
        if (this.g3) {
            f(this.Y);
        } else {
            this.X.onComplete();
        }
    }

    public void onError(Throwable th) {
        this.Y = null;
        this.X.onError(th);
    }
}
