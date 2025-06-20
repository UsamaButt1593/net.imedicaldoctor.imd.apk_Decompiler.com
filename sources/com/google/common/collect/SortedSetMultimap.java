package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface SortedSetMultimap<K, V> extends SetMultimap<K, V> {
    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection b(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Set b(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    SortedSet<V> b(@CheckForNull Object obj);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Collection c(@ParametricNullness Object obj, Iterable iterable);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ Set c(@ParametricNullness Object obj, Iterable iterable);

    @CanIgnoreReturnValue
    SortedSet<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable);

    Map<K, Collection<V>> g();

    /* bridge */ /* synthetic */ Collection get(@ParametricNullness Object obj);

    /* bridge */ /* synthetic */ Set get(@ParametricNullness Object obj);

    SortedSet<V> get(@ParametricNullness K k2);

    @CheckForNull
    Comparator<? super V> i0();
}
