package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableConcatMapEagerPublisher<T, R> extends Flowable<R> {
    final Publisher<T> X;
    final int X2;
    final Function<? super T, ? extends Publisher<? extends R>> Y;
    final ErrorMode Y2;
    final int Z;

    public FlowableConcatMapEagerPublisher(Publisher<T> publisher, Function<? super T, ? extends Publisher<? extends R>> function, int i2, int i3, ErrorMode errorMode) {
        this.X = publisher;
        this.Y = function;
        this.Z = i2;
        this.X2 = i3;
        this.Y2 = errorMode;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        this.X.e(new FlowableConcatMapEager.ConcatMapEagerDelayErrorSubscriber(subscriber, this.Y, this.Z, this.X2, this.Y2));
    }
}
