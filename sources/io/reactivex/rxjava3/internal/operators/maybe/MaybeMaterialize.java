package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.internal.operators.mixed.MaterializeSingleObserver;

public final class MaybeMaterialize<T> extends Single<Notification<T>> {
    final Maybe<T> s;

    public MaybeMaterialize(Maybe<T> maybe) {
        this.s = maybe;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super Notification<T>> singleObserver) {
        this.s.d(new MaterializeSingleObserver(singleObserver));
    }
}
