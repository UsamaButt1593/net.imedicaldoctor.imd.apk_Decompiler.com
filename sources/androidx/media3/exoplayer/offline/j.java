package androidx.media3.exoplayer.offline;

import android.os.Handler;
import android.os.Message;

public final /* synthetic */ class j implements Handler.Callback {
    public final /* synthetic */ DownloadManager s;

    public /* synthetic */ j(DownloadManager downloadManager) {
        this.s = downloadManager;
    }

    public final boolean handleMessage(Message message) {
        return this.s.n(message);
    }
}
