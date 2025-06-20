package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import javax.annotation.CheckForNull;

@GwtCompatible(serializable = true)
@ElementTypesAreNonnullByDefault
final class NullsFirstOrdering<T> extends Ordering<T> implements Serializable {
    private static final long Z = 0;
    final Ordering<? super T> Y;

    NullsFirstOrdering(Ordering<? super T> ordering) {
        this.Y = ordering;
    }

    public <S extends T> Ordering<S> A() {
        return this;
    }

    public <S extends T> Ordering<S> B() {
        return this.Y.B();
    }

    public <S extends T> Ordering<S> E() {
        return this.Y.E().B();
    }

    public int compare(@CheckForNull T t, @CheckForNull T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return this.Y.compare(t, t2);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof NullsFirstOrdering) {
            return this.Y.equals(((NullsFirstOrdering) obj).Y);
        }
        return false;
    }

    public int hashCode() {
        return this.Y.hashCode() ^ 957692532;
    }

    public String toString() {
        return this.Y + ".nullsFirst()";
    }
}
