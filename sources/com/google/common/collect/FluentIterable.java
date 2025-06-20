package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.InlineMe;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public abstract class FluentIterable<E> implements Iterable<E> {
    private final Optional<Iterable<E>> s;

    private static class FromIterableFunction<E> implements Function<Iterable<E>, FluentIterable<E>> {
        private FromIterableFunction() {
        }

        /* renamed from: a */
        public FluentIterable<E> apply(Iterable<E> iterable) {
            return FluentIterable.D(iterable);
        }
    }

    protected FluentIterable() {
        this.s = Optional.a();
    }

    @InlineMe(replacement = "checkNotNull(iterable)", staticImports = {"com.google.common.base.Preconditions.checkNotNull"})
    @Deprecated
    public static <E> FluentIterable<E> C(FluentIterable<E> fluentIterable) {
        return (FluentIterable) Preconditions.E(fluentIterable);
    }

    public static <E> FluentIterable<E> D(final Iterable<E> iterable) {
        return iterable instanceof FluentIterable ? (FluentIterable) iterable : new FluentIterable<E>(iterable) {
            public Iterator<E> iterator() {
                return iterable.iterator();
            }
        };
    }

    public static <E> FluentIterable<E> E(E[] eArr) {
        return D(Arrays.asList(eArr));
    }

    private Iterable<E> G() {
        return this.s.i(this);
    }

    public static <E> FluentIterable<E> M() {
        return D(Collections.emptyList());
    }

    public static <E> FluentIterable<E> N(@ParametricNullness E e2, E... eArr) {
        return D(Lists.c(e2, eArr));
    }

    public static <T> FluentIterable<T> h(final Iterable<? extends Iterable<? extends T>> iterable) {
        Preconditions.E(iterable);
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                return Iterators.i(Iterators.c0(iterable.iterator(), new C0469d()));
            }
        };
    }

    public static <T> FluentIterable<T> j(Iterable<? extends T> iterable, Iterable<? extends T> iterable2) {
        return o(iterable, iterable2);
    }

    public static <T> FluentIterable<T> k(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return o(iterable, iterable2, iterable3);
    }

    public static <T> FluentIterable<T> m(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3, Iterable<? extends T> iterable4) {
        return o(iterable, iterable2, iterable3, iterable4);
    }

    public static <T> FluentIterable<T> n(Iterable<? extends T>... iterableArr) {
        return o((Iterable[]) Arrays.copyOf(iterableArr, iterableArr.length));
    }

    private static <T> FluentIterable<T> o(final Iterable<? extends T>... iterableArr) {
        for (Iterable<? extends T> E : iterableArr) {
            Preconditions.E(E);
        }
        return new FluentIterable<T>() {
            public Iterator<T> iterator() {
                return Iterators.i(new AbstractIndexedListIterator<Iterator<? extends T>>(iterableArr.length) {
                    /* renamed from: b */
                    public Iterator<? extends T> a(int i2) {
                        return iterableArr[i2].iterator();
                    }
                });
            }
        };
    }

    public final Optional<E> B(Predicate<? super E> predicate) {
        return Iterables.U(G(), predicate);
    }

    public final <K> ImmutableListMultimap<K, E> H(Function<? super E, K> function) {
        return Multimaps.r(G(), function);
    }

    public final String I(Joiner joiner) {
        return joiner.k(this);
    }

    public final Optional<E> K() {
        Object next;
        Object last;
        Iterable G = G();
        if (G instanceof List) {
            List list = (List) G;
            if (list.isEmpty()) {
                return Optional.a();
            }
            last = list.get(list.size() - 1);
        } else {
            Iterator it2 = G.iterator();
            if (!it2.hasNext()) {
                return Optional.a();
            }
            if (G instanceof SortedSet) {
                last = ((SortedSet) G).last();
            } else {
                do {
                    next = it2.next();
                } while (it2.hasNext());
                return Optional.f(next);
            }
        }
        return Optional.f(last);
    }

    public final FluentIterable<E> L(int i2) {
        return D(Iterables.D(G(), i2));
    }

    public final FluentIterable<E> O(int i2) {
        return D(Iterables.N(G(), i2));
    }

    @GwtIncompatible
    public final E[] P(Class<E> cls) {
        return Iterables.Q(G(), cls);
    }

    public final ImmutableList<E> R() {
        return ImmutableList.z(G());
    }

    public final <V> ImmutableMap<E, V> T(Function<? super E, V> function) {
        return Maps.u0(G(), function);
    }

    public final ImmutableMultiset<E> U() {
        return ImmutableMultiset.t(G());
    }

    public final ImmutableSet<E> V() {
        return ImmutableSet.B(G());
    }

    public final ImmutableList<E> W(Comparator<? super E> comparator) {
        return Ordering.i(comparator).l(G());
    }

    public final ImmutableSortedSet<E> X(Comparator<? super E> comparator) {
        return ImmutableSortedSet.j0(comparator, G());
    }

    public final <T> FluentIterable<T> Y(Function<? super E, T> function) {
        return D(Iterables.T(G(), function));
    }

    public <T> FluentIterable<T> Z(Function<? super E, ? extends Iterable<? extends T>> function) {
        return h(Y(function));
    }

    public final <K> ImmutableMap<K, E> a0(Function<? super E, K> function) {
        return Maps.E0(G(), function);
    }

    public final boolean b(Predicate<? super E> predicate) {
        return Iterables.b(G(), predicate);
    }

    public final boolean c(Predicate<? super E> predicate) {
        return Iterables.c(G(), predicate);
    }

    public final boolean contains(@CheckForNull Object obj) {
        return Iterables.k(G(), obj);
    }

    public final FluentIterable<E> d(Iterable<? extends E> iterable) {
        return j(G(), iterable);
    }

    public final FluentIterable<E> g(E... eArr) {
        return j(G(), Arrays.asList(eArr));
    }

    @ParametricNullness
    public final E get(int i2) {
        return Iterables.t(G(), i2);
    }

    public final boolean isEmpty() {
        return !G().iterator().hasNext();
    }

    @CanIgnoreReturnValue
    public final <C extends Collection<? super E>> C q(C c2) {
        Preconditions.E(c2);
        Iterable<Object> G = G();
        if (G instanceof Collection) {
            c2.addAll((Collection) G);
        } else {
            for (Object add : G) {
                c2.add(add);
            }
        }
        return c2;
    }

    public final FluentIterable<E> r() {
        return D(Iterables.l(G()));
    }

    public final int size() {
        return Iterables.M(G());
    }

    public final FluentIterable<E> t(Predicate<? super E> predicate) {
        return D(Iterables.o(G(), predicate));
    }

    public String toString() {
        return Iterables.S(G());
    }

    @GwtIncompatible
    public final <T> FluentIterable<T> x(Class<T> cls) {
        return D(Iterables.p(G(), cls));
    }

    public final Optional<E> z() {
        Iterator it2 = G().iterator();
        return it2.hasNext() ? Optional.f(it2.next()) : Optional.a();
    }

    FluentIterable(Iterable<E> iterable) {
        this.s = Optional.f(iterable);
    }
}
