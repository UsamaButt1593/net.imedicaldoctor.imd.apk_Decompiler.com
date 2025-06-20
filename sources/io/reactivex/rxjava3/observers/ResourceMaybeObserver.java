package io.reactivex.rxjava3.observers;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;
import io.reactivex.rxjava3.internal.disposables.ListCompositeDisposable;
import io.reactivex.rxjava3.internal.util.EndConsumerHelper;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public abstract class ResourceMaybeObserver<T> implements MaybeObserver<T>, Disposable {
    private final ListCompositeDisposable X = new ListCompositeDisposable();
    private final AtomicReference<Disposable> s = new AtomicReference<>();

    public final void b(@NonNull Disposable disposable) {
        if (EndConsumerHelper.c(this.s, disposable, getClass())) {
            d();
        }
    }

    public final void c(@NonNull Disposable disposable) {
        Objects.requireNonNull(disposable, "resource is null");
        this.X.b(disposable);
    }

    /* access modifiers changed from: protected */
    public void d() {
    }

    public final boolean g() {
        return DisposableHelper.b(this.s.get());
    }

    public final void m() {
        if (DisposableHelper.a(this.s)) {
            this.X.m();
        }
    }
}
