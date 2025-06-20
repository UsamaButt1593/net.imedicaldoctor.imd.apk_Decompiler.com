package androidx.media3.exoplayer.audio;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;

/* renamed from: androidx.media3.exoplayer.audio.s  reason: case insensitive filesystem */
public final /* synthetic */ class C0273s implements Runnable {
    public final /* synthetic */ Format X;
    public final /* synthetic */ DecoderReuseEvaluation Y;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher s;

    public /* synthetic */ C0273s(AudioRendererEventListener.EventDispatcher eventDispatcher, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.s = eventDispatcher;
        this.X = format;
        this.Y = decoderReuseEvaluation;
    }

    public final void run() {
        this.s.D(this.X, this.Y);
    }
}
