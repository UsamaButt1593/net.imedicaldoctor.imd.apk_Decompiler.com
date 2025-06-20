package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class r implements Runnable {
    public final /* synthetic */ Object X;
    public final /* synthetic */ long Y;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher s;

    public /* synthetic */ r(VideoRendererEventListener.EventDispatcher eventDispatcher, Object obj, long j2) {
        this.s = eventDispatcher;
        this.X = obj;
        this.Y = j2;
    }

    public final void run() {
        this.s.w(this.X, this.Y);
    }
}
