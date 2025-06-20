package androidx.media3.exoplayer.upstream.experimental;

import androidx.media3.common.util.UnstableApi;

@UnstableApi
public class ExponentialWeightedAverageStatistic implements BandwidthStatistic {

    /* renamed from: c  reason: collision with root package name */
    public static final double f12641c = 0.9999d;

    /* renamed from: a  reason: collision with root package name */
    private final double f12642a;

    /* renamed from: b  reason: collision with root package name */
    private long f12643b;

    public ExponentialWeightedAverageStatistic() {
        this(0.9999d);
    }

    public void a(long j2, long j3) {
        long j4 = (8000000 * j2) / j3;
        if (this.f12643b == Long.MIN_VALUE) {
            this.f12643b = j4;
            return;
        }
        double pow = Math.pow(this.f12642a, Math.sqrt((double) j2));
        this.f12643b = (long) ((((double) this.f12643b) * pow) + ((1.0d - pow) * ((double) j4)));
    }

    public long b() {
        return this.f12643b;
    }

    public void reset() {
        this.f12643b = Long.MIN_VALUE;
    }

    public ExponentialWeightedAverageStatistic(double d2) {
        this.f12642a = d2;
        this.f12643b = Long.MIN_VALUE;
    }
}
