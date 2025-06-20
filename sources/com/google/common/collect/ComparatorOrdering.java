package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class ComparatorOrdering<T> extends Ordering<T> implements Serializable {
    private static final long Z = 0;
    final Comparator<T> Y;

    ComparatorOrdering(Comparator<T> comparator) {
        this.Y = (Comparator) Preconditions.E(comparator);
    }

    public int compare(@ParametricNullness T t, @ParametricNullness T t2) {
        return this.Y.compare(t, t2);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ComparatorOrdering) {
            return this.Y.equals(((ComparatorOrdering) obj).Y);
        }
        return false;
    }

    public int hashCode() {
        return this.Y.hashCode();
    }

    public String toString() {
        return this.Y.toString();
    }
}
