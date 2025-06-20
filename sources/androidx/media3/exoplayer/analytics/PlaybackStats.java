package androidx.media3.exoplayer.analytics;

import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import java.util.Collections;
import java.util.List;

@UnstableApi
public final class PlaybackStats {
    public static final int O = 0;
    public static final int P = 1;
    public static final int Q = 2;
    public static final int R = 3;
    public static final int S = 4;
    public static final int T = 5;
    public static final int U = 6;
    public static final int V = 7;
    public static final int W = 9;
    public static final int X = 10;
    public static final int Y = 11;
    public static final int Z = 12;
    public static final int a0 = 13;
    public static final int b0 = 14;
    public static final int c0 = 15;
    static final int d0 = 16;
    public static final PlaybackStats e0 = W(new PlaybackStats[0]);
    public final int A;
    public final long B;
    public final int C;
    public final long D;
    public final long E;
    public final long F;
    public final long G;
    public final long H;
    public final int I;
    public final int J;
    public final int K;
    public final List<EventTimeAndException> L;
    public final List<EventTimeAndException> M;
    private final long[] N;

    /* renamed from: a  reason: collision with root package name */
    public final int f10579a;

    /* renamed from: b  reason: collision with root package name */
    public final List<EventTimeAndPlaybackState> f10580b;

    /* renamed from: c  reason: collision with root package name */
    public final List<long[]> f10581c;

    /* renamed from: d  reason: collision with root package name */
    public final long f10582d;

    /* renamed from: e  reason: collision with root package name */
    public final int f10583e;

    /* renamed from: f  reason: collision with root package name */
    public final int f10584f;

    /* renamed from: g  reason: collision with root package name */
    public final int f10585g;

    /* renamed from: h  reason: collision with root package name */
    public final int f10586h;

    /* renamed from: i  reason: collision with root package name */
    public final long f10587i;

    /* renamed from: j  reason: collision with root package name */
    public final int f10588j;

    /* renamed from: k  reason: collision with root package name */
    public final int f10589k;

    /* renamed from: l  reason: collision with root package name */
    public final int f10590l;

    /* renamed from: m  reason: collision with root package name */
    public final int f10591m;

    /* renamed from: n  reason: collision with root package name */
    public final int f10592n;
    public final long o;
    public final int p;
    public final List<EventTimeAndFormat> q;
    public final List<EventTimeAndFormat> r;
    public final long s;
    public final long t;
    public final long u;
    public final long v;
    public final long w;
    public final long x;
    public final int y;
    public final int z;

    public static final class EventTimeAndException {

        /* renamed from: a  reason: collision with root package name */
        public final AnalyticsListener.EventTime f10593a;

        /* renamed from: b  reason: collision with root package name */
        public final Exception f10594b;

        public EventTimeAndException(AnalyticsListener.EventTime eventTime, Exception exc) {
            this.f10593a = eventTime;
            this.f10594b = exc;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || EventTimeAndException.class != obj.getClass()) {
                return false;
            }
            EventTimeAndException eventTimeAndException = (EventTimeAndException) obj;
            if (!this.f10593a.equals(eventTimeAndException.f10593a)) {
                return false;
            }
            return this.f10594b.equals(eventTimeAndException.f10594b);
        }

