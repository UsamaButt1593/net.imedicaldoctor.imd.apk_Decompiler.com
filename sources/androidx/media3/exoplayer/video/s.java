package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class s implements Runnable {
    public final /* synthetic */ long X;
    public final /* synthetic */ int Y;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher s;

    public /* synthetic */ s(VideoRendererEventListener.EventDispatcher eventDispatcher, long j2, int i2) {
        this.s = eventDispatcher;
        this.X = j2;
        this.Y = i2;
    }

    public final void run() {
        this.s.x(this.X, this.Y);
    }
}
