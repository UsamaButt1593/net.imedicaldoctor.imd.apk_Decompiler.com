package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractSortedKeySortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
    AbstractSortedKeySortedSetMultimap(SortedMap<K, Collection<V>> sortedMap) {
        super(sortedMap);
    }

    /* renamed from: M */
    public SortedMap<K, Collection<V>> g() {
        return (SortedMap) super.g();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: N */
    public SortedMap<K, Collection<V>> t() {
        return (SortedMap) super.t();
    }

    /* renamed from: O */
    public SortedSet<K> keySet() {
        return (SortedSet) super.keySet();
    }

    /* access modifiers changed from: package-private */
    public Set<K> e() {
        return x();
    }
}
