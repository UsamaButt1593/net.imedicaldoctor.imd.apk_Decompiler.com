package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Iterators {

    private static final class ArrayItr<T> extends AbstractIndexedListIterator<T> {
        static final UnmodifiableListIterator<Object> X2 = new ArrayItr(new Object[0], 0, 0, 0);
        private final T[] Y;
        private final int Z;

        ArrayItr(T[] tArr, int i2, int i3, int i4) {
            super(i3, i4);
            this.Y = tArr;
            this.Z = i2;
        }

        /* access modifiers changed from: protected */
        @ParametricNullness
        public T a(int i2) {
            return this.Y[this.Z + i2];
        }
    }

    private static class ConcatenatedIterator<T> implements Iterator<T> {
        private Iterator<? extends T> X = Iterators.u();
        @CheckForNull
        private Iterator<? extends Iterator<? extends T>> Y;
        @CheckForNull
        private Deque<Iterator<? extends Iterator<? extends T>>> Z;
        @CheckForNull
        private Iterator<? extends T> s;

        ConcatenatedIterator(Iterator<? extends Iterator<? extends T>> it2) {
            this.Y = (Iterator) Preconditions.E(it2);
        }

        @CheckForNull
        private Iterator<? extends Iterator<? extends T>> a() {
            while (true) {
                Iterator<? extends Iterator<? extends T>> it2 = this.Y;
                if (it2 != null && it2.hasNext()) {
                    return this.Y;
                }
                Deque<Iterator<? extends Iterator<? extends T>>> deque = this.Z;
                if (deque == null || deque.isEmpty()) {
                    return null;
                }
                this.Y = this.Z.removeFirst();
            }
        }

        public boolean hasNext() {
            while (!((Iterator) Preconditions.E(this.X)).hasNext()) {
                Iterator<? extends Iterator<? extends T>> a2 = a();
                this.Y = a2;
                if (a2 == null) {
                    return false;
                }
                Iterator<? extends T> it2 = (Iterator) a2.next();
                this.X = it2;
                if (it2 instanceof ConcatenatedIterator) {
                    ConcatenatedIterator concatenatedIterator = (ConcatenatedIterator) it2;
                    this.X = concatenatedIterator.X;
                    if (this.Z == null) {
                        this.Z = new ArrayDeque();
                    }
                    this.Z.addFirst(this.Y);
                    if (concatenatedIterator.Z != null) {
                        while (!concatenatedIterator.Z.isEmpty()) {
                            this.Z.addFirst(concatenatedIterator.Z.removeLast());
                        }
                    }
                    this.Y = concatenatedIterator.Y;
                }
            }
            return true;
        }

        @ParametricNullness
        public T next() {
            if (hasNext()) {
                Iterator<? extends T> it2 = this.X;
                this.s = it2;
                return it2.next();
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            Iterator<? extends T> it2 = this.s;
            if (it2 != null) {
                it2.remove();
                this.s = null;
                return;
            }
            throw new IllegalStateException("no calls to next() since the last call to remove()");
        }
    }

    private enum EmptyModifiableIterator implements Iterator<Object> {
        INSTANCE;

        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }

        public void remove() {
            CollectPreconditions.e(false);
        }
    }

    private static class MergingIterator<T> extends UnmodifiableIterator<T> {
        final Queue<PeekingIterator<T>> s;

        public MergingIterator(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
            this.s = new PriorityQueue(2, new C0471f(comparator));
            for (Iterator it2 : iterable) {
                if (it2.hasNext()) {
                    this.s.add(Iterators.T(it2));
                }
            }
        }

        public boolean hasNext() {
            return !this.s.isEmpty();
        }

        @ParametricNullness
        public T next() {
            PeekingIterator remove = this.s.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.s.add(remove);
            }
            return next;
        }
    }

    private static class PeekingImpl<E> implements PeekingIterator<E> {
        private boolean X;
        @CheckForNull
        private E Y;
        private final Iterator<? extends E> s;

        public PeekingImpl(Iterator<? extends E> it2) {
            this.s = (Iterator) Preconditions.E(it2);
        }

        public boolean hasNext() {
            return this.X || this.s.hasNext();
        }

        @ParametricNullness
        public E next() {
            if (!this.X) {
                return this.s.next();
            }
            E a2 = NullnessCasts.a(this.Y);
            this.X = false;
            this.Y = null;
            return a2;
        }

        @ParametricNullness
        public E peek() {
            if (!this.X) {
                this.Y = this.s.next();
                this.X = true;
            }
            return NullnessCasts.a(this.Y);
        }

        public void remove() {
            Preconditions.h0(!this.X, "Can't remove after you've peeked at next");
            this.s.remove();
        }
    }

    private Iterators() {
    }

    @CheckForNull
    public static <T> T A(Iterator<? extends T> it2, Predicate<? super T> predicate, @CheckForNull T t) {
        Preconditions.E(it2);
        Preconditions.E(predicate);
        while (it2.hasNext()) {
            T next = it2.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        return t;
    }

    @SafeVarargs
    public static <T> UnmodifiableIterator<T> B(T... tArr) {
        return C(tArr, 0, tArr.length, 0);
    }

    static <T> UnmodifiableListIterator<T> C(T[] tArr, int i2, int i3, int i4) {
        Preconditions.d(i3 >= 0);
        Preconditions.f0(i2, i2 + i3, tArr.length);
        Preconditions.d0(i4, i3);
        return i3 == 0 ? v() : new ArrayItr(tArr, i2, i3, i4);
    }

    public static <T> UnmodifiableIterator<T> D(final Enumeration<T> enumeration) {
        Preconditions.E(enumeration);
        return new UnmodifiableIterator<T>() {
            public boolean hasNext() {
                return enumeration.hasMoreElements();
            }

            @ParametricNullness
            public T next() {
                return enumeration.nextElement();
            }
        };
    }

    public static int E(Iterator<?> it2, @CheckForNull Object obj) {
        int i2 = 0;
        while (q(it2, obj)) {
            i2++;
        }
        return i2;
    }

    @ParametricNullness
    public static <T> T F(Iterator<T> it2, int i2) {
        g(i2);
        int b2 = b(it2, i2);
        if (it2.hasNext()) {
            return it2.next();
        }
        throw new IndexOutOfBoundsException("position (" + i2 + ") must be less than the number of elements that remained (" + b2 + ")");
    }

    @ParametricNullness
    public static <T> T G(Iterator<? extends T> it2, int i2, @ParametricNullness T t) {
        g(i2);
        b(it2, i2);
        return J(it2, t);
    }

    @ParametricNullness
    public static <T> T H(Iterator<T> it2) {
        T next;
        do {
            next = it2.next();
        } while (it2.hasNext());
        return next;
    }

    @ParametricNullness
    public static <T> T I(Iterator<? extends T> it2, @ParametricNullness T t) {
        return it2.hasNext() ? H(it2) : t;
    }

    @ParametricNullness
    public static <T> T J(Iterator<? extends T> it2, @ParametricNullness T t) {
        return it2.hasNext() ? it2.next() : t;
    }

    @ParametricNullness
    public static <T> T K(Iterator<T> it2) {
        T next = it2.next();
        if (!it2.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <");
        sb.append(next);
        for (int i2 = 0; i2 < 4 && it2.hasNext(); i2++) {
            sb.append(", ");
            sb.append(it2.next());
        }
        if (it2.hasNext()) {
            sb.append(", ...");
        }
        sb.append('>');
        throw new IllegalArgumentException(sb.toString());
    }

    @ParametricNullness
    public static <T> T L(Iterator<? extends T> it2, @ParametricNullness T t) {
        return it2.hasNext() ? K(it2) : t;
    }

    public static <T> int M(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.F(predicate, "predicate");
        int i2 = 0;
        while (it2.hasNext()) {
            if (predicate.apply(it2.next())) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static <T> Iterator<T> N(final Iterator<T> it2, final int i2) {
        Preconditions.E(it2);
        Preconditions.e(i2 >= 0, "limit is negative");
        return new Iterator<T>() {
            private int s;

            public boolean hasNext() {
                return this.s < i2 && it2.hasNext();
            }

            @ParametricNullness
            public T next() {
                if (hasNext()) {
                    this.s++;
                    return it2.next();
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                it2.remove();
            }
        };
    }

    public static <T> UnmodifiableIterator<T> O(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        Preconditions.F(iterable, "iterators");
        Preconditions.F(comparator, "comparator");
        return new MergingIterator(iterable, comparator);
    }

    public static <T> UnmodifiableIterator<List<T>> P(Iterator<T> it2, int i2) {
        return R(it2, i2, true);
    }

    public static <T> UnmodifiableIterator<List<T>> Q(Iterator<T> it2, int i2) {
        return R(it2, i2, false);
    }

    private static <T> UnmodifiableIterator<List<T>> R(final Iterator<T> it2, final int i2, final boolean z) {
        Preconditions.E(it2);
        Preconditions.d(i2 > 0);
        return new UnmodifiableIterator<List<T>>() {
            /* renamed from: a */
            public List<T> next() {
                if (hasNext()) {
                    Object[] objArr = new Object[i2];
                    int i2 = 0;
                    while (i2 < i2 && it2.hasNext()) {
                        objArr[i2] = it2.next();
                        i2++;
                    }
                    for (int i3 = i2; i3 < i2; i3++) {
                        objArr[i3] = null;
                    }
                    List<T> unmodifiableList = Collections.unmodifiableList(Arrays.asList(objArr));
                    return (z || i2 == i2) ? unmodifiableList : unmodifiableList.subList(0, i2);
                }
                throw new NoSuchElementException();
            }

            public boolean hasNext() {
                return it2.hasNext();
            }
        };
    }

    @Deprecated
    public static <T> PeekingIterator<T> S(PeekingIterator<T> peekingIterator) {
        return (PeekingIterator) Preconditions.E(peekingIterator);
    }

    public static <T> PeekingIterator<T> T(Iterator<? extends T> it2) {
        return it2 instanceof PeekingImpl ? (PeekingImpl) it2 : new PeekingImpl(it2);
    }

    @CheckForNull
    static <T> T U(Iterator<T> it2) {
        if (!it2.hasNext()) {
            return null;
        }
        T next = it2.next();
        it2.remove();
        return next;
    }

    @CanIgnoreReturnValue
    public static boolean V(Iterator<?> it2, Collection<?> collection) {
        Preconditions.E(collection);
        boolean z = false;
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static <T> boolean W(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.E(predicate);
        boolean z = false;
        while (it2.hasNext()) {
            if (predicate.apply(it2.next())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    @CanIgnoreReturnValue
    public static boolean X(Iterator<?> it2, Collection<?> collection) {
        Preconditions.E(collection);
        boolean z = false;
        while (it2.hasNext()) {
            if (!collection.contains(it2.next())) {
                it2.remove();
                z = true;
            }
        }
        return z;
    }

    public static <T> UnmodifiableIterator<T> Y(@ParametricNullness final T t) {
        return new UnmodifiableIterator<T>() {
            boolean s;

            public boolean hasNext() {
                return !this.s;
            }

            @ParametricNullness
            public T next() {
                if (!this.s) {
                    this.s = true;
                    return t;
                }
                throw new NoSuchElementException();
            }
        };
    }

    public static int Z(Iterator<?> it2) {
        long j2 = 0;
        while (it2.hasNext()) {
            it2.next();
            j2++;
        }
        return Ints.z(j2);
    }

    @CanIgnoreReturnValue
    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it2) {
        Preconditions.E(collection);
        Preconditions.E(it2);
        boolean z = false;
        while (it2.hasNext()) {
            z |= collection.add(it2.next());
        }
        return z;
    }

    @GwtIncompatible
    public static <T> T[] a0(Iterator<? extends T> it2, Class<T> cls) {
        return Iterables.Q(Lists.s(it2), cls);
    }

    @CanIgnoreReturnValue
    public static int b(Iterator<?> it2, int i2) {
        Preconditions.E(it2);
        int i3 = 0;
        Preconditions.e(i2 >= 0, "numberToAdvance must be nonnegative");
        while (i3 < i2 && it2.hasNext()) {
            it2.next();
            i3++;
        }
        return i3;
    }

    public static String b0(Iterator<?> it2) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        boolean z = true;
        while (it2.hasNext()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(it2.next());
            z = false;
        }
        sb.append(']');
        return sb.toString();
    }

    public static <T> boolean c(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.E(predicate);
        while (it2.hasNext()) {
            if (!predicate.apply(it2.next())) {
                return false;
            }
        }
        return true;
    }

    public static <F, T> Iterator<T> c0(Iterator<F> it2, final Function<? super F, ? extends T> function) {
        Preconditions.E(function);
        return new TransformedIterator<F, T>(it2) {
            /* access modifiers changed from: package-private */
            @ParametricNullness
            public T a(@ParametricNullness F f2) {
                return function.apply(f2);
            }
        };
    }

    public static <T> boolean d(Iterator<T> it2, Predicate<? super T> predicate) {
        return M(it2, predicate) != -1;
    }

    public static <T> Optional<T> d0(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.E(it2);
        Preconditions.E(predicate);
        while (it2.hasNext()) {
            T next = it2.next();
            if (predicate.apply(next)) {
                return Optional.f(next);
            }
        }
        return Optional.a();
    }

    public static <T> Enumeration<T> e(final Iterator<T> it2) {
        Preconditions.E(it2);
        return new Enumeration<T>() {
            public boolean hasMoreElements() {
                return it2.hasNext();
            }

            @ParametricNullness
            public T nextElement() {
                return it2.next();
            }
        };
    }

    @Deprecated
    public static <T> UnmodifiableIterator<T> e0(UnmodifiableIterator<T> unmodifiableIterator) {
        return (UnmodifiableIterator) Preconditions.E(unmodifiableIterator);
    }

    static <T> ListIterator<T> f(Iterator<T> it2) {
        return (ListIterator) it2;
    }

    public static <T> UnmodifiableIterator<T> f0(final Iterator<? extends T> it2) {
        Preconditions.E(it2);
        return it2 instanceof UnmodifiableIterator ? (UnmodifiableIterator) it2 : new UnmodifiableIterator<T>() {
            public boolean hasNext() {
                return it2.hasNext();
            }

            @ParametricNullness
            public T next() {
                return it2.next();
            }
        };
    }

    static void g(int i2) {
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("position (" + i2 + ") must not be negative");
        }
    }

    static void h(Iterator<?> it2) {
        Preconditions.E(it2);
        while (it2.hasNext()) {
            it2.next();
            it2.remove();
        }
    }

    public static <T> Iterator<T> i(Iterator<? extends Iterator<? extends T>> it2) {
        return new ConcatenatedIterator(it2);
    }

    public static <T> Iterator<T> j(Iterator<? extends T> it2, Iterator<? extends T> it3) {
        Preconditions.E(it2);
        Preconditions.E(it3);
        return i(o(it2, it3));
    }

    public static <T> Iterator<T> k(Iterator<? extends T> it2, Iterator<? extends T> it3, Iterator<? extends T> it4) {
        Preconditions.E(it2);
        Preconditions.E(it3);
        Preconditions.E(it4);
        return i(o(it2, it3, it4));
    }

    public static <T> Iterator<T> l(Iterator<? extends T> it2, Iterator<? extends T> it3, Iterator<? extends T> it4, Iterator<? extends T> it5) {
        Preconditions.E(it2);
        Preconditions.E(it3);
        Preconditions.E(it4);
        Preconditions.E(it5);
        return i(o(it2, it3, it4, it5));
    }

    public static <T> Iterator<T> m(Iterator<? extends T>... itArr) {
        return n((Iterator[]) Arrays.copyOf(itArr, itArr.length));
    }

    static <T> Iterator<T> n(Iterator<? extends T>... itArr) {
        for (Iterator E : (Iterator[]) Preconditions.E(itArr)) {
            Preconditions.E(E);
        }
        return i(o(itArr));
    }

    private static <I extends Iterator<?>> Iterator<I> o(final I... iArr) {
        return new UnmodifiableIterator<I>() {
            int s = 0;

            /* renamed from: a */
            public I next() {
                if (hasNext()) {
                    I i2 = iArr[this.s];
                    Objects.requireNonNull(i2);
                    I i3 = (Iterator) i2;
                    Iterator[] itArr = iArr;
                    int i4 = this.s;
                    itArr[i4] = null;
                    this.s = i4 + 1;
                    return i3;
                }
                throw new NoSuchElementException();
            }

            public boolean hasNext() {
                return this.s < iArr.length;
            }
        };
    }

    public static <T> Iterator<T> p(final Iterator<T> it2) {
        Preconditions.E(it2);
        return new UnmodifiableIterator<T>() {
            public boolean hasNext() {
                return it2.hasNext();
            }

            @ParametricNullness
            public T next() {
                T next = it2.next();
                it2.remove();
                return next;
            }

            public String toString() {
                return "Iterators.consumingIterator(...)";
            }
        };
    }

    public static boolean q(Iterator<?> it2, @CheckForNull Object obj) {
        if (obj == null) {
            while (it2.hasNext()) {
                if (it2.next() == null) {
                    return true;
                }
            }
            return false;
        }
        while (it2.hasNext()) {
            if (obj.equals(it2.next())) {
                return true;
            }
        }
        return false;
    }

    public static <T> Iterator<T> r(final Iterable<T> iterable) {
        Preconditions.E(iterable);
        return new Iterator<T>() {
            Iterator<T> s = Iterators.w();

            public boolean hasNext() {
                return this.s.hasNext() || iterable.iterator().hasNext();
            }

            @ParametricNullness
            public T next() {
                if (!this.s.hasNext()) {
                    Iterator<T> it2 = iterable.iterator();
                    this.s = it2;
                    if (!it2.hasNext()) {
                        throw new NoSuchElementException();
                    }
                }
                return this.s.next();
            }

            public void remove() {
                this.s.remove();
            }
        };
    }

    @SafeVarargs
    public static <T> Iterator<T> s(T... tArr) {
        return r(Lists.t(tArr));
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0006  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean t(java.util.Iterator<?> r3, java.util.Iterator<?> r4) {
        /*
        L_0x0000:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x001d
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = com.google.common.base.Objects.a(r0, r2)
            if (r0 != 0) goto L_0x0000
            return r1
        L_0x001d:
            boolean r3 = r4.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterators.t(java.util.Iterator, java.util.Iterator):boolean");
    }

    static <T> UnmodifiableIterator<T> u() {
        return v();
    }

    static <T> UnmodifiableListIterator<T> v() {
        return ArrayItr.X2;
    }

    static <T> Iterator<T> w() {
        return EmptyModifiableIterator.INSTANCE;
    }

    public static <T> UnmodifiableIterator<T> x(final Iterator<T> it2, final Predicate<? super T> predicate) {
        Preconditions.E(it2);
        Preconditions.E(predicate);
        return new AbstractIterator<T>() {
            /* access modifiers changed from: protected */
            @CheckForNull
            public T a() {
                while (it2.hasNext()) {
                    T next = it2.next();
                    if (predicate.apply(next)) {
                        return next;
                    }
                }
                return b();
            }
        };
    }

    @GwtIncompatible
    public static <T> UnmodifiableIterator<T> y(Iterator<?> it2, Class<T> cls) {
        return x(it2, Predicates.o(cls));
    }

    @ParametricNullness
    public static <T> T z(Iterator<T> it2, Predicate<? super T> predicate) {
        Preconditions.E(it2);
        Preconditions.E(predicate);
        while (it2.hasNext()) {
            T next = it2.next();
            if (predicate.apply(next)) {
                return next;
            }
        }
        throw new NoSuchElementException();
    }
}
