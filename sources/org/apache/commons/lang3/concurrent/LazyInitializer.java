package org.apache.commons.lang3.concurrent;

public abstract class LazyInitializer<T> implements ConcurrentInitializer<T> {
    private volatile T object;

    public T get() throws ConcurrentException {
        T t = this.object;
        if (t == null) {
            synchronized (this) {
                try {
                    t = this.object;
                    if (t == null) {
                        t = initialize();
                        this.object = t;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return t;
    }

    /* access modifiers changed from: protected */
    public abstract T initialize() throws ConcurrentException;
}
