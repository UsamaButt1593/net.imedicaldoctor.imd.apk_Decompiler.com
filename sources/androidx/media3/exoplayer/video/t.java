package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class t implements Runnable {
    public final /* synthetic */ Exception X;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher s;

    public /* synthetic */ t(VideoRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.s = eventDispatcher;
        this.X = exc;
    }

    public final void run() {
        this.s.y(this.X);
    }
}
