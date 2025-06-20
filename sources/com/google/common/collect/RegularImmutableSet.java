package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
final class RegularImmutableSet<E> extends ImmutableSet<E> {
    private static final Object[] d3;
    static final RegularImmutableSet<Object> e3;
    @VisibleForTesting
    final transient Object[] Y2;
    private final transient int Z2;
    @VisibleForTesting
    final transient Object[] a3;
    private final transient int b3;
    private final transient int c3;

    static {
        Object[] objArr = new Object[0];
        d3 = objArr;
        e3 = new RegularImmutableSet(objArr, 0, objArr, 0, 0);
    }

    RegularImmutableSet(Object[] objArr, int i2, Object[] objArr2, int i3, int i4) {
        this.Y2 = objArr;
        this.Z2 = i2;
        this.a3 = objArr2;
        this.b3 = i3;
        this.c3 = i4;
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<E> H() {
        return ImmutableList.q(this.Y2, this.c3);
    }

    /* access modifiers changed from: package-private */
    public boolean I() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i2) {
        System.arraycopy(this.Y2, 0, objArr, i2, this.c3);
        return i2 + this.c3;
    }

    public boolean contains(@CheckForNull Object obj) {
        Object[] objArr = this.a3;
        if (obj == null || objArr.length == 0) {
            return false;
        }
        int d2 = Hashing.d(obj);
        while (true) {
            int i2 = d2 & this.b3;
            Object obj2 = objArr[i2];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            d2 = i2 + 1;
        }
    }

    /* access modifiers changed from: package-private */
    public Object[] d() {
        return this.Y2;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return this.c3;
    }

    /* access modifiers changed from: package-private */
    public int h() {
        return 0;
    }

    public int hashCode() {
        return this.Z2;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return false;
    }

    /* renamed from: k */
    public UnmodifiableIterator<E> iterator() {
        return b().iterator();
    }

    public int size() {
        return this.c3;
    }
}
