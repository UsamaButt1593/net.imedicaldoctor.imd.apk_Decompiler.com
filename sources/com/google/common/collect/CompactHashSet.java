package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    @VisibleForTesting
    static final double Y2 = 0.001d;
    private static final int Z2 = 9;
    @CheckForNull
    private transient int[] X;
    private transient int X2;
    @CheckForNull
    @VisibleForTesting
    transient Object[] Y;
    /* access modifiers changed from: private */
    public transient int Z;
    @CheckForNull
    private transient Object s;

    CompactHashSet() {
        D(3);
    }

    private int B() {
        return (1 << (this.Z & 31)) - 1;
    }

    @J2ktIncompatible
    private void L(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readInt = objectInputStream.readInt();
        if (readInt >= 0) {
            D(readInt);
            for (int i2 = 0; i2 < readInt; i2++) {
                add(objectInputStream.readObject());
            }
            return;
        }
        throw new InvalidObjectException("Invalid size: " + readInt);
    }

    private Object[] M() {
        Object[] objArr = this.Y;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    private int[] N() {
        int[] iArr = this.X;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    private Object O() {
        Object obj = this.s;
        Objects.requireNonNull(obj);
        return obj;
    }

    private void R(int i2) {
        int min;
        int length = N().length;
        if (i2 > length && (min = Math.min(LockFreeTaskQueueCore.f29373j, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            P(min);
        }
    }

    @CanIgnoreReturnValue
    private int T(int i2, int i3, int i4, int i5) {
        Object a2 = CompactHashing.a(i3);
        int i6 = i3 - 1;
        if (i5 != 0) {
            CompactHashing.i(a2, i4 & i6, i5 + 1);
        }
        Object O = O();
        int[] N = N();
        for (int i7 = 0; i7 <= i2; i7++) {
            int h2 = CompactHashing.h(O, i7);
            while (h2 != 0) {
                int i8 = h2 - 1;
                int i9 = N[i8];
                int b2 = CompactHashing.b(i9, i2) | i7;
                int i10 = b2 & i6;
                int h3 = CompactHashing.h(a2, i10);
                CompactHashing.i(a2, i10, h2);
                N[i8] = CompactHashing.d(b2, h3, i6);
                h2 = CompactHashing.c(i9, i2);
            }
        }
        this.s = a2;
        W(i6);
        return i6;
    }

    private void U(int i2, E e2) {
        M()[i2] = e2;
    }

    private void V(int i2, int i3) {
        N()[i2] = i3;
    }

    private void W(int i2) {
        this.Z = CompactHashing.d(this.Z, 32 - Integer.numberOfLeadingZeros(i2), 31);
    }

    @J2ktIncompatible
    private void Y(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            objectOutputStream.writeObject(it2.next());
        }
    }

    public static <E> CompactHashSet<E> j() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> k(Collection<? extends E> collection) {
        CompactHashSet<E> o = o(collection.size());
        o.addAll(collection);
        return o;
    }

    @SafeVarargs
    public static <E> CompactHashSet<E> m(E... eArr) {
        CompactHashSet<E> o = o(eArr.length);
        Collections.addAll(o, eArr);
        return o;
    }

    private Set<E> n(int i2) {
        return new LinkedHashSet(i2, 1.0f);
    }

    public static <E> CompactHashSet<E> o(int i2) {
        return new CompactHashSet<>(i2);
    }

    /* access modifiers changed from: private */
    public E r(int i2) {
        return M()[i2];
    }

    private int t(int i2) {
        return N()[i2];
    }

    /* access modifiers changed from: package-private */
    public void C() {
        this.Z += 32;
    }

    /* access modifiers changed from: package-private */
    public void D(int i2) {
        Preconditions.e(i2 >= 0, "Expected size must be >= 0");
        this.Z = Ints.g(i2, 1, LockFreeTaskQueueCore.f29373j);
    }

    /* access modifiers changed from: package-private */
    public void E(int i2, @ParametricNullness E e2, int i3, int i4) {
        V(i2, CompactHashing.d(i3, 0, i4));
        U(i2, e2);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean H() {
        return q() != null;
    }

    /* access modifiers changed from: package-private */
    public void I(int i2, int i3) {
        Object O = O();
        int[] N = N();
        Object[] M = M();
        int size = size();
        int i4 = size - 1;
        if (i2 < i4) {
            Object obj = M[i4];
            M[i2] = obj;
            M[i4] = null;
            N[i2] = N[i4];
            N[i4] = 0;
            int d2 = Hashing.d(obj) & i3;
            int h2 = CompactHashing.h(O, d2);
            if (h2 == size) {
                CompactHashing.i(O, d2, i2 + 1);
                return;
            }
            while (true) {
                int i5 = h2 - 1;
                int i6 = N[i5];
                int c2 = CompactHashing.c(i6, i3);
                if (c2 == size) {
                    N[i5] = CompactHashing.d(i6, i2 + 1, i3);
                    return;
                }
                h2 = c2;
            }
        } else {
            M[i2] = null;
            N[i2] = 0;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean K() {
        return this.s == null;
    }

    /* access modifiers changed from: package-private */
    public void P(int i2) {
        this.X = Arrays.copyOf(N(), i2);
        this.Y = Arrays.copyOf(M(), i2);
    }

    public void X() {
        if (!K()) {
            Set q = q();
            if (q != null) {
                Set n2 = n(size());
                n2.addAll(q);
                this.s = n2;
                return;
            }
            int i2 = this.X2;
            if (i2 < N().length) {
                P(i2);
            }
            int j2 = CompactHashing.j(i2);
            int B = B();
            if (j2 < B) {
                T(B, j2, 0, 0);
            }
        }
    }

    @CanIgnoreReturnValue
    public boolean add(@ParametricNullness E e2) {
        if (K()) {
            g();
        }
        Set q = q();
        if (q != null) {
            return q.add(e2);
        }
        int[] N = N();
        Object[] M = M();
        int i2 = this.X2;
        int i3 = i2 + 1;
        int d2 = Hashing.d(e2);
        int B = B();
        int i4 = d2 & B;
        int h2 = CompactHashing.h(O(), i4);
        if (h2 != 0) {
            int b2 = CompactHashing.b(d2, B);
            int i5 = 0;
            while (true) {
                int i6 = h2 - 1;
                int i7 = N[i6];
                if (CompactHashing.b(i7, B) == b2 && com.google.common.base.Objects.a(e2, M[i6])) {
                    return false;
                }
                int c2 = CompactHashing.c(i7, B);
                i5++;
                if (c2 != 0) {
                    h2 = c2;
                } else if (i5 >= 9) {
                    return h().add(e2);
                } else {
                    if (i3 <= B) {
                        N[i6] = CompactHashing.d(i7, i3, B);
                    }
                }
            }
            R(i3);
            E(i2, e2, d2, B);
            this.X2 = i3;
            C();
            return true;
        } else if (i3 <= B) {
            CompactHashing.i(O(), i4, i3);
            R(i3);
            E(i2, e2, d2, B);
            this.X2 = i3;
            C();
            return true;
        }
        B = T(B, CompactHashing.e(B), d2, i2);
        R(i3);
        E(i2, e2, d2, B);
        this.X2 = i3;
        C();
        return true;
    }

    public void clear() {
        if (!K()) {
            C();
            Set q = q();
            if (q != null) {
                this.Z = Ints.g(size(), 3, LockFreeTaskQueueCore.f29373j);
                q.clear();
                this.s = null;
            } else {
                Arrays.fill(M(), 0, this.X2, (Object) null);
                CompactHashing.g(O());
                Arrays.fill(N(), 0, this.X2, 0);
            }
            this.X2 = 0;
        }
    }

    public boolean contains(@CheckForNull Object obj) {
        if (K()) {
            return false;
        }
        Set q = q();
        if (q != null) {
            return q.contains(obj);
        }
        int d2 = Hashing.d(obj);
        int B = B();
        int h2 = CompactHashing.h(O(), d2 & B);
        if (h2 == 0) {
            return false;
        }
        int b2 = CompactHashing.b(d2, B);
        do {
            int i2 = h2 - 1;
            int t = t(i2);
            if (CompactHashing.b(t, B) == b2 && com.google.common.base.Objects.a(obj, r(i2))) {
                return true;
            }
            h2 = CompactHashing.c(t, B);
        } while (h2 != 0);
        return false;
    }

    /* access modifiers changed from: package-private */
    public int d(int i2, int i3) {
        return i2 - 1;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int g() {
        Preconditions.h0(K(), "Arrays already allocated");
        int i2 = this.Z;
        int j2 = CompactHashing.j(i2);
        this.s = CompactHashing.a(j2);
        W(j2 - 1);
        this.X = new int[i2];
        this.Y = new Object[i2];
        return i2;
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @VisibleForTesting
    public Set<E> h() {
        Set<E> n2 = n(B() + 1);
        int x = x();
        while (x >= 0) {
            n2.add(r(x));
            x = z(x);
        }
        this.s = n2;
        this.X = null;
        this.Y = null;
        C();
        return n2;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Iterator<E> iterator() {
        Set q = q();
        return q != null ? q.iterator() : new Iterator<E>() {
            int X;
            int Y = -1;
            int s;

            {
                this.s = CompactHashSet.this.Z;
                this.X = CompactHashSet.this.x();
            }

            private void a() {
                if (CompactHashSet.this.Z != this.s) {
                    throw new ConcurrentModificationException();
                }
            }

            /* access modifiers changed from: package-private */
            public void b() {
                this.s += 32;
            }

            public boolean hasNext() {
                return this.X >= 0;
            }

            @ParametricNullness
            public E next() {
                a();
                if (hasNext()) {
                    int i2 = this.X;
                    this.Y = i2;
                    E c2 = CompactHashSet.this.r(i2);
                    this.X = CompactHashSet.this.z(this.X);
                    return c2;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                a();
                CollectPreconditions.e(this.Y >= 0);
                b();
                CompactHashSet compactHashSet = CompactHashSet.this;
                compactHashSet.remove(compactHashSet.r(this.Y));
                this.X = CompactHashSet.this.d(this.X, this.Y);
                this.Y = -1;
            }
        };
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    @VisibleForTesting
    public Set<E> q() {
        Object obj = this.s;
        if (obj instanceof Set) {
            return (Set) obj;
        }
        return null;
    }

    @CanIgnoreReturnValue
    public boolean remove(@CheckForNull Object obj) {
        if (K()) {
            return false;
        }
        Set q = q();
        if (q != null) {
            return q.remove(obj);
        }
        int B = B();
        int f2 = CompactHashing.f(obj, (Object) null, B, O(), N(), M(), (Object[]) null);
        if (f2 == -1) {
            return false;
        }
        I(f2, B);
        this.X2--;
        C();
        return true;
    }

    public int size() {
        Set q = q();
        return q != null ? q.size() : this.X2;
    }

    public Object[] toArray() {
        if (K()) {
            return new Object[0];
        }
        Set q = q();
        return q != null ? q.toArray() : Arrays.copyOf(M(), this.X2);
    }

    /* access modifiers changed from: package-private */
    public int x() {
        return isEmpty() ? -1 : 0;
    }

    /* access modifiers changed from: package-private */
    public int z(int i2) {
        int i3 = i2 + 1;
        if (i3 < this.X2) {
            return i3;
        }
        return -1;
    }

    CompactHashSet(int i2) {
        D(i2);
    }

    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        if (K()) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        Set q = q();
        return q != null ? q.toArray(tArr) : ObjectArrays.n(M(), 0, this.X2, tArr);
    }
}
