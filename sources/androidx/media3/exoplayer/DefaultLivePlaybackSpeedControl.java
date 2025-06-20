package androidx.media3.exoplayer;

import android.os.SystemClock;
import androidx.media3.common.C;
import androidx.media3.common.MediaItem;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.primitives.Longs;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
public final class DefaultLivePlaybackSpeedControl implements LivePlaybackSpeedControl {
    public static final float t = 0.97f;
    public static final float u = 1.03f;
    public static final long v = 1000;
    public static final float w = 0.1f;
    public static final long x = 500;
    public static final float y = 0.999f;
    public static final long z = 20;

    /* renamed from: a  reason: collision with root package name */
    private final float f10124a;

    /* renamed from: b  reason: collision with root package name */
    private final float f10125b;

    /* renamed from: c  reason: collision with root package name */
    private final long f10126c;

    /* renamed from: d  reason: collision with root package name */
    private final float f10127d;

    /* renamed from: e  reason: collision with root package name */
    private final long f10128e;

    /* renamed from: f  reason: collision with root package name */
    private final long f10129f;

    /* renamed from: g  reason: collision with root package name */
    private final float f10130g;

    /* renamed from: h  reason: collision with root package name */
    private long f10131h;

    /* renamed from: i  reason: collision with root package name */
    private long f10132i;

    /* renamed from: j  reason: collision with root package name */
    private long f10133j;

    /* renamed from: k  reason: collision with root package name */
    private long f10134k;

    /* renamed from: l  reason: collision with root package name */
    private long f10135l;

    /* renamed from: m  reason: collision with root package name */
    private long f10136m;

    /* renamed from: n  reason: collision with root package name */
    private float f10137n;
    private float o;
    private float p;
    private long q;
    private long r;
    private long s;

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private float f10138a = 0.97f;

        /* renamed from: b  reason: collision with root package name */
        private float f10139b = 1.03f;

        /* renamed from: c  reason: collision with root package name */
        private long f10140c = 1000;

        /* renamed from: d  reason: collision with root package name */
        private float f10141d = 1.0E-7f;

        /* renamed from: e  reason: collision with root package name */
        private long f10142e = Util.I1(20);

        /* renamed from: f  reason: collision with root package name */
        private long f10143f = Util.I1(500);

        /* renamed from: g  reason: collision with root package name */
        private float f10144g = 0.999f;

        public DefaultLivePlaybackSpeedControl a() {
            return new DefaultLivePlaybackSpeedControl(this.f10138a, this.f10139b, this.f10140c, this.f10141d, this.f10142e, this.f10143f, this.f10144g);
        }

