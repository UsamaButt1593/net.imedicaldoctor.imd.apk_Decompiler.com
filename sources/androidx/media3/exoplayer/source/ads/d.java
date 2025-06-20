package androidx.media3.exoplayer.source.ads;

import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;
import java.io.IOException;

public final /* synthetic */ class d implements Runnable {
    public final /* synthetic */ MediaSource.MediaPeriodId X;
    public final /* synthetic */ IOException Y;
    public final /* synthetic */ AdsMediaSource.AdPrepareListener s;

    public /* synthetic */ d(AdsMediaSource.AdPrepareListener adPrepareListener, MediaSource.MediaPeriodId mediaPeriodId, IOException iOException) {
        this.s = adPrepareListener;
        this.X = mediaPeriodId;
        this.Y = iOException;
    }

    public final void run() {
        this.s.f(this.X, this.Y);
    }
}
