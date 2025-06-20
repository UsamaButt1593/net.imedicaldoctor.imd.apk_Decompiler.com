package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class PairedStats implements Serializable {
    private static final long X2 = 0;
    private static final int Z = 88;
    private final Stats X;
    private final double Y;
    private final Stats s;

    PairedStats(Stats stats, Stats stats2, double d2) {
        this.s = stats;
        this.X = stats2;
        this.Y = d2;
    }

    private static double b(double d2) {
        if (d2 >= 1.0d) {
            return 1.0d;
        }
        if (d2 <= -1.0d) {
            return -1.0d;
        }
        return d2;
    }

    private static double c(double d2) {
        if (d2 > 0.0d) {
            return d2;
        }
        return Double.MIN_VALUE;
    }

    public static PairedStats d(byte[] bArr) {
        Preconditions.E(bArr);
        Preconditions.m(bArr.length == 88, "Expected PairedStats.BYTES = %s, got %s", 88, bArr.length);
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        return new PairedStats(Stats.r(order), Stats.r(order), order.getDouble());
    }

    public long a() {
        return this.s.a();
    }

    public LinearTransformation e() {
        boolean z = false;
        Preconditions.g0(a() > 1);
        if (Double.isNaN(this.Y)) {
            return LinearTransformation.a();
        }
        double v = this.s.v();
        if (v > 0.0d) {
            return this.X.v() > 0.0d ? LinearTransformation.f(this.s.d(), this.X.d()).b(this.Y / v) : LinearTransformation.b(this.X.d());
        }
        if (this.X.v() > 0.0d) {
            z = true;
        }
        Preconditions.g0(z);
        return LinearTransformation.i(this.s.d());
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == null || PairedStats.class != obj.getClass()) {
            return false;
        }
        PairedStats pairedStats = (PairedStats) obj;
        return this.s.equals(pairedStats.s) && this.X.equals(pairedStats.X) && Double.doubleToLongBits(this.Y) == Double.doubleToLongBits(pairedStats.Y);
    }

    public double f() {
        boolean z = false;
        Preconditions.g0(a() > 1);
        if (Double.isNaN(this.Y)) {
            return Double.NaN;
        }
        double v = k().v();
        double v2 = l().v();
        Preconditions.g0(v > 0.0d);
        if (v2 > 0.0d) {
            z = true;
        }
        Preconditions.g0(z);
        return b(this.Y / Math.sqrt(c(v * v2)));
    }

    public double g() {
        Preconditions.g0(a() != 0);
        return this.Y / ((double) a());
    }

    public double h() {
        Preconditions.g0(a() > 1);
        return this.Y / ((double) (a() - 1));
    }

    public int hashCode() {
        return Objects.b(this.s, this.X, Double.valueOf(this.Y));
    }

    /* access modifiers changed from: package-private */
    public double i() {
        return this.Y;
    }

    public byte[] j() {
        ByteBuffer order = ByteBuffer.allocate(88).order(ByteOrder.LITTLE_ENDIAN);
        this.s.x(order);
        this.X.x(order);
        order.putDouble(this.Y);
        return order.array();
    }

    public Stats k() {
        return this.s;
    }

    public Stats l() {
        return this.X;
    }

    public String toString() {
        int i2 = (a() > 0 ? 1 : (a() == 0 ? 0 : -1));
        MoreObjects.ToStringHelper f2 = MoreObjects.c(this).f("xStats", this.s).f("yStats", this.X);
        return i2 > 0 ? f2.b("populationCovariance", g()).toString() : f2.toString();
    }
}
