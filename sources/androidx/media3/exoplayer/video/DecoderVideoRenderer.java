package androidx.media3.exoplayer.video;

import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.VideoSize;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.decoder.Decoder;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.audio.SilenceSkippingAudioProcessor;
import androidx.media3.exoplayer.drm.C0295i;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.source.MediaSource;
import androidx.media3.exoplayer.video.VideoRendererEventListener;

@UnstableApi
public abstract class DecoderVideoRenderer extends BaseRenderer {
    private static final String R3 = "DecoderVideoRenderer";
    private static final int S3 = 0;
    private static final int T3 = 1;
    private static final int U3 = 2;
    @Nullable
    private DrmSession A3;
    private int B3;
    private boolean C3;
    private int D3;
    private long E3;
    private long F3 = C.f9084b;
    private boolean G3;
    private boolean H3;
    private boolean I3;
    @Nullable
    private VideoSize J3;
    private long K3;
    private int L3;
    private int M3;
    private int N3;
    private long O3;
    private long P3;
    protected DecoderCounters Q3;
    private final long k3;
    private final int l3;
    private final VideoRendererEventListener.EventDispatcher m3;
    private final TimedValueQueue<Format> n3 = new TimedValueQueue<>();
    private final DecoderInputBuffer o3 = DecoderInputBuffer.v();
    @Nullable
    private Format p3;
    @Nullable
    private Format q3;
    @Nullable
    private Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> r3;
    @Nullable
    private DecoderInputBuffer s3;
    @Nullable
    private VideoDecoderOutputBuffer t3;
    private int u3;
    @Nullable
    private Object v3;
    @Nullable
    private Surface w3;
    @Nullable
    private VideoDecoderOutputBufferRenderer x3;
    @Nullable
    private VideoFrameMetadataListener y3;
    @Nullable
    private DrmSession z3;

    protected DecoderVideoRenderer(long j2, @Nullable Handler handler, @Nullable VideoRendererEventListener videoRendererEventListener, int i2) {
        super(2);
        this.k3 = j2;
        this.l3 = i2;
        this.m3 = new VideoRendererEventListener.EventDispatcher(handler, videoRendererEventListener);
        this.B3 = 0;
        this.u3 = -1;
        this.D3 = 0;
        this.Q3 = new DecoderCounters();
    }

