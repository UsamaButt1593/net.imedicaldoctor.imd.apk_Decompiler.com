package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;
import net.lingala.zip4j.util.InternalZipConstants;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private static final int j3 = -2;
    @CheckForNull
    @VisibleForTesting
    transient long[] f3;
    private transient int g3;
    private transient int h3;
    private final boolean i3;

    CompactLinkedHashMap() {
        this(3);
    }

    public static <K, V> CompactLinkedHashMap<K, V> i0() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> j0(int i2) {
        return new CompactLinkedHashMap<>(i2);
    }

    private int l0(int i2) {
        return ((int) (m0(i2) >>> 32)) - 1;
    }

    private long m0(int i2) {
        return n0()[i2];
    }

    private long[] n0() {
        long[] jArr = this.f3;
        Objects.requireNonNull(jArr);
        return jArr;
    }

    private void o0(int i2, long j2) {
        n0()[i2] = j2;
    }

    private void p0(int i2, int i4) {
        o0(i2, (m0(i2) & InternalZipConstants.f30717k) | (((long) (i4 + 1)) << 32));
    }

    private void r0(int i2, int i4) {
        if (i2 == -2) {
            this.g3 = i4;
        } else {
            t0(i2, i4);
        }
        if (i4 == -2) {
            this.h3 = i2;
        } else {
            p0(i4, i2);
        }
    }

    private void t0(int i2, int i4) {
        o0(i2, (m0(i2) & -4294967296L) | (((long) (i4 + 1)) & InternalZipConstants.f30717k));
    }

    /* access modifiers changed from: package-private */
    public int D() {
        return this.g3;
    }

    /* access modifiers changed from: package-private */
    public int E(int i2) {
        return ((int) m0(i2)) - 1;
    }

    /* access modifiers changed from: package-private */
    public void J(int i2) {
        super.J(i2);
        this.g3 = -2;
        this.h3 = -2;
    }

    /* access modifiers changed from: package-private */
    public void K(int i2, @ParametricNullness K k2, @ParametricNullness V v, int i4, int i5) {
        super.K(i2, k2, v, i4, i5);
        r0(this.h3, i2);
        r0(i2, -2);
    }

    /* access modifiers changed from: package-private */
    public void O(int i2, int i4) {
        int size = size() - 1;
        super.O(i2, i4);
        r0(l0(i2), E(i2));
        if (i2 < size) {
            r0(l0(size), i2);
            r0(i2, E(size));
        }
        o0(size, 0);
    }

    /* access modifiers changed from: package-private */
    public void W(int i2) {
        super.W(i2);
        this.f3 = Arrays.copyOf(n0(), i2);
    }

    public void clear() {
        if (!P()) {
            this.g3 = -2;
            this.h3 = -2;
            long[] jArr = this.f3;
            if (jArr != null) {
                Arrays.fill(jArr, 0, size(), 0);
            }
            super.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public void n(int i2) {
        if (this.i3) {
            r0(l0(i2), E(i2));
            r0(this.h3, i2);
            r0(i2, -2);
            H();
        }
    }

    /* access modifiers changed from: package-private */
    public int o(int i2, int i4) {
        return i2 >= size() ? i4 : i2;
    }

    /* access modifiers changed from: package-private */
    public int p() {
        int p = super.p();
        this.f3 = new long[p];
        return p;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public Map<K, V> s() {
        Map<K, V> s = super.s();
        this.f3 = null;
        return s;
    }

    /* access modifiers changed from: package-private */
    public Map<K, V> v(int i2) {
        return new LinkedHashMap(i2, 1.0f, this.i3);
    }

    CompactLinkedHashMap(int i2) {
        this(i2, false);
    }

    CompactLinkedHashMap(int i2, boolean z) {
        super(i2);
        this.i3 = z;
    }
}
