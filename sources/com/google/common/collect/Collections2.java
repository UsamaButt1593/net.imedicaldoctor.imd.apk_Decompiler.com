package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class Collections2 {

    static class FilteredCollection<E> extends AbstractCollection<E> {
        final Predicate<? super E> X;
        final Collection<E> s;

        FilteredCollection(Collection<E> collection, Predicate<? super E> predicate) {
            this.s = collection;
            this.X = predicate;
        }

        public boolean add(@ParametricNullness E e2) {
            Preconditions.d(this.X.apply(e2));
            return this.s.add(e2);
        }

        public boolean addAll(Collection<? extends E> collection) {
            for (Object apply : collection) {
                Preconditions.d(this.X.apply(apply));
            }
            return this.s.addAll(collection);
        }

        /* access modifiers changed from: package-private */
        public FilteredCollection<E> b(Predicate<? super E> predicate) {
            return new FilteredCollection<>(this.s, Predicates.d(this.X, predicate));
        }

        public void clear() {
            Iterables.J(this.s, this.X);
        }

        public boolean contains(@CheckForNull Object obj) {
            if (Collections2.j(this.s, obj)) {
                return this.X.apply(obj);
            }
            return false;
        }

        public boolean containsAll(Collection<?> collection) {
            return Collections2.b(this, collection);
        }

        public boolean isEmpty() {
            return !Iterables.c(this.s, this.X);
        }

        public Iterator<E> iterator() {
            return Iterators.x(this.s.iterator(), this.X);
        }

        public boolean remove(@CheckForNull Object obj) {
            return contains(obj) && this.s.remove(obj);
        }

        public boolean removeAll(Collection<?> collection) {
            Iterator<E> it2 = this.s.iterator();
            boolean z = false;
            while (it2.hasNext()) {
                E next = it2.next();
                if (this.X.apply(next) && collection.contains(next)) {
                    it2.remove();
                    z = true;
                }
            }
            return z;
        }

        public boolean retainAll(Collection<?> collection) {
            Iterator<E> it2 = this.s.iterator();
            boolean z = false;
            while (it2.hasNext()) {
                E next = it2.next();
                if (this.X.apply(next) && !collection.contains(next)) {
                    it2.remove();
                    z = true;
                }
            }
            return z;
        }

        public int size() {
            int i2 = 0;
            for (E apply : this.s) {
                if (this.X.apply(apply)) {
                    i2++;
                }
            }
            return i2;
        }

        public Object[] toArray() {
            return Lists.s(iterator()).toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return Lists.s(iterator()).toArray(tArr);
        }
    }

    private static final class OrderedPermutationCollection<E> extends AbstractCollection<List<E>> {
        final Comparator<? super E> X;
        final int Y;
        final ImmutableList<E> s;

        OrderedPermutationCollection(Iterable<E> iterable, Comparator<? super E> comparator) {
            ImmutableList<E> a0 = ImmutableList.a0(comparator, iterable);
            this.s = a0;
            this.X = comparator;
            this.Y = b(a0, comparator);
        }

        private static <E> int b(List<E> list, Comparator<? super E> comparator) {
            int i2 = 1;
            int i3 = 1;
            int i4 = 1;
            while (i2 < list.size()) {
                if (comparator.compare(list.get(i2 - 1), list.get(i2)) < 0) {
                    i3 = IntMath.u(i3, IntMath.a(i2, i4));
                    if (i3 == Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                    i4 = 0;
                }
                i2++;
                i4++;
            }
            return IntMath.u(i3, IntMath.a(i2, i4));
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.e(this.s, (List) obj);
        }

        public boolean isEmpty() {
            return false;
        }

        public Iterator<List<E>> iterator() {
            return new OrderedPermutationIterator(this.s, this.X);
        }

        public int size() {
            return this.Y;
        }

        public String toString() {
            return "orderedPermutationCollection(" + this.s + ")";
        }
    }

    private static final class OrderedPermutationIterator<E> extends AbstractIterator<List<E>> {
        @CheckForNull
        List<E> Y;
        final Comparator<? super E> Z;

        OrderedPermutationIterator(List<E> list, Comparator<? super E> comparator) {
            this.Y = Lists.r(list);
            this.Z = comparator;
        }

        /* access modifiers changed from: package-private */
        public void d() {
            int f2 = f();
            if (f2 == -1) {
                this.Y = null;
                return;
            }
            Objects.requireNonNull(this.Y);
            Collections.swap(this.Y, f2, g(f2));
            Collections.reverse(this.Y.subList(f2 + 1, this.Y.size()));
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        /* renamed from: e */
        public List<E> a() {
            List<E> list = this.Y;
            if (list == null) {
                return (List) b();
            }
            ImmutableList<E> B = ImmutableList.B(list);
            d();
            return B;
        }

        /* access modifiers changed from: package-private */
        public int f() {
            Objects.requireNonNull(this.Y);
            for (int size = this.Y.size() - 2; size >= 0; size--) {
                if (this.Z.compare(this.Y.get(size), this.Y.get(size + 1)) < 0) {
                    return size;
                }
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public int g(int i2) {
            Objects.requireNonNull(this.Y);
            E e2 = this.Y.get(i2);
            for (int size = this.Y.size() - 1; size > i2; size--) {
                if (this.Z.compare(e2, this.Y.get(size)) < 0) {
                    return size;
                }
            }
            throw new AssertionError("this statement should be unreachable");
        }
    }

    private static final class PermutationCollection<E> extends AbstractCollection<List<E>> {
        final ImmutableList<E> s;

        PermutationCollection(ImmutableList<E> immutableList) {
            this.s = immutableList;
        }

        public boolean contains(@CheckForNull Object obj) {
            if (!(obj instanceof List)) {
                return false;
            }
            return Collections2.e(this.s, (List) obj);
        }

        public boolean isEmpty() {
            return false;
        }

        public Iterator<List<E>> iterator() {
            return new PermutationIterator(this.s);
        }

        public int size() {
            return IntMath.h(this.s.size());
        }

        public String toString() {
            return "permutations(" + this.s + ")";
        }
    }

    private static class PermutationIterator<E> extends AbstractIterator<List<E>> {
        final int[] X2;
        final List<E> Y;
        int Y2 = Integer.MAX_VALUE;
        final int[] Z;

        PermutationIterator(List<E> list) {
            this.Y = new ArrayList(list);
            int size = list.size();
            int[] iArr = new int[size];
            this.Z = iArr;
            int[] iArr2 = new int[size];
            this.X2 = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 1);
        }

        /* access modifiers changed from: package-private */
        public void d() {
            int size = this.Y.size() - 1;
            this.Y2 = size;
            if (size != -1) {
                int i2 = 0;
                while (true) {
                    int[] iArr = this.Z;
                    int i3 = this.Y2;
                    int i4 = iArr[i3];
                    int i5 = this.X2[i3] + i4;
                    if (i5 >= 0) {
                        if (i5 != i3 + 1) {
                            Collections.swap(this.Y, (i3 - i4) + i2, (i3 - i5) + i2);
                            this.Z[this.Y2] = i5;
                            return;
                        } else if (i3 != 0) {
                            i2++;
                        } else {
                            return;
                        }
                    }
                    f();
                }
            }
        }

        /* access modifiers changed from: protected */
        @CheckForNull
        /* renamed from: e */
        public List<E> a() {
            if (this.Y2 <= 0) {
                return (List) b();
            }
            ImmutableList<E> B = ImmutableList.B(this.Y);
            d();
            return B;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            int[] iArr = this.X2;
            int i2 = this.Y2;
            iArr[i2] = -iArr[i2];
            this.Y2 = i2 - 1;
        }
    }

    static class TransformedCollection<F, T> extends AbstractCollection<T> {
        final Function<? super F, ? extends T> X;
        final Collection<F> s;

        TransformedCollection(Collection<F> collection, Function<? super F, ? extends T> function) {
            this.s = (Collection) Preconditions.E(collection);
            this.X = (Function) Preconditions.E(function);
        }

        public void clear() {
            this.s.clear();
        }

        public boolean isEmpty() {
            return this.s.isEmpty();
        }

        public Iterator<T> iterator() {
            return Iterators.c0(this.s.iterator(), this.X);
        }

        public int size() {
            return this.s.size();
        }
    }

    private Collections2() {
    }

    static boolean b(Collection<?> collection, Collection<?> collection2) {
        for (Object contains : collection2) {
            if (!collection.contains(contains)) {
                return false;
            }
        }
        return true;
    }

    private static <E> ObjectCountHashMap<E> c(Collection<E> collection) {
        ObjectCountHashMap<E> objectCountHashMap = new ObjectCountHashMap<>();
        for (E next : collection) {
            objectCountHashMap.v(next, objectCountHashMap.g(next) + 1);
        }
        return objectCountHashMap;
    }

    public static <E> Collection<E> d(Collection<E> collection, Predicate<? super E> predicate) {
        return collection instanceof FilteredCollection ? ((FilteredCollection) collection).b(predicate) : new FilteredCollection((Collection) Preconditions.E(collection), (Predicate) Preconditions.E(predicate));
    }

    /* access modifiers changed from: private */
    public static boolean e(List<?> list, List<?> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        ObjectCountHashMap<?> c2 = c(list);
        ObjectCountHashMap<?> c3 = c(list2);
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (c2.l(i2) != c3.g(c2.j(i2))) {
                return false;
            }
        }
        return true;
    }

    static StringBuilder f(int i2) {
        CollectPreconditions.b(i2, "size");
        return new StringBuilder((int) Math.min(((long) i2) * 8, 1073741824));
    }

    public static <E extends Comparable<? super E>> Collection<List<E>> g(Iterable<E> iterable) {
        return h(iterable, Ordering.z());
    }

    public static <E> Collection<List<E>> h(Iterable<E> iterable, Comparator<? super E> comparator) {
        return new OrderedPermutationCollection(iterable, comparator);
    }

    public static <E> Collection<List<E>> i(Collection<E> collection) {
        return new PermutationCollection(ImmutableList.B(collection));
    }

    static boolean j(Collection<?> collection, @CheckForNull Object obj) {
        Preconditions.E(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static boolean k(Collection<?> collection, @CheckForNull Object obj) {
        Preconditions.E(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    static String l(Collection<?> collection) {
        StringBuilder f2 = f(collection.size());
        f2.append('[');
        boolean z = true;
        for (Object next : collection) {
            if (!z) {
                f2.append(", ");
            }
            if (next == collection) {
                f2.append("(this Collection)");
            } else {
                f2.append(next);
            }
            z = false;
        }
        f2.append(']');
        return f2.toString();
    }

    public static <F, T> Collection<T> m(Collection<F> collection, Function<? super F, T> function) {
        return new TransformedCollection(collection, function);
    }
}
