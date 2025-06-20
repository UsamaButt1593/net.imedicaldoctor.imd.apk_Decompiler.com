package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;

/* renamed from: androidx.media3.exoplayer.audio.p  reason: case insensitive filesystem */
public final /* synthetic */ class C0271p implements Runnable {
    public final /* synthetic */ AudioSink.AudioTrackConfig X;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher s;

    public /* synthetic */ C0271p(AudioRendererEventListener.EventDispatcher eventDispatcher, AudioSink.AudioTrackConfig audioTrackConfig) {
        this.s = eventDispatcher;
        this.X = audioTrackConfig;
    }

    public final void run() {
        this.s.y(this.X);
    }
}
