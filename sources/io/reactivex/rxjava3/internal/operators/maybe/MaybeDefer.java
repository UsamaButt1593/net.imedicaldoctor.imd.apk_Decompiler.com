package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.MaybeSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

public final class MaybeDefer<T> extends Maybe<T> {
    final Supplier<? extends MaybeSource<? extends T>> s;

    public MaybeDefer(Supplier<? extends MaybeSource<? extends T>> supplier) {
        this.s = supplier;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        try {
            Object obj = this.s.get();
            Objects.requireNonNull(obj, "The maybeSupplier returned a null MaybeSource");
            ((MaybeSource) obj).d(maybeObserver);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.f(th, maybeObserver);
        }
    }
}
