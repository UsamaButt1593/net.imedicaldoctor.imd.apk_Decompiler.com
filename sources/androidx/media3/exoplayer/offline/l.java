package androidx.media3.exoplayer.offline;

import androidx.media3.exoplayer.offline.DownloadManager;
import java.util.Comparator;

public final /* synthetic */ class l implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return DownloadManager.InternalHandler.d((Download) obj, (Download) obj2);
    }
}
