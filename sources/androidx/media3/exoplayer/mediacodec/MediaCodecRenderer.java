package androidx.media3.exoplayer.mediacodec;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.media.metrics.LogSessionId;
import android.os.Bundle;
import androidx.annotation.CallSuper;
import androidx.annotation.CheckResult;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.C;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.TimedValueQueue;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.container.NalUnitUtil;
import androidx.media3.decoder.CryptoConfig;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.BaseRenderer;
import androidx.media3.exoplayer.DecoderCounters;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.analytics.PlayerId;
import androidx.media3.exoplayer.audio.OggOpusAudioPacketizer;
import androidx.media3.exoplayer.drm.C0295i;
import androidx.media3.exoplayer.drm.DrmSession;
import androidx.media3.exoplayer.drm.FrameworkCryptoConfig;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import com.google.common.base.Ascii;
import com.itextpdf.text.DocWriter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.List;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@UnstableApi
public abstract class MediaCodecRenderer extends BaseRenderer {
    private static final long A4 = 1000;
    private static final int B4 = 0;
    private static final int C4 = 1;
    private static final int D4 = 2;
    private static final int E4 = 0;
    private static final int F4 = 1;
    private static final int G4 = 2;
    private static final int H4 = 0;
    private static final int I4 = 1;
    private static final int J4 = 2;
    private static final int K4 = 3;
    private static final int L4 = 0;
    private static final int M4 = 1;
    private static final int N4 = 2;
    private static final byte[] O4 = {0, 0, 1, 103, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, 15, 19, 32, 0, 0, 1, 101, -120, -124, 13, -50, 113, Ascii.B, -96, 0, DocWriter.g3, -65, Ascii.F, 49, -61, 39, 93, 120};
    private static final int P4 = 32;
    protected static final float y4 = -1.0f;
    private static final String z4 = "MediaCodecRenderer";
    private boolean A3;
    private long B3;
    private float C3;
    private float D3;
    @Nullable
    private MediaCodecAdapter E3;
    @Nullable
    private Format F3;
    @Nullable
    private MediaFormat G3;
    private boolean H3;
    private float I3;
    @Nullable
    private ArrayDeque<MediaCodecInfo> J3;
    @Nullable
    private DecoderInitializationException K3;
    @Nullable
    private MediaCodecInfo L3;
    private int M3;
    private boolean N3;
    private boolean O3;
    private boolean P3;
    private boolean Q3;
    private boolean R3;
    private boolean S3;
    private boolean T3;
    private boolean U3;
    private boolean V3;
    private boolean W3;
    private long X3;
    private int Y3;
    private int Z3;
    @Nullable
    private ByteBuffer a4;
    private boolean b4;
    private boolean c4;
    private boolean d4;
    private boolean e4;
    private boolean f4;
    private boolean g4;
    private int h4;
    private int i4;
    private int j4;
    private final MediaCodecAdapter.Factory k3;
    private boolean k4;
    private final MediaCodecSelector l3;
    private boolean l4;
    private final boolean m3;
    private boolean m4;
    private final float n3;
    private long n4;
    private final DecoderInputBuffer o3 = DecoderInputBuffer.v();
    private long o4;
    private final DecoderInputBuffer p3 = new DecoderInputBuffer(0);
    private boolean p4;
    private final DecoderInputBuffer q3 = new DecoderInputBuffer(2);
    private boolean q4;
    private final BatchBuffer r3;
    private boolean r4;
    private final MediaCodec.BufferInfo s3;
    private boolean s4;
    private final ArrayDeque<OutputStreamInfo> t3;
    @Nullable
    private ExoPlaybackException t4;
    private final OggOpusAudioPacketizer u3;
    protected DecoderCounters u4;
    @Nullable
    private Format v3;
    private OutputStreamInfo v4;
    @Nullable
    private Format w3;
    private long w4;
    @Nullable
    private DrmSession x3;
    private boolean x4;
    @Nullable
    private DrmSession y3;
    @Nullable
    private MediaCrypto z3;

    @RequiresApi(31)
    private static final class Api31 {
        private Api31() {
        }

        @DoNotInline
        public static void a(MediaCodecAdapter.Configuration configuration, PlayerId playerId) {
            LogSessionId a2 = playerId.a();
            if (!a2.equals(LogSessionId.LOG_SESSION_ID_NONE)) {
                configuration.f11685b.setString("log-session-id", a2.getStringId());
            }
        }
    }

    public static class DecoderInitializationException extends Exception {
        private static final int Y2 = -50000;
        private static final int Z2 = -49999;
        private static final int a3 = -49998;
        public final boolean X;
        @Nullable
        public final DecoderInitializationException X2;
        @Nullable
        public final MediaCodecInfo Y;
        @Nullable
        public final String Z;
        @Nullable
        public final String s;

        public DecoderInitializationException(Format format, @Nullable Throwable th, boolean z, int i2) {
            this("Decoder init failed: [" + i2 + "], " + format, th, format.f3, z, (MediaCodecInfo) null, b(i2), (DecoderInitializationException) null);
        }

        private static String b(int i2) {
            String str = i2 < 0 ? "neg_" : "";
            return "androidx.media3.exoplayer.mediacodec" + ".MediaCodecRenderer_" + str + Math.abs(i2);
        }

        /* access modifiers changed from: private */
        @CheckResult
        public DecoderInitializationException c(DecoderInitializationException decoderInitializationException) {
            return new DecoderInitializationException(getMessage(), getCause(), this.s, this.X, this.Y, this.Z, decoderInitializationException);
        }

        @RequiresApi(21)
        @Nullable
        private static String d(@Nullable Throwable th) {
            if (th instanceof MediaCodec.CodecException) {
                return ((MediaCodec.CodecException) th).getDiagnosticInfo();
            }
            return null;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public DecoderInitializationException(Format format, @Nullable Throwable th, boolean z, MediaCodecInfo mediaCodecInfo) {
            this("Decoder init failed: " + mediaCodecInfo.f11693a + ", " + format, th, format.f3, z, mediaCodecInfo, Util.f9646a >= 21 ? d(th) : null, (DecoderInitializationException) null);
        }

        private DecoderInitializationException(@Nullable String str, @Nullable Throwable th, @Nullable String str2, boolean z, @Nullable MediaCodecInfo mediaCodecInfo, @Nullable String str3, @Nullable DecoderInitializationException decoderInitializationException) {
            super(str, th);
            this.s = str2;
            this.X = z;
            this.Y = mediaCodecInfo;
            this.Z = str3;
            this.X2 = decoderInitializationException;
        }
    }

    private static final class OutputStreamInfo {

        /* renamed from: e  reason: collision with root package name */
        public static final OutputStreamInfo f11708e = new OutputStreamInfo(C.f9084b, C.f9084b, C.f9084b);

        /* renamed from: a  reason: collision with root package name */
        public final long f11709a;

        /* renamed from: b  reason: collision with root package name */
        public final long f11710b;

        /* renamed from: c  reason: collision with root package name */
        public final long f11711c;

        /* renamed from: d  reason: collision with root package name */
        public final TimedValueQueue<Format> f11712d = new TimedValueQueue<>();

        public OutputStreamInfo(long j2, long j3, long j4) {
            this.f11709a = j2;
            this.f11710b = j3;
            this.f11711c = j4;
        }
    }

