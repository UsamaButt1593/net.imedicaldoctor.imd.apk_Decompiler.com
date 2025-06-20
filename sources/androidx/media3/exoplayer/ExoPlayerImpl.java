package androidx.media3.exoplayer;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.BasePlayer;
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Effect;
import androidx.media3.common.FlagSet;
import androidx.media3.common.Format;
import androidx.media3.common.IllegalSeekPositionException;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaLibraryInfo;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoFrameProcessor;
import androidx.media3.common.VideoSize;
import androidx.media3.common.Z;
import androidx.media3.common.text.Cue;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.HandlerWrapper;
import androidx.media3.common.util.ListenerSet;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.AudioBecomingNoisyManager;
import androidx.media3.exoplayer.AudioFocusManager;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.ExoPlayerImplInternal;
import androidx.media3.exoplayer.MediaSourceList;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.StreamVolumeManager;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.analytics.DefaultAnalyticsCollector;
import androidx.media3.exoplayer.analytics.MediaMetricsListener;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.C0265j;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.metadata.MetadataOutput;
import androidx.media3.exoplayer.source.MaskingMediaSource;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.source.TimelineWithUpdatedMediaItem;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.text.TextOutput;
import androidx.media3.exoplayer.trackselection.TrackSelectionArray;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectorResult;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.video.VideoDecoderOutputBufferRenderer;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.exoplayer.video.VideoRendererEventListener;
import androidx.media3.exoplayer.video.n;
import androidx.media3.exoplayer.video.spherical.CameraMotionListener;
import androidx.media3.exoplayer.video.spherical.SphericalGLSurfaceView;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

final class ExoPlayerImpl extends BasePlayer implements ExoPlayer, ExoPlayer.AudioComponent, ExoPlayer.VideoComponent, ExoPlayer.TextComponent, ExoPlayer.DeviceComponent {
    private static final String C2 = "ExoPlayerImpl";
    private final AudioBecomingNoisyManager A1;
    private int A2;
    private final AudioFocusManager B1;
    private long B2;
    /* access modifiers changed from: private */
    @Nullable
    public final StreamVolumeManager C1;
    private final WakeLockManager D1;
    private final WifiLockManager E1;
    private final long F1;
    @Nullable
    private AudioManager G1;
    private final boolean H1;
    private int I1;
    private boolean J1;
    private int K1;
    private int L1;
    private boolean M1;
    private int N1;
    private boolean O1;
    private SeekParameters P1;
    private ShuffleOrder Q1;
    private boolean R1;
    private Player.Commands S1;
    /* access modifiers changed from: private */
    public MediaMetadata T1;
    private MediaMetadata U1;
    /* access modifiers changed from: private */
    @Nullable
    public Format V1;
    /* access modifiers changed from: private */
    @Nullable
    public Format W1;
    @Nullable
    private AudioTrack X1;
    /* access modifiers changed from: private */
    @Nullable
    public Object Y1;
    @Nullable
    private Surface Z1;
    @Nullable
    private SurfaceHolder a2;
    @Nullable
    private SphericalGLSurfaceView b2;
    final TrackSelectorResult c1;
    /* access modifiers changed from: private */
    public boolean c2;
    final Player.Commands d1;
    @Nullable
    private TextureView d2;
    private final ConditionVariable e1;
    private int e2;
    private final Context f1;
    private int f2;
    private final Player g1;
    private Size g2;
    private final Renderer[] h1;
    /* access modifiers changed from: private */
    @Nullable
    public DecoderCounters h2;
    private final TrackSelector i1;
    /* access modifiers changed from: private */
    @Nullable
    public DecoderCounters i2;
    private final HandlerWrapper j1;
    private int j2;
    private final ExoPlayerImplInternal.PlaybackInfoUpdateListener k1;
    private AudioAttributes k2;
    private final ExoPlayerImplInternal l1;
    private float l2;
    /* access modifiers changed from: private */
    public final ListenerSet<Player.Listener> m1;
    /* access modifiers changed from: private */
    public boolean m2;
    private final CopyOnWriteArraySet<ExoPlayer.AudioOffloadListener> n1;
    /* access modifiers changed from: private */
    public CueGroup n2;
    private final Timeline.Period o1;
    @Nullable
    private VideoFrameMetadataListener o2;
    private final List<MediaSourceHolderSnapshot> p1;
    @Nullable
    private CameraMotionListener p2;
    private final boolean q1;
    private boolean q2;
    private final MediaSource.Factory r1;
    private boolean r2;
    /* access modifiers changed from: private */
    public final AnalyticsCollector s1;
    @Nullable
    private PriorityTaskManager s2;
    private final Looper t1;
    private boolean t2;
    private final BandwidthMeter u1;
    private boolean u2;
    private final long v1;
    /* access modifiers changed from: private */
    public DeviceInfo v2;
    private final long w1;
    /* access modifiers changed from: private */
    public VideoSize w2;
    private final Clock x1;
    /* access modifiers changed from: private */
    public MediaMetadata x2;
    private final ComponentListener y1;
    /* access modifiers changed from: private */
    public PlaybackInfo y2;
    private final FrameMetadataListener z1;
    private int z2;

    @RequiresApi(23)
    private static final class Api23 {
        private Api23() {
        }

        @DoNotInline
        public static boolean a(Context context, AudioDeviceInfo[] audioDeviceInfoArr) {
            if (!Util.r1(context)) {
                return true;
            }
            for (AudioDeviceInfo audioDeviceInfo : audioDeviceInfoArr) {
                if (audioDeviceInfo.getType() == 8 || audioDeviceInfo.getType() == 5 || audioDeviceInfo.getType() == 6 || audioDeviceInfo.getType() == 11 || audioDeviceInfo.getType() == 4 || audioDeviceInfo.getType() == 3) {
                    return true;
                }
                int i2 = Util.f9646a;
                if (i2 >= 26 && audioDeviceInfo.getType() == 22) {
                    return true;
                }
                if (i2 >= 28 && audioDeviceInfo.getType() == 23) {
                    return true;
                }
                if (i2 >= 31 && (audioDeviceInfo.getType() == 26 || audioDeviceInfo.getType() == 27)) {
                    return true;
                }
                if (i2 >= 33 && audioDeviceInfo.getType() == 30) {
                    return true;
                }
            }
            return false;
        }

        @DoNotInline
        public static void b(AudioManager audioManager, AudioDeviceCallback audioDeviceCallback, Handler handler) {
            audioManager.registerAudioDeviceCallback(audioDeviceCallback, handler);
        }
    }

    @RequiresApi(31)
    private static final class Api31 {
        private Api31() {
        }

        @DoNotInline
        public static PlayerId a(Context context, ExoPlayerImpl exoPlayerImpl, boolean z) {
            MediaMetricsListener E0 = MediaMetricsListener.E0(context);
            if (E0 == null) {
                Log.n(ExoPlayerImpl.C2, "MediaMetricsService unavailable.");
                return new PlayerId(LogSessionId.LOG_SESSION_ID_NONE);
            }
            if (z) {
                exoPlayerImpl.l2(E0);
            }
            return new PlayerId(E0.L0());
        }
    }

    private final class ComponentListener implements VideoRendererEventListener, AudioRendererEventListener, TextOutput, MetadataOutput, SurfaceHolder.Callback, TextureView.SurfaceTextureListener, SphericalGLSurfaceView.VideoSurfaceListener, AudioFocusManager.PlayerControl, AudioBecomingNoisyManager.EventListener, StreamVolumeManager.Listener, ExoPlayer.AudioOffloadListener {
        private ComponentListener() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void U(Player.Listener listener) {
            listener.Z(ExoPlayerImpl.this.T1);
        }

        public void A() {
            ExoPlayerImpl.this.g5(false, -1, 3);
        }

        public void B(DecoderCounters decoderCounters) {
            ExoPlayerImpl.this.s1.B(decoderCounters);
            Format unused = ExoPlayerImpl.this.W1 = null;
            DecoderCounters unused2 = ExoPlayerImpl.this.i2 = null;
        }

        public void C(long j2, int i2) {
            ExoPlayerImpl.this.s1.C(j2, i2);
        }

        public void D(float f2) {
            ExoPlayerImpl.this.X4();
        }

        public void E(int i2) {
            boolean m0 = ExoPlayerImpl.this.m0();
            ExoPlayerImpl.this.g5(m0, i2, ExoPlayerImpl.g4(m0, i2));
        }

        public void F(Surface surface) {
            ExoPlayerImpl.this.c5((Object) null);
        }

        public /* synthetic */ void G(boolean z) {
            C0319m.a(this, z);
        }

        public void H(Surface surface) {
            ExoPlayerImpl.this.c5(surface);
        }

        public void I(int i2, boolean z) {
            ExoPlayerImpl.this.m1.m(30, new z0(i2, z));
        }

        public void J(boolean z) {
            ExoPlayerImpl.this.k5();
        }

        public /* synthetic */ void a(Format format) {
            C0265j.f(this, format);
        }

        public void b(AudioSink.AudioTrackConfig audioTrackConfig) {
            ExoPlayerImpl.this.s1.b(audioTrackConfig);
        }

        public void c(VideoSize videoSize) {
            VideoSize unused = ExoPlayerImpl.this.w2 = videoSize;
            ExoPlayerImpl.this.m1.m(25, new C0357x0(videoSize));
        }

        public void d(AudioSink.AudioTrackConfig audioTrackConfig) {
            ExoPlayerImpl.this.s1.d(audioTrackConfig);
        }

        public void e(boolean z) {
            if (ExoPlayerImpl.this.m2 != z) {
                boolean unused = ExoPlayerImpl.this.m2 = z;
                ExoPlayerImpl.this.m1.m(23, new C0353v0(z));
            }
        }

        public void f(Exception exc) {
            ExoPlayerImpl.this.s1.f(exc);
        }

        public void g(String str) {
            ExoPlayerImpl.this.s1.g(str);
        }

        public void h(String str, long j2, long j3) {
            ExoPlayerImpl.this.s1.h(str, j2, j3);
        }

        public void i(String str) {
            ExoPlayerImpl.this.s1.i(str);
        }

        public void j(String str, long j2, long j3) {
            ExoPlayerImpl.this.s1.j(str, j2, j3);
        }

        public /* synthetic */ void k(Format format) {
            n.i(this, format);
        }

        public void l(int i2, long j2) {
            ExoPlayerImpl.this.s1.l(i2, j2);
        }

        public void m(DecoderCounters decoderCounters) {
            DecoderCounters unused = ExoPlayerImpl.this.i2 = decoderCounters;
            ExoPlayerImpl.this.s1.m(decoderCounters);
        }

        public void n(DecoderCounters decoderCounters) {
            DecoderCounters unused = ExoPlayerImpl.this.h2 = decoderCounters;
            ExoPlayerImpl.this.s1.n(decoderCounters);
        }

