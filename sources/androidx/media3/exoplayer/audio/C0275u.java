package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;

/* renamed from: androidx.media3.exoplayer.audio.u  reason: case insensitive filesystem */
public final /* synthetic */ class C0275u implements Runnable {
    public final /* synthetic */ String X;
    public final /* synthetic */ long Y;
    public final /* synthetic */ long Z;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher s;

    public /* synthetic */ C0275u(AudioRendererEventListener.EventDispatcher eventDispatcher, String str, long j2, long j3) {
        this.s = eventDispatcher;
        this.X = str;
        this.Y = j2;
        this.Z = j3;
    }

    public final void run() {
        this.s.z(this.X, this.Y, this.Z);
    }
}
