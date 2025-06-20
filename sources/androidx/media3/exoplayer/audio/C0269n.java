package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;

/* renamed from: androidx.media3.exoplayer.audio.n  reason: case insensitive filesystem */
public final /* synthetic */ class C0269n implements Runnable {
    public final /* synthetic */ int X;
    public final /* synthetic */ long Y;
    public final /* synthetic */ long Z;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher s;

    public /* synthetic */ C0269n(AudioRendererEventListener.EventDispatcher eventDispatcher, int i2, long j2, long j3) {
        this.s = eventDispatcher;
        this.X = i2;
        this.Y = j2;
        this.Z = j3;
    }

    public final void run() {
        this.s.G(this.X, this.Y, this.Z);
    }
}
