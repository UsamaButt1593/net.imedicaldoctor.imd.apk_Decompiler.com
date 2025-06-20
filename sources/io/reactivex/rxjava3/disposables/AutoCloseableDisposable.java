package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.internal.util.ExceptionHelper;

final class AutoCloseableDisposable extends ReferenceDisposable<AutoCloseable> {
    private static final long X = -6646144244598696847L;

    AutoCloseableDisposable(AutoCloseable autoCloseable) {
        super(autoCloseable);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void a(@NonNull AutoCloseable autoCloseable) {
        try {
            autoCloseable.close();
        } catch (Throwable th) {
            throw ExceptionHelper.i(th);
        }
    }

    public String toString() {
        return "AutoCloseableDisposable(disposed=" + g() + ", " + get() + ")";
    }
}
