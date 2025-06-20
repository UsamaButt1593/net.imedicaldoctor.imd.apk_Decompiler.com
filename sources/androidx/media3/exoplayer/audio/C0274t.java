package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;

/* renamed from: androidx.media3.exoplayer.audio.t  reason: case insensitive filesystem */
public final /* synthetic */ class C0274t implements Runnable {
    public final /* synthetic */ boolean X;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher s;

    public /* synthetic */ C0274t(AudioRendererEventListener.EventDispatcher eventDispatcher, boolean z) {
        this.s = eventDispatcher;
        this.X = z;
    }

    public final void run() {
        this.s.F(this.X);
    }
}
