package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class PairedStatsAccumulator {

    /* renamed from: a  reason: collision with root package name */
    private final StatsAccumulator f22858a = new StatsAccumulator();

    /* renamed from: b  reason: collision with root package name */
    private final StatsAccumulator f22859b = new StatsAccumulator();

    /* renamed from: c  reason: collision with root package name */
    private double f22860c = 0.0d;

    private static double d(double d2) {
        return Doubles.f(d2, -1.0d, 1.0d);
    }

    private double e(double d2) {
        if (d2 > 0.0d) {
            return d2;
        }
        return Double.MIN_VALUE;
    }

    public void a(double d2, double d3) {
        this.f22858a.a(d2);
        if (!Doubles.n(d2) || !Doubles.n(d3)) {
            this.f22860c = Double.NaN;
        } else if (this.f22858a.j() > 1) {
            this.f22860c += (d2 - this.f22858a.l()) * (d3 - this.f22859b.l());
        }
        this.f22859b.a(d3);
    }

    public void b(PairedStats pairedStats) {
        if (pairedStats.a() != 0) {
            this.f22858a.b(pairedStats.k());
            this.f22860c = this.f22859b.j() == 0 ? pairedStats.i() : this.f22860c + pairedStats.i() + ((pairedStats.k().d() - this.f22858a.l()) * (pairedStats.l().d() - this.f22859b.l()) * ((double) pairedStats.a()));
            this.f22859b.b(pairedStats.l());
        }
    }

    public long c() {
        return this.f22858a.j();
    }

    public final LinearTransformation f() {
        boolean z = false;
        Preconditions.g0(c() > 1);
        if (Double.isNaN(this.f22860c)) {
            return LinearTransformation.a();
        }
        double u = this.f22858a.u();
        if (u > 0.0d) {
            return this.f22859b.u() > 0.0d ? LinearTransformation.f(this.f22858a.l(), this.f22859b.l()).b(this.f22860c / u) : LinearTransformation.b(this.f22859b.l());
        }
        if (this.f22859b.u() > 0.0d) {
            z = true;
        }
        Preconditions.g0(z);
        return LinearTransformation.i(this.f22858a.l());
    }

    public final double g() {
        boolean z = false;
        Preconditions.g0(c() > 1);
        if (Double.isNaN(this.f22860c)) {
            return Double.NaN;
        }
        double u = this.f22858a.u();
        double u2 = this.f22859b.u();
        Preconditions.g0(u > 0.0d);
        if (u2 > 0.0d) {
            z = true;
        }
        Preconditions.g0(z);
        return d(this.f22860c / Math.sqrt(e(u * u2)));
    }

    public double h() {
        Preconditions.g0(c() != 0);
        return this.f22860c / ((double) c());
    }

    public final double i() {
        Preconditions.g0(c() > 1);
        return this.f22860c / ((double) (c() - 1));
    }

    public PairedStats j() {
        return new PairedStats(this.f22858a.s(), this.f22859b.s(), this.f22860c);
    }

    public Stats k() {
        return this.f22858a.s();
    }

    public Stats l() {
        return this.f22859b.s();
    }
}
