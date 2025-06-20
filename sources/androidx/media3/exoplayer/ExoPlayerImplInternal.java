package androidx.media3.exoplayer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Timeline;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DefaultMediaClock;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.metadata.MetadataRenderer;
import androidx.media3.exoplayer.source.MediaPeriod;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.SampleStream;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.text.TextRenderer;
import androidx.media3.exoplayer.trackselection.ExoTrackSelection;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

final class ExoPlayerImplInternal implements Handler.Callback, MediaPeriod.Callback, TrackSelector.InvalidationListener, MediaSourceList.MediaSourceListInfoRefreshListener, DefaultMediaClock.PlaybackParametersListener, PlayerMessage.Sender {
    private static final String L3 = "ExoPlayerImplInternal";
    private static final int M3 = 0;
    private static final int N3 = 1;
    private static final int O3 = 2;
    private static final int P3 = 3;
    private static final int Q3 = 4;
    private static final int R3 = 5;
    private static final int S3 = 6;
    private static final int T3 = 7;
    private static final int U3 = 8;
    private static final int V3 = 9;
    private static final int W3 = 10;
    private static final int X3 = 11;
    private static final int Y3 = 12;
    private static final int Z3 = 13;
    private static final int a4 = 14;
    private static final int b4 = 15;
    private static final int c4 = 16;
    private static final int d4 = 17;
    private static final int e4 = 18;
    private static final int f4 = 19;
    private static final int g4 = 20;
    private static final int h4 = 21;
    private static final int i4 = 22;
    private static final int j4 = 23;
    private static final int k4 = 25;
    private static final int l4 = 26;
    private static final int m4 = 27;
    private static final int n4 = 10;
    private static final int o4 = 1000;
    private static final long p4 = 4000;
    private static final long q4 = 500000;
    private boolean A3;
    /* access modifiers changed from: private */
    public boolean B3;
    private boolean C3;
    private int D3;
    @Nullable
    private SeekPosition E3;
    private long F3;
    private int G3;
    private boolean H3;
    @Nullable
    private ExoPlaybackException I3;
    private long J3;
    private long K3 = C.f9084b;
    private final Set<Renderer> X;
    private final TrackSelectorResult X2;
    private final RendererCapabilities[] Y;
    private final LoadControl Y2;
    private final TrackSelector Z;
    private final BandwidthMeter Z2;
    /* access modifiers changed from: private */
    public final HandlerWrapper a3;
    @Nullable
    private final HandlerThread b3;
    private final Looper c3;
    private final Timeline.Window d3;
    private final Timeline.Period e3;
    private final long f3;
    private final boolean g3;
    private final DefaultMediaClock h3;
    private final ArrayList<PendingMessageInfo> i3;
    private final Clock j3;
    private final PlaybackInfoUpdateListener k3;
    private final MediaPeriodQueue l3;
    private final MediaSourceList m3;
    private final LivePlaybackSpeedControl n3;
    private final long o3;
    private SeekParameters p3;
    private PlaybackInfo q3;
    private PlaybackInfoUpdate r3;
    private final Renderer[] s;
    private boolean s3;
    private boolean t3;
    private boolean u3;
    private boolean v3;
    private long w3 = C.f9084b;
    private boolean x3;
    private int y3;
    private boolean z3;

    private static final class MediaSourceListUpdateMessage {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final List<MediaSourceList.MediaSourceHolder> f10201a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final ShuffleOrder f10202b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public final int f10203c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final long f10204d;

        private MediaSourceListUpdateMessage(List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder, int i2, long j2) {
            this.f10201a = list;
            this.f10202b = shuffleOrder;
            this.f10203c = i2;
            this.f10204d = j2;
        }
    }

    private static class MoveMediaItemsMessage {

        /* renamed from: a  reason: collision with root package name */
        public final int f10205a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10206b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10207c;

        /* renamed from: d  reason: collision with root package name */
        public final ShuffleOrder f10208d;

        public MoveMediaItemsMessage(int i2, int i3, int i4, ShuffleOrder shuffleOrder) {
            this.f10205a = i2;
            this.f10206b = i3;
            this.f10207c = i4;
            this.f10208d = shuffleOrder;
        }
    }

    private static final class PendingMessageInfo implements Comparable<PendingMessageInfo> {
        public int X;
        public long Y;
        @Nullable
        public Object Z;
        public final PlayerMessage s;

        public PendingMessageInfo(PlayerMessage playerMessage) {
            this.s = playerMessage;
        }

        /* renamed from: a */
        public int compareTo(PendingMessageInfo pendingMessageInfo) {
            Object obj = this.Z;
            if ((obj == null) != (pendingMessageInfo.Z == null)) {
                return obj != null ? -1 : 1;
            }
            if (obj == null) {
                return 0;
            }
            int i2 = this.X - pendingMessageInfo.X;
            return i2 != 0 ? i2 : Util.u(this.Y, pendingMessageInfo.Y);
        }

        public void b(int i2, long j2, Object obj) {
            this.X = i2;
            this.Y = j2;
            this.Z = obj;
        }
    }

    public static final class PlaybackInfoUpdate {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public boolean f10209a;

        /* renamed from: b  reason: collision with root package name */
        public PlaybackInfo f10210b;

        /* renamed from: c  reason: collision with root package name */
        public int f10211c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f10212d;

        /* renamed from: e  reason: collision with root package name */
        public int f10213e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f10214f;

        /* renamed from: g  reason: collision with root package name */
        public int f10215g;

        public PlaybackInfoUpdate(PlaybackInfo playbackInfo) {
            this.f10210b = playbackInfo;
        }

        public void b(int i2) {
            this.f10209a |= i2 > 0;
            this.f10211c += i2;
        }

        public void c(int i2) {
            this.f10209a = true;
            this.f10214f = true;
            this.f10215g = i2;
        }

        public void d(PlaybackInfo playbackInfo) {
            this.f10209a |= this.f10210b != playbackInfo;
            this.f10210b = playbackInfo;
        }

        public void e(int i2) {
            boolean z = true;
            if (!this.f10212d || this.f10213e == 5) {
                this.f10209a = true;
                this.f10212d = true;
                this.f10213e = i2;
                return;
            }
            if (i2 != 5) {
                z = false;
            }
            Assertions.a(z);
        }
    }

    public interface PlaybackInfoUpdateListener {
        void a(PlaybackInfoUpdate playbackInfoUpdate);
    }

    private static final class PositionUpdateForPlaylistChange {

        /* renamed from: a  reason: collision with root package name */
        public final MediaSource.MediaPeriodId f10216a;

        /* renamed from: b  reason: collision with root package name */
        public final long f10217b;

        /* renamed from: c  reason: collision with root package name */
        public final long f10218c;

        /* renamed from: d  reason: collision with root package name */
        public final boolean f10219d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f10220e;

        /* renamed from: f  reason: collision with root package name */
        public final boolean f10221f;

        public PositionUpdateForPlaylistChange(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j3, boolean z, boolean z2, boolean z3) {
            this.f10216a = mediaPeriodId;
            this.f10217b = j2;
            this.f10218c = j3;
            this.f10219d = z;
            this.f10220e = z2;
            this.f10221f = z3;
        }
    }

    private static final class SeekPosition {

        /* renamed from: a  reason: collision with root package name */
        public final Timeline f10222a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10223b;

        /* renamed from: c  reason: collision with root package name */
        public final long f10224c;

        public SeekPosition(Timeline timeline, int i2, long j2) {
            this.f10222a = timeline;
            this.f10223b = i2;
            this.f10224c = j2;
        }
    }

