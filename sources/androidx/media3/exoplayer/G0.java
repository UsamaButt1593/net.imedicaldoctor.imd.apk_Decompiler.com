package androidx.media3.exoplayer;

import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.collect.ImmutableList;

public final /* synthetic */ class G0 implements Runnable {
    public final /* synthetic */ ImmutableList.Builder X;
    public final /* synthetic */ MediaSource.MediaPeriodId Y;
    public final /* synthetic */ MediaPeriodQueue s;

    public /* synthetic */ G0(MediaPeriodQueue mediaPeriodQueue, ImmutableList.Builder builder, MediaSource.MediaPeriodId mediaPeriodId) {
        this.s = mediaPeriodQueue;
        this.X = builder;
        this.Y = mediaPeriodId;
    }

    public final void run() {
        this.s.A(this.X, this.Y);
    }
}
