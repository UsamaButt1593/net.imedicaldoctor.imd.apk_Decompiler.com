package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface MaybeOnSubscribe<T> {
    void a(@NonNull MaybeEmitter<T> maybeEmitter) throws Throwable;
}
