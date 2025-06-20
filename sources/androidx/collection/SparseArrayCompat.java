package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dd.plist.ASCIIPropertyListParser;

public class SparseArrayCompat<E> implements Cloneable {
    private static final Object X2 = new Object();
    private int[] X;
    private Object[] Y;
    private int Z;
    private boolean s;

    public SparseArrayCompat() {
        this(10);
    }

    private void g() {
        int i2 = this.Z;
        int[] iArr = this.X;
        Object[] objArr = this.Y;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            Object obj = objArr[i4];
            if (obj != X2) {
                if (i4 != i3) {
                    iArr[i3] = iArr[i4];
                    objArr[i3] = obj;
                    objArr[i4] = null;
                }
                i3++;
            }
        }
        this.s = false;
        this.Z = i3;
    }

    public E A(int i2) {
        if (this.s) {
            g();
        }
        return this.Y[i2];
    }

    public void a(int i2, E e2) {
        int i3 = this.Z;
        if (i3 == 0 || i2 > this.X[i3 - 1]) {
            if (this.s && i3 >= this.X.length) {
                g();
            }
            int i4 = this.Z;
            if (i4 >= this.X.length) {
                int e3 = ContainerHelpers.e(i4 + 1);
                int[] iArr = new int[e3];
                Object[] objArr = new Object[e3];
                int[] iArr2 = this.X;
                System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
                Object[] objArr2 = this.Y;
                System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
                this.X = iArr;
                this.Y = objArr;
            }
            this.X[i4] = i2;
            this.Y[i4] = e2;
            this.Z = i4 + 1;
            return;
        }
        p(i2, e2);
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
    public SparseArrayCompat<E> clone() {
        try {
            SparseArrayCompat<E> sparseArrayCompat = (SparseArrayCompat) super.clone();
            sparseArrayCompat.X = (int[]) this.X.clone();
            sparseArrayCompat.Y = (Object[]) this.Y.clone();
            return sparseArrayCompat;
        } catch (CloneNotSupportedException e2) {
            throw new AssertionError(e2);
        }
    }

    public boolean d(int i2) {
        return l(i2) >= 0;
    }

    public boolean e(E e2) {
        return m(e2) >= 0;
    }

    @Deprecated
    public void f(int i2) {
        s(i2);
    }

    @Nullable
    public E h(int i2) {
        return i(i2, (Object) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r3 = r2.Y[r3];
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E i(int r3, E r4) {
        /*
            r2 = this;
            int[] r0 = r2.X
            int r1 = r2.Z
            int r3 = androidx.collection.ContainerHelpers.a(r0, r1, r3)
            if (r3 < 0) goto L_0x0014
            java.lang.Object[] r0 = r2.Y
            r3 = r0[r3]
            java.lang.Object r0 = X2
            if (r3 != r0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            return r3
        L_0x0014:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SparseArrayCompat.i(int, java.lang.Object):java.lang.Object");
    }

    public int l(int i2) {
        if (this.s) {
            g();
        }
        return ContainerHelpers.a(this.X, this.Z, i2);
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
        return z() == 0;
    }

    public int o(int i2) {
        if (this.s) {
            g();
        }
        return this.X[i2];
    }

    public void p(int i2, E e2) {
        int a2 = ContainerHelpers.a(this.X, this.Z, i2);
        if (a2 >= 0) {
            this.Y[a2] = e2;
            return;
        }
        int i3 = ~a2;
        int i4 = this.Z;
        if (i3 < i4) {
            Object[] objArr = this.Y;
            if (objArr[i3] == X2) {
                this.X[i3] = i2;
                objArr[i3] = e2;
                return;
            }
        }
        if (this.s && i4 >= this.X.length) {
            g();
            i3 = ~ContainerHelpers.a(this.X, this.Z, i2);
        }
        int i5 = this.Z;
        if (i5 >= this.X.length) {
            int e3 = ContainerHelpers.e(i5 + 1);
            int[] iArr = new int[e3];
            Object[] objArr2 = new Object[e3];
            int[] iArr2 = this.X;
            System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
            Object[] objArr3 = this.Y;
            System.arraycopy(objArr3, 0, objArr2, 0, objArr3.length);
            this.X = iArr;
            this.Y = objArr2;
        }
        int i6 = this.Z;
        if (i6 - i3 != 0) {
            int[] iArr3 = this.X;
            int i7 = i3 + 1;
            System.arraycopy(iArr3, i3, iArr3, i7, i6 - i3);
            Object[] objArr4 = this.Y;
            System.arraycopy(objArr4, i3, objArr4, i7, this.Z - i3);
        }
        this.X[i3] = i2;
        this.Y[i3] = e2;
        this.Z++;
    }

    public void q(@NonNull SparseArrayCompat<? extends E> sparseArrayCompat) {
        int z = sparseArrayCompat.z();
        for (int i2 = 0; i2 < z; i2++) {
            p(sparseArrayCompat.o(i2), sparseArrayCompat.A(i2));
        }
    }

    @Nullable
    public E r(int i2, E e2) {
        E h2 = h(i2);
        if (h2 == null) {
            p(i2, e2);
        }
        return h2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000a, code lost:
        r0 = r3.Y;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void s(int r4) {
        /*
            r3 = this;
            int[] r0 = r3.X
            int r1 = r3.Z
            int r4 = androidx.collection.ContainerHelpers.a(r0, r1, r4)
            if (r4 < 0) goto L_0x0017
            java.lang.Object[] r0 = r3.Y
            r1 = r0[r4]
            java.lang.Object r2 = X2
            if (r1 == r2) goto L_0x0017
            r0[r4] = r2
            r4 = 1
            r3.s = r4
        L_0x0017:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.SparseArrayCompat.s(int):void");
    }

    public boolean t(int i2, Object obj) {
        int l2 = l(i2);
        if (l2 < 0) {
            return false;
        }
        Object A = A(l2);
        if (obj != A && (obj == null || !obj.equals(A))) {
            return false;
        }
        u(l2);
        return true;
    }

    public String toString() {
        if (z() <= 0) {
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
            Object A = A(i2);
            if (A != this) {
                sb.append(A);
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

    public void v(int i2, int i3) {
        int min = Math.min(this.Z, i3 + i2);
        while (i2 < min) {
            u(i2);
            i2++;
        }
    }

    @Nullable
    public E w(int i2, E e2) {
        int l2 = l(i2);
        if (l2 < 0) {
            return null;
        }
        E[] eArr = this.Y;
        E e3 = eArr[l2];
        eArr[l2] = e2;
        return e3;
    }

    public boolean x(int i2, E e2, E e3) {
        int l2 = l(i2);
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

    public void y(int i2, E e2) {
        if (this.s) {
            g();
        }
        this.Y[i2] = e2;
    }

    public int z() {
        if (this.s) {
            g();
        }
        return this.Z;
    }

    public SparseArrayCompat(int i2) {
        this.s = false;
        if (i2 == 0) {
            this.X = ContainerHelpers.f3550a;
            this.Y = ContainerHelpers.f3552c;
            return;
        }
        int e2 = ContainerHelpers.e(i2);
        this.X = new int[e2];
        this.Y = new Object[e2];
    }
}
