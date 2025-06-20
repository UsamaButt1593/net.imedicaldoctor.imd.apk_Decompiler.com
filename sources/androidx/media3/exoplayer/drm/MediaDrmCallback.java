package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import java.util.UUID;

@UnstableApi
public interface MediaDrmCallback {
    byte[] a(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) throws MediaDrmCallbackException;

    byte[] b(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) throws MediaDrmCallbackException;
}
