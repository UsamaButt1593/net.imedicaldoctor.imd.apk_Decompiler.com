package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.List;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class AllEqualOrdering extends Ordering<Object> implements Serializable {
    static final AllEqualOrdering Y = new AllEqualOrdering();
    private static final long Z = 0;

    AllEqualOrdering() {
    }

    private Object I() {
        return Y;
    }

    public <S> Ordering<S> E() {
        return this;
    }

    public <E> List<E> F(Iterable<E> iterable) {
        return Lists.r(iterable);
    }

    public int compare(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return 0;
    }

    public <E> ImmutableList<E> l(Iterable<E> iterable) {
        return ImmutableList.z(iterable);
    }

    public String toString() {
        return "Ordering.allEqual()";
    }
}
