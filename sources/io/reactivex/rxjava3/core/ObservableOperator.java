package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface ObservableOperator<Downstream, Upstream> {
    @NonNull
    Observer<? super Upstream> a(@NonNull Observer<? super Downstream> observer) throws Throwable;
}
