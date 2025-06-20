package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.TrackGroup;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import java.util.List;

public final /* synthetic */ class j implements DefaultTrackSelector.TrackInfo.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector.Parameters f12426a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int[] f12427b;

    public /* synthetic */ j(DefaultTrackSelector.Parameters parameters, int[] iArr) {
        this.f12426a = parameters;
        this.f12427b = iArr;
    }

    public final List a(int i2, TrackGroup trackGroup, int[] iArr) {
        return DefaultTrackSelector.VideoTrackInfo.i(i2, trackGroup, this.f12426a, iArr, this.f12427b[i2]);
    }
}
