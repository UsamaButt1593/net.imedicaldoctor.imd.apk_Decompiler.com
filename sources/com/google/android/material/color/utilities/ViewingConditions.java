package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ViewingConditions {

    /* renamed from: k  reason: collision with root package name */
    public static final ViewingConditions f21290k = a(50.0d);

    /* renamed from: a  reason: collision with root package name */
    private final double f21291a;

    /* renamed from: b  reason: collision with root package name */
    private final double f21292b;

    /* renamed from: c  reason: collision with root package name */
    private final double f21293c;

    /* renamed from: d  reason: collision with root package name */
    private final double f21294d;

    /* renamed from: e  reason: collision with root package name */
    private final double f21295e;

    /* renamed from: f  reason: collision with root package name */
    private final double f21296f;

    /* renamed from: g  reason: collision with root package name */
    private final double[] f21297g;

    /* renamed from: h  reason: collision with root package name */
    private final double f21298h;

    /* renamed from: i  reason: collision with root package name */
    private final double f21299i;

    /* renamed from: j  reason: collision with root package name */
    private final double f21300j;

    private ViewingConditions(double d2, double d3, double d4, double d5, double d6, double d7, double[] dArr, double d8, double d9, double d10) {
        this.f21296f = d2;
        this.f21291a = d3;
        this.f21292b = d4;
        this.f21293c = d5;
        this.f21294d = d6;
        this.f21295e = d7;
        this.f21297g = dArr;
        this.f21298h = d8;
        this.f21299i = d9;
        this.f21300j = d10;
    }

    public static ViewingConditions a(double d2) {
        return l(ColorUtils.r(), (ColorUtils.t(50.0d) * 63.66197723675813d) / 100.0d, d2, 2.0d, false);
    }

    public static ViewingConditions l(double[] dArr, double d2, double d3, double d4, boolean z) {
        double d5;
        double d6;
        double d7;
        double d8 = d2;
        double max = Math.max(0.1d, d3);
        double[][] dArr2 = Cam16.f21146k;
        double d9 = dArr[0];
        double[] dArr3 = dArr2[0];
        double d10 = dArr[1];
        double d11 = dArr[2];
        double d12 = (dArr3[0] * d9) + (dArr3[1] * d10) + (dArr3[2] * d11);
        double[] dArr4 = dArr2[1];
        double d13 = (dArr4[0] * d9) + (dArr4[1] * d10) + (dArr4[2] * d11);
        double[] dArr5 = dArr2[2];
        double d14 = (d9 * dArr5[0]) + (d10 * dArr5[1]) + (d11 * dArr5[2]);
        double d15 = (d4 / 10.0d) + 0.8d;
        if (d15 >= 0.9d) {
            d5 = (d15 - 0.9d) * 10.0d;
            d6 = 0.59d;
            d7 = 0.69d;
        } else {
            d5 = (d15 - 0.8d) * 10.0d;
            d6 = 0.525d;
            d7 = 0.59d;
        }
        double d16 = MathUtils.d(d6, d7, d5);
        double a2 = MathUtils.a(0.0d, 1.0d, z ? 1.0d : (1.0d - (Math.exp(((-d8) - 42.0d) / 92.0d) * 0.2777777777777778d)) * d15);
        double[] dArr6 = {(((100.0d / d12) * a2) + 1.0d) - a2, (((100.0d / d13) * a2) + 1.0d) - a2, (((100.0d / d14) * a2) + 1.0d) - a2};
        double d17 = 5.0d * d8;
        double d18 = 1.0d / (d17 + 1.0d);
        double d19 = d18 * d18 * d18 * d18;
        double d20 = 1.0d - d19;
        double cbrt = (d19 * d8) + (0.1d * d20 * d20 * Math.cbrt(d17));
        double t = ColorUtils.t(max) / dArr[1];
        double d21 = t;
        double sqrt = Math.sqrt(t) + 1.48d;
        double pow = 0.725d / Math.pow(t, 0.2d);
        double d22 = pow;
        double d23 = pow;
        double[] dArr7 = {Math.pow(((dArr6[0] * cbrt) * d12) / 100.0d, 0.42d), Math.pow(((dArr6[1] * cbrt) * d13) / 100.0d, 0.42d), Math.pow(((dArr6[2] * cbrt) * d14) / 100.0d, 0.42d)};
        double d24 = dArr7[0];
        double d25 = (d24 * 400.0d) / (d24 + 27.13d);
        double d26 = dArr7[1];
        double d27 = (d26 * 400.0d) / (d26 + 27.13d);
        double d28 = dArr7[2];
        double[] dArr8 = {d25, d27, (400.0d * d28) / (d28 + 27.13d)};
        return new ViewingConditions(d21, ((dArr8[0] * 2.0d) + dArr8[1] + (dArr8[2] * 0.05d)) * pow, d22, d23, d16, d15, dArr6, cbrt, Math.pow(cbrt, 0.25d), sqrt);
    }

    public double b() {
        return this.f21291a;
    }

    /* access modifiers changed from: package-private */
    public double c() {
        return this.f21294d;
    }

    /* access modifiers changed from: package-private */
    public double d() {
        return this.f21298h;
    }

    public double e() {
        return this.f21299i;
    }

    public double f() {
        return this.f21296f;
    }

    public double g() {
        return this.f21292b;
    }

    /* access modifiers changed from: package-private */
    public double h() {
        return this.f21295e;
    }

    /* access modifiers changed from: package-private */
    public double i() {
        return this.f21293c;
    }

    public double[] j() {
        return this.f21297g;
    }

    /* access modifiers changed from: package-private */
    public double k() {
        return this.f21300j;
    }
}
