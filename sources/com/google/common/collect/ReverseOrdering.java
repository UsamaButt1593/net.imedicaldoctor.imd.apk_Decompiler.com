package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long Z = 0;
    final Ordering<? super T> Y;

    ReverseOrdering(Ordering<? super T> ordering) {
        this.Y = (Ordering) Preconditions.E(ordering);
    }

    public <S extends T> Ordering<S> E() {
        return this.Y;
    }

    public int compare(@ParametricNullness T t, @ParametricNullness T t2) {
        return this.Y.compare(t2, t);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.Y.equals(((ReverseOrdering) obj).Y);
        }
        return false;
    }

    public int hashCode() {
        return -this.Y.hashCode();
    }

    public <E extends T> E r(Iterable<E> iterable) {
        return this.Y.v(iterable);
    }

    public <E extends T> E s(@ParametricNullness E e2, @ParametricNullness E e3) {
        return this.Y.w(e2, e3);
    }

    public <E extends T> E t(@ParametricNullness E e2, @ParametricNullness E e3, @ParametricNullness E e4, E... eArr) {
        return this.Y.x(e2, e3, e4, eArr);
    }

    public String toString() {
        return this.Y + ".reverse()";
    }

    public <E extends T> E u(Iterator<E> it2) {
        return this.Y.y(it2);
    }

    public <E extends T> E v(Iterable<E> iterable) {
        return this.Y.r(iterable);
    }

    public <E extends T> E w(@ParametricNullness E e2, @ParametricNullness E e3) {
        return this.Y.s(e2, e3);
    }

    public <E extends T> E x(@ParametricNullness E e2, @ParametricNullness E e3, @ParametricNullness E e4, E... eArr) {
        return this.Y.t(e2, e3, e4, eArr);
    }

    public <E extends T> E y(Iterator<E> it2) {
        return this.Y.u(it2);
    }
}
