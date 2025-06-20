package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class LexicographicalOrdering<T> extends Ordering<Iterable<T>> implements Serializable {
    private static final long Z = 0;
    final Comparator<? super T> Y;

    LexicographicalOrdering(Comparator<? super T> comparator) {
        this.Y = comparator;
    }

    /* renamed from: I */
    public int compare(Iterable<T> iterable, Iterable<T> iterable2) {
        Iterator<T> it2 = iterable2.iterator();
        for (T compare : iterable) {
            if (!it2.hasNext()) {
                return 1;
            }
            int compare2 = this.Y.compare(compare, it2.next());
            if (compare2 != 0) {
                return compare2;
            }
        }
        return it2.hasNext() ? -1 : 0;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LexicographicalOrdering) {
            return this.Y.equals(((LexicographicalOrdering) obj).Y);
        }
        return false;
    }

    public int hashCode() {
        return this.Y.hashCode() ^ 2075626741;
    }

    public String toString() {
        return this.Y + ".lexicographical()";
    }
}
