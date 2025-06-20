package androidx.media3.exoplayer.drm;

import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class P implements Runnable {
    public final /* synthetic */ SettableFuture X;
    public final /* synthetic */ DrmSession Y;
    public final /* synthetic */ OfflineLicenseHelper s;

    public /* synthetic */ P(OfflineLicenseHelper offlineLicenseHelper, SettableFuture settableFuture, DrmSession drmSession) {
        this.s = offlineLicenseHelper;
        this.X = settableFuture;
        this.Y = drmSession;
    }

    public final void run() {
        this.s.m(this.X, this.Y);
    }
}
