package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.DoNotMock;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V>, Serializable {
    private static final ImmutableRangeMap<Comparable<?>, Object> Y = new ImmutableRangeMap<>(ImmutableList.I(), ImmutableList.I());
    private static final long Z = 0;
    private final transient ImmutableList<V> X;
    /* access modifiers changed from: private */
    public final transient ImmutableList<Range<K>> s;

    @DoNotMock
    public static final class Builder<K extends Comparable<?>, V> {

        /* renamed from: a  reason: collision with root package name */
        private final List<Map.Entry<Range<K>, V>> f22406a = Lists.q();

        public ImmutableRangeMap<K, V> a() {
            Collections.sort(this.f22406a, Range.C().C());
            ImmutableList.Builder builder = new ImmutableList.Builder(this.f22406a.size());
            ImmutableList.Builder builder2 = new ImmutableList.Builder(this.f22406a.size());
            for (int i2 = 0; i2 < this.f22406a.size(); i2++) {
                Range range = (Range) this.f22406a.get(i2).getKey();
                if (i2 > 0) {
                    Range range2 = (Range) this.f22406a.get(i2 - 1).getKey();
                    if (range.t(range2) && !range.s(range2).u()) {
                        throw new IllegalArgumentException("Overlapping ranges: range " + range2 + " overlaps with entry " + range);
                    }
                }
                builder.g(range);
                builder2.g(this.f22406a.get(i2).getValue());
            }
            return new ImmutableRangeMap<>(builder.e(), builder2.e());
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public Builder<K, V> b(Builder<K, V> builder) {
            this.f22406a.addAll(builder.f22406a);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> c(Range<K> range, V v) {
            Preconditions.E(range);
            Preconditions.E(v);
            Preconditions.u(!range.u(), "Range must not be empty, but was %s", range);
            this.f22406a.add(Maps.O(range, v));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<K, V> d(RangeMap<K, ? extends V> rangeMap) {
            for (Map.Entry next : rangeMap.g().entrySet()) {
                c((Range) next.getKey(), next.getValue());
            }
            return this;
        }
    }

    private static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        private static final long X = 0;
        private final ImmutableMap<Range<K>, V> s;

        SerializedForm(ImmutableMap<Range<K>, V> immutableMap) {
            this.s = immutableMap;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            Builder builder = new Builder();
            UnmodifiableIterator<Map.Entry<Range<K>, V>> k2 = this.s.entrySet().iterator();
            while (k2.hasNext()) {
                Map.Entry next = k2.next();
                builder.c((Range) next.getKey(), next.getValue());
            }
            return builder.a();
        }

        /* access modifiers changed from: package-private */
        public Object b() {
            return this.s.isEmpty() ? ImmutableRangeMap.p() : a();
        }
    }

    ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.s = immutableList;
        this.X = immutableList2;
    }

    public static <K extends Comparable<?>, V> Builder<K, V> n() {
        return new Builder<>();
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> o(RangeMap<K, ? extends V> rangeMap) {
        if (rangeMap instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) rangeMap;
        }
        Map<Range<K>, ? extends V> g2 = rangeMap.g();
        ImmutableList.Builder builder = new ImmutableList.Builder(g2.size());
        ImmutableList.Builder builder2 = new ImmutableList.Builder(g2.size());
        for (Map.Entry next : g2.entrySet()) {
            builder.g((Range) next.getKey());
            builder2.g(next.getValue());
        }
        return new ImmutableRangeMap<>(builder.e(), builder2.e());
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> p() {
        return Y;
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> q(Range<K> range, V v) {
        return new ImmutableRangeMap<>(ImmutableList.K(range), ImmutableList.K(v));
    }

    @J2ktIncompatible
    private void r(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void a(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    public Range<K> c() {
        if (!this.s.isEmpty()) {
            ImmutableList<Range<K>> immutableList = this.s;
            return Range.k(this.s.get(0).s, immutableList.get(immutableList.size() - 1).X);
        }
        throw new NoSuchElementException();
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @CheckForNull
    public Map.Entry<Range<K>, V> d(K k2) {
        int a2 = SortedLists.a(this.s, Range.w(), Cut.e(k2), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a2 == -1) {
            return null;
        }
        Range range = this.s.get(a2);
        if (range.i(k2)) {
            return Maps.O(range, this.X.get(a2));
        }
        return null;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof RangeMap) {
            return g().equals(((RangeMap) obj).g());
        }
        return false;
    }

    @CheckForNull
    public V h(K k2) {
        int a2 = SortedLists.a(this.s, Range.w(), Cut.e(k2), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (a2 != -1 && this.s.get(a2).i(k2)) {
            return this.X.get(a2);
        }
        return null;
    }

    public int hashCode() {
        return g().hashCode();
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void i(RangeMap<K, ? extends V> rangeMap) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void j(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void k(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: l */
    public ImmutableMap<Range<K>, V> f() {
        return this.s.isEmpty() ? ImmutableMap.s() : new ImmutableSortedMap(new RegularImmutableSortedSet(this.s.Y(), Range.C().E()), this.X.Y());
    }

    /* renamed from: m */
    public ImmutableMap<Range<K>, V> g() {
        return this.s.isEmpty() ? ImmutableMap.s() : new ImmutableSortedMap(new RegularImmutableSortedSet(this.s, Range.C()), this.X);
    }

    /* renamed from: s */
    public ImmutableRangeMap<K, V> e(final Range<K> range) {
        if (((Range) Preconditions.E(range)).u()) {
            return p();
        }
        if (this.s.isEmpty() || range.n(c())) {
            return this;
        }
        ImmutableList<Range<K>> immutableList = this.s;
        Function J = Range.J();
        Cut<C> cut = range.s;
        SortedLists.KeyPresentBehavior keyPresentBehavior = SortedLists.KeyPresentBehavior.FIRST_AFTER;
        SortedLists.KeyAbsentBehavior keyAbsentBehavior = SortedLists.KeyAbsentBehavior.NEXT_HIGHER;
        final int a2 = SortedLists.a(immutableList, J, cut, keyPresentBehavior, keyAbsentBehavior);
        int a3 = SortedLists.a(this.s, Range.w(), range.X, SortedLists.KeyPresentBehavior.ANY_PRESENT, keyAbsentBehavior);
        if (a2 >= a3) {
            return p();
        }
        final int i2 = a3 - a2;
        final Range<K> range2 = range;
        return new ImmutableRangeMap<K, V>(this, new ImmutableList<Range<K>>() {
            /* renamed from: e0 */
            public Range<K> get(int i2) {
                Preconditions.C(i2, i2);
                return (i2 == 0 || i2 == i2 + -1) ? ((Range) ImmutableRangeMap.this.s.get(i2 + a2)).s(range) : (Range) ImmutableRangeMap.this.s.get(i2 + a2);
            }

            /* access modifiers changed from: package-private */
            public boolean j() {
                return true;
            }

            public int size() {
                return i2;
            }
        }, this.X.subList(a2, a3)) {
            public /* bridge */ /* synthetic */ Map f() {
                return ImmutableRangeMap.super.f();
            }

            public /* bridge */ /* synthetic */ Map g() {
                return ImmutableRangeMap.super.g();
            }

            /* renamed from: s */
            public ImmutableRangeMap<K, V> e(Range<K> range) {
                return range2.t(range) ? this.e(range.s(range2)) : ImmutableRangeMap.p();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Object t() {
        return new SerializedForm(g());
    }

    public String toString() {
        return g().toString();
    }
}
