package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public final class ImmutableSortedMap<K, V> extends ImmutableSortedMapFauxverideShim<K, V> implements NavigableMap<K, V> {
    private static final Comparator<Comparable> b3 = Ordering.z();
    private static final ImmutableSortedMap<Comparable, Object> c3 = new ImmutableSortedMap<>(ImmutableSortedSet.u0(Ordering.z()), ImmutableList.I());
    private static final long d3 = 0;
    /* access modifiers changed from: private */
    public final transient RegularImmutableSortedSet<K> Y2;
    /* access modifiers changed from: private */
    public final transient ImmutableList<V> Z2;
    @CheckForNull
    private transient ImmutableSortedMap<K, V> a3;

    public static class Builder<K, V> extends ImmutableMap.Builder<K, V> {

        /* renamed from: f  reason: collision with root package name */
        private transient Object[] f22411f;

        /* renamed from: g  reason: collision with root package name */
        private transient Object[] f22412g;

        /* renamed from: h  reason: collision with root package name */
        private final Comparator<? super K> f22413h;

        public Builder(Comparator<? super K> comparator) {
            this(comparator, 4);
        }

        private void f(int i2) {
            Object[] objArr = this.f22411f;
            if (i2 > objArr.length) {
                int f2 = ImmutableCollection.Builder.f(objArr.length, i2);
                this.f22411f = Arrays.copyOf(this.f22411f, f2);
                this.f22412g = Arrays.copyOf(this.f22412g, f2);
            }
        }

        /* renamed from: n */
        public ImmutableSortedMap<K, V> a() {
            return d();
        }

        @DoNotCall
        @Deprecated
        /* renamed from: o */
        public final ImmutableSortedMap<K, V> c() {
            throw new UnsupportedOperationException("ImmutableSortedMap.Builder does not yet implement buildKeepingLast()");
        }

        /* renamed from: p */
        public ImmutableSortedMap<K, V> d() {
            int i2 = this.f22392c;
            if (i2 == 0) {
                return ImmutableSortedMap.l0(this.f22413h);
            }
            if (i2 != 1) {
                Object[] copyOf = Arrays.copyOf(this.f22411f, i2);
                Arrays.sort(copyOf, this.f22413h);
                Object[] objArr = new Object[this.f22392c];
                for (int i3 = 0; i3 < this.f22392c; i3++) {
                    if (i3 > 0) {
                        int i4 = i3 - 1;
                        if (this.f22413h.compare(copyOf[i4], copyOf[i3]) == 0) {
                            throw new IllegalArgumentException("keys required to be distinct but compared as equal: " + copyOf[i4] + " and " + copyOf[i3]);
                        }
                    }
                    Object obj = this.f22411f[i3];
                    Objects.requireNonNull(obj);
                    int binarySearch = Arrays.binarySearch(copyOf, obj, this.f22413h);
                    Object obj2 = this.f22412g[i3];
                    Objects.requireNonNull(obj2);
                    objArr[binarySearch] = obj2;
                }
                return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.o(copyOf), this.f22413h), ImmutableList.o(objArr));
            }
            Comparator<? super K> comparator = this.f22413h;
            Object obj3 = this.f22411f[0];
            Objects.requireNonNull(obj3);
            Object obj4 = this.f22412g[0];
            Objects.requireNonNull(obj4);
            return ImmutableSortedMap.K0(comparator, obj3, obj4);
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public Builder<K, V> q(Builder<K, V> builder) {
            f(this.f22392c + builder.f22392c);
            System.arraycopy(builder.f22411f, 0, this.f22411f, this.f22392c, builder.f22392c);
            System.arraycopy(builder.f22412g, 0, this.f22412g, this.f22392c, builder.f22392c);
            this.f22392c += builder.f22392c;
            return this;
        }

        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        /* renamed from: r */
        public final Builder<K, V> h(Comparator<? super V> comparator) {
            throw new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
        }

        @CanIgnoreReturnValue
        /* renamed from: s */
        public Builder<K, V> i(K k2, V v) {
            f(this.f22392c + 1);
            CollectPreconditions.a(k2, v);
            Object[] objArr = this.f22411f;
            int i2 = this.f22392c;
            objArr[i2] = k2;
            this.f22412g[i2] = v;
            this.f22392c = i2 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: t */
        public Builder<K, V> j(Map.Entry<? extends K, ? extends V> entry) {
            super.j(entry);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: u */
        public Builder<K, V> k(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
            super.k(iterable);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: v */
        public Builder<K, V> l(Map<? extends K, ? extends V> map) {
            super.l(map);
            return this;
        }

        private Builder(Comparator<? super K> comparator, int i2) {
            this.f22413h = (Comparator) Preconditions.E(comparator);
            this.f22411f = new Object[i2];
            this.f22412g = new Object[i2];
        }
    }

    @J2ktIncompatible
    private static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long Y2 = 0;
        private final Comparator<? super K> X2;

        SerializedForm(ImmutableSortedMap<K, V> immutableSortedMap) {
            super(immutableSortedMap);
            this.X2 = immutableSortedMap.comparator();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: d */
        public Builder<K, V> b(int i2) {
            return new Builder<>(this.X2);
        }
    }

    ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList) {
        this(regularImmutableSortedSet, immutableList, (ImmutableSortedMap) null);
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> A0(K k2, V v, K k3, V v2) {
        return o0(ImmutableMap.k(k2, v), ImmutableMap.k(k3, v2));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> B0(K k2, V v, K k3, V v2, K k4, V v3) {
        return o0(ImmutableMap.k(k2, v), ImmutableMap.k(k3, v2), ImmutableMap.k(k4, v3));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> C0(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4) {
        return o0(ImmutableMap.k(k2, v), ImmutableMap.k(k3, v2), ImmutableMap.k(k4, v3), ImmutableMap.k(k5, v4));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> D0(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5) {
        return o0(ImmutableMap.k(k2, v), ImmutableMap.k(k3, v2), ImmutableMap.k(k4, v3), ImmutableMap.k(k5, v4), ImmutableMap.k(k6, v5));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> E0(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6) {
        return o0(ImmutableMap.k(k2, v), ImmutableMap.k(k3, v2), ImmutableMap.k(k4, v3), ImmutableMap.k(k5, v4), ImmutableMap.k(k6, v5), ImmutableMap.k(k7, v6));
    }

    @J2ktIncompatible
    private void F(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> F0(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7) {
        return o0(ImmutableMap.k(k2, v), ImmutableMap.k(k3, v2), ImmutableMap.k(k4, v3), ImmutableMap.k(k5, v4), ImmutableMap.k(k6, v5), ImmutableMap.k(k7, v6), ImmutableMap.k(k8, v7));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> H0(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8) {
        return o0(ImmutableMap.k(k2, v), ImmutableMap.k(k3, v2), ImmutableMap.k(k4, v3), ImmutableMap.k(k5, v4), ImmutableMap.k(k6, v5), ImmutableMap.k(k7, v6), ImmutableMap.k(k8, v7), ImmutableMap.k(k9, v8));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> I0(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9) {
        return o0(ImmutableMap.k(k2, v), ImmutableMap.k(k3, v2), ImmutableMap.k(k4, v3), ImmutableMap.k(k5, v4), ImmutableMap.k(k6, v5), ImmutableMap.k(k7, v6), ImmutableMap.k(k8, v7), ImmutableMap.k(k9, v8), ImmutableMap.k(k10, v9));
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> J0(K k2, V v, K k3, V v2, K k4, V v3, K k5, V v4, K k6, V v5, K k7, V v6, K k8, V v7, K k9, V v8, K k10, V v9, K k11, V v10) {
        return o0(ImmutableMap.k(k2, v), ImmutableMap.k(k3, v2), ImmutableMap.k(k4, v3), ImmutableMap.k(k5, v4), ImmutableMap.k(k6, v5), ImmutableMap.k(k7, v6), ImmutableMap.k(k8, v7), ImmutableMap.k(k9, v8), ImmutableMap.k(k10, v9), ImmutableMap.k(k11, v10));
    }

    /* access modifiers changed from: private */
    public static <K, V> ImmutableSortedMap<K, V> K0(Comparator<? super K> comparator, K k2, V v) {
        return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.K(k2), (Comparator) Preconditions.E(comparator)), ImmutableList.K(v));
    }

    public static <K, V> Builder<K, V> L0(Comparator<K> comparator) {
        return new Builder<>(comparator);
    }

    public static <K extends Comparable<?>, V> Builder<K, V> M0() {
        return new Builder<>(Ordering.z().E());
    }

    public static <K, V> ImmutableSortedMap<K, V> b0(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        return c0(iterable, (Ordering) b3);
    }

    public static <K, V> ImmutableSortedMap<K, V> c0(Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable, Comparator<? super K> comparator) {
        return m0((Comparator) Preconditions.E(comparator), false, iterable);
    }

    public static <K, V> ImmutableSortedMap<K, V> d0(Map<? extends K, ? extends V> map) {
        return f0(map, (Ordering) b3);
    }

    public static <K, V> ImmutableSortedMap<K, V> e0(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        return f0(map, (Comparator) Preconditions.E(comparator));
    }

    private static <K, V> ImmutableSortedMap<K, V> f0(Map<? extends K, ? extends V> map, Comparator<? super K> comparator) {
        boolean z = false;
        if (map instanceof SortedMap) {
            Comparator comparator2 = ((SortedMap) map).comparator();
            if (comparator2 != null) {
                z = comparator.equals(comparator2);
            } else if (comparator == b3) {
                z = true;
            }
        }
        if (z && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap<K, V> immutableSortedMap = (ImmutableSortedMap) map;
            if (!immutableSortedMap.n()) {
                return immutableSortedMap;
            }
        }
        return m0(comparator, z, map.entrySet());
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.SortedMap<K, ? extends V>, java.util.SortedMap] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <K, V> com.google.common.collect.ImmutableSortedMap<K, V> h0(java.util.SortedMap<K, ? extends V> r3) {
        /*
            java.util.Comparator r0 = r3.comparator()
            if (r0 != 0) goto L_0x0008
            java.util.Comparator<java.lang.Comparable> r0 = b3
        L_0x0008:
            boolean r1 = r3 instanceof com.google.common.collect.ImmutableSortedMap
            if (r1 == 0) goto L_0x0016
            r1 = r3
            com.google.common.collect.ImmutableSortedMap r1 = (com.google.common.collect.ImmutableSortedMap) r1
            boolean r2 = r1.n()
            if (r2 != 0) goto L_0x0016
            return r1
        L_0x0016:
            r1 = 1
            java.util.Set r3 = r3.entrySet()
            com.google.common.collect.ImmutableSortedMap r3 = m0(r0, r1, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableSortedMap.h0(java.util.SortedMap):com.google.common.collect.ImmutableSortedMap");
    }

    static <K, V> ImmutableSortedMap<K, V> l0(Comparator<? super K> comparator) {
        return Ordering.z().equals(comparator) ? y0() : new ImmutableSortedMap<>(ImmutableSortedSet.u0(comparator), ImmutableList.I());
    }

    private static <K, V> ImmutableSortedMap<K, V> m0(Comparator<? super K> comparator, boolean z, Iterable<? extends Map.Entry<? extends K, ? extends V>> iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) Iterables.R(iterable, ImmutableMap.X2);
        return n0(comparator, z, entryArr, entryArr.length);
    }

    private static <K, V> ImmutableSortedMap<K, V> n0(Comparator<? super K> comparator, boolean z, Map.Entry<K, V>[] entryArr, int i2) {
        if (i2 == 0) {
            return l0(comparator);
        }
        if (i2 != 1) {
            Object[] objArr = new Object[i2];
            Object[] objArr2 = new Object[i2];
            if (z) {
                for (int i3 = 0; i3 < i2; i3++) {
                    Map.Entry<K, V> entry = entryArr[i3];
                    Objects.requireNonNull(entry);
                    Map.Entry entry2 = entry;
                    Object key = entry2.getKey();
                    Object value = entry2.getValue();
                    CollectPreconditions.a(key, value);
                    objArr[i3] = key;
                    objArr2[i3] = value;
                }
            } else {
                Arrays.sort(entryArr, 0, i2, new C0470e(comparator));
                Map.Entry<K, V> entry3 = entryArr[0];
                Objects.requireNonNull(entry3);
                Map.Entry entry4 = entry3;
                Object key2 = entry4.getKey();
                objArr[0] = key2;
                Object value2 = entry4.getValue();
                objArr2[0] = value2;
                CollectPreconditions.a(objArr[0], value2);
                int i4 = 1;
                while (i4 < i2) {
                    Map.Entry<K, V> entry5 = entryArr[i4 - 1];
                    Objects.requireNonNull(entry5);
                    Map.Entry entry6 = entry5;
                    Map.Entry<K, V> entry7 = entryArr[i4];
                    Objects.requireNonNull(entry7);
                    Map.Entry entry8 = entry7;
                    Object key3 = entry8.getKey();
                    Object value3 = entry8.getValue();
                    CollectPreconditions.a(key3, value3);
                    objArr[i4] = key3;
                    objArr2[i4] = value3;
                    ImmutableMap.d(comparator.compare(key2, key3) != 0, "key", entry6, entry8);
                    i4++;
                    key2 = key3;
                }
            }
            return new ImmutableSortedMap<>(new RegularImmutableSortedSet(ImmutableList.o(objArr), comparator), ImmutableList.o(objArr2));
        }
        Map.Entry<K, V> entry9 = entryArr[0];
        Objects.requireNonNull(entry9);
        Map.Entry entry10 = entry9;
        return K0(comparator, entry10.getKey(), entry10.getValue());
    }

    private static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> o0(Map.Entry<K, V>... entryArr) {
        return n0(Ordering.z(), false, entryArr, entryArr.length);
    }

    private ImmutableSortedMap<K, V> p0(int i2, int i3) {
        if (i2 == 0 && i3 == size()) {
            return this;
        }
        return i2 == i3 ? l0(comparator()) : new ImmutableSortedMap<>(this.Y2.X0(i2, i3), this.Z2.subList(i2, i3));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int v0(Comparator comparator, Map.Entry entry, Map.Entry entry2) {
        Objects.requireNonNull(entry);
        Objects.requireNonNull(entry2);
        return comparator.compare(entry.getKey(), entry2.getKey());
    }

    public static <K extends Comparable<?>, V> Builder<K, V> w0() {
        return new Builder<>(Ordering.z());
    }

    public static <K, V> ImmutableSortedMap<K, V> y0() {
        return c3;
    }

    public static <K extends Comparable<? super K>, V> ImmutableSortedMap<K, V> z0(K k2, V v) {
        return K0(Ordering.z(), k2, v);
    }

    /* renamed from: H */
    public ImmutableCollection<V> values() {
        return this.Z2;
    }

    /* access modifiers changed from: package-private */
    @J2ktIncompatible
    public Object I() {
        return new SerializedForm(this);
    }

    /* renamed from: N0 */
    public ImmutableSortedMap<K, V> subMap(K k2, K k3) {
        return subMap(k2, true, k3, false);
    }

    /* renamed from: O0 */
    public ImmutableSortedMap<K, V> subMap(K k2, boolean z, K k3, boolean z2) {
        Preconditions.E(k2);
        Preconditions.E(k3);
        Preconditions.y(comparator().compare(k2, k3) <= 0, "expected fromKey <= toKey but %s > %s", k2, k3);
        return headMap(k3, z2).tailMap(k2, z);
    }

    /* renamed from: P0 */
    public ImmutableSortedMap<K, V> tailMap(K k2) {
        return tailMap(k2, true);
    }

    /* renamed from: Q0 */
    public ImmutableSortedMap<K, V> tailMap(K k2, boolean z) {
        return p0(this.Y2.a1(Preconditions.E(k2), z), size());
    }

    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(K k2) {
        return tailMap(k2, true).firstEntry();
    }

    @CheckForNull
    public K ceilingKey(K k2) {
        return Maps.T(ceilingEntry(k2));
    }

    public Comparator<? super K> comparator() {
        return p().comparator();
    }

    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().b().get(0);
    }

    public K firstKey() {
        return p().first();
    }

    @CheckForNull
    public Map.Entry<K, V> floorEntry(K k2) {
        return headMap(k2, true).lastEntry();
    }

    @CheckForNull
    public K floorKey(K k2) {
        return Maps.T(floorEntry(k2));
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        int indexOf = this.Y2.indexOf(obj);
        if (indexOf == -1) {
            return null;
        }
        return this.Z2.get(indexOf);
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<Map.Entry<K, V>> h() {
        return isEmpty() ? ImmutableSet.K() : new ImmutableMapEntrySet<K, V>() {
            /* access modifiers changed from: package-private */
            public ImmutableList<Map.Entry<K, V>> H() {
                return new ImmutableList<Map.Entry<K, V>>() {
                    /* renamed from: e0 */
                    public Map.Entry<K, V> get(int i2) {
                        return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.Y2.b().get(i2), ImmutableSortedMap.this.Z2.get(i2));
                    }

                    /* access modifiers changed from: package-private */
                    public boolean j() {
                        return true;
                    }

                    public int size() {
                        return ImmutableSortedMap.this.size();
                    }
                };
            }

            /* access modifiers changed from: package-private */
            public ImmutableMap<K, V> U() {
                return ImmutableSortedMap.this;
            }

            /* renamed from: k */
            public UnmodifiableIterator<Map.Entry<K, V>> iterator() {
                return b().iterator();
            }
        };
    }

    @CheckForNull
    public Map.Entry<K, V> higherEntry(K k2) {
        return tailMap(k2, false).firstEntry();
    }

    @CheckForNull
    public K higherKey(K k2) {
        return Maps.T(higherEntry(k2));
    }

    /* access modifiers changed from: package-private */
    public ImmutableSet<K> i() {
        throw new AssertionError("should never be called");
    }

    /* renamed from: i0 */
    public ImmutableSortedSet<K> descendingKeySet() {
        return this.Y2.descendingSet();
    }

    /* access modifiers changed from: package-private */
    public ImmutableCollection<V> j() {
        throw new AssertionError("should never be called");
    }

    /* renamed from: j0 */
    public ImmutableSortedMap<K, V> descendingMap() {
        ImmutableSortedMap<K, V> immutableSortedMap = this.a3;
        if (immutableSortedMap == null) {
            return isEmpty() ? l0(Ordering.i(comparator()).E()) : new ImmutableSortedMap<>((RegularImmutableSortedSet) this.Y2.descendingSet(), this.Z2.Y(), this);
        }
        return immutableSortedMap;
    }

    /* renamed from: l */
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return super.entrySet();
    }

    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().b().get(size() - 1);
    }

    public K lastKey() {
        return p().last();
    }

    @CheckForNull
    public Map.Entry<K, V> lowerEntry(K k2) {
        return headMap(k2, false).lastEntry();
    }

    @CheckForNull
    public K lowerKey(K k2) {
        return Maps.T(lowerEntry(k2));
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return this.Y2.j() || this.Z2.j();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final Map.Entry<K, V> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final Map.Entry<K, V> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: r0 */
    public ImmutableSortedMap<K, V> headMap(K k2) {
        return headMap(k2, false);
    }

    public int size() {
        return this.Z2.size();
    }

    /* renamed from: t0 */
    public ImmutableSortedMap<K, V> headMap(K k2, boolean z) {
        return p0(0, this.Y2.Z0(Preconditions.E(k2), z));
    }

    /* renamed from: u0 */
    public ImmutableSortedSet<K> p() {
        return this.Y2;
    }

    /* renamed from: x0 */
    public ImmutableSortedSet<K> navigableKeySet() {
        return this.Y2;
    }

    ImmutableSortedMap(RegularImmutableSortedSet<K> regularImmutableSortedSet, ImmutableList<V> immutableList, @CheckForNull ImmutableSortedMap<K, V> immutableSortedMap) {
        this.Y2 = regularImmutableSortedSet;
        this.Z2 = immutableList;
        this.a3 = immutableSortedMap;
    }
}
