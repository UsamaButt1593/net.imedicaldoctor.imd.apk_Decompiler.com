package androidx.media3.exoplayer.analytics;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.DeniedByServerException;
import android.media.MediaCodec;
import android.media.MediaDrm;
import android.media.NotProvisionedException;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.DrmInitData;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.ParserException;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.NetworkTypeObserver;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.FileDataSource;
import androidx.media3.datasource.HttpDataSource;
import androidx.media3.datasource.UdpDataSource;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.PlaybackSessionManager;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.drm.DefaultDrmSessionManager;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.UnsupportedDrmException;
import androidx.media3.exoplayer.mediacodec.MediaCodecDecoderException;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.source.LoadEventInfo;
import androidx.media3.exoplayer.source.MediaLoadData;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@RequiresApi(31)
@UnstableApi
public final class MediaMetricsListener implements AnalyticsListener, PlaybackSessionManager.Listener {
    @Nullable
    private PendingFormatUpdate A0;
    @Nullable
    private PendingFormatUpdate B0;
    @Nullable
    private PendingFormatUpdate C0;
    @Nullable
    private Format D0;
    @Nullable
    private Format E0;
    @Nullable
    private Format F0;
    private boolean G0;
    private int H0;
    private boolean I0;
    private int J0;
    private int K0;
    private int L0;
    private boolean M0;
    private final Context m0;
    private final PlaybackSessionManager n0;
    private final PlaybackSession o0;
    private final long p0 = SystemClock.elapsedRealtime();
    private final Timeline.Window q0 = new Timeline.Window();
    private final Timeline.Period r0 = new Timeline.Period();
    private final HashMap<String, Long> s0 = new HashMap<>();
    private final HashMap<String, Long> t0 = new HashMap<>();
    @Nullable
    private String u0;
    @Nullable
    private PlaybackMetrics.Builder v0;
    private int w0;
    private int x0 = 0;
    private int y0 = 0;
    @Nullable
    private PlaybackException z0;

    private static final class ErrorInfo {

        /* renamed from: a  reason: collision with root package name */
        public final int f10569a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10570b;

        public ErrorInfo(int i2, int i3) {
            this.f10569a = i2;
            this.f10570b = i3;
        }
    }

    private static final class PendingFormatUpdate {

        /* renamed from: a  reason: collision with root package name */
        public final Format f10571a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10572b;

        /* renamed from: c  reason: collision with root package name */
        public final String f10573c;

        public PendingFormatUpdate(Format format, int i2, String str) {
            this.f10571a = format;
            this.f10572b = i2;
            this.f10573c = str;
        }
    }

