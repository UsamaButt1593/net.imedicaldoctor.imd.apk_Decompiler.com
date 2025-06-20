package androidx.media3.exoplayer.drm;

import androidx.annotation.Nullable;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;

/* renamed from: androidx.media3.exoplayer.drm.i  reason: case insensitive filesystem */
public final /* synthetic */ class C0295i {
    public static boolean a(DrmSession drmSession) {
        return false;
    }

    public static void b(@Nullable DrmSession drmSession, @Nullable DrmSession drmSession2) {
        if (drmSession != drmSession2) {
            if (drmSession2 != null) {
                drmSession2.f((DrmSessionEventListener.EventDispatcher) null);
            }
            if (drmSession != null) {
                drmSession.j((DrmSessionEventListener.EventDispatcher) null);
            }
        }
    }
}
