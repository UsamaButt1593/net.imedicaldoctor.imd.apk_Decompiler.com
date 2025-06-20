package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Cancellable;

public interface FlowableEmitter<T> extends Emitter<T> {
    void b(@Nullable Disposable disposable);

    boolean c(@NonNull Throwable th);

    long e();

    void h(@Nullable Cancellable cancellable);

    boolean isCancelled();

    @NonNull
    FlowableEmitter<T> serialize();
}
