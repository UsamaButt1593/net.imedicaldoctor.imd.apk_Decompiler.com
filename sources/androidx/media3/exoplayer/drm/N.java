package androidx.media3.exoplayer.drm;

import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class N implements Runnable {
    public final /* synthetic */ DrmSession X;
    public final /* synthetic */ SettableFuture Y;
    public final /* synthetic */ OfflineLicenseHelper s;

    public /* synthetic */ N(OfflineLicenseHelper offlineLicenseHelper, DrmSession drmSession, SettableFuture settableFuture) {
        this.s = offlineLicenseHelper;
        this.X = drmSession;
        this.Y = settableFuture;
    }

    public final void run() {
        this.s.l(this.X, this.Y);
    }
}
