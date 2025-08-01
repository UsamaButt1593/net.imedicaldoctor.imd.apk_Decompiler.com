package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface ObservableOnSubscribe<T> {
    void a(@NonNull ObservableEmitter<T> observableEmitter) throws Throwable;
}
