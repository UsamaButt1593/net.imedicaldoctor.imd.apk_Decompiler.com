package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractNavigableMap<K, V> extends Maps.IteratorBasedAbstractMap<K, V> implements NavigableMap<K, V> {

    private final class DescendingMap extends Maps.DescendingMap<K, V> {
        private DescendingMap() {
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> B1() {
            return AbstractNavigableMap.this.b();
        }

        /* access modifiers changed from: package-private */
        public NavigableMap<K, V> E1() {
            return AbstractNavigableMap.this;
        }
    }

    AbstractNavigableMap() {
    }

    /* access modifiers changed from: package-private */
    public abstract Iterator<Map.Entry<K, V>> b();

    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(@ParametricNullness K k2) {
        return tailMap(k2, true).firstEntry();
    }

    @CheckForNull
    public K ceilingKey(@ParametricNullness K k2) {
        return Maps.T(ceilingEntry(k2));
    }

    public NavigableSet<K> descendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    public NavigableMap<K, V> descendingMap() {
        return new DescendingMap();
    }

    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        return (Map.Entry) Iterators.J(a(), null);
    }

    @ParametricNullness
    public K firstKey() {
        Map.Entry firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public Map.Entry<K, V> floorEntry(@ParametricNullness K k2) {
        return headMap(k2, true).lastEntry();
    }

    @CheckForNull
    public K floorKey(@ParametricNullness K k2) {
        return Maps.T(floorEntry(k2));
    }

    @CheckForNull
    public abstract V get(@CheckForNull Object obj);

    public SortedMap<K, V> headMap(@ParametricNullness K k2) {
        return headMap(k2, false);
    }

    @CheckForNull
    public Map.Entry<K, V> higherEntry(@ParametricNullness K k2) {
        return tailMap(k2, false).firstEntry();
    }

    @CheckForNull
    public K higherKey(@ParametricNullness K k2) {
        return Maps.T(higherEntry(k2));
    }

    public Set<K> keySet() {
        return navigableKeySet();
    }

    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        return (Map.Entry) Iterators.J(b(), null);
    }

    @ParametricNullness
    public K lastKey() {
        Map.Entry lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    @CheckForNull
    public Map.Entry<K, V> lowerEntry(@ParametricNullness K k2) {
        return headMap(k2, false).lastEntry();
    }

    @CheckForNull
    public K lowerKey(@ParametricNullness K k2) {
        return Maps.T(lowerEntry(k2));
    }

    public NavigableSet<K> navigableKeySet() {
        return new Maps.NavigableKeySet(this);
    }

    @CheckForNull
    public Map.Entry<K, V> pollFirstEntry() {
        return (Map.Entry) Iterators.U(a());
    }

    @CheckForNull
    public Map.Entry<K, V> pollLastEntry() {
        return (Map.Entry) Iterators.U(b());
    }

    public SortedMap<K, V> subMap(@ParametricNullness K k2, @ParametricNullness K k3) {
        return subMap(k2, true, k3, false);
    }

    public SortedMap<K, V> tailMap(@ParametricNullness K k2) {
        return tailMap(k2, true);
    }
}
