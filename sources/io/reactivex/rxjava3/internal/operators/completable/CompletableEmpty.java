package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;

public final class CompletableEmpty extends Completable {
    public static final Completable s = new CompletableEmpty();

    private CompletableEmpty() {
    }

    public void Z0(CompletableObserver completableObserver) {
        EmptyDisposable.a(completableObserver);
    }
}
