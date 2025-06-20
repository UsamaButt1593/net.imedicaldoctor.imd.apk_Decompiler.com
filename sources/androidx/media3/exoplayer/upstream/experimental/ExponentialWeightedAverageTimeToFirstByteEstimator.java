package androidx.media3.exoplayer.upstream.experimental;

import androidx.annotation.VisibleForTesting;
import androidx.media3.common.C;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.upstream.TimeToFirstByteEstimator;
import java.util.LinkedHashMap;
import java.util.Map;

@UnstableApi
public final class ExponentialWeightedAverageTimeToFirstByteEstimator implements TimeToFirstByteEstimator {

    /* renamed from: e  reason: collision with root package name */
    public static final double f12644e = 0.85d;

    /* renamed from: f  reason: collision with root package name */
    private static final int f12645f = 10;

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<DataSpec, Long> f12646a;

    /* renamed from: b  reason: collision with root package name */
    private final double f12647b;

    /* renamed from: c  reason: collision with root package name */
    private final Clock f12648c;

    /* renamed from: d  reason: collision with root package name */
    private long f12649d;

    private static class FixedSizeLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
        private final int s;

        public FixedSizeLinkedHashMap(int i2) {
            this.s = i2;
        }

        /* access modifiers changed from: protected */
        public boolean removeEldestEntry(Map.Entry<K, V> entry) {
            return size() > this.s;
        }
    }

    public ExponentialWeightedAverageTimeToFirstByteEstimator() {
        this(0.85d, Clock.f9502a);
    }

    public void a(DataSpec dataSpec) {
        Long remove = this.f12646a.remove(dataSpec);
        if (remove != null) {
            long I1 = Util.I1(this.f12648c.b()) - remove.longValue();
            long j2 = this.f12649d;
            if (j2 != C.f9084b) {
                double d2 = this.f12647b;
                I1 = (long) ((((double) j2) * d2) + ((1.0d - d2) * ((double) I1)));
            }
            this.f12649d = I1;
        }
    }

    public long b() {
        return this.f12649d;
    }

    public void c(DataSpec dataSpec) {
        this.f12646a.remove(dataSpec);
        this.f12646a.put(dataSpec, Long.valueOf(Util.I1(this.f12648c.b())));
    }

    public void reset() {
        this.f12649d = C.f9084b;
    }

    public ExponentialWeightedAverageTimeToFirstByteEstimator(double d2) {
        this(d2, Clock.f9502a);
    }

    @VisibleForTesting
    ExponentialWeightedAverageTimeToFirstByteEstimator(double d2, Clock clock) {
        this.f12647b = d2;
        this.f12648c = clock;
        this.f12646a = new FixedSizeLinkedHashMap(10);
        this.f12649d = C.f9084b;
    }
}
