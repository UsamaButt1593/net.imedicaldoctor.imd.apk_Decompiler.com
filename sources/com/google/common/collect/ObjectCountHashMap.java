package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
class ObjectCountHashMap<K> {

    /* renamed from: i  reason: collision with root package name */
    private static final int f22478i = 1073741824;

    /* renamed from: j  reason: collision with root package name */
    static final float f22479j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    private static final long f22480k = 4294967295L;

    /* renamed from: l  reason: collision with root package name */
    private static final long f22481l = -4294967296L;

    /* renamed from: m  reason: collision with root package name */
    static final int f22482m = 3;

    /* renamed from: n  reason: collision with root package name */
    static final int f22483n = -1;

    /* renamed from: a  reason: collision with root package name */
    transient Object[] f22484a;

    /* renamed from: b  reason: collision with root package name */
    transient int[] f22485b;

    /* renamed from: c  reason: collision with root package name */
    transient int f22486c;

    /* renamed from: d  reason: collision with root package name */
    transient int f22487d;

    /* renamed from: e  reason: collision with root package name */
    private transient int[] f22488e;
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    transient long[] f22489f;

    /* renamed from: g  reason: collision with root package name */
    private transient float f22490g;

    /* renamed from: h  reason: collision with root package name */
    private transient int f22491h;

    class MapEntry extends Multisets.AbstractEntry<K> {
        int X;
        @ParametricNullness
        final K s;

        MapEntry(int i2) {
            this.s = ObjectCountHashMap.this.f22484a[i2];
            this.X = i2;
        }

        @ParametricNullness
        public K a() {
            return this.s;
        }

        @CanIgnoreReturnValue
        public int b(int i2) {
            c();
            int i3 = this.X;
            if (i3 == -1) {
                ObjectCountHashMap.this.v(this.s, i2);
                return 0;
            }
            int[] iArr = ObjectCountHashMap.this.f22485b;
            int i4 = iArr[i3];
            iArr[i3] = i2;
            return i4;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            int i2 = this.X;
            if (i2 == -1 || i2 >= ObjectCountHashMap.this.D() || !Objects.a(this.s, ObjectCountHashMap.this.f22484a[this.X])) {
                this.X = ObjectCountHashMap.this.n(this.s);
            }
        }

        public int getCount() {
            c();
            int i2 = this.X;
            if (i2 == -1) {
                return 0;
            }
            return ObjectCountHashMap.this.f22485b[i2];
        }
    }

    ObjectCountHashMap() {
        o(3, 1.0f);
    }

