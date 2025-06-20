package androidx.media3.exoplayer;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.BasePlayer;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.Player;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.Timeline;
import androidx.media3.common.TrackSelectionParameters;
import androidx.media3.common.Tracks;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Size;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.TrackSelectionArray;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.exoplayer.video.spherical.CameraMotionListener;
import androidx.media3.extractor.ExtractorsFactory;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;

@UnstableApi
@Deprecated
public class SimpleExoPlayer extends BasePlayer implements ExoPlayer, ExoPlayer.AudioComponent, ExoPlayer.VideoComponent, ExoPlayer.TextComponent, ExoPlayer.DeviceComponent {
    private final ExoPlayerImpl c1;
    private final ConditionVariable d1;

    @Deprecated
    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public final ExoPlayer.Builder f10454a;

        @Deprecated
        public Builder(Context context) {
            this.f10454a = new ExoPlayer.Builder(context);
        }

        @Deprecated
        public SimpleExoPlayer b() {
            return this.f10454a.x();
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder c(long j2) {
            this.f10454a.y(j2);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder d(AnalyticsCollector analyticsCollector) {
            this.f10454a.V(analyticsCollector);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder e(AudioAttributes audioAttributes, boolean z) {
            this.f10454a.W(audioAttributes, z);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder f(BandwidthMeter bandwidthMeter) {
            this.f10454a.X(bandwidthMeter);
            return this;
        }

        @VisibleForTesting
        @CanIgnoreReturnValue
        @Deprecated
        public Builder g(Clock clock) {
            this.f10454a.Y(clock);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder h(long j2) {
            this.f10454a.Z(j2);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder i(boolean z) {
            this.f10454a.b0(z);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder j(LivePlaybackSpeedControl livePlaybackSpeedControl) {
            this.f10454a.c0(livePlaybackSpeedControl);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder k(LoadControl loadControl) {
            this.f10454a.d0(loadControl);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder l(Looper looper) {
            this.f10454a.e0(looper);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder m(MediaSource.Factory factory) {
            this.f10454a.f0(factory);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder n(boolean z) {
            this.f10454a.g0(z);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder o(@Nullable PriorityTaskManager priorityTaskManager) {
            this.f10454a.i0(priorityTaskManager);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder p(long j2) {
            this.f10454a.j0(j2);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder q(@IntRange(from = 1) long j2) {
            this.f10454a.l0(j2);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder r(@IntRange(from = 1) long j2) {
            this.f10454a.m0(j2);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder s(SeekParameters seekParameters) {
            this.f10454a.n0(seekParameters);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder t(boolean z) {
            this.f10454a.o0(z);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder u(TrackSelector trackSelector) {
            this.f10454a.q0(trackSelector);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder v(boolean z) {
            this.f10454a.r0(z);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder w(int i2) {
            this.f10454a.t0(i2);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder x(int i2) {
            this.f10454a.u0(i2);
            return this;
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder y(int i2) {
            this.f10454a.v0(i2);
            return this;
        }

        @Deprecated
        public Builder(Context context, RenderersFactory renderersFactory) {
            this.f10454a = new ExoPlayer.Builder(context, renderersFactory);
        }

        @Deprecated
        public Builder(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSource.Factory factory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector) {
            this.f10454a = new ExoPlayer.Builder(context, renderersFactory, factory, trackSelector, loadControl, bandwidthMeter, analyticsCollector);
        }

        @Deprecated
        public Builder(Context context, RenderersFactory renderersFactory, ExtractorsFactory extractorsFactory) {
            this.f10454a = new ExoPlayer.Builder(context, renderersFactory, (MediaSource.Factory) new DefaultMediaSourceFactory(context, extractorsFactory));
        }

        @Deprecated
        public Builder(Context context, ExtractorsFactory extractorsFactory) {
            this.f10454a = new ExoPlayer.Builder(context, (MediaSource.Factory) new DefaultMediaSourceFactory(context, extractorsFactory));
        }
    }

    @Deprecated
    protected SimpleExoPlayer(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSource.Factory factory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, boolean z, Clock clock, Looper looper) {
        this(new ExoPlayer.Builder(context, renderersFactory, factory, trackSelector, loadControl, bandwidthMeter, analyticsCollector).r0(z).Y(clock).e0(looper));
    }

    private void L2() {
        this.d1.c();
    }

    public void A(AudioAttributes audioAttributes, boolean z) {
        L2();
        this.c1.A(audioAttributes, z);
    }

    public void A1(MediaSource mediaSource) {
        L2();
        this.c1.A1(mediaSource);
    }

    public long A2() {
        L2();
        return this.c1.A2();
    }

    public float B() {
        L2();
        return this.c1.B();
    }

    public int B0() {
        L2();
        return this.c1.B0();
    }

    @Nullable
    public Format B1() {
        L2();
        return this.c1.B1();
    }

    public DeviceInfo C() {
        L2();
        return this.c1.C();
    }

    public void C1(int i2) {
        L2();
        this.c1.C1(i2);
    }

    @Deprecated
    @Nullable
    public ExoPlayer.TextComponent C2() {
        return this;
    }

    @Deprecated
    public void D() {
        L2();
        this.c1.D();
    }

    public Tracks D1() {
        L2();
        return this.c1.D1();
    }

    public void E(@Nullable SurfaceView surfaceView) {
        L2();
        this.c1.E(surfaceView);
    }

    public void E1(List<MediaSource> list, boolean z) {
        L2();
        this.c1.E1(list, z);
    }

    public void F(int i2, int i3, List<MediaItem> list) {
        L2();
        this.c1.F(i2, i3, list);
    }

    public void F0(List<MediaItem> list, boolean z) {
        L2();
        this.c1.F0(list, z);
    }

    @VisibleForTesting(otherwise = 4)
    public void F2(int i2, long j2, int i3, boolean z) {
        L2();
        this.c1.F2(i2, j2, i3, z);
    }

    public void G0(@Nullable SeekParameters seekParameters) {
        L2();
        this.c1.G0(seekParameters);
    }

    @RequiresApi(23)
    public void G1(@Nullable AudioDeviceInfo audioDeviceInfo) {
        L2();
        this.c1.G1(audioDeviceInfo);
    }

    public void H() {
        L2();
        this.c1.H();
    }

    public void H0(boolean z) {
        L2();
        this.c1.H0(z);
    }

    public void I(@Nullable SurfaceHolder surfaceHolder) {
        L2();
        this.c1.I(surfaceHolder);
    }

    public void I0(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        L2();
        this.c1.I0(audioOffloadListener);
    }

    public MediaMetadata I1() {
        L2();
        return this.c1.I1();
    }

    public int J() {
        L2();
        return this.c1.J();
    }

    public void J0(MediaSource mediaSource, boolean z) {
        L2();
        this.c1.J0(mediaSource, z);
    }

    public void K(List<Effect> list) {
        L2();
        this.c1.K(list);
    }

    public void K0(int i2, int i3) {
        L2();
        this.c1.K0(i2, i3);
    }

    public void L(VideoFrameMetadataListener videoFrameMetadataListener) {
        L2();
        this.c1.L(videoFrameMetadataListener);
    }

    public Looper L1() {
        L2();
        return this.c1.L1();
    }

    public CueGroup M() {
        L2();
        return this.c1.M();
    }

    public void M0(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        L2();
        this.c1.M0(audioOffloadListener);
    }

    /* access modifiers changed from: package-private */
    public void M2(boolean z) {
        L2();
        this.c1.b5(z);
    }

    @Deprecated
    public void N(boolean z) {
        L2();
        this.c1.N(z);
    }

    public void N0(int i2) {
        L2();
        this.c1.N0(i2);
    }

    public void N1(Player.Listener listener) {
        L2();
        this.c1.N1(listener);
    }

    public void O(@Nullable SurfaceView surfaceView) {
        L2();
        this.c1.O(surfaceView);
    }

    public int O0() {
        L2();
        return this.c1.O0();
    }

    public int O1() {
        L2();
        return this.c1.O1();
    }

    public void P(int i2) {
        L2();
        this.c1.P(i2);
    }

    public void P0(List<MediaSource> list) {
        L2();
        this.c1.P0(list);
    }

    public int P1() {
        L2();
        return this.c1.P1();
    }

    public long Q() {
        L2();
        return this.c1.Q();
    }

    public void Q1(boolean z) {
        L2();
        this.c1.Q1(z);
    }

    public boolean R() {
        L2();
        return this.c1.R();
    }

    public void R0(MediaSource mediaSource, long j2) {
        L2();
        this.c1.R0(mediaSource, j2);
    }

    public void S(CameraMotionListener cameraMotionListener) {
        L2();
        this.c1.S(cameraMotionListener);
    }

    @Deprecated
    public void S1(MediaSource mediaSource, boolean z, boolean z2) {
        L2();
        this.c1.S1(mediaSource, z, z2);
    }

    public int T() {
        L2();
        return this.c1.T();
    }

    public Size T0() {
        L2();
        return this.c1.T0();
    }

    public void T1(@Nullable PriorityTaskManager priorityTaskManager) {
        L2();
        this.c1.T1(priorityTaskManager);
    }

    public int U() {
        L2();
        return this.c1.U();
    }

    @Deprecated
    public void U0(MediaSource mediaSource) {
        L2();
        this.c1.U0(mediaSource);
    }

    @Deprecated
    public void V() {
        L2();
        this.c1.V();
    }

    public void V0(MediaMetadata mediaMetadata) {
        L2();
        this.c1.V0(mediaMetadata);
    }

    public void V1(boolean z) {
        L2();
        this.c1.V1(z);
    }

    public void W(CameraMotionListener cameraMotionListener) {
        L2();
        this.c1.W(cameraMotionListener);
    }

    public void W1(int i2) {
        L2();
        this.c1.W1(i2);
    }

    @Deprecated
    public void X(int i2) {
        L2();
        this.c1.X(i2);
    }

    @Deprecated
    @Nullable
    public ExoPlayer.DeviceComponent X0() {
        return this;
    }

    public void X1(TrackSelectionParameters trackSelectionParameters) {
        L2();
        this.c1.X1(trackSelectionParameters);
    }

    public void Y(@Nullable TextureView textureView) {
        L2();
        this.c1.Y(textureView);
    }

    public void Y1(List<MediaSource> list, int i2, long j2) {
        L2();
        this.c1.Y1(list, i2, j2);
    }

    public void Z(@Nullable SurfaceHolder surfaceHolder) {
        L2();
        this.c1.Z(surfaceHolder);
    }

    public SeekParameters Z1() {
        L2();
        return this.c1.Z1();
    }

    public void a() {
        L2();
        this.c1.a();
    }

    public void a0() {
        L2();
        this.c1.a0();
    }

    public void b(VideoFrameMetadataListener videoFrameMetadataListener) {
        L2();
        this.c1.b(videoFrameMetadataListener);
    }

    public boolean b0() {
        L2();
        return this.c1.b0();
    }

    public void b1(List<MediaSource> list) {
        L2();
        this.c1.b1(list);
    }

    public boolean c() {
        L2();
        return this.c1.c();
    }

    public boolean c0() {
        L2();
        return this.c1.c0();
    }

    public void c1(int i2, int i3) {
        L2();
        this.c1.c1(i2, i3);
    }

    public void c2(int i2, int i3, int i4) {
        L2();
        this.c1.c2(i2, i3, i4);
    }

    public AudioAttributes d() {
        L2();
        return this.c1.d();
    }

    public boolean d0() {
        L2();
        return this.c1.d0();
    }

    public AnalyticsCollector d2() {
        L2();
        return this.c1.d2();
    }

    public void e(int i2) {
        L2();
        this.c1.e(i2);
    }

    @Deprecated
    @Nullable
    public ExoPlayer.AudioComponent e1() {
        return this;
    }

    public void f(PlaybackParameters playbackParameters) {
        L2();
        this.c1.f(playbackParameters);
    }

    public void f2(Player.Listener listener) {
        L2();
        this.c1.f2(listener);
    }

    public void g(float f2) {
        L2();
        this.c1.g(f2);
    }

    public PlayerMessage g1(PlayerMessage.Target target) {
        L2();
        return this.c1.g1(target);
    }

    public int g2() {
        L2();
        return this.c1.g2();
    }

    public long h0() {
        L2();
        return this.c1.h0();
    }

    public void h1(List<MediaItem> list, int i2, long j2) {
        L2();
        this.c1.h1(list, i2, j2);
    }

    public int i() {
        L2();
        return this.c1.i();
    }

    public void i1(boolean z) {
        L2();
        this.c1.i1(z);
    }

    @Deprecated
    public TrackGroupArray i2() {
        L2();
        return this.c1.i2();
    }

    public Player.Commands j0() {
        L2();
        return this.c1.j0();
    }

    @Deprecated
    @Nullable
    public ExoPlayer.VideoComponent j1() {
        return this;
    }

    public Timeline j2() {
        L2();
        return this.c1.j2();
    }

    public void k() {
        L2();
        this.c1.k();
    }

    public void k0(boolean z, int i2) {
        L2();
        this.c1.k0(z, i2);
    }

    public Looper k2() {
        L2();
        return this.c1.k2();
    }

    public void l(int i2) {
        L2();
        this.c1.l(i2);
    }

    public void l0(ShuffleOrder shuffleOrder) {
        L2();
        this.c1.l0(shuffleOrder);
    }

    public long l1() {
        L2();
        return this.c1.l1();
    }

    public void l2(AnalyticsListener analyticsListener) {
        L2();
        this.c1.l2(analyticsListener);
    }

    public boolean m0() {
        L2();
        return this.c1.m0();
    }

    @Nullable
    public DecoderCounters m1() {
        L2();
        return this.c1.m1();
    }

    public boolean m2() {
        L2();
        return this.c1.m2();
    }

    public boolean n() {
        L2();
        return this.c1.n();
    }

    public long n1() {
        L2();
        return this.c1.n1();
    }

    public boolean n2() {
        L2();
        return this.c1.n2();
    }

    @Nullable
    public Format o1() {
        L2();
        return this.c1.o1();
    }

    public TrackSelectionParameters o2() {
        L2();
        return this.c1.o2();
    }

    public void p(int i2) {
        L2();
        this.c1.p(i2);
    }

    public void p0(boolean z) {
        L2();
        this.c1.p0(z);
    }

    public long p2() {
        L2();
        return this.c1.p2();
    }

    public int q() {
        L2();
        return this.c1.q();
    }

    public void q0(ImageOutput imageOutput) {
        L2();
        this.c1.q0(imageOutput);
    }

    public void q1(int i2, List<MediaItem> list) {
        L2();
        this.c1.q1(i2, list);
    }

    public PlaybackParameters r() {
        L2();
        return this.c1.r();
    }

    public Clock r0() {
        L2();
        return this.c1.r0();
    }

    public void r2(MediaSource mediaSource) {
        L2();
        this.c1.r2(mediaSource);
    }

    public void s(boolean z) {
        L2();
        this.c1.s(z);
    }

    public TrackSelector s0() {
        L2();
        return this.c1.s0();
    }

    public void s1(int i2, MediaSource mediaSource) {
        L2();
        this.c1.s1(i2, mediaSource);
    }

    public void stop() {
        L2();
        this.c1.stop();
    }

    public void t(AuxEffectInfo auxEffectInfo) {
        L2();
        this.c1.t(auxEffectInfo);
    }

    @Deprecated
    public TrackSelectionArray t2() {
        L2();
        return this.c1.t2();
    }

    public int u() {
        L2();
        return this.c1.u();
    }

    public int u0() {
        L2();
        return this.c1.u0();
    }

    public long u1() {
        L2();
        return this.c1.u1();
    }

    @Nullable
    public DecoderCounters u2() {
        L2();
        return this.c1.u2();
    }

    public void v(@Nullable Surface surface) {
        L2();
        this.c1.v(surface);
    }

    public void v1(AnalyticsListener analyticsListener) {
        L2();
        this.c1.v1(analyticsListener);
    }

    public void w(@Nullable Surface surface) {
        L2();
        this.c1.w(surface);
    }

    public long w0() {
        L2();
        return this.c1.w0();
    }

    public int w2(int i2) {
        L2();
        return this.c1.w2(i2);
    }

    public void x0(int i2, List<MediaSource> list) {
        L2();
        this.c1.x0(i2, list);
    }

    public MediaMetadata x2() {
        L2();
        return this.c1.x2();
    }

    public void y(@Nullable TextureView textureView) {
        L2();
        this.c1.y(textureView);
    }

    public VideoSize z() {
        L2();
        return this.c1.z();
    }

    public Renderer z0(int i2) {
        L2();
        return this.c1.z0(i2);
    }

    public long z2() {
        L2();
        return this.c1.z2();
    }

    SimpleExoPlayer(ExoPlayer.Builder builder) {
        ConditionVariable conditionVariable = new ConditionVariable();
        this.d1 = conditionVariable;
        try {
            this.c1 = new ExoPlayerImpl(builder, this);
            conditionVariable.f();
        } catch (Throwable th) {
            this.d1.f();
            throw th;
        }
    }

    @Nullable
    public ExoPlaybackException j() {
        L2();
        return this.c1.j();
    }

    protected SimpleExoPlayer(Builder builder) {
        this(builder.f10454a);
    }
}
