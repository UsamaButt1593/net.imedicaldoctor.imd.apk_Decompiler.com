package androidx.media3.exoplayer.analytics;

import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.PlaybackSessionManager;
import androidx.media3.exoplayer.analytics.PlaybackStats;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@UnstableApi
public final class PlaybackStatsListener implements AnalyticsListener, PlaybackSessionManager.Listener {
    @Nullable
    private Format A0;
    @Nullable
    private Format B0;
    private VideoSize C0 = VideoSize.b3;
    private final PlaybackSessionManager m0;
    private final Map<String, PlaybackStatsTracker> n0 = new HashMap();
    private final Map<String, AnalyticsListener.EventTime> o0 = new HashMap();
    @Nullable
    private final Callback p0;
    private final boolean q0;
    private final Timeline.Period r0 = new Timeline.Period();
    private PlaybackStats s0 = PlaybackStats.e0;
    @Nullable
    private String t0;
    private long u0;
    private int v0;
    private int w0;
    @Nullable
    private Exception x0;
    private long y0;
    private long z0;

    public interface Callback {
        void a(AnalyticsListener.EventTime eventTime, PlaybackStats playbackStats);
    }

    private static final class PlaybackStatsTracker {
        private long A;
        private long B;
        private long C;
        private long D;
        private long E;
        private int F;
        private int G;
        private int H;
        private long I;
        private boolean J;
        private boolean K;
        private boolean L;
        private boolean M;
        private boolean N;
        private long O;
        @Nullable
        private Format P;
        @Nullable
        private Format Q;
        private long R;
        private long S;
        private float T;

        /* renamed from: a  reason: collision with root package name */
        private final boolean f10599a;

        /* renamed from: b  reason: collision with root package name */
        private final long[] f10600b = new long[16];

        /* renamed from: c  reason: collision with root package name */
        private final List<PlaybackStats.EventTimeAndPlaybackState> f10601c;

        /* renamed from: d  reason: collision with root package name */
        private final List<long[]> f10602d;

        /* renamed from: e  reason: collision with root package name */
        private final List<PlaybackStats.EventTimeAndFormat> f10603e;

        /* renamed from: f  reason: collision with root package name */
        private final List<PlaybackStats.EventTimeAndFormat> f10604f;

        /* renamed from: g  reason: collision with root package name */
        private final List<PlaybackStats.EventTimeAndException> f10605g;

        /* renamed from: h  reason: collision with root package name */
        private final List<PlaybackStats.EventTimeAndException> f10606h;

        /* renamed from: i  reason: collision with root package name */
        private final boolean f10607i;

        /* renamed from: j  reason: collision with root package name */
        private long f10608j;

        /* renamed from: k  reason: collision with root package name */
        private boolean f10609k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f10610l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f10611m;

        /* renamed from: n  reason: collision with root package name */
        private int f10612n;
        private int o;
        private int p;
        private int q;
        private long r;
        private int s;
        private long t;
        private long u;
        private long v;
        private long w;
        private long x;
        private long y;
        private long z;

        public PlaybackStatsTracker(boolean z2, AnalyticsListener.EventTime eventTime) {
            this.f10599a = z2;
            this.f10601c = z2 ? new ArrayList<>() : Collections.emptyList();
            this.f10602d = z2 ? new ArrayList<>() : Collections.emptyList();
            this.f10603e = z2 ? new ArrayList<>() : Collections.emptyList();
            this.f10604f = z2 ? new ArrayList<>() : Collections.emptyList();
            this.f10605g = z2 ? new ArrayList<>() : Collections.emptyList();
            this.f10606h = z2 ? new ArrayList<>() : Collections.emptyList();
            boolean z3 = false;
            this.H = 0;
            this.I = eventTime.f10506a;
            this.f10608j = C.f9084b;
            this.r = C.f9084b;
            MediaSource.MediaPeriodId mediaPeriodId = eventTime.f10509d;
            if (mediaPeriodId != null && mediaPeriodId.c()) {
                z3 = true;
            }
            this.f10607i = z3;
            this.u = -1;
            this.t = -1;
            this.s = -1;
            this.T = 1.0f;
        }

