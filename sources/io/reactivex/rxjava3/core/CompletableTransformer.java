package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface CompletableTransformer {
    @NonNull
    CompletableSource e(@NonNull Completable completable);
}
