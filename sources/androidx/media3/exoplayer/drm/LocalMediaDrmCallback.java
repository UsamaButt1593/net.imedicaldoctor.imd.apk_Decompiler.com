package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import java.util.UUID;

@UnstableApi
public final class LocalMediaDrmCallback implements MediaDrmCallback {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f11347a;

    public LocalMediaDrmCallback(byte[] bArr) {
        this.f11347a = (byte[]) Assertions.g(bArr);
    }

    public byte[] a(UUID uuid, ExoMediaDrm.ProvisionRequest provisionRequest) {
        throw new UnsupportedOperationException();
    }

    public byte[] b(UUID uuid, ExoMediaDrm.KeyRequest keyRequest) {
        return this.f11347a;
    }
}
