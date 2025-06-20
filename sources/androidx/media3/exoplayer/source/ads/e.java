package androidx.media3.exoplayer.source.ads;

import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ MediaSource.MediaPeriodId X;
    public final /* synthetic */ AdsMediaSource.AdPrepareListener s;

    public /* synthetic */ e(AdsMediaSource.AdPrepareListener adPrepareListener, MediaSource.MediaPeriodId mediaPeriodId) {
        this.s = adPrepareListener;
        this.X = mediaPeriodId;
    }

    public final void run() {
        this.s.e(this.X);
    }
}
