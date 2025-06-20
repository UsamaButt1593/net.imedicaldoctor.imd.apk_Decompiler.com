package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.primitives.Ints;
import java.util.Comparator;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
final class RegularImmutableSortedMultiset<E> extends ImmutableSortedMultiset<E> {
    private static final long[] b3 = {0};
    static final ImmutableSortedMultiset<Comparable> c3 = new RegularImmutableSortedMultiset(Ordering.z());
    @VisibleForTesting
    final transient RegularImmutableSortedSet<E> X2;
    private final transient long[] Y2;
    private final transient int Z2;
    private final transient int a3;

    RegularImmutableSortedMultiset(RegularImmutableSortedSet<E> regularImmutableSortedSet, long[] jArr, int i2, int i3) {
        this.X2 = regularImmutableSortedSet;
        this.Y2 = jArr;
        this.Z2 = i2;
        this.a3 = i3;
    }

    private int E0(int i2) {
        long[] jArr = this.Y2;
        int i3 = this.Z2;
        return (int) (jArr[(i3 + i2) + 1] - jArr[i3 + i2]);
    }

    /* renamed from: B0 */
    public ImmutableSortedMultiset<E> D1(E e2, BoundType boundType) {
        return F0(this.X2.a1(e2, Preconditions.E(boundType) == BoundType.CLOSED), this.a3);
    }

    /* access modifiers changed from: package-private */
    public Multiset.Entry<E> E(int i2) {
        return Multisets.k(this.X2.b().get(i2), E0(i2));
    }

    /* access modifiers changed from: package-private */
    public ImmutableSortedMultiset<E> F0(int i2, int i3) {
        Preconditions.f0(i2, i3, this.a3);
        if (i2 == i3) {
            return ImmutableSortedMultiset.l0(comparator());
        }
        return (i2 == 0 && i3 == this.a3) ? this : new RegularImmutableSortedMultiset(this.X2.X0(i2, i3), this.Y2, this.Z2 + i2, i3 - i2);
    }

    @CheckForNull
    public Multiset.Entry<E> firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return E(0);
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return this.Z2 > 0 || this.a3 < this.Y2.length - 1;
    }

    /* renamed from: k0 */
    public ImmutableSortedSet<E> e() {
        return this.X2;
    }

    public int l1(@CheckForNull Object obj) {
        int indexOf = this.X2.indexOf(obj);
        if (indexOf >= 0) {
            return E0(indexOf);
        }
        return 0;
    }

    @CheckForNull
    public Multiset.Entry<E> lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return E(this.a3 - 1);
    }

    /* renamed from: m0 */
    public ImmutableSortedMultiset<E> e1(E e2, BoundType boundType) {
        return F0(0, this.X2.Z0(e2, Preconditions.E(boundType) == BoundType.CLOSED));
    }

    public int size() {
        long[] jArr = this.Y2;
        int i2 = this.Z2;
        return Ints.z(jArr[this.a3 + i2] - jArr[i2]);
    }

    RegularImmutableSortedMultiset(Comparator<? super E> comparator) {
        this.X2 = ImmutableSortedSet.u0(comparator);
        this.Y2 = b3;
        this.Z2 = 0;
        this.a3 = 0;
    }
}
