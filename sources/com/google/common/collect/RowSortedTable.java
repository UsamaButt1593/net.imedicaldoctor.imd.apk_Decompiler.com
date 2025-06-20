package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface RowSortedTable<R, C, V> extends Table<R, C, V> {
    /* bridge */ /* synthetic */ Map m();

    SortedMap<R, Map<C, V>> m();

    /* bridge */ /* synthetic */ Set n();

    SortedSet<R> n();
}
