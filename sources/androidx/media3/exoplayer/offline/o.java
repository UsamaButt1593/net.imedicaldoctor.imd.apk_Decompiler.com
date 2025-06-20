package androidx.media3.exoplayer.offline;

import androidx.media3.exoplayer.offline.DownloadService;

public final /* synthetic */ class o implements Runnable {
    public final /* synthetic */ DownloadService.ForegroundNotificationUpdater s;

    public /* synthetic */ o(DownloadService.ForegroundNotificationUpdater foregroundNotificationUpdater) {
        this.s = foregroundNotificationUpdater;
    }

    public final void run() {
        this.s.f();
    }
}
