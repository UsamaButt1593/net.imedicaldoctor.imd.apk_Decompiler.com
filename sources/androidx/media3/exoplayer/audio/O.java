package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioSink;

public final /* synthetic */ class O implements Runnable {
    public final /* synthetic */ AudioSink.AudioTrackConfig X;
    public final /* synthetic */ AudioSink.Listener s;

    public /* synthetic */ O(AudioSink.Listener listener, AudioSink.AudioTrackConfig audioTrackConfig) {
        this.s = listener;
        this.X = audioTrackConfig;
    }

    public final void run() {
        this.s.d(this.X);
    }
}