    public ExoPlayerImplInternal(Renderer[] rendererArr, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int i2, boolean z, AnalyticsCollector analyticsCollector, SeekParameters seekParameters, LivePlaybackSpeedControl livePlaybackSpeedControl, long j2, boolean z2, Looper looper, Clock clock, PlaybackInfoUpdateListener playbackInfoUpdateListener, PlayerId playerId, Looper looper2) {
        Renderer[] rendererArr2 = rendererArr;
        BandwidthMeter bandwidthMeter2 = bandwidthMeter;
        AnalyticsCollector analyticsCollector2 = analyticsCollector;
        long j5 = j2;
        Clock clock2 = clock;
        PlayerId playerId2 = playerId;
        Looper looper3 = looper2;
        this.k3 = playbackInfoUpdateListener;
        this.s = rendererArr2;
        this.Z = trackSelector;
        this.X2 = trackSelectorResult;
        this.Y2 = loadControl;
        this.Z2 = bandwidthMeter2;
        this.y3 = i2;
        this.z3 = z;
        this.p3 = seekParameters;
        this.n3 = livePlaybackSpeedControl;
        this.o3 = j5;
        this.J3 = j5;
        this.t3 = z2;
        this.j3 = clock2;
        this.f3 = loadControl.f();
        this.g3 = loadControl.c();
        PlaybackInfo k2 = PlaybackInfo.k(trackSelectorResult);
        this.q3 = k2;
        this.r3 = new PlaybackInfoUpdate(k2);
        this.Y = new RendererCapabilities[rendererArr2.length];
        RendererCapabilities.Listener d2 = trackSelector.d();
        for (int i5 = 0; i5 < rendererArr2.length; i5++) {
            rendererArr2[i5].o(i5, playerId2, clock2);
            this.Y[i5] = rendererArr2[i5].s();
            if (d2 != null) {
                this.Y[i5].t(d2);
            }
        }
        this.h3 = new DefaultMediaClock(this, clock2);
        this.i3 = new ArrayList<>();
        this.X = Sets.z();
        this.d3 = new Timeline.Window();
        this.e3 = new Timeline.Period();
        trackSelector.e(this, bandwidthMeter2);
        this.H3 = true;
        HandlerWrapper e2 = clock2.e(looper, (Handler.Callback) null);
        this.l3 = new MediaPeriodQueue(analyticsCollector2, e2, new C0(this));
        this.m3 = new MediaSourceList(this, analyticsCollector2, e2, playerId2);
        if (looper3 != null) {
            this.b3 = null;
            this.c3 = looper3;
        } else {
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
            this.b3 = handlerThread;
            handlerThread.start();
            this.c3 = handlerThread.getLooper();
        }
        this.a3 = clock2.e(this.c3, this);
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0116  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:67:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void A0(boolean r33, boolean r34, boolean r35, boolean r36) {
        /*
            r32 = this;
            r1 = r32
            androidx.media3.common.util.HandlerWrapper r0 = r1.a3
            r2 = 2
            r0.l(r2)
            r2 = 0
            r1.I3 = r2
            r3 = 0
            r4 = 1
            r1.F1(r3, r4)
            androidx.media3.exoplayer.DefaultMediaClock r0 = r1.h3
            r0.g()
            r5 = 1000000000000(0xe8d4a51000, double:4.94065645841E-312)
            r1.F3 = r5
            androidx.media3.exoplayer.Renderer[] r5 = r1.s
            int r6 = r5.length
            r7 = 0
        L_0x0020:
            java.lang.String r8 = "ExoPlayerImplInternal"
            if (r7 >= r6) goto L_0x0035
            r0 = r5[r7]
            r1.u(r0)     // Catch:{ ExoPlaybackException -> 0x002c, RuntimeException -> 0x002a }
            goto L_0x0032
        L_0x002a:
            r0 = move-exception
            goto L_0x002d
        L_0x002c:
            r0 = move-exception
        L_0x002d:
            java.lang.String r9 = "Disable failed."
            androidx.media3.common.util.Log.e(r8, r9, r0)
        L_0x0032:
            int r7 = r7 + 1
            goto L_0x0020
        L_0x0035:
            if (r33 == 0) goto L_0x0055
            androidx.media3.exoplayer.Renderer[] r5 = r1.s
            int r6 = r5.length
            r7 = 0
        L_0x003b:
            if (r7 >= r6) goto L_0x0055
            r0 = r5[r7]
            java.util.Set<androidx.media3.exoplayer.Renderer> r9 = r1.X
            boolean r9 = r9.remove(r0)
            if (r9 == 0) goto L_0x0052
            r0.reset()     // Catch:{ RuntimeException -> 0x004b }
            goto L_0x0052
        L_0x004b:
            r0 = move-exception
            r9 = r0
            java.lang.String r0 = "Reset failed."
            androidx.media3.common.util.Log.e(r8, r0, r9)
        L_0x0052:
            int r7 = r7 + 1
            goto L_0x003b
        L_0x0055:
            r1.D3 = r3
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.q3
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r5 = r0.f10305b
            long r6 = r0.r
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.q3
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r0 = r0.f10305b
            boolean r0 = r0.c()
            if (r0 != 0) goto L_0x0077
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.q3
            androidx.media3.common.Timeline$Period r8 = r1.e3
            boolean r0 = Y(r0, r8)
            if (r0 == 0) goto L_0x0072
            goto L_0x0077
        L_0x0072:
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.q3
            long r8 = r0.r
            goto L_0x007b
        L_0x0077:
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.q3
            long r8 = r0.f10306c
        L_0x007b:
            if (r34 == 0) goto L_0x00a6
            r1.E3 = r2
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.q3
            androidx.media3.common.Timeline r0 = r0.f10304a
            android.util.Pair r0 = r1.G(r0)
            java.lang.Object r5 = r0.first
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r5 = (androidx.media3.exoplayer.source.MediaSource.MediaPeriodId) r5
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r6 = r0.longValue()
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.q3
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r0 = r0.f10305b
            boolean r0 = r5.equals(r0)
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 != 0) goto L_0x00a6
            r27 = r6
            r9 = r8
            goto L_0x00aa
        L_0x00a6:
            r27 = r6
            r9 = r8
            r4 = 0
        L_0x00aa:
            androidx.media3.exoplayer.MediaPeriodQueue r0 = r1.l3
            r0.f()
            r1.x3 = r3
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.q3
            androidx.media3.common.Timeline r0 = r0.f10304a
            if (r35 == 0) goto L_0x00f0
            boolean r3 = r0 instanceof androidx.media3.exoplayer.PlaylistTimeline
            if (r3 == 0) goto L_0x00f0
            androidx.media3.exoplayer.PlaylistTimeline r0 = (androidx.media3.exoplayer.PlaylistTimeline) r0
            androidx.media3.exoplayer.MediaSourceList r3 = r1.m3
            androidx.media3.exoplayer.source.ShuffleOrder r3 = r3.r()
            androidx.media3.exoplayer.PlaylistTimeline r0 = r0.L(r3)
            int r3 = r5.f12164b
            r6 = -1
            if (r3 == r6) goto L_0x00f0
            java.lang.Object r3 = r5.f12163a
            androidx.media3.common.Timeline$Period r6 = r1.e3
            r0.m(r3, r6)
            androidx.media3.common.Timeline$Period r3 = r1.e3
            int r3 = r3.Y
            androidx.media3.common.Timeline$Window r6 = r1.d3
            androidx.media3.common.Timeline$Window r3 = r0.u(r3, r6)
            boolean r3 = r3.j()
            if (r3 == 0) goto L_0x00f0
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = new androidx.media3.exoplayer.source.MediaSource$MediaPeriodId
            java.lang.Object r6 = r5.f12163a
            long r7 = r5.f12166d
            r3.<init>(r6, r7)
            r7 = r0
            r19 = r3
            goto L_0x00f3
        L_0x00f0:
            r7 = r0
            r19 = r5
        L_0x00f3:
            androidx.media3.exoplayer.PlaybackInfo r0 = new androidx.media3.exoplayer.PlaybackInfo
            androidx.media3.exoplayer.PlaybackInfo r3 = r1.q3
            int r13 = r3.f10308e
            if (r36 == 0) goto L_0x00fd
        L_0x00fb:
            r14 = r2
            goto L_0x0100
        L_0x00fd:
            androidx.media3.exoplayer.ExoPlaybackException r2 = r3.f10309f
            goto L_0x00fb
        L_0x0100:
            if (r4 == 0) goto L_0x0107
            androidx.media3.exoplayer.source.TrackGroupArray r2 = androidx.media3.exoplayer.source.TrackGroupArray.X2
        L_0x0104:
            r16 = r2
            goto L_0x010a
        L_0x0107:
            androidx.media3.exoplayer.source.TrackGroupArray r2 = r3.f10311h
            goto L_0x0104
        L_0x010a:
            if (r4 == 0) goto L_0x0111
            androidx.media3.exoplayer.trackselection.TrackSelectorResult r2 = r1.X2
        L_0x010e:
            r17 = r2
            goto L_0x0114
        L_0x0111:
            androidx.media3.exoplayer.trackselection.TrackSelectorResult r2 = r3.f10312i
            goto L_0x010e
        L_0x0114:
            if (r4 == 0) goto L_0x011d
            com.google.common.collect.ImmutableList r2 = com.google.common.collect.ImmutableList.I()
        L_0x011a:
            r18 = r2
            goto L_0x0120
        L_0x011d:
            java.util.List<androidx.media3.common.Metadata> r2 = r3.f10313j
            goto L_0x011a
        L_0x0120:
            androidx.media3.exoplayer.PlaybackInfo r2 = r1.q3
            boolean r3 = r2.f10315l
            r20 = r3
            int r3 = r2.f10316m
            r21 = r3
            androidx.media3.common.PlaybackParameters r2 = r2.f10317n
            r22 = r2
            r29 = 0
            r31 = 0
            r15 = 0
            r25 = 0
            r6 = r0
            r8 = r19
            r11 = r27
            r23 = r27
            r6.<init>(r7, r8, r9, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r25, r27, r29, r31)
            r1.q3 = r0
            if (r35 == 0) goto L_0x0148
            androidx.media3.exoplayer.MediaSourceList r0 = r1.m3
            r0.B()
        L_0x0148:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.A0(boolean, boolean, boolean, boolean):void");
    }

    private ImmutableList<Metadata> B(ExoTrackSelection[] exoTrackSelectionArr) {
        ImmutableList.Builder builder = new ImmutableList.Builder();
        boolean z = false;
        for (ExoTrackSelection exoTrackSelection : exoTrackSelectionArr) {
            if (exoTrackSelection != null) {
                Metadata metadata = exoTrackSelection.i(0).d3;
                if (metadata == null) {
                    builder.g(new Metadata(new Metadata.Entry[0]));
                } else {
                    builder.g(metadata);
                    z = true;
                }
            }
        }
        return z ? builder.e() : ImmutableList.I();
    }

    private void B0() {
        MediaPeriodHolder r = this.l3.r();
        this.u3 = r != null && r.f10240f.f10256h && this.t3;
    }

    private void B1(int i2, int i5, List<MediaItem> list) throws ExoPlaybackException {
        this.r3.b(1);
        N(this.m3.H(i2, i5, list), false);
    }

    private long C() {
        PlaybackInfo playbackInfo = this.q3;
        return E(playbackInfo.f10304a, playbackInfo.f10305b.f12163a, playbackInfo.r);
    }

    private void C0(long j2) throws ExoPlaybackException {
        MediaPeriodHolder r = this.l3.r();
        long z = r == null ? j2 + MediaPeriodQueue.o : r.z(j2);
        this.F3 = z;
        this.h3.c(z);
        for (Renderer renderer : this.s) {
            if (W(renderer)) {
                renderer.E(this.F3);
            }
        }
        m0();
    }

    private void C1() throws ExoPlaybackException {
        if (!this.q3.f10304a.x() && this.m3.u()) {
            e0();
            h0();
            i0();
            g0();
        }
    }

    private static Format[] D(ExoTrackSelection exoTrackSelection) {
        int length = exoTrackSelection != null ? exoTrackSelection.length() : 0;
        Format[] formatArr = new Format[length];
        for (int i2 = 0; i2 < length; i2++) {
            formatArr[i2] = exoTrackSelection.i(i2);
        }
        return formatArr;
    }

    private static void D0(Timeline timeline, PendingMessageInfo pendingMessageInfo, Timeline.Window window, Timeline.Period period) {
        int i2 = timeline.u(timeline.m(pendingMessageInfo.Z, period).Y, window).i3;
        Object obj = timeline.l(i2, period, true).X;
        long j2 = period.Z;
        pendingMessageInfo.b(i2, j2 != C.f9084b ? j2 - 1 : Long.MAX_VALUE, obj);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void D1() throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r11 = this;
            androidx.media3.exoplayer.MediaPeriodQueue r0 = r11.l3
            androidx.media3.exoplayer.MediaPeriodHolder r0 = r0.r()
            if (r0 != 0) goto L_0x0009
            return
        L_0x0009:
            boolean r1 = r0.f10238d
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 == 0) goto L_0x001a
            androidx.media3.exoplayer.source.MediaPeriod r1 = r0.f10235a
            long r4 = r1.q()
            r6 = r4
            goto L_0x001b
        L_0x001a:
            r6 = r2
        L_0x001b:
            r10 = 0
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x004d
            boolean r1 = r0.q()
            if (r1 != 0) goto L_0x0031
            androidx.media3.exoplayer.MediaPeriodQueue r1 = r11.l3
            r1.D(r0)
            r11.M(r10)
            r11.b0()
        L_0x0031:
            r11.C0(r6)
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3
            long r0 = r0.r
            int r2 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x0081
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r1 = r0.f10305b
            long r4 = r0.f10306c
            r8 = 1
            r9 = 5
        L_0x0044:
            r0 = r11
            r2 = r6
            androidx.media3.exoplayer.PlaybackInfo r0 = r0.R(r1, r2, r4, r6, r8, r9)
            r11.q3 = r0
            goto L_0x0081
        L_0x004d:
            androidx.media3.exoplayer.DefaultMediaClock r1 = r11.h3
            androidx.media3.exoplayer.MediaPeriodQueue r2 = r11.l3
            androidx.media3.exoplayer.MediaPeriodHolder r2 = r2.s()
            if (r0 == r2) goto L_0x0059
            r2 = 1
            goto L_0x005a
        L_0x0059:
            r2 = 0
        L_0x005a:
            long r1 = r1.h(r2)
            r11.F3 = r1
            long r6 = r0.y(r1)
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3
            long r0 = r0.r
            r11.d0(r0, r6)
            androidx.media3.exoplayer.DefaultMediaClock r0 = r11.h3
            boolean r0 = r0.x()
            if (r0 == 0) goto L_0x007c
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r1 = r0.f10305b
            long r4 = r0.f10306c
            r8 = 1
            r9 = 6
            goto L_0x0044
        L_0x007c:
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3
            r0.o(r6)
        L_0x0081:
            androidx.media3.exoplayer.MediaPeriodQueue r0 = r11.l3
            androidx.media3.exoplayer.MediaPeriodHolder r0 = r0.l()
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.q3
            long r2 = r0.i()
            r1.p = r2
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3
            long r1 = r11.I()
            r0.q = r1
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3
            boolean r1 = r0.f10315l
            if (r1 == 0) goto L_0x00ec
            int r1 = r0.f10308e
            r2 = 3
            if (r1 != r2) goto L_0x00ec
            androidx.media3.common.Timeline r1 = r0.f10304a
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r0 = r0.f10305b
            boolean r0 = r11.t1(r1, r0)
            if (r0 == 0) goto L_0x00ec
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3
            androidx.media3.common.PlaybackParameters r0 = r0.f10317n
            float r0 = r0.s
            r1 = 1065353216(0x3f800000, float:1.0)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x00ec
            androidx.media3.exoplayer.LivePlaybackSpeedControl r0 = r11.n3
            long r1 = r11.C()
            long r3 = r11.I()
            float r0 = r0.b(r1, r3)
            androidx.media3.exoplayer.DefaultMediaClock r1 = r11.h3
            androidx.media3.common.PlaybackParameters r1 = r1.r()
            float r1 = r1.s
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 == 0) goto L_0x00ec
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.q3
            androidx.media3.common.PlaybackParameters r1 = r1.f10317n
            androidx.media3.common.PlaybackParameters r0 = r1.d(r0)
            r11.W0(r0)
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3
            androidx.media3.common.PlaybackParameters r0 = r0.f10317n
            androidx.media3.exoplayer.DefaultMediaClock r1 = r11.h3
            androidx.media3.common.PlaybackParameters r1 = r1.r()
            float r1 = r1.s
            r11.P(r0, r1, r10, r10)
        L_0x00ec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.D1():void");
    }

    private long E(Timeline timeline, Object obj, long j2) {
        timeline.u(timeline.m(obj, this.e3).Y, this.d3);
        Timeline.Window window = this.d3;
        if (window.Y2 != C.f9084b && window.j()) {
            Timeline.Window window2 = this.d3;
            if (window2.b3) {
                return Util.I1(window2.c() - this.d3.Y2) - (j2 + this.e3.s());
            }
        }
        return C.f9084b;
    }

    private static boolean E0(PendingMessageInfo pendingMessageInfo, Timeline timeline, Timeline timeline2, int i2, boolean z, Timeline.Window window, Timeline.Period period) {
        PendingMessageInfo pendingMessageInfo2 = pendingMessageInfo;
        Timeline timeline3 = timeline;
        Timeline timeline4 = timeline2;
        Timeline.Window window2 = window;
        Timeline.Period period2 = period;
        Object obj = pendingMessageInfo2.Z;
        if (obj == null) {
            Pair<Object, Long> H0 = H0(timeline, new SeekPosition(pendingMessageInfo2.s.j(), pendingMessageInfo2.s.f(), pendingMessageInfo2.s.h() == Long.MIN_VALUE ? C.f9084b : Util.I1(pendingMessageInfo2.s.h())), false, i2, z, window, period);
            if (H0 == null) {
                return false;
            }
            pendingMessageInfo.b(timeline3.g(H0.first), ((Long) H0.second).longValue(), H0.first);
            if (pendingMessageInfo2.s.h() == Long.MIN_VALUE) {
                D0(timeline3, pendingMessageInfo, window2, period2);
            }
            return true;
        }
        int g2 = timeline3.g(obj);
        if (g2 == -1) {
            return false;
        }
        if (pendingMessageInfo2.s.h() == Long.MIN_VALUE) {
            D0(timeline3, pendingMessageInfo, window2, period2);
            return true;
        }
        pendingMessageInfo2.X = g2;
        timeline4.m(pendingMessageInfo2.Z, period2);
        if (period2.Y2 && timeline4.u(period2.Y, window2).h3 == timeline4.g(pendingMessageInfo2.Z)) {
            Pair<Object, Long> q = timeline.q(window, period, timeline3.m(pendingMessageInfo2.Z, period2).Y, pendingMessageInfo2.Y + period.s());
            pendingMessageInfo.b(timeline3.g(q.first), ((Long) q.second).longValue(), q.first);
        }
        return true;
    }

    private void E1(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId2, long j2, boolean z) throws ExoPlaybackException {
        if (!t1(timeline, mediaPeriodId)) {
            PlaybackParameters playbackParameters = mediaPeriodId.c() ? PlaybackParameters.Z : this.q3.f10317n;
            if (!this.h3.r().equals(playbackParameters)) {
                W0(playbackParameters);
                P(this.q3.f10317n, playbackParameters.s, false, false);
                return;
            }
            return;
        }
        timeline.u(timeline.m(mediaPeriodId.f12163a, this.e3).Y, this.d3);
        this.n3.a((MediaItem.LiveConfiguration) Util.o(this.d3.d3));
        if (j2 != C.f9084b) {
            this.n3.e(E(timeline, mediaPeriodId.f12163a, j2));
            return;
        }
        if (!Util.g(!timeline2.x() ? timeline2.u(timeline2.m(mediaPeriodId2.f12163a, this.e3).Y, this.d3).s : null, this.d3.s) || z) {
            this.n3.e(C.f9084b);
        }
    }

    private long F() {
        MediaPeriodHolder s2 = this.l3.s();
        if (s2 == null) {
            return 0;
        }
        long l2 = s2.l();
        if (!s2.f10238d) {
            return l2;
        }
        int i2 = 0;
        while (true) {
            Renderer[] rendererArr = this.s;
            if (i2 >= rendererArr.length) {
                return l2;
            }
            if (W(rendererArr[i2]) && this.s[i2].e() == s2.f10237c[i2]) {
                long C = this.s[i2].C();
                if (C == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                l2 = Math.max(C, l2);
            }
            i2++;
        }
    }

    private void F0(Timeline timeline, Timeline timeline2) {
        if (!timeline.x() || !timeline2.x()) {
            for (int size = this.i3.size() - 1; size >= 0; size--) {
                if (!E0(this.i3.get(size), timeline, timeline2, this.y3, this.z3, this.d3, this.e3)) {
                    this.i3.get(size).s.m(false);
                    this.i3.remove(size);
                }
            }
            Collections.sort(this.i3);
        }
    }

    private void F1(boolean z, boolean z2) {
        this.v3 = z;
        this.w3 = z2 ? C.f9084b : this.j3.b();
    }

    private Pair<MediaSource.MediaPeriodId, Long> G(Timeline timeline) {
        long j2 = 0;
        if (timeline.x()) {
            return Pair.create(PlaybackInfo.l(), 0L);
        }
        Timeline timeline2 = timeline;
        Pair<Object, Long> q = timeline2.q(this.d3, this.e3, timeline.f(this.z3), C.f9084b);
        MediaSource.MediaPeriodId G = this.l3.G(timeline, q.first, 0);
        long longValue = ((Long) q.second).longValue();
        if (G.c()) {
            timeline.m(G.f12163a, this.e3);
            if (G.f12165c == this.e3.p(G.f12164b)) {
                j2 = this.e3.j();
            }
            longValue = j2;
        }
        return Pair.create(G, Long.valueOf(longValue));
    }

    private static PositionUpdateForPlaylistChange G0(Timeline timeline, PlaybackInfo playbackInfo, @Nullable SeekPosition seekPosition, MediaPeriodQueue mediaPeriodQueue, int i2, boolean z, Timeline.Window window, Timeline.Period period) {
        boolean z2;
        boolean z4;
        boolean z5;
        int i5;
        MediaSource.MediaPeriodId mediaPeriodId;
        int i6;
        long j2;
        long j5;
        MediaPeriodQueue mediaPeriodQueue2;
        int i7;
        long j6;
        long j7;
        int i8;
        boolean z6;
        int i9;
        int i10;
        boolean z7;
        boolean z8;
        boolean z9;
        Timeline timeline2 = timeline;
        PlaybackInfo playbackInfo2 = playbackInfo;
        SeekPosition seekPosition2 = seekPosition;
        boolean z10 = z;
        Timeline.Period period2 = period;
        if (timeline.x()) {
            return new PositionUpdateForPlaylistChange(PlaybackInfo.l(), 0, C.f9084b, false, true, false);
        }
        MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo2.f10305b;
        Object obj = mediaPeriodId2.f12163a;
        boolean Y4 = Y(playbackInfo2, period2);
        long j8 = (playbackInfo2.f10305b.c() || Y4) ? playbackInfo2.f10306c : playbackInfo2.r;
        boolean z11 = true;
        if (seekPosition2 != null) {
            MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId2;
            i5 = -1;
            Pair<Object, Long> H0 = H0(timeline, seekPosition, true, i2, z, window, period);
            if (H0 == null) {
                i10 = timeline2.f(z10);
                j2 = j8;
                z9 = false;
                z8 = false;
                z7 = true;
            } else {
                if (seekPosition2.f10224c == C.f9084b) {
                    i10 = timeline2.m(H0.first, period2).Y;
                    j2 = j8;
                    z9 = false;
                } else {
                    obj = H0.first;
                    j2 = ((Long) H0.second).longValue();
                    z9 = true;
                    i10 = -1;
                }
                z8 = playbackInfo2.f10308e == 4;
                z7 = false;
            }
            Timeline.Window window2 = window;
            z2 = z9;
            z5 = z8;
            z4 = z7;
            i6 = i10;
            mediaPeriodId = mediaPeriodId3;
        } else {
            MediaSource.MediaPeriodId mediaPeriodId4 = mediaPeriodId2;
            i5 = -1;
            if (playbackInfo2.f10304a.x()) {
                i8 = timeline2.f(z10);
            } else if (timeline2.g(obj) == -1) {
                Object I0 = I0(window, period, i2, z, obj, playbackInfo2.f10304a, timeline);
                if (I0 == null) {
                    i9 = timeline2.f(z10);
                    z6 = true;
                } else {
                    i9 = timeline2.m(I0, period2).Y;
                    z6 = false;
                }
                Timeline.Window window3 = window;
                i6 = i9;
                z4 = z6;
                j6 = j8;
                mediaPeriodId = mediaPeriodId4;
                z5 = false;
                z2 = false;
            } else if (j8 == C.f9084b) {
                i8 = timeline2.m(obj, period2).Y;
            } else if (Y4) {
                mediaPeriodId = mediaPeriodId4;
                playbackInfo2.f10304a.m(mediaPeriodId.f12163a, period2);
                if (playbackInfo2.f10304a.u(period2.Y, window).h3 == playbackInfo2.f10304a.g(mediaPeriodId.f12163a)) {
                    Pair<Object, Long> q = timeline.q(window, period, timeline2.m(obj, period2).Y, j8 + period.s());
                    obj = q.first;
                    j7 = ((Long) q.second).longValue();
                } else {
                    j7 = j8;
                }
                i6 = -1;
                z5 = false;
                z4 = false;
                z2 = true;
            } else {
                Timeline.Window window4 = window;
                mediaPeriodId = mediaPeriodId4;
                j6 = j8;
                i6 = -1;
                z5 = false;
                z4 = false;
                z2 = false;
            }
            Timeline.Window window5 = window;
            i6 = i8;
            j6 = j8;
            mediaPeriodId = mediaPeriodId4;
            z5 = false;
            z4 = false;
            z2 = false;
        }
        if (i6 != i5) {
            Pair<Object, Long> q2 = timeline.q(window, period, i6, C.f9084b);
            obj = q2.first;
            j2 = ((Long) q2.second).longValue();
            mediaPeriodQueue2 = mediaPeriodQueue;
            j5 = -9223372036854775807L;
        } else {
            mediaPeriodQueue2 = mediaPeriodQueue;
            j5 = j2;
        }
        MediaSource.MediaPeriodId G = mediaPeriodQueue2.G(timeline2, obj, j2);
        int i11 = G.f12167e;
        boolean z12 = i11 == i5 || ((i7 = mediaPeriodId.f12167e) != i5 && i11 >= i7);
        if (!mediaPeriodId.f12163a.equals(obj) || mediaPeriodId.c() || G.c() || !z12) {
            z11 = false;
        }
        MediaSource.MediaPeriodId mediaPeriodId5 = mediaPeriodId;
        boolean U = U(Y4, mediaPeriodId, j8, G, timeline2.m(obj, period2), j5);
        if (z11 || U) {
            G = mediaPeriodId5;
        }
        if (G.c()) {
            if (G.equals(mediaPeriodId5)) {
                j2 = playbackInfo2.r;
            } else {
                timeline2.m(G.f12163a, period2);
                j2 = G.f12165c == period2.p(G.f12164b) ? period.j() : 0;
            }
        }
        return new PositionUpdateForPlaylistChange(G, j2, j5, z5, z4, z2);
    }

    private void G1(float f2) {
        for (MediaPeriodHolder r = this.l3.r(); r != null; r = r.j()) {
            for (ExoTrackSelection exoTrackSelection : r.o().f12418c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.r(f2);
                }
            }
        }
    }

    @Nullable
    private static Pair<Object, Long> H0(Timeline timeline, SeekPosition seekPosition, boolean z, int i2, boolean z2, Timeline.Window window, Timeline.Period period) {
        Object I0;
        Timeline timeline2 = timeline;
        SeekPosition seekPosition2 = seekPosition;
        Timeline.Period period2 = period;
        Timeline timeline3 = seekPosition2.f10222a;
        if (timeline.x()) {
            return null;
        }
        Timeline timeline4 = timeline3.x() ? timeline2 : timeline3;
        try {
            Pair<Object, Long> q = timeline4.q(window, period, seekPosition2.f10223b, seekPosition2.f10224c);
            if (timeline.equals(timeline4)) {
                return q;
            }
            if (timeline.g(q.first) == -1) {
                Timeline.Window window2 = window;
                if (z && (I0 = I0(window, period, i2, z2, q.first, timeline4, timeline)) != null) {
                    return timeline.q(window, period, timeline.m(I0, period2).Y, C.f9084b);
                }
                return null;
            } else if (!timeline4.m(q.first, period2).Y2 || timeline4.u(period2.Y, window).h3 != timeline4.g(q.first)) {
                return q;
            } else {
                return timeline.q(window, period, timeline.m(q.first, period2).Y, seekPosition2.f10224c);
            }
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    private synchronized void H1(Supplier<Boolean> supplier, long j2) {
        long b2 = this.j3.b() + j2;
        boolean z = false;
        while (!supplier.get().booleanValue() && j2 > 0) {
            try {
                this.j3.f();
                wait(j2);
            } catch (InterruptedException unused) {
                z = true;
            }
            j2 = b2 - this.j3.b();
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private long I() {
        return J(this.q3.p);
    }

    @Nullable
    static Object I0(Timeline.Window window, Timeline.Period period, int i2, boolean z, Object obj, Timeline timeline, Timeline timeline2) {
        int g2 = timeline.g(obj);
        int n2 = timeline.n();
        int i5 = g2;
        int i6 = -1;
        for (int i7 = 0; i7 < n2 && i6 == -1; i7++) {
            i5 = timeline.i(i5, period, window, i2, z);
            if (i5 == -1) {
                break;
            }
            i6 = timeline2.g(timeline.t(i5));
        }
        if (i6 == -1) {
            return null;
        }
        return timeline2.t(i6);
    }

    private long J(long j2) {
        MediaPeriodHolder l2 = this.l3.l();
        if (l2 == null) {
            return 0;
        }
        return Math.max(0, j2 - l2.y(this.F3));
    }

    private void J0(long j2, long j5) {
        this.a3.k(2, j2 + j5);
    }

    private void K(MediaPeriod mediaPeriod) {
        if (this.l3.y(mediaPeriod)) {
            this.l3.C(this.F3);
            b0();
        }
    }

    private void L(IOException iOException, int i2) {
        ExoPlaybackException m2 = ExoPlaybackException.m(iOException, i2);
        MediaPeriodHolder r = this.l3.r();
        if (r != null) {
            m2 = m2.j(r.f10240f.f10249a);
        }
        Log.e(L3, "Playback error", m2);
        w1(false, false);
        this.q3 = this.q3.f(m2);
    }

    private void L0(boolean z) throws ExoPlaybackException {
        MediaSource.MediaPeriodId mediaPeriodId = this.l3.r().f10240f.f10249a;
        long O0 = O0(mediaPeriodId, this.q3.r, true, false);
        if (O0 != this.q3.r) {
            PlaybackInfo playbackInfo = this.q3;
            this.q3 = R(mediaPeriodId, O0, playbackInfo.f10306c, playbackInfo.f10307d, z, 5);
        }
    }

    private void M(boolean z) {
        MediaPeriodHolder l2 = this.l3.l();
        MediaSource.MediaPeriodId mediaPeriodId = l2 == null ? this.q3.f10305b : l2.f10240f.f10249a;
        boolean z2 = !this.q3.f10314k.equals(mediaPeriodId);
        if (z2) {
            this.q3 = this.q3.c(mediaPeriodId);
        }
        PlaybackInfo playbackInfo = this.q3;
        playbackInfo.p = l2 == null ? playbackInfo.r : l2.i();
        this.q3.q = I();
        if ((z2 || z) && l2 != null && l2.f10238d) {
            z1(l2.f10240f.f10249a, l2.n(), l2.o());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ab A[Catch:{ all -> 0x00ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00b2 A[Catch:{ all -> 0x00ae }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void M0(androidx.media3.exoplayer.ExoPlayerImplInternal.SeekPosition r20) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r19 = this;
            r11 = r19
            r0 = r20
            androidx.media3.exoplayer.ExoPlayerImplInternal$PlaybackInfoUpdate r1 = r11.r3
            r8 = 1
            r1.b(r8)
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.q3
            androidx.media3.common.Timeline r1 = r1.f10304a
            int r4 = r11.y3
            boolean r5 = r11.z3
            androidx.media3.common.Timeline$Window r6 = r11.d3
            androidx.media3.common.Timeline$Period r7 = r11.e3
            r3 = 1
            r2 = r20
            android.util.Pair r1 = H0(r1, r2, r3, r4, r5, r6, r7)
            r2 = 0
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = 0
            if (r1 != 0) goto L_0x004b
            androidx.media3.exoplayer.PlaybackInfo r7 = r11.q3
            androidx.media3.common.Timeline r7 = r7.f10304a
            android.util.Pair r7 = r11.G(r7)
            java.lang.Object r9 = r7.first
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r9 = (androidx.media3.exoplayer.source.MediaSource.MediaPeriodId) r9
            java.lang.Object r7 = r7.second
            java.lang.Long r7 = (java.lang.Long) r7
            long r12 = r7.longValue()
            androidx.media3.exoplayer.PlaybackInfo r7 = r11.q3
            androidx.media3.common.Timeline r7 = r7.f10304a
            boolean r7 = r7.x()
            r7 = r7 ^ r8
            r10 = r7
            r17 = r4
        L_0x0047:
            r4 = r12
            r12 = r17
            goto L_0x00a1
        L_0x004b:
            java.lang.Object r7 = r1.first
            java.lang.Object r9 = r1.second
            java.lang.Long r9 = (java.lang.Long) r9
            long r12 = r9.longValue()
            long r9 = r0.f10224c
            int r14 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            if (r14 != 0) goto L_0x005d
            r9 = r4
            goto L_0x005e
        L_0x005d:
            r9 = r12
        L_0x005e:
            androidx.media3.exoplayer.MediaPeriodQueue r14 = r11.l3
            androidx.media3.exoplayer.PlaybackInfo r15 = r11.q3
            androidx.media3.common.Timeline r15 = r15.f10304a
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r7 = r14.G(r15, r7, r12)
            boolean r14 = r7.c()
            if (r14 == 0) goto L_0x0093
            androidx.media3.exoplayer.PlaybackInfo r4 = r11.q3
            androidx.media3.common.Timeline r4 = r4.f10304a
            java.lang.Object r5 = r7.f12163a
            androidx.media3.common.Timeline$Period r12 = r11.e3
            r4.m(r5, r12)
            androidx.media3.common.Timeline$Period r4 = r11.e3
            int r5 = r7.f12164b
            int r4 = r4.p(r5)
            int r5 = r7.f12165c
            if (r4 != r5) goto L_0x008d
            androidx.media3.common.Timeline$Period r4 = r11.e3
            long r4 = r4.j()
            r12 = r4
            goto L_0x008e
        L_0x008d:
            r12 = r2
        L_0x008e:
            r4 = r12
            r12 = r9
            r10 = 1
            r9 = r7
            goto L_0x00a1
        L_0x0093:
            long r14 = r0.f10224c
            int r16 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r16 != 0) goto L_0x009b
            r4 = 1
            goto L_0x009c
        L_0x009b:
            r4 = 0
        L_0x009c:
            r17 = r9
            r10 = r4
            r9 = r7
            goto L_0x0047
        L_0x00a1:
            androidx.media3.exoplayer.PlaybackInfo r7 = r11.q3     // Catch:{ all -> 0x00ae }
            androidx.media3.common.Timeline r7 = r7.f10304a     // Catch:{ all -> 0x00ae }
            boolean r7 = r7.x()     // Catch:{ all -> 0x00ae }
            if (r7 == 0) goto L_0x00b2
            r11.E3 = r0     // Catch:{ all -> 0x00ae }
            goto L_0x00c1
        L_0x00ae:
            r0 = move-exception
            r7 = r4
            goto L_0x0149
        L_0x00b2:
            r0 = 4
            if (r1 != 0) goto L_0x00c4
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.q3     // Catch:{ all -> 0x00ae }
            int r1 = r1.f10308e     // Catch:{ all -> 0x00ae }
            if (r1 == r8) goto L_0x00be
            r11.o1(r0)     // Catch:{ all -> 0x00ae }
        L_0x00be:
            r11.A0(r6, r8, r6, r8)     // Catch:{ all -> 0x00ae }
        L_0x00c1:
            r7 = r4
            goto L_0x0138
        L_0x00c4:
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.q3     // Catch:{ all -> 0x00ae }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r1 = r1.f10305b     // Catch:{ all -> 0x00ae }
            boolean r1 = r9.equals(r1)     // Catch:{ all -> 0x00ae }
            if (r1 == 0) goto L_0x0113
            androidx.media3.exoplayer.MediaPeriodQueue r1 = r11.l3     // Catch:{ all -> 0x00ae }
            androidx.media3.exoplayer.MediaPeriodHolder r1 = r1.r()     // Catch:{ all -> 0x00ae }
            if (r1 == 0) goto L_0x00e7
            boolean r7 = r1.f10238d     // Catch:{ all -> 0x00ae }
            if (r7 == 0) goto L_0x00e7
            int r7 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x00e7
            androidx.media3.exoplayer.source.MediaPeriod r1 = r1.f10235a     // Catch:{ all -> 0x00ae }
            androidx.media3.exoplayer.SeekParameters r2 = r11.p3     // Catch:{ all -> 0x00ae }
            long r1 = r1.f(r4, r2)     // Catch:{ all -> 0x00ae }
            goto L_0x00e8
        L_0x00e7:
            r1 = r4
        L_0x00e8:
            long r14 = androidx.media3.common.util.Util.H2(r1)     // Catch:{ all -> 0x00ae }
            androidx.media3.exoplayer.PlaybackInfo r3 = r11.q3     // Catch:{ all -> 0x00ae }
            long r6 = r3.r     // Catch:{ all -> 0x00ae }
            long r6 = androidx.media3.common.util.Util.H2(r6)     // Catch:{ all -> 0x00ae }
            int r3 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r3 != 0) goto L_0x0114
            androidx.media3.exoplayer.PlaybackInfo r3 = r11.q3     // Catch:{ all -> 0x00ae }
            int r6 = r3.f10308e     // Catch:{ all -> 0x00ae }
            r7 = 2
            if (r6 == r7) goto L_0x0102
            r7 = 3
            if (r6 != r7) goto L_0x0114
        L_0x0102:
            long r7 = r3.r     // Catch:{ all -> 0x00ae }
            r0 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r0
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.R(r2, r3, r5, r7, r9, r10)
            r11.q3 = r0
            return
        L_0x0113:
            r1 = r4
        L_0x0114:
            androidx.media3.exoplayer.PlaybackInfo r3 = r11.q3     // Catch:{ all -> 0x00ae }
            int r3 = r3.f10308e     // Catch:{ all -> 0x00ae }
            if (r3 != r0) goto L_0x011c
            r0 = 1
            goto L_0x011d
        L_0x011c:
            r0 = 0
        L_0x011d:
            long r14 = r11.N0(r9, r1, r0)     // Catch:{ all -> 0x00ae }
            int r0 = (r4 > r14 ? 1 : (r4 == r14 ? 0 : -1))
            if (r0 == 0) goto L_0x0126
            goto L_0x0127
        L_0x0126:
            r8 = 0
        L_0x0127:
            r10 = r10 | r8
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3     // Catch:{ all -> 0x0147 }
            androidx.media3.common.Timeline r4 = r0.f10304a     // Catch:{ all -> 0x0147 }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r5 = r0.f10305b     // Catch:{ all -> 0x0147 }
            r8 = 1
            r1 = r19
            r2 = r4
            r3 = r9
            r6 = r12
            r1.E1(r2, r3, r4, r5, r6, r8)     // Catch:{ all -> 0x0147 }
            r7 = r14
        L_0x0138:
            r0 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r0
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.R(r2, r3, r5, r7, r9, r10)
            r11.q3 = r0
            return
        L_0x0147:
            r0 = move-exception
            r7 = r14
        L_0x0149:
            r14 = 2
            r1 = r19
            r2 = r9
            r3 = r7
            r5 = r12
            r9 = r10
            r10 = r14
            androidx.media3.exoplayer.PlaybackInfo r1 = r1.R(r2, r3, r5, r7, r9, r10)
            r11.q3 = r1
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.M0(androidx.media3.exoplayer.ExoPlayerImplInternal$SeekPosition):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:102:0x01d2  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e2  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0127  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0150  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0161  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0188 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01a9  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x01ab  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void N(androidx.media3.common.Timeline r28, boolean r29) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r27 = this;
            r11 = r27
            r12 = r28
            androidx.media3.exoplayer.PlaybackInfo r2 = r11.q3
            androidx.media3.exoplayer.ExoPlayerImplInternal$SeekPosition r3 = r11.E3
            androidx.media3.exoplayer.MediaPeriodQueue r4 = r11.l3
            int r5 = r11.y3
            boolean r6 = r11.z3
            androidx.media3.common.Timeline$Window r7 = r11.d3
            androidx.media3.common.Timeline$Period r8 = r11.e3
            r1 = r28
            androidx.media3.exoplayer.ExoPlayerImplInternal$PositionUpdateForPlaylistChange r7 = G0(r1, r2, r3, r4, r5, r6, r7, r8)
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r9 = r7.f10216a
            long r13 = r7.f10218c
            boolean r0 = r7.f10219d
            long r5 = r7.f10217b
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.q3
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r1 = r1.f10305b
            boolean r1 = r1.equals(r9)
            r10 = 1
            r15 = 0
            if (r1 == 0) goto L_0x0038
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.q3
            long r1 = r1.r
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0035
            goto L_0x0038
        L_0x0035:
            r16 = 0
            goto L_0x003a
        L_0x0038:
            r16 = 1
        L_0x003a:
            r8 = 0
            r17 = 3
            r18 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r4 = 4
            boolean r1 = r7.f10220e     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x005b
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.q3     // Catch:{ all -> 0x0051 }
            int r1 = r1.f10308e     // Catch:{ all -> 0x0051 }
            if (r1 == r10) goto L_0x0058
            r11.o1(r4)     // Catch:{ all -> 0x0051 }
            goto L_0x0058
        L_0x0051:
            r0 = move-exception
            r15 = r8
            r10 = -1
            r20 = 4
            goto L_0x0157
        L_0x0058:
            r11.A0(r15, r15, r15, r10)     // Catch:{ all -> 0x0051 }
        L_0x005b:
            androidx.media3.exoplayer.Renderer[] r1 = r11.s     // Catch:{ all -> 0x0051 }
            int r2 = r1.length     // Catch:{ all -> 0x0051 }
            r3 = 0
        L_0x005f:
            if (r3 >= r2) goto L_0x006a
            r4 = r1[r3]     // Catch:{ all -> 0x0051 }
            r4.m(r12)     // Catch:{ all -> 0x0051 }
            int r3 = r3 + 1
            r4 = 4
            goto L_0x005f
        L_0x006a:
            if (r16 != 0) goto L_0x0098
            androidx.media3.exoplayer.MediaPeriodQueue r1 = r11.l3     // Catch:{ all -> 0x008f }
            long r3 = r11.F3     // Catch:{ all -> 0x008f }
            long r22 = r27.F()     // Catch:{ all -> 0x008f }
            r2 = r28
            r10 = -1
            r20 = 4
            r25 = r5
            r5 = r22
            boolean r0 = r1.K(r2, r3, r5)     // Catch:{ all -> 0x0089 }
            if (r0 != 0) goto L_0x0086
            r11.L0(r15)     // Catch:{ all -> 0x0089 }
        L_0x0086:
            r5 = r25
            goto L_0x00d6
        L_0x0089:
            r0 = move-exception
            r15 = r8
            r5 = r25
            goto L_0x0157
        L_0x008f:
            r0 = move-exception
            r25 = r5
            r10 = -1
            r20 = 4
        L_0x0095:
            r15 = r8
            goto L_0x0157
        L_0x0098:
            r25 = r5
            r10 = -1
            r20 = 4
            boolean r1 = r28.x()     // Catch:{ all -> 0x0089 }
            if (r1 != 0) goto L_0x0086
            androidx.media3.exoplayer.MediaPeriodQueue r1 = r11.l3     // Catch:{ all -> 0x00d2 }
            androidx.media3.exoplayer.MediaPeriodHolder r1 = r1.r()     // Catch:{ all -> 0x00d2 }
        L_0x00a9:
            if (r1 == 0) goto L_0x00c7
            androidx.media3.exoplayer.MediaPeriodInfo r2 = r1.f10240f     // Catch:{ all -> 0x0089 }
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r2.f10249a     // Catch:{ all -> 0x0089 }
            boolean r2 = r2.equals(r9)     // Catch:{ all -> 0x0089 }
            if (r2 == 0) goto L_0x00c2
            androidx.media3.exoplayer.MediaPeriodQueue r2 = r11.l3     // Catch:{ all -> 0x0089 }
            androidx.media3.exoplayer.MediaPeriodInfo r3 = r1.f10240f     // Catch:{ all -> 0x0089 }
            androidx.media3.exoplayer.MediaPeriodInfo r2 = r2.t(r12, r3)     // Catch:{ all -> 0x0089 }
            r1.f10240f = r2     // Catch:{ all -> 0x0089 }
            r1.A()     // Catch:{ all -> 0x0089 }
        L_0x00c2:
            androidx.media3.exoplayer.MediaPeriodHolder r1 = r1.j()     // Catch:{ all -> 0x0089 }
            goto L_0x00a9
        L_0x00c7:
            r5 = r25
            long r0 = r11.N0(r9, r5, r0)     // Catch:{ all -> 0x00d0 }
            r21 = r0
            goto L_0x00d8
        L_0x00d0:
            r0 = move-exception
            goto L_0x0095
        L_0x00d2:
            r0 = move-exception
            r5 = r25
            goto L_0x0095
        L_0x00d6:
            r21 = r5
        L_0x00d8:
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3
            androidx.media3.common.Timeline r4 = r0.f10304a
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r5 = r0.f10305b
            boolean r0 = r7.f10221f
            if (r0 == 0) goto L_0x00e5
            r6 = r21
            goto L_0x00e7
        L_0x00e5:
            r6 = r18
        L_0x00e7:
            r0 = 0
            r1 = r27
            r2 = r28
            r3 = r9
            r15 = r8
            r8 = r0
            r1.E1(r2, r3, r4, r5, r6, r8)
            if (r16 != 0) goto L_0x00fc
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3
            long r0 = r0.f10306c
            int r2 = (r13 > r0 ? 1 : (r13 == r0 ? 0 : -1))
            if (r2 == 0) goto L_0x0138
        L_0x00fc:
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r1 = r0.f10305b
            java.lang.Object r1 = r1.f12163a
            androidx.media3.common.Timeline r0 = r0.f10304a
            if (r16 == 0) goto L_0x011b
            if (r29 == 0) goto L_0x011b
            boolean r2 = r0.x()
            if (r2 != 0) goto L_0x011b
            androidx.media3.common.Timeline$Period r2 = r11.e3
            androidx.media3.common.Timeline$Period r0 = r0.m(r1, r2)
            boolean r0 = r0.Y2
            if (r0 != 0) goto L_0x011b
            r24 = 1
            goto L_0x011d
        L_0x011b:
            r24 = 0
        L_0x011d:
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3
            long r7 = r0.f10307d
            int r0 = r12.g(r1)
            if (r0 != r10) goto L_0x0129
            r10 = 4
            goto L_0x012a
        L_0x0129:
            r10 = 3
        L_0x012a:
            r1 = r27
            r2 = r9
            r3 = r21
            r5 = r13
            r9 = r24
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.R(r2, r3, r5, r7, r9, r10)
            r11.q3 = r0
        L_0x0138:
            r27.B0()
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3
            androidx.media3.common.Timeline r0 = r0.f10304a
            r11.F0(r12, r0)
            androidx.media3.exoplayer.PlaybackInfo r0 = r11.q3
            androidx.media3.exoplayer.PlaybackInfo r0 = r0.j(r12)
            r11.q3 = r0
            boolean r0 = r28.x()
            if (r0 != 0) goto L_0x0152
            r11.E3 = r15
        L_0x0152:
            r1 = 0
            r11.M(r1)
            return
        L_0x0157:
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.q3
            androidx.media3.common.Timeline r4 = r1.f10304a
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r8 = r1.f10305b
            boolean r1 = r7.f10221f
            if (r1 == 0) goto L_0x0163
            r18 = r5
        L_0x0163:
            r21 = 0
            r1 = r27
            r2 = r28
            r3 = r9
            r25 = r5
            r5 = r8
            r6 = r18
            r8 = r21
            r1.E1(r2, r3, r4, r5, r6, r8)
            if (r16 != 0) goto L_0x017e
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.q3
            long r1 = r1.f10306c
            int r3 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x01ba
        L_0x017e:
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.q3
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r1.f10305b
            java.lang.Object r2 = r2.f12163a
            androidx.media3.common.Timeline r1 = r1.f10304a
            if (r16 == 0) goto L_0x019d
            if (r29 == 0) goto L_0x019d
            boolean r3 = r1.x()
            if (r3 != 0) goto L_0x019d
            androidx.media3.common.Timeline$Period r3 = r11.e3
            androidx.media3.common.Timeline$Period r1 = r1.m(r2, r3)
            boolean r1 = r1.Y2
            if (r1 != 0) goto L_0x019d
            r24 = 1
            goto L_0x019f
        L_0x019d:
            r24 = 0
        L_0x019f:
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.q3
            long r7 = r1.f10307d
            int r1 = r12.g(r2)
            if (r1 != r10) goto L_0x01ab
            r10 = 4
            goto L_0x01ac
        L_0x01ab:
            r10 = 3
        L_0x01ac:
            r1 = r27
            r2 = r9
            r3 = r25
            r5 = r13
            r9 = r24
            androidx.media3.exoplayer.PlaybackInfo r1 = r1.R(r2, r3, r5, r7, r9, r10)
            r11.q3 = r1
        L_0x01ba:
            r27.B0()
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.q3
            androidx.media3.common.Timeline r1 = r1.f10304a
            r11.F0(r12, r1)
            androidx.media3.exoplayer.PlaybackInfo r1 = r11.q3
            androidx.media3.exoplayer.PlaybackInfo r1 = r1.j(r12)
            r11.q3 = r1
            boolean r1 = r28.x()
            if (r1 != 0) goto L_0x01d4
            r11.E3 = r15
        L_0x01d4:
            r1 = 0
            r11.M(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.N(androidx.media3.common.Timeline, boolean):void");
    }

    private long N0(MediaSource.MediaPeriodId mediaPeriodId, long j2, boolean z) throws ExoPlaybackException {
        return O0(mediaPeriodId, j2, this.l3.r() != this.l3.s(), z);
    }

    private void O(MediaPeriod mediaPeriod) throws ExoPlaybackException {
        if (this.l3.y(mediaPeriod)) {
            MediaPeriodHolder l2 = this.l3.l();
            l2.p(this.h3.r().s, this.q3.f10304a);
            z1(l2.f10240f.f10249a, l2.n(), l2.o());
            if (l2 == this.l3.r()) {
                C0(l2.f10240f.f10250b);
                x();
                PlaybackInfo playbackInfo = this.q3;
                MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f10305b;
                long j2 = l2.f10240f.f10250b;
                this.q3 = R(mediaPeriodId, j2, playbackInfo.f10306c, j2, false, 5);
            }
            b0();
        }
    }

    private long O0(MediaSource.MediaPeriodId mediaPeriodId, long j2, boolean z, boolean z2) throws ExoPlaybackException {
        x1();
        F1(false, true);
        if (z2 || this.q3.f10308e == 3) {
            o1(2);
        }
        MediaPeriodHolder r = this.l3.r();
        MediaPeriodHolder mediaPeriodHolder = r;
        while (mediaPeriodHolder != null && !mediaPeriodId.equals(mediaPeriodHolder.f10240f.f10249a)) {
            mediaPeriodHolder = mediaPeriodHolder.j();
        }
        if (z || r != mediaPeriodHolder || (mediaPeriodHolder != null && mediaPeriodHolder.z(j2) < 0)) {
            for (Renderer u : this.s) {
                u(u);
            }
            if (mediaPeriodHolder != null) {
                while (this.l3.r() != mediaPeriodHolder) {
                    this.l3.b();
                }
                this.l3.D(mediaPeriodHolder);
                mediaPeriodHolder.x(MediaPeriodQueue.o);
                x();
            }
        }
        MediaPeriodQueue mediaPeriodQueue = this.l3;
        if (mediaPeriodHolder != null) {
            mediaPeriodQueue.D(mediaPeriodHolder);
            if (!mediaPeriodHolder.f10238d) {
                mediaPeriodHolder.f10240f = mediaPeriodHolder.f10240f.b(j2);
            } else if (mediaPeriodHolder.f10239e) {
                j2 = mediaPeriodHolder.f10235a.m(j2);
                mediaPeriodHolder.f10235a.t(j2 - this.f3, this.g3);
            }
            C0(j2);
            b0();
        } else {
            mediaPeriodQueue.f();
            C0(j2);
        }
        M(false);
        this.a3.i(2);
        return j2;
    }

    private void P(PlaybackParameters playbackParameters, float f2, boolean z, boolean z2) throws ExoPlaybackException {
        if (z) {
            if (z2) {
                this.r3.b(1);
            }
            this.q3 = this.q3.g(playbackParameters);
        }
        G1(playbackParameters.s);
        for (Renderer renderer : this.s) {
            if (renderer != null) {
                renderer.v(f2, playbackParameters.s);
            }
        }
    }

    private void P0(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.h() == C.f9084b) {
            Q0(playerMessage);
        } else if (this.q3.f10304a.x()) {
            this.i3.add(new PendingMessageInfo(playerMessage));
        } else {
            PendingMessageInfo pendingMessageInfo = new PendingMessageInfo(playerMessage);
            Timeline timeline = this.q3.f10304a;
            if (E0(pendingMessageInfo, timeline, timeline, this.y3, this.z3, this.d3, this.e3)) {
                this.i3.add(pendingMessageInfo);
                Collections.sort(this.i3);
                return;
            }
            playerMessage.m(false);
        }
    }

    private void Q(PlaybackParameters playbackParameters, boolean z) throws ExoPlaybackException {
        P(playbackParameters, playbackParameters.s, true, z);
    }

    private void Q0(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (playerMessage.e() == this.c3) {
            t(playerMessage);
            int i2 = this.q3.f10308e;
            if (i2 == 3 || i2 == 2) {
                this.a3.i(2);
                return;
            }
            return;
        }
        this.a3.m(15, playerMessage).a();
    }

    @CheckResult
    private PlaybackInfo R(MediaSource.MediaPeriodId mediaPeriodId, long j2, long j5, long j6, boolean z, int i2) {
        ImmutableList<Metadata> immutableList;
        TrackSelectorResult trackSelectorResult;
        TrackGroupArray trackGroupArray;
        MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
        long j7 = j5;
        this.H3 = this.H3 || j2 != this.q3.r || !mediaPeriodId.equals(this.q3.f10305b);
        B0();
        PlaybackInfo playbackInfo = this.q3;
        TrackGroupArray trackGroupArray2 = playbackInfo.f10311h;
        TrackSelectorResult trackSelectorResult2 = playbackInfo.f10312i;
        List<Metadata> list = playbackInfo.f10313j;
        if (this.m3.u()) {
            MediaPeriodHolder r = this.l3.r();
            TrackGroupArray n2 = r == null ? TrackGroupArray.X2 : r.n();
            TrackSelectorResult o = r == null ? this.X2 : r.o();
            ImmutableList<Metadata> B = B(o.f12418c);
            if (r != null) {
                MediaPeriodInfo mediaPeriodInfo = r.f10240f;
                if (mediaPeriodInfo.f10251c != j7) {
                    r.f10240f = mediaPeriodInfo.a(j7);
                }
            }
            f0();
            trackGroupArray = n2;
            trackSelectorResult = o;
            immutableList = B;
        } else if (!mediaPeriodId.equals(this.q3.f10305b)) {
            trackGroupArray = TrackGroupArray.X2;
            trackSelectorResult = this.X2;
            immutableList = ImmutableList.I();
        } else {
            immutableList = list;
            trackGroupArray = trackGroupArray2;
            trackSelectorResult = trackSelectorResult2;
        }
        if (z) {
            this.r3.e(i2);
        }
        return this.q3.d(mediaPeriodId, j2, j5, j6, I(), trackGroupArray, trackSelectorResult, immutableList);
    }

    private void R0(PlayerMessage playerMessage) {
        Looper e2 = playerMessage.e();
        if (!e2.getThread().isAlive()) {
            Log.n("TAG", "Trying to send message on a dead thread.");
            playerMessage.m(false);
            return;
        }
        this.j3.e(e2, (Handler.Callback) null).e(new B0(this, playerMessage));
    }

    private boolean S(Renderer renderer, MediaPeriodHolder mediaPeriodHolder) {
        MediaPeriodHolder j2 = mediaPeriodHolder.j();
        return mediaPeriodHolder.f10240f.f10254f && j2.f10238d && ((renderer instanceof TextRenderer) || (renderer instanceof MetadataRenderer) || renderer.C() >= j2.m());
    }

    private void S0(long j2) {
        for (Renderer renderer : this.s) {
            if (renderer.e() != null) {
                T0(renderer, j2);
            }
        }
    }

    private boolean T() {
        MediaPeriodHolder s2 = this.l3.s();
        if (!s2.f10238d) {
            return false;
        }
        int i2 = 0;
        while (true) {
            Renderer[] rendererArr = this.s;
            if (i2 >= rendererArr.length) {
                return true;
            }
            Renderer renderer = rendererArr[i2];
            SampleStream sampleStream = s2.f10237c[i2];
            if (renderer.e() != sampleStream || (sampleStream != null && !renderer.l() && !S(renderer, s2))) {
                return false;
            }
            i2++;
        }
        return false;
    }

    private void T0(Renderer renderer, long j2) {
        renderer.q();
        if (renderer instanceof TextRenderer) {
            ((TextRenderer) renderer).w0(j2);
        }
    }

    private static boolean U(boolean z, MediaSource.MediaPeriodId mediaPeriodId, long j2, MediaSource.MediaPeriodId mediaPeriodId2, Timeline.Period period, long j5) {
        if (z || j2 != j5 || !mediaPeriodId.f12163a.equals(mediaPeriodId2.f12163a)) {
            return false;
        }
        return (!mediaPeriodId.c() || !period.w(mediaPeriodId.f12164b)) ? mediaPeriodId2.c() && period.w(mediaPeriodId2.f12164b) : (period.k(mediaPeriodId.f12164b, mediaPeriodId.f12165c) == 4 || period.k(mediaPeriodId.f12164b, mediaPeriodId.f12165c) == 2) ? false : true;
    }

    private boolean V() {
        MediaPeriodHolder l2 = this.l3.l();
        return (l2 == null || l2.k() == Long.MIN_VALUE) ? false : true;
    }

    private void V0(boolean z, @Nullable AtomicBoolean atomicBoolean) {
        if (this.A3 != z) {
            this.A3 = z;
            if (!z) {
                for (Renderer renderer : this.s) {
                    if (!W(renderer) && this.X.remove(renderer)) {
                        renderer.reset();
                    }
                }
            }
        }
        if (atomicBoolean != null) {
            synchronized (this) {
                atomicBoolean.set(true);
                notifyAll();
            }
        }
    }

    private static boolean W(Renderer renderer) {
        return renderer.getState() != 0;
    }

    private void W0(PlaybackParameters playbackParameters) {
        this.a3.l(16);
        this.h3.f(playbackParameters);
    }

    private boolean X() {
        MediaPeriodHolder r = this.l3.r();
        long j2 = r.f10240f.f10253e;
        return r.f10238d && (j2 == C.f9084b || this.q3.r < j2 || !r1());
    }

    private void X0(MediaSourceListUpdateMessage mediaSourceListUpdateMessage) throws ExoPlaybackException {
        this.r3.b(1);
        if (mediaSourceListUpdateMessage.f10203c != -1) {
            this.E3 = new SeekPosition(new PlaylistTimeline(mediaSourceListUpdateMessage.f10201a, mediaSourceListUpdateMessage.f10202b), mediaSourceListUpdateMessage.f10203c, mediaSourceListUpdateMessage.f10204d);
        }
        N(this.m3.F(mediaSourceListUpdateMessage.f10201a, mediaSourceListUpdateMessage.f10202b), false);
    }

    private static boolean Y(PlaybackInfo playbackInfo, Timeline.Period period) {
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f10305b;
        Timeline timeline = playbackInfo.f10304a;
        return timeline.x() || timeline.m(mediaPeriodId.f12163a, period).Y2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Boolean Z() {
        return Boolean.valueOf(this.s3);
    }

    private void Z0(boolean z) {
        if (z != this.C3) {
            this.C3 = z;
            if (!z && this.q3.o) {
                this.a3.i(2);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a0(PlayerMessage playerMessage) {
        try {
            t(playerMessage);
        } catch (ExoPlaybackException e2) {
            Log.e(L3, "Unexpected error delivering message on external thread.", e2);
            throw new RuntimeException(e2);
        }
    }

    private void b0() {
        boolean q1 = q1();
        this.x3 = q1;
        if (q1) {
            this.l3.l().d(this.F3, this.h3.r().s, this.w3);
        }
        y1();
    }

    private void b1(boolean z) throws ExoPlaybackException {
        this.t3 = z;
        B0();
        if (this.u3 && this.l3.s() != this.l3.r()) {
            L0(true);
            M(false);
        }
    }

    private void c0() {
        this.r3.d(this.q3);
        if (this.r3.f10209a) {
            this.k3.a(this.r3);
            this.r3 = new PlaybackInfoUpdate(this.q3);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x006d, code lost:
        if (r1 < r8.i3.size()) goto L_0x006f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006f, code lost:
        r3 = r8.i3.get(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0078, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0079, code lost:
        if (r3 == null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007d, code lost:
        if (r3.Z == null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007f, code lost:
        r4 = r3.X;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0081, code lost:
        if (r4 < r0) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0083, code lost:
        if (r4 != r0) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0089, code lost:
        if (r3.Y > r9) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x008b, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0093, code lost:
        if (r1 >= r8.i3.size()) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0096, code lost:
        if (r3 == null) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x009a, code lost:
        if (r3.Z == null) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009e, code lost:
        if (r3.X != r0) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a0, code lost:
        r4 = r3.Y;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a4, code lost:
        if (r4 <= r9) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00a8, code lost:
        if (r4 > r11) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        Q0(r3.s);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00b5, code lost:
        if (r3.s.d() != false) goto L_0x00c3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00bd, code lost:
        if (r3.s.l() == false) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00c0, code lost:
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c3, code lost:
        r8.i3.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ce, code lost:
        if (r1 >= r8.i3.size()) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00d0, code lost:
        r3 = r8.i3.get(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00d9, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00db, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x00ec, code lost:
        r8.i3.remove(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00f1, code lost:
        throw r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00f2, code lost:
        r8.G3 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d0(long r9, long r11) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r8 = this;
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r0 = r8.i3
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00f4
            androidx.media3.exoplayer.PlaybackInfo r0 = r8.q3
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r0 = r0.f10305b
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0014
            goto L_0x00f4
        L_0x0014:
            boolean r0 = r8.H3
            if (r0 == 0) goto L_0x001e
            r0 = 1
            long r9 = r9 - r0
            r0 = 0
            r8.H3 = r0
        L_0x001e:
            androidx.media3.exoplayer.PlaybackInfo r0 = r8.q3
            androidx.media3.common.Timeline r1 = r0.f10304a
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r0 = r0.f10305b
            java.lang.Object r0 = r0.f12163a
            int r0 = r1.g(r0)
            int r1 = r8.G3
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r2 = r8.i3
            int r2 = r2.size()
            int r1 = java.lang.Math.min(r1, r2)
            r2 = 0
            if (r1 <= 0) goto L_0x0044
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r8.i3
            int r4 = r1 + -1
            java.lang.Object r3 = r3.get(r4)
            androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo r3 = (androidx.media3.exoplayer.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0045
        L_0x0044:
            r3 = r2
        L_0x0045:
            if (r3 == 0) goto L_0x0067
            int r4 = r3.X
            if (r4 > r0) goto L_0x0053
            if (r4 != r0) goto L_0x0067
            long r3 = r3.Y
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x0067
        L_0x0053:
            int r3 = r1 + -1
            if (r3 <= 0) goto L_0x0062
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r4 = r8.i3
            int r1 = r1 + -2
            java.lang.Object r1 = r4.get(r1)
            androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo r1 = (androidx.media3.exoplayer.ExoPlayerImplInternal.PendingMessageInfo) r1
            goto L_0x0063
        L_0x0062:
            r1 = r2
        L_0x0063:
            r7 = r3
            r3 = r1
            r1 = r7
            goto L_0x0045
        L_0x0067:
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r8.i3
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0078
        L_0x006f:
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r8.i3
            java.lang.Object r3 = r3.get(r1)
            androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo r3 = (androidx.media3.exoplayer.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0079
        L_0x0078:
            r3 = r2
        L_0x0079:
            if (r3 == 0) goto L_0x0096
            java.lang.Object r4 = r3.Z
            if (r4 == 0) goto L_0x0096
            int r4 = r3.X
            if (r4 < r0) goto L_0x008b
            if (r4 != r0) goto L_0x0096
            long r4 = r3.Y
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 > 0) goto L_0x0096
        L_0x008b:
            int r1 = r1 + 1
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r8.i3
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x0078
            goto L_0x006f
        L_0x0096:
            if (r3 == 0) goto L_0x00f2
            java.lang.Object r4 = r3.Z
            if (r4 == 0) goto L_0x00f2
            int r4 = r3.X
            if (r4 != r0) goto L_0x00f2
            long r4 = r3.Y
            int r6 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x00f2
            int r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r6 > 0) goto L_0x00f2
            androidx.media3.exoplayer.PlayerMessage r4 = r3.s     // Catch:{ all -> 0x00db }
            r8.Q0(r4)     // Catch:{ all -> 0x00db }
            androidx.media3.exoplayer.PlayerMessage r4 = r3.s
            boolean r4 = r4.d()
            if (r4 != 0) goto L_0x00c3
            androidx.media3.exoplayer.PlayerMessage r3 = r3.s
            boolean r3 = r3.l()
            if (r3 == 0) goto L_0x00c0
            goto L_0x00c3
        L_0x00c0:
            int r1 = r1 + 1
            goto L_0x00c8
        L_0x00c3:
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r8.i3
            r3.remove(r1)
        L_0x00c8:
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r8.i3
            int r3 = r3.size()
            if (r1 >= r3) goto L_0x00d9
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r3 = r8.i3
            java.lang.Object r3 = r3.get(r1)
            androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo r3 = (androidx.media3.exoplayer.ExoPlayerImplInternal.PendingMessageInfo) r3
            goto L_0x0096
        L_0x00d9:
            r3 = r2
            goto L_0x0096
        L_0x00db:
            r9 = move-exception
            androidx.media3.exoplayer.PlayerMessage r10 = r3.s
            boolean r10 = r10.d()
            if (r10 != 0) goto L_0x00ec
            androidx.media3.exoplayer.PlayerMessage r10 = r3.s
            boolean r10 = r10.l()
            if (r10 == 0) goto L_0x00f1
        L_0x00ec:
            java.util.ArrayList<androidx.media3.exoplayer.ExoPlayerImplInternal$PendingMessageInfo> r10 = r8.i3
            r10.remove(r1)
        L_0x00f1:
            throw r9
        L_0x00f2:
            r8.G3 = r1
        L_0x00f4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.d0(long, long):void");
    }

    private void d1(boolean z, int i2, boolean z2, int i5) throws ExoPlaybackException {
        this.r3.b(z2 ? 1 : 0);
        this.r3.c(i5);
        this.q3 = this.q3.e(z, i2);
        F1(false, false);
        n0(z);
        if (!r1()) {
            x1();
            D1();
            return;
        }
        int i6 = this.q3.f10308e;
        if (i6 == 3) {
            F1(false, false);
            this.h3.e();
            u1();
        } else if (i6 != 2) {
            return;
        }
        this.a3.i(2);
    }

    private void e0() throws ExoPlaybackException {
        MediaPeriodInfo q;
        this.l3.C(this.F3);
        if (this.l3.I() && (q = this.l3.q(this.F3, this.q3)) != null) {
            MediaPeriodHolder g2 = this.l3.g(q);
            g2.f10235a.r(this, q.f10250b);
            if (this.l3.r() == g2) {
                C0(q.f10250b);
            }
            M(false);
        }
        if (this.x3) {
            this.x3 = V();
            y1();
            return;
        }
        b0();
    }

    private void f0() {
        boolean z;
        MediaPeriodHolder r = this.l3.r();
        if (r != null) {
            TrackSelectorResult o = r.o();
            boolean z2 = false;
            int i2 = 0;
            boolean z4 = false;
            while (true) {
                if (i2 >= this.s.length) {
                    z = true;
                    break;
                }
                if (o.c(i2)) {
                    if (this.s[i2].i() != 1) {
                        z = false;
                        break;
                    } else if (o.f12417b[i2].f10443a != 0) {
                        z4 = true;
                    }
                }
                i2++;
            }
            if (z4 && z) {
                z2 = true;
            }
            Z0(z2);
        }
    }

    private void f1(PlaybackParameters playbackParameters) throws ExoPlaybackException {
        W0(playbackParameters);
        Q(this.h3.r(), true);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0069 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g0() throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r14 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            boolean r2 = r14.p1()
            if (r2 == 0) goto L_0x006e
            if (r1 == 0) goto L_0x000d
            r14.c0()
        L_0x000d:
            androidx.media3.exoplayer.MediaPeriodQueue r1 = r14.l3
            androidx.media3.exoplayer.MediaPeriodHolder r1 = r1.b()
            java.lang.Object r1 = androidx.media3.common.util.Assertions.g(r1)
            androidx.media3.exoplayer.MediaPeriodHolder r1 = (androidx.media3.exoplayer.MediaPeriodHolder) r1
            androidx.media3.exoplayer.PlaybackInfo r2 = r14.q3
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r2.f10305b
            java.lang.Object r2 = r2.f12163a
            androidx.media3.exoplayer.MediaPeriodInfo r3 = r1.f10240f
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r3.f10249a
            java.lang.Object r3 = r3.f12163a
            boolean r2 = r2.equals(r3)
            r3 = 1
            if (r2 == 0) goto L_0x0045
            androidx.media3.exoplayer.PlaybackInfo r2 = r14.q3
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r2.f10305b
            int r4 = r2.f12164b
            r5 = -1
            if (r4 != r5) goto L_0x0045
            androidx.media3.exoplayer.MediaPeriodInfo r4 = r1.f10240f
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r4 = r4.f10249a
            int r6 = r4.f12164b
            if (r6 != r5) goto L_0x0045
            int r2 = r2.f12167e
            int r4 = r4.f12167e
            if (r2 == r4) goto L_0x0045
            r2 = 1
            goto L_0x0046
        L_0x0045:
            r2 = 0
        L_0x0046:
            androidx.media3.exoplayer.MediaPeriodInfo r1 = r1.f10240f
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r5 = r1.f10249a
            long r10 = r1.f10250b
            long r8 = r1.f10251c
            r12 = r2 ^ 1
            r13 = 0
            r4 = r14
            r6 = r10
            androidx.media3.exoplayer.PlaybackInfo r1 = r4.R(r5, r6, r8, r10, r12, r13)
            r14.q3 = r1
            r14.B0()
            r14.D1()
            androidx.media3.exoplayer.PlaybackInfo r1 = r14.q3
            int r1 = r1.f10308e
            r2 = 3
            if (r1 != r2) goto L_0x0069
            r14.u1()
        L_0x0069:
            r14.q()
            r1 = 1
            goto L_0x0002
        L_0x006e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.g0():void");
    }

    private void h0() throws ExoPlaybackException {
        MediaPeriodHolder s2 = this.l3.s();
        if (s2 != null) {
            int i2 = 0;
            if (s2.j() == null || this.u3) {
                if (s2.f10240f.f10257i || this.u3) {
                    while (true) {
                        Renderer[] rendererArr = this.s;
                        if (i2 < rendererArr.length) {
                            Renderer renderer = rendererArr[i2];
                            SampleStream sampleStream = s2.f10237c[i2];
                            if (sampleStream != null && renderer.e() == sampleStream && renderer.l()) {
                                long j2 = s2.f10240f.f10253e;
                                T0(renderer, (j2 == C.f9084b || j2 == Long.MIN_VALUE) ? -9223372036854775807L : s2.l() + s2.f10240f.f10253e);
                            }
                            i2++;
                        } else {
                            return;
                        }
                    }
                }
            } else if (T()) {
                if (s2.j().f10238d || this.F3 >= s2.j().m()) {
                    TrackSelectorResult o = s2.o();
                    MediaPeriodHolder c2 = this.l3.c();
                    TrackSelectorResult o2 = c2.o();
                    Timeline timeline = this.q3.f10304a;
                    E1(timeline, c2.f10240f.f10249a, timeline, s2.f10240f.f10249a, C.f9084b, false);
                    if (!c2.f10238d || c2.f10235a.q() == C.f9084b) {
                        for (int i5 = 0; i5 < this.s.length; i5++) {
                            boolean c5 = o.c(i5);
                            boolean c6 = o2.c(i5);
                            if (c5 && !this.s[i5].F()) {
                                boolean z = this.Y[i5].i() == -2;
                                RendererConfiguration rendererConfiguration = o.f12417b[i5];
                                RendererConfiguration rendererConfiguration2 = o2.f12417b[i5];
                                if (!c6 || !rendererConfiguration2.equals(rendererConfiguration) || z) {
                                    T0(this.s[i5], c2.m());
                                }
                            }
                        }
                        return;
                    }
                    S0(c2.m());
                    if (!c2.q()) {
                        this.l3.D(c2);
                        M(false);
                        b0();
                    }
                }
            }
        }
    }

    private void h1(int i2) throws ExoPlaybackException {
        this.y3 = i2;
        if (!this.l3.L(this.q3.f10304a, i2)) {
            L0(true);
        }
        M(false);
    }

    private void i0() throws ExoPlaybackException {
        MediaPeriodHolder s2 = this.l3.s();
        if (s2 != null && this.l3.r() != s2 && !s2.f10241g && x0()) {
            x();
        }
    }

    private void j0() throws ExoPlaybackException {
        N(this.m3.j(), true);
    }

    private void j1(SeekParameters seekParameters) {
        this.p3 = seekParameters;
    }

    private void k0(MoveMediaItemsMessage moveMediaItemsMessage) throws ExoPlaybackException {
        this.r3.b(1);
        N(this.m3.y(moveMediaItemsMessage.f10205a, moveMediaItemsMessage.f10206b, moveMediaItemsMessage.f10207c, moveMediaItemsMessage.f10208d), false);
    }

    private void l1(boolean z) throws ExoPlaybackException {
        this.z3 = z;
        if (!this.l3.M(this.q3.f10304a, z)) {
            L0(true);
        }
        M(false);
    }

    private void m0() {
        for (MediaPeriodHolder r = this.l3.r(); r != null; r = r.j()) {
            for (ExoTrackSelection exoTrackSelection : r.o().f12418c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.t();
                }
            }
        }
    }

    private void n(MediaSourceListUpdateMessage mediaSourceListUpdateMessage, int i2) throws ExoPlaybackException {
        this.r3.b(1);
        MediaSourceList mediaSourceList = this.m3;
        if (i2 == -1) {
            i2 = mediaSourceList.s();
        }
        N(mediaSourceList.f(i2, mediaSourceListUpdateMessage.f10201a, mediaSourceListUpdateMessage.f10202b), false);
    }

    private void n0(boolean z) {
        for (MediaPeriodHolder r = this.l3.r(); r != null; r = r.j()) {
            for (ExoTrackSelection exoTrackSelection : r.o().f12418c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.g(z);
                }
            }
        }
    }

    private void n1(ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.r3.b(1);
        N(this.m3.G(shuffleOrder), false);
    }

    private void o0() {
        for (MediaPeriodHolder r = this.l3.r(); r != null; r = r.j()) {
            for (ExoTrackSelection exoTrackSelection : r.o().f12418c) {
                if (exoTrackSelection != null) {
                    exoTrackSelection.u();
                }
            }
        }
    }

    private void o1(int i2) {
        PlaybackInfo playbackInfo = this.q3;
        if (playbackInfo.f10308e != i2) {
            if (i2 != 2) {
                this.K3 = C.f9084b;
            }
            this.q3 = playbackInfo.h(i2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0016, code lost:
        r0 = (r0 = r7.l3.r()).j();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean p1() {
        /*
            r7 = this;
            boolean r0 = r7.r1()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            boolean r0 = r7.u3
            if (r0 == 0) goto L_0x000d
            return r1
        L_0x000d:
            androidx.media3.exoplayer.MediaPeriodQueue r0 = r7.l3
            androidx.media3.exoplayer.MediaPeriodHolder r0 = r0.r()
            if (r0 != 0) goto L_0x0016
            return r1
        L_0x0016:
            androidx.media3.exoplayer.MediaPeriodHolder r0 = r0.j()
            if (r0 == 0) goto L_0x002b
            long r2 = r7.F3
            long r4 = r0.m()
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 < 0) goto L_0x002b
            boolean r0 = r0.f10241g
            if (r0 == 0) goto L_0x002b
            r1 = 1
        L_0x002b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.p1():boolean");
    }

    private void q() {
        TrackSelectorResult o = this.l3.r().o();
        for (int i2 = 0; i2 < this.s.length; i2++) {
            if (o.c(i2)) {
                this.s[i2].p();
            }
        }
    }

    private boolean q1() {
        if (!V()) {
            return false;
        }
        MediaPeriodHolder l2 = this.l3.l();
        long J = J(l2.k());
        long y = l2 == this.l3.r() ? l2.y(this.F3) : l2.y(this.F3) - l2.f10240f.f10250b;
        boolean j2 = this.Y2.j(y, J, this.h3.r().s);
        if (j2 || J >= q4) {
            return j2;
        }
        if (this.f3 <= 0 && !this.g3) {
            return j2;
        }
        this.l3.r().f10235a.t(this.q3.r, false);
        return this.Y2.j(y, J, this.h3.r().s);
    }

    private void r() throws ExoPlaybackException {
        z0();
    }

    private void r0() {
        this.r3.b(1);
        A0(false, false, false, true);
        this.Y2.b();
        o1(this.q3.f10304a.x() ? 4 : 2);
        this.m3.z(this.Z2.f());
        this.a3.i(2);
    }

    private boolean r1() {
        PlaybackInfo playbackInfo = this.q3;
        return playbackInfo.f10315l && playbackInfo.f10316m == 0;
    }

    /* access modifiers changed from: private */
    public MediaPeriodHolder s(MediaPeriodInfo mediaPeriodInfo, long j2) {
        return new MediaPeriodHolder(this.Y, j2, this.Z, this.Y2.k(), this.m3, mediaPeriodInfo, this.X2);
    }

    private boolean s1(boolean z) {
        if (this.D3 == 0) {
            return X();
        }
        if (!z) {
            return false;
        }
        if (!this.q3.f10310g) {
            return true;
        }
        MediaPeriodHolder r = this.l3.r();
        long c2 = t1(this.q3.f10304a, r.f10240f.f10249a) ? this.n3.c() : C.f9084b;
        MediaPeriodHolder l2 = this.l3.l();
        return (l2.q() && l2.f10240f.f10257i) || (l2.f10240f.f10249a.c() && !l2.f10238d) || this.Y2.d(this.q3.f10304a, r.f10240f.f10249a, I(), this.h3.r().s, this.v3, c2);
    }

    private void t(PlayerMessage playerMessage) throws ExoPlaybackException {
        if (!playerMessage.l()) {
            try {
                playerMessage.i().z(playerMessage.k(), playerMessage.g());
            } finally {
                playerMessage.m(true);
            }
        }
    }

    private void t0() {
        try {
            A0(true, false, true, false);
            u0();
            this.Y2.g();
            o1(1);
            HandlerThread handlerThread = this.b3;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            synchronized (this) {
                this.s3 = true;
                notifyAll();
            }
        } catch (Throwable th) {
            HandlerThread handlerThread2 = this.b3;
            if (handlerThread2 != null) {
                handlerThread2.quit();
            }
            synchronized (this) {
                this.s3 = true;
                notifyAll();
                throw th;
            }
        }
    }

    private boolean t1(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId) {
        if (mediaPeriodId.c() || timeline.x()) {
            return false;
        }
        timeline.u(timeline.m(mediaPeriodId.f12163a, this.e3).Y, this.d3);
        if (!this.d3.j()) {
            return false;
        }
        Timeline.Window window = this.d3;
        return window.b3 && window.Y2 != C.f9084b;
    }

    private void u(Renderer renderer) throws ExoPlaybackException {
        if (W(renderer)) {
            this.h3.a(renderer);
            z(renderer);
            renderer.h();
            this.D3--;
        }
    }

    private void u0() {
        for (int i2 = 0; i2 < this.s.length; i2++) {
            this.Y[i2].k();
            this.s[i2].a();
        }
    }

    private void u1() throws ExoPlaybackException {
        MediaPeriodHolder r = this.l3.r();
        if (r != null) {
            TrackSelectorResult o = r.o();
            for (int i2 = 0; i2 < this.s.length; i2++) {
                if (o.c(i2) && this.s[i2].getState() == 1) {
                    this.s[i2].start();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x01b3  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x01b5  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x01c9  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01df  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01e2 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0149  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void v() throws androidx.media3.exoplayer.ExoPlaybackException, java.io.IOException {
        /*
            r15 = this;
            r0 = r15
            androidx.media3.common.util.Clock r1 = r0.j3
            long r1 = r1.d()
            androidx.media3.common.util.HandlerWrapper r3 = r0.a3
            r4 = 2
            r3.l(r4)
            r15.C1()
            androidx.media3.exoplayer.PlaybackInfo r3 = r0.q3
            int r3 = r3.f10308e
            r5 = 1
            if (r3 == r5) goto L_0x01f0
            r6 = 4
            if (r3 != r6) goto L_0x001c
            goto L_0x01f0
        L_0x001c:
            androidx.media3.exoplayer.MediaPeriodQueue r3 = r0.l3
            androidx.media3.exoplayer.MediaPeriodHolder r3 = r3.r()
            r7 = 10
            if (r3 != 0) goto L_0x002a
            r15.J0(r1, r7)
            return
        L_0x002a:
            java.lang.String r9 = "doSomeWork"
            androidx.media3.common.util.TraceUtil.a(r9)
            r15.D1()
            boolean r9 = r3.f10238d
            r10 = 0
            if (r9 == 0) goto L_0x00ad
            androidx.media3.common.util.Clock r9 = r0.j3
            long r11 = r9.b()
            long r11 = androidx.media3.common.util.Util.I1(r11)
            androidx.media3.exoplayer.source.MediaPeriod r9 = r3.f10235a
            androidx.media3.exoplayer.PlaybackInfo r13 = r0.q3
            long r13 = r13.r
            long r7 = r0.f3
            long r13 = r13 - r7
            boolean r7 = r0.g3
            r9.t(r13, r7)
            r7 = 0
            r8 = 1
            r9 = 1
        L_0x0052:
            androidx.media3.exoplayer.Renderer[] r13 = r0.s
            int r14 = r13.length
            if (r7 >= r14) goto L_0x00b4
            r13 = r13[r7]
            boolean r14 = W(r13)
            if (r14 != 0) goto L_0x0060
            goto L_0x00a8
        L_0x0060:
            long r4 = r0.F3
            r13.g(r4, r11)
            if (r8 == 0) goto L_0x006f
            boolean r4 = r13.c()
            if (r4 == 0) goto L_0x006f
            r8 = 1
            goto L_0x0070
        L_0x006f:
            r8 = 0
        L_0x0070:
            androidx.media3.exoplayer.source.SampleStream[] r4 = r3.f10237c
            r4 = r4[r7]
            androidx.media3.exoplayer.source.SampleStream r5 = r13.e()
            if (r4 == r5) goto L_0x007c
            r4 = 1
            goto L_0x007d
        L_0x007c:
            r4 = 0
        L_0x007d:
            if (r4 != 0) goto L_0x0087
            boolean r5 = r13.l()
            if (r5 == 0) goto L_0x0087
            r5 = 1
            goto L_0x0088
        L_0x0087:
            r5 = 0
        L_0x0088:
            if (r4 != 0) goto L_0x009b
            if (r5 != 0) goto L_0x009b
            boolean r4 = r13.d()
            if (r4 != 0) goto L_0x009b
            boolean r4 = r13.c()
            if (r4 == 0) goto L_0x0099
            goto L_0x009b
        L_0x0099:
            r4 = 0
            goto L_0x009c
        L_0x009b:
            r4 = 1
        L_0x009c:
            if (r9 == 0) goto L_0x00a2
            if (r4 == 0) goto L_0x00a2
            r9 = 1
            goto L_0x00a3
        L_0x00a2:
            r9 = 0
        L_0x00a3:
            if (r4 != 0) goto L_0x00a8
            r13.B()
        L_0x00a8:
            int r7 = r7 + 1
            r4 = 2
            r5 = 1
            goto L_0x0052
        L_0x00ad:
            androidx.media3.exoplayer.source.MediaPeriod r4 = r3.f10235a
            r4.l()
            r8 = 1
            r9 = 1
        L_0x00b4:
            androidx.media3.exoplayer.MediaPeriodInfo r4 = r3.f10240f
            long r4 = r4.f10253e
            r11 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r8 == 0) goto L_0x00d1
            boolean r7 = r3.f10238d
            if (r7 == 0) goto L_0x00d1
            int r7 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x00cf
            androidx.media3.exoplayer.PlaybackInfo r7 = r0.q3
            long r7 = r7.r
            int r13 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r13 > 0) goto L_0x00d1
        L_0x00cf:
            r4 = 1
            goto L_0x00d2
        L_0x00d1:
            r4 = 0
        L_0x00d2:
            if (r4 == 0) goto L_0x00e2
            boolean r5 = r0.u3
            if (r5 == 0) goto L_0x00e2
            r0.u3 = r10
            androidx.media3.exoplayer.PlaybackInfo r5 = r0.q3
            int r5 = r5.f10316m
            r7 = 5
            r15.d1(r10, r5, r10, r7)
        L_0x00e2:
            r5 = 3
            if (r4 == 0) goto L_0x00f2
            androidx.media3.exoplayer.MediaPeriodInfo r4 = r3.f10240f
            boolean r4 = r4.f10257i
            if (r4 == 0) goto L_0x00f2
            r15.o1(r6)
        L_0x00ee:
            r15.x1()
            goto L_0x0142
        L_0x00f2:
            androidx.media3.exoplayer.PlaybackInfo r4 = r0.q3
            int r4 = r4.f10308e
            r7 = 2
            if (r4 != r7) goto L_0x0117
            boolean r4 = r15.s1(r9)
            if (r4 == 0) goto L_0x0117
            r15.o1(r5)
            r4 = 0
            r0.I3 = r4
            boolean r4 = r15.r1()
            if (r4 == 0) goto L_0x0142
            r15.F1(r10, r10)
            androidx.media3.exoplayer.DefaultMediaClock r4 = r0.h3
            r4.e()
            r15.u1()
            goto L_0x0142
        L_0x0117:
            androidx.media3.exoplayer.PlaybackInfo r4 = r0.q3
            int r4 = r4.f10308e
            if (r4 != r5) goto L_0x0142
            int r4 = r0.D3
            if (r4 != 0) goto L_0x0128
            boolean r4 = r15.X()
            if (r4 == 0) goto L_0x012a
            goto L_0x0142
        L_0x0128:
            if (r9 != 0) goto L_0x0142
        L_0x012a:
            boolean r4 = r15.r1()
            r15.F1(r4, r10)
            r4 = 2
            r15.o1(r4)
            boolean r4 = r0.v3
            if (r4 == 0) goto L_0x00ee
            r15.o0()
            androidx.media3.exoplayer.LivePlaybackSpeedControl r4 = r0.n3
            r4.d()
            goto L_0x00ee
        L_0x0142:
            androidx.media3.exoplayer.PlaybackInfo r4 = r0.q3
            int r4 = r4.f10308e
            r7 = 2
            if (r4 != r7) goto L_0x01a5
            r4 = 0
        L_0x014a:
            androidx.media3.exoplayer.Renderer[] r7 = r0.s
            int r8 = r7.length
            if (r4 >= r8) goto L_0x016f
            r7 = r7[r4]
            boolean r7 = W(r7)
            if (r7 == 0) goto L_0x016c
            androidx.media3.exoplayer.Renderer[] r7 = r0.s
            r7 = r7[r4]
            androidx.media3.exoplayer.source.SampleStream r7 = r7.e()
            androidx.media3.exoplayer.source.SampleStream[] r8 = r3.f10237c
            r8 = r8[r4]
            if (r7 != r8) goto L_0x016c
            androidx.media3.exoplayer.Renderer[] r7 = r0.s
            r7 = r7[r4]
            r7.B()
        L_0x016c:
            int r4 = r4 + 1
            goto L_0x014a
        L_0x016f:
            androidx.media3.exoplayer.PlaybackInfo r3 = r0.q3
            boolean r4 = r3.f10310g
            if (r4 != 0) goto L_0x01a5
            long r3 = r3.q
            r7 = 500000(0x7a120, double:2.47033E-318)
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x01a5
            boolean r3 = r15.V()
            if (r3 == 0) goto L_0x01a5
            long r3 = r0.K3
            int r7 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            androidx.media3.common.util.Clock r3 = r0.j3
            long r3 = r3.b()
            if (r7 != 0) goto L_0x0193
            r0.K3 = r3
            goto L_0x01a7
        L_0x0193:
            long r7 = r0.K3
            long r3 = r3 - r7
            r7 = 4000(0xfa0, double:1.9763E-320)
            int r9 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r9 >= 0) goto L_0x019d
            goto L_0x01a7
        L_0x019d:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "Playback stuck buffering and not loading"
            r1.<init>(r2)
            throw r1
        L_0x01a5:
            r0.K3 = r11
        L_0x01a7:
            boolean r3 = r15.r1()
            if (r3 == 0) goto L_0x01b5
            androidx.media3.exoplayer.PlaybackInfo r3 = r0.q3
            int r3 = r3.f10308e
            if (r3 != r5) goto L_0x01b5
            r3 = 1
            goto L_0x01b6
        L_0x01b5:
            r3 = 0
        L_0x01b6:
            boolean r4 = r0.C3
            if (r4 == 0) goto L_0x01c2
            boolean r4 = r0.B3
            if (r4 == 0) goto L_0x01c2
            if (r3 == 0) goto L_0x01c2
            r4 = 1
            goto L_0x01c3
        L_0x01c2:
            r4 = 0
        L_0x01c3:
            androidx.media3.exoplayer.PlaybackInfo r7 = r0.q3
            boolean r8 = r7.o
            if (r8 == r4) goto L_0x01cf
            androidx.media3.exoplayer.PlaybackInfo r7 = r7.i(r4)
            r0.q3 = r7
        L_0x01cf:
            r0.B3 = r10
            if (r4 != 0) goto L_0x01ed
            androidx.media3.exoplayer.PlaybackInfo r4 = r0.q3
            int r4 = r4.f10308e
            if (r4 != r6) goto L_0x01da
            goto L_0x01ed
        L_0x01da:
            if (r3 != 0) goto L_0x01df
            r3 = 2
            if (r4 != r3) goto L_0x01e2
        L_0x01df:
            r3 = 10
            goto L_0x01ea
        L_0x01e2:
            if (r4 != r5) goto L_0x01ed
            int r3 = r0.D3
            if (r3 == 0) goto L_0x01ed
            r3 = 1000(0x3e8, double:4.94E-321)
        L_0x01ea:
            r15.J0(r1, r3)
        L_0x01ed:
            androidx.media3.common.util.TraceUtil.c()
        L_0x01f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.v():void");
    }

    private void v0(int i2, int i5, ShuffleOrder shuffleOrder) throws ExoPlaybackException {
        this.r3.b(1);
        N(this.m3.D(i2, i5, shuffleOrder), false);
    }

    private void w(int i2, boolean z, long j2) throws ExoPlaybackException {
        Renderer renderer = this.s[i2];
        if (!W(renderer)) {
            MediaPeriodHolder s2 = this.l3.s();
            boolean z2 = s2 == this.l3.r();
            TrackSelectorResult o = s2.o();
            RendererConfiguration rendererConfiguration = o.f12417b[i2];
            Format[] D = D(o.f12418c[i2]);
            boolean z4 = r1() && this.q3.f10308e == 3;
            boolean z5 = !z && z4;
            this.D3++;
            this.X.add(renderer);
            renderer.n(rendererConfiguration, D, s2.f10237c[i2], this.F3, z5, z2, j2, s2.l(), s2.f10240f.f10249a);
            renderer.z(11, new Renderer.WakeupListener() {
                public void a() {
                    boolean unused = ExoPlayerImplInternal.this.B3 = true;
                }

                public void b() {
                    ExoPlayerImplInternal.this.a3.i(2);
                }
            });
            this.h3.b(renderer);
            if (z4 && z2) {
                renderer.start();
            }
        }
    }

    private void w1(boolean z, boolean z2) {
        A0(z || !this.A3, false, true, false);
        this.r3.b(z2 ? 1 : 0);
        this.Y2.l();
        o1(1);
    }

    private void x() throws ExoPlaybackException {
        y(new boolean[this.s.length], this.l3.s().m());
    }

    private boolean x0() throws ExoPlaybackException {
        MediaPeriodHolder s2 = this.l3.s();
        TrackSelectorResult o = s2.o();
        int i2 = 0;
        boolean z = false;
        while (true) {
            Renderer[] rendererArr = this.s;
            if (i2 >= rendererArr.length) {
                return !z;
            }
            Renderer renderer = rendererArr[i2];
            if (W(renderer)) {
                boolean z2 = renderer.e() != s2.f10237c[i2];
                if (!o.c(i2) || z2) {
                    if (!renderer.F()) {
                        renderer.A(D(o.f12418c[i2]), s2.f10237c[i2], s2.m(), s2.l(), s2.f10240f.f10249a);
                        if (this.C3) {
                            Z0(false);
                        }
                    } else if (renderer.c()) {
                        u(renderer);
                    } else {
                        z = true;
                    }
                }
            }
            i2++;
        }
    }

    private void x1() throws ExoPlaybackException {
        this.h3.g();
        for (Renderer renderer : this.s) {
            if (W(renderer)) {
                z(renderer);
            }
        }
    }

    private void y(boolean[] zArr, long j2) throws ExoPlaybackException {
        MediaPeriodHolder s2 = this.l3.s();
        TrackSelectorResult o = s2.o();
        for (int i2 = 0; i2 < this.s.length; i2++) {
            if (!o.c(i2) && this.X.remove(this.s[i2])) {
                this.s[i2].reset();
            }
        }
        for (int i5 = 0; i5 < this.s.length; i5++) {
            if (o.c(i5)) {
                w(i5, zArr[i5], j2);
            }
        }
        s2.f10241g = true;
    }

    private void y0() throws ExoPlaybackException {
        float f2 = this.h3.r().s;
        MediaPeriodHolder r = this.l3.r();
        MediaPeriodHolder s2 = this.l3.s();
        TrackSelectorResult trackSelectorResult = null;
        boolean z = true;
        while (r != null && r.f10238d) {
            TrackSelectorResult v = r.v(f2, this.q3.f10304a);
            if (r == this.l3.r()) {
                trackSelectorResult = v;
            }
            if (!v.a(r.o())) {
                MediaPeriodQueue mediaPeriodQueue = this.l3;
                if (z) {
                    MediaPeriodHolder r2 = mediaPeriodQueue.r();
                    boolean D = this.l3.D(r2);
                    boolean[] zArr = new boolean[this.s.length];
                    long b2 = r2.b((TrackSelectorResult) Assertions.g(trackSelectorResult), this.q3.r, D, zArr);
                    PlaybackInfo playbackInfo = this.q3;
                    boolean z2 = (playbackInfo.f10308e == 4 || b2 == playbackInfo.r) ? false : true;
                    PlaybackInfo playbackInfo2 = this.q3;
                    long j2 = b2;
                    this.q3 = R(playbackInfo2.f10305b, b2, playbackInfo2.f10306c, playbackInfo2.f10307d, z2, 5);
                    if (z2) {
                        C0(j2);
                    }
                    boolean[] zArr2 = new boolean[this.s.length];
                    int i2 = 0;
                    while (true) {
                        Renderer[] rendererArr = this.s;
                        if (i2 >= rendererArr.length) {
                            break;
                        }
                        Renderer renderer = rendererArr[i2];
                        boolean W = W(renderer);
                        zArr2[i2] = W;
                        SampleStream sampleStream = r2.f10237c[i2];
                        if (W) {
                            if (sampleStream != renderer.e()) {
                                u(renderer);
                            } else if (zArr[i2]) {
                                renderer.E(this.F3);
                            }
                        }
                        i2++;
                    }
                    y(zArr2, this.F3);
                } else {
                    mediaPeriodQueue.D(r);
                    if (r.f10238d) {
                        r.a(v, Math.max(r.f10240f.f10250b, r.y(this.F3)), false);
                    }
                }
                M(true);
                if (this.q3.f10308e != 4) {
                    b0();
                    D1();
                    this.a3.i(2);
                    return;
                }
                return;
            }
            if (r == s2) {
                z = false;
            }
            r = r.j();
        }
    }

    private void y1() {
        MediaPeriodHolder l2 = this.l3.l();
        boolean z = this.x3 || (l2 != null && l2.f10235a.c());
        PlaybackInfo playbackInfo = this.q3;
        if (z != playbackInfo.f10310g) {
            this.q3 = playbackInfo.b(z);
        }
    }

    private void z(Renderer renderer) {
        if (renderer.getState() == 2) {
            renderer.stop();
        }
    }

    private void z0() throws ExoPlaybackException {
        y0();
        L0(true);
    }

    private void z1(MediaSource.MediaPeriodId mediaPeriodId, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult) {
        this.Y2.h(this.q3.f10304a, mediaPeriodId, this.s, trackGroupArray, trackSelectorResult.f12418c);
    }

    public void A(long j2) {
        this.J3 = j2;
    }

    public void A1(int i2, int i5, List<MediaItem> list) {
        this.a3.j(27, i2, i5, list).a();
    }

    public Looper H() {
        return this.c3;
    }

    public void K0(Timeline timeline, int i2, long j2) {
        this.a3.m(3, new SeekPosition(timeline, i2, j2)).a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0044, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean U0(boolean r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.s3     // Catch:{ all -> 0x0023 }
            r1 = 1
            if (r0 != 0) goto L_0x0043
            android.os.Looper r0 = r3.c3     // Catch:{ all -> 0x0023 }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x0023 }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0013
            goto L_0x0043
        L_0x0013:
            r0 = 13
            r2 = 0
            if (r4 == 0) goto L_0x0025
            androidx.media3.common.util.HandlerWrapper r4 = r3.a3     // Catch:{ all -> 0x0023 }
            androidx.media3.common.util.HandlerWrapper$Message r4 = r4.a(r0, r1, r2)     // Catch:{ all -> 0x0023 }
            r4.a()     // Catch:{ all -> 0x0023 }
            monitor-exit(r3)
            return r1
        L_0x0023:
            r4 = move-exception
            goto L_0x0045
        L_0x0025:
            java.util.concurrent.atomic.AtomicBoolean r4 = new java.util.concurrent.atomic.AtomicBoolean     // Catch:{ all -> 0x0023 }
            r4.<init>()     // Catch:{ all -> 0x0023 }
            androidx.media3.common.util.HandlerWrapper r1 = r3.a3     // Catch:{ all -> 0x0023 }
            androidx.media3.common.util.HandlerWrapper$Message r0 = r1.j(r0, r2, r2, r4)     // Catch:{ all -> 0x0023 }
            r0.a()     // Catch:{ all -> 0x0023 }
            androidx.media3.exoplayer.D0 r0 = new androidx.media3.exoplayer.D0     // Catch:{ all -> 0x0023 }
            r0.<init>(r4)     // Catch:{ all -> 0x0023 }
            long r1 = r3.J3     // Catch:{ all -> 0x0023 }
            r3.H1(r0, r1)     // Catch:{ all -> 0x0023 }
            boolean r4 = r4.get()     // Catch:{ all -> 0x0023 }
            monitor-exit(r3)
            return r4
        L_0x0043:
            monitor-exit(r3)
            return r1
        L_0x0045:
            monitor-exit(r3)     // Catch:{ all -> 0x0023 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.U0(boolean):boolean");
    }

    public void Y0(List<MediaSourceList.MediaSourceHolder> list, int i2, long j2, ShuffleOrder shuffleOrder) {
        this.a3.m(17, new MediaSourceListUpdateMessage(list, shuffleOrder, i2, j2)).a();
    }

    public void a(Renderer renderer) {
        this.a3.i(26);
    }

    public void a1(boolean z) {
        this.a3.a(23, z ? 1 : 0, 0).a();
    }

    public void c() {
        this.a3.i(10);
    }

    public void c1(boolean z, int i2) {
        this.a3.a(1, z ? 1 : 0, i2).a();
    }

    public void d() {
        this.a3.i(22);
    }

    public synchronized void e(PlayerMessage playerMessage) {
        if (!this.s3) {
            if (this.c3.getThread().isAlive()) {
                this.a3.m(14, playerMessage).a();
                return;
            }
        }
        Log.n(L3, "Ignoring messages sent after release.");
        playerMessage.m(false);
    }

    public void e1(PlaybackParameters playbackParameters) {
        this.a3.m(4, playbackParameters).a();
    }

    public void g1(int i2) {
        this.a3.a(11, i2, 0).a();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: androidx.media3.exoplayer.drm.DrmSession$DrmSessionException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: androidx.media3.datasource.DataSourceException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v57, resolved type: androidx.media3.exoplayer.drm.DrmSession$DrmSessionException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v58, resolved type: androidx.media3.exoplayer.drm.DrmSession$DrmSessionException} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v59, resolved type: androidx.media3.exoplayer.source.BehindLiveWindowException} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleMessage(android.os.Message r14) {
        /*
            r13 = this;
            java.lang.String r1 = "Playback error"
            java.lang.String r2 = "ExoPlayerImplInternal"
            r3 = 1000(0x3e8, float:1.401E-42)
            r11 = 0
            r12 = 1
            int r4 = r14.what     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            switch(r4) {
                case 0: goto L_0x010a;
                case 1: goto L_0x00fc;
                case 2: goto L_0x00f7;
                case 3: goto L_0x00ee;
                case 4: goto L_0x00e5;
                case 5: goto L_0x00dc;
                case 6: goto L_0x00d7;
                case 7: goto L_0x00d3;
                case 8: goto L_0x00ca;
                case 9: goto L_0x00c1;
                case 10: goto L_0x00bc;
                case 11: goto L_0x00b5;
                case 12: goto L_0x00a9;
                case 13: goto L_0x0099;
                case 14: goto L_0x0090;
                case 15: goto L_0x0087;
                case 16: goto L_0x007e;
                case 17: goto L_0x0075;
                case 18: goto L_0x006a;
                case 19: goto L_0x0061;
                case 20: goto L_0x0054;
                case 21: goto L_0x004b;
                case 22: goto L_0x0046;
                case 23: goto L_0x003a;
                case 24: goto L_0x000d;
                case 25: goto L_0x0035;
                case 26: goto L_0x0030;
                case 27: goto L_0x000e;
                default: goto L_0x000d;
            }     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
        L_0x000d:
            return r11
        L_0x000e:
            int r4 = r14.arg1     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            int r5 = r14.arg2     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            java.lang.Object r0 = r14.obj     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            java.util.List r0 = (java.util.List) r0     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.B1(r4, r5, r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x001b:
            r0 = move-exception
            goto L_0x010f
        L_0x001e:
            r0 = move-exception
            goto L_0x012d
        L_0x0021:
            r0 = move-exception
            goto L_0x0134
        L_0x0024:
            r0 = move-exception
            goto L_0x0137
        L_0x0027:
            r0 = move-exception
            goto L_0x013a
        L_0x002a:
            r0 = move-exception
            goto L_0x0161
        L_0x002d:
            r0 = move-exception
            goto L_0x0164
        L_0x0030:
            r13.z0()     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x0035:
            r13.r()     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x003a:
            int r0 = r14.arg1     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            if (r0 == 0) goto L_0x0040
            r0 = 1
            goto L_0x0041
        L_0x0040:
            r0 = 0
        L_0x0041:
            r13.b1(r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x0046:
            r13.j0()     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x004b:
            java.lang.Object r0 = r14.obj     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            androidx.media3.exoplayer.source.ShuffleOrder r0 = (androidx.media3.exoplayer.source.ShuffleOrder) r0     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.n1(r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x0054:
            int r4 = r14.arg1     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            int r5 = r14.arg2     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            java.lang.Object r0 = r14.obj     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            androidx.media3.exoplayer.source.ShuffleOrder r0 = (androidx.media3.exoplayer.source.ShuffleOrder) r0     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.v0(r4, r5, r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x0061:
            java.lang.Object r0 = r14.obj     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            androidx.media3.exoplayer.ExoPlayerImplInternal$MoveMediaItemsMessage r0 = (androidx.media3.exoplayer.ExoPlayerImplInternal.MoveMediaItemsMessage) r0     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.k0(r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x006a:
            java.lang.Object r4 = r14.obj     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            androidx.media3.exoplayer.ExoPlayerImplInternal$MediaSourceListUpdateMessage r4 = (androidx.media3.exoplayer.ExoPlayerImplInternal.MediaSourceListUpdateMessage) r4     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            int r0 = r14.arg1     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.n(r4, r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x0075:
            java.lang.Object r0 = r14.obj     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            androidx.media3.exoplayer.ExoPlayerImplInternal$MediaSourceListUpdateMessage r0 = (androidx.media3.exoplayer.ExoPlayerImplInternal.MediaSourceListUpdateMessage) r0     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.X0(r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x007e:
            java.lang.Object r0 = r14.obj     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            androidx.media3.common.PlaybackParameters r0 = (androidx.media3.common.PlaybackParameters) r0     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.Q(r0, r11)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x0087:
            java.lang.Object r0 = r14.obj     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            androidx.media3.exoplayer.PlayerMessage r0 = (androidx.media3.exoplayer.PlayerMessage) r0     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.R0(r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x0090:
            java.lang.Object r0 = r14.obj     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            androidx.media3.exoplayer.PlayerMessage r0 = (androidx.media3.exoplayer.PlayerMessage) r0     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.P0(r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x0099:
            int r4 = r14.arg1     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            if (r4 == 0) goto L_0x009f
            r4 = 1
            goto L_0x00a0
        L_0x009f:
            r4 = 0
        L_0x00a0:
            java.lang.Object r0 = r14.obj     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            java.util.concurrent.atomic.AtomicBoolean r0 = (java.util.concurrent.atomic.AtomicBoolean) r0     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.V0(r4, r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x00a9:
            int r0 = r14.arg1     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            if (r0 == 0) goto L_0x00af
            r0 = 1
            goto L_0x00b0
        L_0x00af:
            r0 = 0
        L_0x00b0:
            r13.l1(r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x00b5:
            int r0 = r14.arg1     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.h1(r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x00bc:
            r13.y0()     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x00c1:
            java.lang.Object r0 = r14.obj     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            androidx.media3.exoplayer.source.MediaPeriod r0 = (androidx.media3.exoplayer.source.MediaPeriod) r0     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.K(r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x00ca:
            java.lang.Object r0 = r14.obj     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            androidx.media3.exoplayer.source.MediaPeriod r0 = (androidx.media3.exoplayer.source.MediaPeriod) r0     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.O(r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x00d3:
            r13.t0()     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            return r12
        L_0x00d7:
            r13.w1(r11, r12)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x00dc:
            java.lang.Object r0 = r14.obj     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            androidx.media3.exoplayer.SeekParameters r0 = (androidx.media3.exoplayer.SeekParameters) r0     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.j1(r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x00e5:
            java.lang.Object r0 = r14.obj     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            androidx.media3.common.PlaybackParameters r0 = (androidx.media3.common.PlaybackParameters) r0     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.f1(r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x00ee:
            java.lang.Object r0 = r14.obj     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            androidx.media3.exoplayer.ExoPlayerImplInternal$SeekPosition r0 = (androidx.media3.exoplayer.ExoPlayerImplInternal.SeekPosition) r0     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.M0(r0)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x00f7:
            r13.v()     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x00fc:
            int r4 = r14.arg1     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            if (r4 == 0) goto L_0x0102
            r4 = 1
            goto L_0x0103
        L_0x0102:
            r4 = 0
        L_0x0103:
            int r0 = r14.arg2     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            r13.d1(r4, r0, r12, r12)     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x010a:
            r13.r0()     // Catch:{ ExoPlaybackException -> 0x002d, DrmSessionException -> 0x002a, ParserException -> 0x0027, DataSourceException -> 0x0024, BehindLiveWindowException -> 0x0021, IOException -> 0x001e, RuntimeException -> 0x001b }
            goto L_0x01f9
        L_0x010f:
            boolean r4 = r0 instanceof java.lang.IllegalStateException
            if (r4 != 0) goto L_0x0117
            boolean r4 = r0 instanceof java.lang.IllegalArgumentException
            if (r4 == 0) goto L_0x0119
        L_0x0117:
            r3 = 1004(0x3ec, float:1.407E-42)
        L_0x0119:
            androidx.media3.exoplayer.ExoPlaybackException r0 = androidx.media3.exoplayer.ExoPlaybackException.o(r0, r3)
            androidx.media3.common.util.Log.e(r2, r1, r0)
        L_0x0120:
            r13.w1(r12, r11)
            androidx.media3.exoplayer.PlaybackInfo r1 = r13.q3
            androidx.media3.exoplayer.PlaybackInfo r0 = r1.f(r0)
            r13.q3 = r0
            goto L_0x01f9
        L_0x012d:
            r1 = 2000(0x7d0, float:2.803E-42)
        L_0x012f:
            r13.L(r0, r1)
            goto L_0x01f9
        L_0x0134:
            r1 = 1002(0x3ea, float:1.404E-42)
            goto L_0x012f
        L_0x0137:
            int r1 = r0.s
            goto L_0x012f
        L_0x013a:
            int r1 = r0.X
            if (r1 != r12) goto L_0x014c
            boolean r1 = r0.s
            if (r1 == 0) goto L_0x0147
            r1 = 3001(0xbb9, float:4.205E-42)
            r3 = 3001(0xbb9, float:4.205E-42)
            goto L_0x015c
        L_0x0147:
            r1 = 3003(0xbbb, float:4.208E-42)
            r3 = 3003(0xbbb, float:4.208E-42)
            goto L_0x015c
        L_0x014c:
            r2 = 4
            if (r1 != r2) goto L_0x015c
            boolean r1 = r0.s
            if (r1 == 0) goto L_0x0158
            r1 = 3002(0xbba, float:4.207E-42)
            r3 = 3002(0xbba, float:4.207E-42)
            goto L_0x015c
        L_0x0158:
            r1 = 3004(0xbbc, float:4.21E-42)
            r3 = 3004(0xbbc, float:4.21E-42)
        L_0x015c:
            r13.L(r0, r3)
            goto L_0x01f9
        L_0x0161:
            int r1 = r0.s
            goto L_0x012f
        L_0x0164:
            int r3 = r0.P3
            if (r3 != r12) goto L_0x0178
            androidx.media3.exoplayer.MediaPeriodQueue r3 = r13.l3
            androidx.media3.exoplayer.MediaPeriodHolder r3 = r3.s()
            if (r3 == 0) goto L_0x0178
            androidx.media3.exoplayer.MediaPeriodInfo r3 = r3.f10240f
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r3 = r3.f10249a
            androidx.media3.exoplayer.ExoPlaybackException r0 = r0.j(r3)
        L_0x0178:
            boolean r3 = r0.V3
            if (r3 == 0) goto L_0x01a7
            androidx.media3.exoplayer.ExoPlaybackException r3 = r13.I3
            if (r3 == 0) goto L_0x018a
            int r3 = r0.s
            r4 = 5004(0x138c, float:7.012E-42)
            if (r3 == r4) goto L_0x018a
            r4 = 5003(0x138b, float:7.01E-42)
            if (r3 != r4) goto L_0x01a7
        L_0x018a:
            java.lang.String r1 = "Recoverable renderer error"
            androidx.media3.common.util.Log.o(r2, r1, r0)
            androidx.media3.exoplayer.ExoPlaybackException r1 = r13.I3
            if (r1 == 0) goto L_0x0199
            r1.addSuppressed(r0)
            androidx.media3.exoplayer.ExoPlaybackException r0 = r13.I3
            goto L_0x019b
        L_0x0199:
            r13.I3 = r0
        L_0x019b:
            androidx.media3.common.util.HandlerWrapper r1 = r13.a3
            r2 = 25
            androidx.media3.common.util.HandlerWrapper$Message r0 = r1.m(r2, r0)
            r1.b(r0)
            goto L_0x01f9
        L_0x01a7:
            androidx.media3.exoplayer.ExoPlaybackException r3 = r13.I3
            if (r3 == 0) goto L_0x01b0
            r3.addSuppressed(r0)
            androidx.media3.exoplayer.ExoPlaybackException r0 = r13.I3
        L_0x01b0:
            androidx.media3.common.util.Log.e(r2, r1, r0)
            int r1 = r0.P3
            if (r1 != r12) goto L_0x0120
            androidx.media3.exoplayer.MediaPeriodQueue r1 = r13.l3
            androidx.media3.exoplayer.MediaPeriodHolder r1 = r1.r()
            androidx.media3.exoplayer.MediaPeriodQueue r2 = r13.l3
            androidx.media3.exoplayer.MediaPeriodHolder r2 = r2.s()
            if (r1 == r2) goto L_0x0120
        L_0x01c5:
            androidx.media3.exoplayer.MediaPeriodQueue r1 = r13.l3
            androidx.media3.exoplayer.MediaPeriodHolder r1 = r1.r()
            androidx.media3.exoplayer.MediaPeriodQueue r2 = r13.l3
            androidx.media3.exoplayer.MediaPeriodHolder r2 = r2.s()
            if (r1 == r2) goto L_0x01d9
            androidx.media3.exoplayer.MediaPeriodQueue r1 = r13.l3
            r1.b()
            goto L_0x01c5
        L_0x01d9:
            androidx.media3.exoplayer.MediaPeriodQueue r1 = r13.l3
            androidx.media3.exoplayer.MediaPeriodHolder r1 = r1.r()
            java.lang.Object r1 = androidx.media3.common.util.Assertions.g(r1)
            androidx.media3.exoplayer.MediaPeriodHolder r1 = (androidx.media3.exoplayer.MediaPeriodHolder) r1
            androidx.media3.exoplayer.MediaPeriodInfo r1 = r1.f10240f
            androidx.media3.exoplayer.source.MediaSource$MediaPeriodId r2 = r1.f10249a
            long r7 = r1.f10250b
            long r5 = r1.f10251c
            r9 = 1
            r10 = 0
            r1 = r13
            r3 = r7
            androidx.media3.exoplayer.PlaybackInfo r1 = r1.R(r2, r3, r5, r7, r9, r10)
            r13.q3 = r1
            goto L_0x0120
        L_0x01f9:
            r13.c0()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.handleMessage(android.os.Message):boolean");
    }

    public void i(MediaPeriod mediaPeriod) {
        this.a3.m(8, mediaPeriod).a();
    }

    public void i1(SeekParameters seekParameters) {
        this.a3.m(5, seekParameters).a();
    }

    public void k(PlaybackParameters playbackParameters) {
        this.a3.m(16, playbackParameters).a();
    }

    public void k1(boolean z) {
        this.a3.a(12, z ? 1 : 0, 0).a();
    }

    public void l0(int i2, int i5, int i6, ShuffleOrder shuffleOrder) {
        this.a3.m(19, new MoveMediaItemsMessage(i2, i5, i6, shuffleOrder)).a();
    }

    public void m1(ShuffleOrder shuffleOrder) {
        this.a3.m(21, shuffleOrder).a();
    }

    public void p(int i2, List<MediaSourceList.MediaSourceHolder> list, ShuffleOrder shuffleOrder) {
        this.a3.j(18, i2, 0, new MediaSourceListUpdateMessage(list, shuffleOrder, -1, C.f9084b)).a();
    }

    /* renamed from: p0 */
    public void j(MediaPeriod mediaPeriod) {
        this.a3.m(9, mediaPeriod).a();
    }

    public void q0() {
        this.a3.f(0).a();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean s0() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.s3     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x0028
            android.os.Looper r0 = r3.c3     // Catch:{ all -> 0x0026 }
            java.lang.Thread r0 = r0.getThread()     // Catch:{ all -> 0x0026 }
            boolean r0 = r0.isAlive()     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x0012
            goto L_0x0028
        L_0x0012:
            androidx.media3.common.util.HandlerWrapper r0 = r3.a3     // Catch:{ all -> 0x0026 }
            r1 = 7
            r0.i(r1)     // Catch:{ all -> 0x0026 }
            androidx.media3.exoplayer.A0 r0 = new androidx.media3.exoplayer.A0     // Catch:{ all -> 0x0026 }
            r0.<init>(r3)     // Catch:{ all -> 0x0026 }
            long r1 = r3.o3     // Catch:{ all -> 0x0026 }
            r3.H1(r0, r1)     // Catch:{ all -> 0x0026 }
            boolean r0 = r3.s3     // Catch:{ all -> 0x0026 }
            monitor-exit(r3)
            return r0
        L_0x0026:
            r0 = move-exception
            goto L_0x002b
        L_0x0028:
            monitor-exit(r3)
            r0 = 1
            return r0
        L_0x002b:
            monitor-exit(r3)     // Catch:{ all -> 0x0026 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImplInternal.s0():boolean");
    }

    public void v1() {
        this.a3.f(6).a();
    }

    public void w0(int i2, int i5, ShuffleOrder shuffleOrder) {
        this.a3.j(20, i2, i5, shuffleOrder).a();
    }
}
