package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class CacheStats {

    /* renamed from: a  reason: collision with root package name */
    private final long f22341a;

    /* renamed from: b  reason: collision with root package name */
    private final long f22342b;

    /* renamed from: c  reason: collision with root package name */
    private final long f22343c;

    /* renamed from: d  reason: collision with root package name */
    private final long f22344d;

    /* renamed from: e  reason: collision with root package name */
    private final long f22345e;

    /* renamed from: f  reason: collision with root package name */
    private final long f22346f;

    public CacheStats(long j2, long j3, long j4, long j5, long j6, long j7) {
        long j8 = j2;
        long j9 = j3;
        long j10 = j4;
        long j11 = j5;
        long j12 = j6;
        long j13 = j7;
        boolean z = false;
        Preconditions.d(j8 >= 0);
        Preconditions.d(j9 >= 0);
        Preconditions.d(j10 >= 0);
        Preconditions.d(j11 >= 0);
        Preconditions.d(j12 >= 0);
        Preconditions.d(j13 >= 0 ? true : z);
        this.f22341a = j8;
        this.f22342b = j9;
        this.f22343c = j10;
        this.f22344d = j11;
        this.f22345e = j12;
        this.f22346f = j13;
    }

    public double a() {
        long x = LongMath.x(this.f22343c, this.f22344d);
        if (x == 0) {
            return 0.0d;
        }
        return ((double) this.f22345e) / ((double) x);
    }

    public long b() {
        return this.f22346f;
    }

    public long c() {
        return this.f22341a;
    }

    public double d() {
        long m2 = m();
        if (m2 == 0) {
            return 1.0d;
        }
        return ((double) this.f22341a) / ((double) m2);
    }

    public long e() {
        return LongMath.x(this.f22343c, this.f22344d);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof CacheStats)) {
            return false;
        }
        CacheStats cacheStats = (CacheStats) obj;
        return this.f22341a == cacheStats.f22341a && this.f22342b == cacheStats.f22342b && this.f22343c == cacheStats.f22343c && this.f22344d == cacheStats.f22344d && this.f22345e == cacheStats.f22345e && this.f22346f == cacheStats.f22346f;
    }

    public long f() {
        return this.f22344d;
    }

    public double g() {
        long x = LongMath.x(this.f22343c, this.f22344d);
        if (x == 0) {
            return 0.0d;
        }
        return ((double) this.f22344d) / ((double) x);
    }

    public long h() {
        return this.f22343c;
    }

    public int hashCode() {
        return Objects.b(Long.valueOf(this.f22341a), Long.valueOf(this.f22342b), Long.valueOf(this.f22343c), Long.valueOf(this.f22344d), Long.valueOf(this.f22345e), Long.valueOf(this.f22346f));
    }

    public CacheStats i(CacheStats cacheStats) {
        CacheStats cacheStats2 = cacheStats;
        long max = Math.max(0, LongMath.A(this.f22341a, cacheStats2.f22341a));
        long max2 = Math.max(0, LongMath.A(this.f22342b, cacheStats2.f22342b));
        long max3 = Math.max(0, LongMath.A(this.f22343c, cacheStats2.f22343c));
        return new CacheStats(max, max2, max3, Math.max(0, LongMath.A(this.f22344d, cacheStats2.f22344d)), Math.max(0, LongMath.A(this.f22345e, cacheStats2.f22345e)), Math.max(0, LongMath.A(this.f22346f, cacheStats2.f22346f)));
    }

    public long j() {
        return this.f22342b;
    }

    public double k() {
        long m2 = m();
        if (m2 == 0) {
            return 0.0d;
        }
        return ((double) this.f22342b) / ((double) m2);
    }

    public CacheStats l(CacheStats cacheStats) {
        CacheStats cacheStats2 = cacheStats;
        return new CacheStats(LongMath.x(this.f22341a, cacheStats2.f22341a), LongMath.x(this.f22342b, cacheStats2.f22342b), LongMath.x(this.f22343c, cacheStats2.f22343c), LongMath.x(this.f22344d, cacheStats2.f22344d), LongMath.x(this.f22345e, cacheStats2.f22345e), LongMath.x(this.f22346f, cacheStats2.f22346f));
    }

    public long m() {
        return LongMath.x(this.f22341a, this.f22342b);
    }

    public long n() {
        return this.f22345e;
    }

    public String toString() {
        return MoreObjects.c(this).e("hitCount", this.f22341a).e("missCount", this.f22342b).e("loadSuccessCount", this.f22343c).e("loadExceptionCount", this.f22344d).e("totalLoadTime", this.f22345e).e("evictionCount", this.f22346f).toString();
    }
}
