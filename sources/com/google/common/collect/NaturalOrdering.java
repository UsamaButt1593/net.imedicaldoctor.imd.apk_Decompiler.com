package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class NaturalOrdering extends Ordering<Comparable<?>> implements Serializable {
    static final NaturalOrdering X2 = new NaturalOrdering();
    private static final long Y2 = 0;
    @CheckForNull
    @LazyInit
    private transient Ordering<Comparable<?>> Y;
    @CheckForNull
    @LazyInit
    private transient Ordering<Comparable<?>> Z;

    private NaturalOrdering() {
    }

    private Object J() {
        return X2;
    }

    public <S extends Comparable<?>> Ordering<S> A() {
        Ordering<Comparable<?>> ordering = this.Y;
        if (ordering != null) {
            return ordering;
        }
        Ordering<Comparable<?>> A = super.A();
        this.Y = A;
        return A;
    }

    public <S extends Comparable<?>> Ordering<S> B() {
        Ordering<Comparable<?>> ordering = this.Z;
        if (ordering != null) {
            return ordering;
        }
        Ordering<Comparable<?>> B = super.B();
        this.Z = B;
        return B;
    }

    public <S extends Comparable<?>> Ordering<S> E() {
        return ReverseNaturalOrdering.Y;
    }

    /* renamed from: I */
    public int compare(Comparable<?> comparable, Comparable<?> comparable2) {
        Preconditions.E(comparable);
        Preconditions.E(comparable2);
        return comparable.compareTo(comparable2);
    }

    public String toString() {
        return "Ordering.natural()";
    }
}
