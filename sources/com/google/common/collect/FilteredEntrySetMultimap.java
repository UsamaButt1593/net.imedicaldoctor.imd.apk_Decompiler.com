package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class FilteredEntrySetMultimap<K, V> extends FilteredEntryMultimap<K, V> implements FilteredSetMultimap<K, V> {
    FilteredEntrySetMultimap(SetMultimap<K, V> setMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        super(setMultimap, predicate);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: r */
    public Set<Map.Entry<K, V>> d() {
        return Sets.i(k().j(), W());
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
