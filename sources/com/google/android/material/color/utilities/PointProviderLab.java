package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class PointProviderLab implements PointProvider {
    public double a(double[] dArr, double[] dArr2) {
        double d2 = dArr[0] - dArr2[0];
        double d3 = dArr[1] - dArr2[1];
        double d4 = dArr[2] - dArr2[2];
        return (d2 * d2) + (d3 * d3) + (d4 * d4);
    }

    public int b(double[] dArr) {
        return ColorUtils.b(dArr[0], dArr[1], dArr[2]);
    }

    public double[] c(int i2) {
        double[] l2 = ColorUtils.l(i2);
        return new double[]{l2[0], l2[1], l2[2]};
    }
}
