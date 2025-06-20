package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.DrmSessionEventListener;

/* renamed from: androidx.media3.exoplayer.drm.k  reason: case insensitive filesystem */
public final /* synthetic */ class C0297k implements Runnable {
    public final /* synthetic */ DrmSessionEventListener X;
    public final /* synthetic */ Exception Y;
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher s;

    public /* synthetic */ C0297k(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener, Exception exc) {
        this.s = eventDispatcher;
        this.X = drmSessionEventListener;
        this.Y = exc;
    }

    public final void run() {
        this.s.r(this.X, this.Y);
    }
}
