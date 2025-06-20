package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class HashBiMap<K, V> extends AbstractMap<K, V> implements BiMap<K, V>, Serializable {
    private static final int j3 = -1;
    private static final int k3 = -2;
    transient V[] X;
    private transient int[] X2;
    transient int Y;
    private transient int[] Y2;
    transient int Z;
    private transient int[] Z2;
    private transient int[] a3;
    /* access modifiers changed from: private */
    public transient int b3;
    private transient int c3;
    private transient int[] d3;
    /* access modifiers changed from: private */
    public transient int[] e3;
    @LazyInit
    private transient Set<K> f3;
    @LazyInit
    private transient Set<V> g3;
    @LazyInit
    private transient Set<Map.Entry<K, V>> h3;
    /* access modifiers changed from: private */
    @RetainedWith
    @CheckForNull
    @LazyInit
    public transient BiMap<V, K> i3;
    transient K[] s;

    final class EntryForKey extends AbstractMapEntry<K, V> {
        int X;
        @ParametricNullness
        final K s;

        EntryForKey(int i2) {
            this.s = NullnessCasts.a(HashBiMap.this.s[i2]);
            this.X = i2;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            int i2 = this.X;
            if (i2 != -1) {
                HashBiMap hashBiMap = HashBiMap.this;
                if (i2 <= hashBiMap.Y && Objects.a(hashBiMap.s[i2], this.s)) {
                    return;
                }
            }
            this.X = HashBiMap.this.p(this.s);
        }

        @ParametricNullness
        public K getKey() {
            return this.s;
        }

        @ParametricNullness
        public V getValue() {
            a();
            int i2 = this.X;
            return i2 == -1 ? NullnessCasts.b() : NullnessCasts.a(HashBiMap.this.X[i2]);
        }

        @ParametricNullness
        public V setValue(@ParametricNullness V v) {
            a();
            int i2 = this.X;
            if (i2 == -1) {
                HashBiMap.this.put(this.s, v);
                return NullnessCasts.b();
            }
            V a2 = NullnessCasts.a(HashBiMap.this.X[i2]);
            if (Objects.a(a2, v)) {
                return v;
            }
            HashBiMap.this.M(this.X, v, false);
            return a2;
        }
    }

    static final class EntryForValue<K, V> extends AbstractMapEntry<V, K> {
        @ParametricNullness
        final V X;
        int Y;
        final HashBiMap<K, V> s;

        EntryForValue(HashBiMap<K, V> hashBiMap, int i2) {
            this.s = hashBiMap;
            this.X = NullnessCasts.a(hashBiMap.X[i2]);
            this.Y = i2;
        }

        private void a() {
            int i2 = this.Y;
            if (i2 != -1) {
                HashBiMap<K, V> hashBiMap = this.s;
                if (i2 <= hashBiMap.Y && Objects.a(this.X, hashBiMap.X[i2])) {
                    return;
                }
            }
            this.Y = this.s.t(this.X);
        }

        @ParametricNullness
        public V getKey() {
            return this.X;
        }

        @ParametricNullness
        public K getValue() {
            a();
            int i2 = this.Y;
            return i2 == -1 ? NullnessCasts.b() : NullnessCasts.a(this.s.s[i2]);
        }

        @ParametricNullness
        public K setValue(@ParametricNullness K k2) {
            a();
            int i2 = this.Y;
            if (i2 == -1) {
                this.s.C(this.X, k2, false);
                return NullnessCasts.b();
            }
            K a2 = NullnessCasts.a(this.s.s[i2]);
            if (Objects.a(a2, k2)) {
                return k2;
            }
            this.s.K(this.Y, k2, false);
            return a2;
        }
    }

    final class EntrySet extends View<K, V, Map.Entry<K, V>> {
        EntrySet() {
            super(HashBiMap.this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public Map.Entry<K, V> b(int i2) {
            return new EntryForKey(i2);
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int p = HashBiMap.this.p(key);
            return p != -1 && Objects.a(value, HashBiMap.this.X[p]);
        }

        @CanIgnoreReturnValue
        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int d2 = Hashing.d(key);
            int s = HashBiMap.this.s(key, d2);
            if (s == -1 || !Objects.a(value, HashBiMap.this.X[s])) {
                return false;
            }
            HashBiMap.this.H(s, d2);
            return true;
        }
    }

    static class Inverse<K, V> extends AbstractMap<V, K> implements BiMap<V, K>, Serializable {
        private transient Set<Map.Entry<V, K>> X;
        private final HashBiMap<K, V> s;

        Inverse(HashBiMap<K, V> hashBiMap) {
            this.s = hashBiMap;
        }

        @GwtIncompatible("serialization")
        private void a(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            BiMap unused = this.s.i3 = this;
        }

        public void clear() {
            this.s.clear();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return this.s.containsValue(obj);
        }

        public boolean containsValue(@CheckForNull Object obj) {
            return this.s.containsKey(obj);
        }

        public Set<Map.Entry<V, K>> entrySet() {
            Set<Map.Entry<V, K>> set = this.X;
            if (set != null) {
                return set;
            }
            InverseEntrySet inverseEntrySet = new InverseEntrySet(this.s);
            this.X = inverseEntrySet;
            return inverseEntrySet;
        }

        @CheckForNull
        public K get(@CheckForNull Object obj) {
            return this.s.v(obj);
        }

        @CanIgnoreReturnValue
        @CheckForNull
        public K k0(@ParametricNullness V v, @ParametricNullness K k2) {
            return this.s.C(v, k2, true);
        }

        public Set<V> keySet() {
            return this.s.values();
        }

        @CanIgnoreReturnValue
        @CheckForNull
        public K put(@ParametricNullness V v, @ParametricNullness K k2) {
            return this.s.C(v, k2, false);
        }

        public BiMap<K, V> q2() {
            return this.s;
        }

        @CanIgnoreReturnValue
        @CheckForNull
        public K remove(@CheckForNull Object obj) {
            return this.s.J(obj);
        }

        public int size() {
            return this.s.Y;
        }

        public Set<K> values() {
            return this.s.keySet();
        }
    }

    static class InverseEntrySet<K, V> extends View<K, V, Map.Entry<V, K>> {
        InverseEntrySet(HashBiMap<K, V> hashBiMap) {
            super(hashBiMap);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public Map.Entry<V, K> b(int i2) {
            return new EntryForValue(this.s, i2);
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int t = this.s.t(key);
            return t != -1 && Objects.a(this.s.s[t], value);
        }

        public boolean remove(@CheckForNull Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            int d2 = Hashing.d(key);
            int u = this.s.u(key, d2);
            if (u == -1 || !Objects.a(this.s.s[u], value)) {
                return false;
            }
            this.s.I(u, d2);
            return true;
        }
    }

    final class KeySet extends View<K, V, K> {
        KeySet() {
            super(HashBiMap.this);
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public K b(int i2) {
            return NullnessCasts.a(HashBiMap.this.s[i2]);
        }

        public boolean contains(@CheckForNull Object obj) {
            return HashBiMap.this.containsKey(obj);
        }

        public boolean remove(@CheckForNull Object obj) {
            int d2 = Hashing.d(obj);
            int s = HashBiMap.this.s(obj, d2);
            if (s == -1) {
                return false;
            }
            HashBiMap.this.H(s, d2);
            return true;
        }
    }

    final class ValueSet extends View<K, V, V> {
        ValueSet() {
            super(HashBiMap.this);
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public V b(int i2) {
            return NullnessCasts.a(HashBiMap.this.X[i2]);
        }

        public boolean contains(@CheckForNull Object obj) {
            return HashBiMap.this.containsValue(obj);
        }

        public boolean remove(@CheckForNull Object obj) {
            int d2 = Hashing.d(obj);
            int u = HashBiMap.this.u(obj, d2);
            if (u == -1) {
                return false;
            }
            HashBiMap.this.I(u, d2);
            return true;
        }
    }

    static abstract class View<K, V, T> extends AbstractSet<T> {
        final HashBiMap<K, V> s;

        View(HashBiMap<K, V> hashBiMap) {
            this.s = hashBiMap;
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public abstract T b(int i2);

        public void clear() {
            this.s.clear();
        }

        public Iterator<T> iterator() {
            return new Iterator<T>() {
                private int X = -1;
                private int Y;
                private int Z;
                private int s;

                {
                    this.s = View.this.s.b3;
                    HashBiMap<K, V> hashBiMap = View.this.s;
                    this.Y = hashBiMap.Z;
                    this.Z = hashBiMap.Y;
                }

                private void a() {
                    if (View.this.s.Z != this.Y) {
                        throw new ConcurrentModificationException();
                    }
                }

                public boolean hasNext() {
                    a();
                    return this.s != -2 && this.Z > 0;
                }

                @ParametricNullness
                public T next() {
                    if (hasNext()) {
                        T b2 = View.this.b(this.s);
                        this.X = this.s;
                        this.s = View.this.s.e3[this.s];
                        this.Z--;
                        return b2;
                    }
                    throw new NoSuchElementException();
                }

                public void remove() {
                    a();
                    CollectPreconditions.e(this.X != -1);
                    View.this.s.E(this.X);
                    int i2 = this.s;
                    HashBiMap<K, V> hashBiMap = View.this.s;
                    if (i2 == hashBiMap.Y) {
                        this.s = this.X;
                    }
                    this.X = -1;
                    this.Y = hashBiMap.Z;
                }
            };
        }

        public int size() {
            return this.s.Y;
        }
    }

    private HashBiMap(int i2) {
        w(i2);
    }

    private void A(int i2, int i4) {
        int i5;
        int i6;
        if (i2 != i4) {
            int i7 = this.d3[i2];
            int i8 = this.e3[i2];
            N(i7, i4);
            N(i4, i8);
            K[] kArr = this.s;
            K k2 = kArr[i2];
            V[] vArr = this.X;
            V v = vArr[i2];
            kArr[i4] = k2;
            vArr[i4] = v;
            int f2 = f(Hashing.d(k2));
            int[] iArr = this.X2;
            int i9 = iArr[f2];
            if (i9 == i2) {
                iArr[f2] = i4;
            } else {
                int i10 = this.Z2[i9];
                while (true) {
                    int i11 = i9;
                    i9 = i10;
                    i6 = i11;
                    if (i9 == i2) {
                        break;
                    }
                    i10 = this.Z2[i9];
                }
                this.Z2[i6] = i4;
            }
            int[] iArr2 = this.Z2;
            iArr2[i4] = iArr2[i2];
            iArr2[i2] = -1;
            int f4 = f(Hashing.d(v));
            int[] iArr3 = this.Y2;
            int i12 = iArr3[f4];
            if (i12 == i2) {
                iArr3[f4] = i4;
            } else {
                int i13 = this.a3[i12];
                while (true) {
                    int i14 = i12;
                    i12 = i13;
                    i5 = i14;
                    if (i12 == i2) {
                        break;
                    }
                    i13 = this.a3[i12];
                }
                this.a3[i5] = i4;
            }
            int[] iArr4 = this.a3;
            iArr4[i4] = iArr4[i2];
            iArr4[i2] = -1;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void D(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int h2 = Serialization.h(objectInputStream);
        w(16);
        Serialization.c(this, objectInputStream, h2);
    }

    private void F(int i2, int i4, int i5) {
        Preconditions.d(i2 != -1);
        k(i2, i4);
        l(i2, i5);
        N(this.d3[i2], this.e3[i2]);
        A(this.Y - 1, i2);
        K[] kArr = this.s;
        int i6 = this.Y;
        kArr[i6 - 1] = null;
        this.X[i6 - 1] = null;
        this.Y = i6 - 1;
        this.Z++;
    }

    /* access modifiers changed from: private */
    public void K(int i2, @ParametricNullness K k2, boolean z) {
        int i4;
        Preconditions.d(i2 != -1);
        int d2 = Hashing.d(k2);
        int s2 = s(k2, d2);
        int i5 = this.c3;
        if (s2 == -1) {
            i4 = -2;
        } else if (z) {
            i5 = this.d3[s2];
            i4 = this.e3[s2];
            H(s2, d2);
            if (i2 == this.Y) {
                i2 = s2;
            }
        } else {
            throw new IllegalArgumentException("Key already present in map: " + k2);
        }
        if (i5 == i2) {
            i5 = this.d3[i2];
        } else if (i5 == this.Y) {
            i5 = s2;
        }
        if (i4 == i2) {
            s2 = this.e3[i2];
        } else if (i4 != this.Y) {
            s2 = i4;
        }
        N(this.d3[i2], this.e3[i2]);
        k(i2, Hashing.d(this.s[i2]));
        this.s[i2] = k2;
        y(i2, Hashing.d(k2));
        N(i5, i2);
        N(i2, s2);
    }

    /* access modifiers changed from: private */
    public void M(int i2, @ParametricNullness V v, boolean z) {
        Preconditions.d(i2 != -1);
        int d2 = Hashing.d(v);
        int u = u(v, d2);
        if (u != -1) {
            if (z) {
                I(u, d2);
                if (i2 == this.Y) {
                    i2 = u;
                }
            } else {
                throw new IllegalArgumentException("Value already present in map: " + v);
            }
        }
        l(i2, Hashing.d(this.X[i2]));
        this.X[i2] = v;
        z(i2, d2);
    }

    private void N(int i2, int i4) {
        if (i2 == -2) {
            this.b3 = i4;
        } else {
            this.e3[i2] = i4;
        }
        if (i4 == -2) {
            this.c3 = i2;
        } else {
            this.d3[i4] = i2;
        }
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void O(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.i(this, objectOutputStream);
    }

    private int f(int i2) {
        return i2 & (this.X2.length - 1);
    }

    public static <K, V> HashBiMap<K, V> g() {
        return h(16);
    }

    public static <K, V> HashBiMap<K, V> h(int i2) {
        return new HashBiMap<>(i2);
    }

    public static <K, V> HashBiMap<K, V> i(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> h2 = h(map.size());
        h2.putAll(map);
        return h2;
    }

    private static int[] j(int i2) {
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private void k(int i2, int i4) {
        Preconditions.d(i2 != -1);
        int f2 = f(i4);
        int[] iArr = this.X2;
        int i5 = iArr[f2];
        if (i5 == i2) {
            int[] iArr2 = this.Z2;
            iArr[f2] = iArr2[i2];
            iArr2[i2] = -1;
            return;
        }
        int i6 = this.Z2[i5];
        while (true) {
            int i7 = i5;
            i5 = i6;
            int i8 = i7;
            if (i5 == -1) {
                throw new AssertionError("Expected to find entry with key " + this.s[i2]);
            } else if (i5 == i2) {
                int[] iArr3 = this.Z2;
                iArr3[i8] = iArr3[i2];
                iArr3[i2] = -1;
                return;
            } else {
                i6 = this.Z2[i5];
            }
        }
    }

    private void l(int i2, int i4) {
        Preconditions.d(i2 != -1);
        int f2 = f(i4);
        int[] iArr = this.Y2;
        int i5 = iArr[f2];
        if (i5 == i2) {
            int[] iArr2 = this.a3;
            iArr[f2] = iArr2[i2];
            iArr2[i2] = -1;
            return;
        }
        int i6 = this.a3[i5];
        while (true) {
            int i7 = i5;
            i5 = i6;
            int i8 = i7;
            if (i5 == -1) {
                throw new AssertionError("Expected to find entry with value " + this.X[i2]);
            } else if (i5 == i2) {
                int[] iArr3 = this.a3;
                iArr3[i8] = iArr3[i2];
                iArr3[i2] = -1;
                return;
            } else {
                i6 = this.a3[i5];
            }
        }
    }

    private void m(int i2) {
        int[] iArr = this.Z2;
        if (iArr.length < i2) {
            int f2 = ImmutableCollection.Builder.f(iArr.length, i2);
            this.s = Arrays.copyOf(this.s, f2);
            this.X = Arrays.copyOf(this.X, f2);
            this.Z2 = n(this.Z2, f2);
            this.a3 = n(this.a3, f2);
            this.d3 = n(this.d3, f2);
            this.e3 = n(this.e3, f2);
        }
        if (this.X2.length < i2) {
            int a2 = Hashing.a(i2, 1.0d);
            this.X2 = j(a2);
            this.Y2 = j(a2);
            for (int i4 = 0; i4 < this.Y; i4++) {
                int f4 = f(Hashing.d(this.s[i4]));
                int[] iArr2 = this.Z2;
                int[] iArr3 = this.X2;
                iArr2[i4] = iArr3[f4];
                iArr3[f4] = i4;
                int f5 = f(Hashing.d(this.X[i4]));
                int[] iArr4 = this.a3;
                int[] iArr5 = this.Y2;
                iArr4[i4] = iArr5[f5];
                iArr5[f5] = i4;
            }
        }
    }

    private static int[] n(int[] iArr, int i2) {
        int length = iArr.length;
        int[] copyOf = Arrays.copyOf(iArr, i2);
        Arrays.fill(copyOf, length, i2, -1);
        return copyOf;
    }

    private void y(int i2, int i4) {
        Preconditions.d(i2 != -1);
        int f2 = f(i4);
        int[] iArr = this.Z2;
        int[] iArr2 = this.X2;
        iArr[i2] = iArr2[f2];
        iArr2[f2] = i2;
    }

    private void z(int i2, int i4) {
        Preconditions.d(i2 != -1);
        int f2 = f(i4);
        int[] iArr = this.a3;
        int[] iArr2 = this.Y2;
        iArr[i2] = iArr2[f2];
        iArr2[f2] = i2;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public V B(@ParametricNullness K k2, @ParametricNullness V v, boolean z) {
        int d2 = Hashing.d(k2);
        int s2 = s(k2, d2);
        if (s2 != -1) {
            V v2 = this.X[s2];
            if (Objects.a(v2, v)) {
                return v;
            }
            M(s2, v, z);
            return v2;
        }
        int d4 = Hashing.d(v);
        int u = u(v, d4);
        if (!z) {
            Preconditions.u(u == -1, "Value already present: %s", v);
        } else if (u != -1) {
            I(u, d4);
        }
        m(this.Y + 1);
        K[] kArr = this.s;
        int i2 = this.Y;
        kArr[i2] = k2;
        this.X[i2] = v;
        y(i2, d2);
        z(this.Y, d4);
        N(this.c3, this.Y);
        N(this.Y, -2);
        this.Y++;
        this.Z++;
        return null;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @CheckForNull
    public K C(@ParametricNullness V v, @ParametricNullness K k2, boolean z) {
        int d2 = Hashing.d(v);
        int u = u(v, d2);
        if (u != -1) {
            K k4 = this.s[u];
            if (Objects.a(k4, k2)) {
                return k2;
            }
            K(u, k2, z);
            return k4;
        }
        int i2 = this.c3;
        int d4 = Hashing.d(k2);
        int s2 = s(k2, d4);
        if (!z) {
            Preconditions.u(s2 == -1, "Key already present: %s", k2);
        } else if (s2 != -1) {
            i2 = this.d3[s2];
            H(s2, d4);
        }
        m(this.Y + 1);
        K[] kArr = this.s;
        int i4 = this.Y;
        kArr[i4] = k2;
        this.X[i4] = v;
        y(i4, d4);
        z(this.Y, d2);
        int i5 = i2 == -2 ? this.b3 : this.e3[i2];
        N(i2, this.Y);
        N(this.Y, i5);
        this.Y++;
        this.Z++;
        return null;
    }

    /* access modifiers changed from: package-private */
    public void E(int i2) {
        H(i2, Hashing.d(this.s[i2]));
    }

    /* access modifiers changed from: package-private */
    public void H(int i2, int i4) {
        F(i2, i4, Hashing.d(this.X[i2]));
    }

    /* access modifiers changed from: package-private */
    public void I(int i2, int i4) {
        F(i2, Hashing.d(this.s[i2]), i4);
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public K J(@CheckForNull Object obj) {
        int d2 = Hashing.d(obj);
        int u = u(obj, d2);
        if (u == -1) {
            return null;
        }
        K k2 = this.s[u];
        I(u, d2);
        return k2;
    }

    public void clear() {
        Arrays.fill(this.s, 0, this.Y, (Object) null);
        Arrays.fill(this.X, 0, this.Y, (Object) null);
        Arrays.fill(this.X2, -1);
        Arrays.fill(this.Y2, -1);
        Arrays.fill(this.Z2, 0, this.Y, -1);
        Arrays.fill(this.a3, 0, this.Y, -1);
        Arrays.fill(this.d3, 0, this.Y, -1);
        Arrays.fill(this.e3, 0, this.Y, -1);
        this.Y = 0;
        this.b3 = -2;
        this.c3 = -2;
        this.Z++;
    }

    public boolean containsKey(@CheckForNull Object obj) {
        return p(obj) != -1;
    }

    public boolean containsValue(@CheckForNull Object obj) {
        return t(obj) != -1;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.h3;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.h3 = entrySet;
        return entrySet;
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        int p = p(obj);
        if (p == -1) {
            return null;
        }
        return this.X[p];
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V k0(@ParametricNullness K k2, @ParametricNullness V v) {
        return B(k2, v, true);
    }

    public Set<K> keySet() {
        Set<K> set = this.f3;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.f3 = keySet;
        return keySet;
    }

    /* access modifiers changed from: package-private */
    public int o(@CheckForNull Object obj, int i2, int[] iArr, int[] iArr2, Object[] objArr) {
        int i4 = iArr[f(i2)];
        while (i4 != -1) {
            if (Objects.a(objArr[i4], obj)) {
                return i4;
            }
            i4 = iArr2[i4];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int p(@CheckForNull Object obj) {
        return s(obj, Hashing.d(obj));
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@ParametricNullness K k2, @ParametricNullness V v) {
        return B(k2, v, false);
    }

    public BiMap<V, K> q2() {
        BiMap<V, K> biMap = this.i3;
        if (biMap != null) {
            return biMap;
        }
        Inverse inverse = new Inverse(this);
        this.i3 = inverse;
        return inverse;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        int d2 = Hashing.d(obj);
        int s2 = s(obj, d2);
        if (s2 == -1) {
            return null;
        }
        V v = this.X[s2];
        H(s2, d2);
        return v;
    }

    /* access modifiers changed from: package-private */
    public int s(@CheckForNull Object obj, int i2) {
        return o(obj, i2, this.X2, this.Z2, this.s);
    }

    public int size() {
        return this.Y;
    }

    /* access modifiers changed from: package-private */
    public int t(@CheckForNull Object obj) {
        return u(obj, Hashing.d(obj));
    }

    /* access modifiers changed from: package-private */
    public int u(@CheckForNull Object obj, int i2) {
        return o(obj, i2, this.Y2, this.a3, this.X);
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public K v(@CheckForNull Object obj) {
        int t = t(obj);
        if (t == -1) {
            return null;
        }
        return this.s[t];
    }

    /* access modifiers changed from: package-private */
    public void w(int i2) {
        CollectPreconditions.b(i2, "expectedSize");
        int a2 = Hashing.a(i2, 1.0d);
        this.Y = 0;
        this.s = new Object[i2];
        this.X = new Object[i2];
        this.X2 = j(a2);
        this.Y2 = j(a2);
        this.Z2 = j(i2);
        this.a3 = j(i2);
        this.b3 = -2;
        this.c3 = -2;
        this.d3 = j(i2);
        this.e3 = j(i2);
    }

    public Set<V> values() {
        Set<V> set = this.g3;
        if (set != null) {
            return set;
        }
        ValueSet valueSet = new ValueSet();
        this.g3 = valueSet;
        return valueSet;
    }
}
