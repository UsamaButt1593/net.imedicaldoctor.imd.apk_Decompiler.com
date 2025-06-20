package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingIterator<T> extends ForwardingObject implements Iterator<T> {
    protected ForwardingIterator() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: a1 */
    public abstract Iterator<T> Z0();

    public boolean hasNext() {
        return Z0().hasNext();
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public T next() {
        return Z0().next();
    }

    public void remove() {
        Z0().remove();
    }
}