        @CanIgnoreReturnValue
        public Builder b(float f2) {
            Assertions.a(f2 >= 1.0f);
            this.f10139b = f2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder c(float f2) {
            Assertions.a(0.0f < f2 && f2 <= 1.0f);
            this.f10138a = f2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder d(long j2) {
            Assertions.a(j2 > 0);
            this.f10142e = Util.I1(j2);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder e(float f2) {
            Assertions.a(f2 >= 0.0f && f2 < 1.0f);
            this.f10144g = f2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder f(long j2) {
            Assertions.a(j2 > 0);
            this.f10140c = j2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder g(float f2) {
            Assertions.a(f2 > 0.0f);
            this.f10141d = f2 / 1000000.0f;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder h(long j2) {
            Assertions.a(j2 >= 0);
            this.f10143f = Util.I1(j2);
            return this;
        }
    }

    private DefaultLivePlaybackSpeedControl(float f2, float f3, long j2, float f4, long j3, long j4, float f5) {
        this.f10124a = f2;
        this.f10125b = f3;
        this.f10126c = j2;
        this.f10127d = f4;
        this.f10128e = j3;
        this.f10129f = j4;
        this.f10130g = f5;
        this.f10131h = C.f9084b;
        this.f10132i = C.f9084b;
        this.f10134k = C.f9084b;
        this.f10135l = C.f9084b;
        this.o = f2;
        this.f10137n = f3;
        this.p = 1.0f;
        this.q = C.f9084b;
        this.f10133j = C.f9084b;
        this.f10136m = C.f9084b;
        this.r = C.f9084b;
        this.s = C.f9084b;
    }

    private void f(long j2) {
        long j3 = this.r + (this.s * 3);
        if (this.f10136m > j3) {
            float I1 = (float) Util.I1(this.f10126c);
            long j4 = ((long) ((this.p - 1.0f) * I1)) + ((long) ((this.f10137n - 1.0f) * I1));
            this.f10136m = Longs.t(j3, this.f10133j, this.f10136m - j4);
            return;
        }
        long x2 = Util.x(j2 - ((long) (Math.max(0.0f, this.p - 1.0f) / this.f10127d)), this.f10136m, j3);
        this.f10136m = x2;
        long j5 = this.f10135l;
        if (j5 != C.f9084b && x2 > j5) {
            this.f10136m = j5;
        }
    }

    private void g() {
        long j2;
        long j3 = this.f10131h;
        if (j3 != C.f9084b) {
            j2 = this.f10132i;
            if (j2 == C.f9084b) {
                long j4 = this.f10134k;
                if (j4 != C.f9084b && j3 < j4) {
                    j3 = j4;
                }
                j2 = this.f10135l;
                if (j2 == C.f9084b || j3 <= j2) {
                    j2 = j3;
                }
            }
        } else {
            j2 = -9223372036854775807L;
        }
        if (this.f10133j != j2) {
            this.f10133j = j2;
            this.f10136m = j2;
            this.r = C.f9084b;
            this.s = C.f9084b;
            this.q = C.f9084b;
        }
    }

    private static long h(long j2, long j3, float f2) {
        return (long) ((((float) j2) * f2) + ((1.0f - f2) * ((float) j3)));
    }

    private void i(long j2, long j3) {
        long h2;
        long j4 = j2 - j3;
        long j5 = this.r;
        if (j5 == C.f9084b) {
            this.r = j4;
            h2 = 0;
        } else {
            long max = Math.max(j4, h(j5, j4, this.f10130g));
            this.r = max;
            h2 = h(this.s, Math.abs(j4 - max), this.f10130g);
        }
        this.s = h2;
    }

    public void a(MediaItem.LiveConfiguration liveConfiguration) {
        this.f10131h = Util.I1(liveConfiguration.s);
        this.f10134k = Util.I1(liveConfiguration.X);
        this.f10135l = Util.I1(liveConfiguration.Y);
        float f2 = liveConfiguration.Z;
        if (f2 == -3.4028235E38f) {
            f2 = this.f10124a;
        }
        this.o = f2;
        float f3 = liveConfiguration.X2;
        if (f3 == -3.4028235E38f) {
            f3 = this.f10125b;
        }
        this.f10137n = f3;
        if (f2 == 1.0f && f3 == 1.0f) {
            this.f10131h = C.f9084b;
        }
        g();
    }

    public float b(long j2, long j3) {
        if (this.f10131h == C.f9084b) {
            return 1.0f;
        }
        i(j2, j3);
        if (this.q != C.f9084b && SystemClock.elapsedRealtime() - this.q < this.f10126c) {
            return this.p;
        }
        this.q = SystemClock.elapsedRealtime();
        f(j2);
        long j4 = j2 - this.f10136m;
        if (Math.abs(j4) < this.f10128e) {
            this.p = 1.0f;
        } else {
            this.p = Util.v((this.f10127d * ((float) j4)) + 1.0f, this.o, this.f10137n);
        }
        return this.p;
    }

    public long c() {
        return this.f10136m;
    }

    public void d() {
        long j2 = this.f10136m;
        if (j2 != C.f9084b) {
            long j3 = j2 + this.f10129f;
            this.f10136m = j3;
            long j4 = this.f10135l;
            if (j4 != C.f9084b && j3 > j4) {
                this.f10136m = j4;
            }
            this.q = C.f9084b;
        }
    }

    public void e(long j2) {
        this.f10132i = j2;
        g();
    }
}
