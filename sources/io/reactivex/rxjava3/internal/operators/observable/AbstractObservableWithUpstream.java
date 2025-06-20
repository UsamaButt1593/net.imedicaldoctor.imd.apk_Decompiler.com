package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.internal.fuseable.HasUpstreamObservableSource;

abstract class AbstractObservableWithUpstream<T, U> extends Observable<U> implements HasUpstreamObservableSource<T> {
    protected final ObservableSource<T> s;

    AbstractObservableWithUpstream(ObservableSource<T> observableSource) {
        this.s = observableSource;
    }

    public final ObservableSource<T> source() {
        return this.s;
    }
}
