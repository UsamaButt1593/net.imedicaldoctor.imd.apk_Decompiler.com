package io.reactivex.rxjava3.internal.disposables;

import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.exceptions.Exceptions;
import io.reactivex.rxjava3.functions.Cancellable;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.concurrent.atomic.AtomicReference;

public final class CancellableDisposable extends AtomicReference<Cancellable> implements Disposable {
    private static final long s = 5718521705281392066L;

    public CancellableDisposable(Cancellable cancellable) {
        super(cancellable);
    }

    public boolean g() {
        return get() == null;
    }

    public void m() {
        Cancellable cancellable;
        if (get() != null && (cancellable = (Cancellable) getAndSet((Object) null)) != null) {
            try {
                cancellable.cancel();
            } catch (Throwable th) {
                Exceptions.b(th);
                RxJavaPlugins.Y(th);
            }
        }
    }
}
