package androidx.media3.exoplayer;

import android.os.SystemClock;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import com.google.common.collect.ImmutableList;
import java.util.List;

final class PlaybackInfo {
    private static final MediaSource.MediaPeriodId t = new MediaSource.MediaPeriodId(new Object());

    /* renamed from: a  reason: collision with root package name */
    public final Timeline f10304a;

    /* renamed from: b  reason: collision with root package name */
    public final MediaSource.MediaPeriodId f10305b;

    /* renamed from: c  reason: collision with root package name */
    public final long f10306c;

    /* renamed from: d  reason: collision with root package name */
    public final long f10307d;

    /* renamed from: e  reason: collision with root package name */
    public final int f10308e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    public final ExoPlaybackException f10309f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f10310g;

    /* renamed from: h  reason: collision with root package name */
    public final TrackGroupArray f10311h;

    /* renamed from: i  reason: collision with root package name */
    public final TrackSelectorResult f10312i;

    /* renamed from: j  reason: collision with root package name */
    public final List<Metadata> f10313j;

    /* renamed from: k  reason: collision with root package name */
    public final MediaSource.MediaPeriodId f10314k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f10315l;

    /* renamed from: m  reason: collision with root package name */
    public final int f10316m;

    /* renamed from: n  reason: collision with root package name */
    public final PlaybackParameters f10317n;
    public final boolean o;
    public volatile long p;
    public volatile long q;
    public volatile long r;
    public volatile long s;

    public PlaybackInfo(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, int i2, @Nullable ExoPlaybackException exoPlaybackException, boolean z, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List<Metadata> list, MediaSource.MediaPeriodId mediaPeriodId2, boolean z2, int i3, PlaybackParameters playbackParameters, long j4, long j5, long j6, long j7, boolean z3) {
        this.f10304a = timeline;
        this.f10305b = mediaPeriodId;
        this.f10306c = j2;
        this.f10307d = j3;
        this.f10308e = i2;
        this.f10309f = exoPlaybackException;
        this.f10310g = z;
        this.f10311h = trackGroupArray;
        this.f10312i = trackSelectorResult;
        this.f10313j = list;
        this.f10314k = mediaPeriodId2;
        this.f10315l = z2;
        this.f10316m = i3;
        this.f10317n = playbackParameters;
        this.p = j4;
        this.q = j5;
        this.r = j6;
        this.s = j7;
        this.o = z3;
    }

    public static PlaybackInfo k(TrackSelectorResult trackSelectorResult) {
        Timeline timeline = Timeline.s;
        MediaSource.MediaPeriodId mediaPeriodId = t;
        return new PlaybackInfo(timeline, mediaPeriodId, C.f9084b, 0, 1, (ExoPlaybackException) null, false, TrackGroupArray.X2, trackSelectorResult, ImmutableList.I(), mediaPeriodId, false, 0, PlaybackParameters.Z, 0, 0, 0, 0, false);
    }

    public static MediaSource.MediaPeriodId l() {
        return t;
    }

    @CheckResult
    public PlaybackInfo a() {
        return new PlaybackInfo(this.f10304a, this.f10305b, this.f10306c, this.f10307d, this.f10308e, this.f10309f, this.f10310g, this.f10311h, this.f10312i, this.f10313j, this.f10314k, this.f10315l, this.f10316m, this.f10317n, this.p, this.q, m(), SystemClock.elapsedRealtime(), this.o);
    }

    @CheckResult
    public PlaybackInfo b(boolean z) {
        Timeline timeline = this.f10304a;
        return new PlaybackInfo(timeline, this.f10305b, this.f10306c, this.f10307d, this.f10308e, this.f10309f, z, this.f10311h, this.f10312i, this.f10313j, this.f10314k, this.f10315l, this.f10316m, this.f10317n, this.p, this.q, this.r, this.s, this.o);
    }

    @CheckResult
    public PlaybackInfo c(MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline = this.f10304a;
        return new PlaybackInfo(timeline, this.f10305b, this.f10306c, this.f10307d, this.f10308e, this.f10309f, this.f10310g, this.f10311h, this.f10312i, this.f10313j, mediaPeriodId, this.f10315l, this.f10316m, this.f10317n, this.p, this.q, this.r, this.s, this.o);
    }

