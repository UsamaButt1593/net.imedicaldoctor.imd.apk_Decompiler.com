package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

public final class SingleError<T> extends Single<T> {
    final Supplier<? extends Throwable> s;

    public SingleError(Supplier<? extends Throwable> supplier) {
        this.s = supplier;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        try {
            th = (Throwable) ExceptionHelper.d(this.s.get(), "Supplier returned a null Throwable.");
        } catch (Throwable th) {
            th = th;
            Exceptions.b(th);
        }
        EmptyDisposable.i(th, singleObserver);
    }
}
