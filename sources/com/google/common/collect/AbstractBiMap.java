package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
abstract class AbstractBiMap<K, V> extends ForwardingMap<K, V> implements BiMap<K, V>, Serializable {
    @GwtIncompatible
    @J2ktIncompatible
    private static final long Y2 = 0;
    @RetainedWith
    transient AbstractBiMap<V, K> X;
    @CheckForNull
    @LazyInit
    private transient Set<Map.Entry<K, V>> X2;
    @CheckForNull
    @LazyInit
    private transient Set<K> Y;
    @CheckForNull
    @LazyInit
    private transient Set<V> Z;
    /* access modifiers changed from: private */
    public transient Map<K, V> s;

    class BiMapEntry extends ForwardingMapEntry<K, V> {
        private final Map.Entry<K, V> s;

        BiMapEntry(Map.Entry<K, V> entry) {
            this.s = entry;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a1 */
        public Map.Entry<K, V> Z0() {
            return this.s;
        }

        public V setValue(V v) {
            AbstractBiMap.this.J1(v);
            Preconditions.h0(AbstractBiMap.this.entrySet().contains(this), "entry no longer in map");
            if (Objects.a(v, getValue())) {
                return v;
            }
            Preconditions.u(!AbstractBiMap.this.containsValue(v), "value already present: %s", v);
            V value = this.s.setValue(v);
            Preconditions.h0(Objects.a(v, AbstractBiMap.this.get(getKey())), "entry no longer in map");
            AbstractBiMap.this.W1(getKey(), true, value, v);
            return value;
        }
    }

    private class EntrySet extends ForwardingSet<Map.Entry<K, V>> {
        final Set<Map.Entry<K, V>> s;

        private EntrySet() {
            this.s = AbstractBiMap.this.s.entrySet();
        }

        /* access modifiers changed from: protected */
        /* renamed from: E1 */
        public Set<Map.Entry<K, V>> a1() {
            return this.s;
        }

