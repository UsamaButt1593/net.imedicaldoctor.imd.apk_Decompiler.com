package androidx.media3.exoplayer.source.ads;

import androidx.media3.exoplayer.source.ads.AdsMediaSource;

public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ AdsMediaSource.ComponentListener X;
    public final /* synthetic */ AdsMediaSource s;

    public /* synthetic */ c(AdsMediaSource adsMediaSource, AdsMediaSource.ComponentListener componentListener) {
        this.s = adsMediaSource;
        this.X = componentListener;
    }

    public final void run() {
        this.s.X0(this.X);
    }
}
