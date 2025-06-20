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
import androidx.media3.common.C;
import androidx.media3.common.DeviceInfo;
import androidx.media3.common.Effect;
import androidx.media3.common.Format;
import androidx.media3.common.MediaItem;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.Player;
import androidx.media3.common.PriorityTaskManager;
import androidx.media3.common.VideoSize;
import androidx.media3.common.text.CueGroup;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.DefaultLivePlaybackSpeedControl;
import androidx.media3.exoplayer.PlayerMessage;
import androidx.media3.exoplayer.analytics.AnalyticsCollector;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.exoplayer.source.DefaultMediaSourceFactory;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.source.ShuffleOrder;
import androidx.media3.exoplayer.source.TrackGroupArray;
import androidx.media3.exoplayer.trackselection.DefaultTrackSelector;
import androidx.media3.exoplayer.trackselection.TrackSelectionArray;
import androidx.media3.exoplayer.trackselection.TrackSelector;
import androidx.media3.exoplayer.upstream.BandwidthMeter;
import androidx.media3.exoplayer.video.VideoFrameMetadataListener;
import androidx.media3.exoplayer.video.spherical.CameraMotionListener;
import androidx.media3.extractor.DefaultExtractorsFactory;
import androidx.media3.extractor.ExtractorsFactory;
import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.List;

public interface ExoPlayer extends Player {
    @UnstableApi
    public static final long Z0 = 500;
    @UnstableApi
    public static final long a1 = 2000;

    @UnstableApi
    @Deprecated
    public interface AudioComponent {
        @Deprecated
        void A(AudioAttributes audioAttributes, boolean z);

        @Deprecated
        float B();

        @Deprecated
        int T();

        @Deprecated
        void a0();

        @Deprecated
        AudioAttributes d();

        @Deprecated
        void e(int i2);

        @Deprecated
        void g(float f2);

        @Deprecated
        boolean n();

        @Deprecated
        void s(boolean z);

        @Deprecated
        void t(AuxEffectInfo auxEffectInfo);
    }

    @UnstableApi
    public interface AudioOffloadListener {
        void G(boolean z);

        void J(boolean z);
    }

    public static final class Builder {
        boolean A;
        boolean B;
        @Nullable
        Looper C;
        boolean D;
        boolean E;

        /* renamed from: a  reason: collision with root package name */
        final Context f10182a;

        /* renamed from: b  reason: collision with root package name */
        Clock f10183b;

        /* renamed from: c  reason: collision with root package name */
        long f10184c;

        /* renamed from: d  reason: collision with root package name */
        Supplier<RenderersFactory> f10185d;

        /* renamed from: e  reason: collision with root package name */
        Supplier<MediaSource.Factory> f10186e;

        /* renamed from: f  reason: collision with root package name */
        Supplier<TrackSelector> f10187f;

        /* renamed from: g  reason: collision with root package name */
        Supplier<LoadControl> f10188g;

        /* renamed from: h  reason: collision with root package name */
        Supplier<BandwidthMeter> f10189h;

        /* renamed from: i  reason: collision with root package name */
        Function<Clock, AnalyticsCollector> f10190i;

        /* renamed from: j  reason: collision with root package name */
        Looper f10191j;
        @Nullable

        /* renamed from: k  reason: collision with root package name */
        PriorityTaskManager f10192k;

        /* renamed from: l  reason: collision with root package name */
        AudioAttributes f10193l;

        /* renamed from: m  reason: collision with root package name */
        boolean f10194m;

        /* renamed from: n  reason: collision with root package name */
        int f10195n;
        boolean o;
        boolean p;
        boolean q;
        int r;
        int s;
        boolean t;
        SeekParameters u;
        long v;
        long w;
        LivePlaybackSpeedControl x;
        long y;
        long z;

