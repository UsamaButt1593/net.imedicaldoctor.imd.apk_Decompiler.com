package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;

/* renamed from: androidx.media3.exoplayer.audio.q  reason: case insensitive filesystem */
public final /* synthetic */ class C0272q implements Runnable {
    public final /* synthetic */ Exception X;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher s;

    public /* synthetic */ C0272q(AudioRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.s = eventDispatcher;
        this.X = exc;
    }

    public final void run() {
        this.s.v(this.X);
    }
}
