package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class CompoundOrdering<T> extends Ordering<T> implements Serializable {
    private static final long Z = 0;
    final Comparator<? super T>[] Y;

    CompoundOrdering(Iterable<? extends Comparator<? super T>> iterable) {
        this.Y = (Comparator[]) Iterables.R(iterable, new Comparator[0]);
    }

    public int compare(@ParametricNullness T t, @ParametricNullness T t2) {
        int i2 = 0;
        while (true) {
            Comparator<? super T>[] comparatorArr = this.Y;
            if (i2 >= comparatorArr.length) {
                return 0;
            }
            int compare = comparatorArr[i2].compare(t, t2);
            if (compare != 0) {
                return compare;
            }
            i2++;
        }
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CompoundOrdering) {
            return Arrays.equals(this.Y, ((CompoundOrdering) obj).Y);
        }
        return false;
    }

    public int hashCode() {
        return Arrays.hashCode(this.Y);
    }

    public String toString() {
        return "Ordering.compound(" + Arrays.toString(this.Y) + ")";
    }

    CompoundOrdering(Comparator<? super T> comparator, Comparator<? super T> comparator2) {
        this.Y = new Comparator[]{comparator, comparator2};
    }
}
