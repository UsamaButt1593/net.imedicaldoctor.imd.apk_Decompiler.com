package androidx.media3.exoplayer.source.ads;

import androidx.media3.common.AdPlaybackState;
import androidx.media3.exoplayer.source.ads.AdsMediaSource;

public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ AdPlaybackState X;
    public final /* synthetic */ AdsMediaSource.ComponentListener s;

    public /* synthetic */ f(AdsMediaSource.ComponentListener componentListener, AdPlaybackState adPlaybackState) {
        this.s = componentListener;
        this.X = adPlaybackState;
    }

    public final void run() {
        this.s.f(this.X);
    }
}
