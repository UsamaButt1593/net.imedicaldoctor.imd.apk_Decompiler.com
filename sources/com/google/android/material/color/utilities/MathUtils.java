package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class MathUtils {
    private MathUtils() {
    }

    public static double a(double d2, double d3, double d4) {
        if (d4 < d2) {
            return d2;
        }
        return d4 > d3 ? d3 : d4;
    }

    public static int b(int i2, int i3, int i4) {
        if (i4 < i2) {
            return i2;
        }
        return i4 > i3 ? i3 : i4;
    }

    public static double c(double d2, double d3) {
        return 180.0d - Math.abs(Math.abs(d2 - d3) - 180.0d);
    }

    public static double d(double d2, double d3, double d4) {
        return ((1.0d - d4) * d2) + (d4 * d3);
    }

    public static double[] e(double[] dArr, double[][] dArr2) {
        double d2 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d3 = dArr[1];
        double d4 = dArr[2];
        double d5 = (dArr3[0] * d2) + (dArr3[1] * d3) + (dArr3[2] * d4);
        double[] dArr4 = dArr2[1];
        double d6 = (dArr4[0] * d2) + (dArr4[1] * d3) + (dArr4[2] * d4);
        double[] dArr5 = dArr2[2];
        return new double[]{d5, d6, (d2 * dArr5[0]) + (d3 * dArr5[1]) + (d4 * dArr5[2])};
    }

    public static double f(double d2, double d3) {
        return g(d3 - d2) <= 180.0d ? 1.0d : -1.0d;
    }

    public static double g(double d2) {
        double d3 = d2 % 360.0d;
        return d3 < 0.0d ? d3 + 360.0d : d3;
    }

    public static int h(int i2) {
        int i3 = i2 % 360;
        return i3 < 0 ? i3 + 360 : i3;
    }

    public static int i(double d2) {
        if (d2 < 0.0d) {
            return -1;
        }
        return d2 == 0.0d ? 0 : 1;
    }
}
