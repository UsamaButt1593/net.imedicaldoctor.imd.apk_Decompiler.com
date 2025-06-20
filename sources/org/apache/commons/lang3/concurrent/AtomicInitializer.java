package org.apache.commons.lang3.concurrent;

import androidx.lifecycle.g;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AtomicInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<T> reference = new AtomicReference<>();

    public T get() throws ConcurrentException {
        T t = this.reference.get();
        if (t != null) {
            return t;
        }
        T initialize = initialize();
        return !g.a(this.reference, (Object) null, initialize) ? this.reference.get() : initialize;
    }

    /* access modifiers changed from: protected */
    public abstract T initialize() throws ConcurrentException;
}
