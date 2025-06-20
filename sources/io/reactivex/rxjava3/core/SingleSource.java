package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface SingleSource<T> {
    void e(@NonNull SingleObserver<? super T> singleObserver);
}
