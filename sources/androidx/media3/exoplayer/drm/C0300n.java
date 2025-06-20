package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.DrmSessionEventListener;

/* renamed from: androidx.media3.exoplayer.drm.n  reason: case insensitive filesystem */
public final /* synthetic */ class C0300n implements Runnable {
    public final /* synthetic */ DrmSessionEventListener X;
    public final /* synthetic */ int Y;
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher s;

    public /* synthetic */ C0300n(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, int i2) {
        this.s = eventDispatcher;
        this.X = drmSessionEventListener;
        this.Y = i2;
    }

    public final void run() {
        this.s.q(this.X, this.Y);
    }
}
