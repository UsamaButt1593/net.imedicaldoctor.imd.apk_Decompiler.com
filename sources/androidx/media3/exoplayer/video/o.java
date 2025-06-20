package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ String X;
    public final /* synthetic */ long Y;
    public final /* synthetic */ long Z;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher s;

    public /* synthetic */ o(VideoRendererEventListener.EventDispatcher eventDispatcher, String str, long j2, long j3) {
        this.s = eventDispatcher;
        this.X = str;
        this.Y = j2;
        this.Z = j3;
    }

    public final void run() {
        this.s.q(this.X, this.Y, this.Z);
    }
}
