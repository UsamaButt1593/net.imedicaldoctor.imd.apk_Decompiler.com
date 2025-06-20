package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class ByFunctionOrdering<F, T> extends Ordering<F> implements Serializable {
    private static final long X2 = 0;
    final Function<F, ? extends T> Y;
    final Ordering<T> Z;

    ByFunctionOrdering(Function<F, ? extends T> function, Ordering<T> ordering) {
        this.Y = (Function) Preconditions.E(function);
        this.Z = (Ordering) Preconditions.E(ordering);
    }

    public int compare(@ParametricNullness F f2, @ParametricNullness F f3) {
        return this.Z.compare(this.Y.apply(f2), this.Y.apply(f3));
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByFunctionOrdering)) {
            return false;
        }
        ByFunctionOrdering byFunctionOrdering = (ByFunctionOrdering) obj;
        return this.Y.equals(byFunctionOrdering.Y) && this.Z.equals(byFunctionOrdering.Z);
    }

    public int hashCode() {
        return Objects.b(this.Y, this.Z);
    }

    public String toString() {
        return this.Z + ".onResultOf(" + this.Y + ")";
    }
}
