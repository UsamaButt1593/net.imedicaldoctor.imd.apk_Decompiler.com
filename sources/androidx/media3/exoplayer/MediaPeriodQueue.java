package androidx.media3.exoplayer;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.exoplayer.MediaPeriodHolder;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.collect.ImmutableList;

final class MediaPeriodQueue {
    public static final long o = 1000000000000L;
    private static final int p = 100;

    /* renamed from: a  reason: collision with root package name */
    private final Timeline.Period f10258a = new Timeline.Period();

    /* renamed from: b  reason: collision with root package name */
    private final Timeline.Window f10259b = new Timeline.Window();

    /* renamed from: c  reason: collision with root package name */
    private final AnalyticsCollector f10260c;

    /* renamed from: d  reason: collision with root package name */
    private final HandlerWrapper f10261d;

    /* renamed from: e  reason: collision with root package name */
    private final MediaPeriodHolder.Factory f10262e;

    /* renamed from: f  reason: collision with root package name */
    private long f10263f;

    /* renamed from: g  reason: collision with root package name */
    private int f10264g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10265h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private MediaPeriodHolder f10266i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private MediaPeriodHolder f10267j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private MediaPeriodHolder f10268k;

    /* renamed from: l  reason: collision with root package name */
    private int f10269l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private Object f10270m;

    /* renamed from: n  reason: collision with root package name */
    private long f10271n;

