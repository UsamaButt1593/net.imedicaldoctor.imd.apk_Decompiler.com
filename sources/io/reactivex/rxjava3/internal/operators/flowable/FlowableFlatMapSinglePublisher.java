package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableFlatMapSingle;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableFlatMapSinglePublisher<T, R> extends Flowable<R> {
    final Publisher<T> X;
    final int X2;
    final Function<? super T, ? extends SingleSource<? extends R>> Y;
    final boolean Z;

    public FlowableFlatMapSinglePublisher(Publisher<T> publisher, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z, int i2) {
        this.X = publisher;
        this.Y = function;
        this.Z = z;
        this.X2 = i2;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        this.X.e(new FlowableFlatMapSingle.FlatMapSingleSubscriber(subscriber, this.Y, this.Z, this.X2));
    }
}
