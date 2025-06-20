package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;

public abstract class DefaultObserver<T> implements Observer<T> {
    private Disposable s;

    /* access modifiers changed from: protected */
    public final void a() {
        Disposable disposable = this.s;
        this.s = DisposableHelper.DISPOSED;
        disposable.m();
    }

    public final void b(@NonNull Disposable disposable) {
        if (EndConsumerHelper.e(this.s, disposable, getClass())) {
            this.s = disposable;
            c();
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
    }
}
