package io.reactivex.rxjava3.flowables;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Flowable;

public abstract class GroupedFlowable<K, T> extends Flowable<T> {
    final K X;

    protected GroupedFlowable(@Nullable K k2) {
        this.X = k2;
    }

    @Nullable
    public K j9() {
        return this.X;
    }
}
