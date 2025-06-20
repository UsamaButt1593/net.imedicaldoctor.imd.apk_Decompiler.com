package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.fuseable.SimpleQueue;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.QueueDrainHelper;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Subscription;

public final class InnerQueuedSubscriber<T> extends AtomicReference<Subscription> implements FlowableSubscriber<T>, Subscription {
    private static final long a3 = 22876611072430776L;
    final int X;
    volatile boolean X2;
    final int Y;
    long Y2;
    volatile SimpleQueue<T> Z;
    int Z2;
    final InnerQueuedSubscriberSupport<T> s;

    public InnerQueuedSubscriber(InnerQueuedSubscriberSupport<T> innerQueuedSubscriberSupport, int i2) {
        this.s = innerQueuedSubscriberSupport;
        this.X = i2;
        this.Y = i2 - (i2 >> 2);
    }

    public boolean a() {
        return this.X2;
    }

    public SimpleQueue<T> b() {
        return this.Z;
    }

    public void c() {
        this.X2 = true;
    }

    public void cancel() {
        SubscriptionHelper.a(this);
    }

    public void h(Subscription subscription) {
        if (SubscriptionHelper.i(this, subscription)) {
            if (subscription instanceof QueueSubscription) {
                QueueSubscription queueSubscription = (QueueSubscription) subscription;
                int r = queueSubscription.r(3);
                if (r == 1) {
                    this.Z2 = r;
                    this.Z = queueSubscription;
                    this.X2 = true;
                    this.s.a(this);
                    return;
                } else if (r == 2) {
                    this.Z2 = r;
                    this.Z = queueSubscription;
                    QueueDrainHelper.j(subscription, this.X);
                    return;
                }
            }
            this.Z = QueueDrainHelper.c(this.X);
            QueueDrainHelper.j(subscription, this.X);
        }
    }

    public void onComplete() {
        this.s.a(this);
    }

    public void onError(Throwable th) {
        this.s.b(this, th);
    }

    public void onNext(T t) {
        if (this.Z2 == 0) {
            this.s.c(this, t);
        } else {
            this.s.d();
        }
    }

    public void request(long j2) {
        if (this.Z2 != 1) {
            long j3 = this.Y2 + j2;
            if (j3 >= ((long) this.Y)) {
                this.Y2 = 0;
                ((Subscription) get()).request(j3);
                return;
            }
            this.Y2 = j3;
        }
    }
}
