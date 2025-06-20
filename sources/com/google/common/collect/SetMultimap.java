package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface SetMultimap<K, V> extends Multimap<K, V> {
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection b(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    Set<V> b(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection c(@ParametricNullness Object obj, Iterable iterable);

    @CanIgnoreReturnValue
    Set<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable);

    boolean equals(@CheckForNull Object obj);

    Map<K, Collection<V>> g();

    /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object obj);

    Set<V> get(@ParametricNullness K k2);

    /* bridge */ /* synthetic */ Collection j();

    Set<Map.Entry<K, V>> j();
}
