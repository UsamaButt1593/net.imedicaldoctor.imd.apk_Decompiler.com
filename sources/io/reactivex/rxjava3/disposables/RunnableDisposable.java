package io.reactivex.rxjava3.disposables;

import io.reactivex.rxjava3.annotations.NonNull;

final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    private static final long X = -8219729196779211169L;

    RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void a(@NonNull Runnable runnable) {
        runnable.run();
    }

    public String toString() {
        return "RunnableDisposable(disposed=" + g() + ", " + get() + ")";
    }
}
