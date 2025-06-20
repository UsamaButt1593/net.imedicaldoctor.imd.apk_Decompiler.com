package androidx.media3.exoplayer.drm;

import android.media.MediaDrm;
import androidx.media3.exoplayer.drm.ExoMediaDrm;
import java.util.List;

public final /* synthetic */ class F implements MediaDrm.OnKeyStatusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FrameworkMediaDrm f11328a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ExoMediaDrm.OnKeyStatusChangeListener f11329b;

    public /* synthetic */ F(FrameworkMediaDrm frameworkMediaDrm, ExoMediaDrm.OnKeyStatusChangeListener onKeyStatusChangeListener) {
        this.f11328a = frameworkMediaDrm;
        this.f11329b = onKeyStatusChangeListener;
    }

    public final void onKeyStatusChange(MediaDrm mediaDrm, byte[] bArr, List list, boolean z) {
        this.f11328a.O(this.f11329b, mediaDrm, bArr, list, z);
    }
}
