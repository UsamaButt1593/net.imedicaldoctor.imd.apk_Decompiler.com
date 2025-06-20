package androidx.media3.exoplayer.upstream.experimental;

import androidx.media3.common.util.Clock;
import androidx.media3.exoplayer.upstream.experimental.SlidingWeightedAverageBandwidthStatistic;
import java.util.Deque;

public final /* synthetic */ class b implements SlidingWeightedAverageBandwidthStatistic.SampleEvictionFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f12692a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Clock f12693b;

    public /* synthetic */ b(long j2, Clock clock) {
        this.f12692a = j2;
        this.f12693b = clock;
    }

    public final boolean a(Deque deque) {
        return SlidingWeightedAverageBandwidthStatistic.h(this.f12692a, this.f12693b, deque);
    }
}
