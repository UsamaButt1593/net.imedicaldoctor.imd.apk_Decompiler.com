package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.AtomicThrowable;
import io.reactivex.rxjava3.internal.util.HalfSerializer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class StrictSubscriber<T> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
    private static final long Z2 = -4945028590049415624L;
    final AtomicThrowable X = new AtomicThrowable();
    final AtomicBoolean X2 = new AtomicBoolean();
    final AtomicLong Y = new AtomicLong();
    volatile boolean Y2;
    final AtomicReference<Subscription> Z = new AtomicReference<>();
    final Subscriber<? super T> s;

    public StrictSubscriber(Subscriber<? super T> subscriber) {
        this.s = subscriber;
    }

    public void cancel() {
        if (!this.Y2) {
            SubscriptionHelper.a(this.Z);
        }
    }

    public void h(Subscription subscription) {
        if (this.X2.compareAndSet(false, true)) {
            this.s.h(this);
            SubscriptionHelper.c(this.Z, this.Y, subscription);
            return;
        }
        subscription.cancel();
        cancel();
        onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
    }

    public void onComplete() {
        this.Y2 = true;
        HalfSerializer.b(this.s, this, this.X);
    }

    public void onError(Throwable th) {
        this.Y2 = true;
        HalfSerializer.d(this.s, th, this, this.X);
    }

    public void onNext(T t) {
        HalfSerializer.f(this.s, t, this, this.X);
    }

    public void request(long j2) {
        if (j2 <= 0) {
            cancel();
            onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j2));
            return;
        }
        SubscriptionHelper.b(this.Z, this.Y, j2);
    }
}
