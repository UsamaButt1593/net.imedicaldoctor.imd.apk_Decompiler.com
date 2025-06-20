package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Iterator;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class ReverseNaturalOrdering extends Ordering<Comparable<?>> implements Serializable {
    static final ReverseNaturalOrdering Y = new ReverseNaturalOrdering();
    private static final long Z = 0;

    private ReverseNaturalOrdering() {
    }

    private Object R() {
        return Y;
    }

    public <S extends Comparable<?>> Ordering<S> E() {
        return Ordering.z();
    }

    /* renamed from: I */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        Preconditions.E(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    /* renamed from: J */
    public <E extends Comparable<?>> E s(E e2, E e3) {
        return (Comparable) NaturalOrdering.X2.w(e2, e3);
    }

    /* renamed from: K */
    public <E extends Comparable<?>> E t(E e2, E e3, E e4, E... eArr) {
        return (Comparable) NaturalOrdering.X2.x(e2, e3, e4, eArr);
    }

    /* renamed from: L */
    public <E extends Comparable<?>> E r(Iterable<E> iterable) {
        return (Comparable) NaturalOrdering.X2.v(iterable);
    }

    /* renamed from: M */
    public <E extends Comparable<?>> E u(Iterator<E> it2) {
        return (Comparable) NaturalOrdering.X2.y(it2);
    }

    /* renamed from: N */
    public <E extends Comparable<?>> E w(E e2, E e3) {
        return (Comparable) NaturalOrdering.X2.s(e2, e3);
    }

    /* renamed from: O */
    public <E extends Comparable<?>> E x(E e2, E e3, E e4, E... eArr) {
        return (Comparable) NaturalOrdering.X2.t(e2, e3, e4, eArr);
    }

    /* renamed from: P */
    public <E extends Comparable<?>> E v(Iterable<E> iterable) {
        return (Comparable) NaturalOrdering.X2.r(iterable);
    }

    /* renamed from: Q */
    public <E extends Comparable<?>> E y(Iterator<E> it2) {
        return (Comparable) NaturalOrdering.X2.u(it2);
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }
}
