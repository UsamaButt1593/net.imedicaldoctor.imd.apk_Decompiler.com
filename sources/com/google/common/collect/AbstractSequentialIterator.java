package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class AbstractSequentialIterator<T> extends UnmodifiableIterator<T> {
    @CheckForNull
    private T s;

    protected AbstractSequentialIterator(@CheckForNull T t) {
        this.s = t;
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public abstract T a(T t);

    public final boolean hasNext() {
        return this.s != null;
    }

    public final T next() {
        T t = this.s;
        if (t != null) {
            this.s = a(t);
            return t;
        }
        throw new NoSuchElementException();
    }
}
