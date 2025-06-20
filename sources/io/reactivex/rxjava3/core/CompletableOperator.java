package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface CompletableOperator {
    @NonNull
    CompletableObserver a(@NonNull CompletableObserver completableObserver) throws Throwable;
}
