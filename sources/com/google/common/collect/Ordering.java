package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class Ordering<T> implements Comparator<T> {
    static final int X = -1;
    static final int s = 1;

    @VisibleForTesting
    @J2ktIncompatible
    static class ArbitraryOrdering extends Ordering<Object> {
        private final AtomicInteger Y = new AtomicInteger(0);
        private final ConcurrentMap<Object, Integer> Z = Platform.l(new MapMaker()).i();

        ArbitraryOrdering() {
        }

        private Integer I(Object obj) {
            Integer num = this.Z.get(obj);
            if (num != null) {
                return num;
            }
            Integer valueOf = Integer.valueOf(this.Y.getAndIncrement());
            Integer putIfAbsent = this.Z.putIfAbsent(obj, valueOf);
            return putIfAbsent != null ? putIfAbsent : valueOf;
        }

        /* access modifiers changed from: package-private */
        public int J(Object obj) {
            return System.identityHashCode(obj);
        }

        public int compare(@CheckForNull Object obj, @CheckForNull Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int J = J(obj);
            int J2 = J(obj2);
            if (J != J2) {
                return J < J2 ? -1 : 1;
            }
            int compareTo = I(obj).compareTo(I(obj2));
            if (compareTo != 0) {
                return compareTo;
            }
            throw new AssertionError();
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }
    }

    @J2ktIncompatible
    private static class ArbitraryOrderingHolder {

        /* renamed from: a  reason: collision with root package name */
        static final Ordering<Object> f22492a = new ArbitraryOrdering();

        private ArbitraryOrderingHolder() {
        }
    }

    @VisibleForTesting
    static class IncomparableValueException extends ClassCastException {
        private static final long X = 0;
        final Object s;

        IncomparableValueException(Object obj) {
            super("Cannot compare value: " + obj);
            this.s = obj;
        }
    }

    protected Ordering() {
    }

    @GwtCompatible(serializable = true)
    public static Ordering<Object> H() {
        return UsingToStringOrdering.Y;
    }

    @GwtCompatible(serializable = true)
    public static Ordering<Object> a() {
        return AllEqualOrdering.Y;
    }

    @J2ktIncompatible
    public static Ordering<Object> b() {
        return ArbitraryOrderingHolder.f22492a;
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> d(Iterable<? extends Comparator<? super T>> iterable) {
        return new CompoundOrdering(iterable);
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> f(T t, T... tArr) {
        return g(Lists.c(t, tArr));
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> g(List<T> list) {
        return new ExplicitOrdering(list);
    }

    @GwtCompatible(serializable = true)
    @Deprecated
    public static <T> Ordering<T> h(Ordering<T> ordering) {
        return (Ordering) Preconditions.E(ordering);
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> i(Comparator<T> comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    @GwtCompatible(serializable = true)
    public static <C extends Comparable> Ordering<C> z() {
        return NaturalOrdering.X2;
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> A() {
        return new NullsFirstOrdering(this);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> B() {
        return new NullsLastOrdering(this);
    }

    /* access modifiers changed from: package-private */
    public <T2 extends T> Ordering<Map.Entry<T2, ?>> C() {
        return D(Maps.R());
    }

    @GwtCompatible(serializable = true)
    public <F> Ordering<F> D(Function<F, ? extends T> function) {
        return new ByFunctionOrdering(function, this);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> E() {
        return new ReverseOrdering(this);
    }

    public <E extends T> List<E> F(Iterable<E> iterable) {
        Object[] P = Iterables.P(iterable);
        Arrays.sort(P, this);
        return Lists.r(Arrays.asList(P));
    }

    @Deprecated
    public int c(List<? extends T> list, @ParametricNullness T t) {
        return Collections.binarySearch(list, t, this);
    }

    public abstract int compare(@ParametricNullness T t, @ParametricNullness T t2);

    @GwtCompatible(serializable = true)
    public <U extends T> Ordering<U> e(Comparator<? super U> comparator) {
        return new CompoundOrdering(this, (Comparator) Preconditions.E(comparator));
    }

    public <E extends T> List<E> j(Iterable<E> iterable, int i2) {
        return E().o(iterable, i2);
    }

    public <E extends T> List<E> k(Iterator<E> it2, int i2) {
        return E().p(it2, i2);
    }

    public <E extends T> ImmutableList<E> l(Iterable<E> iterable) {
        return ImmutableList.a0(this, iterable);
    }

    public boolean m(Iterable<? extends T> iterable) {
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return true;
        }
        Object next = it2.next();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            if (compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public boolean n(Iterable<? extends T> iterable) {
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return true;
        }
        Object next = it2.next();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            if (compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public <E extends T> List<E> o(Iterable<E> iterable, int i2) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (((long) collection.size()) <= ((long) i2) * 2) {
                Object[] array = collection.toArray();
                Arrays.sort(array, this);
                if (array.length > i2) {
                    array = Arrays.copyOf(array, i2);
                }
                return Collections.unmodifiableList(Arrays.asList(array));
            }
        }
        return p(iterable.iterator(), i2);
    }

    public <E extends T> List<E> p(Iterator<E> it2, int i2) {
        Preconditions.E(it2);
        CollectPreconditions.b(i2, "k");
        if (i2 == 0 || !it2.hasNext()) {
            return Collections.emptyList();
        }
        if (i2 >= 1073741823) {
            ArrayList<E> s2 = Lists.s(it2);
            Collections.sort(s2, this);
            if (s2.size() > i2) {
                s2.subList(i2, s2.size()).clear();
            }
            s2.trimToSize();
            return Collections.unmodifiableList(s2);
        }
        TopKSelector d2 = TopKSelector.d(i2, this);
        d2.g(it2);
        return d2.j();
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<Iterable<S>> q() {
        return new LexicographicalOrdering(this);
    }

    @ParametricNullness
    public <E extends T> E r(Iterable<E> iterable) {
        return u(iterable.iterator());
    }

    @ParametricNullness
    public <E extends T> E s(@ParametricNullness E e2, @ParametricNullness E e3) {
        return compare(e2, e3) >= 0 ? e2 : e3;
    }

    @ParametricNullness
    public <E extends T> E t(@ParametricNullness E e2, @ParametricNullness E e3, @ParametricNullness E e4, E... eArr) {
        E s2 = s(s(e2, e3), e4);
        for (E s3 : eArr) {
            s2 = s(s2, s3);
        }
        return s2;
    }

    @ParametricNullness
    public <E extends T> E u(Iterator<E> it2) {
        E next = it2.next();
        while (it2.hasNext()) {
            next = s(next, it2.next());
        }
        return next;
    }

    @ParametricNullness
    public <E extends T> E v(Iterable<E> iterable) {
        return y(iterable.iterator());
    }

    @ParametricNullness
    public <E extends T> E w(@ParametricNullness E e2, @ParametricNullness E e3) {
        return compare(e2, e3) <= 0 ? e2 : e3;
    }

    @ParametricNullness
    public <E extends T> E x(@ParametricNullness E e2, @ParametricNullness E e3, @ParametricNullness E e4, E... eArr) {
        E w = w(w(e2, e3), e4);
        for (E w2 : eArr) {
            w = w(w, w2);
        }
        return w;
    }

    @ParametricNullness
    public <E extends T> E y(Iterator<E> it2) {
        E next = it2.next();
        while (it2.hasNext()) {
            next = w(next, it2.next());
        }
        return next;
    }
}
