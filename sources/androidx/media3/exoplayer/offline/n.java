package androidx.media3.exoplayer.offline;

import androidx.media3.exoplayer.offline.DownloadService;

public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ DownloadService X;
    public final /* synthetic */ DownloadService.DownloadManagerHelper s;

    public /* synthetic */ n(DownloadService.DownloadManagerHelper downloadManagerHelper, DownloadService downloadService) {
        this.s = downloadManagerHelper;
        this.X = downloadService;
    }

    public final void run() {
        this.s.m(this.X);
    }
}
