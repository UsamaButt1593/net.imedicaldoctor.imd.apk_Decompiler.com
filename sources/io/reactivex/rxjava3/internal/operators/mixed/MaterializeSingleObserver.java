package io.reactivex.rxjava3.internal.operators.mixed;

import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.core.Notification;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.internal.disposables.DisposableHelper;

public final class MaterializeSingleObserver<T> implements SingleObserver<T>, MaybeObserver<T>, CompletableObserver, Disposable {
    Disposable X;
    final SingleObserver<? super Notification<T>> s;

    public MaterializeSingleObserver(SingleObserver<? super Notification<T>> singleObserver) {
        this.s = singleObserver;
    }

    public void a(T t) {
        this.s.a(Notification.c(t));
    }

    public void b(Disposable disposable) {
        if (DisposableHelper.j(this.X, disposable)) {
            this.X = disposable;
            this.s.b(this);
        }
    }

    public boolean g() {
        return this.X.g();
    }

    public void m() {
        this.X.m();
    }

    public void onComplete() {
        this.s.a(Notification.a());
    }

    public void onError(Throwable th) {
        this.s.a(Notification.b(th));
    }
}
