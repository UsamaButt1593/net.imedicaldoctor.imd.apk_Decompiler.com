package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ColorUtils {

    /* renamed from: a  reason: collision with root package name */
    static final double[][] f21158a = {new double[]{0.41233895d, 0.35762064d, 0.18051042d}, new double[]{0.2126d, 0.7152d, 0.0722d}, new double[]{0.01932141d, 0.11916382d, 0.95034478d}};

    /* renamed from: b  reason: collision with root package name */
    static final double[][] f21159b = {new double[]{3.2413774792388685d, -1.5376652402851851d, -0.49885366846268053d}, new double[]{-0.9691452513005321d, 1.8758853451067872d, 0.04156585616912061d}, new double[]{0.05562093689691305d, -0.20395524564742123d, 1.0571799111220335d}};

    /* renamed from: c  reason: collision with root package name */
    static final double[] f21160c = {95.047d, 100.0d, 108.883d};

    private ColorUtils() {
    }

    public static int a(int i2) {
        return (i2 >> 24) & 255;
    }

    public static int b(double d2, double d3, double d4) {
        double[] dArr = f21160c;
        double d5 = (d2 + 16.0d) / 116.0d;
        double d6 = d5 - (d4 / 200.0d);
        return f(m((d3 / 500.0d) + d5) * dArr[0], m(d5) * dArr[1], m(d6) * dArr[2]);
    }

    public static int c(double[] dArr) {
        return e(h(dArr[0]), h(dArr[1]), h(dArr[2]));
    }

    public static int d(double d2) {
        int h2 = h(t(d2));
        return e(h2, h2, h2);
    }

    public static int e(int i2, int i3, int i4) {
        return ((i2 & 255) << 16) | ViewCompat.y | ((i3 & 255) << 8) | (i4 & 255);
    }

    public static int f(double d2, double d3, double d4) {
        double[][] dArr = f21159b;
        double[] dArr2 = dArr[0];
        double d5 = (dArr2[0] * d2) + (dArr2[1] * d3) + (dArr2[2] * d4);
        double[] dArr3 = dArr[1];
        double d6 = (dArr3[0] * d2) + (dArr3[1] * d3) + (dArr3[2] * d4);
        double[] dArr4 = dArr[2];
        return e(h(d5), h(d6), h((dArr4[0] * d2) + (dArr4[1] * d3) + (dArr4[2] * d4)));
    }

    public static int g(int i2) {
        return i2 & 255;
    }

    public static int h(double d2) {
        double d3 = d2 / 100.0d;
        return MathUtils.b(0, 255, (int) Math.round((d3 <= 0.0031308d ? d3 * 12.92d : (Math.pow(d3, 0.4166666666666667d) * 1.055d) - 0.055d) * 255.0d));
    }

    public static int i(int i2) {
        return (i2 >> 8) & 255;
    }

    public static boolean j(int i2) {
        return a(i2) >= 255;
    }

    static double k(double d2) {
        return d2 > 0.008856451679035631d ? Math.pow(d2, 0.3333333333333333d) : ((d2 * 903.2962962962963d) + 16.0d) / 116.0d;
    }

    public static double[] l(int i2) {
        double n2 = n(q(i2));
        double n3 = n(i(i2));
        double n4 = n(g(i2));
        double[][] dArr = f21158a;
        double[] dArr2 = dArr[0];
        double d2 = (dArr2[0] * n2) + (dArr2[1] * n3) + (dArr2[2] * n4);
        double[] dArr3 = dArr[1];
        double d3 = (dArr3[0] * n2) + (dArr3[1] * n3) + (dArr3[2] * n4);
        double[] dArr4 = dArr[2];
        double d4 = (dArr4[0] * n2) + (dArr4[1] * n3) + (dArr4[2] * n4);
        double[] dArr5 = f21160c;
        double d5 = d2 / dArr5[0];
        double d6 = d3 / dArr5[1];
        double k2 = k(d5);
        double k3 = k(d6);
        return new double[]{(116.0d * k3) - 16.0d, (k2 - k3) * 500.0d, (k3 - k(d4 / dArr5[2])) * 200.0d};
    }

    static double m(double d2) {
        double d3 = d2 * d2 * d2;
        return d3 > 0.008856451679035631d ? d3 : ((d2 * 116.0d) - 16.0d) / 903.2962962962963d;
    }

    public static double n(int i2) {
        double d2 = ((double) i2) / 255.0d;
        return (d2 <= 0.040449936d ? d2 / 12.92d : Math.pow((d2 + 0.055d) / 1.055d, 2.4d)) * 100.0d;
    }

    public static double o(int i2) {
        return (k(s(i2)[1] / 100.0d) * 116.0d) - 16.0d;
    }

    public static double p(double d2) {
        return (k(d2 / 100.0d) * 116.0d) - 16.0d;
    }

    public static int q(int i2) {
        return (i2 >> 16) & 255;
    }

    public static double[] r() {
        return f21160c;
    }

    public static double[] s(int i2) {
        return MathUtils.e(new double[]{n(q(i2)), n(i(i2)), n(g(i2))}, f21158a);
    }

    public static double t(double d2) {
        return m((d2 + 16.0d) / 116.0d) * 100.0d;
    }
}
