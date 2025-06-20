package com.google.common.primitives;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
public final class Doubles extends DoublesMethodsForWeb {

    /* renamed from: a  reason: collision with root package name */
    public static final int f22947a = 8;
    @GwtIncompatible
    @J2ktIncompatible

    /* renamed from: b  reason: collision with root package name */
    static final Pattern f22948b = i();

    @GwtCompatible
    private static class DoubleArrayAsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private static final long Z = 0;
        final int X;
        final int Y;
        final double[] s;

        DoubleArrayAsList(double[] dArr) {
            this(dArr, 0, dArr.length);
        }

        /* renamed from: b */
        public Double get(int i2) {
            Preconditions.C(i2, size());
            return Double.valueOf(this.s[this.X + i2]);
        }

        /* renamed from: c */
        public Double set(int i2, Double d2) {
            Preconditions.C(i2, size());
            double[] dArr = this.s;
            int i3 = this.X;
            double d3 = dArr[i3 + i2];
            dArr[i3 + i2] = ((Double) Preconditions.E(d2)).doubleValue();
            return Double.valueOf(d3);
        }

        public boolean contains(@CheckForNull Object obj) {
            return (obj instanceof Double) && Doubles.l(this.s, ((Double) obj).doubleValue(), this.X, this.Y) != -1;
        }

