package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.DrmSessionEventListener;

/* renamed from: androidx.media3.exoplayer.drm.o  reason: case insensitive filesystem */
public final /* synthetic */ class C0301o implements Runnable {
    public final /* synthetic */ DrmSessionEventListener X;
    public final /* synthetic */ DrmSessionEventListener.EventDispatcher s;

    public /* synthetic */ C0301o(DrmSessionEventListener.EventDispatcher eventDispatcher, DrmSessionEventListener drmSessionEventListener) {
        this.s = eventDispatcher;
        this.X = drmSessionEventListener;
    }

    public final void run() {
        this.s.n(this.X);
    }
}
