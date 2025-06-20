package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;
import io.reactivex.rxjava3.internal.subscriptions.EmptySubscription;
import org.reactivestreams.Subscriber;

public final class FlowableEmpty extends Flowable<Object> implements ScalarSupplier<Object> {
    public static final Flowable<Object> X = new FlowableEmpty();

    private FlowableEmpty() {
    }

    public void K6(Subscriber<? super Object> subscriber) {
        EmptySubscription.a(subscriber);
    }

    public Object get() {
        return null;
    }
}
