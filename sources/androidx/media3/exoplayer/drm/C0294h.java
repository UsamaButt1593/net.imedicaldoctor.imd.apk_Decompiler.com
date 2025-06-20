package androidx.media3.exoplayer.drm;

import androidx.media3.exoplayer.drm.DrmSessionEventListener;

/* renamed from: androidx.media3.exoplayer.drm.h  reason: case insensitive filesystem */
public final /* synthetic */ class C0294h implements Runnable {
    public final /* synthetic */ DefaultDrmSession s;

    public /* synthetic */ C0294h(DefaultDrmSession defaultDrmSession) {
        this.s = defaultDrmSession;
    }

    public final void run() {
        this.s.j((DrmSessionEventListener.EventDispatcher) null);
    }
}
