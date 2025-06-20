package androidx.media3.exoplayer.analytics;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.FlagSet;
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
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.base.Objects;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;

public interface AnalyticsListener {
    @UnstableApi
    public static final int A = 26;
    @UnstableApi
    public static final int B = 28;
    @UnstableApi
    public static final int C = 27;
    @UnstableApi
    public static final int D = 29;
    @UnstableApi
    public static final int E = 30;
    @UnstableApi
    public static final int F = 1000;
    @UnstableApi
    public static final int G = 1001;
    @UnstableApi
    public static final int H = 1002;
    @UnstableApi
    public static final int I = 1003;
    @UnstableApi
    public static final int J = 1004;
    @UnstableApi
    public static final int K = 1005;
    @UnstableApi
    public static final int L = 1006;
    @UnstableApi
    public static final int M = 1007;
    @UnstableApi
    public static final int N = 1008;
    @UnstableApi
    public static final int O = 1009;
    @UnstableApi
    public static final int P = 1010;
    @UnstableApi
    public static final int Q = 1011;
    @UnstableApi
    public static final int R = 1012;
    @UnstableApi
    public static final int S = 1013;
    @UnstableApi
    public static final int T = 1014;
    @UnstableApi
    public static final int U = 1015;
    @UnstableApi
    public static final int V = 1016;
    @UnstableApi
    public static final int W = 1017;
    @UnstableApi
    public static final int X = 1018;
    @UnstableApi
    public static final int Y = 1019;
    @UnstableApi
    public static final int Z = 1020;
    @UnstableApi

    /* renamed from: a  reason: collision with root package name */
    public static final int f10492a = 0;
    @UnstableApi
    public static final int a0 = 1021;
    @UnstableApi

    /* renamed from: b  reason: collision with root package name */
    public static final int f10493b = 1;
    @UnstableApi
    public static final int b0 = 1022;
    @UnstableApi

    /* renamed from: c  reason: collision with root package name */
    public static final int f10494c = 2;
    @UnstableApi
    public static final int c0 = 1023;
    @UnstableApi

    /* renamed from: d  reason: collision with root package name */
    public static final int f10495d = 3;
    @UnstableApi
    public static final int d0 = 1024;
    @UnstableApi

    /* renamed from: e  reason: collision with root package name */
    public static final int f10496e = 4;
    @UnstableApi
    public static final int e0 = 1025;
    @UnstableApi

    /* renamed from: f  reason: collision with root package name */
    public static final int f10497f = 5;
    @UnstableApi
    public static final int f0 = 1026;
    @UnstableApi

    /* renamed from: g  reason: collision with root package name */
    public static final int f10498g = 6;
    @UnstableApi
    public static final int g0 = 1027;
    @UnstableApi

    /* renamed from: h  reason: collision with root package name */
    public static final int f10499h = 7;
    @UnstableApi
    public static final int h0 = 1028;
    @UnstableApi

    /* renamed from: i  reason: collision with root package name */
    public static final int f10500i = 8;
    @UnstableApi
    public static final int i0 = 1029;
    @UnstableApi

    /* renamed from: j  reason: collision with root package name */
    public static final int f10501j = 9;
    @UnstableApi
    public static final int j0 = 1030;
    @UnstableApi

    /* renamed from: k  reason: collision with root package name */
    public static final int f10502k = 10;
    @UnstableApi
    public static final int k0 = 1031;
    @UnstableApi

    /* renamed from: l  reason: collision with root package name */
    public static final int f10503l = 11;
    @UnstableApi
    public static final int l0 = 1032;
    @UnstableApi

    /* renamed from: m  reason: collision with root package name */
    public static final int f10504m = 12;
    @UnstableApi

    /* renamed from: n  reason: collision with root package name */
    public static final int f10505n = 13;
    @UnstableApi
    public static final int o = 14;
    @UnstableApi
    public static final int p = 15;
    @UnstableApi
    public static final int q = 16;
    @UnstableApi
    public static final int r = 17;
    @UnstableApi
    public static final int s = 18;
    @UnstableApi
    public static final int t = 19;
    @UnstableApi
    public static final int u = 20;
    @UnstableApi
    public static final int v = 21;
    @UnstableApi
    public static final int w = 22;
    @UnstableApi
    public static final int x = 23;
    @UnstableApi
    public static final int y = 24;
    @UnstableApi
    public static final int z = 25;

    @UnstableApi
    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface EventFlags {
    }

    @UnstableApi
    public static final class EventTime {

        /* renamed from: a  reason: collision with root package name */
        public final long f10506a;

