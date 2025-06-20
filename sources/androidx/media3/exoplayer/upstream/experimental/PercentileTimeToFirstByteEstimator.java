package androidx.media3.exoplayer.upstream.experimental;

import androidx.annotation.VisibleForTesting;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSpec;
import androidx.media3.exoplayer.upstream.SlidingPercentile;
import androidx.media3.exoplayer.upstream.TimeToFirstByteEstimator;
import java.util.LinkedHashMap;
import java.util.Map;

@UnstableApi
public final class PercentileTimeToFirstByteEstimator implements TimeToFirstByteEstimator {

    /* renamed from: f  reason: collision with root package name */
    public static final int f12650f = 10;

    /* renamed from: g  reason: collision with root package name */
    public static final float f12651g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    private static final int f12652h = 10;

    /* renamed from: a  reason: collision with root package name */
    private final LinkedHashMap<DataSpec, Long> f12653a;

    /* renamed from: b  reason: collision with root package name */
    private final SlidingPercentile f12654b;

    /* renamed from: c  reason: collision with root package name */
    private final float f12655c;

    /* renamed from: d  reason: collision with root package name */
    private final Clock f12656d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f12657e;

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

    public PercentileTimeToFirstByteEstimator() {
        this(10, 0.5f);
    }

    public void a(DataSpec dataSpec) {
        Long remove = this.f12653a.remove(dataSpec);
        if (remove != null) {
            this.f12654b.c(1, (float) (Util.I1(this.f12656d.b()) - remove.longValue()));
            this.f12657e = false;
        }
    }

    public long b() {
        return !this.f12657e ? (long) this.f12654b.f(this.f12655c) : C.f9084b;
    }

    public void c(DataSpec dataSpec) {
        this.f12653a.remove(dataSpec);
        this.f12653a.put(dataSpec, Long.valueOf(Util.I1(this.f12656d.b())));
    }

    public void reset() {
        this.f12654b.i();
        this.f12657e = true;
    }

    public PercentileTimeToFirstByteEstimator(int i2, float f2) {
        this(i2, f2, Clock.f9502a);
    }

    @VisibleForTesting
    PercentileTimeToFirstByteEstimator(int i2, float f2, Clock clock) {
        Assertions.a(i2 > 0 && f2 > 0.0f && f2 <= 1.0f);
        this.f12655c = f2;
        this.f12656d = clock;
        this.f12653a = new FixedSizeLinkedHashMap(10);
        this.f12654b = new SlidingPercentile(i2);
        this.f12657e = true;
    }
}
