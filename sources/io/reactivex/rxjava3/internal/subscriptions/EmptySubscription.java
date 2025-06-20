package io.reactivex.rxjava3.internal.subscriptions;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import org.reactivestreams.Subscriber;

public enum EmptySubscription implements QueueSubscription<Object> {
    INSTANCE;

    public static void a(Subscriber<?> subscriber) {
        subscriber.h(INSTANCE);
        subscriber.onComplete();
    }

    public static void b(Throwable th, Subscriber<?> subscriber) {
        subscriber.h(INSTANCE);
        subscriber.onError(th);
    }

    public void cancel() {
    }

    public void clear() {
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean offer(Object obj) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Nullable
    public Object poll() {
        return null;
    }

    public boolean q(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public int r(int i2) {
        return i2 & 2;
    }

    public void request(long j2) {
        SubscriptionHelper.k(j2);
    }

    public String toString() {
        return "EmptySubscription";
    }
}