    public MediaCodecRenderer(int i2, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, boolean z, float f2) {
        super(i2);
        this.k3 = factory;
        this.l3 = (MediaCodecSelector) Assertions.g(mediaCodecSelector);
        this.m3 = z;
        this.n3 = f2;
        BatchBuffer batchBuffer = new BatchBuffer();
        this.r3 = batchBuffer;
        this.s3 = new MediaCodec.BufferInfo();
        this.C3 = 1.0f;
        this.D3 = 1.0f;
        this.B3 = C.f9084b;
        this.t3 = new ArrayDeque<>();
        this.v4 = OutputStreamInfo.f11708e;
        batchBuffer.r(0);
        batchBuffer.Z.order(ByteOrder.nativeOrder());
        this.u3 = new OggOpusAudioPacketizer();
        this.I3 = y4;
        this.M3 = 0;
        this.h4 = 0;
        this.Y3 = -1;
        this.Z3 = -1;
        this.X3 = C.f9084b;
        this.n4 = C.f9084b;
        this.o4 = C.f9084b;
        this.w4 = C.f9084b;
        this.i4 = 0;
        this.j4 = 0;
        this.u4 = new DecoderCounters();
    }

    private void A0() {
        try {
            ((MediaCodecAdapter) Assertions.k(this.E3)).flush();
        } finally {
            v1();
        }
    }

    private void A1(OutputStreamInfo outputStreamInfo) {
        this.v4 = outputStreamInfo;
        long j2 = outputStreamInfo.f11711c;
        if (j2 != C.f9084b) {
            this.x4 = true;
            j1(j2);
        }
    }

    private List<MediaCodecInfo> D0(boolean z) throws MediaCodecUtil.DecoderQueryException {
        Format format = (Format) Assertions.g(this.v3);
        List<MediaCodecInfo> L0 = L0(this.l3, format, z);
        if (L0.isEmpty() && z) {
            L0 = L0(this.l3, format, false);
            if (!L0.isEmpty()) {
                Log.n(z4, "Drm session requires secure decoder for " + format.f3 + ", but no secure decoder available. Trying to proceed with " + L0 + ".");
            }
        }
        return L0;
    }

    private void E1(@Nullable DrmSession drmSession) {
        C0295i.b(this.y3, drmSession);
        this.y3 = drmSession;
    }

    private boolean F1(long j2) {
        return this.B3 == C.f9084b || J().b() - j2 < this.B3;
    }

    protected static boolean K1(Format format) {
        int i2 = format.B3;
        return i2 == 0 || i2 == 2;
    }

    private boolean M1(@Nullable Format format) throws ExoPlaybackException {
        if (!(Util.f9646a < 23 || this.E3 == null || this.j4 == 3 || getState() == 0)) {
            float J0 = J0(this.D3, (Format) Assertions.g(format), P());
            float f2 = this.I3;
            if (f2 == J0) {
                return true;
            }
            if (J0 == y4) {
                v0();
                return false;
            } else if (f2 == y4 && J0 <= this.n3) {
                return true;
            } else {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", J0);
                ((MediaCodecAdapter) Assertions.g(this.E3)).b(bundle);
                this.I3 = J0;
            }
        }
        return true;
    }

    @RequiresApi(23)
    private void N1() throws ExoPlaybackException {
        CryptoConfig m2 = ((DrmSession) Assertions.g(this.y3)).m();
        if (m2 instanceof FrameworkCryptoConfig) {
            try {
                ((MediaCrypto) Assertions.g(this.z3)).setMediaDrmSession(((FrameworkCryptoConfig) m2).f11332b);
            } catch (MediaCryptoException e2) {
                throw H(e2, this.v3, PlaybackException.C3);
            }
        }
        z1(this.y3);
        this.i4 = 0;
        this.j4 = 0;
    }

    private boolean R0() {
        return this.Z3 >= 0;
    }

    private boolean S0() {
        if (!this.r3.D()) {
            return true;
        }
        long N = N();
        return Y0(N, this.r3.A()) == Y0(N, this.q3.Y2);
    }

    private void T0(Format format) {
        t0();
        String str = format.f3;
        if (MimeTypes.F.equals(str) || MimeTypes.I.equals(str) || MimeTypes.a0.equals(str)) {
            this.r3.E(32);
        } else {
            this.r3.E(1);
        }
        this.d4 = true;
    }

    /* JADX INFO: finally extract failed */
    private void U0(MediaCodecInfo mediaCodecInfo, @Nullable MediaCrypto mediaCrypto) throws Exception {
        boolean z = false;
        Format format = (Format) Assertions.g(this.v3);
        String str = mediaCodecInfo.f11693a;
        int i2 = Util.f9646a;
        float f2 = y4;
        float J0 = i2 < 23 ? y4 : J0(this.D3, format, P());
        if (J0 > this.n3) {
            f2 = J0;
        }
        n1(format);
        long b2 = J().b();
        MediaCodecAdapter.Configuration M0 = M0(mediaCodecInfo, format, mediaCrypto, f2);
        if (i2 >= 31) {
            Api31.a(M0, O());
        }
        try {
            TraceUtil.a("createCodec:" + str);
            this.E3 = this.k3.a(M0);
            TraceUtil.c();
            long b3 = J().b();
            if (!mediaCodecInfo.p(format)) {
                Log.n(z4, Util.S("Format exceeds selected codec's capabilities [%s, %s]", Format.m(format), str));
            }
            this.L3 = mediaCodecInfo;
            this.I3 = f2;
            this.F3 = format;
            this.M3 = j0(str);
            this.N3 = k0(str, (Format) Assertions.g(this.F3));
            this.O3 = p0(str);
            this.P3 = r0(str);
            this.Q3 = m0(str);
            this.R3 = n0(str);
            this.S3 = l0(str);
            this.T3 = q0(str, (Format) Assertions.g(this.F3));
            this.W3 = o0(mediaCodecInfo) || H0();
            if (((MediaCodecAdapter) Assertions.g(this.E3)).f()) {
                this.g4 = true;
                this.h4 = 1;
                if (this.M3 != 0) {
                    z = true;
                }
                this.U3 = z;
            }
            if (getState() == 2) {
                this.X3 = J().b() + 1000;
            }
            this.u4.f10098a++;
            f1(str, M0, b3, b3 - b2);
        } catch (Throwable th) {
            TraceUtil.c();
            throw th;
        }
    }

