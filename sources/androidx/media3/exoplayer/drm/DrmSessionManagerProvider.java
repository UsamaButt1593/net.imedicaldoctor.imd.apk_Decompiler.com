package androidx.media3.exoplayer.drm;

import androidx.media3.common.MediaItem;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public interface DrmSessionManagerProvider {
    DrmSessionManager a(MediaItem mediaItem);
}
