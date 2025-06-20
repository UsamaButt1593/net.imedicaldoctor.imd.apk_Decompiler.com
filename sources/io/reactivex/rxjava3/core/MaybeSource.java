package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface MaybeSource<T> {
    void d(@NonNull MaybeObserver<? super T> maybeObserver);
}
