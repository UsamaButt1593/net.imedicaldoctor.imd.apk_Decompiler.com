package androidx.media3.exoplayer.offline;

import android.os.Handler;
import android.os.Message;
import androidx.media3.exoplayer.offline.DownloadHelper;

public final /* synthetic */ class i implements Handler.Callback {
    public final /* synthetic */ DownloadHelper.MediaPreparer s;

    public /* synthetic */ i(DownloadHelper.MediaPreparer mediaPreparer) {
        this.s = mediaPreparer;
    }

    public final boolean handleMessage(Message message) {
        return this.s.c(message);
    }
}
