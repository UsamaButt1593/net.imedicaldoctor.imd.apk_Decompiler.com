package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ResumeSingleObserver<T> implements SingleObserver<T> {
    final SingleObserver<? super T> X;
    final AtomicReference<Disposable> s;

    public ResumeSingleObserver(AtomicReference<Disposable> atomicReference, SingleObserver<? super T> singleObserver) {
        this.s = atomicReference;
        this.X = singleObserver;
    }

    public void a(T t) {
        this.X.a(t);
    }

    public void b(Disposable disposable) {
        DisposableHelper.c(this.s, disposable);
    }

    public void onError(Throwable th) {
        this.X.onError(th);
    }
}
