package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface ObservableConverter<T, R> {
    R d(@NonNull Observable<T> observable);
}
