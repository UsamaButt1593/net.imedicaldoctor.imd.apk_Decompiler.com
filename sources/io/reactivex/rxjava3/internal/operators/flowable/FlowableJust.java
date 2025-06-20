package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;
import io.reactivex.rxjava3.internal.subscriptions.ScalarSubscription;
import org.reactivestreams.Subscriber;

public final class FlowableJust<T> extends Flowable<T> implements ScalarSupplier<T> {
    private final T X;

    public FlowableJust(T t) {
        this.X = t;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        subscriber.h(new ScalarSubscription(subscriber, this.X));
    }

    public T get() {
        return this.X;
    }
}
