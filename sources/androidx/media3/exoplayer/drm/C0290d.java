package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.Consumer;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;

/* renamed from: androidx.media3.exoplayer.drm.d  reason: case insensitive filesystem */
public final /* synthetic */ class C0290d implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Throwable f11357a;

    public /* synthetic */ C0290d(Throwable th) {
        this.f11357a = th;
    }

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).l((Exception) this.f11357a);
    }
}
