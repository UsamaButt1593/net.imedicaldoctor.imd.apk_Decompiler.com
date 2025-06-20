package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Iterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class TransformedIterator<F, T> implements Iterator<T> {
    final Iterator<? extends F> s;

    TransformedIterator(Iterator<? extends F> it2) {
        this.s = (Iterator) Preconditions.E(it2);
    }

    /* access modifiers changed from: package-private */
    @ParametricNullness
    public abstract T a(@ParametricNullness F f2);

    public final boolean hasNext() {
        return this.s.hasNext();
    }

    @ParametricNullness
    public final T next() {
        return a(this.s.next());
    }

    public final void remove() {
        this.s.remove();
    }
}
