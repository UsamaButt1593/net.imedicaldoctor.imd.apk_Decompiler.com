package io.reactivex.rxjava3.internal.util;

public final class OpenHashSet<T> {

    /* renamed from: f  reason: collision with root package name */
    private static final int f28485f = -1640531527;

    /* renamed from: a  reason: collision with root package name */
    final float f28486a;

    /* renamed from: b  reason: collision with root package name */
    int f28487b;

    /* renamed from: c  reason: collision with root package name */
    int f28488c;

    /* renamed from: d  reason: collision with root package name */
    int f28489d;

    /* renamed from: e  reason: collision with root package name */
    T[] f28490e;

    public OpenHashSet() {
        this(16, 0.75f);
    }

    static int c(int i2) {
        int i3 = i2 * f28485f;
        return i3 ^ (i3 >>> 16);
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.f28490e;
        int i2 = this.f28487b;
        int c2 = c(t.hashCode()) & i2;
        T t3 = tArr[c2];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                c2 = (c2 + 1) & i2;
                t2 = tArr[c2];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[c2] = t;
        int i3 = this.f28488c + 1;
        this.f28488c = i3;
        if (i3 >= this.f28489d) {
            d();
        }
        return true;
    }

    public Object[] b() {
        return this.f28490e;
    }

    /* access modifiers changed from: package-private */
    public void d() {
        T t;
        T[] tArr = this.f28490e;
        int length = tArr.length;
        int i2 = length << 1;
        int i3 = i2 - 1;
        T[] tArr2 = new Object[i2];
        int i4 = this.f28488c;
        while (true) {
            int i5 = i4 - 1;
            if (i4 != 0) {
                do {
                    length--;
                    t = tArr[length];
                } while (t == null);
                int c2 = c(t.hashCode()) & i3;
                if (tArr2[c2] != null) {
                    do {
                        c2 = (c2 + 1) & i3;
                    } while (tArr2[c2] != null);
                }
                tArr2[c2] = tArr[length];
                i4 = i5;
            } else {
                this.f28487b = i3;
                this.f28489d = (int) (((float) i2) * this.f28486a);
                this.f28490e = tArr2;
                return;
            }
        }
    }

    public boolean e(T t) {
        T t2;
        T[] tArr = this.f28490e;
        int i2 = this.f28487b;
        int c2 = c(t.hashCode()) & i2;
        T t3 = tArr[c2];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return f(c2, tArr, i2);
        }
        do {
            c2 = (c2 + 1) & i2;
            t2 = tArr[c2];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return f(c2, tArr, i2);
    }

    /* access modifiers changed from: package-private */
    public boolean f(int i2, T[] tArr, int i3) {
        int i4;
        T t;
        this.f28488c--;
        while (true) {
            int i5 = i2 + 1;
            while (true) {
                i4 = i5 & i3;
                t = tArr[i4];
                if (t == null) {
                    tArr[i2] = null;
                    return true;
                }
                int c2 = c(t.hashCode()) & i3;
                if (i2 <= i4) {
                    if (i2 >= c2 || c2 > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                } else {
                    if (i2 >= c2 && c2 > i4) {
                        break;
                    }
                    i5 = i4 + 1;
                }
            }
            tArr[i2] = t;
            i2 = i4;
        }
    }

    public int g() {
        return this.f28488c;
    }

    public OpenHashSet(int i2) {
        this(i2, 0.75f);
    }

    public OpenHashSet(int i2, float f2) {
        this.f28486a = f2;
        int b2 = Pow2.b(i2);
        this.f28487b = b2 - 1;
        this.f28489d = (int) (f2 * ((float) b2));
        this.f28490e = new Object[b2];
    }
}
