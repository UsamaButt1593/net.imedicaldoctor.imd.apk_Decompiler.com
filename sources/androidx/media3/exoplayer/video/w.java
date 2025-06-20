package androidx.media3.exoplayer.video;

import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class w implements Runnable {
    public final /* synthetic */ DecoderCounters X;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher s;

    public /* synthetic */ w(VideoRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.s = eventDispatcher;
        this.X = decoderCounters;
    }

    public final void run() {
        this.s.s(this.X);
    }
}
