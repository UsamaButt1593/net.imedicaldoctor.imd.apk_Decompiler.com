package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

public final class MaybeErrorCallable<T> extends Maybe<T> {
    final Supplier<? extends Throwable> s;

    public MaybeErrorCallable(Supplier<? extends Throwable> supplier) {
        this.s = supplier;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        maybeObserver.b(b.a());
        try {
            th = (Throwable) ExceptionHelper.d(this.s.get(), "Supplier returned a null Throwable.");
        } catch (Throwable th) {
            th = th;
            Exceptions.b(th);
        }
        maybeObserver.onError(th);
    }
}
