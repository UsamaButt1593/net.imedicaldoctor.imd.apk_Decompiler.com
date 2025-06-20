package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class CompletableFromSupplier extends Completable {
    final Supplier<?> s;

    public CompletableFromSupplier(Supplier<?> supplier) {
        this.s = supplier;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        Disposable b2 = b.b();
        completableObserver.b(b2);
        try {
            this.s.get();
            if (!b2.g()) {
                completableObserver.onComplete();
            }
        } catch (Throwable th) {
            Exceptions.b(th);
            if (!b2.g()) {
                completableObserver.onError(th);
            } else {
                RxJavaPlugins.Y(th);
            }
        }
    }
}
