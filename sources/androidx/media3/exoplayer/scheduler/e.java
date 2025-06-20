package androidx.media3.exoplayer.scheduler;

import androidx.media3.exoplayer.scheduler.RequirementsWatcher;

public final /* synthetic */ class e implements Runnable {
    public final /* synthetic */ RequirementsWatcher.NetworkCallback s;

    public /* synthetic */ e(RequirementsWatcher.NetworkCallback networkCallback) {
        this.s = networkCallback;
    }

    public final void run() {
        this.s.c();
    }
}
