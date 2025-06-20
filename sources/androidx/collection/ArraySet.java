package androidx.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.dd.plist.ASCIIPropertyListParser;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;

public final class ArraySet<E> implements Collection<E>, Set<E> {
    private static final String X2 = "ArraySet";
    private static final int Y2 = 4;
    private static final boolean Z = false;
    private static final int Z2 = 10;
    @Nullable
    private static Object[] a3;
    private static int b3;
    @Nullable
    private static Object[] c3;
    private static int d3;
    private static final Object e3 = new Object();
    private static final Object f3 = new Object();
    Object[] X;
    int Y;
    private int[] s;

    private class ElementIterator extends IndexBasedArrayIterator<E> {
        ElementIterator() {
            super(ArraySet.this.Y);
        }

        /* access modifiers changed from: protected */
        public E a(int i2) {
            return ArraySet.this.o(i2);
        }

        /* access modifiers changed from: protected */
        public void b(int i2) {
            ArraySet.this.n(i2);
        }
    }

    public ArraySet() {
        this(0);
    }

    private void c(int i2) {
        if (i2 == 8) {
            synchronized (f3) {
                try {
                    Object[] objArr = c3;
                    if (objArr != null) {
                        try {
                            this.X = objArr;
                            c3 = (Object[]) objArr[0];
                            int[] iArr = (int[]) objArr[1];
                            this.s = iArr;
                            if (iArr != null) {
                                objArr[1] = null;
                                objArr[0] = null;
                                d3--;
                                return;
                            }
                        } catch (ClassCastException unused) {
                        }
                        System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + objArr[0] + " [1]=" + objArr[1]);
                        c3 = null;
                        d3 = 0;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (i2 == 4) {
            synchronized (e3) {
                try {
                    Object[] objArr2 = a3;
                    if (objArr2 != null) {
                        try {
                            this.X = objArr2;
                            a3 = (Object[]) objArr2[0];
                            int[] iArr2 = (int[]) objArr2[1];
                            this.s = iArr2;
                            if (iArr2 != null) {
                                objArr2[1] = null;
                                objArr2[0] = null;
                                b3--;
                                return;
                            }
                        } catch (ClassCastException unused2) {
                        }
                        System.out.println("ArraySet Found corrupt ArraySet cache: [0]=" + objArr2[0] + " [1]=" + objArr2[1]);
                        a3 = null;
                        b3 = 0;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        this.s = new int[i2];
        this.X = new Object[i2];
    }

    private int d(int i2) {
        try {
            return ContainerHelpers.a(this.s, this.Y, i2);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    private static void h(int[] iArr, Object[] objArr, int i2) {
        if (iArr.length == 8) {
            synchronized (f3) {
                try {
                    if (d3 < 10) {
                        objArr[0] = c3;
                        objArr[1] = iArr;
                        for (int i3 = i2 - 1; i3 >= 2; i3--) {
                            objArr[i3] = null;
                        }
                        c3 = objArr;
                        d3++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (iArr.length == 4) {
            synchronized (e3) {
                try {
                    if (b3 < 10) {
                        objArr[0] = a3;
                        objArr[1] = iArr;
                        for (int i4 = i2 - 1; i4 >= 2; i4--) {
                            objArr[i4] = null;
                        }
                        a3 = objArr;
                        b3++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    private int j(Object obj, int i2) {
        int i3 = this.Y;
        if (i3 == 0) {
            return -1;
        }
        int d2 = d(i2);
        if (d2 < 0 || obj.equals(this.X[d2])) {
            return d2;
        }
        int i4 = d2 + 1;
        while (i4 < i3 && this.s[i4] == i2) {
            if (obj.equals(this.X[i4])) {
                return i4;
            }
            i4++;
        }
        int i5 = d2 - 1;
        while (i5 >= 0 && this.s[i5] == i2) {
            if (obj.equals(this.X[i5])) {
                return i5;
            }
            i5--;
        }
        return ~i4;
    }

    private int k() {
        int i2 = this.Y;
        if (i2 == 0) {
            return -1;
        }
        int d2 = d(0);
        if (d2 < 0 || this.X[d2] == null) {
            return d2;
        }
        int i3 = d2 + 1;
        while (i3 < i2 && this.s[i3] == 0) {
            if (this.X[i3] == null) {
                return i3;
            }
            i3++;
        }
        int i4 = d2 - 1;
        while (i4 >= 0 && this.s[i4] == 0) {
            if (this.X[i4] == null) {
                return i4;
            }
            i4--;
        }
        return ~i3;
    }

    public boolean add(@Nullable E e2) {
        int i2;
        int i3;
        int i4 = this.Y;
        if (e2 == null) {
            i3 = k();
            i2 = 0;
        } else {
            int hashCode = e2.hashCode();
            i2 = hashCode;
            i3 = j(e2, hashCode);
        }
        if (i3 >= 0) {
            return false;
        }
        int i5 = ~i3;
        int[] iArr = this.s;
        if (i4 >= iArr.length) {
            int i6 = 8;
            if (i4 >= 8) {
                i6 = (i4 >> 1) + i4;
            } else if (i4 < 4) {
                i6 = 4;
            }
            Object[] objArr = this.X;
            c(i6);
            if (i4 == this.Y) {
                int[] iArr2 = this.s;
                if (iArr2.length > 0) {
                    System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                    System.arraycopy(objArr, 0, this.X, 0, objArr.length);
                }
                h(iArr, objArr, i4);
            } else {
                throw new ConcurrentModificationException();
            }
        }
        if (i5 < i4) {
            int[] iArr3 = this.s;
            int i7 = i5 + 1;
            int i8 = i4 - i5;
            System.arraycopy(iArr3, i5, iArr3, i7, i8);
            Object[] objArr2 = this.X;
            System.arraycopy(objArr2, i5, objArr2, i7, i8);
        }
        int i9 = this.Y;
        if (i4 == i9) {
            int[] iArr4 = this.s;
            if (i5 < iArr4.length) {
                iArr4[i5] = i2;
                this.X[i5] = e2;
                this.Y = i9 + 1;
                return true;
            }
        }
        throw new ConcurrentModificationException();
    }

    public boolean addAll(@NonNull Collection<? extends E> collection) {
        g(this.Y + collection.size());
        boolean z = false;
        for (Object add : collection) {
            z |= add(add);
        }
        return z;
    }

    public void b(@NonNull ArraySet<? extends E> arraySet) {
        int i2 = arraySet.Y;
        g(this.Y + i2);
        if (this.Y != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                add(arraySet.o(i3));
            }
        } else if (i2 > 0) {
            System.arraycopy(arraySet.s, 0, this.s, 0, i2);
            System.arraycopy(arraySet.X, 0, this.X, 0, i2);
            if (this.Y == 0) {
                this.Y = i2;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public void clear() {
        int i2 = this.Y;
        if (i2 != 0) {
            int[] iArr = this.s;
            Object[] objArr = this.X;
            this.s = ContainerHelpers.f3550a;
            this.X = ContainerHelpers.f3552c;
            this.Y = 0;
            h(iArr, objArr, i2);
        }
        if (this.Y != 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean contains(@Nullable Object obj) {
        return indexOf(obj) >= 0;
    }

    public boolean containsAll(@NonNull Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            if (size() != set.size()) {
                return false;
            }
            int i2 = 0;
            while (i2 < this.Y) {
                try {
                    if (!set.contains(o(i2))) {
                        return false;
                    }
                    i2++;
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
            return true;
        }
        return false;
    }

    public void g(int i2) {
        int i3 = this.Y;
        int[] iArr = this.s;
        if (iArr.length < i2) {
            Object[] objArr = this.X;
            c(i2);
            int i4 = this.Y;
            if (i4 > 0) {
                System.arraycopy(iArr, 0, this.s, 0, i4);
                System.arraycopy(objArr, 0, this.X, 0, this.Y);
            }
            h(iArr, objArr, this.Y);
        }
        if (this.Y != i3) {
            throw new ConcurrentModificationException();
        }
    }

    public int hashCode() {
        int[] iArr = this.s;
        int i2 = this.Y;
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            i3 += iArr[i4];
        }
        return i3;
    }

    public int indexOf(@Nullable Object obj) {
        return obj == null ? k() : j(obj, obj.hashCode());
    }

    public boolean isEmpty() {
        return this.Y <= 0;
    }

    @NonNull
    public Iterator<E> iterator() {
        return new ElementIterator();
    }

    public boolean m(@NonNull ArraySet<? extends E> arraySet) {
        int i2 = arraySet.Y;
        int i3 = this.Y;
        for (int i4 = 0; i4 < i2; i4++) {
            remove(arraySet.o(i4));
        }
        return i3 != this.Y;
    }

    public E n(int i2) {
        int i3 = this.Y;
        E[] eArr = this.X;
        E e2 = eArr[i2];
        if (i3 <= 1) {
            clear();
        } else {
            int i4 = i3 - 1;
            int[] iArr = this.s;
            int i5 = 8;
            if (iArr.length <= 8 || i3 >= iArr.length / 3) {
                if (i2 < i4) {
                    int i6 = i2 + 1;
                    int i7 = i4 - i2;
                    System.arraycopy(iArr, i6, iArr, i2, i7);
                    Object[] objArr = this.X;
                    System.arraycopy(objArr, i6, objArr, i2, i7);
                }
                this.X[i4] = null;
            } else {
                if (i3 > 8) {
                    i5 = i3 + (i3 >> 1);
                }
                c(i5);
                if (i2 > 0) {
                    System.arraycopy(iArr, 0, this.s, 0, i2);
                    System.arraycopy(eArr, 0, this.X, 0, i2);
                }
                if (i2 < i4) {
                    int i8 = i2 + 1;
                    int i9 = i4 - i2;
                    System.arraycopy(iArr, i8, this.s, i2, i9);
                    System.arraycopy(eArr, i8, this.X, i2, i9);
                }
            }
            if (i3 == this.Y) {
                this.Y = i4;
            } else {
                throw new ConcurrentModificationException();
            }
        }
        return e2;
    }

    public E o(int i2) {
        return this.X[i2];
    }

    public boolean remove(@Nullable Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf < 0) {
            return false;
        }
        n(indexOf);
        return true;
    }

    public boolean removeAll(@NonNull Collection<?> collection) {
        boolean z = false;
        for (Object remove : collection) {
            z |= remove(remove);
        }
        return z;
    }

    public boolean retainAll(@NonNull Collection<?> collection) {
        boolean z = false;
        for (int i2 = this.Y - 1; i2 >= 0; i2--) {
            if (!collection.contains(this.X[i2])) {
                n(i2);
                z = true;
            }
        }
        return z;
    }

    public int size() {
        return this.Y;
    }

    @NonNull
    public Object[] toArray() {
        int i2 = this.Y;
        Object[] objArr = new Object[i2];
        System.arraycopy(this.X, 0, objArr, 0, i2);
        return objArr;
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.Y * 14);
        sb.append(ASCIIPropertyListParser.f18652j);
        for (int i2 = 0; i2 < this.Y; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object o = o(i2);
            if (o != this) {
                sb.append(o);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append(ASCIIPropertyListParser.f18653k);
        return sb.toString();
    }

    public ArraySet(int i2) {
        if (i2 == 0) {
            this.s = ContainerHelpers.f3550a;
            this.X = ContainerHelpers.f3552c;
        } else {
            c(i2);
        }
        this.Y = 0;
    }

    @NonNull
    public <T> T[] toArray(@NonNull T[] tArr) {
        if (tArr.length < this.Y) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.Y);
        }
        System.arraycopy(this.X, 0, tArr, 0, this.Y);
        int length = tArr.length;
        int i2 = this.Y;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    public ArraySet(@Nullable ArraySet<E> arraySet) {
        this();
        if (arraySet != null) {
            b(arraySet);
        }
    }

    public ArraySet(@Nullable Collection<E> collection) {
        this();
        if (collection != null) {
            addAll(collection);
        }
    }

    public ArraySet(@Nullable E[] eArr) {
        this();
        if (eArr != null) {
            for (E add : eArr) {
                add(add);
            }
        }
    }
}
