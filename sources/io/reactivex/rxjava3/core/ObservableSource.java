package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface ObservableSource<T> {
    void a(@NonNull Observer<? super T> observer);
}
