package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;

public final class CompletableNever extends Completable {
    public static final Completable s = new CompletableNever();

    private CompletableNever() {
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        completableObserver.b(EmptyDisposable.NEVER);
    }
}
