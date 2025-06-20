package io.reactivex.rxjava3.parallel;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface ParallelFlowableConverter<T, R> {
    @NonNull
    R a(@NonNull ParallelFlowable<T> parallelFlowable);
}
