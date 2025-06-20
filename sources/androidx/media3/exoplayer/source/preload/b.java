package androidx.media3.exoplayer.source.preload;

public final /* synthetic */ class b implements Runnable {
    public final /* synthetic */ long X;
    public final /* synthetic */ PreloadMediaSource s;

    public /* synthetic */ b(PreloadMediaSource preloadMediaSource, long j2) {
        this.s = preloadMediaSource;
        this.X = j2;
    }

    public final void run() {
        this.s.g1(this.X);
    }
}
