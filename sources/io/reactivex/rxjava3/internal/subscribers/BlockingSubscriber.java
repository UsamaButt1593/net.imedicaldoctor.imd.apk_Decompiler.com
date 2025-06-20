package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class BlockingSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    private static final long X = -4875965440900746268L;
    public static final Object Y = new Object();
    final Queue<Object> s;

    public BlockingSubscriber(Queue<Object> queue) {
        this.s = queue;
    }

    public boolean a() {
        return get() == SubscriptionHelper.CANCELLED;
    }

    public void cancel() {
        if (SubscriptionHelper.a(this)) {
            this.s.offer(Y);
        }
    }

    public void h(Subscription subscription) {
        if (SubscriptionHelper.i(this, subscription)) {
            this.s.offer(NotificationLite.r(this));
        }
    }

    public void onComplete() {
        this.s.offer(NotificationLite.f());
    }

    public void onError(Throwable th) {
        this.s.offer(NotificationLite.h(th));
    }

    public void onNext(T t) {
        this.s.offer(NotificationLite.q(t));
    }

    public void request(long j2) {
        ((Subscription) get()).request(j2);
    }
}
