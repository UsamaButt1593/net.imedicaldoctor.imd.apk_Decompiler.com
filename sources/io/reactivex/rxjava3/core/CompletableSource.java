package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface CompletableSource {
    void a(@NonNull CompletableObserver completableObserver);
}
