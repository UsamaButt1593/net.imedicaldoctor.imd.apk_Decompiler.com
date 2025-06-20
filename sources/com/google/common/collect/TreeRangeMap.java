package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {
    private static final RangeMap<Comparable<?>, Object> X = new RangeMap<Comparable<?>, Object>() {
        public void a(Range<Comparable<?>> range) {
            Preconditions.E(range);
        }

        public Range<Comparable<?>> c() {
            throw new NoSuchElementException();
        }

        public void clear() {
        }

        @CheckForNull
        public Map.Entry<Range<Comparable<?>>, Object> d(Comparable<?> comparable) {
            return null;
        }

        public RangeMap<Comparable<?>, Object> e(Range<Comparable<?>> range) {
            Preconditions.E(range);
            return this;
        }

        public Map<Range<Comparable<?>>, Object> f() {
            return Collections.emptyMap();
        }

        public Map<Range<Comparable<?>>, Object> g() {
            return Collections.emptyMap();
        }

        @CheckForNull
        public Object h(Comparable<?> comparable) {
            return null;
        }

        public void i(RangeMap<Comparable<?>, ? extends Object> rangeMap) {
            if (!rangeMap.g().isEmpty()) {
                throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
            }
        }

        public void j(Range<Comparable<?>> range, Object obj) {
            Preconditions.E(range);
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        public void k(Range<Comparable<?>> range, Object obj) {
            Preconditions.E(range);
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }
    };
    /* access modifiers changed from: private */
    public final NavigableMap<Cut<K>, RangeMapEntry<K, V>> s = Maps.f0();

    private final class AsMapOfRanges extends Maps.IteratorBasedAbstractMap<Range<K>, V> {
        final Iterable<Map.Entry<Range<K>, V>> s;

        AsMapOfRanges(Iterable<RangeMapEntry<K, V>> iterable) {
            this.s = iterable;
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<Range<K>, V>> a() {
            return this.s.iterator();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return get(obj) != null;
        }

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            if (!(obj instanceof Range)) {
                return null;
            }
            Range range = (Range) obj;
            RangeMapEntry rangeMapEntry = (RangeMapEntry) TreeRangeMap.this.s.get(range.s);
            if (rangeMapEntry == null || !rangeMapEntry.getKey().equals(range)) {
                return null;
            }
            return rangeMapEntry.getValue();
        }

        public int size() {
            return TreeRangeMap.this.s.size();
        }
    }

    private static final class RangeMapEntry<K extends Comparable, V> extends AbstractMapEntry<Range<K>, V> {
        private final V X;
        private final Range<K> s;

        RangeMapEntry(Cut<K> cut, Cut<K> cut2, V v) {
            this(Range.k(cut, cut2), v);
        }

        public boolean a(K k2) {
            return this.s.i(k2);
        }

        /* renamed from: e */
        public Range<K> getKey() {
            return this.s;
        }

        /* access modifiers changed from: package-private */
        public Cut<K> f() {
            return this.s.s;
        }

        public V getValue() {
            return this.X;
        }

        /* access modifiers changed from: package-private */
        public Cut<K> h() {
            return this.s.X;
        }

        RangeMapEntry(Range<K> range, V v) {
            this.s = range;
            this.X = v;
        }
    }

    private class SubRangeMap implements RangeMap<K, V> {
        /* access modifiers changed from: private */
        public final Range<K> s;

        class SubRangeMapAsMap extends AbstractMap<Range<K>, V> {
            SubRangeMapAsMap() {
            }

            /* access modifiers changed from: private */
            public boolean c(Predicate<? super Map.Entry<Range<K>, V>> predicate) {
                ArrayList<Range> q = Lists.q();
                for (Map.Entry entry : entrySet()) {
                    if (predicate.apply(entry)) {
                        q.add((Range) entry.getKey());
                    }
                }
                for (Range a2 : q) {
                    TreeRangeMap.this.a(a2);
                }
                return !q.isEmpty();
            }

            /* access modifiers changed from: package-private */
            public Iterator<Map.Entry<Range<K>, V>> b() {
                if (SubRangeMap.this.s.u()) {
                    return Iterators.u();
                }
                final Iterator it2 = TreeRangeMap.this.s.tailMap((Cut) MoreObjects.a((Cut) TreeRangeMap.this.s.floorKey(SubRangeMap.this.s.s), SubRangeMap.this.s.s), true).values().iterator();
                return new AbstractIterator<Map.Entry<Range<K>, V>>() {
                    /* access modifiers changed from: protected */
                    @CheckForNull
                    /* renamed from: d */
                    public Map.Entry<Range<K>, V> a() {
                        while (it2.hasNext()) {
                            RangeMapEntry rangeMapEntry = (RangeMapEntry) it2.next();
                            if (rangeMapEntry.f().compareTo(SubRangeMap.this.s.X) >= 0) {
                                return (Map.Entry) b();
                            }
                            if (rangeMapEntry.h().compareTo(SubRangeMap.this.s.s) > 0) {
                                return Maps.O(rangeMapEntry.getKey().s(SubRangeMap.this.s), rangeMapEntry.getValue());
                            }
                        }
                        return (Map.Entry) b();
                    }
                };
            }

            public void clear() {
                SubRangeMap.this.clear();
            }

            public boolean containsKey(@CheckForNull Object obj) {
                return get(obj) != null;
            }

            public Set<Map.Entry<Range<K>, V>> entrySet() {
                return new Maps.EntrySet<Range<K>, V>() {
                    /* access modifiers changed from: package-private */
                    public Map<Range<K>, V> h() {
                        return SubRangeMapAsMap.this;
                    }

                    public boolean isEmpty() {
                        return !iterator().hasNext();
                    }

                    public Iterator<Map.Entry<Range<K>, V>> iterator() {
                        return SubRangeMapAsMap.this.b();
                    }

                    public boolean retainAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.c(Predicates.q(Predicates.n(collection)));
                    }

                    public int size() {
                        return Iterators.Z(iterator());
                    }
                };
            }

            @CheckForNull
            public V get(@CheckForNull Object obj) {
                RangeMapEntry rangeMapEntry;
                V v;
                try {
                    if (obj instanceof Range) {
                        Range range = (Range) obj;
                        if (SubRangeMap.this.s.n(range)) {
                            if (!range.u()) {
                                if (range.s.compareTo(SubRangeMap.this.s.s) == 0) {
                                    Map.Entry<K, V> floorEntry = TreeRangeMap.this.s.floorEntry(range.s);
                                    if (floorEntry != null) {
                                        v = floorEntry.getValue();
                                    } else {
                                        rangeMapEntry = null;
                                        if (rangeMapEntry != null && rangeMapEntry.getKey().t(SubRangeMap.this.s) && rangeMapEntry.getKey().s(SubRangeMap.this.s).equals(range)) {
                                            return rangeMapEntry.getValue();
                                        }
                                    }
                                } else {
                                    v = TreeRangeMap.this.s.get(range.s);
                                }
                                rangeMapEntry = (RangeMapEntry) v;
                                return rangeMapEntry.getValue();
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            public Set<Range<K>> keySet() {
                return new Maps.KeySet<Range<K>, V>(this) {
                    public boolean remove(@CheckForNull Object obj) {
                        return SubRangeMapAsMap.this.remove(obj) != null;
                    }

                    public boolean retainAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.c(Predicates.h(Predicates.q(Predicates.n(collection)), Maps.R()));
                    }
                };
            }

            @CheckForNull
            public V remove(@CheckForNull Object obj) {
                V v = get(obj);
                if (v == null) {
                    return null;
                }
                Objects.requireNonNull(obj);
                TreeRangeMap.this.a((Range) obj);
                return v;
            }

            public Collection<V> values() {
                return new Maps.Values<Range<K>, V>(this) {
                    public boolean removeAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.c(Predicates.h(Predicates.n(collection), Maps.O0()));
                    }

                    public boolean retainAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.c(Predicates.h(Predicates.q(Predicates.n(collection)), Maps.O0()));
                    }
                };
            }
        }

        SubRangeMap(Range<K> range) {
            this.s = range;
        }

        public void a(Range<K> range) {
            if (range.t(this.s)) {
                TreeRangeMap.this.a(range.s(this.s));
            }
        }

        public Range<K> c() {
            Cut<C> cut;
            Map.Entry<K, V> floorEntry = TreeRangeMap.this.s.floorEntry(this.s.s);
            if (floorEntry == null || ((RangeMapEntry) floorEntry.getValue()).h().compareTo(this.s.s) <= 0) {
                cut = (Cut) TreeRangeMap.this.s.ceilingKey(this.s.s);
                if (cut == null || cut.compareTo(this.s.X) >= 0) {
                    throw new NoSuchElementException();
                }
            } else {
                cut = this.s.s;
            }
            Map.Entry<K, V> lowerEntry = TreeRangeMap.this.s.lowerEntry(this.s.X);
            if (lowerEntry != null) {
                return Range.k(cut, ((RangeMapEntry) lowerEntry.getValue()).h().compareTo(this.s.X) >= 0 ? this.s.X : ((RangeMapEntry) lowerEntry.getValue()).h());
            }
            throw new NoSuchElementException();
        }

        public void clear() {
            TreeRangeMap.this.a(this.s);
        }

        @CheckForNull
        public Map.Entry<Range<K>, V> d(K k2) {
            Map.Entry d2;
            if (!this.s.i(k2) || (d2 = TreeRangeMap.this.d(k2)) == null) {
                return null;
            }
            return Maps.O(((Range) d2.getKey()).s(this.s), d2.getValue());
        }

        public RangeMap<K, V> e(Range<K> range) {
            return !range.t(this.s) ? TreeRangeMap.this.q() : TreeRangeMap.this.e(range.s(this.s));
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof RangeMap) {
                return g().equals(((RangeMap) obj).g());
            }
            return false;
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [java.util.Map<com.google.common.collect.Range<K>, V>, com.google.common.collect.TreeRangeMap$SubRangeMap$1] */
        public Map<Range<K>, V> f() {
            return new TreeRangeMap<K, V>.SubRangeMap.SubRangeMapAsMap() {
                /* access modifiers changed from: package-private */
                public Iterator<Map.Entry<Range<K>, V>> b() {
                    if (SubRangeMap.this.s.u()) {
                        return Iterators.u();
                    }
                    final Iterator<V> it2 = TreeRangeMap.this.s.headMap(SubRangeMap.this.s.X, false).descendingMap().values().iterator();
                    return new AbstractIterator<Map.Entry<Range<K>, V>>() {
                        /* access modifiers changed from: protected */
                        @CheckForNull
                        /* renamed from: d */
                        public Map.Entry<Range<K>, V> a() {
                            if (!it2.hasNext()) {
                                return (Map.Entry) b();
                            }
                            RangeMapEntry rangeMapEntry = (RangeMapEntry) it2.next();
                            return rangeMapEntry.h().compareTo(SubRangeMap.this.s.s) <= 0 ? (Map.Entry) b() : Maps.O(rangeMapEntry.getKey().s(SubRangeMap.this.s), rangeMapEntry.getValue());
                        }
                    };
                }
            };
        }

        public Map<Range<K>, V> g() {
            return new SubRangeMapAsMap();
        }

        @CheckForNull
        public V h(K k2) {
            if (this.s.i(k2)) {
                return TreeRangeMap.this.h(k2);
            }
            return null;
        }

        public int hashCode() {
            return g().hashCode();
        }

        public void i(RangeMap<K, ? extends V> rangeMap) {
            if (!rangeMap.g().isEmpty()) {
                Range<K> c2 = rangeMap.c();
                Preconditions.y(this.s.n(c2), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", c2, this.s);
                TreeRangeMap.this.i(rangeMap);
            }
        }

        public void j(Range<K> range, V v) {
            if (TreeRangeMap.this.s.isEmpty() || !this.s.n(range)) {
                k(range, v);
            } else {
                k(TreeRangeMap.this.o(range, Preconditions.E(v)).s(this.s), v);
            }
        }

        public void k(Range<K> range, V v) {
            Preconditions.y(this.s.n(range), "Cannot put range %s into a subRangeMap(%s)", range, this.s);
            TreeRangeMap.this.k(range, v);
        }

        public String toString() {
            return g().toString();
        }
    }

    private TreeRangeMap() {
    }

    private static <K extends Comparable, V> Range<K> n(Range<K> range, V v, @CheckForNull Map.Entry<Cut<K>, RangeMapEntry<K, V>> entry) {
        return (entry == null || !entry.getValue().getKey().t(range) || !entry.getValue().getValue().equals(v)) ? range : range.F(entry.getValue().getKey());
    }

    /* access modifiers changed from: private */
    public Range<K> o(Range<K> range, V v) {
        return n(n(range, v, this.s.lowerEntry(range.s)), v, this.s.floorEntry(range.X));
    }

    public static <K extends Comparable, V> TreeRangeMap<K, V> p() {
        return new TreeRangeMap<>();
    }

    /* access modifiers changed from: private */
    public RangeMap<K, V> q() {
        return X;
    }

    private void r(Cut<K> cut, Cut<K> cut2, V v) {
        this.s.put(cut, new RangeMapEntry(cut, cut2, v));
    }

    public void a(Range<K> range) {
        if (!range.u()) {
            Map.Entry<Cut<K>, RangeMapEntry<K, V>> lowerEntry = this.s.lowerEntry(range.s);
            if (lowerEntry != null) {
                RangeMapEntry value = lowerEntry.getValue();
                if (value.h().compareTo(range.s) > 0) {
                    if (value.h().compareTo(range.X) > 0) {
                        r(range.X, value.h(), lowerEntry.getValue().getValue());
                    }
                    r(value.f(), range.s, lowerEntry.getValue().getValue());
                }
            }
            Map.Entry<Cut<K>, RangeMapEntry<K, V>> lowerEntry2 = this.s.lowerEntry(range.X);
            if (lowerEntry2 != null) {
                RangeMapEntry value2 = lowerEntry2.getValue();
                if (value2.h().compareTo(range.X) > 0) {
                    r(range.X, value2.h(), lowerEntry2.getValue().getValue());
                }
            }
            this.s.subMap(range.s, range.X).clear();
        }
    }

    public Range<K> c() {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> firstEntry = this.s.firstEntry();
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> lastEntry = this.s.lastEntry();
        if (firstEntry != null && lastEntry != null) {
            return Range.k(firstEntry.getValue().getKey().s, lastEntry.getValue().getKey().X);
        }
        throw new NoSuchElementException();
    }

    public void clear() {
        this.s.clear();
    }

    @CheckForNull
    public Map.Entry<Range<K>, V> d(K k2) {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> floorEntry = this.s.floorEntry(Cut.e(k2));
        if (floorEntry == null || !floorEntry.getValue().a(k2)) {
            return null;
        }
        return floorEntry.getValue();
    }

    public RangeMap<K, V> e(Range<K> range) {
        return range.equals(Range.a()) ? this : new SubRangeMap(range);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof RangeMap) {
            return g().equals(((RangeMap) obj).g());
        }
        return false;
    }

    public Map<Range<K>, V> f() {
        return new AsMapOfRanges(this.s.descendingMap().values());
    }

    public Map<Range<K>, V> g() {
        return new AsMapOfRanges(this.s.values());
    }

    @CheckForNull
    public V h(K k2) {
        Map.Entry d2 = d(k2);
        if (d2 == null) {
            return null;
        }
        return d2.getValue();
    }

    public int hashCode() {
        return g().hashCode();
    }

    public void i(RangeMap<K, ? extends V> rangeMap) {
        for (Map.Entry next : rangeMap.g().entrySet()) {
            k((Range) next.getKey(), next.getValue());
        }
    }

    public void j(Range<K> range, V v) {
        if (this.s.isEmpty()) {
            k(range, v);
        } else {
            k(o(range, Preconditions.E(v)), v);
        }
    }

    public void k(Range<K> range, V v) {
        if (!range.u()) {
            Preconditions.E(v);
            a(range);
            this.s.put(range.s, new RangeMapEntry(range, v));
        }
    }

    public String toString() {
        return this.s.values().toString();
    }
}
