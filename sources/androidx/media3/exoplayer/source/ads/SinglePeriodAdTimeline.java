package androidx.media3.exoplayer.source.ads;

import androidx.annotation.VisibleForTesting;
import androidx.media3.common.AdPlaybackState;
import androidx.media3.common.C;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.ForwardingTimeline;

@VisibleForTesting(otherwise = 3)
@UnstableApi
public final class SinglePeriodAdTimeline extends ForwardingTimeline {
    private final AdPlaybackState Z2;

    public SinglePeriodAdTimeline(Timeline timeline, AdPlaybackState adPlaybackState) {
        super(timeline);
        boolean z = false;
        Assertions.i(timeline.n() == 1);
        Assertions.i(timeline.w() == 1 ? true : z);
        this.Z2 = adPlaybackState;
    }

    public Timeline.Period l(int i2, Timeline.Period period, boolean z) {
        this.Y2.l(i2, period, z);
        long j2 = period.Z;
        if (j2 == C.f9084b) {
            j2 = this.Z2.Z;
        }
        Timeline.Period period2 = period;
        period2.y(period.s, period.X, period.Y, j2, period.s(), this.Z2, period.Y2);
        return period;
    }
}
