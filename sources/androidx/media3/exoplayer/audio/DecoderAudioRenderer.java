package androidx.media3.exoplayer.audio;

import android.os.Handler;
import android.os.SystemClock;
import androidx.annotation.CallSuper;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.AudioAttributes;
import androidx.media3.common.AuxEffectInfo;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.PlaybackParameters;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.decoder.Decoder;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.SimpleDecoderOutputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.MediaClock;
import androidx.media3.exoplayer.V0;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.drm.C0295i;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.source.MediaSource;
import com.google.common.base.MoreObjects;
import com.google.errorprone.annotations.ForOverride;

@UnstableApi
public abstract class DecoderAudioRenderer<T extends Decoder<DecoderInputBuffer, ? extends SimpleDecoderOutputBuffer, ? extends DecoderException>> extends BaseRenderer implements MediaClock {
    private static final String I3 = "DecoderAudioRenderer";
    private static final int J3 = 0;
    private static final int K3 = 1;
    private static final int L3 = 2;
    private static final int M3 = 10;
    private long A3;
    private boolean B3;
    private boolean C3;
    private boolean D3;
    private long E3;
    private final long[] F3;
    private int G3;
    /* access modifiers changed from: private */
    public boolean H3;
    /* access modifiers changed from: private */
    public final AudioRendererEventListener.EventDispatcher k3;
    private final AudioSink l3;
    private final DecoderInputBuffer m3;
    private DecoderCounters n3;
    private Format o3;
    private int p3;
    private int q3;
    private boolean r3;
    @Nullable
    private T s3;
    @Nullable
    private DecoderInputBuffer t3;
    @Nullable
    private SimpleDecoderOutputBuffer u3;
    @Nullable
    private DrmSession v3;
    @Nullable
    private DrmSession w3;
    private int x3;
    private boolean y3;
    private boolean z3;

    @RequiresApi(23)
    private static final class Api23 {
        private Api23() {
        }

        @DoNotInline
        public static void a(AudioSink audioSink, @Nullable Object obj) {
            audioSink.m(C0262g.a(obj));
        }
    }

    private final class AudioSinkListener implements AudioSink.Listener {
        private AudioSinkListener() {
        }

        public void a(long j2) {
            DecoderAudioRenderer.this.k3.H(j2);
        }

        public void b(AudioSink.AudioTrackConfig audioTrackConfig) {
            DecoderAudioRenderer.this.k3.o(audioTrackConfig);
        }

        public void c() {
            boolean unused = DecoderAudioRenderer.this.H3 = true;
        }

        public void d(AudioSink.AudioTrackConfig audioTrackConfig) {
            DecoderAudioRenderer.this.k3.p(audioTrackConfig);
        }

        public void e(boolean z) {
            DecoderAudioRenderer.this.k3.I(z);
        }

        public void f(Exception exc) {
            Log.e(DecoderAudioRenderer.I3, "Audio sink error", exc);
            DecoderAudioRenderer.this.k3.n(exc);
        }

        public /* synthetic */ void g() {
            C0278x.f(this);
        }

        public void h(int i2, long j2, long j3) {
            DecoderAudioRenderer.this.k3.J(i2, j2, j3);
        }

        public /* synthetic */ void i() {
            C0278x.a(this);
        }

        public void j() {
            DecoderAudioRenderer.this.s0();
        }

        public /* synthetic */ void k() {
            C0278x.e(this);
        }
    }

    public DecoderAudioRenderer() {
        this((Handler) null, (AudioRendererEventListener) null, new AudioProcessor[0]);
    }

    private void B0() {
        long x = this.l3.x(c());
        if (x != Long.MIN_VALUE) {
            if (!this.B3) {
                x = Math.max(this.A3, x);
            }
            this.A3 = x;
            this.B3 = false;
        }
    }

