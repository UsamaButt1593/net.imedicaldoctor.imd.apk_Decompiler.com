package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class x implements Runnable {
    public final /* synthetic */ String X;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher s;

    public /* synthetic */ x(VideoRendererEventListener.EventDispatcher eventDispatcher, String str) {
        this.s = eventDispatcher;
        this.X = str;
    }

    public final void run() {
        this.s.r(this.X);
    }
}
