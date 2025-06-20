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
public class SplitParallelSampleBandwidthEstimator implements BandwidthEstimator {

    /* renamed from: b  reason: collision with root package name */
    private final BandwidthStatistic f12675b;

    /* renamed from: c  reason: collision with root package name */
    private final int f12676c;

    /* renamed from: d  reason: collision with root package name */
    private final long f12677d;

    /* renamed from: e  reason: collision with root package name */
    private final Clock f12678e;

    /* renamed from: f  reason: collision with root package name */
    private final BandwidthMeter.EventListener.EventDispatcher f12679f;

    /* renamed from: g  reason: collision with root package name */
    private int f12680g;

    /* renamed from: h  reason: collision with root package name */
    private long f12681h;

    /* renamed from: i  reason: collision with root package name */
    private long f12682i;

    /* renamed from: j  reason: collision with root package name */
    private long f12683j;

    /* renamed from: k  reason: collision with root package name */
    private long f12684k;

    /* renamed from: l  reason: collision with root package name */
    private int f12685l;

    /* renamed from: m  reason: collision with root package name */
    private long f12686m;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public BandwidthStatistic f12687a = new SlidingWeightedAverageBandwidthStatistic();
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f12688b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public long f12689c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Clock f12690d = Clock.f9502a;

        public SplitParallelSampleBandwidthEstimator e() {
            return new SplitParallelSampleBandwidthEstimator(this);
        }

        @CanIgnoreReturnValue
        public Builder f(BandwidthStatistic bandwidthStatistic) {
            Assertions.g(bandwidthStatistic);
            this.f12687a = bandwidthStatistic;
            return this;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        @CanIgnoreReturnValue
        public Builder g(Clock clock) {
            this.f12690d = clock;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder h(long j2) {
            Assertions.a(j2 >= 0);
            this.f12689c = j2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder i(int i2) {
            Assertions.a(i2 >= 0);
            this.f12688b = i2;
            return this;
        }
    }

    private SplitParallelSampleBandwidthEstimator(Builder builder) {
        this.f12675b = builder.f12687a;
        this.f12676c = builder.f12688b;
        this.f12677d = builder.f12689c;
        this.f12678e = builder.f12690d;
        this.f12679f = new BandwidthMeter.EventListener.EventDispatcher();
        this.f12683j = Long.MIN_VALUE;
        this.f12684k = Long.MIN_VALUE;
    }

    private void i(int i2, long j2, long j3) {
        if (j3 == Long.MIN_VALUE) {
            return;
        }
        if (i2 != 0 || j2 != 0 || j3 != this.f12684k) {
            this.f12684k = j3;
            this.f12679f.c(i2, j2, j3);
        }
    }

    public void a(BandwidthMeter.EventListener eventListener) {
        this.f12679f.e(eventListener);
    }

    public long b() {
        return this.f12683j;
    }

    public void c(Handler handler, BandwidthMeter.EventListener eventListener) {
        this.f12679f.b(handler, eventListener);
    }

    public void d(DataSource dataSource, int i2) {
        long j2 = (long) i2;
        this.f12682i += j2;
        this.f12686m += j2;
    }

    public void e(DataSource dataSource) {
    }

    public void f(long j2) {
        long b2 = this.f12678e.b();
        i(this.f12680g > 0 ? (int) (b2 - this.f12681h) : 0, this.f12682i, j2);
        this.f12675b.reset();
        this.f12683j = Long.MIN_VALUE;
        this.f12681h = b2;
        this.f12682i = 0;
        this.f12685l = 0;
        this.f12686m = 0;
    }

    public void g(DataSource dataSource) {
        if (this.f12680g == 0) {
            this.f12681h = this.f12678e.b();
        }
        this.f12680g++;
    }

    public void h(DataSource dataSource) {
        Assertions.i(this.f12680g > 0);
        long b2 = this.f12678e.b();
        long j2 = (long) ((int) (b2 - this.f12681h));
        if (j2 > 0) {
            this.f12675b.a(this.f12682i, 1000 * j2);
            int i2 = this.f12685l + 1;
            this.f12685l = i2;
            if (i2 > this.f12676c && this.f12686m > this.f12677d) {
                this.f12683j = this.f12675b.b();
            }
            i((int) j2, this.f12682i, this.f12683j);
            this.f12681h = b2;
            this.f12682i = 0;
        }
        this.f12680g--;
    }
}
