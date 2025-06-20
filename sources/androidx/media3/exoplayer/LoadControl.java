package androidx.media3.exoplayer;

import androidx.media3.common.Timeline;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.upstream.Allocator;

@UnstableApi
public interface LoadControl {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final MediaSource.MediaPeriodId f10227a = new MediaSource.MediaPeriodId(new Object());

    void b();

    boolean c();

    boolean d(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2, float f2, boolean z, long j3);

    @Deprecated
    void e(Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr);

    long f();

    void g();

    void h(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Renderer[] rendererArr, TrackGroupArray trackGroupArray, ExoTrackSelection[] exoTrackSelectionArr);

    @Deprecated
    boolean i(long j2, float f2, boolean z, long j3);

    boolean j(long j2, long j3, float f2);

    Allocator k();

    void l();
}
