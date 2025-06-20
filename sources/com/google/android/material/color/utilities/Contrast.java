package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Contrast {

    /* renamed from: a  reason: collision with root package name */
    public static final double f21161a = 1.0d;

    /* renamed from: b  reason: collision with root package name */
    public static final double f21162b = 21.0d;

    /* renamed from: c  reason: collision with root package name */
    public static final double f21163c = 3.0d;

    /* renamed from: d  reason: collision with root package name */
    public static final double f21164d = 4.5d;

    /* renamed from: e  reason: collision with root package name */
    public static final double f21165e = 7.0d;

    /* renamed from: f  reason: collision with root package name */
    private static final double f21166f = 0.04d;

    /* renamed from: g  reason: collision with root package name */
    private static final double f21167g = 0.4d;

    private Contrast() {
    }

    public static double a(double d2, double d3) {
        if (d2 >= 0.0d && d2 <= 100.0d) {
            double t = ColorUtils.t(d2);
            double d4 = ((t + 5.0d) / d3) - 5.0d;
            if (d4 >= 0.0d && d4 <= 100.0d) {
                double f2 = f(t, d4);
                double abs = Math.abs(f2 - d3);
                if (f2 < d3 && abs > f21166f) {
                    return -1.0d;
                }
                double p = ColorUtils.p(d4) - f21167g;
                if (p < 0.0d || p > 100.0d) {
                    return -1.0d;
                }
                return p;
            }
        }
        return -1.0d;
    }

    public static double b(double d2, double d3) {
        return Math.max(0.0d, a(d2, d3));
    }

    public static double c(double d2, double d3) {
        if (d2 >= 0.0d && d2 <= 100.0d) {
            double t = ColorUtils.t(d2);
            double d4 = ((t + 5.0d) * d3) - 5.0d;
            if (d4 >= 0.0d && d4 <= 100.0d) {
                double f2 = f(d4, t);
                double abs = Math.abs(f2 - d3);
                if (f2 < d3 && abs > f21166f) {
                    return -1.0d;
                }
                double p = ColorUtils.p(d4) + f21167g;
                if (p < 0.0d || p > 100.0d) {
                    return -1.0d;
                }
                return p;
            }
        }
        return -1.0d;
    }

    public static double d(double d2, double d3) {
        double c2 = c(d2, d3);
        if (c2 < 0.0d) {
            return 100.0d;
        }
        return c2;
    }

    public static double e(double d2, double d3) {
        return f(ColorUtils.t(d2), ColorUtils.t(d3));
    }

    public static double f(double d2, double d3) {
        double max = Math.max(d2, d3);
        if (max != d3) {
            d2 = d3;
        }
        return (max + 5.0d) / (d2 + 5.0d);
    }
}
