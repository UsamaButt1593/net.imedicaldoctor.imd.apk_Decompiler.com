package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableConcatMapMaybe;
import io.reactivex.rxjava3.internal.util.ErrorMode;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableConcatMapMaybePublisher<T, R> extends Flowable<R> {
    final Publisher<T> X;
    final int X2;
    final Function<? super T, ? extends MaybeSource<? extends R>> Y;
    final ErrorMode Z;

    public FlowableConcatMapMaybePublisher(Publisher<T> publisher, Function<? super T, ? extends MaybeSource<? extends R>> function, ErrorMode errorMode, int i2) {
        this.X = publisher;
        this.Y = function;
        this.Z = errorMode;
        this.X2 = i2;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        this.X.e(new FlowableConcatMapMaybe.ConcatMapMaybeSubscriber(subscriber, this.Y, this.X2, this.Z));
    }
}
