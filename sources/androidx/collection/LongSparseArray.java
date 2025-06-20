package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dd.plist.ASCIIPropertyListParser;

public class LongSparseArray<E> implements Cloneable {
    private static final Object X2 = new Object();
    private long[] X;
    private Object[] Y;
    private int Z;
    private boolean s;

    public LongSparseArray() {
        this(10);
    }

    private void g() {
        int i2 = this.Z;
        long[] jArr = this.X;
        Object[] objArr = this.Y;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != X2) {
                if (i4 != i3) {
                    jArr[i3] = jArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.s = false;
        this.Z = i3;
    }

    public void a(long j2, E e2) {
        int i2 = this.Z;
        if (i2 == 0 || j2 > this.X[i2 - 1]) {
            if (this.s && i2 >= this.X.length) {
                g();
            }
            int i3 = this.Z;
            if (i3 >= this.X.length) {
                int f2 = ContainerHelpers.f(i3 + 1);
                long[] jArr = new long[f2];
                Object[] objArr = new Object[f2];
                long[] jArr2 = this.X;
                System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
                Object[] objArr2 = this.Y;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.X = jArr;
                this.Y = objArr;
            }
            this.X[i3] = j2;
            this.Y[i3] = e2;
            this.Z = i3 + 1;
            return;
        }
        p(j2, e2);
    }

    public void b() {
        int i2 = this.Z;
        Object[] objArr = this.Y;
        for (int i3 = 0; i3 < i2; i3++) {
            objArr[i3] = null;
        }
        this.Z = 0;
        this.s = false;
    }

    /* renamed from: c */
    public LongSparseArray<E> clone() {
        try {
            LongSparseArray<E> longSparseArray = (LongSparseArray) super.clone();
            longSparseArray.X = (long[]) this.X.clone();
            longSparseArray.Y = (Object[]) this.Y.clone();
            return longSparseArray;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean d(long j2) {
        return l(j2) >= 0;
    }

    public boolean e(E e2) {
        return m(e2) >= 0;
    }

    @Deprecated
    public void f(long j2) {
        s(j2);
    }

    @Nullable
    public E h(long j2) {
        return i(j2, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = r2.Y[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E i(long r3, E r5) {
        /*
            r2 = this;
            long[] r0 = r2.X
            int r1 = r2.Z
            int r3 = androidx.collection.ContainerHelpers.b(r0, r1, r3)
            if (r3 < 0) goto L_0x0014
            java.lang.Object[] r4 = r2.Y
            r3 = r4[r3]
            java.lang.Object r4 = X2
            if (r3 != r4) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return r3
        L_0x0014:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongSparseArray.i(long, java.lang.Object):java.lang.Object");
    }

    public int l(long j2) {
        if (this.s) {
            g();
        }
        return ContainerHelpers.b(this.X, this.Z, j2);
    }

    public int m(E e2) {
        if (this.s) {
            g();
        }
        for (int i2 = 0; i2 < this.Z; i2++) {
            if (this.Y[i2] == e2) {
                return i2;
            }
        }
        return -1;
    }

    public boolean n() {
        return y() == 0;
    }

    public long o(int i2) {
        if (this.s) {
            g();
        }
        return this.X[i2];
    }

    public void p(long j2, E e2) {
        int b2 = ContainerHelpers.b(this.X, this.Z, j2);
        if (b2 >= 0) {
            this.Y[b2] = e2;
            return;
        }
        int i2 = ~b2;
        int i3 = this.Z;
        if (i2 < i3) {
            Object[] objArr = this.Y;
            if (objArr[i2] == X2) {
                this.X[i2] = j2;
                objArr[i2] = e2;
                return;
            }
        }
        if (this.s && i3 >= this.X.length) {
            g();
            i2 = ~ContainerHelpers.b(this.X, this.Z, j2);
        }
        int i4 = this.Z;
        if (i4 >= this.X.length) {
            int f2 = ContainerHelpers.f(i4 + 1);
            long[] jArr = new long[f2];
            Object[] objArr2 = new Object[f2];
            long[] jArr2 = this.X;
            System.arraycopy(jArr2, 0, jArr, 0, jArr2.length);
            Object[] objArr3 = this.Y;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.X = jArr;
            this.Y = objArr2;
        }
        int i5 = this.Z;
        if (i5 - i2 != 0) {
            long[] jArr3 = this.X;
            int i6 = i2 + 1;
            System.arraycopy(jArr3, i2, jArr3, i6, i5 - i2);
            Object[] objArr4 = this.Y;
            System.arraycopy(objArr4, i2, objArr4, i6, this.Z - i2);
        }
        this.X[i2] = j2;
        this.Y[i2] = e2;
        this.Z++;
    }

    public void q(@NonNull LongSparseArray<? extends E> longSparseArray) {
        int y = longSparseArray.y();
        for (int i2 = 0; i2 < y; i2++) {
            p(longSparseArray.o(i2), longSparseArray.z(i2));
        }
    }

    @Nullable
    public E r(long j2, E e2) {
        E h2 = h(j2);
        if (h2 == null) {
            p(j2, e2);
        }
        return h2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r4 = r2.Y;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s(long r3) {
        /*
            r2 = this;
            long[] r0 = r2.X
            int r1 = r2.Z
            int r3 = androidx.collection.ContainerHelpers.b(r0, r1, r3)
            if (r3 < 0) goto L_0x0017
            java.lang.Object[] r4 = r2.Y
            r0 = r4[r3]
            java.lang.Object r1 = X2
            if (r0 == r1) goto L_0x0017
            r4[r3] = r1
            r3 = 1
            r2.s = r3
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongSparseArray.s(long):void");
    }

    public boolean t(long j2, Object obj) {
        int l2 = l(j2);
        if (l2 < 0) {
            return false;
        }
        Object z = z(l2);
        if (obj != z && (obj == null || !obj.equals(z))) {
            return false;
        }
        u(l2);
        return true;
    }

    public String toString() {
        if (y() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.Z * 28);
        sb.append(ASCIIPropertyListParser.f18652j);
        for (int i2 = 0; i2 < this.Z; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(o(i2));
            sb.append(ASCIIPropertyListParser.f18654l);
            Object z = z(i2);
            if (z != this) {
                sb.append(z);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append(ASCIIPropertyListParser.f18653k);
        return sb.toString();
    }

    public void u(int i2) {
        Object[] objArr = this.Y;
        Object obj = objArr[i2];
        Object obj2 = X2;
        if (obj != obj2) {
            objArr[i2] = obj2;
            this.s = true;
        }
    }

    @Nullable
    public E v(long j2, E e2) {
        int l2 = l(j2);
        if (l2 < 0) {
            return null;
        }
        E[] eArr = this.Y;
        E e3 = eArr[l2];
        eArr[l2] = e2;
        return e3;
    }

    public boolean w(long j2, E e2, E e3) {
        int l2 = l(j2);
        if (l2 < 0) {
            return false;
        }
        E e4 = this.Y[l2];
        if (e4 != e2 && (e2 == null || !e2.equals(e4))) {
            return false;
        }
        this.Y[l2] = e3;
        return true;
    }

    public void x(int i2, E e2) {
        if (this.s) {
            g();
        }
        this.Y[i2] = e2;
    }

    public int y() {
        if (this.s) {
            g();
        }
        return this.Z;
    }

    public E z(int i2) {
        if (this.s) {
            g();
        }
        return this.Y[i2];
    }

    public LongSparseArray(int i2) {
        this.s = false;
        if (i2 == 0) {
            this.X = ContainerHelpers.f3551b;
            this.Y = ContainerHelpers.f3552c;
            return;
        }
        int f2 = ContainerHelpers.f(i2);
        this.X = new long[f2];
        this.Y = new Object[f2];
    }
}
