package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@Immutable(containerOf = {"C"})
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements Predicate<C>, Serializable {
    private static final Range<Comparable> Y = new Range<>(Cut.c(), Cut.a());
    private static final long Z = 0;
    final Cut<C> X;
    final Cut<C> s;

    /* renamed from: com.google.common.collect.Range$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22493a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.google.common.collect.BoundType[] r0 = com.google.common.collect.BoundType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22493a = r0
                com.google.common.collect.BoundType r1 = com.google.common.collect.BoundType.OPEN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22493a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.collect.BoundType r1 = com.google.common.collect.BoundType.CLOSED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Range.AnonymousClass1.<clinit>():void");
        }
    }

    static class LowerBoundFn implements Function<Range, Cut> {
        static final LowerBoundFn s = new LowerBoundFn();

        LowerBoundFn() {
        }

        /* renamed from: a */
        public Cut apply(Range range) {
            return range.s;
        }
    }

    private static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        static final Ordering<Range<?>> Y = new RangeLexOrdering();
        private static final long Z = 0;

        private RangeLexOrdering() {
        }

        /* renamed from: I */
        public int compare(Range<?> range, Range<?> range2) {
            return ComparisonChain.n().i(range.s, range2.s).i(range.X, range2.X).m();
        }
    }

    static class UpperBoundFn implements Function<Range, Cut> {
        static final UpperBoundFn s = new UpperBoundFn();

        UpperBoundFn() {
        }

        /* renamed from: a */
        public Cut apply(Range range) {
            return range.X;
        }
    }

    private Range(Cut<C> cut, Cut<C> cut2) {
        this.s = (Cut) Preconditions.E(cut);
        this.X = (Cut) Preconditions.E(cut2);
        if (cut.compareTo(cut2) > 0 || cut == Cut.a() || cut2 == Cut.c()) {
            throw new IllegalArgumentException("Invalid range: " + H(cut, cut2));
        }
    }

    public static <C extends Comparable<?>> Range<C> A(C c2, C c3) {
        return k(Cut.b(c2), Cut.b(c3));
    }

    public static <C extends Comparable<?>> Range<C> B(C c2, BoundType boundType, C c3, BoundType boundType2) {
        Preconditions.E(boundType);
        Preconditions.E(boundType2);
        BoundType boundType3 = BoundType.OPEN;
        return k(boundType == boundType3 ? Cut.b(c2) : Cut.e(c2), boundType2 == boundType3 ? Cut.e(c3) : Cut.b(c3));
    }

    static <C extends Comparable<?>> Ordering<Range<C>> C() {
        return RangeLexOrdering.Y;
    }

    public static <C extends Comparable<?>> Range<C> E(C c2) {
        return f(c2, c2);
    }

    private static String H(Cut<?> cut, Cut<?> cut2) {
        StringBuilder sb = new StringBuilder(16);
        cut.h(sb);
        sb.append("..");
        cut2.i(sb);
        return sb.toString();
    }

    public static <C extends Comparable<?>> Range<C> I(C c2, BoundType boundType) {
        int i2 = AnonymousClass1.f22493a[boundType.ordinal()];
        if (i2 == 1) {
            return v(c2);
        }
        if (i2 == 2) {
            return d(c2);
        }
        throw new AssertionError();
    }

    static <C extends Comparable<?>> Function<Range<C>, Cut<C>> J() {
        return UpperBoundFn.s;
    }

    public static <C extends Comparable<?>> Range<C> a() {
        return Y;
    }

    public static <C extends Comparable<?>> Range<C> c(C c2) {
        return k(Cut.e(c2), Cut.a());
    }

    public static <C extends Comparable<?>> Range<C> d(C c2) {
        return k(Cut.c(), Cut.b(c2));
    }

    public static <C extends Comparable<?>> Range<C> f(C c2, C c3) {
        return k(Cut.e(c2), Cut.b(c3));
    }

    public static <C extends Comparable<?>> Range<C> g(C c2, C c3) {
        return k(Cut.e(c2), Cut.e(c3));
    }

    static int h(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    static <C extends Comparable<?>> Range<C> k(Cut<C> cut, Cut<C> cut2) {
        return new Range<>(cut, cut2);
    }

    public static <C extends Comparable<?>> Range<C> l(C c2, BoundType boundType) {
        int i2 = AnonymousClass1.f22493a[boundType.ordinal()];
        if (i2 == 1) {
            return p(c2);
        }
        if (i2 == 2) {
            return c(c2);
        }
        throw new AssertionError();
    }

    public static <C extends Comparable<?>> Range<C> m(Iterable<C> iterable) {
        Preconditions.E(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (Ordering.z().equals(comparator) || comparator == null) {
                return f((Comparable) sortedSet.first(), (Comparable) sortedSet.last());
            }
        }
        Iterator<C> it2 = iterable.iterator();
        Comparable comparable = (Comparable) Preconditions.E((Comparable) it2.next());
        Comparable comparable2 = comparable;
        while (it2.hasNext()) {
            Comparable comparable3 = (Comparable) Preconditions.E((Comparable) it2.next());
            comparable = (Comparable) Ordering.z().w(comparable, comparable3);
            comparable2 = (Comparable) Ordering.z().s(comparable2, comparable3);
        }
        return f(comparable, comparable2);
    }

    public static <C extends Comparable<?>> Range<C> p(C c2) {
        return k(Cut.b(c2), Cut.a());
    }

    public static <C extends Comparable<?>> Range<C> v(C c2) {
        return k(Cut.c(), Cut.e(c2));
    }

    static <C extends Comparable<?>> Function<Range<C>, Cut<C>> w() {
        return LowerBoundFn.s;
    }

    public static <C extends Comparable<?>> Range<C> z(C c2, C c3) {
        return k(Cut.b(c2), Cut.e(c3));
    }

    /* access modifiers changed from: package-private */
    public Object D() {
        return equals(Y) ? a() : this;
    }

    public Range<C> F(Range<C> range) {
        int g2 = this.s.compareTo(range.s);
        int g3 = this.X.compareTo(range.X);
        if (g2 <= 0 && g3 >= 0) {
            return this;
        }
        if (g2 >= 0 && g3 <= 0) {
            return range;
        }
        return k(g2 <= 0 ? this.s : range.s, g3 >= 0 ? this.X : range.X);
    }

    public BoundType K() {
        return this.X.o();
    }

    public C L() {
        return this.X.j();
    }

    @Deprecated
    /* renamed from: b */
    public boolean apply(C c2) {
        return i(c2);
    }

    public Range<C> e(DiscreteDomain<C> discreteDomain) {
        Preconditions.E(discreteDomain);
        Cut<C> f2 = this.s.f(discreteDomain);
        Cut<C> f3 = this.X.f(discreteDomain);
        return (f2 == this.s && f3 == this.X) ? this : k(f2, f3);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.s.equals(range.s) && this.X.equals(range.X);
    }

    public int hashCode() {
        return (this.s.hashCode() * 31) + this.X.hashCode();
    }

    public boolean i(C c2) {
        Preconditions.E(c2);
        return this.s.l(c2) && !this.X.l(c2);
    }

    public boolean j(Iterable<? extends C> iterable) {
        if (Iterables.C(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (Ordering.z().equals(comparator) || comparator == null) {
                return i((Comparable) sortedSet.first()) && i((Comparable) sortedSet.last());
            }
        }
        Iterator<? extends C> it2 = iterable.iterator();
        while (it2.hasNext()) {
            if (!i((Comparable) it2.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean n(Range<C> range) {
        return this.s.compareTo(range.s) <= 0 && this.X.compareTo(range.X) >= 0;
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=com.google.common.collect.Range<C>, code=com.google.common.collect.Range, for r4v0, types: [com.google.common.collect.Range, com.google.common.collect.Range<C>, java.lang.Object] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.collect.Range<C> o(com.google.common.collect.Range r4) {
        /*
            r3 = this;
            com.google.common.collect.Cut<C> r0 = r3.s
            com.google.common.collect.Cut<C> r1 = r4.X
            int r0 = r0.compareTo(r1)
            if (r0 >= 0) goto L_0x0034
            com.google.common.collect.Cut<C> r0 = r4.s
            com.google.common.collect.Cut<C> r1 = r3.X
            int r0 = r0.compareTo(r1)
            if (r0 < 0) goto L_0x0015
            goto L_0x0034
        L_0x0015:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Ranges have a nonempty intersection: "
            r1.append(r2)
            r1.append(r3)
            java.lang.String r2 = ", "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x0034:
            com.google.common.collect.Cut<C> r0 = r3.s
            com.google.common.collect.Cut<C> r1 = r4.s
            int r0 = r0.compareTo(r1)
            if (r0 >= 0) goto L_0x0040
            r0 = 1
            goto L_0x0041
        L_0x0040:
            r0 = 0
        L_0x0041:
            if (r0 == 0) goto L_0x0045
            r1 = r3
            goto L_0x0046
        L_0x0045:
            r1 = r4
        L_0x0046:
            if (r0 == 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r4 = r3
        L_0x004a:
            com.google.common.collect.Cut<C> r0 = r1.X
            com.google.common.collect.Cut<C> r4 = r4.s
            com.google.common.collect.Range r4 = k(r0, r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Range.o(com.google.common.collect.Range):com.google.common.collect.Range");
    }

    public boolean q() {
        return this.s != Cut.c();
    }

    public boolean r() {
        return this.X != Cut.a();
    }

    public Range<C> s(Range<C> range) {
        int g2 = this.s.compareTo(range.s);
        int g3 = this.X.compareTo(range.X);
        if (g2 >= 0 && g3 <= 0) {
            return this;
        }
        if (g2 <= 0 && g3 >= 0) {
            return range;
        }
        Cut<C> cut = g2 >= 0 ? this.s : range.s;
        Cut<C> cut2 = g3 <= 0 ? this.X : range.X;
        Preconditions.y(cut.compareTo(cut2) <= 0, "intersection is undefined for disconnected ranges %s and %s", this, range);
        return k(cut, cut2);
    }

    public boolean t(Range<C> range) {
        return this.s.compareTo(range.X) <= 0 && range.s.compareTo(this.X) <= 0;
    }

    public String toString() {
        return H(this.s, this.X);
    }

    public boolean u() {
        return this.s.equals(this.X);
    }

    public BoundType x() {
        return this.s.n();
    }

    public C y() {
        return this.s.j();
    }
}
