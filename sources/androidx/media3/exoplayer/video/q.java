package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class q implements Runnable {
    public final /* synthetic */ int X;
    public final /* synthetic */ long Y;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher s;

    public /* synthetic */ q(VideoRendererEventListener.EventDispatcher eventDispatcher, int i2, long j2) {
        this.s = eventDispatcher;
        this.X = i2;
        this.Y = j2;
    }

    public final void run() {
        this.s.t(this.X, this.Y);
    }
}
