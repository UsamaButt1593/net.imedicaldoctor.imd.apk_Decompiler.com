package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.Consumer;
import androidx.media3.exoplayer.drm.DrmSessionEventListener;

/* renamed from: androidx.media3.exoplayer.drm.a  reason: case insensitive filesystem */
public final /* synthetic */ class C0287a implements Consumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f11356a;

    public /* synthetic */ C0287a(int i2) {
        this.f11356a = i2;
    }

    public final void accept(Object obj) {
        ((DrmSessionEventListener.EventDispatcher) obj).k(this.f11356a);
    }
}
