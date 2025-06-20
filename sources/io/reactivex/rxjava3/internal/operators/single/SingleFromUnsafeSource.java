package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.core.SingleSource;

public final class SingleFromUnsafeSource<T> extends Single<T> {
    final SingleSource<T> s;

    public SingleFromUnsafeSource(SingleSource<T> singleSource) {
        this.s = singleSource;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        this.s.e(singleObserver);
    }
}
