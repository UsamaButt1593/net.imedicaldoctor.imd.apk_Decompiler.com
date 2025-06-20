package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Iterables {

    private static final class UnmodifiableIterable<T> extends FluentIterable<T> {
        private final Iterable<? extends T> X;

        private UnmodifiableIterable(Iterable<? extends T> iterable) {
            this.X = iterable;
        }

        public Iterator<T> iterator() {
            return Iterators.f0(this.X.iterator());
        }

        public String toString() {
            return this.X.toString();
        }
    }

    private Iterables() {
    }

    @ParametricNullness
    public static <T> T A(Iterable<? extends T> iterable, @ParametricNullness T t) {
        return Iterators.L(iterable.iterator(), t);
    }

    public static <T> int B(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.M(iterable.iterator(), predicate);
    }

    public static boolean C(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).isEmpty() : !iterable.iterator().hasNext();
    }

    public static <T> Iterable<T> D(final Iterable<T> iterable, final int i2) {
        Preconditions.E(iterable);
        Preconditions.e(i2 >= 0, "limit is negative");
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                return Iterators.N(iterable.iterator(), i2);
            }
        };
    }

    public static <T> Iterable<T> E(final Iterable<? extends Iterable<? extends T>> iterable, final Comparator<? super T> comparator) {
        Preconditions.F(iterable, "iterables");
        Preconditions.F(comparator, "comparator");
        return new UnmodifiableIterable(new FluentIterable<T>() {
            public Iterator<T> iterator() {
                return Iterators.O(Iterables.T(iterable, new C0469d()), comparator);
            }
        });
    }

    public static <T> Iterable<List<T>> F(final Iterable<T> iterable, final int i2) {
        Preconditions.E(iterable);
        Preconditions.d(i2 > 0);
        return new FluentIterable<List<T>>() {
            public Iterator<List<T>> iterator() {
                return Iterators.P(iterable.iterator(), i2);
            }
        };
    }

    public static <T> Iterable<List<T>> G(final Iterable<T> iterable, final int i2) {
        Preconditions.E(iterable);
        Preconditions.d(i2 > 0);
        return new FluentIterable<List<T>>() {
            public Iterator<List<T>> iterator() {
                return Iterators.Q(iterable.iterator(), i2);
            }
        };
    }

    @CanIgnoreReturnValue
    public static boolean H(Iterable<?> iterable, Collection<?> collection) {
        return iterable instanceof Collection ? ((Collection) iterable).removeAll((Collection) Preconditions.E(collection)) : Iterators.V(iterable.iterator(), collection);
    }

    @CheckForNull
    static <T> T I(Iterable<T> iterable, Predicate<? super T> predicate) {
        Preconditions.E(predicate);
        Iterator<T> it2 = iterable.iterator();
        while (it2.hasNext()) {
            T next = it2.next();
            if (predicate.apply(next)) {
                it2.remove();
                return next;
            }
        }
        return null;
    }

    @CanIgnoreReturnValue
    public static <T> boolean J(Iterable<T> iterable, Predicate<? super T> predicate) {
        return (!(iterable instanceof RandomAccess) || !(iterable instanceof List)) ? Iterators.W(iterable.iterator(), predicate) : K((List) iterable, (Predicate) Preconditions.E(predicate));
    }

    private static <T> boolean K(List<T> list, Predicate<? super T> predicate) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < list.size()) {
            T t = list.get(i2);
            if (!predicate.apply(t)) {
                if (i2 > i3) {
                    try {
                        list.set(i3, t);
                    } catch (UnsupportedOperationException unused) {
                        O(list, predicate, i3, i2);
                        return true;
                    } catch (IllegalArgumentException unused2) {
                        O(list, predicate, i3, i2);
                        return true;
                    }
                }
                i3++;
            }
            i2++;
        }
        list.subList(i3, list.size()).clear();
        return i2 != i3;
    }

    @CanIgnoreReturnValue
    public static boolean L(Iterable<?> iterable, Collection<?> collection) {
        return iterable instanceof Collection ? ((Collection) iterable).retainAll((Collection) Preconditions.E(collection)) : Iterators.X(iterable.iterator(), collection);
    }

    public static int M(Iterable<?> iterable) {
        return iterable instanceof Collection ? ((Collection) iterable).size() : Iterators.Z(iterable.iterator());
    }

    public static <T> Iterable<T> N(final Iterable<T> iterable, final int i2) {
        Preconditions.E(iterable);
        Preconditions.e(i2 >= 0, "number to skip cannot be negative");
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                Iterable iterable = iterable;
                if (iterable instanceof List) {
                    List list = (List) iterable;
                    return list.subList(Math.min(list.size(), i2), list.size()).iterator();
                }
                final Iterator it2 = iterable.iterator();
                Iterators.b(it2, i2);
                return new Iterator<T>(this) {
                    boolean s = true;

                    public boolean hasNext() {
                        return it2.hasNext();
                    }

                    @ParametricNullness
                    public T next() {
                        T next = it2.next();
                        this.s = false;
                        return next;
                    }

                    public void remove() {
                        CollectPreconditions.e(!this.s);
                        it2.remove();
                    }
                };
            }
        };
    }

    private static <T> void O(List<T> list, Predicate<? super T> predicate, int i2, int i3) {
        for (int size = list.size() - 1; size > i3; size--) {
            if (predicate.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            list.remove(i4);
        }
    }

    static Object[] P(Iterable<?> iterable) {
        return d(iterable).toArray();
    }

    @GwtIncompatible
    public static <T> T[] Q(Iterable<? extends T> iterable, Class<T> cls) {
        return R(iterable, ObjectArrays.i(cls, 0));
    }

    static <T> T[] R(Iterable<? extends T> iterable, T[] tArr) {
        return d(iterable).toArray(tArr);
    }

    public static String S(Iterable<?> iterable) {
        return Iterators.b0(iterable.iterator());
    }

    public static <F, T> Iterable<T> T(final Iterable<F> iterable, final Function<? super F, ? extends T> function) {
        Preconditions.E(iterable);
        Preconditions.E(function);
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                return Iterators.c0(iterable.iterator(), function);
            }
        };
    }

    public static <T> Optional<T> U(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.d0(iterable.iterator(), predicate);
    }

    @Deprecated
    public static <E> Iterable<E> V(ImmutableCollection<E> immutableCollection) {
        return (Iterable) Preconditions.E(immutableCollection);
    }

    public static <T> Iterable<T> W(Iterable<? extends T> iterable) {
        Preconditions.E(iterable);
        return ((iterable instanceof UnmodifiableIterable) || (iterable instanceof ImmutableCollection)) ? iterable : new UnmodifiableIterable(iterable);
    }

    @CanIgnoreReturnValue
    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        return iterable instanceof Collection ? collection.addAll((Collection) iterable) : Iterators.a(collection, ((Iterable) Preconditions.E(iterable)).iterator());
    }

    public static <T> boolean b(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.c(iterable.iterator(), predicate);
    }

    public static <T> boolean c(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.d(iterable.iterator(), predicate);
    }

    private static <E> Collection<E> d(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : Lists.s(iterable.iterator());
    }

    public static <T> Iterable<T> e(Iterable<? extends Iterable<? extends T>> iterable) {
        return FluentIterable.h(iterable);
    }

    public static <T> Iterable<T> f(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return FluentIterable.j(iterable, iterable2);
    }

    public static <T> Iterable<T> g(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return FluentIterable.k(iterable, iterable2, iterable3);
    }

    public static <T> Iterable<T> h(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return FluentIterable.m(iterable, iterable2, iterable3, iterable4);
    }

    @SafeVarargs
    public static <T> Iterable<T> i(Iterable<? extends T>... iterableArr) {
        return FluentIterable.n(iterableArr);
    }

    public static <T> Iterable<T> j(final Iterable<T> iterable) {
        Preconditions.E(iterable);
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                Iterable iterable = iterable;
                return iterable instanceof Queue ? new ConsumingQueueIterator((Queue) iterable) : Iterators.p(iterable.iterator());
            }

            public String toString() {
                return "Iterables.consumingIterable(...)";
            }
        };
    }

    public static boolean k(Iterable<? extends Object> iterable, @CheckForNull Object obj) {
        return iterable instanceof Collection ? Collections2.j((Collection) iterable, obj) : Iterators.q(iterable.iterator(), obj);
    }

    public static <T> Iterable<T> l(final Iterable<T> iterable) {
        Preconditions.E(iterable);
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                return Iterators.r(iterable);
            }

            public String toString() {
                return iterable.toString() + " (cycled)";
            }
        };
    }

    @SafeVarargs
    public static <T> Iterable<T> m(T... tArr) {
        return l(Lists.t(tArr));
    }

    public static boolean n(Iterable<?> iterable, Iterable<?> iterable2) {
        if (!(iterable instanceof Collection) || !(iterable2 instanceof Collection) || ((Collection) iterable).size() == ((Collection) iterable2).size()) {
            return Iterators.t(iterable.iterator(), iterable2.iterator());
        }
        return false;
    }

    public static <T> Iterable<T> o(final Iterable<T> iterable, final Predicate<? super T> predicate) {
        Preconditions.E(iterable);
        Preconditions.E(predicate);
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                return Iterators.x(iterable.iterator(), predicate);
            }
        };
    }

    @GwtIncompatible
    public static <T> Iterable<T> p(Iterable<?> iterable, Class<T> cls) {
        Preconditions.E(iterable);
        Preconditions.E(cls);
        return o(iterable, Predicates.o(cls));
    }

    @ParametricNullness
    public static <T> T q(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.z(iterable.iterator(), predicate);
    }

    @CheckForNull
    public static <T> T r(Iterable<? extends T> iterable, Predicate<? super T> predicate, @CheckForNull T t) {
        return Iterators.A(iterable.iterator(), predicate, t);
    }

    public static int s(Iterable<?> iterable, @CheckForNull Object obj) {
        if (iterable instanceof Multiset) {
            return ((Multiset) iterable).l1(obj);
        }
        if (iterable instanceof Set) {
            return ((Set) iterable).contains(obj) ? 1 : 0;
        }
        return Iterators.E(iterable.iterator(), obj);
    }

    @ParametricNullness
    public static <T> T t(Iterable<T> iterable, int i2) {
        Preconditions.E(iterable);
        return iterable instanceof List ? ((List) iterable).get(i2) : Iterators.F(iterable.iterator(), i2);
    }

    @ParametricNullness
    public static <T> T u(Iterable<? extends T> iterable, int i2, @ParametricNullness T t) {
        Preconditions.E(iterable);
        Iterators.g(i2);
        if (iterable instanceof List) {
            List<? extends T> f2 = Lists.f(iterable);
            return i2 < f2.size() ? f2.get(i2) : t;
        }
        Iterator<? extends T> it2 = iterable.iterator();
        Iterators.b(it2, i2);
        return Iterators.J(it2, t);
    }

    @ParametricNullness
    public static <T> T v(Iterable<? extends T> iterable, @ParametricNullness T t) {
        return Iterators.J(iterable.iterator(), t);
    }

    @ParametricNullness
    public static <T> T w(Iterable<T> iterable) {
        if (!(iterable instanceof List)) {
            return Iterators.H(iterable.iterator());
        }
        List list = (List) iterable;
        if (!list.isEmpty()) {
            return y(list);
        }
        throw new NoSuchElementException();
    }

    @ParametricNullness
    public static <T> T x(Iterable<? extends T> iterable, @ParametricNullness T t) {
        if (iterable instanceof Collection) {
            if (((Collection) iterable).isEmpty()) {
                return t;
            }
            if (iterable instanceof List) {
                return y(Lists.f(iterable));
            }
        }
        return Iterators.I(iterable.iterator(), t);
    }

    @ParametricNullness
    private static <T> T y(List<T> list) {
        return list.get(list.size() - 1);
    }

    @ParametricNullness
    public static <T> T z(Iterable<T> iterable) {
        return Iterators.K(iterable.iterator());
    }
}