    private MediaMetricsListener(Context context, PlaybackSession playbackSession) {
        this.m0 = context.getApplicationContext();
        this.o0 = playbackSession;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.n0 = defaultPlaybackSessionManager;
        defaultPlaybackSessionManager.d(this);
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private boolean D0(@Nullable PendingFormatUpdate pendingFormatUpdate) {
        return pendingFormatUpdate != null && pendingFormatUpdate.f10573c.equals(this.n0.c());
    }

    @Nullable
    public static MediaMetricsListener E0(Context context) {
        MediaMetricsManager a2 = X0.a(context.getSystemService("media_metrics"));
        if (a2 == null) {
            return null;
        }
        return new MediaMetricsListener(context, a2.createPlaybackSession());
    }

    private void F0() {
        PlaybackMetrics.Builder builder = this.v0;
        if (builder != null && this.M0) {
            PlaybackMetrics.Builder unused = builder.setAudioUnderrunCount(this.L0);
            PlaybackMetrics.Builder unused2 = this.v0.setVideoFramesDropped(this.J0);
            PlaybackMetrics.Builder unused3 = this.v0.setVideoFramesPlayed(this.K0);
            Long l2 = this.s0.get(this.u0);
            PlaybackMetrics.Builder unused4 = this.v0.setNetworkTransferDurationMillis(l2 == null ? 0 : l2.longValue());
            Long l3 = this.t0.get(this.u0);
            PlaybackMetrics.Builder unused5 = this.v0.setNetworkBytesRead(l3 == null ? 0 : l3.longValue());
            PlaybackMetrics.Builder unused6 = this.v0.setStreamSource((l3 == null || l3.longValue() <= 0) ? 0 : 1);
            this.o0.reportPlaybackMetrics(this.v0.build());
        }
        this.v0 = null;
        this.u0 = null;
        this.L0 = 0;
        this.J0 = 0;
        this.K0 = 0;
        this.D0 = null;
        this.E0 = null;
        this.F0 = null;
        this.M0 = false;
    }

    @SuppressLint({"SwitchIntDef"})
    private static int G0(int i2) {
        switch (Util.t0(i2)) {
            case PlaybackException.y3:
                return 24;
            case PlaybackException.z3:
                return 28;
            case PlaybackException.A3:
                return 25;
            case PlaybackException.B3:
                return 26;
            default:
                return 27;
        }
    }

    @Nullable
    private static DrmInitData H0(ImmutableList<Tracks.Group> immutableList) {
        DrmInitData drmInitData;
        UnmodifiableIterator<Tracks.Group> k2 = immutableList.iterator();
        while (k2.hasNext()) {
            Tracks.Group next = k2.next();
            int i2 = 0;
            while (true) {
                if (i2 < next.s) {
                    if (next.l(i2) && (drmInitData = next.e(i2).i3) != null) {
                        return drmInitData;
                    }
                    i2++;
                }
            }
        }
        return null;
    }

    private static int I0(DrmInitData drmInitData) {
        for (int i2 = 0; i2 < drmInitData.Z; i2++) {
            UUID uuid = drmInitData.g(i2).X;
            if (uuid.equals(C.k2)) {
                return 3;
            }
            if (uuid.equals(C.l2)) {
                return 2;
            }
            if (uuid.equals(C.j2)) {
                return 6;
            }
        }
        return 1;
    }

    private static ErrorInfo J0(PlaybackException playbackException, Context context, boolean z) {
        boolean z2;
        int i2;
        if (playbackException.s == 1001) {
            return new ErrorInfo(20, 0);
        }
        if (playbackException instanceof ExoPlaybackException) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
            z2 = exoPlaybackException.P3 == 1;
            i2 = exoPlaybackException.T3;
        } else {
            i2 = 0;
            z2 = false;
        }
        Throwable th = (Throwable) Assertions.g(playbackException.getCause());
        if (th instanceof IOException) {
            if (th instanceof HttpDataSource.InvalidResponseCodeException) {
                return new ErrorInfo(5, ((HttpDataSource.InvalidResponseCodeException) th).a3);
            }
            if ((th instanceof HttpDataSource.InvalidContentTypeException) || (th instanceof ParserException)) {
                return new ErrorInfo(z ? 10 : 11, 0);
            }
            boolean z3 = th instanceof HttpDataSource.HttpDataSourceException;
            if (z3 || (th instanceof UdpDataSource.UdpDataSourceException)) {
                if (NetworkTypeObserver.d(context).f() == 1) {
                    return new ErrorInfo(3, 0);
                }
                Throwable cause = th.getCause();
                if (cause instanceof UnknownHostException) {
                    return new ErrorInfo(6, 0);
                }
                if (cause instanceof SocketTimeoutException) {
                    return new ErrorInfo(7, 0);
                }
                return (!z3 || ((HttpDataSource.HttpDataSourceException) th).Z != 1) ? new ErrorInfo(8, 0) : new ErrorInfo(4, 0);
            } else if (playbackException.s == 1002) {
                return new ErrorInfo(21, 0);
            } else {
                if (th instanceof DrmSession.DrmSessionException) {
                    Throwable th2 = (Throwable) Assertions.g(th.getCause());
                    int i3 = Util.f9646a;
                    if (i3 >= 21 && (th2 instanceof MediaDrm.MediaDrmStateException)) {
                        int u02 = Util.u0(((MediaDrm.MediaDrmStateException) th2).getDiagnosticInfo());
                        return new ErrorInfo(G0(u02), u02);
                    } else if (i3 >= 23 && W0.a(th2)) {
                        return new ErrorInfo(27, 0);
                    } else {
                        if (i3 >= 18 && (th2 instanceof NotProvisionedException)) {
                            return new ErrorInfo(24, 0);
                        }
                        if (i3 >= 18 && (th2 instanceof DeniedByServerException)) {
                            return new ErrorInfo(29, 0);
                        }
                        if (th2 instanceof UnsupportedDrmException) {
                            return new ErrorInfo(23, 0);
                        }
                        return th2 instanceof DefaultDrmSessionManager.MissingSchemeDataException ? new ErrorInfo(28, 0) : new ErrorInfo(30, 0);
                    }
                } else if (!(th instanceof FileDataSource.FileDataSourceException) || !(th.getCause() instanceof FileNotFoundException)) {
                    return new ErrorInfo(9, 0);
                } else {
                    Throwable cause2 = ((Throwable) Assertions.g(th.getCause())).getCause();
                    return (Util.f9646a < 21 || !(cause2 instanceof ErrnoException) || ((ErrnoException) cause2).errno != OsConstants.EACCES) ? new ErrorInfo(31, 0) : new ErrorInfo(32, 0);
                }
            }
        } else if (z2 && (i2 == 0 || i2 == 1)) {
            return new ErrorInfo(35, 0);
        } else {
            if (z2 && i2 == 3) {
                return new ErrorInfo(15, 0);
            }
            if (z2 && i2 == 2) {
                return new ErrorInfo(23, 0);
            }
            if (th instanceof MediaCodecRenderer.DecoderInitializationException) {
                return new ErrorInfo(13, Util.u0(((MediaCodecRenderer.DecoderInitializationException) th).Z));
            }
            if (th instanceof MediaCodecDecoderException) {
                return new ErrorInfo(14, Util.u0(((MediaCodecDecoderException) th).X));
            }
            if (th instanceof OutOfMemoryError) {
                return new ErrorInfo(14, 0);
            }
            if (th instanceof AudioSink.InitializationException) {
                return new ErrorInfo(17, ((AudioSink.InitializationException) th).s);
            }
            if (th instanceof AudioSink.WriteException) {
                return new ErrorInfo(18, ((AudioSink.WriteException) th).s);
            }
            if (Util.f9646a < 16 || !(th instanceof MediaCodec.CryptoException)) {
                return new ErrorInfo(22, 0);
            }
            int errorCode = ((MediaCodec.CryptoException) th).getErrorCode();
            return new ErrorInfo(G0(errorCode), errorCode);
        }
    }

