package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;
import java.util.Objects;

public final class CompletableDefer extends Completable {
    final Supplier<? extends CompletableSource> s;

    public CompletableDefer(Supplier<? extends CompletableSource> supplier) {
        this.s = supplier;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        try {
            Object obj = this.s.get();
            Objects.requireNonNull(obj, "The completableSupplier returned a null CompletableSource");
            ((CompletableSource) obj).a(completableObserver);
        } catch (Throwable th) {
            Exceptions.b(th);
            EmptyDisposable.e(th, completableObserver);
        }
    }
}
