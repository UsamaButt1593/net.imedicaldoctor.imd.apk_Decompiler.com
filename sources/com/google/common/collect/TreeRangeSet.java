package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeMap;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public class TreeRangeSet<C extends Comparable<?>> extends AbstractRangeSet<C> implements Serializable {
    @CheckForNull
    @LazyInit
    private transient Set<Range<C>> X;
    @CheckForNull
    @LazyInit
    private transient Set<Range<C>> Y;
    @CheckForNull
    @LazyInit
    private transient RangeSet<C> Z;
    @VisibleForTesting
    final NavigableMap<Cut<C>, Range<C>> s;

    final class AsRanges extends ForwardingCollection<Range<C>> implements Set<Range<C>> {
        final Collection<Range<C>> s;

        AsRanges(TreeRangeSet treeRangeSet, Collection<Range<C>> collection) {
            this.s = collection;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a1 */
        public Collection<Range<C>> Z0() {
            return this.s;
        }

        public boolean equals(@CheckForNull Object obj) {
            return Sets.g(this, obj);
        }

        public int hashCode() {
            return Sets.k(this);
        }
    }

    private final class Complement extends TreeRangeSet<C> {
        Complement() {
            super(new ComplementRangesByLowerBound(TreeRangeSet.this.s));
        }

        public void a(Range<C> range) {
            TreeRangeSet.this.h(range);
        }

        public boolean b(C c2) {
            return !TreeRangeSet.this.b(c2);
        }

        public void h(Range<C> range) {
            TreeRangeSet.this.a(range);
        }

        public RangeSet<C> i() {
            return TreeRangeSet.this;
        }
    }

    private static final class ComplementRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
        private final NavigableMap<Cut<C>, Range<C>> X;
        /* access modifiers changed from: private */
        public final Range<Cut<C>> Y;
        private final NavigableMap<Cut<C>, Range<C>> s;

        ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this(navigableMap, Range.a());
        }

        private NavigableMap<Cut<C>, Range<C>> g(Range<Cut<C>> range) {
            if (!this.Y.t(range)) {
                return ImmutableSortedMap.y0();
            }
            return new ComplementRangesByLowerBound(this.s, range.s(this.Y));
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            NavigableMap<Cut<C>, Range<C>> navigableMap;
            Cut<C> cut;
            if (this.Y.q()) {
                navigableMap = this.X.tailMap(this.Y.y(), this.Y.x() == BoundType.CLOSED);
            } else {
                navigableMap = this.X;
            }
            PeekingIterator<T> T = Iterators.T(navigableMap.values().iterator());
            if (this.Y.i(Cut.c()) && (!T.hasNext() || ((Range) T.peek()).s != Cut.c())) {
                cut = Cut.c();
            } else if (!T.hasNext()) {
                return Iterators.u();
            } else {
                cut = ((Range) T.next()).X;
            }
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>(cut, T) {
                final /* synthetic */ PeekingIterator X2;
                Cut<C> Y;
                final /* synthetic */ Cut Z;

                {
                    this.Z = r2;
                    this.X2 = r3;
                    this.Y = r2;
                }

                /* access modifiers changed from: protected */
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<Cut<C>, Range<C>> a() {
                    Range<C> k2;
                    Cut<C> a2;
                    if (ComplementRangesByLowerBound.this.Y.X.l(this.Y) || this.Y == Cut.a()) {
                        return (Map.Entry) b();
                    }
                    if (this.X2.hasNext()) {
                        Range range = (Range) this.X2.next();
                        k2 = Range.k(this.Y, range.s);
                        a2 = range.X;
                    } else {
                        k2 = Range.k(this.Y, Cut.a());
                        a2 = Cut.a();
                    }
                    this.Y = a2;
                    return Maps.O(k2.s, k2);
                }
            };
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            Cut<C> cut;
            Cut<C> cut2;
            NavigableMap<Cut<C>, Range<C>> navigableMap;
            PeekingIterator<T> T = Iterators.T(this.X.headMap(this.Y.r() ? this.Y.L() : Cut.a(), this.Y.r() && this.Y.K() == BoundType.CLOSED).descendingMap().values().iterator());
            if (T.hasNext()) {
                if (((Range) T.peek()).X == Cut.a()) {
                    cut = ((Range) T.next()).s;
                    return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>((Cut) MoreObjects.a(cut, Cut.a()), T) {
                        final /* synthetic */ PeekingIterator X2;
                        Cut<C> Y;
                        final /* synthetic */ Cut Z;

                        {
                            this.Z = r2;
                            this.X2 = r3;
                            this.Y = r2;
                        }

                        /* access modifiers changed from: protected */
                        @CheckForNull
                        /* renamed from: d */
                        public Map.Entry<Cut<C>, Range<C>> a() {
                            if (this.Y == Cut.c()) {
                                return (Map.Entry) b();
                            }
                            if (this.X2.hasNext()) {
                                Range range = (Range) this.X2.next();
                                Range<C> k2 = Range.k(range.X, this.Y);
                                this.Y = range.s;
                                if (ComplementRangesByLowerBound.this.Y.s.l(k2.s)) {
                                    return Maps.O(k2.s, k2);
                                }
                            } else if (ComplementRangesByLowerBound.this.Y.s.l(Cut.c())) {
                                Range<C> k3 = Range.k(Cut.c(), this.Y);
                                this.Y = Cut.c();
                                return Maps.O(Cut.c(), k3);
                            }
                            return (Map.Entry) b();
                        }
                    };
                }
                navigableMap = this.s;
                cut2 = ((Range) T.peek()).X;
            } else if (!this.Y.i(Cut.c()) || this.s.containsKey(Cut.c())) {
                return Iterators.u();
            } else {
                navigableMap = this.s;
                cut2 = Cut.c();
            }
            cut = navigableMap.higherKey(cut2);
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>((Cut) MoreObjects.a(cut, Cut.a()), T) {
                final /* synthetic */ PeekingIterator X2;
                Cut<C> Y;
                final /* synthetic */ Cut Z;

                {
                    this.Z = r2;
                    this.X2 = r3;
                    this.Y = r2;
                }

                /* access modifiers changed from: protected */
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<Cut<C>, Range<C>> a() {
                    if (this.Y == Cut.c()) {
                        return (Map.Entry) b();
                    }
                    if (this.X2.hasNext()) {
                        Range range = (Range) this.X2.next();
                        Range<C> k2 = Range.k(range.X, this.Y);
                        this.Y = range.s;
                        if (ComplementRangesByLowerBound.this.Y.s.l(k2.s)) {
                            return Maps.O(k2.s, k2);
                        }
                    } else if (ComplementRangesByLowerBound.this.Y.s.l(Cut.c())) {
                        Range<C> k3 = Range.k(Cut.c(), this.Y);
                        this.Y = Cut.c();
                        return Maps.O(Cut.c(), k3);
                    }
                    return (Map.Entry) b();
                }
            };
        }

        public Comparator<? super Cut<C>> comparator() {
            return Ordering.z();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return get(obj) != null;
        }

        @CheckForNull
        /* renamed from: d */
        public Range<C> get(@CheckForNull Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut cut = (Cut) obj;
                    Map.Entry firstEntry = tailMap(cut, true).firstEntry();
                    if (firstEntry != null && ((Cut) firstEntry.getKey()).equals(cut)) {
                        return (Range) firstEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        /* renamed from: e */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return g(Range.I(cut, BoundType.b(z)));
        }

        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return g(Range.B(cut, BoundType.b(z), cut2, BoundType.b(z2)));
        }

        /* renamed from: h */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return g(Range.l(cut, BoundType.b(z)));
        }

        public int size() {
            return Iterators.Z(a());
        }

        private ComplementRangesByLowerBound(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.s = navigableMap;
            this.X = new RangesByUpperBound(navigableMap);
            this.Y = range;
        }
    }

    @VisibleForTesting
    static final class RangesByUpperBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
        /* access modifiers changed from: private */
        public final Range<Cut<C>> X;
        private final NavigableMap<Cut<C>, Range<C>> s;

        RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.s = navigableMap;
            this.X = Range.a();
        }

        private NavigableMap<Cut<C>, Range<C>> g(Range<Cut<C>> range) {
            return range.t(this.X) ? new RangesByUpperBound(this.s, range.s(this.X)) : ImmutableSortedMap.y0();
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            Map.Entry<Cut<C>, Range<C>> lowerEntry;
            final Iterator<Range<C>> it2 = ((this.X.q() && (lowerEntry = this.s.lowerEntry(this.X.y())) != null) ? this.X.s.l(lowerEntry.getValue().X) ? this.s.tailMap(lowerEntry.getKey(), true) : this.s.tailMap(this.X.y(), true) : this.s).values().iterator();
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>() {
                /* access modifiers changed from: protected */
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<Cut<C>, Range<C>> a() {
                    if (!it2.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) it2.next();
                    return RangesByUpperBound.this.X.X.l(range.X) ? (Map.Entry) b() : Maps.O(range.X, range);
                }
            };
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            final PeekingIterator<T> T = Iterators.T((this.X.r() ? this.s.headMap(this.X.L(), false) : this.s).descendingMap().values().iterator());
            if (T.hasNext() && this.X.X.l(((Range) T.peek()).X)) {
                T.next();
            }
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>() {
                /* access modifiers changed from: protected */
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<Cut<C>, Range<C>> a() {
                    if (!T.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) T.next();
                    return RangesByUpperBound.this.X.s.l(range.X) ? Maps.O(range.X, range) : (Map.Entry) b();
                }
            };
        }

        public Comparator<? super Cut<C>> comparator() {
            return Ordering.z();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return get(obj) != null;
        }

        @CheckForNull
        /* renamed from: d */
        public Range<C> get(@CheckForNull Object obj) {
            Map.Entry<Cut<C>, Range<C>> lowerEntry;
            if (obj instanceof Cut) {
                try {
                    Cut cut = (Cut) obj;
                    if (this.X.i(cut) && (lowerEntry = this.s.lowerEntry(cut)) != null && lowerEntry.getValue().X.equals(cut)) {
                        return lowerEntry.getValue();
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        /* renamed from: e */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return g(Range.I(cut, BoundType.b(z)));
        }

        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return g(Range.B(cut, BoundType.b(z), cut2, BoundType.b(z2)));
        }

        /* renamed from: h */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return g(Range.l(cut, BoundType.b(z)));
        }

        public boolean isEmpty() {
            return this.X.equals(Range.a()) ? this.s.isEmpty() : !a().hasNext();
        }

        public int size() {
            return this.X.equals(Range.a()) ? this.s.size() : Iterators.Z(a());
        }

        private RangesByUpperBound(NavigableMap<Cut<C>, Range<C>> navigableMap, Range<Cut<C>> range) {
            this.s = navigableMap;
            this.X = range;
        }
    }

    private final class SubRangeSet extends TreeRangeSet<C> {
        private final Range<C> X2;

        SubRangeSet(Range<C> range) {
            super(new SubRangeSetRangesByLowerBound(Range.a(), range, TreeRangeSet.this.s));
            this.X2 = range;
        }

        public void a(Range<C> range) {
            if (range.t(this.X2)) {
                TreeRangeSet.this.a(range.s(this.X2));
            }
        }

        public boolean b(C c2) {
            return this.X2.i(c2) && TreeRangeSet.this.b(c2);
        }

        public void clear() {
            TreeRangeSet.this.a(this.X2);
        }

        public void h(Range<C> range) {
            Preconditions.y(this.X2.n(range), "Cannot add range %s to subRangeSet(%s)", range, this.X2);
            TreeRangeSet.this.h(range);
        }

        @CheckForNull
        public Range<C> j(C c2) {
            Range j2;
            if (this.X2.i(c2) && (j2 = TreeRangeSet.this.j(c2)) != null) {
                return j2.s(this.X2);
            }
            return null;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
            r3 = com.google.common.collect.TreeRangeSet.r(r2.Y2, r3);
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean k(com.google.common.collect.Range<C> r3) {
            /*
                r2 = this;
                com.google.common.collect.Range<C> r0 = r2.X2
                boolean r0 = r0.u()
                r1 = 0
                if (r0 != 0) goto L_0x0026
                com.google.common.collect.Range<C> r0 = r2.X2
                boolean r0 = r0.n(r3)
                if (r0 == 0) goto L_0x0026
                com.google.common.collect.TreeRangeSet r0 = com.google.common.collect.TreeRangeSet.this
                com.google.common.collect.Range r3 = r0.v(r3)
                if (r3 == 0) goto L_0x0026
                com.google.common.collect.Range<C> r0 = r2.X2
                com.google.common.collect.Range r3 = r3.s(r0)
                boolean r3 = r3.u()
                if (r3 != 0) goto L_0x0026
                r1 = 1
            L_0x0026:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeRangeSet.SubRangeSet.k(com.google.common.collect.Range):boolean");
        }

        public RangeSet<C> m(Range<C> range) {
            if (range.n(this.X2)) {
                return this;
            }
            return range.t(this.X2) ? new SubRangeSet(this.X2.s(range)) : ImmutableRangeSet.E();
        }
    }

    private static final class SubRangeSetRangesByLowerBound<C extends Comparable<?>> extends AbstractNavigableMap<Cut<C>, Range<C>> {
        /* access modifiers changed from: private */
        public final Range<C> X;
        private final NavigableMap<Cut<C>, Range<C>> Y;
        private final NavigableMap<Cut<C>, Range<C>> Z;
        /* access modifiers changed from: private */
        public final Range<Cut<C>> s;

        private SubRangeSetRangesByLowerBound(Range<Cut<C>> range, Range<C> range2, NavigableMap<Cut<C>, Range<C>> navigableMap) {
            this.s = (Range) Preconditions.E(range);
            this.X = (Range) Preconditions.E(range2);
            this.Y = (NavigableMap) Preconditions.E(navigableMap);
            this.Z = new RangesByUpperBound(navigableMap);
        }

        private NavigableMap<Cut<C>, Range<C>> h(Range<Cut<C>> range) {
            return !range.t(this.s) ? ImmutableSortedMap.y0() : new SubRangeSetRangesByLowerBound(this.s.s(range), this.X, this.Y);
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<Cut<C>, Range<C>>> a() {
            NavigableMap<Cut<C>, Range<C>> navigableMap;
            Object obj;
            if (this.X.u()) {
                return Iterators.u();
            }
            if (this.s.X.l(this.X.s)) {
                return Iterators.u();
            }
            boolean z = false;
            if (this.s.s.l(this.X.s)) {
                navigableMap = this.Z;
                obj = this.X.s;
            } else {
                navigableMap = this.Y;
                obj = (Cut) this.s.s.j();
                if (this.s.x() == BoundType.CLOSED) {
                    z = true;
                }
            }
            final Iterator<Range<C>> it2 = navigableMap.tailMap(obj, z).values().iterator();
            final Cut cut = (Cut) Ordering.z().w(this.s.X, Cut.e(this.X.X));
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>() {
                /* access modifiers changed from: protected */
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<Cut<C>, Range<C>> a() {
                    if (!it2.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) it2.next();
                    if (cut.l(range.s)) {
                        return (Map.Entry) b();
                    }
                    Range s = range.s(SubRangeSetRangesByLowerBound.this.X);
                    return Maps.O(s.s, s);
                }
            };
        }

        /* access modifiers changed from: package-private */
        public Iterator<Map.Entry<Cut<C>, Range<C>>> b() {
            if (this.X.u()) {
                return Iterators.u();
            }
            Cut cut = (Cut) Ordering.z().w(this.s.X, Cut.e(this.X.X));
            final Iterator<Range<C>> it2 = this.Y.headMap((Cut) cut.j(), cut.o() == BoundType.CLOSED).descendingMap().values().iterator();
            return new AbstractIterator<Map.Entry<Cut<C>, Range<C>>>() {
                /* access modifiers changed from: protected */
                @CheckForNull
                /* renamed from: d */
                public Map.Entry<Cut<C>, Range<C>> a() {
                    if (!it2.hasNext()) {
                        return (Map.Entry) b();
                    }
                    Range range = (Range) it2.next();
                    if (SubRangeSetRangesByLowerBound.this.X.s.compareTo(range.X) >= 0) {
                        return (Map.Entry) b();
                    }
                    Range s = range.s(SubRangeSetRangesByLowerBound.this.X);
                    return SubRangeSetRangesByLowerBound.this.s.i(s.s) ? Maps.O(s.s, s) : (Map.Entry) b();
                }
            };
        }

        public Comparator<? super Cut<C>> comparator() {
            return Ordering.z();
        }

        public boolean containsKey(@CheckForNull Object obj) {
            return get(obj) != null;
        }

        @CheckForNull
        /* renamed from: e */
        public Range<C> get(@CheckForNull Object obj) {
            if (obj instanceof Cut) {
                try {
                    Cut cut = (Cut) obj;
                    if (this.s.i(cut) && cut.compareTo(this.X.s) >= 0) {
                        if (cut.compareTo(this.X.X) < 0) {
                            if (cut.equals(this.X.s)) {
                                Range range = (Range) Maps.Q0(this.Y.floorEntry(cut));
                                if (range != null && range.X.compareTo(this.X.s) > 0) {
                                    return range.s(this.X);
                                }
                            } else {
                                Range range2 = this.Y.get(cut);
                                if (range2 != null) {
                                    return range2.s(this.X);
                                }
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
            }
            return null;
        }

        /* renamed from: f */
        public NavigableMap<Cut<C>, Range<C>> headMap(Cut<C> cut, boolean z) {
            return h(Range.I(cut, BoundType.b(z)));
        }

        /* renamed from: g */
        public NavigableMap<Cut<C>, Range<C>> subMap(Cut<C> cut, boolean z, Cut<C> cut2, boolean z2) {
            return h(Range.B(cut, BoundType.b(z), cut2, BoundType.b(z2)));
        }

        /* renamed from: i */
        public NavigableMap<Cut<C>, Range<C>> tailMap(Cut<C> cut, boolean z) {
            return h(Range.l(cut, BoundType.b(z)));
        }

        public int size() {
            return Iterators.Z(a());
        }
    }

    private TreeRangeSet(NavigableMap<Cut<C>, Range<C>> navigableMap) {
        this.s = navigableMap;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> s() {
        return new TreeRangeSet<>(new TreeMap());
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> t(RangeSet<C> rangeSet) {
        TreeRangeSet<C> s2 = s();
        s2.e(rangeSet);
        return s2;
    }

    public static <C extends Comparable<?>> TreeRangeSet<C> u(Iterable<Range<C>> iterable) {
        TreeRangeSet<C> s2 = s();
        s2.d(iterable);
        return s2;
    }

    /* access modifiers changed from: private */
    @CheckForNull
    public Range<C> v(Range<C> range) {
        Preconditions.E(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.s.floorEntry(range.s);
        if (floorEntry == null || !floorEntry.getValue().n(range)) {
            return null;
        }
        return floorEntry.getValue();
    }

    private void w(Range<C> range) {
        if (range.u()) {
            this.s.remove(range.s);
        } else {
            this.s.put(range.s, range);
        }
    }

    public void a(Range<C> range) {
        Preconditions.E(range);
        if (!range.u()) {
            Map.Entry<Cut<C>, Range<C>> lowerEntry = this.s.lowerEntry(range.s);
            if (lowerEntry != null) {
                Range value = lowerEntry.getValue();
                if (value.X.compareTo(range.s) >= 0) {
                    if (range.r() && value.X.compareTo(range.X) >= 0) {
                        w(Range.k(range.X, value.X));
                    }
                    w(Range.k(value.s, range.s));
                }
            }
            Map.Entry<Cut<C>, Range<C>> floorEntry = this.s.floorEntry(range.X);
            if (floorEntry != null) {
                Range value2 = floorEntry.getValue();
                if (range.r() && value2.X.compareTo(range.X) >= 0) {
                    w(Range.k(range.X, value2.X));
                }
            }
            this.s.subMap(range.s, range.X).clear();
        }
    }

    public /* bridge */ /* synthetic */ boolean b(Comparable comparable) {
        return super.b(comparable);
    }

    public Range<C> c() {
        Map.Entry<Cut<C>, Range<C>> firstEntry = this.s.firstEntry();
        Map.Entry<Cut<C>, Range<C>> lastEntry = this.s.lastEntry();
        if (firstEntry != null && lastEntry != null) {
            return Range.k(firstEntry.getValue().s, lastEntry.getValue().X);
        }
        throw new NoSuchElementException();
    }

    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public /* bridge */ /* synthetic */ void d(Iterable iterable) {
        super.d(iterable);
    }

    public /* bridge */ /* synthetic */ void e(RangeSet rangeSet) {
        super.e(rangeSet);
    }

    public /* bridge */ /* synthetic */ boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    public /* bridge */ /* synthetic */ void f(Iterable iterable) {
        super.f(iterable);
    }

    public /* bridge */ /* synthetic */ boolean g(RangeSet rangeSet) {
        return super.g(rangeSet);
    }

    public void h(Range<C> range) {
        Preconditions.E(range);
        if (!range.u()) {
            Cut<C> cut = range.s;
            Cut<C> cut2 = range.X;
            Map.Entry<K, V> lowerEntry = this.s.lowerEntry(cut);
            if (lowerEntry != null) {
                Range range2 = (Range) lowerEntry.getValue();
                if (range2.X.compareTo(cut) >= 0) {
                    if (range2.X.compareTo(cut2) >= 0) {
                        cut2 = range2.X;
                    }
                    cut = range2.s;
                }
            }
            Map.Entry<K, V> floorEntry = this.s.floorEntry(cut2);
            if (floorEntry != null) {
                Range range3 = (Range) floorEntry.getValue();
                if (range3.X.compareTo(cut2) >= 0) {
                    cut2 = range3.X;
                }
            }
            this.s.subMap(cut, cut2).clear();
            w(Range.k(cut, cut2));
        }
    }

    public RangeSet<C> i() {
        RangeSet<C> rangeSet = this.Z;
        if (rangeSet != null) {
            return rangeSet;
        }
        Complement complement = new Complement();
        this.Z = complement;
        return complement;
    }

    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @CheckForNull
    public Range<C> j(C c2) {
        Preconditions.E(c2);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.s.floorEntry(Cut.e(c2));
        if (floorEntry == null || !floorEntry.getValue().i(c2)) {
            return null;
        }
        return floorEntry.getValue();
    }

    public boolean k(Range<C> range) {
        Preconditions.E(range);
        Map.Entry<Cut<C>, Range<C>> floorEntry = this.s.floorEntry(range.s);
        return floorEntry != null && floorEntry.getValue().n(range);
    }

    public /* bridge */ /* synthetic */ boolean l(Iterable iterable) {
        return super.l(iterable);
    }

    public RangeSet<C> m(Range<C> range) {
        return range.equals(Range.a()) ? this : new SubRangeSet(range);
    }

    public Set<Range<C>> n() {
        Set<Range<C>> set = this.Y;
        if (set != null) {
            return set;
        }
        AsRanges asRanges = new AsRanges(this, this.s.descendingMap().values());
        this.Y = asRanges;
        return asRanges;
    }

    public Set<Range<C>> o() {
        Set<Range<C>> set = this.X;
        if (set != null) {
            return set;
        }
        AsRanges asRanges = new AsRanges(this, this.s.values());
        this.X = asRanges;
        return asRanges;
    }

    public /* bridge */ /* synthetic */ void p(RangeSet rangeSet) {
        super.p(rangeSet);
    }

    public boolean q(Range<C> range) {
        Preconditions.E(range);
        Map.Entry<Cut<C>, Range<C>> ceilingEntry = this.s.ceilingEntry(range.s);
        if (ceilingEntry != null && ceilingEntry.getValue().t(range) && !ceilingEntry.getValue().s(range).u()) {
            return true;
        }
        Map.Entry<Cut<C>, Range<C>> lowerEntry = this.s.lowerEntry(range.s);
        return lowerEntry != null && lowerEntry.getValue().t(range) && !lowerEntry.getValue().s(range).u();
    }
}
