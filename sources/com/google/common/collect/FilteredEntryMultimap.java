package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
class FilteredEntryMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
    final Multimap<K, V> Y2;
    final Predicate<? super Map.Entry<K, V>> Z2;

    class AsMap extends Maps.ViewCachingAbstractMap<K, Collection<V>> {
        AsMap() {
        }

        /* access modifiers changed from: package-private */
        public Set<Map.Entry<K, Collection<V>>> a() {
            return new Maps.EntrySet<K, Collection<V>>() {
                /* access modifiers changed from: package-private */
                public Map<K, Collection<V>> h() {
                    return AsMap.this;
                }

                public Iterator<Map.Entry<K, Collection<V>>> iterator() {
                    return new AbstractIterator<Map.Entry<K, Collection<V>>>() {
                        final Iterator<Map.Entry<K, Collection<V>>> Y;

                        {
                            this.Y = FilteredEntryMultimap.this.Y2.g().entrySet().iterator();
                        }

                        /* access modifiers changed from: protected */
                        @CheckForNull
                        /* renamed from: d */
                        public Map.Entry<K, Collection<V>> a() {
                            while (this.Y.hasNext()) {
                                Map.Entry next = this.Y.next();
                                Object key = next.getKey();
                                Collection n2 = FilteredEntryMultimap.n((Collection) next.getValue(), new ValuePredicate(key));
                                if (!n2.isEmpty()) {
                                    return Maps.O(key, n2);
                                }
                            }
                            return (Map.Entry) b();
                        }
                    };
                }

                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.o(Predicates.n(collection));
                }

                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.o(Predicates.q(Predicates.n(collection)));
                }

                public int size() {
                    return Iterators.Z(iterator());
                }
            };
        }

        /* access modifiers changed from: package-private */
        public Set<K> b() {
            return new Maps.KeySet<K, Collection<V>>() {
                public boolean remove(@CheckForNull Object obj) {
                    return AsMap.this.remove(obj) != null;
                }

                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.o(Maps.U(Predicates.n(collection)));
                }

                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.o(Maps.U(Predicates.q(Predicates.n(collection))));
                }
            };
        }

        /* access modifiers changed from: package-private */
        public Collection<Collection<V>> c() {
            return new Maps.Values<K, Collection<V>>() {
                public boolean remove(@CheckForNull Object obj) {
                    if (!(obj instanceof Collection)) {
                        return false;
                    }
                    Collection collection = (Collection) obj;
                    Iterator<Map.Entry<K, Collection<V>>> it2 = FilteredEntryMultimap.this.Y2.g().entrySet().iterator();
                    while (it2.hasNext()) {
                        Map.Entry next = it2.next();
                        Collection n2 = FilteredEntryMultimap.n((Collection) next.getValue(), new ValuePredicate(next.getKey()));
                        if (!n2.isEmpty() && collection.equals(n2)) {
                            if (n2.size() == ((Collection) next.getValue()).size()) {
                                it2.remove();
                                return true;
                            }
                            n2.clear();
                            return true;
                        }
                    }
                    return false;
                }

                public boolean removeAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.o(Maps.R0(Predicates.n(collection)));
                }

                public boolean retainAll(Collection<?> collection) {
                    return FilteredEntryMultimap.this.o(Maps.R0(Predicates.q(Predicates.n(collection))));
                }
            };
        }

        public void clear() {
            FilteredEntryMultimap.this.clear();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return get(obj) != null;
        }

        @CheckForNull
        /* renamed from: d */
        public Collection<V> get(@CheckForNull Object obj) {
            Collection collection = FilteredEntryMultimap.this.Y2.g().get(obj);
            if (collection == null) {
                return null;
            }
            Collection<V> n2 = FilteredEntryMultimap.n(collection, new ValuePredicate(obj));
            if (n2.isEmpty()) {
                return null;
            }
            return n2;
        }

        @CheckForNull
        /* renamed from: e */
        public Collection<V> remove(@CheckForNull Object obj) {
            Collection collection = FilteredEntryMultimap.this.Y2.g().get(obj);
            if (collection == null) {
                return null;
            }
            ArrayList q = Lists.q();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                if (FilteredEntryMultimap.this.p(obj, next)) {
                    it2.remove();
                    q.add(next);
                }
            }
            if (q.isEmpty()) {
                return null;
            }
            return FilteredEntryMultimap.this.Y2 instanceof SetMultimap ? Collections.unmodifiableSet(Sets.B(q)) : Collections.unmodifiableList(q);
        }
    }

    class Keys extends Multimaps.Keys<K, V> {
        Keys() {
            super(FilteredEntryMultimap.this);
        }

        public int F(@CheckForNull Object obj, int i2) {
            CollectPreconditions.b(i2, "occurrences");
            if (i2 == 0) {
                return l1(obj);
            }
            Collection collection = FilteredEntryMultimap.this.Y2.g().get(obj);
            int i3 = 0;
            if (collection == null) {
                return 0;
            }
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                if (FilteredEntryMultimap.this.p(obj, it2.next()) && (i3 = i3 + 1) <= i2) {
                    it2.remove();
                }
            }
            return i3;
        }

        public Set<Multiset.Entry<K>> entrySet() {
            return new Multisets.EntrySet<K>() {
                private boolean m(Predicate<? super Multiset.Entry<K>> predicate) {
                    return FilteredEntryMultimap.this.o(new C0467b(predicate));
                }

                /* access modifiers changed from: package-private */
                public Multiset<K> h() {
                    return Keys.this;
                }

                public Iterator<Multiset.Entry<K>> iterator() {
                    return Keys.this.h();
                }

                public boolean removeAll(Collection<?> collection) {
                    return m(Predicates.n(collection));
                }

                public boolean retainAll(Collection<?> collection) {
                    return m(Predicates.q(Predicates.n(collection)));
                }

                public int size() {
                    return FilteredEntryMultimap.this.keySet().size();
                }
            };
        }
    }

    final class ValuePredicate implements Predicate<V> {
        @ParametricNullness
        private final K s;

        ValuePredicate(@ParametricNullness K k2) {
            this.s = k2;
        }

        public boolean apply(@ParametricNullness V v) {
            return FilteredEntryMultimap.this.p(this.s, v);
        }
    }

    FilteredEntryMultimap(Multimap<K, V> multimap, Predicate<? super Map.Entry<K, V>> predicate) {
        this.Y2 = (Multimap) Preconditions.E(multimap);
        this.Z2 = (Predicate) Preconditions.E(predicate);
    }

    static <E> Collection<E> n(Collection<E> collection, Predicate<? super E> predicate) {
        return collection instanceof Set ? Sets.i((Set) collection, predicate) : Collections2.d(collection, predicate);
    }

    /* access modifiers changed from: private */
    public boolean p(@ParametricNullness K k2, @ParametricNullness V v) {
        return this.Z2.apply(Maps.O(k2, v));
    }

    public Predicate<? super Map.Entry<K, V>> W() {
        return this.Z2;
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> a() {
        return new AsMap();
    }

    public Collection<V> b(@CheckForNull Object obj) {
        return (Collection) MoreObjects.a((Collection) g().remove(obj), q());
    }

    public void clear() {
        j().clear();
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return g().get(obj) != null;
    }

    /* access modifiers changed from: package-private */
    public Collection<Map.Entry<K, V>> d() {
        return n(this.Y2.j(), this.Z2);
    }

    /* access modifiers changed from: package-private */
    public Set<K> e() {
        return g().keySet();
    }

    /* access modifiers changed from: package-private */
    public Multiset<K> f() {
        return new Keys();
    }

    public Collection<V> get(@ParametricNullness K k2) {
        return n(this.Y2.get(k2), new ValuePredicate(k2));
    }

    /* access modifiers changed from: package-private */
    public Collection<V> h() {
        return new FilteredMultimapValues(this);
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> i() {
        throw new AssertionError("should never be called");
    }

    public Multimap<K, V> k() {
        return this.Y2;
    }

    /* access modifiers changed from: package-private */
    public boolean o(Predicate<? super Map.Entry<K, Collection<V>>> predicate) {
        Iterator<Map.Entry<K, Collection<V>>> it2 = this.Y2.g().entrySet().iterator();
        boolean z = false;
        while (it2.hasNext()) {
            Map.Entry next = it2.next();
            Object key = next.getKey();
            Collection n2 = n((Collection) next.getValue(), new ValuePredicate(key));
            if (!n2.isEmpty() && predicate.apply(Maps.O(key, n2))) {
                if (n2.size() == ((Collection) next.getValue()).size()) {
                    it2.remove();
                } else {
                    n2.clear();
                }
                z = true;
            }
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public Collection<V> q() {
        return this.Y2 instanceof SetMultimap ? Collections.emptySet() : Collections.emptyList();
    }

    public int size() {
        return j().size();
    }
}
