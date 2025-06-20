package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.Objects;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> X2 = new RegularImmutableList(new Object[0], 0);
    @VisibleForTesting
    final transient Object[] Y;
    private final transient int Z;

    RegularImmutableList(Object[] objArr, int i2) {
        this.Y = objArr;
        this.Z = i2;
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i2) {
        System.arraycopy(this.Y, 0, objArr, i2, this.Z);
        return i2 + this.Z;
    }

    /* access modifiers changed from: package-private */
    public Object[] d() {
        return this.Y;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.Z;
    }

    public E get(int i2) {
        Preconditions.C(i2, this.Z);
        E e2 = this.Y[i2];
        Objects.requireNonNull(e2);
        return e2;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return false;
    }

    public int size() {
        return this.Z;
    }
}
