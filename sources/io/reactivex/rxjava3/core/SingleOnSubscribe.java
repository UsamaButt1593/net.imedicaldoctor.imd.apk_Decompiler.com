package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface SingleOnSubscribe<T> {
    void a(@NonNull SingleEmitter<T> singleEmitter) throws Throwable;
}
