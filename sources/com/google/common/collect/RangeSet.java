package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.DoNotMock;
import java.lang.Comparable;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@DoNotMock("Use ImmutableRangeSet or TreeRangeSet")
public interface RangeSet<C extends Comparable> {
    void a(Range<C> range);

    boolean b(C c2);

    Range<C> c();

    void clear();

    void d(Iterable<Range<C>> iterable);

    void e(RangeSet<C> rangeSet);

    boolean equals(@CheckForNull Object obj);

    void f(Iterable<Range<C>> iterable);

    boolean g(RangeSet<C> rangeSet);

    void h(Range<C> range);

    int hashCode();

    RangeSet<C> i();

    boolean isEmpty();

    @CheckForNull
    Range<C> j(C c2);

    boolean k(Range<C> range);

    boolean l(Iterable<Range<C>> iterable);

    RangeSet<C> m(Range<C> range);

    Set<Range<C>> n();

    Set<Range<C>> o();

    void p(RangeSet<C> rangeSet);

    boolean q(Range<C> range);

    String toString();
}
