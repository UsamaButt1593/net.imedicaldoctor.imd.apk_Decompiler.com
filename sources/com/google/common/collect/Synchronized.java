package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Table;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class Synchronized {

    private static class SynchronizedAsMap<K, V> extends SynchronizedMap<K, Collection<V>> {
        private static final long c3 = 0;
        @CheckForNull
        transient Set<Map.Entry<K, Collection<V>>> a3;
        @CheckForNull
        transient Collection<Collection<V>> b3;

        SynchronizedAsMap(Map<K, Collection<V>> map, @CheckForNull Object obj) {
            super(map, obj);
        }

        public boolean containsValue(@CheckForNull Object obj) {
            return values().contains(obj);
        }

        public Set<Map.Entry<K, Collection<V>>> entrySet() {
            Set<Map.Entry<K, Collection<V>>> set;
            synchronized (this.X) {
                try {
                    if (this.a3 == null) {
                        this.a3 = new SynchronizedAsMapEntries(d().entrySet(), this.X);
                    }
                    set = this.a3;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        public Collection<Collection<V>> values() {
            Collection<Collection<V>> collection;
            synchronized (this.X) {
                try {
                    if (this.b3 == null) {
                        this.b3 = new SynchronizedAsMapValues(d().values(), this.X);
                    }
                    collection = this.b3;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        @CheckForNull
        public Collection<V> get(@CheckForNull Object obj) {
            Collection<V> d2;
            synchronized (this.X) {
                Collection collection = (Collection) super.get(obj);
                d2 = collection == null ? null : Synchronized.A(collection, this.X);
            }
            return d2;
        }
    }

    private static class SynchronizedAsMapEntries<K, V> extends SynchronizedSet<Map.Entry<K, Collection<V>>> {
        private static final long Y2 = 0;

        SynchronizedAsMapEntries(Set<Map.Entry<K, Collection<V>>> set, @CheckForNull Object obj) {
            super(set, obj);
        }

        public boolean contains(@CheckForNull Object obj) {
            boolean p;
            synchronized (this.X) {
                p = Maps.p(o(), obj);
            }
            return p;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean b2;
            synchronized (this.X) {
                b2 = Collections2.b(o(), collection);
            }
            return b2;
        }

        public boolean equals(@CheckForNull Object obj) {
            boolean g2;
            if (obj == this) {
                return true;
            }
            synchronized (this.X) {
                g2 = Sets.g(o(), obj);
            }
            return g2;
        }

        public Iterator<Map.Entry<K, Collection<V>>> iterator() {
            return new TransformedIterator<Map.Entry<K, Collection<V>>, Map.Entry<K, Collection<V>>>(super.iterator()) {
                /* access modifiers changed from: package-private */
                /* renamed from: b */
                public Map.Entry<K, Collection<V>> a(final Map.Entry<K, Collection<V>> entry) {
                    return new ForwardingMapEntry<K, Collection<V>>() {
                        /* access modifiers changed from: protected */
                        /* renamed from: a1 */
                        public Map.Entry<K, Collection<V>> Z0() {
                            return entry;
                        }

                        /* renamed from: n1 */
                        public Collection<V> getValue() {
                            return Synchronized.A((Collection) entry.getValue(), SynchronizedAsMapEntries.this.X);
                        }
                    };
                }
            };
        }

        public boolean remove(@CheckForNull Object obj) {
            boolean k0;
            synchronized (this.X) {
                k0 = Maps.k0(o(), obj);
            }
            return k0;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean V;
            synchronized (this.X) {
                V = Iterators.V(o().iterator(), collection);
            }
            return V;
        }

        public boolean retainAll(Collection<?> collection) {
            boolean X;
            synchronized (this.X) {
                X = Iterators.X(o().iterator(), collection);
            }
            return X;
        }

        public Object[] toArray() {
            Object[] l2;
            synchronized (this.X) {
                l2 = ObjectArrays.l(o());
            }
            return l2;
        }

        public <T> T[] toArray(T[] tArr) {
            T[] m2;
            synchronized (this.X) {
                m2 = ObjectArrays.m(o(), tArr);
            }
            return m2;
        }
    }

    private static class SynchronizedAsMapValues<V> extends SynchronizedCollection<Collection<V>> {
        private static final long X2 = 0;

        SynchronizedAsMapValues(Collection<Collection<V>> collection, @CheckForNull Object obj) {
            super(collection, obj);
        }

        public Iterator<Collection<V>> iterator() {
            return new TransformedIterator<Collection<V>, Collection<V>>(super.iterator()) {
                /* access modifiers changed from: package-private */
                /* renamed from: b */
                public Collection<V> a(Collection<V> collection) {
                    return Synchronized.A(collection, SynchronizedAsMapValues.this.X);
                }
            };
        }
    }

    @VisibleForTesting
    static class SynchronizedBiMap<K, V> extends SynchronizedMap<K, V> implements BiMap<K, V>, Serializable {
        private static final long c3 = 0;
        @CheckForNull
        private transient Set<V> a3;
        @RetainedWith
        @CheckForNull
        private transient BiMap<V, K> b3;

        private SynchronizedBiMap(BiMap<K, V> biMap, @CheckForNull Object obj, @CheckForNull BiMap<V, K> biMap2) {
            super(biMap, obj);
            this.b3 = biMap2;
        }

        @CheckForNull
        public V k0(@ParametricNullness K k2, @ParametricNullness V v) {
            V k0;
            synchronized (this.X) {
                k0 = o().k0(k2, v);
            }
            return k0;
        }

        public BiMap<V, K> q2() {
            BiMap<V, K> biMap;
            synchronized (this.X) {
                try {
                    if (this.b3 == null) {
                        this.b3 = new SynchronizedBiMap(o().q2(), this.X, this);
                    }
                    biMap = this.b3;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return biMap;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public BiMap<K, V> o() {
            return (BiMap) super.d();
        }

        public Set<V> values() {
            Set<V> set;
            synchronized (this.X) {
                try {
                    if (this.a3 == null) {
                        this.a3 = Synchronized.u(o().values(), this.X);
                    }
                    set = this.a3;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }
    }

    @VisibleForTesting
    static class SynchronizedCollection<E> extends SynchronizedObject implements Collection<E> {
        private static final long Z = 0;

        private SynchronizedCollection(Collection<E> collection, @CheckForNull Object obj) {
            super(collection, obj);
        }

        public boolean add(E e2) {
            boolean add;
            synchronized (this.X) {
                add = d().add(e2);
            }
            return add;
        }

        public boolean addAll(Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.X) {
                addAll = d().addAll(collection);
            }
            return addAll;
        }

        public void clear() {
            synchronized (this.X) {
                d().clear();
            }
        }

        public boolean contains(@CheckForNull Object obj) {
            boolean contains;
            synchronized (this.X) {
                contains = d().contains(obj);
            }
            return contains;
        }

        public boolean containsAll(Collection<?> collection) {
            boolean containsAll;
            synchronized (this.X) {
                containsAll = d().containsAll(collection);
            }
            return containsAll;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.X) {
                isEmpty = d().isEmpty();
            }
            return isEmpty;
        }

        public Iterator<E> iterator() {
            return d().iterator();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public Collection<E> d() {
            return (Collection) super.d();
        }

        public boolean remove(@CheckForNull Object obj) {
            boolean remove;
            synchronized (this.X) {
                remove = d().remove(obj);
            }
            return remove;
        }

        public boolean removeAll(Collection<?> collection) {
            boolean removeAll;
            synchronized (this.X) {
                removeAll = d().removeAll(collection);
            }
            return removeAll;
        }

        public boolean retainAll(Collection<?> collection) {
            boolean retainAll;
            synchronized (this.X) {
                retainAll = d().retainAll(collection);
            }
            return retainAll;
        }

        public int size() {
            int size;
            synchronized (this.X) {
                size = d().size();
            }
            return size;
        }

        public Object[] toArray() {
            Object[] array;
            synchronized (this.X) {
                array = d().toArray();
            }
            return array;
        }

        public <T> T[] toArray(T[] tArr) {
            T[] array;
            synchronized (this.X) {
                array = d().toArray(tArr);
            }
            return array;
        }
    }

    private static final class SynchronizedDeque<E> extends SynchronizedQueue<E> implements Deque<E> {
        private static final long Y2 = 0;

        SynchronizedDeque(Deque<E> deque, @CheckForNull Object obj) {
            super(deque, obj);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: B */
        public Deque<E> t() {
            return (Deque) super.o();
        }

        public void addFirst(E e2) {
            synchronized (this.X) {
                t().addFirst(e2);
            }
        }

        public void addLast(E e2) {
            synchronized (this.X) {
                t().addLast(e2);
            }
        }

        public Iterator<E> descendingIterator() {
            Iterator<E> descendingIterator;
            synchronized (this.X) {
                descendingIterator = t().descendingIterator();
            }
            return descendingIterator;
        }

        public E getFirst() {
            E first;
            synchronized (this.X) {
                first = t().getFirst();
            }
            return first;
        }

        public E getLast() {
            E last;
            synchronized (this.X) {
                last = t().getLast();
            }
            return last;
        }

        public boolean offerFirst(E e2) {
            boolean offerFirst;
            synchronized (this.X) {
                offerFirst = t().offerFirst(e2);
            }
            return offerFirst;
        }

        public boolean offerLast(E e2) {
            boolean offerLast;
            synchronized (this.X) {
                offerLast = t().offerLast(e2);
            }
            return offerLast;
        }

        @CheckForNull
        public E peekFirst() {
            E peekFirst;
            synchronized (this.X) {
                peekFirst = t().peekFirst();
            }
            return peekFirst;
        }

        @CheckForNull
        public E peekLast() {
            E peekLast;
            synchronized (this.X) {
                peekLast = t().peekLast();
            }
            return peekLast;
        }

        @CheckForNull
        public E pollFirst() {
            E pollFirst;
            synchronized (this.X) {
                pollFirst = t().pollFirst();
            }
            return pollFirst;
        }

        @CheckForNull
        public E pollLast() {
            E pollLast;
            synchronized (this.X) {
                pollLast = t().pollLast();
            }
            return pollLast;
        }

        public E pop() {
            E pop;
            synchronized (this.X) {
                pop = t().pop();
            }
            return pop;
        }

        public void push(E e2) {
            synchronized (this.X) {
                t().push(e2);
            }
        }

        public E removeFirst() {
            E removeFirst;
            synchronized (this.X) {
                removeFirst = t().removeFirst();
            }
            return removeFirst;
        }

        public boolean removeFirstOccurrence(@CheckForNull Object obj) {
            boolean removeFirstOccurrence;
            synchronized (this.X) {
                removeFirstOccurrence = t().removeFirstOccurrence(obj);
            }
            return removeFirstOccurrence;
        }

        public E removeLast() {
            E removeLast;
            synchronized (this.X) {
                removeLast = t().removeLast();
            }
            return removeLast;
        }

        public boolean removeLastOccurrence(@CheckForNull Object obj) {
            boolean removeLastOccurrence;
            synchronized (this.X) {
                removeLastOccurrence = t().removeLastOccurrence(obj);
            }
            return removeLastOccurrence;
        }
    }

    @GwtIncompatible
    private static class SynchronizedEntry<K, V> extends SynchronizedObject implements Map.Entry<K, V> {
        private static final long Z = 0;

        SynchronizedEntry(Map.Entry<K, V> entry, @CheckForNull Object obj) {
            super(entry, obj);
        }

        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            synchronized (this.X) {
                equals = d().equals(obj);
            }
            return equals;
        }

        public K getKey() {
            K key;
            synchronized (this.X) {
                key = d().getKey();
            }
            return key;
        }

        public V getValue() {
            V value;
            synchronized (this.X) {
                value = d().getValue();
            }
            return value;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.X) {
                hashCode = d().hashCode();
            }
            return hashCode;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public Map.Entry<K, V> d() {
            return (Map.Entry) super.d();
        }

        public V setValue(V v) {
            V value;
            synchronized (this.X) {
                value = d().setValue(v);
            }
            return value;
        }
    }

    private static class SynchronizedList<E> extends SynchronizedCollection<E> implements List<E> {
        private static final long X2 = 0;

        SynchronizedList(List<E> list, @CheckForNull Object obj) {
            super(list, obj);
        }

        public void add(int i2, E e2) {
            synchronized (this.X) {
                o().add(i2, e2);
            }
        }

        public boolean addAll(int i2, Collection<? extends E> collection) {
            boolean addAll;
            synchronized (this.X) {
                addAll = o().addAll(i2, collection);
            }
            return addAll;
        }

        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.X) {
                equals = o().equals(obj);
            }
            return equals;
        }

        public E get(int i2) {
            E e2;
            synchronized (this.X) {
                e2 = o().get(i2);
            }
            return e2;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.X) {
                hashCode = o().hashCode();
            }
            return hashCode;
        }

        public int indexOf(@CheckForNull Object obj) {
            int indexOf;
            synchronized (this.X) {
                indexOf = o().indexOf(obj);
            }
            return indexOf;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            int lastIndexOf;
            synchronized (this.X) {
                lastIndexOf = o().lastIndexOf(obj);
            }
            return lastIndexOf;
        }

        public ListIterator<E> listIterator() {
            return o().listIterator();
        }

        public E remove(int i2) {
            E remove;
            synchronized (this.X) {
                remove = o().remove(i2);
            }
            return remove;
        }

        public E set(int i2, E e2) {
            E e3;
            synchronized (this.X) {
                e3 = o().set(i2, e2);
            }
            return e3;
        }

        public List<E> subList(int i2, int i3) {
            List<E> b2;
            synchronized (this.X) {
                b2 = Synchronized.j(o().subList(i2, i3), this.X);
            }
            return b2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public List<E> o() {
            return (List) super.d();
        }

        public ListIterator<E> listIterator(int i2) {
            return o().listIterator(i2);
        }
    }

    private static class SynchronizedListMultimap<K, V> extends SynchronizedMultimap<K, V> implements ListMultimap<K, V> {
        private static final long c3 = 0;

        SynchronizedListMultimap(ListMultimap<K, V> listMultimap, @CheckForNull Object obj) {
            super(listMultimap, obj);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public ListMultimap<K, V> o() {
            return (ListMultimap) super.d();
        }

        public List<V> b(@CheckForNull Object obj) {
            List<V> b2;
            synchronized (this.X) {
                b2 = o().b(obj);
            }
            return b2;
        }

        public List<V> c(K k2, Iterable<? extends V> iterable) {
            List<V> c2;
            synchronized (this.X) {
                c2 = o().c((Object) k2, (Iterable) iterable);
            }
            return c2;
        }

        public List<V> get(K k2) {
            List<V> b2;
            synchronized (this.X) {
                b2 = Synchronized.j(o().get((Object) k2), this.X);
            }
            return b2;
        }
    }

    private static class SynchronizedMap<K, V> extends SynchronizedObject implements Map<K, V> {
        private static final long Z2 = 0;
        @CheckForNull
        transient Collection<V> X2;
        @CheckForNull
        transient Set<Map.Entry<K, V>> Y2;
        @CheckForNull
        transient Set<K> Z;

        SynchronizedMap(Map<K, V> map, @CheckForNull Object obj) {
            super(map, obj);
        }

        public void clear() {
            synchronized (this.X) {
                d().clear();
            }
        }

        public boolean containsKey(@CheckForNull Object obj) {
            boolean containsKey;
            synchronized (this.X) {
                containsKey = d().containsKey(obj);
            }
            return containsKey;
        }

        public boolean containsValue(@CheckForNull Object obj) {
            boolean containsValue;
            synchronized (this.X) {
                containsValue = d().containsValue(obj);
            }
            return containsValue;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.X) {
                try {
                    if (this.Y2 == null) {
                        this.Y2 = Synchronized.u(d().entrySet(), this.X);
                    }
                    set = this.Y2;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.X) {
                equals = d().equals(obj);
            }
            return equals;
        }

        @CheckForNull
        public V get(@CheckForNull Object obj) {
            V v;
            synchronized (this.X) {
                v = d().get(obj);
            }
            return v;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.X) {
                hashCode = d().hashCode();
            }
            return hashCode;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.X) {
                isEmpty = d().isEmpty();
            }
            return isEmpty;
        }

        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.X) {
                try {
                    if (this.Z == null) {
                        this.Z = Synchronized.u(d().keySet(), this.X);
                    }
                    set = this.Z;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public Map<K, V> d() {
            return (Map) super.d();
        }

        @CheckForNull
        public V put(K k2, V v) {
            V put;
            synchronized (this.X) {
                put = d().put(k2, v);
            }
            return put;
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            synchronized (this.X) {
                d().putAll(map);
            }
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj) {
            V remove;
            synchronized (this.X) {
                remove = d().remove(obj);
            }
            return remove;
        }

        public int size() {
            int size;
            synchronized (this.X) {
                size = d().size();
            }
            return size;
        }

        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.X) {
                try {
                    if (this.X2 == null) {
                        this.X2 = Synchronized.h(d().values(), this.X);
                    }
                    collection = this.X2;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }
    }

    private static class SynchronizedMultimap<K, V> extends SynchronizedObject implements Multimap<K, V> {
        private static final long b3 = 0;
        @CheckForNull
        transient Collection<V> X2;
        @CheckForNull
        transient Collection<Map.Entry<K, V>> Y2;
        @CheckForNull
        transient Set<K> Z;
        @CheckForNull
        transient Map<K, Collection<V>> Z2;
        @CheckForNull
        transient Multiset<K> a3;

        SynchronizedMultimap(Multimap<K, V> multimap, @CheckForNull Object obj) {
            super(multimap, obj);
        }

        public boolean N0(@CheckForNull Object obj, @CheckForNull Object obj2) {
            boolean N0;
            synchronized (this.X) {
                N0 = d().N0(obj, obj2);
            }
            return N0;
        }

        public boolean T0(@ParametricNullness K k2, Iterable<? extends V> iterable) {
            boolean T0;
            synchronized (this.X) {
                T0 = d().T0(k2, iterable);
            }
            return T0;
        }

        public boolean Z(Multimap<? extends K, ? extends V> multimap) {
            boolean Z3;
            synchronized (this.X) {
                Z3 = d().Z(multimap);
            }
            return Z3;
        }

        public Collection<V> b(@CheckForNull Object obj) {
            Collection<V> b2;
            synchronized (this.X) {
                b2 = d().b(obj);
            }
            return b2;
        }

        public Collection<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
            Collection<V> c2;
            synchronized (this.X) {
                c2 = d().c(k2, iterable);
            }
            return c2;
        }

        public void clear() {
            synchronized (this.X) {
                d().clear();
            }
        }

        public boolean containsKey(@CheckForNull Object obj) {
            boolean containsKey;
            synchronized (this.X) {
                containsKey = d().containsKey(obj);
            }
            return containsKey;
        }

        public boolean containsValue(@CheckForNull Object obj) {
            boolean containsValue;
            synchronized (this.X) {
                containsValue = d().containsValue(obj);
            }
            return containsValue;
        }

        public Multiset<K> d0() {
            Multiset<K> multiset;
            synchronized (this.X) {
                try {
                    if (this.a3 == null) {
                        this.a3 = Synchronized.n(d().d0(), this.X);
                    }
                    multiset = this.a3;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return multiset;
        }

        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.X) {
                equals = d().equals(obj);
            }
            return equals;
        }

        public Map<K, Collection<V>> g() {
            Map<K, Collection<V>> map;
            synchronized (this.X) {
                try {
                    if (this.Z2 == null) {
                        this.Z2 = new SynchronizedAsMap(d().g(), this.X);
                    }
                    map = this.Z2;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return map;
        }

        public Collection<V> get(@ParametricNullness K k2) {
            Collection<V> d2;
            synchronized (this.X) {
                d2 = Synchronized.A(d().get(k2), this.X);
            }
            return d2;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.X) {
                hashCode = d().hashCode();
            }
            return hashCode;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.X) {
                isEmpty = d().isEmpty();
            }
            return isEmpty;
        }

        public Collection<Map.Entry<K, V>> j() {
            Collection<Map.Entry<K, V>> collection;
            synchronized (this.X) {
                try {
                    if (this.Y2 == null) {
                        this.Y2 = Synchronized.A(d().j(), this.X);
                    }
                    collection = this.Y2;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }

        public Set<K> keySet() {
            Set<K> set;
            synchronized (this.X) {
                try {
                    if (this.Z == null) {
                        this.Z = Synchronized.B(d().keySet(), this.X);
                    }
                    set = this.Z;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public Multimap<K, V> d() {
            return (Multimap) super.d();
        }

        public boolean put(@ParametricNullness K k2, @ParametricNullness V v) {
            boolean put;
            synchronized (this.X) {
                put = d().put(k2, v);
            }
            return put;
        }

        public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            boolean remove;
            synchronized (this.X) {
                remove = d().remove(obj, obj2);
            }
            return remove;
        }

        public int size() {
            int size;
            synchronized (this.X) {
                size = d().size();
            }
            return size;
        }

        public Collection<V> values() {
            Collection<V> collection;
            synchronized (this.X) {
                try {
                    if (this.X2 == null) {
                        this.X2 = Synchronized.h(d().values(), this.X);
                    }
                    collection = this.X2;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return collection;
        }
    }

    private static class SynchronizedMultiset<E> extends SynchronizedCollection<E> implements Multiset<E> {
        private static final long Z2 = 0;
        @CheckForNull
        transient Set<E> X2;
        @CheckForNull
        transient Set<Multiset.Entry<E>> Y2;

        SynchronizedMultiset(Multiset<E> multiset, @CheckForNull Object obj) {
            super(multiset, obj);
        }

        public boolean D0(@ParametricNullness E e2, int i2, int i3) {
            boolean D0;
            synchronized (this.X) {
                D0 = o().D0(e2, i2, i3);
            }
            return D0;
        }

        public int F(@CheckForNull Object obj, int i2) {
            int F;
            synchronized (this.X) {
                F = o().F(obj, i2);
            }
            return F;
        }

        public int Q(@ParametricNullness E e2, int i2) {
            int Q;
            synchronized (this.X) {
                Q = o().Q(e2, i2);
            }
            return Q;
        }

        public Set<E> e() {
            Set<E> set;
            synchronized (this.X) {
                try {
                    if (this.X2 == null) {
                        this.X2 = Synchronized.B(o().e(), this.X);
                    }
                    set = this.X2;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> set;
            synchronized (this.X) {
                try {
                    if (this.Y2 == null) {
                        this.Y2 = Synchronized.B(o().entrySet(), this.X);
                    }
                    set = this.Y2;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }

        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.X) {
                equals = o().equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.X) {
                hashCode = o().hashCode();
            }
            return hashCode;
        }

        public int l1(@CheckForNull Object obj) {
            int l1;
            synchronized (this.X) {
                l1 = o().l1(obj);
            }
            return l1;
        }

        public int r0(@ParametricNullness E e2, int i2) {
            int r0;
            synchronized (this.X) {
                r0 = o().r0(e2, i2);
            }
            return r0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public Multiset<E> o() {
            return (Multiset) super.d();
        }
    }

    @GwtIncompatible
    @VisibleForTesting
    static class SynchronizedNavigableMap<K, V> extends SynchronizedSortedMap<K, V> implements NavigableMap<K, V> {
        private static final long e3 = 0;
        @CheckForNull
        transient NavigableSet<K> b3;
        @CheckForNull
        transient NavigableMap<K, V> c3;
        @CheckForNull
        transient NavigableSet<K> d3;

        SynchronizedNavigableMap(NavigableMap<K, V> navigableMap, @CheckForNull Object obj) {
            super(navigableMap, obj);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: B */
        public NavigableMap<K, V> t() {
            return (NavigableMap) super.o();
        }

        @CheckForNull
        public Map.Entry<K, V> ceilingEntry(K k2) {
            Map.Entry<K, V> f2;
            synchronized (this.X) {
                f2 = Synchronized.s(t().ceilingEntry(k2), this.X);
            }
            return f2;
        }

        @CheckForNull
        public K ceilingKey(K k2) {
            K ceilingKey;
            synchronized (this.X) {
                ceilingKey = t().ceilingKey(k2);
            }
            return ceilingKey;
        }

        public NavigableSet<K> descendingKeySet() {
            synchronized (this.X) {
                try {
                    NavigableSet<K> navigableSet = this.b3;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet<K> r = Synchronized.r(t().descendingKeySet(), this.X);
                    this.b3 = r;
                    return r;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public NavigableMap<K, V> descendingMap() {
            synchronized (this.X) {
                try {
                    NavigableMap<K, V> navigableMap = this.c3;
                    if (navigableMap != null) {
                        return navigableMap;
                    }
                    NavigableMap<K, V> p = Synchronized.p(t().descendingMap(), this.X);
                    this.c3 = p;
                    return p;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @CheckForNull
        public Map.Entry<K, V> firstEntry() {
            Map.Entry<K, V> f2;
            synchronized (this.X) {
                f2 = Synchronized.s(t().firstEntry(), this.X);
            }
            return f2;
        }

        @CheckForNull
        public Map.Entry<K, V> floorEntry(K k2) {
            Map.Entry<K, V> f2;
            synchronized (this.X) {
                f2 = Synchronized.s(t().floorEntry(k2), this.X);
            }
            return f2;
        }

        @CheckForNull
        public K floorKey(K k2) {
            K floorKey;
            synchronized (this.X) {
                floorKey = t().floorKey(k2);
            }
            return floorKey;
        }

        public NavigableMap<K, V> headMap(K k2, boolean z) {
            NavigableMap<K, V> p;
            synchronized (this.X) {
                p = Synchronized.p(t().headMap(k2, z), this.X);
            }
            return p;
        }

        @CheckForNull
        public Map.Entry<K, V> higherEntry(K k2) {
            Map.Entry<K, V> f2;
            synchronized (this.X) {
                f2 = Synchronized.s(t().higherEntry(k2), this.X);
            }
            return f2;
        }

        @CheckForNull
        public K higherKey(K k2) {
            K higherKey;
            synchronized (this.X) {
                higherKey = t().higherKey(k2);
            }
            return higherKey;
        }

        public Set<K> keySet() {
            return navigableKeySet();
        }

        @CheckForNull
        public Map.Entry<K, V> lastEntry() {
            Map.Entry<K, V> f2;
            synchronized (this.X) {
                f2 = Synchronized.s(t().lastEntry(), this.X);
            }
            return f2;
        }

        @CheckForNull
        public Map.Entry<K, V> lowerEntry(K k2) {
            Map.Entry<K, V> f2;
            synchronized (this.X) {
                f2 = Synchronized.s(t().lowerEntry(k2), this.X);
            }
            return f2;
        }

        @CheckForNull
        public K lowerKey(K k2) {
            K lowerKey;
            synchronized (this.X) {
                lowerKey = t().lowerKey(k2);
            }
            return lowerKey;
        }

        public NavigableSet<K> navigableKeySet() {
            synchronized (this.X) {
                try {
                    NavigableSet<K> navigableSet = this.d3;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet<K> r = Synchronized.r(t().navigableKeySet(), this.X);
                    this.d3 = r;
                    return r;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @CheckForNull
        public Map.Entry<K, V> pollFirstEntry() {
            Map.Entry<K, V> f2;
            synchronized (this.X) {
                f2 = Synchronized.s(t().pollFirstEntry(), this.X);
            }
            return f2;
        }

        @CheckForNull
        public Map.Entry<K, V> pollLastEntry() {
            Map.Entry<K, V> f2;
            synchronized (this.X) {
                f2 = Synchronized.s(t().pollLastEntry(), this.X);
            }
            return f2;
        }

        public NavigableMap<K, V> subMap(K k2, boolean z, K k3, boolean z2) {
            NavigableMap<K, V> p;
            synchronized (this.X) {
                p = Synchronized.p(t().subMap(k2, z, k3, z2), this.X);
            }
            return p;
        }

        public NavigableMap<K, V> tailMap(K k2, boolean z) {
            NavigableMap<K, V> p;
            synchronized (this.X) {
                p = Synchronized.p(t().tailMap(k2, z), this.X);
            }
            return p;
        }

        public SortedMap<K, V> headMap(K k2) {
            return headMap(k2, false);
        }

        public SortedMap<K, V> subMap(K k2, K k3) {
            return subMap(k2, true, k3, false);
        }

        public SortedMap<K, V> tailMap(K k2) {
            return tailMap(k2, true);
        }
    }

    @GwtIncompatible
    @VisibleForTesting
    static class SynchronizedNavigableSet<E> extends SynchronizedSortedSet<E> implements NavigableSet<E> {
        private static final long a3 = 0;
        @CheckForNull
        transient NavigableSet<E> Z2;

        SynchronizedNavigableSet(NavigableSet<E> navigableSet, @CheckForNull Object obj) {
            super(navigableSet, obj);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: C */
        public NavigableSet<E> t() {
            return (NavigableSet) super.t();
        }

        @CheckForNull
        public E ceiling(E e2) {
            E ceiling;
            synchronized (this.X) {
                ceiling = t().ceiling(e2);
            }
            return ceiling;
        }

        public Iterator<E> descendingIterator() {
            return t().descendingIterator();
        }

        public NavigableSet<E> descendingSet() {
            synchronized (this.X) {
                try {
                    NavigableSet<E> navigableSet = this.Z2;
                    if (navigableSet != null) {
                        return navigableSet;
                    }
                    NavigableSet<E> r = Synchronized.r(t().descendingSet(), this.X);
                    this.Z2 = r;
                    return r;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @CheckForNull
        public E floor(E e2) {
            E floor;
            synchronized (this.X) {
                floor = t().floor(e2);
            }
            return floor;
        }

        public NavigableSet<E> headSet(E e2, boolean z) {
            NavigableSet<E> r;
            synchronized (this.X) {
                r = Synchronized.r(t().headSet(e2, z), this.X);
            }
            return r;
        }

        @CheckForNull
        public E higher(E e2) {
            E higher;
            synchronized (this.X) {
                higher = t().higher(e2);
            }
            return higher;
        }

        @CheckForNull
        public E lower(E e2) {
            E lower;
            synchronized (this.X) {
                lower = t().lower(e2);
            }
            return lower;
        }

        @CheckForNull
        public E pollFirst() {
            E pollFirst;
            synchronized (this.X) {
                pollFirst = t().pollFirst();
            }
            return pollFirst;
        }

        @CheckForNull
        public E pollLast() {
            E pollLast;
            synchronized (this.X) {
                pollLast = t().pollLast();
            }
            return pollLast;
        }

        public NavigableSet<E> subSet(E e2, boolean z, E e3, boolean z2) {
            NavigableSet<E> r;
            synchronized (this.X) {
                r = Synchronized.r(t().subSet(e2, z, e3, z2), this.X);
            }
            return r;
        }

        public NavigableSet<E> tailSet(E e2, boolean z) {
            NavigableSet<E> r;
            synchronized (this.X) {
                r = Synchronized.r(t().tailSet(e2, z), this.X);
            }
            return r;
        }

        public SortedSet<E> headSet(E e2) {
            return headSet(e2, false);
        }

        public SortedSet<E> subSet(E e2, E e3) {
            return subSet(e2, true, e3, false);
        }

        public SortedSet<E> tailSet(E e2) {
            return tailSet(e2, true);
        }
    }

    static class SynchronizedObject implements Serializable {
        @GwtIncompatible
        @J2ktIncompatible
        private static final long Y = 0;
        final Object X;
        final Object s;

        SynchronizedObject(Object obj, @CheckForNull Object obj2) {
            this.s = Preconditions.E(obj);
            this.X = obj2 == null ? this : obj2;
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void h(ObjectOutputStream objectOutputStream) throws IOException {
            synchronized (this.X) {
                objectOutputStream.defaultWriteObject();
            }
        }

        /* access modifiers changed from: package-private */
        public Object d() {
            return this.s;
        }

        public String toString() {
            String obj;
            synchronized (this.X) {
                obj = this.s.toString();
            }
            return obj;
        }
    }

    private static class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
        private static final long X2 = 0;

        SynchronizedQueue(Queue<E> queue, @CheckForNull Object obj) {
            super(queue, obj);
        }

        public E element() {
            E element;
            synchronized (this.X) {
                element = o().element();
            }
            return element;
        }

        public boolean offer(E e2) {
            boolean offer;
            synchronized (this.X) {
                offer = o().offer(e2);
            }
            return offer;
        }

        @CheckForNull
        public E peek() {
            E peek;
            synchronized (this.X) {
                peek = o().peek();
            }
            return peek;
        }

        @CheckForNull
        public E poll() {
            E poll;
            synchronized (this.X) {
                poll = o().poll();
            }
            return poll;
        }

        public E remove() {
            E remove;
            synchronized (this.X) {
                remove = o().remove();
            }
            return remove;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public Queue<E> o() {
            return (Queue) super.d();
        }
    }

    private static class SynchronizedRandomAccessList<E> extends SynchronizedList<E> implements RandomAccess {
        private static final long Y2 = 0;

        SynchronizedRandomAccessList(List<E> list, @CheckForNull Object obj) {
            super(list, obj);
        }
    }

    static class SynchronizedSet<E> extends SynchronizedCollection<E> implements Set<E> {
        private static final long X2 = 0;

        SynchronizedSet(Set<E> set, @CheckForNull Object obj) {
            super(set, obj);
        }

        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (obj == this) {
                return true;
            }
            synchronized (this.X) {
                equals = o().equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.X) {
                hashCode = o().hashCode();
            }
            return hashCode;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public Set<E> o() {
            return (Set) super.d();
        }
    }

    private static class SynchronizedSetMultimap<K, V> extends SynchronizedMultimap<K, V> implements SetMultimap<K, V> {
        private static final long d3 = 0;
        @CheckForNull
        transient Set<Map.Entry<K, V>> c3;

        SynchronizedSetMultimap(SetMultimap<K, V> setMultimap, @CheckForNull Object obj) {
            super(setMultimap, obj);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public SetMultimap<K, V> o() {
            return (SetMultimap) super.d();
        }

        public Set<V> b(@CheckForNull Object obj) {
            Set<V> b2;
            synchronized (this.X) {
                b2 = o().b(obj);
            }
            return b2;
        }

        public Set<V> c(K k2, Iterable<? extends V> iterable) {
            Set<V> c2;
            synchronized (this.X) {
                c2 = o().c((Object) k2, (Iterable) iterable);
            }
            return c2;
        }

        public Set<V> get(K k2) {
            Set<V> u;
            synchronized (this.X) {
                u = Synchronized.u(o().get((Object) k2), this.X);
            }
            return u;
        }

        public Set<Map.Entry<K, V>> j() {
            Set<Map.Entry<K, V>> set;
            synchronized (this.X) {
                try {
                    if (this.c3 == null) {
                        this.c3 = Synchronized.u(o().j(), this.X);
                    }
                    set = this.c3;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return set;
        }
    }

    static class SynchronizedSortedMap<K, V> extends SynchronizedMap<K, V> implements SortedMap<K, V> {
        private static final long a3 = 0;

        SynchronizedSortedMap(SortedMap<K, V> sortedMap, @CheckForNull Object obj) {
            super(sortedMap, obj);
        }

        @CheckForNull
        public Comparator<? super K> comparator() {
            Comparator<? super K> comparator;
            synchronized (this.X) {
                comparator = o().comparator();
            }
            return comparator;
        }

        public K firstKey() {
            K firstKey;
            synchronized (this.X) {
                firstKey = o().firstKey();
            }
            return firstKey;
        }

        public SortedMap<K, V> headMap(K k2) {
            SortedMap<K, V> w;
            synchronized (this.X) {
                w = Synchronized.w(o().headMap(k2), this.X);
            }
            return w;
        }

        public K lastKey() {
            K lastKey;
            synchronized (this.X) {
                lastKey = o().lastKey();
            }
            return lastKey;
        }

        public SortedMap<K, V> subMap(K k2, K k3) {
            SortedMap<K, V> w;
            synchronized (this.X) {
                w = Synchronized.w(o().subMap(k2, k3), this.X);
            }
            return w;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: t */
        public SortedMap<K, V> o() {
            return (SortedMap) super.d();
        }

        public SortedMap<K, V> tailMap(K k2) {
            SortedMap<K, V> w;
            synchronized (this.X) {
                w = Synchronized.w(o().tailMap(k2), this.X);
            }
            return w;
        }
    }

    static class SynchronizedSortedSet<E> extends SynchronizedSet<E> implements SortedSet<E> {
        private static final long Y2 = 0;

        SynchronizedSortedSet(SortedSet<E> sortedSet, @CheckForNull Object obj) {
            super(sortedSet, obj);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: B */
        public SortedSet<E> t() {
            return (SortedSet) super.o();
        }

        @CheckForNull
        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator;
            synchronized (this.X) {
                comparator = t().comparator();
            }
            return comparator;
        }

        public E first() {
            E first;
            synchronized (this.X) {
                first = t().first();
            }
            return first;
        }

        public SortedSet<E> headSet(E e2) {
            SortedSet<E> a2;
            synchronized (this.X) {
                a2 = Synchronized.x(t().headSet(e2), this.X);
            }
            return a2;
        }

        public E last() {
            E last;
            synchronized (this.X) {
                last = t().last();
            }
            return last;
        }

        public SortedSet<E> subSet(E e2, E e3) {
            SortedSet<E> a2;
            synchronized (this.X) {
                a2 = Synchronized.x(t().subSet(e2, e3), this.X);
            }
            return a2;
        }

        public SortedSet<E> tailSet(E e2) {
            SortedSet<E> a2;
            synchronized (this.X) {
                a2 = Synchronized.x(t().tailSet(e2), this.X);
            }
            return a2;
        }
    }

    private static final class SynchronizedTable<R, C, V> extends SynchronizedObject implements Table<R, C, V> {
        SynchronizedTable(Table<R, C, V> table, @CheckForNull Object obj) {
            super(table, obj);
        }

        public void B0(Table<? extends R, ? extends C, ? extends V> table) {
            synchronized (this.X) {
                d().B0(table);
            }
        }

        public boolean D(@CheckForNull Object obj) {
            boolean D;
            synchronized (this.X) {
                D = d().D(obj);
            }
            return D;
        }

        public Map<R, V> E(@ParametricNullness C c2) {
            Map<R, V> l2;
            synchronized (this.X) {
                l2 = Synchronized.l(d().E(c2), this.X);
            }
            return l2;
        }

        public Set<Table.Cell<R, C, V>> I() {
            Set<Table.Cell<R, C, V>> u;
            synchronized (this.X) {
                u = Synchronized.u(d().I(), this.X);
            }
            return u;
        }

        public boolean I0(@CheckForNull Object obj, @CheckForNull Object obj2) {
            boolean I0;
            synchronized (this.X) {
                I0 = d().I0(obj, obj2);
            }
            return I0;
        }

        public Map<C, Map<R, V>> J0() {
            Map<C, Map<R, V>> l2;
            synchronized (this.X) {
                l2 = Synchronized.l(Maps.B0(d().J0(), new Function<Map<R, V>, Map<R, V>>() {
                    /* renamed from: a */
                    public Map<R, V> apply(Map<R, V> map) {
                        return Synchronized.l(map, SynchronizedTable.this.X);
                    }
                }), this.X);
            }
            return l2;
        }

        @CheckForNull
        public V N(@ParametricNullness R r, @ParametricNullness C c2, @ParametricNullness V v) {
            V N;
            synchronized (this.X) {
                N = d().N(r, c2, v);
            }
            return N;
        }

        public Map<C, V> P0(@ParametricNullness R r) {
            Map<C, V> l2;
            synchronized (this.X) {
                l2 = Synchronized.l(d().P0(r), this.X);
            }
            return l2;
        }

        public void clear() {
            synchronized (this.X) {
                d().clear();
            }
        }

        public boolean containsValue(@CheckForNull Object obj) {
            boolean containsValue;
            synchronized (this.X) {
                containsValue = d().containsValue(obj);
            }
            return containsValue;
        }

        public boolean equals(@CheckForNull Object obj) {
            boolean equals;
            if (this == obj) {
                return true;
            }
            synchronized (this.X) {
                equals = d().equals(obj);
            }
            return equals;
        }

        public int hashCode() {
            int hashCode;
            synchronized (this.X) {
                hashCode = d().hashCode();
            }
            return hashCode;
        }

        public boolean isEmpty() {
            boolean isEmpty;
            synchronized (this.X) {
                isEmpty = d().isEmpty();
            }
            return isEmpty;
        }

        public Set<C> j0() {
            Set<C> u;
            synchronized (this.X) {
                u = Synchronized.u(d().j0(), this.X);
            }
            return u;
        }

        public Map<R, Map<C, V>> m() {
            Map<R, Map<C, V>> l2;
            synchronized (this.X) {
                l2 = Synchronized.l(Maps.B0(d().m(), new Function<Map<C, V>, Map<C, V>>() {
                    /* renamed from: a */
                    public Map<C, V> apply(Map<C, V> map) {
                        return Synchronized.l(map, SynchronizedTable.this.X);
                    }
                }), this.X);
            }
            return l2;
        }

        public boolean m0(@CheckForNull Object obj) {
            boolean m0;
            synchronized (this.X) {
                m0 = d().m0(obj);
            }
            return m0;
        }

        public Set<R> n() {
            Set<R> u;
            synchronized (this.X) {
                u = Synchronized.u(d().n(), this.X);
            }
            return u;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public Table<R, C, V> d() {
            return (Table) super.d();
        }

        @CheckForNull
        public V remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            V remove;
            synchronized (this.X) {
                remove = d().remove(obj, obj2);
            }
            return remove;
        }

        public int size() {
            int size;
            synchronized (this.X) {
                size = d().size();
            }
            return size;
        }

        public Collection<V> values() {
            Collection<V> e2;
            synchronized (this.X) {
                e2 = Synchronized.h(d().values(), this.X);
            }
            return e2;
        }

        @CheckForNull
        public V z(@CheckForNull Object obj, @CheckForNull Object obj2) {
            V z;
            synchronized (this.X) {
                z = d().z(obj, obj2);
            }
            return z;
        }
    }

    private Synchronized() {
    }

    /* access modifiers changed from: private */
    public static <E> Collection<E> A(Collection<E> collection, @CheckForNull Object obj) {
        if (collection instanceof SortedSet) {
            return x((SortedSet) collection, obj);
        }
        if (collection instanceof Set) {
            return u((Set) collection, obj);
        }
        return collection instanceof List ? j((List) collection, obj) : h(collection, obj);
    }

    /* access modifiers changed from: private */
    public static <E> Set<E> B(Set<E> set, @CheckForNull Object obj) {
        return set instanceof SortedSet ? x((SortedSet) set, obj) : u(set, obj);
    }

    static <K, V> BiMap<K, V> g(BiMap<K, V> biMap, @CheckForNull Object obj) {
        return ((biMap instanceof SynchronizedBiMap) || (biMap instanceof ImmutableBiMap)) ? biMap : new SynchronizedBiMap(biMap, obj, (BiMap) null);
    }

    /* access modifiers changed from: private */
    public static <E> Collection<E> h(Collection<E> collection, @CheckForNull Object obj) {
        return new SynchronizedCollection(collection, obj);
    }

    static <E> Deque<E> i(Deque<E> deque, @CheckForNull Object obj) {
        return new SynchronizedDeque(deque, obj);
    }

    /* access modifiers changed from: private */
    public static <E> List<E> j(List<E> list, @CheckForNull Object obj) {
        return list instanceof RandomAccess ? new SynchronizedRandomAccessList(list, obj) : new SynchronizedList(list, obj);
    }

    static <K, V> ListMultimap<K, V> k(ListMultimap<K, V> listMultimap, @CheckForNull Object obj) {
        return ((listMultimap instanceof SynchronizedListMultimap) || (listMultimap instanceof BaseImmutableMultimap)) ? listMultimap : new SynchronizedListMultimap(listMultimap, obj);
    }

    @VisibleForTesting
    static <K, V> Map<K, V> l(Map<K, V> map, @CheckForNull Object obj) {
        return new SynchronizedMap(map, obj);
    }

    static <K, V> Multimap<K, V> m(Multimap<K, V> multimap, @CheckForNull Object obj) {
        return ((multimap instanceof SynchronizedMultimap) || (multimap instanceof BaseImmutableMultimap)) ? multimap : new SynchronizedMultimap(multimap, obj);
    }

    static <E> Multiset<E> n(Multiset<E> multiset, @CheckForNull Object obj) {
        return ((multiset instanceof SynchronizedMultiset) || (multiset instanceof ImmutableMultiset)) ? multiset : new SynchronizedMultiset(multiset, obj);
    }

    @GwtIncompatible
    static <K, V> NavigableMap<K, V> o(NavigableMap<K, V> navigableMap) {
        return p(navigableMap, (Object) null);
    }

    @GwtIncompatible
    static <K, V> NavigableMap<K, V> p(NavigableMap<K, V> navigableMap, @CheckForNull Object obj) {
        return new SynchronizedNavigableMap(navigableMap, obj);
    }

    @GwtIncompatible
    static <E> NavigableSet<E> q(NavigableSet<E> navigableSet) {
        return r(navigableSet, (Object) null);
    }

    @GwtIncompatible
    static <E> NavigableSet<E> r(NavigableSet<E> navigableSet, @CheckForNull Object obj) {
        return new SynchronizedNavigableSet(navigableSet, obj);
    }

    /* access modifiers changed from: private */
    @GwtIncompatible
    @CheckForNull
    public static <K, V> Map.Entry<K, V> s(@CheckForNull Map.Entry<K, V> entry, @CheckForNull Object obj) {
        if (entry == null) {
            return null;
        }
        return new SynchronizedEntry(entry, obj);
    }

    static <E> Queue<E> t(Queue<E> queue, @CheckForNull Object obj) {
        return queue instanceof SynchronizedQueue ? queue : new SynchronizedQueue(queue, obj);
    }

    @VisibleForTesting
    static <E> Set<E> u(Set<E> set, @CheckForNull Object obj) {
        return new SynchronizedSet(set, obj);
    }

    static <K, V> SetMultimap<K, V> v(SetMultimap<K, V> setMultimap, @CheckForNull Object obj) {
        return ((setMultimap instanceof SynchronizedSetMultimap) || (setMultimap instanceof BaseImmutableMultimap)) ? setMultimap : new SynchronizedSetMultimap(setMultimap, obj);
    }

    static <K, V> SortedMap<K, V> w(SortedMap<K, V> sortedMap, @CheckForNull Object obj) {
        return new SynchronizedSortedMap(sortedMap, obj);
    }

    /* access modifiers changed from: private */
    public static <E> SortedSet<E> x(SortedSet<E> sortedSet, @CheckForNull Object obj) {
        return new SynchronizedSortedSet(sortedSet, obj);
    }

    static <K, V> SortedSetMultimap<K, V> y(SortedSetMultimap<K, V> sortedSetMultimap, @CheckForNull Object obj) {
        return sortedSetMultimap instanceof SynchronizedSortedSetMultimap ? sortedSetMultimap : new SynchronizedSortedSetMultimap(sortedSetMultimap, obj);
    }

    static <R, C, V> Table<R, C, V> z(Table<R, C, V> table, @CheckForNull Object obj) {
        return new SynchronizedTable(table, obj);
    }

    private static class SynchronizedSortedSetMultimap<K, V> extends SynchronizedSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long e3 = 0;

        SynchronizedSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap, @CheckForNull Object obj) {
            super(sortedSetMultimap, obj);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: B */
        public SortedSetMultimap<K, V> t() {
            return (SortedSetMultimap) super.o();
        }

        @CheckForNull
        public Comparator<? super V> i0() {
            Comparator<? super V> i0;
            synchronized (this.X) {
                i0 = t().i0();
            }
            return i0;
        }

        public SortedSet<V> b(@CheckForNull Object obj) {
            SortedSet<V> b2;
            synchronized (this.X) {
                b2 = t().b(obj);
            }
            return b2;
        }

        public SortedSet<V> c(K k2, Iterable<? extends V> iterable) {
            SortedSet<V> c2;
            synchronized (this.X) {
                c2 = t().c((Object) k2, (Iterable) iterable);
            }
            return c2;
        }

        public SortedSet<V> get(K k2) {
            SortedSet<V> a2;
            synchronized (this.X) {
                a2 = Synchronized.x(t().get((Object) k2), this.X);
            }
            return a2;
        }
    }
}
