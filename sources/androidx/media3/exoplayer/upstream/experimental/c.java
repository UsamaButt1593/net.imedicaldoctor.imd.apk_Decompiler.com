package androidx.media3.exoplayer.upstream.experimental;

import androidx.media3.exoplayer.upstream.experimental.SlidingWeightedAverageBandwidthStatistic;
import java.util.Deque;

public final /* synthetic */ class c implements SlidingWeightedAverageBandwidthStatistic.SampleEvictionFunction {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f12694a;

    public /* synthetic */ c(long j2) {
        this.f12694a = j2;
    }

    public final boolean a(Deque deque) {
        return SlidingWeightedAverageBandwidthStatistic.i(this.f12694a, deque);
    }
}
