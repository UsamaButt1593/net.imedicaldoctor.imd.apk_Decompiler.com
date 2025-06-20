package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.TrackGroup;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import java.util.List;

public final /* synthetic */ class l implements DefaultTrackSelector.TrackInfo.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector.Parameters f12428a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f12429b;

    public /* synthetic */ l(DefaultTrackSelector.Parameters parameters, String str) {
        this.f12428a = parameters;
        this.f12429b = str;
    }

    public final List a(int i2, TrackGroup trackGroup, int[] iArr) {
        return DefaultTrackSelector.TextTrackInfo.f(i2, trackGroup, this.f12428a, iArr, this.f12429b);
    }
}
