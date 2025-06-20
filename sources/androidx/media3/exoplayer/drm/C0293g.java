package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;

/* renamed from: androidx.media3.exoplayer.drm.g  reason: case insensitive filesystem */
public final /* synthetic */ class C0293g implements Runnable {
    public final /* synthetic */ DefaultDrmSessionManager.PreacquiredSessionReference s;

    public /* synthetic */ C0293g(DefaultDrmSessionManager.PreacquiredSessionReference preacquiredSessionReference) {
        this.s = preacquiredSessionReference;
    }

    public final void run() {
        this.s.f();
    }
}
