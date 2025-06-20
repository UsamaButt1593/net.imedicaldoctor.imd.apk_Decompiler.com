package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.fuseable.QueueSubscription;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableIgnoreElements<T> extends AbstractFlowableWithUpstream<T, T> {

    static final class IgnoreElementsSubscriber<T> implements FlowableSubscriber<T>, QueueSubscription<T> {
        Subscription X;
        final Subscriber<? super T> s;

        IgnoreElementsSubscriber(Subscriber<? super T> subscriber) {
            this.s = subscriber;
        }

        public void cancel() {
            this.X.cancel();
        }

        public void clear() {
        }

        public void h(Subscription subscription) {
            if (SubscriptionHelper.l(this.X, subscription)) {
                this.X = subscription;
                this.s.h(this);
                subscription.request(Long.MAX_VALUE);
            }
        }

        public boolean isEmpty() {
            return true;
        }

        public boolean offer(T t) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public void onComplete() {
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
        }

        @Nullable
        public T poll() {
            return null;
        }

        public boolean q(T t, T t2) {
            throw new UnsupportedOperationException("Should not be called!");
        }

        public int r(int i2) {
            return i2 & 2;
        }

        public void request(long j2) {
        }
    }

    public FlowableIgnoreElements(Flowable<T> flowable) {
        super(flowable);
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.J6(new IgnoreElementsSubscriber(subscriber));
    }
}