        public void o(Object obj, long j2) {
            ExoPlayerImpl.this.s1.o(obj, j2);
            if (ExoPlayerImpl.this.Y1 == obj) {
                ExoPlayerImpl.this.m1.m(26, new Z());
            }
        }

        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
            ExoPlayerImpl.this.a5(surfaceTexture);
            ExoPlayerImpl.this.R4(i2, i3);
        }

        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            ExoPlayerImpl.this.c5((Object) null);
            ExoPlayerImpl.this.R4(0, 0);
            return true;
        }

        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
            ExoPlayerImpl.this.R4(i2, i3);
        }

        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        public void p(CueGroup cueGroup) {
            CueGroup unused = ExoPlayerImpl.this.n2 = cueGroup;
            ExoPlayerImpl.this.m1.m(27, new C0334s0(cueGroup));
        }

        public void q(Metadata metadata) {
            ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
            MediaMetadata unused = exoPlayerImpl.x2 = exoPlayerImpl.x2.b().K(metadata).H();
            MediaMetadata u3 = ExoPlayerImpl.this.U3();
            if (!u3.equals(ExoPlayerImpl.this.T1)) {
                MediaMetadata unused2 = ExoPlayerImpl.this.T1 = u3;
                ExoPlayerImpl.this.m1.j(14, new C0345t0(this));
            }
            ExoPlayerImpl.this.m1.j(28, new C0351u0(metadata));
            ExoPlayerImpl.this.m1.g();
        }

        public void r(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            Format unused = ExoPlayerImpl.this.V1 = format;
            ExoPlayerImpl.this.s1.r(format, decoderReuseEvaluation);
        }

        public void s(List<Cue> list) {
            ExoPlayerImpl.this.m1.m(27, new C0355w0(list));
        }

        public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            ExoPlayerImpl.this.R4(i3, i4);
        }

        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            if (ExoPlayerImpl.this.c2) {
                ExoPlayerImpl.this.c5(surfaceHolder.getSurface());
            }
        }

        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            if (ExoPlayerImpl.this.c2) {
                ExoPlayerImpl.this.c5((Object) null);
            }
            ExoPlayerImpl.this.R4(0, 0);
        }

        public void t(DecoderCounters decoderCounters) {
            ExoPlayerImpl.this.s1.t(decoderCounters);
            Format unused = ExoPlayerImpl.this.V1 = null;
            DecoderCounters unused2 = ExoPlayerImpl.this.h2 = null;
        }

        public void u(long j2) {
            ExoPlayerImpl.this.s1.u(j2);
        }

        public void v(Format format, @Nullable DecoderReuseEvaluation decoderReuseEvaluation) {
            Format unused = ExoPlayerImpl.this.W1 = format;
            ExoPlayerImpl.this.s1.v(format, decoderReuseEvaluation);
        }

        public void w(Exception exc) {
            ExoPlayerImpl.this.s1.w(exc);
        }

        public void x(int i2) {
            DeviceInfo F3 = ExoPlayerImpl.X3(ExoPlayerImpl.this.C1);
            if (!F3.equals(ExoPlayerImpl.this.v2)) {
                DeviceInfo unused = ExoPlayerImpl.this.v2 = F3;
                ExoPlayerImpl.this.m1.m(29, new C0359y0(F3));
            }
        }

        public void y(Exception exc) {
            ExoPlayerImpl.this.s1.y(exc);
        }

        public void z(int i2, long j2, long j3) {
            ExoPlayerImpl.this.s1.z(i2, j2, j3);
        }
    }

    private static final class FrameMetadataListener implements VideoFrameMetadataListener, CameraMotionListener, PlayerMessage.Target {
        public static final int X2 = 7;
        public static final int Y2 = 8;
        public static final int Z2 = 10000;
        @Nullable
        private CameraMotionListener X;
        @Nullable
        private VideoFrameMetadataListener Y;
        @Nullable
        private CameraMotionListener Z;
        @Nullable
        private VideoFrameMetadataListener s;

        private FrameMetadataListener() {
        }

        public void b(long j2, float[] fArr) {
            CameraMotionListener cameraMotionListener = this.Z;
            if (cameraMotionListener != null) {
                cameraMotionListener.b(j2, fArr);
            }
            CameraMotionListener cameraMotionListener2 = this.X;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.b(j2, fArr);
            }
        }

        public void f() {
            CameraMotionListener cameraMotionListener = this.Z;
            if (cameraMotionListener != null) {
                cameraMotionListener.f();
            }
            CameraMotionListener cameraMotionListener2 = this.X;
            if (cameraMotionListener2 != null) {
                cameraMotionListener2.f();
            }
        }

        public void j(long j2, long j3, Format format, @Nullable MediaFormat mediaFormat) {
            VideoFrameMetadataListener videoFrameMetadataListener = this.Y;
            if (videoFrameMetadataListener != null) {
                videoFrameMetadataListener.j(j2, j3, format, mediaFormat);
            }
            VideoFrameMetadataListener videoFrameMetadataListener2 = this.s;
            if (videoFrameMetadataListener2 != null) {
                videoFrameMetadataListener2.j(j2, j3, format, mediaFormat);
            }
        }

        public void z(int i2, @Nullable Object obj) {
            CameraMotionListener cameraMotionListener;
            if (i2 == 7) {
                this.s = (VideoFrameMetadataListener) obj;
            } else if (i2 == 8) {
                this.X = (CameraMotionListener) obj;
            } else if (i2 == 10000) {
                SphericalGLSurfaceView sphericalGLSurfaceView = (SphericalGLSurfaceView) obj;
                if (sphericalGLSurfaceView == null) {
                    cameraMotionListener = null;
                    this.Y = null;
                } else {
                    this.Y = sphericalGLSurfaceView.getVideoFrameMetadataListener();
                    cameraMotionListener = sphericalGLSurfaceView.getCameraMotionListener();
                }
                this.Z = cameraMotionListener;
            }
        }
    }

    private static final class MediaSourceHolderSnapshot implements MediaSourceInfoHolder {

        /* renamed from: a  reason: collision with root package name */
        private final Object f10196a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final MediaSource f10197b;

        /* renamed from: c  reason: collision with root package name */
        private Timeline f10198c;

        public MediaSourceHolderSnapshot(Object obj, MaskingMediaSource maskingMediaSource) {
            this.f10196a = obj;
            this.f10197b = maskingMediaSource;
            this.f10198c = maskingMediaSource.Z0();
        }

        public Timeline a() {
            return this.f10198c;
        }

        public Object b() {
            return this.f10196a;
        }

        public void d(Timeline timeline) {
            this.f10198c = timeline;
        }
    }

    @RequiresApi(23)
    private final class NoSuitableOutputPlaybackSuppressionAudioDeviceCallback extends AudioDeviceCallback {
        private NoSuitableOutputPlaybackSuppressionAudioDeviceCallback() {
        }

        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            if (ExoPlayerImpl.this.l4() && ExoPlayerImpl.this.y2.f10316m == 3) {
                ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
                exoPlayerImpl.i5(exoPlayerImpl.y2.f10315l, 1, 0);
            }
        }

        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            if (!ExoPlayerImpl.this.l4()) {
                ExoPlayerImpl exoPlayerImpl = ExoPlayerImpl.this;
                exoPlayerImpl.i5(exoPlayerImpl.y2.f10315l, 1, 3);
            }
        }
    }

    static {
        MediaLibraryInfo.a("media3.exoplayer");
    }

    /* JADX WARNING: type inference failed for: r41v0, types: [androidx.media3.common.Player] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @android.annotation.SuppressLint({"HandlerLeak"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public ExoPlayerImpl(androidx.media3.exoplayer.ExoPlayer.Builder r40, @androidx.annotation.Nullable androidx.media3.common.Player r41) {
        /*
            r39 = this;
            r1 = r39
            r0 = r40
            r39.<init>()
            androidx.media3.common.util.ConditionVariable r8 = new androidx.media3.common.util.ConditionVariable
            r8.<init>()
            r1.e1 = r8
            java.lang.String r9 = "ExoPlayerImpl"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b1 }
            r10.<init>()     // Catch:{ all -> 0x01b1 }
            java.lang.String r11 = "Init "
            r10.append(r11)     // Catch:{ all -> 0x01b1 }
            int r11 = java.lang.System.identityHashCode(r39)     // Catch:{ all -> 0x01b1 }
            java.lang.String r11 = java.lang.Integer.toHexString(r11)     // Catch:{ all -> 0x01b1 }
            r10.append(r11)     // Catch:{ all -> 0x01b1 }
            java.lang.String r11 = " ["
            r10.append(r11)     // Catch:{ all -> 0x01b1 }
            java.lang.String r11 = "AndroidXMedia3/1.3.1"
            r10.append(r11)     // Catch:{ all -> 0x01b1 }
            java.lang.String r11 = "] ["
            r10.append(r11)     // Catch:{ all -> 0x01b1 }
            java.lang.String r11 = androidx.media3.common.util.Util.f9650e     // Catch:{ all -> 0x01b1 }
            r10.append(r11)     // Catch:{ all -> 0x01b1 }
            java.lang.String r11 = "]"
            r10.append(r11)     // Catch:{ all -> 0x01b1 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.util.Log.h(r9, r10)     // Catch:{ all -> 0x01b1 }
            android.content.Context r9 = r0.f10182a     // Catch:{ all -> 0x01b1 }
            android.content.Context r9 = r9.getApplicationContext()     // Catch:{ all -> 0x01b1 }
            r1.f1 = r9     // Catch:{ all -> 0x01b1 }
            com.google.common.base.Function<androidx.media3.common.util.Clock, androidx.media3.exoplayer.analytics.AnalyticsCollector> r10 = r0.f10190i     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.util.Clock r11 = r0.f10183b     // Catch:{ all -> 0x01b1 }
            java.lang.Object r10 = r10.apply(r11)     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.analytics.AnalyticsCollector r10 = (androidx.media3.exoplayer.analytics.AnalyticsCollector) r10     // Catch:{ all -> 0x01b1 }
            r1.s1 = r10     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.PriorityTaskManager r11 = r0.f10192k     // Catch:{ all -> 0x01b1 }
            r1.s2 = r11     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.AudioAttributes r11 = r0.f10193l     // Catch:{ all -> 0x01b1 }
            r1.k2 = r11     // Catch:{ all -> 0x01b1 }
            int r11 = r0.r     // Catch:{ all -> 0x01b1 }
            r1.e2 = r11     // Catch:{ all -> 0x01b1 }
            int r11 = r0.s     // Catch:{ all -> 0x01b1 }
            r1.f2 = r11     // Catch:{ all -> 0x01b1 }
            boolean r11 = r0.p     // Catch:{ all -> 0x01b1 }
            r1.m2 = r11     // Catch:{ all -> 0x01b1 }
            long r11 = r0.z     // Catch:{ all -> 0x01b1 }
            r1.F1 = r11     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.ExoPlayerImpl$ComponentListener r12 = new androidx.media3.exoplayer.ExoPlayerImpl$ComponentListener     // Catch:{ all -> 0x01b1 }
            r11 = 0
            r12.<init>()     // Catch:{ all -> 0x01b1 }
            r1.y1 = r12     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.ExoPlayerImpl$FrameMetadataListener r15 = new androidx.media3.exoplayer.ExoPlayerImpl$FrameMetadataListener     // Catch:{ all -> 0x01b1 }
            r15.<init>()     // Catch:{ all -> 0x01b1 }
            r1.z1 = r15     // Catch:{ all -> 0x01b1 }
            android.os.Handler r14 = new android.os.Handler     // Catch:{ all -> 0x01b1 }
            android.os.Looper r13 = r0.f10191j     // Catch:{ all -> 0x01b1 }
            r14.<init>(r13)     // Catch:{ all -> 0x01b1 }
            com.google.common.base.Supplier<androidx.media3.exoplayer.RenderersFactory> r13 = r0.f10185d     // Catch:{ all -> 0x01b1 }
            java.lang.Object r13 = r13.get()     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.RenderersFactory r13 = (androidx.media3.exoplayer.RenderersFactory) r13     // Catch:{ all -> 0x01b1 }
            r30 = r14
            r31 = r15
            r15 = r12
            r16 = r12
            r17 = r12
            r18 = r12
            androidx.media3.exoplayer.Renderer[] r13 = r13.a(r14, r15, r16, r17, r18)     // Catch:{ all -> 0x01b1 }
            r1.h1 = r13     // Catch:{ all -> 0x01b1 }
            int r14 = r13.length     // Catch:{ all -> 0x01b1 }
            r15 = 0
            if (r14 <= 0) goto L_0x00a6
            r14 = 1
            goto L_0x00a7
        L_0x00a6:
            r14 = 0
        L_0x00a7:
            androidx.media3.common.util.Assertions.i(r14)     // Catch:{ all -> 0x01b1 }
            com.google.common.base.Supplier<androidx.media3.exoplayer.trackselection.TrackSelector> r14 = r0.f10187f     // Catch:{ all -> 0x01b1 }
            java.lang.Object r14 = r14.get()     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.trackselection.TrackSelector r14 = (androidx.media3.exoplayer.trackselection.TrackSelector) r14     // Catch:{ all -> 0x01b1 }
            r1.i1 = r14     // Catch:{ all -> 0x01b1 }
            com.google.common.base.Supplier<androidx.media3.exoplayer.source.MediaSource$Factory> r5 = r0.f10186e     // Catch:{ all -> 0x01b1 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.source.MediaSource$Factory r5 = (androidx.media3.exoplayer.source.MediaSource.Factory) r5     // Catch:{ all -> 0x01b1 }
            r1.r1 = r5     // Catch:{ all -> 0x01b1 }
            com.google.common.base.Supplier<androidx.media3.exoplayer.upstream.BandwidthMeter> r5 = r0.f10189h     // Catch:{ all -> 0x01b1 }
            java.lang.Object r5 = r5.get()     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.upstream.BandwidthMeter r5 = (androidx.media3.exoplayer.upstream.BandwidthMeter) r5     // Catch:{ all -> 0x01b1 }
            r1.u1 = r5     // Catch:{ all -> 0x01b1 }
            boolean r6 = r0.t     // Catch:{ all -> 0x01b1 }
            r1.q1 = r6     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.SeekParameters r6 = r0.u     // Catch:{ all -> 0x01b1 }
            r1.P1 = r6     // Catch:{ all -> 0x01b1 }
            r32 = r8
            long r7 = r0.v     // Catch:{ all -> 0x01b1 }
            r1.v1 = r7     // Catch:{ all -> 0x01b1 }
            long r7 = r0.w     // Catch:{ all -> 0x01b1 }
            r1.w1 = r7     // Catch:{ all -> 0x01b1 }
            boolean r7 = r0.A     // Catch:{ all -> 0x01b1 }
            r1.R1 = r7     // Catch:{ all -> 0x01b1 }
            android.os.Looper r7 = r0.f10191j     // Catch:{ all -> 0x01b1 }
            r1.t1 = r7     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.util.Clock r8 = r0.f10183b     // Catch:{ all -> 0x01b1 }
            r1.x1 = r8     // Catch:{ all -> 0x01b1 }
            if (r41 != 0) goto L_0x00ea
            r6 = r1
            goto L_0x00ec
        L_0x00ea:
            r6 = r41
        L_0x00ec:
            r1.g1 = r6     // Catch:{ all -> 0x01b1 }
            boolean r2 = r0.E     // Catch:{ all -> 0x01b1 }
            r1.H1 = r2     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.util.ListenerSet r4 = new androidx.media3.common.util.ListenerSet     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.M r3 = new androidx.media3.exoplayer.M     // Catch:{ all -> 0x01b1 }
            r3.<init>(r1)     // Catch:{ all -> 0x01b1 }
            r4.<init>(r7, r8, r3)     // Catch:{ all -> 0x01b1 }
            r1.m1 = r4     // Catch:{ all -> 0x01b1 }
            java.util.concurrent.CopyOnWriteArraySet r3 = new java.util.concurrent.CopyOnWriteArraySet     // Catch:{ all -> 0x01b1 }
            r3.<init>()     // Catch:{ all -> 0x01b1 }
            r1.n1 = r3     // Catch:{ all -> 0x01b1 }
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x01b1 }
            r3.<init>()     // Catch:{ all -> 0x01b1 }
            r1.p1 = r3     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.source.ShuffleOrder$DefaultShuffleOrder r3 = new androidx.media3.exoplayer.source.ShuffleOrder$DefaultShuffleOrder     // Catch:{ all -> 0x01b1 }
            r3.<init>(r15)     // Catch:{ all -> 0x01b1 }
            r1.Q1 = r3     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.trackselection.TrackSelectorResult r3 = new androidx.media3.exoplayer.trackselection.TrackSelectorResult     // Catch:{ all -> 0x01b1 }
            int r4 = r13.length     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.RendererConfiguration[] r4 = new androidx.media3.exoplayer.RendererConfiguration[r4]     // Catch:{ all -> 0x01b1 }
            int r15 = r13.length     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.trackselection.ExoTrackSelection[] r15 = new androidx.media3.exoplayer.trackselection.ExoTrackSelection[r15]     // Catch:{ all -> 0x01b1 }
            r19 = r12
            androidx.media3.common.Tracks r12 = androidx.media3.common.Tracks.X     // Catch:{ all -> 0x01b1 }
            r3.<init>(r4, r15, r12, r11)     // Catch:{ all -> 0x01b1 }
            r1.c1 = r3     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.Timeline$Period r4 = new androidx.media3.common.Timeline$Period     // Catch:{ all -> 0x01b1 }
            r4.<init>()     // Catch:{ all -> 0x01b1 }
            r1.o1 = r4     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.Player$Commands$Builder r4 = new androidx.media3.common.Player$Commands$Builder     // Catch:{ all -> 0x01b1 }
            r4.<init>()     // Catch:{ all -> 0x01b1 }
            r12 = 20
            int[] r12 = new int[r12]     // Catch:{ all -> 0x01b1 }
            r12 = {1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32} // fill-array     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.Player$Commands$Builder r4 = r4.c(r12)     // Catch:{ all -> 0x01b1 }
            boolean r12 = r14.h()     // Catch:{ all -> 0x01b1 }
            r15 = 29
            androidx.media3.common.Player$Commands$Builder r4 = r4.e(r15, r12)     // Catch:{ all -> 0x01b1 }
            boolean r12 = r0.q     // Catch:{ all -> 0x01b1 }
            r15 = 23
            androidx.media3.common.Player$Commands$Builder r4 = r4.e(r15, r12)     // Catch:{ all -> 0x01b1 }
            boolean r12 = r0.q     // Catch:{ all -> 0x01b1 }
            r15 = 25
            androidx.media3.common.Player$Commands$Builder r4 = r4.e(r15, r12)     // Catch:{ all -> 0x01b1 }
            boolean r12 = r0.q     // Catch:{ all -> 0x01b1 }
            r15 = 33
            androidx.media3.common.Player$Commands$Builder r4 = r4.e(r15, r12)     // Catch:{ all -> 0x01b1 }
            boolean r12 = r0.q     // Catch:{ all -> 0x01b1 }
            r15 = 26
            androidx.media3.common.Player$Commands$Builder r4 = r4.e(r15, r12)     // Catch:{ all -> 0x01b1 }
            boolean r12 = r0.q     // Catch:{ all -> 0x01b1 }
            r15 = 34
            androidx.media3.common.Player$Commands$Builder r4 = r4.e(r15, r12)     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.Player$Commands r4 = r4.f()     // Catch:{ all -> 0x01b1 }
            r1.d1 = r4     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.Player$Commands$Builder r12 = new androidx.media3.common.Player$Commands$Builder     // Catch:{ all -> 0x01b1 }
            r12.<init>()     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.Player$Commands$Builder r4 = r12.b(r4)     // Catch:{ all -> 0x01b1 }
            r15 = 4
            androidx.media3.common.Player$Commands$Builder r4 = r4.a(r15)     // Catch:{ all -> 0x01b1 }
            r12 = 10
            androidx.media3.common.Player$Commands$Builder r4 = r4.a(r12)     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.Player$Commands r4 = r4.f()     // Catch:{ all -> 0x01b1 }
            r1.S1 = r4     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.util.HandlerWrapper r4 = r8.e(r7, r11)     // Catch:{ all -> 0x01b1 }
            r1.j1 = r4     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.N r4 = new androidx.media3.exoplayer.N     // Catch:{ all -> 0x01b1 }
            r4.<init>(r1)     // Catch:{ all -> 0x01b1 }
            r1.k1 = r4     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.PlaybackInfo r11 = androidx.media3.exoplayer.PlaybackInfo.k(r3)     // Catch:{ all -> 0x01b1 }
            r1.y2 = r11     // Catch:{ all -> 0x01b1 }
            r10.n0(r6, r7)     // Catch:{ all -> 0x01b1 }
            int r6 = androidx.media3.common.util.Util.f9646a     // Catch:{ all -> 0x01b1 }
            r11 = 31
            if (r6 >= r11) goto L_0x01b4
            androidx.media3.exoplayer.analytics.PlayerId r11 = new androidx.media3.exoplayer.analytics.PlayerId     // Catch:{ all -> 0x01b1 }
            r11.<init>()     // Catch:{ all -> 0x01b1 }
        L_0x01ae:
            r28 = r11
            goto L_0x01bb
        L_0x01b1:
            r0 = move-exception
            goto L_0x0342
        L_0x01b4:
            boolean r11 = r0.B     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.analytics.PlayerId r11 = androidx.media3.exoplayer.ExoPlayerImpl.Api31.a(r9, r1, r11)     // Catch:{ all -> 0x01b1 }
            goto L_0x01ae
        L_0x01bb:
            androidx.media3.exoplayer.ExoPlayerImplInternal r11 = new androidx.media3.exoplayer.ExoPlayerImplInternal     // Catch:{ all -> 0x01b1 }
            com.google.common.base.Supplier<androidx.media3.exoplayer.LoadControl> r12 = r0.f10188g     // Catch:{ all -> 0x01b1 }
            java.lang.Object r12 = r12.get()     // Catch:{ all -> 0x01b1 }
            r20 = r12
            androidx.media3.exoplayer.LoadControl r20 = (androidx.media3.exoplayer.LoadControl) r20     // Catch:{ all -> 0x01b1 }
            int r12 = r1.I1     // Catch:{ all -> 0x01b1 }
            r33 = r2
            boolean r2 = r1.J1     // Catch:{ all -> 0x01b1 }
            r34 = r9
            androidx.media3.exoplayer.SeekParameters r9 = r1.P1     // Catch:{ all -> 0x01b1 }
            r35 = r6
            androidx.media3.exoplayer.LivePlaybackSpeedControl r6 = r0.x     // Catch:{ all -> 0x01b1 }
            r36 = r7
            r26 = r8
            long r7 = r0.y     // Catch:{ all -> 0x01b1 }
            r27 = r4
            boolean r4 = r1.R1     // Catch:{ all -> 0x01b1 }
            android.os.Looper r1 = r0.C     // Catch:{ all -> 0x033f }
            r37 = r11
            r11 = r37
            r17 = r12
            r0 = r19
            r12 = r13
            r13 = r14
            r38 = r14
            r14 = r3
            r3 = 0
            r15 = r20
            r16 = r5
            r18 = r2
            r19 = r10
            r20 = r9
            r21 = r6
            r22 = r7
            r24 = r4
            r25 = r36
            r29 = r1
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r24, r25, r26, r27, r28, r29)     // Catch:{ all -> 0x033f }
            r1 = r39
            r2 = r37
            r1.l1 = r2     // Catch:{ all -> 0x01b1 }
            r4 = 1065353216(0x3f800000, float:1.0)
            r1.l2 = r4     // Catch:{ all -> 0x01b1 }
            r1.I1 = r3     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.MediaMetadata r4 = androidx.media3.common.MediaMetadata.O4     // Catch:{ all -> 0x01b1 }
            r1.T1 = r4     // Catch:{ all -> 0x01b1 }
            r1.U1 = r4     // Catch:{ all -> 0x01b1 }
            r1.x2 = r4     // Catch:{ all -> 0x01b1 }
            r4 = -1
            r1.z2 = r4     // Catch:{ all -> 0x01b1 }
            r4 = r35
            r6 = 21
            if (r4 >= r6) goto L_0x022a
            int r6 = r1.m4(r3)     // Catch:{ all -> 0x01b1 }
        L_0x0227:
            r1.j2 = r6     // Catch:{ all -> 0x01b1 }
            goto L_0x022f
        L_0x022a:
            int r6 = androidx.media3.common.util.Util.V(r34)     // Catch:{ all -> 0x01b1 }
            goto L_0x0227
        L_0x022f:
            androidx.media3.common.text.CueGroup r6 = androidx.media3.common.text.CueGroup.Y     // Catch:{ all -> 0x01b1 }
            r1.n2 = r6     // Catch:{ all -> 0x01b1 }
            r6 = 1
            r1.q2 = r6     // Catch:{ all -> 0x01b1 }
            r1.f2(r10)     // Catch:{ all -> 0x01b1 }
            android.os.Handler r7 = new android.os.Handler     // Catch:{ all -> 0x01b1 }
            r8 = r36
            r7.<init>(r8)     // Catch:{ all -> 0x01b1 }
            r5.c(r7, r10)     // Catch:{ all -> 0x01b1 }
            r1.M0(r0)     // Catch:{ all -> 0x01b1 }
            r5 = r0
            r0 = r40
            long r9 = r0.f10184c     // Catch:{ all -> 0x01b1 }
            r11 = 0
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 <= 0) goto L_0x0254
            r2.A(r9)     // Catch:{ all -> 0x01b1 }
        L_0x0254:
            androidx.media3.exoplayer.AudioBecomingNoisyManager r2 = new androidx.media3.exoplayer.AudioBecomingNoisyManager     // Catch:{ all -> 0x01b1 }
            android.content.Context r7 = r0.f10182a     // Catch:{ all -> 0x01b1 }
            r9 = r30
            r2.<init>(r7, r9, r5)     // Catch:{ all -> 0x01b1 }
            r1.A1 = r2     // Catch:{ all -> 0x01b1 }
            boolean r7 = r0.o     // Catch:{ all -> 0x01b1 }
            r2.b(r7)     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.AudioFocusManager r2 = new androidx.media3.exoplayer.AudioFocusManager     // Catch:{ all -> 0x01b1 }
            android.content.Context r7 = r0.f10182a     // Catch:{ all -> 0x01b1 }
            r2.<init>(r7, r9, r5)     // Catch:{ all -> 0x01b1 }
            r1.B1 = r2     // Catch:{ all -> 0x01b1 }
            boolean r7 = r0.f10194m     // Catch:{ all -> 0x01b1 }
            if (r7 == 0) goto L_0x0274
            androidx.media3.common.AudioAttributes r11 = r1.k2     // Catch:{ all -> 0x01b1 }
            goto L_0x0275
        L_0x0274:
            r11 = 0
        L_0x0275:
            r2.n(r11)     // Catch:{ all -> 0x01b1 }
            if (r33 == 0) goto L_0x0299
            r2 = 23
            if (r4 < r2) goto L_0x0299
            java.lang.String r2 = "audio"
            r4 = r34
            java.lang.Object r2 = r4.getSystemService(r2)     // Catch:{ all -> 0x01b1 }
            android.media.AudioManager r2 = (android.media.AudioManager) r2     // Catch:{ all -> 0x01b1 }
            r1.G1 = r2     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.ExoPlayerImpl$NoSuitableOutputPlaybackSuppressionAudioDeviceCallback r4 = new androidx.media3.exoplayer.ExoPlayerImpl$NoSuitableOutputPlaybackSuppressionAudioDeviceCallback     // Catch:{ all -> 0x01b1 }
            r7 = 0
            r4.<init>()     // Catch:{ all -> 0x01b1 }
            android.os.Handler r10 = new android.os.Handler     // Catch:{ all -> 0x01b1 }
            r10.<init>(r8)     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.ExoPlayerImpl.Api23.b(r2, r4, r10)     // Catch:{ all -> 0x01b1 }
            goto L_0x029a
        L_0x0299:
            r7 = 0
        L_0x029a:
            boolean r2 = r0.q     // Catch:{ all -> 0x01b1 }
            if (r2 == 0) goto L_0x02b3
            androidx.media3.exoplayer.StreamVolumeManager r2 = new androidx.media3.exoplayer.StreamVolumeManager     // Catch:{ all -> 0x01b1 }
            android.content.Context r4 = r0.f10182a     // Catch:{ all -> 0x01b1 }
            r2.<init>(r4, r9, r5)     // Catch:{ all -> 0x01b1 }
            r1.C1 = r2     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.AudioAttributes r4 = r1.k2     // Catch:{ all -> 0x01b1 }
            int r4 = r4.Y     // Catch:{ all -> 0x01b1 }
            int r4 = androidx.media3.common.util.Util.J0(r4)     // Catch:{ all -> 0x01b1 }
            r2.m(r4)     // Catch:{ all -> 0x01b1 }
            goto L_0x02b5
        L_0x02b3:
            r1.C1 = r7     // Catch:{ all -> 0x01b1 }
        L_0x02b5:
            androidx.media3.exoplayer.WakeLockManager r2 = new androidx.media3.exoplayer.WakeLockManager     // Catch:{ all -> 0x01b1 }
            android.content.Context r4 = r0.f10182a     // Catch:{ all -> 0x01b1 }
            r2.<init>(r4)     // Catch:{ all -> 0x01b1 }
            r1.D1 = r2     // Catch:{ all -> 0x01b1 }
            int r4 = r0.f10195n     // Catch:{ all -> 0x01b1 }
            if (r4 == 0) goto L_0x02c4
            r15 = 1
            goto L_0x02c5
        L_0x02c4:
            r15 = 0
        L_0x02c5:
            r2.a(r15)     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.WifiLockManager r2 = new androidx.media3.exoplayer.WifiLockManager     // Catch:{ all -> 0x01b1 }
            android.content.Context r4 = r0.f10182a     // Catch:{ all -> 0x01b1 }
            r2.<init>(r4)     // Catch:{ all -> 0x01b1 }
            r1.E1 = r2     // Catch:{ all -> 0x01b1 }
            int r0 = r0.f10195n     // Catch:{ all -> 0x01b1 }
            r4 = 2
            if (r0 != r4) goto L_0x02d8
            r15 = 1
            goto L_0x02d9
        L_0x02d8:
            r15 = 0
        L_0x02d9:
            r2.a(r15)     // Catch:{ all -> 0x01b1 }
            androidx.media3.exoplayer.StreamVolumeManager r0 = r1.C1     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.DeviceInfo r0 = X3(r0)     // Catch:{ all -> 0x01b1 }
            r1.v2 = r0     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.VideoSize r0 = androidx.media3.common.VideoSize.b3     // Catch:{ all -> 0x01b1 }
            r1.w2 = r0     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.util.Size r0 = androidx.media3.common.util.Size.f9620c     // Catch:{ all -> 0x01b1 }
            r1.g2 = r0     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.AudioAttributes r0 = r1.k2     // Catch:{ all -> 0x01b1 }
            r14 = r38
            r14.l(r0)     // Catch:{ all -> 0x01b1 }
            int r0 = r1.j2     // Catch:{ all -> 0x01b1 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x01b1 }
            r2 = 10
            r3 = 1
            r1.W4(r3, r2, r0)     // Catch:{ all -> 0x01b1 }
            int r0 = r1.j2     // Catch:{ all -> 0x01b1 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x01b1 }
            r4 = 2
            r1.W4(r4, r2, r0)     // Catch:{ all -> 0x01b1 }
            androidx.media3.common.AudioAttributes r0 = r1.k2     // Catch:{ all -> 0x01b1 }
            r2 = 3
            r1.W4(r3, r2, r0)     // Catch:{ all -> 0x01b1 }
            int r0 = r1.e2     // Catch:{ all -> 0x01b1 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x01b1 }
            r2 = 4
            r1.W4(r4, r2, r0)     // Catch:{ all -> 0x01b1 }
            int r0 = r1.f2     // Catch:{ all -> 0x01b1 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x01b1 }
            r2 = 5
            r1.W4(r4, r2, r0)     // Catch:{ all -> 0x01b1 }
            boolean r0 = r1.m2     // Catch:{ all -> 0x01b1 }
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ all -> 0x01b1 }
            r2 = 9
            r3 = 1
            r1.W4(r3, r2, r0)     // Catch:{ all -> 0x01b1 }
            r0 = 7
            r2 = r31
            r1.W4(r4, r0, r2)     // Catch:{ all -> 0x01b1 }
            r0 = 6
            r3 = 8
            r1.W4(r0, r3, r2)     // Catch:{ all -> 0x01b1 }
            r32.f()
            return
        L_0x033f:
            r0 = move-exception
            r1 = r39
        L_0x0342:
            androidx.media3.common.util.ConditionVariable r2 = r1.e1
            r2.f()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.ExoPlayerImpl.<init>(androidx.media3.exoplayer.ExoPlayer$Builder, androidx.media3.common.Player):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A4(Player.Listener listener) {
        listener.t0(this.S1);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void C4(int i3, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, Player.Listener listener) {
        listener.F(i3);
        listener.u0(positionInfo, positionInfo2, i3);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void I4(PlaybackInfo playbackInfo, Player.Listener listener) {
        listener.E(playbackInfo.f10310g);
        listener.H(playbackInfo.f10310g);
    }

    private PlaybackInfo P4(PlaybackInfo playbackInfo, Timeline timeline, @Nullable Pair<Object, Long> pair) {
        int i3;
        Timeline timeline2 = timeline;
        Pair<Object, Long> pair2 = pair;
        Assertions.a(timeline.x() || pair2 != null);
        Timeline timeline3 = playbackInfo.f10304a;
        long c4 = c4(playbackInfo);
        PlaybackInfo j3 = playbackInfo.j(timeline);
        if (timeline.x()) {
            MediaSource.MediaPeriodId l3 = PlaybackInfo.l();
            long I12 = Util.I1(this.B2);
            PlaybackInfo c3 = j3.d(l3, I12, I12, I12, 0, TrackGroupArray.X2, this.c1, ImmutableList.I()).c(l3);
            c3.p = c3.r;
            return c3;
        }
        Object obj = j3.f10305b.f12163a;
        boolean z = !obj.equals(((Pair) Util.o(pair)).first);
        MediaSource.MediaPeriodId mediaPeriodId = z ? new MediaSource.MediaPeriodId(pair2.first) : j3.f10305b;
        long longValue = ((Long) pair2.second).longValue();
        long I13 = Util.I1(c4);
        if (!timeline3.x()) {
            I13 -= timeline3.m(obj, this.o1).s();
        }
        if (z || longValue < I13) {
            long j4 = longValue;
            MediaSource.MediaPeriodId mediaPeriodId2 = mediaPeriodId;
            Assertions.i(!mediaPeriodId2.c());
            MediaSource.MediaPeriodId mediaPeriodId3 = mediaPeriodId2;
            PlaybackInfo c5 = j3.d(mediaPeriodId3, j4, j4, j4, 0, z ? TrackGroupArray.X2 : j3.f10311h, z ? this.c1 : j3.f10312i, z ? ImmutableList.I() : j3.f10313j).c(mediaPeriodId3);
            c5.p = j4;
            return c5;
        }
        if (i3 == 0) {
            int g3 = timeline2.g(j3.f10314k.f12163a);
            if (g3 == -1 || timeline2.k(g3, this.o1).Y != timeline2.m(mediaPeriodId.f12163a, this.o1).Y) {
                timeline2.m(mediaPeriodId.f12163a, this.o1);
                long j5 = mediaPeriodId.c() ? this.o1.e(mediaPeriodId.f12164b, mediaPeriodId.f12165c) : this.o1.Z;
                j3 = j3.d(mediaPeriodId, j3.r, j3.r, j3.f10307d, j5 - j3.r, j3.f10311h, j3.f10312i, j3.f10313j).c(mediaPeriodId);
                j3.p = j5;
            }
        } else {
            MediaSource.MediaPeriodId mediaPeriodId4 = mediaPeriodId;
            Assertions.i(!mediaPeriodId4.c());
            long max = Math.max(0, j3.q - (longValue - I13));
            long j6 = j3.p;
            if (j3.f10314k.equals(j3.f10305b)) {
                j6 = longValue + max;
            }
            j3 = j3.d(mediaPeriodId4, longValue, longValue, longValue, max, j3.f10311h, j3.f10312i, j3.f10313j);
            j3.p = j5;
        }
        return j3;
    }

    @Nullable
    private Pair<Object, Long> Q4(Timeline timeline, int i3, long j3) {
        if (timeline.x()) {
            this.z2 = i3;
            if (j3 == C.f9084b) {
                j3 = 0;
            }
            this.B2 = j3;
            this.A2 = 0;
            return null;
        }
        if (i3 == -1 || i3 >= timeline.w()) {
            i3 = timeline.f(this.J1);
            j3 = timeline.u(i3, this.b1).d();
        }
        return timeline.q(this.b1, this.o1, i3, Util.I1(j3));
    }

    /* access modifiers changed from: private */
    public void R4(int i3, int i4) {
        if (i3 != this.g2.b() || i4 != this.g2.a()) {
            this.g2 = new Size(i3, i4);
            this.m1.m(24, new C0312i0(i3, i4));
            W4(2, 14, new Size(i3, i4));
        }
    }

    private List<MediaSourceList.MediaSourceHolder> S3(int i3, List<MediaSource> list) {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < list.size(); i4++) {
            MediaSourceList.MediaSourceHolder mediaSourceHolder = new MediaSourceList.MediaSourceHolder(list.get(i4), this.q1);
            arrayList.add(mediaSourceHolder);
            this.p1.add(i4 + i3, new MediaSourceHolderSnapshot(mediaSourceHolder.f10289b, mediaSourceHolder.f10288a));
        }
        this.Q1 = this.Q1.e(i3, arrayList.size());
        return arrayList;
    }

    private long S4(Timeline timeline, MediaSource.MediaPeriodId mediaPeriodId, long j3) {
        timeline.m(mediaPeriodId.f12163a, this.o1);
        return j3 + this.o1.s();
    }

    private PlaybackInfo T3(PlaybackInfo playbackInfo, int i3, List<MediaSource> list) {
        Timeline timeline = playbackInfo.f10304a;
        this.K1++;
        List<MediaSourceList.MediaSourceHolder> S3 = S3(i3, list);
        Timeline Y3 = Y3();
        PlaybackInfo P4 = P4(playbackInfo, Y3, f4(timeline, Y3, e4(playbackInfo), c4(playbackInfo)));
        this.l1.p(i3, S3, this.Q1);
        return P4;
    }

    private PlaybackInfo T4(PlaybackInfo playbackInfo, int i3, int i4) {
        int e4 = e4(playbackInfo);
        long c4 = c4(playbackInfo);
        Timeline timeline = playbackInfo.f10304a;
        int size = this.p1.size();
        this.K1++;
        U4(i3, i4);
        Timeline Y3 = Y3();
        PlaybackInfo P4 = P4(playbackInfo, Y3, f4(timeline, Y3, e4, c4));
        int i5 = P4.f10308e;
        if (i5 != 1 && i5 != 4 && i3 < i4 && i4 == size && e4 >= P4.f10304a.w()) {
            P4 = P4.h(4);
        }
        this.l1.w0(i3, i4, this.Q1);
        return P4;
    }

    /* access modifiers changed from: private */
    public MediaMetadata U3() {
        Timeline j22 = j2();
        if (j22.x()) {
            return this.x2;
        }
        return this.x2.b().J(j22.u(P1(), this.b1).Y.X2).H();
    }

    private void U4(int i3, int i4) {
        for (int i5 = i4 - 1; i5 >= i3; i5--) {
            this.p1.remove(i5);
        }
        this.Q1 = this.Q1.a(i3, i4);
    }

    private boolean V3(int i3, int i4, List<MediaItem> list) {
        if (i4 - i3 != list.size()) {
            return false;
        }
        for (int i5 = i3; i5 < i4; i5++) {
            if (!this.p1.get(i5).f10197b.S(list.get(i5 - i3))) {
                return false;
            }
        }
        return true;
    }

    private void V4() {
        if (this.b2 != null) {
            a4(this.z1).u(10000).r((Object) null).n();
            this.b2.i(this.y1);
            this.b2 = null;
        }
        TextureView textureView = this.d2;
        if (textureView != null) {
            if (textureView.getSurfaceTextureListener() != this.y1) {
                Log.n(C2, "SurfaceTextureListener already unset or replaced.");
            } else {
                this.d2.setSurfaceTextureListener((TextureView.SurfaceTextureListener) null);
            }
            this.d2 = null;
        }
        SurfaceHolder surfaceHolder = this.a2;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.y1);
            this.a2 = null;
        }
    }

    private int W3(boolean z, int i3) {
        if (z && i3 != 1) {
            return 1;
        }
        if (!this.H1) {
            return 0;
        }
        if (!z || l4()) {
            return (z || this.y2.f10316m != 3) ? 0 : 3;
        }
        return 3;
    }

    private void W4(int i3, int i4, @Nullable Object obj) {
        for (Renderer renderer : this.h1) {
            if (renderer.i() == i3) {
                a4(renderer).u(i4).r(obj).n();
            }
        }
    }

    /* access modifiers changed from: private */
    public static DeviceInfo X3(@Nullable StreamVolumeManager streamVolumeManager) {
        int i3 = 0;
        DeviceInfo.Builder g3 = new DeviceInfo.Builder(0).g(streamVolumeManager != null ? streamVolumeManager.e() : 0);
        if (streamVolumeManager != null) {
            i3 = streamVolumeManager.d();
        }
        return g3.f(i3).e();
    }

    /* access modifiers changed from: private */
    public void X4() {
        W4(1, 2, Float.valueOf(this.l2 * this.B1.h()));
    }

    private Timeline Y3() {
        return new PlaylistTimeline(this.p1, this.Q1);
    }

    private void Y4(List<MediaSource> list, int i3, long j3, boolean z) {
        int i4;
        long j4;
        int i5 = i3;
        int e4 = e4(this.y2);
        long z22 = z2();
        this.K1++;
        if (!this.p1.isEmpty()) {
            U4(0, this.p1.size());
        }
        List<MediaSourceList.MediaSourceHolder> S3 = S3(0, list);
        Timeline Y3 = Y3();
        if (Y3.x() || i5 < Y3.w()) {
            long j5 = j3;
            if (z) {
                int f3 = Y3.f(this.J1);
                j4 = C.f9084b;
                i4 = f3;
            } else if (i5 == -1) {
                i4 = e4;
                j4 = z22;
            } else {
                i4 = i5;
                j4 = j5;
            }
            PlaybackInfo P4 = P4(this.y2, Y3, Q4(Y3, i4, j4));
            int i6 = P4.f10308e;
            if (!(i4 == -1 || i6 == 1)) {
                i6 = (Y3.x() || i4 >= Y3.w()) ? 4 : 2;
            }
            PlaybackInfo h3 = P4.h(i6);
            this.l1.Y0(S3, i4, Util.I1(j4), this.Q1);
            h5(h3, 0, 1, !this.y2.f10305b.f12163a.equals(h3.f10305b.f12163a) && !this.y2.f10304a.x(), 4, d4(h3), -1, false);
            return;
        }
        throw new IllegalSeekPositionException(Y3, i5, j3);
    }

    private List<MediaSource> Z3(List<MediaItem> list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            arrayList.add(this.r1.c(list.get(i3)));
        }
        return arrayList;
    }

    private void Z4(SurfaceHolder surfaceHolder) {
        this.c2 = false;
        this.a2 = surfaceHolder;
        surfaceHolder.addCallback(this.y1);
        Surface surface = this.a2.getSurface();
        if (surface == null || !surface.isValid()) {
            R4(0, 0);
            return;
        }
        Rect surfaceFrame = this.a2.getSurfaceFrame();
        R4(surfaceFrame.width(), surfaceFrame.height());
    }

    private PlayerMessage a4(PlayerMessage.Target target) {
        int e4 = e4(this.y2);
        ExoPlayerImplInternal exoPlayerImplInternal = this.l1;
        return new PlayerMessage(exoPlayerImplInternal, target, this.y2.f10304a, e4 == -1 ? 0 : e4, this.x1, exoPlayerImplInternal.H());
    }

    /* access modifiers changed from: private */
    public void a5(SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        c5(surface);
        this.Z1 = surface;
    }

    private Pair<Boolean, Integer> b4(PlaybackInfo playbackInfo, PlaybackInfo playbackInfo2, boolean z, int i3, boolean z3, boolean z4) {
        Timeline timeline = playbackInfo2.f10304a;
        Timeline timeline2 = playbackInfo.f10304a;
        if (timeline2.x() && timeline.x()) {
            return new Pair<>(Boolean.FALSE, -1);
        }
        int i4 = 3;
        if (timeline2.x() != timeline.x()) {
            return new Pair<>(Boolean.TRUE, 3);
        }
        if (!timeline.u(timeline.m(playbackInfo2.f10305b.f12163a, this.o1).Y, this.b1).s.equals(timeline2.u(timeline2.m(playbackInfo.f10305b.f12163a, this.o1).Y, this.b1).s)) {
            if (z && i3 == 0) {
                i4 = 1;
            } else if (z && i3 == 1) {
                i4 = 2;
            } else if (!z3) {
                throw new IllegalStateException();
            }
            return new Pair<>(Boolean.TRUE, Integer.valueOf(i4));
        } else if (!z || i3 != 0 || playbackInfo2.f10305b.f12166d >= playbackInfo.f10305b.f12166d) {
            return (!z || i3 != 1 || !z4) ? new Pair<>(Boolean.FALSE, -1) : new Pair<>(Boolean.TRUE, 2);
        } else {
            return new Pair<>(Boolean.TRUE, 0);
        }
    }

    private long c4(PlaybackInfo playbackInfo) {
        if (!playbackInfo.f10305b.c()) {
            return Util.H2(d4(playbackInfo));
        }
        playbackInfo.f10304a.m(playbackInfo.f10305b.f12163a, this.o1);
        return playbackInfo.f10306c == C.f9084b ? playbackInfo.f10304a.u(e4(playbackInfo), this.b1).d() : this.o1.r() + Util.H2(playbackInfo.f10306c);
    }

    /* access modifiers changed from: private */
    public void c5(@Nullable Object obj) {
        ArrayList<PlayerMessage> arrayList = new ArrayList<>();
        boolean z = false;
        for (Renderer renderer : this.h1) {
            if (renderer.i() == 2) {
                arrayList.add(a4(renderer).u(1).r(obj).n());
            }
        }
        Object obj2 = this.Y1;
        if (!(obj2 == null || obj2 == obj)) {
            try {
                for (PlayerMessage b3 : arrayList) {
                    b3.b(this.F1);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z = true;
            }
            Object obj3 = this.Y1;
            Surface surface = this.Z1;
            if (obj3 == surface) {
                surface.release();
                this.Z1 = null;
            }
        }
        this.Y1 = obj;
        if (z) {
            d5(ExoPlaybackException.o(new ExoTimeoutException(3), 1003));
        }
    }

    private long d4(PlaybackInfo playbackInfo) {
        if (playbackInfo.f10304a.x()) {
            return Util.I1(this.B2);
        }
        long m3 = playbackInfo.o ? playbackInfo.m() : playbackInfo.r;
        return playbackInfo.f10305b.c() ? m3 : S4(playbackInfo.f10304a, playbackInfo.f10305b, m3);
    }

    private void d5(@Nullable ExoPlaybackException exoPlaybackException) {
        PlaybackInfo playbackInfo = this.y2;
        PlaybackInfo c3 = playbackInfo.c(playbackInfo.f10305b);
        c3.p = c3.r;
        c3.q = 0;
        PlaybackInfo h3 = c3.h(1);
        if (exoPlaybackException != null) {
            h3 = h3.f(exoPlaybackException);
        }
        this.K1++;
        this.l1.v1();
        h5(h3, 0, 1, false, 5, C.f9084b, -1, false);
    }

    private int e4(PlaybackInfo playbackInfo) {
        return playbackInfo.f10304a.x() ? this.z2 : playbackInfo.f10304a.m(playbackInfo.f10305b.f12163a, this.o1).Y;
    }

    private void e5() {
        Player.Commands commands = this.S1;
        Player.Commands c0 = Util.c0(this.g1, this.d1);
        this.S1 = c0;
        if (!c0.equals(commands)) {
            this.m1.j(13, new Q(this));
        }
    }

    @Nullable
    private Pair<Object, Long> f4(Timeline timeline, Timeline timeline2, int i3, long j3) {
        Timeline timeline3 = timeline2;
        boolean x = timeline.x();
        long j4 = C.f9084b;
        int i4 = -1;
        if (x || timeline2.x()) {
            boolean z = !timeline.x() && timeline2.x();
            if (!z) {
                i4 = i3;
            }
            if (!z) {
                j4 = j3;
            }
            return Q4(timeline2, i4, j4);
        }
        Pair<Object, Long> q = timeline.q(this.b1, this.o1, i3, Util.I1(j3));
        Object obj = ((Pair) Util.o(q)).first;
        if (timeline2.g(obj) != -1) {
            return q;
        }
        Object I0 = ExoPlayerImplInternal.I0(this.b1, this.o1, this.I1, this.J1, obj, timeline, timeline2);
        if (I0 == null) {
            return Q4(timeline2, -1, C.f9084b);
        }
        timeline2.m(I0, this.o1);
        int i5 = this.o1.Y;
        return Q4(timeline2, i5, timeline2.u(i5, this.b1).d());
    }

    private void f5(int i3, int i4, List<MediaItem> list) {
        this.K1++;
        this.l1.A1(i3, i4, list);
        for (int i5 = i3; i5 < i4; i5++) {
            MediaSourceHolderSnapshot mediaSourceHolderSnapshot = this.p1.get(i5);
            mediaSourceHolderSnapshot.d(new TimelineWithUpdatedMediaItem(mediaSourceHolderSnapshot.a(), list.get(i5 - i3)));
        }
        h5(this.y2.j(Y3()), 0, 1, false, 4, C.f9084b, -1, false);
    }

    /* access modifiers changed from: private */
    public static int g4(boolean z, int i3) {
        return (!z || i3 == 1) ? 1 : 2;
    }

    /* access modifiers changed from: private */
    public void g5(boolean z, int i3, int i4) {
        boolean z3 = z && i3 != -1;
        int W3 = W3(z3, i3);
        PlaybackInfo playbackInfo = this.y2;
        if (playbackInfo.f10315l != z3 || playbackInfo.f10316m != W3) {
            i5(z3, i4, W3);
        }
    }

    private Player.PositionInfo h4(long j3) {
        int i3;
        Object obj;
        MediaItem mediaItem;
        Object obj2;
        int P12 = P1();
        if (!this.y2.f10304a.x()) {
            PlaybackInfo playbackInfo = this.y2;
            Object obj3 = playbackInfo.f10305b.f12163a;
            playbackInfo.f10304a.m(obj3, this.o1);
            i3 = this.y2.f10304a.g(obj3);
            obj = obj3;
            obj2 = this.y2.f10304a.u(P12, this.b1).s;
            mediaItem = this.b1.Y;
        } else {
            obj2 = null;
            mediaItem = null;
            obj = null;
            i3 = -1;
        }
        long H2 = Util.H2(j3);
        long H22 = this.y2.f10305b.c() ? Util.H2(j4(this.y2)) : H2;
        MediaSource.MediaPeriodId mediaPeriodId = this.y2.f10305b;
        return new Player.PositionInfo(obj2, P12, mediaItem, obj, i3, H2, H22, mediaPeriodId.f12164b, mediaPeriodId.f12165c);
    }

    private void h5(PlaybackInfo playbackInfo, int i3, int i4, boolean z, int i5, long j3, int i6, boolean z3) {
        PlaybackInfo playbackInfo2 = playbackInfo;
        int i7 = i5;
        PlaybackInfo playbackInfo3 = this.y2;
        this.y2 = playbackInfo2;
        boolean z4 = !playbackInfo3.f10304a.equals(playbackInfo2.f10304a);
        Pair<Boolean, Integer> b4 = b4(playbackInfo, playbackInfo3, z, i5, z4, z3);
        boolean booleanValue = ((Boolean) b4.first).booleanValue();
        int intValue = ((Integer) b4.second).intValue();
        MediaItem mediaItem = null;
        if (booleanValue) {
            if (!playbackInfo2.f10304a.x()) {
                mediaItem = playbackInfo2.f10304a.u(playbackInfo2.f10304a.m(playbackInfo2.f10305b.f12163a, this.o1).Y, this.b1).Y;
            }
            this.x2 = MediaMetadata.O4;
        }
        if (booleanValue || !playbackInfo3.f10313j.equals(playbackInfo2.f10313j)) {
            this.x2 = this.x2.b().L(playbackInfo2.f10313j).H();
        }
        MediaMetadata U3 = U3();
        boolean z5 = !U3.equals(this.T1);
        this.T1 = U3;
        boolean z6 = playbackInfo3.f10315l != playbackInfo2.f10315l;
        boolean z7 = playbackInfo3.f10308e != playbackInfo2.f10308e;
        if (z7 || z6) {
            k5();
        }
        boolean z8 = playbackInfo3.f10310g;
        boolean z9 = playbackInfo2.f10310g;
        boolean z10 = z8 != z9;
        if (z10) {
            j5(z9);
        }
        if (z4) {
            this.m1.j(0, new S(playbackInfo2, i3));
        }
        if (z) {
            this.m1.j(11, new Y(i7, i4(i7, playbackInfo3, i6), h4(j3)));
        }
        if (booleanValue) {
            this.m1.j(1, new Z(mediaItem, intValue));
        }
        if (playbackInfo3.f10309f != playbackInfo2.f10309f) {
            this.m1.j(10, new C0204a0(playbackInfo2));
            if (playbackInfo2.f10309f != null) {
                this.m1.j(10, new C0282b0(playbackInfo2));
            }
        }
        TrackSelectorResult trackSelectorResult = playbackInfo3.f10312i;
        TrackSelectorResult trackSelectorResult2 = playbackInfo2.f10312i;
        if (trackSelectorResult != trackSelectorResult2) {
            this.i1.i(trackSelectorResult2.f12420e);
            this.m1.j(2, new C0284c0(playbackInfo2));
        }
        if (z5) {
            this.m1.j(14, new C0286d0(this.T1));
        }
        if (z10) {
            this.m1.j(3, new C0304e0(playbackInfo2));
        }
        if (z7 || z6) {
            this.m1.j(-1, new C0306f0(playbackInfo2));
        }
        if (z7) {
            this.m1.j(4, new C0308g0(playbackInfo2));
        }
        if (z6) {
            this.m1.j(5, new T(playbackInfo2, i4));
        }
        if (playbackInfo3.f10316m != playbackInfo2.f10316m) {
            this.m1.j(6, new U(playbackInfo2));
        }
        if (playbackInfo3.n() != playbackInfo.n()) {
            this.m1.j(7, new V(playbackInfo2));
        }
        if (!playbackInfo3.f10317n.equals(playbackInfo2.f10317n)) {
            this.m1.j(12, new W(playbackInfo2));
        }
        e5();
        this.m1.g();
        if (playbackInfo3.o != playbackInfo2.o) {
            Iterator<ExoPlayer.AudioOffloadListener> it2 = this.n1.iterator();
            while (it2.hasNext()) {
                it2.next().J(playbackInfo2.o);
            }
        }
    }

    private Player.PositionInfo i4(int i3, PlaybackInfo playbackInfo, int i4) {
        int i5;
        Object obj;
        MediaItem mediaItem;
        int i6;
        Object obj2;
        long j3;
        long j4;
        long j5;
        PlaybackInfo playbackInfo2 = playbackInfo;
        Timeline.Period period = new Timeline.Period();
        if (!playbackInfo2.f10304a.x()) {
            Object obj3 = playbackInfo2.f10305b.f12163a;
            playbackInfo2.f10304a.m(obj3, period);
            int i7 = period.Y;
            int g3 = playbackInfo2.f10304a.g(obj3);
            Object obj4 = playbackInfo2.f10304a.u(i7, this.b1).s;
            mediaItem = this.b1.Y;
            obj = obj3;
            i5 = g3;
            obj2 = obj4;
            i6 = i7;
        } else {
            i6 = i4;
            obj2 = null;
            mediaItem = null;
            obj = null;
            i5 = -1;
        }
        boolean c3 = playbackInfo2.f10305b.c();
        if (i3 == 0) {
            if (c3) {
                MediaSource.MediaPeriodId mediaPeriodId = playbackInfo2.f10305b;
                j4 = period.e(mediaPeriodId.f12164b, mediaPeriodId.f12165c);
            } else {
                j5 = playbackInfo2.f10305b.f12167e != -1 ? j4(this.y2) : period.X2 + period.Z;
                j3 = j4;
                long H2 = Util.H2(j4);
                long H22 = Util.H2(j3);
                MediaSource.MediaPeriodId mediaPeriodId2 = playbackInfo2.f10305b;
                return new Player.PositionInfo(obj2, i6, mediaItem, obj, i5, H2, H22, mediaPeriodId2.f12164b, mediaPeriodId2.f12165c);
            }
        } else if (c3) {
            j4 = playbackInfo2.r;
        } else {
            j5 = period.X2 + playbackInfo2.r;
            j3 = j4;
            long H23 = Util.H2(j4);
            long H222 = Util.H2(j3);
            MediaSource.MediaPeriodId mediaPeriodId22 = playbackInfo2.f10305b;
            return new Player.PositionInfo(obj2, i6, mediaItem, obj, i5, H23, H222, mediaPeriodId22.f12164b, mediaPeriodId22.f12165c);
        }
        j3 = j4(playbackInfo);
        long H232 = Util.H2(j4);
        long H2222 = Util.H2(j3);
        MediaSource.MediaPeriodId mediaPeriodId222 = playbackInfo2.f10305b;
        return new Player.PositionInfo(obj2, i6, mediaItem, obj, i5, H232, H2222, mediaPeriodId222.f12164b, mediaPeriodId222.f12165c);
    }

    /* access modifiers changed from: private */
    public void i5(boolean z, int i3, int i4) {
        this.K1++;
        PlaybackInfo playbackInfo = this.y2;
        if (playbackInfo.o) {
            playbackInfo = playbackInfo.a();
        }
        PlaybackInfo e3 = playbackInfo.e(z, i4);
        this.l1.c1(z, i4);
        h5(e3, 0, i3, false, 5, C.f9084b, -1, false);
    }

    private static long j4(PlaybackInfo playbackInfo) {
        Timeline.Window window = new Timeline.Window();
        Timeline.Period period = new Timeline.Period();
        playbackInfo.f10304a.m(playbackInfo.f10305b.f12163a, period);
        return playbackInfo.f10306c == C.f9084b ? playbackInfo.f10304a.u(period.Y, window).e() : period.s() + playbackInfo.f10306c;
    }

    private void j5(boolean z) {
        PriorityTaskManager priorityTaskManager = this.s2;
        if (priorityTaskManager == null) {
            return;
        }
        if (z && !this.t2) {
            priorityTaskManager.a(0);
            this.t2 = true;
        } else if (!z && this.t2) {
            priorityTaskManager.e(0);
            this.t2 = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k4 */
    public void p4(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        long j3;
        boolean z;
        long j4;
        int i3 = this.K1 - playbackInfoUpdate.f10211c;
        this.K1 = i3;
        boolean z3 = true;
        if (playbackInfoUpdate.f10212d) {
            this.L1 = playbackInfoUpdate.f10213e;
            this.M1 = true;
        }
        if (playbackInfoUpdate.f10214f) {
            this.N1 = playbackInfoUpdate.f10215g;
        }
        if (i3 == 0) {
            Timeline timeline = playbackInfoUpdate.f10210b.f10304a;
            if (!this.y2.f10304a.x() && timeline.x()) {
                this.z2 = -1;
                this.B2 = 0;
                this.A2 = 0;
            }
            if (!timeline.x()) {
                List<Timeline> M = ((PlaylistTimeline) timeline).M();
                Assertions.i(M.size() == this.p1.size());
                for (int i4 = 0; i4 < M.size(); i4++) {
                    this.p1.get(i4).d(M.get(i4));
                }
            }
            if (this.M1) {
                if (playbackInfoUpdate.f10210b.f10305b.equals(this.y2.f10305b) && playbackInfoUpdate.f10210b.f10307d == this.y2.r) {
                    z3 = false;
                }
                if (z3) {
                    if (timeline.x() || playbackInfoUpdate.f10210b.f10305b.c()) {
                        j4 = playbackInfoUpdate.f10210b.f10307d;
                    } else {
                        PlaybackInfo playbackInfo = playbackInfoUpdate.f10210b;
                        j4 = S4(timeline, playbackInfo.f10305b, playbackInfo.f10307d);
                    }
                    j3 = j4;
                } else {
                    j3 = -9223372036854775807L;
                }
                z = z3;
            } else {
                j3 = -9223372036854775807L;
                z = false;
            }
            this.M1 = false;
            h5(playbackInfoUpdate.f10210b, 1, this.N1, z, this.L1, j3, -1, false);
        }
    }

    /* access modifiers changed from: private */
    public void k5() {
        int i3 = i();
        boolean z = true;
        if (i3 != 1) {
            if (i3 == 2 || i3 == 3) {
                boolean n22 = n2();
                WakeLockManager wakeLockManager = this.D1;
                if (!m0() || n22) {
                    z = false;
                }
                wakeLockManager.b(z);
                this.E1.b(m0());
                return;
            } else if (i3 != 4) {
                throw new IllegalStateException();
            }
        }
        this.D1.b(false);
        this.E1.b(false);
    }

    /* access modifiers changed from: private */
    public boolean l4() {
        AudioManager audioManager = this.G1;
        if (audioManager == null || Util.f9646a < 23) {
            return true;
        }
        return Api23.a(this.f1, audioManager.getDevices(2));
    }

    private void l5() {
        this.e1.c();
        if (Thread.currentThread() != k2().getThread()) {
            String S = Util.S("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), k2().getThread().getName());
            if (!this.q2) {
                Log.o(C2, S, this.r2 ? null : new IllegalStateException());
                this.r2 = true;
                return;
            }
            throw new IllegalStateException(S);
        }
    }

    private int m4(int i3) {
        AudioTrack audioTrack = this.X1;
        if (!(audioTrack == null || audioTrack.getAudioSessionId() == i3)) {
            this.X1.release();
            this.X1 = null;
        }
        if (this.X1 == null) {
            this.X1 = new AudioTrack(3, 4000, 4, 2, 2, 0, i3);
        }
        return this.X1.getAudioSessionId();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void o4(Player.Listener listener, FlagSet flagSet) {
        listener.I(this.g1, new Player.Events(flagSet));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q4(ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate) {
        this.j1.e(new C0318l0(this, playbackInfoUpdate));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u4(Player.Listener listener) {
        listener.a0(this.U1);
    }

    public void A(AudioAttributes audioAttributes, boolean z) {
        l5();
        if (!this.u2) {
            if (!Util.g(this.k2, audioAttributes)) {
                this.k2 = audioAttributes;
                W4(1, 3, audioAttributes);
                StreamVolumeManager streamVolumeManager = this.C1;
                if (streamVolumeManager != null) {
                    streamVolumeManager.m(Util.J0(audioAttributes.Y));
                }
                this.m1.j(20, new O(audioAttributes));
            }
            this.B1.n(z ? audioAttributes : null);
            this.i1.l(audioAttributes);
            boolean m0 = m0();
            int q = this.B1.q(m0, i());
            g5(m0, q, g4(m0, q));
            this.m1.g();
        }
    }

    public void A1(MediaSource mediaSource) {
        l5();
        b1(Collections.singletonList(mediaSource));
    }

    public long A2() {
        l5();
        return this.v1;
    }

    public float B() {
        l5();
        return this.l2;
    }

    public int B0() {
        l5();
        if (this.y2.f10304a.x()) {
            return this.A2;
        }
        PlaybackInfo playbackInfo = this.y2;
        return playbackInfo.f10304a.g(playbackInfo.f10305b.f12163a);
    }

    @Nullable
    public Format B1() {
        l5();
        return this.V1;
    }

    public DeviceInfo C() {
        l5();
        return this.v2;
    }

    public void C1(int i3) {
        l5();
        StreamVolumeManager streamVolumeManager = this.C1;
        if (streamVolumeManager != null) {
            streamVolumeManager.c(i3);
        }
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ExoPlayer.TextComponent C2() {
        l5();
        return this;
    }

    @Deprecated
    public void D() {
        l5();
        StreamVolumeManager streamVolumeManager = this.C1;
        if (streamVolumeManager != null) {
            streamVolumeManager.c(1);
        }
    }

    public Tracks D1() {
        l5();
        return this.y2.f10312i.f12419d;
    }

    public void E(@Nullable SurfaceView surfaceView) {
        l5();
        if (surfaceView instanceof VideoDecoderOutputBufferRenderer) {
            V4();
            c5(surfaceView);
        } else if (surfaceView instanceof SphericalGLSurfaceView) {
            V4();
            this.b2 = (SphericalGLSurfaceView) surfaceView;
            a4(this.z1).u(10000).r(this.b2).n();
            this.b2.d(this.y1);
            c5(this.b2.getVideoSurface());
        } else {
            I(surfaceView == null ? null : surfaceView.getHolder());
            return;
        }
        Z4(surfaceView.getHolder());
    }

    public void E1(List<MediaSource> list, boolean z) {
        l5();
        Y4(list, -1, C.f9084b, z);
    }

    public void F(int i3, int i4, List<MediaItem> list) {
        l5();
        boolean z = false;
        Assertions.a(i3 >= 0 && i4 >= i3);
        int size = this.p1.size();
        if (i3 <= size) {
            int min = Math.min(i4, size);
            if (V3(i3, min, list)) {
                f5(i3, min, list);
                return;
            }
            List<MediaSource> Z3 = Z3(list);
            if (this.p1.isEmpty()) {
                if (this.z2 == -1) {
                    z = true;
                }
                E1(Z3, z);
                return;
            }
            PlaybackInfo T4 = T4(T3(this.y2, min, Z3), i3, min);
            h5(T4, 0, 1, !T4.f10305b.f12163a.equals(this.y2.f10305b.f12163a), 4, d4(T4), -1, false);
        }
    }

    public void F0(List<MediaItem> list, boolean z) {
        l5();
        E1(Z3(list), z);
    }

    public void F2(int i3, long j3, int i4, boolean z) {
        int i5 = i3;
        l5();
        Assertions.a(i5 >= 0);
        this.s1.T();
        Timeline timeline = this.y2.f10304a;
        if (timeline.x() || i5 < timeline.w()) {
            this.K1++;
            if (c0()) {
                Log.n(C2, "seekTo ignored because an ad is playing");
                ExoPlayerImplInternal.PlaybackInfoUpdate playbackInfoUpdate = new ExoPlayerImplInternal.PlaybackInfoUpdate(this.y2);
                playbackInfoUpdate.b(1);
                this.k1.a(playbackInfoUpdate);
                return;
            }
            PlaybackInfo playbackInfo = this.y2;
            int i6 = playbackInfo.f10308e;
            if (i6 == 3 || (i6 == 4 && !timeline.x())) {
                playbackInfo = this.y2.h(2);
            }
            int P12 = P1();
            long j4 = j3;
            PlaybackInfo P4 = P4(playbackInfo, timeline, Q4(timeline, i3, j3));
            this.l1.K0(timeline, i3, Util.I1(j3));
            h5(P4, 0, 1, true, 1, d4(P4), P12, z);
        }
    }

    public void G0(@Nullable SeekParameters seekParameters) {
        l5();
        if (seekParameters == null) {
            seekParameters = SeekParameters.f10451g;
        }
        if (!this.P1.equals(seekParameters)) {
            this.P1 = seekParameters;
            this.l1.i1(seekParameters);
        }
    }

    @RequiresApi(23)
    public void G1(@Nullable AudioDeviceInfo audioDeviceInfo) {
        l5();
        W4(1, 12, audioDeviceInfo);
    }

    public void H() {
        l5();
        V4();
        c5((Object) null);
        R4(0, 0);
    }

    public void H0(boolean z) {
        l5();
        if (this.O1 != z) {
            this.O1 = z;
            if (!this.l1.U0(z)) {
                d5(ExoPlaybackException.o(new ExoTimeoutException(2), 1003));
            }
        }
    }

    public void I(@Nullable SurfaceHolder surfaceHolder) {
        l5();
        if (surfaceHolder == null) {
            H();
            return;
        }
        V4();
        this.c2 = true;
        this.a2 = surfaceHolder;
        surfaceHolder.addCallback(this.y1);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            c5((Object) null);
            R4(0, 0);
            return;
        }
        c5(surface);
        Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
        R4(surfaceFrame.width(), surfaceFrame.height());
    }

    public void I0(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        l5();
        this.n1.remove(audioOffloadListener);
    }

    public MediaMetadata I1() {
        l5();
        return this.U1;
    }

    public int J() {
        l5();
        return this.f2;
    }

    public void J0(MediaSource mediaSource, boolean z) {
        l5();
        E1(Collections.singletonList(mediaSource), z);
    }

    public void K(List<Effect> list) {
        l5();
        try {
            Class.forName("androidx.media3.effect.PreviewingSingleInputVideoGraph$Factory").getConstructor(new Class[]{VideoFrameProcessor.Factory.class});
            W4(2, 13, list);
        } catch (ClassNotFoundException | NoSuchMethodException e3) {
            throw new IllegalStateException("Could not find required lib-effect dependencies.", e3);
        }
    }

    public void K0(int i3, int i4) {
        l5();
        StreamVolumeManager streamVolumeManager = this.C1;
        if (streamVolumeManager != null) {
            streamVolumeManager.n(i3, i4);
        }
    }

    public void L(VideoFrameMetadataListener videoFrameMetadataListener) {
        l5();
        if (this.o2 == videoFrameMetadataListener) {
            a4(this.z1).u(7).r((Object) null).n();
        }
    }

    public Looper L1() {
        return this.l1.H();
    }

    public CueGroup M() {
        l5();
        return this.n2;
    }

    public void M0(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        this.n1.add(audioOffloadListener);
    }

    @Deprecated
    public void N(boolean z) {
        l5();
        StreamVolumeManager streamVolumeManager = this.C1;
        if (streamVolumeManager != null) {
            streamVolumeManager.l(z, 1);
        }
    }

    public void N0(int i3) {
        l5();
        StreamVolumeManager streamVolumeManager = this.C1;
        if (streamVolumeManager != null) {
            streamVolumeManager.i(i3);
        }
    }

    public void N1(Player.Listener listener) {
        l5();
        this.m1.l((Player.Listener) Assertions.g(listener));
    }

    public void O(@Nullable SurfaceView surfaceView) {
        l5();
        Z(surfaceView == null ? null : surfaceView.getHolder());
    }

    public int O0() {
        l5();
        if (c0()) {
            return this.y2.f10305b.f12165c;
        }
        return -1;
    }

    public int O1() {
        l5();
        if (c0()) {
            return this.y2.f10305b.f12164b;
        }
        return -1;
    }

    public void P(int i3) {
        l5();
        if (this.f2 != i3) {
            this.f2 = i3;
            W4(2, 5, Integer.valueOf(i3));
        }
    }

    public void P0(List<MediaSource> list) {
        l5();
        x0(this.p1.size(), list);
    }

    public int P1() {
        l5();
        int e4 = e4(this.y2);
        if (e4 == -1) {
            return 0;
        }
        return e4;
    }

    public long Q() {
        l5();
        if (!c0()) {
            return A0();
        }
        PlaybackInfo playbackInfo = this.y2;
        MediaSource.MediaPeriodId mediaPeriodId = playbackInfo.f10305b;
        playbackInfo.f10304a.m(mediaPeriodId.f12163a, this.o1);
        return Util.H2(this.o1.e(mediaPeriodId.f12164b, mediaPeriodId.f12165c));
    }

    public void Q1(boolean z) {
        l5();
        if (!this.u2) {
            this.A1.b(z);
        }
    }

    public boolean R() {
        l5();
        StreamVolumeManager streamVolumeManager = this.C1;
        if (streamVolumeManager != null) {
            return streamVolumeManager.j();
        }
        return false;
    }

    public void R0(MediaSource mediaSource, long j3) {
        l5();
        Y1(Collections.singletonList(mediaSource), 0, j3);
    }

    public void S(CameraMotionListener cameraMotionListener) {
        l5();
        if (this.p2 == cameraMotionListener) {
            a4(this.z1).u(8).r((Object) null).n();
        }
    }

    @Deprecated
    public void S1(MediaSource mediaSource, boolean z, boolean z3) {
        l5();
        J0(mediaSource, z);
        k();
    }

    public int T() {
        l5();
        return this.j2;
    }

    public Size T0() {
        l5();
        return this.g2;
    }

    public void T1(@Nullable PriorityTaskManager priorityTaskManager) {
        l5();
        if (!Util.g(this.s2, priorityTaskManager)) {
            if (this.t2) {
                ((PriorityTaskManager) Assertions.g(this.s2)).e(0);
            }
            if (priorityTaskManager == null || !c()) {
                this.t2 = false;
            } else {
                priorityTaskManager.a(0);
                this.t2 = true;
            }
            this.s2 = priorityTaskManager;
        }
    }

    public int U() {
        l5();
        return this.e2;
    }

    @Deprecated
    public void U0(MediaSource mediaSource) {
        l5();
        A1(mediaSource);
        k();
    }

    @Deprecated
    public void V() {
        l5();
        StreamVolumeManager streamVolumeManager = this.C1;
        if (streamVolumeManager != null) {
            streamVolumeManager.i(1);
        }
    }

    public void V0(MediaMetadata mediaMetadata) {
        l5();
        Assertions.g(mediaMetadata);
        if (!mediaMetadata.equals(this.U1)) {
            this.U1 = mediaMetadata;
            this.m1.m(15, new C0324n0(this));
        }
    }

    public void V1(boolean z) {
        l5();
        if (this.R1 != z) {
            this.R1 = z;
            this.l1.a1(z);
        }
    }

    public void W(CameraMotionListener cameraMotionListener) {
        l5();
        this.p2 = cameraMotionListener;
        a4(this.z1).u(8).r(cameraMotionListener).n();
    }

    public void W1(int i3) {
        l5();
        if (i3 == 0) {
            this.D1.a(false);
        } else if (i3 == 1) {
            this.D1.a(true);
        } else if (i3 == 2) {
            this.D1.a(true);
            this.E1.a(true);
            return;
        } else {
            return;
        }
        this.E1.a(false);
    }

    @Deprecated
    public void X(int i3) {
        l5();
        StreamVolumeManager streamVolumeManager = this.C1;
        if (streamVolumeManager != null) {
            streamVolumeManager.n(i3, 1);
        }
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ExoPlayer.DeviceComponent X0() {
        l5();
        return this;
    }

    public void X1(TrackSelectionParameters trackSelectionParameters) {
        l5();
        if (this.i1.h() && !trackSelectionParameters.equals(this.i1.c())) {
            this.i1.m(trackSelectionParameters);
            this.m1.m(19, new P(trackSelectionParameters));
        }
    }

    public void Y(@Nullable TextureView textureView) {
        l5();
        if (textureView == null) {
            H();
            return;
        }
        V4();
        this.d2 = textureView;
        if (textureView.getSurfaceTextureListener() != null) {
            Log.n(C2, "Replacing existing SurfaceTextureListener.");
        }
        textureView.setSurfaceTextureListener(this.y1);
        SurfaceTexture surfaceTexture = textureView.isAvailable() ? textureView.getSurfaceTexture() : null;
        if (surfaceTexture == null) {
            c5((Object) null);
            R4(0, 0);
            return;
        }
        a5(surfaceTexture);
        R4(textureView.getWidth(), textureView.getHeight());
    }

    public void Y1(List<MediaSource> list, int i3, long j3) {
        l5();
        Y4(list, i3, j3, false);
    }

    public void Z(@Nullable SurfaceHolder surfaceHolder) {
        l5();
        if (surfaceHolder != null && surfaceHolder == this.a2) {
            H();
        }
    }

    public SeekParameters Z1() {
        l5();
        return this.P1;
    }

    public void a() {
        AudioTrack audioTrack;
        Log.h(C2, "Release " + Integer.toHexString(System.identityHashCode(this)) + " [" + MediaLibraryInfo.f9206c + "] [" + Util.f9650e + "] [" + MediaLibraryInfo.b() + "]");
        l5();
        if (Util.f9646a < 21 && (audioTrack = this.X1) != null) {
            audioTrack.release();
            this.X1 = null;
        }
        this.A1.b(false);
        StreamVolumeManager streamVolumeManager = this.C1;
        if (streamVolumeManager != null) {
            streamVolumeManager.k();
        }
        this.D1.b(false);
        this.E1.b(false);
        this.B1.j();
        if (!this.l1.s0()) {
            this.m1.m(10, new C0316k0());
        }
        this.m1.k();
        this.j1.n((Object) null);
        this.u1.a(this.s1);
        PlaybackInfo playbackInfo = this.y2;
        if (playbackInfo.o) {
            this.y2 = playbackInfo.a();
        }
        PlaybackInfo h3 = this.y2.h(1);
        this.y2 = h3;
        PlaybackInfo c3 = h3.c(h3.f10305b);
        this.y2 = c3;
        c3.p = c3.r;
        this.y2.q = 0;
        this.s1.a();
        this.i1.j();
        V4();
        Surface surface = this.Z1;
        if (surface != null) {
            surface.release();
            this.Z1 = null;
        }
        if (this.t2) {
            ((PriorityTaskManager) Assertions.g(this.s2)).e(0);
            this.t2 = false;
        }
        this.n2 = CueGroup.Y;
        this.u2 = true;
    }

    public void a0() {
        l5();
        t(new AuxEffectInfo(0, 0.0f));
    }

    public void b(VideoFrameMetadataListener videoFrameMetadataListener) {
        l5();
        this.o2 = videoFrameMetadataListener;
        a4(this.z1).u(7).r(videoFrameMetadataListener).n();
    }

    public boolean b0() {
        l5();
        for (RendererConfiguration rendererConfiguration : this.y2.f10312i.f12417b) {
            if (rendererConfiguration != null && rendererConfiguration.f10444b) {
                return true;
            }
        }
        return false;
    }

    public void b1(List<MediaSource> list) {
        l5();
        E1(list, true);
    }

    /* access modifiers changed from: package-private */
    public void b5(boolean z) {
        this.q2 = z;
        this.m1.n(z);
        AnalyticsCollector analyticsCollector = this.s1;
        if (analyticsCollector instanceof DefaultAnalyticsCollector) {
            ((DefaultAnalyticsCollector) analyticsCollector).u3(z);
        }
    }

    public boolean c() {
        l5();
        return this.y2.f10310g;
    }

    public boolean c0() {
        l5();
        return this.y2.f10305b.c();
    }

    public void c1(int i3, int i4) {
        l5();
        Assertions.a(i3 >= 0 && i4 >= i3);
        int size = this.p1.size();
        int min = Math.min(i4, size);
        if (i3 < size && i3 != min) {
            PlaybackInfo T4 = T4(this.y2, i3, min);
            h5(T4, 0, 1, !T4.f10305b.f12163a.equals(this.y2.f10305b.f12163a), 4, d4(T4), -1, false);
        }
    }

    public void c2(int i3, int i4, int i5) {
        l5();
        Assertions.a(i3 >= 0 && i3 <= i4 && i5 >= 0);
        int size = this.p1.size();
        int min = Math.min(i4, size);
        int min2 = Math.min(i5, size - (min - i3));
        if (i3 < size && i3 != min && i3 != min2) {
            Timeline j22 = j2();
            this.K1++;
            Util.H1(this.p1, i3, min, min2);
            Timeline Y3 = Y3();
            PlaybackInfo playbackInfo = this.y2;
            PlaybackInfo P4 = P4(playbackInfo, Y3, f4(j22, Y3, e4(playbackInfo), c4(this.y2)));
            this.l1.l0(i3, min, min2, this.Q1);
            h5(P4, 0, 1, false, 5, C.f9084b, -1, false);
        }
    }

    public AudioAttributes d() {
        l5();
        return this.k2;
    }

    public boolean d0() {
        l5();
        return this.R1;
    }

    public AnalyticsCollector d2() {
        l5();
        return this.s1;
    }

    public void e(int i3) {
        l5();
        if (this.j2 != i3) {
            if (i3 == 0) {
                i3 = Util.f9646a < 21 ? m4(0) : Util.V(this.f1);
            } else if (Util.f9646a < 21) {
                m4(i3);
            }
            this.j2 = i3;
            W4(1, 10, Integer.valueOf(i3));
            W4(2, 10, Integer.valueOf(i3));
            this.m1.m(21, new C0314j0(i3));
        }
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ExoPlayer.AudioComponent e1() {
        l5();
        return this;
    }

    public void f(PlaybackParameters playbackParameters) {
        l5();
        if (playbackParameters == null) {
            playbackParameters = PlaybackParameters.Z;
        }
        if (!this.y2.f10317n.equals(playbackParameters)) {
            PlaybackInfo g3 = this.y2.g(playbackParameters);
            this.K1++;
            this.l1.e1(playbackParameters);
            h5(g3, 0, 1, false, 5, C.f9084b, -1, false);
        }
    }

    public void f2(Player.Listener listener) {
        this.m1.c((Player.Listener) Assertions.g(listener));
    }

    public void g(float f3) {
        l5();
        float v = Util.v(f3, 0.0f, 1.0f);
        if (this.l2 != v) {
            this.l2 = v;
            X4();
            this.m1.m(22, new C0310h0(v));
        }
    }

    public PlayerMessage g1(PlayerMessage.Target target) {
        l5();
        return a4(target);
    }

    public int g2() {
        l5();
        return this.y2.f10316m;
    }

    public long h0() {
        l5();
        return Util.H2(this.y2.q);
    }

    public void h1(List<MediaItem> list, int i3, long j3) {
        l5();
        Y1(Z3(list), i3, j3);
    }

    public int i() {
        l5();
        return this.y2.f10308e;
    }

    public void i1(boolean z) {
        l5();
        int q = this.B1.q(z, i());
        g5(z, q, g4(z, q));
    }

    public TrackGroupArray i2() {
        l5();
        return this.y2.f10311h;
    }

    public Player.Commands j0() {
        l5();
        return this.S1;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public ExoPlayer.VideoComponent j1() {
        l5();
        return this;
    }

    public Timeline j2() {
        l5();
        return this.y2.f10304a;
    }

    public void k() {
        l5();
        boolean m0 = m0();
        int i3 = 2;
        int q = this.B1.q(m0, 2);
        g5(m0, q, g4(m0, q));
        PlaybackInfo playbackInfo = this.y2;
        if (playbackInfo.f10308e == 1) {
            PlaybackInfo f3 = playbackInfo.f((ExoPlaybackException) null);
            if (f3.f10304a.x()) {
                i3 = 4;
            }
            PlaybackInfo h3 = f3.h(i3);
            this.K1++;
            this.l1.q0();
            h5(h3, 1, 1, false, 5, C.f9084b, -1, false);
        }
    }

    public void k0(boolean z, int i3) {
        l5();
        StreamVolumeManager streamVolumeManager = this.C1;
        if (streamVolumeManager != null) {
            streamVolumeManager.l(z, i3);
        }
    }

    public Looper k2() {
        return this.t1;
    }

    public void l(int i3) {
        l5();
        this.e2 = i3;
        W4(2, 4, Integer.valueOf(i3));
    }

    public void l0(ShuffleOrder shuffleOrder) {
        l5();
        Assertions.a(shuffleOrder.getLength() == this.p1.size());
        this.Q1 = shuffleOrder;
        Timeline Y3 = Y3();
        PlaybackInfo P4 = P4(this.y2, Y3, Q4(Y3, P1(), z2()));
        this.K1++;
        this.l1.m1(shuffleOrder);
        h5(P4, 0, 1, false, 5, C.f9084b, -1, false);
    }

    public long l1() {
        l5();
        return this.w1;
    }

    public void l2(AnalyticsListener analyticsListener) {
        this.s1.J((AnalyticsListener) Assertions.g(analyticsListener));
    }

    public boolean m0() {
        l5();
        return this.y2.f10315l;
    }

    @Nullable
    public DecoderCounters m1() {
        l5();
        return this.h2;
    }

    public boolean m2() {
        l5();
        return this.J1;
    }

    public boolean n() {
        l5();
        return this.m2;
    }

    public long n1() {
        l5();
        return c4(this.y2);
    }

    public boolean n2() {
        l5();
        return this.y2.o;
    }

    @Nullable
    public Format o1() {
        l5();
        return this.W1;
    }

    public TrackSelectionParameters o2() {
        l5();
        return this.i1.c();
    }

    public void p(int i3) {
        l5();
        if (this.I1 != i3) {
            this.I1 = i3;
            this.l1.g1(i3);
            this.m1.j(8, new C0320m0(i3));
            e5();
            this.m1.g();
        }
    }

    public void p0(boolean z) {
        l5();
        if (this.J1 != z) {
            this.J1 = z;
            this.l1.k1(z);
            this.m1.j(9, new C0326o0(z));
            e5();
            this.m1.g();
        }
    }

    public long p2() {
        l5();
        if (this.y2.f10304a.x()) {
            return this.B2;
        }
        PlaybackInfo playbackInfo = this.y2;
        if (playbackInfo.f10314k.f12166d != playbackInfo.f10305b.f12166d) {
            return playbackInfo.f10304a.u(P1(), this.b1).f();
        }
        long j3 = playbackInfo.p;
        if (this.y2.f10314k.c()) {
            PlaybackInfo playbackInfo2 = this.y2;
            Timeline.Period m3 = playbackInfo2.f10304a.m(playbackInfo2.f10314k.f12163a, this.o1);
            long i3 = m3.i(this.y2.f10314k.f12164b);
            j3 = i3 == Long.MIN_VALUE ? m3.Z : i3;
        }
        PlaybackInfo playbackInfo3 = this.y2;
        return Util.H2(S4(playbackInfo3.f10304a, playbackInfo3.f10314k, j3));
    }

    public int q() {
        l5();
        return this.I1;
    }

    public void q0(ImageOutput imageOutput) {
        l5();
        W4(4, 15, imageOutput);
    }

    public void q1(int i3, List<MediaItem> list) {
        l5();
        x0(i3, Z3(list));
    }

    public PlaybackParameters r() {
        l5();
        return this.y2.f10317n;
    }

    public Clock r0() {
        return this.x1;
    }

    public void r2(MediaSource mediaSource) {
        l5();
        P0(Collections.singletonList(mediaSource));
    }

    public void s(boolean z) {
        l5();
        if (this.m2 != z) {
            this.m2 = z;
            W4(1, 9, Boolean.valueOf(z));
            this.m1.m(23, new X(z));
        }
    }

    public TrackSelector s0() {
        l5();
        return this.i1;
    }

    public void s1(int i3, MediaSource mediaSource) {
        l5();
        x0(i3, Collections.singletonList(mediaSource));
    }

    public void stop() {
        l5();
        this.B1.q(m0(), 1);
        d5((ExoPlaybackException) null);
        this.n2 = new CueGroup(ImmutableList.I(), this.y2.r);
    }

    public void t(AuxEffectInfo auxEffectInfo) {
        l5();
        W4(1, 6, auxEffectInfo);
    }

    public TrackSelectionArray t2() {
        l5();
        return new TrackSelectionArray(this.y2.f10312i.f12418c);
    }

    public int u() {
        l5();
        StreamVolumeManager streamVolumeManager = this.C1;
        if (streamVolumeManager != null) {
            return streamVolumeManager.g();
        }
        return 0;
    }

    public int u0() {
        l5();
        return this.h1.length;
    }

    public long u1() {
        l5();
        if (!c0()) {
            return p2();
        }
        PlaybackInfo playbackInfo = this.y2;
        return playbackInfo.f10314k.equals(playbackInfo.f10305b) ? Util.H2(this.y2.p) : Q();
    }

    @Nullable
    public DecoderCounters u2() {
        l5();
        return this.i2;
    }

    public void v(@Nullable Surface surface) {
        l5();
        V4();
        c5(surface);
        int i3 = surface == null ? 0 : -1;
        R4(i3, i3);
    }

    public void v1(AnalyticsListener analyticsListener) {
        l5();
        this.s1.i0((AnalyticsListener) Assertions.g(analyticsListener));
    }

    public void w(@Nullable Surface surface) {
        l5();
        if (surface != null && surface == this.Y1) {
            H();
        }
    }

    public long w0() {
        l5();
        return C.c2;
    }

    public int w2(int i3) {
        l5();
        return this.h1[i3].i();
    }

    public void x0(int i3, List<MediaSource> list) {
        l5();
        boolean z = false;
        Assertions.a(i3 >= 0);
        int min = Math.min(i3, this.p1.size());
        if (this.p1.isEmpty()) {
            if (this.z2 == -1) {
                z = true;
            }
            E1(list, z);
            return;
        }
        h5(T3(this.y2, min, list), 0, 1, false, 5, C.f9084b, -1, false);
    }

    public MediaMetadata x2() {
        l5();
        return this.T1;
    }

    public void y(@Nullable TextureView textureView) {
        l5();
        if (textureView != null && textureView == this.d2) {
            H();
        }
    }

    public VideoSize z() {
        l5();
        return this.w2;
    }

    public Renderer z0(int i3) {
        l5();
        return this.h1[i3];
    }

    public long z2() {
        l5();
        return Util.H2(d4(this.y2));
    }

    @Nullable
    public ExoPlaybackException j() {
        l5();
        return this.y2.f10309f;
    }
}