    private boolean k0() throws ExoPlaybackException, DecoderException, AudioSink.ConfigurationException, AudioSink.InitializationException, AudioSink.WriteException {
        if (this.u3 == null) {
            SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = (SimpleDecoderOutputBuffer) this.s3.b();
            this.u3 = simpleDecoderOutputBuffer;
            if (simpleDecoderOutputBuffer == null) {
                return false;
            }
            int i2 = simpleDecoderOutputBuffer.Y;
            if (i2 > 0) {
                this.n3.f10103f += i2;
                this.l3.B();
            }
            if (this.u3.m()) {
                u0();
            }
        }
        if (this.u3.l()) {
            if (this.x3 == 2) {
                v0();
                q0();
                this.z3 = true;
            } else {
                this.u3.q();
                this.u3 = null;
                try {
                    t0();
                } catch (AudioSink.WriteException e2) {
                    throw I(e2, e2.Y, e2.X, PlaybackException.t3);
                }
            }
            return false;
        }
        if (this.z3) {
            this.l3.j(o0(this.s3).c().S(this.p3).T(this.q3).d0(this.o3.d3).X(this.o3.s).Z(this.o3.X).a0(this.o3.Y).b0(this.o3.Z).m0(this.o3.X2).i0(this.o3.Y2).I(), 0, n0(this.s3));
            this.z3 = false;
        }
        AudioSink audioSink = this.l3;
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer2 = this.u3;
        if (!audioSink.E(simpleDecoderOutputBuffer2.Y2, simpleDecoderOutputBuffer2.X, 1)) {
            return false;
        }
        this.n3.f10102e++;
        this.u3.q();
        this.u3 = null;
        return true;
    }

