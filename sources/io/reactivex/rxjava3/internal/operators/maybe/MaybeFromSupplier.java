package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class MaybeFromSupplier<T> extends Maybe<T> implements Supplier<T> {
    final Supplier<? extends T> s;

    public MaybeFromSupplier(Supplier<? extends T> supplier) {
        this.s = supplier;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        Disposable b2 = b.b();
        maybeObserver.b(b2);
        if (!b2.g()) {
            try {
                Object obj = this.s.get();
                if (b2.g()) {
                    return;
                }
                if (obj == null) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.a(obj);
                }
            } catch (Throwable th) {
                Exceptions.b(th);
                if (!b2.g()) {
                    maybeObserver.onError(th);
                } else {
                    RxJavaPlugins.Y(th);
                }
            }
        }
    }

    public T get() throws Throwable {
        return this.s.get();
    }
}