    private static Pair<String, String> K0(String str) {
        String[] p2 = Util.p2(str, "-");
        return Pair.create(p2[0], p2.length >= 2 ? p2[1] : null);
    }

    private static int M0(Context context) {
        switch (NetworkTypeObserver.d(context).f()) {
            case 0:
                return 0;
            case 1:
                return 9;
            case 2:
                return 2;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 7:
                return 3;
            case 9:
                return 8;
            case 10:
                return 7;
            default:
                return 1;
        }
    }

    private static int N0(MediaItem mediaItem) {
        MediaItem.LocalConfiguration localConfiguration = mediaItem.X;
        if (localConfiguration == null) {
            return 0;
        }
        int b1 = Util.b1(localConfiguration.s, localConfiguration.X);
        if (b1 == 0) {
            return 3;
        }
        if (b1 != 1) {
            return b1 != 2 ? 1 : 4;
        }
        return 5;
    }

    private static int O0(int i2) {
        if (i2 == 1) {
            return 2;
        }
        if (i2 != 2) {
            return i2 != 3 ? 1 : 4;
        }
        return 3;
    }

    private void P0(AnalyticsListener.Events events) {
        for (int i2 = 0; i2 < events.e(); i2++) {
            int c2 = events.c(i2);
            AnalyticsListener.EventTime d2 = events.d(c2);
            if (c2 == 0) {
                this.n0.h(d2);
            } else if (c2 == 11) {
                this.n0.g(d2, this.w0);
            } else {
                this.n0.b(d2);
            }
        }
    }

    private void Q0(long j2) {
        int M02 = M0(this.m0);
        if (M02 != this.y0) {
            this.y0 = M02;
            this.o0.reportNetworkEvent(p1.a().setNetworkType(M02).setTimeSinceCreatedMillis(j2 - this.p0).build());
        }
    }

    private void R0(long j2) {
        PlaybackException playbackException = this.z0;
        if (playbackException != null) {
            ErrorInfo J02 = J0(playbackException, this.m0, this.H0 == 4);
            this.o0.reportPlaybackErrorEvent(r1.a().setTimeSinceCreatedMillis(j2 - this.p0).setErrorCode(J02.f10569a).setSubErrorCode(J02.f10570b).setException(playbackException).build());
            this.M0 = true;
            this.z0 = null;
        }
    }

