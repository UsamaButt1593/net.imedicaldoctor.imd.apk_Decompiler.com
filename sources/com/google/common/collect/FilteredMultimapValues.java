package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class FilteredMultimapValues<K, V> extends AbstractCollection<V> {
    @Weak
    private final FilteredMultimap<K, V> s;

    FilteredMultimapValues(FilteredMultimap<K, V> filteredMultimap) {
        this.s = (FilteredMultimap) Preconditions.E(filteredMultimap);
    }

    public void clear() {
        this.s.clear();
    }

    public boolean contains(@CheckForNull Object obj) {
        return this.s.containsValue(obj);
    }

    public Iterator<V> iterator() {
        return Maps.P0(this.s.j().iterator());
    }

    public boolean remove(@CheckForNull Object obj) {
        Predicate<? super Map.Entry<K, V>> W = this.s.W();
        Iterator<Map.Entry<K, V>> it2 = this.s.k().j().iterator();
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            if (W.apply(next) && Objects.a(next.getValue(), obj)) {
                it2.remove();
                return true;
            }
        }
        return false;
    }

    public boolean removeAll(Collection<?> collection) {
        return Iterables.J(this.s.k().j(), Predicates.d(this.s.W(), Maps.R0(Predicates.n(collection))));
    }

    public boolean retainAll(Collection<?> collection) {
        return Iterables.J(this.s.k().j(), Predicates.d(this.s.W(), Maps.R0(Predicates.q(Predicates.n(collection)))));
    }

    public int size() {
        return this.s.size();
    }
}
