package io.reactivex.rxjava3.internal.subscribers;

import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class BasicFuseableSubscriber<T, R> implements FlowableSubscriber<T>, QueueSubscription<R> {
    protected Subscription X;
    protected int X2;
    protected QueueSubscription<T> Y;
    protected boolean Z;
    protected final Subscriber<? super R> s;

    public BasicFuseableSubscriber(Subscriber<? super R> subscriber) {
        this.s = subscriber;
    }

    /* access modifiers changed from: protected */
    public void a() {
    }

    /* access modifiers changed from: protected */
    public boolean b() {
        return true;
    }

    /* access modifiers changed from: protected */
    public final void c(Throwable th) {
        Exceptions.b(th);
        this.X.cancel();
        onError(th);
    }

    public void cancel() {
        this.X.cancel();
    }

    public void clear() {
        this.Y.clear();
    }

    /* access modifiers changed from: protected */
    public final int d(int i2) {
        QueueSubscription<T> queueSubscription = this.Y;
        if (queueSubscription == null || (i2 & 4) != 0) {
            return 0;
        }
        int r = queueSubscription.r(i2);
        if (r != 0) {
            this.X2 = r;
        }
        return r;
    }

    public final void h(Subscription subscription) {
        if (SubscriptionHelper.l(this.X, subscription)) {
            this.X = subscription;
            if (subscription instanceof QueueSubscription) {
                this.Y = (QueueSubscription) subscription;
            }
            if (b()) {
                this.s.h(this);
                a();
            }
        }
    }

    public boolean isEmpty() {
        return this.Y.isEmpty();
    }

    public final boolean offer(R r) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void onComplete() {
        if (!this.Z) {
            this.Z = true;
            this.s.onComplete();
        }
    }

    public void onError(Throwable th) {
        if (this.Z) {
            RxJavaPlugins.Y(th);
            return;
        }
        this.Z = true;
        this.s.onError(th);
    }

    public final boolean q(R r, R r2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public void request(long j2) {
        this.X.request(j2);
    }
}