        /* access modifiers changed from: package-private */
        public double[] d() {
            return Arrays.copyOfRange(this.s, this.X, this.Y);
        }

        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof DoubleArrayAsList)) {
                return super.equals(obj);
            }
            DoubleArrayAsList doubleArrayAsList = (DoubleArrayAsList) obj;
            int size = size();
            if (doubleArrayAsList.size() != size) {
                return false;
            }
            for (int i2 = 0; i2 < size; i2++) {
                if (this.s[this.X + i2] != doubleArrayAsList.s[doubleArrayAsList.X + i2]) {
                    return false;
                }
            }
            return true;
        }

        public int hashCode() {
            int i2 = 1;
            for (int i3 = this.X; i3 < this.Y; i3++) {
                i2 = (i2 * 31) + Doubles.j(this.s[i3]);
            }
            return i2;
        }

        public int indexOf(@CheckForNull Object obj) {
            int a2;
            if (!(obj instanceof Double) || (a2 = Doubles.l(this.s, ((Double) obj).doubleValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return a2 - this.X;
        }

        public boolean isEmpty() {
            return false;
        }

        public int lastIndexOf(@CheckForNull Object obj) {
            int b2;
            if (!(obj instanceof Double) || (b2 = Doubles.q(this.s, ((Double) obj).doubleValue(), this.X, this.Y)) < 0) {
                return -1;
            }
            return b2 - this.X;
        }

        public int size() {
            return this.Y - this.X;
        }

        public List<Double> subList(int i2, int i3) {
            Preconditions.f0(i2, i3, size());
            if (i2 == i3) {
                return Collections.emptyList();
            }
            double[] dArr = this.s;
            int i4 = this.X;
            return new DoubleArrayAsList(dArr, i2 + i4, i4 + i3);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 12);
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

        DoubleArrayAsList(double[] dArr, int i2, int i3) {
            this.s = dArr;
            this.X = i2;
            this.Y = i3;
        }
    }

    private static final class DoubleConverter extends Converter<String, Double> implements Serializable {
        static final DoubleConverter Y = new DoubleConverter();
        private static final long Z = 1;

        private DoubleConverter() {
        }

        private Object q() {
            return Y;
        }

        /* access modifiers changed from: protected */
        /* renamed from: o */
        public String h(Double d2) {
            return d2.toString();
        }

        /* access modifiers changed from: protected */
        /* renamed from: p */
        public Double i(String str) {
            return Double.valueOf(str);
        }

        public String toString() {
            return "Doubles.stringConverter()";
        }
    }

    private enum LexicographicalComparator implements Comparator<double[]> {
        INSTANCE;

        /* renamed from: b */
        public int compare(double[] dArr, double[] dArr2) {
            int min = Math.min(dArr.length, dArr2.length);
            for (int i2 = 0; i2 < min; i2++) {
                int compare = Double.compare(dArr[i2], dArr2[i2]);
                if (compare != 0) {
                    return compare;
                }
            }
            return dArr.length - dArr2.length;
        }

        public String toString() {
            return "Doubles.lexicographicalComparator()";
        }
    }

    private Doubles() {
    }

    public static Converter<String, Double> A() {
        return DoubleConverter.Y;
    }

    public static double[] B(Collection<? extends Number> collection) {
        if (collection instanceof DoubleArrayAsList) {
            return ((DoubleArrayAsList) collection).d();
        }
        Object[] array = collection.toArray();
        int length = array.length;
        double[] dArr = new double[length];
        for (int i2 = 0; i2 < length; i2++) {
            dArr[i2] = ((Number) Preconditions.E(array[i2])).doubleValue();
        }
        return dArr;
    }

    @GwtIncompatible
    @CheckForNull
    @J2ktIncompatible
    public static Double C(String str) {
        if (!f22948b.matcher(str).matches()) {
            return null;
        }
        try {
            return Double.valueOf(Double.parseDouble(str));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    public static List<Double> c(double... dArr) {
        return dArr.length == 0 ? Collections.emptyList() : new DoubleArrayAsList(dArr);
    }

    public static int d(double d2, double d3) {
        return Double.compare(d2, d3);
    }

    public static double[] e(double[]... dArr) {
        int i2 = 0;
        for (double[] length : dArr) {
            i2 += length.length;
        }
        double[] dArr2 = new double[i2];
        int i3 = 0;
        for (double[] dArr3 : dArr) {
            System.arraycopy(dArr3, 0, dArr2, i3, dArr3.length);
            i3 += dArr3.length;
        }
        return dArr2;
    }

    public static double f(double d2, double d3, double d4) {
        if (d3 <= d4) {
            return Math.min(Math.max(d2, d3), d4);
        }
        throw new IllegalArgumentException(Strings.e("min (%s) must be less than or equal to max (%s)", Double.valueOf(d3), Double.valueOf(d4)));
    }

    public static boolean g(double[] dArr, double d2) {
        for (double d3 : dArr) {
            if (d3 == d2) {
                return true;
            }
        }
        return false;
    }

    public static double[] h(double[] dArr, int i2, int i3) {
        boolean z = false;
        Preconditions.k(i2 >= 0, "Invalid minLength: %s", i2);
        if (i3 >= 0) {
            z = true;
        }
        Preconditions.k(z, "Invalid padding: %s", i3);
        return dArr.length < i2 ? Arrays.copyOf(dArr, i2 + i3) : dArr;
    }

    @GwtIncompatible
    private static Pattern i() {
        return Pattern.compile(("[+-]?(?:NaN|Infinity|" + ("(?:\\d+#(?:\\.\\d*#)?|\\.\\d+#)" + "(?:[eE][+-]?\\d+#)?[fFdD]?") + "|" + ("0[xX]" + "(?:[0-9a-fA-F]+#(?:\\.[0-9a-fA-F]*#)?|\\.[0-9a-fA-F]+#)" + "[pP][+-]?\\d+#[fFdD]?") + ")").replace("#", "+"));
    }

    public static int j(double d2) {
        return Double.valueOf(d2).hashCode();
    }

    public static int k(double[] dArr, double d2) {
        return l(dArr, d2, 0, dArr.length);
    }

    /* access modifiers changed from: private */
    public static int l(double[] dArr, double d2, int i2, int i3) {
        while (i2 < i3) {
            if (dArr[i2] == d2) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int m(double[] dArr, double[] dArr2) {
        Preconditions.F(dArr, "array");
        Preconditions.F(dArr2, TypedValues.AttributesType.M);
        if (dArr2.length == 0) {
            return 0;
        }
        int i2 = 0;
        while (i2 < (dArr.length - dArr2.length) + 1) {
            int i3 = 0;
            while (i3 < dArr2.length) {
                if (dArr[i2 + i3] != dArr2[i3]) {
                    i2++;
                } else {
                    i3++;
                }
            }
            return i2;
        }
        return -1;
    }

    public static boolean n(double d2) {
        return Double.NEGATIVE_INFINITY < d2 && d2 < Double.POSITIVE_INFINITY;
    }

    public static String o(String str, double... dArr) {
        Preconditions.E(str);
        if (dArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(dArr.length * 12);
        sb.append(dArr[0]);
        for (int i2 = 1; i2 < dArr.length; i2++) {
            sb.append(str);
            sb.append(dArr[i2]);
        }
        return sb.toString();
    }

    public static int p(double[] dArr, double d2) {
        return q(dArr, d2, 0, dArr.length);
    }

    /* access modifiers changed from: private */
    public static int q(double[] dArr, double d2, int i2, int i3) {
        for (int i4 = i3 - 1; i4 >= i2; i4--) {
            if (dArr[i4] == d2) {
                return i4;
            }
        }
        return -1;
    }

    public static Comparator<double[]> r() {
        return LexicographicalComparator.INSTANCE;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static double s(double... dArr) {
        Preconditions.d(dArr.length > 0);
        double d2 = dArr[0];
        for (int i2 = 1; i2 < dArr.length; i2++) {
            d2 = Math.max(d2, dArr[i2]);
        }
        return d2;
    }

    @GwtIncompatible("Available in GWT! Annotation is to avoid conflict with GWT specialization of base class.")
    public static double t(double... dArr) {
        Preconditions.d(dArr.length > 0);
        double d2 = dArr[0];
        for (int i2 = 1; i2 < dArr.length; i2++) {
            d2 = Math.min(d2, dArr[i2]);
        }
        return d2;
    }

    public static void u(double[] dArr) {
        Preconditions.E(dArr);
        v(dArr, 0, dArr.length);
    }

    public static void v(double[] dArr, int i2, int i3) {
        Preconditions.E(dArr);
        Preconditions.f0(i2, i3, dArr.length);
        for (int i4 = i3 - 1; i2 < i4; i4--) {
            double d2 = dArr[i2];
            dArr[i2] = dArr[i4];
            dArr[i4] = d2;
            i2++;
        }
    }

    public static void w(double[] dArr, int i2) {
        x(dArr, i2, 0, dArr.length);
    }

    public static void x(double[] dArr, int i2, int i3, int i4) {
        Preconditions.E(dArr);
        Preconditions.f0(i3, i4, dArr.length);
        if (dArr.length > 1) {
            int i5 = i4 - i3;
            int i6 = (-i2) % i5;
            if (i6 < 0) {
                i6 += i5;
            }
            int i7 = i6 + i3;
            if (i7 != i3) {
                v(dArr, i3, i7);
                v(dArr, i7, i4);
                v(dArr, i3, i4);
            }
        }
    }

    public static void y(double[] dArr) {
        Preconditions.E(dArr);
        z(dArr, 0, dArr.length);
    }

    public static void z(double[] dArr, int i2, int i3) {
        Preconditions.E(dArr);
        Preconditions.f0(i2, i3, dArr.length);
        Arrays.sort(dArr, i2, i3);
        v(dArr, i2, i3);
    }
}