        public Builder(Context context) {
            this(context, (Supplier<RenderersFactory>) new C0327p(context), (Supplier<MediaSource.Factory>) new C0329q(context));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory A(Context context) {
            return new DefaultMediaSourceFactory(context, (ExtractorsFactory) new DefaultExtractorsFactory());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ TrackSelector B(TrackSelector trackSelector) {
            return trackSelector;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ LoadControl C(LoadControl loadControl) {
            return loadControl;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ BandwidthMeter D(BandwidthMeter bandwidthMeter) {
            return bandwidthMeter;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ AnalyticsCollector E(AnalyticsCollector analyticsCollector, Clock clock) {
            return analyticsCollector;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ TrackSelector F(Context context) {
            return new DefaultTrackSelector(context);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory H(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory I(Context context) {
            return new DefaultMediaSourceFactory(context, (ExtractorsFactory) new DefaultExtractorsFactory());
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory J(Context context) {
            return new DefaultRenderersFactory(context);
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory K(MediaSource.Factory factory) {
            return factory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory L(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory M(MediaSource.Factory factory) {
            return factory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory N(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory O(MediaSource.Factory factory) {
            return factory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ AnalyticsCollector P(AnalyticsCollector analyticsCollector, Clock clock) {
            return analyticsCollector;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ BandwidthMeter Q(BandwidthMeter bandwidthMeter) {
            return bandwidthMeter;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ LoadControl R(LoadControl loadControl) {
            return loadControl;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ MediaSource.Factory S(MediaSource.Factory factory) {
            return factory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory T(RenderersFactory renderersFactory) {
            return renderersFactory;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ TrackSelector U(TrackSelector trackSelector) {
            return trackSelector;
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ RenderersFactory z(Context context) {
            return new DefaultRenderersFactory(context);
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder V(AnalyticsCollector analyticsCollector) {
            Assertions.i(!this.D);
            Assertions.g(analyticsCollector);
            this.f10190i = new C0325o(analyticsCollector);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder W(AudioAttributes audioAttributes, boolean z2) {
            Assertions.i(!this.D);
            this.f10193l = (AudioAttributes) Assertions.g(audioAttributes);
            this.f10194m = z2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder X(BandwidthMeter bandwidthMeter) {
            Assertions.i(!this.D);
            Assertions.g(bandwidthMeter);
            this.f10189h = new C0358y(bandwidthMeter);
            return this;
        }

        @VisibleForTesting
        @UnstableApi
        @CanIgnoreReturnValue
        public Builder Y(Clock clock) {
            Assertions.i(!this.D);
            this.f10183b = clock;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder Z(long j2) {
            Assertions.i(!this.D);
            this.z = j2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder a0(boolean z2) {
            Assertions.i(!this.D);
            this.q = z2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder b0(boolean z2) {
            Assertions.i(!this.D);
            this.o = z2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder c0(LivePlaybackSpeedControl livePlaybackSpeedControl) {
            Assertions.i(!this.D);
            this.x = (LivePlaybackSpeedControl) Assertions.g(livePlaybackSpeedControl);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder d0(LoadControl loadControl) {
            Assertions.i(!this.D);
            Assertions.g(loadControl);
            this.f10188g = new C0323n(loadControl);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder e0(Looper looper) {
            Assertions.i(!this.D);
            Assertions.g(looper);
            this.f10191j = looper;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder f0(MediaSource.Factory factory) {
            Assertions.i(!this.D);
            Assertions.g(factory);
            this.f10186e = new K(factory);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder g0(boolean z2) {
            Assertions.i(!this.D);
            this.A = z2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder h0(Looper looper) {
            Assertions.i(!this.D);
            this.C = looper;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder i0(@Nullable PriorityTaskManager priorityTaskManager) {
            Assertions.i(!this.D);
            this.f10192k = priorityTaskManager;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder j0(long j2) {
            Assertions.i(!this.D);
            this.y = j2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder k0(RenderersFactory renderersFactory) {
            Assertions.i(!this.D);
            Assertions.g(renderersFactory);
            this.f10185d = new C0331r(renderersFactory);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder l0(@IntRange(from = 1) long j2) {
            Assertions.a(j2 > 0);
            Assertions.i(!this.D);
            this.v = j2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder m0(@IntRange(from = 1) long j2) {
            Assertions.a(j2 > 0);
            Assertions.i(!this.D);
            this.w = j2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder n0(SeekParameters seekParameters) {
            Assertions.i(!this.D);
            this.u = (SeekParameters) Assertions.g(seekParameters);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder o0(boolean z2) {
            Assertions.i(!this.D);
            this.p = z2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder p0(boolean z2) {
            Assertions.i(!this.D);
            this.E = z2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder q0(TrackSelector trackSelector) {
            Assertions.i(!this.D);
            Assertions.g(trackSelector);
            this.f10187f = new J(trackSelector);
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder r0(boolean z2) {
            Assertions.i(!this.D);
            this.t = z2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder s0(boolean z2) {
            Assertions.i(!this.D);
            this.B = z2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder t0(int i2) {
            Assertions.i(!this.D);
            this.s = i2;
            return this;
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder u0(int i2) {
            Assertions.i(!this.D);
            this.r = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder v0(int i2) {
            Assertions.i(!this.D);
            this.f10195n = i2;
            return this;
        }

        public ExoPlayer w() {
            Assertions.i(!this.D);
            this.D = true;
            return new ExoPlayerImpl(this, (Player) null);
        }

        /* access modifiers changed from: package-private */
        public SimpleExoPlayer x() {
            Assertions.i(!this.D);
            this.D = true;
            return new SimpleExoPlayer(this);
        }

        @UnstableApi
        @CanIgnoreReturnValue
        public Builder y(long j2) {
            Assertions.i(!this.D);
            this.f10184c = j2;
            return this;
        }

        @UnstableApi
        public Builder(Context context, RenderersFactory renderersFactory) {
            this(context, (Supplier<RenderersFactory>) new C0350u(renderersFactory), (Supplier<MediaSource.Factory>) new C0352v(context));
            Assertions.g(renderersFactory);
        }

        @UnstableApi
        public Builder(Context context, RenderersFactory renderersFactory, MediaSource.Factory factory) {
            this(context, (Supplier<RenderersFactory>) new C0333s(renderersFactory), (Supplier<MediaSource.Factory>) new C0344t(factory));
            Assertions.g(renderersFactory);
            Assertions.g(factory);
        }

        @UnstableApi
        public Builder(Context context, RenderersFactory renderersFactory, MediaSource.Factory factory, TrackSelector trackSelector, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector) {
            this(context, (Supplier<RenderersFactory>) new C0354w(renderersFactory), (Supplier<MediaSource.Factory>) new C0356x(factory), (Supplier<TrackSelector>) new C0360z(trackSelector), (Supplier<LoadControl>) new A(loadControl), (Supplier<BandwidthMeter>) new B(bandwidthMeter), (Function<Clock, AnalyticsCollector>) new C(analyticsCollector));
            Assertions.g(renderersFactory);
            Assertions.g(factory);
            Assertions.g(trackSelector);
            Assertions.g(bandwidthMeter);
            Assertions.g(analyticsCollector);
        }

        @UnstableApi
        public Builder(Context context, MediaSource.Factory factory) {
            this(context, (Supplier<RenderersFactory>) new H(context), (Supplier<MediaSource.Factory>) new I(factory));
            Assertions.g(factory);
        }

        private Builder(Context context, Supplier<RenderersFactory> supplier, Supplier<MediaSource.Factory> supplier2) {
            this(context, supplier, supplier2, (Supplier<TrackSelector>) new D(context), (Supplier<LoadControl>) new E(), (Supplier<BandwidthMeter>) new F(context), (Function<Clock, AnalyticsCollector>) new G());
        }

        private Builder(Context context, Supplier<RenderersFactory> supplier, Supplier<MediaSource.Factory> supplier2, Supplier<TrackSelector> supplier3, Supplier<LoadControl> supplier4, Supplier<BandwidthMeter> supplier5, Function<Clock, AnalyticsCollector> function) {
            this.f10182a = (Context) Assertions.g(context);
            this.f10185d = supplier;
            this.f10186e = supplier2;
            this.f10187f = supplier3;
            this.f10188g = supplier4;
            this.f10189h = supplier5;
            this.f10190i = function;
            this.f10191j = Util.l0();
            this.f10193l = AudioAttributes.Z2;
            this.f10195n = 0;
            this.r = 1;
            this.s = 0;
            this.t = true;
            this.u = SeekParameters.f10451g;
            this.v = 5000;
            this.w = C.b2;
            this.x = new DefaultLivePlaybackSpeedControl.Builder().a();
            this.f10183b = Clock.f9502a;
            this.y = 500;
            this.z = ExoPlayer.a1;
            this.B = true;
        }
    }

    @UnstableApi
    @Deprecated
    public interface DeviceComponent {
        @Deprecated
        DeviceInfo C();

        @Deprecated
        void D();

        @Deprecated
        void N(boolean z);

        @Deprecated
        boolean R();

        @Deprecated
        void V();

        @Deprecated
        void X(int i2);

        @Deprecated
        int u();
    }

    @UnstableApi
    @Deprecated
    public interface TextComponent {
        @Deprecated
        CueGroup M();
    }

    @UnstableApi
    @Deprecated
    public interface VideoComponent {
        @Deprecated
        void E(@Nullable SurfaceView surfaceView);

        @Deprecated
        void H();

        @Deprecated
        void I(@Nullable SurfaceHolder surfaceHolder);

        @Deprecated
        int J();

        @Deprecated
        void L(VideoFrameMetadataListener videoFrameMetadataListener);

        @Deprecated
        void O(@Nullable SurfaceView surfaceView);

        @Deprecated
        void P(int i2);

        @Deprecated
        void S(CameraMotionListener cameraMotionListener);

        @Deprecated
        int U();

        @Deprecated
        void W(CameraMotionListener cameraMotionListener);

        @Deprecated
        void Y(@Nullable TextureView textureView);

        @Deprecated
        void Z(@Nullable SurfaceHolder surfaceHolder);

        @Deprecated
        void b(VideoFrameMetadataListener videoFrameMetadataListener);

        @Deprecated
        void l(int i2);

        @Deprecated
        void v(@Nullable Surface surface);

        @Deprecated
        void w(@Nullable Surface surface);

        @Deprecated
        void y(@Nullable TextureView textureView);

        @Deprecated
        VideoSize z();
    }

    @UnstableApi
    void A1(MediaSource mediaSource);

    @UnstableApi
    @Nullable
    Format B1();

    @UnstableApi
    @Deprecated
    @Nullable
    TextComponent C2();

    @UnstableApi
    void E1(List<MediaSource> list, boolean z);

    void F(int i2, int i3, List<MediaItem> list);

    @UnstableApi
    void G0(@Nullable SeekParameters seekParameters);

    @RequiresApi(23)
    @UnstableApi
    void G1(@Nullable AudioDeviceInfo audioDeviceInfo);

    @UnstableApi
    void H0(boolean z);

    @UnstableApi
    void I0(AudioOffloadListener audioOffloadListener);

    @UnstableApi
    int J();

    @UnstableApi
    void J0(MediaSource mediaSource, boolean z);

    @RequiresApi(18)
    @UnstableApi
    void K(List<Effect> list);

    @UnstableApi
    void L(VideoFrameMetadataListener videoFrameMetadataListener);

    @UnstableApi
    Looper L1();

    @UnstableApi
    void M0(AudioOffloadListener audioOffloadListener);

    @UnstableApi
    void P(int i2);

    @UnstableApi
    void P0(List<MediaSource> list);

    void Q1(boolean z);

    @UnstableApi
    void R0(MediaSource mediaSource, long j2);

    @UnstableApi
    void S(CameraMotionListener cameraMotionListener);

    @UnstableApi
    @Deprecated
    void S1(MediaSource mediaSource, boolean z, boolean z2);

    @UnstableApi
    int T();

    @UnstableApi
    void T1(@Nullable PriorityTaskManager priorityTaskManager);

    @UnstableApi
    int U();

    @UnstableApi
    @Deprecated
    void U0(MediaSource mediaSource);

    @UnstableApi
    void V1(boolean z);

    @UnstableApi
    void W(CameraMotionListener cameraMotionListener);

    void W1(int i2);

    @UnstableApi
    @Deprecated
    @Nullable
    DeviceComponent X0();

    @UnstableApi
    void Y1(List<MediaSource> list, int i2, long j2);

    @UnstableApi
    SeekParameters Z1();

    @UnstableApi
    void a0();

    @UnstableApi
    void b(VideoFrameMetadataListener videoFrameMetadataListener);

    @UnstableApi
    boolean b0();

    @UnstableApi
    void b1(List<MediaSource> list);

    @UnstableApi
    boolean d0();

    @UnstableApi
    AnalyticsCollector d2();

    @UnstableApi
    void e(int i2);

    @UnstableApi
    @Deprecated
    @Nullable
    AudioComponent e1();

    @UnstableApi
    PlayerMessage g1(PlayerMessage.Target target);

    @UnstableApi
    @Deprecated
    TrackGroupArray i2();

    @Nullable
    /* bridge */ /* synthetic */ PlaybackException j();

    @Nullable
    ExoPlaybackException j();

    @UnstableApi
    @Deprecated
    @Nullable
    VideoComponent j1();

    @UnstableApi
    void l(int i2);

    @UnstableApi
    void l0(ShuffleOrder shuffleOrder);

    void l2(AnalyticsListener analyticsListener);

    @UnstableApi
    @Nullable
    DecoderCounters m1();

    @UnstableApi
    boolean n();

    @UnstableApi
    boolean n2();

    @UnstableApi
    @Nullable
    Format o1();

    @UnstableApi
    void q0(ImageOutput imageOutput);

    @UnstableApi
    Clock r0();

    @UnstableApi
    void r2(MediaSource mediaSource);

    @UnstableApi
    void s(boolean z);

    @UnstableApi
    @Nullable
    TrackSelector s0();

    @UnstableApi
    void s1(int i2, MediaSource mediaSource);

    @UnstableApi
    void t(AuxEffectInfo auxEffectInfo);

    @UnstableApi
    @Deprecated
    TrackSelectionArray t2();

    @UnstableApi
    int u0();

    @UnstableApi
    @Nullable
    DecoderCounters u2();

    void v1(AnalyticsListener analyticsListener);

    @UnstableApi
    int w2(int i2);

    void x(int i2, MediaItem mediaItem);

    @UnstableApi
    void x0(int i2, List<MediaSource> list);

    @UnstableApi
    Renderer z0(int i2);
}
