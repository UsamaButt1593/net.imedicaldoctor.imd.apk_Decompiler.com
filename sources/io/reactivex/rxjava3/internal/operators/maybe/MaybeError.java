package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.b;

public final class MaybeError<T> extends Maybe<T> {
    final Throwable s;

    public MaybeError(Throwable th) {
        this.s = th;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.b(b.a());
        maybeObserver.onError(this.s);
    }
}
