package io.reactivex.rxjava3.internal.disposables;

import io.reactivex.rxjava3.disposables.Disposable;
import java.util.concurrent.atomic.AtomicReference;

public final class SequentialDisposable extends AtomicReference<Disposable> implements Disposable {
    private static final long s = -754898800686245608L;

    public SequentialDisposable() {
    }

    public boolean a(Disposable disposable) {
        return DisposableHelper.c(this, disposable);
    }

    public boolean b(Disposable disposable) {
        return DisposableHelper.f(this, disposable);
    }

    public boolean g() {
        return DisposableHelper.b((Disposable) get());
    }

    public void m() {
        DisposableHelper.a(this);
    }

    public SequentialDisposable(Disposable disposable) {
        lazySet(disposable);
    }
}
