package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

public final class CompletableErrorSupplier extends Completable {
    final Supplier<? extends Throwable> s;

    public CompletableErrorSupplier(Supplier<? extends Throwable> supplier) {
        this.s = supplier;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        try {
            Object obj = this.s.get();
            Objects.requireNonNull(obj, "The error returned is null");
            th = (Throwable) obj;
        } catch (Throwable th) {
            th = th;
            Exceptions.b(th);
        }
        EmptyDisposable.e(th, completableObserver);
    }
}
