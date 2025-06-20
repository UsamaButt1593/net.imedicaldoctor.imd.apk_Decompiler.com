package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Predicate;
import java.util.List;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class FilteredKeyListMultimap<K, V> extends FilteredKeyMultimap<K, V> implements ListMultimap<K, V> {
    FilteredKeyListMultimap(ListMultimap<K, V> listMultimap, Predicate<? super K> predicate) {
        super(listMultimap, predicate);
    }

    /* renamed from: n */
    public ListMultimap<K, V> k() {
        return (ListMultimap) super.k();
    }

    public List<V> b(@CheckForNull Object obj) {
        return (List) super.b(obj);
    }

    public List<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        return (List) super.c(k2, iterable);
    }

    public List<V> get(@ParametricNullness K k2) {
        return (List) super.get(k2);
    }
}