    private boolean l0() throws DecoderException, ExoPlaybackException {
        T t = this.s3;
        if (t == null || this.x3 == 2 || this.C3) {
            return false;
        }
        if (this.t3 == null) {
            DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) t.f();
            this.t3 = decoderInputBuffer;
            if (decoderInputBuffer == null) {
                return false;
            }
        }
        if (this.x3 == 1) {
            this.t3.p(4);
            this.s3.c(this.t3);
            this.t3 = null;
            this.x3 = 2;
            return false;
        }
        FormatHolder L = L();
        int d0 = d0(L, this.t3, 0);
        if (d0 == -5) {
            r0(L);
            return true;
        } else if (d0 != -4) {
            if (d0 == -3) {
                return false;
            }
            throw new IllegalStateException();
        } else if (this.t3.l()) {
            this.C3 = true;
            this.s3.c(this.t3);
            this.t3 = null;
            return false;
        } else {
            if (!this.r3) {
                this.r3 = true;
                this.t3.f(C.S0);
            }
            if (this.t3.Y2 < N()) {
                this.t3.f(Integer.MIN_VALUE);
            }
            this.t3.s();
            DecoderInputBuffer decoderInputBuffer2 = this.t3;
            decoderInputBuffer2.X = this.o3;
            this.s3.c(decoderInputBuffer2);
            this.y3 = true;
            this.n3.f10100c++;
            this.t3 = null;
            return true;
        }
    }

    private void m0() throws ExoPlaybackException {
        if (this.x3 != 0) {
            v0();
            q0();
            return;
        }
        this.t3 = null;
        SimpleDecoderOutputBuffer simpleDecoderOutputBuffer = this.u3;
        if (simpleDecoderOutputBuffer != null) {
            simpleDecoderOutputBuffer.q();
            this.u3 = null;
        }
        Decoder decoder = (Decoder) Assertions.g(this.s3);
        decoder.flush();
        decoder.d(N());
        this.y3 = false;
    }

    private void q0() throws ExoPlaybackException {
        CryptoConfig cryptoConfig;
        if (this.s3 == null) {
            w0(this.w3);
            DrmSession drmSession = this.v3;
            if (drmSession != null) {
                cryptoConfig = drmSession.m();
                if (cryptoConfig == null && this.v3.e() == null) {
                    return;
                }
            } else {
                cryptoConfig = null;
            }
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                TraceUtil.a("createAudioDecoder");
                T j0 = j0(this.o3, cryptoConfig);
                this.s3 = j0;
                j0.d(N());
                TraceUtil.c();
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                this.k3.q(this.s3.getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.n3.f10098a++;
            } catch (DecoderException e2) {
                Log.e(I3, "Audio codec error", e2);
                this.k3.m(e2);
                throw H(e2, this.o3, PlaybackException.n3);
            } catch (OutOfMemoryError e3) {
                throw H(e3, this.o3, PlaybackException.n3);
            }
        }
    }

    private void r0(FormatHolder formatHolder) throws ExoPlaybackException {
        Format format = (Format) Assertions.g(formatHolder.f10226b);
        y0(formatHolder.f10225a);
        Format format2 = this.o3;
        this.o3 = format;
        this.p3 = format.v3;
        this.q3 = format.w3;
        T t = this.s3;
        if (t == null) {
            q0();
            this.k3.u(this.o3, (DecoderReuseEvaluation) null);
            return;
        }
        DecoderReuseEvaluation decoderReuseEvaluation = this.w3 != this.v3 ? new DecoderReuseEvaluation(t.getName(), format2, format, 0, 128) : i0(t.getName(), format2, format);
        if (decoderReuseEvaluation.f10122d == 0) {
            if (this.y3) {
                this.x3 = 1;
            } else {
                v0();
                q0();
                this.z3 = true;
            }
        }
        this.k3.u(this.o3, decoderReuseEvaluation);
    }

    private void t0() throws AudioSink.WriteException {
        this.D3 = true;
        this.l3.p();
    }

    private void u0() {
        this.l3.B();
        if (this.G3 != 0) {
            x0(this.F3[0]);
            int i2 = this.G3 - 1;
            this.G3 = i2;
            long[] jArr = this.F3;
            System.arraycopy(jArr, 1, jArr, 0, i2);
        }
    }

    private void v0() {
        this.t3 = null;
        this.u3 = null;
        this.x3 = 0;
        this.y3 = false;
        T t = this.s3;
        if (t != null) {
            this.n3.f10099b++;
            t.a();
            this.k3.r(this.s3.getName());
            this.s3 = null;
        }
        w0((DrmSession) null);
    }

    private void w0(@Nullable DrmSession drmSession) {
        C0295i.b(this.v3, drmSession);
        this.v3 = drmSession;
    }

    private void x0(long j2) {
        this.E3 = j2;
        if (j2 != C.f9084b) {
            this.l3.A(j2);
        }
    }

    private void y0(@Nullable DrmSession drmSession) {
        C0295i.b(this.w3, drmSession);
        this.w3 = drmSession;
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract int A0(Format format);

    @Nullable
    public MediaClock G() {
        return this;
    }

    /* access modifiers changed from: protected */
    public void S() {
        this.o3 = null;
        this.z3 = true;
        x0(C.f9084b);
        this.H3 = false;
        try {
            y0((DrmSession) null);
            v0();
            this.l3.reset();
        } finally {
            this.k3.s(this.n3);
        }
    }

    /* access modifiers changed from: protected */
    public void T(boolean z, boolean z2) throws ExoPlaybackException {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.n3 = decoderCounters;
        this.k3.t(decoderCounters);
        if (K().f10444b) {
            this.l3.C();
        } else {
            this.l3.y();
        }
        this.l3.z(O());
        this.l3.i(J());
    }

    /* access modifiers changed from: protected */
    public void V(long j2, boolean z) throws ExoPlaybackException {
        this.l3.flush();
        this.A3 = j2;
        this.H3 = false;
        this.B3 = true;
        this.C3 = false;
        this.D3 = false;
        if (this.s3 != null) {
            m0();
        }
    }

    /* access modifiers changed from: protected */
    public void Z() {
        this.l3.o();
    }

    /* access modifiers changed from: protected */
    public void a0() {
        B0();
        this.l3.h();
    }

    public final int b(Format format) {
        int i2 = 0;
        if (!MimeTypes.p(format.f3)) {
            return V0.c(0);
        }
        int A0 = A0(format);
        if (A0 <= 2) {
            return V0.c(A0);
        }
        if (Util.f9646a >= 21) {
            i2 = 32;
        }
        return V0.d(A0, 8, i2);
    }

    /* access modifiers changed from: protected */
    public void b0(Format[] formatArr, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        super.b0(formatArr, j2, j3, mediaPeriodId);
        this.r3 = false;
        if (this.E3 == C.f9084b) {
            x0(j3);
            return;
        }
        int i2 = this.G3;
        if (i2 == this.F3.length) {
            Log.n(I3, "Too many stream changes, so dropping offset: " + this.F3[this.G3 - 1]);
        } else {
            this.G3 = i2 + 1;
        }
        this.F3[this.G3 - 1] = j3;
    }

    public boolean c() {
        return this.D3 && this.l3.c();
    }

    public boolean d() {
        return this.l3.q() || (this.o3 != null && (R() || this.u3 != null));
    }

    public void f(PlaybackParameters playbackParameters) {
        this.l3.f(playbackParameters);
    }

    public void g(long j2, long j3) throws ExoPlaybackException {
        if (this.D3) {
            try {
                this.l3.p();
            } catch (AudioSink.WriteException e2) {
                throw I(e2, e2.Y, e2.X, PlaybackException.t3);
            }
        } else {
            if (this.o3 == null) {
                FormatHolder L = L();
                this.m3.g();
                int d0 = d0(L, this.m3, 2);
                if (d0 == -5) {
                    r0(L);
                } else if (d0 == -4) {
                    Assertions.i(this.m3.l());
                    this.C3 = true;
                    try {
                        t0();
                        return;
                    } catch (AudioSink.WriteException e3) {
                        throw H(e3, (Format) null, PlaybackException.t3);
                    }
                } else {
                    return;
                }
            }
            q0();
            if (this.s3 != null) {
                try {
                    TraceUtil.a("drainAndFeed");
                    while (k0()) {
                    }
                    while (l0()) {
                    }
                    TraceUtil.c();
                    this.n3.c();
                } catch (DecoderException e4) {
                    Log.e(I3, "Audio codec error", e4);
                    this.k3.m(e4);
                    throw H(e4, this.o3, PlaybackException.p3);
                } catch (AudioSink.ConfigurationException e5) {
                    throw H(e5, e5.s, PlaybackException.s3);
                } catch (AudioSink.InitializationException e6) {
                    throw I(e6, e6.Y, e6.X, PlaybackException.s3);
                } catch (AudioSink.WriteException e7) {
                    throw I(e7, e7.Y, e7.X, PlaybackException.t3);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public DecoderReuseEvaluation i0(String str, Format format, Format format2) {
        return new DecoderReuseEvaluation(str, format, format2, 0, 1);
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract T j0(Format format, @Nullable CryptoConfig cryptoConfig) throws DecoderException;

    /* access modifiers changed from: protected */
    @ForOverride
    @Nullable
    public int[] n0(T t) {
        return null;
    }

    /* access modifiers changed from: protected */
    @ForOverride
    public abstract Format o0(T t);

    /* access modifiers changed from: protected */
    public final int p0(Format format) {
        return this.l3.D(format);
    }

    public PlaybackParameters r() {
        return this.l3.r();
    }

    /* access modifiers changed from: protected */
    @ForOverride
    @CallSuper
    public void s0() {
        this.B3 = true;
    }

    public long u() {
        if (getState() == 2) {
            B0();
        }
        return this.A3;
    }

    public boolean x() {
        boolean z = this.H3;
        this.H3 = false;
        return z;
    }

    public void z(int i2, @Nullable Object obj) throws ExoPlaybackException {
        if (i2 == 2) {
            this.l3.g(((Float) obj).floatValue());
        } else if (i2 == 3) {
            this.l3.k((AudioAttributes) obj);
        } else if (i2 == 6) {
            this.l3.t((AuxEffectInfo) obj);
        } else if (i2 != 12) {
            if (i2 == 9) {
                this.l3.s(((Boolean) obj).booleanValue());
            } else if (i2 != 10) {
                super.z(i2, obj);
            } else {
                this.l3.e(((Integer) obj).intValue());
            }
        } else if (Util.f9646a >= 23) {
            Api23.a(this.l3, obj);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean z0(Format format) {
        return this.l3.b(format);
    }

    public DecoderAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, (AudioSink) new DefaultAudioSink.Builder().j((AudioCapabilities) MoreObjects.a(audioCapabilities, AudioCapabilities.f10743e)).m(audioProcessorArr).i());
    }

    public DecoderAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(1);
        this.k3 = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        this.l3 = audioSink;
        audioSink.v(new AudioSinkListener());
        this.m3 = DecoderInputBuffer.v();
        this.x3 = 0;
        this.z3 = true;
        x0(C.f9084b);
        this.F3 = new long[10];
    }

    public DecoderAudioRenderer(@Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioProcessor... audioProcessorArr) {
        this(handler, audioRendererEventListener, (AudioCapabilities) null, audioProcessorArr);
    }
}
