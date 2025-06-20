package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class SerialDisposable implements Disposable {
    final AtomicReference<Disposable> s;

    public SerialDisposable() {
        this.s = new AtomicReference<>();
    }

    @Nullable
    public Disposable a() {
        Disposable disposable = this.s.get();
        return disposable == DisposableHelper.DISPOSED ? b.a() : disposable;
    }

    public boolean b(@Nullable Disposable disposable) {
        return DisposableHelper.c(this.s, disposable);
    }

    public boolean c(@Nullable Disposable disposable) {
        return DisposableHelper.f(this.s, disposable);
    }

    public boolean g() {
        return DisposableHelper.b(this.s.get());
    }

    public void m() {
        DisposableHelper.a(this.s);
    }

    public SerialDisposable(@Nullable Disposable disposable) {
        this.s = new AtomicReference<>(disposable);
    }
}
