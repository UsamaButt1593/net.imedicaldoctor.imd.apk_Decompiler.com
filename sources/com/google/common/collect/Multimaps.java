package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.Weak;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Multimaps {

    static final class AsMap<K, V> extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
        /* access modifiers changed from: private */
        @Weak
        public final Multimap<K, V> Z;

        class EntrySet extends Maps.EntrySet<K, Collection<V>> {
            EntrySet() {
            }

            /* access modifiers changed from: private */
            public /* synthetic */ Collection k(Object obj) {
                return AsMap.this.Z.get(obj);
            }

            /* access modifiers changed from: package-private */
            public Map<K, Collection<V>> h() {
                return AsMap.this;
            }

            public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                return Maps.m(AsMap.this.Z.keySet(), new h(this));
            }

            public boolean remove(@CheckForNull Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Objects.requireNonNull(entry);
                AsMap.this.g(entry.getKey());
                return true;
            }
        }

        AsMap(Multimap<K, V> multimap) {
            this.Z = (Multimap) Preconditions.E(multimap);
        }

        /* access modifiers changed from: protected */
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new EntrySet();
        }

        public void clear() {
            this.Z.clear();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.Z.containsKey(obj);
        }

        @CheckForNull
        /* renamed from: e */
        public Collection<V> get(@CheckForNull Object obj) {
            if (containsKey(obj)) {
                return this.Z.get(obj);
            }
            return null;
        }

        @CheckForNull
        /* renamed from: f */
        public Collection<V> remove(@CheckForNull Object obj) {
            if (containsKey(obj)) {
                return this.Z.b(obj);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void g(@CheckForNull Object obj) {
            this.Z.keySet().remove(obj);
        }

        public boolean isEmpty() {
            return this.Z.isEmpty();
        }

        public Set<K> keySet() {
            return this.Z.keySet();
        }

        public int size() {
            return this.Z.keySet().size();
        }
    }

    private static class CustomListMultimap<K, V> extends AbstractListMultimap<K, V> {
        @GwtIncompatible
        @J2ktIncompatible
        private static final long d3 = 0;
        transient Supplier<? extends List<V>> c3;

        CustomListMultimap(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
            super(map);
            this.c3 = (Supplier) Preconditions.E(supplier);
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void J(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            Object readObject = objectInputStream.readObject();
            Objects.requireNonNull(readObject);
            this.c3 = (Supplier) readObject;
            Object readObject2 = objectInputStream.readObject();
            Objects.requireNonNull(readObject2);
            C((Map) readObject2);
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void K(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.c3);
            objectOutputStream.writeObject(t());
        }

        /* access modifiers changed from: protected */
        /* renamed from: H */
        public List<V> u() {
            return (List) this.c3.get();
        }

        /* access modifiers changed from: package-private */
        public Map<K, Collection<V>> a() {
            return w();
        }

        /* access modifiers changed from: package-private */
        public Set<K> e() {
            return x();
        }
    }

    private static class CustomMultimap<K, V> extends AbstractMapBasedMultimap<K, V> {
        @GwtIncompatible
        @J2ktIncompatible
        private static final long c3 = 0;
        transient Supplier<? extends Collection<V>> b3;

        CustomMultimap(Map<K, Collection<V>> map, Supplier<? extends Collection<V>> supplier) {
            super(map);
            this.b3 = (Supplier) Preconditions.E(supplier);
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void H(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            Object readObject = objectInputStream.readObject();
            Objects.requireNonNull(readObject);
            this.b3 = (Supplier) readObject;
            Object readObject2 = objectInputStream.readObject();
            Objects.requireNonNull(readObject2);
            C((Map) readObject2);
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void I(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.b3);
            objectOutputStream.writeObject(t());
        }

        /* access modifiers changed from: package-private */
        public <E> Collection<E> D(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return Sets.O((NavigableSet) collection);
            }
            if (collection instanceof SortedSet) {
                return Collections.unmodifiableSortedSet((SortedSet) collection);
            }
            if (collection instanceof Set) {
                return Collections.unmodifiableSet((Set) collection);
            }
            return collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
        }

        /* access modifiers changed from: package-private */
        public Collection<V> E(@ParametricNullness K k2, Collection<V> collection) {
            if (collection instanceof List) {
                return F(k2, (List) collection, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null);
            }
            if (collection instanceof NavigableSet) {
                return new AbstractMapBasedMultimap.WrappedNavigableSet(k2, (NavigableSet) collection, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null);
            }
            if (collection instanceof SortedSet) {
                return new AbstractMapBasedMultimap.WrappedSortedSet(k2, (SortedSet) collection, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null);
            }
            return collection instanceof Set ? new AbstractMapBasedMultimap.WrappedSet(k2, (Set) collection) : new AbstractMapBasedMultimap.WrappedCollection(k2, collection, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null);
        }

        /* access modifiers changed from: package-private */
        public Map<K, Collection<V>> a() {
            return w();
        }

        /* access modifiers changed from: package-private */
        public Set<K> e() {
            return x();
        }

        /* access modifiers changed from: protected */
        public Collection<V> u() {
            return (Collection) this.b3.get();
        }
    }

    private static class CustomSetMultimap<K, V> extends AbstractSetMultimap<K, V> {
        @GwtIncompatible
        @J2ktIncompatible
        private static final long d3 = 0;
        transient Supplier<? extends Set<V>> c3;

        CustomSetMultimap(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
            super(map);
            this.c3 = (Supplier) Preconditions.E(supplier);
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void J(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            Object readObject = objectInputStream.readObject();
            Objects.requireNonNull(readObject);
            this.c3 = (Supplier) readObject;
            Object readObject2 = objectInputStream.readObject();
            Objects.requireNonNull(readObject2);
            C((Map) readObject2);
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void K(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.c3);
            objectOutputStream.writeObject(t());
        }

        /* access modifiers changed from: package-private */
        public <E> Collection<E> D(Collection<E> collection) {
            if (collection instanceof NavigableSet) {
                return Sets.O((NavigableSet) collection);
            }
            return collection instanceof SortedSet ? Collections.unmodifiableSortedSet((SortedSet) collection) : Collections.unmodifiableSet((Set) collection);
        }

        /* access modifiers changed from: package-private */
        public Collection<V> E(@ParametricNullness K k2, Collection<V> collection) {
            if (collection instanceof NavigableSet) {
                return new AbstractMapBasedMultimap.WrappedNavigableSet(k2, (NavigableSet) collection, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null);
            }
            return collection instanceof SortedSet ? new AbstractMapBasedMultimap.WrappedSortedSet(k2, (SortedSet) collection, (AbstractMapBasedMultimap<K, V>.WrappedCollection) null) : new AbstractMapBasedMultimap.WrappedSet(k2, (Set) collection);
        }

        /* access modifiers changed from: protected */
        /* renamed from: H */
        public Set<V> u() {
            return (Set) this.c3.get();
        }

        /* access modifiers changed from: package-private */
        public Map<K, Collection<V>> a() {
            return w();
        }

        /* access modifiers changed from: package-private */
        public Set<K> e() {
            return x();
        }
    }

    private static class CustomSortedSetMultimap<K, V> extends AbstractSortedSetMultimap<K, V> {
        @GwtIncompatible
        @J2ktIncompatible
        private static final long f3 = 0;
        transient Supplier<? extends SortedSet<V>> d3;
        @CheckForNull
        transient Comparator<? super V> e3;

        CustomSortedSetMultimap(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> supplier) {
            super(map);
            this.d3 = (Supplier) Preconditions.E(supplier);
            this.e3 = ((SortedSet) supplier.get()).comparator();
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void M(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            Object readObject = objectInputStream.readObject();
            Objects.requireNonNull(readObject);
            Supplier<? extends SortedSet<V>> supplier = (Supplier) readObject;
            this.d3 = supplier;
            this.e3 = ((SortedSet) supplier.get()).comparator();
            Object readObject2 = objectInputStream.readObject();
            Objects.requireNonNull(readObject2);
            C((Map) readObject2);
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void N(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(this.d3);
            objectOutputStream.writeObject(t());
        }

        /* access modifiers changed from: protected */
        /* renamed from: J */
        public SortedSet<V> u() {
            return (SortedSet) this.d3.get();
        }

        /* access modifiers changed from: package-private */
        public Map<K, Collection<V>> a() {
            return w();
        }

        /* access modifiers changed from: package-private */
        public Set<K> e() {
            return x();
        }

        @CheckForNull
        public Comparator<? super V> i0() {
            return this.e3;
        }
    }

    static abstract class Entries<K, V> extends AbstractCollection<Map.Entry<K, V>> {
        Entries() {
        }

        /* access modifiers changed from: package-private */
        public abstract Multimap<K, V> b();

        public void clear() {
            b().clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b().N0(entry.getKey(), entry.getValue());
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return b().remove(entry.getKey(), entry.getValue());
        }

        public int size() {
            return b().size();
        }
    }

    static class Keys<K, V> extends AbstractMultiset<K> {
        @Weak
        final Multimap<K, V> Y;

        Keys(Multimap<K, V> multimap) {
            this.Y = multimap;
        }

        public int F(@CheckForNull Object obj, int i2) {
            CollectPreconditions.b(i2, "occurrences");
            if (i2 == 0) {
                return l1(obj);
            }
            Collection collection = (Collection) Maps.p0(this.Y.g(), obj);
            if (collection == null) {
                return 0;
            }
            int size = collection.size();
            if (i2 >= size) {
                collection.clear();
            } else {
                Iterator it2 = collection.iterator();
                for (int i3 = 0; i3 < i2; i3++) {
                    it2.next();
                    it2.remove();
                }
            }
            return size;
        }

        public void clear() {
            this.Y.clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            return this.Y.containsKey(obj);
        }

        /* access modifiers changed from: package-private */
        public int d() {
            return this.Y.g().size();
        }

        public Set<K> e() {
            return this.Y.keySet();
        }

        /* access modifiers changed from: package-private */
        public Iterator<K> g() {
            throw new AssertionError("should never be called");
        }

        /* access modifiers changed from: package-private */
        public Iterator<Multiset.Entry<K>> h() {
            return new TransformedIterator<Map.Entry<K, Collection<V>>, Multiset.Entry<K>>(this, this.Y.g().entrySet().iterator()) {
                /* access modifiers changed from: package-private */
                /* renamed from: b */
                public Multiset.Entry<K> a(final Map.Entry<K, Collection<V>> entry) {
                    return new Multisets.AbstractEntry<K>(this) {
                        @ParametricNullness
                        public K a() {
                            return entry.getKey();
                        }

                        public int getCount() {
                            return ((Collection) entry.getValue()).size();
                        }
                    };
                }
            };
        }

        public Iterator<K> iterator() {
            return Maps.S(this.Y.j().iterator());
        }

        public int l1(@CheckForNull Object obj) {
            Collection collection = (Collection) Maps.p0(this.Y.g(), obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        public int size() {
            return this.Y.size();
        }
    }

    private static class MapMultimap<K, V> extends AbstractMultimap<K, V> implements SetMultimap<K, V>, Serializable {
        private static final long Z2 = 7845222491160860175L;
        final Map<K, V> Y2;

        MapMultimap(Map<K, V> map) {
            this.Y2 = (Map) Preconditions.E(map);
        }

        public boolean N0(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.Y2.entrySet().contains(Maps.O(obj, obj2));
        }

        public boolean T0(@ParametricNullness K k2, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        public boolean Z(Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        public Map<K, Collection<V>> a() {
            return new AsMap(this);
        }

        public void clear() {
            this.Y2.clear();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.Y2.containsKey(obj);
        }

        public boolean containsValue(@CheckForNull Object obj) {
            return this.Y2.containsValue(obj);
        }

        /* access modifiers changed from: package-private */
        public Collection<Map.Entry<K, V>> d() {
            throw new AssertionError("unreachable");
        }

        /* access modifiers changed from: package-private */
        public Set<K> e() {
            return this.Y2.keySet();
        }

        /* access modifiers changed from: package-private */
        public Multiset<K> f() {
            return new Keys(this);
        }

        /* access modifiers changed from: package-private */
        public Collection<V> h() {
            return this.Y2.values();
        }

        public int hashCode() {
            return this.Y2.hashCode();
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V>> i() {
            return this.Y2.entrySet().iterator();
        }

        public boolean put(@ParametricNullness K k2, @ParametricNullness V v) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return this.Y2.entrySet().remove(Maps.O(obj, obj2));
        }

        public int size() {
            return this.Y2.size();
        }

        public Set<V> b(@CheckForNull Object obj) {
            HashSet hashSet = new HashSet(2);
            if (!this.Y2.containsKey(obj)) {
                return hashSet;
            }
            hashSet.add(this.Y2.remove(obj));
            return hashSet;
        }

        public Set<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        public Set<V> get(@ParametricNullness final K k2) {
            return new Sets.ImprovedAbstractSet<V>() {
                public Iterator<V> iterator() {
                    return new Iterator<V>() {
                        int s;

                        public boolean hasNext() {
                            if (this.s == 0) {
                                AnonymousClass1 r0 = AnonymousClass1.this;
                                if (MapMultimap.this.Y2.containsKey(k2)) {
                                    return true;
                                }
                            }
                            return false;
                        }

                        @ParametricNullness
                        public V next() {
                            if (hasNext()) {
                                this.s++;
                                AnonymousClass1 r0 = AnonymousClass1.this;
                                return NullnessCasts.a(MapMultimap.this.Y2.get(k2));
                            }
                            throw new NoSuchElementException();
                        }

                        public void remove() {
                            boolean z = true;
                            if (this.s != 1) {
                                z = false;
                            }
                            CollectPreconditions.e(z);
                            this.s = -1;
                            AnonymousClass1 r0 = AnonymousClass1.this;
                            MapMultimap.this.Y2.remove(k2);
                        }
                    };
                }

                public int size() {
                    return MapMultimap.this.Y2.containsKey(k2) ? 1 : 0;
                }
            };
        }

        public Set<Map.Entry<K, V>> j() {
            return this.Y2.entrySet();
        }
    }

    private static final class TransformedEntriesListMultimap<K, V1, V2> extends TransformedEntriesMultimap<K, V1, V2> implements ListMultimap<K, V2> {
        TransformedEntriesListMultimap(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            super(listMultimap, entryTransformer);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: p */
        public List<V2> o(@ParametricNullness K k2, Collection<V1> collection) {
            return Lists.D((List) collection, Maps.n(this.Z2, k2));
        }

        public List<V2> b(@CheckForNull Object obj) {
            return o(obj, this.Y2.b(obj));
        }

        public List<V2> c(@ParametricNullness K k2, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        public List<V2> get(@ParametricNullness K k2) {
            return o(k2, this.Y2.get(k2));
        }
    }

    private static class TransformedEntriesMultimap<K, V1, V2> extends AbstractMultimap<K, V2> {
        final Multimap<K, V1> Y2;
        final Maps.EntryTransformer<? super K, ? super V1, V2> Z2;

        TransformedEntriesMultimap(Multimap<K, V1> multimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
            this.Y2 = (Multimap) Preconditions.E(multimap);
            this.Z2 = (Maps.EntryTransformer) Preconditions.E(entryTransformer);
        }

        public boolean T0(@ParametricNullness K k2, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        public boolean Z(Multimap<? extends K, ? extends V2> multimap) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        public Map<K, Collection<V2>> a() {
            return Maps.x0(this.Y2.g(), new i(this));
        }

        public Collection<V2> b(@CheckForNull Object obj) {
            return n(obj, this.Y2.b(obj));
        }

        public Collection<V2> c(@ParametricNullness K k2, Iterable<? extends V2> iterable) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            this.Y2.clear();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.Y2.containsKey(obj);
        }

        /* access modifiers changed from: package-private */
        public Collection<Map.Entry<K, V2>> d() {
            return new AbstractMultimap.Entries();
        }

        /* access modifiers changed from: package-private */
        public Set<K> e() {
            return this.Y2.keySet();
        }

        /* access modifiers changed from: package-private */
        public Multiset<K> f() {
            return this.Y2.d0();
        }

        public Collection<V2> get(@ParametricNullness K k2) {
            return n(k2, this.Y2.get(k2));
        }

        /* access modifiers changed from: package-private */
        public Collection<V2> h() {
            return Collections2.m(this.Y2.j(), Maps.h(this.Z2));
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<K, V2>> i() {
            return Iterators.c0(this.Y2.j().iterator(), Maps.g(this.Z2));
        }

        public boolean isEmpty() {
            return this.Y2.isEmpty();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: o */
        public Collection<V2> n(@ParametricNullness K k2, Collection<V1> collection) {
            Function<? super V1, V2> n2 = Maps.n(this.Z2, k2);
            return collection instanceof List ? Lists.D((List) collection, n2) : Collections2.m(collection, n2);
        }

        public boolean put(@ParametricNullness K k2, @ParametricNullness V2 v2) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            return get(obj).remove(obj2);
        }

        public int size() {
            return this.Y2.size();
        }
    }

    private static class UnmodifiableListMultimap<K, V> extends UnmodifiableMultimap<K, V> implements ListMultimap<K, V> {
        private static final long a3 = 0;

        UnmodifiableListMultimap(ListMultimap<K, V> listMultimap) {
            super(listMultimap);
        }

        /* renamed from: m1 */
        public ListMultimap<K, V> a1() {
            return (ListMultimap) super.Z0();
        }

        public List<V> b(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        public List<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        public List<V> get(@ParametricNullness K k2) {
            return Collections.unmodifiableList(a1().get((Object) k2));
        }
    }

    private static class UnmodifiableMultimap<K, V> extends ForwardingMultimap<K, V> implements Serializable {
        private static final long Z2 = 0;
        @CheckForNull
        @LazyInit
        transient Collection<Map.Entry<K, V>> X;
        @CheckForNull
        @LazyInit
        transient Collection<V> X2;
        @CheckForNull
        @LazyInit
        transient Multiset<K> Y;
        @CheckForNull
        @LazyInit
        transient Map<K, Collection<V>> Y2;
        @CheckForNull
        @LazyInit
        transient Set<K> Z;
        final Multimap<K, V> s;

        UnmodifiableMultimap(Multimap<K, V> multimap) {
            this.s = (Multimap) Preconditions.E(multimap);
        }

        public boolean T0(@ParametricNullness K k2, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        public boolean Z(Multimap<? extends K, ? extends V> multimap) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a1 */
        public Multimap<K, V> Z0() {
            return this.s;
        }

        public Collection<V> b(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        public Collection<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Multiset<K> d0() {
            Multiset<K> multiset = this.Y;
            if (multiset != null) {
                return multiset;
            }
            Multiset<K> A = Multisets.A(this.s.d0());
            this.Y = A;
            return A;
        }

        public Map<K, Collection<V>> g() {
            Map<K, Collection<V>> map = this.Y2;
            if (map != null) {
                return map;
            }
            Map<K, Collection<V>> unmodifiableMap = Collections.unmodifiableMap(Maps.B0(this.s.g(), new j()));
            this.Y2 = unmodifiableMap;
            return unmodifiableMap;
        }

        public Collection<V> get(@ParametricNullness K k2) {
            return Multimaps.O(this.s.get(k2));
        }

        public Collection<Map.Entry<K, V>> j() {
            Collection<Map.Entry<K, V>> collection = this.X;
            if (collection != null) {
                return collection;
            }
            Collection<Map.Entry<K, V>> a2 = Multimaps.G(this.s.j());
            this.X = a2;
            return a2;
        }

        public Set<K> keySet() {
            Set<K> set = this.Z;
            if (set != null) {
                return set;
            }
            Set<K> unmodifiableSet = Collections.unmodifiableSet(this.s.keySet());
            this.Z = unmodifiableSet;
            return unmodifiableSet;
        }

        public boolean put(@ParametricNullness K k2, @ParametricNullness V v) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
            throw new UnsupportedOperationException();
        }

        public Collection<V> values() {
            Collection<V> collection = this.X2;
            if (collection != null) {
                return collection;
            }
            Collection<V> unmodifiableCollection = Collections.unmodifiableCollection(this.s.values());
            this.X2 = unmodifiableCollection;
            return unmodifiableCollection;
        }
    }

    private static class UnmodifiableSetMultimap<K, V> extends UnmodifiableMultimap<K, V> implements SetMultimap<K, V> {
        private static final long a3 = 0;

        UnmodifiableSetMultimap(SetMultimap<K, V> setMultimap) {
            super(setMultimap);
        }

        /* renamed from: m1 */
        public SetMultimap<K, V> a1() {
            return (SetMultimap) super.Z0();
        }

        public Set<V> b(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        public Set<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        public Set<V> get(@ParametricNullness K k2) {
            return Collections.unmodifiableSet(a1().get((Object) k2));
        }

        public Set<Map.Entry<K, V>> j() {
            return Maps.K0(a1().j());
        }
    }

    private Multimaps() {
    }

    public static <K, V> SetMultimap<K, V> A(SetMultimap<K, V> setMultimap) {
        return Synchronized.v(setMultimap, (Object) null);
    }

    public static <K, V> SortedSetMultimap<K, V> B(SortedSetMultimap<K, V> sortedSetMultimap) {
        return Synchronized.y(sortedSetMultimap, (Object) null);
    }

    public static <K, V1, V2> ListMultimap<K, V2> C(ListMultimap<K, V1> listMultimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new TransformedEntriesListMultimap(listMultimap, entryTransformer);
    }

    public static <K, V1, V2> Multimap<K, V2> D(Multimap<K, V1> multimap, Maps.EntryTransformer<? super K, ? super V1, V2> entryTransformer) {
        return new TransformedEntriesMultimap(multimap, entryTransformer);
    }

    public static <K, V1, V2> ListMultimap<K, V2> E(ListMultimap<K, V1> listMultimap, Function<? super V1, V2> function) {
        Preconditions.E(function);
        return C(listMultimap, Maps.i(function));
    }

    public static <K, V1, V2> Multimap<K, V2> F(Multimap<K, V1> multimap, Function<? super V1, V2> function) {
        Preconditions.E(function);
        return D(multimap, Maps.i(function));
    }

    /* access modifiers changed from: private */
    public static <K, V> Collection<Map.Entry<K, V>> G(Collection<Map.Entry<K, V>> collection) {
        return collection instanceof Set ? Maps.K0((Set) collection) : new Maps.UnmodifiableEntries(Collections.unmodifiableCollection(collection));
    }

    @Deprecated
    public static <K, V> ListMultimap<K, V> H(ImmutableListMultimap<K, V> immutableListMultimap) {
        return (ListMultimap) Preconditions.E(immutableListMultimap);
    }

    public static <K, V> ListMultimap<K, V> I(ListMultimap<K, V> listMultimap) {
        return ((listMultimap instanceof UnmodifiableListMultimap) || (listMultimap instanceof ImmutableListMultimap)) ? listMultimap : new UnmodifiableListMultimap(listMultimap);
    }

    @Deprecated
    public static <K, V> Multimap<K, V> J(ImmutableMultimap<K, V> immutableMultimap) {
        return (Multimap) Preconditions.E(immutableMultimap);
    }

    public static <K, V> Multimap<K, V> K(Multimap<K, V> multimap) {
        return ((multimap instanceof UnmodifiableMultimap) || (multimap instanceof ImmutableMultimap)) ? multimap : new UnmodifiableMultimap(multimap);
    }

    @Deprecated
    public static <K, V> SetMultimap<K, V> L(ImmutableSetMultimap<K, V> immutableSetMultimap) {
        return (SetMultimap) Preconditions.E(immutableSetMultimap);
    }

    public static <K, V> SetMultimap<K, V> M(SetMultimap<K, V> setMultimap) {
        return ((setMultimap instanceof UnmodifiableSetMultimap) || (setMultimap instanceof ImmutableSetMultimap)) ? setMultimap : new UnmodifiableSetMultimap(setMultimap);
    }

    public static <K, V> SortedSetMultimap<K, V> N(SortedSetMultimap<K, V> sortedSetMultimap) {
        return sortedSetMultimap instanceof UnmodifiableSortedSetMultimap ? sortedSetMultimap : new UnmodifiableSortedSetMultimap(sortedSetMultimap);
    }

    /* access modifiers changed from: private */
    public static <V> Collection<V> O(Collection<V> collection) {
        if (collection instanceof SortedSet) {
            return Collections.unmodifiableSortedSet((SortedSet) collection);
        }
        if (collection instanceof Set) {
            return Collections.unmodifiableSet((Set) collection);
        }
        return collection instanceof List ? Collections.unmodifiableList((List) collection) : Collections.unmodifiableCollection(collection);
    }

    public static <K, V> Map<K, List<V>> c(ListMultimap<K, V> listMultimap) {
        return listMultimap.g();
    }

    public static <K, V> Map<K, Collection<V>> d(Multimap<K, V> multimap) {
        return multimap.g();
    }

    public static <K, V> Map<K, Set<V>> e(SetMultimap<K, V> setMultimap) {
        return setMultimap.g();
    }

    public static <K, V> Map<K, SortedSet<V>> f(SortedSetMultimap<K, V> sortedSetMultimap) {
        return sortedSetMultimap.g();
    }

    static boolean g(Multimap<?, ?> multimap, @CheckForNull Object obj) {
        if (obj == multimap) {
            return true;
        }
        if (obj instanceof Multimap) {
            return multimap.g().equals(((Multimap) obj).g());
        }
        return false;
    }

    public static <K, V> Multimap<K, V> h(Multimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.E(predicate);
        if (multimap instanceof SetMultimap) {
            return i((SetMultimap) multimap, predicate);
        }
        return multimap instanceof FilteredMultimap ? j((FilteredMultimap) multimap, predicate) : new FilteredEntryMultimap((Multimap) Preconditions.E(multimap), predicate);
    }

    public static <K, V> SetMultimap<K, V> i(SetMultimap<K, V> setMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        Preconditions.E(predicate);
        return setMultimap instanceof FilteredSetMultimap ? k((FilteredSetMultimap) setMultimap, predicate) : new FilteredEntrySetMultimap((SetMultimap) Preconditions.E(setMultimap), predicate);
    }

    private static <K, V> Multimap<K, V> j(FilteredMultimap<K, V> filteredMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntryMultimap(filteredMultimap.k(), Predicates.d(filteredMultimap.W(), predicate));
    }

    private static <K, V> SetMultimap<K, V> k(FilteredSetMultimap<K, V> filteredSetMultimap, Predicate<? super Map.Entry<K, V>> predicate) {
        return new FilteredEntrySetMultimap(filteredSetMultimap.k(), Predicates.d(filteredSetMultimap.W(), predicate));
    }

    public static <K, V> ListMultimap<K, V> l(ListMultimap<K, V> listMultimap, Predicate<? super K> predicate) {
        if (!(listMultimap instanceof FilteredKeyListMultimap)) {
            return new FilteredKeyListMultimap(listMultimap, predicate);
        }
        FilteredKeyListMultimap filteredKeyListMultimap = (FilteredKeyListMultimap) listMultimap;
        return new FilteredKeyListMultimap(filteredKeyListMultimap.k(), Predicates.d(filteredKeyListMultimap.Z2, predicate));
    }

    public static <K, V> Multimap<K, V> m(Multimap<K, V> multimap, Predicate<? super K> predicate) {
        if (multimap instanceof SetMultimap) {
            return n((SetMultimap) multimap, predicate);
        }
        if (multimap instanceof ListMultimap) {
            return l((ListMultimap) multimap, predicate);
        }
        if (!(multimap instanceof FilteredKeyMultimap)) {
            return multimap instanceof FilteredMultimap ? j((FilteredMultimap) multimap, Maps.U(predicate)) : new FilteredKeyMultimap(multimap, predicate);
        }
        FilteredKeyMultimap filteredKeyMultimap = (FilteredKeyMultimap) multimap;
        return new FilteredKeyMultimap(filteredKeyMultimap.Y2, Predicates.d(filteredKeyMultimap.Z2, predicate));
    }

    public static <K, V> SetMultimap<K, V> n(SetMultimap<K, V> setMultimap, Predicate<? super K> predicate) {
        if (!(setMultimap instanceof FilteredKeySetMultimap)) {
            return setMultimap instanceof FilteredSetMultimap ? k((FilteredSetMultimap) setMultimap, Maps.U(predicate)) : new FilteredKeySetMultimap(setMultimap, predicate);
        }
        FilteredKeySetMultimap filteredKeySetMultimap = (FilteredKeySetMultimap) setMultimap;
        return new FilteredKeySetMultimap(filteredKeySetMultimap.k(), Predicates.d(filteredKeySetMultimap.Z2, predicate));
    }

    public static <K, V> Multimap<K, V> o(Multimap<K, V> multimap, Predicate<? super V> predicate) {
        return h(multimap, Maps.R0(predicate));
    }

    public static <K, V> SetMultimap<K, V> p(SetMultimap<K, V> setMultimap, Predicate<? super V> predicate) {
        return i(setMultimap, Maps.R0(predicate));
    }

    public static <K, V> SetMultimap<K, V> q(Map<K, V> map) {
        return new MapMultimap(map);
    }

    public static <K, V> ImmutableListMultimap<K, V> r(Iterable<V> iterable, Function<? super V, K> function) {
        return s(iterable.iterator(), function);
    }

    public static <K, V> ImmutableListMultimap<K, V> s(Iterator<V> it2, Function<? super V, K> function) {
        Preconditions.E(function);
        ImmutableListMultimap.Builder L = ImmutableListMultimap.L();
        while (it2.hasNext()) {
            V next = it2.next();
            Preconditions.F(next, it2);
            L.f(function.apply(next), next);
        }
        return L.a();
    }

    @CanIgnoreReturnValue
    public static <K, V, M extends Multimap<K, V>> M t(Multimap<? extends V, ? extends K> multimap, M m2) {
        Preconditions.E(m2);
        for (Map.Entry next : multimap.j()) {
            m2.put(next.getValue(), next.getKey());
        }
        return m2;
    }

    public static <K, V> ListMultimap<K, V> u(Map<K, Collection<V>> map, Supplier<? extends List<V>> supplier) {
        return new CustomListMultimap(map, supplier);
    }

    public static <K, V> Multimap<K, V> v(Map<K, Collection<V>> map, Supplier<? extends Collection<V>> supplier) {
        return new CustomMultimap(map, supplier);
    }

    public static <K, V> SetMultimap<K, V> w(Map<K, Collection<V>> map, Supplier<? extends Set<V>> supplier) {
        return new CustomSetMultimap(map, supplier);
    }

    public static <K, V> SortedSetMultimap<K, V> x(Map<K, Collection<V>> map, Supplier<? extends SortedSet<V>> supplier) {
        return new CustomSortedSetMultimap(map, supplier);
    }

    public static <K, V> ListMultimap<K, V> y(ListMultimap<K, V> listMultimap) {
        return Synchronized.k(listMultimap, (Object) null);
    }

    public static <K, V> Multimap<K, V> z(Multimap<K, V> multimap) {
        return Synchronized.m(multimap, (Object) null);
    }

    private static class UnmodifiableSortedSetMultimap<K, V> extends UnmodifiableSetMultimap<K, V> implements SortedSetMultimap<K, V> {
        private static final long b3 = 0;

        UnmodifiableSortedSetMultimap(SortedSetMultimap<K, V> sortedSetMultimap) {
            super(sortedSetMultimap);
        }

        @CheckForNull
        public Comparator<? super V> i0() {
            return m1().i0();
        }

        /* renamed from: n1 */
        public SortedSetMultimap<K, V> m1() {
            return (SortedSetMultimap) super.a1();
        }

        public SortedSet<V> b(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        public SortedSet<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
            throw new UnsupportedOperationException();
        }

        public SortedSet<V> get(@ParametricNullness K k2) {
            return Collections.unmodifiableSortedSet(m1().get((Object) k2));
        }
    }
}
