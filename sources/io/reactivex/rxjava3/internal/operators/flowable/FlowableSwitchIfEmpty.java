package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableSubscriber;
import io.reactivex.rxjava3.internal.subscriptions.SubscriptionArbiter;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableSwitchIfEmpty<T> extends AbstractFlowableWithUpstream<T, T> {
    final Publisher<? extends T> Y;

    static final class SwitchIfEmptySubscriber<T> implements FlowableSubscriber<T> {
        final Publisher<? extends T> X;
        final SubscriptionArbiter Y = new SubscriptionArbiter(false);
        boolean Z = true;
        final Subscriber<? super T> s;

        SwitchIfEmptySubscriber(Subscriber<? super T> subscriber, Publisher<? extends T> publisher) {
            this.s = subscriber;
            this.X = publisher;
        }

        public void h(Subscription subscription) {
            this.Y.i(subscription);
        }

        public void onComplete() {
            if (this.Z) {
                this.Z = false;
                this.X.e(this);
                return;
            }
            this.s.onComplete();
        }

        public void onError(Throwable th) {
            this.s.onError(th);
        }

        public void onNext(T t) {
            if (this.Z) {
                this.Z = false;
            }
            this.s.onNext(t);
        }
    }

    public FlowableSwitchIfEmpty(Flowable<T> flowable, Publisher<? extends T> publisher) {
        super(flowable);
        this.Y = publisher;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        SwitchIfEmptySubscriber switchIfEmptySubscriber = new SwitchIfEmptySubscriber(subscriber, this.Y);
        subscriber.h(switchIfEmptySubscriber.Y);
        this.X.J6(switchIfEmptySubscriber);
    }
}
