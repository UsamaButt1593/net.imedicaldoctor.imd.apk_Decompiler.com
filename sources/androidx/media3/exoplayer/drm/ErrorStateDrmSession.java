package androidx.media3.exoplayer.drm;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;
import java.util.Map;
import java.util.UUID;

@UnstableApi
public final class ErrorStateDrmSession implements DrmSession {

    /* renamed from: f  reason: collision with root package name */
    private final DrmSession.DrmSessionException f11307f;

    public ErrorStateDrmSession(DrmSession.DrmSessionException drmSessionException) {
        this.f11307f = (DrmSession.DrmSessionException) Assertions.g(drmSessionException);
    }

    @Nullable
    public DrmSession.DrmSessionException e() {
        return this.f11307f;
    }

    public void f(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }

    public final UUID g() {
        return C.h2;
    }

    public int getState() {
        return 1;
    }

    public boolean h() {
        return false;
    }

    @Nullable
    public Map<String, String> i() {
        return null;
    }

    public void j(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
    }

    @Nullable
    public byte[] k() {
        return null;
    }

    public boolean l(String str) {
        return false;
    }

    @Nullable
    public CryptoConfig m() {
        return null;
    }
}
