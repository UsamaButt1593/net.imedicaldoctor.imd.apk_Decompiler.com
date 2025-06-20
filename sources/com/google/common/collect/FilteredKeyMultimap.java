package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
class FilteredKeyMultimap<K, V> extends AbstractMultimap<K, V> implements FilteredMultimap<K, V> {
    final Multimap<K, V> Y2;
    final Predicate<? super K> Z2;

    static class AddRejectingList<K, V> extends ForwardingList<V> {
        @ParametricNullness
        final K s;

        AddRejectingList(@ParametricNullness K k2) {
            this.s = k2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: E1 */
        public List<V> a1() {
            return Collections.emptyList();
        }

        public void add(int i2, @ParametricNullness V v) {
            Preconditions.d0(i2, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.s);
        }

        @CanIgnoreReturnValue
        public boolean addAll(int i2, Collection<? extends V> collection) {
            Preconditions.E(collection);
            Preconditions.d0(i2, 0);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.s);
        }

        public boolean add(@ParametricNullness V v) {
            add(0, v);
            return true;
        }

        public boolean addAll(Collection<? extends V> collection) {
            addAll(0, collection);
            return true;
        }
    }

    static class AddRejectingSet<K, V> extends ForwardingSet<V> {
        @ParametricNullness
        final K s;

        AddRejectingSet(@ParametricNullness K k2) {
            this.s = k2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: E1 */
        public Set<V> a1() {
            return Collections.emptySet();
        }

        public boolean add(@ParametricNullness V v) {
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.s);
        }

        public boolean addAll(Collection<? extends V> collection) {
            Preconditions.E(collection);
            throw new IllegalArgumentException("Key does not satisfy predicate: " + this.s);
        }
    }

    class Entries extends ForwardingCollection<Map.Entry<K, V>> {
        Entries() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a1 */
        public Collection<Map.Entry<K, V>> Z0() {
            return Collections2.d(FilteredKeyMultimap.this.Y2.j(), FilteredKeyMultimap.this.W());
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            if (!FilteredKeyMultimap.this.Y2.containsKey(entry.getKey()) || !FilteredKeyMultimap.this.Z2.apply(entry.getKey())) {
                return false;
            }
            return FilteredKeyMultimap.this.Y2.remove(entry.getKey(), entry.getValue());
        }
    }

    FilteredKeyMultimap(Multimap<K, V> multimap, Predicate<? super K> predicate) {
        this.Y2 = (Multimap) Preconditions.E(multimap);
        this.Z2 = (Predicate) Preconditions.E(predicate);
    }

    public Predicate<? super Map.Entry<K, V>> W() {
        return Maps.U(this.Z2);
    }

    /* access modifiers changed from: package-private */
    public Map<K, Collection<V>> a() {
        return Maps.G(this.Y2.g(), this.Z2);
    }

    public Collection<V> b(@CheckForNull Object obj) {
        return containsKey(obj) ? this.Y2.b(obj) : m();
    }

    public void clear() {
        keySet().clear();
    }

    public boolean containsKey(@CheckForNull Object obj) {
        if (this.Y2.containsKey(obj)) {
            return this.Z2.apply(obj);
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public Collection<Map.Entry<K, V>> d() {
        return new Entries();
    }

    /* access modifiers changed from: package-private */
    public Set<K> e() {
        return Sets.i(this.Y2.keySet(), this.Z2);
    }

    /* access modifiers changed from: package-private */
    public Multiset<K> f() {
        return Multisets.j(this.Y2.d0(), this.Z2);
    }

    public Collection<V> get(@ParametricNullness K k2) {
        return this.Z2.apply(k2) ? this.Y2.get(k2) : this.Y2 instanceof SetMultimap ? new AddRejectingSet(k2) : new AddRejectingList(k2);
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
    public Collection<V> m() {
        return this.Y2 instanceof SetMultimap ? Collections.emptySet() : Collections.emptyList();
    }

    public int size() {
        int i2 = 0;
        for (Collection size : g().values()) {
            i2 += size.size();
        }
        return i2;
    }
}
