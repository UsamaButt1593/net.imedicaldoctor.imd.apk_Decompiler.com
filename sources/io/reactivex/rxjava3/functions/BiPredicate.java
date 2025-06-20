package io.reactivex.rxjava3.functions;

import io.reactivex.rxjava3.annotations.NonNull;

@FunctionalInterface
public interface BiPredicate<T1, T2> {
    boolean a(@NonNull T1 t1, @NonNull T2 t2) throws Throwable;
}
