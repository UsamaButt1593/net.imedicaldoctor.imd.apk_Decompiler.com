package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long Z = 0;
    final ImmutableMap<T, Integer> Y;

    ExplicitOrdering(ImmutableMap<T, Integer> immutableMap) {
        this.Y = immutableMap;
    }

    private int I(T t) {
        Integer num = this.Y.get(t);
        if (num != null) {
            return num.intValue();
        }
        throw new Ordering.IncomparableValueException(t);
    }

    public int compare(T t, T t2) {
        return I(t) - I(t2);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof ExplicitOrdering) {
            return this.Y.equals(((ExplicitOrdering) obj).Y);
        }
        return false;
    }

    public int hashCode() {
        return this.Y.hashCode();
    }

    public String toString() {
        return "Ordering.explicit(" + this.Y.keySet() + ")";
    }

    ExplicitOrdering(List<T> list) {
        this(Maps.Q(list));
    }
}
