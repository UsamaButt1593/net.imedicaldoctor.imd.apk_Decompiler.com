package androidx.media3.exoplayer.trackselection;

import androidx.annotation.Nullable;
import androidx.media3.common.Tracks;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.RendererConfiguration;

@UnstableApi
public final class TrackSelectorResult {

    /* renamed from: a  reason: collision with root package name */
    public final int f12416a;

    /* renamed from: b  reason: collision with root package name */
    public final RendererConfiguration[] f12417b;

    /* renamed from: c  reason: collision with root package name */
    public final ExoTrackSelection[] f12418c;

    /* renamed from: d  reason: collision with root package name */
    public final Tracks f12419d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    public final Object f12420e;

    public TrackSelectorResult(RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr, Tracks tracks, @Nullable Object obj) {
        this.f12417b = rendererConfigurationArr;
        this.f12418c = (ExoTrackSelection[]) exoTrackSelectionArr.clone();
        this.f12419d = tracks;
        this.f12420e = obj;
        this.f12416a = rendererConfigurationArr.length;
    }

    public boolean a(@Nullable TrackSelectorResult trackSelectorResult) {
        if (trackSelectorResult == null || trackSelectorResult.f12418c.length != this.f12418c.length) {
            return false;
        }
        for (int i2 = 0; i2 < this.f12418c.length; i2++) {
            if (!b(trackSelectorResult, i2)) {
                return false;
            }
        }
        return true;
    }

    public boolean b(@Nullable TrackSelectorResult trackSelectorResult, int i2) {
        return trackSelectorResult != null && Util.g(this.f12417b[i2], trackSelectorResult.f12417b[i2]) && Util.g(this.f12418c[i2], trackSelectorResult.f12418c[i2]);
    }

    public boolean c(int i2) {
        return this.f12417b[i2] != null;
    }

    @Deprecated
    public TrackSelectorResult(RendererConfiguration[] rendererConfigurationArr, ExoTrackSelection[] exoTrackSelectionArr, @Nullable Object obj) {
        this(rendererConfigurationArr, exoTrackSelectionArr, Tracks.X, obj);
    }
}
