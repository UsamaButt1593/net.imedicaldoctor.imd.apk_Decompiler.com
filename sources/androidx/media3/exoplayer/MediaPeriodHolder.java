package androidx.media3.exoplayer;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.exoplayer.LoadingInfo;
import androidx.media3.exoplayer.source.ClippingMediaPeriod;
import androidx.media3.exoplayer.source.EmptySampleStream;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.Allocator;

final class MediaPeriodHolder {
    private static final String p = "MediaPeriodHolder";

    /* renamed from: a  reason: collision with root package name */
    public final MediaPeriod f10235a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f10236b;

    /* renamed from: c  reason: collision with root package name */
    public final SampleStream[] f10237c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10238d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10239e;

    /* renamed from: f  reason: collision with root package name */
    public MediaPeriodInfo f10240f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f10241g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean[] f10242h;

    /* renamed from: i  reason: collision with root package name */
    private final RendererCapabilities[] f10243i;

    /* renamed from: j  reason: collision with root package name */
    private final TrackSelector f10244j;

    /* renamed from: k  reason: collision with root package name */
    private final MediaSourceList f10245k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private MediaPeriodHolder f10246l;

    /* renamed from: m  reason: collision with root package name */
    private TrackGroupArray f10247m = TrackGroupArray.X2;

    /* renamed from: n  reason: collision with root package name */
    private TrackSelectorResult f10248n;
    private long o;

    interface Factory {
        MediaPeriodHolder a(MediaPeriodInfo mediaPeriodInfo, long j2);
    }

    public MediaPeriodHolder(RendererCapabilities[] rendererCapabilitiesArr, long j2, TrackSelector trackSelector, Allocator allocator, MediaSourceList mediaSourceList, MediaPeriodInfo mediaPeriodInfo, TrackSelectorResult trackSelectorResult) {
        this.f10243i = rendererCapabilitiesArr;
        this.o = j2;
        this.f10244j = trackSelector;
        this.f10245k = mediaSourceList;
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f10249a;
        this.f10236b = mediaPeriodId.f12163a;
        this.f10240f = mediaPeriodInfo;
        this.f10248n = trackSelectorResult;
        this.f10237c = new SampleStream[rendererCapabilitiesArr.length];
        this.f10242h = new boolean[rendererCapabilitiesArr.length];
        this.f10235a = e(mediaPeriodId, mediaSourceList, allocator, mediaPeriodInfo.f10250b, mediaPeriodInfo.f10252d);
    }

