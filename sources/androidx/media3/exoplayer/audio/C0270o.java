package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;

/* renamed from: androidx.media3.exoplayer.audio.o  reason: case insensitive filesystem */
public final /* synthetic */ class C0270o implements Runnable {
    public final /* synthetic */ AudioSink.AudioTrackConfig X;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher s;

    public /* synthetic */ C0270o(AudioRendererEventListener.EventDispatcher eventDispatcher, AudioSink.AudioTrackConfig audioTrackConfig) {
        this.s = eventDispatcher;
        this.X = audioTrackConfig;
    }

    public final void run() {
        this.s.x(this.X);
    }
}
