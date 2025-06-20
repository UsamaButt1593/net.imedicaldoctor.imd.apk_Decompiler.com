package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.concurrent.Callable;

public final class SingleFromCallable<T> extends Single<T> {
    final Callable<? extends T> s;

    public SingleFromCallable(Callable<? extends T> callable) {
        this.s = callable;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        Disposable b2 = b.b();
        singleObserver.b(b2);
        if (!b2.g()) {
            try {
                Object call = this.s.call();
                Objects.requireNonNull(call, "The callable returned a null value");
                if (!b2.g()) {
                    singleObserver.a(call);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                if (!b2.g()) {
                    singleObserver.onError(th);
                } else {
                    RxJavaPlugins.Y(th);
                }
            }
        }
    }
}
