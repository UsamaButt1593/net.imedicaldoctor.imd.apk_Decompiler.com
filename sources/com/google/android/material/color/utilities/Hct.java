package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class Hct {

    /* renamed from: a  reason: collision with root package name */
    private double f21206a;

    /* renamed from: b  reason: collision with root package name */
    private double f21207b;

    /* renamed from: c  reason: collision with root package name */
    private double f21208c;

    /* renamed from: d  reason: collision with root package name */
    private int f21209d;

    private Hct(int i2) {
        i(i2);
    }

    public static Hct a(double d2, double d3, double d4) {
        return new Hct(HctSolver.r(d2, d3, d4));
    }

    public static Hct b(int i2) {
        return new Hct(i2);
    }

    private void i(int i2) {
        this.f21209d = i2;
        Cam16 b2 = Cam16.b(i2);
        this.f21206a = b2.l();
        this.f21207b = b2.k();
        this.f21208c = ColorUtils.o(i2);
    }

    public double c() {
        return this.f21207b;
    }

    public double d() {
        return this.f21206a;
    }

    public double e() {
        return this.f21208c;
    }

    public Hct f(ViewingConditions viewingConditions) {
        double[] t = Cam16.b(k()).t(viewingConditions, (double[]) null);
        Cam16 h2 = Cam16.h(t[0], t[1], t[2], ViewingConditions.f21290k);
        return a(h2.l(), h2.k(), ColorUtils.p(t[1]));
    }

    public void g(double d2) {
        i(HctSolver.r(this.f21206a, d2, this.f21208c));
    }

    public void h(double d2) {
        i(HctSolver.r(d2, this.f21207b, this.f21208c));
    }

    public void j(double d2) {
        i(HctSolver.r(this.f21206a, this.f21207b, d2));
    }

    public int k() {
        return this.f21209d;
    }
}
