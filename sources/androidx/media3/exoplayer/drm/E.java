package androidx.media3.exoplayer.drm;

import android.media.MediaDrm;
import androidx.media3.exoplayer.drm.ExoMediaDrm;

public final /* synthetic */ class E implements MediaDrm.OnEventListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMediaDrm f11305a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoMediaDrm.OnEventListener f11306b;

    public /* synthetic */ E(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.OnEventListener onEventListener) {
        this.f11305a = frameworkMediaDrm;
        this.f11306b = onEventListener;
    }

    public final void onEvent(MediaDrm mediaDrm, byte[] bArr, int i2, int i3, byte[] bArr2) {
        this.f11305a.M(this.f11306b, mediaDrm, bArr, i2, i3, bArr2);
    }
}