        private long[] b(long j2) {
            List<long[]> list = this.f10602d;
            long[] jArr = list.get(list.size() - 1);
            return new long[]{j2, jArr[1] + ((long) (((float) (j2 - jArr[0])) * this.T))};
        }

        private static boolean c(int i2, int i3) {
            return ((i2 != 1 && i2 != 2 && i2 != 14) || i3 == 1 || i3 == 2 || i3 == 14 || i3 == 3 || i3 == 4 || i3 == 9 || i3 == 11) ? false : true;
        }

        private static boolean d(int i2) {
            return i2 == 4 || i2 == 7;
        }

        private static boolean e(int i2) {
            return i2 == 3 || i2 == 4 || i2 == 9;
        }

        private static boolean f(int i2) {
            return i2 == 6 || i2 == 7 || i2 == 10;
        }

        private void g(long j2) {
            Format format;
            int i2;
            if (!(this.H != 3 || (format = this.Q) == null || (i2 = format.b3) == -1)) {
                long j3 = (long) (((float) (j2 - this.S)) * this.T);
                this.z += j3;
                this.A += j3 * ((long) i2);
            }
            this.S = j2;
        }

        private void h(long j2) {
            Format format;
            if (this.H == 3 && (format = this.P) != null) {
                long j3 = (long) (((float) (j2 - this.R)) * this.T);
                int i2 = format.l3;
                if (i2 != -1) {
                    this.v += j3;
                    this.w += ((long) i2) * j3;
                }
                int i3 = format.b3;
                if (i3 != -1) {
                    this.x += j3;
                    this.y += j3 * ((long) i3);
                }
            }
            this.R = j2;
        }

        private void i(AnalyticsListener.EventTime eventTime, @Nullable Format format) {
            int i2;
            if (!Util.g(this.Q, format)) {
                g(eventTime.f10506a);
                if (!(format == null || this.u != -1 || (i2 = format.b3) == -1)) {
                    this.u = (long) i2;
                }
                this.Q = format;
                if (this.f10599a) {
                    this.f10604f.add(new PlaybackStats.EventTimeAndFormat(eventTime, format));
                }
            }
        }

        private void j(long j2) {
            if (f(this.H)) {
                long j3 = j2 - this.O;
                long j4 = this.r;
                if (j4 == C.f9084b || j3 > j4) {
                    this.r = j3;
                }
            }
        }

