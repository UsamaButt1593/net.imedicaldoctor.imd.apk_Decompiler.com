package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {
    private int X;
    private final int s;

    protected AbstractIndexedListIterator(int i2) {
        this(i2, 0);
    }

    /* access modifiers changed from: protected */
    @ParametricNullness
    public abstract E a(int i2);

    public final boolean hasNext() {
        return this.X < this.s;
    }

    public final boolean hasPrevious() {
        return this.X > 0;
    }

    @ParametricNullness
    public final E next() {
        if (hasNext()) {
            int i2 = this.X;
            this.X = i2 + 1;
            return a(i2);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.X;
    }

    @ParametricNullness
    public final E previous() {
        if (hasPrevious()) {
            int i2 = this.X - 1;
            this.X = i2;
            return a(i2);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.X - 1;
    }

    protected AbstractIndexedListIterator(int i2, int i3) {
        Preconditions.d0(i3, i2);
        this.s = i2;
        this.X = i3;
    }
}
