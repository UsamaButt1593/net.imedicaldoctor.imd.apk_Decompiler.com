package androidx.media3.exoplayer.audio;

public final /* synthetic */ class P implements Runnable {
    public final /* synthetic */ DefaultAudioSink s;

    public /* synthetic */ P(DefaultAudioSink defaultAudioSink) {
        this.s = defaultAudioSink;
    }

    public final void run() {
        this.s.g0();
    }
}