        private void k(long j2, long j3) {
            if (this.f10599a) {
                if (this.H != 3) {
                    if (j3 != C.f9084b) {
                        if (!this.f10602d.isEmpty()) {
                            List<long[]> list = this.f10602d;
                            long j4 = list.get(list.size() - 1)[1];
                            if (j4 != j3) {
                                this.f10602d.add(new long[]{j2, j4});
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (j3 != C.f9084b) {
                    this.f10602d.add(new long[]{j2, j3});
                } else if (!this.f10602d.isEmpty()) {
                    this.f10602d.add(b(j2));
                }
            }
        }

        private void l(AnalyticsListener.EventTime eventTime, @Nullable Format format) {
            int i2;
            int i3;
            if (!Util.g(this.P, format)) {
                h(eventTime.f10506a);
                if (format != null) {
                    if (this.s == -1 && (i3 = format.l3) != -1) {
                        this.s = i3;
                    }
                    if (this.t == -1 && (i2 = format.b3) != -1) {
                        this.t = (long) i2;
                    }
                }
                this.P = format;
                if (this.f10599a) {
                    this.f10603e.add(new PlaybackStats.EventTimeAndFormat(eventTime, format));
                }
            }
        }

        private int q(Player player) {
            int i2 = player.i();
            if (this.J && this.K) {
                return 5;
            }
            if (this.M) {
                return 13;
            }
            if (!this.K) {
                return this.N ? 1 : 0;
            }
            if (this.L) {
                return 14;
            }
            if (i2 == 4) {
                return 11;
            }
            if (i2 == 2) {
                int i3 = this.H;
                if (i3 == 0 || i3 == 1 || i3 == 2 || i3 == 14) {
                    return 2;
                }
                if (!player.m0()) {
                    return 7;
                }
                return player.g2() != 0 ? 10 : 6;
            } else if (i2 == 3) {
                if (!player.m0()) {
                    return 4;
                }
                return player.g2() != 0 ? 9 : 3;
            } else if (i2 != 1 || this.H == 0) {
                return this.H;
            } else {
                return 12;
            }
        }

        private void r(int i2, AnalyticsListener.EventTime eventTime) {
            boolean z2 = false;
            Assertions.a(eventTime.f10506a >= this.I);
            long j2 = eventTime.f10506a;
            long[] jArr = this.f10600b;
            int i3 = this.H;
            jArr[i3] = jArr[i3] + (j2 - this.I);
            if (this.f10608j == C.f9084b) {
                this.f10608j = j2;
            }
            this.f10611m |= c(i3, i2);
            this.f10609k |= e(i2);
            boolean z3 = this.f10610l;
            if (i2 == 11) {
                z2 = true;
            }
            this.f10610l = z3 | z2;
            if (!d(this.H) && d(i2)) {
                this.f10612n++;
            }
            if (i2 == 5) {
                this.p++;
            }
            if (!f(this.H) && f(i2)) {
                this.q++;
                this.O = eventTime.f10506a;
            }
            if (f(this.H) && this.H != 7 && i2 == 7) {
                this.o++;
            }
            j(eventTime.f10506a);
            this.H = i2;
            this.I = eventTime.f10506a;
            if (this.f10599a) {
                this.f10601c.add(new PlaybackStats.EventTimeAndPlaybackState(eventTime, i2));
            }
        }

        public PlaybackStats a(boolean z2) {
            ArrayList arrayList;
            long[] jArr;
            long[] jArr2 = this.f10600b;
            List<long[]> list = this.f10602d;
            if (!z2) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long[] copyOf = Arrays.copyOf(this.f10600b, 16);
                long max = Math.max(0, elapsedRealtime - this.I);
                int i2 = this.H;
                copyOf[i2] = copyOf[i2] + max;
                j(elapsedRealtime);
                h(elapsedRealtime);
                g(elapsedRealtime);
                ArrayList arrayList2 = new ArrayList(this.f10602d);
                if (this.f10599a && this.H == 3) {
                    arrayList2.add(b(elapsedRealtime));
                }
                jArr = copyOf;
                arrayList = arrayList2;
            } else {
                jArr = jArr2;
                arrayList = list;
            }
            int i3 = (this.f10611m || !this.f10609k) ? 1 : 0;
            long j2 = i3 != 0 ? C.f9084b : jArr[2];
            int i4 = jArr[1] > 0 ? 1 : 0;
            List arrayList3 = z2 ? this.f10603e : new ArrayList(this.f10603e);
            List arrayList4 = z2 ? this.f10604f : new ArrayList(this.f10604f);
            List arrayList5 = z2 ? this.f10601c : new ArrayList(this.f10601c);
            long j3 = this.f10608j;
            boolean z3 = this.K;
            boolean z4 = !this.f10609k;
            boolean z5 = this.f10610l;
            int i5 = i3 ^ 1;
            int i6 = this.f10612n;
            int i7 = this.o;
            int i8 = this.p;
            int i9 = this.q;
            int i10 = i7;
            long j4 = this.r;
            boolean z6 = this.f10607i;
            int i11 = i9;
            long[] jArr3 = jArr;
            long j5 = this.v;
            long j6 = this.w;
            long j7 = this.x;
            long j8 = this.y;
            long j9 = this.z;
            long j10 = this.A;
            int i12 = this.s;
            int i13 = i12;
            int i14 = i12 == -1 ? 0 : 1;
            long j11 = this.t;
            long j12 = j11;
            int i15 = j11 == -1 ? 0 : 1;
            long j13 = this.u;
            long j14 = j13;
            int i16 = j13 == -1 ? 0 : 1;
            long j15 = this.B;
            long j16 = this.C;
            long j17 = this.D;
            long j18 = this.E;
            int i17 = this.F;
            long j19 = j18;
            return new PlaybackStats(1, jArr3, arrayList5, arrayList, j3, z3 ? 1 : 0, z4 ? 1 : 0, z5 ? 1 : 0, i4, j2, i5, i6, i10, i8, i11, j4, z6 ? 1 : 0, arrayList3, arrayList4, j5, j6, j7, j8, j9, j10, i14, i15, i13, j12, i16, j14, j15, j16, j17, j19, i17 > 0 ? 1 : 0, i17, this.G, this.f10605g, this.f10606h);
        }

        public void m(Player player, AnalyticsListener.EventTime eventTime, boolean z2, long j2, boolean z3, int i2, boolean z4, boolean z5, @Nullable PlaybackException playbackException, @Nullable Exception exc, long j3, long j4, @Nullable Format format, @Nullable Format format2, @Nullable VideoSize videoSize) {
            AnalyticsListener.EventTime eventTime2 = eventTime;
            long j5 = j2;
            PlaybackException playbackException2 = playbackException;
            Exception exc2 = exc;
            Format format3 = format;
            Format format4 = format2;
            VideoSize videoSize2 = videoSize;
            long j6 = C.f9084b;
            if (j5 != C.f9084b) {
                k(eventTime2.f10506a, j5);
                this.J = true;
            }
            if (player.i() != 2) {
                this.J = false;
            }
            int i3 = player.i();
            if (i3 == 1 || i3 == 4 || z3) {
                this.L = false;
            }
            if (playbackException2 != null) {
                this.M = true;
                this.F++;
                if (this.f10599a) {
                    this.f10605g.add(new PlaybackStats.EventTimeAndException(eventTime2, playbackException2));
                }
            } else if (player.j() == null) {
                this.M = false;
            }
            if (this.K && !this.L) {
                Tracks D1 = player.D1();
                if (!D1.f(2)) {
                    l(eventTime2, (Format) null);
                }
                if (!D1.f(1)) {
                    i(eventTime2, (Format) null);
                }
            }
            if (format3 != null) {
                l(eventTime2, format3);
            }
            if (format4 != null) {
                i(eventTime2, format4);
            }
            Format format5 = this.P;
            if (!(format5 == null || format5.l3 != -1 || videoSize2 == null)) {
                l(eventTime2, format5.c().r0(videoSize2.s).V(videoSize2.X).I());
            }
            if (z5) {
                this.N = true;
            }
            if (z4) {
                this.E++;
            }
            this.D += (long) i2;
            this.B += j3;
            this.C += j4;
            if (exc2 != null) {
                this.G++;
                if (this.f10599a) {
                    this.f10606h.add(new PlaybackStats.EventTimeAndException(eventTime2, exc2));
                }
            }
            int q2 = q(player);
            float f2 = player.r().s;
            if (!(this.H == q2 && this.T == f2)) {
                long j7 = eventTime2.f10506a;
                if (z2) {
                    j6 = eventTime2.f10510e;
                }
                k(j7, j6);
                h(eventTime2.f10506a);
                g(eventTime2.f10506a);
            }
            this.T = f2;
            if (this.H != q2) {
                r(q2, eventTime2);
            }
        }

        public void n(AnalyticsListener.EventTime eventTime, boolean z2, long j2) {
            int i2 = 11;
            if (this.H != 11 && !z2) {
                i2 = 15;
            }
            k(eventTime.f10506a, j2);
            h(eventTime.f10506a);
            g(eventTime.f10506a);
            r(i2, eventTime);
        }

        public void o() {
            this.K = true;
        }

        public void p() {
            this.L = true;
            this.J = false;
        }
    }

    public PlaybackStatsListener(boolean z, @Nullable Callback callback) {
        this.p0 = callback;
        this.q0 = z;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.m0 = defaultPlaybackSessionManager;
        defaultPlaybackSessionManager.d(this);
    }

    private Pair<AnalyticsListener.EventTime, Boolean> D0(AnalyticsListener.Events events, String str) {
        MediaSource.MediaPeriodId mediaPeriodId;
        AnalyticsListener.Events events2 = events;
        String str2 = str;
        AnalyticsListener.EventTime eventTime = null;
        boolean z = false;
        for (int i2 = 0; i2 < events.e(); i2++) {
            AnalyticsListener.EventTime d2 = events2.d(events2.c(i2));
            boolean f2 = this.m0.f(d2, str2);
            if (eventTime == null || ((f2 && !z) || (f2 == z && d2.f10506a > eventTime.f10506a))) {
                eventTime = d2;
                z = f2;
            }
        }
        Assertions.g(eventTime);
        if (!z && (mediaPeriodId = eventTime.f10509d) != null && mediaPeriodId.c()) {
            long i3 = eventTime.f10507b.m(eventTime.f10509d.f12163a, this.r0).i(eventTime.f10509d.f12164b);
            if (i3 == Long.MIN_VALUE) {
                i3 = this.r0.Z;
            }
            long s = i3 + this.r0.s();
            long j2 = eventTime.f10506a;
            Timeline timeline = eventTime.f10507b;
            int i4 = eventTime.f10508c;
            MediaSource.MediaPeriodId mediaPeriodId2 = eventTime.f10509d;
            MediaSource.MediaPeriodId mediaPeriodId3 = new MediaSource.MediaPeriodId(mediaPeriodId2.f12163a, mediaPeriodId2.f12166d, mediaPeriodId2.f12164b);
            long H2 = Util.H2(s);
            Timeline timeline2 = eventTime.f10507b;
            int i5 = eventTime.f10512g;
            MediaSource.MediaPeriodId mediaPeriodId4 = eventTime.f10513h;
            MediaSource.MediaPeriodId mediaPeriodId5 = mediaPeriodId4;
            AnalyticsListener.EventTime eventTime2 = new AnalyticsListener.EventTime(j2, timeline, i4, mediaPeriodId3, H2, timeline2, i5, mediaPeriodId5, eventTime.f10514i, eventTime.f10515j);
            z = this.m0.f(eventTime2, str);
            eventTime = eventTime2;
        }
        return Pair.create(eventTime, Boolean.valueOf(z));
    }

    private boolean G0(AnalyticsListener.Events events, String str, int i2) {
        return events.a(i2) && this.m0.f(events.d(i2), str);
    }

    private void H0(AnalyticsListener.Events events) {
        for (int i2 = 0; i2 < events.e(); i2++) {
            int c2 = events.c(i2);
            AnalyticsListener.EventTime d2 = events.d(c2);
            if (c2 == 0) {
                this.m0.h(d2);
            } else if (c2 == 11) {
                this.m0.g(d2, this.v0);
            } else {
                this.m0.b(d2);
            }
        }
    }

    public /* synthetic */ void A(AnalyticsListener.EventTime eventTime, Format format) {
        C0205a.h(this, eventTime, format);
    }

    public /* synthetic */ void A0(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        C0205a.o(this, eventTime, i2, j2, j3);
    }

    public /* synthetic */ void B(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        C0205a.r0(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void B0(AnalyticsListener.EventTime eventTime, int i2) {
        C0205a.k(this, eventTime, i2);
    }

    public /* synthetic */ void C(AnalyticsListener.EventTime eventTime, boolean z, int i2) {
        C0205a.X(this, eventTime, z, i2);
    }

    public /* synthetic */ void C0(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        C0205a.i(this, eventTime, format, decoderReuseEvaluation);
    }

    public /* synthetic */ void D(AnalyticsListener.EventTime eventTime) {
        C0205a.C(this, eventTime);
    }

    public void E(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        this.y0 = (long) i2;
        this.z0 = j2;
    }

    public PlaybackStats E0() {
        int i2 = 1;
        PlaybackStats[] playbackStatsArr = new PlaybackStats[(this.n0.size() + 1)];
        playbackStatsArr[0] = this.s0;
        for (PlaybackStatsTracker a2 : this.n0.values()) {
            playbackStatsArr[i2] = a2.a(false);
            i2++;
        }
        return PlaybackStats.W(playbackStatsArr);
    }

    public /* synthetic */ void F(AnalyticsListener.EventTime eventTime, Exception exc) {
        C0205a.b(this, eventTime, exc);
    }

    @Nullable
    public PlaybackStats F0() {
        String c2 = this.m0.c();
        PlaybackStatsTracker playbackStatsTracker = c2 == null ? null : this.n0.get(c2);
        if (playbackStatsTracker == null) {
            return null;
        }
        return playbackStatsTracker.a(false);
    }

    public /* synthetic */ void G(AnalyticsListener.EventTime eventTime, Format format) {
        C0205a.u0(this, eventTime, format);
    }

    public /* synthetic */ void H(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        C0205a.V(this, eventTime, playbackException);
    }

    public /* synthetic */ void I(AnalyticsListener.EventTime eventTime, String str, long j2) {
        C0205a.o0(this, eventTime, str, j2);
    }

    public /* synthetic */ void J(AnalyticsListener.EventTime eventTime) {
        C0205a.f0(this, eventTime);
    }

    public /* synthetic */ void K(AnalyticsListener.EventTime eventTime) {
        C0205a.y(this, eventTime);
    }

    public /* synthetic */ void L(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        C0205a.I(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void M(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        C0205a.l0(this, eventTime, tracks);
    }

    public void N(AnalyticsListener.EventTime eventTime, String str, boolean z) {
        PlaybackStatsTracker playbackStatsTracker = (PlaybackStatsTracker) Assertions.g(this.n0.remove(str));
        AnalyticsListener.EventTime eventTime2 = (AnalyticsListener.EventTime) Assertions.g(this.o0.remove(str));
        playbackStatsTracker.n(eventTime, z, str.equals(this.t0) ? this.u0 : C.f9084b);
        PlaybackStats a2 = playbackStatsTracker.a(true);
        this.s0 = PlaybackStats.W(this.s0, a2);
        Callback callback = this.p0;
        if (callback != null) {
            callback.a(eventTime2, a2);
        }
    }

    public /* synthetic */ void O(AnalyticsListener.EventTime eventTime, long j2) {
        C0205a.M(this, eventTime, j2);
    }

    public /* synthetic */ void P(AnalyticsListener.EventTime eventTime, int i2) {
        C0205a.c0(this, eventTime, i2);
    }

    public /* synthetic */ void Q(AnalyticsListener.EventTime eventTime, CueGroup cueGroup) {
        C0205a.r(this, eventTime, cueGroup);
    }

    public /* synthetic */ void R(AnalyticsListener.EventTime eventTime, String str, long j2, long j3) {
        C0205a.d(this, eventTime, str, j2, j3);
    }

    public /* synthetic */ void S(AnalyticsListener.EventTime eventTime, String str, long j2, long j3) {
        C0205a.p0(this, eventTime, str, j2, j3);
    }

    public /* synthetic */ void T(AnalyticsListener.EventTime eventTime, TrackSelectionParameters trackSelectionParameters) {
        C0205a.k0(this, eventTime, trackSelectionParameters);
    }

    public /* synthetic */ void U(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        C0205a.O(this, eventTime, mediaMetadata);
    }

    public /* synthetic */ void V(AnalyticsListener.EventTime eventTime, AudioAttributes audioAttributes) {
        C0205a.a(this, eventTime, audioAttributes);
    }

    public void W(AnalyticsListener.EventTime eventTime, VideoSize videoSize) {
        this.C0 = videoSize;
    }

    public /* synthetic */ void X(AnalyticsListener.EventTime eventTime, long j2) {
        C0205a.e0(this, eventTime, j2);
    }

    public /* synthetic */ void Y(AnalyticsListener.EventTime eventTime, int i2) {
        C0205a.j0(this, eventTime, i2);
    }

    public /* synthetic */ void Z(AnalyticsListener.EventTime eventTime, long j2, int i2) {
        C0205a.t0(this, eventTime, j2, i2);
    }

    public /* synthetic */ void a(AnalyticsListener.EventTime eventTime, String str, long j2) {
        C0205a.c(this, eventTime, str, j2);
    }

    public void a0(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.x0 = exc;
    }

    public /* synthetic */ void b(AnalyticsListener.EventTime eventTime, Object obj, long j2) {
        C0205a.b0(this, eventTime, obj, j2);
    }

    public /* synthetic */ void b0(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        C0205a.f(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void c(AnalyticsListener.EventTime eventTime, boolean z) {
        C0205a.F(this, eventTime, z);
    }

    public /* synthetic */ void c0(AnalyticsListener.EventTime eventTime, MediaItem mediaItem, int i2) {
        C0205a.N(this, eventTime, mediaItem, i2);
    }

    public /* synthetic */ void d(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        C0205a.m(this, eventTime, audioTrackConfig);
    }

    public /* synthetic */ void d0(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        C0205a.g(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void e(AnalyticsListener.EventTime eventTime, PlaybackParameters playbackParameters) {
        C0205a.R(this, eventTime, playbackParameters);
    }

    public void e0(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        int i2 = mediaLoadData.f12150b;
        if (i2 == 2 || i2 == 0) {
            this.A0 = mediaLoadData.f12151c;
        } else if (i2 == 1) {
            this.B0 = mediaLoadData.f12151c;
        }
    }

    public /* synthetic */ void f(AnalyticsListener.EventTime eventTime, String str) {
        C0205a.e(this, eventTime, str);
    }

    public void f0(Player player, AnalyticsListener.Events events) {
        AnalyticsListener.Events events2 = events;
        if (events.e() != 0) {
            H0(events2);
            for (String next : this.n0.keySet()) {
                Pair<AnalyticsListener.EventTime, Boolean> D0 = D0(events2, next);
                PlaybackStatsTracker playbackStatsTracker = this.n0.get(next);
                boolean G0 = G0(events2, next, 11);
                boolean G02 = G0(events2, next, 1018);
                boolean G03 = G0(events2, next, 1011);
                boolean G04 = G0(events2, next, 1000);
                boolean G05 = G0(events2, next, 10);
                boolean z = G0(events2, next, 1003) || G0(events2, next, 1024);
                boolean G06 = G0(events2, next, 1006);
                boolean G07 = G0(events2, next, 1004);
                playbackStatsTracker.m(player, (AnalyticsListener.EventTime) D0.first, ((Boolean) D0.second).booleanValue(), next.equals(this.t0) ? this.u0 : C.f9084b, G0, G02 ? this.w0 : 0, G03, G04, G05 ? player.j() : null, z ? this.x0 : null, G06 ? this.y0 : 0, G06 ? this.z0 : 0, G07 ? this.A0 : null, G07 ? this.B0 : null, G0(events2, next, 25) ? this.C0 : null);
            }
            this.A0 = null;
            this.B0 = null;
            this.t0 = null;
            if (events2.a(AnalyticsListener.h0)) {
                this.m0.a(events2.d(AnalyticsListener.h0));
            }
        }
    }

    public /* synthetic */ void g(AnalyticsListener.EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig) {
        C0205a.n(this, eventTime, audioTrackConfig);
    }

    public /* synthetic */ void g0(AnalyticsListener.EventTime eventTime, DeviceInfo deviceInfo) {
        C0205a.t(this, eventTime, deviceInfo);
    }

    public /* synthetic */ void h(AnalyticsListener.EventTime eventTime, String str) {
        C0205a.q0(this, eventTime, str);
    }

    public /* synthetic */ void h0(AnalyticsListener.EventTime eventTime) {
        C0205a.W(this, eventTime);
    }

    public void i(AnalyticsListener.EventTime eventTime, String str, String str2) {
        ((PlaybackStatsTracker) Assertions.g(this.n0.get(str))).p();
    }

    public /* synthetic */ void i0(AnalyticsListener.EventTime eventTime, MediaMetadata mediaMetadata) {
        C0205a.Y(this, eventTime, mediaMetadata);
    }

    public /* synthetic */ void j(AnalyticsListener.EventTime eventTime, int i2, boolean z) {
        C0205a.u(this, eventTime, i2, z);
    }

    public /* synthetic */ void j0(AnalyticsListener.EventTime eventTime, int i2, int i3) {
        C0205a.i0(this, eventTime, i2, i3);
    }

    public /* synthetic */ void k(AnalyticsListener.EventTime eventTime, int i2) {
        C0205a.T(this, eventTime, i2);
    }

    public void k0(AnalyticsListener.EventTime eventTime, String str) {
        this.n0.put(str, new PlaybackStatsTracker(this.q0, eventTime));
        this.o0.put(str, eventTime);
    }

    public /* synthetic */ void l(AnalyticsListener.EventTime eventTime, boolean z) {
        C0205a.G(this, eventTime, z);
    }

    public void l0(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
        if (this.t0 == null) {
            this.t0 = this.m0.c();
            this.u0 = positionInfo.Z2;
        }
        this.v0 = i2;
    }

    public /* synthetic */ void m(AnalyticsListener.EventTime eventTime, Metadata metadata) {
        C0205a.P(this, eventTime, metadata);
    }

    public /* synthetic */ void m0(AnalyticsListener.EventTime eventTime, int i2) {
        C0205a.A(this, eventTime, i2);
    }

    public /* synthetic */ void n(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        C0205a.m0(this, eventTime, mediaLoadData);
    }

    public /* synthetic */ void n0(AnalyticsListener.EventTime eventTime) {
        C0205a.w(this, eventTime);
    }

    public /* synthetic */ void o(AnalyticsListener.EventTime eventTime, List list) {
        C0205a.s(this, eventTime, list);
    }

    public /* synthetic */ void o0(AnalyticsListener.EventTime eventTime, Player.Commands commands) {
        C0205a.p(this, eventTime, commands);
    }

    public /* synthetic */ void p(AnalyticsListener.EventTime eventTime) {
        C0205a.x(this, eventTime);
    }

    public /* synthetic */ void p0(AnalyticsListener.EventTime eventTime, Exception exc) {
        C0205a.n0(this, eventTime, exc);
    }

    public /* synthetic */ void q(AnalyticsListener.EventTime eventTime, boolean z) {
        C0205a.h0(this, eventTime, z);
    }

    public /* synthetic */ void q0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        C0205a.H(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public /* synthetic */ void r(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        C0205a.U(this, eventTime, playbackException);
    }

    public /* synthetic */ void r0(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        C0205a.s0(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void s(AnalyticsListener.EventTime eventTime, int i2, int i3, int i4, float f2) {
        C0205a.w0(this, eventTime, i2, i3, i4, f2);
    }

    public void s0(AnalyticsListener.EventTime eventTime, String str) {
        ((PlaybackStatsTracker) Assertions.g(this.n0.get(str))).o();
    }

    public /* synthetic */ void t(AnalyticsListener.EventTime eventTime, boolean z) {
        C0205a.L(this, eventTime, z);
    }

    public /* synthetic */ void t0(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        C0205a.v0(this, eventTime, format, decoderReuseEvaluation);
    }

    public void u(AnalyticsListener.EventTime eventTime, int i2, long j2) {
        this.w0 = i2;
    }

    public /* synthetic */ void u0(AnalyticsListener.EventTime eventTime, Exception exc) {
        C0205a.l(this, eventTime, exc);
    }

    public /* synthetic */ void v(AnalyticsListener.EventTime eventTime, long j2) {
        C0205a.d0(this, eventTime, j2);
    }

    public /* synthetic */ void v0(AnalyticsListener.EventTime eventTime, float f2) {
        C0205a.y0(this, eventTime, f2);
    }

    public /* synthetic */ void w(AnalyticsListener.EventTime eventTime, int i2) {
        C0205a.Z(this, eventTime, i2);
    }

    public /* synthetic */ void w0(AnalyticsListener.EventTime eventTime, boolean z) {
        C0205a.g0(this, eventTime, z);
    }

    public /* synthetic */ void x(AnalyticsListener.EventTime eventTime) {
        C0205a.z(this, eventTime);
    }

    public /* synthetic */ void x0(AnalyticsListener.EventTime eventTime, int i2) {
        C0205a.S(this, eventTime, i2);
    }

    public /* synthetic */ void y(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        C0205a.K(this, eventTime, loadEventInfo, mediaLoadData);
    }

    public void y0(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        this.x0 = iOException;
    }

    public /* synthetic */ void z(AnalyticsListener.EventTime eventTime, boolean z, int i2) {
        C0205a.Q(this, eventTime, z, i2);
    }

    public /* synthetic */ void z0(AnalyticsListener.EventTime eventTime, long j2) {
        C0205a.j(this, eventTime, j2);
    }
}
