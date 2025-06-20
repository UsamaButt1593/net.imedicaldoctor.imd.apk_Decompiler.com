package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.operators.mixed.MaterializeSingleObserver;

public final class SingleMaterialize<T> extends Single<Notification<T>> {
    final Single<T> s;

    public SingleMaterialize(Single<T> single) {
        this.s = single;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super Notification<T>> singleObserver) {
        this.s.e(new MaterializeSingleObserver(singleObserver));
    }
}
