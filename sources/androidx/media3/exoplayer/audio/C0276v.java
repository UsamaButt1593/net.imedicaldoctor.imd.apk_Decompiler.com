package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;

/* renamed from: androidx.media3.exoplayer.audio.v  reason: case insensitive filesystem */
public final /* synthetic */ class C0276v implements Runnable {
    public final /* synthetic */ String X;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher s;

    public /* synthetic */ C0276v(AudioRendererEventListener.EventDispatcher eventDispatcher, String str) {
        this.s = eventDispatcher;
        this.X = str;
    }

    public final void run() {
        this.s.A(this.X);
    }
}