    private void S0(Player player, AnalyticsListener.Events events, long j2) {
        if (player.i() != 2) {
            this.G0 = false;
        }
        if (player.j() == null) {
            this.I0 = false;
        } else if (events.a(10)) {
            this.I0 = true;
        }
        int a1 = a1(player);
        if (this.x0 != a1) {
            this.x0 = a1;
            this.M0 = true;
            this.o0.reportPlaybackStateEvent(s1.a().setState(this.x0).setTimeSinceCreatedMillis(j2 - this.p0).build());
        }
    }

    private void T0(Player player, AnalyticsListener.Events events, long j2) {
        if (events.a(2)) {
            Tracks D1 = player.D1();
            boolean f2 = D1.f(2);
            boolean f3 = D1.f(1);
            boolean f4 = D1.f(3);
            if (f2 || f3 || f4) {
                if (!f2) {
                    Y0(j2, (Format) null, 0);
                }
                if (!f3) {
                    U0(j2, (Format) null, 0);
                }
                if (!f4) {
                    W0(j2, (Format) null, 0);
                }
            }
        }
        if (D0(this.A0)) {
            PendingFormatUpdate pendingFormatUpdate = this.A0;
            Format format = pendingFormatUpdate.f10571a;
            if (format.l3 != -1) {
                Y0(j2, format, pendingFormatUpdate.f10572b);
                this.A0 = null;
            }
        }
        if (D0(this.B0)) {
            PendingFormatUpdate pendingFormatUpdate2 = this.B0;
            U0(j2, pendingFormatUpdate2.f10571a, pendingFormatUpdate2.f10572b);
            this.B0 = null;
        }
        if (D0(this.C0)) {
            PendingFormatUpdate pendingFormatUpdate3 = this.C0;
            W0(j2, pendingFormatUpdate3.f10571a, pendingFormatUpdate3.f10572b);
            this.C0 = null;
        }
    }

    private void U0(long j2, @Nullable Format format, int i2) {
        if (!Util.g(this.E0, format)) {
            int i3 = (this.E0 == null && i2 == 0) ? 1 : i2;
            this.E0 = format;
            Z0(0, j2, format, i3);
        }
    }

    private void V0(Player player, AnalyticsListener.Events events) {
        DrmInitData H02;
        if (events.a(0)) {
            AnalyticsListener.EventTime d2 = events.d(0);
            if (this.v0 != null) {
                X0(d2.f10507b, d2.f10509d);
            }
        }
        if (!(!events.a(2) || this.v0 == null || (H02 = H0(player.D1().d())) == null)) {
            PlaybackMetrics.Builder unused = L0.a(Util.o(this.v0)).setDrmType(I0(H02));
        }
        if (events.a(1011)) {
            this.L0++;
        }
    }

    private void W0(long j2, @Nullable Format format, int i2) {
        if (!Util.g(this.F0, format)) {
            int i3 = (this.F0 == null && i2 == 0) ? 1 : i2;
            this.F0 = format;
            Z0(2, j2, format, i3);
        }
    }

    @RequiresNonNull({"metricsBuilder"})
    private void X0(Timeline timeline, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
        int g2;
        PlaybackMetrics.Builder builder = this.v0;
        if (mediaPeriodId != null && (g2 = timeline.g(mediaPeriodId.f12163a)) != -1) {
            timeline.k(g2, this.r0);
            timeline.u(this.r0.Y, this.q0);
            PlaybackMetrics.Builder unused = builder.setStreamType(N0(this.q0.Y));
            Timeline.Window window = this.q0;
            if (window.g3 != C.f9084b && !window.e3 && !window.b3 && !window.j()) {
                PlaybackMetrics.Builder unused2 = builder.setMediaDurationMillis(this.q0.f());
            }
            PlaybackMetrics.Builder unused3 = builder.setPlaybackType(this.q0.j() ? 2 : 1);
            this.M0 = true;
        }
    }

    private void Y0(long j2, @Nullable Format format, int i2) {
        if (!Util.g(this.D0, format)) {
            int i3 = (this.D0 == null && i2 == 0) ? 1 : i2;
            this.D0 = format;
            Z0(1, j2, format, i3);
        }
    }

