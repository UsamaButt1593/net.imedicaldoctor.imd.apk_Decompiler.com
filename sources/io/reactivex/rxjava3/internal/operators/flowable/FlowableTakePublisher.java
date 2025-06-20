package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableTake;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableTakePublisher<T> extends Flowable<T> {
    final Publisher<T> X;
    final long Y;

    public FlowableTakePublisher(Publisher<T> publisher, long j2) {
        this.X = publisher;
        this.Y = j2;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super T> subscriber) {
        this.X.e(new FlowableTake.TakeSubscriber(subscriber, this.Y));
    }
}
