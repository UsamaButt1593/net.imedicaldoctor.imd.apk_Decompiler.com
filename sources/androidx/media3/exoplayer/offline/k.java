package androidx.media3.exoplayer.offline;

import androidx.media3.exoplayer.scheduler.RequirementsWatcher;

public final /* synthetic */ class k implements RequirementsWatcher.Listener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DownloadManager f11869a;

    public /* synthetic */ k(DownloadManager downloadManager) {
        this.f11869a = downloadManager;
    }

    public final void a(RequirementsWatcher requirementsWatcher, int i2) {
        this.f11869a.w(requirementsWatcher, i2);
    }
}
