package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
class CompactLinkedHashSet<E> extends CompactHashSet<E> {
    private static final int e3 = -2;
    @CheckForNull
    private transient int[] a3;
    @CheckForNull
    private transient int[] b3;
    private transient int c3;
    private transient int d3;

    CompactLinkedHashSet() {
    }

    public static <E> CompactLinkedHashSet<E> Z() {
        return new CompactLinkedHashSet<>();
    }

    public static <E> CompactLinkedHashSet<E> a0(Collection<? extends E> collection) {
        CompactLinkedHashSet<E> d0 = d0(collection.size());
        d0.addAll(collection);
        return d0;
    }

    @SafeVarargs
    public static <E> CompactLinkedHashSet<E> b0(E... eArr) {
        CompactLinkedHashSet<E> d0 = d0(eArr.length);
        Collections.addAll(d0, eArr);
        return d0;
    }

    public static <E> CompactLinkedHashSet<E> d0(int i2) {
        return new CompactLinkedHashSet<>(i2);
    }

    private int e0(int i2) {
        return f0()[i2] - 1;
    }

    private int[] f0() {
        int[] iArr = this.a3;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private int[] i0() {
        int[] iArr = this.b3;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private void j0(int i2, int i3) {
        f0()[i2] = i3 + 1;
    }

    private void k0(int i2, int i3) {
        if (i2 == -2) {
            this.c3 = i3;
        } else {
            l0(i2, i3);
        }
        if (i3 == -2) {
            this.d3 = i2;
        } else {
            j0(i3, i2);
        }
    }

    private void l0(int i2, int i3) {
        i0()[i2] = i3 + 1;
    }

    /* access modifiers changed from: package-private */
    public void D(int i2) {
        super.D(i2);
        this.c3 = -2;
        this.d3 = -2;
    }

    /* access modifiers changed from: package-private */
    public void E(int i2, @ParametricNullness E e2, int i3, int i4) {
        super.E(i2, e2, i3, i4);
        k0(this.d3, i2);
        k0(i2, -2);
    }

    /* access modifiers changed from: package-private */
    public void I(int i2, int i3) {
        int size = size() - 1;
        super.I(i2, i3);
        k0(e0(i2), z(i2));
        if (i2 < size) {
            k0(e0(size), i2);
            k0(i2, z(size));
        }
        f0()[size] = 0;
        i0()[size] = 0;
    }

    /* access modifiers changed from: package-private */
    public void P(int i2) {
        super.P(i2);
        this.a3 = Arrays.copyOf(f0(), i2);
        this.b3 = Arrays.copyOf(i0(), i2);
    }

    public void clear() {
        if (!K()) {
            this.c3 = -2;
            this.d3 = -2;
            int[] iArr = this.a3;
            if (!(iArr == null || this.b3 == null)) {
                Arrays.fill(iArr, 0, size(), 0);
                Arrays.fill(this.b3, 0, size(), 0);
            }
            super.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public int d(int i2, int i3) {
        return i2 >= size() ? i3 : i2;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        int g2 = super.g();
        this.a3 = new int[g2];
        this.b3 = new int[g2];
        return g2;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public Set<E> h() {
        Set<E> h2 = super.h();
        this.a3 = null;
        this.b3 = null;
        return h2;
    }

    public Object[] toArray() {
        return ObjectArrays.l(this);
    }

    /* access modifiers changed from: package-private */
    public int x() {
        return this.c3;
    }

    /* access modifiers changed from: package-private */
    public int z(int i2) {
        return i0()[i2] - 1;
    }

    CompactLinkedHashSet(int i2) {
        super(i2);
    }

    public <T> T[] toArray(T[] tArr) {
        return ObjectArrays.m(this, tArr);
    }
}
