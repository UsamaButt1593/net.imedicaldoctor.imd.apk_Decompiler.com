package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;

public final class MaybeNever extends Maybe<Object> {
    public static final MaybeNever s = new MaybeNever();

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super Object> maybeObserver) {
        maybeObserver.b(EmptyDisposable.NEVER);
    }
}
