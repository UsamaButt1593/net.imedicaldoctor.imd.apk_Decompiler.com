package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class FilteredKeySetMultimap<K, V> extends FilteredKeyMultimap<K, V> implements FilteredSetMultimap<K, V> {

    class EntrySet extends FilteredKeyMultimap<K, V>.Entries implements Set<Map.Entry<K, V>> {
        EntrySet(FilteredKeySetMultimap filteredKeySetMultimap) {
            super();
        }

        public boolean equals(@CheckForNull Object obj) {
            return Sets.g(this, obj);
        }

        public int hashCode() {
            return Sets.k(this);
        }
    }

    FilteredKeySetMultimap(SetMultimap<K, V> setMultimap, Predicate<? super K> predicate) {
        super(setMultimap, predicate);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: n */
    public Set<Map.Entry<K, V>> d() {
        return new EntrySet(this);
    }

    public Set<V> b(@CheckForNull Object obj) {
        return (Set) super.b(obj);
    }

    public Set<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        return (Set) super.c(k2, iterable);
    }

    public Set<V> get(@ParametricNullness K k2) {
        return (Set) super.get(k2);
    }

    public Set<Map.Entry<K, V>> j() {
        return (Set) super.j();
    }

    public SetMultimap<K, V> k() {
        return (SetMultimap) this.Y2;
    }
}
