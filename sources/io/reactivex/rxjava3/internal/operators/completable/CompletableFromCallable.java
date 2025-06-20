package io.reactivex.rxjava3.internal.operators.completable;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class CompletableFromCallable extends Completable {
    final Callable<?> s;

    public CompletableFromCallable(Callable<?> callable) {
        this.s = callable;
    }

    /* access modifiers changed from: protected */
    public void Z0(CompletableObserver completableObserver) {
        Disposable b2 = b.b();
        completableObserver.b(b2);
        try {
            this.s.call();
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
