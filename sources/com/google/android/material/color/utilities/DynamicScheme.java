package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class DynamicScheme {

    /* renamed from: a  reason: collision with root package name */
    public final int f21191a;

    /* renamed from: b  reason: collision with root package name */
    public final Hct f21192b;

    /* renamed from: c  reason: collision with root package name */
    public final Variant f21193c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f21194d;

    /* renamed from: e  reason: collision with root package name */
    public final double f21195e;

    /* renamed from: f  reason: collision with root package name */
    public final TonalPalette f21196f;

    /* renamed from: g  reason: collision with root package name */
    public final TonalPalette f21197g;

    /* renamed from: h  reason: collision with root package name */
    public final TonalPalette f21198h;

    /* renamed from: i  reason: collision with root package name */
    public final TonalPalette f21199i;

    /* renamed from: j  reason: collision with root package name */
    public final TonalPalette f21200j;

    /* renamed from: k  reason: collision with root package name */
    public final TonalPalette f21201k = TonalPalette.c(25.0d, 84.0d);

    public DynamicScheme(Hct hct, Variant variant, boolean z, double d2, TonalPalette tonalPalette, TonalPalette tonalPalette2, TonalPalette tonalPalette3, TonalPalette tonalPalette4, TonalPalette tonalPalette5) {
        this.f21191a = hct.k();
        this.f21192b = hct;
        this.f21193c = variant;
        this.f21194d = z;
        this.f21195e = d2;
        this.f21196f = tonalPalette;
        this.f21197g = tonalPalette2;
        this.f21198h = tonalPalette3;
        this.f21199i = tonalPalette4;
        this.f21200j = tonalPalette5;
    }

    public static double a(Hct hct, double[] dArr, double[] dArr2) {
        double d2;
        double d3 = hct.d();
        int i2 = 0;
        if (dArr2.length == 1) {
            d2 = dArr2[0];
        } else {
            int length = dArr.length;
            while (i2 <= length - 2) {
                double d4 = dArr[i2];
                int i3 = i2 + 1;
                double d5 = dArr[i3];
                if (d4 >= d3 || d3 >= d5) {
                    i2 = i3;
                } else {
                    d2 = dArr2[i2];
                }
            }
            return d3;
        }
        return MathUtils.g(d3 + d2);
    }
}
