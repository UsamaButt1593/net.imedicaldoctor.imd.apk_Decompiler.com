package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.fuseable.ScalarSupplier;

public final class MaybeEmpty extends Maybe<Object> implements ScalarSupplier<Object> {
    public static final MaybeEmpty s = new MaybeEmpty();

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super Object> maybeObserver) {
        EmptyDisposable.b(maybeObserver);
    }

    public Object get() {
        return null;
    }
}
