package com.google.common.math;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class Stats implements Serializable {
    static final int Y2 = 40;
    private static final long Z2 = 0;
    private final double X;
    private final double X2;
    private final double Y;
    private final double Z;
    private final long s;

    Stats(long j2, double d2, double d3, double d4, double d5) {
        this.s = j2;
        this.X = d2;
        this.Y = d3;
        this.Z = d4;
        this.X2 = d5;
    }

    public static Stats b(byte[] bArr) {
        Preconditions.E(bArr);
        Preconditions.m(bArr.length == 40, "Expected Stats.BYTES = %s remaining , got %s", 40, bArr.length);
        return r(ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN));
    }

    public static double e(Iterable<? extends Number> iterable) {
        return f(iterable.iterator());
    }

    public static double f(Iterator<? extends Number> it2) {
        Preconditions.d(it2.hasNext());
        double doubleValue = ((Number) it2.next()).doubleValue();
        long j2 = 1;
        while (it2.hasNext()) {
            double doubleValue2 = ((Number) it2.next()).doubleValue();
            j2++;
            doubleValue = (!Doubles.n(doubleValue2) || !Doubles.n(doubleValue)) ? StatsAccumulator.i(doubleValue, doubleValue2) : doubleValue + ((doubleValue2 - doubleValue) / ((double) j2));
        }
        return doubleValue;
    }

    public static double g(double... dArr) {
        Preconditions.d(dArr.length > 0);
        double d2 = dArr[0];
        for (int i2 = 1; i2 < dArr.length; i2++) {
            double d3 = dArr[i2];
            d2 = (!Doubles.n(d3) || !Doubles.n(d2)) ? StatsAccumulator.i(d2, d3) : d2 + ((d3 - d2) / ((double) (i2 + 1)));
        }
        return d2;
    }

    public static double h(int... iArr) {
        Preconditions.d(iArr.length > 0);
        double d2 = (double) iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            double d3 = (double) iArr[i2];
            d2 = (!Doubles.n(d3) || !Doubles.n(d2)) ? StatsAccumulator.i(d2, d3) : d2 + ((d3 - d2) / ((double) (i2 + 1)));
        }
        return d2;
    }

    public static double i(long... jArr) {
        Preconditions.d(jArr.length > 0);
        double d2 = (double) jArr[0];
        for (int i2 = 1; i2 < jArr.length; i2++) {
            double d3 = (double) jArr[i2];
            d2 = (!Doubles.n(d3) || !Doubles.n(d2)) ? StatsAccumulator.i(d2, d3) : d2 + ((d3 - d2) / ((double) (i2 + 1)));
        }
        return d2;
    }

    public static Stats k(Iterable<? extends Number> iterable) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.d(iterable);
        return statsAccumulator.s();
    }

    public static Stats l(Iterator<? extends Number> it2) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.e(it2);
        return statsAccumulator.s();
    }

    public static Stats m(double... dArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.f(dArr);
        return statsAccumulator.s();
    }

    public static Stats n(int... iArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.g(iArr);
        return statsAccumulator.s();
    }

    public static Stats o(long... jArr) {
        StatsAccumulator statsAccumulator = new StatsAccumulator();
        statsAccumulator.h(jArr);
        return statsAccumulator.s();
    }

    static Stats r(ByteBuffer byteBuffer) {
        Preconditions.E(byteBuffer);
        Preconditions.m(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        return new Stats(byteBuffer.getLong(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble(), byteBuffer.getDouble());
    }

    public long a() {
        return this.s;
    }

    public double c() {
        Preconditions.g0(this.s != 0);
        return this.X2;
    }

    public double d() {
        Preconditions.g0(this.s != 0);
        return this.X;
    }

    public boolean equals(@CheckForNull Object obj) {
        if (obj == null || Stats.class != obj.getClass()) {
            return false;
        }
        Stats stats = (Stats) obj;
        return this.s == stats.s && Double.doubleToLongBits(this.X) == Double.doubleToLongBits(stats.X) && Double.doubleToLongBits(this.Y) == Double.doubleToLongBits(stats.Y) && Double.doubleToLongBits(this.Z) == Double.doubleToLongBits(stats.Z) && Double.doubleToLongBits(this.X2) == Double.doubleToLongBits(stats.X2);
    }

    public int hashCode() {
        return Objects.b(Long.valueOf(this.s), Double.valueOf(this.X), Double.valueOf(this.Y), Double.valueOf(this.Z), Double.valueOf(this.X2));
    }

    public double j() {
        Preconditions.g0(this.s != 0);
        return this.Z;
    }

    public double p() {
        return Math.sqrt(q());
    }

    public double q() {
        Preconditions.g0(this.s > 0);
        if (Double.isNaN(this.Y)) {
            return Double.NaN;
        }
        if (this.s == 1) {
            return 0.0d;
        }
        return DoubleUtils.b(this.Y) / ((double) a());
    }

    public double s() {
        return Math.sqrt(t());
    }

    public double t() {
        Preconditions.g0(this.s > 1);
        if (Double.isNaN(this.Y)) {
            return Double.NaN;
        }
        return DoubleUtils.b(this.Y) / ((double) (this.s - 1));
    }

    public String toString() {
        int i2 = (a() > 0 ? 1 : (a() == 0 ? 0 : -1));
        MoreObjects.ToStringHelper e2 = MoreObjects.c(this).e("count", this.s);
        return i2 > 0 ? e2.b("mean", this.X).b("populationStandardDeviation", p()).b("min", this.Z).b("max", this.X2).toString() : e2.toString();
    }

    public double u() {
        return this.X * ((double) this.s);
    }

    /* access modifiers changed from: package-private */
    public double v() {
        return this.Y;
    }

    public byte[] w() {
        ByteBuffer order = ByteBuffer.allocate(40).order(ByteOrder.LITTLE_ENDIAN);
        x(order);
        return order.array();
    }

    /* access modifiers changed from: package-private */
    public void x(ByteBuffer byteBuffer) {
        Preconditions.E(byteBuffer);
        Preconditions.m(byteBuffer.remaining() >= 40, "Expected at least Stats.BYTES = %s remaining , got %s", 40, byteBuffer.remaining());
        byteBuffer.putLong(this.s).putDouble(this.X).putDouble(this.Y).putDouble(this.Z).putDouble(this.X2);
    }
}
