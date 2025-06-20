package androidx.media3.exoplayer.upstream.experimental;

import android.os.Handler;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSource;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@UnstableApi
public class CombinedParallelSampleBandwidthEstimator implements BandwidthEstimator {

    /* renamed from: b  reason: collision with root package name */
    private final BandwidthStatistic f12606b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12607c;

    /* renamed from: d  reason: collision with root package name */
    private final long f12608d;

    /* renamed from: e  reason: collision with root package name */
    private final BandwidthMeter.EventListener.EventDispatcher f12609e;

    /* renamed from: f  reason: collision with root package name */
    private final Clock f12610f;

    /* renamed from: g  reason: collision with root package name */
    private int f12611g;

    /* renamed from: h  reason: collision with root package name */
    private long f12612h;

    /* renamed from: i  reason: collision with root package name */
    private long f12613i;

    /* renamed from: j  reason: collision with root package name */
    private long f12614j;

    /* renamed from: k  reason: collision with root package name */
    private long f12615k;

    /* renamed from: l  reason: collision with root package name */
    private int f12616l;

    /* renamed from: m  reason: collision with root package name */
    private long f12617m;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public BandwidthStatistic f12618a = new SlidingWeightedAverageBandwidthStatistic();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f12619b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public long f12620c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Clock f12621d = Clock.f9502a;

        public CombinedParallelSampleBandwidthEstimator e() {
            return new CombinedParallelSampleBandwidthEstimator(this);
        }

        @CanIgnoreReturnValue
        public Builder f(BandwidthStatistic bandwidthStatistic) {
            Assertions.g(bandwidthStatistic);
            this.f12618a = bandwidthStatistic;
            return this;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        @CanIgnoreReturnValue
        public Builder g(Clock clock) {
            this.f12621d = clock;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder h(long j2) {
            Assertions.a(j2 >= 0);
            this.f12620c = j2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder i(int i2) {
            Assertions.a(i2 >= 0);
            this.f12619b = i2;
            return this;
        }
    }

    private CombinedParallelSampleBandwidthEstimator(Builder builder) {
        this.f12606b = builder.f12618a;
        this.f12607c = builder.f12619b;
        this.f12608d = builder.f12620c;
        this.f12610f = builder.f12621d;
        this.f12609e = new BandwidthMeter.EventListener.EventDispatcher();
        this.f12614j = Long.MIN_VALUE;
        this.f12615k = Long.MIN_VALUE;
    }

    private void i(int i2, long j2, long j3) {
        if (j3 == Long.MIN_VALUE) {
            return;
        }
        if (i2 != 0 || j2 != 0 || j3 != this.f12615k) {
            this.f12615k = j3;
            this.f12609e.c(i2, j2, j3);
        }
    }

    public void a(BandwidthMeter.EventListener eventListener) {
        this.f12609e.e(eventListener);
    }

    public long b() {
        return this.f12614j;
    }

    public void c(Handler handler, BandwidthMeter.EventListener eventListener) {
        this.f12609e.b(handler, eventListener);
    }

    public void d(DataSource dataSource, int i2) {
        long j2 = (long) i2;
        this.f12613i += j2;
        this.f12617m += j2;
    }

    public void e(DataSource dataSource) {
    }

    public void f(long j2) {
        long b2 = this.f12610f.b();
        i(this.f12611g > 0 ? (int) (b2 - this.f12612h) : 0, this.f12613i, j2);
        this.f12606b.reset();
        this.f12614j = Long.MIN_VALUE;
        this.f12612h = b2;
        this.f12613i = 0;
        this.f12616l = 0;
        this.f12617m = 0;
    }

    public void g(DataSource dataSource) {
        if (this.f12611g == 0) {
            this.f12612h = this.f12610f.b();
        }
        this.f12611g++;
    }

    public void h(DataSource dataSource) {
        Assertions.i(this.f12611g > 0);
        int i2 = this.f12611g - 1;
        this.f12611g = i2;
        if (i2 <= 0) {
            long b2 = (long) ((int) (this.f12610f.b() - this.f12612h));
            if (b2 > 0) {
                this.f12606b.a(this.f12613i, 1000 * b2);
                int i3 = this.f12616l + 1;
                this.f12616l = i3;
                if (i3 > this.f12607c && this.f12617m > this.f12608d) {
                    this.f12614j = this.f12606b.b();
                }
                i((int) b2, this.f12613i, this.f12614j);
                this.f12613i = 0;
            }
        }
    }
}
