package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.MapDifference;
import java.util.Map;
import java.util.SortedMap;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface SortedMapDifference<K, V> extends MapDifference<K, V> {
    /* bridge */ /* synthetic */ Map a();

    SortedMap<K, V> a();

    /* bridge */ /* synthetic */ Map b();

    SortedMap<K, MapDifference.ValueDifference<V>> b();

    /* bridge */ /* synthetic */ Map c();

    SortedMap<K, V> c();

    /* bridge */ /* synthetic */ Map d();

    SortedMap<K, V> d();
}
