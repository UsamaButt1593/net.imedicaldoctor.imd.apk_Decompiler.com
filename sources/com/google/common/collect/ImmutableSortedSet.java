package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, SortedIterable<E> {
    final transient Comparator<? super E> Y2;
    @GwtIncompatible
    @CheckForNull
    @LazyInit
    transient ImmutableSortedSet<E> Z2;

    public static final class Builder<E> extends ImmutableSet.Builder<E> {

        /* renamed from: g  reason: collision with root package name */
        private final Comparator<? super E> f22419g;

        public Builder(Comparator<? super E> comparator) {
            this.f22419g = (Comparator) Preconditions.E(comparator);
        }

        @CanIgnoreReturnValue
        /* renamed from: q */
        public Builder<E> j(E e2) {
            super.g(e2);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: r */
        public Builder<E> k(E... eArr) {
            super.b(eArr);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: s */
        public Builder<E> l(Iterable<? extends E> iterable) {
            super.c(iterable);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: t */
        public Builder<E> m(Iterator<? extends E> it2) {
            super.d(it2);
            return this;
        }

        /* renamed from: u */
        public ImmutableSortedSet<E> o() {
            ImmutableSortedSet<E> e0 = ImmutableSortedSet.e0(this.f22419g, this.f22387c, this.f22386b);
            this.f22387c = e0.size();
            this.f22388d = true;
            return e0;
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        /* renamed from: v */
        public Builder<E> p(ImmutableSet.Builder<E> builder) {
            super.p(builder);
            return this;
        }
    }

    @J2ktIncompatible
    private static class SerializedForm<E> implements Serializable {
        private static final long Y = 0;
        final Object[] X;
        final Comparator<? super E> s;

        public SerializedForm(Comparator<? super E> comparator, Object[] objArr) {
            this.s = comparator;
            this.X = objArr;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return new Builder(this.s).k(this.X).o();
        }
    }

    ImmutableSortedSet(Comparator<? super E> comparator) {
        this.Y2 = comparator;
    }

    public static <E> ImmutableSortedSet<E> A0() {
        return RegularImmutableSortedSet.b3;
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> B0(E e2) {
        return new RegularImmutableSortedSet(ImmutableList.K(e2), Ordering.z());
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> E0(E e2, E e3) {
        return e0(Ordering.z(), 2, e2, e3);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> F0(E e2, E e3, E e4) {
        return e0(Ordering.z(), 3, e2, e3, e4);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> G0(E e2, E e3, E e4, E e5) {
        return e0(Ordering.z(), 4, e2, e3, e4, e5);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> H0(E e2, E e3, E e4, E e5, E e6) {
        return e0(Ordering.z(), 5, e2, e3, e4, e5, e6);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> I0(E e2, E e3, E e4, E e5, E e6, E e7, E... eArr) {
        int length = eArr.length + 6;
        Comparable[] comparableArr = new Comparable[length];
        comparableArr[0] = e2;
        comparableArr[1] = e3;
        comparableArr[2] = e4;
        comparableArr[3] = e5;
        comparableArr[4] = e6;
        comparableArr[5] = e7;
        System.arraycopy(eArr, 0, comparableArr, 6, eArr.length);
        return e0(Ordering.z(), length, comparableArr);
    }

    public static <E> Builder<E> J0(Comparator<E> comparator) {
        return new Builder<>(comparator);
    }

    public static <E extends Comparable<?>> Builder<E> M0() {
        return new Builder<>(Collections.reverseOrder());
    }

    static int W0(Comparator<?> comparator, Object obj, @CheckForNull Object obj2) {
        return comparator.compare(obj, obj2);
    }

    static <E> ImmutableSortedSet<E> e0(Comparator<? super E> comparator, int i2, E... eArr) {
        if (i2 == 0) {
            return u0(comparator);
        }
        ObjectArrays.c(eArr, i2);
        Arrays.sort(eArr, 0, i2, comparator);
        int i3 = 1;
        for (int i4 = 1; i4 < i2; i4++) {
            E e2 = eArr[i4];
            if (comparator.compare(e2, eArr[i3 - 1]) != 0) {
                eArr[i3] = e2;
                i3++;
            }
        }
        Arrays.fill(eArr, i3, i2, (Object) null);
        if (i3 < eArr.length / 2) {
            eArr = Arrays.copyOf(eArr, i3);
        }
        return new RegularImmutableSortedSet(ImmutableList.q(eArr, i3), comparator);
    }

    public static <E> ImmutableSortedSet<E> f0(Iterable<? extends E> iterable) {
        return j0(Ordering.z(), iterable);
    }

    public static <E> ImmutableSortedSet<E> i0(Collection<? extends E> collection) {
        return k0(Ordering.z(), collection);
    }

    public static <E> ImmutableSortedSet<E> j0(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Preconditions.E(comparator);
        if (SortedIterables.b(comparator, iterable) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.j()) {
                return immutableSortedSet;
            }
        }
        Object[] P = Iterables.P(iterable);
        return e0(comparator, P.length, P);
    }

    public static <E> ImmutableSortedSet<E> k0(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return j0(comparator, collection);
    }

    public static <E> ImmutableSortedSet<E> l0(Comparator<? super E> comparator, Iterator<? extends E> it2) {
        return new Builder(comparator).m(it2).o();
    }

    @J2ktIncompatible
    private void m(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E> ImmutableSortedSet<E> m0(Iterator<? extends E> it2) {
        return l0(Ordering.z(), it2);
    }

    public static <E extends Comparable<? super E>> ImmutableSortedSet<E> n0(E[] eArr) {
        return e0(Ordering.z(), eArr.length, (Comparable[]) eArr.clone());
    }

    public static <E> ImmutableSortedSet<E> o0(SortedSet<E> sortedSet) {
        Comparator<? super E> a2 = SortedIterables.a(sortedSet);
        ImmutableList<E> B = ImmutableList.B(sortedSet);
        return B.isEmpty() ? u0(a2) : new RegularImmutableSortedSet(B, a2);
    }

    static <E> RegularImmutableSortedSet<E> u0(Comparator<? super E> comparator) {
        return Ordering.z().equals(comparator) ? RegularImmutableSortedSet.b3 : new RegularImmutableSortedSet<>(ImmutableList.I(), comparator);
    }

    public static <E extends Comparable<?>> Builder<E> z0() {
        return new Builder<>(Ordering.z());
    }

    /* renamed from: N0 */
    public ImmutableSortedSet<E> subSet(E e2, E e3) {
        return subSet(e2, true, e3, false);
    }

    @GwtIncompatible
    /* renamed from: O0 */
    public ImmutableSortedSet<E> subSet(E e2, boolean z, E e3, boolean z2) {
        Preconditions.E(e2);
        Preconditions.E(e3);
        Preconditions.d(this.Y2.compare(e2, e3) <= 0);
        return P0(e2, z, e3, z2);
    }

    /* access modifiers changed from: package-private */
    public abstract ImmutableSortedSet<E> P0(E e2, boolean z, E e3, boolean z2);

    /* renamed from: Q0 */
    public ImmutableSortedSet<E> tailSet(E e2) {
        return tailSet(e2, true);
    }

    /* renamed from: T0 */
    public ImmutableSortedSet<E> tailSet(E e2, boolean z) {
        return U0(Preconditions.E(e2), z);
    }

    /* access modifiers changed from: package-private */
    public abstract ImmutableSortedSet<E> U0(E e2, boolean z);

    /* access modifiers changed from: package-private */
    public int V0(Object obj, @CheckForNull Object obj2) {
        return W0(this.Y2, obj, obj2);
    }

    @CheckForNull
    public E ceiling(E e2) {
        return Iterables.v(tailSet(e2, true), null);
    }

    public Comparator<? super E> comparator() {
        return this.Y2;
    }

    public E first() {
        return iterator().next();
    }

    @CheckForNull
    public E floor(E e2) {
        return Iterators.J(headSet(e2, true).descendingIterator(), null);
    }

    @GwtIncompatible
    @CheckForNull
    public E higher(E e2) {
        return Iterables.v(tailSet(e2, false), null);
    }

    /* access modifiers changed from: package-private */
    public abstract int indexOf(@CheckForNull Object obj);

    /* renamed from: k */
    public abstract UnmodifiableIterator<E> iterator();

    public E last() {
        return descendingIterator().next();
    }

    @GwtIncompatible
    @CheckForNull
    public E lower(E e2) {
        return Iterators.J(headSet(e2, false).descendingIterator(), null);
    }

    /* access modifiers changed from: package-private */
    @J2ktIncompatible
    public Object n() {
        return new SerializedForm(this.Y2, toArray());
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public abstract ImmutableSortedSet<E> p0();

    @GwtIncompatible
    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible
    @CanIgnoreReturnValue
    @CheckForNull
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible
    /* renamed from: q0 */
    public abstract UnmodifiableIterator<E> descendingIterator();

    @GwtIncompatible
    /* renamed from: t0 */
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.Z2;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        ImmutableSortedSet<E> p0 = p0();
        this.Z2 = p0;
        p0.Z2 = this;
        return p0;
    }

    /* renamed from: w0 */
    public ImmutableSortedSet<E> headSet(E e2) {
        return headSet(e2, false);
    }

    /* renamed from: x0 */
    public ImmutableSortedSet<E> headSet(E e2, boolean z) {
        return y0(Preconditions.E(e2), z);
    }

    /* access modifiers changed from: package-private */
    public abstract ImmutableSortedSet<E> y0(E e2, boolean z);
}
