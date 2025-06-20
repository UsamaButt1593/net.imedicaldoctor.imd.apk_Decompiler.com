package androidx.media3.exoplayer.analytics;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.CallSuper;
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
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.drm.C0296j;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public class DefaultAnalyticsCollector implements AnalyticsCollector {
    private final Timeline.Period X;
    private final SparseArray<AnalyticsListener.EventTime> X2;
    private final Timeline.Window Y = new Timeline.Window();
    private ListenerSet<AnalyticsListener> Y2;
    private final MediaPeriodQueueTracker Z;
    private Player Z2;
    private HandlerWrapper a3;
    private boolean b3;
    private final Clock s;

    private static final class MediaPeriodQueueTracker {

        /* renamed from: a  reason: collision with root package name */
        private final Timeline.Period f10526a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public ImmutableList<MediaSource.MediaPeriodId> f10527b = ImmutableList.I();

        /* renamed from: c  reason: collision with root package name */
        private ImmutableMap<MediaSource.MediaPeriodId, Timeline> f10528c = ImmutableMap.s();
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private MediaSource.MediaPeriodId f10529d;

        /* renamed from: e  reason: collision with root package name */
        private MediaSource.MediaPeriodId f10530e;

        /* renamed from: f  reason: collision with root package name */
        private MediaSource.MediaPeriodId f10531f;

        public MediaPeriodQueueTracker(Timeline.Period period) {
            this.f10526a = period;
        }

        private void b(ImmutableMap.Builder<MediaSource.MediaPeriodId, Timeline> builder, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            if (mediaPeriodId != null) {
                if (timeline.g(mediaPeriodId.f12163a) != -1 || (timeline = this.f10528c.get(mediaPeriodId)) != null) {
                    builder.i(mediaPeriodId, timeline);
                }
            }
        }

        @Nullable
        private static MediaSource.MediaPeriodId c(Player player, ImmutableList<MediaSource.MediaPeriodId> immutableList, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Timeline.Period period) {
            Timeline j2 = player.j2();
            int B0 = player.B0();
            Object t = j2.x() ? null : j2.t(B0);
            int g2 = (player.c0() || j2.x()) ? -1 : j2.k(B0, period).g(Util.I1(player.z2()) - period.s());
            for (int i2 = 0; i2 < immutableList.size(); i2++) {
                MediaSource.MediaPeriodId mediaPeriodId2 = immutableList.get(i2);
                if (i(mediaPeriodId2, t, player.c0(), player.O1(), player.O0(), g2)) {
                    return mediaPeriodId2;
                }
            }
            if (immutableList.isEmpty() && mediaPeriodId != null) {
                if (i(mediaPeriodId, t, player.c0(), player.O1(), player.O0(), g2)) {
                    return mediaPeriodId;
                }
            }
            return null;
        }

        private static boolean i(MediaSource.MediaPeriodId mediaPeriodId, @Nullable Object obj, boolean z, int i2, int i3, int i4) {
            if (!mediaPeriodId.f12163a.equals(obj)) {
                return false;
            }
            return (z && mediaPeriodId.f12164b == i2 && mediaPeriodId.f12165c == i3) || (!z && mediaPeriodId.f12164b == -1 && mediaPeriodId.f12167e == i4);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0059, code lost:
            if (r3.f10527b.contains(r3.f10529d) == false) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0032, code lost:
            if (com.google.common.base.Objects.a(r3.f10529d, r3.f10531f) == false) goto L_0x0034;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void m(androidx.media3.common.Timeline r4) {
            /*
                r3 = this;
                com.google.common.collect.ImmutableMap$Builder r0 = com.google.common.collect.ImmutableMap.b()
                com.google.common.collect.ImmutableList<androidx.media3.exoplayer.source.MediaSource$MediaPeriodId> r1 = r3.f10527b
                boolean r1 = r1.isEmpty()
                if (r1 == 0) goto L_0x003a
                androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r1 = r3.f10530e
                r3.b(r0, r1, r4)
                androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r1 = r3.f10531f
                androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r3.f10530e
                boolean r1 = com.google.common.base.Objects.a(r1, r2)
                if (r1 != 0) goto L_0x0020
                androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r1 = r3.f10531f
                r3.b(r0, r1, r4)
            L_0x0020:
                androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r1 = r3.f10529d
                androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r3.f10530e
                boolean r1 = com.google.common.base.Objects.a(r1, r2)
                if (r1 != 0) goto L_0x005c
                androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r1 = r3.f10529d
                androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r3.f10531f
                boolean r1 = com.google.common.base.Objects.a(r1, r2)
                if (r1 != 0) goto L_0x005c
            L_0x0034:
                androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r1 = r3.f10529d
                r3.b(r0, r1, r4)
                goto L_0x005c
            L_0x003a:
                r1 = 0
            L_0x003b:
                com.google.common.collect.ImmutableList<androidx.media3.exoplayer.source.MediaSource$MediaPeriodId> r2 = r3.f10527b
                int r2 = r2.size()
                if (r1 >= r2) goto L_0x0051
                com.google.common.collect.ImmutableList<androidx.media3.exoplayer.source.MediaSource$MediaPeriodId> r2 = r3.f10527b
                java.lang.Object r2 = r2.get(r1)
                androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = (androidx.media3.exoplayer.source.MediaSource.MediaPeriodId) r2
                r3.b(r0, r2, r4)
                int r1 = r1 + 1
                goto L_0x003b
            L_0x0051:
                com.google.common.collect.ImmutableList<androidx.media3.exoplayer.source.MediaSource$MediaPeriodId> r1 = r3.f10527b
                androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r3.f10529d
                boolean r1 = r1.contains(r2)
                if (r1 != 0) goto L_0x005c
                goto L_0x0034
            L_0x005c:
                com.google.common.collect.ImmutableMap r4 = r0.d()
                r3.f10528c = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector.MediaPeriodQueueTracker.m(androidx.media3.common.Timeline):void");
        }

        @Nullable
        public MediaSource.MediaPeriodId d() {
            return this.f10529d;
        }

        @Nullable
        public MediaSource.MediaPeriodId e() {
            if (this.f10527b.isEmpty()) {
                return null;
            }
            return (MediaSource.MediaPeriodId) Iterables.w(this.f10527b);
        }

        @Nullable
        public Timeline f(MediaSource.MediaPeriodId mediaPeriodId) {
            return this.f10528c.get(mediaPeriodId);
        }

        @Nullable
        public MediaSource.MediaPeriodId g() {
            return this.f10530e;
        }

        @Nullable
        public MediaSource.MediaPeriodId h() {
            return this.f10531f;
        }

        public void j(Player player) {
            this.f10529d = c(player, this.f10527b, this.f10530e, this.f10526a);
        }

        public void k(List<MediaSource.MediaPeriodId> list, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Player player) {
            this.f10527b = ImmutableList.B(list);
            if (!list.isEmpty()) {
                this.f10530e = list.get(0);
                this.f10531f = (MediaSource.MediaPeriodId) Assertions.g(mediaPeriodId);
            }
            if (this.f10529d == null) {
                this.f10529d = c(player, this.f10527b, this.f10530e, this.f10526a);
            }
            m(player.j2());
        }

        public void l(Player player) {
            this.f10529d = c(player, this.f10527b, this.f10530e, this.f10526a);
            m(player.j2());
        }
    }

    public DefaultAnalyticsCollector(Clock clock) {
        this.s = (Clock) Assertions.g(clock);
        this.Y2 = new ListenerSet<>(Util.l0(), clock, new G());
        Timeline.Period period = new Timeline.Period();
        this.X = period;
        this.Z = new MediaPeriodQueueTracker(period);
        this.X2 = new SparseArray<>();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void D2(AnalyticsListener.EventTime eventTime, boolean z, AnalyticsListener analyticsListener) {
        analyticsListener.t(eventTime, z);
        analyticsListener.c(eventTime, z);
    }

    private AnalyticsListener.EventTime U1(@Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.g(this.Z2);
        Timeline f2 = mediaPeriodId == null ? null : this.Z.f(mediaPeriodId);
        if (mediaPeriodId != null && f2 != null) {
            return T1(f2, f2.m(mediaPeriodId.f12163a, this.X).Y, mediaPeriodId);
        }
        int P1 = this.Z2.P1();
        Timeline j2 = this.Z2.j2();
        if (P1 >= j2.w()) {
            j2 = Timeline.s;
        }
        return T1(j2, P1, (MediaSource.MediaPeriodId) null);
    }

    private AnalyticsListener.EventTime V1() {
        return U1(this.Z.e());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void V2(AnalyticsListener.EventTime eventTime, int i2, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, AnalyticsListener analyticsListener) {
        analyticsListener.w(eventTime, i2);
        analyticsListener.l0(eventTime, positionInfo, positionInfo2, i2);
    }

    private AnalyticsListener.EventTime W1(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.g(this.Z2);
        if (mediaPeriodId != null) {
            return this.Z.f(mediaPeriodId) != null ? U1(mediaPeriodId) : T1(Timeline.s, i2, mediaPeriodId);
        }
        Timeline j2 = this.Z2.j2();
        if (i2 >= j2.w()) {
            j2 = Timeline.s;
        }
        return T1(j2, i2, (MediaSource.MediaPeriodId) null);
    }

    private AnalyticsListener.EventTime X1() {
        return U1(this.Z.g());
    }

    private AnalyticsListener.EventTime Y1() {
        return U1(this.Z.h());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = ((androidx.media3.exoplayer.ExoPlaybackException) r2).U3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.media3.exoplayer.analytics.AnalyticsListener.EventTime Z1(@androidx.annotation.Nullable androidx.media3.common.PlaybackException r2) {
        /*
            r1 = this;
            boolean r0 = r2 instanceof androidx.media3.exoplayer.ExoPlaybackException
            if (r0 == 0) goto L_0x000f
            androidx.media3.exoplayer.ExoPlaybackException r2 = (androidx.media3.exoplayer.ExoPlaybackException) r2
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r2.U3
            if (r2 == 0) goto L_0x000f
            androidx.media3.exoplayer.analytics.AnalyticsListener$EventTime r2 = r1.U1(r2)
            return r2
        L_0x000f:
            androidx.media3.exoplayer.analytics.AnalyticsListener$EventTime r2 = r1.S1()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector.Z1(androidx.media3.common.PlaybackException):androidx.media3.exoplayer.analytics.AnalyticsListener$EventTime");
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void a2(AnalyticsListener analyticsListener, FlagSet flagSet) {
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e2(AnalyticsListener.EventTime eventTime, String str, long j2, long j3, AnalyticsListener analyticsListener) {
        analyticsListener.a(eventTime, str, j2);
        analyticsListener.R(eventTime, str, j3, j2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void i2(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.A(eventTime, format);
        analyticsListener.C0(eventTime, format, decoderReuseEvaluation);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void i3(AnalyticsListener.EventTime eventTime, String str, long j2, long j3, AnalyticsListener analyticsListener) {
        analyticsListener.I(eventTime, str, j2);
        analyticsListener.S(eventTime, str, j3, j2);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void n3(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.G(eventTime, format);
        analyticsListener.t0(eventTime, format, decoderReuseEvaluation);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void o3(AnalyticsListener.EventTime eventTime, VideoSize videoSize, AnalyticsListener analyticsListener) {
        analyticsListener.W(eventTime, videoSize);
        analyticsListener.s(eventTime, videoSize.s, videoSize.X, videoSize.Y, videoSize.Z);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r3(Player player, AnalyticsListener analyticsListener, FlagSet flagSet) {
        analyticsListener.f0(player, new AnalyticsListener.Events(flagSet, this.X2));
    }

    /* access modifiers changed from: private */
    public void s3() {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, AnalyticsListener.h0, new C0209c(S1));
        this.Y2.k();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void z2(AnalyticsListener.EventTime eventTime, int i2, AnalyticsListener analyticsListener) {
        analyticsListener.x(eventTime);
        analyticsListener.m0(eventTime, i2);
    }

    public final void A(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime W1 = W1(i2, mediaPeriodId);
        t3(W1, AnalyticsListener.K, new C0222i0(W1, mediaLoadData));
    }

    public final void B(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime X1 = X1();
        t3(X1, 1013, new L(X1, decoderCounters));
    }

    public final void C(long j2, int i2) {
        AnalyticsListener.EventTime X1 = X1();
        t3(X1, 1021, new H(X1, j2, i2));
    }

    public final void D(int i2) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 6, new C0254z(S1, i2));
    }

    public void E(boolean z) {
    }

    public void F(int i2) {
    }

    public final void G(List<MediaSource.MediaPeriodId> list, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        this.Z.k(list, mediaPeriodId, (Player) Assertions.g(this.Z2));
    }

    public final void H(boolean z) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 3, new C0215f(S1, z));
    }

    public void I(Player player, Player.Events events) {
    }

    @CallSuper
    public void J(AnalyticsListener analyticsListener) {
        Assertions.g(analyticsListener);
        this.Y2.c(analyticsListener);
    }

    public final void K(float f2) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 22, new C0231n(Y1, f2));
    }

    public final void L(int i2) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 21, new X(Y1, i2));
    }

    public final void M(int i2) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 4, new M(S1, i2));
    }

    public final void N(AudioAttributes audioAttributes) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 20, new C0242t(Y1, audioAttributes));
    }

    public final void O(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime W1 = W1(i2, mediaPeriodId);
        t3(W1, 1001, new S(W1, loadEventInfo, mediaLoadData));
    }

    public final void P(int i2, long j2, long j3) {
        AnalyticsListener.EventTime V1 = V1();
        t3(V1, 1006, new C0229m(V1, i2, j2, j3));
    }

    public final void Q(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime W1 = W1(i2, mediaPeriodId);
        t3(W1, 1004, new I(W1, mediaLoadData));
    }

    public final void R(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime W1 = W1(i2, mediaPeriodId);
        t3(W1, 1025, new W(W1));
    }

    public final void S(Timeline timeline, int i2) {
        this.Z.l((Player) Assertions.g(this.Z2));
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 0, new C0223j(S1, i2));
    }

    /* access modifiers changed from: protected */
    public final AnalyticsListener.EventTime S1() {
        return U1(this.Z.d());
    }

    public final void T() {
        if (!this.b3) {
            AnalyticsListener.EventTime S1 = S1();
            this.b3 = true;
            t3(S1, -1, new C0206a0(S1));
        }
    }

    /* access modifiers changed from: protected */
    @RequiresNonNull({"player"})
    public final AnalyticsListener.EventTime T1(Timeline timeline, int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline2 = timeline;
        int i3 = i2;
        MediaSource.MediaPeriodId mediaPeriodId2 = timeline.x() ? null : mediaPeriodId;
        long b2 = this.s.b();
        boolean z = timeline2.equals(this.Z2.j2()) && i3 == this.Z2.P1();
        long j2 = 0;
        if (mediaPeriodId2 == null || !mediaPeriodId2.c()) {
            if (z) {
                j2 = this.Z2.n1();
            } else if (!timeline.x()) {
                j2 = timeline2.u(i3, this.Y).d();
            }
        } else if (z && this.Z2.O1() == mediaPeriodId2.f12164b && this.Z2.O0() == mediaPeriodId2.f12165c) {
            j2 = this.Z2.z2();
        }
        return new AnalyticsListener.EventTime(b2, timeline, i2, mediaPeriodId2, j2, this.Z2.j2(), this.Z2.P1(), this.Z.d(), this.Z2.z2(), this.Z2.h0());
    }

    public final void U(boolean z) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 9, new C0236p0(S1, z));
    }

    public final void V(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime W1 = W1(i2, mediaPeriodId);
        t3(W1, 1000, new C0219h(W1, loadEventInfo, mediaLoadData));
    }

    public void W(int i2, boolean z) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 30, new D(S1, i2, z));
    }

    public final void X(boolean z, int i2) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, -1, new C0240s(S1, z, i2));
    }

    public void Y(long j2) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 16, new C0241s0(S1, j2));
    }

    public void Z(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 14, new C0238q0(S1, mediaMetadata));
    }

    @CallSuper
    public void a() {
        ((HandlerWrapper) Assertions.k(this.a3)).e(new C0214e0(this));
    }

    public void a0(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 15, new Y(S1, mediaMetadata));
    }

    public void b(AudioSink.AudioTrackConfig audioTrackConfig) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, AnalyticsListener.k0, new V(Y1, audioTrackConfig));
    }

    public void b0(long j2) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 17, new C0213e(S1, j2));
    }

    public final void c(VideoSize videoSize) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 25, new Z(Y1, videoSize));
    }

    public final void c0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime W1 = W1(i2, mediaPeriodId);
        t3(W1, AnalyticsListener.c0, new C0228l0(W1));
    }

    public void d(AudioSink.AudioTrackConfig audioTrackConfig) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, AnalyticsListener.l0, new C0230m0(Y1, audioTrackConfig));
    }

    public void d0(TrackSelectionParameters trackSelectionParameters) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 19, new C0245u0(S1, trackSelectionParameters));
    }

    public final void e(boolean z) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 23, new C0227l(Y1, z));
    }

    public void e0() {
    }

    public final void f(Exception exc) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 1014, new C0234o0(Y1, exc));
    }

    public void f0(Tracks tracks) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 2, new C0250x(S1, tracks));
    }

    public final void g(String str) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 1019, new A(Y1, str));
    }

    public void g0(DeviceInfo deviceInfo) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 29, new O(S1, deviceInfo));
    }

    public final void h(String str, long j2, long j3) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 1016, new C0226k0(Y1, str, j3, j2));
    }

    public final void h0(@Nullable MediaItem mediaItem, int i2) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 1, new C0225k(S1, mediaItem, i2));
    }

    public final void i(String str) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 1012, new C0217g(Y1, str));
    }

    @CallSuper
    public void i0(AnalyticsListener analyticsListener) {
        this.Y2.l(analyticsListener);
    }

    public final void j(String str, long j2, long j3) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 1008, new C0252y(Y1, str, j3, j2));
    }

    public void j0(@Nullable PlaybackException playbackException) {
        AnalyticsListener.EventTime Z1 = Z1(playbackException);
        t3(Z1, 10, new C(Z1, playbackException));
    }

    public final void k(PlaybackParameters playbackParameters) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 12, new C0207b(S1, playbackParameters));
    }

    public void k0(long j2) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 18, new C0243t0(S1, j2));
    }

    public final void l(int i2, long j2) {
        AnalyticsListener.EventTime X1 = X1();
        t3(X1, 1018, new B(X1, i2, j2));
    }

    public final void l0(boolean z, int i2) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 5, new E(S1, z, i2));
    }

    public final void m(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 1007, new C0211d(Y1, decoderCounters));
    }

    public final void m0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime W1 = W1(i2, mediaPeriodId);
        t3(W1, AnalyticsListener.g0, new C0232n0(W1));
    }

    public final void n(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 1015, new C0212d0(Y1, decoderCounters));
    }

    @CallSuper
    public void n0(Player player, Looper looper) {
        Assertions.i(this.Z2 == null || this.Z.f10527b.isEmpty());
        this.Z2 = (Player) Assertions.g(player);
        this.a3 = this.s.e(looper, (Handler.Callback) null);
        this.Y2 = this.Y2.f(looper, new r(this, player));
    }

    public final void o(Object obj, long j2) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 26, new C0220h0(Y1, obj, j2));
    }

    public final void o0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, int i3) {
        AnalyticsListener.EventTime W1 = W1(i2, mediaPeriodId);
        t3(W1, AnalyticsListener.b0, new N(W1, i3));
    }

    public void p(CueGroup cueGroup) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 27, new C0216f0(S1, cueGroup));
    }

    public final void p0(PlaybackException playbackException) {
        AnalyticsListener.EventTime Z1 = Z1(playbackException);
        t3(Z1, 10, new K(Z1, playbackException));
    }

    public final void q(Metadata metadata) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 28, new C0244u(S1, metadata));
    }

    public final void q0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        AnalyticsListener.EventTime W1 = W1(i2, mediaPeriodId);
        t3(W1, 1003, new C0237q(W1, loadEventInfo, mediaLoadData, iOException, z));
    }

    public final void r(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 1017, new T(Y1, format, decoderReuseEvaluation));
    }

    public /* synthetic */ void r0(int i2, MediaSource.MediaPeriodId mediaPeriodId) {
        C0296j.d(this, i2, mediaPeriodId);
    }

    public void s(List<Cue> list) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 27, new F(S1, list));
    }

    public final void s0(int i2, int i3) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 24, new C0239r0(Y1, i2, i3));
    }

    public final void t(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime X1 = X1();
        t3(X1, 1020, new U(X1, decoderCounters));
    }

    public void t0(Player.Commands commands) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 13, new C0221i(S1, commands));
    }

    /* access modifiers changed from: protected */
    public final void t3(AnalyticsListener.EventTime eventTime, int i2, ListenerSet.Event<AnalyticsListener> event) {
        this.X2.put(i2, eventTime);
        this.Y2.m(i2, event);
    }

    public final void u(long j2) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 1010, new C0246v(Y1, j2));
    }

    public final void u0(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
        if (i2 == 1) {
            this.b3 = false;
        }
        this.Z.j((Player) Assertions.g(this.Z2));
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 11, new C0210c0(S1, i2, positionInfo, positionInfo2));
    }

    @Deprecated
    public void u3(boolean z) {
        this.Y2.n(z);
    }

    public final void v(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 1009, new C0208b0(Y1, format, decoderReuseEvaluation));
    }

    public final void v0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime W1 = W1(i2, mediaPeriodId);
        t3(W1, AnalyticsListener.f0, new P(W1));
    }

    public final void w(Exception exc) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, AnalyticsListener.i0, new C0224j0(Y1, exc));
    }

    public final void w0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        AnalyticsListener.EventTime W1 = W1(i2, mediaPeriodId);
        t3(W1, 1024, new Q(W1, exc));
    }

    public final void x(int i2) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 8, new C0218g0(S1, i2));
    }

    public final void x0(int i2, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime W1 = W1(i2, mediaPeriodId);
        t3(W1, 1002, new J(W1, loadEventInfo, mediaLoadData));
    }

    public final void y(Exception exc) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, AnalyticsListener.j0, new C0233o(Y1, exc));
    }

    public void y0(boolean z) {
        AnalyticsListener.EventTime S1 = S1();
        t3(S1, 7, new C0248w(S1, z));
    }

    public final void z(int i2, long j2, long j3) {
        AnalyticsListener.EventTime Y1 = Y1();
        t3(Y1, 1011, new C0235p(Y1, i2, j2, j3));
    }
}
