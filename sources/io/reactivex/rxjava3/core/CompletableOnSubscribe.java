package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface CompletableOnSubscribe {
    void a(@NonNull CompletableEmitter completableEmitter) throws Throwable;
}
