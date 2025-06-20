package io.reactivex.rxjava3.internal.subscriptions;

import java.util.concurrent.atomic.AtomicBoolean;
import org.reactivestreams.Subscription;

public final class BooleanSubscription extends AtomicBoolean implements Subscription {
    private static final long s = -8127758972444290902L;

    public boolean a() {
        return get();
    }

    public void cancel() {
        lazySet(true);
    }

    public void request(long j2) {
        SubscriptionHelper.k(j2);
    }

    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + ")";
    }
}
