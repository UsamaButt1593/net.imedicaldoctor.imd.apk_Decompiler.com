package androidx.media3.exoplayer.trackselection;

import androidx.media3.common.TrackGroup;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import java.util.List;

public final /* synthetic */ class h implements DefaultTrackSelector.TrackInfo.Factory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector f12422a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultTrackSelector.Parameters f12423b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f12424c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int[] f12425d;

    public /* synthetic */ h(DefaultTrackSelector defaultTrackSelector, DefaultTrackSelector.Parameters parameters, boolean z, int[] iArr) {
        this.f12422a = defaultTrackSelector;
        this.f12423b = parameters;
        this.f12424c = z;
        this.f12425d = iArr;
    }

    public final List a(int i2, TrackGroup trackGroup, int[] iArr) {
        return this.f12422a.T(this.f12423b, this.f12424c, this.f12425d, i2, trackGroup, iArr);
    }
}
