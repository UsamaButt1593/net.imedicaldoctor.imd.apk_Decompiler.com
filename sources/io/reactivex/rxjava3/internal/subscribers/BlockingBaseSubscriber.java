package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BlockingHelper;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import org.reactivestreams.Subscription;

public abstract class BlockingBaseSubscriber<T> extends CountDownLatch implements FlowableSubscriber<T> {
    Throwable X;
    Subscription Y;
    volatile boolean Z;
    T s;

    public BlockingBaseSubscriber() {
        super(1);
    }

    public final T a() {
        if (getCount() != 0) {
            try {
                BlockingHelper.b();
                await();
            } catch (InterruptedException e2) {
                Subscription subscription = this.Y;
                this.Y = SubscriptionHelper.CANCELLED;
                if (subscription != null) {
                    subscription.cancel();
                }
                throw ExceptionHelper.i(e2);
            }
        }
        Throwable th = this.X;
        if (th == null) {
            return this.s;
        }
        throw ExceptionHelper.i(th);
    }

    public final void h(Subscription subscription) {
        if (SubscriptionHelper.l(this.Y, subscription)) {
            this.Y = subscription;
            if (!this.Z) {
                subscription.request(Long.MAX_VALUE);
                if (this.Z) {
                    this.Y = SubscriptionHelper.CANCELLED;
                    subscription.cancel();
                }
            }
        }
    }

    public final void onComplete() {
        countDown();
    }
}
