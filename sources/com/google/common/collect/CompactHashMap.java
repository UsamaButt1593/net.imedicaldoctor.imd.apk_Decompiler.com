package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
class CompactHashMap<K, V> extends AbstractMap<K, V> implements Serializable {
    /* access modifiers changed from: private */
    public static final Object c3 = new Object();
    @VisibleForTesting
    static final double d3 = 0.001d;
    private static final int e3 = 9;
    @CheckForNull
    @VisibleForTesting
    transient int[] X;
    /* access modifiers changed from: private */
    public transient int X2;
    @CheckForNull
    @VisibleForTesting
    transient Object[] Y;
    private transient int Y2;
    @CheckForNull
    @VisibleForTesting
    transient Object[] Z;
    @CheckForNull
    @LazyInit
    private transient Set<K> Z2;
    @CheckForNull
    @LazyInit
    private transient Set<Map.Entry<K, V>> a3;
    @CheckForNull
    @LazyInit
    private transient Collection<V> b3;
    @CheckForNull
    private transient Object s;

    class EntrySetView extends AbstractSet<Map.Entry<K, V>> {
        EntrySetView() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            Map A = CompactHashMap.this.A();
            if (A != null) {
                return A.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int i2 = CompactHashMap.this.I(entry.getKey());
            return i2 != -1 && Objects.a(CompactHashMap.this.e0(i2), entry.getValue());
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return CompactHashMap.this.C();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0021, code lost:
            r0 = com.google.common.collect.CompactHashMap.k(r9.s);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean remove(@javax.annotation.CheckForNull java.lang.Object r10) {
            /*
                r9 = this;
                com.google.common.collect.CompactHashMap r0 = com.google.common.collect.CompactHashMap.this
                java.util.Map r0 = r0.A()
                if (r0 == 0) goto L_0x0011
                java.util.Set r0 = r0.entrySet()
                boolean r10 = r0.remove(r10)
                return r10
            L_0x0011:
                boolean r0 = r10 instanceof java.util.Map.Entry
                r1 = 0
                if (r0 == 0) goto L_0x0061
                java.util.Map$Entry r10 = (java.util.Map.Entry) r10
                com.google.common.collect.CompactHashMap r0 = com.google.common.collect.CompactHashMap.this
                boolean r0 = r0.P()
                if (r0 == 0) goto L_0x0021
                return r1
            L_0x0021:
                com.google.common.collect.CompactHashMap r0 = com.google.common.collect.CompactHashMap.this
                int r0 = r0.F()
                java.lang.Object r2 = r10.getKey()
                java.lang.Object r3 = r10.getValue()
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                java.lang.Object r5 = r10.U()
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                int[] r6 = r10.S()
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                java.lang.Object[] r7 = r10.T()
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                java.lang.Object[] r8 = r10.V()
                r4 = r0
                int r10 = com.google.common.collect.CompactHashing.f(r2, r3, r4, r5, r6, r7, r8)
                r2 = -1
                if (r10 != r2) goto L_0x0050
                return r1
            L_0x0050:
                com.google.common.collect.CompactHashMap r1 = com.google.common.collect.CompactHashMap.this
                r1.O(r10, r0)
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                com.google.common.collect.CompactHashMap.e(r10)
                com.google.common.collect.CompactHashMap r10 = com.google.common.collect.CompactHashMap.this
                r10.H()
                r10 = 1
                return r10
            L_0x0061:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.CompactHashMap.EntrySetView.remove(java.lang.Object):boolean");
        }

        public int size() {
            return CompactHashMap.this.size();
        }
    }

    private abstract class Itr<T> implements Iterator<T> {
        int X;
        int Y;
        int s;

        private Itr() {
            this.s = CompactHashMap.this.X2;
            this.X = CompactHashMap.this.D();
            this.Y = -1;
        }

        private void a() {
            if (CompactHashMap.this.X2 != this.s) {
                throw new ConcurrentModificationException();
            }
        }

        /* access modifiers changed from: package-private */
        @ParametricNullness
        public abstract T b(int i2);

        /* access modifiers changed from: package-private */
        public void c() {
            this.s += 32;
        }

        public boolean hasNext() {
            return this.X >= 0;
        }

        @ParametricNullness
        public T next() {
            a();
            if (hasNext()) {
                int i2 = this.X;
                this.Y = i2;
                T b2 = b(i2);
                this.X = CompactHashMap.this.E(this.X);
                return b2;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            a();
            CollectPreconditions.e(this.Y >= 0);
            c();
            CompactHashMap compactHashMap = CompactHashMap.this;
            compactHashMap.remove(compactHashMap.M(this.Y));
            this.X = CompactHashMap.this.o(this.X, this.Y);
            this.Y = -1;
        }
    }

    class KeySetView extends AbstractSet<K> {
        KeySetView() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            return CompactHashMap.this.containsKey(obj);
        }

        public Iterator<K> iterator() {
            return CompactHashMap.this.N();
        }

        public boolean remove(@CheckForNull Object obj) {
            Map A = CompactHashMap.this.A();
            return A != null ? A.keySet().remove(obj) : CompactHashMap.this.R(obj) != CompactHashMap.c3;
        }

        public int size() {
            return CompactHashMap.this.size();
        }
    }

    final class MapEntry extends AbstractMapEntry<K, V> {
        private int X;
        @ParametricNullness
        private final K s;

        MapEntry(int i2) {
            this.s = CompactHashMap.this.M(i2);
            this.X = i2;
        }

        private void a() {
            int i2 = this.X;
            if (i2 == -1 || i2 >= CompactHashMap.this.size() || !Objects.a(this.s, CompactHashMap.this.M(this.X))) {
                this.X = CompactHashMap.this.I(this.s);
            }
        }

        @ParametricNullness
        public K getKey() {
            return this.s;
        }

        @ParametricNullness
        public V getValue() {
            Map A = CompactHashMap.this.A();
            if (A != null) {
                return NullnessCasts.a(A.get(this.s));
            }
            a();
            int i2 = this.X;
            return i2 == -1 ? NullnessCasts.b() : CompactHashMap.this.e0(i2);
        }

        @ParametricNullness
        public V setValue(@ParametricNullness V v) {
            Map A = CompactHashMap.this.A();
            if (A != null) {
                return NullnessCasts.a(A.put(this.s, v));
            }
            a();
            int i2 = this.X;
            if (i2 == -1) {
                CompactHashMap.this.put(this.s, v);
                return NullnessCasts.b();
            }
            V j2 = CompactHashMap.this.e0(i2);
            CompactHashMap.this.c0(this.X, v);
            return j2;
        }
    }

    class ValuesView extends AbstractCollection<V> {
        ValuesView() {
        }

        public void clear() {
            CompactHashMap.this.clear();
        }

        public Iterator<V> iterator() {
            return CompactHashMap.this.f0();
        }

        public int size() {
            return CompactHashMap.this.size();
        }
    }

    CompactHashMap() {
        J(3);
    }

    private int B(int i2) {
        return S()[i2];
    }

    /* access modifiers changed from: private */
    public int F() {
        return (1 << (this.X2 & 31)) - 1;
    }

    /* access modifiers changed from: private */
    public int I(@CheckForNull Object obj) {
        if (P()) {
            return -1;
        }
        int d2 = Hashing.d(obj);
        int F = F();
        int h2 = CompactHashing.h(U(), d2 & F);
        if (h2 == 0) {
            return -1;
        }
        int b2 = CompactHashing.b(d2, F);
        do {
            int i2 = h2 - 1;
            int B = B(i2);
            if (CompactHashing.b(B, F) == b2 && Objects.a(obj, M(i2))) {
                return i2;
            }
            h2 = CompactHashing.c(B, F);
        } while (h2 != 0);
        return -1;
    }

    /* access modifiers changed from: private */
    public K M(int i2) {
        return T()[i2];
    }

    @J2ktIncompatible
    private void Q(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            J(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                put(objectInputStream.readObject(), objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    /* access modifiers changed from: private */
    public Object R(@CheckForNull Object obj) {
        if (P()) {
            return c3;
        }
        int F = F();
        int f2 = CompactHashing.f(obj, (Object) null, F, U(), S(), T(), (Object[]) null);
        if (f2 == -1) {
            return c3;
        }
        Object e0 = e0(f2);
        O(f2, F);
        this.Y2--;
        H();
        return e0;
    }

    /* access modifiers changed from: private */
    public int[] S() {
        int[] iArr = this.X;
        java.util.Objects.requireNonNull(iArr);
        return iArr;
    }

    /* access modifiers changed from: private */
    public Object[] T() {
        Object[] objArr = this.Y;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    /* access modifiers changed from: private */
    public Object U() {
        Object obj = this.s;
        java.util.Objects.requireNonNull(obj);
        return obj;
    }

    /* access modifiers changed from: private */
    public Object[] V() {
        Object[] objArr = this.Z;
        java.util.Objects.requireNonNull(objArr);
        return objArr;
    }

    private void X(int i2) {
        int min;
        int length = S().length;
        if (i2 > length && (min = Math.min(LockFreeTaskQueueCore.f29373j, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            W(min);
        }
    }

    @CanIgnoreReturnValue
    private int Y(int i2, int i3, int i4, int i5) {
        Object a2 = CompactHashing.a(i3);
        int i6 = i3 - 1;
        if (i5 != 0) {
            CompactHashing.i(a2, i4 & i6, i5 + 1);
        }
        Object U = U();
        int[] S = S();
        for (int i7 = 0; i7 <= i2; i7++) {
            int h2 = CompactHashing.h(U, i7);
            while (h2 != 0) {
                int i8 = h2 - 1;
                int i9 = S[i8];
                int b2 = CompactHashing.b(i9, i2) | i7;
                int i10 = b2 & i6;
                int h3 = CompactHashing.h(a2, i10);
                CompactHashing.i(a2, i10, h2);
                S[i8] = CompactHashing.d(b2, h3, i6);
                h2 = CompactHashing.c(i9, i2);
            }
        }
        this.s = a2;
        a0(i6);
        return i6;
    }

    private void Z(int i2, int i3) {
        S()[i2] = i3;
    }

    private void a0(int i2) {
        this.X2 = CompactHashing.d(this.X2, 32 - Integer.numberOfLeadingZeros(i2), 31);
    }

    private void b0(int i2, K k2) {
        T()[i2] = k2;
    }

    /* access modifiers changed from: private */
    public void c0(int i2, V v) {
        V()[i2] = v;
    }

    static /* synthetic */ int e(CompactHashMap compactHashMap) {
        int i2 = compactHashMap.Y2;
        compactHashMap.Y2 = i2 - 1;
        return i2;
    }

    /* access modifiers changed from: private */
    public V e0(int i2) {
        return V()[i2];
    }

    @J2ktIncompatible
    private void h0(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator C = C();
        while (C.hasNext()) {
            Map.Entry entry = (Map.Entry) C.next();
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    public static <K, V> CompactHashMap<K, V> t() {
        return new CompactHashMap<>();
    }

    public static <K, V> CompactHashMap<K, V> z(int i2) {
        return new CompactHashMap<>(i2);
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    @VisibleForTesting
    public Map<K, V> A() {
        Object obj = this.s;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Iterator<Map.Entry<K, V>> C() {
        Map A = A();
        return A != null ? A.entrySet().iterator() : new CompactHashMap<K, V>.Itr<Map.Entry<K, V>>() {
            /* access modifiers changed from: package-private */
            /* renamed from: d */
            public Map.Entry<K, V> b(int i2) {
                return new MapEntry(i2);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public int D() {
        return isEmpty() ? -1 : 0;
    }

    /* access modifiers changed from: package-private */
    public int E(int i2) {
        int i3 = i2 + 1;
        if (i3 < this.Y2) {
            return i3;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void H() {
        this.X2 += 32;
    }

    /* access modifiers changed from: package-private */
    public void J(int i2) {
        Preconditions.e(i2 >= 0, "Expected size must be >= 0");
        this.X2 = Ints.g(i2, 1, LockFreeTaskQueueCore.f29373j);
    }

    /* access modifiers changed from: package-private */
    public void K(int i2, @ParametricNullness K k2, @ParametricNullness V v, int i3, int i4) {
        Z(i2, CompactHashing.d(i3, 0, i4));
        b0(i2, k2);
        c0(i2, v);
    }

    /* access modifiers changed from: package-private */
    public Iterator<K> N() {
        Map A = A();
        return A != null ? A.keySet().iterator() : new CompactHashMap<K, V>.Itr<K>() {
            /* access modifiers changed from: package-private */
            @ParametricNullness
            public K b(int i2) {
                return CompactHashMap.this.M(i2);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void O(int i2, int i3) {
        Object U = U();
        int[] S = S();
        Object[] T = T();
        Object[] V = V();
        int size = size();
        int i4 = size - 1;
        if (i2 < i4) {
            Object obj = T[i4];
            T[i2] = obj;
            V[i2] = V[i4];
            T[i4] = null;
            V[i4] = null;
            S[i2] = S[i4];
            S[i4] = 0;
            int d2 = Hashing.d(obj) & i3;
            int h2 = CompactHashing.h(U, d2);
            if (h2 == size) {
                CompactHashing.i(U, d2, i2 + 1);
                return;
            }
            while (true) {
                int i5 = h2 - 1;
                int i6 = S[i5];
                int c2 = CompactHashing.c(i6, i3);
                if (c2 == size) {
                    S[i5] = CompactHashing.d(i6, i2 + 1, i3);
                    return;
                }
                h2 = c2;
            }
        } else {
            T[i2] = null;
            V[i2] = null;
            S[i2] = 0;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean P() {
        return this.s == null;
    }

    /* access modifiers changed from: package-private */
    public void W(int i2) {
        this.X = Arrays.copyOf(S(), i2);
        this.Y = Arrays.copyOf(T(), i2);
        this.Z = Arrays.copyOf(V(), i2);
    }

    public void clear() {
        if (!P()) {
            H();
            Map A = A();
            if (A != null) {
                this.X2 = Ints.g(size(), 3, LockFreeTaskQueueCore.f29373j);
                A.clear();
                this.s = null;
            } else {
                Arrays.fill(T(), 0, this.Y2, (Object) null);
                Arrays.fill(V(), 0, this.Y2, (Object) null);
                CompactHashing.g(U());
                Arrays.fill(S(), 0, this.Y2, 0);
            }
            this.Y2 = 0;
        }
    }

    public boolean containsKey(@CheckForNull Object obj) {
        Map A = A();
        return A != null ? A.containsKey(obj) : I(obj) != -1;
    }

    public boolean containsValue(@CheckForNull Object obj) {
        Map A = A();
        if (A != null) {
            return A.containsValue(obj);
        }
        for (int i2 = 0; i2 < this.Y2; i2++) {
            if (Objects.a(obj, e0(i2))) {
                return true;
            }
        }
        return false;
    }

    public void d0() {
        if (!P()) {
            Map A = A();
            if (A != null) {
                Map v = v(size());
                v.putAll(A);
                this.s = v;
                return;
            }
            int i2 = this.Y2;
            if (i2 < S().length) {
                W(i2);
            }
            int j2 = CompactHashing.j(i2);
            int F = F();
            if (j2 < F) {
                Y(F, j2, 0, 0);
            }
        }
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.a3;
        if (set != null) {
            return set;
        }
        Set<Map.Entry<K, V>> u = u();
        this.a3 = u;
        return u;
    }

    /* access modifiers changed from: package-private */
    public Iterator<V> f0() {
        Map A = A();
        return A != null ? A.values().iterator() : new CompactHashMap<K, V>.Itr<V>() {
            /* access modifiers changed from: package-private */
            @ParametricNullness
            public V b(int i2) {
                return CompactHashMap.this.e0(i2);
            }
        };
    }

    @CheckForNull
    public V get(@CheckForNull Object obj) {
        Map A = A();
        if (A != null) {
            return A.get(obj);
        }
        int I = I(obj);
        if (I == -1) {
            return null;
        }
        n(I);
        return e0(I);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Set<K> keySet() {
        Set<K> set = this.Z2;
        if (set != null) {
            return set;
        }
        Set<K> w = w();
        this.Z2 = w;
        return w;
    }

    /* access modifiers changed from: package-private */
    public void n(int i2) {
    }

    /* access modifiers changed from: package-private */
    public int o(int i2, int i3) {
        return i2 - 1;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int p() {
        Preconditions.h0(P(), "Arrays already allocated");
        int i2 = this.X2;
        int j2 = CompactHashing.j(i2);
        this.s = CompactHashing.a(j2);
        a0(j2 - 1);
        this.X = new int[i2];
        this.Y = new Object[i2];
        this.Z = new Object[i2];
        return i2;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V put(@ParametricNullness K k2, @ParametricNullness V v) {
        int i2;
        if (P()) {
            p();
        }
        Map A = A();
        if (A != null) {
            return A.put(k2, v);
        }
        int[] S = S();
        Object[] T = T();
        V[] V = V();
        int i3 = this.Y2;
        int i4 = i3 + 1;
        int d2 = Hashing.d(k2);
        int F = F();
        int i5 = d2 & F;
        int h2 = CompactHashing.h(U(), i5);
        if (h2 != 0) {
            int b2 = CompactHashing.b(d2, F);
            int i6 = 0;
            while (true) {
                int i7 = h2 - 1;
                int i8 = S[i7];
                if (CompactHashing.b(i8, F) != b2 || !Objects.a(k2, T[i7])) {
                    int c2 = CompactHashing.c(i8, F);
                    i6++;
                    if (c2 != 0) {
                        h2 = c2;
                    } else if (i6 >= 9) {
                        return s().put(k2, v);
                    } else {
                        if (i4 <= F) {
                            S[i7] = CompactHashing.d(i8, i4, F);
                        }
                    }
                } else {
                    V v2 = V[i7];
                    V[i7] = v;
                    n(i7);
                    return v2;
                }
            }
            i2 = F;
            X(i4);
            K(i3, k2, v, d2, i2);
            this.Y2 = i4;
            H();
            return null;
        } else if (i4 <= F) {
            CompactHashing.i(U(), i5, i4);
            i2 = F;
            X(i4);
            K(i3, k2, v, d2, i2);
            this.Y2 = i4;
            H();
            return null;
        }
        i2 = Y(F, CompactHashing.e(F), d2, i3);
        X(i4);
        K(i3, k2, v, d2, i2);
        this.Y2 = i4;
        H();
        return null;
    }

    @CanIgnoreReturnValue
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        Map A = A();
        if (A != null) {
            return A.remove(obj);
        }
        V R = R(obj);
        if (R == c3) {
            return null;
        }
        return R;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @VisibleForTesting
    public Map<K, V> s() {
        Map<K, V> v = v(F() + 1);
        int D = D();
        while (D >= 0) {
            v.put(M(D), e0(D));
            D = E(D);
        }
        this.s = v;
        this.X = null;
        this.Y = null;
        this.Z = null;
        H();
        return v;
    }

    public int size() {
        Map A = A();
        return A != null ? A.size() : this.Y2;
    }

    /* access modifiers changed from: package-private */
    public Set<Map.Entry<K, V>> u() {
        return new EntrySetView();
    }

    /* access modifiers changed from: package-private */
    public Map<K, V> v(int i2) {
        return new LinkedHashMap(i2, 1.0f);
    }

    public Collection<V> values() {
        Collection<V> collection = this.b3;
        if (collection != null) {
            return collection;
        }
        Collection<V> y = y();
        this.b3 = y;
        return y;
    }

    /* access modifiers changed from: package-private */
    public Set<K> w() {
        return new KeySetView();
    }

    /* access modifiers changed from: package-private */
    public Collection<V> y() {
        return new ValuesView();
    }

    CompactHashMap(int i2) {
        J(i2);
    }
}
