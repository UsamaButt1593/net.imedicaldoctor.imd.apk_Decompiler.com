package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Comparators {
    private Comparators() {
    }

    public static <T> boolean a(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.E(comparator);
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return true;
        }
        Object next = it2.next();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            if (comparator.compare(next, next2) > 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T> boolean b(Iterable<? extends T> iterable, Comparator<T> comparator) {
        Preconditions.E(comparator);
        Iterator<? extends T> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return true;
        }
        Object next = it2.next();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            if (comparator.compare(next, next2) >= 0) {
                return false;
            }
            next = next2;
        }
        return true;
    }

    public static <T, S extends T> Comparator<Iterable<S>> c(Comparator<T> comparator) {
        return new LexicographicalOrdering((Comparator) Preconditions.E(comparator));
    }

    public static <T extends Comparable<? super T>> T d(T t, T t2) {
        return t.compareTo(t2) >= 0 ? t : t2;
    }

    @ParametricNullness
    public static <T> T e(@ParametricNullness T t, @ParametricNullness T t2, Comparator<T> comparator) {
        return comparator.compare(t, t2) >= 0 ? t : t2;
    }

    public static <T extends Comparable<? super T>> T f(T t, T t2) {
        return t.compareTo(t2) <= 0 ? t : t2;
    }

    @ParametricNullness
    public static <T> T g(@ParametricNullness T t, @ParametricNullness T t2, Comparator<T> comparator) {
        return comparator.compare(t, t2) <= 0 ? t : t2;
    }
}
