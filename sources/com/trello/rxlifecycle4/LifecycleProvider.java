package com.trello.rxlifecycle4;

import io.reactivex.rxjava3.core.Observable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nonnull;

public interface LifecycleProvider<E> {
    @CheckReturnValue
    @Nonnull
    Observable<E> a();

    @CheckReturnValue
    @Nonnull
    <T> LifecycleTransformer<T> h(@Nonnull E e2);

    @CheckReturnValue
    @Nonnull
    <T> LifecycleTransformer<T> i();
}
