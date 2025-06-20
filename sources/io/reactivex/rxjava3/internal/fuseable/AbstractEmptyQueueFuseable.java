package io.reactivex.rxjava3.internal.fuseable;

import io.reactivex.rxjava3.annotations.NonNull;

public abstract class AbstractEmptyQueueFuseable<T> implements QueueSubscription<T>, QueueDisposable<T> {
    public void cancel() {
    }

    public final void clear() {
    }

    public boolean g() {
        return false;
    }

    public final boolean isEmpty() {
        return true;
    }

    public void m() {
    }

    public final boolean offer(@NonNull T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final T poll() throws Throwable {
        return null;
    }

    public final boolean q(@NonNull T t, @NonNull T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    public final int r(int i2) {
        return i2 & 2;
    }

    public final void request(long j2) {
    }
}
