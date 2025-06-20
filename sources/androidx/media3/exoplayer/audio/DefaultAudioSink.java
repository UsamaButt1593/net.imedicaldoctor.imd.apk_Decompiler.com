package androidx.media3.exoplayer.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioDeviceInfo;
import android.media.AudioRouting;
import android.media.AudioTrack;
import android.media.metrics.LogSessionId;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.DoNotInline;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.emoji2.text.a;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.audio.AudioProcessingPipeline;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.SonicAudioProcessor;
import androidx.media3.common.audio.ToInt16PcmAudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Clock;
import androidx.media3.common.util.ConditionVariable;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.AudioCapabilitiesReceiver;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.AudioTrackPositionTracker;
import androidx.media3.exoplayer.audio.DefaultAudioTrackBufferSizeProvider;
import androidx.media3.extractor.Ac3Util;
import androidx.media3.extractor.Ac4Util;
import androidx.media3.extractor.DtsUtil;
import androidx.media3.extractor.MpegAudioUtil;
import androidx.media3.extractor.OpusUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public final class DefaultAudioSink implements AudioSink {
    public static final float A0 = 8.0f;
    private static final boolean B0 = false;
    public static final int C0 = 0;
    public static final int D0 = 1;
    public static final int E0 = 2;
    private static final int F0 = -32;
    private static final int G0 = 100;
    private static final String H0 = "DefaultAudioSink";
    public static boolean I0 = false;
    private static final Object J0 = new Object();
    @GuardedBy("releaseExecutorLock")
    @Nullable
    private static ExecutorService K0 = null;
    @GuardedBy("releaseExecutorLock")
    private static int L0 = 0;
    private static final int t0 = 1000000;
    private static final int u0 = 300000;
    private static final int v0 = 100;
    public static final float w0 = 1.0f;
    public static final float x0 = 0.1f;
    public static final float y0 = 8.0f;
    public static final float z0 = 0.1f;
    /* access modifiers changed from: private */
    @Nullable
    public AudioSink.Listener A;
    @Nullable
    private Configuration B;
    private Configuration C;
    private AudioProcessingPipeline D;
    /* access modifiers changed from: private */
    @Nullable
    public AudioTrack E;
    private AudioCapabilities F;
    private AudioCapabilitiesReceiver G;
    @Nullable
    private OnRoutingChangedListenerApi24 H;
    private AudioAttributes I;
    @Nullable
    private MediaPositionParameters J;
    private MediaPositionParameters K;
    private PlaybackParameters L;
    private boolean M;
    @Nullable
    private ByteBuffer N;
    private int O;
    private long P;
    private long Q;
    private long R;
    private long S;
    private int T;
    private boolean U;
    private boolean V;
    private long W;
    private float X;
    @Nullable
    private ByteBuffer Y;
    private int Z;
    @Nullable
    private ByteBuffer a0;
    private byte[] b0;
    private int c0;
    private boolean d0;
    private boolean e0;
    /* access modifiers changed from: private */
    public boolean f0;
    private boolean g0;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Context f10831h;
    private int h0;

    /* renamed from: i  reason: collision with root package name */
    private final androidx.media3.common.audio.AudioProcessorChain f10832i;
    private AuxEffectInfo i0;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f10833j;
    @Nullable
    private AudioDeviceInfoApi23 j0;

    /* renamed from: k  reason: collision with root package name */
    private final ChannelMappingAudioProcessor f10834k;
    private boolean k0;

    /* renamed from: l  reason: collision with root package name */
    private final TrimmingAudioProcessor f10835l;
    private long l0;

    /* renamed from: m  reason: collision with root package name */
    private final ImmutableList<AudioProcessor> f10836m;
    /* access modifiers changed from: private */
    public long m0;

    /* renamed from: n  reason: collision with root package name */
    private final ImmutableList<AudioProcessor> f10837n;
    private boolean n0;
    private final ConditionVariable o;
    private boolean o0;
    private final AudioTrackPositionTracker p;
    @Nullable
    private Looper p0;
    private final ArrayDeque<MediaPositionParameters> q;
    private long q0;
    private final boolean r;
    private long r0;
    private int s;
    private Handler s0;
    private StreamEventCallbackV29 t;
    private final PendingExceptionHolder<AudioSink.InitializationException> u;
    private final PendingExceptionHolder<AudioSink.WriteException> v;
    private final AudioTrackBufferSizeProvider w;
    private final AudioOffloadSupportProvider x;
    @Nullable
    private final ExoPlayer.AudioOffloadListener y;
    @Nullable
    private PlayerId z;

    @RequiresApi(23)
    private static final class Api23 {
        private Api23() {
        }

        @DoNotInline
        public static void a(AudioTrack audioTrack, @Nullable AudioDeviceInfoApi23 audioDeviceInfoApi23) {
            boolean unused = audioTrack.setPreferredDevice(audioDeviceInfoApi23 == null ? null : audioDeviceInfoApi23.f10769a);
        }
    }

    @RequiresApi(31)
    private static final class Api31 {
        private Api31() {
        }

        @DoNotInline
        public static void a(AudioTrack audioTrack, PlayerId playerId) {
            LogSessionId a2 = playerId.a();
            if (!a2.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                audioTrack.setLogSessionId(a2);
            }
        }
    }

    public interface AudioOffloadSupportProvider {
        AudioOffloadSupport a(Format format, AudioAttributes audioAttributes);
    }

    @Deprecated
    public interface AudioProcessorChain extends androidx.media3.common.audio.AudioProcessorChain {
    }

    public interface AudioTrackBufferSizeProvider {

        /* renamed from: a  reason: collision with root package name */
        public static final AudioTrackBufferSizeProvider f10838a = new DefaultAudioTrackBufferSizeProvider.Builder().h();

        int a(int i2, int i3, int i4, int i5, int i6, int i7, double d2);
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public final Context f10839a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public AudioCapabilities f10840b;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        public androidx.media3.common.audio.AudioProcessorChain f10841c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f10842d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public boolean f10843e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f10844f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public AudioTrackBufferSizeProvider f10845g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public AudioOffloadSupportProvider f10846h;
        /* access modifiers changed from: private */
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        public ExoPlayer.AudioOffloadListener f10847i;

        @Deprecated
        public Builder() {
            this.f10839a = null;
            this.f10840b = AudioCapabilities.f10743e;
            this.f10845g = AudioTrackBufferSizeProvider.f10838a;
        }

        public DefaultAudioSink i() {
            Assertions.i(!this.f10844f);
            this.f10844f = true;
            if (this.f10841c == null) {
                this.f10841c = new DefaultAudioProcessorChain(new AudioProcessor[0]);
            }
            if (this.f10846h == null) {
                this.f10846h = new DefaultAudioOffloadSupportProvider(this.f10839a);
            }
            return new DefaultAudioSink(this);
        }

        @CanIgnoreReturnValue
        @Deprecated
        public Builder j(AudioCapabilities audioCapabilities) {
            Assertions.g(audioCapabilities);
            this.f10840b = audioCapabilities;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder k(AudioOffloadSupportProvider audioOffloadSupportProvider) {
            this.f10846h = audioOffloadSupportProvider;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder l(androidx.media3.common.audio.AudioProcessorChain audioProcessorChain) {
            Assertions.g(audioProcessorChain);
            this.f10841c = audioProcessorChain;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder m(AudioProcessor[] audioProcessorArr) {
            Assertions.g(audioProcessorArr);
            return l(new DefaultAudioProcessorChain(audioProcessorArr));
        }

        @CanIgnoreReturnValue
        public Builder n(AudioTrackBufferSizeProvider audioTrackBufferSizeProvider) {
            this.f10845g = audioTrackBufferSizeProvider;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder o(boolean z) {
            this.f10843e = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder p(boolean z) {
            this.f10842d = z;
            return this;
        }

        @CanIgnoreReturnValue
        public Builder q(@Nullable ExoPlayer.AudioOffloadListener audioOffloadListener) {
            this.f10847i = audioOffloadListener;
            return this;
        }

        public Builder(Context context) {
            this.f10839a = context;
            this.f10840b = AudioCapabilities.f10743e;
            this.f10845g = AudioTrackBufferSizeProvider.f10838a;
        }
    }

    private static final class Configuration {

        /* renamed from: a  reason: collision with root package name */
        public final Format f10848a;

        /* renamed from: b  reason: collision with root package name */
        public final int f10849b;

        /* renamed from: c  reason: collision with root package name */
        public final int f10850c;

        /* renamed from: d  reason: collision with root package name */
        public final int f10851d;

        /* renamed from: e  reason: collision with root package name */
        public final int f10852e;

        /* renamed from: f  reason: collision with root package name */
        public final int f10853f;

        /* renamed from: g  reason: collision with root package name */
        public final int f10854g;

        /* renamed from: h  reason: collision with root package name */
        public final int f10855h;

        /* renamed from: i  reason: collision with root package name */
        public final AudioProcessingPipeline f10856i;

        /* renamed from: j  reason: collision with root package name */
        public final boolean f10857j;

        /* renamed from: k  reason: collision with root package name */
        public final boolean f10858k;

        /* renamed from: l  reason: collision with root package name */
        public final boolean f10859l;

        public Configuration(Format format, int i2, int i3, int i4, int i5, int i6, int i7, int i8, AudioProcessingPipeline audioProcessingPipeline, boolean z, boolean z2, boolean z3) {
            this.f10848a = format;
            this.f10849b = i2;
            this.f10850c = i3;
            this.f10851d = i4;
            this.f10852e = i5;
            this.f10853f = i6;
            this.f10854g = i7;
            this.f10855h = i8;
            this.f10856i = audioProcessingPipeline;
            this.f10857j = z;
            this.f10858k = z2;
            this.f10859l = z3;
        }

        private AudioTrack e(AudioAttributes audioAttributes, int i2) {
            int i3 = Util.f9646a;
            if (i3 >= 29) {
                return g(audioAttributes, i2);
            }
            return i3 >= 21 ? f(audioAttributes, i2) : h(audioAttributes, i2);
        }

        @RequiresApi(21)
        private AudioTrack f(AudioAttributes audioAttributes, int i2) {
            return new AudioTrack(j(audioAttributes, this.f10859l), Util.Z(this.f10852e, this.f10853f, this.f10854g), this.f10855h, 1, i2);
        }

        @RequiresApi(29)
        private AudioTrack g(AudioAttributes audioAttributes, int i2) {
            AudioTrack.Builder a2 = c0.a().setAudioAttributes(j(audioAttributes, this.f10859l)).setAudioFormat(Util.Z(this.f10852e, this.f10853f, this.f10854g));
            boolean z = true;
            AudioTrack.Builder a3 = a2.setTransferMode(1).setBufferSizeInBytes(this.f10855h).setSessionId(i2);
            if (this.f10850c != 1) {
                z = false;
            }
            return a3.setOffloadedPlayback(z).build();
        }

        private AudioTrack h(AudioAttributes audioAttributes, int i2) {
            int J0 = Util.J0(audioAttributes.Y);
            int i3 = this.f10852e;
            int i4 = this.f10853f;
            int i5 = this.f10854g;
            int i6 = this.f10855h;
            if (i2 == 0) {
                return r0;
            }
            AudioTrack audioTrack = new AudioTrack(J0, i3, i4, i5, i6, 1, i2);
            return audioTrack;
        }

        @RequiresApi(21)
        private static android.media.AudioAttributes j(AudioAttributes audioAttributes, boolean z) {
            return z ? k() : audioAttributes.c().f9067a;
        }

        @RequiresApi(21)
        private static android.media.AudioAttributes k() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        public AudioTrack a(androidx.media3.common.AudioAttributes audioAttributes, int i2) throws AudioSink.InitializationException {
            try {
                AudioTrack e2 = e(audioAttributes, i2);
                int state = e2.getState();
                if (state == 1) {
                    return e2;
                }
                try {
                    e2.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.f10852e, this.f10853f, this.f10855h, this.f10848a, m(), (Exception) null);
            } catch (IllegalArgumentException | UnsupportedOperationException e3) {
                throw new AudioSink.InitializationException(0, this.f10852e, this.f10853f, this.f10855h, this.f10848a, m(), e3);
            }
        }

        public AudioSink.AudioTrackConfig b() {
            int i2 = this.f10854g;
            int i3 = this.f10852e;
            int i4 = this.f10853f;
            boolean z = this.f10859l;
            boolean z2 = true;
            if (this.f10850c != 1) {
                z2 = false;
            }
            return new AudioSink.AudioTrackConfig(i2, i3, i4, z, z2, this.f10855h);
        }

        public boolean c(Configuration configuration) {
            return configuration.f10850c == this.f10850c && configuration.f10854g == this.f10854g && configuration.f10852e == this.f10852e && configuration.f10853f == this.f10853f && configuration.f10851d == this.f10851d && configuration.f10857j == this.f10857j && configuration.f10858k == this.f10858k;
        }

        public Configuration d(int i2) {
            return new Configuration(this.f10848a, this.f10849b, this.f10850c, this.f10851d, this.f10852e, this.f10853f, this.f10854g, i2, this.f10856i, this.f10857j, this.f10858k, this.f10859l);
        }

        public long i(long j2) {
            return Util.b2(j2, this.f10852e);
        }

        public long l(long j2) {
            return Util.b2(j2, this.f10848a.t3);
        }

        public boolean m() {
            return this.f10850c == 1;
        }
    }

    public static class DefaultAudioProcessorChain implements AudioProcessorChain {

        /* renamed from: a  reason: collision with root package name */
        private final AudioProcessor[] f10860a;

        /* renamed from: b  reason: collision with root package name */
        private final SilenceSkippingAudioProcessor f10861b;

        /* renamed from: c  reason: collision with root package name */
        private final SonicAudioProcessor f10862c;

        public DefaultAudioProcessorChain(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new SilenceSkippingAudioProcessor(), new SonicAudioProcessor());
        }

        public long a(long j2) {
            return this.f10862c.a(j2);
        }

        public long b() {
            return this.f10861b.u();
        }

        public boolean c(boolean z) {
            this.f10861b.D(z);
            return z;
        }

        public AudioProcessor[] d() {
            return this.f10860a;
        }

        public PlaybackParameters e(PlaybackParameters playbackParameters) {
            this.f10862c.j(playbackParameters.s);
            this.f10862c.i(playbackParameters.X);
            return playbackParameters;
        }

        public DefaultAudioProcessorChain(AudioProcessor[] audioProcessorArr, SilenceSkippingAudioProcessor silenceSkippingAudioProcessor, SonicAudioProcessor sonicAudioProcessor) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[(audioProcessorArr.length + 2)];
            this.f10860a = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.f10861b = silenceSkippingAudioProcessor;
            this.f10862c = sonicAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length] = silenceSkippingAudioProcessor;
            audioProcessorArr2[audioProcessorArr.length + 1] = sonicAudioProcessor;
        }
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    private static final class MediaPositionParameters {

        /* renamed from: a  reason: collision with root package name */
        public final PlaybackParameters f10863a;

        /* renamed from: b  reason: collision with root package name */
        public final long f10864b;

        /* renamed from: c  reason: collision with root package name */
        public final long f10865c;

        private MediaPositionParameters(PlaybackParameters playbackParameters, long j2, long j3) {
            this.f10863a = playbackParameters;
            this.f10864b = j2;
            this.f10865c = j3;
        }
    }

    @RequiresApi(24)
    private static final class OnRoutingChangedListenerApi24 {

        /* renamed from: a  reason: collision with root package name */
        private final AudioTrack f10866a;

        /* renamed from: b  reason: collision with root package name */
        private final AudioCapabilitiesReceiver f10867b;
        @Nullable

        /* renamed from: c  reason: collision with root package name */
        private AudioRouting.OnRoutingChangedListener f10868c = new h0(this);

        public OnRoutingChangedListenerApi24(AudioTrack audioTrack, AudioCapabilitiesReceiver audioCapabilitiesReceiver) {
            this.f10866a = audioTrack;
            this.f10867b = audioCapabilitiesReceiver;
            audioTrack.addOnRoutingChangedListener(this.f10868c, new Handler(Looper.myLooper()));
        }

        /* access modifiers changed from: private */
        @DoNotInline
        public void b(AudioRouting audioRouting) {
            if (this.f10868c != null && audioRouting.getRoutedDevice() != null) {
                this.f10867b.i(audioRouting.getRoutedDevice());
            }
        }

        @DoNotInline
        public void c() {
            this.f10866a.removeOnRoutingChangedListener(e0.a(Assertions.g(this.f10868c)));
            this.f10868c = null;
        }
    }

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface OutputMode {
    }

    private static final class PendingExceptionHolder<T extends Exception> {

        /* renamed from: a  reason: collision with root package name */
        private final long f10869a;
        @Nullable

        /* renamed from: b  reason: collision with root package name */
        private T f10870b;

        /* renamed from: c  reason: collision with root package name */
        private long f10871c;

        public PendingExceptionHolder(long j2) {
            this.f10869a = j2;
        }

        public void a() {
            this.f10870b = null;
        }

        public void b(T t) throws Exception {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.f10870b == null) {
                this.f10870b = t;
                this.f10871c = this.f10869a + elapsedRealtime;
            }
            if (elapsedRealtime >= this.f10871c) {
                T t2 = this.f10870b;
                if (t2 != t) {
                    t2.addSuppressed(t);
                }
                T t3 = this.f10870b;
                a();
                throw t3;
            }
        }
    }

    private final class PositionTrackerListener implements AudioTrackPositionTracker.Listener {
        private PositionTrackerListener() {
        }

        public void a(long j2) {
            if (DefaultAudioSink.this.A != null) {
                DefaultAudioSink.this.A.a(j2);
            }
        }

        public void b(int i2, long j2) {
            if (DefaultAudioSink.this.A != null) {
                DefaultAudioSink.this.A.h(i2, j2, SystemClock.elapsedRealtime() - DefaultAudioSink.this.m0);
            }
        }

        public void c(long j2) {
            Log.n(DefaultAudioSink.H0, "Ignoring impossibly large audio latency: " + j2);
        }

        public void d(long j2, long j3, long j4, long j5) {
            String str = "Spurious audio timestamp (frame position mismatch): " + j2 + ", " + j3 + ", " + j4 + ", " + j5 + ", " + DefaultAudioSink.this.W() + ", " + DefaultAudioSink.this.X();
            if (!DefaultAudioSink.I0) {
                Log.n(DefaultAudioSink.H0, str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str);
        }

        public void e(long j2, long j3, long j4, long j5) {
            String str = "Spurious audio timestamp (system clock mismatch): " + j2 + ", " + j3 + ", " + j4 + ", " + j5 + ", " + DefaultAudioSink.this.W() + ", " + DefaultAudioSink.this.X();
            if (!DefaultAudioSink.I0) {
                Log.n(DefaultAudioSink.H0, str);
                return;
            }
            throw new InvalidAudioTrackTimestampException(str);
        }
    }

    @RequiresApi(29)
    private final class StreamEventCallbackV29 {

        /* renamed from: a  reason: collision with root package name */
        private final Handler f10873a = new Handler(Looper.myLooper());

        /* renamed from: b  reason: collision with root package name */
        private final AudioTrack.StreamEventCallback f10874b;

        public StreamEventCallbackV29() {
            this.f10874b = new AudioTrack.StreamEventCallback(DefaultAudioSink.this) {
                public void onDataRequest(AudioTrack audioTrack, int i2) {
                    if (audioTrack.equals(DefaultAudioSink.this.E) && DefaultAudioSink.this.A != null && DefaultAudioSink.this.f0) {
                        DefaultAudioSink.this.A.k();
                    }
                }

                public void onTearDown(AudioTrack audioTrack) {
                    if (audioTrack.equals(DefaultAudioSink.this.E) && DefaultAudioSink.this.A != null && DefaultAudioSink.this.f0) {
                        DefaultAudioSink.this.A.k();
                    }
                }
            };
        }

        @DoNotInline
        public void a(AudioTrack audioTrack) {
            Handler handler = this.f10873a;
            Objects.requireNonNull(handler);
            audioTrack.registerStreamEventCallback(new a(handler), this.f10874b);
        }

        @DoNotInline
        public void b(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.f10874b);
            this.f10873a.removeCallbacksAndMessages((Object) null);
        }
    }

    @RequiresNonNull({"#1.audioProcessorChain"})
    private DefaultAudioSink(Builder builder) {
        Context a2 = builder.f10839a;
        this.f10831h = a2;
        androidx.media3.common.AudioAttributes audioAttributes = androidx.media3.common.AudioAttributes.Z2;
        this.I = audioAttributes;
        this.F = a2 != null ? AudioCapabilities.f(a2, audioAttributes, (AudioDeviceInfo) null) : builder.f10840b;
        this.f10832i = builder.f10841c;
        int i2 = Util.f9646a;
        boolean z2 = true;
        this.f10833j = i2 >= 21 && builder.f10842d;
        this.r = (i2 < 23 || !builder.f10843e) ? false : z2;
        this.s = 0;
        this.w = builder.f10845g;
        this.x = (AudioOffloadSupportProvider) Assertions.g(builder.f10846h);
        ConditionVariable conditionVariable = new ConditionVariable(Clock.f9502a);
        this.o = conditionVariable;
        conditionVariable.f();
        this.p = new AudioTrackPositionTracker(new PositionTrackerListener());
        ChannelMappingAudioProcessor channelMappingAudioProcessor = new ChannelMappingAudioProcessor();
        this.f10834k = channelMappingAudioProcessor;
        TrimmingAudioProcessor trimmingAudioProcessor = new TrimmingAudioProcessor();
        this.f10835l = trimmingAudioProcessor;
        this.f10836m = ImmutableList.M(new ToInt16PcmAudioProcessor(), channelMappingAudioProcessor, trimmingAudioProcessor);
        this.f10837n = ImmutableList.K(new ToFloatPcmAudioProcessor());
        this.X = 1.0f;
        this.h0 = 0;
        this.i0 = new AuxEffectInfo(0, 0.0f);
        PlaybackParameters playbackParameters = PlaybackParameters.Z;
        this.K = new MediaPositionParameters(playbackParameters, 0, 0);
        this.L = playbackParameters;
        this.M = false;
        this.q = new ArrayDeque<>();
        this.u = new PendingExceptionHolder<>(100);
        this.v = new PendingExceptionHolder<>(100);
        this.y = builder.f10847i;
    }

    private void O(long j2) {
        PlaybackParameters playbackParameters;
        if (!w0()) {
            playbackParameters = u0() ? this.f10832i.e(this.L) : PlaybackParameters.Z;
            this.L = playbackParameters;
        } else {
            playbackParameters = PlaybackParameters.Z;
        }
        PlaybackParameters playbackParameters2 = playbackParameters;
        this.M = u0() ? this.f10832i.c(this.M) : false;
        this.q.add(new MediaPositionParameters(playbackParameters2, Math.max(0, j2), this.C.i(X())));
        t0();
        AudioSink.Listener listener = this.A;
        if (listener != null) {
            listener.e(this.M);
        }
    }

    private long P(long j2) {
        while (!this.q.isEmpty() && j2 >= this.q.getFirst().f10865c) {
            this.K = this.q.remove();
        }
        MediaPositionParameters mediaPositionParameters = this.K;
        long j3 = j2 - mediaPositionParameters.f10865c;
        if (mediaPositionParameters.f10863a.equals(PlaybackParameters.Z)) {
            return this.K.f10864b + j3;
        }
        if (this.q.isEmpty()) {
            return this.K.f10864b + this.f10832i.a(j3);
        }
        MediaPositionParameters first = this.q.getFirst();
        return first.f10864b - Util.A0(first.f10865c - j2, this.K.f10863a.s);
    }

    private long Q(long j2) {
        long b2 = this.f10832i.b();
        long i2 = j2 + this.C.i(b2);
        long j3 = this.q0;
        if (b2 > j3) {
            long i3 = this.C.i(b2 - j3);
            this.q0 = b2;
            Y(i3);
        }
        return i2;
    }

    private AudioTrack R(Configuration configuration) throws AudioSink.InitializationException {
        try {
            AudioTrack a2 = configuration.a(this.I, this.h0);
            ExoPlayer.AudioOffloadListener audioOffloadListener = this.y;
            if (audioOffloadListener != null) {
                audioOffloadListener.G(c0(a2));
            }
            return a2;
        } catch (AudioSink.InitializationException e2) {
            AudioSink.Listener listener = this.A;
            if (listener != null) {
                listener.f(e2);
            }
            throw e2;
        }
    }

    private AudioTrack S() throws AudioSink.InitializationException {
        try {
            return R((Configuration) Assertions.g(this.C));
        } catch (AudioSink.InitializationException e2) {
            Configuration configuration = this.C;
            if (configuration.f10855h > 1000000) {
                Configuration d2 = configuration.d(1000000);
                try {
                    AudioTrack R2 = R(d2);
                    this.C = d2;
                    return R2;
                } catch (AudioSink.InitializationException e3) {
                    e2.addSuppressed(e3);
                    f0();
                    throw e2;
                }
            }
            f0();
            throw e2;
        }
    }

    private boolean T() throws AudioSink.WriteException {
        if (!this.D.g()) {
            ByteBuffer byteBuffer = this.a0;
            if (byteBuffer == null) {
                return true;
            }
            x0(byteBuffer, Long.MIN_VALUE);
            return this.a0 == null;
        }
        this.D.i();
        k0(Long.MIN_VALUE);
        if (!this.D.f()) {
            return false;
        }
        ByteBuffer byteBuffer2 = this.a0;
        return byteBuffer2 == null || !byteBuffer2.hasRemaining();
    }

    private static int U(int i2, int i3, int i4) {
        int minBufferSize = AudioTrack.getMinBufferSize(i2, i3, i4);
        Assertions.i(minBufferSize != -2);
        return minBufferSize;
    }

    private static int V(int i2, ByteBuffer byteBuffer) {
        switch (i2) {
            case 5:
            case 6:
            case 18:
                return Ac3Util.e(byteBuffer);
            case 7:
            case 8:
                return DtsUtil.f(byteBuffer);
            case 9:
                int m2 = MpegAudioUtil.m(Util.d0(byteBuffer, byteBuffer.position()));
                if (m2 != -1) {
                    return m2;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 14:
                int b2 = Ac3Util.b(byteBuffer);
                if (b2 == -1) {
                    return 0;
                }
                return Ac3Util.i(byteBuffer, b2) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return Ac4Util.c(byteBuffer);
            case 20:
                return OpusUtil.h(byteBuffer);
            default:
                throw new IllegalStateException("Unexpected audio encoding: " + i2);
        }
    }

    /* access modifiers changed from: private */
    public long W() {
        Configuration configuration = this.C;
        return configuration.f10850c == 0 ? this.P / ((long) configuration.f10849b) : this.Q;
    }

    /* access modifiers changed from: private */
    public long X() {
        Configuration configuration = this.C;
        return configuration.f10850c == 0 ? Util.r(this.R, (long) configuration.f10851d) : this.S;
    }

    private void Y(long j2) {
        this.r0 += j2;
        if (this.s0 == null) {
            this.s0 = new Handler(Looper.myLooper());
        }
        this.s0.removeCallbacksAndMessages((Object) null);
        this.s0.postDelayed(new P(this), 100);
    }

    private boolean Z() throws AudioSink.InitializationException {
        AudioCapabilitiesReceiver audioCapabilitiesReceiver;
        PlayerId playerId;
        if (!this.o.e()) {
            return false;
        }
        AudioTrack S2 = S();
        this.E = S2;
        if (c0(S2)) {
            l0(this.E);
            Configuration configuration = this.C;
            if (configuration.f10858k) {
                AudioTrack audioTrack = this.E;
                Format format = configuration.f10848a;
                audioTrack.setOffloadDelayPadding(format.v3, format.w3);
            }
        }
        int i2 = Util.f9646a;
        if (i2 >= 31 && (playerId = this.z) != null) {
            Api31.a(this.E, playerId);
        }
        this.h0 = this.E.getAudioSessionId();
        AudioTrackPositionTracker audioTrackPositionTracker = this.p;
        AudioTrack audioTrack2 = this.E;
        Configuration configuration2 = this.C;
        audioTrackPositionTracker.s(audioTrack2, configuration2.f10850c == 2, configuration2.f10854g, configuration2.f10851d, configuration2.f10855h);
        q0();
        int i3 = this.i0.f9074a;
        if (i3 != 0) {
            this.E.attachAuxEffect(i3);
            this.E.setAuxEffectSendLevel(this.i0.f9075b);
        }
        AudioDeviceInfoApi23 audioDeviceInfoApi23 = this.j0;
        if (audioDeviceInfoApi23 != null && i2 >= 23) {
            Api23.a(this.E, audioDeviceInfoApi23);
            AudioCapabilitiesReceiver audioCapabilitiesReceiver2 = this.G;
            if (audioCapabilitiesReceiver2 != null) {
                audioCapabilitiesReceiver2.i(this.j0.f10769a);
            }
        }
        if (i2 >= 24 && (audioCapabilitiesReceiver = this.G) != null) {
            this.H = new OnRoutingChangedListenerApi24(this.E, audioCapabilitiesReceiver);
        }
        this.V = true;
        AudioSink.Listener listener = this.A;
        if (listener != null) {
            listener.b(this.C.b());
        }
        return true;
    }

    private static boolean a0(int i2) {
        return (Util.f9646a >= 24 && i2 == -6) || i2 == F0;
    }

    private boolean b0() {
        return this.E != null;
    }

    private static boolean c0(AudioTrack audioTrack) {
        return Util.f9646a >= 29 && audioTrack.isOffloadedPlayback();
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void e0(AudioTrack audioTrack, AudioSink.Listener listener, Handler handler, AudioSink.AudioTrackConfig audioTrackConfig, ConditionVariable conditionVariable) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (listener != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new O(listener, audioTrackConfig));
            }
            conditionVariable.f();
            synchronized (J0) {
                try {
                    int i2 = L0 - 1;
                    L0 = i2;
                    if (i2 == 0) {
                        K0.shutdown();
                        K0 = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } catch (Throwable th2) {
            if (listener != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new O(listener, audioTrackConfig));
            }
            conditionVariable.f();
            synchronized (J0) {
                int i3 = L0 - 1;
                L0 = i3;
                if (i3 == 0) {
                    K0.shutdown();
                    K0 = null;
                }
                throw th2;
            }
        } finally {
            while (true) {
            }
        }
    }

    private void f0() {
        if (this.C.m()) {
            this.n0 = true;
        }
    }

    /* access modifiers changed from: private */
    public void g0() {
        if (this.r0 >= 300000) {
            this.A.c();
            this.r0 = 0;
        }
    }

    private void h0() {
        if (this.G == null && this.f10831h != null) {
            this.p0 = Looper.myLooper();
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = new AudioCapabilitiesReceiver(this.f10831h, (AudioCapabilitiesReceiver.Listener) new Q(this), this.I, this.j0);
            this.G = audioCapabilitiesReceiver;
            this.F = audioCapabilitiesReceiver.g();
        }
    }

    private void j0() {
        if (!this.e0) {
            this.e0 = true;
            this.p.g(X());
            this.E.stop();
            this.O = 0;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        r0 = r2.Y;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        if (r0 == null) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r0.hasRemaining() != false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003c, code lost:
        r2.D.j(r2.Y);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void k0(long r3) throws androidx.media3.exoplayer.audio.AudioSink.WriteException {
        /*
            r2 = this;
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r2.D
            boolean r0 = r0.g()
            if (r0 != 0) goto L_0x0013
            java.nio.ByteBuffer r0 = r2.Y
            if (r0 == 0) goto L_0x000d
            goto L_0x000f
        L_0x000d:
            java.nio.ByteBuffer r0 = androidx.media3.common.audio.AudioProcessor.f9380a
        L_0x000f:
            r2.x0(r0, r3)
            return
        L_0x0013:
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r2.D
            boolean r0 = r0.f()
            if (r0 != 0) goto L_0x0044
        L_0x001b:
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r2.D
            java.nio.ByteBuffer r0 = r0.d()
            boolean r1 = r0.hasRemaining()
            if (r1 == 0) goto L_0x0031
            r2.x0(r0, r3)
            boolean r0 = r0.hasRemaining()
            if (r0 == 0) goto L_0x001b
            return
        L_0x0031:
            java.nio.ByteBuffer r0 = r2.Y
            if (r0 == 0) goto L_0x0044
            boolean r0 = r0.hasRemaining()
            if (r0 != 0) goto L_0x003c
            goto L_0x0044
        L_0x003c:
            androidx.media3.common.audio.AudioProcessingPipeline r0 = r2.D
            java.nio.ByteBuffer r1 = r2.Y
            r0.j(r1)
            goto L_0x0013
        L_0x0044:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioSink.k0(long):void");
    }

    @RequiresApi(29)
    private void l0(AudioTrack audioTrack) {
        if (this.t == null) {
            this.t = new StreamEventCallbackV29();
        }
        this.t.a(audioTrack);
    }

    private static void m0(AudioTrack audioTrack, ConditionVariable conditionVariable, @Nullable AudioSink.Listener listener, AudioSink.AudioTrackConfig audioTrackConfig) {
        conditionVariable.d();
        Handler handler = new Handler(Looper.myLooper());
        synchronized (J0) {
            try {
                if (K0 == null) {
                    K0 = Util.J1("ExoPlayer:AudioTrackReleaseThread");
                }
                L0++;
                K0.execute(new N(audioTrack, listener, handler, audioTrackConfig, conditionVariable));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void n0() {
        this.P = 0;
        this.Q = 0;
        this.R = 0;
        this.S = 0;
        this.o0 = false;
        this.T = 0;
        this.K = new MediaPositionParameters(this.L, 0, 0);
        this.W = 0;
        this.J = null;
        this.q.clear();
        this.Y = null;
        this.Z = 0;
        this.a0 = null;
        this.e0 = false;
        this.d0 = false;
        this.N = null;
        this.O = 0;
        this.f10835l.n();
        t0();
    }

    private void o0(PlaybackParameters playbackParameters) {
        MediaPositionParameters mediaPositionParameters = new MediaPositionParameters(playbackParameters, C.f9084b, C.f9084b);
        if (b0()) {
            this.J = mediaPositionParameters;
        } else {
            this.K = mediaPositionParameters;
        }
    }

    @RequiresApi(23)
    private void p0() {
        if (b0()) {
            try {
                this.E.setPlaybackParams(D.a().allowDefaults().setSpeed(this.L.s).setPitch(this.L.X).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e2) {
                Log.o(H0, "Failed to set playback params", e2);
            }
            PlaybackParameters playbackParameters = new PlaybackParameters(this.E.getPlaybackParams().getSpeed(), this.E.getPlaybackParams().getPitch());
            this.L = playbackParameters;
            this.p.t(playbackParameters.s);
        }
    }

    private void q0() {
        if (b0()) {
            if (Util.f9646a >= 21) {
                r0(this.E, this.X);
            } else {
                s0(this.E, this.X);
            }
        }
    }

    @RequiresApi(21)
    private static void r0(AudioTrack audioTrack, float f2) {
        audioTrack.setVolume(f2);
    }

    private static void s0(AudioTrack audioTrack, float f2) {
        audioTrack.setStereoVolume(f2, f2);
    }

    private void t0() {
        AudioProcessingPipeline audioProcessingPipeline = this.C.f10856i;
        this.D = audioProcessingPipeline;
        audioProcessingPipeline.b();
    }

    private boolean u0() {
        if (!this.k0) {
            Configuration configuration = this.C;
            return configuration.f10850c == 0 && !v0(configuration.f10848a.u3);
        }
    }

    private boolean v0(int i2) {
        return this.f10833j && Util.h1(i2);
    }

    private boolean w0() {
        Configuration configuration = this.C;
        return configuration != null && configuration.f10857j && Util.f9646a >= 23;
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d0  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00dd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void x0(java.nio.ByteBuffer r13, long r14) throws androidx.media3.exoplayer.audio.AudioSink.WriteException {
        /*
            r12 = this;
            boolean r0 = r13.hasRemaining()
            if (r0 != 0) goto L_0x0007
            return
        L_0x0007:
            java.nio.ByteBuffer r0 = r12.a0
            r1 = 21
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L_0x0018
            if (r0 != r13) goto L_0x0013
            r0 = 1
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            androidx.media3.common.util.Assertions.a(r0)
            goto L_0x003b
        L_0x0018:
            r12.a0 = r13
            int r0 = androidx.media3.common.util.Util.f9646a
            if (r0 >= r1) goto L_0x003b
            int r0 = r13.remaining()
            byte[] r4 = r12.b0
            if (r4 == 0) goto L_0x0029
            int r4 = r4.length
            if (r4 >= r0) goto L_0x002d
        L_0x0029:
            byte[] r4 = new byte[r0]
            r12.b0 = r4
        L_0x002d:
            int r4 = r13.position()
            byte[] r5 = r12.b0
            r13.get(r5, r3, r0)
            r13.position(r4)
            r12.c0 = r3
        L_0x003b:
            int r0 = r13.remaining()
            int r4 = androidx.media3.common.util.Util.f9646a
            if (r4 >= r1) goto L_0x006d
            androidx.media3.exoplayer.audio.AudioTrackPositionTracker r14 = r12.p
            long r4 = r12.R
            int r14 = r14.c(r4)
            if (r14 <= 0) goto L_0x006b
            int r14 = java.lang.Math.min(r0, r14)
            android.media.AudioTrack r15 = r12.E
            byte[] r1 = r12.b0
            int r4 = r12.c0
            int r14 = r15.write(r1, r4, r14)
            if (r14 <= 0) goto L_0x009d
            int r15 = r12.c0
            int r15 = r15 + r14
            r12.c0 = r15
            int r15 = r13.position()
            int r15 = r15 + r14
            r13.position(r15)
            goto L_0x009d
        L_0x006b:
            r14 = 0
            goto L_0x009d
        L_0x006d:
            boolean r1 = r12.k0
            if (r1 == 0) goto L_0x0097
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r1 == 0) goto L_0x007c
            r1 = 1
            goto L_0x007d
        L_0x007c:
            r1 = 0
        L_0x007d:
            androidx.media3.common.util.Assertions.i(r1)
            r4 = -9223372036854775808
            int r1 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x008a
            long r14 = r12.l0
        L_0x0088:
            r10 = r14
            goto L_0x008d
        L_0x008a:
            r12.l0 = r14
            goto L_0x0088
        L_0x008d:
            android.media.AudioTrack r7 = r12.E
            r6 = r12
            r8 = r13
            r9 = r0
            int r14 = r6.z0(r7, r8, r9, r10)
            goto L_0x009d
        L_0x0097:
            android.media.AudioTrack r14 = r12.E
            int r14 = y0(r14, r13, r0)
        L_0x009d:
            long r4 = android.os.SystemClock.elapsedRealtime()
            r12.m0 = r4
            r4 = 0
            if (r14 >= 0) goto L_0x00e2
            boolean r13 = a0(r14)
            if (r13 == 0) goto L_0x00c2
            long r0 = r12.X()
            int r13 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r13 <= 0) goto L_0x00b6
            goto L_0x00c3
        L_0x00b6:
            android.media.AudioTrack r13 = r12.E
            boolean r13 = c0(r13)
            if (r13 == 0) goto L_0x00c2
            r12.f0()
            goto L_0x00c3
        L_0x00c2:
            r2 = 0
        L_0x00c3:
            androidx.media3.exoplayer.audio.AudioSink$WriteException r13 = new androidx.media3.exoplayer.audio.AudioSink$WriteException
            androidx.media3.exoplayer.audio.DefaultAudioSink$Configuration r15 = r12.C
            androidx.media3.common.Format r15 = r15.f10848a
            r13.<init>(r14, r15, r2)
            androidx.media3.exoplayer.audio.AudioSink$Listener r14 = r12.A
            if (r14 == 0) goto L_0x00d3
            r14.f(r13)
        L_0x00d3:
            boolean r14 = r13.X
            if (r14 != 0) goto L_0x00dd
            androidx.media3.exoplayer.audio.DefaultAudioSink$PendingExceptionHolder<androidx.media3.exoplayer.audio.AudioSink$WriteException> r14 = r12.v
            r14.b(r13)
            return
        L_0x00dd:
            androidx.media3.exoplayer.audio.AudioCapabilities r14 = androidx.media3.exoplayer.audio.AudioCapabilities.f10743e
            r12.F = r14
            throw r13
        L_0x00e2:
            androidx.media3.exoplayer.audio.DefaultAudioSink$PendingExceptionHolder<androidx.media3.exoplayer.audio.AudioSink$WriteException> r15 = r12.v
            r15.a()
            android.media.AudioTrack r15 = r12.E
            boolean r15 = c0(r15)
            if (r15 == 0) goto L_0x0108
            long r6 = r12.S
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 <= 0) goto L_0x00f7
            r12.o0 = r3
        L_0x00f7:
            boolean r15 = r12.f0
            if (r15 == 0) goto L_0x0108
            androidx.media3.exoplayer.audio.AudioSink$Listener r15 = r12.A
            if (r15 == 0) goto L_0x0108
            if (r14 >= r0) goto L_0x0108
            boolean r1 = r12.o0
            if (r1 != 0) goto L_0x0108
            r15.g()
        L_0x0108:
            androidx.media3.exoplayer.audio.DefaultAudioSink$Configuration r15 = r12.C
            int r15 = r15.f10850c
            if (r15 != 0) goto L_0x0114
            long r4 = r12.R
            long r6 = (long) r14
            long r4 = r4 + r6
            r12.R = r4
        L_0x0114:
            if (r14 != r0) goto L_0x0131
            if (r15 == 0) goto L_0x012e
            java.nio.ByteBuffer r14 = r12.Y
            if (r13 != r14) goto L_0x011d
            goto L_0x011e
        L_0x011d:
            r2 = 0
        L_0x011e:
            androidx.media3.common.util.Assertions.i(r2)
            long r13 = r12.S
            int r15 = r12.T
            long r0 = (long) r15
            int r15 = r12.Z
            long r2 = (long) r15
            long r0 = r0 * r2
            long r13 = r13 + r0
            r12.S = r13
        L_0x012e:
            r13 = 0
            r12.a0 = r13
        L_0x0131:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.DefaultAudioSink.x0(java.nio.ByteBuffer, long):void");
    }

    @RequiresApi(21)
    private static int y0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2) {
        return audioTrack.write(byteBuffer, i2, 1);
    }

    @RequiresApi(21)
    private int z0(AudioTrack audioTrack, ByteBuffer byteBuffer, int i2, long j2) {
        if (Util.f9646a >= 26) {
            return audioTrack.write(byteBuffer, i2, 1, j2 * 1000);
        }
        if (this.N == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.N = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.N.putInt(1431633921);
        }
        if (this.O == 0) {
            this.N.putInt(4, i2);
            this.N.putLong(8, j2 * 1000);
            this.N.position(0);
            this.O = i2;
        }
        int remaining = this.N.remaining();
        if (remaining > 0) {
            int write = audioTrack.write(this.N, remaining, 1);
            if (write < 0) {
                this.O = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int y02 = y0(audioTrack, byteBuffer, i2);
        if (y02 < 0) {
            this.O = 0;
            return y02;
        }
        this.O -= y02;
        return y02;
    }

    public /* synthetic */ void A(long j2) {
        C0277w.f(this, j2);
    }

    public void B() {
        this.U = true;
    }

    public void C() {
        Assertions.i(Util.f9646a >= 21);
        Assertions.i(this.g0);
        if (!this.k0) {
            this.k0 = true;
            flush();
        }
    }

    public int D(Format format) {
        h0();
        if (!MimeTypes.N.equals(format.f3)) {
            return this.F.o(format, this.I) ? 2 : 0;
        }
        if (!Util.i1(format.u3)) {
            Log.n(H0, "Invalid PCM encoding: " + format.u3);
            return 0;
        }
        int i2 = format.u3;
        return (i2 == 2 || (this.f10833j && i2 == 4)) ? 2 : 1;
    }

    public boolean E(ByteBuffer byteBuffer, long j2, int i2) throws AudioSink.InitializationException, AudioSink.WriteException {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j3 = j2;
        int i3 = i2;
        ByteBuffer byteBuffer3 = this.Y;
        Assertions.a(byteBuffer3 == null || byteBuffer2 == byteBuffer3);
        if (this.B != null) {
            if (!T()) {
                return false;
            }
            if (!this.B.c(this.C)) {
                j0();
                if (q()) {
                    return false;
                }
                flush();
            } else {
                this.C = this.B;
                this.B = null;
                AudioTrack audioTrack = this.E;
                if (audioTrack != null && c0(audioTrack) && this.C.f10858k) {
                    if (this.E.getPlayState() == 3) {
                        this.E.setOffloadEndOfStream();
                        this.p.a();
                    }
                    AudioTrack audioTrack2 = this.E;
                    Format format = this.C.f10848a;
                    audioTrack2.setOffloadDelayPadding(format.v3, format.w3);
                    this.o0 = true;
                }
            }
            O(j3);
        }
        if (!b0()) {
            try {
                if (!Z()) {
                    return false;
                }
            } catch (AudioSink.InitializationException e2) {
                AudioSink.InitializationException initializationException = e2;
                if (!initializationException.X) {
                    this.u.b(initializationException);
                    return false;
                }
                throw initializationException;
            }
        }
        this.u.a();
        if (this.V) {
            this.W = Math.max(0, j3);
            this.U = false;
            this.V = false;
            if (w0()) {
                p0();
            }
            O(j3);
            if (this.f0) {
                o();
            }
        }
        if (!this.p.k(X())) {
            return false;
        }
        if (this.Y == null) {
            Assertions.a(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            Configuration configuration = this.C;
            if (configuration.f10850c != 0 && this.T == 0) {
                int V2 = V(configuration.f10854g, byteBuffer2);
                this.T = V2;
                if (V2 == 0) {
                    return true;
                }
            }
            if (this.J != null) {
                if (!T()) {
                    return false;
                }
                O(j3);
                this.J = null;
            }
            long l2 = this.W + this.C.l(W() - this.f10835l.m());
            if (!this.U && Math.abs(l2 - j3) > 200000) {
                AudioSink.Listener listener = this.A;
                if (listener != null) {
                    listener.f(new AudioSink.UnexpectedDiscontinuityException(j3, l2));
                }
                this.U = true;
            }
            if (this.U) {
                if (!T()) {
                    return false;
                }
                long j4 = j3 - l2;
                this.W += j4;
                this.U = false;
                O(j3);
                AudioSink.Listener listener2 = this.A;
                if (!(listener2 == null || j4 == 0)) {
                    listener2.j();
                }
            }
            if (this.C.f10850c == 0) {
                this.P += (long) byteBuffer.remaining();
            } else {
                this.Q += ((long) this.T) * ((long) i3);
            }
            this.Y = byteBuffer2;
            this.Z = i3;
        }
        k0(j3);
        if (!this.Y.hasRemaining()) {
            this.Y = null;
            this.Z = 0;
            return true;
        } else if (!this.p.j(X())) {
            return false;
        } else {
            Log.n(H0, "Resetting stalled audio track");
            flush();
            return true;
        }
    }

    public void a() {
        AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.G;
        if (audioCapabilitiesReceiver != null) {
            audioCapabilitiesReceiver.j();
        }
    }

    public boolean b(Format format) {
        return D(format) != 0;
    }

    public boolean c() {
        return !b0() || (this.d0 && !q());
    }

    public androidx.media3.common.AudioAttributes d() {
        return this.I;
    }

    public void e(int i2) {
        if (this.h0 != i2) {
            this.h0 = i2;
            this.g0 = i2 != 0;
            flush();
        }
    }

    public void f(PlaybackParameters playbackParameters) {
        this.L = new PlaybackParameters(Util.v(playbackParameters.s, 0.1f, 8.0f), Util.v(playbackParameters.X, 0.1f, 8.0f));
        if (w0()) {
            p0();
        } else {
            o0(playbackParameters);
        }
    }

    public void flush() {
        OnRoutingChangedListenerApi24 onRoutingChangedListenerApi24;
        if (b0()) {
            n0();
            if (this.p.i()) {
                this.E.pause();
            }
            if (c0(this.E)) {
                ((StreamEventCallbackV29) Assertions.g(this.t)).b(this.E);
            }
            int i2 = Util.f9646a;
            if (i2 < 21 && !this.g0) {
                this.h0 = 0;
            }
            AudioSink.AudioTrackConfig b2 = this.C.b();
            Configuration configuration = this.B;
            if (configuration != null) {
                this.C = configuration;
                this.B = null;
            }
            this.p.q();
            if (i2 >= 24 && (onRoutingChangedListenerApi24 = this.H) != null) {
                onRoutingChangedListenerApi24.c();
                this.H = null;
            }
            m0(this.E, this.o, this.A, b2);
            this.E = null;
        }
        this.v.a();
        this.u.a();
        this.q0 = 0;
        this.r0 = 0;
        Handler handler = this.s0;
        if (handler != null) {
            ((Handler) Assertions.g(handler)).removeCallbacksAndMessages((Object) null);
        }
    }

    public void g(float f2) {
        if (this.X != f2) {
            this.X = f2;
            q0();
        }
    }

    public void h() {
        this.f0 = false;
        if (!b0()) {
            return;
        }
        if (this.p.p() || c0(this.E)) {
            this.E.pause();
        }
    }

    public void i(Clock clock) {
        this.p.u(clock);
    }

    public void i0(AudioCapabilities audioCapabilities) {
        Assertions.i(this.p0 == Looper.myLooper());
        if (!audioCapabilities.equals(this.F)) {
            this.F = audioCapabilities;
            AudioSink.Listener listener = this.A;
            if (listener != null) {
                listener.i();
            }
        }
    }

    public void j(Format format, int i2, @Nullable int[] iArr) throws AudioSink.ConfigurationException {
        boolean z2;
        boolean z3;
        AudioProcessingPipeline audioProcessingPipeline;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int[] iArr2;
        Format format2 = format;
        h0();
        if (MimeTypes.N.equals(format2.f3)) {
            Assertions.a(Util.i1(format2.u3));
            i8 = Util.F0(format2.u3, format2.s3);
            ImmutableList.Builder builder = new ImmutableList.Builder();
            if (v0(format2.u3)) {
                builder.c(this.f10837n);
            } else {
                builder.c(this.f10836m);
                builder.b(this.f10832i.d());
            }
            AudioProcessingPipeline audioProcessingPipeline2 = new AudioProcessingPipeline(builder.e());
            if (audioProcessingPipeline2.equals(this.D)) {
                audioProcessingPipeline2 = this.D;
            }
            this.f10835l.o(format2.v3, format2.w3);
            if (Util.f9646a < 21 && format2.s3 == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i14 = 0; i14 < 6; i14++) {
                    iArr2[i14] = i14;
                }
            } else {
                iArr2 = iArr;
            }
            this.f10834k.m(iArr2);
            try {
                AudioProcessor.AudioFormat a2 = audioProcessingPipeline2.a(new AudioProcessor.AudioFormat(format2));
                int i15 = a2.f9384c;
                int i16 = a2.f9382a;
                int a02 = Util.a0(a2.f9383b);
                i5 = Util.F0(i15, a2.f9383b);
                audioProcessingPipeline = audioProcessingPipeline2;
                i4 = i16;
                i6 = a02;
                z3 = this.r;
                i3 = 0;
                z2 = false;
                i7 = i15;
            } catch (AudioProcessor.UnhandledAudioFormatException e2) {
                throw new AudioSink.ConfigurationException((Throwable) e2, format2);
            }
        } else {
            AudioProcessingPipeline audioProcessingPipeline3 = new AudioProcessingPipeline(ImmutableList.I());
            int i17 = format2.t3;
            AudioOffloadSupport l2 = this.s != 0 ? l(format) : AudioOffloadSupport.f10770d;
            if (this.s == 0 || !l2.f10771a) {
                Pair<Integer, Integer> k2 = this.F.k(format2, this.I);
                if (k2 != null) {
                    int intValue = ((Integer) k2.first).intValue();
                    audioProcessingPipeline = audioProcessingPipeline3;
                    i4 = i17;
                    i6 = ((Integer) k2.second).intValue();
                    i7 = intValue;
                    z3 = this.r;
                    i8 = -1;
                    i5 = -1;
                    i3 = 2;
                    z2 = false;
                } else {
                    throw new AudioSink.ConfigurationException("Unable to configure passthrough for: " + format2, format2);
                }
            } else {
                int f2 = MimeTypes.f((String) Assertions.g(format2.f3), format2.c3);
                int a03 = Util.a0(format2.s3);
                audioProcessingPipeline = audioProcessingPipeline3;
                i4 = i17;
                z2 = l2.f10772b;
                i7 = f2;
                i6 = a03;
                i8 = -1;
                i5 = -1;
                i3 = 1;
                z3 = true;
            }
        }
        if (i7 == 0) {
            throw new AudioSink.ConfigurationException("Invalid output encoding (mode=" + i3 + ") for: " + format2, format2);
        } else if (i6 != 0) {
            int i18 = format2.b3;
            int i19 = (!MimeTypes.X.equals(format2.f3) || i18 != -1) ? i18 : 768000;
            if (i2 != 0) {
                i13 = i2;
                i11 = i7;
                i10 = i6;
                i9 = i5;
                i12 = i4;
            } else {
                AudioTrackBufferSizeProvider audioTrackBufferSizeProvider = this.w;
                int U2 = U(i4, i6, i7);
                i11 = i7;
                i10 = i6;
                int i20 = i19;
                i9 = i5;
                i12 = i4;
                i13 = audioTrackBufferSizeProvider.a(U2, i7, i3, i5 != -1 ? i5 : 1, i4, i20, z3 ? 8.0d : 1.0d);
            }
            this.n0 = false;
            Configuration configuration = r2;
            Configuration configuration2 = new Configuration(format, i8, i3, i9, i12, i10, i11, i13, audioProcessingPipeline, z3, z2, this.k0);
            if (b0()) {
                this.B = configuration;
            } else {
                this.C = configuration;
            }
        } else {
            throw new AudioSink.ConfigurationException("Invalid output channel config (mode=" + i3 + ") for: " + format2, format2);
        }
    }

    public void k(androidx.media3.common.AudioAttributes audioAttributes) {
        if (!this.I.equals(audioAttributes)) {
            this.I = audioAttributes;
            if (!this.k0) {
                AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.G;
                if (audioCapabilitiesReceiver != null) {
                    audioCapabilitiesReceiver.h(audioAttributes);
                }
                flush();
            }
        }
    }

    public AudioOffloadSupport l(Format format) {
        return this.n0 ? AudioOffloadSupport.f10770d : this.x.a(format, this.I);
    }

    @RequiresApi(23)
    public void m(@Nullable AudioDeviceInfo audioDeviceInfo) {
        this.j0 = audioDeviceInfo == null ? null : new AudioDeviceInfoApi23(audioDeviceInfo);
        AudioCapabilitiesReceiver audioCapabilitiesReceiver = this.G;
        if (audioCapabilitiesReceiver != null) {
            audioCapabilitiesReceiver.i(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.E;
        if (audioTrack != null) {
            Api23.a(audioTrack, this.j0);
        }
    }

    public boolean n() {
        return this.M;
    }

    public void o() {
        this.f0 = true;
        if (b0()) {
            this.p.v();
            this.E.play();
        }
    }

    public void p() throws AudioSink.WriteException {
        if (!this.d0 && b0() && T()) {
            j0();
            this.d0 = true;
        }
    }

    public boolean q() {
        return b0() && this.p.h(X());
    }

    public PlaybackParameters r() {
        return this.L;
    }

    public void reset() {
        flush();
        UnmodifiableIterator<AudioProcessor> k2 = this.f10836m.iterator();
        while (k2.hasNext()) {
            k2.next().reset();
        }
        UnmodifiableIterator<AudioProcessor> k3 = this.f10837n.iterator();
        while (k3.hasNext()) {
            k3.next().reset();
        }
        AudioProcessingPipeline audioProcessingPipeline = this.D;
        if (audioProcessingPipeline != null) {
            audioProcessingPipeline.k();
        }
        this.f0 = false;
        this.n0 = false;
    }

    public void s(boolean z2) {
        this.M = z2;
        o0(w0() ? PlaybackParameters.Z : this.L);
    }

    public void t(AuxEffectInfo auxEffectInfo) {
        if (!this.i0.equals(auxEffectInfo)) {
            int i2 = auxEffectInfo.f9074a;
            float f2 = auxEffectInfo.f9075b;
            AudioTrack audioTrack = this.E;
            if (audioTrack != null) {
                if (this.i0.f9074a != i2) {
                    audioTrack.attachAuxEffect(i2);
                }
                if (i2 != 0) {
                    this.E.setAuxEffectSendLevel(f2);
                }
            }
            this.i0 = auxEffectInfo;
        }
    }

    @RequiresApi(29)
    public void u(int i2, int i3) {
        Configuration configuration;
        AudioTrack audioTrack = this.E;
        if (audioTrack != null && c0(audioTrack) && (configuration = this.C) != null && configuration.f10858k) {
            this.E.setOffloadDelayPadding(i2, i3);
        }
    }

    public void v(AudioSink.Listener listener) {
        this.A = listener;
    }

    @RequiresApi(29)
    public void w(int i2) {
        Assertions.i(Util.f9646a >= 29);
        this.s = i2;
    }

    public long x(boolean z2) {
        if (!b0() || this.V) {
            return Long.MIN_VALUE;
        }
        return Q(P(Math.min(this.p.d(z2), this.C.i(X()))));
    }

    public void y() {
        if (this.k0) {
            this.k0 = false;
            flush();
        }
    }

    public void z(@Nullable PlayerId playerId) {
        this.z = playerId;
    }
}
