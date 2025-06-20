package org.apache.commons.lang3.concurrent;

import androidx.lifecycle.g;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AtomicSafeInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<AtomicSafeInitializer<T>> factory = new AtomicReference<>();
    private final AtomicReference<T> reference = new AtomicReference<>();

    public final T get() throws ConcurrentException {
        while (true) {
            T t = this.reference.get();
            if (t != null) {
                return t;
            }
            if (g.a(this.factory, (Object) null, this)) {
                this.reference.set(initialize());
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract T initialize() throws ConcurrentException;
}
