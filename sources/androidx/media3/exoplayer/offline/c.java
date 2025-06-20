package androidx.media3.exoplayer.offline;

import androidx.media3.common.MediaItem;
import androidx.media3.exoplayer.drm.DrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSessionManagerProvider;

public final /* synthetic */ class c implements DrmSessionManagerProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DrmSessionManager f11868a;

    public /* synthetic */ c(DrmSessionManager drmSessionManager) {
        this.f11868a = drmSessionManager;
    }

    public final DrmSessionManager a(MediaItem mediaItem) {
        return DownloadHelper.I(this.f11868a, mediaItem);
    }
}
