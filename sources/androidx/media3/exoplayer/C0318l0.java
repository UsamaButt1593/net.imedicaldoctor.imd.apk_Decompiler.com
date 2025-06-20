package androidx.media3.exoplayer;

import androidx.media3.exoplayer.ExoPlayerImplInternal;

/* renamed from: androidx.media3.exoplayer.l0  reason: case insensitive filesystem */
public final /* synthetic */ class C0318l0 implements Runnable {
    public final /* synthetic */ ExoPlayerImplInternal.PlaybackInfoUpdate X;
    public final /* synthetic */ ExoPlayerImpl s;

    public /* synthetic */ C0318l0(ExoPlayerImpl exoPlayerImpl, ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.s = exoPlayerImpl;
        this.X = playbackInfoUpdate;
    }

    public final void run() {
        this.s.p4(this.X);
    }
}
