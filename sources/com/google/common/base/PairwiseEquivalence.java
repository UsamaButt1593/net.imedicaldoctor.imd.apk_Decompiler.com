package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class PairwiseEquivalence<E, T extends E> extends Equivalence<Iterable<T>> implements Serializable {
    private static final long X = 1;
    final Equivalence<E> s;

    PairwiseEquivalence(Equivalence<E> equivalence) {
        this.s = (Equivalence) Preconditions.E(equivalence);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof PairwiseEquivalence) {
            return this.s.equals(((PairwiseEquivalence) obj).s);
        }
        return false;
    }

    public int hashCode() {
        return this.s.hashCode() ^ 1185147655;
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public boolean a(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator<T> it2 = iterable.iterator();
        Iterator<T> it3 = iterable2.iterator();
        while (it2.hasNext() && it3.hasNext()) {
            if (!this.s.d(it2.next(), it3.next())) {
                return false;
            }
        }
        return !it2.hasNext() && !it3.hasNext();
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public int b(Iterable<T> iterable) {
        int i2 = 78721;
        for (T f2 : iterable) {
            i2 = (i2 * 24943) + this.s.f(f2);
        }
        return i2;
    }

    public String toString() {
        return this.s + ".pairwise()";
    }
}
