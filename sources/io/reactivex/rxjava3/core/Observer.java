package io.reactivex.rxjava3.core;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.disposables.Disposable;

public interface Observer<T> {
    void b(@NonNull Disposable disposable);

    void onComplete();

    void onError(@NonNull Throwable th);

    void onNext(@NonNull T t);
}
