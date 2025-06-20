package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface MaybeConverter<T, R> {
    @NonNull
    R a(@NonNull Maybe<T> maybe);
}