        public int hashCode() {
            return (this.f10593a.hashCode() * 31) + this.f10594b.hashCode();
        }
    }

    public static final class EventTimeAndFormat {

        /* renamed from: a  reason: collision with root package name */
        public final AnalyticsListener.EventTime f10595a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        public final Format f10596b;

        public EventTimeAndFormat(AnalyticsListener.EventTime eventTime, @Nullable Format format) {
            this.f10595a = eventTime;
            this.f10596b = format;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || EventTimeAndFormat.class != obj.getClass()) {
                return false;
            }
            EventTimeAndFormat eventTimeAndFormat = (EventTimeAndFormat) obj;
            if (!this.f10595a.equals(eventTimeAndFormat.f10595a)) {
                return false;
            }
            Format format = this.f10596b;
            Format format2 = eventTimeAndFormat.f10596b;
            return format != null ? format.equals(format2) : format2 == null;
        }

        public int hashCode() {
            int hashCode = this.f10595a.hashCode() * 31;
            Format format = this.f10596b;
            return hashCode + (format != null ? format.hashCode() : 0);
        }
    }

    public static final class EventTimeAndPlaybackState {

        /* renamed from: a  reason: collision with root package name */
        public final AnalyticsListener.EventTime f10597a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10598b;

        public EventTimeAndPlaybackState(AnalyticsListener.EventTime eventTime, int i2) {
            this.f10597a = eventTime;
            this.f10598b = i2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || EventTimeAndPlaybackState.class != obj.getClass()) {
                return false;
            }
            EventTimeAndPlaybackState eventTimeAndPlaybackState = (EventTimeAndPlaybackState) obj;
            if (this.f10598b != eventTimeAndPlaybackState.f10598b) {
                return false;
            }
            return this.f10597a.equals(eventTimeAndPlaybackState.f10597a);
        }

        public int hashCode() {
            return (this.f10597a.hashCode() * 31) + this.f10598b;
        }
    }

    PlaybackStats(int i2, long[] jArr, List<EventTimeAndPlaybackState> list, List<long[]> list2, long j2, int i3, int i4, int i5, int i6, long j3, int i7, int i8, int i9, int i10, int i11, long j4, int i12, List<EventTimeAndFormat> list3, List<EventTimeAndFormat> list4, long j5, long j6, long j7, long j8, long j9, long j10, int i13, int i14, int i15, long j11, int i16, long j12, long j13, long j14, long j15, long j16, int i17, int i18, int i19, List<EventTimeAndException> list5, List<EventTimeAndException> list6) {
        this.f10579a = i2;
        this.N = jArr;
        this.f10580b = Collections.unmodifiableList(list);
        this.f10581c = Collections.unmodifiableList(list2);
        this.f10582d = j2;
        this.f10583e = i3;
        this.f10584f = i4;
        this.f10585g = i5;
        this.f10586h = i6;
        this.f10587i = j3;
        this.f10588j = i7;
        this.f10589k = i8;
        this.f10590l = i9;
        this.f10591m = i10;
        this.f10592n = i11;
        this.o = j4;
        this.p = i12;
        this.q = Collections.unmodifiableList(list3);
        this.r = Collections.unmodifiableList(list4);
        this.s = j5;
        this.t = j6;
        this.u = j7;
        this.v = j8;
        this.w = j9;
        this.x = j10;
        this.y = i13;
        this.z = i14;
        this.A = i15;
        this.B = j11;
        this.C = i16;
        this.D = j12;
        this.E = j13;
        this.F = j14;
        this.G = j15;
        this.H = j16;
        this.I = i17;
        this.J = i18;
        this.K = i19;
        this.L = Collections.unmodifiableList(list5);
        this.M = Collections.unmodifiableList(list6);
    }

    public static PlaybackStats W(PlaybackStats... playbackStatsArr) {
        int i2;
        PlaybackStats[] playbackStatsArr2 = playbackStatsArr;
        int i3 = 16;
        long[] jArr = new long[16];
        int length = playbackStatsArr2.length;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        long j11 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = -1;
        long j12 = C.f9084b;
        long j13 = C.f9084b;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        long j14 = C.f9084b;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        long j15 = -1;
        int i19 = 0;
        long j16 = -1;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        while (i4 < length) {
            PlaybackStats playbackStats = playbackStatsArr2[i4];
            i5 += playbackStats.f10579a;
            for (int i23 = 0; i23 < i3; i23++) {
                jArr[i23] = jArr[i23] + playbackStats.N[i23];
            }
            if (j13 == C.f9084b) {
                j13 = playbackStats.f10582d;
                i2 = length;
            } else {
                i2 = length;
                long j17 = playbackStats.f10582d;
                if (j17 != C.f9084b) {
                    j13 = Math.min(j13, j17);
                }
            }
            i7 += playbackStats.f10583e;
            i8 += playbackStats.f10584f;
            i9 += playbackStats.f10585g;
            i10 += playbackStats.f10586h;
            if (j14 == C.f9084b) {
                j14 = playbackStats.f10587i;
            } else {
                long j18 = playbackStats.f10587i;
                if (j18 != C.f9084b) {
                    j14 += j18;
                }
            }
            i11 += playbackStats.f10588j;
            i12 += playbackStats.f10589k;
            i13 += playbackStats.f10590l;
            i14 += playbackStats.f10591m;
            i15 += playbackStats.f10592n;
            if (j12 == C.f9084b) {
                j12 = playbackStats.o;
            } else {
                long j19 = playbackStats.o;
                if (j19 != C.f9084b) {
                    j12 = Math.max(j12, j19);
                }
            }
            i16 += playbackStats.p;
            j2 += playbackStats.s;
            j3 += playbackStats.t;
            j4 += playbackStats.u;
            j5 += playbackStats.v;
            j6 += playbackStats.w;
            j7 += playbackStats.x;
            i17 += playbackStats.y;
            i18 += playbackStats.z;
            if (i6 == -1) {
                i6 = playbackStats.A;
            } else {
                int i24 = playbackStats.A;
                if (i24 != -1) {
                    i6 += i24;
                }
            }
            int i25 = (j15 > -1 ? 1 : (j15 == -1 ? 0 : -1));
            long j20 = playbackStats.B;
            if (i25 == 0) {
                j15 = j20;
            } else if (j20 != -1) {
                j15 += j20;
            }
            i19 += playbackStats.C;
            if (j16 == -1) {
                j16 = playbackStats.D;
            } else {
                long j21 = playbackStats.D;
                if (j21 != -1) {
                    j16 += j21;
                }
            }
            j8 += playbackStats.E;
            j9 += playbackStats.F;
            j10 += playbackStats.G;
            j11 += playbackStats.H;
            i20 += playbackStats.I;
            i21 += playbackStats.J;
            i22 += playbackStats.K;
            i4++;
            length = i2;
            i3 = 16;
        }
        return new PlaybackStats(i5, jArr, Collections.emptyList(), Collections.emptyList(), j13, i7, i8, i9, i10, j14, i11, i12, i13, i14, i15, j12, i16, Collections.emptyList(), Collections.emptyList(), j2, j3, j4, j5, j6, j7, i17, i18, i6, j15, i19, j16, j8, j9, j10, j11, i20, i21, i22, Collections.emptyList(), Collections.emptyList());
    }

    public float A() {
        return 1.0f / e();
    }

    public float B() {
        return 1.0f / H();
    }

    public float C() {
        return 1.0f / K();
    }

    public int D() {
        long j2 = this.u;
        if (j2 == 0) {
            return -1;
        }
        return (int) (this.v / j2);
    }

    public int E() {
        long j2 = this.s;
        if (j2 == 0) {
            return -1;
        }
        return (int) (this.t / j2);
    }

    public long F() {
        return this.f10583e == 0 ? C.f9084b : U() / ((long) this.f10583e);
    }

    public long G(long j2) {
        if (this.f10581c.isEmpty()) {
            return C.f9084b;
        }
        int i2 = 0;
        while (i2 < this.f10581c.size() && this.f10581c.get(i2)[0] <= j2) {
            i2++;
        }
        if (i2 == 0) {
            return this.f10581c.get(0)[1];
        }
        if (i2 == this.f10581c.size()) {
            List<long[]> list = this.f10581c;
            return list.get(list.size() - 1)[1];
        }
        int i3 = i2 - 1;
        long j3 = this.f10581c.get(i3)[0];
        long j4 = this.f10581c.get(i3)[1];
        long j5 = this.f10581c.get(i2)[0];
        long j6 = this.f10581c.get(i2)[1];
        long j7 = j5 - j3;
        if (j7 == 0) {
            return j4;
        }
        return j4 + ((long) (((float) (j6 - j4)) * (((float) (j2 - j3)) / ((float) j7))));
    }

    public float H() {
        long R2 = R();
        if (R2 == 0) {
            return 0.0f;
        }
        return (((float) this.K) * 1000.0f) / ((float) R2);
    }

    public int I(long j2) {
        int i2 = 0;
        for (EventTimeAndPlaybackState next : this.f10580b) {
            if (next.f10597a.f10506a > j2) {
                break;
            }
            i2 = next.f10598b;
        }
        return i2;
    }

    public long J(int i2) {
        return this.N[i2];
    }

    public float K() {
        long R2 = R();
        if (R2 == 0) {
            return 0.0f;
        }
        return (((float) this.f10592n) * 1000.0f) / ((float) R2);
    }

    public float L() {
        long Q2 = Q();
        if (Q2 == 0) {
            return 0.0f;
        }
        return ((float) S()) / ((float) Q2);
    }

    public float M() {
        long Q2 = Q();
        if (Q2 == 0) {
            return 0.0f;
        }
        return ((float) T()) / ((float) Q2);
    }

    public long N() {
        long j2 = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            j2 += this.N[i2];
        }
        return j2;
    }

    public long O() {
        return J(2);
    }

    public long P() {
        return J(4) + J(7);
    }

    public long Q() {
        return R() + U();
    }

    public long R() {
        return J(3);
    }

    public long S() {
        return J(6);
    }

    public long T() {
        return J(5);
    }

    public long U() {
        return J(2) + J(6) + J(5);
    }

    public float V() {
        long Q2 = Q();
        if (Q2 == 0) {
            return 0.0f;
        }
        return ((float) U()) / ((float) Q2);
    }

    public float a() {
        int i2 = this.f10584f;
        int i3 = this.f10579a;
        int i4 = this.f10583e;
        int i5 = i2 - (i3 - i4);
        if (i4 == 0) {
            return 0.0f;
        }
        return ((float) i5) / ((float) i4);
    }

    public float b() {
        long R2 = R();
        if (R2 == 0) {
            return 0.0f;
        }
        return (((float) this.H) * 1000.0f) / ((float) R2);
    }

    public float c() {
        long R2 = R();
        if (R2 == 0) {
            return 0.0f;
        }
        return (((float) this.G) * 1000.0f) / ((float) R2);
    }

    public float d() {
        int i2 = this.f10583e;
        if (i2 == 0) {
            return 0.0f;
        }
        return ((float) this.f10585g) / ((float) i2);
    }

    public float e() {
        long R2 = R();
        if (R2 == 0) {
            return 0.0f;
        }
        return (((float) this.J) * 1000.0f) / ((float) R2);
    }

    public float f() {
        int i2 = this.f10583e;
        if (i2 == 0) {
            return 0.0f;
        }
        return ((float) this.I) / ((float) i2);
    }

    public float g() {
        long Q2 = Q();
        if (Q2 == 0) {
            return 0.0f;
        }
        return ((float) O()) / ((float) Q2);
    }

    public int h() {
        long j2 = this.w;
        if (j2 == 0) {
            return -1;
        }
        return (int) (this.x / j2);
    }

    public int i() {
        long j2 = this.E;
        if (j2 == 0) {
            return -1;
        }
        return (int) ((this.F * 8000) / j2);
    }

    public long j() {
        return this.f10579a == 0 ? C.f9084b : N() / ((long) this.f10579a);
    }

    public int k() {
        int i2 = this.C;
        if (i2 == 0) {
            return -1;
        }
        return (int) (this.D / ((long) i2));
    }

    public int l() {
        int i2 = this.z;
        if (i2 == 0) {
            return -1;
        }
        return (int) (this.B / ((long) i2));
    }

    public int m() {
        int i2 = this.y;
        if (i2 == 0) {
            return -1;
        }
        return this.A / i2;
    }

    public long n() {
        int i2 = this.f10588j;
        return i2 == 0 ? C.f9084b : this.f10587i / ((long) i2);
    }

    public float o() {
        int i2 = this.f10583e;
        if (i2 == 0) {
            return 0.0f;
        }
        return ((float) this.K) / ((float) i2);
    }

    public float p() {
        int i2 = this.f10583e;
        if (i2 == 0) {
            return 0.0f;
        }
        return ((float) this.f10590l) / ((float) i2);
    }

    public float q() {
        int i2 = this.f10583e;
        if (i2 == 0) {
            return 0.0f;
        }
        return ((float) this.f10589k) / ((float) i2);
    }

    public long r() {
        return this.f10583e == 0 ? C.f9084b : P() / ((long) this.f10583e);
    }

    public long s() {
        return this.f10583e == 0 ? C.f9084b : Q() / ((long) this.f10583e);
    }

    public long t() {
        return this.f10583e == 0 ? C.f9084b : R() / ((long) this.f10583e);
    }

    public float u() {
        int i2 = this.f10583e;
        if (i2 == 0) {
            return 0.0f;
        }
        return ((float) this.f10592n) / ((float) i2);
    }

    public long v() {
        return this.f10583e == 0 ? C.f9084b : S() / ((long) this.f10583e);
    }

    public float w() {
        int i2 = this.f10583e;
        if (i2 == 0) {
            return 0.0f;
        }
        return ((float) this.f10591m) / ((float) i2);
    }

    public long x() {
        return this.f10583e == 0 ? C.f9084b : T() / ((long) this.f10583e);
    }

    public long y() {
        return this.f10592n == 0 ? C.f9084b : (J(6) + J(7)) / ((long) this.f10592n);
    }

    public long z() {
        return this.f10591m == 0 ? C.f9084b : T() / ((long) this.f10591m);
    }
}
