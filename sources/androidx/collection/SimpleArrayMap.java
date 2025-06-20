package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap<K, V> {
    private static final String X2 = "ArrayMap";
    private static final boolean Y2 = true;
    private static final boolean Z = false;
    private static final int Z2 = 4;
    private static final int a3 = 10;
    @Nullable
    static Object[] b3;
    static int c3;
    @Nullable
    static Object[] d3;
    static int e3;
    Object[] X;
    int Y;
    int[] s;

    public SimpleArrayMap() {
        this.s = ContainerHelpers.f3550a;
        this.X = ContainerHelpers.f3552c;
        this.Y = 0;
    }

    private void a(int i2) {
        if (i2 == 8) {
            synchronized (SimpleArrayMap.class) {
                try {
                    Object[] objArr = d3;
                    if (objArr != null) {
                        this.X = objArr;
                        d3 = (Object[]) objArr[0];
                        this.s = (int[]) objArr[1];
                        objArr[1] = null;
                        objArr[0] = null;
                        e3--;
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i2 == 4) {
            synchronized (SimpleArrayMap.class) {
                try {
                    Object[] objArr2 = b3;
                    if (objArr2 != null) {
                        this.X = objArr2;
                        b3 = (Object[]) objArr2[0];
                        this.s = (int[]) objArr2[1];
                        objArr2[1] = null;
                        objArr2[0] = null;
                        c3--;
                        return;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        this.s = new int[i2];
        this.X = new Object[(i2 << 1)];
    }

    private static int b(int[] iArr, int i2, int i3) {
        try {
            return ContainerHelpers.a(iArr, i2, i3);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void d(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (e3 < 10) {
                        objArr[0] = d3;
                        objArr[1] = iArr;
                        for (int i3 = (i2 << 1) - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        d3 = objArr;
                        e3++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (SimpleArrayMap.class) {
                try {
                    if (c3 < 10) {
                        objArr[0] = b3;
                        objArr[1] = iArr;
                        for (int i4 = (i2 << 1) - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        b3 = objArr;
                        c3++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public void c(int i2) {
        int i3 = this.Y;
        int[] iArr = this.s;
        if (iArr.length < i2) {
            Object[] objArr = this.X;
            a(i2);
            if (this.Y > 0) {
                System.arraycopy(iArr, 0, this.s, 0, i3);
                System.arraycopy(objArr, 0, this.X, 0, i3 << 1);
            }
            d(iArr, objArr, i3);
        }
        if (this.Y != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i2 = this.Y;
        if (i2 > 0) {
            int[] iArr = this.s;
            Object[] objArr = this.X;
            this.s = ContainerHelpers.f3550a;
            this.X = ContainerHelpers.f3552c;
            this.Y = 0;
            d(iArr, objArr, i2);
        }
        if (this.Y > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(@Nullable Object obj) {
        return f(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return h(obj) >= 0;
    }

    /* access modifiers changed from: package-private */
    public int e(Object obj, int i2) {
        int i3 = this.Y;
        if (i3 == 0) {
            return -1;
        }
        int b2 = b(this.s, i3, i2);
        if (b2 < 0 || obj.equals(this.X[b2 << 1])) {
            return b2;
        }
        int i4 = b2 + 1;
        while (i4 < i3 && this.s[i4] == i2) {
            if (obj.equals(this.X[i4 << 1])) {
                return i4;
            }
            i4++;
        }
        int i5 = b2 - 1;
        while (i5 >= 0 && this.s[i5] == i2) {
            if (obj.equals(this.X[i5 << 1])) {
                return i5;
            }
            i5--;
        }
        return ~i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof SimpleArrayMap) {
                SimpleArrayMap simpleArrayMap = (SimpleArrayMap) obj;
                if (size() != simpleArrayMap.size()) {
                    return false;
                }
                for (int i2 = 0; i2 < this.Y; i2++) {
                    Object i3 = i(i2);
                    Object m2 = m(i2);
                    Object obj2 = simpleArrayMap.get(i3);
                    if (m2 == null) {
                        if (obj2 != null || !simpleArrayMap.containsKey(i3)) {
                            return false;
                        }
                    } else if (!m2.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (obj instanceof Map) {
                Map map = (Map) obj;
                if (size() != map.size()) {
                    return false;
                }
                for (int i4 = 0; i4 < this.Y; i4++) {
                    Object i5 = i(i4);
                    Object m3 = m(i4);
                    Object obj3 = map.get(i5);
                    if (m3 == null) {
                        if (obj3 != null || !map.containsKey(i5)) {
                            return false;
                        }
                    } else if (!m3.equals(obj3)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (ClassCastException | NullPointerException unused) {
        }
    }

    public int f(@Nullable Object obj) {
        return obj == null ? g() : e(obj, obj.hashCode());
    }

    /* access modifiers changed from: package-private */
    public int g() {
        int i2 = this.Y;
        if (i2 == 0) {
            return -1;
        }
        int b2 = b(this.s, i2, 0);
        if (b2 < 0 || this.X[b2 << 1] == null) {
            return b2;
        }
        int i3 = b2 + 1;
        while (i3 < i2 && this.s[i3] == 0) {
            if (this.X[i3 << 1] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = b2 - 1;
        while (i4 >= 0 && this.s[i4] == 0) {
            if (this.X[i4 << 1] == null) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    @Nullable
    public V get(Object obj) {
        return getOrDefault(obj, (Object) null);
    }

    public V getOrDefault(Object obj, V v) {
        int f2 = f(obj);
        return f2 >= 0 ? this.X[(f2 << 1) + 1] : v;
    }

    /* access modifiers changed from: package-private */
    public int h(Object obj) {
        int i2 = this.Y * 2;
        Object[] objArr = this.X;
        if (obj == null) {
            for (int i3 = 1; i3 < i2; i3 += 2) {
                if (objArr[i3] == null) {
                    return i3 >> 1;
                }
            }
            return -1;
        }
        for (int i4 = 1; i4 < i2; i4 += 2) {
            if (obj.equals(objArr[i4])) {
                return i4 >> 1;
            }
        }
        return -1;
    }

    public int hashCode() {
        int[] iArr = this.s;
        Object[] objArr = this.X;
        int i2 = this.Y;
        int i3 = 1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            Object obj = objArr[i3];
            i5 += (obj == null ? 0 : obj.hashCode()) ^ iArr[i4];
            i4++;
            i3 += 2;
        }
        return i5;
    }

    public K i(int i2) {
        return this.X[i2 << 1];
    }

    public boolean isEmpty() {
        return this.Y <= 0;
    }

    public void j(@NonNull SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        int i2 = simpleArrayMap.Y;
        c(this.Y + i2);
        if (this.Y != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                put(simpleArrayMap.i(i3), simpleArrayMap.m(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(simpleArrayMap.s, 0, this.s, 0, i2);
            System.arraycopy(simpleArrayMap.X, 0, this.X, 0, i2 << 1);
            this.Y = i2;
        }
    }

    public V k(int i2) {
        V[] vArr = this.X;
        int i3 = i2 << 1;
        V v = vArr[i3 + 1];
        int i4 = this.Y;
        if (i4 <= 1) {
            clear();
        } else {
            int i5 = i4 - 1;
            int[] iArr = this.s;
            int i6 = 8;
            if (iArr.length <= 8 || i4 >= iArr.length / 3) {
                if (i2 < i5) {
                    int i7 = i2 + 1;
                    int i8 = i5 - i2;
                    System.arraycopy(iArr, i7, iArr, i2, i8);
                    Object[] objArr = this.X;
                    System.arraycopy(objArr, i7 << 1, objArr, i3, i8 << 1);
                }
                Object[] objArr2 = this.X;
                int i9 = i5 << 1;
                objArr2[i9] = null;
                objArr2[i9 + 1] = null;
            } else {
                if (i4 > 8) {
                    i6 = i4 + (i4 >> 1);
                }
                a(i6);
                if (i4 == this.Y) {
                    if (i2 > 0) {
                        System.arraycopy(iArr, 0, this.s, 0, i2);
                        System.arraycopy(vArr, 0, this.X, 0, i3);
                    }
                    if (i2 < i5) {
                        int i10 = i2 + 1;
                        int i11 = i5 - i2;
                        System.arraycopy(iArr, i10, this.s, i2, i11);
                        System.arraycopy(vArr, i10 << 1, this.X, i3, i11 << 1);
                    }
                } else {
                    throw new ConcurrentModificationException();
                }
            }
            if (i4 == this.Y) {
                this.Y = i5;
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return v;
    }

    public V l(int i2, V v) {
        int i3 = (i2 << 1) + 1;
        V[] vArr = this.X;
        V v2 = vArr[i3];
        vArr[i3] = v;
        return v2;
    }

    public V m(int i2) {
        return this.X[(i2 << 1) + 1];
    }

    @Nullable
    public V put(K k2, V v) {
        int i2;
        int i3;
        int i4 = this.Y;
        if (k2 == null) {
            i3 = g();
            i2 = 0;
        } else {
            int hashCode = k2.hashCode();
            i2 = hashCode;
            i3 = e(k2, hashCode);
        }
        if (i3 >= 0) {
            int i5 = (i3 << 1) + 1;
            V[] vArr = this.X;
            V v2 = vArr[i5];
            vArr[i5] = v;
            return v2;
        }
        int i6 = ~i3;
        int[] iArr = this.s;
        if (i4 >= iArr.length) {
            int i7 = 8;
            if (i4 >= 8) {
                i7 = (i4 >> 1) + i4;
            } else if (i4 < 4) {
                i7 = 4;
            }
            Object[] objArr = this.X;
            a(i7);
            if (i4 == this.Y) {
                int[] iArr2 = this.s;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.X, 0, objArr.length);
                }
                d(iArr, objArr, i4);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i6 < i4) {
            int[] iArr3 = this.s;
            int i8 = i6 + 1;
            System.arraycopy(iArr3, i6, iArr3, i8, i4 - i6);
            Object[] objArr2 = this.X;
            System.arraycopy(objArr2, i6 << 1, objArr2, i8 << 1, (this.Y - i6) << 1);
        }
        int i9 = this.Y;
        if (i4 == i9) {
            int[] iArr4 = this.s;
            if (i6 < iArr4.length) {
                iArr4[i6] = i2;
                Object[] objArr3 = this.X;
                int i10 = i6 << 1;
                objArr3[i10] = k2;
                objArr3[i10 + 1] = v;
                this.Y = i9 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    @Nullable
    public V putIfAbsent(K k2, V v) {
        V v2 = get(k2);
        return v2 == null ? put(k2, v) : v2;
    }

    @Nullable
    public V remove(Object obj) {
        int f2 = f(obj);
        if (f2 >= 0) {
            return k(f2);
        }
        return null;
    }

    @Nullable
    public V replace(K k2, V v) {
        int f2 = f(k2);
        if (f2 >= 0) {
            return l(f2, v);
        }
        return null;
    }

    public int size() {
        return this.Y;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.Y * 28);
        sb.append(ASCIIPropertyListParser.f18652j);
        for (int i2 = 0; i2 < this.Y; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object i3 = i(i2);
            if (i3 != this) {
                sb.append(i3);
            } else {
                sb.append("(this Map)");
            }
            sb.append(ASCIIPropertyListParser.f18654l);
            Object m2 = m(i2);
            if (m2 != this) {
                sb.append(m2);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(ASCIIPropertyListParser.f18653k);
        return sb.toString();
    }

    public SimpleArrayMap(int i2) {
        if (i2 == 0) {
            this.s = ContainerHelpers.f3550a;
            this.X = ContainerHelpers.f3552c;
        } else {
            a(i2);
        }
        this.Y = 0;
    }

    public boolean remove(Object obj, Object obj2) {
        int f2 = f(obj);
        if (f2 < 0) {
            return false;
        }
        Object m2 = m(f2);
        if (obj2 != m2 && (obj2 == null || !obj2.equals(m2))) {
            return false;
        }
        k(f2);
        return true;
    }

    public boolean replace(K k2, V v, V v2) {
        int f2 = f(k2);
        if (f2 < 0) {
            return false;
        }
        V m2 = m(f2);
        if (m2 != v && (v == null || !v.equals(m2))) {
            return false;
        }
        l(f2, v2);
        return true;
    }

    public SimpleArrayMap(SimpleArrayMap<K, V> simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            j(simpleArrayMap);
        }
    }
}