        public void clear() {
            AbstractBiMap.this.clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            return Maps.p(a1(), obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return n1(collection);
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return AbstractBiMap.this.K1();
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!this.s.contains(obj) || !(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            AbstractBiMap.this.X.s.remove(entry.getValue());
            this.s.remove(entry);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return q1(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return s1(collection);
        }

        public Object[] toArray() {
            return v1();
        }

        public <T> T[] toArray(T[] tArr) {
            return x1(tArr);
        }
    }

    static class Inverse<K, V> extends AbstractBiMap<K, V> {
        @GwtIncompatible
        @J2ktIncompatible
        private static final long Z2 = 0;

        Inverse(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
            super(map, abstractBiMap);
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void X1(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            Object readObject = objectInputStream.readObject();
            java.util.Objects.requireNonNull(readObject);
            V1((AbstractBiMap) readObject);
        }

        @GwtIncompatible
        @J2ktIncompatible
        private void Z1(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(q2());
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public K I1(@ParametricNullness K k2) {
            return this.X.J1(k2);
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public V J1(@ParametricNullness V v) {
            return this.X.I1(v);
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        @J2ktIncompatible
        public Object Y1() {
            return q2().q2();
        }

        /* access modifiers changed from: protected */
        public /* bridge */ /* synthetic */ Object Z0() {
            return AbstractBiMap.super.Z0();
        }

        public /* bridge */ /* synthetic */ Collection values() {
            return AbstractBiMap.super.values();
        }
    }

    private class KeySet extends ForwardingSet<K> {
        private KeySet() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: E1 */
        public Set<K> a1() {
            return AbstractBiMap.this.s.keySet();
        }

        public void clear() {
            AbstractBiMap.this.clear();
        }

        public Iterator<K> iterator() {
            return Maps.S(AbstractBiMap.this.entrySet().iterator());
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!contains(obj)) {
                return false;
            }
            Object unused = AbstractBiMap.this.N1(obj);
            return true;
        }

        public boolean removeAll(Collection<?> collection) {
            return q1(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return s1(collection);
        }
    }

    private class ValueSet extends ForwardingSet<V> {
        final Set<V> s;

        private ValueSet() {
            this.s = AbstractBiMap.this.X.keySet();
        }

        /* access modifiers changed from: protected */
        /* renamed from: E1 */
        public Set<V> a1() {
            return this.s;
        }

        public Iterator<V> iterator() {
            return Maps.P0(AbstractBiMap.this.entrySet().iterator());
        }

        public Object[] toArray() {
            return v1();
        }

        public String toString() {
            return B1();
        }

        public <T> T[] toArray(T[] tArr) {
            return x1(tArr);
        }
    }

    private AbstractBiMap(Map<K, V> map, AbstractBiMap<V, K> abstractBiMap) {
        this.s = map;
        this.X = abstractBiMap;
    }

    @CheckForNull
    private V M1(@ParametricNullness K k2, @ParametricNullness V v, boolean z) {
        I1(k2);
        J1(v);
        boolean containsKey = containsKey(k2);
        if (containsKey && Objects.a(v, get(k2))) {
            return v;
        }
        if (z) {
            q2().remove(v);
        } else {
            Preconditions.u(!containsValue(v), "value already present: %s", v);
        }
        V put = this.s.put(k2, v);
        W1(k2, containsKey, put, v);
        return put;
    }

    /* access modifiers changed from: private */
    @ParametricNullness
    @CanIgnoreReturnValue
    public V N1(@CheckForNull Object obj) {
        V a2 = NullnessCasts.a(this.s.remove(obj));
        P1(a2);
        return a2;
    }

    /* access modifiers changed from: private */
    public void P1(@ParametricNullness V v) {
        this.X.s.remove(v);
    }

    /* access modifiers changed from: private */
    public void W1(@ParametricNullness K k2, boolean z, @CheckForNull V v, @ParametricNullness V v2) {
        if (z) {
            P1(NullnessCasts.a(v));
        }
        this.X.s.put(v2, k2);
    }

    /* access modifiers changed from: package-private */
    @ParametricNullness
    @CanIgnoreReturnValue
    public K I1(@ParametricNullness K k2) {
        return k2;
    }

    /* access modifiers changed from: package-private */
    @ParametricNullness
    @CanIgnoreReturnValue
    public V J1(@ParametricNullness V v) {
        return v;
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> K1() {
        final Iterator<Map.Entry<K, V>> it2 = this.s.entrySet().iterator();
        return new Iterator<Map.Entry<K, V>>() {
            @CheckForNull
            Map.Entry<K, V> s;

            /* renamed from: a */
            public Map.Entry<K, V> next() {
                Map.Entry<K, V> entry = (Map.Entry) it2.next();
                this.s = entry;
                return new BiMapEntry(entry);
            }

            public boolean hasNext() {
                return it2.hasNext();
            }

            public void remove() {
                Map.Entry<K, V> entry = this.s;
                if (entry != null) {
                    V value = entry.getValue();
                    it2.remove();
                    AbstractBiMap.this.P1(value);
                    this.s = null;
                    return;
                }
                throw new IllegalStateException("no calls to next() since the last call to remove()");
            }
        };
    }

    /* access modifiers changed from: package-private */
    public AbstractBiMap<V, K> L1(Map<V, K> map) {
        return new Inverse(map, this);
    }

    /* access modifiers changed from: package-private */
    public void Q1(Map<K, V> map, Map<V, K> map2) {
        boolean z = false;
        Preconditions.g0(this.s == null);
        Preconditions.g0(this.X == null);
        Preconditions.d(map.isEmpty());
        Preconditions.d(map2.isEmpty());
        if (map != map2) {
            z = true;
        }
        Preconditions.d(z);
        this.s = map;
        this.X = L1(map2);
    }

    /* access modifiers changed from: package-private */
    public void V1(AbstractBiMap<V, K> abstractBiMap) {
        this.X = abstractBiMap;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a1 */
    public Map<K, V> Z0() {
        return this.s;
    }

    public void clear() {
        this.s.clear();
        this.X.s.clear();
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return this.X.containsKey(obj);
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.X2;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.X2 = entrySet;
        return entrySet;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V k0(@ParametricNullness K k2, @ParametricNullness V v) {
        return M1(k2, v, true);
    }

    public Set<K> keySet() {
        Set<K> set = this.Y;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.Y = keySet;
        return keySet;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@ParametricNullness K k2, @ParametricNullness V v) {
        return M1(k2, v, false);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public BiMap<V, K> q2() {
        return this.X;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        if (containsKey(obj)) {
            return N1(obj);
        }
        return null;
    }

    public Set<V> values() {
        Set<V> set = this.Z;
        if (set != null) {
            return set;
        }
        ValueSet valueSet = new ValueSet();
        this.Z = valueSet;
        return valueSet;
    }

    AbstractBiMap(Map<K, V> map, Map<V, K> map2) {
        Q1(map, map2);
    }
}
