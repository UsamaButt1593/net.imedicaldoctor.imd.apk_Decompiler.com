package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;

public final /* synthetic */ class E0 {
    public static void a(LoadControl loadControl, Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        loadControl.e(rendererArr, trackGroupArray, exoTrackSelectionArr);
    }

    @Deprecated
    public static void b(LoadControl loadControl, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr) {
        loadControl.h(Timeline.s, LoadControl.f10227a, rendererArr, trackGroupArray, exoTrackSelectionArr);
    }

    @Deprecated
    public static boolean c(LoadControl loadControl, long j2, float f2, boolean z, long j3) {
        return loadControl.d(Timeline.s, LoadControl.f10227a, j2, f2, z, j3);
    }

    public static boolean d(LoadControl loadControl, Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2, float f2, boolean z, long j3) {
        return loadControl.i(j2, f2, z, j3);
    }
}
