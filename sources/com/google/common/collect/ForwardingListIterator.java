package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ListIterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingListIterator<E> extends ForwardingIterator<E> implements ListIterator<E> {
    protected ForwardingListIterator() {
    }

    public void add(@ParametricNullness E e2) {
        a1().add(e2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f1 */
    public abstract ListIterator<E> a1();

    public boolean hasPrevious() {
        return a1().hasPrevious();
    }

    public int nextIndex() {
        return a1().nextIndex();
    }

    @ParametricNullness
    @CanIgnoreReturnValue
    public E previous() {
        return a1().previous();
    }

    public int previousIndex() {
        return a1().previousIndex();
    }

    public void set(@ParametricNullness E e2) {
        a1().set(e2);
    }
}
