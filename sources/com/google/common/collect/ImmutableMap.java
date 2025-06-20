package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
@DoNotMock("Use ImmutableMap.of or another implementation")
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {
    static final Map.Entry<?, ?>[] X2 = new Map.Entry[0];
    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableSet<K> X;
    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableCollection<V> Y;
    @CheckForNull
    @LazyInit
    private transient ImmutableSetMultimap<K, V> Z;
    @RetainedWith
    @CheckForNull
    @LazyInit
    private transient ImmutableSet<Map.Entry<K, V>> s;

    @DoNotMock
    public static class Builder<K, V> {
        @CheckForNull

        /* renamed from: a  reason: collision with root package name */
        Comparator<? super V> f22390a;

        /* renamed from: b  reason: collision with root package name */
        Object[] f22391b;

        /* renamed from: c  reason: collision with root package name */
        int f22392c;

        /* renamed from: d  reason: collision with root package name */
        boolean f22393d;

        /* renamed from: e  reason: collision with root package name */
        DuplicateKey f22394e;

        static final class DuplicateKey {

            /* renamed from: a  reason: collision with root package name */
            private final Object f22395a;

            /* renamed from: b  reason: collision with root package name */
            private final Object f22396b;

            /* renamed from: c  reason: collision with root package name */
            private final Object f22397c;

            DuplicateKey(Object obj, Object obj2, Object obj3) {
                this.f22395a = obj;
                this.f22396b = obj2;
                this.f22397c = obj3;
            }

            /* access modifiers changed from: package-private */
            public IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f22395a + "=" + this.f22396b + " and " + this.f22395a + "=" + this.f22397c);
            }
        }

        public Builder() {
            this(4);
        }

        private ImmutableMap<K, V> b(boolean z) {
            Object[] objArr;
            DuplicateKey duplicateKey;
            DuplicateKey duplicateKey2;
            if (!z || (duplicateKey2 = this.f22394e) == null) {
                int i2 = this.f22392c;
                if (this.f22390a == null) {
                    objArr = this.f22391b;
                } else {
                    if (this.f22393d) {
                        this.f22391b = Arrays.copyOf(this.f22391b, i2 * 2);
                    }
                    objArr = this.f22391b;
                    if (!z) {
                        objArr = g(objArr, this.f22392c);
                        if (objArr.length < this.f22391b.length) {
                            i2 = objArr.length >>> 1;
                        }
                    }
                    m(objArr, i2, this.f22390a);
                }
                this.f22393d = true;
                RegularImmutableMap K = RegularImmutableMap.K(i2, objArr, this);
                if (!z || (duplicateKey = this.f22394e) == null) {
                    return K;
                }
                throw duplicateKey.a();
            }
            throw duplicateKey2.a();
        }

        private void f(int i2) {
            int i3 = i2 * 2;
            Object[] objArr = this.f22391b;
            if (i3 > objArr.length) {
                this.f22391b = Arrays.copyOf(objArr, ImmutableCollection.Builder.f(objArr.length, i3));
                this.f22393d = false;
            }
        }

        private Object[] g(Object[] objArr, int i2) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i3 = i2 - 1; i3 >= 0; i3--) {
                Object obj = objArr[i3 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i3);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[((i2 - bitSet.cardinality()) * 2)];
            int i4 = 0;
            int i5 = 0;
            while (i4 < i2 * 2) {
                if (bitSet.get(i4 >>> 1)) {
                    i4 += 2;
                } else {
                    int i6 = i5 + 1;
                    int i7 = i4 + 1;
                    Object obj2 = objArr[i4];
                    Objects.requireNonNull(obj2);
                    objArr2[i5] = obj2;
                    i5 += 2;
                    i4 += 2;
                    Object obj3 = objArr[i7];
                    Objects.requireNonNull(obj3);
                    objArr2[i6] = obj3;
                }
            }
            return objArr2;
        }

        static <V> void m(Object[] objArr, int i2, Comparator<? super V> comparator) {
            Map.Entry[] entryArr = new Map.Entry[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = i3 * 2;
                Object obj = objArr[i4];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i4 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i3] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i2, Ordering.i(comparator).D(Maps.O0()));
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 * 2;
                objArr[i6] = entryArr[i5].getKey();
                objArr[i6 + 1] = entryArr[i5].getValue();
            }
        }

        public ImmutableMap<K, V> a() {
            return d();
        }

        public ImmutableMap<K, V> c() {
            return b(false);
        }

        public ImmutableMap<K, V> d() {
            return b(true);
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public Builder<K, V> e(Builder<K, V> builder) {
            Preconditions.E(builder);
            f(this.f22392c + builder.f22392c);
            System.arraycopy(builder.f22391b, 0, this.f22391b, this.f22392c * 2, builder.f22392c * 2);
            this.f22392c += builder.f22392c;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> h(Comparator<? super V> comparator) {
            Preconditions.h0(this.f22390a == null, "valueComparator was already set");
            this.f22390a = (Comparator) Preconditions.F(comparator, "valueComparator");
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> i(K k2, V v) {
            f(this.f22392c + 1);
            CollectPreconditions.a(k2, v);
            Object[] objArr = this.f22391b;
            int i2 = this.f22392c;
            objArr[i2 * 2] = k2;
            objArr[(i2 * 2) + 1] = v;
            this.f22392c = i2 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> j(Map.Entry<? extends K, ? extends V> entry) {
            return i(entry.getKey(), entry.getValue());
        }

        @CanIgnoreReturnValue
        public Builder<K, V> k(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            if (iterable instanceof Collection) {
                f(this.f22392c + ((Collection) iterable).size());
            }
            for (Map.Entry j2 : iterable) {
                j(j2);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> l(Map<? extends K, ? extends V> map) {
            return k(map.entrySet());
        }

        Builder(int i2) {
            this.f22391b = new Object[(i2 * 2)];
            this.f22392c = 0;
            this.f22393d = false;
        }
    }

    static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        IteratorBasedImmutableMap() {
        }

        /* access modifiers changed from: package-private */
        public abstract UnmodifiableIterator<Map.Entry<K, V>> J();

        public /* bridge */ /* synthetic */ Set entrySet() {
            return ImmutableMap.super.entrySet();
        }

        /* access modifiers changed from: package-private */
        public ImmutableSet<Map.Entry<K, V>> h() {
            return new ImmutableMapEntrySet<K, V>() {
                /* access modifiers changed from: package-private */
                public ImmutableMap<K, V> U() {
                    return IteratorBasedImmutableMap.this;
                }

                /* renamed from: k */
                public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
                    return IteratorBasedImmutableMap.this.J();
                }
            };
        }

        /* access modifiers changed from: package-private */
        public ImmutableSet<K> i() {
            return new ImmutableMapKeySet(this);
        }

        /* access modifiers changed from: package-private */
        public ImmutableCollection<V> j() {
            return new ImmutableMapValues(this);
        }

        public /* bridge */ /* synthetic */ Set keySet() {
            return ImmutableMap.super.keySet();
        }

        public /* bridge */ /* synthetic */ Collection values() {
            return ImmutableMap.super.values();
        }
    }

    private final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {
        private MapViewOfValuesAsSingletonSets() {
        }

        /* access modifiers changed from: package-private */
        public UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> J() {
            final UnmodifiableIterator k2 = ImmutableMap.this.entrySet().iterator();
            return new UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>>(this) {
                /* renamed from: a */
                public Map.Entry<K, ImmutableSet<V>> next() {
                    final Map.Entry entry = (Map.Entry) k2.next();
                    return new AbstractMapEntry<K, ImmutableSet<V>>(this) {
                        /* renamed from: a */
                        public ImmutableSet<V> getValue() {
                            return ImmutableSet.L(entry.getValue());
                        }

                        public K getKey() {
                            return entry.getKey();
                        }
                    };
                }

                public boolean hasNext() {
                    return k2.hasNext();
                }
            };
        }

        @CheckForNull
        /* renamed from: K */
        public ImmutableSet<V> get(@CheckForNull Object obj) {
            Object obj2 = ImmutableMap.this.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.L(obj2);
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return ImmutableMap.this.containsKey(obj);
        }

        public int hashCode() {
            return ImmutableMap.this.hashCode();
        }

        /* access modifiers changed from: package-private */
        public ImmutableSet<K> i() {
            return ImmutableMap.this.keySet();
        }

        /* access modifiers changed from: package-private */
        public boolean m() {
            return ImmutableMap.this.m();
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return ImmutableMap.this.n();
        }

        public int size() {
            return ImmutableMap.this.size();
        }
    }

    @J2ktIncompatible
    static class SerializedForm<K, V> implements Serializable {
        private static final boolean Y = true;
        private static final long Z = 0;
        private final Object X;
        private final Object s;

        SerializedForm(ImmutableMap<K, V> immutableMap) {
            Object[] objArr = new Object[immutableMap.size()];
            Object[] objArr2 = new Object[immutableMap.size()];
            UnmodifiableIterator<Map.Entry<K, V>> k2 = immutableMap.entrySet().iterator();
            int i2 = 0;
            while (k2.hasNext()) {
                Map.Entry next = k2.next();
                objArr[i2] = next.getKey();
                objArr2[i2] = next.getValue();
                i2++;
            }
            this.s = objArr;
            this.X = objArr2;
        }

        /* access modifiers changed from: package-private */
        public final Object a() {
            Object[] objArr = (Object[]) this.s;
            Object[] objArr2 = (Object[]) this.X;
            Builder b2 = b(objArr.length);
            for (int i2 = 0; i2 < objArr.length; i2++) {
                b2.i(objArr[i2], objArr2[i2]);
            }
            return b2.d();
        }

        /* access modifiers changed from: package-private */
        public Builder<K, V> b(int i2) {
            return new Builder<>(i2);
        }

        /* access modifiers changed from: package-private */
        public final Object c() {
            Object obj = this.s;
            if (!(obj instanceof ImmutableSet)) {
                return a();
            }
            ImmutableSet immutableSet = (ImmutableSet) obj;
            Builder b2 = b(immutableSet.size());
            UnmodifiableIterator k2 = immutableSet.iterator();
            UnmodifiableIterator k3 = ((ImmutableCollection) this.X).iterator();
            while (k2.hasNext()) {
                b2.i(k2.next(), k3.next());
            }
            return b2.d();
        }
    }

    ImmutableMap() {
    }

    public static <K, V> ImmutableMap<K, V> A(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        return RegularImmutableMap.J(7, new Object[]{k2, v, k3, v2, k4, v3, k5, v4, k6, v5, k7, v6, k8, v7});
    }

    public static <K, V> ImmutableMap<K, V> B(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        return RegularImmutableMap.J(8, new Object[]{k2, v, k3, v2, k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8});
    }

    public static <K, V> ImmutableMap<K, V> C(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        CollectPreconditions.a(k10, v9);
        return RegularImmutableMap.J(9, new Object[]{k2, v, k3, v2, k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8, k10, v9});
    }

    public static <K, V> ImmutableMap<K, V> D(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9, K k11, V v10) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        CollectPreconditions.a(k8, v7);
        CollectPreconditions.a(k9, v8);
        CollectPreconditions.a(k10, v9);
        CollectPreconditions.a(k11, v10);
        return RegularImmutableMap.J(10, new Object[]{k2, v, k3, v2, k4, v3, k5, v4, k6, v5, k7, v6, k8, v7, k9, v8, k10, v9, k11, v10});
    }

    @SafeVarargs
    public static <K, V> ImmutableMap<K, V> E(Map.Entry<? extends K, ? extends V>... entryArr) {
        return f(Arrays.asList(entryArr));
    }

    @J2ktIncompatible
    private void F(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <K, V> Builder<K, V> b() {
        return new Builder<>();
    }

    public static <K, V> Builder<K, V> c(int i2) {
        CollectPreconditions.b(i2, "expectedSize");
        return new Builder<>(i2);
    }

    static void d(boolean z, String str, Object obj, Object obj2) {
        if (!z) {
            throw e(str, obj, obj2);
        }
    }

    static IllegalArgumentException e(String str, Object obj, Object obj2) {
        return new IllegalArgumentException("Multiple entries with same " + str + ": " + obj + " and " + obj2);
    }

    public static <K, V> ImmutableMap<K, V> f(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Builder builder = new Builder(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        builder.k(iterable);
        return builder.a();
    }

    public static <K, V> ImmutableMap<K, V> g(Map<? extends K, ? extends V> map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap<K, V> immutableMap = (ImmutableMap) map;
            if (!immutableMap.n()) {
                return immutableMap;
            }
        }
        return f(map.entrySet());
    }

    static <K, V> Map.Entry<K, V> k(K k2, V v) {
        CollectPreconditions.a(k2, v);
        return new AbstractMap.SimpleImmutableEntry(k2, v);
    }

    public static <K, V> ImmutableMap<K, V> s() {
        return RegularImmutableMap.g3;
    }

    public static <K, V> ImmutableMap<K, V> t(K k2, V v) {
        CollectPreconditions.a(k2, v);
        return RegularImmutableMap.J(1, new Object[]{k2, v});
    }

    public static <K, V> ImmutableMap<K, V> u(K k2, V v, K k3, V v2) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        return RegularImmutableMap.J(2, new Object[]{k2, v, k3, v2});
    }

    public static <K, V> ImmutableMap<K, V> v(K k2, V v, K k3, V v2, K k4, V v3) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        return RegularImmutableMap.J(3, new Object[]{k2, v, k3, v2, k4, v3});
    }

    public static <K, V> ImmutableMap<K, V> w(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        return RegularImmutableMap.J(4, new Object[]{k2, v, k3, v2, k4, v3, k5, v4});
    }

    public static <K, V> ImmutableMap<K, V> y(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        return RegularImmutableMap.J(5, new Object[]{k2, v, k3, v2, k4, v3, k5, v4, k6, v5});
    }

    public static <K, V> ImmutableMap<K, V> z(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6) {
        CollectPreconditions.a(k2, v);
        CollectPreconditions.a(k3, v2);
        CollectPreconditions.a(k4, v3);
        CollectPreconditions.a(k5, v4);
        CollectPreconditions.a(k6, v5);
        CollectPreconditions.a(k7, v6);
        return RegularImmutableMap.J(6, new Object[]{k2, v, k3, v2, k4, v3, k5, v4, k6, v5, k7, v6});
    }

    /* renamed from: H */
    public ImmutableCollection<V> values() {
        ImmutableCollection<V> immutableCollection = this.Y;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection<V> j2 = j();
        this.Y = j2;
        return j2;
    }

    /* access modifiers changed from: package-private */
    @J2ktIncompatible
    public Object I() {
        return new SerializedForm(this);
    }

    public ImmutableSetMultimap<K, V> a() {
        if (isEmpty()) {
            return ImmutableSetMultimap.V();
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap = this.Z;
        if (immutableSetMultimap != null) {
            return immutableSetMultimap;
        }
        ImmutableSetMultimap<K, V> immutableSetMultimap2 = new ImmutableSetMultimap<>(new MapViewOfValuesAsSingletonSets(), size(), (Comparator) null);
        this.Z = immutableSetMultimap2;
        return immutableSetMultimap2;
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return values().contains(obj);
    }

    public boolean equals(@CheckForNull Object obj) {
        return Maps.w(this, obj);
    }

    @CheckForNull
    public abstract V get(@CheckForNull Object obj);

    @CheckForNull
    public final V getOrDefault(@CheckForNull Object obj, @CheckForNull V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    /* access modifiers changed from: package-private */
    public abstract ImmutableSet<Map.Entry<K, V>> h();

    public int hashCode() {
        return Sets.k(entrySet());
    }

    /* access modifiers changed from: package-private */
    public abstract ImmutableSet<K> i();

    public boolean isEmpty() {
        return size() == 0;
    }

    /* access modifiers changed from: package-private */
    public abstract ImmutableCollection<V> j();

    /* renamed from: l */
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        ImmutableSet<Map.Entry<K, V>> immutableSet = this.s;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Map.Entry<K, V>> h2 = h();
        this.s = h2;
        return h2;
    }

    /* access modifiers changed from: package-private */
    public boolean m() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean n();

    /* access modifiers changed from: package-private */
    public UnmodifiableIterator<K> o() {
        final UnmodifiableIterator k2 = entrySet().iterator();
        return new UnmodifiableIterator<K>(this) {
            public boolean hasNext() {
                return k2.hasNext();
            }

            public K next() {
                return ((Map.Entry) k2.next()).getKey();
            }
        };
    }

    /* renamed from: p */
    public ImmutableSet<K> keySet() {
        ImmutableSet<K> immutableSet = this.X;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<K> i2 = i();
        this.X = i2;
        return i2;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final V put(K k2, V v) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @Deprecated
    public final V remove(@CheckForNull Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return Maps.w0(this);
    }
}
