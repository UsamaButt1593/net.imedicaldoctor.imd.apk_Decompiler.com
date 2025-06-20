package androidx.media3.exoplayer.offline;

import androidx.media3.exoplayer.offline.DownloadHelper;

public final /* synthetic */ class h implements Runnable {
    public final /* synthetic */ DownloadHelper.Callback X;
    public final /* synthetic */ DownloadHelper s;

    public /* synthetic */ h(DownloadHelper downloadHelper, DownloadHelper.Callback callback) {
        this.s = downloadHelper;
        this.X = callback;
    }

    public final void run() {
        this.s.O(this.X);
    }
}
