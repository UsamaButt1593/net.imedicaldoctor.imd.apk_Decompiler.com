package io.reactivex.rxjava3.internal.subscribers;

import androidx.media3.common.C;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.BackpressureHelper;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public abstract class SinglePostCompleteSubscriber<T, R> extends AtomicLong implements FlowableSubscriber<T>, Subscription {
    private static final long X2 = 7917814472626990048L;
    static final long Y2 = Long.MIN_VALUE;
    static final long Z2 = Long.MAX_VALUE;
    protected Subscription X;
    protected R Y;
    protected long Z;
    protected final Subscriber<? super R> s;

    public SinglePostCompleteSubscriber(Subscriber<? super R> subscriber) {
        this.s = subscriber;
    }

    /* access modifiers changed from: protected */
    public final void c(R r) {
        long j2 = this.Z;
        if (j2 != 0) {
            BackpressureHelper.e(this, j2);
        }
        while (true) {
            long j3 = get();
            if ((j3 & Long.MIN_VALUE) != 0) {
                d(r);
                return;
            } else if ((j3 & Long.MAX_VALUE) != 0) {
                lazySet(C.f9084b);
                this.s.onNext(r);
                this.s.onComplete();
                return;
            } else {
                this.Y = r;
                if (!compareAndSet(0, Long.MIN_VALUE)) {
                    this.Y = null;
                } else {
                    return;
                }
            }
        }
    }

    public void cancel() {
        this.X.cancel();
    }

    /* access modifiers changed from: protected */
    public void d(R r) {
    }

    public void h(Subscription subscription) {
        if (SubscriptionHelper.l(this.X, subscription)) {
            this.X = subscription;
            this.s.h(this);
        }
    }

    public final void request(long j2) {
        long j3;
        if (SubscriptionHelper.k(j2)) {
            do {
                j3 = get();
                if ((j3 & Long.MIN_VALUE) != 0) {
                    if (compareAndSet(Long.MIN_VALUE, C.f9084b)) {
                        this.s.onNext(this.Y);
                        this.s.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(j3, BackpressureHelper.c(j3, j2)));
            this.X.request(j2);
        }
    }
}
