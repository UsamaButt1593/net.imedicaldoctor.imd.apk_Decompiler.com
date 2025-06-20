package io.reactivex.rxjava3.internal.operators.single;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;

public final class SingleFromSupplier<T> extends Single<T> {
    final Supplier<? extends T> s;

    public SingleFromSupplier(Supplier<? extends T> supplier) {
        this.s = supplier;
    }

    /* access modifiers changed from: protected */
    public void O1(SingleObserver<? super T> singleObserver) {
        Disposable b2 = b.b();
        singleObserver.b(b2);
        if (!b2.g()) {
            try {
                Object obj = this.s.get();
                Objects.requireNonNull(obj, "The supplier returned a null value");
                if (!b2.g()) {
                    singleObserver.a(obj);
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
