package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.Callable;

public final class MaybeFromCallable<T> extends Maybe<T> implements Supplier<T> {
    final Callable<? extends T> s;

    public MaybeFromCallable(Callable<? extends T> callable) {
        this.s = callable;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        Disposable b2 = b.b();
        maybeObserver.b(b2);
        if (!b2.g()) {
            try {
                Object call = this.s.call();
                if (b2.g()) {
                    return;
                }
                if (call == null) {
                    maybeObserver.onComplete();
                } else {
                    maybeObserver.a(call);
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

    public T get() throws Exception {
        return this.s.call();
    }
}
