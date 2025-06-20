package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.Immutable;
import com.itextpdf.xmp.XMPConst;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@Immutable
public final class ImmutableIntArray implements Serializable {
    /* access modifiers changed from: private */
    public static final ImmutableIntArray Z = new ImmutableIntArray(new int[0]);
    /* access modifiers changed from: private */
    public final transient int X;
    private final int Y;
    /* access modifiers changed from: private */
    public final int[] s;

    static class AsList extends AbstractList<Integer> implements RandomAccess, Serializable {
        private final ImmutableIntArray s;

        private AsList(ImmutableIntArray immutableIntArray) {
            this.s = immutableIntArray;
        }

        /* renamed from: b */
        public Integer get(int i2) {
            return Integer.valueOf(this.s.k(i2));
        }

        public boolean contains(@CheckForNull Object obj) {
            return indexOf(obj) >= 0;
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof AsList) {
                return this.s.equals(((AsList) obj).s);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int b2 = this.s.X;
            for (Object next : list) {
                if (next instanceof Integer) {
                    int i2 = b2 + 1;
                    if (this.s.s[b2] == ((Integer) next).intValue()) {
                        b2 = i2;
                    }
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.s.hashCode();
        }

        public int indexOf(@CheckForNull Object obj) {
            if (obj instanceof Integer) {
                return this.s.l(((Integer) obj).intValue());
            }
            return -1;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Integer) {
                return this.s.o(((Integer) obj).intValue());
            }
            return -1;
        }

        public int size() {
            return this.s.p();
        }

        public List<Integer> subList(int i2, int i3) {
            return this.s.z(i2, i3).d();
        }

        public String toString() {
            return this.s.toString();
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private int[] f22952a;

        /* renamed from: b  reason: collision with root package name */
        private int f22953b = 0;

        Builder(int i2) {
            this.f22952a = new int[i2];
        }

        private void g(int i2) {
            int i3 = this.f22953b + i2;
            int[] iArr = this.f22952a;
            if (i3 > iArr.length) {
                this.f22952a = Arrays.copyOf(iArr, h(iArr.length, i3));
            }
        }

        private static int h(int i2, int i3) {
            if (i3 >= 0) {
                int i4 = i2 + (i2 >> 1) + 1;
                if (i4 < i3) {
                    i4 = Integer.highestOneBit(i3 - 1) << 1;
                }
                if (i4 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i4;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        @CanIgnoreReturnValue
        public Builder a(int i2) {
            g(1);
            int[] iArr = this.f22952a;
            int i3 = this.f22953b;
            iArr[i3] = i2;
            this.f22953b = i3 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder b(ImmutableIntArray immutableIntArray) {
            g(immutableIntArray.p());
            System.arraycopy(immutableIntArray.s, immutableIntArray.X, this.f22952a, this.f22953b, immutableIntArray.p());
            this.f22953b += immutableIntArray.p();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder c(Iterable<Integer> iterable) {
            if (iterable instanceof Collection) {
                return d((Collection) iterable);
            }
            for (Integer intValue : iterable) {
                a(intValue.intValue());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder d(Collection<Integer> collection) {
            g(collection.size());
            for (Integer intValue : collection) {
                int[] iArr = this.f22952a;
                int i2 = this.f22953b;
                this.f22953b = i2 + 1;
                iArr[i2] = intValue.intValue();
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder e(int[] iArr) {
            g(iArr.length);
            System.arraycopy(iArr, 0, this.f22952a, this.f22953b, iArr.length);
            this.f22953b += iArr.length;
            return this;
        }

        public ImmutableIntArray f() {
            return this.f22953b == 0 ? ImmutableIntArray.Z : new ImmutableIntArray(this.f22952a, 0, this.f22953b);
        }
    }

    private ImmutableIntArray(int[] iArr) {
        this(iArr, 0, iArr.length);
    }

    public static Builder e() {
        return new Builder(10);
    }

    public static Builder f(int i2) {
        Preconditions.k(i2 >= 0, "Invalid initialCapacity: %s", i2);
        return new Builder(i2);
    }

    public static ImmutableIntArray h(Iterable<Integer> iterable) {
        return iterable instanceof Collection ? i((Collection) iterable) : e().c(iterable).f();
    }

    public static ImmutableIntArray i(Collection<Integer> collection) {
        return collection.isEmpty() ? Z : new ImmutableIntArray(Ints.D(collection));
    }

    public static ImmutableIntArray j(int[] iArr) {
        return iArr.length == 0 ? Z : new ImmutableIntArray(Arrays.copyOf(iArr, iArr.length));
    }

    private boolean n() {
        return this.X > 0 || this.Y < this.s.length;
    }

    public static ImmutableIntArray q() {
        return Z;
    }

    public static ImmutableIntArray r(int i2) {
        return new ImmutableIntArray(new int[]{i2});
    }

    public static ImmutableIntArray s(int i2, int i3) {
        return new ImmutableIntArray(new int[]{i2, i3});
    }

    public static ImmutableIntArray t(int i2, int i3, int i4) {
        return new ImmutableIntArray(new int[]{i2, i3, i4});
    }

    public static ImmutableIntArray u(int i2, int i3, int i4, int i5) {
        return new ImmutableIntArray(new int[]{i2, i3, i4, i5});
    }

    public static ImmutableIntArray v(int i2, int i3, int i4, int i5, int i6) {
        return new ImmutableIntArray(new int[]{i2, i3, i4, i5, i6});
    }

    public static ImmutableIntArray w(int i2, int i3, int i4, int i5, int i6, int i7) {
        return new ImmutableIntArray(new int[]{i2, i3, i4, i5, i6, i7});
    }

    public static ImmutableIntArray x(int i2, int... iArr) {
        Preconditions.e(iArr.length <= 2147483646, "the total number of elements must fit in an int");
        int[] iArr2 = new int[(iArr.length + 1)];
        iArr2[0] = i2;
        System.arraycopy(iArr, 0, iArr2, 1, iArr.length);
        return new ImmutableIntArray(iArr2);
    }

    public int[] A() {
        return Arrays.copyOfRange(this.s, this.X, this.Y);
    }

    public ImmutableIntArray B() {
        return n() ? new ImmutableIntArray(A()) : this;
    }

    /* access modifiers changed from: package-private */
    public Object C() {
        return B();
    }

    public List<Integer> d() {
        return new AsList();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableIntArray)) {
            return false;
        }
        ImmutableIntArray immutableIntArray = (ImmutableIntArray) obj;
        if (p() != immutableIntArray.p()) {
            return false;
        }
        for (int i2 = 0; i2 < p(); i2++) {
            if (k(i2) != immutableIntArray.k(i2)) {
                return false;
            }
        }
        return true;
    }

    public boolean g(int i2) {
        return l(i2) >= 0;
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = this.X; i3 < this.Y; i3++) {
            i2 = (i2 * 31) + Ints.l(this.s[i3]);
        }
        return i2;
    }

    public int k(int i2) {
        Preconditions.C(i2, p());
        return this.s[this.X + i2];
    }

    public int l(int i2) {
        for (int i3 = this.X; i3 < this.Y; i3++) {
            if (this.s[i3] == i2) {
                return i3 - this.X;
            }
        }
        return -1;
    }

    public boolean m() {
        return this.Y == this.X;
    }

    public int o(int i2) {
        int i3 = this.Y;
        while (true) {
            i3--;
            int i4 = this.X;
            if (i3 < i4) {
                return -1;
            }
            if (this.s[i3] == i2) {
                return i3 - i4;
            }
        }
    }

    public int p() {
        return this.Y - this.X;
    }

    public String toString() {
        if (m()) {
            return XMPConst.o2;
        }
        StringBuilder sb = new StringBuilder(p() * 5);
        sb.append('[');
        sb.append(this.s[this.X]);
        int i2 = this.X;
        while (true) {
            i2++;
            if (i2 < this.Y) {
                sb.append(", ");
                sb.append(this.s[i2]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Object y() {
        return m() ? Z : this;
    }

    public ImmutableIntArray z(int i2, int i3) {
        Preconditions.f0(i2, i3, p());
        if (i2 == i3) {
            return Z;
        }
        int[] iArr = this.s;
        int i4 = this.X;
        return new ImmutableIntArray(iArr, i2 + i4, i4 + i3);
    }

    private ImmutableIntArray(int[] iArr, int i2, int i3) {
        this.s = iArr;
        this.X = i2;
        this.Y = i3;
    }
}
