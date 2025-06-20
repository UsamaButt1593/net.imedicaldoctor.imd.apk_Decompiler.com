package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements SortedMultiset<E> {
    @CheckForNull
    @LazyInit
    transient ImmutableSortedMultiset<E> Z;

    public static class Builder<E> extends ImmutableMultiset.Builder<E> {

        /* renamed from: e  reason: collision with root package name */
        private final Comparator<? super E> f22414e;
        @VisibleForTesting

        /* renamed from: f  reason: collision with root package name */
        E[] f22415f = new Object[4];

        /* renamed from: g  reason: collision with root package name */
        private int[] f22416g = new int[4];

        /* renamed from: h  reason: collision with root package name */
        private int f22417h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f22418i;

        public Builder(Comparator<? super E> comparator) {
            super(true);
            this.f22414e = (Comparator) Preconditions.E(comparator);
        }

        private void u(boolean z) {
            int i2 = this.f22417h;
            if (i2 != 0) {
                E[] copyOf = Arrays.copyOf(this.f22415f, i2);
                Arrays.sort(copyOf, this.f22414e);
                int i3 = 1;
                for (int i4 = 1; i4 < copyOf.length; i4++) {
                    if (this.f22414e.compare(copyOf[i3 - 1], copyOf[i4]) < 0) {
                        copyOf[i3] = copyOf[i4];
                        i3++;
                    }
                }
                Arrays.fill(copyOf, i3, this.f22417h, (Object) null);
                if (z) {
                    int i5 = i3 * 4;
                    int i6 = this.f22417h;
                    if (i5 > i6 * 3) {
                        copyOf = Arrays.copyOf(copyOf, IntMath.t(i6, (i6 / 2) + 1));
                    }
                }
                int[] iArr = new int[copyOf.length];
                for (int i7 = 0; i7 < this.f22417h; i7++) {
                    int binarySearch = Arrays.binarySearch(copyOf, 0, i3, this.f22415f[i7], this.f22414e);
                    int i8 = this.f22416g[i7];
                    if (i8 >= 0) {
                        iArr[binarySearch] = iArr[binarySearch] + i8;
                    } else {
                        iArr[binarySearch] = ~i8;
                    }
                }
                this.f22415f = copyOf;
                this.f22416g = iArr;
                this.f22417h = i3;
            }
        }

        private void v() {
            u(false);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                int i4 = this.f22417h;
                if (i2 < i4) {
                    int[] iArr = this.f22416g;
                    int i5 = iArr[i2];
                    if (i5 > 0) {
                        E[] eArr = this.f22415f;
                        eArr[i3] = eArr[i2];
                        iArr[i3] = i5;
                        i3++;
                    }
                    i2++;
                } else {
                    Arrays.fill(this.f22415f, i3, i4, (Object) null);
                    Arrays.fill(this.f22416g, i3, this.f22417h, 0);
                    this.f22417h = i3;
                    return;
                }
            }
        }

        private void w() {
            int i2 = this.f22417h;
            E[] eArr = this.f22415f;
            if (i2 == eArr.length) {
                u(true);
            } else if (this.f22418i) {
                this.f22415f = Arrays.copyOf(eArr, eArr.length);
            }
            this.f22418i = false;
        }

        @CanIgnoreReturnValue
        /* renamed from: o */
        public Builder<E> g(E e2) {
            return k(e2, 1);
        }

        @CanIgnoreReturnValue
        /* renamed from: p */
        public Builder<E> h(E... eArr) {
            for (E o : eArr) {
                g(o);
            }
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: q */
        public Builder<E> i(Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                for (Multiset.Entry entry : ((Multiset) iterable).entrySet()) {
                    k(entry.a(), entry.getCount());
                }
            } else {
                for (Object o : iterable) {
                    g(o);
                }
            }
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: r */
        public Builder<E> j(Iterator<? extends E> it2) {
            while (it2.hasNext()) {
                g(it2.next());
            }
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: s */
        public Builder<E> k(E e2, int i2) {
            Preconditions.E(e2);
            CollectPreconditions.b(i2, "occurrences");
            if (i2 == 0) {
                return this;
            }
            w();
            E[] eArr = this.f22415f;
            int i3 = this.f22417h;
            eArr[i3] = e2;
            this.f22416g[i3] = i2;
            this.f22417h = i3 + 1;
            return this;
        }

        /* renamed from: t */
        public ImmutableSortedMultiset<E> l() {
            v();
            int i2 = this.f22417h;
            if (i2 == 0) {
                return ImmutableSortedMultiset.l0(this.f22414e);
            }
            RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet) ImmutableSortedSet.e0(this.f22414e, i2, this.f22415f);
            long[] jArr = new long[(this.f22417h + 1)];
            int i3 = 0;
            while (i3 < this.f22417h) {
                int i4 = i3 + 1;
                jArr[i4] = jArr[i3] + ((long) this.f22416g[i3]);
                i3 = i4;
            }
            this.f22418i = true;
            return new RegularImmutableSortedMultiset(regularImmutableSortedSet, jArr, 0, this.f22417h);
        }

        @CanIgnoreReturnValue
        /* renamed from: x */
        public Builder<E> m(E e2, int i2) {
            Preconditions.E(e2);
            CollectPreconditions.b(i2, "count");
            w();
            E[] eArr = this.f22415f;
            int i3 = this.f22417h;
            eArr[i3] = e2;
            this.f22416g[i3] = ~i2;
            this.f22417h = i3 + 1;
            return this;
        }
    }

    @J2ktIncompatible
    private static final class SerializedForm<E> implements Serializable {
        final E[] X;
        final int[] Y;
        final Comparator<? super E> s;

        SerializedForm(SortedMultiset<E> sortedMultiset) {
            this.s = sortedMultiset.comparator();
            int size = sortedMultiset.entrySet().size();
            this.X = new Object[size];
            this.Y = new int[size];
            int i2 = 0;
            for (Multiset.Entry next : sortedMultiset.entrySet()) {
                this.X[i2] = next.a();
                this.Y[i2] = next.getCount();
                i2++;
            }
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            int length = this.X.length;
            Builder builder = new Builder(this.s);
            for (int i2 = 0; i2 < length; i2++) {
                builder.k(this.X[i2], this.Y[i2]);
            }
            return builder.l();
        }
    }

    ImmutableSortedMultiset() {
    }

    public static <E> ImmutableSortedMultiset<E> Z(Iterable<? extends E> iterable) {
        return a0(Ordering.z(), iterable);
    }

    public static <E> ImmutableSortedMultiset<E> a0(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                return immutableSortedMultiset.j() ? i0(comparator, immutableSortedMultiset.entrySet().b()) : immutableSortedMultiset;
            }
        }
        return new Builder(comparator).i(iterable).l();
    }

    public static <E> ImmutableSortedMultiset<E> b0(Comparator<? super E> comparator, Iterator<? extends E> it2) {
        Preconditions.E(comparator);
        return new Builder(comparator).j(it2).l();
    }

    public static <E> ImmutableSortedMultiset<E> d0(Iterator<? extends E> it2) {
        return b0(Ordering.z(), it2);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> e0(E[] eArr) {
        return a0(Ordering.z(), Arrays.asList(eArr));
    }

    public static <E> ImmutableSortedMultiset<E> f0(SortedMultiset<E> sortedMultiset) {
        return i0(sortedMultiset.comparator(), Lists.r(sortedMultiset.entrySet()));
    }

    private static <E> ImmutableSortedMultiset<E> i0(Comparator<? super E> comparator, Collection<Multiset.Entry<E>> collection) {
        if (collection.isEmpty()) {
            return l0(comparator);
        }
        ImmutableList.Builder builder = new ImmutableList.Builder(collection.size());
        long[] jArr = new long[(collection.size() + 1)];
        int i2 = 0;
        for (Multiset.Entry next : collection) {
            builder.g(next.a());
            int i3 = i2 + 1;
            jArr[i3] = jArr[i2] + ((long) next.getCount());
            i2 = i3;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(builder.e(), comparator), jArr, 0, collection.size());
    }

    static <E> ImmutableSortedMultiset<E> l0(Comparator<? super E> comparator) {
        return Ordering.z().equals(comparator) ? RegularImmutableSortedMultiset.c3 : new RegularImmutableSortedMultiset(comparator);
    }

    @J2ktIncompatible
    private void m(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> Builder<E> n0() {
        return new Builder<>(Ordering.z());
    }

    public static <E> ImmutableSortedMultiset<E> o0() {
        return RegularImmutableSortedMultiset.c3;
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> p0(E e2) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.B0(e2), new long[]{0, 1}, 0, 1);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> q0(E e2, E e3) {
        return a0(Ordering.z(), Arrays.asList(new Comparable[]{e2, e3}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> t0(E e2, E e3, E e4) {
        return a0(Ordering.z(), Arrays.asList(new Comparable[]{e2, e3, e4}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> u0(E e2, E e3, E e4, E e5) {
        return a0(Ordering.z(), Arrays.asList(new Comparable[]{e2, e3, e4, e5}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> w0(E e2, E e3, E e4, E e5, E e6) {
        return a0(Ordering.z(), Arrays.asList(new Comparable[]{e2, e3, e4, e5, e6}));
    }

    public static <E extends Comparable<? super E>> ImmutableSortedMultiset<E> x0(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        ArrayList u = Lists.u(eArr.length + 6);
        Collections.addAll(u, new Comparable[]{e2, e3, e4, e5, e6, e7});
        Collections.addAll(u, eArr);
        return a0(Ordering.z(), u);
    }

    public static <E> Builder<E> y0(Comparator<E> comparator) {
        return new Builder<>(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> z0() {
        return new Builder<>(Ordering.z().E());
    }

    /* renamed from: A0 */
    public ImmutableSortedMultiset<E> J2(E e2, BoundType boundType, E e3, BoundType boundType2) {
        Preconditions.y(comparator().compare(e2, e3) <= 0, "Expected lowerBound <= upperBound but %s > %s", e2, e3);
        return D1(e2, boundType).e1(e3, boundType2);
    }

    /* renamed from: B0 */
    public abstract ImmutableSortedMultiset<E> D1(E e2, BoundType boundType);

    public final Comparator<? super E> comparator() {
        return e().comparator();
    }

    /* renamed from: j0 */
    public ImmutableSortedMultiset<E> c0() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.Z;
        if (immutableSortedMultiset == null) {
            immutableSortedMultiset = isEmpty() ? l0(Ordering.i(comparator()).E()) : new DescendingImmutableSortedMultiset<>(this);
            this.Z = immutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    /* renamed from: k0 */
    public abstract ImmutableSortedSet<E> e();

    /* renamed from: m0 */
    public abstract ImmutableSortedMultiset<E> e1(E e2, BoundType boundType);

    /* access modifiers changed from: package-private */
    @J2ktIncompatible
    public Object n() {
        return new SerializedForm(this);
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }
}
