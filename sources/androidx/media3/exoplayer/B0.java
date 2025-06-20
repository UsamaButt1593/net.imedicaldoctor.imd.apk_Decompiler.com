package androidx.media3.exoplayer;

public final /* synthetic */ class B0 implements Runnable {
    public final /* synthetic */ PlayerMessage X;
    public final /* synthetic */ ExoPlayerImplInternal s;

    public /* synthetic */ B0(ExoPlayerImplInternal exoPlayerImplInternal, PlayerMessage playerMessage) {
        this.s = exoPlayerImplInternal;
        this.X = playerMessage;
    }

    public final void run() {
        this.s.a0(this.X);
    }
}
