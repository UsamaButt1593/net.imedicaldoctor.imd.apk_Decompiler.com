package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {

    protected class StandardDescendingMap extends Maps.DescendingMap<K, V> {
        public StandardDescendingMap() {
        }

        /* access modifiers changed from: protected */
        public Iterator<Map.Entry<K, V>> B1() {
            return new Iterator<Map.Entry<K, V>>() {
                @CheckForNull
                private Map.Entry<K, V> X;
                @CheckForNull
                private Map.Entry<K, V> s = null;

                {
                    this.X = StandardDescendingMap.this.E1().lastEntry();
                }

                /* renamed from: a */
                public Map.Entry<K, V> next() {
                    Map.Entry<K, V> entry = this.X;
                    if (entry != null) {
                        this.s = entry;
                        this.X = StandardDescendingMap.this.E1().lowerEntry(this.X.getKey());
                        return entry;
                    }
                    throw new NoSuchElementException();
                }

                public boolean hasNext() {
                    return this.X != null;
                }

                public void remove() {
                    if (this.s != null) {
                        StandardDescendingMap.this.E1().remove(this.s.getKey());
                        this.s = null;
                        return;
                    }
                    throw new IllegalStateException("no calls to next() since the last call to remove()");
                }
            };
        }

        /* access modifiers changed from: package-private */
        public NavigableMap<K, V> E1() {
            return ForwardingNavigableMap.this;
        }
    }

    protected class StandardNavigableKeySet extends Maps.NavigableKeySet<K, V> {
        public StandardNavigableKeySet(ForwardingNavigableMap forwardingNavigableMap) {
            super(forwardingNavigableMap);
        }
    }

    protected ForwardingNavigableMap() {
    }

    /* access modifiers changed from: protected */
    public SortedMap<K, V> B1(@ParametricNullness K k2, @ParametricNullness K k3) {
        return subMap(k2, true, k3, false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: G1 */
    public abstract NavigableMap<K, V> x1();

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> I1(@ParametricNullness K k2) {
        return tailMap(k2, true).firstEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public K J1(@ParametricNullness K k2) {
        return Maps.T(ceilingEntry(k2));
    }

    /* access modifiers changed from: protected */
    public NavigableSet<K> K1() {
        return descendingMap().navigableKeySet();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> L1() {
        return (Map.Entry) Iterables.v(entrySet(), null);
    }

    /* access modifiers changed from: protected */
    public K M1() {
        Map.Entry firstEntry = firstEntry();
        if (firstEntry != null) {
            return firstEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> N1(@ParametricNullness K k2) {
        return headMap(k2, true).lastEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public K P1(@ParametricNullness K k2) {
        return Maps.T(floorEntry(k2));
    }

    /* access modifiers changed from: protected */
    public SortedMap<K, V> Q1(@ParametricNullness K k2) {
        return headMap(k2, false);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> V1(@ParametricNullness K k2) {
        return tailMap(k2, false).firstEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public K W1(@ParametricNullness K k2) {
        return Maps.T(higherEntry(k2));
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> X1() {
        return (Map.Entry) Iterables.v(descendingMap().entrySet(), null);
    }

    /* access modifiers changed from: protected */
    public K Y1() {
        Map.Entry lastEntry = lastEntry();
        if (lastEntry != null) {
            return lastEntry.getKey();
        }
        throw new NoSuchElementException();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> Z1(@ParametricNullness K k2) {
        return headMap(k2, false).lastEntry();
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public K c2(@ParametricNullness K k2) {
        return Maps.T(lowerEntry(k2));
    }

    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(@ParametricNullness K k2) {
        return x1().ceilingEntry(k2);
    }

    @CheckForNull
    public K ceilingKey(@ParametricNullness K k2) {
        return x1().ceilingKey(k2);
    }

    public NavigableSet<K> descendingKeySet() {
        return x1().descendingKeySet();
    }

    public NavigableMap<K, V> descendingMap() {
        return x1().descendingMap();
    }

    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        return x1().firstEntry();
    }

    @CheckForNull
    public Map.Entry<K, V> floorEntry(@ParametricNullness K k2) {
        return x1().floorEntry(k2);
    }

    @CheckForNull
    public K floorKey(@ParametricNullness K k2) {
        return x1().floorKey(k2);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> h2() {
        return (Map.Entry) Iterators.U(entrySet().iterator());
    }

    public NavigableMap<K, V> headMap(@ParametricNullness K k2, boolean z) {
        return x1().headMap(k2, z);
    }

    @CheckForNull
    public Map.Entry<K, V> higherEntry(@ParametricNullness K k2) {
        return x1().higherEntry(k2);
    }

    @CheckForNull
    public K higherKey(@ParametricNullness K k2) {
        return x1().higherKey(k2);
    }

    /* access modifiers changed from: protected */
    @CheckForNull
    public Map.Entry<K, V> i2() {
        return (Map.Entry) Iterators.U(descendingMap().entrySet().iterator());
    }

    /* access modifiers changed from: protected */
    public SortedMap<K, V> j2(@ParametricNullness K k2) {
        return tailMap(k2, true);
    }

    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        return x1().lastEntry();
    }

    @CheckForNull
    public Map.Entry<K, V> lowerEntry(@ParametricNullness K k2) {
        return x1().lowerEntry(k2);
    }

    @CheckForNull
    public K lowerKey(@ParametricNullness K k2) {
        return x1().lowerKey(k2);
    }

    public NavigableSet<K> navigableKeySet() {
        return x1().navigableKeySet();
    }

    @CheckForNull
    public Map.Entry<K, V> pollFirstEntry() {
        return x1().pollFirstEntry();
    }

    @CheckForNull
    public Map.Entry<K, V> pollLastEntry() {
        return x1().pollLastEntry();
    }

    public NavigableMap<K, V> subMap(@ParametricNullness K k2, boolean z, @ParametricNullness K k3, boolean z2) {
        return x1().subMap(k2, z, k3, z2);
    }

    public NavigableMap<K, V> tailMap(@ParametricNullness K k2, boolean z) {
        return x1().tailMap(k2, z);
    }
}
