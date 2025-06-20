package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSortedSet;
import com.google.errorprone.annotations.DoNotCall;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import java.util.Objects;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public abstract class ContiguousSet<C extends Comparable> extends ImmutableSortedSet<C> {
    final DiscreteDomain<C> a3;

    ContiguousSet(DiscreteDomain<C> discreteDomain) {
        super(Ordering.z());
        this.a3 = discreteDomain;
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public static <E> ImmutableSortedSet.Builder<E> U() {
        throw new UnsupportedOperationException();
    }

    public static ContiguousSet<Integer> X0(int i2, int i3) {
        return f1(Range.f(Integer.valueOf(i2), Integer.valueOf(i3)), DiscreteDomain.c());
    }

    public static ContiguousSet<Long> Z0(long j2, long j3) {
        return f1(Range.f(Long.valueOf(j2), Long.valueOf(j3)), DiscreteDomain.d());
    }

    public static ContiguousSet<Integer> a1(int i2, int i3) {
        return f1(Range.g(Integer.valueOf(i2), Integer.valueOf(i3)), DiscreteDomain.c());
    }

    public static ContiguousSet<Long> b1(long j2, long j3) {
        return f1(Range.g(Long.valueOf(j2), Long.valueOf(j3)), DiscreteDomain.d());
    }

    public static <C extends Comparable> ContiguousSet<C> f1(Range<C> range, DiscreteDomain<C> discreteDomain) {
        Preconditions.E(range);
        Preconditions.E(discreteDomain);
        try {
            Range<C> s = !range.q() ? range.s(Range.c(discreteDomain.f())) : range;
            if (!range.r()) {
                s = s.s(Range.d(discreteDomain.e()));
            }
            if (!s.u()) {
                C m2 = range.s.m(discreteDomain);
                Objects.requireNonNull(m2);
                C k2 = range.X.k(discreteDomain);
                Objects.requireNonNull(k2);
                if (Range.h((Comparable) m2, (Comparable) k2) <= 0) {
                    return new RegularContiguousSet(s, discreteDomain);
                }
            }
            return new EmptyContiguousSet(discreteDomain);
        } catch (NoSuchElementException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    /* renamed from: g1 */
    public ContiguousSet<C> w0(C c2) {
        return y0((Comparable) Preconditions.E(c2), false);
    }

    @GwtIncompatible
    /* renamed from: i1 */
    public ContiguousSet<C> x0(C c2, boolean z) {
        return y0((Comparable) Preconditions.E(c2), z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m1 */
    public abstract ContiguousSet<C> y0(C c2, boolean z);

    public abstract ContiguousSet<C> n1(ContiguousSet<C> contiguousSet);

    public abstract Range<C> o1();

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public ImmutableSortedSet<C> p0() {
        return new DescendingImmutableSortedSet(this);
    }

    public abstract Range<C> p1(BoundType boundType, BoundType boundType2);

    /* renamed from: q1 */
    public ContiguousSet<C> subSet(C c2, C c3) {
        Preconditions.E(c2);
        Preconditions.E(c3);
        Preconditions.d(comparator().compare(c2, c3) <= 0);
        return P0(c2, true, c3, false);
    }

    @GwtIncompatible
    /* renamed from: r1 */
    public ContiguousSet<C> subSet(C c2, boolean z, C c3, boolean z2) {
        Preconditions.E(c2);
        Preconditions.E(c3);
        Preconditions.d(comparator().compare(c2, c3) <= 0);
        return P0(c2, z, c3, z2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s1 */
    public abstract ContiguousSet<C> P0(C c2, boolean z, C c3, boolean z2);

    /* renamed from: t1 */
    public ContiguousSet<C> tailSet(C c2) {
        return U0((Comparable) Preconditions.E(c2), true);
    }

    public String toString() {
        return o1().toString();
    }

    @GwtIncompatible
    /* renamed from: u1 */
    public ContiguousSet<C> tailSet(C c2, boolean z) {
        return U0((Comparable) Preconditions.E(c2), z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v1 */
    public abstract ContiguousSet<C> U0(C c2, boolean z);
}
