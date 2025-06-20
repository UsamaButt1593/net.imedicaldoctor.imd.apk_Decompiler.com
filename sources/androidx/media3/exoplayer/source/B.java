package androidx.media3.exoplayer.source;

import androidx.media3.extractor.SeekMap;

public final /* synthetic */ class B implements Runnable {
    public final /* synthetic */ SeekMap X;
    public final /* synthetic */ ProgressiveMediaPeriod s;

    public /* synthetic */ B(ProgressiveMediaPeriod progressiveMediaPeriod, SeekMap seekMap) {
        this.s = progressiveMediaPeriod;
        this.X = seekMap;
    }

    public final void run() {
        this.s.U(this.X);
    }
}
