package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableMap;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableMapPublisher<T, U> extends Flowable<U> {
    final Publisher<T> X;
    final Function<? super T, ? extends U> Y;

    public FlowableMapPublisher(Publisher<T> publisher, Function<? super T, ? extends U> function) {
        this.X = publisher;
        this.Y = function;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super U> subscriber) {
        this.X.e(new FlowableMap.MapSubscriber(subscriber, this.Y));
    }
}
