package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class SortedList<T> {

    /* renamed from: j  reason: collision with root package name */
    public static final int f15614j = -1;

    /* renamed from: k  reason: collision with root package name */
    private static final int f15615k = 10;

    /* renamed from: l  reason: collision with root package name */
    private static final int f15616l = 10;

    /* renamed from: m  reason: collision with root package name */
    private static final int f15617m = 1;

    /* renamed from: n  reason: collision with root package name */
    private static final int f15618n = 2;
    private static final int o = 4;

    /* renamed from: a  reason: collision with root package name */
    T[] f15619a;

    /* renamed from: b  reason: collision with root package name */
    private T[] f15620b;

    /* renamed from: c  reason: collision with root package name */
    private int f15621c;

    /* renamed from: d  reason: collision with root package name */
    private int f15622d;

    /* renamed from: e  reason: collision with root package name */
    private int f15623e;

    /* renamed from: f  reason: collision with root package name */
    private Callback f15624f;

    /* renamed from: g  reason: collision with root package name */
    private BatchedCallback f15625g;

    /* renamed from: h  reason: collision with root package name */
    private int f15626h;

    /* renamed from: i  reason: collision with root package name */
    private final Class<T> f15627i;

    public static class BatchedCallback<T2> extends Callback<T2> {
        private final BatchingListUpdateCallback X;
        final Callback<T2> s;

        @SuppressLint({"UnknownNullness"})
        public BatchedCallback(Callback<T2> callback) {
            this.s = callback;
            this.X = new BatchingListUpdateCallback(callback);
        }

        public void a(int i2, int i3) {
            this.X.a(i2, i3);
        }

        public void b(int i2, int i3) {
            this.X.b(i2, i3);
        }

        public void c(int i2, int i3) {
            this.X.c(i2, i3);
        }

        public int compare(T2 t2, T2 t22) {
            return this.s.compare(t2, t22);
        }

        @SuppressLint({"UnknownNullness"})
        public void d(int i2, int i3, Object obj) {
            this.X.d(i2, i3, obj);
        }

        public boolean e(T2 t2, T2 t22) {
            return this.s.e(t2, t22);
        }

        public boolean f(T2 t2, T2 t22) {
            return this.s.f(t2, t22);
        }

        @Nullable
        public Object g(T2 t2, T2 t22) {
            return this.s.g(t2, t22);
        }

        public void h(int i2, int i3) {
            this.X.d(i2, i3, (Object) null);
        }

        public void i() {
            this.X.e();
        }
    }

    public static abstract class Callback<T2> implements Comparator<T2>, ListUpdateCallback {
        public abstract int compare(T2 t2, T2 t22);

        @SuppressLint({"UnknownNullness"})
        public void d(int i2, int i3, Object obj) {
            h(i2, i3);
        }

        public abstract boolean e(T2 t2, T2 t22);

        public abstract boolean f(T2 t2, T2 t22);

        @Nullable
        public Object g(T2 t2, T2 t22) {
            return null;
        }

        public abstract void h(int i2, int i3);
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback) {
        this(cls, callback, 10);
    }

    private void A(@NonNull T[] tArr) {
        boolean z = !(this.f15624f instanceof BatchedCallback);
        if (z) {
            h();
        }
        this.f15621c = 0;
        this.f15622d = this.f15626h;
        this.f15620b = this.f15619a;
        this.f15623e = 0;
        int D = D(tArr);
        this.f15619a = (Object[]) Array.newInstance(this.f15627i, D);
        while (true) {
            int i2 = this.f15623e;
            if (i2 >= D && this.f15621c >= this.f15622d) {
                break;
            }
            int i3 = this.f15621c;
            int i4 = this.f15622d;
            if (i3 >= i4) {
                int i5 = D - i2;
                System.arraycopy(tArr, i2, this.f15619a, i2, i5);
                this.f15623e += i5;
                this.f15626h += i5;
                this.f15624f.b(i2, i5);
                break;
            } else if (i2 >= D) {
                int i6 = i4 - i3;
                this.f15626h -= i6;
                this.f15624f.c(i2, i6);
                break;
            } else {
                T t = this.f15620b[i3];
                T t2 = tArr[i2];
                int compare = this.f15624f.compare(t, t2);
                if (compare < 0) {
                    B();
                } else {
                    if (compare <= 0) {
                        if (!this.f15624f.f(t, t2)) {
                            B();
                        } else {
                            T[] tArr2 = this.f15619a;
                            int i7 = this.f15623e;
                            tArr2[i7] = t2;
                            this.f15621c++;
                            this.f15623e = i7 + 1;
                            if (!this.f15624f.e(t, t2)) {
                                Callback callback = this.f15624f;
                                callback.d(this.f15623e - 1, 1, callback.g(t, t2));
                            }
                        }
                    }
                    z(t2);
                }
            }
        }
        this.f15620b = null;
        if (z) {
            k();
        }
    }

    private void B() {
        this.f15626h--;
        this.f15621c++;
        this.f15624f.c(this.f15623e, 1);
    }

    private int D(@NonNull T[] tArr) {
        if (tArr.length == 0) {
            return 0;
        }
        Arrays.sort(tArr, this.f15624f);
        int i2 = 1;
        int i3 = 0;
        for (int i4 = 1; i4 < tArr.length; i4++) {
            T t = tArr[i4];
            if (this.f15624f.compare(tArr[i3], t) == 0) {
                int m2 = m(t, tArr, i3, i2);
                if (m2 != -1) {
                    tArr[m2] = t;
                } else {
                    if (i2 != i4) {
                        tArr[i2] = t;
                    }
                    i2++;
                }
            } else {
                if (i2 != i4) {
                    tArr[i2] = t;
                }
                i3 = i2;
                i2++;
            }
        }
        return i2;
    }

    private void E() {
        if (this.f15620b != null) {
            throw new IllegalStateException("Data cannot be mutated in the middle of a batch update operation such as addAll or replaceAll.");
        }
    }

    private int b(T t, boolean z) {
        int l2 = l(t, this.f15619a, 0, this.f15626h, 1);
        if (l2 == -1) {
            l2 = 0;
        } else if (l2 < this.f15626h) {
            T t2 = this.f15619a[l2];
            if (this.f15624f.f(t2, t)) {
                if (this.f15624f.e(t2, t)) {
                    this.f15619a[l2] = t;
                    return l2;
                }
                this.f15619a[l2] = t;
                Callback callback = this.f15624f;
                callback.d(l2, 1, callback.g(t2, t));
                return l2;
            }
        }
        g(l2, t);
        if (z) {
            this.f15624f.b(l2, 1);
        }
        return l2;
    }

    private void f(T[] tArr) {
        if (tArr.length >= 1) {
            int D = D(tArr);
            if (this.f15626h == 0) {
                this.f15619a = tArr;
                this.f15626h = D;
                this.f15624f.b(0, D);
                return;
            }
            q(tArr, D);
        }
    }

    private void g(int i2, T t) {
        int i3 = this.f15626h;
        if (i2 <= i3) {
            T[] tArr = this.f15619a;
            if (i3 == tArr.length) {
                T[] tArr2 = (Object[]) Array.newInstance(this.f15627i, tArr.length + 10);
                System.arraycopy(this.f15619a, 0, tArr2, 0, i2);
                tArr2[i2] = t;
                System.arraycopy(this.f15619a, i2, tArr2, i2 + 1, this.f15626h - i2);
                this.f15619a = tArr2;
            } else {
                System.arraycopy(tArr, i2, tArr, i2 + 1, i3 - i2);
                this.f15619a[i2] = t;
            }
            this.f15626h++;
            return;
        }
        throw new IndexOutOfBoundsException("cannot add item to " + i2 + " because size is " + this.f15626h);
    }

    private T[] j(T[] tArr) {
        T[] tArr2 = (Object[]) Array.newInstance(this.f15627i, tArr.length);
        System.arraycopy(tArr, 0, tArr2, 0, tArr.length);
        return tArr2;
    }

    private int l(T t, T[] tArr, int i2, int i3, int i4) {
        while (i2 < i3) {
            int i5 = (i2 + i3) / 2;
            T t2 = tArr[i5];
            int compare = this.f15624f.compare(t2, t);
            if (compare < 0) {
                i2 = i5 + 1;
            } else if (compare != 0) {
                i3 = i5;
            } else if (this.f15624f.f(t2, t)) {
                return i5;
            } else {
                int p = p(t, i5, i2, i3);
                if (i4 == 1) {
                    return p == -1 ? i5 : p;
                }
                return p;
            }
        }
        if (i4 == 1) {
            return i2;
        }
        return -1;
    }

    private int m(T t, T[] tArr, int i2, int i3) {
        while (i2 < i3) {
            if (this.f15624f.f(tArr[i2], t)) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    private int p(T t, int i2, int i3, int i4) {
        T t2;
        int i5 = i2 - 1;
        while (i5 >= i3) {
            T t3 = this.f15619a[i5];
            if (this.f15624f.compare(t3, t) != 0) {
                break;
            } else if (this.f15624f.f(t3, t)) {
                return i5;
            } else {
                i5--;
            }
        }
        do {
            i2++;
            if (i2 >= i4) {
                return -1;
            }
            t2 = this.f15619a[i2];
            if (this.f15624f.compare(t2, t) != 0) {
                return -1;
            }
        } while (!this.f15624f.f(t2, t));
        return i2;
    }

    private void q(T[] tArr, int i2) {
        boolean z = !(this.f15624f instanceof BatchedCallback);
        if (z) {
            h();
        }
        this.f15620b = this.f15619a;
        int i3 = 0;
        this.f15621c = 0;
        int i4 = this.f15626h;
        this.f15622d = i4;
        this.f15619a = (Object[]) Array.newInstance(this.f15627i, i4 + i2 + 10);
        this.f15623e = 0;
        while (true) {
            int i5 = this.f15621c;
            int i6 = this.f15622d;
            if (i5 >= i6 && i3 >= i2) {
                break;
            } else if (i5 == i6) {
                int i7 = i2 - i3;
                System.arraycopy(tArr, i3, this.f15619a, this.f15623e, i7);
                int i8 = this.f15623e + i7;
                this.f15623e = i8;
                this.f15626h += i7;
                this.f15624f.b(i8 - i7, i7);
                break;
            } else if (i3 == i2) {
                int i9 = i6 - i5;
                System.arraycopy(this.f15620b, i5, this.f15619a, this.f15623e, i9);
                this.f15623e += i9;
                break;
            } else {
                T t = this.f15620b[i5];
                T t2 = tArr[i3];
                int compare = this.f15624f.compare(t, t2);
                if (compare > 0) {
                    T[] tArr2 = this.f15619a;
                    int i10 = this.f15623e;
                    this.f15623e = i10 + 1;
                    tArr2[i10] = t2;
                    this.f15626h++;
                    i3++;
                    this.f15624f.b(i10, 1);
                } else if (compare != 0 || !this.f15624f.f(t, t2)) {
                    T[] tArr3 = this.f15619a;
                    int i11 = this.f15623e;
                    this.f15623e = i11 + 1;
                    tArr3[i11] = t;
                    this.f15621c++;
                } else {
                    T[] tArr4 = this.f15619a;
                    int i12 = this.f15623e;
                    this.f15623e = i12 + 1;
                    tArr4[i12] = t2;
                    i3++;
                    this.f15621c++;
                    if (!this.f15624f.e(t, t2)) {
                        Callback callback = this.f15624f;
                        callback.d(this.f15623e - 1, 1, callback.g(t, t2));
                    }
                }
            }
        }
        this.f15620b = null;
        if (z) {
            k();
        }
    }

    private boolean t(T t, boolean z) {
        int l2 = l(t, this.f15619a, 0, this.f15626h, 2);
        if (l2 == -1) {
            return false;
        }
        v(l2, z);
        return true;
    }

    private void v(int i2, boolean z) {
        T[] tArr = this.f15619a;
        System.arraycopy(tArr, i2 + 1, tArr, i2, (this.f15626h - i2) - 1);
        int i3 = this.f15626h - 1;
        this.f15626h = i3;
        this.f15619a[i3] = null;
        if (z) {
            this.f15624f.c(i2, 1);
        }
    }

    private void z(T t) {
        T[] tArr = this.f15619a;
        int i2 = this.f15623e;
        tArr[i2] = t;
        this.f15623e = i2 + 1;
        this.f15626h++;
        this.f15624f.b(i2, 1);
    }

    public int C() {
        return this.f15626h;
    }

    public void F(int i2, T t) {
        E();
        T n2 = n(i2);
        boolean z = n2 == t || !this.f15624f.e(n2, t);
        if (n2 == t || this.f15624f.compare(n2, t) != 0) {
            if (z) {
                Callback callback = this.f15624f;
                callback.d(i2, 1, callback.g(n2, t));
            }
            v(i2, false);
            int b2 = b(t, false);
            if (i2 != b2) {
                this.f15624f.a(i2, b2);
                return;
            }
            return;
        }
        this.f15619a[i2] = t;
        if (z) {
            Callback callback2 = this.f15624f;
            callback2.d(i2, 1, callback2.g(n2, t));
        }
    }

    public int a(T t) {
        E();
        return b(t, true);
    }

    public void c(@NonNull Collection<T> collection) {
        e(collection.toArray((Object[]) Array.newInstance(this.f15627i, collection.size())), true);
    }

    public void d(@NonNull T... tArr) {
        e(tArr, false);
    }

    public void e(@NonNull T[] tArr, boolean z) {
        E();
        if (tArr.length != 0) {
            if (z) {
                f(tArr);
            } else {
                f(j(tArr));
            }
        }
    }

    public void h() {
        E();
        Callback callback = this.f15624f;
        if (!(callback instanceof BatchedCallback)) {
            if (this.f15625g == null) {
                this.f15625g = new BatchedCallback(callback);
            }
            this.f15624f = this.f15625g;
        }
    }

    public void i() {
        E();
        int i2 = this.f15626h;
        if (i2 != 0) {
            Arrays.fill(this.f15619a, 0, i2, (Object) null);
            this.f15626h = 0;
            this.f15624f.c(0, i2);
        }
    }

    public void k() {
        E();
        Callback callback = this.f15624f;
        if (callback instanceof BatchedCallback) {
            ((BatchedCallback) callback).i();
        }
        Callback callback2 = this.f15624f;
        BatchedCallback batchedCallback = this.f15625g;
        if (callback2 == batchedCallback) {
            this.f15624f = batchedCallback.s;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000a, code lost:
        r1 = r3.f15623e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T n(int r4) throws java.lang.IndexOutOfBoundsException {
        /*
            r3 = this;
            int r0 = r3.f15626h
            if (r4 >= r0) goto L_0x001a
            if (r4 < 0) goto L_0x001a
            T[] r0 = r3.f15620b
            if (r0 == 0) goto L_0x0015
            int r1 = r3.f15623e
            if (r4 < r1) goto L_0x0015
            int r4 = r4 - r1
            int r1 = r3.f15621c
            int r4 = r4 + r1
            r4 = r0[r4]
            return r4
        L_0x0015:
            T[] r0 = r3.f15619a
            r4 = r0[r4]
            return r4
        L_0x001a:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Asked to get item at "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = " but size is "
            r1.append(r4)
            int r4 = r3.f15626h
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.SortedList.n(int):java.lang.Object");
    }

    public int o(T t) {
        if (this.f15620b != null) {
            int l2 = l(t, this.f15619a, 0, this.f15623e, 4);
            if (l2 != -1) {
                return l2;
            }
            int l3 = l(t, this.f15620b, this.f15621c, this.f15622d, 4);
            if (l3 != -1) {
                return (l3 - this.f15621c) + this.f15623e;
            }
            return -1;
        }
        return l(t, this.f15619a, 0, this.f15626h, 4);
    }

    public void r(int i2) {
        E();
        Object n2 = n(i2);
        v(i2, false);
        int b2 = b(n2, false);
        if (i2 != b2) {
            this.f15624f.a(i2, b2);
        }
    }

    public boolean s(T t) {
        E();
        return t(t, true);
    }

    public T u(int i2) {
        E();
        T n2 = n(i2);
        v(i2, true);
        return n2;
    }

    public void w(@NonNull Collection<T> collection) {
        y(collection.toArray((Object[]) Array.newInstance(this.f15627i, collection.size())), true);
    }

    public void x(@NonNull T... tArr) {
        y(tArr, false);
    }

    public void y(@NonNull T[] tArr, boolean z) {
        E();
        if (z) {
            A(tArr);
        } else {
            A(j(tArr));
        }
    }

    public SortedList(@NonNull Class<T> cls, @NonNull Callback<T> callback, int i2) {
        this.f15627i = cls;
        this.f15619a = (Object[]) Array.newInstance(cls, i2);
        this.f15624f = callback;
        this.f15626h = 0;
    }
}
