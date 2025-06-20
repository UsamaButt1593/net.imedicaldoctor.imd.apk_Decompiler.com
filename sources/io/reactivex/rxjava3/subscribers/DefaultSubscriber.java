package io.reactivex.rxjava3.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;
import org.reactivestreams.Subscription;

public abstract class DefaultSubscriber<T> implements FlowableSubscriber<T> {
    Subscription s;

    /* access modifiers changed from: protected */
    public final void a() {
        Subscription subscription = this.s;
        this.s = SubscriptionHelper.CANCELLED;
        subscription.cancel();
    }

    /* access modifiers changed from: protected */
    public void b() {
        c(Long.MAX_VALUE);
    }

    /* access modifiers changed from: protected */
    public final void c(long j2) {
        Subscription subscription = this.s;
        if (subscription != null) {
            subscription.request(j2);
        }
    }

    public final void h(Subscription subscription) {
        if (EndConsumerHelper.f(this.s, subscription, getClass())) {
            this.s = subscription;
            b();
        }
    }
}
