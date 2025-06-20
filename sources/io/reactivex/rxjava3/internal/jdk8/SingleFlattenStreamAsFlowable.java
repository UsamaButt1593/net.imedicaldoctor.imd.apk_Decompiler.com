package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.jdk8.MaybeFlattenStreamAsFlowable;
import java.util.stream.Stream;
import org.reactivestreams.Subscriber;

public final class SingleFlattenStreamAsFlowable<T, R> extends Flowable<R> {
    final Single<T> X;
    final Function<? super T, ? extends Stream<? extends R>> Y;

    public SingleFlattenStreamAsFlowable(Single<T> single, Function<? super T, ? extends Stream<? extends R>> function) {
        this.X = single;
        this.Y = function;
    }

    /* access modifiers changed from: protected */
    public void K6(@NonNull Subscriber<? super R> subscriber) {
        this.X.e(new MaybeFlattenStreamAsFlowable.FlattenStreamMultiObserver(subscriber, this.Y));
    }
}