    private void Z0(int i2, long j2, @Nullable Format format, int i3) {
        TrackChangeEvent.Builder a2 = n1.a(i2).setTimeSinceCreatedMillis(j2 - this.p0);
        if (format != null) {
            TrackChangeEvent.Builder unused = a2.setTrackState(1);
            TrackChangeEvent.Builder unused2 = a2.setTrackChangeReason(O0(i3));
            String str = format.e3;
            if (str != null) {
                TrackChangeEvent.Builder unused3 = a2.setContainerMimeType(str);
            }
            String str2 = format.f3;
            if (str2 != null) {
                TrackChangeEvent.Builder unused4 = a2.setSampleMimeType(str2);
            }
            String str3 = format.c3;
            if (str3 != null) {
                TrackChangeEvent.Builder unused5 = a2.setCodecName(str3);
            }
            int i4 = format.b3;
            if (i4 != -1) {
                TrackChangeEvent.Builder unused6 = a2.setBitrate(i4);
            }
            int i5 = format.k3;
            if (i5 != -1) {
                TrackChangeEvent.Builder unused7 = a2.setWidth(i5);
            }
            int i6 = format.l3;
            if (i6 != -1) {
                TrackChangeEvent.Builder unused8 = a2.setHeight(i6);
            }
            int i7 = format.s3;
            if (i7 != -1) {
                TrackChangeEvent.Builder unused9 = a2.setChannelCount(i7);
            }
            int i8 = format.t3;
            if (i8 != -1) {
                TrackChangeEvent.Builder unused10 = a2.setAudioSampleRate(i8);
            }
            String str4 = format.Z;
            if (str4 != null) {
                Pair<String, String> K02 = K0(str4);
                TrackChangeEvent.Builder unused11 = a2.setLanguage((String) K02.first);
                Object obj = K02.second;
                if (obj != null) {
                    TrackChangeEvent.Builder unused12 = a2.setLanguageRegion((String) obj);
                }
            }
            float f2 = format.m3;
            if (f2 != -1.0f) {
                TrackChangeEvent.Builder unused13 = a2.setVideoFrameRate(f2);
            }
        } else {
            TrackChangeEvent.Builder unused14 = a2.setTrackState(0);
        }
        this.M0 = true;
        this.o0.reportTrackChangeEvent(a2.build());
    }

