package com.google.common.collect;

import WrappedCollection.WrappedIterator;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractMapBasedMultimap<K, V> extends AbstractMultimap<K, V> implements Serializable {
    private static final long a3 = 2447537837011683357L;
    /* access modifiers changed from: private */
    public transient Map<K, Collection<V>> Y2;
    private transient int Z2;

    private class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
        final transient Map<K, Collection<V>> Z;

        class AsMapEntries extends Maps.EntrySet<K, Collection<V>> {
            AsMapEntries() {
            }

            public boolean contains(@CheckForNull Object obj) {
                return Collections2.j(AsMap.this.Z.entrySet(), obj);
            }

            /* access modifiers changed from: package-private */
            public Map<K, Collection<V>> h() {
                return AsMap.this;
            }

            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return new AsMapIterator();
            }

            public boolean remove(@CheckForNull Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AbstractMapBasedMultimap.this.B(entry.getKey());
                return true;
            }
        }

        class AsMapIterator implements Iterator<Map.Entry<K, Collection<V>>> {
            @CheckForNull
            Collection<V> X;
            final Iterator<Map.Entry<K, Collection<V>>> s;

            AsMapIterator() {
                this.s = AsMap.this.Z.entrySet().iterator();
            }

            /* renamed from: a */
            public Map.Entry<K, Collection<V>> next() {
                Map.Entry next = this.s.next();
                this.X = (Collection) next.getValue();
                return AsMap.this.f(next);
            }

            public boolean hasNext() {
                return this.s.hasNext();
            }

            public void remove() {
                Preconditions.h0(this.X != null, "no calls to next() since the last call to remove()");
                this.s.remove();
                AbstractMapBasedMultimap.r(AbstractMapBasedMultimap.this, this.X.size());
                this.X.clear();
                this.X = null;
            }
        }

        AsMap(Map<K, Collection<V>> map) {
            this.Z = map;
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new AsMapEntries();
        }

        public void clear() {
            if (this.Z == AbstractMapBasedMultimap.this.Y2) {
                AbstractMapBasedMultimap.this.clear();
            } else {
                Iterators.h(new AsMapIterator());
            }
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return Maps.o0(this.Z, obj);
        }

        @CheckForNull
        /* renamed from: d */
        public Collection<V> get(@CheckForNull Object obj) {
            Collection collection = (Collection) Maps.p0(this.Z, obj);
            if (collection == null) {
                return null;
            }
            return AbstractMapBasedMultimap.this.E(obj, collection);
        }

        @CheckForNull
        /* renamed from: e */
        public Collection<V> remove(@CheckForNull Object obj) {
            Collection remove = this.Z.remove(obj);
            if (remove == null) {
                return null;
            }
            Collection<V> u = AbstractMapBasedMultimap.this.u();
            u.addAll(remove);
            AbstractMapBasedMultimap.r(AbstractMapBasedMultimap.this, remove.size());
            remove.clear();
            return u;
        }

        public boolean equals(@CheckForNull Object obj) {
            return this == obj || this.Z.equals(obj);
        }

        /* access modifiers changed from: package-private */
        public Map.Entry<K, Collection<V>> f(Map.Entry<K, Collection<V>> entry) {
            K key = entry.getKey();
            return Maps.O(key, AbstractMapBasedMultimap.this.E(key, entry.getValue()));
        }

        public int hashCode() {
            return this.Z.hashCode();
        }

        public Set<K> keySet() {
            return AbstractMapBasedMultimap.this.keySet();
        }

        public int size() {
            return this.Z.size();
        }

        public String toString() {
            return this.Z.toString();
        }
    }

    private abstract class Itr<T> implements Iterator<T> {
        @CheckForNull
        K X = null;
        @CheckForNull
        Collection<V> Y = null;
        Iterator<V> Z = Iterators.w();
        final Iterator<Map.Entry<K, Collection<V>>> s;

        Itr() {
            this.s = AbstractMapBasedMultimap.this.Y2.entrySet().iterator();
        }

        /* access modifiers changed from: package-private */
        public abstract T a(@ParametricNullness K k2, @ParametricNullness V v);

        public boolean hasNext() {
            return this.s.hasNext() || this.Z.hasNext();
        }

        @ParametricNullness
        public T next() {
            if (!this.Z.hasNext()) {
                Map.Entry next = this.s.next();
                this.X = next.getKey();
                Collection<V> collection = (Collection) next.getValue();
                this.Y = collection;
                this.Z = collection.iterator();
            }
            return a(NullnessCasts.a(this.X), this.Z.next());
        }

        public void remove() {
            this.Z.remove();
            Collection<V> collection = this.Y;
            Objects.requireNonNull(collection);
            if (collection.isEmpty()) {
                this.s.remove();
            }
            AbstractMapBasedMultimap.p(AbstractMapBasedMultimap.this);
        }
    }

    private class KeySet extends Maps.KeySet<K, Collection<V>> {
        KeySet(Map<K, Collection<V>> map) {
            super(map);
        }

        public void clear() {
            Iterators.h(iterator());
        }

        public boolean containsAll(Collection<?> collection) {
            return h().keySet().containsAll(collection);
        }

        public boolean equals(@CheckForNull Object obj) {
            return this == obj || h().keySet().equals(obj);
        }

        public int hashCode() {
            return h().keySet().hashCode();
        }

        public Iterator<K> iterator() {
            final Iterator it2 = h().entrySet().iterator();
            return new Iterator<K>() {
                @CheckForNull
                Map.Entry<K, Collection<V>> s;

                public boolean hasNext() {
                    return it2.hasNext();
                }

                @ParametricNullness
                public K next() {
                    Map.Entry<K, Collection<V>> entry = (Map.Entry) it2.next();
                    this.s = entry;
                    return entry.getKey();
                }

                public void remove() {
                    Preconditions.h0(this.s != null, "no calls to next() since the last call to remove()");
                    Collection value = this.s.getValue();
                    it2.remove();
                    AbstractMapBasedMultimap.r(AbstractMapBasedMultimap.this, value.size());
                    value.clear();
                    this.s = null;
                }
            };
        }

        public boolean remove(@CheckForNull Object obj) {
            int i2;
            Collection collection = (Collection) h().remove(obj);
            if (collection != null) {
                i2 = collection.size();
                collection.clear();
                AbstractMapBasedMultimap.r(AbstractMapBasedMultimap.this, i2);
            } else {
                i2 = 0;
            }
            return i2 > 0;
        }
    }

    class NavigableAsMap extends AbstractMapBasedMultimap<K, V>.SortedAsMap implements NavigableMap<K, Collection<V>> {
        NavigableAsMap(NavigableMap<K, Collection<V>> navigableMap) {
            super(navigableMap);
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> ceilingEntry(@ParametricNullness K k2) {
            Map.Entry ceilingEntry = i().ceilingEntry(k2);
            if (ceilingEntry == null) {
                return null;
            }
            return f(ceilingEntry);
        }

        @CheckForNull
        public K ceilingKey(@ParametricNullness K k2) {
            return i().ceilingKey(k2);
        }

        public NavigableSet<K> descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        public NavigableMap<K, Collection<V>> descendingMap() {
            return new NavigableAsMap(i().descendingMap());
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> firstEntry() {
            Map.Entry firstEntry = i().firstEntry();
            if (firstEntry == null) {
                return null;
            }
            return f(firstEntry);
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> floorEntry(@ParametricNullness K k2) {
            Map.Entry floorEntry = i().floorEntry(k2);
            if (floorEntry == null) {
                return null;
            }
            return f(floorEntry);
        }

        @CheckForNull
        public K floorKey(@ParametricNullness K k2) {
            return i().floorKey(k2);
        }

        public NavigableMap<K, Collection<V>> headMap(@ParametricNullness K k2, boolean z) {
            return new NavigableAsMap(i().headMap(k2, z));
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> higherEntry(@ParametricNullness K k2) {
            Map.Entry higherEntry = i().higherEntry(k2);
            if (higherEntry == null) {
                return null;
            }
            return f(higherEntry);
        }

        @CheckForNull
        public K higherKey(@ParametricNullness K k2) {
            return i().higherKey(k2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: j */
        public NavigableSet<K> g() {
            return new NavigableKeySet(i());
        }

        /* renamed from: k */
        public NavigableMap<K, Collection<V>> headMap(@ParametricNullness K k2) {
            return headMap(k2, false);
        }

        /* renamed from: l */
        public NavigableSet<K> keySet() {
            return (NavigableSet) super.keySet();
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> lastEntry() {
            Map.Entry lastEntry = i().lastEntry();
            if (lastEntry == null) {
                return null;
            }
            return f(lastEntry);
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> lowerEntry(@ParametricNullness K k2) {
            Map.Entry lowerEntry = i().lowerEntry(k2);
            if (lowerEntry == null) {
                return null;
            }
            return f(lowerEntry);
        }

        @CheckForNull
        public K lowerKey(@ParametricNullness K k2) {
            return i().lowerKey(k2);
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public Map.Entry<K, Collection<V>> m(Iterator<Map.Entry<K, Collection<V>>> it2) {
            if (!it2.hasNext()) {
                return null;
            }
            Map.Entry next = it2.next();
            Collection u = AbstractMapBasedMultimap.this.u();
            u.addAll((Collection) next.getValue());
            it2.remove();
            return Maps.O(next.getKey(), AbstractMapBasedMultimap.this.D(u));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: n */
        public NavigableMap<K, Collection<V>> i() {
            return (NavigableMap) super.i();
        }

        public NavigableSet<K> navigableKeySet() {
            return keySet();
        }

        /* renamed from: o */
        public NavigableMap<K, Collection<V>> subMap(@ParametricNullness K k2, @ParametricNullness K k3) {
            return subMap(k2, true, k3, false);
        }

        /* renamed from: p */
        public NavigableMap<K, Collection<V>> tailMap(@ParametricNullness K k2) {
            return tailMap(k2, true);
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> pollFirstEntry() {
            return m(entrySet().iterator());
        }

        @CheckForNull
        public Map.Entry<K, Collection<V>> pollLastEntry() {
            return m(descendingMap().entrySet().iterator());
        }

        public NavigableMap<K, Collection<V>> subMap(@ParametricNullness K k2, boolean z, @ParametricNullness K k3, boolean z2) {
            return new NavigableAsMap(i().subMap(k2, z, k3, z2));
        }

        public NavigableMap<K, Collection<V>> tailMap(@ParametricNullness K k2, boolean z) {
            return new NavigableAsMap(i().tailMap(k2, z));
        }
    }

    class NavigableKeySet extends AbstractMapBasedMultimap<K, V>.SortedKeySet implements NavigableSet<K> {
        NavigableKeySet(NavigableMap<K, Collection<V>> navigableMap) {
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
            return new NavigableKeySet(j().descendingMap());
        }

        @CheckForNull
        public K floor(@ParametricNullness K k2) {
            return j().floorKey(k2);
        }

        public NavigableSet<K> headSet(@ParametricNullness K k2, boolean z) {
            return new NavigableKeySet(j().headMap(k2, z));
        }

        @CheckForNull
        public K higher(@ParametricNullness K k2) {
            return j().higherKey(k2);
        }

        /* renamed from: k */
        public NavigableSet<K> headSet(@ParametricNullness K k2) {
            return headSet(k2, false);
        }

        @CheckForNull
        public K lower(@ParametricNullness K k2) {
            return j().lowerKey(k2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public NavigableMap<K, Collection<V>> j() {
            return (NavigableMap) super.j();
        }

        /* renamed from: n */
        public NavigableSet<K> subSet(@ParametricNullness K k2, @ParametricNullness K k3) {
            return subSet(k2, true, k3, false);
        }

        /* renamed from: o */
        public NavigableSet<K> tailSet(@ParametricNullness K k2) {
            return tailSet(k2, true);
        }

        @CheckForNull
        public K pollFirst() {
            return Iterators.U(iterator());
        }

        @CheckForNull
        public K pollLast() {
            return Iterators.U(descendingIterator());
        }

        public NavigableSet<K> subSet(@ParametricNullness K k2, boolean z, @ParametricNullness K k3, boolean z2) {
            return new NavigableKeySet(j().subMap(k2, z, k3, z2));
        }

        public NavigableSet<K> tailSet(@ParametricNullness K k2, boolean z) {
            return new NavigableKeySet(j().tailMap(k2, z));
        }
    }

    private class RandomAccessWrappedList extends AbstractMapBasedMultimap<K, V>.WrappedList implements RandomAccess {
        RandomAccessWrappedList(@ParametricNullness AbstractMapBasedMultimap abstractMapBasedMultimap, K k2, @CheckForNull List<V> list, AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k2, list, wrappedCollection);
        }
    }

    private class SortedAsMap extends AbstractMapBasedMultimap<K, V>.AsMap implements SortedMap<K, Collection<V>> {
        @CheckForNull
        SortedSet<K> Y2;

        SortedAsMap(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return i().comparator();
        }

        @ParametricNullness
        public K firstKey() {
            return i().firstKey();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: g */
        public SortedSet<K> b() {
            return new SortedKeySet(i());
        }

        /* renamed from: h */
        public SortedSet<K> keySet() {
            SortedSet<K> sortedSet = this.Y2;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet<K> g2 = b();
            this.Y2 = g2;
            return g2;
        }

        public SortedMap<K, Collection<V>> headMap(@ParametricNullness K k2) {
            return new SortedAsMap(i().headMap(k2));
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, Collection<V>> i() {
            return (SortedMap) this.Z;
        }

        @ParametricNullness
        public K lastKey() {
            return i().lastKey();
        }

        public SortedMap<K, Collection<V>> subMap(@ParametricNullness K k2, @ParametricNullness K k3) {
            return new SortedAsMap(i().subMap(k2, k3));
        }

        public SortedMap<K, Collection<V>> tailMap(@ParametricNullness K k2) {
            return new SortedAsMap(i().tailMap(k2));
        }
    }

    private class SortedKeySet extends AbstractMapBasedMultimap<K, V>.KeySet implements SortedSet<K> {
        SortedKeySet(SortedMap<K, Collection<V>> sortedMap) {
            super(sortedMap);
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            return j().comparator();
        }

        @ParametricNullness
        public K first() {
            return j().firstKey();
        }

        public SortedSet<K> headSet(@ParametricNullness K k2) {
            return new SortedKeySet(j().headMap(k2));
        }

        /* access modifiers changed from: package-private */
        public SortedMap<K, Collection<V>> j() {
            return (SortedMap) super.h();
        }

        @ParametricNullness
        public K last() {
            return j().lastKey();
        }

        public SortedSet<K> subSet(@ParametricNullness K k2, @ParametricNullness K k3) {
            return new SortedKeySet(j().subMap(k2, k3));
        }

        public SortedSet<K> tailSet(@ParametricNullness K k2) {
            return new SortedKeySet(j().tailMap(k2));
        }
    }

    class WrappedCollection extends AbstractCollection<V> {
        Collection<V> X;
        @CheckForNull
        final AbstractMapBasedMultimap<K, V>.WrappedCollection Y;
        @CheckForNull
        final Collection<V> Z;
        @ParametricNullness
        final K s;

        class WrappedIterator implements Iterator<V> {
            final Collection<V> X;
            final Iterator<V> s;

            WrappedIterator() {
                Collection<V> collection = WrappedCollection.this.X;
                this.X = collection;
                this.s = AbstractMapBasedMultimap.A(collection);
            }

            /* access modifiers changed from: package-private */
            public Iterator<V> a() {
                b();
                return this.s;
            }

            /* access modifiers changed from: package-private */
            public void b() {
                WrappedCollection.this.h();
                if (WrappedCollection.this.X != this.X) {
                    throw new ConcurrentModificationException();
                }
            }

            public boolean hasNext() {
                b();
                return this.s.hasNext();
            }

            @ParametricNullness
            public V next() {
                b();
                return this.s.next();
            }

            public void remove() {
                this.s.remove();
                AbstractMapBasedMultimap.p(AbstractMapBasedMultimap.this);
                WrappedCollection.this.j();
            }

            WrappedIterator(Iterator<V> it2) {
                this.X = WrappedCollection.this.X;
                this.s = it2;
            }
        }

        WrappedCollection(@ParametricNullness K k2, Collection<V> collection, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            this.s = k2;
            this.X = collection;
            this.Y = wrappedCollection;
            this.Z = wrappedCollection == null ? null : wrappedCollection.d();
        }

        public boolean add(@ParametricNullness V v) {
            h();
            boolean isEmpty = this.X.isEmpty();
            boolean add = this.X.add(v);
            if (add) {
                AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    b();
                }
            }
            return add;
        }

        public boolean addAll(Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = this.X.addAll(collection);
            if (addAll) {
                AbstractMapBasedMultimap.q(AbstractMapBasedMultimap.this, this.X.size() - size);
                if (size == 0) {
                    b();
                }
            }
            return addAll;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection = this.Y;
            if (wrappedCollection != null) {
                wrappedCollection.b();
            } else {
                AbstractMapBasedMultimap.this.Y2.put(this.s, this.X);
            }
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public AbstractMapBasedMultimap<K, V>.WrappedCollection c() {
            return this.Y;
        }

        public void clear() {
            int size = size();
            if (size != 0) {
                this.X.clear();
                AbstractMapBasedMultimap.r(AbstractMapBasedMultimap.this, size);
                j();
            }
        }

        public boolean contains(@CheckForNull Object obj) {
            h();
            return this.X.contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            h();
            return this.X.containsAll(collection);
        }

        /* access modifiers changed from: package-private */
        public Collection<V> d() {
            return this.X;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            h();
            return this.X.equals(obj);
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public K g() {
            return this.s;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            Collection<V> collection;
            AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection = this.Y;
            if (wrappedCollection != null) {
                wrappedCollection.h();
                if (this.Y.d() != this.Z) {
                    throw new ConcurrentModificationException();
                }
            } else if (this.X.isEmpty() && (collection = (Collection) AbstractMapBasedMultimap.this.Y2.get(this.s)) != null) {
                this.X = collection;
            }
        }

        public int hashCode() {
            h();
            return this.X.hashCode();
        }

        public Iterator<V> iterator() {
            h();
            return new WrappedIterator();
        }

        /* access modifiers changed from: package-private */
        public void j() {
            AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection = this.Y;
            if (wrappedCollection != null) {
                wrappedCollection.j();
            } else if (this.X.isEmpty()) {
                AbstractMapBasedMultimap.this.Y2.remove(this.s);
            }
        }

        public boolean remove(@CheckForNull Object obj) {
            h();
            boolean remove = this.X.remove(obj);
            if (remove) {
                AbstractMapBasedMultimap.p(AbstractMapBasedMultimap.this);
                j();
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean removeAll = this.X.removeAll(collection);
            if (removeAll) {
                AbstractMapBasedMultimap.q(AbstractMapBasedMultimap.this, this.X.size() - size);
                j();
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            Preconditions.E(collection);
            int size = size();
            boolean retainAll = this.X.retainAll(collection);
            if (retainAll) {
                AbstractMapBasedMultimap.q(AbstractMapBasedMultimap.this, this.X.size() - size);
                j();
            }
            return retainAll;
        }

        public int size() {
            h();
            return this.X.size();
        }

        public String toString() {
            h();
            return this.X.toString();
        }
    }

    class WrappedList extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements List<V> {

        private class WrappedListIterator extends AbstractMapBasedMultimap<K, V>.WrappedIterator implements ListIterator<V> {
            WrappedListIterator() {
                super();
            }

            /* JADX WARNING: type inference failed for: r1v0, types: [com.google.common.collect.AbstractMapBasedMultimap$WrappedList$WrappedListIterator, com.google.common.collect.AbstractMapBasedMultimap$WrappedCollection$WrappedIterator] */
            private ListIterator<V> c() {
                return (ListIterator) a();
            }

            public void add(@ParametricNullness V v) {
                boolean isEmpty = WrappedList.this.isEmpty();
                c().add(v);
                AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this);
                if (isEmpty) {
                    WrappedList.this.b();
                }
            }

            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            public int nextIndex() {
                return c().nextIndex();
            }

            @ParametricNullness
            public V previous() {
                return c().previous();
            }

            public int previousIndex() {
                return c().previousIndex();
            }

            public void set(@ParametricNullness V v) {
                c().set(v);
            }

            public WrappedListIterator(int i2) {
                super(WrappedList.this.k().listIterator(i2));
            }
        }

        WrappedList(@ParametricNullness K k2, List<V> list, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k2, list, wrappedCollection);
        }

        public void add(int i2, @ParametricNullness V v) {
            h();
            boolean isEmpty = d().isEmpty();
            k().add(i2, v);
            AbstractMapBasedMultimap.o(AbstractMapBasedMultimap.this);
            if (isEmpty) {
                b();
            }
        }

        public boolean addAll(int i2, Collection<? extends V> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean addAll = k().addAll(i2, collection);
            if (addAll) {
                AbstractMapBasedMultimap.q(AbstractMapBasedMultimap.this, d().size() - size);
                if (size == 0) {
                    b();
                }
            }
            return addAll;
        }

        @ParametricNullness
        public V get(int i2) {
            h();
            return k().get(i2);
        }

        public int indexOf(@CheckForNull Object obj) {
            h();
            return k().indexOf(obj);
        }

        /* access modifiers changed from: package-private */
        public List<V> k() {
            return (List) d();
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            h();
            return k().lastIndexOf(obj);
        }

        public ListIterator<V> listIterator() {
            h();
            return new WrappedListIterator();
        }

        @ParametricNullness
        public V remove(int i2) {
            h();
            V remove = k().remove(i2);
            AbstractMapBasedMultimap.p(AbstractMapBasedMultimap.this);
            j();
            return remove;
        }

        @ParametricNullness
        public V set(int i2, @ParametricNullness V v) {
            h();
            return k().set(i2, v);
        }

        public List<V> subList(int i2, int i3) {
            h();
            return AbstractMapBasedMultimap.this.F(g(), k().subList(i2, i3), c() == null ? this : c());
        }

        public ListIterator<V> listIterator(int i2) {
            h();
            return new WrappedListIterator(i2);
        }
    }

    class WrappedNavigableSet extends AbstractMapBasedMultimap<K, V>.WrappedSortedSet implements NavigableSet<V> {
        WrappedNavigableSet(@ParametricNullness K k2, NavigableSet<V> navigableSet, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k2, navigableSet, wrappedCollection);
        }

        private NavigableSet<V> n(NavigableSet<V> navigableSet) {
            return new WrappedNavigableSet(this.s, navigableSet, c() == null ? this : c());
        }

        @CheckForNull
        public V ceiling(@ParametricNullness V v) {
            return k().ceiling(v);
        }

        public Iterator<V> descendingIterator() {
            return new WrappedCollection.WrappedIterator(k().descendingIterator());
        }

        public NavigableSet<V> descendingSet() {
            return n(k().descendingSet());
        }

        @CheckForNull
        public V floor(@ParametricNullness V v) {
            return k().floor(v);
        }

        public NavigableSet<V> headSet(@ParametricNullness V v, boolean z) {
            return n(k().headSet(v, z));
        }

        @CheckForNull
        public V higher(@ParametricNullness V v) {
            return k().higher(v);
        }

        @CheckForNull
        public V lower(@ParametricNullness V v) {
            return k().lower(v);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: m */
        public NavigableSet<V> k() {
            return (NavigableSet) super.k();
        }

        @CheckForNull
        public V pollFirst() {
            return Iterators.U(iterator());
        }

        @CheckForNull
        public V pollLast() {
            return Iterators.U(descendingIterator());
        }

        public NavigableSet<V> subSet(@ParametricNullness V v, boolean z, @ParametricNullness V v2, boolean z2) {
            return n(k().subSet(v, z, v2, z2));
        }

        public NavigableSet<V> tailSet(@ParametricNullness V v, boolean z) {
            return n(k().tailSet(v, z));
        }
    }

    class WrappedSet extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements Set<V> {
        WrappedSet(@ParametricNullness K k2, Set<V> set) {
            super(k2, set, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null);
        }

        public boolean removeAll(Collection<?> collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean I = Sets.I((Set) this.X, collection);
            if (I) {
                AbstractMapBasedMultimap.q(AbstractMapBasedMultimap.this, this.X.size() - size);
                j();
            }
            return I;
        }
    }

    class WrappedSortedSet extends AbstractMapBasedMultimap<K, V>.WrappedCollection implements SortedSet<V> {
        WrappedSortedSet(@ParametricNullness K k2, SortedSet<V> sortedSet, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
            super(k2, sortedSet, wrappedCollection);
        }

        @CheckForNull
        public Comparator<? super V> comparator() {
            return k().comparator();
        }

        @ParametricNullness
        public V first() {
            h();
            return k().first();
        }

        public SortedSet<V> headSet(@ParametricNullness V v) {
            h();
            return new WrappedSortedSet(g(), k().headSet(v), c() == null ? this : c());
        }

        /* access modifiers changed from: package-private */
        public SortedSet<V> k() {
            return (SortedSet) d();
        }

        @ParametricNullness
        public V last() {
            h();
            return k().last();
        }

        public SortedSet<V> subSet(@ParametricNullness V v, @ParametricNullness V v2) {
            h();
            return new WrappedSortedSet(g(), k().subSet(v, v2), c() == null ? this : c());
        }

        public SortedSet<V> tailSet(@ParametricNullness V v) {
            h();
            return new WrappedSortedSet(g(), k().tailSet(v), c() == null ? this : c());
        }
    }

    protected AbstractMapBasedMultimap(Map<K, Collection<V>> map) {
        Preconditions.d(map.isEmpty());
        this.Y2 = map;
    }

    /* access modifiers changed from: private */
    public static <E> Iterator<E> A(Collection<E> collection) {
        return collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    /* access modifiers changed from: private */
    public void B(@CheckForNull Object obj) {
        Collection collection = (Collection) Maps.q0(this.Y2, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.Z2 -= size;
        }
    }

    static /* synthetic */ int o(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.Z2;
        abstractMapBasedMultimap.Z2 = i2 + 1;
        return i2;
    }

    static /* synthetic */ int p(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        int i2 = abstractMapBasedMultimap.Z2;
        abstractMapBasedMultimap.Z2 = i2 - 1;
        return i2;
    }

    static /* synthetic */ int q(AbstractMapBasedMultimap abstractMapBasedMultimap, int i2) {
        int i3 = abstractMapBasedMultimap.Z2 + i2;
        abstractMapBasedMultimap.Z2 = i3;
        return i3;
    }

    static /* synthetic */ int r(AbstractMapBasedMultimap abstractMapBasedMultimap, int i2) {
        int i3 = abstractMapBasedMultimap.Z2 - i2;
        abstractMapBasedMultimap.Z2 = i3;
        return i3;
    }

    private Collection<V> z(@ParametricNullness K k2) {
        Collection<V> collection = this.Y2.get(k2);
        if (collection != null) {
            return collection;
        }
        Collection<V> v = v(k2);
        this.Y2.put(k2, v);
        return v;
    }

    /* access modifiers changed from: package-private */
    public final void C(Map<K, Collection<V>> map) {
        this.Y2 = map;
        this.Z2 = 0;
        for (Collection next : map.values()) {
            Preconditions.d(!next.isEmpty());
            this.Z2 += next.size();
        }
    }

    /* access modifiers changed from: package-private */
    public <E> Collection<E> D(Collection<E> collection) {
        return Collections.unmodifiableCollection(collection);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> E(@ParametricNullness K k2, Collection<V> collection) {
        return new WrappedCollection(k2, collection, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null);
    }

    /* access modifiers changed from: package-private */
    public final List<V> F(@ParametricNullness K k2, List<V> list, @CheckForNull AbstractMapBasedMultimap<K, V>.WrappedCollection wrappedCollection) {
        return list instanceof RandomAccess ? new RandomAccessWrappedList(this, k2, list, wrappedCollection) : new WrappedList(k2, list, wrappedCollection);
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> a() {
        return new AsMap(this.Y2);
    }

    public Collection<V> b(@CheckForNull Object obj) {
        Collection remove = this.Y2.remove(obj);
        if (remove == null) {
            return y();
        }
        Collection u = u();
        u.addAll(remove);
        this.Z2 -= remove.size();
        remove.clear();
        return D(u);
    }

    public Collection<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        Iterator<? extends V> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return b(k2);
        }
        Collection z = z(k2);
        Collection u = u();
        u.addAll(z);
        this.Z2 -= z.size();
        z.clear();
        while (it2.hasNext()) {
            if (z.add(it2.next())) {
                this.Z2++;
            }
        }
        return D(u);
    }

    public void clear() {
        for (Collection<V> clear : this.Y2.values()) {
            clear.clear();
        }
        this.Y2.clear();
        this.Z2 = 0;
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return this.Y2.containsKey(obj);
    }

    /* access modifiers changed from: package-private */
    public Collection<Map.Entry<K, V>> d() {
        return this instanceof SetMultimap ? new AbstractMultimap.EntrySet(this) : new AbstractMultimap.Entries();
    }

    /* access modifiers changed from: package-private */
    public Set<K> e() {
        return new KeySet(this.Y2);
    }

    /* access modifiers changed from: package-private */
    public Multiset<K> f() {
        return new Multimaps.Keys(this);
    }

    public Collection<V> get(@ParametricNullness K k2) {
        Collection collection = this.Y2.get(k2);
        if (collection == null) {
            collection = v(k2);
        }
        return E(k2, collection);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> h() {
        return new AbstractMultimap.Values();
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> i() {
        return new AbstractMapBasedMultimap<K, V>.Itr<Map.Entry<K, V>>(this) {
            /* access modifiers changed from: package-private */
            /* renamed from: b */
            public Map.Entry<K, V> a(@ParametricNullness K k2, @ParametricNullness V v) {
                return Maps.O(k2, v);
            }
        };
    }

    public Collection<Map.Entry<K, V>> j() {
        return super.j();
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> l() {
        return new AbstractMapBasedMultimap<K, V>.Itr<V>(this) {
            /* access modifiers changed from: package-private */
            @ParametricNullness
            public V a(@ParametricNullness K k2, @ParametricNullness V v) {
                return v;
            }
        };
    }

    public boolean put(@ParametricNullness K k2, @ParametricNullness V v) {
        Collection collection = this.Y2.get(k2);
        if (collection == null) {
            Collection v2 = v(k2);
            if (v2.add(v)) {
                this.Z2++;
                this.Y2.put(k2, v2);
                return true;
            }
            throw new AssertionError("New Collection violated the Collection spec");
        } else if (!collection.add(v)) {
            return false;
        } else {
            this.Z2++;
            return true;
        }
    }

    public int size() {
        return this.Z2;
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> t() {
        return this.Y2;
    }

    /* access modifiers changed from: package-private */
    public abstract Collection<V> u();

    /* access modifiers changed from: package-private */
    public Collection<V> v(@ParametricNullness K k2) {
        return u();
    }

    public Collection<V> values() {
        return super.values();
    }

    /* access modifiers changed from: package-private */
    public final Map<K, Collection<V>> w() {
        Map<K, Collection<V>> map = this.Y2;
        if (map instanceof NavigableMap) {
            return new NavigableAsMap((NavigableMap) this.Y2);
        }
        return map instanceof SortedMap ? new SortedAsMap((SortedMap) this.Y2) : new AsMap(this.Y2);
    }

    /* access modifiers changed from: package-private */
    public final Set<K> x() {
        Map<K, Collection<V>> map = this.Y2;
        if (map instanceof NavigableMap) {
            return new NavigableKeySet((NavigableMap) this.Y2);
        }
        return map instanceof SortedMap ? new SortedKeySet((SortedMap) this.Y2) : new KeySet(this.Y2);
    }

    /* access modifiers changed from: package-private */
    public Collection<V> y() {
        return D(u());
    }
}
