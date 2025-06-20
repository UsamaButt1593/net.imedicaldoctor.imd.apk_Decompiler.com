package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
final class CartesianList<E> extends AbstractList<List<E>> implements RandomAccess {
    private final transient int[] X;
    /* access modifiers changed from: private */
    public final transient ImmutableList<List<E>> s;

    CartesianList(ImmutableList<List<E>> immutableList) {
        this.s = immutableList;
        int[] iArr = new int[(immutableList.size() + 1)];
        iArr[immutableList.size()] = 1;
        try {
            for (int size = immutableList.size() - 1; size >= 0; size--) {
                iArr[size] = IntMath.d(iArr[size + 1], immutableList.get(size).size());
            }
            this.X = iArr;
        } catch (ArithmeticException unused) {
            throw new IllegalArgumentException("Cartesian product too large; must have size at most Integer.MAX_VALUE");
        }
    }

    static <E> List<List<E>> d(List<? extends List<? extends E>> list) {
        ImmutableList.Builder builder = new ImmutableList.Builder(list.size());
        for (List B : list) {
            ImmutableList B2 = ImmutableList.B(B);
            if (B2.isEmpty()) {
                return ImmutableList.I();
            }
            builder.g(B2);
        }
        return new CartesianList(builder.e());
    }

    /* access modifiers changed from: private */
    public int h(int i2, int i3) {
        return (i2 / this.X[i3 + 1]) % this.s.get(i3).size();
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

    /* renamed from: g */
    public ImmutableList<E> get(final int i2) {
        Preconditions.C(i2, size());
        return new ImmutableList<E>() {
            public E get(int i2) {
                Preconditions.C(i2, size());
                return ((List) CartesianList.this.s.get(i2)).get(CartesianList.this.h(i2, i2));
            }

            /* access modifiers changed from: package-private */
            public boolean j() {
                return true;
            }

            public int size() {
                return CartesianList.this.s.size();
            }
        };
    }

    public int indexOf(@CheckForNull Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        if (list.size() != this.s.size()) {
            return -1;
        }
        ListIterator listIterator = list.listIterator();
        int i2 = 0;
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            int indexOf = this.s.get(nextIndex).indexOf(listIterator.next());
            if (indexOf == -1) {
                return -1;
            }
            i2 += indexOf * this.X[nextIndex + 1];
        }
        return i2;
    }

    public int lastIndexOf(@CheckForNull Object obj) {
        if (!(obj instanceof List)) {
            return -1;
        }
        List list = (List) obj;
        if (list.size() != this.s.size()) {
            return -1;
        }
        ListIterator listIterator = list.listIterator();
        int i2 = 0;
        while (listIterator.hasNext()) {
            int nextIndex = listIterator.nextIndex();
            int lastIndexOf = this.s.get(nextIndex).lastIndexOf(listIterator.next());
            if (lastIndexOf == -1) {
                return -1;
            }
            i2 += lastIndexOf * this.X[nextIndex + 1];
        }
        return i2;
    }

    public int size() {
        return this.X[0];
    }
}
