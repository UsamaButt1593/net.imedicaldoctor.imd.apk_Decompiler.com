package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@DoNotMock("Use ImmutableMultimap, HashMultimap, or another implementation")
public interface Multimap<K, V> {
    boolean N0(@CompatibleWith("K") @CheckForNull Object obj, @CompatibleWith("V") @CheckForNull Object obj2);

    @CanIgnoreReturnValue
    boolean T0(@ParametricNullness K k2, Iterable<? extends V> iterable);

    @CanIgnoreReturnValue
    boolean Z(Multimap<? extends K, ? extends V> multimap);

    @CanIgnoreReturnValue
    Collection<V> b(@CompatibleWith("K") @CheckForNull Object obj);

    @CanIgnoreReturnValue
    Collection<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable);

    void clear();

    boolean containsKey(@CompatibleWith("K") @CheckForNull Object obj);

    boolean containsValue(@CompatibleWith("V") @CheckForNull Object obj);

    Multiset<K> d0();

    boolean equals(@CheckForNull Object obj);

    Map<K, Collection<V>> g();

    Collection<V> get(@ParametricNullness K k2);

    int hashCode();

    boolean isEmpty();

    Collection<Map.Entry<K, V>> j();

    Set<K> keySet();

    @CanIgnoreReturnValue
    boolean put(@ParametricNullness K k2, @ParametricNullness V v);

    @CanIgnoreReturnValue
    boolean remove(@CompatibleWith("K") @CheckForNull Object obj, @CompatibleWith("V") @CheckForNull Object obj2);

    int size();

    Collection<V> values();
}
