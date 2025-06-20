package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import net.lingala.zip4j.util.InternalZipConstants;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
class ObjectCountLinkedHashMap<K> extends ObjectCountHashMap<K> {
    private static final int r = -2;
    @VisibleForTesting
    transient long[] o;
    private transient int p;
    private transient int q;

    ObjectCountLinkedHashMap() {
        this(3);
    }

    static <K> ObjectCountLinkedHashMap<K> F() {
        return new ObjectCountLinkedHashMap<>();
    }

    static <K> ObjectCountLinkedHashMap<K> G(int i2) {
        return new ObjectCountLinkedHashMap<>(i2);
    }

    private int H(int i2) {
        return (int) (this.o[i2] >>> 32);
    }

    private int I(int i2) {
        return (int) this.o[i2];
    }

    private void J(int i2, int i3) {
        long[] jArr = this.o;
        jArr[i2] = (jArr[i2] & InternalZipConstants.f30717k) | (((long) i3) << 32);
    }

    private void K(int i2, int i3) {
        if (i2 == -2) {
            this.p = i3;
        } else {
            L(i2, i3);
        }
        if (i3 == -2) {
            this.q = i2;
        } else {
            J(i3, i2);
        }
    }

    private void L(int i2, int i3) {
        long[] jArr = this.o;
        jArr[i2] = (jArr[i2] & -4294967296L) | (((long) i3) & InternalZipConstants.f30717k);
    }

    public void a() {
        super.a();
        this.p = -2;
        this.q = -2;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        int i2 = this.p;
        if (i2 == -2) {
            return -1;
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void o(int i2, float f2) {
        super.o(i2, f2);
        this.p = -2;
        this.q = -2;
        long[] jArr = new long[i2];
        this.o = jArr;
        Arrays.fill(jArr, -1);
    }

    /* access modifiers changed from: package-private */
    public void p(int i2, @ParametricNullness K k2, int i3, int i4) {
        super.p(i2, k2, i3, i4);
        K(this.q, i2);
        K(i2, -2);
    }

    /* access modifiers changed from: package-private */
    public void q(int i2) {
        int D = D() - 1;
        K(H(i2), I(i2));
        if (i2 < D) {
            K(H(D), i2);
            K(i2, I(D));
        }
        super.q(i2);
    }

    /* access modifiers changed from: package-private */
    public int t(int i2) {
        int I = I(i2);
        if (I == -2) {
            return -1;
        }
        return I;
    }

    /* access modifiers changed from: package-private */
    public int u(int i2, int i3) {
        return i2 == D() ? i3 : i2;
    }

    /* access modifiers changed from: package-private */
    public void z(int i2) {
        super.z(i2);
        long[] jArr = this.o;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i2);
        this.o = copyOf;
        Arrays.fill(copyOf, length, i2, -1);
    }

    ObjectCountLinkedHashMap(int i2) {
        this(i2, 1.0f);
    }

    ObjectCountLinkedHashMap(int i2, float f2) {
        super(i2, f2);
    }

    ObjectCountLinkedHashMap(ObjectCountHashMap<K> objectCountHashMap) {
        o(objectCountHashMap.D(), 1.0f);
        int f2 = objectCountHashMap.f();
        while (f2 != -1) {
            v(objectCountHashMap.j(f2), objectCountHashMap.l(f2));
            f2 = objectCountHashMap.t(f2);
        }
    }
}
