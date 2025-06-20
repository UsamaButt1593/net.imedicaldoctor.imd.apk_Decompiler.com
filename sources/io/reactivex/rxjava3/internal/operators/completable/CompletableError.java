package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;

public final class CompletableError extends Completable {
    final Throwable s;

    public CompletableError(Throwable th) {
        this.s = th;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        EmptyDisposable.e(this.s, completableObserver);
    }
}
