package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.DoNotMock;
import java.lang.Comparable;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@DoNotMock("Use ImmutableRangeMap or TreeRangeMap")
public interface RangeMap<K extends Comparable, V> {
    void a(Range<K> range);

    Range<K> c();

    void clear();

    @CheckForNull
    Map.Entry<Range<K>, V> d(K k2);

    RangeMap<K, V> e(Range<K> range);

    boolean equals(@CheckForNull Object obj);

    Map<Range<K>, V> f();

    Map<Range<K>, V> g();

    @CheckForNull
    V h(K k2);

    int hashCode();

    void i(RangeMap<K, ? extends V> rangeMap);

    void j(Range<K> range, V v);

    void k(Range<K> range, V v);

    String toString();
}
