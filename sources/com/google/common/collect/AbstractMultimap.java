package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multimaps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
abstract class AbstractMultimap<K, V> implements Multimap<K, V> {
    @CheckForNull
    @LazyInit
    private transient Set<K> X;
    @CheckForNull
    @LazyInit
    private transient Map<K, Collection<V>> X2;
    @CheckForNull
    @LazyInit
    private transient Multiset<K> Y;
    @CheckForNull
    @LazyInit
    private transient Collection<V> Z;
    @CheckForNull
    @LazyInit
    private transient Collection<Map.Entry<K, V>> s;

    class Entries extends Multimaps.Entries<K, V> {
        Entries() {
        }

        /* access modifiers changed from: package-private */
        public Multimap<K, V> b() {
            return AbstractMultimap.this;
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractMultimap.this.i();
        }
    }

    class EntrySet extends AbstractMultimap<K, V>.Entries implements Set<Map.Entry<K, V>> {
        EntrySet(AbstractMultimap abstractMultimap) {
            super();
        }

        public boolean equals(@CheckForNull Object obj) {
            return Sets.g(this, obj);
        }

        public int hashCode() {
            return Sets.k(this);
        }
    }

    class Values extends AbstractCollection<V> {
        Values() {
        }

        public void clear() {
            AbstractMultimap.this.clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            return AbstractMultimap.this.containsValue(obj);
        }

        public Iterator<V> iterator() {
            return AbstractMultimap.this.l();
        }

        public int size() {
            return AbstractMultimap.this.size();
        }
    }

    AbstractMultimap() {
    }

    public boolean N0(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Collection collection = (Collection) g().get(obj);
        return collection != null && collection.contains(obj2);
    }

    @CanIgnoreReturnValue
    public boolean T0(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        Preconditions.E(iterable);
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            return !collection.isEmpty() && get(k2).addAll(collection);
        }
        Iterator<? extends V> it2 = iterable.iterator();
        return it2.hasNext() && Iterators.a(get(k2), it2);
    }

    @CanIgnoreReturnValue
    public boolean Z(Multimap<? extends K, ? extends V> multimap) {
        boolean z = false;
        for (Map.Entry next : multimap.j()) {
            z |= put(next.getKey(), next.getValue());
        }
        return z;
    }

    /* access modifiers changed from: package-private */
    public abstract Map<K, Collection<V>> a();

    @CanIgnoreReturnValue
    public Collection<V> c(@ParametricNullness K k2, Iterable<? extends V> iterable) {
        Preconditions.E(iterable);
        Collection<V> b2 = b(k2);
        T0(k2, iterable);
        return b2;
    }

    public boolean containsValue(@CheckForNull Object obj) {
        for (Collection contains : g().values()) {
            if (contains.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract Collection<Map.Entry<K, V>> d();

    public Multiset<K> d0() {
        Multiset<K> multiset = this.Y;
        if (multiset != null) {
            return multiset;
        }
        Multiset<K> f2 = f();
        this.Y = f2;
        return f2;
    }

    /* access modifiers changed from: package-private */
    public abstract Set<K> e();

    public boolean equals(@CheckForNull Object obj) {
        return Multimaps.g(this, obj);
    }

    /* access modifiers changed from: package-private */
    public abstract Multiset<K> f();

    public Map<K, Collection<V>> g() {
        Map<K, Collection<V>> map = this.X2;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> a2 = a();
        this.X2 = a2;
        return a2;
    }

    /* access modifiers changed from: package-private */
    public abstract Collection<V> h();

    public int hashCode() {
        return g().hashCode();
    }

    /* access modifiers changed from: package-private */
    public abstract Iterator<Map.Entry<K, V>> i();

    public boolean isEmpty() {
        return size() == 0;
    }

    public Collection<Map.Entry<K, V>> j() {
        Collection<Map.Entry<K, V>> collection = this.s;
        if (collection != null) {
            return collection;
        }
        Collection<Map.Entry<K, V>> d2 = d();
        this.s = d2;
        return d2;
    }

    public Set<K> keySet() {
        Set<K> set = this.X;
        if (set != null) {
            return set;
        }
        Set<K> e2 = e();
        this.X = e2;
        return e2;
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> l() {
        return Maps.P0(j().iterator());
    }

    @CanIgnoreReturnValue
    public boolean put(@ParametricNullness K k2, @ParametricNullness V v) {
        return get(k2).add(v);
    }

    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        Collection collection = (Collection) g().get(obj);
        return collection != null && collection.remove(obj2);
    }

    public String toString() {
        return g().toString();
    }

    public Collection<V> values() {
        Collection<V> collection = this.Z;
        if (collection != null) {
            return collection;
        }
        Collection<V> h2 = h();
        this.Z = h2;
        return h2;
    }
}
