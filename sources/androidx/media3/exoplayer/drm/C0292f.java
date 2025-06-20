package androidx.media3.exoplayer.drm;

import androidx.media3.common.Format;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;

/* renamed from: androidx.media3.exoplayer.drm.f  reason: case insensitive filesystem */
public final /* synthetic */ class C0292f implements Runnable {
    public final /* synthetic */ Format X;
    public final /* synthetic */ DefaultDrmSessionManager.PreacquiredSessionReference s;

    public /* synthetic */ C0292f(DefaultDrmSessionManager.PreacquiredSessionReference preacquiredSessionReference, Format format) {
        this.s = preacquiredSessionReference;
        this.X = format;
    }

    public final void run() {
        this.s.e(this.X);
    }
}