        /* renamed from: b  reason: collision with root package name */
        public final Timeline f10507b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10508c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f10509d;

        /* renamed from: e  reason: collision with root package name */
        public final long f10510e;

        /* renamed from: f  reason: collision with root package name */
        public final Timeline f10511f;

        /* renamed from: g  reason: collision with root package name */
        public final int f10512g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f10513h;

        /* renamed from: i  reason: collision with root package name */
        public final long f10514i;

        /* renamed from: j  reason: collision with root package name */
        public final long f10515j;

        public EventTime(long j2, Timeline timeline, int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, long j3, Timeline timeline2, int i3, @Nullable MediaSource.MediaPeriodId mediaPeriodId2, long j4, long j5) {
            this.f10506a = j2;
            this.f10507b = timeline;
            this.f10508c = i2;
            this.f10509d = mediaPeriodId;
            this.f10510e = j3;
            this.f10511f = timeline2;
            this.f10512g = i3;
            this.f10513h = mediaPeriodId2;
            this.f10514i = j4;
            this.f10515j = j5;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || EventTime.class != obj.getClass()) {
                return false;
            }
            EventTime eventTime = (EventTime) obj;
            return this.f10506a == eventTime.f10506a && this.f10508c == eventTime.f10508c && this.f10510e == eventTime.f10510e && this.f10512g == eventTime.f10512g && this.f10514i == eventTime.f10514i && this.f10515j == eventTime.f10515j && Objects.a(this.f10507b, eventTime.f10507b) && Objects.a(this.f10509d, eventTime.f10509d) && Objects.a(this.f10511f, eventTime.f10511f) && Objects.a(this.f10513h, eventTime.f10513h);
        }

