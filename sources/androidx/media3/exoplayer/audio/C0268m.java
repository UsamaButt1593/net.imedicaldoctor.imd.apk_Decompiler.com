package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;

/* renamed from: androidx.media3.exoplayer.audio.m  reason: case insensitive filesystem */
public final /* synthetic */ class C0268m implements Runnable {
    public final /* synthetic */ long X;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher s;

    public /* synthetic */ C0268m(AudioRendererEventListener.EventDispatcher eventDispatcher, long j2) {
        this.s = eventDispatcher;
        this.X = j2;
    }

    public final void run() {
        this.s.E(this.X);
    }
}
