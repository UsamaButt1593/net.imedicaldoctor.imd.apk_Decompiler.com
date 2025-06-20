package androidx.media3.exoplayer.offline;

import java.io.IOException;

public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ IOException X;
    public final /* synthetic */ DownloadHelper s;

    public /* synthetic */ g(DownloadHelper downloadHelper, IOException iOException) {
        this.s = downloadHelper;
        this.X = iOException;
    }

    public final void run() {
        this.s.M(this.X);
    }
}
