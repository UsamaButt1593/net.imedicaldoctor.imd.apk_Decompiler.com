package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Cam16 {

    /* renamed from: k  reason: collision with root package name */
    static final double[][] f21146k = {new double[]{0.401288d, 0.650173d, -0.051461d}, new double[]{-0.250268d, 1.204414d, 0.045854d}, new double[]{-0.002079d, 0.048952d, 0.953127d}};

    /* renamed from: l  reason: collision with root package name */
    static final double[][] f21147l = {new double[]{1.8620678d, -1.0112547d, 0.14918678d}, new double[]{0.38752654d, 0.62144744d, -0.00897398d}, new double[]{-0.0158415d, -0.03412294d, 1.0499644d}};

    /* renamed from: a  reason: collision with root package name */
    private final double f21148a;

    /* renamed from: b  reason: collision with root package name */
    private final double f21149b;

    /* renamed from: c  reason: collision with root package name */
    private final double f21150c;

    /* renamed from: d  reason: collision with root package name */
    private final double f21151d;

    /* renamed from: e  reason: collision with root package name */
    private final double f21152e;

    /* renamed from: f  reason: collision with root package name */
    private final double f21153f;

    /* renamed from: g  reason: collision with root package name */
    private final double f21154g;

    /* renamed from: h  reason: collision with root package name */
    private final double f21155h;

    /* renamed from: i  reason: collision with root package name */
    private final double f21156i;

    /* renamed from: j  reason: collision with root package name */
    private final double[] f21157j = {0.0d, 0.0d, 0.0d};

    private Cam16(double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9, double d10) {
        this.f21148a = d2;
        this.f21149b = d3;
        this.f21150c = d4;
        this.f21151d = d5;
        this.f21152e = d6;
        this.f21153f = d7;
        this.f21154g = d8;
        this.f21155h = d9;
        this.f21156i = d10;
    }

    public static Cam16 b(int i2) {
        return c(i2, ViewingConditions.f21290k);
    }

    static Cam16 c(int i2, ViewingConditions viewingConditions) {
        int i3 = i2;
        double n2 = ColorUtils.n((16711680 & i3) >> 16);
        double n3 = ColorUtils.n((65280 & i3) >> 8);
        double n4 = ColorUtils.n(i3 & 255);
        return h((0.41233895d * n2) + (0.35762064d * n3) + (0.18051042d * n4), (0.2126d * n2) + (0.7152d * n3) + (0.0722d * n4), (n2 * 0.01932141d) + (n3 * 0.11916382d) + (n4 * 0.95034478d), viewingConditions);
    }

    static Cam16 d(double d2, double d3, double d4) {
        return e(d2, d3, d4, ViewingConditions.f21290k);
    }

    private static Cam16 e(double d2, double d3, double d4, ViewingConditions viewingConditions) {
        double d5 = d3;
        double d6 = d4;
        double d7 = d2 / 100.0d;
        double c2 = (4.0d / viewingConditions.c()) * Math.sqrt(d7) * (viewingConditions.b() + 4.0d) * viewingConditions.e();
        double e2 = d3 * viewingConditions.e();
        double radians = Math.toRadians(d4);
        double d8 = (1.7000000000000002d * d2) / ((0.007d * d2) + 1.0d);
        double log1p = 43.859649122807014d * Math.log1p(e2 * 0.0228d);
        return new Cam16(d6, d5, d2, c2, e2, Math.sqrt(((d3 / Math.sqrt(d7)) * viewingConditions.c()) / (viewingConditions.b() + 4.0d)) * 50.0d, d8, Math.cos(radians) * log1p, Math.sin(radians) * log1p);
    }

    public static Cam16 f(double d2, double d3, double d4) {
        return g(d2, d3, d4, ViewingConditions.f21290k);
    }

    public static Cam16 g(double d2, double d3, double d4, ViewingConditions viewingConditions) {
        double expm1 = (Math.expm1(Math.hypot(d3, d4) * 0.0228d) / 0.0228d) / viewingConditions.e();
        double d5 = d3;
        double atan2 = Math.atan2(d4, d3) * 57.29577951308232d;
        if (atan2 < 0.0d) {
            atan2 += 360.0d;
        }
        return e(d2 / (1.0d - ((d2 - 100.0d) * 0.007d)), expm1, atan2, viewingConditions);
    }

    static Cam16 h(double d2, double d3, double d4, ViewingConditions viewingConditions) {
        double[][] dArr = f21146k;
        double[] dArr2 = dArr[0];
        double d5 = (dArr2[0] * d2) + (dArr2[1] * d3) + (dArr2[2] * d4);
        double[] dArr3 = dArr[1];
        double d6 = (dArr3[0] * d2) + (dArr3[1] * d3) + (dArr3[2] * d4);
        double[] dArr4 = dArr[2];
        double d7 = viewingConditions.j()[0] * d5;
        double d8 = viewingConditions.j()[1] * d6;
        double d9 = viewingConditions.j()[2] * ((dArr4[0] * d2) + (dArr4[1] * d3) + (dArr4[2] * d4));
        double pow = Math.pow((viewingConditions.d() * Math.abs(d7)) / 100.0d, 0.42d);
        double pow2 = Math.pow((viewingConditions.d() * Math.abs(d8)) / 100.0d, 0.42d);
        double d10 = d9;
        double pow3 = Math.pow((viewingConditions.d() * Math.abs(d9)) / 100.0d, 0.42d);
        double signum = ((Math.signum(d7) * 400.0d) * pow) / (pow + 27.13d);
        double signum2 = ((Math.signum(d8) * 400.0d) * pow2) / (pow2 + 27.13d);
        double signum3 = ((Math.signum(d10) * 400.0d) * pow3) / (pow3 + 27.13d);
        double d11 = (((signum * 11.0d) + (-12.0d * signum2)) + signum3) / 11.0d;
        double d12 = ((signum + signum2) - (signum3 * 2.0d)) / 9.0d;
        double d13 = signum2 * 20.0d;
        double d14 = (((signum * 20.0d) + d13) + (21.0d * signum3)) / 20.0d;
        double d15 = (((signum * 40.0d) + d13) + signum3) / 20.0d;
        double degrees = Math.toDegrees(Math.atan2(d12, d11));
        if (degrees < 0.0d) {
            degrees += 360.0d;
        } else if (degrees >= 360.0d) {
            degrees -= 360.0d;
        }
        double d16 = degrees;
        double radians = Math.toRadians(d16);
        double pow4 = Math.pow((d15 * viewingConditions.g()) / viewingConditions.b(), viewingConditions.c() * viewingConditions.k()) * 100.0d;
        double d17 = pow4 / 100.0d;
        double c2 = (4.0d / viewingConditions.c()) * Math.sqrt(d17) * (viewingConditions.b() + 4.0d) * viewingConditions.e();
        double pow5 = Math.pow(1.64d - Math.pow(0.29d, viewingConditions.f()), 0.73d) * Math.pow(((((((Math.cos(Math.toRadians(d16 < 20.14d ? d16 + 360.0d : d16) + 2.0d) + 3.8d) * 0.25d) * 3846.153846153846d) * viewingConditions.h()) * viewingConditions.i()) * Math.hypot(d11, d12)) / (d14 + 0.305d), 0.9d);
        double sqrt = Math.sqrt(d17) * pow5;
        double d18 = sqrt;
        double e2 = sqrt * viewingConditions.e();
        double log1p = Math.log1p(e2 * 0.0228d) * 43.859649122807014d;
        return new Cam16(d16, d18, pow4, c2, e2, Math.sqrt((pow5 * viewingConditions.c()) / (viewingConditions.b() + 4.0d)) * 50.0d, (1.7000000000000002d * pow4) / ((0.007d * pow4) + 1.0d), log1p * Math.cos(radians), log1p * Math.sin(radians));
    }

    /* access modifiers changed from: package-private */
    public double a(Cam16 cam16) {
        double n2 = n() - cam16.n();
        double i2 = i() - cam16.i();
        double j2 = j() - cam16.j();
        return Math.pow(Math.sqrt((n2 * n2) + (i2 * i2) + (j2 * j2)), 0.63d) * 1.41d;
    }

    public double i() {
        return this.f21155h;
    }

    public double j() {
        return this.f21156i;
    }

    public double k() {
        return this.f21149b;
    }

    public double l() {
        return this.f21148a;
    }

    public double m() {
        return this.f21150c;
    }

    public double n() {
        return this.f21154g;
    }

    public double o() {
        return this.f21152e;
    }

    public double p() {
        return this.f21151d;
    }

    public double q() {
        return this.f21153f;
    }

    public int r() {
        return s(ViewingConditions.f21290k);
    }

    /* access modifiers changed from: package-private */
    public int s(ViewingConditions viewingConditions) {
        double[] t = t(viewingConditions, this.f21157j);
        return ColorUtils.f(t[0], t[1], t[2]);
    }

    /* access modifiers changed from: package-private */
    public double[] t(ViewingConditions viewingConditions, double[] dArr) {
        double pow = Math.pow(((k() == 0.0d || m() == 0.0d) ? 0.0d : k() / Math.sqrt(m() / 100.0d)) / Math.pow(1.64d - Math.pow(0.29d, viewingConditions.f()), 0.73d), 1.1111111111111112d);
        double radians = Math.toRadians(l());
        double b2 = viewingConditions.b() * Math.pow(m() / 100.0d, (1.0d / viewingConditions.c()) / viewingConditions.k());
        double cos = (Math.cos(2.0d + radians) + 3.8d) * 0.25d * 3846.153846153846d * viewingConditions.h() * viewingConditions.i();
        double g2 = b2 / viewingConditions.g();
        double sin = Math.sin(radians);
        double cos2 = Math.cos(radians);
        double d2 = (((0.305d + g2) * 23.0d) * pow) / (((cos * 23.0d) + ((11.0d * pow) * cos2)) + ((pow * 108.0d) * sin));
        double d3 = cos2 * d2;
        double d4 = d2 * sin;
        double d5 = g2 * 460.0d;
        double d6 = (((451.0d * d3) + d5) + (288.0d * d4)) / 1403.0d;
        double d7 = ((d5 - (891.0d * d3)) - (261.0d * d4)) / 1403.0d;
        double d8 = ((d5 - (d3 * 220.0d)) - (d4 * 6300.0d)) / 1403.0d;
        double signum = Math.signum(d6) * (100.0d / viewingConditions.d()) * Math.pow(Math.max(0.0d, (Math.abs(d6) * 27.13d) / (400.0d - Math.abs(d6))), 2.380952380952381d);
        double signum2 = Math.signum(d7) * (100.0d / viewingConditions.d()) * Math.pow(Math.max(0.0d, (Math.abs(d7) * 27.13d) / (400.0d - Math.abs(d7))), 2.380952380952381d);
        double signum3 = Math.signum(d8) * (100.0d / viewingConditions.d()) * Math.pow(Math.max(0.0d, (Math.abs(d8) * 27.13d) / (400.0d - Math.abs(d8))), 2.380952380952381d);
        double d9 = signum / viewingConditions.j()[0];
        double d10 = signum2 / viewingConditions.j()[1];
        double d11 = signum3 / viewingConditions.j()[2];
        double[][] dArr2 = f21147l;
        double[] dArr3 = dArr2[0];
        double d12 = (dArr3[0] * d9) + (dArr3[1] * d10) + (dArr3[2] * d11);
        double[] dArr4 = dArr2[1];
        double d13 = (dArr4[0] * d9) + (dArr4[1] * d10) + (dArr4[2] * d11);
        double[] dArr5 = dArr2[2];
        double d14 = (d9 * dArr5[0]) + (d10 * dArr5[1]) + (d11 * dArr5[2]);
        if (dArr != null) {
            dArr[0] = d12;
            dArr[1] = d13;
            dArr[2] = d14;
            return dArr;
        }
        return new double[]{d12, d13, d14};
    }
}
