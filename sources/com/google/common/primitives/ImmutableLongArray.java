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
public final class ImmutableLongArray implements Serializable {
    /* access modifiers changed from: private */
    public static final ImmutableLongArray Z = new ImmutableLongArray(new long[0]);
    /* access modifiers changed from: private */
    public final transient int X;
    private final int Y;
    /* access modifiers changed from: private */
    public final long[] s;

    static class AsList extends AbstractList<Long> implements RandomAccess, Serializable {
        private final ImmutableLongArray s;

        private AsList(ImmutableLongArray immutableLongArray) {
            this.s = immutableLongArray;
        }

        /* renamed from: b */
        public Long get(int i2) {
            return Long.valueOf(this.s.k(i2));
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
                if (next instanceof Long) {
                    int i2 = b2 + 1;
                    if (this.s.s[b2] == ((Long) next).longValue()) {
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
            if (obj instanceof Long) {
                return this.s.l(((Long) obj).longValue());
            }
            return -1;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Long) {
                return this.s.o(((Long) obj).longValue());
            }
            return -1;
        }

        public int size() {
            return this.s.p();
        }

        public List<Long> subList(int i2, int i3) {
            return this.s.z(i2, i3).d();
        }

        public String toString() {
            return this.s.toString();
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long[] f22954a;

        /* renamed from: b  reason: collision with root package name */
        private int f22955b = 0;

        Builder(int i2) {
            this.f22954a = new long[i2];
        }

        private void g(int i2) {
            int i3 = this.f22955b + i2;
            long[] jArr = this.f22954a;
            if (i3 > jArr.length) {
                this.f22954a = Arrays.copyOf(jArr, h(jArr.length, i3));
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
        public Builder a(long j2) {
            g(1);
            long[] jArr = this.f22954a;
            int i2 = this.f22955b;
            jArr[i2] = j2;
            this.f22955b = i2 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder b(ImmutableLongArray immutableLongArray) {
            g(immutableLongArray.p());
            System.arraycopy(immutableLongArray.s, immutableLongArray.X, this.f22954a, this.f22955b, immutableLongArray.p());
            this.f22955b += immutableLongArray.p();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder c(Iterable<Long> iterable) {
            if (iterable instanceof Collection) {
                return d((Collection) iterable);
            }
            for (Long longValue : iterable) {
                a(longValue.longValue());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder d(Collection<Long> collection) {
            g(collection.size());
            for (Long longValue : collection) {
                long[] jArr = this.f22954a;
                int i2 = this.f22955b;
                this.f22955b = i2 + 1;
                jArr[i2] = longValue.longValue();
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder e(long[] jArr) {
            g(jArr.length);
            System.arraycopy(jArr, 0, this.f22954a, this.f22955b, jArr.length);
            this.f22955b += jArr.length;
            return this;
        }

        public ImmutableLongArray f() {
            return this.f22955b == 0 ? ImmutableLongArray.Z : new ImmutableLongArray(this.f22954a, 0, this.f22955b);
        }
    }

    private ImmutableLongArray(long[] jArr) {
        this(jArr, 0, jArr.length);
    }

    public static Builder e() {
        return new Builder(10);
    }

    public static Builder f(int i2) {
        Preconditions.k(i2 >= 0, "Invalid initialCapacity: %s", i2);
        return new Builder(i2);
    }

    public static ImmutableLongArray h(Iterable<Long> iterable) {
        return iterable instanceof Collection ? i((Collection) iterable) : e().c(iterable).f();
    }

    public static ImmutableLongArray i(Collection<Long> collection) {
        return collection.isEmpty() ? Z : new ImmutableLongArray(Longs.C(collection));
    }

    public static ImmutableLongArray j(long[] jArr) {
        return jArr.length == 0 ? Z : new ImmutableLongArray(Arrays.copyOf(jArr, jArr.length));
    }

    private boolean n() {
        return this.X > 0 || this.Y < this.s.length;
    }

    public static ImmutableLongArray q() {
        return Z;
    }

    public static ImmutableLongArray r(long j2) {
        return new ImmutableLongArray(new long[]{j2});
    }

    public static ImmutableLongArray s(long j2, long j3) {
        return new ImmutableLongArray(new long[]{j2, j3});
    }

    public static ImmutableLongArray t(long j2, long j3, long j4) {
        return new ImmutableLongArray(new long[]{j2, j3, j4});
    }

    public static ImmutableLongArray u(long j2, long j3, long j4, long j5) {
        return new ImmutableLongArray(new long[]{j2, j3, j4, j5});
    }

    public static ImmutableLongArray v(long j2, long j3, long j4, long j5, long j6) {
        return new ImmutableLongArray(new long[]{j2, j3, j4, j5, j6});
    }

    public static ImmutableLongArray w(long j2, long j3, long j4, long j5, long j6, long j7) {
        return new ImmutableLongArray(new long[]{j2, j3, j4, j5, j6, j7});
    }

    public static ImmutableLongArray x(long j2, long... jArr) {
        Preconditions.e(jArr.length <= 2147483646, "the total number of elements must fit in an int");
        long[] jArr2 = new long[(jArr.length + 1)];
        jArr2[0] = j2;
        System.arraycopy(jArr, 0, jArr2, 1, jArr.length);
        return new ImmutableLongArray(jArr2);
    }

    public long[] A() {
        return Arrays.copyOfRange(this.s, this.X, this.Y);
    }

    public ImmutableLongArray B() {
        return n() ? new ImmutableLongArray(A()) : this;
    }

    /* access modifiers changed from: package-private */
    public Object C() {
        return B();
    }

    public List<Long> d() {
        return new AsList();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableLongArray)) {
            return false;
        }
        ImmutableLongArray immutableLongArray = (ImmutableLongArray) obj;
        if (p() != immutableLongArray.p()) {
            return false;
        }
        for (int i2 = 0; i2 < p(); i2++) {
            if (k(i2) != immutableLongArray.k(i2)) {
                return false;
            }
        }
        return true;
    }

    public boolean g(long j2) {
        return l(j2) >= 0;
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = this.X; i3 < this.Y; i3++) {
            i2 = (i2 * 31) + Longs.l(this.s[i3]);
        }
        return i2;
    }

    public long k(int i2) {
        Preconditions.C(i2, p());
        return this.s[this.X + i2];
    }

    public int l(long j2) {
        for (int i2 = this.X; i2 < this.Y; i2++) {
            if (this.s[i2] == j2) {
                return i2 - this.X;
            }
        }
        return -1;
    }

    public boolean m() {
        return this.Y == this.X;
    }

    public int o(long j2) {
        int i2 = this.Y;
        while (true) {
            i2--;
            int i3 = this.X;
            if (i2 < i3) {
                return -1;
            }
            if (this.s[i2] == j2) {
                return i2 - i3;
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

    public ImmutableLongArray z(int i2, int i3) {
        Preconditions.f0(i2, i3, p());
        if (i2 == i3) {
            return Z;
        }
        long[] jArr = this.s;
        int i4 = this.X;
        return new ImmutableLongArray(jArr, i2 + i4, i4 + i3);
    }

    private ImmutableLongArray(long[] jArr, int i2, int i3) {
        this.s = jArr;
        this.X = i2;
        this.Y = i3;
    }
}
