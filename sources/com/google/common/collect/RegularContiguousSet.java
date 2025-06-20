package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Objects;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    private static final long c3 = 0;
    private final Range<C> b3;

    @GwtIncompatible
    @J2ktIncompatible
    private static final class SerializedForm<C extends Comparable> implements Serializable {
        final DiscreteDomain<C> X;
        final Range<C> s;

        private SerializedForm(Range<C> range, DiscreteDomain<C> discreteDomain) {
            this.s = range;
            this.X = discreteDomain;
        }

        private Object a() {
            return new RegularContiguousSet(this.s, this.X);
        }
    }

    RegularContiguousSet(Range<C> range, DiscreteDomain<C> discreteDomain) {
        super(discreteDomain);
        this.b3 = range;
    }

    @GwtIncompatible
    @J2ktIncompatible
    private void m(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* access modifiers changed from: private */
    public static boolean x1(Comparable<?> comparable, @CheckForNull Comparable<?> comparable2) {
        return comparable2 != null && Range.h(comparable, comparable2) == 0;
    }

    private ContiguousSet<C> z1(Range<C> range) {
        return this.b3.t(range) ? ContiguousSet.f1(this.b3.s(range), this.a3) : new EmptyContiguousSet(this.a3);
    }

    /* renamed from: A1 */
    public C last() {
        C k2 = this.b3.X.k(this.a3);
        Objects.requireNonNull(k2);
        return (Comparable) k2;
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<C> H() {
        return this.a3.s ? new ImmutableAsList<C>() {
            /* access modifiers changed from: package-private */
            /* renamed from: f0 */
            public ImmutableSortedSet<C> e0() {
                return RegularContiguousSet.this;
            }

            /* renamed from: i0 */
            public C get(int i2) {
                Preconditions.C(i2, size());
                RegularContiguousSet regularContiguousSet = RegularContiguousSet.this;
                return regularContiguousSet.a3.h(regularContiguousSet.first(), (long) i2);
            }
        } : super.H();
    }

    public boolean contains(@CheckForNull Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.b3.i((Comparable) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public boolean containsAll(Collection<?> collection) {
        return Collections2.b(this, collection);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RegularContiguousSet) {
            RegularContiguousSet regularContiguousSet = (RegularContiguousSet) obj;
            if (this.a3.equals(regularContiguousSet.a3)) {
                return first().equals(regularContiguousSet.first()) && last().equals(regularContiguousSet.last());
            }
        }
        return super.equals(obj);
    }

    public int hashCode() {
        return Sets.k(this);
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public int indexOf(@CheckForNull Object obj) {
        if (!contains(obj)) {
            return -1;
        }
        DiscreteDomain<C> discreteDomain = this.a3;
        Comparable y1 = first();
        Objects.requireNonNull(obj);
        return (int) discreteDomain.b(y1, (Comparable) obj);
    }

    public boolean isEmpty() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean j() {
        return false;
    }

    /* renamed from: k */
    public UnmodifiableIterator<C> iterator() {
        return new AbstractSequentialIterator<C>(first()) {
            final C X;

            {
                this.X = RegularContiguousSet.this.last();
            }

            /* access modifiers changed from: protected */
            @CheckForNull
            /* renamed from: b */
            public C a(C c2) {
                if (RegularContiguousSet.x1(c2, this.X)) {
                    return null;
                }
                return RegularContiguousSet.this.a3.g(c2);
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: m1 */
    public ContiguousSet<C> y0(C c2, boolean z) {
        return z1(Range.I(c2, BoundType.b(z)));
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    @J2ktIncompatible
    public Object n() {
        return new SerializedForm(this.b3, this.a3);
    }

    public ContiguousSet<C> n1(ContiguousSet<C> contiguousSet) {
        Preconditions.E(contiguousSet);
        Preconditions.d(this.a3.equals(contiguousSet.a3));
        if (contiguousSet.isEmpty()) {
            return contiguousSet;
        }
        Comparable comparable = (Comparable) Ordering.z().s(first(), (Comparable) contiguousSet.first());
        Comparable comparable2 = (Comparable) Ordering.z().w(last(), (Comparable) contiguousSet.last());
        return comparable.compareTo(comparable2) <= 0 ? ContiguousSet.f1(Range.f(comparable, comparable2), this.a3) : new EmptyContiguousSet(this.a3);
    }

    public Range<C> o1() {
        BoundType boundType = BoundType.CLOSED;
        return p1(boundType, boundType);
    }

    public Range<C> p1(BoundType boundType, BoundType boundType2) {
        return Range.k(this.b3.s.p(boundType, this.a3), this.b3.X.q(boundType2, this.a3));
    }

    @GwtIncompatible
    /* renamed from: q0 */
    public UnmodifiableIterator<C> descendingIterator() {
        return new AbstractSequentialIterator<C>(last()) {
            final C X;

            {
                this.X = RegularContiguousSet.this.first();
            }

            /* access modifiers changed from: protected */
            @CheckForNull
            /* renamed from: b */
            public C a(C c2) {
                if (RegularContiguousSet.x1(c2, this.X)) {
                    return null;
                }
                return RegularContiguousSet.this.a3.i(c2);
            }
        };
    }

    /* access modifiers changed from: package-private */
    /* renamed from: s1 */
    public ContiguousSet<C> P0(C c2, boolean z, C c4, boolean z2) {
        return (c2.compareTo(c4) != 0 || z || z2) ? z1(Range.B(c2, BoundType.b(z), c4, BoundType.b(z2))) : new EmptyContiguousSet(this.a3);
    }

    public int size() {
        long b2 = this.a3.b(first(), last());
        if (b2 >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return ((int) b2) + 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: v1 */
    public ContiguousSet<C> U0(C c2, boolean z) {
        return z1(Range.l(c2, BoundType.b(z)));
    }

    /* renamed from: y1 */
    public C first() {
        C m2 = this.b3.s.m(this.a3);
        Objects.requireNonNull(m2);
        return (Comparable) m2;
    }
}