        public int hashCode() {
            return Objects.b(Long.valueOf(this.f10506a), this.f10507b, Integer.valueOf(this.f10508c), this.f10509d, Long.valueOf(this.f10510e), this.f10511f, Integer.valueOf(this.f10512g), this.f10513h, Long.valueOf(this.f10514i), Long.valueOf(this.f10515j));
        }
    }

    @UnstableApi
    public static final class Events {

        /* renamed from: a  reason: collision with root package name */
        private final FlagSet f10516a;

        /* renamed from: b  reason: collision with root package name */
        private final SparseArray<EventTime> f10517b;

        public Events(FlagSet flagSet, SparseArray<EventTime> sparseArray) {
            this.f10516a = flagSet;
            SparseArray<EventTime> sparseArray2 = new SparseArray<>(flagSet.d());
            for (int i2 = 0; i2 < flagSet.d(); i2++) {
                int c2 = flagSet.c(i2);
                sparseArray2.append(c2, (EventTime) Assertions.g(sparseArray.get(c2)));
            }
            this.f10517b = sparseArray2;
        }

        public boolean a(int i2) {
            return this.f10516a.a(i2);
        }

        public boolean b(int... iArr) {
            return this.f10516a.b(iArr);
        }

        public int c(int i2) {
            return this.f10516a.c(i2);
        }

        public EventTime d(int i2) {
            return (EventTime) Assertions.g(this.f10517b.get(i2));
        }

        public int e() {
            return this.f10516a.d();
        }
    }

    @UnstableApi
    @Deprecated
    void A(EventTime eventTime, Format format);

    @UnstableApi
    void A0(EventTime eventTime, int i2, long j2, long j3);

    @UnstableApi
    void B(EventTime eventTime, DecoderCounters decoderCounters);

    @UnstableApi
    void B0(EventTime eventTime, int i2);

    @UnstableApi
    @Deprecated
    void C(EventTime eventTime, boolean z2, int i2);

    @UnstableApi
    void C0(EventTime eventTime, Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    @UnstableApi
    void D(EventTime eventTime);

    @UnstableApi
    void E(EventTime eventTime, int i2, long j2, long j3);

    @UnstableApi
    void F(EventTime eventTime, Exception exc);

    @UnstableApi
    @Deprecated
    void G(EventTime eventTime, Format format);

    @UnstableApi
    void H(EventTime eventTime, @Nullable PlaybackException playbackException);

    @UnstableApi
    @Deprecated
    void I(EventTime eventTime, String str, long j2);

    @UnstableApi
    @Deprecated
    void J(EventTime eventTime);

    @UnstableApi
    void K(EventTime eventTime);

    @UnstableApi
    void L(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    @UnstableApi
    void M(EventTime eventTime, Tracks tracks);

    @UnstableApi
    void O(EventTime eventTime, long j2);

    @UnstableApi
    void P(EventTime eventTime, int i2);

    @UnstableApi
    void Q(EventTime eventTime, CueGroup cueGroup);

    @UnstableApi
    void R(EventTime eventTime, String str, long j2, long j3);

    @UnstableApi
    void S(EventTime eventTime, String str, long j2, long j3);

    @UnstableApi
    void T(EventTime eventTime, TrackSelectionParameters trackSelectionParameters);

    @UnstableApi
    void U(EventTime eventTime, MediaMetadata mediaMetadata);

    @UnstableApi
    void V(EventTime eventTime, AudioAttributes audioAttributes);

    @UnstableApi
    void W(EventTime eventTime, VideoSize videoSize);

    @UnstableApi
    void X(EventTime eventTime, long j2);

    @UnstableApi
    void Y(EventTime eventTime, int i2);

    @UnstableApi
    void Z(EventTime eventTime, long j2, int i2);

    @UnstableApi
    @Deprecated
    void a(EventTime eventTime, String str, long j2);

    @UnstableApi
    void a0(EventTime eventTime, Exception exc);

    @UnstableApi
    void b(EventTime eventTime, Object obj, long j2);

    @UnstableApi
    void b0(EventTime eventTime, DecoderCounters decoderCounters);

    @UnstableApi
    void c(EventTime eventTime, boolean z2);

    @UnstableApi
    void c0(EventTime eventTime, @Nullable MediaItem mediaItem, int i2);

    @UnstableApi
    void d(EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig);

    @UnstableApi
    void d0(EventTime eventTime, DecoderCounters decoderCounters);

    @UnstableApi
    void e(EventTime eventTime, PlaybackParameters playbackParameters);

    @UnstableApi
    void e0(EventTime eventTime, MediaLoadData mediaLoadData);

    @UnstableApi
    void f(EventTime eventTime, String str);

    @UnstableApi
    void f0(Player player, Events events);

    @UnstableApi
    void g(EventTime eventTime, AudioSink.AudioTrackConfig audioTrackConfig);

    @UnstableApi
    void g0(EventTime eventTime, DeviceInfo deviceInfo);

    @UnstableApi
    void h(EventTime eventTime, String str);

    @UnstableApi
    void h0(EventTime eventTime);

    @UnstableApi
    void i0(EventTime eventTime, MediaMetadata mediaMetadata);

    @UnstableApi
    void j(EventTime eventTime, int i2, boolean z2);

    @UnstableApi
    void j0(EventTime eventTime, int i2, int i3);

    @UnstableApi
    void k(EventTime eventTime, int i2);

    @UnstableApi
    void l(EventTime eventTime, boolean z2);

    @UnstableApi
    void l0(EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2);

    @UnstableApi
    void m(EventTime eventTime, Metadata metadata);

    @UnstableApi
    void m0(EventTime eventTime, int i2);

    @UnstableApi
    void n(EventTime eventTime, MediaLoadData mediaLoadData);

    @UnstableApi
    void n0(EventTime eventTime);

    @UnstableApi
    @Deprecated
    void o(EventTime eventTime, List<Cue> list);

    @UnstableApi
    void o0(EventTime eventTime, Player.Commands commands);

    @UnstableApi
    void p(EventTime eventTime);

    @UnstableApi
    void p0(EventTime eventTime, Exception exc);

    @UnstableApi
    void q(EventTime eventTime, boolean z2);

    @UnstableApi
    void q0(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    @UnstableApi
    void r(EventTime eventTime, PlaybackException playbackException);

    @UnstableApi
    void r0(EventTime eventTime, DecoderCounters decoderCounters);

    @UnstableApi
    @Deprecated
    void s(EventTime eventTime, int i2, int i3, int i4, float f2);

    @UnstableApi
    @Deprecated
    void t(EventTime eventTime, boolean z2);

    @UnstableApi
    void t0(EventTime eventTime, Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation);

    @UnstableApi
    void u(EventTime eventTime, int i2, long j2);

    @UnstableApi
    void u0(EventTime eventTime, Exception exc);

    @UnstableApi
    void v(EventTime eventTime, long j2);

    @UnstableApi
    void v0(EventTime eventTime, float f2);

    @UnstableApi
    @Deprecated
    void w(EventTime eventTime, int i2);

    @UnstableApi
    void w0(EventTime eventTime, boolean z2);

    @UnstableApi
    @Deprecated
    void x(EventTime eventTime);

    @UnstableApi
    void x0(EventTime eventTime, int i2);

    @UnstableApi
    void y(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    @UnstableApi
    void y0(EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z2);

    @UnstableApi
    void z(EventTime eventTime, boolean z2, int i2);

    @UnstableApi
    void z0(EventTime eventTime, long j2);
}
