package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@Beta
@J2ktIncompatible
public abstract class RateLimiter {

    /* renamed from: a  reason: collision with root package name */
    private final SleepingStopwatch f23199a;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private volatile Object f23200b;

    static abstract class SleepingStopwatch {
        protected SleepingStopwatch() {
        }

        public static SleepingStopwatch a() {
            return new SleepingStopwatch() {

                /* renamed from: a  reason: collision with root package name */
                final Stopwatch f23201a = Stopwatch.c();

                /* access modifiers changed from: protected */
                public long b() {
                    return this.f23201a.g(TimeUnit.MICROSECONDS);
                }

                /* access modifiers changed from: protected */
                public void c(long j2) {
                    if (j2 > 0) {
                        Uninterruptibles.k(j2, TimeUnit.MICROSECONDS);
                    }
                }
            };
        }

        /* access modifiers changed from: protected */
        public abstract long b();

        /* access modifiers changed from: protected */
        public abstract void c(long j2);
    }

    RateLimiter(SleepingStopwatch sleepingStopwatch) {
        this.f23199a = (SleepingStopwatch) Preconditions.E(sleepingStopwatch);
    }

    private boolean c(long j2, long j3) {
        return m(j2) - j3 <= j2;
    }

    private static void d(int i2) {
        Preconditions.k(i2 > 0, "Requested permits (%s) must be positive", i2);
    }

    public static RateLimiter e(double d2) {
        return h(d2, SleepingStopwatch.a());
    }

    public static RateLimiter f(double d2, long j2, TimeUnit timeUnit) {
        Preconditions.p(j2 >= 0, "warmupPeriod must not be negative: %s", j2);
        return g(d2, j2, timeUnit, 3.0d, SleepingStopwatch.a());
    }

    @VisibleForTesting
    static RateLimiter g(double d2, long j2, TimeUnit timeUnit, double d3, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothWarmingUp smoothWarmingUp = new SmoothRateLimiter.SmoothWarmingUp(sleepingStopwatch, j2, timeUnit, d3);
        smoothWarmingUp.q(d2);
        return smoothWarmingUp;
    }

    @VisibleForTesting
    static RateLimiter h(double d2, SleepingStopwatch sleepingStopwatch) {
        SmoothRateLimiter.SmoothBursty smoothBursty = new SmoothRateLimiter.SmoothBursty(sleepingStopwatch, 1.0d);
        smoothBursty.q(d2);
        return smoothBursty;
    }

    private Object l() {
        Object obj = this.f23200b;
        if (obj == null) {
            synchronized (this) {
                try {
                    obj = this.f23200b;
                    if (obj == null) {
                        obj = new Object();
                        this.f23200b = obj;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return obj;
    }

    @CanIgnoreReturnValue
    public double a() {
        return b(1);
    }

    @CanIgnoreReturnValue
    public double b(int i2) {
        long n2 = n(i2);
        this.f23199a.c(n2);
        return (((double) n2) * 1.0d) / ((double) TimeUnit.SECONDS.toMicros(1));
    }

    /* access modifiers changed from: package-private */
    public abstract double i();

    /* access modifiers changed from: package-private */
    public abstract void j(double d2, long j2);

    public final double k() {
        double i2;
        synchronized (l()) {
            i2 = i();
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public abstract long m(long j2);

    /* access modifiers changed from: package-private */
    public final long n(int i2) {
        long o;
        d(i2);
        synchronized (l()) {
            o = o(i2, this.f23199a.b());
        }
        return o;
    }

    /* access modifiers changed from: package-private */
    public final long o(int i2, long j2) {
        return Math.max(p(i2, j2) - j2, 0);
    }

    /* access modifiers changed from: package-private */
    public abstract long p(int i2, long j2);

    public final void q(double d2) {
        Preconditions.e(d2 > 0.0d && !Double.isNaN(d2), "rate must be positive");
        synchronized (l()) {
            j(d2, this.f23199a.b());
        }
    }

    public boolean r() {
        return t(1, 0, TimeUnit.MICROSECONDS);
    }

    public boolean s(int i2) {
        return t(i2, 0, TimeUnit.MICROSECONDS);
    }

    public boolean t(int i2, long j2, TimeUnit timeUnit) {
        long max = Math.max(timeUnit.toMicros(j2), 0);
        d(i2);
        synchronized (l()) {
            try {
                long b2 = this.f23199a.b();
                if (!c(b2, max)) {
                    return false;
                }
                long o = o(i2, b2);
                this.f23199a.c(o);
                return true;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public String toString() {
        return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", new Object[]{Double.valueOf(k())});
    }

    public boolean u(long j2, TimeUnit timeUnit) {
        return t(1, j2, timeUnit);
    }
}
