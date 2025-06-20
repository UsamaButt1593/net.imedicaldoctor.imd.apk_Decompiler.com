package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;

public final class MaybeJust<T> extends Maybe<T> implements ScalarSupplier<T> {
    final T s;

    public MaybeJust(T t) {
        this.s = t;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.b(b.a());
        maybeObserver.a(this.s);
    }

    public T get() {
        return this.s;
    }
}
