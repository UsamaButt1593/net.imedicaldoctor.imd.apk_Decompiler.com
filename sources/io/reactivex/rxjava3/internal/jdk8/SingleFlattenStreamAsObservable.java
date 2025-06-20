package io.reactivex.rxjava3.internal.jdk8;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.internal.jdk8.MaybeFlattenStreamAsObservable;
import java.util.stream.Stream;

public final class SingleFlattenStreamAsObservable<T, R> extends Observable<R> {
    final Function<? super T, ? extends Stream<? extends R>> X;
    final Single<T> s;

    public SingleFlattenStreamAsObservable(Single<T> single, Function<? super T, ? extends Stream<? extends R>> function) {
        this.s = single;
        this.X = function;
    }

    /* access modifiers changed from: protected */
    public void g6(@NonNull Observer<? super R> observer) {
        this.s.e(new MaybeFlattenStreamAsObservable.FlattenStreamMultiObserver(observer, this.X));
    }
}
