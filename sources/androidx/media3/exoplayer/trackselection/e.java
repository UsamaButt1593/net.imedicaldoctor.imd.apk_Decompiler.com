package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.TrackGroup;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import java.util.List;

public final /* synthetic */ class e implements DefaultTrackSelector.TrackInfo.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector.Parameters f12421a;

    public /* synthetic */ e(DefaultTrackSelector.Parameters parameters) {
        this.f12421a = parameters;
    }

    public final List a(int i2, TrackGroup trackGroup, int[] iArr) {
        return DefaultTrackSelector.ImageTrackInfo.f(i2, trackGroup, this.f12421a, iArr);
    }
}
