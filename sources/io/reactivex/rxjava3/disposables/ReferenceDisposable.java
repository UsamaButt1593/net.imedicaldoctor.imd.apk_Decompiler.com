package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.NonNull;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

abstract class ReferenceDisposable<T> extends AtomicReference<T> implements Disposable {
    private static final long s = 6537757548749041217L;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ReferenceDisposable(T t) {
        super(t);
        Objects.requireNonNull(t, "value is null");
    }

    /* access modifiers changed from: protected */
    public abstract void a(@NonNull T t);

    public final boolean g() {
        return get() == null;
    }

    public final void m() {
        Object andSet;
        if (get() != null && (andSet = getAndSet((Object) null)) != null) {
            a(andSet);
        }
    }
}
