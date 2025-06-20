package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;

/* renamed from: androidx.media3.exoplayer.audio.k  reason: case insensitive filesystem */
public final /* synthetic */ class C0266k implements Runnable {
    public final /* synthetic */ DecoderCounters X;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher s;

    public /* synthetic */ C0266k(AudioRendererEventListener.EventDispatcher eventDispatcher, DecoderCounters decoderCounters) {
        this.s = eventDispatcher;
        this.X = decoderCounters;
    }

    public final void run() {
        this.s.C(this.X);
    }
}