    @RequiresNonNull({"this.codecDrmSession"})
    private boolean V0() throws ExoPlaybackException {
        boolean z = false;
        Assertions.i(this.z3 == null);
        DrmSession drmSession = this.x3;
        String str = ((Format) Assertions.g(this.v3)).f3;
        CryptoConfig m2 = drmSession.m();
        if (FrameworkCryptoConfig.f11330d && (m2 instanceof FrameworkCryptoConfig)) {
            int state = drmSession.getState();
            if (state == 1) {
                DrmSession.DrmSessionException drmSessionException = (DrmSession.DrmSessionException) Assertions.g(drmSession.e());
                throw H(drmSessionException, this.v3, drmSessionException.s);
            } else if (state != 4) {
                return false;
            }
        }
        if (m2 == null) {
            return drmSession.e() != null;
        }
        if (m2 instanceof FrameworkCryptoConfig) {
            FrameworkCryptoConfig frameworkCryptoConfig = (FrameworkCryptoConfig) m2;
            try {
                MediaCrypto mediaCrypto = new MediaCrypto(frameworkCryptoConfig.f11331a, frameworkCryptoConfig.f11332b);
                this.z3 = mediaCrypto;
                if (!frameworkCryptoConfig.f11333c && mediaCrypto.requiresSecureDecoderComponent((String) Assertions.k(str))) {
                    z = true;
                }
                this.A3 = z;
            } catch (MediaCryptoException e2) {
                throw H(e2, this.v3, PlaybackException.C3);
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r2.w3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean Y0(long r3, long r5) {
        /*
            r2 = this;
            int r0 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x001a
            androidx.media3.common.Format r0 = r2.w3
            if (r0 == 0) goto L_0x0018
            java.lang.String r0 = r0.f3
            java.lang.String r1 = "audio/opus"
            boolean r0 = java.util.Objects.equals(r0, r1)
            if (r0 == 0) goto L_0x0018
            boolean r3 = androidx.media3.extractor.OpusUtil.g(r3, r5)
            if (r3 != 0) goto L_0x001a
        L_0x0018:
            r3 = 1
            goto L_0x001b
        L_0x001a:
            r3 = 0
        L_0x001b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.Y0(long, long):boolean");
    }

    private static boolean Z0(IllegalStateException illegalStateException) {
        if (Util.f9646a >= 21 && a1(illegalStateException)) {
            return true;
        }
        StackTraceElement[] stackTrace = illegalStateException.getStackTrace();
        return stackTrace.length > 0 && stackTrace[0].getClassName().equals("android.media.MediaCodec");
    }

    @RequiresApi(21)
    private static boolean a1(IllegalStateException illegalStateException) {
        return illegalStateException instanceof MediaCodec.CodecException;
    }

    @RequiresApi(21)
    private static boolean b1(IllegalStateException illegalStateException) {
        if (illegalStateException instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) illegalStateException).isRecoverable();
        }
        return false;
    }

    private void d1(@Nullable MediaCrypto mediaCrypto, boolean z) throws DecoderInitializationException {
        Format format = (Format) Assertions.g(this.v3);
        if (this.J3 == null) {
            try {
                List<MediaCodecInfo> D0 = D0(z);
                ArrayDeque<MediaCodecInfo> arrayDeque = new ArrayDeque<>();
                this.J3 = arrayDeque;
                if (this.m3) {
                    arrayDeque.addAll(D0);
                } else if (!D0.isEmpty()) {
                    this.J3.add(D0.get(0));
                }
                this.K3 = null;
            } catch (MediaCodecUtil.DecoderQueryException e2) {
                throw new DecoderInitializationException(format, (Throwable) e2, z, -49998);
            }
        }
        if (!this.J3.isEmpty()) {
            ArrayDeque arrayDeque2 = (ArrayDeque) Assertions.g(this.J3);
            MediaCodecInfo mediaCodecInfo = (MediaCodecInfo) arrayDeque2.peekFirst();
            while (this.E3 == null) {
                MediaCodecInfo mediaCodecInfo2 = (MediaCodecInfo) Assertions.g((MediaCodecInfo) arrayDeque2.peekFirst());
                if (G1(mediaCodecInfo2)) {
                    try {
                        U0(mediaCodecInfo2, mediaCrypto);
                    } catch (Exception e3) {
                        if (mediaCodecInfo2 == mediaCodecInfo) {
                            Log.n(z4, "Preferred decoder instantiation failed. Sleeping for 50ms then retrying.");
                            Thread.sleep(50);
                            U0(mediaCodecInfo2, mediaCrypto);
                        } else {
                            throw e3;
                        }
                    } catch (Exception e5) {
                        Log.o(z4, "Failed to initialize decoder: " + mediaCodecInfo2, e5);
                        arrayDeque2.removeFirst();
                        DecoderInitializationException decoderInitializationException = new DecoderInitializationException(format, (Throwable) e5, z, mediaCodecInfo2);
                        e1(decoderInitializationException);
                        DecoderInitializationException decoderInitializationException2 = this.K3;
                        if (decoderInitializationException2 == null) {
                            this.K3 = decoderInitializationException;
                        } else {
                            this.K3 = decoderInitializationException2.c(decoderInitializationException);
                        }
                        if (arrayDeque2.isEmpty()) {
                            throw this.K3;
                        }
                    }
                } else {
                    return;
                }
            }
            this.J3 = null;
            return;
        }
        throw new DecoderInitializationException(format, (Throwable) null, z, -49999);
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00d9 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g0() throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r6 = this;
            boolean r0 = r6.p4
            r1 = 1
            r0 = r0 ^ r1
            androidx.media3.common.util.Assertions.i(r0)
            androidx.media3.exoplayer.FormatHolder r0 = r6.L()
            androidx.media3.decoder.DecoderInputBuffer r2 = r6.q3
            r2.g()
        L_0x0010:
            androidx.media3.decoder.DecoderInputBuffer r2 = r6.q3
            r2.g()
            androidx.media3.decoder.DecoderInputBuffer r2 = r6.q3
            r3 = 0
            int r2 = r6.d0(r0, r2, r3)
            r4 = -5
            if (r2 == r4) goto L_0x00d9
            r4 = -4
            if (r2 == r4) goto L_0x002c
            r0 = -3
            if (r2 != r0) goto L_0x0026
            return
        L_0x0026:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L_0x002c:
            androidx.media3.decoder.DecoderInputBuffer r2 = r6.q3
            boolean r2 = r2.l()
            if (r2 == 0) goto L_0x0037
            r6.p4 = r1
            return
        L_0x0037:
            boolean r2 = r6.r4
            java.lang.String r4 = "audio/opus"
            if (r2 == 0) goto L_0x0085
            androidx.media3.common.Format r2 = r6.v3
            java.lang.Object r2 = androidx.media3.common.util.Assertions.g(r2)
            androidx.media3.common.Format r2 = (androidx.media3.common.Format) r2
            r6.w3 = r2
            java.lang.String r2 = r2.f3
            boolean r2 = java.util.Objects.equals(r2, r4)
            if (r2 == 0) goto L_0x007d
            androidx.media3.common.Format r2 = r6.w3
            java.util.List<byte[]> r2 = r2.h3
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x007d
            androidx.media3.common.Format r2 = r6.w3
            java.util.List<byte[]> r2 = r2.h3
            java.lang.Object r2 = r2.get(r3)
            byte[] r2 = (byte[]) r2
            int r2 = androidx.media3.extractor.OpusUtil.f(r2)
            androidx.media3.common.Format r5 = r6.w3
            java.lang.Object r5 = androidx.media3.common.util.Assertions.g(r5)
            androidx.media3.common.Format r5 = (androidx.media3.common.Format) r5
            androidx.media3.common.Format$Builder r5 = r5.c()
            androidx.media3.common.Format$Builder r2 = r5.S(r2)
            androidx.media3.common.Format r2 = r2.I()
            r6.w3 = r2
        L_0x007d:
            androidx.media3.common.Format r2 = r6.w3
            r5 = 0
            r6.i1(r2, r5)
            r6.r4 = r3
        L_0x0085:
            androidx.media3.decoder.DecoderInputBuffer r2 = r6.q3
            r2.s()
            androidx.media3.common.Format r2 = r6.w3
            if (r2 == 0) goto L_0x00c6
            java.lang.String r2 = r2.f3
            boolean r2 = java.util.Objects.equals(r2, r4)
            if (r2 == 0) goto L_0x00c6
            androidx.media3.decoder.DecoderInputBuffer r2 = r6.q3
            boolean r2 = r2.j()
            if (r2 == 0) goto L_0x00a7
            androidx.media3.decoder.DecoderInputBuffer r2 = r6.q3
            androidx.media3.common.Format r3 = r6.w3
            r2.X = r3
            r6.Q0(r2)
        L_0x00a7:
            long r2 = r6.N()
            androidx.media3.decoder.DecoderInputBuffer r4 = r6.q3
            long r4 = r4.Y2
            boolean r2 = androidx.media3.extractor.OpusUtil.g(r2, r4)
            if (r2 == 0) goto L_0x00c6
            androidx.media3.exoplayer.audio.OggOpusAudioPacketizer r2 = r6.u3
            androidx.media3.decoder.DecoderInputBuffer r3 = r6.q3
            androidx.media3.common.Format r4 = r6.w3
            java.lang.Object r4 = androidx.media3.common.util.Assertions.g(r4)
            androidx.media3.common.Format r4 = (androidx.media3.common.Format) r4
            java.util.List<byte[]> r4 = r4.h3
            r2.a(r3, r4)
        L_0x00c6:
            boolean r2 = r6.S0()
            if (r2 == 0) goto L_0x00d6
            androidx.media3.exoplayer.mediacodec.BatchBuffer r2 = r6.r3
            androidx.media3.decoder.DecoderInputBuffer r3 = r6.q3
            boolean r2 = r2.x(r3)
            if (r2 != 0) goto L_0x0010
        L_0x00d6:
            r6.e4 = r1
            return
        L_0x00d9:
            r6.h1(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.g0():void");
    }

    private boolean h0(long j2, long j3) throws ExoPlaybackException {
        Assertions.i(!this.q4);
        if (this.r3.D()) {
            BatchBuffer batchBuffer = this.r3;
            if (!p1(j2, j3, (MediaCodecAdapter) null, batchBuffer.Z, this.Z3, 0, batchBuffer.C(), this.r3.z(), Y0(N(), this.r3.A()), this.r3.l(), (Format) Assertions.g(this.w3))) {
                return false;
            }
            k1(this.r3.A());
            this.r3.g();
        }
        if (this.p4) {
            this.q4 = true;
            return false;
        }
        if (this.e4) {
            Assertions.i(this.r3.x(this.q3));
            this.e4 = false;
        }
        if (this.f4) {
            if (this.r3.D()) {
                return true;
            }
            t0();
            this.f4 = false;
            c1();
            if (!this.d4) {
                return false;
            }
        }
        g0();
        if (this.r3.D()) {
            this.r3.s();
        }
        return this.r3.D() || this.p4 || this.f4;
    }

    private int j0(String str) {
        int i2 = Util.f9646a;
        if (i2 <= 25 && "OMX.Exynos.avc.dec.secure".equals(str)) {
            String str2 = Util.f9649d;
            if (str2.startsWith("SM-T585") || str2.startsWith("SM-A510") || str2.startsWith("SM-A520") || str2.startsWith("SM-J700")) {
                return 2;
            }
        }
        if (i2 >= 24) {
            return 0;
        }
        if (!"OMX.Nvidia.h264.decode".equals(str) && !"OMX.Nvidia.h264.decode.secure".equals(str)) {
            return 0;
        }
        String str3 = Util.f9647b;
        return ("flounder".equals(str3) || "flounder_lte".equals(str3) || "grouper".equals(str3) || "tilapia".equals(str3)) ? 1 : 0;
    }

    private static boolean k0(String str, Format format) {
        return Util.f9646a < 21 && format.h3.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str);
    }

    private static boolean l0(String str) {
        if (Util.f9646a < 21 && "OMX.SEC.mp3.dec".equals(str) && "samsung".equals(Util.f9648c)) {
            String str2 = Util.f9647b;
            if (str2.startsWith("baffin") || str2.startsWith("grand") || str2.startsWith("fortuna") || str2.startsWith("gprimelte") || str2.startsWith("j2y18lte") || str2.startsWith("ms01")) {
                return true;
            }
        }
        return false;
    }

    private static boolean m0(String str) {
        int i2 = Util.f9646a;
        if (i2 > 23 || !"OMX.google.vorbis.decoder".equals(str)) {
            if (i2 <= 19) {
                String str2 = Util.f9647b;
                if (("hb2000".equals(str2) || "stvm8".equals(str2)) && ("OMX.amlogic.avc.decoder.awesome".equals(str) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str))) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    private static boolean n0(String str) {
        return Util.f9646a == 21 && "OMX.google.aac.decoder".equals(str);
    }

    private static boolean o0(MediaCodecInfo mediaCodecInfo) {
        String str = mediaCodecInfo.f11693a;
        int i2 = Util.f9646a;
        return (i2 <= 25 && "OMX.rk.video_decoder.avc".equals(str)) || (i2 <= 17 && "OMX.allwinner.video.decoder.avc".equals(str)) || ((i2 <= 29 && ("OMX.broadcom.video_decoder.tunnel".equals(str) || "OMX.broadcom.video_decoder.tunnel.secure".equals(str) || "OMX.bcm.vdec.avc.tunnel".equals(str) || "OMX.bcm.vdec.avc.tunnel.secure".equals(str) || "OMX.bcm.vdec.hevc.tunnel".equals(str) || "OMX.bcm.vdec.hevc.tunnel.secure".equals(str))) || ("Amazon".equals(Util.f9648c) && "AFTS".equals(Util.f9649d) && mediaCodecInfo.f11699g));
    }

    @TargetApi(23)
    private void o1() throws ExoPlaybackException {
        int i2 = this.j4;
        if (i2 == 1) {
            A0();
        } else if (i2 == 2) {
            A0();
            N1();
        } else if (i2 != 3) {
            this.q4 = true;
            u1();
        } else {
            s1();
        }
    }

    private static boolean p0(String str) {
        int i2 = Util.f9646a;
        return i2 < 18 || (i2 == 18 && ("OMX.SEC.avc.dec".equals(str) || "OMX.SEC.avc.dec.secure".equals(str))) || (i2 == 19 && Util.f9649d.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str) || "OMX.Exynos.avc.dec.secure".equals(str)));
    }

    private static boolean q0(String str, Format format) {
        return Util.f9646a <= 18 && format.s3 == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str);
    }

    private void q1() {
        this.m4 = true;
        MediaFormat h2 = ((MediaCodecAdapter) Assertions.g(this.E3)).h();
        if (this.M3 != 0 && h2.getInteger("width") == 32 && h2.getInteger("height") == 32) {
            this.V3 = true;
            return;
        }
        if (this.T3) {
            h2.setInteger("channel-count", 1);
        }
        this.G3 = h2;
        this.H3 = true;
    }

    private static boolean r0(String str) {
        return Util.f9646a == 29 && "c2.android.aac.decoder".equals(str);
    }

    private boolean r1(int i2) throws ExoPlaybackException {
        FormatHolder L = L();
        this.o3.g();
        int d0 = d0(L, this.o3, i2 | 4);
        if (d0 == -5) {
            h1(L);
            return true;
        } else if (d0 != -4 || !this.o3.l()) {
            return false;
        } else {
            this.p4 = true;
            o1();
            return false;
        }
    }

    private void s1() throws ExoPlaybackException {
        t1();
        c1();
    }

    private void t0() {
        this.f4 = false;
        this.r3.g();
        this.q3.g();
        this.e4 = false;
        this.d4 = false;
        this.u3.d();
    }

    private boolean u0() {
        if (this.k4) {
            this.i4 = 1;
            if (this.O3 || this.Q3) {
                this.j4 = 3;
                return false;
            }
            this.j4 = 1;
        }
        return true;
    }

    private void v0() throws ExoPlaybackException {
        if (this.k4) {
            this.i4 = 1;
            this.j4 = 3;
            return;
        }
        s1();
    }

    @TargetApi(23)
    private boolean w0() throws ExoPlaybackException {
        if (this.k4) {
            this.i4 = 1;
            if (this.O3 || this.Q3) {
                this.j4 = 3;
                return false;
            }
            this.j4 = 2;
        } else {
            N1();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:74:0x0110  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean x0(long r20, long r22) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r19 = this;
            r15 = r19
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter r0 = r15.E3
            java.lang.Object r0 = androidx.media3.common.util.Assertions.g(r0)
            r5 = r0
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter r5 = (androidx.media3.exoplayer.mediacodec.MediaCodecAdapter) r5
            boolean r0 = r19.R0()
            r16 = 1
            r14 = 0
            if (r0 != 0) goto L_0x00d4
            boolean r0 = r15.R3
            if (r0 == 0) goto L_0x002f
            boolean r0 = r15.l4
            if (r0 == 0) goto L_0x002f
            android.media.MediaCodec$BufferInfo r0 = r15.s3     // Catch:{ IllegalStateException -> 0x0023 }
            int r0 = r5.k(r0)     // Catch:{ IllegalStateException -> 0x0023 }
            goto L_0x0035
        L_0x0023:
            r19.o1()
            boolean r0 = r15.q4
            if (r0 == 0) goto L_0x002e
            r19.t1()
        L_0x002e:
            return r14
        L_0x002f:
            android.media.MediaCodec$BufferInfo r0 = r15.s3
            int r0 = r5.k(r0)
        L_0x0035:
            if (r0 >= 0) goto L_0x004f
            r1 = -2
            if (r0 != r1) goto L_0x003e
            r19.q1()
            return r16
        L_0x003e:
            boolean r0 = r15.W3
            if (r0 == 0) goto L_0x004e
            boolean r0 = r15.p4
            if (r0 != 0) goto L_0x004b
            int r0 = r15.i4
            r1 = 2
            if (r0 != r1) goto L_0x004e
        L_0x004b:
            r19.o1()
        L_0x004e:
            return r14
        L_0x004f:
            boolean r1 = r15.V3
            if (r1 == 0) goto L_0x0059
            r15.V3 = r14
            r5.m(r0, r14)
            return r16
        L_0x0059:
            android.media.MediaCodec$BufferInfo r1 = r15.s3
            int r2 = r1.size
            if (r2 != 0) goto L_0x0069
            int r1 = r1.flags
            r1 = r1 & 4
            if (r1 == 0) goto L_0x0069
            r19.o1()
            return r14
        L_0x0069:
            r15.Z3 = r0
            java.nio.ByteBuffer r0 = r5.p(r0)
            r15.a4 = r0
            if (r0 == 0) goto L_0x0086
            android.media.MediaCodec$BufferInfo r1 = r15.s3
            int r1 = r1.offset
            r0.position(r1)
            java.nio.ByteBuffer r0 = r15.a4
            android.media.MediaCodec$BufferInfo r1 = r15.s3
            int r2 = r1.offset
            int r1 = r1.size
            int r2 = r2 + r1
            r0.limit(r2)
        L_0x0086:
            boolean r0 = r15.S3
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r0 == 0) goto L_0x00a9
            android.media.MediaCodec$BufferInfo r0 = r15.s3
            long r3 = r0.presentationTimeUs
            r6 = 0
            int r8 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x00a9
            int r3 = r0.flags
            r3 = r3 & 4
            if (r3 == 0) goto L_0x00a9
            long r3 = r15.n4
            int r6 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r6 == 0) goto L_0x00a9
            long r3 = r15.o4
            r0.presentationTimeUs = r3
        L_0x00a9:
            android.media.MediaCodec$BufferInfo r0 = r15.s3
            long r3 = r0.presentationTimeUs
            long r6 = r19.N()
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x00b7
            r0 = 1
            goto L_0x00b8
        L_0x00b7:
            r0 = 0
        L_0x00b8:
            r15.b4 = r0
            long r3 = r15.o4
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x00ca
            android.media.MediaCodec$BufferInfo r0 = r15.s3
            long r0 = r0.presentationTimeUs
            int r2 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ca
            r0 = 1
            goto L_0x00cb
        L_0x00ca:
            r0 = 0
        L_0x00cb:
            r15.c4 = r0
            android.media.MediaCodec$BufferInfo r0 = r15.s3
            long r0 = r0.presentationTimeUs
            r15.O1(r0)
        L_0x00d4:
            boolean r0 = r15.R3
            if (r0 == 0) goto L_0x0114
            boolean r0 = r15.l4
            if (r0 == 0) goto L_0x0114
            java.nio.ByteBuffer r6 = r15.a4     // Catch:{ IllegalStateException -> 0x0106 }
            int r7 = r15.Z3     // Catch:{ IllegalStateException -> 0x0106 }
            android.media.MediaCodec$BufferInfo r0 = r15.s3     // Catch:{ IllegalStateException -> 0x0106 }
            int r8 = r0.flags     // Catch:{ IllegalStateException -> 0x0106 }
            long r10 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0106 }
            boolean r12 = r15.b4     // Catch:{ IllegalStateException -> 0x0106 }
            boolean r13 = r15.c4     // Catch:{ IllegalStateException -> 0x0106 }
            androidx.media3.common.Format r0 = r15.w3     // Catch:{ IllegalStateException -> 0x0106 }
            java.lang.Object r0 = androidx.media3.common.util.Assertions.g(r0)     // Catch:{ IllegalStateException -> 0x0106 }
            r17 = r0
            androidx.media3.common.Format r17 = (androidx.media3.common.Format) r17     // Catch:{ IllegalStateException -> 0x0106 }
            r9 = 1
            r0 = r19
            r1 = r20
            r3 = r22
            r18 = 0
            r14 = r17
            boolean r0 = r0.p1(r1, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14)     // Catch:{ IllegalStateException -> 0x0104 }
            goto L_0x0138
        L_0x0104:
            goto L_0x0109
        L_0x0106:
            r18 = 0
            goto L_0x0104
        L_0x0109:
            r19.o1()
            boolean r0 = r15.q4
            if (r0 == 0) goto L_0x0113
            r19.t1()
        L_0x0113:
            return r18
        L_0x0114:
            r18 = 0
            java.nio.ByteBuffer r6 = r15.a4
            int r7 = r15.Z3
            android.media.MediaCodec$BufferInfo r0 = r15.s3
            int r8 = r0.flags
            long r10 = r0.presentationTimeUs
            boolean r12 = r15.b4
            boolean r13 = r15.c4
            androidx.media3.common.Format r0 = r15.w3
            java.lang.Object r0 = androidx.media3.common.util.Assertions.g(r0)
            r14 = r0
            androidx.media3.common.Format r14 = (androidx.media3.common.Format) r14
            r9 = 1
            r0 = r19
            r1 = r20
            r3 = r22
            boolean r0 = r0.p1(r1, r3, r5, r6, r7, r8, r9, r10, r12, r13, r14)
        L_0x0138:
            if (r0 == 0) goto L_0x0155
            android.media.MediaCodec$BufferInfo r0 = r15.s3
            long r0 = r0.presentationTimeUs
            r15.k1(r0)
            android.media.MediaCodec$BufferInfo r0 = r15.s3
            int r0 = r0.flags
            r0 = r0 & 4
            if (r0 == 0) goto L_0x014b
            r14 = 1
            goto L_0x014c
        L_0x014b:
            r14 = 0
        L_0x014c:
            r19.y1()
            if (r14 != 0) goto L_0x0152
            return r16
        L_0x0152:
            r19.o1()
        L_0x0155:
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.x0(long, long):boolean");
    }

    private void x1() {
        this.Y3 = -1;
        this.p3.Z = null;
    }

    private boolean y0(MediaCodecInfo mediaCodecInfo, Format format, @Nullable DrmSession drmSession, @Nullable DrmSession drmSession2) throws ExoPlaybackException {
        CryptoConfig m2;
        CryptoConfig m5;
        if (drmSession == drmSession2) {
            return false;
        }
        if (!(drmSession2 == null || drmSession == null || (m2 = drmSession2.m()) == null || (m5 = drmSession.m()) == null || !m2.getClass().equals(m5.getClass()))) {
            if (!(m2 instanceof FrameworkCryptoConfig)) {
                return false;
            }
            FrameworkCryptoConfig frameworkCryptoConfig = (FrameworkCryptoConfig) m2;
            if (!drmSession2.g().equals(drmSession.g()) || Util.f9646a < 23) {
                return true;
            }
            UUID uuid = C.l2;
            if (!uuid.equals(drmSession.g()) && !uuid.equals(drmSession2.g())) {
                return !mediaCodecInfo.f11699g && (frameworkCryptoConfig.f11333c ? false : drmSession2.l((String) Assertions.g(format.f3)));
            }
        }
        return true;
    }

    private void y1() {
        this.Z3 = -1;
        this.a4 = null;
    }

    private boolean z0() throws ExoPlaybackException {
        int i2;
        if (this.E3 == null || (i2 = this.i4) == 2 || this.p4) {
            return false;
        }
        if (i2 == 0 && H1()) {
            v0();
        }
        MediaCodecAdapter mediaCodecAdapter = (MediaCodecAdapter) Assertions.g(this.E3);
        if (this.Y3 < 0) {
            int j2 = mediaCodecAdapter.j();
            this.Y3 = j2;
            if (j2 < 0) {
                return false;
            }
            this.p3.Z = mediaCodecAdapter.n(j2);
            this.p3.g();
        }
        if (this.i4 == 1) {
            if (!this.W3) {
                this.l4 = true;
                mediaCodecAdapter.d(this.Y3, 0, 0, 0, 4);
                x1();
            }
            this.i4 = 2;
            return false;
        } else if (this.U3) {
            this.U3 = false;
            byte[] bArr = O4;
            ((ByteBuffer) Assertions.g(this.p3.Z)).put(bArr);
            mediaCodecAdapter.d(this.Y3, 0, bArr.length, 0, 0);
            x1();
            this.k4 = true;
            return true;
        } else {
            if (this.h4 == 1) {
                for (int i3 = 0; i3 < ((Format) Assertions.g(this.F3)).h3.size(); i3++) {
                    ((ByteBuffer) Assertions.g(this.p3.Z)).put(this.F3.h3.get(i3));
                }
                this.h4 = 2;
            }
            int position = ((ByteBuffer) Assertions.g(this.p3.Z)).position();
            FormatHolder L = L();
            try {
                int d0 = d0(L, this.p3, 0);
                if (d0 == -3) {
                    if (l()) {
                        this.o4 = this.n4;
                    }
                    return false;
                } else if (d0 == -5) {
                    if (this.h4 == 2) {
                        this.p3.g();
                        this.h4 = 1;
                    }
                    h1(L);
                    return true;
                } else if (this.p3.l()) {
                    this.o4 = this.n4;
                    if (this.h4 == 2) {
                        this.p3.g();
                        this.h4 = 1;
                    }
                    this.p4 = true;
                    if (!this.k4) {
                        o1();
                        return false;
                    }
                    try {
                        if (!this.W3) {
                            this.l4 = true;
                            mediaCodecAdapter.d(this.Y3, 0, 0, 0, 4);
                            x1();
                        }
                        return false;
                    } catch (MediaCodec.CryptoException e2) {
                        throw H(e2, this.v3, Util.t0(e2.getErrorCode()));
                    }
                } else if (this.k4 || this.p3.n()) {
                    boolean u = this.p3.u();
                    if (u) {
                        this.p3.Y.b(position);
                    }
                    if (this.N3 && !u) {
                        NalUnitUtil.b((ByteBuffer) Assertions.g(this.p3.Z));
                        if (((ByteBuffer) Assertions.g(this.p3.Z)).position() == 0) {
                            return true;
                        }
                        this.N3 = false;
                    }
                    long j3 = this.p3.Y2;
                    if (this.r4) {
                        (!this.t3.isEmpty() ? this.t3.peekLast() : this.v4).f11712d.a(j3, (Format) Assertions.g(this.v3));
                        this.r4 = false;
                    }
                    this.n4 = Math.max(this.n4, j3);
                    if (l() || this.p3.o()) {
                        this.o4 = this.n4;
                    }
                    this.p3.s();
                    if (this.p3.j()) {
                        Q0(this.p3);
                    }
                    m1(this.p3);
                    int F0 = F0(this.p3);
                    if (u) {
                        try {
                            ((MediaCodecAdapter) Assertions.g(mediaCodecAdapter)).e(this.Y3, 0, this.p3.Y, j3, F0);
                        } catch (MediaCodec.CryptoException e3) {
                            throw H(e3, this.v3, Util.t0(e3.getErrorCode()));
                        }
                    } else {
                        ((MediaCodecAdapter) Assertions.g(mediaCodecAdapter)).d(this.Y3, 0, ((ByteBuffer) Assertions.g(this.p3.Z)).limit(), j3, F0);
                    }
                    x1();
                    this.k4 = true;
                    this.h4 = 0;
                    this.u4.f10100c++;
                    return true;
                } else {
                    this.p3.g();
                    if (this.h4 == 2) {
                        this.h4 = 1;
                    }
                    return true;
                }
            } catch (DecoderInputBuffer.InsufficientCapacityException e5) {
                e1(e5);
                r1(0);
                A0();
                return true;
            }
        }
    }

    private void z1(@Nullable DrmSession drmSession) {
        C0295i.b(this.x3, drmSession);
        this.x3 = drmSession;
    }

    /* access modifiers changed from: protected */
    public final boolean B0() throws ExoPlaybackException {
        boolean C0 = C0();
        if (C0) {
            c1();
        }
        return C0;
    }

    /* access modifiers changed from: protected */
    public final void B1() {
        this.s4 = true;
    }

    /* access modifiers changed from: protected */
    public boolean C0() {
        if (this.E3 == null) {
            return false;
        }
        int i2 = this.j4;
        if (i2 == 3 || this.O3 || ((this.P3 && !this.m4) || (this.Q3 && this.l4))) {
            t1();
            return true;
        }
        if (i2 == 2) {
            int i3 = Util.f9646a;
            Assertions.i(i3 >= 23);
            if (i3 >= 23) {
                try {
                    N1();
                } catch (ExoPlaybackException e2) {
                    Log.o(z4, "Failed to update the DRM session, releasing the codec instead.", e2);
                    t1();
                    return true;
                }
            }
        }
        A0();
        return false;
    }

    /* access modifiers changed from: protected */
    public final void C1(ExoPlaybackException exoPlaybackException) {
        this.t4 = exoPlaybackException;
    }

    public void D1(long j2) {
        this.B3 = j2;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final MediaCodecAdapter E0() {
        return this.E3;
    }

    /* access modifiers changed from: protected */
    public int F0(DecoderInputBuffer decoderInputBuffer) {
        return 0;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public final MediaCodecInfo G0() {
        return this.L3;
    }

    /* access modifiers changed from: protected */
    public boolean G1(MediaCodecInfo mediaCodecInfo) {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean H0() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean H1() {
        return false;
    }

    /* access modifiers changed from: protected */
    public float I0() {
        return this.I3;
    }

    /* access modifiers changed from: protected */
    public boolean I1(Format format) {
        return false;
    }

    /* access modifiers changed from: protected */
    public float J0(float f2, Format format, Format[] formatArr) {
        return y4;
    }

    /* access modifiers changed from: protected */
    public abstract int J1(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException;

    /* access modifiers changed from: protected */
    @Nullable
    public final MediaFormat K0() {
        return this.G3;
    }

    /* access modifiers changed from: protected */
    public abstract List<MediaCodecInfo> L0(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException;

    /* access modifiers changed from: protected */
    public final boolean L1() throws ExoPlaybackException {
        return M1(this.F3);
    }

    /* access modifiers changed from: protected */
    public abstract MediaCodecAdapter.Configuration M0(MediaCodecInfo mediaCodecInfo, Format format, @Nullable MediaCrypto mediaCrypto, float f2);

    /* access modifiers changed from: protected */
    public final long N0() {
        return this.v4.f11711c;
    }

    /* access modifiers changed from: protected */
    public final long O0() {
        return this.v4.f11710b;
    }

    /* access modifiers changed from: protected */
    public final void O1(long j2) throws ExoPlaybackException {
        Format j3 = this.v4.f11712d.j(j2);
        if (j3 == null && this.x4 && this.G3 != null) {
            j3 = this.v4.f11712d.i();
        }
        if (j3 != null) {
            this.w3 = j3;
        } else if (!this.H3 || this.w3 == null) {
            return;
        }
        i1((Format) Assertions.g(this.w3), this.G3);
        this.H3 = false;
        this.x4 = false;
    }

    /* access modifiers changed from: protected */
    public float P0() {
        return this.C3;
    }

    /* access modifiers changed from: protected */
    public void Q0(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void S() {
        this.v3 = null;
        A1(OutputStreamInfo.f11708e);
        this.t3.clear();
        C0();
    }

    /* access modifiers changed from: protected */
    public void T(boolean z, boolean z2) throws ExoPlaybackException {
        this.u4 = new DecoderCounters();
    }

    /* access modifiers changed from: protected */
    public void V(long j2, boolean z) throws ExoPlaybackException {
        this.p4 = false;
        this.q4 = false;
        this.s4 = false;
        if (this.d4) {
            this.r3.g();
            this.q3.g();
            this.e4 = false;
            this.u3.d();
        } else {
            B0();
        }
        if (this.v4.f11712d.l() > 0) {
            this.r4 = true;
        }
        this.v4.f11712d.c();
        this.t3.clear();
    }

    /* access modifiers changed from: protected */
    public final boolean W0() {
        return this.d4;
    }

    /* access modifiers changed from: protected */
    public final boolean X0(Format format) {
        return this.y3 == null && I1(format);
    }

    /* access modifiers changed from: protected */
    public void Y() {
        try {
            t0();
            t1();
        } finally {
            E1((DrmSession) null);
        }
    }

    /* access modifiers changed from: protected */
    public void Z() {
    }

    /* access modifiers changed from: protected */
    public void a0() {
    }

    public final int b(Format format) throws ExoPlaybackException {
        try {
            return J1(this.l3, format);
        } catch (MediaCodecUtil.DecoderQueryException e2) {
            throw H(e2, format, PlaybackException.o3);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0037, code lost:
        if (r5 >= r1) goto L_0x0039;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b0(androidx.media3.common.Format[] r16, long r17, long r19, androidx.media3.exoplayer.source.MediaSource.MediaPeriodId r21) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r15 = this;
            r0 = r15
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r1 = r0.v4
            long r1 = r1.f11711c
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0021
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r1 = new androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r6 = r1
            r9 = r17
            r11 = r19
            r6.<init>(r7, r9, r11)
            r15.A1(r1)
            goto L_0x0068
        L_0x0021:
            java.util.ArrayDeque<androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo> r1 = r0.t3
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0057
            long r1 = r0.n4
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0039
            long r5 = r0.w4
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 == 0) goto L_0x0057
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 < 0) goto L_0x0057
        L_0x0039:
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r1 = new androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo
            r9 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r8 = r1
            r11 = r17
            r13 = r19
            r8.<init>(r9, r11, r13)
            r15.A1(r1)
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r1 = r0.v4
            long r1 = r1.f11711c
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x0068
            r15.l1()
            goto L_0x0068
        L_0x0057:
            java.util.ArrayDeque<androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo> r1 = r0.t3
            androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo r9 = new androidx.media3.exoplayer.mediacodec.MediaCodecRenderer$OutputStreamInfo
            long r3 = r0.n4
            r2 = r9
            r5 = r17
            r7 = r19
            r2.<init>(r3, r5, r7)
            r1.add(r9)
        L_0x0068:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.b0(androidx.media3.common.Format[], long, long, androidx.media3.exoplayer.source.MediaSource$MediaPeriodId):void");
    }

    public boolean c() {
        return this.q4;
    }

    /* access modifiers changed from: protected */
    public final void c1() throws ExoPlaybackException {
        Format format;
        if (this.E3 == null && !this.d4 && (format = this.v3) != null) {
            if (X0(format)) {
                T0(this.v3);
                return;
            }
            z1(this.y3);
            if (this.x3 == null || V0()) {
                try {
                    d1(this.z3, this.A3);
                } catch (DecoderInitializationException e2) {
                    throw H(e2, this.v3, PlaybackException.n3);
                }
            }
            MediaCrypto mediaCrypto = this.z3;
            if (mediaCrypto != null && this.E3 == null) {
                mediaCrypto.release();
                this.z3 = null;
                this.A3 = false;
            }
        }
    }

    public boolean d() {
        return this.v3 != null && (R() || R0() || (this.X3 != C.f9084b && J().b() < this.X3));
    }

    /* access modifiers changed from: protected */
    public void e1(Exception exc) {
    }

    /* access modifiers changed from: protected */
    public void f1(String str, MediaCodecAdapter.Configuration configuration, long j2, long j3) {
    }

    public void g(long j2, long j3) throws ExoPlaybackException {
        boolean z = false;
        if (this.s4) {
            this.s4 = false;
            o1();
        }
        ExoPlaybackException exoPlaybackException = this.t4;
        if (exoPlaybackException == null) {
            try {
                if (this.q4) {
                    u1();
                } else if (this.v3 != null || r1(2)) {
                    c1();
                    if (this.d4) {
                        TraceUtil.a("bypassRender");
                        while (h0(j2, j3)) {
                        }
                    } else if (this.E3 != null) {
                        long b2 = J().b();
                        TraceUtil.a("drainAndFeed");
                        while (x0(j2, j3) && F1(b2)) {
                        }
                        while (z0() && F1(b2)) {
                        }
                    } else {
                        this.u4.f10101d += f0(j2);
                        r1(1);
                        this.u4.c();
                    }
                    TraceUtil.c();
                    this.u4.c();
                }
            } catch (IllegalStateException e2) {
                if (Z0(e2)) {
                    e1(e2);
                    if (Util.f9646a >= 21 && b1(e2)) {
                        z = true;
                    }
                    if (z) {
                        t1();
                    }
                    throw I(s0(e2, G0()), this.v3, z, PlaybackException.p3);
                }
                throw e2;
            }
        } else {
            this.t4 = null;
            throw exoPlaybackException;
        }
    }

    /* access modifiers changed from: protected */
    public void g1(String str) {
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x008f, code lost:
        if (w0() == false) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0091, code lost:
        r7 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00c2, code lost:
        if (w0() == false) goto L_0x0091;
     */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00f8 A[RETURN] */
    @androidx.annotation.CallSuper
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.media3.exoplayer.DecoderReuseEvaluation h1(androidx.media3.exoplayer.FormatHolder r12) throws androidx.media3.exoplayer.ExoPlaybackException {
        /*
            r11 = this;
            r0 = 1
            r11.r4 = r0
            androidx.media3.common.Format r1 = r12.f10226b
            java.lang.Object r1 = androidx.media3.common.util.Assertions.g(r1)
            r5 = r1
            androidx.media3.common.Format r5 = (androidx.media3.common.Format) r5
            java.lang.String r1 = r5.f3
            if (r1 == 0) goto L_0x00f9
            androidx.media3.exoplayer.drm.DrmSession r12 = r12.f10225a
            r11.E1(r12)
            r11.v3 = r5
            boolean r12 = r11.d4
            r1 = 0
            if (r12 == 0) goto L_0x001f
            r11.f4 = r0
            return r1
        L_0x001f:
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter r12 = r11.E3
            if (r12 != 0) goto L_0x0029
            r11.J3 = r1
            r11.c1()
            return r1
        L_0x0029:
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r1 = r11.L3
            java.lang.Object r1 = androidx.media3.common.util.Assertions.g(r1)
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r1 = (androidx.media3.exoplayer.mediacodec.MediaCodecInfo) r1
            androidx.media3.common.Format r2 = r11.F3
            java.lang.Object r2 = androidx.media3.common.util.Assertions.g(r2)
            r4 = r2
            androidx.media3.common.Format r4 = (androidx.media3.common.Format) r4
            androidx.media3.exoplayer.drm.DrmSession r2 = r11.x3
            androidx.media3.exoplayer.drm.DrmSession r3 = r11.y3
            boolean r2 = r11.y0(r1, r5, r2, r3)
            if (r2 == 0) goto L_0x0053
            r11.v0()
            androidx.media3.exoplayer.DecoderReuseEvaluation r12 = new androidx.media3.exoplayer.DecoderReuseEvaluation
            java.lang.String r3 = r1.f11693a
            r6 = 0
            r7 = 128(0x80, float:1.794E-43)
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            return r12
        L_0x0053:
            androidx.media3.exoplayer.drm.DrmSession r2 = r11.y3
            androidx.media3.exoplayer.drm.DrmSession r3 = r11.x3
            r6 = 0
            if (r2 == r3) goto L_0x005c
            r2 = 1
            goto L_0x005d
        L_0x005c:
            r2 = 0
        L_0x005d:
            if (r2 == 0) goto L_0x0068
            int r3 = androidx.media3.common.util.Util.f9646a
            r7 = 23
            if (r3 < r7) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            r3 = 0
            goto L_0x0069
        L_0x0068:
            r3 = 1
        L_0x0069:
            androidx.media3.common.util.Assertions.i(r3)
            androidx.media3.exoplayer.DecoderReuseEvaluation r3 = r11.i0(r1, r4, r5)
            int r7 = r3.f10122d
            r8 = 3
            if (r7 == 0) goto L_0x00de
            r9 = 16
            r10 = 2
            if (r7 == r0) goto L_0x00c5
            if (r7 == r10) goto L_0x0099
            if (r7 != r8) goto L_0x0093
            boolean r0 = r11.M1(r5)
            if (r0 != 0) goto L_0x0087
        L_0x0084:
            r7 = 16
            goto L_0x00e2
        L_0x0087:
            r11.F3 = r5
            if (r2 == 0) goto L_0x00e1
            boolean r0 = r11.w0()
            if (r0 != 0) goto L_0x00e1
        L_0x0091:
            r7 = 2
            goto L_0x00e2
        L_0x0093:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            r12.<init>()
            throw r12
        L_0x0099:
            boolean r7 = r11.M1(r5)
            if (r7 != 0) goto L_0x00a0
            goto L_0x0084
        L_0x00a0:
            r11.g4 = r0
            r11.h4 = r0
            int r7 = r11.M3
            if (r7 == r10) goto L_0x00b8
            if (r7 != r0) goto L_0x00b7
            int r7 = r5.k3
            int r9 = r4.k3
            if (r7 != r9) goto L_0x00b7
            int r7 = r5.l3
            int r9 = r4.l3
            if (r7 != r9) goto L_0x00b7
            goto L_0x00b8
        L_0x00b7:
            r0 = 0
        L_0x00b8:
            r11.U3 = r0
            r11.F3 = r5
            if (r2 == 0) goto L_0x00e1
            boolean r0 = r11.w0()
            if (r0 != 0) goto L_0x00e1
            goto L_0x0091
        L_0x00c5:
            boolean r0 = r11.M1(r5)
            if (r0 != 0) goto L_0x00cc
            goto L_0x0084
        L_0x00cc:
            r11.F3 = r5
            if (r2 == 0) goto L_0x00d7
            boolean r0 = r11.w0()
            if (r0 != 0) goto L_0x00e1
            goto L_0x0091
        L_0x00d7:
            boolean r0 = r11.u0()
            if (r0 != 0) goto L_0x00e1
            goto L_0x0091
        L_0x00de:
            r11.v0()
        L_0x00e1:
            r7 = 0
        L_0x00e2:
            int r0 = r3.f10122d
            if (r0 == 0) goto L_0x00f8
            androidx.media3.exoplayer.mediacodec.MediaCodecAdapter r0 = r11.E3
            if (r0 != r12) goto L_0x00ee
            int r12 = r11.j4
            if (r12 != r8) goto L_0x00f8
        L_0x00ee:
            androidx.media3.exoplayer.DecoderReuseEvaluation r12 = new androidx.media3.exoplayer.DecoderReuseEvaluation
            java.lang.String r3 = r1.f11693a
            r6 = 0
            r2 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            return r12
        L_0x00f8:
            return r3
        L_0x00f9:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Sample MIME type is null."
            r12.<init>(r0)
            r0 = 4005(0xfa5, float:5.612E-42)
            androidx.media3.exoplayer.ExoPlaybackException r12 = r11.H(r12, r5, r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.MediaCodecRenderer.h1(androidx.media3.exoplayer.FormatHolder):androidx.media3.exoplayer.DecoderReuseEvaluation");
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation i0(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        return new DecoderReuseEvaluation(mediaCodecInfo.f11693a, format, format2, 0, 1);
    }

    /* access modifiers changed from: protected */
    public void i1(Format format, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void j1(long j2) {
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void k1(long j2) {
        this.w4 = j2;
        while (!this.t3.isEmpty() && j2 >= this.t3.peek().f11709a) {
            A1((OutputStreamInfo) Assertions.g(this.t3.poll()));
            l1();
        }
    }

    /* access modifiers changed from: protected */
    public void l1() {
    }

    /* access modifiers changed from: protected */
    public void m1(DecoderInputBuffer decoderInputBuffer) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public void n1(Format format) throws ExoPlaybackException {
    }

    /* access modifiers changed from: protected */
    public abstract boolean p1(long j2, long j3, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i2, int i3, int i5, long j5, boolean z, boolean z2, Format format) throws ExoPlaybackException;

    /* access modifiers changed from: protected */
    public MediaCodecDecoderException s0(Throwable th, @Nullable MediaCodecInfo mediaCodecInfo) {
        return new MediaCodecDecoderException(th, mediaCodecInfo);
    }

    /* access modifiers changed from: protected */
    public void t1() {
        try {
            MediaCodecAdapter mediaCodecAdapter = this.E3;
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.a();
                this.u4.f10099b++;
                g1(((MediaCodecInfo) Assertions.g(this.L3)).f11693a);
            }
            this.E3 = null;
            try {
                MediaCrypto mediaCrypto = this.z3;
                if (mediaCrypto != null) {
                    mediaCrypto.release();
                }
            } finally {
                this.z3 = null;
                z1((DrmSession) null);
                w1();
            }
        } catch (Throwable th) {
            this.E3 = null;
            MediaCrypto mediaCrypto2 = this.z3;
            if (mediaCrypto2 != null) {
                mediaCrypto2.release();
            }
            throw th;
        } finally {
            this.z3 = null;
            z1((DrmSession) null);
            w1();
        }
    }

    /* access modifiers changed from: protected */
    public void u1() throws ExoPlaybackException {
    }

    public void v(float f2, float f3) throws ExoPlaybackException {
        this.C3 = f2;
        this.D3 = f3;
        M1(this.F3);
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void v1() {
        x1();
        y1();
        this.X3 = C.f9084b;
        this.l4 = false;
        this.k4 = false;
        this.U3 = false;
        this.V3 = false;
        this.b4 = false;
        this.c4 = false;
        this.n4 = C.f9084b;
        this.o4 = C.f9084b;
        this.w4 = C.f9084b;
        this.i4 = 0;
        this.j4 = 0;
        this.h4 = this.g4 ? 1 : 0;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void w1() {
        v1();
        this.t4 = null;
        this.J3 = null;
        this.L3 = null;
        this.F3 = null;
        this.G3 = null;
        this.H3 = false;
        this.m4 = false;
        this.I3 = y4;
        this.M3 = 0;
        this.N3 = false;
        this.O3 = false;
        this.P3 = false;
        this.Q3 = false;
        this.R3 = false;
        this.S3 = false;
        this.T3 = false;
        this.W3 = false;
        this.g4 = false;
        this.h4 = 0;
        this.A3 = false;
    }

    public final int y() {
        return 8;
    }
}
