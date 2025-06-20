package androidx.media3.exoplayer.video;

import androidx.media3.common.VideoSize;
import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class p implements Runnable {
    public final /* synthetic */ VideoSize X;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher s;

    public /* synthetic */ p(VideoRendererEventListener.EventDispatcher eventDispatcher, VideoSize videoSize) {
        this.s = eventDispatcher;
        this.X = videoSize;
    }

    public final void run() {
        this.s.z(this.X);
    }
}
