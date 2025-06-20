package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;
import java.util.concurrent.atomic.AtomicReference;

public abstract class DisposableMaybeObserver<T> implements MaybeObserver<T>, Disposable {
    final AtomicReference<Disposable> s = new AtomicReference<>();

    public final void b(@NonNull Disposable disposable) {
        if (EndConsumerHelper.c(this.s, disposable, getClass())) {
            c();
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    public final boolean g() {
        return this.s.get() == DisposableHelper.DISPOSED;
    }

    public final void m() {
        DisposableHelper.a(this.s);
    }
}
