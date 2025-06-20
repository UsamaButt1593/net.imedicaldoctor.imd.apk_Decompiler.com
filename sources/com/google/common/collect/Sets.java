package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Sets {

    private static final class CartesianSet<E> extends ForwardingCollection<List<E>> implements Set<List<E>> {
        private final transient CartesianList<E> X;
        private final transient ImmutableList<ImmutableSet<E>> s;

        private CartesianSet(ImmutableList<ImmutableSet<E>> immutableList, CartesianList<E> cartesianList) {
            this.s = immutableList;
            this.X = cartesianList;
        }

        static <E> Set<List<E>> E1(List<? extends Set<? extends E>> list) {
            ImmutableList.Builder builder = new ImmutableList.Builder(list.size());
            for (Set C : list) {
                ImmutableSet C2 = ImmutableSet.C(C);
                if (C2.isEmpty()) {
                    return ImmutableSet.K();
                }
                builder.g(C2);
            }
            final ImmutableList n2 = builder.e();
            return new CartesianSet(n2, new CartesianList(new ImmutableList<List<E>>() {
                /* renamed from: e0 */
                public List<E> get(int i2) {
                    return ((ImmutableSet) ImmutableList.this.get(i2)).b();
                }

                /* access modifiers changed from: package-private */
                public boolean j() {
                    return true;
                }

                public int size() {
                    return ImmutableList.this.size();
                }
            }));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a1 */
        public Collection<List<E>> Z0() {
            return this.X;
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            List<Object> list = (List) obj;
            if (list.size() != this.s.size()) {
                return false;
            }
            int i2 = 0;
            for (Object contains : list) {
                if (!this.s.get(i2).contains(contains)) {
                    return false;
                }
                i2++;
            }
            return true;
        }

        public boolean equals(@CheckForNull Object obj) {
            return obj instanceof CartesianSet ? this.s.equals(((CartesianSet) obj).s) : super.equals(obj);
        }

        public int hashCode() {
            int i2 = 1;
            int size = size() - 1;
            for (int i3 = 0; i3 < this.s.size(); i3++) {
                size = ~(~(size * 31));
            }
            UnmodifiableIterator<ImmutableSet<E>> k2 = this.s.iterator();
            while (k2.hasNext()) {
                Set next = k2.next();
                i2 = ~(~((i2 * 31) + ((size() / next.size()) * next.hashCode())));
            }
            return ~(~(i2 + size));
        }
    }

    @GwtIncompatible
    static class DescendingSet<E> extends ForwardingNavigableSet<E> {
        private final NavigableSet<E> s;

        DescendingSet(NavigableSet<E> navigableSet) {
            this.s = navigableSet;
        }

        private static <T> Ordering<T> i2(Comparator<T> comparator) {
            return Ordering.i(comparator).E();
        }

        /* access modifiers changed from: protected */
        /* renamed from: L1 */
        public NavigableSet<E> a1() {
            return this.s;
        }

        @CheckForNull
        public E ceiling(@ParametricNullness E e2) {
            return this.s.floor(e2);
        }

        public Comparator<? super E> comparator() {
            Comparator<? super E> comparator = this.s.comparator();
            return comparator == null ? Ordering.z().E() : i2(comparator);
        }

        public Iterator<E> descendingIterator() {
            return this.s.iterator();
        }

        public NavigableSet<E> descendingSet() {
            return this.s;
        }

        @ParametricNullness
        public E first() {
            return this.s.last();
        }

        @CheckForNull
        public E floor(@ParametricNullness E e2) {
            return this.s.ceiling(e2);
        }

        public NavigableSet<E> headSet(@ParametricNullness E e2, boolean z) {
            return this.s.tailSet(e2, z).descendingSet();
        }

        @CheckForNull
        public E higher(@ParametricNullness E e2) {
            return this.s.lower(e2);
        }

        public Iterator<E> iterator() {
            return this.s.descendingIterator();
        }

        @ParametricNullness
        public E last() {
            return this.s.first();
        }

        @CheckForNull
        public E lower(@ParametricNullness E e2) {
            return this.s.higher(e2);
        }

        @CheckForNull
        public E pollFirst() {
            return this.s.pollLast();
        }

        @CheckForNull
        public E pollLast() {
            return this.s.pollFirst();
        }

        public NavigableSet<E> subSet(@ParametricNullness E e2, boolean z, @ParametricNullness E e3, boolean z2) {
            return this.s.subSet(e3, z2, e2, z).descendingSet();
        }

        public NavigableSet<E> tailSet(@ParametricNullness E e2, boolean z) {
            return this.s.headSet(e2, z).descendingSet();
        }

        public Object[] toArray() {
            return v1();
        }

        public String toString() {
            return B1();
        }

        public SortedSet<E> headSet(@ParametricNullness E e2) {
            return Q1(e2);
        }

        public SortedSet<E> subSet(@ParametricNullness E e2, @ParametricNullness E e3) {
            return K1(e2, e3);
        }

        public SortedSet<E> tailSet(@ParametricNullness E e2) {
            return h2(e2);
        }

        public <T> T[] toArray(T[] tArr) {
            return x1(tArr);
        }
    }

    @GwtIncompatible
    private static class FilteredNavigableSet<E> extends FilteredSortedSet<E> implements NavigableSet<E> {
        FilteredNavigableSet(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
            super(navigableSet, predicate);
        }

        /* access modifiers changed from: package-private */
        public NavigableSet<E> c() {
            return (NavigableSet) this.s;
        }

        @CheckForNull
        public E ceiling(@ParametricNullness E e2) {
            return Iterables.r(c().tailSet(e2, true), this.X, null);
        }

        public Iterator<E> descendingIterator() {
            return Iterators.x(c().descendingIterator(), this.X);
        }

        public NavigableSet<E> descendingSet() {
            return Sets.h(c().descendingSet(), this.X);
        }

        @CheckForNull
        public E floor(@ParametricNullness E e2) {
            return Iterators.A(c().headSet(e2, true).descendingIterator(), this.X, null);
        }

        public NavigableSet<E> headSet(@ParametricNullness E e2, boolean z) {
            return Sets.h(c().headSet(e2, z), this.X);
        }

        @CheckForNull
        public E higher(@ParametricNullness E e2) {
            return Iterables.r(c().tailSet(e2, false), this.X, null);
        }

        @ParametricNullness
        public E last() {
            return Iterators.z(c().descendingIterator(), this.X);
        }

        @CheckForNull
        public E lower(@ParametricNullness E e2) {
            return Iterators.A(c().headSet(e2, false).descendingIterator(), this.X, null);
        }

        @CheckForNull
        public E pollFirst() {
            return Iterables.I(c(), this.X);
        }

        @CheckForNull
        public E pollLast() {
            return Iterables.I(c().descendingSet(), this.X);
        }

        public NavigableSet<E> subSet(@ParametricNullness E e2, boolean z, @ParametricNullness E e3, boolean z2) {
            return Sets.h(c().subSet(e2, z, e3, z2), this.X);
        }

        public NavigableSet<E> tailSet(@ParametricNullness E e2, boolean z) {
            return Sets.h(c().tailSet(e2, z), this.X);
        }
    }

    private static class FilteredSet<E> extends Collections2.FilteredCollection<E> implements Set<E> {
        FilteredSet(Set<E> set, Predicate<? super E> predicate) {
            super(set, predicate);
        }

        public boolean equals(@CheckForNull Object obj) {
            return Sets.g(this, obj);
        }

        public int hashCode() {
            return Sets.k(this);
        }
    }

    private static class FilteredSortedSet<E> extends FilteredSet<E> implements SortedSet<E> {
        FilteredSortedSet(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
            super(sortedSet, predicate);
        }

        @CheckForNull
        public Comparator<? super E> comparator() {
            return ((SortedSet) this.s).comparator();
        }

        @ParametricNullness
        public E first() {
            return Iterators.z(this.s.iterator(), this.X);
        }

        public SortedSet<E> headSet(@ParametricNullness E e2) {
            return new FilteredSortedSet(((SortedSet) this.s).headSet(e2), this.X);
        }

        @ParametricNullness
        public E last() {
            SortedSet sortedSet = (SortedSet) this.s;
            while (true) {
                E last = sortedSet.last();
                if (this.X.apply(last)) {
                    return last;
                }
                sortedSet = sortedSet.headSet(last);
            }
        }

        public SortedSet<E> subSet(@ParametricNullness E e2, @ParametricNullness E e3) {
            return new FilteredSortedSet(((SortedSet) this.s).subSet(e2, e3), this.X);
        }

        public SortedSet<E> tailSet(@ParametricNullness E e2) {
            return new FilteredSortedSet(((SortedSet) this.s).tailSet(e2), this.X);
        }
    }

    static abstract class ImprovedAbstractSet<E> extends AbstractSet<E> {
        ImprovedAbstractSet() {
        }

        public boolean removeAll(Collection<?> collection) {
            return Sets.I(this, collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return super.retainAll((Collection) Preconditions.E(collection));
        }
    }

    private static final class PowerSet<E> extends AbstractSet<Set<E>> {
        final ImmutableMap<E, Integer> s;

        PowerSet(Set<E> set) {
            Preconditions.k(set.size() <= 30, "Too many elements to create power set: %s > 30", set.size());
            this.s = Maps.Q(set);
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Set)) {
                return false;
            }
            return this.s.keySet().containsAll((Set) obj);
        }

        public boolean equals(@CheckForNull Object obj) {
            return obj instanceof PowerSet ? this.s.keySet().equals(((PowerSet) obj).s.keySet()) : super.equals(obj);
        }

        public int hashCode() {
            return this.s.keySet().hashCode() << (this.s.size() - 1);
        }

        public boolean isEmpty() {
            return false;
        }

        public Iterator<Set<E>> iterator() {
            return new AbstractIndexedListIterator<Set<E>>(size()) {
                /* access modifiers changed from: protected */
                /* renamed from: b */
                public Set<E> a(int i2) {
                    return new SubSet(PowerSet.this.s, i2);
                }
            };
        }

        public int size() {
            return 1 << this.s.size();
        }

        public String toString() {
            return "powerSet(" + this.s + ")";
        }
    }

    public static abstract class SetView<E> extends AbstractSet<E> {
        private SetView() {
        }

        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean add(@ParametricNullness E e2) {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        public <S extends Set<E>> S b(S s) {
            s.addAll(this);
            return s;
        }

        public ImmutableSet<E> c() {
            return ImmutableSet.C(this);
        }

        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        /* renamed from: d */
        public abstract UnmodifiableIterator<E> iterator();

        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @CanIgnoreReturnValue
        @DoNotCall("Always throws UnsupportedOperationException")
        @Deprecated
        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }
    }

    private static final class SubSet<E> extends AbstractSet<E> {
        /* access modifiers changed from: private */
        public final int X;
        /* access modifiers changed from: private */
        public final ImmutableMap<E, Integer> s;

        SubSet(ImmutableMap<E, Integer> immutableMap, int i2) {
            this.s = immutableMap;
            this.X = i2;
        }

        public boolean contains(@CheckForNull Object obj) {
            Integer num = this.s.get(obj);
            if (num != null) {
                if (((1 << num.intValue()) & this.X) != 0) {
                    return true;
                }
            }
            return false;
        }

        public Iterator<E> iterator() {
            return new UnmodifiableIterator<E>() {
                int X;
                final ImmutableList<E> s;

                {
                    this.s = SubSet.this.s.keySet().b();
                    this.X = SubSet.this.X;
                }

                public boolean hasNext() {
                    return this.X != 0;
                }

                public E next() {
                    int numberOfTrailingZeros = Integer.numberOfTrailingZeros(this.X);
                    if (numberOfTrailingZeros != 32) {
                        this.X &= ~(1 << numberOfTrailingZeros);
                        return this.s.get(numberOfTrailingZeros);
                    }
                    throw new NoSuchElementException();
                }
            };
        }

        public int size() {
            return Integer.bitCount(this.X);
        }
    }

    static final class UnmodifiableNavigableSet<E> extends ForwardingSortedSet<E> implements NavigableSet<E>, Serializable {
        private static final long Z = 0;
        private final SortedSet<E> X;
        @CheckForNull
        @LazyInit
        private transient UnmodifiableNavigableSet<E> Y;
        private final NavigableSet<E> s;

        UnmodifiableNavigableSet(NavigableSet<E> navigableSet) {
            this.s = (NavigableSet) Preconditions.E(navigableSet);
            this.X = Collections.unmodifiableSortedSet(navigableSet);
        }

        /* access modifiers changed from: protected */
        /* renamed from: J1 */
        public SortedSet<E> a1() {
            return this.X;
        }

        @CheckForNull
        public E ceiling(@ParametricNullness E e2) {
            return this.s.ceiling(e2);
        }

        public Iterator<E> descendingIterator() {
            return Iterators.f0(this.s.descendingIterator());
        }

        public NavigableSet<E> descendingSet() {
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet = this.Y;
            if (unmodifiableNavigableSet != null) {
                return unmodifiableNavigableSet;
            }
            UnmodifiableNavigableSet<E> unmodifiableNavigableSet2 = new UnmodifiableNavigableSet<>(this.s.descendingSet());
            this.Y = unmodifiableNavigableSet2;
            unmodifiableNavigableSet2.Y = this;
            return unmodifiableNavigableSet2;
        }

        @CheckForNull
        public E floor(@ParametricNullness E e2) {
            return this.s.floor(e2);
        }

        public NavigableSet<E> headSet(@ParametricNullness E e2, boolean z) {
            return Sets.O(this.s.headSet(e2, z));
        }

        @CheckForNull
        public E higher(@ParametricNullness E e2) {
            return this.s.higher(e2);
        }

        @CheckForNull
        public E lower(@ParametricNullness E e2) {
            return this.s.lower(e2);
        }

        @CheckForNull
        public E pollFirst() {
            throw new UnsupportedOperationException();
        }

        @CheckForNull
        public E pollLast() {
            throw new UnsupportedOperationException();
        }

        public NavigableSet<E> subSet(@ParametricNullness E e2, boolean z, @ParametricNullness E e3, boolean z2) {
            return Sets.O(this.s.subSet(e2, z, e3, z2));
        }

        public NavigableSet<E> tailSet(@ParametricNullness E e2, boolean z) {
            return Sets.O(this.s.tailSet(e2, z));
        }
    }

    private Sets() {
    }

    public static <E> LinkedHashSet<E> A() {
        return new LinkedHashSet<>();
    }

    public static <E> LinkedHashSet<E> B(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return new LinkedHashSet<>((Collection) iterable);
        }
        LinkedHashSet<E> A = A();
        Iterables.a(A, iterable);
        return A;
    }

    public static <E> LinkedHashSet<E> C(int i2) {
        return new LinkedHashSet<>(Maps.o(i2));
    }

    @Deprecated
    public static <E> Set<E> D(Map<E, Boolean> map) {
        return Collections.newSetFromMap(map);
    }

    public static <E extends Comparable> TreeSet<E> E() {
        return new TreeSet<>();
    }

    public static <E extends Comparable> TreeSet<E> F(Iterable<? extends E> iterable) {
        TreeSet<E> E = E();
        Iterables.a(E, iterable);
        return E;
    }

    public static <E> TreeSet<E> G(Comparator<? super E> comparator) {
        return new TreeSet<>((Comparator) Preconditions.E(comparator));
    }

    @GwtCompatible(serializable = false)
    public static <E> Set<Set<E>> H(Set<E> set) {
        return new PowerSet(set);
    }

    static boolean I(Set<?> set, Collection<?> collection) {
        Preconditions.E(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).e();
        }
        return (!(collection instanceof Set) || collection.size() <= set.size()) ? J(set, collection.iterator()) : Iterators.V(set.iterator(), collection);
    }

    static boolean J(Set<?> set, Iterator<?> it2) {
        boolean z = false;
        while (it2.hasNext()) {
            z |= set.remove(it2.next());
        }
        return z;
    }

    @GwtIncompatible
    public static <K extends Comparable<? super K>> NavigableSet<K> K(NavigableSet<K> navigableSet, Range<K> range) {
        boolean z = false;
        if (navigableSet.comparator() != null && navigableSet.comparator() != Ordering.z() && range.q() && range.r()) {
            Preconditions.e(navigableSet.comparator().compare(range.y(), range.L()) <= 0, "set is using a custom comparator which is inconsistent with the natural ordering.");
        }
        if (range.q() && range.r()) {
            K y = range.y();
            BoundType x = range.x();
            BoundType boundType = BoundType.CLOSED;
            boolean z2 = x == boundType;
            K L = range.L();
            if (range.K() == boundType) {
                z = true;
            }
            return navigableSet.subSet(y, z2, L, z);
        } else if (range.q()) {
            K y2 = range.y();
            if (range.x() == BoundType.CLOSED) {
                z = true;
            }
            return navigableSet.tailSet(y2, z);
        } else if (!range.r()) {
            return (NavigableSet) Preconditions.E(navigableSet);
        } else {
            K L2 = range.L();
            if (range.K() == BoundType.CLOSED) {
                z = true;
            }
            return navigableSet.headSet(L2, z);
        }
    }

    public static <E> SetView<E> L(final Set<? extends E> set, final Set<? extends E> set2) {
        Preconditions.F(set, "set1");
        Preconditions.F(set2, "set2");
        return new SetView<E>() {
            public boolean contains(@CheckForNull Object obj) {
                return set2.contains(obj) ^ set.contains(obj);
            }

            /* renamed from: d */
            public UnmodifiableIterator<E> iterator() {
                final Iterator it2 = set.iterator();
                final Iterator it3 = set2.iterator();
                return new AbstractIterator<E>() {
                    @CheckForNull
                    public E a() {
                        while (it2.hasNext()) {
                            E next = it2.next();
                            if (!set2.contains(next)) {
                                return next;
                            }
                        }
                        while (it3.hasNext()) {
                            E next2 = it3.next();
                            if (!set.contains(next2)) {
                                return next2;
                            }
                        }
                        return b();
                    }
                };
            }

            public boolean isEmpty() {
                return set.equals(set2);
            }

            public int size() {
                int i2 = 0;
                for (Object contains : set) {
                    if (!set2.contains(contains)) {
                        i2++;
                    }
                }
                for (Object contains2 : set2) {
                    if (!set.contains(contains2)) {
                        i2++;
                    }
                }
                return i2;
            }
        };
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> M(NavigableSet<E> navigableSet) {
        return Synchronized.q(navigableSet);
    }

    public static <E> SetView<E> N(final Set<? extends E> set, final Set<? extends E> set2) {
        Preconditions.F(set, "set1");
        Preconditions.F(set2, "set2");
        return new SetView<E>() {
            public <S extends Set<E>> S b(S s2) {
                s2.addAll(set);
                s2.addAll(set2);
                return s2;
            }

            public ImmutableSet<E> c() {
                return new ImmutableSet.Builder().c(set).c(set2).e();
            }

            public boolean contains(@CheckForNull Object obj) {
                return set.contains(obj) || set2.contains(obj);
            }

            /* renamed from: d */
            public UnmodifiableIterator<E> iterator() {
                return new AbstractIterator<E>() {
                    final Iterator<? extends E> Y;
                    final Iterator<? extends E> Z;

                    {
                        this.Y = set.iterator();
                        this.Z = set2.iterator();
                    }

                    /* access modifiers changed from: protected */
                    @CheckForNull
                    public E a() {
                        if (this.Y.hasNext()) {
                            return this.Y.next();
                        }
                        while (this.Z.hasNext()) {
                            E next = this.Z.next();
                            if (!set.contains(next)) {
                                return next;
                            }
                        }
                        return b();
                    }
                };
            }

            public boolean isEmpty() {
                return set.isEmpty() && set2.isEmpty();
            }

            public int size() {
                int size = set.size();
                for (Object contains : set2) {
                    if (!set.contains(contains)) {
                        size++;
                    }
                }
                return size;
            }
        };
    }

    public static <E> NavigableSet<E> O(NavigableSet<E> navigableSet) {
        return ((navigableSet instanceof ImmutableCollection) || (navigableSet instanceof UnmodifiableNavigableSet)) ? navigableSet : new UnmodifiableNavigableSet(navigableSet);
    }

    public static <B> Set<List<B>> a(List<? extends Set<? extends B>> list) {
        return CartesianSet.E1(list);
    }

    @SafeVarargs
    public static <B> Set<List<B>> b(Set<? extends B>... setArr) {
        return a(Arrays.asList(setArr));
    }

    public static <E> Set<Set<E>> c(Set<E> set, final int i2) {
        ImmutableSet<E> p;
        final ImmutableMap<E, Integer> Q = Maps.Q(set);
        CollectPreconditions.b(i2, "size");
        Preconditions.m(i2 <= Q.size(), "size (%s) must be <= set.size() (%s)", i2, Q.size());
        if (i2 == 0) {
            p = ImmutableSet.K();
        } else if (i2 != Q.size()) {
            return new AbstractSet<Set<E>>() {
                public boolean contains(@CheckForNull Object obj) {
                    if (!(obj instanceof Set)) {
                        return false;
                    }
                    Set set = (Set) obj;
                    return set.size() == i2 && Q.keySet().containsAll(set);
                }

                public Iterator<Set<E>> iterator() {
                    return new AbstractIterator<Set<E>>() {
                        final BitSet Y;

                        {
                            this.Y = new BitSet(Q.size());
                        }

                        /* access modifiers changed from: protected */
                        @CheckForNull
                        /* renamed from: d */
                        public Set<E> a() {
                            if (this.Y.isEmpty()) {
                                this.Y.set(0, i2);
                            } else {
                                int nextSetBit = this.Y.nextSetBit(0);
                                int nextClearBit = this.Y.nextClearBit(nextSetBit);
                                if (nextClearBit == Q.size()) {
                                    return (Set) b();
                                }
                                int i2 = (nextClearBit - nextSetBit) - 1;
                                this.Y.set(0, i2);
                                this.Y.clear(i2, nextClearBit);
                                this.Y.set(nextClearBit);
                            }
                            final BitSet bitSet = (BitSet) this.Y.clone();
                            return new AbstractSet<E>() {
                                public boolean contains(@CheckForNull Object obj) {
                                    Integer num = (Integer) Q.get(obj);
                                    return num != null && bitSet.get(num.intValue());
                                }

                                public Iterator<E> iterator() {
                                    return new AbstractIterator<E>() {
                                        int Y = -1;

                                        /* access modifiers changed from: protected */
                                        @CheckForNull
                                        public E a() {
                                            int nextSetBit = bitSet.nextSetBit(this.Y + 1);
                                            this.Y = nextSetBit;
                                            return nextSetBit == -1 ? b() : Q.keySet().b().get(this.Y);
                                        }
                                    };
                                }

                                public int size() {
                                    return i2;
                                }
                            };
                        }
                    };
                }

                public int size() {
                    return IntMath.a(Q.size(), i2);
                }

                public String toString() {
                    return "Sets.combinations(" + Q.keySet() + ", " + i2 + ")";
                }
            };
        } else {
            p = Q.keySet();
        }
        return ImmutableSet.L(p);
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E extends Enum<E>> EnumSet<E> d(Collection<E> collection) {
        if (collection instanceof EnumSet) {
            return EnumSet.complementOf((EnumSet) collection);
        }
        Preconditions.e(!collection.isEmpty(), "collection is empty; use the other version of this method");
        return o(collection, ((Enum) collection.iterator().next()).getDeclaringClass());
    }

    @GwtIncompatible
    public static <E extends Enum<E>> EnumSet<E> e(Collection<E> collection, Class<E> cls) {
        Preconditions.E(collection);
        return collection instanceof EnumSet ? EnumSet.complementOf((EnumSet) collection) : o(collection, cls);
    }

    public static <E> SetView<E> f(final Set<E> set, final Set<?> set2) {
        Preconditions.F(set, "set1");
        Preconditions.F(set2, "set2");
        return new SetView<E>() {
            public boolean contains(@CheckForNull Object obj) {
                return set.contains(obj) && !set2.contains(obj);
            }

            /* renamed from: d */
            public UnmodifiableIterator<E> iterator() {
                return new AbstractIterator<E>() {
                    final Iterator<E> Y;

                    {
                        this.Y = set.iterator();
                    }

                    /* access modifiers changed from: protected */
                    @CheckForNull
                    public E a() {
                        while (this.Y.hasNext()) {
                            E next = this.Y.next();
                            if (!set2.contains(next)) {
                                return next;
                            }
                        }
                        return b();
                    }
                };
            }

            public boolean isEmpty() {
                return set2.containsAll(set);
            }

            public int size() {
                int i2 = 0;
                for (Object contains : set) {
                    if (!set2.contains(contains)) {
                        i2++;
                    }
                }
                return i2;
            }
        };
    }

    static boolean g(Set<?> set, @CheckForNull Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @GwtIncompatible
    public static <E> NavigableSet<E> h(NavigableSet<E> navigableSet, Predicate<? super E> predicate) {
        if (!(navigableSet instanceof FilteredSet)) {
            return new FilteredNavigableSet((NavigableSet) Preconditions.E(navigableSet), (Predicate) Preconditions.E(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) navigableSet;
        return new FilteredNavigableSet((NavigableSet) filteredSet.s, Predicates.d(filteredSet.X, predicate));
    }

    public static <E> Set<E> i(Set<E> set, Predicate<? super E> predicate) {
        if (set instanceof SortedSet) {
            return j((SortedSet) set, predicate);
        }
        if (!(set instanceof FilteredSet)) {
            return new FilteredSet((Set) Preconditions.E(set), (Predicate) Preconditions.E(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) set;
        return new FilteredSet((Set) filteredSet.s, Predicates.d(filteredSet.X, predicate));
    }

    public static <E> SortedSet<E> j(SortedSet<E> sortedSet, Predicate<? super E> predicate) {
        if (!(sortedSet instanceof FilteredSet)) {
            return new FilteredSortedSet((SortedSet) Preconditions.E(sortedSet), (Predicate) Preconditions.E(predicate));
        }
        FilteredSet filteredSet = (FilteredSet) sortedSet;
        return new FilteredSortedSet((SortedSet) filteredSet.s, Predicates.d(filteredSet.X, predicate));
    }

    static int k(Set<?> set) {
        Iterator<?> it2 = set.iterator();
        int i2 = 0;
        while (it2.hasNext()) {
            Object next = it2.next();
            i2 = ~(~(i2 + (next != null ? next.hashCode() : 0)));
        }
        return i2;
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> l(E e2, E... eArr) {
        return ImmutableEnumSet.U(EnumSet.of(e2, eArr));
    }

    @GwtCompatible(serializable = true)
    public static <E extends Enum<E>> ImmutableSet<E> m(Iterable<E> iterable) {
        if (iterable instanceof ImmutableEnumSet) {
            return (ImmutableEnumSet) iterable;
        }
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            return collection.isEmpty() ? ImmutableSet.K() : ImmutableEnumSet.U(EnumSet.copyOf(collection));
        }
        Iterator<E> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return ImmutableSet.K();
        }
        EnumSet of = EnumSet.of((Enum) it2.next());
        Iterators.a(of, it2);
        return ImmutableEnumSet.U(of);
    }

    public static <E> SetView<E> n(final Set<E> set, final Set<?> set2) {
        Preconditions.F(set, "set1");
        Preconditions.F(set2, "set2");
        return new SetView<E>() {
            public boolean contains(@CheckForNull Object obj) {
                return set.contains(obj) && set2.contains(obj);
            }

            public boolean containsAll(Collection<?> collection) {
                return set.containsAll(collection) && set2.containsAll(collection);
            }

            /* renamed from: d */
            public UnmodifiableIterator<E> iterator() {
                return new AbstractIterator<E>() {
                    final Iterator<E> Y;

                    {
                        this.Y = set.iterator();
                    }

                    /* access modifiers changed from: protected */
                    @CheckForNull
                    public E a() {
                        while (this.Y.hasNext()) {
                            E next = this.Y.next();
                            if (set2.contains(next)) {
                                return next;
                            }
                        }
                        return b();
                    }
                };
            }

            public boolean isEmpty() {
                return Collections.disjoint(set2, set);
            }

            public int size() {
                int i2 = 0;
                for (Object contains : set) {
                    if (set2.contains(contains)) {
                        i2++;
                    }
                }
                return i2;
            }
        };
    }

    @GwtIncompatible
    private static <E extends Enum<E>> EnumSet<E> o(Collection<E> collection, Class<E> cls) {
        EnumSet<E> allOf = EnumSet.allOf(cls);
        allOf.removeAll(collection);
        return allOf;
    }

    public static <E> Set<E> p() {
        return Collections.newSetFromMap(new ConcurrentHashMap());
    }

    public static <E> Set<E> q(Iterable<? extends E> iterable) {
        Set<E> p = p();
        Iterables.a(p, iterable);
        return p;
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E> CopyOnWriteArraySet<E> r() {
        return new CopyOnWriteArraySet<>();
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Iterable<? extends E>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.common.annotations.GwtIncompatible
    @com.google.common.annotations.J2ktIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <E> java.util.concurrent.CopyOnWriteArraySet<E> s(java.lang.Iterable<? extends E> r1) {
        /*
            boolean r0 = r1 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0007
            java.util.Collection r1 = (java.util.Collection) r1
            goto L_0x000b
        L_0x0007:
            java.util.ArrayList r1 = com.google.common.collect.Lists.r(r1)
        L_0x000b:
            java.util.concurrent.CopyOnWriteArraySet r0 = new java.util.concurrent.CopyOnWriteArraySet
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Sets.s(java.lang.Iterable):java.util.concurrent.CopyOnWriteArraySet");
    }

    public static <E extends Enum<E>> EnumSet<E> t(Iterable<E> iterable, Class<E> cls) {
        EnumSet<E> noneOf = EnumSet.noneOf(cls);
        Iterables.a(noneOf, iterable);
        return noneOf;
    }

    public static <E> HashSet<E> u() {
        return new HashSet<>();
    }

    public static <E> HashSet<E> v(Iterable<? extends E> iterable) {
        return iterable instanceof Collection ? new HashSet<>((Collection) iterable) : w(iterable.iterator());
    }

    public static <E> HashSet<E> w(Iterator<? extends E> it2) {
        HashSet<E> u = u();
        Iterators.a(u, it2);
        return u;
    }

    public static <E> HashSet<E> x(E... eArr) {
        HashSet<E> y = y(eArr.length);
        Collections.addAll(y, eArr);
        return y;
    }

    public static <E> HashSet<E> y(int i2) {
        return new HashSet<>(Maps.o(i2));
    }

    public static <E> Set<E> z() {
        return Collections.newSetFromMap(Maps.b0());
    }
}
