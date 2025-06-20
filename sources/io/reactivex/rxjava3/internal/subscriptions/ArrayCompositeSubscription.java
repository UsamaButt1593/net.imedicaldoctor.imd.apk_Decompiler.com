package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReferenceArray;
import org.reactivestreams.Subscription;

public final class ArrayCompositeSubscription extends AtomicReferenceArray<Subscription> implements Disposable {
    private static final long s = 2746389416410565408L;

    public ArrayCompositeSubscription(int i2) {
        super(i2);
    }

    public Subscription a(int i2, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = (Subscription) get(i2);
            if (subscription2 == SubscriptionHelper.CANCELLED) {
                if (subscription == null) {
                    return null;
                }
                subscription.cancel();
                return null;
            }
        } while (!compareAndSet(i2, subscription2, subscription));
        return subscription2;
    }

    public boolean b(int i2, Subscription subscription) {
        Subscription subscription2;
        do {
            subscription2 = (Subscription) get(i2);
            if (subscription2 == SubscriptionHelper.CANCELLED) {
                if (subscription == null) {
                    return false;
                }
                subscription.cancel();
                return false;
            }
        } while (!compareAndSet(i2, subscription2, subscription));
        if (subscription2 == null) {
            return true;
        }
        subscription2.cancel();
        return true;
    }

    public boolean g() {
        return get(0) == SubscriptionHelper.CANCELLED;
    }

    public void m() {
        Subscription subscription;
        if (get(0) != SubscriptionHelper.CANCELLED) {
            int length = length();
            for (int i2 = 0; i2 < length; i2++) {
                Subscription subscription2 = (Subscription) get(i2);
                SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
                if (!(subscription2 == subscriptionHelper || (subscription = (Subscription) getAndSet(i2, subscriptionHelper)) == subscriptionHelper || subscription == null)) {
                    subscription.cancel();
                }
            }
        }
    }
}
