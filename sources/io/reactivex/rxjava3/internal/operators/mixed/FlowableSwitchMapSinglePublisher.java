package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.operators.mixed.FlowableSwitchMapSingle;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public final class FlowableSwitchMapSinglePublisher<T, R> extends Flowable<R> {
    final Publisher<T> X;
    final Function<? super T, ? extends SingleSource<? extends R>> Y;
    final boolean Z;

    public FlowableSwitchMapSinglePublisher(Publisher<T> publisher, Function<? super T, ? extends SingleSource<? extends R>> function, boolean z) {
        this.X = publisher;
        this.Y = function;
        this.Z = z;
    }

    /* access modifiers changed from: protected */
    public void K6(Subscriber<? super R> subscriber) {
        this.X.e(new FlowableSwitchMapSingle.SwitchMapSingleSubscriber(subscriber, this.Y, this.Z));
    }
}
