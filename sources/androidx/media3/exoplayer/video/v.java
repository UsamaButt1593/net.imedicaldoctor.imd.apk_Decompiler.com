package androidx.media3.exoplayer.video;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.video.VideoRendererEventListener;

public final /* synthetic */ class v implements Runnable {
    public final /* synthetic */ Format X;
    public final /* synthetic */ DecoderReuseEvaluation Y;
    public final /* synthetic */ VideoRendererEventListener.EventDispatcher s;

    public /* synthetic */ v(VideoRendererEventListener.EventDispatcher eventDispatcher, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.s = eventDispatcher;
        this.X = format;
        this.Y = decoderReuseEvaluation;
    }

    public final void run() {
        this.s.v(this.X, this.Y);
    }
}
