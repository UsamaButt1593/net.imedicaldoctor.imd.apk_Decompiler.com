package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class NullsLastOrdering<T> extends Ordering<T> implements Serializable {
    private static final long Z = 0;
    final Ordering<? super T> Y;

    NullsLastOrdering(Ordering<? super T> ordering) {
        this.Y = ordering;
    }

    public <S extends T> Ordering<S> A() {
        return this.Y.A();
    }

    public <S extends T> Ordering<S> B() {
        return this;
    }

    public <S extends T> Ordering<S> E() {
        return this.Y.E().A();
    }

    public int compare(@CheckForNull T t, @CheckForNull T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return 1;
        }
        if (t2 == null) {
            return -1;
        }
        return this.Y.compare(t, t2);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NullsLastOrdering) {
            return this.Y.equals(((NullsLastOrdering) obj).Y);
        }
        return false;
    }

    public int hashCode() {
        return this.Y.hashCode() ^ -921210296;
    }

    public String toString() {
        return this.Y + ".nullsLast()";
    }
}
