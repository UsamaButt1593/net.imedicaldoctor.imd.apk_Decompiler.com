package com.google.common.collect;

import com.dd.plist.ASCIIPropertyListParser;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Maps {

    private static abstract class AbstractFilteredMap<K, V> extends ViewCachingAbstractMap<K, V> {
        final Predicate<? super Map.Entry<K, V>> X2;
        final Map<K, V> Z;

        AbstractFilteredMap(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
            this.Z = map;
            this.X2 = predicate;
        }

        /* access modifiers changed from: package-private */
        public Collection<V> c() {
            return new FilteredMapValues(this, this.Z, this.X2);
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.Z.containsKey(obj) && d(obj, this.Z.get(obj));
        }

        /* access modifiers changed from: package-private */
        public boolean d(@CheckForNull Object obj, @ParametricNullness V v) {
            return this.X2.apply(Maps.O(obj, v));
        }

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            V v = this.Z.get(obj);
            if (v == null || !d(obj, v)) {
                return null;
            }
            return v;
        }

        public boolean isEmpty() {
            return entrySet().isEmpty();
        }

        @CheckForNull
        public V put(@ParametricNullness K k2, @ParametricNullness V v) {
            Preconditions.d(d(k2, v));
            return this.Z.put(k2, v);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            for (Map.Entry next : map.entrySet()) {
                Preconditions.d(d(next.getKey(), next.getValue()));
            }
            this.Z.putAll(map);
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            if (containsKey(obj)) {
                return this.Z.remove(obj);
            }
            return null;
        }
    }

    private static class AsMapView<K, V> extends ViewCachingAbstractMap<K, V> {
        final Function<? super K, V> X2;
        private final Set<K> Z;

        AsMapView(Set<K> set, Function<? super K, V> function) {
            this.Z = (Set) Preconditions.E(set);
            this.X2 = (Function) Preconditions.E(function);
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, V>> a() {
            return new EntrySet<K, V>() {
                /* access modifiers changed from: package-private */
                public Map<K, V> h() {
                    return AsMapView.this;
                }

                public Iterator<Map.Entry<K, V>> iterator() {
                    return Maps.m(AsMapView.this.d(), AsMapView.this.X2);
                }
            };
        }

        public Set<K> b() {
            return Maps.m0(d());
        }

        /* access modifiers changed from: package-private */
        public Collection<V> c() {
            return Collections2.m(this.Z, this.X2);
        }

        public void clear() {
            d().clear();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return d().contains(obj);
        }

        /* access modifiers changed from: package-private */
        public Set<K> d() {
            return this.Z;
        }

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            if (Collections2.j(d(), obj)) {
                return this.X2.apply(obj);
            }
            return null;
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            if (d().remove(obj)) {
                return this.X2.apply(obj);
            }
            return null;
        }

        public int size() {
            return d().size();
        }
    }

    private static final class BiMapConverter<A, B> extends Converter<A, B> implements Serializable {
        private static final long Z = 0;
        private final BiMap<A, B> Y;

        BiMapConverter(BiMap<A, B> biMap) {
            this.Y = (BiMap) Preconditions.E(biMap);
        }

        private static <X, Y> Y o(BiMap<X, Y> biMap, X x) {
            Y y = biMap.get(x);
            Preconditions.u(y != null, "No non-null mapping present for input: %s", x);
            return y;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof BiMapConverter) {
                return this.Y.equals(((BiMapConverter) obj).Y);
            }
            return false;
        }

        /* access modifiers changed from: protected */
        public A h(B b2) {
            return o(this.Y.q2(), b2);
        }

        public int hashCode() {
            return this.Y.hashCode();
        }

        /* access modifiers changed from: protected */
        public B i(A a2) {
            return o(this.Y, a2);
        }

        public String toString() {
            return "Maps.asConverter(" + this.Y + ")";
        }
    }

    @GwtIncompatible
    static abstract class DescendingMap<K, V> extends ForwardingMap<K, V> implements NavigableMap<K, V> {
        @CheckForNull
        @LazyInit
        private transient Set<Map.Entry<K, V>> X;
        @CheckForNull
        @LazyInit
        private transient NavigableSet<K> Y;
        @CheckForNull
        @LazyInit
        private transient Comparator<? super K> s;

        DescendingMap() {
        }

        private static <T> Ordering<T> G1(Comparator<T> comparator) {
            return Ordering.i(comparator).E();
        }

        /* access modifiers changed from: package-private */
        public abstract Iterator<Map.Entry<K, V>> B1();

        /* access modifiers changed from: package-private */
        public abstract NavigableMap<K, V> E1();

        /* access modifiers changed from: protected */
        /* renamed from: a1 */
        public final Map<K, V> Z0() {
            return E1();
        }

        @CheckForNull
        public Map.Entry<K, V> ceilingEntry(@ParametricNullness K k2) {
            return E1().floorEntry(k2);
        }

        @CheckForNull
        public K ceilingKey(@ParametricNullness K k2) {
            return E1().floorKey(k2);
        }

        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator = this.s;
            if (comparator != null) {
                return comparator;
            }
            Comparator comparator2 = E1().comparator();
            if (comparator2 == null) {
                comparator2 = Ordering.z();
            }
            Ordering G1 = G1(comparator2);
            this.s = G1;
            return G1;
        }

        public NavigableSet<K> descendingKeySet() {
            return E1().navigableKeySet();
        }

        public NavigableMap<K, V> descendingMap() {
            return E1();
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.X;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> x1 = x1();
            this.X = x1;
            return x1;
        }

        @CheckForNull
        public Map.Entry<K, V> firstEntry() {
            return E1().lastEntry();
        }

        @ParametricNullness
        public K firstKey() {
            return E1().lastKey();
        }

        @CheckForNull
        public Map.Entry<K, V> floorEntry(@ParametricNullness K k2) {
            return E1().ceilingEntry(k2);
        }

        @CheckForNull
        public K floorKey(@ParametricNullness K k2) {
            return E1().ceilingKey(k2);
        }

        public NavigableMap<K, V> headMap(@ParametricNullness K k2, boolean z) {
            return E1().tailMap(k2, z).descendingMap();
        }

        @CheckForNull
        public Map.Entry<K, V> higherEntry(@ParametricNullness K k2) {
            return E1().lowerEntry(k2);
        }

        @CheckForNull
        public K higherKey(@ParametricNullness K k2) {
            return E1().lowerKey(k2);
        }

        public Set<K> keySet() {
            return navigableKeySet();
        }

        @CheckForNull
        public Map.Entry<K, V> lastEntry() {
            return E1().firstEntry();
        }

        @ParametricNullness
        public K lastKey() {
            return E1().firstKey();
        }

        @CheckForNull
        public Map.Entry<K, V> lowerEntry(@ParametricNullness K k2) {
            return E1().higherEntry(k2);
        }

        @CheckForNull
        public K lowerKey(@ParametricNullness K k2) {
            return E1().higherKey(k2);
        }

        public NavigableSet<K> navigableKeySet() {
            NavigableSet<K> navigableSet = this.Y;
            if (navigableSet != null) {
                return navigableSet;
            }
            NavigableKeySet navigableKeySet = new NavigableKeySet(this);
            this.Y = navigableKeySet;
            return navigableKeySet;
        }

        @CheckForNull
        public Map.Entry<K, V> pollFirstEntry() {
            return E1().pollLastEntry();
        }

        @CheckForNull
        public Map.Entry<K, V> pollLastEntry() {
            return E1().pollFirstEntry();
        }

        public NavigableMap<K, V> subMap(@ParametricNullness K k2, boolean z, @ParametricNullness K k3, boolean z2) {
            return E1().subMap(k3, z2, k2, z).descendingMap();
        }

        public NavigableMap<K, V> tailMap(@ParametricNullness K k2, boolean z) {
            return E1().headMap(k2, z).descendingMap();
        }

        public String toString() {
            return v1();
        }

        public Collection<V> values() {
            return new Values(this);
        }

        /* access modifiers changed from: package-private */
        public Set<Map.Entry<K, V>> x1() {
            return new EntrySet<K, V>() {
                /* access modifiers changed from: package-private */
                public Map<K, V> h() {
                    return DescendingMap.this;
                }

                public Iterator<Map.Entry<K, V>> iterator() {
                    return DescendingMap.this.B1();
                }
            };
        }

        public SortedMap<K, V> headMap(@ParametricNullness K k2) {
            return headMap(k2, false);
        }

        public SortedMap<K, V> subMap(@ParametricNullness K k2, @ParametricNullness K k3) {
            return subMap(k2, true, k3, false);
        }

        public SortedMap<K, V> tailMap(@ParametricNullness K k2) {
            return tailMap(k2, true);
        }
    }

    private enum EntryFunction implements Function<Map.Entry<?, ?>, Object> {
        KEY {
            @CheckForNull
            /* renamed from: b */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getKey();
            }
        },
        VALUE {
            @CheckForNull
            /* renamed from: b */
            public Object apply(Map.Entry<?, ?> entry) {
                return entry.getValue();
            }
        }
    }

    static abstract class EntrySet<K, V> extends Sets.ImprovedAbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        public void clear() {
            h().clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object p0 = Maps.p0(h(), key);
            if (Objects.a(p0, entry.getValue())) {
                return p0 != null || h().containsKey(key);
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public abstract Map<K, V> h();

        public boolean isEmpty() {
            return h().isEmpty();
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!contains(obj) || !(obj instanceof Map.Entry)) {
                return false;
            }
            return h().keySet().remove(((Map.Entry) obj).getKey());
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.E(collection));
            } catch (UnsupportedOperationException unused) {
                return Sets.J(this, collection.iterator());
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.E(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet y = Sets.y(collection.size());
                for (Object next : collection) {
                    if (contains(next) && (next instanceof Map.Entry)) {
                        y.add(((Map.Entry) next).getKey());
                    }
                }
                return h().keySet().retainAll(y);
            }
        }

        public int size() {
            return h().size();
        }
    }

    public interface EntryTransformer<K, V1, V2> {
        @ParametricNullness
        V2 a(@ParametricNullness K k2, @ParametricNullness V1 v1);
    }

    static final class FilteredEntryBiMap<K, V> extends FilteredEntryMap<K, V> implements BiMap<K, V> {
        @RetainedWith
        private final BiMap<V, K> Z2;

        FilteredEntryBiMap(BiMap<K, V> biMap, Predicate<? super Map.Entry<K, V>> predicate) {
            super(biMap, predicate);
            this.Z2 = new FilteredEntryBiMap(biMap.q2(), g(predicate), this);
        }

        private static <K, V> Predicate<Map.Entry<V, K>> g(final Predicate<? super Map.Entry<K, V>> predicate) {
            return new Predicate<Map.Entry<V, K>>() {
                /* renamed from: a */
                public boolean apply(Map.Entry<V, K> entry) {
                    return Predicate.this.apply(Maps.O(entry.getValue(), entry.getKey()));
                }
            };
        }

        /* access modifiers changed from: package-private */
        public BiMap<K, V> h() {
            return (BiMap) this.Z;
        }

        @CheckForNull
        public V k0(@ParametricNullness K k2, @ParametricNullness V v) {
            Preconditions.d(d(k2, v));
            return h().k0(k2, v);
        }

        public BiMap<V, K> q2() {
            return this.Z2;
        }

        private FilteredEntryBiMap(BiMap<K, V> biMap, Predicate<? super Map.Entry<K, V>> predicate, BiMap<V, K> biMap2) {
            super(biMap, predicate);
            this.Z2 = biMap2;
        }

        public Set<V> values() {
            return this.Z2.keySet();
        }
    }

    static class FilteredEntryMap<K, V> extends AbstractFilteredMap<K, V> {
        final Set<Map.Entry<K, V>> Y2;

        private class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
            private EntrySet() {
            }

            /* access modifiers changed from: protected */
            /* renamed from: E1 */
            public Set<Map.Entry<K, V>> a1() {
                return FilteredEntryMap.this.Y2;
            }

            public Iterator<Map.Entry<K, V>> iterator() {
                return new TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>>(FilteredEntryMap.this.Y2.iterator()) {
                    /* access modifiers changed from: package-private */
                    /* renamed from: b */
                    public Map.Entry<K, V> a(final Map.Entry<K, V> entry) {
                        return new ForwardingMapEntry<K, V>() {
                            /* access modifiers changed from: protected */
                            /* renamed from: a1 */
                            public Map.Entry<K, V> Z0() {
                                return entry;
                            }

                            @ParametricNullness
                            public V setValue(@ParametricNullness V v) {
                                Preconditions.d(FilteredEntryMap.this.d(getKey(), v));
                                return super.setValue(v);
                            }
                        };
                    }
                };
            }
        }

        class KeySet extends KeySet<K, V> {
            KeySet() {
                super(FilteredEntryMap.this);
            }

            public boolean remove(@CheckForNull Object obj) {
                if (!FilteredEntryMap.this.containsKey(obj)) {
                    return false;
                }
                FilteredEntryMap.this.Z.remove(obj);
                return true;
            }

            public boolean removeAll(Collection<?> collection) {
                FilteredEntryMap filteredEntryMap = FilteredEntryMap.this;
                return FilteredEntryMap.e(filteredEntryMap.Z, filteredEntryMap.X2, collection);
            }

            public boolean retainAll(Collection<?> collection) {
                FilteredEntryMap filteredEntryMap = FilteredEntryMap.this;
                return FilteredEntryMap.f(filteredEntryMap.Z, filteredEntryMap.X2, collection);
            }

            public Object[] toArray() {
                return Lists.s(iterator()).toArray();
            }

            public <T> T[] toArray(T[] tArr) {
                return Lists.s(iterator()).toArray(tArr);
            }
        }

        FilteredEntryMap(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
            super(map, predicate);
            this.Y2 = Sets.i(map.entrySet(), this.X2);
        }

        static <K, V> boolean e(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate, Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
            boolean z = false;
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                if (predicate.apply(next) && collection.contains(next.getKey())) {
                    it2.remove();
                    z = true;
                }
            }
            return z;
        }

        static <K, V> boolean f(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate, Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
            boolean z = false;
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                if (predicate.apply(next) && !collection.contains(next.getKey())) {
                    it2.remove();
                    z = true;
                }
            }
            return z;
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, V>> a() {
            return new EntrySet();
        }

        /* access modifiers changed from: package-private */
        public Set<K> b() {
            return new KeySet();
        }
    }

    @GwtIncompatible
    private static class FilteredEntryNavigableMap<K, V> extends AbstractNavigableMap<K, V> {
        /* access modifiers changed from: private */
        public final Predicate<? super Map.Entry<K, V>> X;
        private final Map<K, V> Y;
        /* access modifiers changed from: private */
        public final NavigableMap<K, V> s;

        FilteredEntryNavigableMap(NavigableMap<K, V> navigableMap, Predicate<? super Map.Entry<K, V>> predicate) {
            this.s = (NavigableMap) Preconditions.E(navigableMap);
            this.X = predicate;
            this.Y = new FilteredEntryMap(navigableMap, predicate);
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> a() {
            return Iterators.x(this.s.entrySet().iterator(), this.X);
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> b() {
            return Iterators.x(this.s.descendingMap().entrySet().iterator(), this.X);
        }

        public void clear() {
            this.Y.clear();
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return this.s.comparator();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.Y.containsKey(obj);
        }

        public NavigableMap<K, V> descendingMap() {
            return Maps.z(this.s.descendingMap(), this.X);
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return this.Y.entrySet();
        }

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            return this.Y.get(obj);
        }

        public NavigableMap<K, V> headMap(@ParametricNullness K k2, boolean z) {
            return Maps.z(this.s.headMap(k2, z), this.X);
        }

        public boolean isEmpty() {
            return !Iterables.c(this.s.entrySet(), this.X);
        }

        public NavigableSet<K> navigableKeySet() {
            return new NavigableKeySet<K, V>(this) {
                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMap.e(FilteredEntryNavigableMap.this.s, FilteredEntryNavigableMap.this.X, collection);
                }

                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMap.f(FilteredEntryNavigableMap.this.s, FilteredEntryNavigableMap.this.X, collection);
                }
            };
        }

        @CheckForNull
        public Map.Entry<K, V> pollFirstEntry() {
            return (Map.Entry) Iterables.I(this.s.entrySet(), this.X);
        }

        @CheckForNull
        public Map.Entry<K, V> pollLastEntry() {
            return (Map.Entry) Iterables.I(this.s.descendingMap().entrySet(), this.X);
        }

        @CheckForNull
        public V put(@ParametricNullness K k2, @ParametricNullness V v) {
            return this.Y.put(k2, v);
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            this.Y.putAll(map);
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            return this.Y.remove(obj);
        }

        public int size() {
            return this.Y.size();
        }

        public NavigableMap<K, V> subMap(@ParametricNullness K k2, boolean z, @ParametricNullness K k3, boolean z2) {
            return Maps.z(this.s.subMap(k2, z, k3, z2), this.X);
        }

        public NavigableMap<K, V> tailMap(@ParametricNullness K k2, boolean z) {
            return Maps.z(this.s.tailMap(k2, z), this.X);
        }

        public Collection<V> values() {
            return new FilteredMapValues(this, this.s, this.X);
        }
    }

    private static class FilteredEntrySortedMap<K, V> extends FilteredEntryMap<K, V> implements SortedMap<K, V> {

        class SortedKeySet extends FilteredEntryMap<K, V>.KeySet implements SortedSet<K> {
            SortedKeySet() {
                super();
            }

            @CheckForNull
            public Comparator<? super K> comparator() {
                return FilteredEntrySortedMap.this.i().comparator();
            }

            @ParametricNullness
            public K first() {
                return FilteredEntrySortedMap.this.firstKey();
            }

            public SortedSet<K> headSet(@ParametricNullness K k2) {
                return (SortedSet) FilteredEntrySortedMap.this.headMap(k2).keySet();
            }

            @ParametricNullness
            public K last() {
                return FilteredEntrySortedMap.this.lastKey();
            }

            public SortedSet<K> subSet(@ParametricNullness K k2, @ParametricNullness K k3) {
                return (SortedSet) FilteredEntrySortedMap.this.subMap(k2, k3).keySet();
            }

            public SortedSet<K> tailSet(@ParametricNullness K k2) {
                return (SortedSet) FilteredEntrySortedMap.this.tailMap(k2).keySet();
            }
        }

        FilteredEntrySortedMap(SortedMap<K, V> sortedMap, Predicate<? super Map.Entry<K, V>> predicate) {
            super(sortedMap, predicate);
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return i().comparator();
        }

        @ParametricNullness
        public K firstKey() {
            return keySet().iterator().next();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public SortedSet<K> b() {
            return new SortedKeySet();
        }

        /* renamed from: h */
        public SortedSet<K> keySet() {
            return (SortedSet) super.keySet();
        }

        public SortedMap<K, V> headMap(@ParametricNullness K k2) {
            return new FilteredEntrySortedMap(i().headMap(k2), this.X2);
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, V> i() {
            return (SortedMap) this.Z;
        }

        @ParametricNullness
        public K lastKey() {
            SortedMap i2 = i();
            while (true) {
                K lastKey = i2.lastKey();
                if (d(lastKey, NullnessCasts.a(this.Z.get(lastKey)))) {
                    return lastKey;
                }
                i2 = i().headMap(lastKey);
            }
        }

        public SortedMap<K, V> subMap(@ParametricNullness K k2, @ParametricNullness K k3) {
            return new FilteredEntrySortedMap(i().subMap(k2, k3), this.X2);
        }

        public SortedMap<K, V> tailMap(@ParametricNullness K k2) {
            return new FilteredEntrySortedMap(i().tailMap(k2), this.X2);
        }
    }

    private static class FilteredKeyMap<K, V> extends AbstractFilteredMap<K, V> {
        final Predicate<? super K> Y2;

        FilteredKeyMap(Map<K, V> map, Predicate<? super K> predicate, Predicate<? super Map.Entry<K, V>> predicate2) {
            super(map, predicate2);
            this.Y2 = predicate;
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, V>> a() {
            return Sets.i(this.Z.entrySet(), this.X2);
        }

        /* access modifiers changed from: package-private */
        public Set<K> b() {
            return Sets.i(this.Z.keySet(), this.Y2);
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.Z.containsKey(obj) && this.Y2.apply(obj);
        }
    }

    private static final class FilteredMapValues<K, V> extends Values<K, V> {
        final Map<K, V> X;
        final Predicate<? super Map.Entry<K, V>> Y;

        FilteredMapValues(Map<K, V> map, Map<K, V> map2, Predicate<? super Map.Entry<K, V>> predicate) {
            super(map);
            this.X = map2;
            this.Y = predicate;
        }

        public boolean remove(@CheckForNull Object obj) {
            Iterator<Map.Entry<K, V>> it2 = this.X.entrySet().iterator();
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                if (this.Y.apply(next) && Objects.a(next.getValue(), obj)) {
                    it2.remove();
                    return true;
                }
            }
            return false;
        }

        public boolean removeAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it2 = this.X.entrySet().iterator();
            boolean z = false;
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                if (this.Y.apply(next) && collection.contains(next.getValue())) {
                    it2.remove();
                    z = true;
                }
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            Iterator<Map.Entry<K, V>> it2 = this.X.entrySet().iterator();
            boolean z = false;
            while (it2.hasNext()) {
                Map.Entry next = it2.next();
                if (this.Y.apply(next) && !collection.contains(next.getValue())) {
                    it2.remove();
                    z = true;
                }
            }
            return z;
        }

        public Object[] toArray() {
            return Lists.s(iterator()).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return Lists.s(iterator()).toArray(tArr);
        }
    }

    static abstract class IteratorBasedAbstractMap<K, V> extends AbstractMap<K, V> {
        IteratorBasedAbstractMap() {
        }

        /* access modifiers changed from: package-private */
        public abstract Iterator<Map.Entry<K, V>> a();

        public void clear() {
            Iterators.h(a());
        }

        public Set<Map.Entry<K, V>> entrySet() {
            return new EntrySet<K, V>() {
                /* access modifiers changed from: package-private */
                public Map<K, V> h() {
                    return IteratorBasedAbstractMap.this;
                }

                public Iterator<Map.Entry<K, V>> iterator() {
                    return IteratorBasedAbstractMap.this.a();
                }
            };
        }

        public abstract int size();
    }

    static class KeySet<K, V> extends Sets.ImprovedAbstractSet<K> {
        @Weak
        final Map<K, V> s;

        KeySet(Map<K, V> map) {
            this.s = (Map) Preconditions.E(map);
        }

        public void clear() {
            h().clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            return h().containsKey(obj);
        }

        /* access modifiers changed from: package-private */
        public Map<K, V> h() {
            return this.s;
        }

        public boolean isEmpty() {
            return h().isEmpty();
        }

        public Iterator<K> iterator() {
            return Maps.S(h().entrySet().iterator());
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!contains(obj)) {
                return false;
            }
            h().remove(obj);
            return true;
        }

        public int size() {
            return h().size();
        }
    }

    static class MapDifferenceImpl<K, V> implements MapDifference<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final Map<K, V> f22446a;

        /* renamed from: b  reason: collision with root package name */
        final Map<K, V> f22447b;

        /* renamed from: c  reason: collision with root package name */
        final Map<K, V> f22448c;

        /* renamed from: d  reason: collision with root package name */
        final Map<K, MapDifference.ValueDifference<V>> f22449d;

        MapDifferenceImpl(Map<K, V> map, Map<K, V> map2, Map<K, V> map3, Map<K, MapDifference.ValueDifference<V>> map4) {
            this.f22446a = Maps.L0(map);
            this.f22447b = Maps.L0(map2);
            this.f22448c = Maps.L0(map3);
            this.f22449d = Maps.L0(map4);
        }

        public Map<K, V> a() {
            return this.f22446a;
        }

        public Map<K, MapDifference.ValueDifference<V>> b() {
            return this.f22449d;
        }

        public Map<K, V> c() {
            return this.f22447b;
        }

        public Map<K, V> d() {
            return this.f22448c;
        }

        public boolean e() {
            return this.f22446a.isEmpty() && this.f22447b.isEmpty() && this.f22449d.isEmpty();
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MapDifference)) {
                return false;
            }
            MapDifference mapDifference = (MapDifference) obj;
            return a().equals(mapDifference.a()) && c().equals(mapDifference.c()) && d().equals(mapDifference.d()) && b().equals(mapDifference.b());
        }

        public int hashCode() {
            return Objects.b(a(), c(), d(), b());
        }

        public String toString() {
            if (e()) {
                return "equal";
            }
            StringBuilder sb = new StringBuilder("not equal");
            if (!this.f22446a.isEmpty()) {
                sb.append(": only on left=");
                sb.append(this.f22446a);
            }
            if (!this.f22447b.isEmpty()) {
                sb.append(": only on right=");
                sb.append(this.f22447b);
            }
            if (!this.f22449d.isEmpty()) {
                sb.append(": value differences=");
                sb.append(this.f22449d);
            }
            return sb.toString();
        }
    }

    @GwtIncompatible
    private static final class NavigableAsMapView<K, V> extends AbstractNavigableMap<K, V> {
        private final Function<? super K, V> X;
        private final NavigableSet<K> s;

        NavigableAsMapView(NavigableSet<K> navigableSet, Function<? super K, V> function) {
            this.s = (NavigableSet) Preconditions.E(navigableSet);
            this.X = (Function) Preconditions.E(function);
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> a() {
            return Maps.m(this.s, this.X);
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> b() {
            return descendingMap().entrySet().iterator();
        }

        public void clear() {
            this.s.clear();
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return this.s.comparator();
        }

        public NavigableMap<K, V> descendingMap() {
            return Maps.k(this.s.descendingSet(), this.X);
        }

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            if (Collections2.j(this.s, obj)) {
                return this.X.apply(obj);
            }
            return null;
        }

        public NavigableMap<K, V> headMap(@ParametricNullness K k2, boolean z) {
            return Maps.k(this.s.headSet(k2, z), this.X);
        }

        public NavigableSet<K> navigableKeySet() {
            return Maps.l0(this.s);
        }

        public int size() {
            return this.s.size();
        }

        public NavigableMap<K, V> subMap(@ParametricNullness K k2, boolean z, @ParametricNullness K k3, boolean z2) {
            return Maps.k(this.s.subSet(k2, z, k3, z2), this.X);
        }

        public NavigableMap<K, V> tailMap(@ParametricNullness K k2, boolean z) {
            return Maps.k(this.s.tailSet(k2, z), this.X);
        }
    }

    @GwtIncompatible
    static class NavigableKeySet<K, V> extends SortedKeySet<K, V> implements NavigableSet<K> {
        NavigableKeySet(NavigableMap<K, V> navigableMap) {
            super(navigableMap);
        }

        @CheckForNull
        public K ceiling(@ParametricNullness K k2) {
            return j().ceilingKey(k2);
        }

        public Iterator<K> descendingIterator() {
            return descendingSet().iterator();
        }

        public NavigableSet<K> descendingSet() {
            return j().descendingKeySet();
        }

        @CheckForNull
        public K floor(@ParametricNullness K k2) {
            return j().floorKey(k2);
        }

        public NavigableSet<K> headSet(@ParametricNullness K k2, boolean z) {
            return j().headMap(k2, z).navigableKeySet();
        }

        @CheckForNull
        public K higher(@ParametricNullness K k2) {
            return j().higherKey(k2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: k */
        public NavigableMap<K, V> j() {
            return (NavigableMap) this.s;
        }

        @CheckForNull
        public K lower(@ParametricNullness K k2) {
            return j().lowerKey(k2);
        }

        @CheckForNull
        public K pollFirst() {
            return Maps.T(j().pollFirstEntry());
        }

        @CheckForNull
        public K pollLast() {
            return Maps.T(j().pollLastEntry());
        }

        public NavigableSet<K> subSet(@ParametricNullness K k2, boolean z, @ParametricNullness K k3, boolean z2) {
            return j().subMap(k2, z, k3, z2).navigableKeySet();
        }

        public NavigableSet<K> tailSet(@ParametricNullness K k2, boolean z) {
            return j().tailMap(k2, z).navigableKeySet();
        }

        public SortedSet<K> headSet(@ParametricNullness K k2) {
            return headSet(k2, false);
        }

        public SortedSet<K> subSet(@ParametricNullness K k2, @ParametricNullness K k3) {
            return subSet(k2, true, k3, false);
        }

        public SortedSet<K> tailSet(@ParametricNullness K k2) {
            return tailSet(k2, true);
        }
    }

    private static class SortedAsMapView<K, V> extends AsMapView<K, V> implements SortedMap<K, V> {
        SortedAsMapView(SortedSet<K> sortedSet, Function<? super K, V> function) {
            super(sortedSet, function);
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return d().comparator();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: e */
        public SortedSet<K> d() {
            return (SortedSet) super.d();
        }

        @ParametricNullness
        public K firstKey() {
            return d().first();
        }

        public SortedMap<K, V> headMap(@ParametricNullness K k2) {
            return Maps.l(d().headSet(k2), this.X2);
        }

        public Set<K> keySet() {
            return Maps.n0(d());
        }

        @ParametricNullness
        public K lastKey() {
            return d().last();
        }

        public SortedMap<K, V> subMap(@ParametricNullness K k2, @ParametricNullness K k3) {
            return Maps.l(d().subSet(k2, k3), this.X2);
        }

        public SortedMap<K, V> tailMap(@ParametricNullness K k2) {
            return Maps.l(d().tailSet(k2), this.X2);
        }
    }

    static class SortedKeySet<K, V> extends KeySet<K, V> implements SortedSet<K> {
        SortedKeySet(SortedMap<K, V> sortedMap) {
            super(sortedMap);
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return h().comparator();
        }

        @ParametricNullness
        public K first() {
            return h().firstKey();
        }

        public SortedSet<K> headSet(@ParametricNullness K k2) {
            return new SortedKeySet(h().headMap(k2));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public SortedMap<K, V> h() {
            return (SortedMap) super.h();
        }

        @ParametricNullness
        public K last() {
            return h().lastKey();
        }

        public SortedSet<K> subSet(@ParametricNullness K k2, @ParametricNullness K k3) {
            return new SortedKeySet(h().subMap(k2, k3));
        }

        public SortedSet<K> tailSet(@ParametricNullness K k2) {
            return new SortedKeySet(h().tailMap(k2));
        }
    }

    static class SortedMapDifferenceImpl<K, V> extends MapDifferenceImpl<K, V> implements SortedMapDifference<K, V> {
        SortedMapDifferenceImpl(SortedMap<K, V> sortedMap, SortedMap<K, V> sortedMap2, SortedMap<K, V> sortedMap3, SortedMap<K, MapDifference.ValueDifference<V>> sortedMap4) {
            super(sortedMap, sortedMap2, sortedMap3, sortedMap4);
        }

        public SortedMap<K, V> a() {
            return (SortedMap) super.a();
        }

        public SortedMap<K, MapDifference.ValueDifference<V>> b() {
            return (SortedMap) super.b();
        }

        public SortedMap<K, V> c() {
            return (SortedMap) super.c();
        }

        public SortedMap<K, V> d() {
            return (SortedMap) super.d();
        }
    }

    static class TransformedEntriesMap<K, V1, V2> extends IteratorBasedAbstractMap<K, V2> {
        final EntryTransformer<? super K, ? super V1, V2> X;
        final Map<K, V1> s;

        TransformedEntriesMap(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.s = (Map) Preconditions.E(map);
            this.X = (EntryTransformer) Preconditions.E(entryTransformer);
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V2>> a() {
            return Iterators.c0(this.s.entrySet().iterator(), Maps.g(this.X));
        }

        public void clear() {
            this.s.clear();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.s.containsKey(obj);
        }

        @CheckForNull
        public V2 get(@CheckForNull Object obj) {
            V1 v1 = this.s.get(obj);
            if (v1 != null || this.s.containsKey(obj)) {
                return this.X.a(obj, NullnessCasts.a(v1));
            }
            return null;
        }

        public Set<K> keySet() {
            return this.s.keySet();
        }

        @CheckForNull
        public V2 remove(@CheckForNull Object obj) {
            if (this.s.containsKey(obj)) {
                return this.X.a(obj, NullnessCasts.a(this.s.remove(obj)));
            }
            return null;
        }

        public int size() {
            return this.s.size();
        }

        public Collection<V2> values() {
            return new Values(this);
        }
    }

    @GwtIncompatible
    private static class TransformedEntriesNavigableMap<K, V1, V2> extends TransformedEntriesSortedMap<K, V1, V2> implements NavigableMap<K, V2> {
        TransformedEntriesNavigableMap(NavigableMap<K, V1> navigableMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(navigableMap, entryTransformer);
        }

        @CheckForNull
        private Map.Entry<K, V2> g(@CheckForNull Map.Entry<K, V1> entry) {
            if (entry == null) {
                return null;
            }
            return Maps.A0(this.X, entry);
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public NavigableMap<K, V1> b() {
            return (NavigableMap) super.b();
        }

        @CheckForNull
        public Map.Entry<K, V2> ceilingEntry(@ParametricNullness K k2) {
            return g(b().ceilingEntry(k2));
        }

        @CheckForNull
        public K ceilingKey(@ParametricNullness K k2) {
            return b().ceilingKey(k2);
        }

        /* renamed from: d */
        public NavigableMap<K, V2> headMap(@ParametricNullness K k2) {
            return headMap(k2, false);
        }

        public NavigableSet<K> descendingKeySet() {
            return b().descendingKeySet();
        }

        public NavigableMap<K, V2> descendingMap() {
            return Maps.y0(b().descendingMap(), this.X);
        }

        /* renamed from: e */
        public NavigableMap<K, V2> subMap(@ParametricNullness K k2, @ParametricNullness K k3) {
            return subMap(k2, true, k3, false);
        }

        /* renamed from: f */
        public NavigableMap<K, V2> tailMap(@ParametricNullness K k2) {
            return tailMap(k2, true);
        }

        @CheckForNull
        public Map.Entry<K, V2> firstEntry() {
            return g(b().firstEntry());
        }

        @CheckForNull
        public Map.Entry<K, V2> floorEntry(@ParametricNullness K k2) {
            return g(b().floorEntry(k2));
        }

        @CheckForNull
        public K floorKey(@ParametricNullness K k2) {
            return b().floorKey(k2);
        }

        public NavigableMap<K, V2> headMap(@ParametricNullness K k2, boolean z) {
            return Maps.y0(b().headMap(k2, z), this.X);
        }

        @CheckForNull
        public Map.Entry<K, V2> higherEntry(@ParametricNullness K k2) {
            return g(b().higherEntry(k2));
        }

        @CheckForNull
        public K higherKey(@ParametricNullness K k2) {
            return b().higherKey(k2);
        }

        @CheckForNull
        public Map.Entry<K, V2> lastEntry() {
            return g(b().lastEntry());
        }

        @CheckForNull
        public Map.Entry<K, V2> lowerEntry(@ParametricNullness K k2) {
            return g(b().lowerEntry(k2));
        }

        @CheckForNull
        public K lowerKey(@ParametricNullness K k2) {
            return b().lowerKey(k2);
        }

        public NavigableSet<K> navigableKeySet() {
            return b().navigableKeySet();
        }

        @CheckForNull
        public Map.Entry<K, V2> pollFirstEntry() {
            return g(b().pollFirstEntry());
        }

        @CheckForNull
        public Map.Entry<K, V2> pollLastEntry() {
            return g(b().pollLastEntry());
        }

        public NavigableMap<K, V2> subMap(@ParametricNullness K k2, boolean z, @ParametricNullness K k3, boolean z2) {
            return Maps.y0(b().subMap(k2, z, k3, z2), this.X);
        }

        public NavigableMap<K, V2> tailMap(@ParametricNullness K k2, boolean z) {
            return Maps.y0(b().tailMap(k2, z), this.X);
        }
    }

    static class TransformedEntriesSortedMap<K, V1, V2> extends TransformedEntriesMap<K, V1, V2> implements SortedMap<K, V2> {
        TransformedEntriesSortedMap(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(sortedMap, entryTransformer);
        }

        /* access modifiers changed from: protected */
        public SortedMap<K, V1> b() {
            return (SortedMap) this.s;
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return b().comparator();
        }

        @ParametricNullness
        public K firstKey() {
            return b().firstKey();
        }

        public SortedMap<K, V2> headMap(@ParametricNullness K k2) {
            return Maps.z0(b().headMap(k2), this.X);
        }

        @ParametricNullness
        public K lastKey() {
            return b().lastKey();
        }

        public SortedMap<K, V2> subMap(@ParametricNullness K k2, @ParametricNullness K k3) {
            return Maps.z0(b().subMap(k2, k3), this.X);
        }

        public SortedMap<K, V2> tailMap(@ParametricNullness K k2) {
            return Maps.z0(b().tailMap(k2), this.X);
        }
    }

    private static class UnmodifiableBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long X2 = 0;
        final BiMap<? extends K, ? extends V> X;
        @RetainedWith
        @CheckForNull
        @LazyInit
        BiMap<V, K> Y;
        @CheckForNull
        @LazyInit
        transient Set<V> Z;
        final Map<K, V> s;

        UnmodifiableBiMap(BiMap<? extends K, ? extends V> biMap, @CheckForNull BiMap<V, K> biMap2) {
            this.s = Collections.unmodifiableMap(biMap);
            this.X = biMap;
            this.Y = biMap2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a1 */
        public Map<K, V> Z0() {
            return this.s;
        }

        @CheckForNull
        public V k0(@ParametricNullness K k2, @ParametricNullness V v) {
            throw new UnsupportedOperationException();
        }

        public BiMap<V, K> q2() {
            BiMap<V, K> biMap = this.Y;
            if (biMap != null) {
                return biMap;
            }
            UnmodifiableBiMap unmodifiableBiMap = new UnmodifiableBiMap(this.X.q2(), this);
            this.Y = unmodifiableBiMap;
            return unmodifiableBiMap;
        }

        public Set<V> values() {
            Set<V> set = this.Z;
            if (set != null) {
                return set;
            }
            Set<V> unmodifiableSet = Collections.unmodifiableSet(this.X.values());
            this.Z = unmodifiableSet;
            return unmodifiableSet;
        }
    }

    static class UnmodifiableEntries<K, V> extends ForwardingCollection<Map.Entry<K, V>> {
        private final Collection<Map.Entry<K, V>> s;

        UnmodifiableEntries(Collection<Map.Entry<K, V>> collection) {
            this.s = collection;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a1 */
        public Collection<Map.Entry<K, V>> Z0() {
            return this.s;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return Maps.J0(this.s.iterator());
        }

        public Object[] toArray() {
            return v1();
        }

        public <T> T[] toArray(T[] tArr) {
            return x1(tArr);
        }
    }

    static class UnmodifiableEntrySet<K, V> extends UnmodifiableEntries<K, V> implements Set<Map.Entry<K, V>> {
        UnmodifiableEntrySet(Set<Map.Entry<K, V>> set) {
            super(set);
        }

        public boolean equals(@CheckForNull Object obj) {
            return Sets.g(this, obj);
        }

        public int hashCode() {
            return Sets.k(this);
        }
    }

    @GwtIncompatible
    static class UnmodifiableNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V>, Serializable {
        @CheckForNull
        @LazyInit
        private transient UnmodifiableNavigableMap<K, V> X;
        private final NavigableMap<K, ? extends V> s;

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap) {
            this.s = navigableMap;
        }

        @CheckForNull
        public Map.Entry<K, V> ceilingEntry(@ParametricNullness K k2) {
            return Maps.N0(this.s.ceilingEntry(k2));
        }

        @CheckForNull
        public K ceilingKey(@ParametricNullness K k2) {
            return this.s.ceilingKey(k2);
        }

        public NavigableSet<K> descendingKeySet() {
            return Sets.O(this.s.descendingKeySet());
        }

        public NavigableMap<K, V> descendingMap() {
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap = this.X;
            if (unmodifiableNavigableMap != null) {
                return unmodifiableNavigableMap;
            }
            UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap2 = new UnmodifiableNavigableMap<>(this.s.descendingMap(), this);
            this.X = unmodifiableNavigableMap2;
            return unmodifiableNavigableMap2;
        }

        @CheckForNull
        public Map.Entry<K, V> firstEntry() {
            return Maps.N0(this.s.firstEntry());
        }

        @CheckForNull
        public Map.Entry<K, V> floorEntry(@ParametricNullness K k2) {
            return Maps.N0(this.s.floorEntry(k2));
        }

        @CheckForNull
        public K floorKey(@ParametricNullness K k2) {
            return this.s.floorKey(k2);
        }

        public NavigableMap<K, V> headMap(@ParametricNullness K k2, boolean z) {
            return Maps.M0(this.s.headMap(k2, z));
        }

        @CheckForNull
        public Map.Entry<K, V> higherEntry(@ParametricNullness K k2) {
            return Maps.N0(this.s.higherEntry(k2));
        }

        @CheckForNull
        public K higherKey(@ParametricNullness K k2) {
            return this.s.higherKey(k2);
        }

        public Set<K> keySet() {
            return navigableKeySet();
        }

        @CheckForNull
        public Map.Entry<K, V> lastEntry() {
            return Maps.N0(this.s.lastEntry());
        }

        @CheckForNull
        public Map.Entry<K, V> lowerEntry(@ParametricNullness K k2) {
            return Maps.N0(this.s.lowerEntry(k2));
        }

        @CheckForNull
        public K lowerKey(@ParametricNullness K k2) {
            return this.s.lowerKey(k2);
        }

        public NavigableSet<K> navigableKeySet() {
            return Sets.O(this.s.navigableKeySet());
        }

        @CheckForNull
        public final Map.Entry<K, V> pollFirstEntry() {
            throw new UnsupportedOperationException();
        }

        @CheckForNull
        public final Map.Entry<K, V> pollLastEntry() {
            throw new UnsupportedOperationException();
        }

        public NavigableMap<K, V> subMap(@ParametricNullness K k2, boolean z, @ParametricNullness K k3, boolean z2) {
            return Maps.M0(this.s.subMap(k2, z, k3, z2));
        }

        public NavigableMap<K, V> tailMap(@ParametricNullness K k2, boolean z) {
            return Maps.M0(this.s.tailMap(k2, z));
        }

        /* access modifiers changed from: protected */
        /* renamed from: x1 */
        public SortedMap<K, V> a1() {
            return Collections.unmodifiableSortedMap(this.s);
        }

        UnmodifiableNavigableMap(NavigableMap<K, ? extends V> navigableMap, UnmodifiableNavigableMap<K, V> unmodifiableNavigableMap) {
            this.s = navigableMap;
            this.X = unmodifiableNavigableMap;
        }

        public SortedMap<K, V> headMap(@ParametricNullness K k2) {
            return headMap(k2, false);
        }

        public SortedMap<K, V> subMap(@ParametricNullness K k2, @ParametricNullness K k3) {
            return subMap(k2, true, k3, false);
        }

        public SortedMap<K, V> tailMap(@ParametricNullness K k2) {
            return tailMap(k2, true);
        }
    }

    static class ValueDifferenceImpl<V> implements MapDifference.ValueDifference<V> {
        @ParametricNullness

        /* renamed from: a  reason: collision with root package name */
        private final V f22450a;
        @ParametricNullness

        /* renamed from: b  reason: collision with root package name */
        private final V f22451b;

        private ValueDifferenceImpl(@ParametricNullness V v, @ParametricNullness V v2) {
            this.f22450a = v;
            this.f22451b = v2;
        }

        static <V> MapDifference.ValueDifference<V> c(@ParametricNullness V v, @ParametricNullness V v2) {
            return new ValueDifferenceImpl(v, v2);
        }

        @ParametricNullness
        public V a() {
            return this.f22451b;
        }

        @ParametricNullness
        public V b() {
            return this.f22450a;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof MapDifference.ValueDifference)) {
                return false;
            }
            MapDifference.ValueDifference valueDifference = (MapDifference.ValueDifference) obj;
            return Objects.a(this.f22450a, valueDifference.b()) && Objects.a(this.f22451b, valueDifference.a());
        }

        public int hashCode() {
            return Objects.b(this.f22450a, this.f22451b);
        }

        public String toString() {
            return "(" + this.f22450a + ", " + this.f22451b + ")";
        }
    }

    static class Values<K, V> extends AbstractCollection<V> {
        @Weak
        final Map<K, V> s;

        Values(Map<K, V> map) {
            this.s = (Map) Preconditions.E(map);
        }

        /* access modifiers changed from: package-private */
        public final Map<K, V> b() {
            return this.s;
        }

        public void clear() {
            b().clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            return b().containsValue(obj);
        }

        public boolean isEmpty() {
            return b().isEmpty();
        }

        public Iterator<V> iterator() {
            return Maps.P0(b().entrySet().iterator());
        }

        public boolean remove(@CheckForNull Object obj) {
            try {
                return super.remove(obj);
            } catch (UnsupportedOperationException unused) {
                for (Map.Entry entry : b().entrySet()) {
                    if (Objects.a(obj, entry.getValue())) {
                        b().remove(entry.getKey());
                        return true;
                    }
                }
                return false;
            }
        }

        public boolean removeAll(Collection<?> collection) {
            try {
                return super.removeAll((Collection) Preconditions.E(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet u = Sets.u();
                for (Map.Entry entry : b().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        u.add(entry.getKey());
                    }
                }
                return b().keySet().removeAll(u);
            }
        }

        public boolean retainAll(Collection<?> collection) {
            try {
                return super.retainAll((Collection) Preconditions.E(collection));
            } catch (UnsupportedOperationException unused) {
                HashSet u = Sets.u();
                for (Map.Entry entry : b().entrySet()) {
                    if (collection.contains(entry.getValue())) {
                        u.add(entry.getKey());
                    }
                }
                return b().keySet().retainAll(u);
            }
        }

        public int size() {
            return b().size();
        }
    }

    @GwtCompatible
    static abstract class ViewCachingAbstractMap<K, V> extends AbstractMap<K, V> {
        @CheckForNull
        @LazyInit
        private transient Set<K> X;
        @CheckForNull
        @LazyInit
        private transient Collection<V> Y;
        @CheckForNull
        @LazyInit
        private transient Set<Map.Entry<K, V>> s;

        ViewCachingAbstractMap() {
        }

        /* access modifiers changed from: package-private */
        public abstract Set<Map.Entry<K, V>> a();

        /* access modifiers changed from: package-private */
        public Set<K> b() {
            return new KeySet(this);
        }

        /* access modifiers changed from: package-private */
        public Collection<V> c() {
            return new Values(this);
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.s;
            if (set != null) {
                return set;
            }
            Set<Map.Entry<K, V>> a2 = a();
            this.s = a2;
            return a2;
        }

        public Set<K> keySet() {
            Set<K> set = this.X;
            if (set != null) {
                return set;
            }
            Set<K> b2 = b();
            this.X = b2;
            return b2;
        }

        public Collection<V> values() {
            Collection<V> collection = this.Y;
            if (collection != null) {
                return collection;
            }
            Collection<V> c2 = c();
            this.Y = c2;
            return c2;
        }
    }

    private Maps() {
    }

    public static <K, V> SortedMap<K, V> A(SortedMap<K, V> sortedMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.E(predicate);
        return sortedMap instanceof FilteredEntrySortedMap ? E((FilteredEntrySortedMap) sortedMap, predicate) : new FilteredEntrySortedMap((SortedMap) Preconditions.E(sortedMap), predicate);
    }

    static <V2, K, V1> Map.Entry<K, V2> A0(final EntryTransformer<? super K, ? super V1, V2> entryTransformer, final Map.Entry<K, V1> entry) {
        Preconditions.E(entryTransformer);
        Preconditions.E(entry);
        return new AbstractMapEntry<K, V2>() {
            @ParametricNullness
            public K getKey() {
                return entry.getKey();
            }

            @ParametricNullness
            public V2 getValue() {
                return entryTransformer.a(entry.getKey(), entry.getValue());
            }
        };
    }

    private static <K, V> BiMap<K, V> B(FilteredEntryBiMap<K, V> filteredEntryBiMap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntryBiMap(filteredEntryBiMap.h(), Predicates.d(filteredEntryBiMap.X2, predicate));
    }

    public static <K, V1, V2> Map<K, V2> B0(Map<K, V1> map, Function<? super V1, V2> function) {
        return x0(map, i(function));
    }

    private static <K, V> Map<K, V> C(AbstractFilteredMap<K, V> abstractFilteredMap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntryMap(abstractFilteredMap.Z, Predicates.d(abstractFilteredMap.X2, predicate));
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> C0(NavigableMap<K, V1> navigableMap, Function<? super V1, V2> function) {
        return y0(navigableMap, i(function));
    }

    @GwtIncompatible
    private static <K, V> NavigableMap<K, V> D(FilteredEntryNavigableMap<K, V> filteredEntryNavigableMap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntryNavigableMap(filteredEntryNavigableMap.s, Predicates.d(filteredEntryNavigableMap.X, predicate));
    }

    public static <K, V1, V2> SortedMap<K, V2> D0(SortedMap<K, V1> sortedMap, Function<? super V1, V2> function) {
        return z0(sortedMap, i(function));
    }

    private static <K, V> SortedMap<K, V> E(FilteredEntrySortedMap<K, V> filteredEntrySortedMap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntrySortedMap(filteredEntrySortedMap.i(), Predicates.d(filteredEntrySortedMap.X2, predicate));
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> E0(Iterable<V> iterable, Function<? super V, K> function) {
        return iterable instanceof Collection ? G0(iterable.iterator(), function, ImmutableMap.c(((Collection) iterable).size())) : F0(iterable.iterator(), function);
    }

    public static <K, V> BiMap<K, V> F(BiMap<K, V> biMap, Predicate<? super K> predicate) {
        Preconditions.E(predicate);
        return x(biMap, U(predicate));
    }

    @CanIgnoreReturnValue
    public static <K, V> ImmutableMap<K, V> F0(Iterator<V> it2, Function<? super V, K> function) {
        return G0(it2, function, ImmutableMap.b());
    }

    public static <K, V> Map<K, V> G(Map<K, V> map, Predicate<? super K> predicate) {
        Preconditions.E(predicate);
        Predicate<Map.Entry<K, ?>> U = U(predicate);
        return map instanceof AbstractFilteredMap ? C((AbstractFilteredMap) map, U) : new FilteredKeyMap((Map) Preconditions.E(map), predicate, U);
    }

    private static <K, V> ImmutableMap<K, V> G0(Iterator<V> it2, Function<? super V, K> function, ImmutableMap.Builder<K, V> builder) {
        Preconditions.E(function);
        while (it2.hasNext()) {
            V next = it2.next();
            builder.i(function.apply(next), next);
        }
        try {
            return builder.d();
        } catch (IllegalArgumentException e2) {
            throw new IllegalArgumentException(e2.getMessage() + ". To index multiple values under a key, use Multimaps.index.");
        }
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> H(NavigableMap<K, V> navigableMap, Predicate<? super K> predicate) {
        return z(navigableMap, U(predicate));
    }

    public static <K, V> BiMap<K, V> H0(BiMap<? extends K, ? extends V> biMap) {
        return new UnmodifiableBiMap(biMap, (BiMap) null);
    }

    public static <K, V> SortedMap<K, V> I(SortedMap<K, V> sortedMap, Predicate<? super K> predicate) {
        return A(sortedMap, U(predicate));
    }

    static <K, V> Map.Entry<K, V> I0(final Map.Entry<? extends K, ? extends V> entry) {
        Preconditions.E(entry);
        return new AbstractMapEntry<K, V>() {
            @ParametricNullness
            public K getKey() {
                return entry.getKey();
            }

            @ParametricNullness
            public V getValue() {
                return entry.getValue();
            }
        };
    }

    public static <K, V> BiMap<K, V> J(BiMap<K, V> biMap, Predicate<? super V> predicate) {
        return x(biMap, R0(predicate));
    }

    static <K, V> UnmodifiableIterator<Map.Entry<K, V>> J0(final Iterator<Map.Entry<K, V>> it2) {
        return new UnmodifiableIterator<Map.Entry<K, V>>() {
            /* renamed from: a */
            public Map.Entry<K, V> next() {
                return Maps.I0((Map.Entry) it2.next());
            }

            public boolean hasNext() {
                return it2.hasNext();
            }
        };
    }

    public static <K, V> Map<K, V> K(Map<K, V> map, Predicate<? super V> predicate) {
        return y(map, R0(predicate));
    }

    static <K, V> Set<Map.Entry<K, V>> K0(Set<Map.Entry<K, V>> set) {
        return new UnmodifiableEntrySet(Collections.unmodifiableSet(set));
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> L(NavigableMap<K, V> navigableMap, Predicate<? super V> predicate) {
        return z(navigableMap, R0(predicate));
    }

    /* access modifiers changed from: private */
    public static <K, V> Map<K, V> L0(Map<K, ? extends V> map) {
        return map instanceof SortedMap ? Collections.unmodifiableSortedMap((SortedMap) map) : Collections.unmodifiableMap(map);
    }

    public static <K, V> SortedMap<K, V> M(SortedMap<K, V> sortedMap, Predicate<? super V> predicate) {
        return A(sortedMap, R0(predicate));
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> M0(NavigableMap<K, ? extends V> navigableMap) {
        Preconditions.E(navigableMap);
        return navigableMap instanceof UnmodifiableNavigableMap ? navigableMap : new UnmodifiableNavigableMap(navigableMap);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static ImmutableMap<String, String> N(Properties properties) {
        ImmutableMap.Builder b2 = ImmutableMap.b();
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            Object nextElement = propertyNames.nextElement();
            java.util.Objects.requireNonNull(nextElement);
            String str = (String) nextElement;
            String property = properties.getProperty(str);
            java.util.Objects.requireNonNull(property);
            b2.i(str, property);
        }
        return b2.d();
    }

    /* access modifiers changed from: private */
    @CheckForNull
    public static <K, V> Map.Entry<K, V> N0(@CheckForNull Map.Entry<K, ? extends V> entry) {
        if (entry == null) {
            return null;
        }
        return I0(entry);
    }

    @GwtCompatible(serializable = true)
    public static <K, V> Map.Entry<K, V> O(@ParametricNullness K k2, @ParametricNullness V v) {
        return new ImmutableEntry(k2, v);
    }

    static <V> Function<Map.Entry<?, V>, V> O0() {
        return EntryFunction.VALUE;
    }

    @GwtCompatible(serializable = true)
    @J2ktIncompatible
    public static <K extends Enum<K>, V> ImmutableMap<K, V> P(Map<K, ? extends V> map) {
        if (map instanceof ImmutableEnumMap) {
            return (ImmutableEnumMap) map;
        }
        Iterator<Map.Entry<K, ? extends V>> it2 = map.entrySet().iterator();
        if (!it2.hasNext()) {
            return ImmutableMap.s();
        }
        Map.Entry next = it2.next();
        Enum enumR = (Enum) next.getKey();
        Object value = next.getValue();
        CollectPreconditions.a(enumR, value);
        EnumMap enumMap = new EnumMap(Collections.singletonMap(enumR, value));
        while (it2.hasNext()) {
            Map.Entry next2 = it2.next();
            Enum enumR2 = (Enum) next2.getKey();
            Object value2 = next2.getValue();
            CollectPreconditions.a(enumR2, value2);
            enumMap.put(enumR2, value2);
        }
        return ImmutableEnumMap.K(enumMap);
    }

    static <K, V> Iterator<V> P0(Iterator<Map.Entry<K, V>> it2) {
        return new TransformedIterator<Map.Entry<K, V>, V>(it2) {
            /* access modifiers changed from: package-private */
            @ParametricNullness
            /* renamed from: b */
            public V a(Map.Entry<K, V> entry) {
                return entry.getValue();
            }
        };
    }

    static <E> ImmutableMap<E, Integer> Q(Collection<E> collection) {
        ImmutableMap.Builder builder = new ImmutableMap.Builder(collection.size());
        int i2 = 0;
        for (E i3 : collection) {
            builder.i(i3, Integer.valueOf(i2));
            i2++;
        }
        return builder.d();
    }

    @CheckForNull
    static <V> V Q0(@CheckForNull Map.Entry<?, V> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    static <K> Function<Map.Entry<K, ?>, K> R() {
        return EntryFunction.KEY;
    }

    static <V> Predicate<Map.Entry<?, V>> R0(Predicate<? super V> predicate) {
        return Predicates.h(predicate, O0());
    }

    static <K, V> Iterator<K> S(Iterator<Map.Entry<K, V>> it2) {
        return new TransformedIterator<Map.Entry<K, V>, K>(it2) {
            /* access modifiers changed from: package-private */
            @ParametricNullness
            /* renamed from: b */
            public K a(Map.Entry<K, V> entry) {
                return entry.getKey();
            }
        };
    }

    @CheckForNull
    static <K> K T(@CheckForNull Map.Entry<K, ?> entry) {
        if (entry == null) {
            return null;
        }
        return entry.getKey();
    }

    static <K> Predicate<Map.Entry<K, ?>> U(Predicate<? super K> predicate) {
        return Predicates.h(predicate, R());
    }

    public static <K, V> ConcurrentMap<K, V> V() {
        return new ConcurrentHashMap();
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> W(Class<K> cls) {
        return new EnumMap<>((Class) Preconditions.E(cls));
    }

    public static <K extends Enum<K>, V> EnumMap<K, V> X(Map<K, ? extends V> map) {
        return new EnumMap<>(map);
    }

    public static <K, V> HashMap<K, V> Y() {
        return new HashMap<>();
    }

    public static <K, V> HashMap<K, V> Z(Map<? extends K, ? extends V> map) {
        return new HashMap<>(map);
    }

    public static <K, V> HashMap<K, V> a0(int i2) {
        return new HashMap<>(o(i2));
    }

    public static <K, V> IdentityHashMap<K, V> b0() {
        return new IdentityHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> c0() {
        return new LinkedHashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> d0(Map<? extends K, ? extends V> map) {
        return new LinkedHashMap<>(map);
    }

    public static <K, V> LinkedHashMap<K, V> e0(int i2) {
        return new LinkedHashMap<>(o(i2));
    }

    public static <A, B> Converter<A, B> f(BiMap<A, B> biMap) {
        return new BiMapConverter(biMap);
    }

    public static <K extends Comparable, V> TreeMap<K, V> f0() {
        return new TreeMap<>();
    }

    static <K, V1, V2> Function<Map.Entry<K, V1>, Map.Entry<K, V2>> g(final EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        Preconditions.E(entryTransformer);
        return new Function<Map.Entry<K, V1>, Map.Entry<K, V2>>() {
            /* renamed from: a */
            public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
                return Maps.A0(EntryTransformer.this, entry);
            }
        };
    }

    public static <C, K extends C, V> TreeMap<K, V> g0(@CheckForNull Comparator<C> comparator) {
        return new TreeMap<>(comparator);
    }

    static <K, V1, V2> Function<Map.Entry<K, V1>, V2> h(final EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        Preconditions.E(entryTransformer);
        return new Function<Map.Entry<K, V1>, V2>() {
            @ParametricNullness
            /* renamed from: a */
            public V2 apply(Map.Entry<K, V1> entry) {
                return EntryTransformer.this.a(entry.getKey(), entry.getValue());
            }
        };
    }

    public static <K, V> TreeMap<K, V> h0(SortedMap<K, ? extends V> sortedMap) {
        return new TreeMap<>(sortedMap);
    }

    static <K, V1, V2> EntryTransformer<K, V1, V2> i(final Function<? super V1, V2> function) {
        Preconditions.E(function);
        return new EntryTransformer<K, V1, V2>() {
            @ParametricNullness
            public V2 a(@ParametricNullness K k2, @ParametricNullness V1 v1) {
                return Function.this.apply(v1);
            }
        };
    }

    static <E> Comparator<? super E> i0(@CheckForNull Comparator<? super E> comparator) {
        return comparator != null ? comparator : Ordering.z();
    }

    public static <K, V> Map<K, V> j(Set<K> set, Function<? super K, V> function) {
        return new AsMapView(set, function);
    }

    static <K, V> void j0(Map<K, V> map, Map<? extends K, ? extends V> map2) {
        for (Map.Entry next : map2.entrySet()) {
            map.put(next.getKey(), next.getValue());
        }
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> k(NavigableSet<K> navigableSet, Function<? super K, V> function) {
        return new NavigableAsMapView(navigableSet, function);
    }

    static <K, V> boolean k0(Collection<Map.Entry<K, V>> collection, @CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return collection.remove(I0((Map.Entry) obj));
    }

    public static <K, V> SortedMap<K, V> l(SortedSet<K> sortedSet, Function<? super K, V> function) {
        return new SortedAsMapView(sortedSet, function);
    }

    /* access modifiers changed from: private */
    @GwtIncompatible
    public static <E> NavigableSet<E> l0(final NavigableSet<E> navigableSet) {
        return new ForwardingNavigableSet<E>() {
            /* access modifiers changed from: protected */
            /* renamed from: L1 */
            public NavigableSet<E> a1() {
                return navigableSet;
            }

            public boolean add(@ParametricNullness E e2) {
                throw new UnsupportedOperationException();
            }

            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            public NavigableSet<E> descendingSet() {
                return Maps.l0(super.descendingSet());
            }

            public NavigableSet<E> headSet(@ParametricNullness E e2, boolean z) {
                return Maps.l0(super.headSet(e2, z));
            }

            public NavigableSet<E> subSet(@ParametricNullness E e2, boolean z, @ParametricNullness E e3, boolean z2) {
                return Maps.l0(super.subSet(e2, z, e3, z2));
            }

            public NavigableSet<E> tailSet(@ParametricNullness E e2, boolean z) {
                return Maps.l0(super.tailSet(e2, z));
            }

            public SortedSet<E> headSet(@ParametricNullness E e2) {
                return Maps.n0(super.headSet(e2));
            }

            public SortedSet<E> subSet(@ParametricNullness E e2, @ParametricNullness E e3) {
                return Maps.n0(super.subSet(e2, e3));
            }

            public SortedSet<E> tailSet(@ParametricNullness E e2) {
                return Maps.n0(super.tailSet(e2));
            }
        };
    }

    static <K, V> Iterator<Map.Entry<K, V>> m(Set<K> set, final Function<? super K, V> function) {
        return new TransformedIterator<K, Map.Entry<K, V>>(set.iterator()) {
            /* access modifiers changed from: package-private */
            /* renamed from: b */
            public Map.Entry<K, V> a(@ParametricNullness K k2) {
                return Maps.O(k2, function.apply(k2));
            }
        };
    }

    /* access modifiers changed from: private */
    public static <E> Set<E> m0(final Set<E> set) {
        return new ForwardingSet<E>() {
            /* access modifiers changed from: protected */
            /* renamed from: E1 */
            public Set<E> a1() {
                return set;
            }

            public boolean add(@ParametricNullness E e2) {
                throw new UnsupportedOperationException();
            }

            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }
        };
    }

    static <K, V1, V2> Function<V1, V2> n(final EntryTransformer<? super K, V1, V2> entryTransformer, @ParametricNullness final K k2) {
        Preconditions.E(entryTransformer);
        return new Function<V1, V2>() {
            @ParametricNullness
            public V2 apply(@ParametricNullness V1 v1) {
                return EntryTransformer.this.a(k2, v1);
            }
        };
    }

    /* access modifiers changed from: private */
    public static <E> SortedSet<E> n0(final SortedSet<E> sortedSet) {
        return new ForwardingSortedSet<E>() {
            /* access modifiers changed from: protected */
            /* renamed from: J1 */
            public SortedSet<E> a1() {
                return sortedSet;
            }

            public boolean add(@ParametricNullness E e2) {
                throw new UnsupportedOperationException();
            }

            public boolean addAll(Collection<? extends E> collection) {
                throw new UnsupportedOperationException();
            }

            public SortedSet<E> headSet(@ParametricNullness E e2) {
                return Maps.n0(super.headSet(e2));
            }

            public SortedSet<E> subSet(@ParametricNullness E e2, @ParametricNullness E e3) {
                return Maps.n0(super.subSet(e2, e3));
            }

            public SortedSet<E> tailSet(@ParametricNullness E e2) {
                return Maps.n0(super.tailSet(e2));
            }
        };
    }

    static int o(int i2) {
        if (i2 < 3) {
            CollectPreconditions.b(i2, "expectedSize");
            return i2 + 1;
        } else if (i2 < 1073741824) {
            return (int) Math.ceil(((double) i2) / 0.75d);
        } else {
            return Integer.MAX_VALUE;
        }
    }

    static boolean o0(Map<?, ?> map, @CheckForNull Object obj) {
        Preconditions.E(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static <K, V> boolean p(Collection<Map.Entry<K, V>> collection, @CheckForNull Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        return collection.contains(I0((Map.Entry) obj));
    }

    @CheckForNull
    static <V> V p0(Map<?, V> map, @CheckForNull Object obj) {
        Preconditions.E(map);
        try {
            return map.get(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static boolean q(Map<?, ?> map, @CheckForNull Object obj) {
        return Iterators.q(S(map.entrySet().iterator()), obj);
    }

    @CheckForNull
    static <V> V q0(Map<?, V> map, @CheckForNull Object obj) {
        Preconditions.E(map);
        try {
            return map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return null;
        }
    }

    static boolean r(Map<?, ?> map, @CheckForNull Object obj) {
        return Iterators.q(P0(map.entrySet().iterator()), obj);
    }

    @GwtIncompatible
    public static <K extends Comparable<? super K>, V> NavigableMap<K, V> r0(NavigableMap<K, V> navigableMap, Range<K> range) {
        boolean z = false;
        if (navigableMap.comparator() != null && navigableMap.comparator() != Ordering.z() && range.q() && range.r()) {
            Preconditions.e(navigableMap.comparator().compare(range.y(), range.L()) <= 0, "map is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.q() && range.r()) {
            K y = range.y();
            BoundType x = range.x();
            BoundType boundType = BoundType.CLOSED;
            boolean z2 = x == boundType;
            K L = range.L();
            if (range.K() == boundType) {
                z = true;
            }
            return navigableMap.subMap(y, z2, L, z);
        } else if (range.q()) {
            K y2 = range.y();
            if (range.x() == BoundType.CLOSED) {
                z = true;
            }
            return navigableMap.tailMap(y2, z);
        } else if (!range.r()) {
            return (NavigableMap) Preconditions.E(navigableMap);
        } else {
            K L2 = range.L();
            if (range.K() == BoundType.CLOSED) {
                z = true;
            }
            return navigableMap.headMap(L2, z);
        }
    }

    public static <K, V> MapDifference<K, V> s(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2) {
        return map instanceof SortedMap ? u((SortedMap) map, map2) : t(map, map2, Equivalence.c());
    }

    public static <K, V> BiMap<K, V> s0(BiMap<K, V> biMap) {
        return Synchronized.g(biMap, (Object) null);
    }

    public static <K, V> MapDifference<K, V> t(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence) {
        Preconditions.E(equivalence);
        LinkedHashMap c0 = c0();
        LinkedHashMap linkedHashMap = new LinkedHashMap(map2);
        LinkedHashMap c02 = c0();
        LinkedHashMap c03 = c0();
        v(map, map2, equivalence, c0, linkedHashMap, c02, c03);
        return new MapDifferenceImpl(c0, linkedHashMap, c02, c03);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> t0(NavigableMap<K, V> navigableMap) {
        return Synchronized.o(navigableMap);
    }

    public static <K, V> SortedMapDifference<K, V> u(SortedMap<K, ? extends V> sortedMap, Map<? extends K, ? extends V> map) {
        Preconditions.E(sortedMap);
        Preconditions.E(map);
        Comparator<? super E> i0 = i0(sortedMap.comparator());
        TreeMap<K, V> g0 = g0(i0);
        TreeMap<K, V> g02 = g0(i0);
        g02.putAll(map);
        TreeMap<K, V> g03 = g0(i0);
        TreeMap<K, V> g04 = g0(i0);
        v(sortedMap, map, Equivalence.c(), g0, g02, g03, g04);
        return new SortedMapDifferenceImpl(g0, g02, g03, g04);
    }

    public static <K, V> ImmutableMap<K, V> u0(Iterable<K> iterable, Function<? super K, V> function) {
        return v0(iterable.iterator(), function);
    }

    private static <K, V> void v(Map<? extends K, ? extends V> map, Map<? extends K, ? extends V> map2, Equivalence<? super V> equivalence, Map<K, V> map3, Map<K, V> map4, Map<K, V> map5, Map<K, MapDifference.ValueDifference<V>> map6) {
        for (Map.Entry next : map.entrySet()) {
            Object key = next.getKey();
            Object value = next.getValue();
            if (map2.containsKey(key)) {
                Object a2 = NullnessCasts.a(map4.remove(key));
                if (equivalence.d(value, a2)) {
                    map5.put(key, value);
                } else {
                    map6.put(key, ValueDifferenceImpl.c(value, a2));
                }
            } else {
                map3.put(key, value);
            }
        }
    }

    public static <K, V> ImmutableMap<K, V> v0(Iterator<K> it2, Function<? super K, V> function) {
        Preconditions.E(function);
        ImmutableMap.Builder b2 = ImmutableMap.b();
        while (it2.hasNext()) {
            K next = it2.next();
            b2.i(next, function.apply(next));
        }
        return b2.c();
    }

    static boolean w(Map<?, ?> map, @CheckForNull Object obj) {
        if (map == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return map.entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    static String w0(Map<?, ?> map) {
        StringBuilder f2 = Collections2.f(map.size());
        f2.append(ASCIIPropertyListParser.f18652j);
        boolean z = true;
        for (Map.Entry next : map.entrySet()) {
            if (!z) {
                f2.append(", ");
            }
            f2.append(next.getKey());
            f2.append(ASCIIPropertyListParser.f18654l);
            f2.append(next.getValue());
            z = false;
        }
        f2.append(ASCIIPropertyListParser.f18653k);
        return f2.toString();
    }

    public static <K, V> BiMap<K, V> x(BiMap<K, V> biMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.E(biMap);
        Preconditions.E(predicate);
        return biMap instanceof FilteredEntryBiMap ? B((FilteredEntryBiMap) biMap, predicate) : new FilteredEntryBiMap(biMap, predicate);
    }

    public static <K, V1, V2> Map<K, V2> x0(Map<K, V1> map, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new TransformedEntriesMap(map, entryTransformer);
    }

    public static <K, V> Map<K, V> y(Map<K, V> map, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.E(predicate);
        return map instanceof AbstractFilteredMap ? C((AbstractFilteredMap) map, predicate) : new FilteredEntryMap((Map) Preconditions.E(map), predicate);
    }

    @GwtIncompatible
    public static <K, V1, V2> NavigableMap<K, V2> y0(NavigableMap<K, V1> navigableMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new TransformedEntriesNavigableMap(navigableMap, entryTransformer);
    }

    @GwtIncompatible
    public static <K, V> NavigableMap<K, V> z(NavigableMap<K, V> navigableMap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.E(predicate);
        return navigableMap instanceof FilteredEntryNavigableMap ? D((FilteredEntryNavigableMap) navigableMap, predicate) : new FilteredEntryNavigableMap((NavigableMap) Preconditions.E(navigableMap), predicate);
    }

    public static <K, V1, V2> SortedMap<K, V2> z0(SortedMap<K, V1> sortedMap, EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new TransformedEntriesSortedMap(sortedMap, entryTransformer);
    }
}
