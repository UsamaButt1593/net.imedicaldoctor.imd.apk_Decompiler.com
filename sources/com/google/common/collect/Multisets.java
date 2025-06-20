package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Multisets {

    static abstract class AbstractEntry<E> implements Multiset.Entry<E> {
        AbstractEntry() {
        }

        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            return getCount() == entry.getCount() && Objects.a(a(), entry.a());
        }

        public int hashCode() {
            Object a2 = a();
            return (a2 == null ? 0 : a2.hashCode()) ^ getCount();
        }

        public String toString() {
            String valueOf = String.valueOf(a());
            int count = getCount();
            if (count == 1) {
                return valueOf;
            }
            return valueOf + " x " + count;
        }
    }

    private static final class DecreasingCount implements Comparator<Multiset.Entry<?>> {
        static final DecreasingCount s = new DecreasingCount();

        private DecreasingCount() {
        }

        /* renamed from: a */
        public int compare(Multiset.Entry<?> entry, Multiset.Entry<?> entry2) {
            return entry2.getCount() - entry.getCount();
        }
    }

    static abstract class ElementSet<E> extends Sets.ImprovedAbstractSet<E> {
        ElementSet() {
        }

        public void clear() {
            h().clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            return h().contains(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return h().containsAll(collection);
        }

        /* access modifiers changed from: package-private */
        public abstract Multiset<E> h();

        public boolean isEmpty() {
            return h().isEmpty();
        }

        public abstract Iterator<E> iterator();

        public boolean remove(@CheckForNull Object obj) {
            return h().F(obj, Integer.MAX_VALUE) > 0;
        }

        public int size() {
            return h().entrySet().size();
        }
    }

    static abstract class EntrySet<E> extends Sets.ImprovedAbstractSet<Multiset.Entry<E>> {
        EntrySet() {
        }

        public void clear() {
            h().clear();
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof Multiset.Entry)) {
                return false;
            }
            Multiset.Entry entry = (Multiset.Entry) obj;
            return entry.getCount() > 0 && h().l1(entry.a()) == entry.getCount();
        }

        /* access modifiers changed from: package-private */
        public abstract Multiset<E> h();

        public boolean remove(@CheckForNull Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                Object a2 = entry.a();
                int count = entry.getCount();
                if (count != 0) {
                    return h().D0(a2, count, 0);
                }
            }
            return false;
        }
    }

    private static final class FilteredMultiset<E> extends ViewMultiset<E> {
        final Multiset<E> Y;
        final Predicate<? super E> Z;

        FilteredMultiset(Multiset<E> multiset, Predicate<? super E> predicate) {
            super();
            this.Y = (Multiset) Preconditions.E(multiset);
            this.Z = (Predicate) Preconditions.E(predicate);
        }

        public int F(@CheckForNull Object obj, int i2) {
            CollectPreconditions.b(i2, "occurrences");
            if (i2 == 0) {
                return l1(obj);
            }
            if (contains(obj)) {
                return this.Y.F(obj, i2);
            }
            return 0;
        }

        public int Q(@ParametricNullness E e2, int i2) {
            Preconditions.y(this.Z.apply(e2), "Element %s does not match predicate %s", e2, this.Z);
            return this.Y.Q(e2, i2);
        }

        /* access modifiers changed from: package-private */
        public Set<E> b() {
            return Sets.i(this.Y.e(), this.Z);
        }

        /* access modifiers changed from: package-private */
        public Set<Multiset.Entry<E>> c() {
            return Sets.i(this.Y.entrySet(), new Predicate<Multiset.Entry<E>>() {
                /* renamed from: a */
                public boolean apply(Multiset.Entry<E> entry) {
                    return FilteredMultiset.this.Z.apply(entry.a());
                }
            });
        }

        /* access modifiers changed from: package-private */
        public Iterator<E> g() {
            throw new AssertionError("should never be called");
        }

        /* access modifiers changed from: package-private */
        public Iterator<Multiset.Entry<E>> h() {
            throw new AssertionError("should never be called");
        }

        /* renamed from: j */
        public UnmodifiableIterator<E> iterator() {
            return Iterators.x(this.Y.iterator(), this.Z);
        }

        public int l1(@CheckForNull Object obj) {
            int l1 = this.Y.l1(obj);
            if (l1 <= 0 || !this.Z.apply(obj)) {
                return 0;
            }
            return l1;
        }
    }

    static class ImmutableEntry<E> extends AbstractEntry<E> implements Serializable {
        private static final long Y = 0;
        private final int X;
        @ParametricNullness
        private final E s;

        ImmutableEntry(@ParametricNullness E e2, int i2) {
            this.s = e2;
            this.X = i2;
            CollectPreconditions.b(i2, "count");
        }

        @ParametricNullness
        public final E a() {
            return this.s;
        }

        @CheckForNull
        public ImmutableEntry<E> b() {
            return null;
        }

        public final int getCount() {
            return this.X;
        }
    }

    static final class MultisetIteratorImpl<E> implements Iterator<E> {
        private final Iterator<Multiset.Entry<E>> X;
        private int X2;
        @CheckForNull
        private Multiset.Entry<E> Y;
        private boolean Y2;
        private int Z;
        private final Multiset<E> s;

        MultisetIteratorImpl(Multiset<E> multiset, Iterator<Multiset.Entry<E>> it2) {
            this.s = multiset;
            this.X = it2;
        }

        public boolean hasNext() {
            return this.Z > 0 || this.X.hasNext();
        }

        @ParametricNullness
        public E next() {
            if (hasNext()) {
                if (this.Z == 0) {
                    Multiset.Entry<E> next = this.X.next();
                    this.Y = next;
                    int count = next.getCount();
                    this.Z = count;
                    this.X2 = count;
                }
                this.Z--;
                this.Y2 = true;
                Multiset.Entry<E> entry = this.Y;
                java.util.Objects.requireNonNull(entry);
                return entry.a();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            CollectPreconditions.e(this.Y2);
            if (this.X2 == 1) {
                this.X.remove();
            } else {
                Multiset<E> multiset = this.s;
                Multiset.Entry<E> entry = this.Y;
                java.util.Objects.requireNonNull(entry);
                multiset.remove(entry.a());
            }
            this.X2--;
            this.Y2 = false;
        }
    }

    static class UnmodifiableMultiset<E> extends ForwardingMultiset<E> implements Serializable {
        private static final long Z = 0;
        @CheckForNull
        @LazyInit
        transient Set<E> X;
        @CheckForNull
        @LazyInit
        transient Set<Multiset.Entry<E>> Y;
        final Multiset<? extends E> s;

        UnmodifiableMultiset(Multiset<? extends E> multiset) {
            this.s = multiset;
        }

        public boolean D0(@ParametricNullness E e2, int i2, int i3) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: protected */
        /* renamed from: E1 */
        public Multiset<E> a1() {
            return this.s;
        }

        public int F(@CheckForNull Object obj, int i2) {
            throw new UnsupportedOperationException();
        }

        public int Q(@ParametricNullness E e2, int i2) {
            throw new UnsupportedOperationException();
        }

        /* access modifiers changed from: package-private */
        public Set<E> Q1() {
            return Collections.unmodifiableSet(this.s.e());
        }

        public boolean add(@ParametricNullness E e2) {
            throw new UnsupportedOperationException();
        }

        public boolean addAll(Collection<? extends E> collection) {
            throw new UnsupportedOperationException();
        }

        public void clear() {
            throw new UnsupportedOperationException();
        }

        public Set<E> e() {
            Set<E> set = this.X;
            if (set != null) {
                return set;
            }
            Set<E> Q1 = Q1();
            this.X = Q1;
            return Q1;
        }

        public Set<Multiset.Entry<E>> entrySet() {
            Set<Multiset.Entry<E>> set = this.Y;
            if (set != null) {
                return set;
            }
            Set<Multiset.Entry<E>> unmodifiableSet = Collections.unmodifiableSet(this.s.entrySet());
            this.Y = unmodifiableSet;
            return unmodifiableSet;
        }

        public Iterator<E> iterator() {
            return Iterators.f0(this.s.iterator());
        }

        public int r0(@ParametricNullness E e2, int i2) {
            throw new UnsupportedOperationException();
        }

        public boolean remove(@CheckForNull Object obj) {
            throw new UnsupportedOperationException();
        }

        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }
    }

    private static abstract class ViewMultiset<E> extends AbstractMultiset<E> {
        private ViewMultiset() {
        }

        public void clear() {
            e().clear();
        }

        /* access modifiers changed from: package-private */
        public int d() {
            return e().size();
        }

        public Iterator<E> iterator() {
            return Multisets.n(this);
        }

        public int size() {
            return Multisets.o(this);
        }
    }

    private Multisets() {
    }

    public static <E> Multiset<E> A(Multiset<? extends E> multiset) {
        return ((multiset instanceof UnmodifiableMultiset) || (multiset instanceof ImmutableMultiset)) ? multiset : new UnmodifiableMultiset((Multiset) Preconditions.E(multiset));
    }

    public static <E> SortedMultiset<E> B(SortedMultiset<E> sortedMultiset) {
        return new UnmodifiableSortedMultiset((SortedMultiset) Preconditions.E(sortedMultiset));
    }

    private static <E> boolean a(Multiset<E> multiset, AbstractMapBasedMultiset<? extends E> abstractMapBasedMultiset) {
        if (abstractMapBasedMultiset.isEmpty()) {
            return false;
        }
        abstractMapBasedMultiset.j(multiset);
        return true;
    }

    private static <E> boolean b(Multiset<E> multiset, Multiset<? extends E> multiset2) {
        if (multiset2 instanceof AbstractMapBasedMultiset) {
            return a(multiset, (AbstractMapBasedMultiset) multiset2);
        }
        if (multiset2.isEmpty()) {
            return false;
        }
        for (Multiset.Entry next : multiset2.entrySet()) {
            multiset.Q(next.a(), next.getCount());
        }
        return true;
    }

    static <E> boolean c(Multiset<E> multiset, Collection<? extends E> collection) {
        Preconditions.E(multiset);
        Preconditions.E(collection);
        if (collection instanceof Multiset) {
            return b(multiset, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return Iterators.a(multiset, collection.iterator());
    }

    static <T> Multiset<T> d(Iterable<T> iterable) {
        return (Multiset) iterable;
    }

    @CanIgnoreReturnValue
    public static boolean e(Multiset<?> multiset, Multiset<?> multiset2) {
        Preconditions.E(multiset);
        Preconditions.E(multiset2);
        for (Multiset.Entry next : multiset2.entrySet()) {
            if (multiset.l1(next.a()) < next.getCount()) {
                return false;
            }
        }
        return true;
    }

    public static <E> ImmutableMultiset<E> f(Multiset<E> multiset) {
        Multiset.Entry[] entryArr = (Multiset.Entry[]) multiset.entrySet().toArray(new Multiset.Entry[0]);
        Arrays.sort(entryArr, DecreasingCount.s);
        return ImmutableMultiset.r(Arrays.asList(entryArr));
    }

    public static <E> Multiset<E> g(final Multiset<E> multiset, final Multiset<?> multiset2) {
        Preconditions.E(multiset);
        Preconditions.E(multiset2);
        return new ViewMultiset<E>() {
            public void clear() {
                throw new UnsupportedOperationException();
            }

            /* access modifiers changed from: package-private */
            public int d() {
                return Iterators.Z(h());
            }

            /* access modifiers changed from: package-private */
            public Iterator<E> g() {
                final Iterator it2 = Multiset.this.entrySet().iterator();
                return new AbstractIterator<E>() {
                    /* access modifiers changed from: protected */
                    @CheckForNull
                    public E a() {
                        while (it2.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry) it2.next();
                            E a2 = entry.a();
                            if (entry.getCount() > multiset2.l1(a2)) {
                                return a2;
                            }
                        }
                        return b();
                    }
                };
            }

            /* access modifiers changed from: package-private */
            public Iterator<Multiset.Entry<E>> h() {
                final Iterator it2 = Multiset.this.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>() {
                    /* access modifiers changed from: protected */
                    @CheckForNull
                    /* renamed from: d */
                    public Multiset.Entry<E> a() {
                        while (it2.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry) it2.next();
                            Object a2 = entry.a();
                            int count = entry.getCount() - multiset2.l1(a2);
                            if (count > 0) {
                                return Multisets.k(a2, count);
                            }
                        }
                        return (Multiset.Entry) b();
                    }
                };
            }

            public int l1(@CheckForNull Object obj) {
                int l1 = Multiset.this.l1(obj);
                if (l1 == 0) {
                    return 0;
                }
                return Math.max(0, l1 - multiset2.l1(obj));
            }
        };
    }

    static <E> Iterator<E> h(Iterator<Multiset.Entry<E>> it2) {
        return new TransformedIterator<Multiset.Entry<E>, E>(it2) {
            /* access modifiers changed from: package-private */
            @ParametricNullness
            /* renamed from: b */
            public E a(Multiset.Entry<E> entry) {
                return entry.a();
            }
        };
    }

    static boolean i(Multiset<?> multiset, @CheckForNull Object obj) {
        if (obj == multiset) {
            return true;
        }
        if (obj instanceof Multiset) {
            Multiset multiset2 = (Multiset) obj;
            if (multiset.size() == multiset2.size() && multiset.entrySet().size() == multiset2.entrySet().size()) {
                for (Multiset.Entry entry : multiset2.entrySet()) {
                    if (multiset.l1(entry.a()) != entry.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static <E> Multiset<E> j(Multiset<E> multiset, Predicate<? super E> predicate) {
        if (!(multiset instanceof FilteredMultiset)) {
            return new FilteredMultiset(multiset, predicate);
        }
        FilteredMultiset filteredMultiset = (FilteredMultiset) multiset;
        return new FilteredMultiset(filteredMultiset.Y, Predicates.d(filteredMultiset.Z, predicate));
    }

    public static <E> Multiset.Entry<E> k(@ParametricNullness E e2, int i2) {
        return new ImmutableEntry(e2, i2);
    }

    static int l(Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).e().size();
        }
        return 11;
    }

    public static <E> Multiset<E> m(final Multiset<E> multiset, final Multiset<?> multiset2) {
        Preconditions.E(multiset);
        Preconditions.E(multiset2);
        return new ViewMultiset<E>() {
            /* access modifiers changed from: package-private */
            public Set<E> b() {
                return Sets.n(Multiset.this.e(), multiset2.e());
            }

            /* access modifiers changed from: package-private */
            public Iterator<E> g() {
                throw new AssertionError("should never be called");
            }

            /* access modifiers changed from: package-private */
            public Iterator<Multiset.Entry<E>> h() {
                final Iterator it2 = Multiset.this.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>() {
                    /* access modifiers changed from: protected */
                    @CheckForNull
                    /* renamed from: d */
                    public Multiset.Entry<E> a() {
                        while (it2.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry) it2.next();
                            Object a2 = entry.a();
                            int min = Math.min(entry.getCount(), multiset2.l1(a2));
                            if (min > 0) {
                                return Multisets.k(a2, min);
                            }
                        }
                        return (Multiset.Entry) b();
                    }
                };
            }

            public int l1(@CheckForNull Object obj) {
                int l1 = Multiset.this.l1(obj);
                if (l1 == 0) {
                    return 0;
                }
                return Math.min(l1, multiset2.l1(obj));
            }
        };
    }

    static <E> Iterator<E> n(Multiset<E> multiset) {
        return new MultisetIteratorImpl(multiset, multiset.entrySet().iterator());
    }

    static int o(Multiset<?> multiset) {
        long j2 = 0;
        for (Multiset.Entry<?> count : multiset.entrySet()) {
            j2 += (long) count.getCount();
        }
        return Ints.z(j2);
    }

    static boolean p(Multiset<?> multiset, Collection<?> collection) {
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).e();
        }
        return multiset.e().removeAll(collection);
    }

    @CanIgnoreReturnValue
    public static boolean q(Multiset<?> multiset, Multiset<?> multiset2) {
        Preconditions.E(multiset);
        Preconditions.E(multiset2);
        Iterator<Multiset.Entry<?>> it2 = multiset.entrySet().iterator();
        boolean z = false;
        while (it2.hasNext()) {
            Multiset.Entry next = it2.next();
            int l1 = multiset2.l1(next.a());
            if (l1 >= next.getCount()) {
                it2.remove();
            } else if (l1 > 0) {
                multiset.F(next.a(), l1);
            }
            z = true;
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static boolean r(Multiset<?> multiset, Iterable<?> iterable) {
        if (iterable instanceof Multiset) {
            return q(multiset, (Multiset) iterable);
        }
        Preconditions.E(multiset);
        Preconditions.E(iterable);
        boolean z = false;
        for (Object remove : iterable) {
            z |= multiset.remove(remove);
        }
        return z;
    }

    static boolean s(Multiset<?> multiset, Collection<?> collection) {
        Preconditions.E(collection);
        if (collection instanceof Multiset) {
            collection = ((Multiset) collection).e();
        }
        return multiset.e().retainAll(collection);
    }

    @CanIgnoreReturnValue
    public static boolean t(Multiset<?> multiset, Multiset<?> multiset2) {
        return u(multiset, multiset2);
    }

    private static <E> boolean u(Multiset<E> multiset, Multiset<?> multiset2) {
        Preconditions.E(multiset);
        Preconditions.E(multiset2);
        Iterator<Multiset.Entry<E>> it2 = multiset.entrySet().iterator();
        boolean z = false;
        while (it2.hasNext()) {
            Multiset.Entry next = it2.next();
            int l1 = multiset2.l1(next.a());
            if (l1 == 0) {
                it2.remove();
            } else if (l1 < next.getCount()) {
                multiset.r0(next.a(), l1);
            }
            z = true;
        }
        return z;
    }

    static <E> int v(Multiset<E> multiset, @ParametricNullness E e2, int i2) {
        CollectPreconditions.b(i2, "count");
        int l1 = multiset.l1(e2);
        int i3 = i2 - l1;
        if (i3 > 0) {
            multiset.Q(e2, i3);
        } else if (i3 < 0) {
            multiset.F(e2, -i3);
        }
        return l1;
    }

    static <E> boolean w(Multiset<E> multiset, @ParametricNullness E e2, int i2, int i3) {
        CollectPreconditions.b(i2, "oldCount");
        CollectPreconditions.b(i3, "newCount");
        if (multiset.l1(e2) != i2) {
            return false;
        }
        multiset.r0(e2, i3);
        return true;
    }

    public static <E> Multiset<E> x(final Multiset<? extends E> multiset, final Multiset<? extends E> multiset2) {
        Preconditions.E(multiset);
        Preconditions.E(multiset2);
        return new ViewMultiset<E>() {
            /* access modifiers changed from: package-private */
            public Set<E> b() {
                return Sets.N(Multiset.this.e(), multiset2.e());
            }

            public boolean contains(@CheckForNull Object obj) {
                return Multiset.this.contains(obj) || multiset2.contains(obj);
            }

            /* access modifiers changed from: package-private */
            public Iterator<E> g() {
                throw new AssertionError("should never be called");
            }

            /* access modifiers changed from: package-private */
            public Iterator<Multiset.Entry<E>> h() {
                final Iterator it2 = Multiset.this.entrySet().iterator();
                final Iterator it3 = multiset2.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>() {
                    /* access modifiers changed from: protected */
                    @CheckForNull
                    /* renamed from: d */
                    public Multiset.Entry<E> a() {
                        if (it2.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry) it2.next();
                            Object a2 = entry.a();
                            return Multisets.k(a2, entry.getCount() + multiset2.l1(a2));
                        }
                        while (it3.hasNext()) {
                            Multiset.Entry entry2 = (Multiset.Entry) it3.next();
                            Object a3 = entry2.a();
                            if (!Multiset.this.contains(a3)) {
                                return Multisets.k(a3, entry2.getCount());
                            }
                        }
                        return (Multiset.Entry) b();
                    }
                };
            }

            public boolean isEmpty() {
                return Multiset.this.isEmpty() && multiset2.isEmpty();
            }

            public int l1(@CheckForNull Object obj) {
                return Multiset.this.l1(obj) + multiset2.l1(obj);
            }

            public int size() {
                return IntMath.t(Multiset.this.size(), multiset2.size());
            }
        };
    }

    public static <E> Multiset<E> y(final Multiset<? extends E> multiset, final Multiset<? extends E> multiset2) {
        Preconditions.E(multiset);
        Preconditions.E(multiset2);
        return new ViewMultiset<E>() {
            /* access modifiers changed from: package-private */
            public Set<E> b() {
                return Sets.N(Multiset.this.e(), multiset2.e());
            }

            public boolean contains(@CheckForNull Object obj) {
                return Multiset.this.contains(obj) || multiset2.contains(obj);
            }

            /* access modifiers changed from: package-private */
            public Iterator<E> g() {
                throw new AssertionError("should never be called");
            }

            /* access modifiers changed from: package-private */
            public Iterator<Multiset.Entry<E>> h() {
                final Iterator it2 = Multiset.this.entrySet().iterator();
                final Iterator it3 = multiset2.entrySet().iterator();
                return new AbstractIterator<Multiset.Entry<E>>() {
                    /* access modifiers changed from: protected */
                    @CheckForNull
                    /* renamed from: d */
                    public Multiset.Entry<E> a() {
                        if (it2.hasNext()) {
                            Multiset.Entry entry = (Multiset.Entry) it2.next();
                            Object a2 = entry.a();
                            return Multisets.k(a2, Math.max(entry.getCount(), multiset2.l1(a2)));
                        }
                        while (it3.hasNext()) {
                            Multiset.Entry entry2 = (Multiset.Entry) it3.next();
                            Object a3 = entry2.a();
                            if (!Multiset.this.contains(a3)) {
                                return Multisets.k(a3, entry2.getCount());
                            }
                        }
                        return (Multiset.Entry) b();
                    }
                };
            }

            public boolean isEmpty() {
                return Multiset.this.isEmpty() && multiset2.isEmpty();
            }

            public int l1(@CheckForNull Object obj) {
                return Math.max(Multiset.this.l1(obj), multiset2.l1(obj));
            }
        };
    }

    @Deprecated
    public static <E> Multiset<E> z(ImmutableMultiset<E> immutableMultiset) {
        return (Multiset) Preconditions.E(immutableMultiset);
    }
}
