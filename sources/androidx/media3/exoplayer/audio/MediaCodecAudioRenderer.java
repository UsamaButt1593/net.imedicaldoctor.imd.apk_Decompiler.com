package androidx.media3.exoplayer.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
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
import androidx.media3.common.util.MediaFormatUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.DecoderReuseEvaluation;
import androidx.media3.exoplayer.ExoPlaybackException;
import androidx.media3.exoplayer.FormatHolder;
import androidx.media3.exoplayer.MediaClock;
import androidx.media3.exoplayer.Renderer;
import androidx.media3.exoplayer.V0;
import androidx.media3.exoplayer.audio.AudioRendererEventListener;
import androidx.media3.exoplayer.audio.AudioSink;
import androidx.media3.exoplayer.audio.DefaultAudioSink;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import androidx.media3.exoplayer.mediacodec.MediaCodecInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecRenderer;
import androidx.media3.exoplayer.mediacodec.MediaCodecSelector;
import androidx.media3.exoplayer.mediacodec.MediaCodecUtil;
import androidx.media3.exoplayer.mediacodec.j;
import androidx.media3.extractor.VorbisUtil;
import com.google.common.base.MoreObjects;
import com.itextpdf.text.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;
import java.util.Objects;

@UnstableApi
public class MediaCodecAudioRenderer extends MediaCodecRenderer implements MediaClock {
    private static final String d5 = "MediaCodecAudioRenderer";
    private static final String e5 = "v-bits-per-sample";
    private final Context Q4;
    /* access modifiers changed from: private */
    public final AudioRendererEventListener.EventDispatcher R4;
    private final AudioSink S4;
    private int T4;
    private boolean U4;
    private boolean V4;
    @Nullable
    private Format W4;
    @Nullable
    private Format X4;
    private long Y4;
    private boolean Z4;
    private boolean a5;
    /* access modifiers changed from: private */
    @Nullable
    public Renderer.WakeupListener b5;
    /* access modifiers changed from: private */
    public boolean c5;

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
            MediaCodecAudioRenderer.this.R4.H(j2);
        }

        public void b(AudioSink.AudioTrackConfig audioTrackConfig) {
            MediaCodecAudioRenderer.this.R4.o(audioTrackConfig);
        }

        public void c() {
            boolean unused = MediaCodecAudioRenderer.this.c5 = true;
        }

        public void d(AudioSink.AudioTrackConfig audioTrackConfig) {
            MediaCodecAudioRenderer.this.R4.p(audioTrackConfig);
        }

        public void e(boolean z) {
            MediaCodecAudioRenderer.this.R4.I(z);
        }

        public void f(Exception exc) {
            Log.e(MediaCodecAudioRenderer.d5, "Audio sink error", exc);
            MediaCodecAudioRenderer.this.R4.n(exc);
        }

        public void g() {
            if (MediaCodecAudioRenderer.this.b5 != null) {
                MediaCodecAudioRenderer.this.b5.a();
            }
        }

        public void h(int i2, long j2, long j3) {
            MediaCodecAudioRenderer.this.R4.J(i2, j2, j3);
        }

        public void i() {
            MediaCodecAudioRenderer.this.X();
        }

        public void j() {
            MediaCodecAudioRenderer.this.b2();
        }

        public void k() {
            if (MediaCodecAudioRenderer.this.b5 != null) {
                MediaCodecAudioRenderer.this.b5.b();
            }
        }
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecAdapter.Factory factory, MediaCodecSelector mediaCodecSelector, boolean z, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        super(1, factory, mediaCodecSelector, z, 44100.0f);
        this.Q4 = context.getApplicationContext();
        this.S4 = audioSink;
        this.R4 = new AudioRendererEventListener.EventDispatcher(handler, audioRendererEventListener);
        audioSink.v(new AudioSinkListener());
    }

    private static boolean T1(String str) {
        if (Util.f9646a < 24 && "OMX.SEC.aac.dec".equals(str) && "samsung".equals(Util.f9648c)) {
            String str2 = Util.f9647b;
            if (str2.startsWith("zeroflte") || str2.startsWith("herolte") || str2.startsWith("heroqlte")) {
                return true;
            }
        }
        return false;
    }

    private static boolean U1(String str) {
        return str.equals("OMX.google.opus.decoder") || str.equals("c2.android.opus.decoder") || str.equals("OMX.google.vorbis.decoder") || str.equals("c2.android.vorbis.decoder");
    }

    private static boolean V1() {
        if (Util.f9646a == 23) {
            String str = Util.f9649d;
            if ("ZTE B2017G".equals(str) || "AXON 7 mini".equals(str)) {
                return true;
            }
        }
        return false;
    }

    private int W1(Format format) {
        AudioOffloadSupport l2 = this.S4.l(format);
        if (!l2.f10771a) {
            return 0;
        }
        int i2 = l2.f10772b ? 1536 : 512;
        return l2.f10773c ? i2 | 2048 : i2;
    }

    private int X1(MediaCodecInfo mediaCodecInfo, Format format) {
        int i2;
        if (!"OMX.google.raw.decoder".equals(mediaCodecInfo.f11693a) || (i2 = Util.f9646a) >= 24 || (i2 == 23 && Util.q1(this.Q4))) {
            return format.g3;
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000f, code lost:
        r4 = androidx.media3.exoplayer.mediacodec.MediaCodecUtil.y();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.List<androidx.media3.exoplayer.mediacodec.MediaCodecInfo> Z1(androidx.media3.exoplayer.mediacodec.MediaCodecSelector r1, androidx.media3.common.Format r2, boolean r3, androidx.media3.exoplayer.audio.AudioSink r4) throws androidx.media3.exoplayer.mediacodec.MediaCodecUtil.DecoderQueryException {
        /*
            java.lang.String r0 = r2.f3
            if (r0 != 0) goto L_0x0009
            com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.I()
            return r1
        L_0x0009:
            boolean r4 = r4.b(r2)
            if (r4 == 0) goto L_0x001a
            androidx.media3.exoplayer.mediacodec.MediaCodecInfo r4 = androidx.media3.exoplayer.mediacodec.MediaCodecUtil.y()
            if (r4 == 0) goto L_0x001a
            com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.K(r4)
            return r1
        L_0x001a:
            r4 = 0
            java.util.List r1 = androidx.media3.exoplayer.mediacodec.MediaCodecUtil.w(r1, r2, r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.audio.MediaCodecAudioRenderer.Z1(androidx.media3.exoplayer.mediacodec.MediaCodecSelector, androidx.media3.common.Format, boolean, androidx.media3.exoplayer.audio.AudioSink):java.util.List");
    }

    private void c2() {
        long x = this.S4.x(c());
        if (x != Long.MIN_VALUE) {
            if (!this.Z4) {
                x = Math.max(this.Y4, x);
            }
            this.Y4 = x;
            this.Z4 = false;
        }
    }

    @Nullable
    public MediaClock G() {
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean I1(Format format) {
        if (K().f10443a != 0) {
            int W1 = W1(format);
            if ((W1 & 512) != 0) {
                if (K().f10443a == 2 || (W1 & 1024) != 0) {
                    return true;
                }
                if (format.v3 == 0 && format.w3 == 0) {
                    return true;
                }
            }
        }
        return this.S4.b(format);
    }

    /* access modifiers changed from: protected */
    public float J0(float f2, Format format, Format[] formatArr) {
        int i2 = -1;
        for (Format format2 : formatArr) {
            int i3 = format2.t3;
            if (i3 != -1) {
                i2 = Math.max(i2, i3);
            }
        }
        if (i2 == -1) {
            return -1.0f;
        }
        return f2 * ((float) i2);
    }

    /* access modifiers changed from: protected */
    public int J1(MediaCodecSelector mediaCodecSelector, Format format) throws MediaCodecUtil.DecoderQueryException {
        int i2;
        boolean z;
        if (!MimeTypes.p(format.f3)) {
            return V0.c(0);
        }
        int i3 = Util.f9646a >= 21 ? 32 : 0;
        boolean z2 = true;
        boolean z3 = format.B3 != 0;
        boolean K1 = MediaCodecRenderer.K1(format);
        if (!K1 || (z3 && MediaCodecUtil.y() == null)) {
            i2 = 0;
        } else {
            int W1 = W1(format);
            if (this.S4.b(format)) {
                return V0.e(4, 8, i3, W1);
            }
            i2 = W1;
        }
        if (MimeTypes.N.equals(format.f3) && !this.S4.b(format)) {
            return V0.c(1);
        }
        if (!this.S4.b(Util.D0(2, format.s3, format.t3))) {
            return V0.c(1);
        }
        List<MediaCodecInfo> Z1 = Z1(mediaCodecSelector, format, false, this.S4);
        if (Z1.isEmpty()) {
            return V0.c(1);
        }
        if (!K1) {
            return V0.c(2);
        }
        MediaCodecInfo mediaCodecInfo = Z1.get(0);
        boolean p = mediaCodecInfo.p(format);
        if (!p) {
            int i4 = 1;
            while (true) {
                if (i4 >= Z1.size()) {
                    break;
                }
                MediaCodecInfo mediaCodecInfo2 = Z1.get(i4);
                if (mediaCodecInfo2.p(format)) {
                    mediaCodecInfo = mediaCodecInfo2;
                    z = false;
                    break;
                }
                i4++;
            }
        }
        z2 = p;
        z = true;
        return V0.g(z2 ? 4 : 3, (!z2 || !mediaCodecInfo.s(format)) ? 8 : 16, i3, mediaCodecInfo.f11700h ? 64 : 0, z ? 128 : 0, i2);
    }

    /* access modifiers changed from: protected */
    public List<MediaCodecInfo> L0(MediaCodecSelector mediaCodecSelector, Format format, boolean z) throws MediaCodecUtil.DecoderQueryException {
        return MediaCodecUtil.x(Z1(mediaCodecSelector, format, z, this.S4), format);
    }

    /* access modifiers changed from: protected */
    public MediaCodecAdapter.Configuration M0(MediaCodecInfo mediaCodecInfo, Format format, @Nullable MediaCrypto mediaCrypto, float f2) {
        this.T4 = Y1(mediaCodecInfo, format, P());
        this.U4 = T1(mediaCodecInfo.f11693a);
        this.V4 = U1(mediaCodecInfo.f11693a);
        MediaFormat a2 = a2(format, mediaCodecInfo.f11695c, this.T4, f2);
        this.X4 = (!MimeTypes.N.equals(mediaCodecInfo.f11694b) || MimeTypes.N.equals(format.f3)) ? null : format;
        return MediaCodecAdapter.Configuration.a(mediaCodecInfo, a2, format, mediaCrypto);
    }

    /* access modifiers changed from: protected */
    public void Q0(DecoderInputBuffer decoderInputBuffer) {
        Format format;
        if (Util.f9646a >= 29 && (format = decoderInputBuffer.X) != null && Objects.equals(format.f3, MimeTypes.a0) && W0()) {
            ByteBuffer byteBuffer = (ByteBuffer) Assertions.g(decoderInputBuffer.Z2);
            int i2 = ((Format) Assertions.g(decoderInputBuffer.X)).v3;
            if (byteBuffer.remaining() == 8) {
                this.S4.u(i2, (int) ((byteBuffer.order(ByteOrder.LITTLE_ENDIAN).getLong() * 48000) / C.f9093k));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void S() {
        this.a5 = true;
        this.W4 = null;
        try {
            this.S4.flush();
            try {
                super.S();
            } finally {
                this.R4.s(this.u4);
            }
        } catch (Throwable th) {
            super.S();
            throw th;
        } finally {
            this.R4.s(this.u4);
        }
    }

    /* access modifiers changed from: protected */
    public void T(boolean z, boolean z2) throws ExoPlaybackException {
        super.T(z, z2);
        this.R4.t(this.u4);
        if (K().f10444b) {
            this.S4.C();
        } else {
            this.S4.y();
        }
        this.S4.z(O());
        this.S4.i(J());
    }

    /* access modifiers changed from: protected */
    public void V(long j2, boolean z) throws ExoPlaybackException {
        super.V(j2, z);
        this.S4.flush();
        this.Y4 = j2;
        this.c5 = false;
        this.Z4 = true;
    }

    /* access modifiers changed from: protected */
    public void W() {
        this.S4.a();
    }

    /* access modifiers changed from: protected */
    public void Y() {
        this.c5 = false;
        try {
            super.Y();
        } finally {
            if (this.a5) {
                this.a5 = false;
                this.S4.reset();
            }
        }
    }

    /* access modifiers changed from: protected */
    public int Y1(MediaCodecInfo mediaCodecInfo, Format format, Format[] formatArr) {
        int X1 = X1(mediaCodecInfo, format);
        if (formatArr.length == 1) {
            return X1;
        }
        for (Format format2 : formatArr) {
            if (mediaCodecInfo.e(format, format2).f10122d != 0) {
                X1 = Math.max(X1, X1(mediaCodecInfo, format2));
            }
        }
        return X1;
    }

    /* access modifiers changed from: protected */
    public void Z() {
        super.Z();
        this.S4.o();
    }

    /* access modifiers changed from: protected */
    public void a0() {
        c2();
        this.S4.h();
        super.a0();
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"InlinedApi"})
    public MediaFormat a2(Format format, String str, int i2, float f2) {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString(Annotation.w3, str);
        mediaFormat.setInteger("channel-count", format.s3);
        mediaFormat.setInteger("sample-rate", format.t3);
        MediaFormatUtil.x(mediaFormat, format.h3);
        MediaFormatUtil.s(mediaFormat, "max-input-size", i2);
        int i3 = Util.f9646a;
        if (i3 >= 23) {
            mediaFormat.setInteger("priority", 0);
            if (f2 != -1.0f && !V1()) {
                mediaFormat.setFloat("operating-rate", f2);
            }
        }
        if (i3 <= 28 && MimeTypes.T.equals(format.f3)) {
            mediaFormat.setInteger("ac4-is-sync", 1);
        }
        if (i3 >= 24 && this.S4.D(Util.D0(4, format.s3, format.t3)) == 2) {
            mediaFormat.setInteger("pcm-encoding", 4);
        }
        if (i3 >= 32) {
            mediaFormat.setInteger("max-output-channel-count", 99);
        }
        return mediaFormat;
    }

    /* access modifiers changed from: protected */
    @CallSuper
    public void b2() {
        this.Z4 = true;
    }

    public boolean c() {
        return super.c() && this.S4.c();
    }

    public boolean d() {
        return this.S4.q() || super.d();
    }

    /* access modifiers changed from: protected */
    public void e1(Exception exc) {
        Log.e(d5, "Audio codec error", exc);
        this.R4.m(exc);
    }

    public void f(PlaybackParameters playbackParameters) {
        this.S4.f(playbackParameters);
    }

    /* access modifiers changed from: protected */
    public void f1(String str, MediaCodecAdapter.Configuration configuration, long j2, long j3) {
        this.R4.q(str, j2, j3);
    }

    /* access modifiers changed from: protected */
    public void g1(String str) {
        this.R4.r(str);
    }

    public String getName() {
        return d5;
    }

    /* access modifiers changed from: protected */
    @Nullable
    public DecoderReuseEvaluation h1(FormatHolder formatHolder) throws ExoPlaybackException {
        Format format = (Format) Assertions.g(formatHolder.f10226b);
        this.W4 = format;
        DecoderReuseEvaluation h1 = super.h1(formatHolder);
        this.R4.u(format, h1);
        return h1;
    }

    /* access modifiers changed from: protected */
    public DecoderReuseEvaluation i0(MediaCodecInfo mediaCodecInfo, Format format, Format format2) {
        DecoderReuseEvaluation e2 = mediaCodecInfo.e(format, format2);
        int i2 = e2.f10123e;
        if (X0(format2)) {
            i2 |= 32768;
        }
        if (X1(mediaCodecInfo, format2) > this.T4) {
            i2 |= 64;
        }
        int i3 = i2;
        return new DecoderReuseEvaluation(mediaCodecInfo.f11693a, format, format2, i3 != 0 ? 0 : e2.f10122d, i3);
    }

    /* access modifiers changed from: protected */
    public void i1(Format format, @Nullable MediaFormat mediaFormat) throws ExoPlaybackException {
        int i2;
        Format format2 = this.X4;
        int[] iArr = null;
        if (format2 != null) {
            format = format2;
        } else if (E0() != null) {
            Assertions.g(mediaFormat);
            Format I = new Format.Builder().k0(MimeTypes.N).e0(MimeTypes.N.equals(format.f3) ? format.u3 : (Util.f9646a < 24 || !mediaFormat.containsKey("pcm-encoding")) ? mediaFormat.containsKey(e5) ? Util.C0(mediaFormat.getInteger(e5)) : 2 : mediaFormat.getInteger("pcm-encoding")).S(format.v3).T(format.w3).d0(format.d3).X(format.s).Z(format.X).a0(format.Y).b0(format.Z).m0(format.X2).i0(format.Y2).L(mediaFormat.getInteger("channel-count")).l0(mediaFormat.getInteger("sample-rate")).I();
            if (this.U4 && I.s3 == 6 && (i2 = format.s3) < 6) {
                iArr = new int[i2];
                for (int i3 = 0; i3 < format.s3; i3++) {
                    iArr[i3] = i3;
                }
            } else if (this.V4) {
                iArr = VorbisUtil.a(I.s3);
            }
            format = I;
        }
        try {
            if (Util.f9646a >= 29) {
                if (!W0() || K().f10443a == 0) {
                    this.S4.w(0);
                } else {
                    this.S4.w(K().f10443a);
                }
            }
            this.S4.j(format, 0, iArr);
        } catch (AudioSink.ConfigurationException e2) {
            throw H(e2, e2.s, PlaybackException.s3);
        }
    }

    /* access modifiers changed from: protected */
    public void j1(long j2) {
        this.S4.A(j2);
    }

    /* access modifiers changed from: protected */
    public void l1() {
        super.l1();
        this.S4.B();
    }

    /* access modifiers changed from: protected */
    public boolean p1(long j2, long j3, @Nullable MediaCodecAdapter mediaCodecAdapter, @Nullable ByteBuffer byteBuffer, int i2, int i3, int i4, long j4, boolean z, boolean z2, Format format) throws ExoPlaybackException {
        Assertions.g(byteBuffer);
        if (this.X4 != null && (i3 & 2) != 0) {
            ((MediaCodecAdapter) Assertions.g(mediaCodecAdapter)).m(i2, false);
            return true;
        } else if (z) {
            if (mediaCodecAdapter != null) {
                mediaCodecAdapter.m(i2, false);
            }
            this.u4.f10103f += i4;
            this.S4.B();
            return true;
        } else {
            try {
                if (!this.S4.E(byteBuffer, j4, i4)) {
                    return false;
                }
                if (mediaCodecAdapter != null) {
                    mediaCodecAdapter.m(i2, false);
                }
                this.u4.f10102e += i4;
                return true;
            } catch (AudioSink.InitializationException e2) {
                throw I(e2, this.W4, e2.X, (!W0() || K().f10443a == 0) ? PlaybackException.s3 : PlaybackException.v3);
            } catch (AudioSink.WriteException e3) {
                throw I(e3, format, e3.X, (!W0() || K().f10443a == 0) ? PlaybackException.t3 : PlaybackException.u3);
            }
        }
    }

    public PlaybackParameters r() {
        return this.S4.r();
    }

    public long u() {
        if (getState() == 2) {
            c2();
        }
        return this.Y4;
    }

    /* access modifiers changed from: protected */
    public void u1() throws ExoPlaybackException {
        try {
            this.S4.p();
        } catch (AudioSink.WriteException e2) {
            throw I(e2, e2.Y, e2.X, W0() ? PlaybackException.u3 : PlaybackException.t3);
        }
    }

    public boolean x() {
        boolean z = this.c5;
        this.c5 = false;
        return z;
    }

    public void z(int i2, @Nullable Object obj) throws ExoPlaybackException {
        if (i2 == 2) {
            this.S4.g(((Float) Assertions.g(obj)).floatValue());
        } else if (i2 == 3) {
            this.S4.k((AudioAttributes) Assertions.g((AudioAttributes) obj));
        } else if (i2 != 6) {
            switch (i2) {
                case 9:
                    this.S4.s(((Boolean) Assertions.g(obj)).booleanValue());
                    return;
                case 10:
                    this.S4.e(((Integer) Assertions.g(obj)).intValue());
                    return;
                case 11:
                    this.b5 = (Renderer.WakeupListener) obj;
                    return;
                case 12:
                    if (Util.f9646a >= 23) {
                        Api23.a(this.S4, obj);
                        return;
                    }
                    return;
                default:
                    super.z(i2, obj);
                    return;
            }
        } else {
            this.S4.t((AuxEffectInfo) Assertions.g((AuxEffectInfo) obj));
        }
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector) {
        this(context, mediaCodecSelector, (Handler) null, (AudioRendererEventListener) null);
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener) {
        this(context, mediaCodecSelector, handler, audioRendererEventListener, new DefaultAudioSink.Builder(context).i());
    }

    @Deprecated
    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioCapabilities audioCapabilities, AudioProcessor... audioProcessorArr) {
        this(context, mediaCodecSelector, handler, audioRendererEventListener, new DefaultAudioSink.Builder().j((AudioCapabilities) MoreObjects.a(audioCapabilities, AudioCapabilities.f10743e)).m(audioProcessorArr).i());
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        this(context, j.a(context), mediaCodecSelector, false, handler, audioRendererEventListener, audioSink);
    }

    public MediaCodecAudioRenderer(Context context, MediaCodecSelector mediaCodecSelector, boolean z, @Nullable Handler handler, @Nullable AudioRendererEventListener audioRendererEventListener, AudioSink audioSink) {
        this(context, j.a(context), mediaCodecSelector, z, handler, audioRendererEventListener, audioSink);
    }
}
