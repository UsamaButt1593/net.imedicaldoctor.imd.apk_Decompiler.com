package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class TonalPalette {

    /* renamed from: a  reason: collision with root package name */
    Map<Integer, Integer> f21281a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    Hct f21282b;

    /* renamed from: c  reason: collision with root package name */
    double f21283c;

    /* renamed from: d  reason: collision with root package name */
    double f21284d;

    private TonalPalette(double d2, double d3, Hct hct) {
        this.f21283c = d2;
        this.f21284d = d3;
        this.f21282b = hct;
    }

    private static Hct a(double d2, double d3) {
        Hct a2 = Hct.a(d2, d3, 50.0d);
        Hct hct = a2;
        double abs = Math.abs(a2.c() - d3);
        for (double d4 = 1.0d; d4 < 50.0d && Math.round(d3) != Math.round(hct.c()); d4 += 1.0d) {
            Hct a3 = Hct.a(d2, d3, 50.0d + d4);
            double abs2 = Math.abs(a3.c() - d3);
            if (abs2 < abs) {
                hct = a3;
                abs = abs2;
            }
            Hct a4 = Hct.a(d2, d3, 50.0d - d4);
            double abs3 = Math.abs(a4.c() - d3);
            if (abs3 < abs) {
                hct = a4;
                abs = abs3;
            }
        }
        return hct;
    }

    public static TonalPalette b(Hct hct) {
        return new TonalPalette(hct.d(), hct.c(), hct);
    }

    public static TonalPalette c(double d2, double d3) {
        return new TonalPalette(d2, d3, a(d2, d3));
    }

    public static TonalPalette d(int i2) {
        return b(Hct.b(i2));
    }

    public double e() {
        return this.f21284d;
    }

    public Hct f(double d2) {
        return Hct.a(this.f21283c, this.f21284d, d2);
    }

    public double g() {
        return this.f21283c;
    }

    public Hct h() {
        return this.f21282b;
    }

    public int i(int i2) {
        Integer num = this.f21281a.get(Integer.valueOf(i2));
        if (num == null) {
            num = Integer.valueOf(Hct.a(this.f21283c, this.f21284d, (double) i2).k());
            this.f21281a.put(Integer.valueOf(i2), num);
        }
        return num.intValue();
    }
}