    private void c(SampleStream[] sampleStreamArr) {
        int i2 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.f10243i;
            if (i2 < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i2].i() == -2 && this.f10248n.c(i2)) {
                    sampleStreamArr[i2] = new EmptySampleStream();
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private static MediaPeriod e(MediaSource.MediaPeriodId mediaPeriodId, MediaSourceList mediaSourceList, Allocator allocator, long j2, long j3) {
        MediaPeriod i2 = mediaSourceList.i(mediaPeriodId, allocator, j2);
        return j3 != C.f9084b ? new ClippingMediaPeriod(i2, true, 0, j3) : i2;
    }

    private void f() {
        if (r()) {
            int i2 = 0;
            while (true) {
                TrackSelectorResult trackSelectorResult = this.f10248n;
                if (i2 < trackSelectorResult.f12416a) {
                    boolean c2 = trackSelectorResult.c(i2);
                    ExoTrackSelection exoTrackSelection = this.f10248n.f12418c[i2];
                    if (c2 && exoTrackSelection != null) {
                        exoTrackSelection.h();
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    private void g(SampleStream[] sampleStreamArr) {
        int i2 = 0;
        while (true) {
            RendererCapabilities[] rendererCapabilitiesArr = this.f10243i;
            if (i2 < rendererCapabilitiesArr.length) {
                if (rendererCapabilitiesArr[i2].i() == -2) {
                    sampleStreamArr[i2] = null;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private void h() {
        if (r()) {
            int i2 = 0;
            while (true) {
                TrackSelectorResult trackSelectorResult = this.f10248n;
                if (i2 < trackSelectorResult.f12416a) {
                    boolean c2 = trackSelectorResult.c(i2);
                    ExoTrackSelection exoTrackSelection = this.f10248n.f12418c[i2];
                    if (c2 && exoTrackSelection != null) {
                        exoTrackSelection.j();
                    }
                    i2++;
                } else {
                    return;
                }
            }
        }
    }

    private boolean r() {
        return this.f10246l == null;
    }

    private static void u(MediaSourceList mediaSourceList, MediaPeriod mediaPeriod) {
        try {
            if (mediaPeriod instanceof ClippingMediaPeriod) {
                mediaPeriod = ((ClippingMediaPeriod) mediaPeriod).s;
            }
            mediaSourceList.C(mediaPeriod);
        } catch (RuntimeException e2) {
            Log.e(p, "Period release failed.", e2);
        }
    }

    public void A() {
        MediaPeriod mediaPeriod = this.f10235a;
        if (mediaPeriod instanceof ClippingMediaPeriod) {
            long j2 = this.f10240f.f10252d;
            if (j2 == C.f9084b) {
                j2 = Long.MIN_VALUE;
            }
            ((ClippingMediaPeriod) mediaPeriod).x(0, j2);
        }
    }

    public long a(TrackSelectorResult trackSelectorResult, long j2, boolean z) {
        return b(trackSelectorResult, j2, z, new boolean[this.f10243i.length]);
    }

    public long b(TrackSelectorResult trackSelectorResult, long j2, boolean z, boolean[] zArr) {
        TrackSelectorResult trackSelectorResult2 = trackSelectorResult;
        int i2 = 0;
        while (true) {
            boolean z2 = true;
            if (i2 >= trackSelectorResult2.f12416a) {
                break;
            }
            boolean[] zArr2 = this.f10242h;
            if (z || !trackSelectorResult.b(this.f10248n, i2)) {
                z2 = false;
            }
            zArr2[i2] = z2;
            i2++;
        }
        g(this.f10237c);
        f();
        this.f10248n = trackSelectorResult2;
        h();
        long n2 = this.f10235a.n(trackSelectorResult2.f12418c, this.f10242h, this.f10237c, zArr, j2);
        c(this.f10237c);
        this.f10239e = false;
        int i3 = 0;
        while (true) {
            SampleStream[] sampleStreamArr = this.f10237c;
            if (i3 >= sampleStreamArr.length) {
                return n2;
            }
            if (sampleStreamArr[i3] != null) {
                Assertions.i(trackSelectorResult.c(i3));
                if (this.f10243i[i3].i() != -2) {
                    this.f10239e = true;
                }
            } else {
                Assertions.i(trackSelectorResult2.f12418c[i3] == null);
            }
            i3++;
        }
    }

    public void d(long j2, float f2, long j3) {
        Assertions.i(r());
        this.f10235a.a(new LoadingInfo.Builder().f(y(j2)).g(f2).e(j3).d());
    }

    public long i() {
        if (!this.f10238d) {
            return this.f10240f.f10250b;
        }
        long g2 = this.f10239e ? this.f10235a.g() : Long.MIN_VALUE;
        return g2 == Long.MIN_VALUE ? this.f10240f.f10253e : g2;
    }

    @Nullable
    public MediaPeriodHolder j() {
        return this.f10246l;
    }

    public long k() {
        if (!this.f10238d) {
            return 0;
        }
        return this.f10235a.e();
    }

    public long l() {
        return this.o;
    }

    public long m() {
        return this.f10240f.f10250b + this.o;
    }

    public TrackGroupArray n() {
        return this.f10247m;
    }

    public TrackSelectorResult o() {
        return this.f10248n;
    }

    public void p(float f2, Timeline timeline) throws ExoPlaybackException {
        this.f10238d = true;
        this.f10247m = this.f10235a.s();
        TrackSelectorResult v = v(f2, timeline);
        MediaPeriodInfo mediaPeriodInfo = this.f10240f;
        long j2 = mediaPeriodInfo.f10250b;
        long j3 = mediaPeriodInfo.f10253e;
        if (j3 != C.f9084b && j2 >= j3) {
            j2 = Math.max(0, j3 - 1);
        }
        long a2 = a(v, j2, false);
        long j4 = this.o;
        MediaPeriodInfo mediaPeriodInfo2 = this.f10240f;
        this.o = j4 + (mediaPeriodInfo2.f10250b - a2);
        this.f10240f = mediaPeriodInfo2.b(a2);
    }

    public boolean q() {
        return this.f10238d && (!this.f10239e || this.f10235a.g() == Long.MIN_VALUE);
    }

    public void s(long j2) {
        Assertions.i(r());
        if (this.f10238d) {
            this.f10235a.h(y(j2));
        }
    }

    public void t() {
        f();
        u(this.f10245k, this.f10235a);
    }

    public TrackSelectorResult v(float f2, Timeline timeline) throws ExoPlaybackException {
        TrackSelectorResult k2 = this.f10244j.k(this.f10243i, n(), this.f10240f.f10249a, timeline);
        for (ExoTrackSelection exoTrackSelection : k2.f12418c) {
            if (exoTrackSelection != null) {
                exoTrackSelection.r(f2);
            }
        }
        return k2;
    }

    public void w(@Nullable MediaPeriodHolder mediaPeriodHolder) {
        if (mediaPeriodHolder != this.f10246l) {
            f();
            this.f10246l = mediaPeriodHolder;
            h();
        }
    }

    public void x(long j2) {
        this.o = j2;
    }

    public long y(long j2) {
        return j2 - l();
    }

    public long z(long j2) {
        return j2 + l();
    }
}
