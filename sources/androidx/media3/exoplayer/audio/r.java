package androidx.media3.exoplayer.audio;

import androidx.media3.exoplayer.audio.AudioRendererEventListener;

public final /* synthetic */ class r implements Runnable {
    public final /* synthetic */ Exception X;
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher s;

    public /* synthetic */ r(AudioRendererEventListener.EventDispatcher eventDispatcher, Exception exc) {
        this.s = eventDispatcher;
        this.X = exc;
    }

    public final void run() {
        this.s.w(this.X);
    }
}
