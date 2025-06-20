package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public final class ImmutableRangeSet<C extends Comparable> extends AbstractRangeSet<C> implements Serializable {
    private static final ImmutableRangeSet<Comparable<?>> Y = new ImmutableRangeSet<>(ImmutableList.I());
    private static final ImmutableRangeSet<Comparable<?>> Z = new ImmutableRangeSet<>(ImmutableList.K(Range.a()));
    @CheckForNull
    @LazyInit
    private transient ImmutableRangeSet<C> X;
    /* access modifiers changed from: private */
    public final transient ImmutableList<Range<C>> s;

    private final class AsSet extends ImmutableSortedSet<C> {
        /* access modifiers changed from: private */
        public final DiscreteDomain<C> a3;
        @CheckForNull
        @LazyInit
        private transient Integer b3;

        AsSet(DiscreteDomain<C> discreteDomain) {
            super(Ordering.z());
            this.a3 = discreteDomain;
        }

        @J2ktIncompatible
        private void m(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use SerializedForm");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: Z0 */
        public ImmutableSortedSet<C> y0(C c2, boolean z) {
            return a1(Range.I(c2, BoundType.b(z)));
        }

        /* access modifiers changed from: package-private */
        public ImmutableSortedSet<C> a1(Range<C> range) {
            return ImmutableRangeSet.this.m(range).v(this.a3);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b1 */
        public ImmutableSortedSet<C> P0(C c2, boolean z, C c4, boolean z2) {
            return (z || z2 || Range.h(c2, c4) != 0) ? a1(Range.B(c2, BoundType.b(z), c4, BoundType.b(z2))) : ImmutableSortedSet.A0();
        }

        public boolean contains(@CheckForNull Object obj) {
            if (obj == null) {
                return false;
            }
            try {
                return ImmutableRangeSet.this.b((Comparable) obj);
            } catch (ClassCastException unused) {
                return false;
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: f1 */
        public ImmutableSortedSet<C> U0(C c2, boolean z) {
            return a1(Range.l(c2, BoundType.b(z)));
        }

        /* access modifiers changed from: package-private */
        public int indexOf(@CheckForNull Object obj) {
            if (!contains(obj)) {
                return -1;
            }
            Objects.requireNonNull(obj);
            Comparable comparable = (Comparable) obj;
            UnmodifiableIterator k2 = ImmutableRangeSet.this.s.iterator();
            long j2 = 0;
            while (k2.hasNext()) {
                Range range = (Range) k2.next();
                if (range.i(comparable)) {
                    return Ints.z(j2 + ((long) ContiguousSet.f1(range, this.a3).indexOf(comparable)));
                }
                j2 += (long) ContiguousSet.f1(range, this.a3).size();
            }
            throw new AssertionError("impossible");
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return ImmutableRangeSet.this.s.j();
        }

        /* renamed from: k */
        public UnmodifiableIterator<C> iterator() {
            return new AbstractIterator<C>() {
                final Iterator<Range<C>> Y;
                Iterator<C> Z = Iterators.u();

                {
                    this.Y = ImmutableRangeSet.this.s.iterator();
                }

                /* access modifiers changed from: protected */
                @CheckForNull
                /* renamed from: d */
                public C a() {
                    C next;
                    while (true) {
                        if (!this.Z.hasNext()) {
                            if (!this.Y.hasNext()) {
                                next = b();
                                break;
                            }
                            this.Z = ContiguousSet.f1(this.Y.next(), AsSet.this.a3).iterator();
                        } else {
                            next = this.Z.next();
                            break;
                        }
                    }
                    return (Comparable) next;
                }
            };
        }

        /* access modifiers changed from: package-private */
        @J2ktIncompatible
        public Object n() {
            return new AsSetSerializedForm(ImmutableRangeSet.this.s, this.a3);
        }

        /* access modifiers changed from: package-private */
        public ImmutableSortedSet<C> p0() {
            return new DescendingImmutableSortedSet(this);
        }

        @GwtIncompatible("NavigableSet")
        /* renamed from: q0 */
        public UnmodifiableIterator<C> descendingIterator() {
            return new AbstractIterator<C>() {
                final Iterator<Range<C>> Y;
                Iterator<C> Z = Iterators.u();

                {
                    this.Y = ImmutableRangeSet.this.s.Y().iterator();
                }

                /* access modifiers changed from: protected */
                @CheckForNull
                /* renamed from: d */
                public C a() {
                    C next;
                    while (true) {
                        if (!this.Z.hasNext()) {
                            if (!this.Y.hasNext()) {
                                next = b();
                                break;
                            }
                            this.Z = ContiguousSet.f1(this.Y.next(), AsSet.this.a3).descendingIterator();
                        } else {
                            next = this.Z.next();
                            break;
                        }
                    }
                    return (Comparable) next;
                }
            };
        }

        public int size() {
            Integer num = this.b3;
            if (num == null) {
                UnmodifiableIterator k2 = ImmutableRangeSet.this.s.iterator();
                long j2 = 0;
                while (k2.hasNext()) {
                    j2 += (long) ContiguousSet.f1((Range) k2.next(), this.a3).size();
                    if (j2 >= 2147483647L) {
                        break;
                    }
                }
                num = Integer.valueOf(Ints.z(j2));
                this.b3 = num;
            }
            return num.intValue();
        }

        public String toString() {
            return ImmutableRangeSet.this.s.toString();
        }
    }

    private static class AsSetSerializedForm<C extends Comparable> implements Serializable {
        private final DiscreteDomain<C> X;
        private final ImmutableList<Range<C>> s;

        AsSetSerializedForm(ImmutableList<Range<C>> immutableList, DiscreteDomain<C> discreteDomain) {
            this.s = immutableList;
            this.X = discreteDomain;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return new ImmutableRangeSet(this.s).v(this.X);
        }
    }

    public static class Builder<C extends Comparable<?>> {

        /* renamed from: a  reason: collision with root package name */
        private final List<Range<C>> f22407a = Lists.q();

        @CanIgnoreReturnValue
        public Builder<C> a(Range<C> range) {
            Preconditions.u(!range.u(), "range must not be empty, but was %s", range);
            this.f22407a.add(range);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<C> b(RangeSet<C> rangeSet) {
            return c(rangeSet.o());
        }

        @CanIgnoreReturnValue
        public Builder<C> c(Iterable<Range<C>> iterable) {
            for (Range<C> a2 : iterable) {
                a(a2);
            }
            return this;
        }

        public ImmutableRangeSet<C> d() {
            ImmutableList.Builder builder = new ImmutableList.Builder(this.f22407a.size());
            Collections.sort(this.f22407a, Range.C());
            PeekingIterator<T> T = Iterators.T(this.f22407a.iterator());
            while (T.hasNext()) {
                Range range = (Range) T.next();
                while (T.hasNext()) {
                    Range range2 = (Range) T.peek();
                    if (!range.t(range2)) {
                        break;
                    }
                    Preconditions.y(range.s(range2).u(), "Overlapping ranges not permitted but found %s overlapping %s", range, range2);
                    range = range.F((Range) T.next());
                }
                builder.g(range);
            }
            ImmutableList n2 = builder.e();
            if (n2.isEmpty()) {
                return ImmutableRangeSet.E();
            }
            return (n2.size() != 1 || !((Range) Iterables.z(n2)).equals(Range.a())) ? new ImmutableRangeSet<>(n2) : ImmutableRangeSet.s();
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public Builder<C> e(Builder<C> builder) {
            c(builder.f22407a);
            return this;
        }
    }

    private final class ComplementRanges extends ImmutableList<Range<C>> {
        private final int X2;
        private final boolean Y;
        private final boolean Z;

        ComplementRanges() {
            boolean q = ((Range) ImmutableRangeSet.this.s.get(0)).q();
            this.Y = q;
            boolean r = ((Range) Iterables.w(ImmutableRangeSet.this.s)).r();
            this.Z = r;
            int size = ImmutableRangeSet.this.s.size();
            size = !q ? size - 1 : size;
            this.X2 = r ? size + 1 : size;
        }

        /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
        /* renamed from: e0 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.common.collect.Range<C> get(int r4) {
            /*
                r3 = this;
                int r0 = r3.X2
                com.google.common.base.Preconditions.C(r4, r0)
                boolean r0 = r3.Y
                if (r0 == 0) goto L_0x001d
                if (r4 != 0) goto L_0x0010
                com.google.common.collect.Cut r0 = com.google.common.collect.Cut.c()
                goto L_0x002b
            L_0x0010:
                com.google.common.collect.ImmutableRangeSet r0 = com.google.common.collect.ImmutableRangeSet.this
                com.google.common.collect.ImmutableList r0 = r0.s
                int r1 = r4 + -1
                java.lang.Object r0 = r0.get(r1)
                goto L_0x0027
            L_0x001d:
                com.google.common.collect.ImmutableRangeSet r0 = com.google.common.collect.ImmutableRangeSet.this
                com.google.common.collect.ImmutableList r0 = r0.s
                java.lang.Object r0 = r0.get(r4)
            L_0x0027:
                com.google.common.collect.Range r0 = (com.google.common.collect.Range) r0
                com.google.common.collect.Cut<C> r0 = r0.X
            L_0x002b:
                boolean r1 = r3.Z
                if (r1 == 0) goto L_0x003a
                int r1 = r3.X2
                int r1 = r1 + -1
                if (r4 != r1) goto L_0x003a
                com.google.common.collect.Cut r4 = com.google.common.collect.Cut.a()
                goto L_0x004d
            L_0x003a:
                com.google.common.collect.ImmutableRangeSet r1 = com.google.common.collect.ImmutableRangeSet.this
                com.google.common.collect.ImmutableList r1 = r1.s
                boolean r2 = r3.Y
                r2 = r2 ^ 1
                int r4 = r4 + r2
                java.lang.Object r4 = r1.get(r4)
                com.google.common.collect.Range r4 = (com.google.common.collect.Range) r4
                com.google.common.collect.Cut<C> r4 = r4.s
            L_0x004d:
                com.google.common.collect.Range r4 = com.google.common.collect.Range.k(r0, r4)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.ImmutableRangeSet.ComplementRanges.get(int):com.google.common.collect.Range");
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return true;
        }

        public int size() {
            return this.X2;
        }
    }

    private static final class SerializedForm<C extends Comparable> implements Serializable {
        private final ImmutableList<Range<C>> s;

        SerializedForm(ImmutableList<Range<C>> immutableList) {
            this.s = immutableList;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            if (this.s.isEmpty()) {
                return ImmutableRangeSet.E();
            }
            return this.s.equals(ImmutableList.K(Range.a())) ? ImmutableRangeSet.s() : new ImmutableRangeSet(this.s);
        }
    }

    ImmutableRangeSet(ImmutableList<Range<C>> immutableList) {
        this.s = immutableList;
    }

    private ImmutableList<Range<C>> B(final Range<C> range) {
        if (this.s.isEmpty() || range.u()) {
            return ImmutableList.I();
        }
        if (range.n(c())) {
            return this.s;
        }
        final int a2 = range.q() ? SortedLists.a(this.s, Range.J(), range.s, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : 0;
        final int a3 = (range.r() ? SortedLists.a(this.s, Range.w(), range.X, SortedLists.KeyPresentBehavior.FIRST_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER) : this.s.size()) - a2;
        return a3 == 0 ? ImmutableList.I() : new ImmutableList<Range<C>>() {
            /* renamed from: e0 */
            public Range<C> get(int i2) {
                Preconditions.C(i2, a3);
                return (i2 == 0 || i2 == a3 + -1) ? ((Range) ImmutableRangeSet.this.s.get(i2 + a2)).s(range) : (Range) ImmutableRangeSet.this.s.get(i2 + a2);
            }

            /* access modifiers changed from: package-private */
            public boolean j() {
                return true;
            }

            public int size() {
                return a3;
            }
        };
    }

    public static <C extends Comparable> ImmutableRangeSet<C> E() {
        return Y;
    }

    public static <C extends Comparable> ImmutableRangeSet<C> F(Range<C> range) {
        Preconditions.E(range);
        if (range.u()) {
            return E();
        }
        return range.equals(Range.a()) ? s() : new ImmutableRangeSet<>(ImmutableList.K(range));
    }

    @J2ktIncompatible
    private void H(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> K(Iterable<Range<C>> iterable) {
        return y(TreeRangeSet.u(iterable));
    }

    static <C extends Comparable> ImmutableRangeSet<C> s() {
        return Z;
    }

    public static <C extends Comparable<?>> Builder<C> w() {
        return new Builder<>();
    }

    public static <C extends Comparable> ImmutableRangeSet<C> y(RangeSet<C> rangeSet) {
        Preconditions.E(rangeSet);
        if (rangeSet.isEmpty()) {
            return E();
        }
        if (rangeSet.k(Range.a())) {
            return s();
        }
        if (rangeSet instanceof ImmutableRangeSet) {
            ImmutableRangeSet<C> immutableRangeSet = (ImmutableRangeSet) rangeSet;
            if (!immutableRangeSet.D()) {
                return immutableRangeSet;
            }
        }
        return new ImmutableRangeSet<>(ImmutableList.B(rangeSet.o()));
    }

    public static <C extends Comparable<?>> ImmutableRangeSet<C> z(Iterable<Range<C>> iterable) {
        return new Builder().c(iterable).d();
    }

    public ImmutableRangeSet<C> A(RangeSet<C> rangeSet) {
        TreeRangeSet t = TreeRangeSet.t(this);
        t.p(rangeSet);
        return y(t);
    }

    public ImmutableRangeSet<C> C(RangeSet<C> rangeSet) {
        TreeRangeSet t = TreeRangeSet.t(this);
        t.p(rangeSet.i());
        return y(t);
    }

    /* access modifiers changed from: package-private */
    public boolean D() {
        return this.s.j();
    }

    /* renamed from: I */
    public ImmutableRangeSet<C> m(Range<C> range) {
        if (!isEmpty()) {
            Range c2 = c();
            if (range.n(c2)) {
                return this;
            }
            if (range.t(c2)) {
                return new ImmutableRangeSet<>(B(range));
            }
        }
        return E();
    }

    public ImmutableRangeSet<C> J(RangeSet<C> rangeSet) {
        return K(Iterables.f(o(), rangeSet.o()));
    }

    /* access modifiers changed from: package-private */
    @J2ktIncompatible
    public Object L() {
        return new SerializedForm(this.s);
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void a(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public /* bridge */ /* synthetic */ boolean b(Comparable comparable) {
        return super.b(comparable);
    }

    public Range<C> c() {
        if (!this.s.isEmpty()) {
            Cut<C> cut = this.s.get(0).s;
            ImmutableList<Range<C>> immutableList = this.s;
            return Range.k(cut, immutableList.get(immutableList.size() - 1).X);
        }
        throw new NoSuchElementException();
    }

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void d(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void e(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void f(Iterable<Range<C>> iterable) {
        throw new UnsupportedOperationException();
    }

    public /* bridge */ /* synthetic */ boolean g(RangeSet rangeSet) {
        return super.g(rangeSet);
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void h(Range<C> range) {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return this.s.isEmpty();
    }

    @CheckForNull
    public Range<C> j(C c2) {
        int b2 = SortedLists.b(this.s, Range.w(), Cut.e(c2), Ordering.z(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (b2 == -1) {
            return null;
        }
        Range<C> range = this.s.get(b2);
        if (range.i(c2)) {
            return range;
        }
        return null;
    }

    public boolean k(Range<C> range) {
        int b2 = SortedLists.b(this.s, Range.w(), range.s, Ordering.z(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        return b2 != -1 && this.s.get(b2).n(range);
    }

    public /* bridge */ /* synthetic */ boolean l(Iterable iterable) {
        return super.l(iterable);
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public void p(RangeSet<C> rangeSet) {
        throw new UnsupportedOperationException();
    }

    public boolean q(Range<C> range) {
        int b2 = SortedLists.b(this.s, Range.w(), range.s, Ordering.z(), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (b2 < this.s.size() && this.s.get(b2).t(range) && !this.s.get(b2).s(range).u()) {
            return true;
        }
        if (b2 > 0) {
            int i2 = b2 - 1;
            return this.s.get(i2).t(range) && !this.s.get(i2).s(range).u();
        }
    }

    /* renamed from: t */
    public ImmutableSet<Range<C>> n() {
        return this.s.isEmpty() ? ImmutableSet.K() : new RegularImmutableSortedSet(this.s.Y(), Range.C().E());
    }

    /* renamed from: u */
    public ImmutableSet<Range<C>> o() {
        return this.s.isEmpty() ? ImmutableSet.K() : new RegularImmutableSortedSet(this.s, Range.C());
    }

    public ImmutableSortedSet<C> v(DiscreteDomain<C> discreteDomain) {
        Preconditions.E(discreteDomain);
        if (isEmpty()) {
            return ImmutableSortedSet.A0();
        }
        Range<C> e2 = c().e(discreteDomain);
        if (e2.q()) {
            if (!e2.r()) {
                try {
                    discreteDomain.e();
                } catch (NoSuchElementException unused) {
                    throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded above");
                }
            }
            return new AsSet(discreteDomain);
        }
        throw new IllegalArgumentException("Neither the DiscreteDomain nor this range set are bounded below");
    }

    /* renamed from: x */
    public ImmutableRangeSet<C> i() {
        ImmutableRangeSet<C> E;
        ImmutableRangeSet<C> immutableRangeSet = this.X;
        if (immutableRangeSet != null) {
            return immutableRangeSet;
        }
        if (this.s.isEmpty()) {
            E = s();
        } else if (this.s.size() != 1 || !this.s.get(0).equals(Range.a())) {
            ImmutableRangeSet<C> immutableRangeSet2 = new ImmutableRangeSet<>(new ComplementRanges(), this);
            this.X = immutableRangeSet2;
            return immutableRangeSet2;
        } else {
            E = E();
        }
        this.X = E;
        return E;
    }

    private ImmutableRangeSet(ImmutableList<Range<C>> immutableList, ImmutableRangeSet<C> immutableRangeSet) {
        this.s = immutableList;
        this.X = immutableRangeSet;
    }
}
