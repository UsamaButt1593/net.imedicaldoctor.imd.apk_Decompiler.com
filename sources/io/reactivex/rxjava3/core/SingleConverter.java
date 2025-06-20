package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface SingleConverter<T, R> {
    R c(@NonNull Single<T> single);
}
