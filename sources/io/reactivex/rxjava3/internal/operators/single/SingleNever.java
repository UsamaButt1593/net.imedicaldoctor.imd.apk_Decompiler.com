package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.disposables.EmptyDisposable;

public final class SingleNever extends Single<Object> {
    public static final Single<Object> s = new SingleNever();

    private SingleNever() {
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super Object> singleObserver) {
        singleObserver.b(EmptyDisposable.NEVER);
    }
}
