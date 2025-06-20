package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface FlowableOnSubscribe<T> {
    void a(@NonNull FlowableEmitter<T> flowableEmitter) throws Throwable;
}
