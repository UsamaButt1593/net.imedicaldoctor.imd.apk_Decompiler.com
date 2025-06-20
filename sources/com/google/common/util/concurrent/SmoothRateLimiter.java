package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import java.util.concurrent.TimeUnit;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
abstract class SmoothRateLimiter extends RateLimiter {

    /* renamed from: c  reason: collision with root package name */
    double f23229c;

    /* renamed from: d  reason: collision with root package name */
    double f23230d;

    /* renamed from: e  reason: collision with root package name */
    double f23231e;

    /* renamed from: f  reason: collision with root package name */
    private long f23232f;

    static final class SmoothBursty extends SmoothRateLimiter {

        /* renamed from: g  reason: collision with root package name */
        final double f23233g;

        SmoothBursty(RateLimiter.SleepingStopwatch sleepingStopwatch, double d2) {
            super(sleepingStopwatch);
            this.f23233g = d2;
        }

        /* access modifiers changed from: package-private */
        public double v() {
            return this.f23231e;
        }

        /* access modifiers changed from: package-private */
        public void w(double d2, double d3) {
            double d4 = this.f23230d;
            double d5 = this.f23233g * d2;
            this.f23230d = d5;
            if (d4 == Double.POSITIVE_INFINITY) {
                this.f23229c = d5;
                return;
            }
            double d6 = 0.0d;
            if (d4 != 0.0d) {
                d6 = (this.f23229c * d5) / d4;
            }
            this.f23229c = d6;
        }

        /* access modifiers changed from: package-private */
        public long y(double d2, double d3) {
            return 0;
        }
    }

    static final class SmoothWarmingUp extends SmoothRateLimiter {

        /* renamed from: g  reason: collision with root package name */
        private final long f23234g;

        /* renamed from: h  reason: collision with root package name */
        private double f23235h;

        /* renamed from: i  reason: collision with root package name */
        private double f23236i;

        /* renamed from: j  reason: collision with root package name */
        private double f23237j;

        SmoothWarmingUp(RateLimiter.SleepingStopwatch sleepingStopwatch, long j2, TimeUnit timeUnit, double d2) {
            super(sleepingStopwatch);
            this.f23234g = timeUnit.toMicros(j2);
            this.f23237j = d2;
        }

        private double z(double d2) {
            return this.f23231e + (d2 * this.f23235h);
        }

        /* access modifiers changed from: package-private */
        public double v() {
            return ((double) this.f23234g) / this.f23230d;
        }

        /* access modifiers changed from: package-private */
        public void w(double d2, double d3) {
            double d4 = this.f23230d;
            double d5 = this.f23237j * d3;
            long j2 = this.f23234g;
            double d6 = (((double) j2) * 0.5d) / d3;
            this.f23236i = d6;
            double d7 = ((((double) j2) * 2.0d) / (d3 + d5)) + d6;
            this.f23230d = d7;
            this.f23235h = (d5 - d3) / (d7 - d6);
            if (d4 == Double.POSITIVE_INFINITY) {
                this.f23229c = 0.0d;
                return;
            }
            if (d4 != 0.0d) {
                d7 = (this.f23229c * d7) / d4;
            }
            this.f23229c = d7;
        }

        /* access modifiers changed from: package-private */
        public long y(double d2, double d3) {
            long j2;
            double d4 = d2 - this.f23236i;
            if (d4 > 0.0d) {
                double min = Math.min(d4, d3);
                j2 = (long) (((z(d4) + z(d4 - min)) * min) / 2.0d);
                d3 -= min;
            } else {
                j2 = 0;
            }
            return j2 + ((long) (this.f23231e * d3));
        }
    }

    private SmoothRateLimiter(RateLimiter.SleepingStopwatch sleepingStopwatch) {
        super(sleepingStopwatch);
        this.f23232f = 0;
    }

    /* access modifiers changed from: package-private */
    public final double i() {
        return ((double) TimeUnit.SECONDS.toMicros(1)) / this.f23231e;
    }

    /* access modifiers changed from: package-private */
    public final void j(double d2, long j2) {
        x(j2);
        double micros = ((double) TimeUnit.SECONDS.toMicros(1)) / d2;
        this.f23231e = micros;
        w(d2, micros);
    }

    /* access modifiers changed from: package-private */
    public final long m(long j2) {
        return this.f23232f;
    }

    /* access modifiers changed from: package-private */
    public final long p(int i2, long j2) {
        x(j2);
        long j3 = this.f23232f;
        double d2 = (double) i2;
        double min = Math.min(d2, this.f23229c);
        this.f23232f = LongMath.x(this.f23232f, y(this.f23229c, min) + ((long) ((d2 - min) * this.f23231e)));
        this.f23229c -= min;
        return j3;
    }

    /* access modifiers changed from: package-private */
    public abstract double v();

    /* access modifiers changed from: package-private */
    public abstract void w(double d2, double d3);

    /* access modifiers changed from: package-private */
    public void x(long j2) {
        long j3 = this.f23232f;
        if (j2 > j3) {
            this.f23229c = Math.min(this.f23230d, this.f23229c + (((double) (j2 - j3)) / v()));
            this.f23232f = j2;
        }
    }

    /* access modifiers changed from: package-private */
    public abstract long y(double d2, double d3);
}
