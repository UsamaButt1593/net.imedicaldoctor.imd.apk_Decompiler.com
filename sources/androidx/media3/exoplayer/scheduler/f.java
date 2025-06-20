package androidx.media3.exoplayer.scheduler;

import androidx.media3.exoplayer.scheduler.RequirementsWatcher;

public final /* synthetic */ class f implements Runnable {
    public final /* synthetic */ RequirementsWatcher.NetworkCallback s;

    public /* synthetic */ f(RequirementsWatcher.NetworkCallback networkCallback) {
        this.s = networkCallback;
    }

    public final void run() {
        this.s.d();
    }
}
