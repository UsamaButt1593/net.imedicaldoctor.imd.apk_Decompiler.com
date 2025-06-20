package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.Ints;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class Quantiles {

    public static final class Scale {

        /* renamed from: a  reason: collision with root package name */
        private final int f22861a;

        private Scale(int i2) {
            Preconditions.e(i2 > 0, "Quantile scale must be positive");
            this.f22861a = i2;
        }

        public ScaleAndIndex a(int i2) {
            return new ScaleAndIndex(this.f22861a, i2);
        }

        public ScaleAndIndexes b(Collection<Integer> collection) {
            return new ScaleAndIndexes(this.f22861a, Ints.D(collection));
        }

        public ScaleAndIndexes c(int... iArr) {
            return new ScaleAndIndexes(this.f22861a, (int[]) iArr.clone());
        }
    }

    public static final class ScaleAndIndex {

        /* renamed from: a  reason: collision with root package name */
        private final int f22862a;

        /* renamed from: b  reason: collision with root package name */
        private final int f22863b;

        private ScaleAndIndex(int i2, int i3) {
            Quantiles.h(i3, i2);
            this.f22862a = i2;
            this.f22863b = i3;
        }

        public double a(Collection<? extends Number> collection) {
            return e(Doubles.B(collection));
        }

        public double b(double... dArr) {
            return e((double[]) dArr.clone());
        }

        public double c(int... iArr) {
            return e(Quantiles.l(iArr));
        }

        public double d(long... jArr) {
            return e(Quantiles.m(jArr));
        }

        public double e(double... dArr) {
            Preconditions.e(dArr.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.j(dArr)) {
                return Double.NaN;
            }
            long length = ((long) this.f22863b) * ((long) (dArr.length - 1));
            int g2 = (int) LongMath.g(length, (long) this.f22862a, RoundingMode.DOWN);
            int i2 = (int) (length - (((long) g2) * ((long) this.f22862a)));
            Quantiles.u(g2, dArr, 0, dArr.length - 1);
            if (i2 == 0) {
                return dArr[g2];
            }
            int i3 = g2 + 1;
            Quantiles.u(i3, dArr, i3, dArr.length - 1);
            return Quantiles.k(dArr[g2], dArr[i3], (double) i2, (double) this.f22862a);
        }
    }

    public static final class ScaleAndIndexes {

        /* renamed from: a  reason: collision with root package name */
        private final int f22864a;

        /* renamed from: b  reason: collision with root package name */
        private final int[] f22865b;

        private ScaleAndIndexes(int i2, int[] iArr) {
            boolean z = false;
            for (int a2 : iArr) {
                Quantiles.h(a2, i2);
            }
            Preconditions.e(iArr.length > 0 ? true : z, "Indexes must be a non empty array");
            this.f22864a = i2;
            this.f22865b = iArr;
        }

        public Map<Integer, Double> a(Collection<? extends Number> collection) {
            return e(Doubles.B(collection));
        }

        public Map<Integer, Double> b(double... dArr) {
            return e((double[]) dArr.clone());
        }

        public Map<Integer, Double> c(int... iArr) {
            return e(Quantiles.l(iArr));
        }

        public Map<Integer, Double> d(long... jArr) {
            return e(Quantiles.m(jArr));
        }

        public Map<Integer, Double> e(double... dArr) {
            Integer valueOf;
            double f2;
            double[] dArr2 = dArr;
            int i2 = 0;
            int i3 = 1;
            Preconditions.e(dArr2.length > 0, "Cannot calculate quantiles of an empty dataset");
            if (Quantiles.j(dArr)) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                int[] iArr = this.f22865b;
                int length = iArr.length;
                while (i2 < length) {
                    linkedHashMap.put(Integer.valueOf(iArr[i2]), Double.valueOf(Double.NaN));
                    i2++;
                }
                return Collections.unmodifiableMap(linkedHashMap);
            }
            int[] iArr2 = this.f22865b;
            int[] iArr3 = new int[iArr2.length];
            int[] iArr4 = new int[iArr2.length];
            int[] iArr5 = new int[(iArr2.length * 2)];
            int i4 = 0;
            int i5 = 0;
            while (true) {
                int[] iArr6 = this.f22865b;
                if (i4 >= iArr6.length) {
                    break;
                }
                long length2 = ((long) iArr6[i4]) * ((long) (dArr2.length - i3));
                int g2 = (int) LongMath.g(length2, (long) this.f22864a, RoundingMode.DOWN);
                int i6 = i4;
                int i7 = (int) (length2 - (((long) g2) * ((long) this.f22864a)));
                iArr3[i6] = g2;
                iArr4[i6] = i7;
                iArr5[i5] = g2;
                int i8 = i5 + 1;
                if (i7 != 0) {
                    iArr5[i8] = g2 + 1;
                    i5 += 2;
                } else {
                    i5 = i8;
                }
                i4 = i6 + 1;
                i3 = 1;
            }
            Arrays.sort(iArr5, 0, i5);
            Quantiles.t(iArr5, 0, i5 - 1, dArr, 0, dArr2.length - 1);
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            while (true) {
                int[] iArr7 = this.f22865b;
                if (i2 >= iArr7.length) {
                    return Collections.unmodifiableMap(linkedHashMap2);
                }
                int i9 = iArr3[i2];
                int i10 = iArr4[i2];
                if (i10 == 0) {
                    valueOf = Integer.valueOf(iArr7[i2]);
                    f2 = dArr2[i9];
                } else {
                    valueOf = Integer.valueOf(iArr7[i2]);
                    f2 = Quantiles.k(dArr2[i9], dArr2[i9 + 1], (double) i10, (double) this.f22864a);
                }
                linkedHashMap2.put(valueOf, Double.valueOf(f2));
                i2++;
            }
        }
    }

    /* access modifiers changed from: private */
    public static void h(int i2, int i3) {
        if (i2 < 0 || i2 > i3) {
            throw new IllegalArgumentException("Quantile indexes must be between 0 and the scale, which is " + i3);
        }
    }

    private static int i(int[] iArr, int i2, int i3, int i4, int i5) {
        if (i2 == i3) {
            return i2;
        }
        int i6 = i4 + i5;
        int i7 = i6 >>> 1;
        while (i3 > i2 + 1) {
            int i8 = (i2 + i3) >>> 1;
            int i9 = iArr[i8];
            if (i9 > i7) {
                i3 = i8;
            } else if (i9 >= i7) {
                return i8;
            } else {
                i2 = i8;
            }
        }
        return (i6 - iArr[i2]) - iArr[i3] > 0 ? i3 : i2;
    }

    /* access modifiers changed from: private */
    public static boolean j(double... dArr) {
        for (double isNaN : dArr) {
            if (Double.isNaN(isNaN)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static double k(double d2, double d3, double d4, double d5) {
        if (d2 == Double.NEGATIVE_INFINITY) {
            return d3 == Double.POSITIVE_INFINITY ? Double.NaN : Double.NEGATIVE_INFINITY;
        }
        if (d3 == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }
        return d2 + (((d3 - d2) * d4) / d5);
    }

    /* access modifiers changed from: private */
    public static double[] l(int[] iArr) {
        int length = iArr.length;
        double[] dArr = new double[length];
        for (int i2 = 0; i2 < length; i2++) {
            dArr[i2] = (double) iArr[i2];
        }
        return dArr;
    }

    /* access modifiers changed from: private */
    public static double[] m(long[] jArr) {
        int length = jArr.length;
        double[] dArr = new double[length];
        for (int i2 = 0; i2 < length; i2++) {
            dArr[i2] = (double) jArr[i2];
        }
        return dArr;
    }

    public static ScaleAndIndex n() {
        return s(2).a(1);
    }

    private static void o(double[] dArr, int i2, int i3) {
        boolean z = true;
        int i4 = (i2 + i3) >>> 1;
        double d2 = dArr[i3];
        double d3 = dArr[i4];
        boolean z2 = d2 < d3;
        double d4 = dArr[i2];
        boolean z3 = d3 < d4;
        if (d2 >= d4) {
            z = false;
        }
        if (z2 == z3) {
            v(dArr, i4, i2);
        } else if (z2 != z) {
            v(dArr, i2, i3);
        }
    }

    private static int p(double[] dArr, int i2, int i3) {
        o(dArr, i2, i3);
        double d2 = dArr[i2];
        int i4 = i3;
        while (i3 > i2) {
            if (dArr[i3] > d2) {
                v(dArr, i4, i3);
                i4--;
            }
            i3--;
        }
        v(dArr, i2, i4);
        return i4;
    }

    public static Scale q() {
        return s(100);
    }

    public static Scale r() {
        return s(4);
    }

    public static Scale s(int i2) {
        return new Scale(i2);
    }

    /* access modifiers changed from: private */
    public static void t(int[] iArr, int i2, int i3, double[] dArr, int i4, int i5) {
        int i6 = i(iArr, i2, i3, i4, i5);
        int i7 = iArr[i6];
        u(i7, dArr, i4, i5);
        int i8 = i6 - 1;
        while (i8 >= i2 && iArr[i8] == i7) {
            i8--;
        }
        if (i8 >= i2) {
            t(iArr, i2, i8, dArr, i4, i7 - 1);
        }
        int i9 = i6 + 1;
        while (i9 <= i3 && iArr[i9] == i7) {
            i9++;
        }
        if (i9 <= i3) {
            t(iArr, i9, i3, dArr, i7 + 1, i5);
        }
    }

    /* access modifiers changed from: private */
    public static void u(int i2, double[] dArr, int i3, int i4) {
        if (i2 == i3) {
            int i5 = i3;
            for (int i6 = i3 + 1; i6 <= i4; i6++) {
                if (dArr[i5] > dArr[i6]) {
                    i5 = i6;
                }
            }
            if (i5 != i3) {
                v(dArr, i5, i3);
                return;
            }
            return;
        }
        while (i4 > i3) {
            int p = p(dArr, i3, i4);
            if (p >= i2) {
                i4 = p - 1;
            }
            if (p <= i2) {
                i3 = p + 1;
            }
        }
    }

    private static void v(double[] dArr, int i2, int i3) {
        double d2 = dArr[i2];
        dArr[i2] = dArr[i3];
        dArr[i3] = d2;
    }
}
