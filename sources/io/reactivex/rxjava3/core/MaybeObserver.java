package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;

public interface MaybeObserver<T> {
    void a(@NonNull T t);

    void b(@NonNull Disposable disposable);

    void onComplete();

    void onError(@NonNull Throwable th);
}