    private void A0() {
        w0();
        v0();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0084, code lost:
        if (r3 < 30000) goto L_0x004f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean D0(long r11, long r13) throws androidx.media3.exoplayer.ExoPlaybackException, androidx.media3.decoder.DecoderException {
        /*
            r10 = this;
            long r0 = r10.E3
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x000d
            r10.E3 = r11
        L_0x000d:
            androidx.media3.decoder.VideoDecoderOutputBuffer r0 = r10.t3
            java.lang.Object r0 = androidx.media3.common.util.Assertions.g(r0)
            androidx.media3.decoder.VideoDecoderOutputBuffer r0 = (androidx.media3.decoder.VideoDecoderOutputBuffer) r0
            long r1 = r0.X
            long r3 = r1 - r11
            boolean r5 = r10.m0()
            r6 = 0
            r7 = 1
            if (r5 != 0) goto L_0x002c
            boolean r11 = n0(r3)
            if (r11 == 0) goto L_0x002b
            r10.Q0(r0)
            return r7
        L_0x002b:
            return r6
        L_0x002c:
            androidx.media3.common.util.TimedValueQueue<androidx.media3.common.Format> r5 = r10.n3
            java.lang.Object r5 = r5.j(r1)
            androidx.media3.common.Format r5 = (androidx.media3.common.Format) r5
            if (r5 == 0) goto L_0x0039
        L_0x0036:
            r10.q3 = r5
            goto L_0x0046
        L_0x0039:
            androidx.media3.common.Format r5 = r10.q3
            if (r5 != 0) goto L_0x0046
            androidx.media3.common.util.TimedValueQueue<androidx.media3.common.Format> r5 = r10.n3
            java.lang.Object r5 = r5.i()
            androidx.media3.common.Format r5 = (androidx.media3.common.Format) r5
            goto L_0x0036
        L_0x0046:
            long r8 = r10.P3
            long r1 = r1 - r8
            boolean r5 = r10.O0(r3)
            if (r5 == 0) goto L_0x005b
        L_0x004f:
            androidx.media3.common.Format r11 = r10.q3
            java.lang.Object r11 = androidx.media3.common.util.Assertions.g(r11)
            androidx.media3.common.Format r11 = (androidx.media3.common.Format) r11
            r10.F0(r0, r1, r11)
            return r7
        L_0x005b:
            int r5 = r10.getState()
            r8 = 2
            if (r5 != r8) goto L_0x0087
            long r8 = r10.E3
            int r5 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r5 != 0) goto L_0x0069
            goto L_0x0087
        L_0x0069:
            boolean r5 = r10.M0(r3, r13)
            if (r5 == 0) goto L_0x0076
            boolean r11 = r10.q0(r11)
            if (r11 == 0) goto L_0x0076
            return r6
        L_0x0076:
            boolean r11 = r10.N0(r3, r13)
            if (r11 == 0) goto L_0x0080
            r10.j0(r0)
            return r7
        L_0x0080:
            r11 = 30000(0x7530, double:1.4822E-319)
            int r13 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r13 >= 0) goto L_0x0087
            goto L_0x004f
        L_0x0087:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.DecoderVideoRenderer.D0(long, long):boolean");
    }

    private void H0(@Nullable DrmSession drmSession) {
        C0295i.b(this.z3, drmSession);
        this.z3 = drmSession;
    }

    private void J0() {
        this.F3 = this.k3 > 0 ? SystemClock.elapsedRealtime() + this.k3 : C.f9084b;
    }

    private void L0(@Nullable DrmSession drmSession) {
        C0295i.b(this.A3, drmSession);
        this.A3 = drmSession;
    }

    private boolean O0(long j2) {
        boolean z = getState() == 2;
        int i2 = this.D3;
        if (i2 == 0) {
            return z;
        }
        if (i2 == 1) {
            return true;
        }
        if (i2 == 3) {
            return z && P0(j2, Util.I1(SystemClock.elapsedRealtime()) - this.O3);
        }
        throw new IllegalStateException();
    }

    private boolean i0(long j2, long j3) throws ExoPlaybackException, DecoderException {
        if (this.t3 == null) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) ((Decoder) Assertions.g(this.r3)).b();
            this.t3 = videoDecoderOutputBuffer;
            if (videoDecoderOutputBuffer == null) {
                return false;
            }
            DecoderCounters decoderCounters = this.Q3;
            int i2 = decoderCounters.f10103f;
            int i3 = videoDecoderOutputBuffer.Y;
            decoderCounters.f10103f = i2 + i3;
            this.N3 -= i3;
        }
        if (this.t3.l()) {
            if (this.B3 == 2) {
                E0();
                r0();
            } else {
                this.t3.q();
                this.t3 = null;
                this.I3 = true;
            }
            return false;
        }
        boolean D0 = D0(j2, j3);
        if (D0) {
            B0(((VideoDecoderOutputBuffer) Assertions.g(this.t3)).X);
            this.t3 = null;
        }
        return D0;
    }

    private boolean k0() throws DecoderException, ExoPlaybackException {
        Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder = this.r3;
        if (decoder == null || this.B3 == 2 || this.H3) {
            return false;
        }
        if (this.s3 == null) {
            DecoderInputBuffer f2 = decoder.f();
            this.s3 = f2;
            if (f2 == null) {
                return false;
            }
        }
        DecoderInputBuffer decoderInputBuffer = (DecoderInputBuffer) Assertions.g(this.s3);
        if (this.B3 == 1) {
            decoderInputBuffer.p(4);
            ((Decoder) Assertions.g(this.r3)).c(decoderInputBuffer);
            this.s3 = null;
            this.B3 = 2;
            return false;
        }
        FormatHolder L = L();
        int d0 = d0(L, decoderInputBuffer, 0);
        if (d0 == -5) {
            x0(L);
            return true;
        } else if (d0 != -4) {
            if (d0 == -3) {
                return false;
            }
            throw new IllegalStateException();
        } else if (decoderInputBuffer.l()) {
            this.H3 = true;
            ((Decoder) Assertions.g(this.r3)).c(decoderInputBuffer);
            this.s3 = null;
            return false;
        } else {
            if (this.G3) {
                this.n3.a(decoderInputBuffer.Y2, (Format) Assertions.g(this.p3));
                this.G3 = false;
            }
            if (decoderInputBuffer.Y2 < N()) {
                decoderInputBuffer.f(Integer.MIN_VALUE);
            }
            decoderInputBuffer.s();
            decoderInputBuffer.X = this.p3;
            C0(decoderInputBuffer);
            ((Decoder) Assertions.g(this.r3)).c(decoderInputBuffer);
            this.N3++;
            this.C3 = true;
            this.Q3.f10100c++;
            this.s3 = null;
            return true;
        }
    }

    private boolean m0() {
        return this.u3 != -1;
    }

    private static boolean n0(long j2) {
        return j2 < -30000;
    }

    private static boolean o0(long j2) {
        return j2 < -500000;
    }

    private void p0(int i2) {
        this.D3 = Math.min(this.D3, i2);
    }

    private void r0() throws ExoPlaybackException {
        CryptoConfig cryptoConfig;
        if (this.r3 == null) {
            H0(this.A3);
            DrmSession drmSession = this.z3;
            if (drmSession != null) {
                cryptoConfig = drmSession.m();
                if (cryptoConfig == null && this.z3.e() == null) {
                    return;
                }
            } else {
                cryptoConfig = null;
            }
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> h0 = h0((Format) Assertions.g(this.p3), cryptoConfig);
                this.r3 = h0;
                h0.d(N());
                I0(this.u3);
                long elapsedRealtime2 = SystemClock.elapsedRealtime();
                this.m3.k(((Decoder) Assertions.g(this.r3)).getName(), elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                this.Q3.f10098a++;
            } catch (DecoderException e2) {
                Log.e(R3, "Video codec error", e2);
                this.m3.C(e2);
                throw H(e2, this.p3, PlaybackException.n3);
            } catch (OutOfMemoryError e3) {
                throw H(e3, this.p3, PlaybackException.n3);
            }
        }
    }

    private void s0() {
        if (this.L3 > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.m3.n(this.L3, elapsedRealtime - this.K3);
            this.L3 = 0;
            this.K3 = elapsedRealtime;
        }
    }

    private void t0() {
        if (this.D3 != 3) {
            this.D3 = 3;
            Object obj = this.v3;
            if (obj != null) {
                this.m3.A(obj);
            }
        }
    }

    private void u0(int i2, int i3) {
        VideoSize videoSize = this.J3;
        if (videoSize == null || videoSize.s != i2 || videoSize.X != i3) {
            VideoSize videoSize2 = new VideoSize(i2, i3);
            this.J3 = videoSize2;
            this.m3.D(videoSize2);
        }
    }

    private void v0() {
        Object obj;
        if (this.D3 == 3 && (obj = this.v3) != null) {
            this.m3.A(obj);
        }
    }

    private void w0() {
        VideoSize videoSize = this.J3;
        if (videoSize != null) {
            this.m3.D(videoSize);
        }
    }

    private void y0() {
        w0();
        p0(1);
        if (getState() == 2) {
            J0();
        }
    }

    private void z0() {
        this.J3 = null;
        p0(1);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void B0(long j2) {
        this.N3--;
    }

    /* access modifiers changed from: protected */
    public void C0(DecoderInputBuffer decoderInputBuffer) {
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void E0() {
        this.s3 = null;
        this.t3 = null;
        this.B3 = 0;
        this.C3 = false;
        this.N3 = 0;
        Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder = this.r3;
        if (decoder != null) {
            this.Q3.f10099b++;
            decoder.a();
            this.m3.l(this.r3.getName());
            this.r3 = null;
        }
        H0((DrmSession) null);
    }

    /* access modifiers changed from: protected */
    public void F0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, long j2, Format format) throws DecoderException {
        VideoFrameMetadataListener videoFrameMetadataListener = this.y3;
        if (videoFrameMetadataListener != null) {
            videoFrameMetadataListener.j(j2, J().c(), format, (MediaFormat) null);
        }
        this.O3 = Util.I1(SystemClock.elapsedRealtime());
        int i2 = videoDecoderOutputBuffer.Y2;
        boolean z = i2 == 1 && this.w3 != null;
        boolean z2 = i2 == 0 && this.x3 != null;
        if (z2 || z) {
            u0(videoDecoderOutputBuffer.a3, videoDecoderOutputBuffer.b3);
            if (z2) {
                ((VideoDecoderOutputBufferRenderer) Assertions.g(this.x3)).setOutputBuffer(videoDecoderOutputBuffer);
            } else {
                G0(videoDecoderOutputBuffer, (Surface) Assertions.g(this.w3));
            }
            this.M3 = 0;
            this.Q3.f10102e++;
            t0();
            return;
        }
        j0(videoDecoderOutputBuffer);
    }

    /* access modifiers changed from: protected */
    public abstract void G0(VideoDecoderOutputBuffer videoDecoderOutputBuffer, Surface surface) throws DecoderException;

    /* access modifiers changed from: protected */
    public abstract void I0(int i2);

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void K0(@androidx.annotation.Nullable java.lang.Object r3) {
        /*
            r2 = this;
            boolean r0 = r3 instanceof android.view.Surface
            r1 = 0
            if (r0 == 0) goto L_0x0010
            r0 = r3
            android.view.Surface r0 = (android.view.Surface) r0
            r2.w3 = r0
            r2.x3 = r1
            r0 = 1
        L_0x000d:
            r2.u3 = r0
            goto L_0x0023
        L_0x0010:
            boolean r0 = r3 instanceof androidx.media3.exoplayer.video.VideoDecoderOutputBufferRenderer
            r2.w3 = r1
            if (r0 == 0) goto L_0x001d
            r0 = r3
            androidx.media3.exoplayer.video.VideoDecoderOutputBufferRenderer r0 = (androidx.media3.exoplayer.video.VideoDecoderOutputBufferRenderer) r0
            r2.x3 = r0
            r0 = 0
            goto L_0x000d
        L_0x001d:
            r2.x3 = r1
            r3 = -1
            r2.u3 = r3
            r3 = r1
        L_0x0023:
            java.lang.Object r0 = r2.v3
            if (r0 == r3) goto L_0x003c
            r2.v3 = r3
            if (r3 == 0) goto L_0x0038
            androidx.media3.decoder.Decoder<androidx.media3.decoder.DecoderInputBuffer, ? extends androidx.media3.decoder.VideoDecoderOutputBuffer, ? extends androidx.media3.decoder.DecoderException> r3 = r2.r3
            if (r3 == 0) goto L_0x0034
            int r3 = r2.u3
            r2.I0(r3)
        L_0x0034:
            r2.y0()
            goto L_0x0041
        L_0x0038:
            r2.z0()
            goto L_0x0041
        L_0x003c:
            if (r3 == 0) goto L_0x0041
            r2.A0()
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.video.DecoderVideoRenderer.K0(java.lang.Object):void");
    }

    /* access modifiers changed from: protected */
    public boolean M0(long j2, long j3) {
        return o0(j2);
    }

    /* access modifiers changed from: protected */
    public boolean N0(long j2, long j3) {
        return n0(j2);
    }

    /* access modifiers changed from: protected */
    public boolean P0(long j2, long j3) {
        return n0(j2) && j3 > SilenceSkippingAudioProcessor.A;
    }

    /* access modifiers changed from: protected */
    public void Q0(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.Q3.f10103f++;
        videoDecoderOutputBuffer.q();
    }

    /* access modifiers changed from: protected */
    public void R0(int i2, int i3) {
        DecoderCounters decoderCounters = this.Q3;
        decoderCounters.f10105h += i2;
        int i4 = i2 + i3;
        decoderCounters.f10104g += i4;
        this.L3 += i4;
        int i5 = this.M3 + i4;
        this.M3 = i5;
        decoderCounters.f10106i = Math.max(i5, decoderCounters.f10106i);
        int i6 = this.l3;
        if (i6 > 0 && this.L3 >= i6) {
            s0();
        }
    }

    /* access modifiers changed from: protected */
    public void S() {
        this.p3 = null;
        this.J3 = null;
        p0(0);
        try {
            L0((DrmSession) null);
            E0();
        } finally {
            this.m3.m(this.Q3);
        }
    }

    /* access modifiers changed from: protected */
    public void T(boolean z, boolean z2) throws ExoPlaybackException {
        DecoderCounters decoderCounters = new DecoderCounters();
        this.Q3 = decoderCounters;
        this.m3.o(decoderCounters);
        this.D3 = z2 ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    public void V(long j2, boolean z) throws ExoPlaybackException {
        this.H3 = false;
        this.I3 = false;
        p0(1);
        this.E3 = C.f9084b;
        this.M3 = 0;
        if (this.r3 != null) {
            l0();
        }
        if (z) {
            J0();
        } else {
            this.F3 = C.f9084b;
        }
        this.n3.c();
    }

    /* access modifiers changed from: protected */
    public void Z() {
        this.L3 = 0;
        this.K3 = SystemClock.elapsedRealtime();
        this.O3 = Util.I1(SystemClock.elapsedRealtime());
    }

    /* access modifiers changed from: protected */
    public void a0() {
        this.F3 = C.f9084b;
        s0();
    }

    /* access modifiers changed from: protected */
    public void b0(Format[] formatArr, long j2, long j3, MediaSource.MediaPeriodId mediaPeriodId) throws ExoPlaybackException {
        this.P3 = j3;
        super.b0(formatArr, j2, j3, mediaPeriodId);
    }

    public boolean c() {
        return this.I3;
    }

    public boolean d() {
        if (this.p3 != null && ((R() || this.t3 != null) && (this.D3 == 3 || !m0()))) {
            this.F3 = C.f9084b;
            return true;
        } else if (this.F3 == C.f9084b) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.F3) {
                return true;
            }
            this.F3 = C.f9084b;
            return false;
        }
    }

    public void g(long j2, long j3) throws ExoPlaybackException {
        if (!this.I3) {
            if (this.p3 == null) {
                FormatHolder L = L();
                this.o3.g();
                int d0 = d0(L, this.o3, 2);
                if (d0 == -5) {
                    x0(L);
                } else if (d0 == -4) {
                    Assertions.i(this.o3.l());
                    this.H3 = true;
                    this.I3 = true;
                    return;
                } else {
                    return;
                }
            }
            r0();
            if (this.r3 != null) {
                try {
                    TraceUtil.a("drainAndFeed");
                    while (i0(j2, j3)) {
                    }
                    while (k0()) {
                    }
                    TraceUtil.c();
                    this.Q3.c();
                } catch (DecoderException e2) {
                    Log.e(R3, "Video codec error", e2);
                    this.m3.C(e2);
                    throw H(e2, this.p3, PlaybackException.p3);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation g0(String str, Format format, Format format2) {
        return new DecoderReuseEvaluation(str, format, format2, 0, 1);
    }

    /* access modifiers changed from: protected */
    public abstract Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> h0(Format format, @Nullable CryptoConfig cryptoConfig) throws DecoderException;

    /* access modifiers changed from: protected */
    public void j0(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        R0(0, 1);
        videoDecoderOutputBuffer.q();
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void l0() throws ExoPlaybackException {
        this.N3 = 0;
        if (this.B3 != 0) {
            E0();
            r0();
            return;
        }
        this.s3 = null;
        VideoDecoderOutputBuffer videoDecoderOutputBuffer = this.t3;
        if (videoDecoderOutputBuffer != null) {
            videoDecoderOutputBuffer.q();
            this.t3 = null;
        }
        Decoder decoder = (Decoder) Assertions.g(this.r3);
        decoder.flush();
        decoder.d(N());
        this.C3 = false;
    }

    public void p() {
        if (this.D3 == 0) {
            this.D3 = 1;
        }
    }

    /* access modifiers changed from: protected */
    public boolean q0(long j2) throws ExoPlaybackException {
        int f0 = f0(j2);
        if (f0 == 0) {
            return false;
        }
        this.Q3.f10107j++;
        R0(f0, this.N3);
        l0();
        return true;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void x0(FormatHolder formatHolder) throws ExoPlaybackException {
        this.G3 = true;
        Format format = (Format) Assertions.g(formatHolder.f10226b);
        L0(formatHolder.f10225a);
        Format format2 = this.p3;
        this.p3 = format;
        Decoder<DecoderInputBuffer, ? extends VideoDecoderOutputBuffer, ? extends DecoderException> decoder = this.r3;
        if (decoder == null) {
            r0();
            this.m3.p((Format) Assertions.g(this.p3), (DecoderReuseEvaluation) null);
            return;
        }
        DecoderReuseEvaluation decoderReuseEvaluation = this.A3 != this.z3 ? new DecoderReuseEvaluation(decoder.getName(), (Format) Assertions.g(format2), format, 0, 128) : g0(decoder.getName(), (Format) Assertions.g(format2), format);
        if (decoderReuseEvaluation.f10122d == 0) {
            if (this.C3) {
                this.B3 = 1;
            } else {
                E0();
                r0();
            }
        }
        this.m3.p((Format) Assertions.g(this.p3), decoderReuseEvaluation);
    }

    public void z(int i2, @Nullable Object obj) throws ExoPlaybackException {
        if (i2 == 1) {
            K0(obj);
        } else if (i2 == 7) {
            this.y3 = (VideoFrameMetadataListener) obj;
        } else {
            super.z(i2, obj);
        }
    }
}