    public MediaPeriodQueue(AnalyticsCollector analyticsCollector, HandlerWrapper handlerWrapper, MediaPeriodHolder.Factory factory) {
        this.f10260c = analyticsCollector;
        this.f10261d = handlerWrapper;
        this.f10262e = factory;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A(ImmutableList.Builder builder, MediaSource.MediaPeriodId mediaPeriodId) {
        this.f10260c.G(builder.e(), mediaPeriodId);
    }

    private void B() {
        ImmutableList.Builder r = ImmutableList.r();
        for (MediaPeriodHolder mediaPeriodHolder = this.f10266i; mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.j()) {
            r.g(mediaPeriodHolder.f10240f.f10249a);
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.f10267j;
        this.f10261d.e(new G0(this, r, mediaPeriodHolder2 == null ? null : mediaPeriodHolder2.f10240f.f10249a));
    }

    private static MediaSource.MediaPeriodId F(Timeline timeline, Object obj, long j2, long j3, Timeline.Window window, Timeline.Period period) {
        timeline.m(obj, period);
        timeline.u(period.Y, window);
        int g2 = timeline.g(obj);
        Object obj2 = obj;
        while (z(period) && g2 <= window.i3) {
            timeline.l(g2, period, true);
            obj2 = Assertions.g(period.X);
            g2++;
        }
        timeline.m(obj2, period);
        int h2 = period.h(j2);
        return h2 == -1 ? new MediaSource.MediaPeriodId(obj2, j3, period.g(j2)) : new MediaSource.MediaPeriodId(obj2, h2, period.p(h2), j3);
    }

    private long H(Timeline timeline, Object obj) {
        MediaPeriodHolder mediaPeriodHolder;
        int g2;
        int i2 = timeline.m(obj, this.f10258a).Y;
        Object obj2 = this.f10270m;
        if (obj2 != null && (g2 = timeline.g(obj2)) != -1 && timeline.k(g2, this.f10258a).Y == i2) {
            return this.f10271n;
        }
        MediaPeriodHolder mediaPeriodHolder2 = this.f10266i;
        while (true) {
            if (mediaPeriodHolder == null) {
                mediaPeriodHolder = this.f10266i;
                while (mediaPeriodHolder != null) {
                    int g3 = timeline.g(mediaPeriodHolder.f10236b);
                    if (g3 == -1 || timeline.k(g3, this.f10258a).Y != i2) {
                        mediaPeriodHolder = mediaPeriodHolder.j();
                    }
                }
                long j2 = this.f10263f;
                this.f10263f = 1 + j2;
                if (this.f10266i == null) {
                    this.f10270m = obj;
                    this.f10271n = j2;
                }
                return j2;
            } else if (mediaPeriodHolder.f10236b.equals(obj)) {
                break;
            } else {
                mediaPeriodHolder2 = mediaPeriodHolder.j();
            }
        }
        return mediaPeriodHolder.f10240f.f10249a.f12166d;
    }

    private boolean J(Timeline timeline) {
        MediaPeriodHolder mediaPeriodHolder = this.f10266i;
        if (mediaPeriodHolder == null) {
            return true;
        }
        int g2 = timeline.g(mediaPeriodHolder.f10236b);
        while (true) {
            g2 = timeline.i(g2, this.f10258a, this.f10259b, this.f10264g, this.f10265h);
            while (((MediaPeriodHolder) Assertions.g(mediaPeriodHolder)).j() != null && !mediaPeriodHolder.f10240f.f10255g) {
                mediaPeriodHolder = mediaPeriodHolder.j();
            }
            MediaPeriodHolder j2 = mediaPeriodHolder.j();
            if (g2 == -1 || j2 == null || timeline.g(j2.f10236b) != g2) {
                boolean D = D(mediaPeriodHolder);
                mediaPeriodHolder.f10240f = t(timeline, mediaPeriodHolder.f10240f);
            } else {
                mediaPeriodHolder = j2;
            }
        }
        boolean D2 = D(mediaPeriodHolder);
        mediaPeriodHolder.f10240f = t(timeline, mediaPeriodHolder.f10240f);
        return !D2;
    }

    private boolean d(long j2, long j3) {
        return j2 == C.f9084b || j2 == j3;
    }

    private boolean e(MediaPeriodInfo mediaPeriodInfo, MediaPeriodInfo mediaPeriodInfo2) {
        return mediaPeriodInfo.f10250b == mediaPeriodInfo2.f10250b && mediaPeriodInfo.f10249a.equals(mediaPeriodInfo2.f10249a);
    }

    @Nullable
    private MediaPeriodInfo h(PlaybackInfo playbackInfo) {
        return m(playbackInfo.f10304a, playbackInfo.f10305b, playbackInfo.f10306c, playbackInfo.r);
    }

    @Nullable
    private MediaPeriodInfo i(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j2) {
        long j3;
        Object obj;
        long j4;
        long j5;
        MediaPeriodInfo mediaPeriodInfo;
        long j6;
        long j7;
        Timeline timeline2 = timeline;
        MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder.f10240f;
        int i2 = timeline.i(timeline2.g(mediaPeriodInfo2.f10249a.f12163a), this.f10258a, this.f10259b, this.f10264g, this.f10265h);
        if (i2 == -1) {
            return null;
        }
        int i3 = timeline2.l(i2, this.f10258a, true).Y;
        Object g2 = Assertions.g(this.f10258a.X);
        long j8 = mediaPeriodInfo2.f10249a.f12166d;
        if (timeline2.u(i3, this.f10259b).h3 == i2) {
            mediaPeriodInfo = mediaPeriodInfo2;
            Pair<Object, Long> r = timeline.r(this.f10259b, this.f10258a, i3, C.f9084b, Math.max(0, j2));
            if (r == null) {
                return null;
            }
            Object obj2 = r.first;
            long longValue = ((Long) r.second).longValue();
            MediaPeriodHolder j9 = mediaPeriodHolder.j();
            if (j9 == null || !j9.f10236b.equals(obj2)) {
                j7 = this.f10263f;
                this.f10263f = 1 + j7;
            } else {
                j7 = j9.f10240f.f10249a.f12166d;
            }
            j3 = j7;
            j4 = -9223372036854775807L;
            obj = obj2;
            j5 = longValue;
        } else {
            mediaPeriodInfo = mediaPeriodInfo2;
            j3 = j8;
            j4 = 0;
            obj = g2;
            j5 = 0;
        }
        MediaSource.MediaPeriodId F = F(timeline, obj, j5, j3, this.f10259b, this.f10258a);
        if (!(j4 == C.f9084b || mediaPeriodInfo.f10251c == C.f9084b)) {
            boolean u = u(mediaPeriodInfo.f10249a.f12163a, timeline2);
            if (F.c() && u) {
                j4 = mediaPeriodInfo.f10251c;
            } else if (u) {
                j6 = mediaPeriodInfo.f10251c;
                return m(timeline, F, j4, j6);
            }
        }
        j6 = j5;
        return m(timeline, F, j4, j6);
    }

    @Nullable
    private MediaPeriodInfo j(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j2) {
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f10240f;
        long l2 = (mediaPeriodHolder.l() + mediaPeriodInfo.f10253e) - j2;
        return mediaPeriodInfo.f10255g ? i(timeline, mediaPeriodHolder, l2) : k(timeline, mediaPeriodHolder, l2);
    }

    @Nullable
    private MediaPeriodInfo k(Timeline timeline, MediaPeriodHolder mediaPeriodHolder, long j2) {
        Timeline timeline2 = timeline;
        MediaPeriodInfo mediaPeriodInfo = mediaPeriodHolder.f10240f;
        MediaSource.MediaPeriodId mediaPeriodId = mediaPeriodInfo.f10249a;
        timeline.m(mediaPeriodId.f12163a, this.f10258a);
        if (mediaPeriodId.c()) {
            int i2 = mediaPeriodId.f12164b;
            int d2 = this.f10258a.d(i2);
            if (d2 == -1) {
                return null;
            }
            int q = this.f10258a.q(i2, mediaPeriodId.f12165c);
            if (q < d2) {
                return n(timeline, mediaPeriodId.f12163a, i2, q, mediaPeriodInfo.f10251c, mediaPeriodId.f12166d);
            }
            long j3 = mediaPeriodInfo.f10251c;
            if (j3 == C.f9084b) {
                Timeline.Window window = this.f10259b;
                Timeline.Period period = this.f10258a;
                Pair<Object, Long> r = timeline.r(window, period, period.Y, C.f9084b, Math.max(0, j2));
                if (r == null) {
                    return null;
                }
                j3 = ((Long) r.second).longValue();
            }
            return o(timeline, mediaPeriodId.f12163a, Math.max(p(timeline, mediaPeriodId.f12163a, mediaPeriodId.f12164b), j3), mediaPeriodInfo.f10251c, mediaPeriodId.f12166d);
        }
        long j4 = j2;
        int i3 = mediaPeriodId.f12167e;
        if (i3 != -1 && this.f10258a.v(i3)) {
            return i(timeline, mediaPeriodHolder, j2);
        }
        int p2 = this.f10258a.p(mediaPeriodId.f12167e);
        boolean z = this.f10258a.w(mediaPeriodId.f12167e) && this.f10258a.k(mediaPeriodId.f12167e, p2) == 3;
        if (p2 == this.f10258a.d(mediaPeriodId.f12167e) || z) {
            return o(timeline, mediaPeriodId.f12163a, p(timeline, mediaPeriodId.f12163a, mediaPeriodId.f12167e), mediaPeriodInfo.f10253e, mediaPeriodId.f12166d);
        }
        return n(timeline, mediaPeriodId.f12163a, mediaPeriodId.f12167e, p2, mediaPeriodInfo.f10253e, mediaPeriodId.f12166d);
    }

    @Nullable
    private MediaPeriodInfo m(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3) {
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        Timeline timeline2 = timeline;
        timeline.m(mediaPeriodId2.f12163a, this.f10258a);
        boolean c2 = mediaPeriodId.c();
        Object obj = mediaPeriodId2.f12163a;
        if (c2) {
            return n(timeline, obj, mediaPeriodId2.f12164b, mediaPeriodId2.f12165c, j2, mediaPeriodId2.f12166d);
        }
        return o(timeline, obj, j3, j2, mediaPeriodId2.f12166d);
    }

    private MediaPeriodInfo n(Timeline timeline, Object obj, int i2, int i3, long j2, long j3) {
        int i4 = i3;
        MediaSource.MediaPeriodId mediaPeriodId = new MediaSource.MediaPeriodId(obj, i2, i4, j3);
        long e2 = timeline.m(mediaPeriodId.f12163a, this.f10258a).e(mediaPeriodId.f12164b, mediaPeriodId.f12165c);
        long j4 = i4 == this.f10258a.p(i2) ? this.f10258a.j() : 0;
        return new MediaPeriodInfo(mediaPeriodId, (e2 == C.f9084b || j4 < e2) ? j4 : Math.max(0, e2 - 1), j2, C.f9084b, e2, this.f10258a.w(mediaPeriodId.f12164b), false, false, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0037, code lost:
        if (r10.w(r10.t()) != false) goto L_0x0055;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0083 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.media3.exoplayer.MediaPeriodInfo o(androidx.media3.common.Timeline r26, java.lang.Object r27, long r28, long r30, long r32) {
        /*
            r25 = this;
            r0 = r25
            r1 = r26
            r2 = r27
            r3 = r28
            androidx.media3.common.Timeline$Period r5 = r0.f10258a
            r1.m(r2, r5)
            androidx.media3.common.Timeline$Period r5 = r0.f10258a
            int r5 = r5.g(r3)
            r6 = 0
            r7 = 1
            r8 = -1
            if (r5 == r8) goto L_0x0022
            androidx.media3.common.Timeline$Period r9 = r0.f10258a
            boolean r9 = r9.v(r5)
            if (r9 == 0) goto L_0x0022
            r9 = 1
            goto L_0x0023
        L_0x0022:
            r9 = 0
        L_0x0023:
            androidx.media3.common.Timeline$Period r10 = r0.f10258a
            if (r5 != r8) goto L_0x003a
            int r10 = r10.f()
            if (r10 <= 0) goto L_0x0057
            androidx.media3.common.Timeline$Period r10 = r0.f10258a
            int r11 = r10.t()
            boolean r10 = r10.w(r11)
            if (r10 == 0) goto L_0x0057
            goto L_0x0055
        L_0x003a:
            boolean r10 = r10.w(r5)
            if (r10 == 0) goto L_0x0057
            androidx.media3.common.Timeline$Period r10 = r0.f10258a
            long r10 = r10.i(r5)
            androidx.media3.common.Timeline$Period r12 = r0.f10258a
            long r13 = r12.Z
            int r15 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r15 != 0) goto L_0x0057
            boolean r10 = r12.u(r5)
            if (r10 == 0) goto L_0x0057
            r5 = -1
        L_0x0055:
            r10 = 1
            goto L_0x0058
        L_0x0057:
            r10 = 0
        L_0x0058:
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r12 = new androidx.media3.exoplayer.source.MediaSource$MediaPeriodId
            r13 = r32
            r12.<init>(r2, r13, r5)
            boolean r2 = r0.v(r12)
            boolean r23 = r0.x(r1, r12)
            boolean r24 = r0.w(r1, r12, r2)
            if (r5 == r8) goto L_0x007a
            androidx.media3.common.Timeline$Period r1 = r0.f10258a
            boolean r1 = r1.w(r5)
            if (r1 == 0) goto L_0x007a
            if (r9 != 0) goto L_0x007a
            r21 = 1
            goto L_0x007c
        L_0x007a:
            r21 = 0
        L_0x007c:
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r5 == r8) goto L_0x008e
            if (r9 != 0) goto L_0x008e
            androidx.media3.common.Timeline$Period r1 = r0.f10258a
            long r8 = r1.i(r5)
        L_0x008b:
            r17 = r8
            goto L_0x0097
        L_0x008e:
            if (r10 == 0) goto L_0x0095
            androidx.media3.common.Timeline$Period r1 = r0.f10258a
            long r8 = r1.Z
            goto L_0x008b
        L_0x0095:
            r17 = r13
        L_0x0097:
            int r1 = (r17 > r13 ? 1 : (r17 == r13 ? 0 : -1))
            if (r1 == 0) goto L_0x00a5
            r8 = -9223372036854775808
            int r1 = (r17 > r8 ? 1 : (r17 == r8 ? 0 : -1))
            if (r1 != 0) goto L_0x00a2
            goto L_0x00a5
        L_0x00a2:
            r19 = r17
            goto L_0x00ab
        L_0x00a5:
            androidx.media3.common.Timeline$Period r1 = r0.f10258a
            long r8 = r1.Z
            r19 = r8
        L_0x00ab:
            int r1 = (r19 > r13 ? 1 : (r19 == r13 ? 0 : -1))
            if (r1 == 0) goto L_0x00c1
            int r1 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r1 < 0) goto L_0x00c1
            if (r24 != 0) goto L_0x00b7
            if (r10 != 0) goto L_0x00b8
        L_0x00b7:
            r6 = 1
        L_0x00b8:
            long r3 = (long) r6
            long r3 = r19 - r3
            r5 = 0
            long r3 = java.lang.Math.max(r5, r3)
        L_0x00c1:
            r13 = r3
            androidx.media3.exoplayer.MediaPeriodInfo r1 = new androidx.media3.exoplayer.MediaPeriodInfo
            r11 = r1
            r15 = r30
            r22 = r2
            r11.<init>(r12, r13, r15, r17, r19, r21, r22, r23, r24)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.MediaPeriodQueue.o(androidx.media3.common.Timeline, java.lang.Object, long, long, long):androidx.media3.exoplayer.MediaPeriodInfo");
    }

    private long p(Timeline timeline, Object obj, int i2) {
        timeline.m(obj, this.f10258a);
        long i3 = this.f10258a.i(i2);
        return i3 == Long.MIN_VALUE ? this.f10258a.Z : i3 + this.f10258a.m(i2);
    }

    private boolean u(Object obj, Timeline timeline) {
        int f2 = timeline.m(obj, this.f10258a).f();
        int t = this.f10258a.t();
        return f2 > 0 && this.f10258a.w(t) && (f2 > 1 || this.f10258a.i(t) != Long.MIN_VALUE);
    }

    private boolean v(MediaSource.MediaPeriodId mediaPeriodId) {
        return !mediaPeriodId.c() && mediaPeriodId.f12167e == -1;
    }

    private boolean w(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, boolean z) {
        int g2 = timeline.g(mediaPeriodId.f12163a);
        if (!timeline.u(timeline.k(g2, this.f10258a).Y, this.f10259b).b3) {
            return timeline.y(g2, this.f10258a, this.f10259b, this.f10264g, this.f10265h) && z;
        }
    }

    private boolean x(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (!v(mediaPeriodId)) {
            return false;
        }
        return timeline.u(timeline.m(mediaPeriodId.f12163a, this.f10258a).Y, this.f10259b).i3 == timeline.g(mediaPeriodId.f12163a);
    }

    private static boolean z(Timeline.Period period) {
        int f2 = period.f();
        if (f2 == 0) {
            return false;
        }
        if ((f2 == 1 && period.v(0)) || !period.w(period.t())) {
            return false;
        }
        long j2 = 0;
        if (period.h(0) != -1) {
            return false;
        }
        if (period.Z == 0) {
            return true;
        }
        int i2 = f2 - (period.v(f2 + -1) ? 2 : 1);
        for (int i3 = 0; i3 <= i2; i3++) {
            j2 += period.m(i3);
        }
        return period.Z <= j2;
    }

    public void C(long j2) {
        MediaPeriodHolder mediaPeriodHolder = this.f10268k;
        if (mediaPeriodHolder != null) {
            mediaPeriodHolder.s(j2);
        }
    }

    public boolean D(MediaPeriodHolder mediaPeriodHolder) {
        Assertions.k(mediaPeriodHolder);
        boolean z = false;
        if (mediaPeriodHolder.equals(this.f10268k)) {
            return false;
        }
        this.f10268k = mediaPeriodHolder;
        while (mediaPeriodHolder.j() != null) {
            mediaPeriodHolder = (MediaPeriodHolder) Assertions.g(mediaPeriodHolder.j());
            if (mediaPeriodHolder == this.f10267j) {
                this.f10267j = this.f10266i;
                z = true;
            }
            mediaPeriodHolder.t();
            this.f10269l--;
        }
        ((MediaPeriodHolder) Assertions.g(this.f10268k)).w((MediaPeriodHolder) null);
        B();
        return z;
    }

    public MediaSource.MediaPeriodId E(Timeline timeline, Object obj, long j2) {
        return F(timeline, obj, j2, H(timeline, obj), this.f10259b, this.f10258a);
    }

    public MediaSource.MediaPeriodId G(Timeline timeline, Object obj, long j2) {
        long H = H(timeline, obj);
        timeline.m(obj, this.f10258a);
        timeline.u(this.f10258a.Y, this.f10259b);
        boolean z = false;
        for (int g2 = timeline.g(obj); g2 >= this.f10259b.h3; g2--) {
            boolean z2 = true;
            timeline.l(g2, this.f10258a, true);
            if (this.f10258a.f() <= 0) {
                z2 = false;
            }
            z |= z2;
            Timeline.Period period = this.f10258a;
            if (period.h(period.Z) != -1) {
                obj = Assertions.g(this.f10258a.X);
            }
            if (z && (!z2 || this.f10258a.Z != 0)) {
                break;
            }
        }
        return F(timeline, obj, j2, H, this.f10259b, this.f10258a);
    }

    public boolean I() {
        MediaPeriodHolder mediaPeriodHolder = this.f10268k;
        return mediaPeriodHolder == null || (!mediaPeriodHolder.f10240f.f10257i && mediaPeriodHolder.q() && this.f10268k.f10240f.f10253e != C.f9084b && this.f10269l < 100);
    }

    public boolean K(Timeline timeline, long j2, long j3) {
        MediaPeriodInfo mediaPeriodInfo;
        MediaPeriodHolder mediaPeriodHolder = this.f10266i;
        MediaPeriodHolder mediaPeriodHolder2 = null;
        while (mediaPeriodHolder != null) {
            MediaPeriodInfo mediaPeriodInfo2 = mediaPeriodHolder.f10240f;
            if (mediaPeriodHolder2 == null) {
                mediaPeriodInfo = t(timeline, mediaPeriodInfo2);
            } else {
                MediaPeriodInfo j4 = j(timeline, mediaPeriodHolder2, j2);
                if (j4 == null) {
                    return !D(mediaPeriodHolder2);
                }
                if (!e(mediaPeriodInfo2, j4)) {
                    return !D(mediaPeriodHolder2);
                }
                mediaPeriodInfo = j4;
            }
            mediaPeriodHolder.f10240f = mediaPeriodInfo.a(mediaPeriodInfo2.f10251c);
            if (!d(mediaPeriodInfo2.f10253e, mediaPeriodInfo.f10253e)) {
                mediaPeriodHolder.A();
                long j5 = mediaPeriodInfo.f10253e;
                return !D(mediaPeriodHolder) && !(mediaPeriodHolder == this.f10267j && !mediaPeriodHolder.f10240f.f10254f && ((j3 > Long.MIN_VALUE ? 1 : (j3 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j3 > ((j5 > C.f9084b ? 1 : (j5 == C.f9084b ? 0 : -1)) == 0 ? Long.MAX_VALUE : mediaPeriodHolder.z(j5)) ? 1 : (j3 == ((j5 > C.f9084b ? 1 : (j5 == C.f9084b ? 0 : -1)) == 0 ? Long.MAX_VALUE : mediaPeriodHolder.z(j5)) ? 0 : -1)) >= 0));
            }
            mediaPeriodHolder2 = mediaPeriodHolder;
            mediaPeriodHolder = mediaPeriodHolder.j();
        }
        return true;
    }

    public boolean L(Timeline timeline, int i2) {
        this.f10264g = i2;
        return J(timeline);
    }

    public boolean M(Timeline timeline, boolean z) {
        this.f10265h = z;
        return J(timeline);
    }

    @Nullable
    public MediaPeriodHolder b() {
        MediaPeriodHolder mediaPeriodHolder = this.f10266i;
        if (mediaPeriodHolder == null) {
            return null;
        }
        if (mediaPeriodHolder == this.f10267j) {
            this.f10267j = mediaPeriodHolder.j();
        }
        this.f10266i.t();
        int i2 = this.f10269l - 1;
        this.f10269l = i2;
        if (i2 == 0) {
            this.f10268k = null;
            MediaPeriodHolder mediaPeriodHolder2 = this.f10266i;
            this.f10270m = mediaPeriodHolder2.f10236b;
            this.f10271n = mediaPeriodHolder2.f10240f.f10249a.f12166d;
        }
        this.f10266i = this.f10266i.j();
        B();
        return this.f10266i;
    }

    public MediaPeriodHolder c() {
        this.f10267j = ((MediaPeriodHolder) Assertions.k(this.f10267j)).j();
        B();
        return (MediaPeriodHolder) Assertions.k(this.f10267j);
    }

    public void f() {
        if (this.f10269l != 0) {
            MediaPeriodHolder mediaPeriodHolder = (MediaPeriodHolder) Assertions.k(this.f10266i);
            this.f10270m = mediaPeriodHolder.f10236b;
            this.f10271n = mediaPeriodHolder.f10240f.f10249a.f12166d;
            while (mediaPeriodHolder != null) {
                mediaPeriodHolder.t();
                mediaPeriodHolder = mediaPeriodHolder.j();
            }
            this.f10266i = null;
            this.f10268k = null;
            this.f10267j = null;
            this.f10269l = 0;
            B();
        }
    }

    public MediaPeriodHolder g(MediaPeriodInfo mediaPeriodInfo) {
        MediaPeriodHolder mediaPeriodHolder = this.f10268k;
        MediaPeriodHolder a2 = this.f10262e.a(mediaPeriodInfo, mediaPeriodHolder == null ? o : (mediaPeriodHolder.l() + this.f10268k.f10240f.f10253e) - mediaPeriodInfo.f10250b);
        MediaPeriodHolder mediaPeriodHolder2 = this.f10268k;
        if (mediaPeriodHolder2 != null) {
            mediaPeriodHolder2.w(a2);
        } else {
            this.f10266i = a2;
            this.f10267j = a2;
        }
        this.f10270m = null;
        this.f10268k = a2;
        this.f10269l++;
        B();
        return a2;
    }

    @Nullable
    public MediaPeriodHolder l() {
        return this.f10268k;
    }

    @Nullable
    public MediaPeriodInfo q(long j2, PlaybackInfo playbackInfo) {
        MediaPeriodHolder mediaPeriodHolder = this.f10268k;
        return mediaPeriodHolder == null ? h(playbackInfo) : j(playbackInfo.f10304a, mediaPeriodHolder, j2);
    }

    @Nullable
    public MediaPeriodHolder r() {
        return this.f10266i;
    }

    @Nullable
    public MediaPeriodHolder s() {
        return this.f10267j;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0029, code lost:
        r1 = r3.f12167e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.exoplayer.MediaPeriodInfo t(androidx.media3.common.Timeline r19, androidx.media3.exoplayer.MediaPeriodInfo r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r2.f10249a
            boolean r12 = r0.v(r3)
            boolean r13 = r0.x(r1, r3)
            boolean r14 = r0.w(r1, r3, r12)
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r4 = r2.f10249a
            java.lang.Object r4 = r4.f12163a
            androidx.media3.common.Timeline$Period r5 = r0.f10258a
            r1.m(r4, r5)
            boolean r1 = r3.c()
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = -1
            if (r1 != 0) goto L_0x0035
            int r1 = r3.f12167e
            if (r1 != r6) goto L_0x002e
            goto L_0x0035
        L_0x002e:
            androidx.media3.common.Timeline$Period r7 = r0.f10258a
            long r7 = r7.i(r1)
            goto L_0x0036
        L_0x0035:
            r7 = r4
        L_0x0036:
            boolean r1 = r3.c()
            if (r1 == 0) goto L_0x0048
            androidx.media3.common.Timeline$Period r1 = r0.f10258a
            int r4 = r3.f12164b
            int r5 = r3.f12165c
            long r4 = r1.e(r4, r5)
        L_0x0046:
            r9 = r4
            goto L_0x005c
        L_0x0048:
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x0055
            r4 = -9223372036854775808
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x0053
            goto L_0x0055
        L_0x0053:
            r9 = r7
            goto L_0x005c
        L_0x0055:
            androidx.media3.common.Timeline$Period r1 = r0.f10258a
            long r4 = r1.o()
            goto L_0x0046
        L_0x005c:
            boolean r1 = r3.c()
            if (r1 == 0) goto L_0x006c
            androidx.media3.common.Timeline$Period r1 = r0.f10258a
            int r4 = r3.f12164b
            boolean r1 = r1.w(r4)
            r11 = r1
            goto L_0x007d
        L_0x006c:
            int r1 = r3.f12167e
            if (r1 == r6) goto L_0x007b
            androidx.media3.common.Timeline$Period r4 = r0.f10258a
            boolean r1 = r4.w(r1)
            if (r1 == 0) goto L_0x007b
            r1 = 1
            r11 = 1
            goto L_0x007d
        L_0x007b:
            r1 = 0
            r11 = 0
        L_0x007d:
            androidx.media3.exoplayer.MediaPeriodInfo r15 = new androidx.media3.exoplayer.MediaPeriodInfo
            long r4 = r2.f10250b
            long r1 = r2.f10251c
            r16 = r1
            r1 = r15
            r2 = r3
            r3 = r4
            r5 = r16
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.MediaPeriodQueue.t(androidx.media3.common.Timeline, androidx.media3.exoplayer.MediaPeriodInfo):androidx.media3.exoplayer.MediaPeriodInfo");
    }

    public boolean y(MediaPeriod mediaPeriod) {
        MediaPeriodHolder mediaPeriodHolder = this.f10268k;
        return mediaPeriodHolder != null && mediaPeriodHolder.f10235a == mediaPeriod;
    }
}
