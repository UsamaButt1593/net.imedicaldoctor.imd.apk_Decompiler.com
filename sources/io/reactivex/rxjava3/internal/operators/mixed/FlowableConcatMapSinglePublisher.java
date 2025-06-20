package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapSingle;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableConcatMapSinglePublisher<T, R> extends Flowable<R> {
    final Publisher<T> X;
    final int X2;
    final Function<? super T, ? extends SingleSource<? extends R>> Y;
    final ErrorMode Z;

    public FlowableConcatMapSinglePublisher(Publisher<T> publisher, Function<? super T, ? extends SingleSource<? extends R>> function, ErrorMode errorMode, int i2) {
        this.X = publisher;
        this.Y = function;
        this.Z = errorMode;
        this.X2 = i2;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        this.X.e(new FlowableConcatMapSingle.ConcatMapSingleSubscriber(subscriber, this.Y, this.X2, this.Z));
    }
}