    private void A(int i2) {
        int length = this.f22489f.length;
        if (i2 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                z(max);
            }
        }
    }

    private void B(int i2) {
        if (this.f22488e.length >= 1073741824) {
            this.f22491h = Integer.MAX_VALUE;
            return;
        }
        int i3 = ((int) (((float) i2) * this.f22490g)) + 1;
        int[] s = s(i2);
        long[] jArr = this.f22489f;
        int length = s.length - 1;
        for (int i4 = 0; i4 < this.f22486c; i4++) {
            int i5 = i(jArr[i4]);
            int i6 = i5 & length;
            int i7 = s[i6];
            s[i6] = i4;
            jArr[i4] = (((long) i5) << 32) | (((long) i7) & 4294967295L);
        }
        this.f22491h = i3;
        this.f22488e = s;
    }

    private static long E(long j2, int i2) {
        return (j2 & f22481l) | (4294967295L & ((long) i2));
    }

    static <K> ObjectCountHashMap<K> c() {
        return new ObjectCountHashMap<>();
    }

    static <K> ObjectCountHashMap<K> d(int i2) {
        return new ObjectCountHashMap<>(i2);
    }

    private static int i(long j2) {
        return (int) (j2 >>> 32);
    }

    private static int k(long j2) {
        return (int) j2;
    }

    private int m() {
        return this.f22488e.length - 1;
    }

    private static long[] r(int i2) {
        long[] jArr = new long[i2];
        Arrays.fill(jArr, -1);
        return jArr;
    }

    private static int[] s(int i2) {
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private int x(@CheckForNull Object obj, int i2) {
        int m2 = m() & i2;
        int i3 = this.f22488e[m2];
        if (i3 == -1) {
            return 0;
        }
        int i4 = -1;
        while (true) {
            if (i(this.f22489f[i3]) != i2 || !Objects.a(obj, this.f22484a[i3])) {
                int k2 = k(this.f22489f[i3]);
                if (k2 == -1) {
                    return 0;
                }
                int i5 = k2;
                i4 = i3;
                i3 = i5;
            } else {
                int i6 = this.f22485b[i3];
                if (i4 == -1) {
                    this.f22488e[m2] = k(this.f22489f[i3]);
                } else {
                    long[] jArr = this.f22489f;
                    jArr[i4] = E(jArr[i4], k(jArr[i3]));
                }
                q(i3);
                this.f22486c--;
                this.f22487d++;
                return i6;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void C(int i2, int i3) {
        Preconditions.C(i2, this.f22486c);
        this.f22485b[i2] = i3;
    }

    /* access modifiers changed from: package-private */
    public int D() {
        return this.f22486c;
    }

    public void a() {
        this.f22487d++;
        Arrays.fill(this.f22484a, 0, this.f22486c, (Object) null);
        Arrays.fill(this.f22485b, 0, this.f22486c, 0);
        Arrays.fill(this.f22488e, -1);
        Arrays.fill(this.f22489f, -1);
        this.f22486c = 0;
    }

    public boolean b(@CheckForNull Object obj) {
        return n(obj) != -1;
    }

    /* access modifiers changed from: package-private */
    public void e(int i2) {
        if (i2 > this.f22489f.length) {
            z(i2);
        }
        if (i2 >= this.f22491h) {
            B(Math.max(2, Integer.highestOneBit(i2 - 1) << 1));
        }
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f22486c == 0 ? -1 : 0;
    }

    public int g(@CheckForNull Object obj) {
        int n2 = n(obj);
        if (n2 == -1) {
            return 0;
        }
        return this.f22485b[n2];
    }

    /* access modifiers changed from: package-private */
    public Multiset.Entry<K> h(int i2) {
        Preconditions.C(i2, this.f22486c);
        return new MapEntry(i2);
    }

    /* access modifiers changed from: package-private */
    @ParametricNullness
    public K j(int i2) {
        Preconditions.C(i2, this.f22486c);
        return this.f22484a[i2];
    }

    /* access modifiers changed from: package-private */
    public int l(int i2) {
        Preconditions.C(i2, this.f22486c);
        return this.f22485b[i2];
    }

    /* access modifiers changed from: package-private */
    public int n(@CheckForNull Object obj) {
        int d2 = Hashing.d(obj);
        int i2 = this.f22488e[m() & d2];
        while (i2 != -1) {
            long j2 = this.f22489f[i2];
            if (i(j2) == d2 && Objects.a(obj, this.f22484a[i2])) {
                return i2;
            }
            i2 = k(j2);
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void o(int i2, float f2) {
        boolean z = false;
        Preconditions.e(i2 >= 0, "Initial capacity must be non-negative");
        if (f2 > 0.0f) {
            z = true;
        }
        Preconditions.e(z, "Illegal load factor");
        int a2 = Hashing.a(i2, (double) f2);
        this.f22488e = s(a2);
        this.f22490g = f2;
        this.f22484a = new Object[i2];
        this.f22485b = new int[i2];
        this.f22489f = r(i2);
        this.f22491h = Math.max(1, (int) (((float) a2) * f2));
    }

    /* access modifiers changed from: package-private */
    public void p(int i2, @ParametricNullness K k2, int i3, int i4) {
        this.f22489f[i2] = (((long) i4) << 32) | 4294967295L;
        this.f22484a[i2] = k2;
        this.f22485b[i2] = i3;
    }

    /* access modifiers changed from: package-private */
    public void q(int i2) {
        int D = D() - 1;
        if (i2 < D) {
            Object[] objArr = this.f22484a;
            objArr[i2] = objArr[D];
            int[] iArr = this.f22485b;
            iArr[i2] = iArr[D];
            objArr[D] = null;
            iArr[D] = 0;
            long[] jArr = this.f22489f;
            long j2 = jArr[D];
            jArr[i2] = j2;
            jArr[D] = -1;
            int i3 = i(j2) & m();
            int[] iArr2 = this.f22488e;
            int i4 = iArr2[i3];
            if (i4 == D) {
                iArr2[i3] = i2;
                return;
            }
            while (true) {
                long j3 = this.f22489f[i4];
                int k2 = k(j3);
                if (k2 == D) {
                    this.f22489f[i4] = E(j3, i2);
                    return;
                }
                i4 = k2;
            }
        } else {
            this.f22484a[i2] = null;
            this.f22485b[i2] = 0;
            this.f22489f[i2] = -1;
        }
    }

    /* access modifiers changed from: package-private */
    public int t(int i2) {
        int i3 = i2 + 1;
        if (i3 < this.f22486c) {
            return i3;
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int u(int i2, int i3) {
        return i2 - 1;
    }

    @CanIgnoreReturnValue
    public int v(@ParametricNullness K k2, int i2) {
        CollectPreconditions.d(i2, "count");
        long[] jArr = this.f22489f;
        Object[] objArr = this.f22484a;
        int[] iArr = this.f22485b;
        int d2 = Hashing.d(k2);
        int m2 = m() & d2;
        int i3 = this.f22486c;
        int[] iArr2 = this.f22488e;
        int i4 = iArr2[m2];
        if (i4 == -1) {
            iArr2[m2] = i3;
        } else {
            while (true) {
                long j2 = jArr[i4];
                if (i(j2) != d2 || !Objects.a(k2, objArr[i4])) {
                    int k3 = k(j2);
                    if (k3 == -1) {
                        jArr[i4] = E(j2, i3);
                        break;
                    }
                    i4 = k3;
                } else {
                    int i5 = iArr[i4];
                    iArr[i4] = i2;
                    return i5;
                }
            }
        }
        if (i3 != Integer.MAX_VALUE) {
            int i6 = i3 + 1;
            A(i6);
            p(i3, k2, i2, d2);
            this.f22486c = i6;
            if (i3 >= this.f22491h) {
                B(this.f22488e.length * 2);
            }
            this.f22487d++;
            return 0;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    @CanIgnoreReturnValue
    public int w(@CheckForNull Object obj) {
        return x(obj, Hashing.d(obj));
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int y(int i2) {
        return x(this.f22484a[i2], i(this.f22489f[i2]));
    }

    /* access modifiers changed from: package-private */
    public void z(int i2) {
        this.f22484a = Arrays.copyOf(this.f22484a, i2);
        this.f22485b = Arrays.copyOf(this.f22485b, i2);
        long[] jArr = this.f22489f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i2);
        if (i2 > length) {
            Arrays.fill(copyOf, length, i2, -1);
        }
        this.f22489f = copyOf;
    }

    ObjectCountHashMap(int i2) {
        this(i2, 1.0f);
    }

    ObjectCountHashMap(int i2, float f2) {
        o(i2, f2);
    }

    ObjectCountHashMap(ObjectCountHashMap<? extends K> objectCountHashMap) {
        o(objectCountHashMap.D(), 1.0f);
        int f2 = objectCountHashMap.f();
        while (f2 != -1) {
            v(objectCountHashMap.j(f2), objectCountHashMap.l(f2));
            f2 = objectCountHashMap.t(f2);
        }
    }
}
