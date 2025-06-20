package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import java.lang.Comparable;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractRangeSet<C extends Comparable> implements RangeSet<C> {
    AbstractRangeSet() {
    }

    public void a(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public boolean b(C c2) {
        return j(c2) != null;
    }

    public void clear() {
        a(Range.a());
    }

    public void d(Iterable<Range<C>> iterable) {
        for (Range<C> h2 : iterable) {
            h(h2);
        }
    }

    public void e(RangeSet<C> rangeSet) {
        d(rangeSet.o());
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RangeSet) {
            return o().equals(((RangeSet) obj).o());
        }
        return false;
    }

    public void f(Iterable<Range<C>> iterable) {
        for (Range<C> a2 : iterable) {
            a(a2);
        }
    }

    public boolean g(RangeSet<C> rangeSet) {
        return l(rangeSet.o());
    }

    public void h(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public final int hashCode() {
        return o().hashCode();
    }

    public boolean isEmpty() {
        return o().isEmpty();
    }

    @CheckForNull
    public abstract Range<C> j(C c2);

    public abstract boolean k(Range<C> range);

    public boolean l(Iterable<Range<C>> iterable) {
        for (Range<C> k2 : iterable) {
            if (!k(k2)) {
                return false;
            }
        }
        return true;
    }

    public void p(RangeSet<C> rangeSet) {
        f(rangeSet.o());
    }

    public boolean q(Range<C> range) {
        return !m(range).isEmpty();
    }

    public final String toString() {
        return o().toString();
    }
}
