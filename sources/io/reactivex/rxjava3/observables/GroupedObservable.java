package io.reactivex.rxjava3.observables;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Observable;

public abstract class GroupedObservable<K, T> extends Observable<T> {
    final K s;

    protected GroupedObservable(@Nullable K k2) {
        this.s = k2;
    }

    @Nullable
    public K D8() {
        return this.s;
    }
}
