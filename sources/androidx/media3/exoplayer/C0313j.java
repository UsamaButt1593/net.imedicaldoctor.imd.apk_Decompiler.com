package androidx.media3.exoplayer;

import androidx.media3.exoplayer.AudioFocusManager;

/* renamed from: androidx.media3.exoplayer.j  reason: case insensitive filesystem */
public final /* synthetic */ class C0313j implements Runnable {
    public final /* synthetic */ int X;
    public final /* synthetic */ AudioFocusManager.AudioFocusListener s;

    public /* synthetic */ C0313j(AudioFocusManager.AudioFocusListener audioFocusListener, int i2) {
        this.s = audioFocusListener;
        this.X = i2;
    }

    public final void run() {
        this.s.b(this.X);
    }
}
