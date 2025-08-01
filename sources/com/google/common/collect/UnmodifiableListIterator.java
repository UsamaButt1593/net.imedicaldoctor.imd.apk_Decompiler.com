package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.DoNotCall;
import java.util.ListIterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class UnmodifiableListIterator<E> extends UnmodifiableIterator<E> implements ListIterator<E> {
    protected UnmodifiableListIterator() {
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void add(@ParametricNullness E e2) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void set(@ParametricNullness E e2) {
        throw new UnsupportedOperationException();
    }
}
