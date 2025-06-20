package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.ListIterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class TransformedListIterator<F, T> extends TransformedIterator<F, T> implements ListIterator<T> {
    TransformedListIterator(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    private ListIterator<? extends F> b() {
        return Iterators.f(this.s);
    }

    public void add(@ParametricNullness T t) {
        throw new UnsupportedOperationException();
    }

    public final boolean hasPrevious() {
        return b().hasPrevious();
    }

    public final int nextIndex() {
        return b().nextIndex();
    }

    @ParametricNullness
    public final T previous() {
        return a(b().previous());
    }

    public final int previousIndex() {
        return b().previousIndex();
    }

    public void set(@ParametricNullness T t) {
        throw new UnsupportedOperationException();
    }
}
