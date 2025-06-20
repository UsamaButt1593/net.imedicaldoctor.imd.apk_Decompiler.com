package androidx.media3.exoplayer.drm;

import android.media.MediaDrm;
import androidx.media3.exoplayer.drm.ExoMediaDrm;

public final /* synthetic */ class D implements MediaDrm.OnExpirationUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMediaDrm f11235a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoMediaDrm.OnExpirationUpdateListener f11236b;

    public /* synthetic */ D(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.OnExpirationUpdateListener onExpirationUpdateListener) {
        this.f11235a = frameworkMediaDrm;
        this.f11236b = onExpirationUpdateListener;
    }

    public final void onExpirationUpdate(MediaDrm mediaDrm, byte[] bArr, long j2) {
        this.f11235a.N(this.f11236b, mediaDrm, bArr, j2);
    }
}
