package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Cancellable;

public interface SingleEmitter<T> {
    void a(@NonNull T t);

    void b(@Nullable Disposable disposable);

    boolean c(@NonNull Throwable th);

    boolean g();

    void h(@Nullable Cancellable cancellable);

    void onError(@NonNull Throwable th);
}
