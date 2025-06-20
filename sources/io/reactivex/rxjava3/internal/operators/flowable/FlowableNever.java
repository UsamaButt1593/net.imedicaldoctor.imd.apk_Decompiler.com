package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

public final class FlowableNever extends Flowable<Object> {
    public static final Flowable<Object> X = new FlowableNever();

    private FlowableNever() {
    }

    public void K6(Subscriber<? super Object> subscriber) {
        subscriber.h(EmptySubscription.INSTANCE);
    }
}
