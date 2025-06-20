package androidx.media3.exoplayer.mediacodec;

public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ AsynchronousMediaCodecCallback s;

    public /* synthetic */ i(AsynchronousMediaCodecCallback asynchronousMediaCodecCallback) {
        this.s = asynchronousMediaCodecCallback;
    }

    public final void run() {
        this.s.n();
    }
}