    private int a1(Player player) {
        int i2 = player.i();
        if (this.G0) {
            return 5;
        }
        if (this.I0) {
            return 13;
        }
        if (i2 == 4) {
            return 11;
        }
        if (i2 == 2) {
            int i3 = this.x0;
            if (i3 == 0 || i3 == 2) {
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
        } else if (i2 != 1 || this.x0 == 0) {
            return this.x0;
        } else {
            return 12;
        }
    }

    public /* synthetic */ void A(AnalyticsListener.EventTime eventTime, Format format) {
        C0205a.h(this, eventTime, format);
    }

    public /* synthetic */ void A0(AnalyticsListener.EventTime eventTime, int i2, long j2, long j3) {
        C0205a.o(this, eventTime, i2, j2, j3);
    }

    public void B(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        this.J0 += decoderCounters.f10104g;
        this.K0 += decoderCounters.f10102e;
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
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f10509d;
        if (mediaPeriodId != null) {
            String e2 = this.n0.e(eventTime.f10507b, (MediaSource.MediaPeriodId) Assertions.g(mediaPeriodId));
            Long l2 = this.t0.get(e2);
            Long l3 = this.s0.get(e2);
            long j4 = 0;
            this.t0.put(e2, Long.valueOf((l2 == null ? 0 : l2.longValue()) + j2));
            HashMap<String, Long> hashMap = this.s0;
            if (l3 != null) {
                j4 = l3.longValue();
            }
            hashMap.put(e2, Long.valueOf(j4 + ((long) i2)));
        }
    }

    public /* synthetic */ void F(AnalyticsListener.EventTime eventTime, Exception exc) {
        C0205a.b(this, eventTime, exc);
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

    public LogSessionId L0() {
        return this.o0.getSessionId();
    }

    public /* synthetic */ void M(AnalyticsListener.EventTime eventTime, Tracks tracks) {
        C0205a.l0(this, eventTime, tracks);
    }

    public void N(AnalyticsListener.EventTime eventTime, String str, boolean z) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f10509d;
        if ((mediaPeriodId == null || !mediaPeriodId.c()) && str.equals(this.u0)) {
            F0();
        }
        this.s0.remove(str);
        this.t0.remove(str);
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
        PendingFormatUpdate pendingFormatUpdate = this.A0;
        if (pendingFormatUpdate != null) {
            Format format = pendingFormatUpdate.f10571a;
            if (format.l3 == -1) {
                this.A0 = new PendingFormatUpdate(format.c().r0(videoSize.s).V(videoSize.X).I(), pendingFormatUpdate.f10572b, pendingFormatUpdate.f10573c);
            }
        }
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

    public /* synthetic */ void a0(AnalyticsListener.EventTime eventTime, Exception exc) {
        C0205a.B(this, eventTime, exc);
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
        if (eventTime.f10509d != null) {
            PendingFormatUpdate pendingFormatUpdate = new PendingFormatUpdate((Format) Assertions.g(mediaLoadData.f12151c), mediaLoadData.f12152d, this.n0.e(eventTime.f10507b, (MediaSource.MediaPeriodId) Assertions.g(eventTime.f10509d)));
            int i2 = mediaLoadData.f12150b;
            if (i2 != 0) {
                if (i2 == 1) {
                    this.B0 = pendingFormatUpdate;
                    return;
                } else if (i2 != 2) {
                    if (i2 == 3) {
                        this.C0 = pendingFormatUpdate;
                        return;
                    }
                    return;
                }
            }
            this.A0 = pendingFormatUpdate;
        }
    }

    public /* synthetic */ void f(AnalyticsListener.EventTime eventTime, String str) {
        C0205a.e(this, eventTime, str);
    }

    public void f0(Player player, AnalyticsListener.Events events) {
        if (events.e() != 0) {
            P0(events);
            long elapsedRealtime = SystemClock.elapsedRealtime();
            V0(player, events);
            R0(elapsedRealtime);
            T0(player, events, elapsedRealtime);
            Q0(elapsedRealtime);
            S0(player, events, elapsedRealtime);
            if (events.a(AnalyticsListener.h0)) {
                this.n0.a(events.d(AnalyticsListener.h0));
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
    }

    public /* synthetic */ void l(AnalyticsListener.EventTime eventTime, boolean z) {
        C0205a.G(this, eventTime, z);
    }

    public void l0(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i2) {
        if (i2 == 1) {
            this.G0 = true;
        }
        this.w0 = i2;
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

    public void r(AnalyticsListener.EventTime eventTime, PlaybackException playbackException) {
        this.z0 = playbackException;
    }

    public /* synthetic */ void r0(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters) {
        C0205a.s0(this, eventTime, decoderCounters);
    }

    public /* synthetic */ void s(AnalyticsListener.EventTime eventTime, int i2, int i3, int i4, float f2) {
        C0205a.w0(this, eventTime, i2, i3, i4, f2);
    }

    public void s0(AnalyticsListener.EventTime eventTime, String str) {
        MediaSource.MediaPeriodId mediaPeriodId = eventTime.f10509d;
        if (mediaPeriodId == null || !mediaPeriodId.c()) {
            F0();
            this.u0 = str;
            this.v0 = q1.a().setPlayerName(MediaLibraryInfo.f9204a).setPlayerVersion(MediaLibraryInfo.f9205b);
            X0(eventTime.f10507b, eventTime.f10509d);
        }
    }

    public /* synthetic */ void t(AnalyticsListener.EventTime eventTime, boolean z) {
        C0205a.L(this, eventTime, z);
    }

    public /* synthetic */ void t0(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        C0205a.v0(this, eventTime, format, decoderReuseEvaluation);
    }

    public /* synthetic */ void u(AnalyticsListener.EventTime eventTime, int i2, long j2) {
        C0205a.D(this, eventTime, i2, j2);
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
        this.H0 = mediaLoadData.f12149a;
    }

    public /* synthetic */ void z(AnalyticsListener.EventTime eventTime, boolean z, int i2) {
        C0205a.Q(this, eventTime, z, i2);
    }

    public /* synthetic */ void z0(AnalyticsListener.EventTime eventTime, long j2) {
        C0205a.j(this, eventTime, j2);
    }
}
