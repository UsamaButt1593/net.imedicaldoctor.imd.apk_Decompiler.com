package io.reactivex.rxjava3.internal.observers;

import io.reactivex.rxjava3.internal.fuseable.QueueDisposable;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BasicIntQueueDisposable<T> extends AtomicInteger implements QueueDisposable<T> {
    private static final long s = -1001730202384742097L;

    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }

    public final boolean q(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