    @CheckResult
    public PlaybackInfo d(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, long j4, long j5, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List<Metadata> list) {
        long j6 = j2;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        TrackSelectorResult trackSelectorResult2 = trackSelectorResult;
        List<Metadata> list2 = list;
        Timeline timeline = this.f10304a;
        return new PlaybackInfo(timeline, mediaPeriodId, j3, j4, this.f10308e, this.f10309f, this.f10310g, trackGroupArray2, trackSelectorResult2, list2, this.f10314k, this.f10315l, this.f10316m, this.f10317n, this.p, j5, j6, SystemClock.elapsedRealtime(), this.o);
    }

    @CheckResult
    public PlaybackInfo e(boolean z, int i2) {
        Timeline timeline = this.f10304a;
        return new PlaybackInfo(timeline, this.f10305b, this.f10306c, this.f10307d, this.f10308e, this.f10309f, this.f10310g, this.f10311h, this.f10312i, this.f10313j, this.f10314k, z, i2, this.f10317n, this.p, this.q, this.r, this.s, this.o);
    }

    @CheckResult
    public PlaybackInfo f(@Nullable ExoPlaybackException exoPlaybackException) {
        Timeline timeline = this.f10304a;
        return new PlaybackInfo(timeline, this.f10305b, this.f10306c, this.f10307d, this.f10308e, exoPlaybackException, this.f10310g, this.f10311h, this.f10312i, this.f10313j, this.f10314k, this.f10315l, this.f10316m, this.f10317n, this.p, this.q, this.r, this.s, this.o);
    }

    @CheckResult
    public PlaybackInfo g(PlaybackParameters playbackParameters) {
        Timeline timeline = this.f10304a;
        return new PlaybackInfo(timeline, this.f10305b, this.f10306c, this.f10307d, this.f10308e, this.f10309f, this.f10310g, this.f10311h, this.f10312i, this.f10313j, this.f10314k, this.f10315l, this.f10316m, playbackParameters, this.p, this.q, this.r, this.s, this.o);
    }

    @CheckResult
    public PlaybackInfo h(int i2) {
        Timeline timeline = this.f10304a;
        return new PlaybackInfo(timeline, this.f10305b, this.f10306c, this.f10307d, i2, this.f10309f, this.f10310g, this.f10311h, this.f10312i, this.f10313j, this.f10314k, this.f10315l, this.f10316m, this.f10317n, this.p, this.q, this.r, this.s, this.o);
    }

    @CheckResult
    public PlaybackInfo i(boolean z) {
        Timeline timeline = this.f10304a;
        return new PlaybackInfo(timeline, this.f10305b, this.f10306c, this.f10307d, this.f10308e, this.f10309f, this.f10310g, this.f10311h, this.f10312i, this.f10313j, this.f10314k, this.f10315l, this.f10316m, this.f10317n, this.p, this.q, this.r, this.s, z);
    }

    @CheckResult
    public PlaybackInfo j(Timeline timeline) {
        return new PlaybackInfo(timeline, this.f10305b, this.f10306c, this.f10307d, this.f10308e, this.f10309f, this.f10310g, this.f10311h, this.f10312i, this.f10313j, this.f10314k, this.f10315l, this.f10316m, this.f10317n, this.p, this.q, this.r, this.s, this.o);
    }

    public long m() {
        long j2;
        long j3;
        if (!n()) {
            return this.r;
        }
        do {
            j2 = this.s;
            j3 = this.r;
        } while (j2 != this.s);
        return Util.I1(Util.H2(j3) + ((long) (((float) (SystemClock.elapsedRealtime() - j2)) * this.f10317n.s)));
    }

    public boolean n() {
        return this.f10308e == 3 && this.f10315l && this.f10316m == 0;
    }

    public void o(long j2) {
        this.r = j2;
        this.s = SystemClock.elapsedRealtime();
    }
}
