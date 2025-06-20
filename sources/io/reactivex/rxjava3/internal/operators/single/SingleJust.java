package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.b;

public final class SingleJust<T> extends Single<T> {
    final T s;

    public SingleJust(T t) {
        this.s = t;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        singleObserver.b(b.a());
        singleObserver.a(this.s);
    }
}
