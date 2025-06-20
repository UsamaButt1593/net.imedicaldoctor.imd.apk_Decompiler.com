package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotCall;
import com.google.errorprone.annotations.InlineMe;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    private static final UnmodifiableListIterator<Object> X = new Itr(RegularImmutableList.X2, 0);

    public static final class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        public Builder() {
            this(4);
        }

        @CanIgnoreReturnValue
        /* renamed from: j */
        public Builder<E> g(E e2) {
            super.a(e2);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: k */
        public Builder<E> b(E... eArr) {
            super.b(eArr);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: l */
        public Builder<E> c(Iterable<? extends E> iterable) {
            super.c(iterable);
            return this;
        }

        @CanIgnoreReturnValue
        /* renamed from: m */
        public Builder<E> d(Iterator<? extends E> it2) {
            super.d(it2);
            return this;
        }

        /* renamed from: n */
        public ImmutableList<E> e() {
            this.f22388d = true;
            return ImmutableList.q(this.f22386b, this.f22387c);
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public Builder<E> o(Builder<E> builder) {
            h(builder.f22386b, builder.f22387c);
            return this;
        }

        Builder(int i2) {
            super(i2);
        }
    }

    static class Itr<E> extends AbstractIndexedListIterator<E> {
        private final ImmutableList<E> Y;

        Itr(ImmutableList<E> immutableList, int i2) {
            super(immutableList.size(), i2);
            this.Y = immutableList;
        }

        /* access modifiers changed from: protected */
        public E a(int i2) {
            return this.Y.get(i2);
        }
    }

    private static class ReverseImmutableList<E> extends ImmutableList<E> {
        private final transient ImmutableList<E> Y;

        ReverseImmutableList(ImmutableList<E> immutableList) {
            this.Y = immutableList;
        }

        private int e0(int i2) {
            return (size() - 1) - i2;
        }

        private int f0(int i2) {
            return size() - i2;
        }

        public ImmutableList<E> Y() {
            return this.Y;
        }

        /* renamed from: b0 */
        public ImmutableList<E> subList(int i2, int i3) {
            Preconditions.f0(i2, i3, size());
            return this.Y.subList(f0(i3), f0(i2)).Y();
        }

        public boolean contains(@CheckForNull Object obj) {
            return this.Y.contains(obj);
        }

        public E get(int i2) {
            Preconditions.C(i2, size());
            return this.Y.get(e0(i2));
        }

        public int indexOf(@CheckForNull Object obj) {
            int lastIndexOf = this.Y.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return e0(lastIndexOf);
            }
            return -1;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return ImmutableList.super.iterator();
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return this.Y.j();
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            int indexOf = this.Y.indexOf(obj);
            if (indexOf >= 0) {
                return e0(indexOf);
            }
            return -1;
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return ImmutableList.super.listIterator();
        }

        public int size() {
            return this.Y.size();
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator(int i2) {
            return ImmutableList.super.listIterator(i2);
        }
    }

    @J2ktIncompatible
    static class SerializedForm implements Serializable {
        private static final long X = 0;
        final Object[] s;

        SerializedForm(Object[] objArr) {
            this.s = objArr;
        }

        /* access modifiers changed from: package-private */
        public Object a() {
            return ImmutableList.D(this.s);
        }
    }

    class SubList extends ImmutableList<E> {
        final transient int Y;
        final transient int Z;

        SubList(int i2, int i3) {
            this.Y = i2;
            this.Z = i3;
        }

        /* renamed from: b0 */
        public ImmutableList<E> subList(int i2, int i3) {
            Preconditions.f0(i2, i3, this.Z);
            ImmutableList immutableList = ImmutableList.this;
            int i4 = this.Y;
            return immutableList.subList(i2 + i4, i3 + i4);
        }

        /* access modifiers changed from: package-private */
        @CheckForNull
        public Object[] d() {
            return ImmutableList.this.d();
        }

        /* access modifiers changed from: package-private */
        public int g() {
            return ImmutableList.this.h() + this.Y + this.Z;
        }

        public E get(int i2) {
            Preconditions.C(i2, this.Z);
            return ImmutableList.this.get(i2 + this.Y);
        }

        /* access modifiers changed from: package-private */
        public int h() {
            return ImmutableList.this.h() + this.Y;
        }

        public /* bridge */ /* synthetic */ Iterator iterator() {
            return ImmutableList.super.iterator();
        }

        /* access modifiers changed from: package-private */
        public boolean j() {
            return true;
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return ImmutableList.super.listIterator();
        }

        public int size() {
            return this.Z;
        }

        public /* bridge */ /* synthetic */ ListIterator listIterator(int i2) {
            return ImmutableList.super.listIterator(i2);
        }
    }

    ImmutableList() {
    }

    public static <E> ImmutableList<E> B(Collection<? extends E> collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return x(collection.toArray());
        }
        ImmutableList<E> b2 = ((ImmutableCollection) collection).b();
        return b2.j() ? o(b2.toArray()) : b2;
    }

    public static <E> ImmutableList<E> C(Iterator<? extends E> it2) {
        if (!it2.hasNext()) {
            return I();
        }
        Object next = it2.next();
        return !it2.hasNext() ? K(next) : new Builder().g(next).d(it2).e();
    }

    public static <E> ImmutableList<E> D(E[] eArr) {
        return eArr.length == 0 ? I() : x((Object[]) eArr.clone());
    }

    public static <E> ImmutableList<E> I() {
        return RegularImmutableList.X2;
    }

    public static <E> ImmutableList<E> K(E e2) {
        return x(e2);
    }

    public static <E> ImmutableList<E> L(E e2, E e3) {
        return x(e2, e3);
    }

    public static <E> ImmutableList<E> M(E e2, E e3, E e4) {
        return x(e2, e3, e4);
    }

    public static <E> ImmutableList<E> N(E e2, E e3, E e4, E e5) {
        return x(e2, e3, e4, e5);
    }

    public static <E> ImmutableList<E> O(E e2, E e3, E e4, E e5, E e6) {
        return x(e2, e3, e4, e5, e6);
    }

    public static <E> ImmutableList<E> P(E e2, E e3, E e4, E e5, E e6, E e7) {
        return x(e2, e3, e4, e5, e6, e7);
    }

    public static <E> ImmutableList<E> R(E e2, E e3, E e4, E e5, E e6, E e7, E e8) {
        return x(e2, e3, e4, e5, e6, e7, e8);
    }

    public static <E> ImmutableList<E> T(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9) {
        return x(e2, e3, e4, e5, e6, e7, e8, e9);
    }

    public static <E> ImmutableList<E> U(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10) {
        return x(e2, e3, e4, e5, e6, e7, e8, e9, e10);
    }

    public static <E> ImmutableList<E> V(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11) {
        return x(e2, e3, e4, e5, e6, e7, e8, e9, e10, e11);
    }

    public static <E> ImmutableList<E> W(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12) {
        return x(e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);
    }

    @SafeVarargs
    public static <E> ImmutableList<E> X(E e2, E e3, E e4, E e5, E e6, E e7, E e8, E e9, E e10, E e11, E e12, E e13, E... eArr) {
        E[] eArr2 = eArr;
        Preconditions.e(eArr2.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr = new Object[(eArr2.length + 12)];
        objArr[0] = e2;
        objArr[1] = e3;
        objArr[2] = e4;
        objArr[3] = e5;
        objArr[4] = e6;
        objArr[5] = e7;
        objArr[6] = e8;
        objArr[7] = e9;
        objArr[8] = e10;
        objArr[9] = e11;
        objArr[10] = e12;
        objArr[11] = e13;
        System.arraycopy(eArr2, 0, objArr, 12, eArr2.length);
        return x(objArr);
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> Z(Iterable<? extends E> iterable) {
        Comparable[] comparableArr = (Comparable[]) Iterables.R(iterable, new Comparable[0]);
        ObjectArrays.b(comparableArr);
        Arrays.sort(comparableArr);
        return o(comparableArr);
    }

    public static <E> ImmutableList<E> a0(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Preconditions.E(comparator);
        Object[] P = Iterables.P(iterable);
        ObjectArrays.b(P);
        Arrays.sort(P, comparator);
        return o(P);
    }

    @J2ktIncompatible
    private void m(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    static <E> ImmutableList<E> o(Object[] objArr) {
        return q(objArr, objArr.length);
    }

    static <E> ImmutableList<E> q(Object[] objArr, int i2) {
        return i2 == 0 ? I() : new RegularImmutableList(objArr, i2);
    }

    public static <E> Builder<E> r() {
        return new Builder<>();
    }

    public static <E> Builder<E> t(int i2) {
        CollectPreconditions.b(i2, "expectedSize");
        return new Builder<>(i2);
    }

    private static <E> ImmutableList<E> x(Object... objArr) {
        return o(ObjectArrays.b(objArr));
    }

    public static <E> ImmutableList<E> z(Iterable<? extends E> iterable) {
        Preconditions.E(iterable);
        return iterable instanceof Collection ? B((Collection) iterable) : C(iterable.iterator());
    }

    /* renamed from: E */
    public UnmodifiableListIterator<E> listIterator() {
        return listIterator(0);
    }

    /* renamed from: H */
    public UnmodifiableListIterator<E> listIterator(int i2) {
        Preconditions.d0(i2, size());
        return isEmpty() ? X : new Itr(this, i2);
    }

    public ImmutableList<E> Y() {
        return size() <= 1 ? this : new ReverseImmutableList(this);
    }

    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final void add(int i2, E e2) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final boolean addAll(int i2, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @InlineMe(replacement = "this")
    @Deprecated
    public final ImmutableList<E> b() {
        return this;
    }

    /* renamed from: b0 */
    public ImmutableList<E> subList(int i2, int i3) {
        Preconditions.f0(i2, i3, size());
        int i4 = i3 - i2;
        if (i4 == size()) {
            return this;
        }
        return i4 == 0 ? I() : d0(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i2) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            objArr[i2 + i3] = get(i3);
        }
        return i2 + size;
    }

    public boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<E> d0(int i2, int i3) {
        return new SubList(i2, i3 - i2);
    }

    public boolean equals(@CheckForNull Object obj) {
        return Lists.j(this, obj);
    }

    public int hashCode() {
        int size = size();
        int i2 = 1;
        for (int i3 = 0; i3 < size; i3++) {
            i2 = ~(~((i2 * 31) + get(i3).hashCode()));
        }
        return i2;
    }

    public int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.l(this, obj);
    }

    /* renamed from: k */
    public UnmodifiableIterator<E> iterator() {
        return listIterator();
    }

    public int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.n(this, obj);
    }

    /* access modifiers changed from: package-private */
    @J2ktIncompatible
    public Object n() {
        return new SerializedForm(toArray());
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final E remove(int i2) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @DoNotCall("Always throws UnsupportedOperationException")
    @Deprecated
    public final E set(int i2, E e2) {
        throw new UnsupportedOperationException();
    }
}
