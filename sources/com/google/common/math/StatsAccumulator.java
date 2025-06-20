package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class StatsAccumulator {

    /* renamed from: a  reason: collision with root package name */
    private long f22866a = 0;

    /* renamed from: b  reason: collision with root package name */
    private double f22867b = 0.0d;

    /* renamed from: c  reason: collision with root package name */
    private double f22868c = 0.0d;

    /* renamed from: d  reason: collision with root package name */
    private double f22869d = Double.NaN;

    /* renamed from: e  reason: collision with root package name */
    private double f22870e = Double.NaN;

    static double i(double d2, double d3) {
        if (Doubles.n(d2)) {
            return d3;
        }
        if (Doubles.n(d3) || d2 == d3) {
            return d2;
        }
        return Double.NaN;
    }

    private void m(long j2, double d2, double d3, double d4, double d5) {
        long j3 = j2;
        double d6 = d2;
        double d7 = d3;
        double d8 = d4;
        double d9 = d5;
        long j4 = this.f22866a;
        if (j4 == 0) {
            this.f22866a = j3;
            this.f22867b = d6;
            this.f22868c = d7;
            this.f22869d = d8;
            this.f22870e = d9;
            return;
        }
        this.f22866a = j4 + j3;
        if (!Doubles.n(this.f22867b) || !Doubles.n(d2)) {
            this.f22867b = i(this.f22867b, d6);
            this.f22868c = Double.NaN;
        } else {
            double d10 = this.f22867b;
            double d11 = d6 - d10;
            double d12 = (double) j3;
            double d13 = d10 + ((d11 * d12) / ((double) this.f22866a));
            this.f22867b = d13;
            this.f22868c += d7 + (d11 * (d6 - d13) * d12);
        }
        this.f22869d = Math.min(this.f22869d, d8);
        this.f22870e = Math.max(this.f22870e, d5);
    }

    public void a(double d2) {
        long j2 = this.f22866a;
        double d3 = Double.NaN;
        if (j2 == 0) {
            this.f22866a = 1;
            this.f22867b = d2;
            this.f22869d = d2;
            this.f22870e = d2;
            if (!Doubles.n(d2)) {
                this.f22868c = Double.NaN;
                return;
            }
            return;
        }
        this.f22866a = j2 + 1;
        if (!Doubles.n(d2) || !Doubles.n(this.f22867b)) {
            this.f22867b = i(this.f22867b, d2);
        } else {
            double d4 = this.f22867b;
            double d5 = d2 - d4;
            double d6 = d4 + (d5 / ((double) this.f22866a));
            this.f22867b = d6;
            d3 = this.f22868c + (d5 * (d2 - d6));
        }
        this.f22868c = d3;
        this.f22869d = Math.min(this.f22869d, d2);
        this.f22870e = Math.max(this.f22870e, d2);
    }

    public void b(Stats stats) {
        if (stats.a() != 0) {
            m(stats.a(), stats.d(), stats.v(), stats.j(), stats.c());
        }
    }

    public void c(StatsAccumulator statsAccumulator) {
        if (statsAccumulator.j() != 0) {
            m(statsAccumulator.j(), statsAccumulator.l(), statsAccumulator.u(), statsAccumulator.n(), statsAccumulator.k());
        }
    }

    public void d(Iterable<? extends Number> iterable) {
        for (Number doubleValue : iterable) {
            a(doubleValue.doubleValue());
        }
    }

    public void e(Iterator<? extends Number> it2) {
        while (it2.hasNext()) {
            a(((Number) it2.next()).doubleValue());
        }
    }

    public void f(double... dArr) {
        for (double a2 : dArr) {
            a(a2);
        }
    }

    public void g(int... iArr) {
        for (int i2 : iArr) {
            a((double) i2);
        }
    }

    public void h(long... jArr) {
        for (long j2 : jArr) {
            a((double) j2);
        }
    }

    public long j() {
        return this.f22866a;
    }

    public double k() {
        Preconditions.g0(this.f22866a != 0);
        return this.f22870e;
    }

    public double l() {
        Preconditions.g0(this.f22866a != 0);
        return this.f22867b;
    }

    public double n() {
        Preconditions.g0(this.f22866a != 0);
        return this.f22869d;
    }

    public final double o() {
        return Math.sqrt(p());
    }

    public final double p() {
        Preconditions.g0(this.f22866a != 0);
        if (Double.isNaN(this.f22868c)) {
            return Double.NaN;
        }
        if (this.f22866a == 1) {
            return 0.0d;
        }
        return DoubleUtils.b(this.f22868c) / ((double) this.f22866a);
    }

    public final double q() {
        return Math.sqrt(r());
    }

    public final double r() {
        Preconditions.g0(this.f22866a > 1);
        if (Double.isNaN(this.f22868c)) {
            return Double.NaN;
        }
        return DoubleUtils.b(this.f22868c) / ((double) (this.f22866a - 1));
    }

    public Stats s() {
        return new Stats(this.f22866a, this.f22867b, this.f22868c, this.f22869d, this.f22870e);
    }

    public final double t() {
        return this.f22867b * ((double) this.f22866a);
    }

    /* access modifiers changed from: package-private */
    public double u() {
        return this.f22868c;
    }
}
