package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface ListMultimap<K, V> extends Multimap<K, V> {
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection b(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    List<V> b(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection c(@ParametricNullness Object obj, Iterable iterable);

    @CanIgnoreReturnValue
    List<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable);

    boolean equals(@CheckForNull Object obj);

    Map<K, Collection<V>> g();

    /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object obj);

    List<V> get(@ParametricNullness K k2);
}
