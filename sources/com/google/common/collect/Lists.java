package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Lists {

    private static class AbstractListWrapper<E> extends AbstractList<E> {
        final List<E> s;

        AbstractListWrapper(List<E> list) {
            this.s = (List) Preconditions.E(list);
        }

        public void add(int i2, @ParametricNullness E e2) {
            this.s.add(i2, e2);
        }

        public boolean addAll(int i2, Collection<? extends E> collection) {
            return this.s.addAll(i2, collection);
        }

        public boolean contains(@CheckForNull Object obj) {
            return this.s.contains(obj);
        }

        @ParametricNullness
        public E get(int i2) {
            return this.s.get(i2);
        }

        @ParametricNullness
        public E remove(int i2) {
            return this.s.remove(i2);
        }

        @ParametricNullness
        public E set(int i2, @ParametricNullness E e2) {
            return this.s.set(i2, e2);
        }

        public int size() {
            return this.s.size();
        }
    }

    private static final class CharSequenceAsList extends AbstractList<Character> {
        private final CharSequence s;

        CharSequenceAsList(CharSequence charSequence) {
            this.s = charSequence;
        }

        /* renamed from: b */
        public Character get(int i2) {
            Preconditions.C(i2, size());
            return Character.valueOf(this.s.charAt(i2));
        }

        public int size() {
            return this.s.length();
        }
    }

    private static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        @J2ktIncompatible
        private static final long Y = 0;
        final E[] X;
        @ParametricNullness
        final E s;

        OnePlusArrayList(@ParametricNullness E e2, E[] eArr) {
            this.s = e2;
            this.X = (Object[]) Preconditions.E(eArr);
        }

        @ParametricNullness
        public E get(int i2) {
            Preconditions.C(i2, size());
            return i2 == 0 ? this.s : this.X[i2 - 1];
        }

        public int size() {
            return IntMath.t(this.X.length, 1);
        }
    }

    private static class Partition<T> extends AbstractList<List<T>> {
        final int X;
        final List<T> s;

        Partition(List<T> list, int i2) {
            this.s = list;
            this.X = i2;
        }

        /* renamed from: b */
        public List<T> get(int i2) {
            Preconditions.C(i2, size());
            int i3 = this.X;
            int i4 = i2 * i3;
            return this.s.subList(i4, Math.min(i3 + i4, this.s.size()));
        }

        public boolean isEmpty() {
            return this.s.isEmpty();
        }

        public int size() {
            return IntMath.g(this.s.size(), this.X, RoundingMode.CEILING);
        }
    }

    private static class RandomAccessListWrapper<E> extends AbstractListWrapper<E> implements RandomAccess {
        RandomAccessListWrapper(List<E> list) {
            super(list);
        }
    }

    private static class RandomAccessPartition<T> extends Partition<T> implements RandomAccess {
        RandomAccessPartition(List<T> list, int i2) {
            super(list, i2);
        }
    }

    private static class RandomAccessReverseList<T> extends ReverseList<T> implements RandomAccess {
        RandomAccessReverseList(List<T> list) {
            super(list);
        }
    }

    private static class ReverseList<T> extends AbstractList<T> {
        private final List<T> s;

        ReverseList(List<T> list) {
            this.s = (List) Preconditions.E(list);
        }

        private int d(int i2) {
            int size = size();
            Preconditions.C(i2, size);
            return (size - 1) - i2;
        }

        /* access modifiers changed from: private */
        public int g(int i2) {
            int size = size();
            Preconditions.d0(i2, size);
            return size - i2;
        }

        public void add(int i2, @ParametricNullness T t) {
            this.s.add(g(i2), t);
        }

        /* access modifiers changed from: package-private */
        public List<T> c() {
            return this.s;
        }

        public void clear() {
            this.s.clear();
        }

        @ParametricNullness
        public T get(int i2) {
            return this.s.get(d(i2));
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i2) {
            final ListIterator<T> listIterator = this.s.listIterator(g(i2));
            return new ListIterator<T>() {
                boolean s;

                public void add(@ParametricNullness T t) {
                    listIterator.add(t);
                    listIterator.previous();
                    this.s = false;
                }

                public boolean hasNext() {
                    return listIterator.hasPrevious();
                }

                public boolean hasPrevious() {
                    return listIterator.hasNext();
                }

                @ParametricNullness
                public T next() {
                    if (hasNext()) {
                        this.s = true;
                        return listIterator.previous();
                    }
                    throw new NoSuchElementException();
                }

                public int nextIndex() {
                    return ReverseList.this.g(listIterator.nextIndex());
                }

                @ParametricNullness
                public T previous() {
                    if (hasPrevious()) {
                        this.s = true;
                        return listIterator.next();
                    }
                    throw new NoSuchElementException();
                }

                public int previousIndex() {
                    return nextIndex() - 1;
                }

                public void remove() {
                    CollectPreconditions.e(this.s);
                    listIterator.remove();
                    this.s = false;
                }

                public void set(@ParametricNullness T t) {
                    Preconditions.g0(this.s);
                    listIterator.set(t);
                }
            };
        }

        @ParametricNullness
        public T remove(int i2) {
            return this.s.remove(d(i2));
        }

        /* access modifiers changed from: protected */
        public void removeRange(int i2, int i3) {
            subList(i2, i3).clear();
        }

        @ParametricNullness
        public T set(int i2, @ParametricNullness T t) {
            return this.s.set(d(i2), t);
        }

        public int size() {
            return this.s.size();
        }

        public List<T> subList(int i2, int i3) {
            Preconditions.f0(i2, i3, size());
            return Lists.B(this.s.subList(g(i3), g(i2)));
        }
    }

    private static final class StringAsImmutableList extends ImmutableList<Character> {
        private final String Y;

        StringAsImmutableList(String str) {
            this.Y = str;
        }

        /* renamed from: b0 */
        public ImmutableList<Character> subList(int i2, int i3) {
            Preconditions.f0(i2, i3, size());
            return Lists.g(this.Y.substring(i2, i3));
        }

        /* renamed from: e0 */
        public Character get(int i2) {
            Preconditions.C(i2, size());
            return Character.valueOf(this.Y.charAt(i2));
        }

        public int indexOf(@CheckForNull Object obj) {
            if (obj instanceof Character) {
                return this.Y.indexOf(((Character) obj).charValue());
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return false;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Character) {
                return this.Y.lastIndexOf(((Character) obj).charValue());
            }
            return -1;
        }

        public int size() {
            return this.Y.length();
        }
    }

    private static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long Y = 0;
        final Function<? super F, ? extends T> X;
        final List<F> s;

        TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function) {
            this.s = (List) Preconditions.E(list);
            this.X = (Function) Preconditions.E(function);
        }

        @ParametricNullness
        public T get(int i2) {
            return this.X.apply(this.s.get(i2));
        }

        public boolean isEmpty() {
            return this.s.isEmpty();
        }

        public Iterator<T> iterator() {
            return listIterator();
        }

        public ListIterator<T> listIterator(int i2) {
            return new TransformedListIterator<F, T>(this.s.listIterator(i2)) {
                /* access modifiers changed from: package-private */
                public T a(F f2) {
                    return TransformingRandomAccessList.this.X.apply(f2);
                }
            };
        }

        public T remove(int i2) {
            return this.X.apply(this.s.remove(i2));
        }

        /* access modifiers changed from: protected */
        public void removeRange(int i2, int i3) {
            this.s.subList(i2, i3).clear();
        }

        public int size() {
            return this.s.size();
        }
    }

    private static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long Y = 0;
        final Function<? super F, ? extends T> X;
        final List<F> s;

        TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function) {
            this.s = (List) Preconditions.E(list);
            this.X = (Function) Preconditions.E(function);
        }

        public ListIterator<T> listIterator(int i2) {
            return new TransformedListIterator<F, T>(this.s.listIterator(i2)) {
                /* access modifiers changed from: package-private */
                @ParametricNullness
                public T a(@ParametricNullness F f2) {
                    return TransformingSequentialList.this.X.apply(f2);
                }
            };
        }

        /* access modifiers changed from: protected */
        public void removeRange(int i2, int i3) {
            this.s.subList(i2, i3).clear();
        }

        public int size() {
            return this.s.size();
        }
    }

    private static class TwoPlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        @J2ktIncompatible
        private static final long Z = 0;
        @ParametricNullness
        final E X;
        final E[] Y;
        @ParametricNullness
        final E s;

        TwoPlusArrayList(@ParametricNullness E e2, @ParametricNullness E e3, E[] eArr) {
            this.s = e2;
            this.X = e3;
            this.Y = (Object[]) Preconditions.E(eArr);
        }

        @ParametricNullness
        public E get(int i2) {
            if (i2 == 0) {
                return this.s;
            }
            if (i2 == 1) {
                return this.X;
            }
            Preconditions.C(i2, size());
            return this.Y[i2 - 2];
        }

        public int size() {
            return IntMath.t(this.Y.length, 2);
        }
    }

    private Lists() {
    }

    public static <T> List<List<T>> A(List<T> list, int i2) {
        Preconditions.E(list);
        Preconditions.d(i2 > 0);
        return list instanceof RandomAccess ? new RandomAccessPartition(list, i2) : new Partition(list, i2);
    }

    public static <T> List<T> B(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).Y();
        }
        if (list instanceof ReverseList) {
            return ((ReverseList) list).c();
        }
        return list instanceof RandomAccess ? new RandomAccessReverseList(list) : new ReverseList(list);
    }

    static <E> List<E> C(List<E> list, int i2, int i3) {
        return (list instanceof RandomAccess ? new RandomAccessListWrapper<E>(list) {
            @J2ktIncompatible
            private static final long X = 0;

            public ListIterator<E> listIterator(int i2) {
                return this.s.listIterator(i2);
            }
        } : new AbstractListWrapper<E>(list) {
            @J2ktIncompatible
            private static final long X = 0;

            public ListIterator<E> listIterator(int i2) {
                return this.s.listIterator(i2);
            }
        }).subList(i2, i3);
    }

    public static <F, T> List<T> D(List<F> list, Function<? super F, ? extends T> function) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, function) : new TransformingSequentialList(list, function);
    }

    static <E> boolean a(List<E> list, int i2, Iterable<? extends E> iterable) {
        ListIterator<E> listIterator = list.listIterator(i2);
        boolean z = false;
        for (Object add : iterable) {
            listIterator.add(add);
            z = true;
        }
        return z;
    }

    public static <E> List<E> b(@ParametricNullness E e2, @ParametricNullness E e3, E[] eArr) {
        return new TwoPlusArrayList(e2, e3, eArr);
    }

    public static <E> List<E> c(@ParametricNullness E e2, E[] eArr) {
        return new OnePlusArrayList(e2, eArr);
    }

    public static <B> List<List<B>> d(List<? extends List<? extends B>> list) {
        return CartesianList.d(list);
    }

    @SafeVarargs
    public static <B> List<List<B>> e(List<? extends B>... listArr) {
        return d(Arrays.asList(listArr));
    }

    static <T> List<T> f(Iterable<T> iterable) {
        return (List) iterable;
    }

    public static ImmutableList<Character> g(String str) {
        return new StringAsImmutableList((String) Preconditions.E(str));
    }

    public static List<Character> h(CharSequence charSequence) {
        return new CharSequenceAsList((CharSequence) Preconditions.E(charSequence));
    }

    @VisibleForTesting
    static int i(int i2) {
        CollectPreconditions.b(i2, "arraySize");
        return Ints.z(((long) i2) + 5 + ((long) (i2 / 10)));
    }

    static boolean j(List<?> list, @CheckForNull Object obj) {
        if (obj == Preconditions.E(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if (!(list instanceof RandomAccess) || !(list2 instanceof RandomAccess)) {
            return Iterators.t(list.iterator(), list2.iterator());
        }
        for (int i2 = 0; i2 < size; i2++) {
            if (!Objects.a(list.get(i2), list2.get(i2))) {
                return false;
            }
        }
        return true;
    }

    static int k(List<?> list) {
        Iterator<?> it2 = list.iterator();
        int i2 = 1;
        while (it2.hasNext()) {
            Object next = it2.next();
            i2 = ~(~((i2 * 31) + (next == null ? 0 : next.hashCode())));
        }
        return i2;
    }

    static int l(List<?> list, @CheckForNull Object obj) {
        if (list instanceof RandomAccess) {
            return m(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int m(List<?> list, @CheckForNull Object obj) {
        int size = list.size();
        int i2 = 0;
        if (obj == null) {
            while (i2 < size) {
                if (list.get(i2) == null) {
                    return i2;
                }
                i2++;
            }
            return -1;
        }
        while (i2 < size) {
            if (obj.equals(list.get(i2))) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    static int n(List<?> list, @CheckForNull Object obj) {
        if (list instanceof RandomAccess) {
            return o(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Objects.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int o(List<?> list, @CheckForNull Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    static <E> ListIterator<E> p(List<E> list, int i2) {
        return new AbstractListWrapper(list).listIterator(i2);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> q() {
        return new ArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> r(Iterable<? extends E> iterable) {
        Preconditions.E(iterable);
        return iterable instanceof Collection ? new ArrayList<>((Collection) iterable) : s(iterable.iterator());
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> s(Iterator<? extends E> it2) {
        ArrayList<E> q = q();
        Iterators.a(q, it2);
        return q;
    }

    @GwtCompatible(serializable = true)
    @SafeVarargs
    public static <E> ArrayList<E> t(E... eArr) {
        Preconditions.E(eArr);
        ArrayList<E> arrayList = new ArrayList<>(i(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> u(int i2) {
        CollectPreconditions.b(i2, "initialArraySize");
        return new ArrayList<>(i2);
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> v(int i2) {
        return new ArrayList<>(i(i2));
    }

    @GwtIncompatible
    @J2ktIncompatible
    public static <E> CopyOnWriteArrayList<E> w() {
        return new CopyOnWriteArrayList<>();
    }

    /* JADX WARNING: type inference failed for: r1v0, types: [java.lang.Iterable<? extends E>, java.lang.Iterable] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.google.common.annotations.GwtIncompatible
    @com.google.common.annotations.J2ktIncompatible
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <E> java.util.concurrent.CopyOnWriteArrayList<E> x(java.lang.Iterable<? extends E> r1) {
        /*
            boolean r0 = r1 instanceof java.util.Collection
            if (r0 == 0) goto L_0x0007
            java.util.Collection r1 = (java.util.Collection) r1
            goto L_0x000b
        L_0x0007:
            java.util.ArrayList r1 = r(r1)
        L_0x000b:
            java.util.concurrent.CopyOnWriteArrayList r0 = new java.util.concurrent.CopyOnWriteArrayList
            r0.<init>(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Lists.x(java.lang.Iterable):java.util.concurrent.CopyOnWriteArrayList");
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> y() {
        return new LinkedList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> LinkedList<E> z(Iterable<? extends E> iterable) {
        LinkedList<E> y = y();
        Iterables.a(y, iterable);
        return y;
    }
}
