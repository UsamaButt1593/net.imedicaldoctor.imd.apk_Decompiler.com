package io.reactivex.rxjava3.internal.operators.maybe;

import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.MaybeObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Supplier;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public final class MaybeFromRunnable<T> extends Maybe<T> implements Supplier<T> {
    final Runnable s;

    public MaybeFromRunnable(Runnable runnable) {
        this.s = runnable;
    }

    /* access modifiers changed from: protected */
    public void W1(MaybeObserver<? super T> maybeObserver) {
        Disposable b2 = b.b();
        maybeObserver.b(b2);
        if (!b2.g()) {
            try {
                this.s.run();
                if (!b2.g()) {
                    maybeObserver.onComplete();
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

    public T get() {
        this.s.run();
        return null;
    }
}
