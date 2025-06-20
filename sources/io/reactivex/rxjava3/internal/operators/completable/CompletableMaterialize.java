package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.operators.mixed.MaterializeSingleObserver;

public final class CompletableMaterialize<T> extends Single<Notification<T>> {
    final Completable s;

    public CompletableMaterialize(Completable completable) {
        this.s = completable;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super Notification<T>> singleObserver) {
        this.s.a(new MaterializeSingleObserver(singleObserver));
    }
}
