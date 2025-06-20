package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSkipLast<T> extends AbstractFlowableWithUpstream<T, T> {
    final int Y;

    static final class SkipLastSubscriber<T> extends ArrayDeque<T> implements FlowableSubscriber<T>, Subscription {
        private static final long Z = -3807491841935125653L;
        final int X;
        Subscription Y;
        final Subscriber<? super T> s;

        SkipLastSubscriber(Subscriber<? super T> subscriber, int i2) {
            super(i2);
            this.s = subscriber;
            this.X = i2;
        }

        public void cancel() {
            this.Y.cancel();
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.Y, subscription)) {
                this.Y = subscription;
                this.s.h(this);
            }
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (this.X == size()) {
                this.s.onNext(poll());
            } else {
                this.Y.request(1);
            }
            offer(t);
        }

        public void request(long j2) {
            this.Y.request(j2);
        }
    }

    public FlowableSkipLast(Flowable<T> flowable, int i2) {
        super(flowable);
        this.Y = i2;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new SkipLastSubscriber(subscriber, this.Y));
    }
}
