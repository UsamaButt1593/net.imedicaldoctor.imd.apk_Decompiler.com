package androidx.media3.exoplayer.upstream;

import androidx.media3.exoplayer.upstream.BandwidthMeter;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ int X;
    public final /* synthetic */ long Y;
    public final /* synthetic */ long Z;
    public final /* synthetic */ BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener s;

    public /* synthetic */ b(BandwidthMeter.EventListener.EventDispatcher.HandlerAndListener handlerAndListener, int i2, long j2, long j3) {
        this.s = handlerAndListener;
        this.X = i2;
        this.Y = j2;
        this.Z = j3;
    }

    public final void run() {
        this.s.f12435b.P(this.X, this.Y, this.Z);
    }
}
