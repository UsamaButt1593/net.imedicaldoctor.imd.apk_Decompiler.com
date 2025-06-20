package androidx.media3.exoplayer.drm;

import com.google.common.util.concurrent.SettableFuture;

public final /* synthetic */ class O implements Runnable {
    public final /* synthetic */ SettableFuture X;
    public final /* synthetic */ OfflineLicenseHelper s;

    public /* synthetic */ O(OfflineLicenseHelper offlineLicenseHelper, SettableFuture settableFuture) {
        this.s = offlineLicenseHelper;
        this.X = settableFuture;
    }

    public final void run() {
        this.s.o(this.X);
    }
}
