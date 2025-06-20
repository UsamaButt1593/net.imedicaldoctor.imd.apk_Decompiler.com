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
public final class ImmutableDoubleArray implements Serializable {
    /* access modifiers changed from: private */
    public static final ImmutableDoubleArray Z = new ImmutableDoubleArray(new double[0]);
    /* access modifiers changed from: private */
    public final transient int X;
    private final int Y;
    /* access modifiers changed from: private */
    public final double[] s;

    static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private final ImmutableDoubleArray s;

        private AsList(ImmutableDoubleArray immutableDoubleArray) {
            this.s = immutableDoubleArray;
        }

        /* renamed from: b */
        public Double get(int i2) {
            return Double.valueOf(this.s.m(i2));
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
                if (next instanceof Double) {
                    int i2 = b2 + 1;
                    if (ImmutableDoubleArray.e(this.s.s[b2], ((Double) next).doubleValue())) {
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
            if (obj instanceof Double) {
                return this.s.n(((Double) obj).doubleValue());
            }
            return -1;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Double) {
                return this.s.q(((Double) obj).doubleValue());
            }
            return -1;
        }

        public int size() {
            return this.s.r();
        }

        public List<Double> subList(int i2, int i3) {
            return this.s.B(i2, i3).f();
        }

        public String toString() {
            return this.s.toString();
        }
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private double[] f22950a;

        /* renamed from: b  reason: collision with root package name */
        private int f22951b = 0;

        Builder(int i2) {
            this.f22950a = new double[i2];
        }

        private void g(int i2) {
            int i3 = this.f22951b + i2;
            double[] dArr = this.f22950a;
            if (i3 > dArr.length) {
                this.f22950a = Arrays.copyOf(dArr, h(dArr.length, i3));
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
        public Builder a(double d2) {
            g(1);
            double[] dArr = this.f22950a;
            int i2 = this.f22951b;
            dArr[i2] = d2;
            this.f22951b = i2 + 1;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder b(ImmutableDoubleArray immutableDoubleArray) {
            g(immutableDoubleArray.r());
            System.arraycopy(immutableDoubleArray.s, immutableDoubleArray.X, this.f22950a, this.f22951b, immutableDoubleArray.r());
            this.f22951b += immutableDoubleArray.r();
            return this;
        }

        @CanIgnoreReturnValue
        public Builder c(Iterable<Double> iterable) {
            if (iterable instanceof Collection) {
                return d((Collection) iterable);
            }
            for (Double doubleValue : iterable) {
                a(doubleValue.doubleValue());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder d(Collection<Double> collection) {
            g(collection.size());
            for (Double doubleValue : collection) {
                double[] dArr = this.f22950a;
                int i2 = this.f22951b;
                this.f22951b = i2 + 1;
                dArr[i2] = doubleValue.doubleValue();
            }
            return this;
        }

        @CanIgnoreReturnValue
        public Builder e(double[] dArr) {
            g(dArr.length);
            System.arraycopy(dArr, 0, this.f22950a, this.f22951b, dArr.length);
            this.f22951b += dArr.length;
            return this;
        }

        public ImmutableDoubleArray f() {
            return this.f22951b == 0 ? ImmutableDoubleArray.Z : new ImmutableDoubleArray(this.f22950a, 0, this.f22951b);
        }
    }

    private ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    /* access modifiers changed from: private */
    public static boolean e(double d2, double d3) {
        return Double.doubleToLongBits(d2) == Double.doubleToLongBits(d3);
    }

    public static Builder g() {
        return new Builder(10);
    }

    public static Builder h(int i2) {
        Preconditions.k(i2 >= 0, "Invalid initialCapacity: %s", i2);
        return new Builder(i2);
    }

    public static ImmutableDoubleArray j(Iterable<Double> iterable) {
        return iterable instanceof Collection ? k((Collection) iterable) : g().c(iterable).f();
    }

    public static ImmutableDoubleArray k(Collection<Double> collection) {
        return collection.isEmpty() ? Z : new ImmutableDoubleArray(Doubles.B(collection));
    }

    public static ImmutableDoubleArray l(double[] dArr) {
        return dArr.length == 0 ? Z : new ImmutableDoubleArray(Arrays.copyOf(dArr, dArr.length));
    }

    private boolean p() {
        return this.X > 0 || this.Y < this.s.length;
    }

    public static ImmutableDoubleArray s() {
        return Z;
    }

    public static ImmutableDoubleArray t(double d2) {
        return new ImmutableDoubleArray(new double[]{d2});
    }

    public static ImmutableDoubleArray u(double d2, double d3) {
        return new ImmutableDoubleArray(new double[]{d2, d3});
    }

    public static ImmutableDoubleArray v(double d2, double d3, double d4) {
        return new ImmutableDoubleArray(new double[]{d2, d3, d4});
    }

    public static ImmutableDoubleArray w(double d2, double d3, double d4, double d5) {
        return new ImmutableDoubleArray(new double[]{d2, d3, d4, d5});
    }

    public static ImmutableDoubleArray x(double d2, double d3, double d4, double d5, double d6) {
        return new ImmutableDoubleArray(new double[]{d2, d3, d4, d5, d6});
    }

    public static ImmutableDoubleArray y(double d2, double d3, double d4, double d5, double d6, double d7) {
        return new ImmutableDoubleArray(new double[]{d2, d3, d4, d5, d6, d7});
    }

    public static ImmutableDoubleArray z(double d2, double... dArr) {
        Preconditions.e(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr2 = new double[(dArr.length + 1)];
        dArr2[0] = d2;
        System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new ImmutableDoubleArray(dArr2);
    }

    /* access modifiers changed from: package-private */
    public Object A() {
        return o() ? Z : this;
    }

    public ImmutableDoubleArray B(int i2, int i3) {
        Preconditions.f0(i2, i3, r());
        if (i2 == i3) {
            return Z;
        }
        double[] dArr = this.s;
        int i4 = this.X;
        return new ImmutableDoubleArray(dArr, i2 + i4, i4 + i3);
    }

    public double[] C() {
        return Arrays.copyOfRange(this.s, this.X, this.Y);
    }

    public ImmutableDoubleArray D() {
        return p() ? new ImmutableDoubleArray(C()) : this;
    }

    /* access modifiers changed from: package-private */
    public Object E() {
        return D();
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoubleArray)) {
            return false;
        }
        ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
        if (r() != immutableDoubleArray.r()) {
            return false;
        }
        for (int i2 = 0; i2 < r(); i2++) {
            if (!e(m(i2), immutableDoubleArray.m(i2))) {
                return false;
            }
        }
        return true;
    }

    public List<Double> f() {
        return new AsList();
    }

    public int hashCode() {
        int i2 = 1;
        for (int i3 = this.X; i3 < this.Y; i3++) {
            i2 = (i2 * 31) + Doubles.j(this.s[i3]);
        }
        return i2;
    }

    public boolean i(double d2) {
        return n(d2) >= 0;
    }

    public double m(int i2) {
        Preconditions.C(i2, r());
        return this.s[this.X + i2];
    }

    public int n(double d2) {
        for (int i2 = this.X; i2 < this.Y; i2++) {
            if (e(this.s[i2], d2)) {
                return i2 - this.X;
            }
        }
        return -1;
    }

    public boolean o() {
        return this.Y == this.X;
    }

    public int q(double d2) {
        int i2 = this.Y;
        while (true) {
            i2--;
            if (i2 < this.X) {
                return -1;
            }
            if (e(this.s[i2], d2)) {
                return i2 - this.X;
            }
        }
    }

    public int r() {
        return this.Y - this.X;
    }

    public String toString() {
        if (o()) {
            return XMPConst.o2;
        }
        StringBuilder sb = new StringBuilder(r() * 5);
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

    private ImmutableDoubleArray(double[] dArr, int i2, int i3) {
        this.s = dArr;
        this.X = i2;
        this.Y = i3;
    }
}
