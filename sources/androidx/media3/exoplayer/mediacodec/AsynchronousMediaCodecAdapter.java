package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PersistableBundle;
import android.view.Surface;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.Format;
import androidx.media3.common.MimeTypes;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import com.google.common.base.Supplier;
import java.nio.ByteBuffer;

@RequiresApi(23)
final class AsynchronousMediaCodecAdapter implements MediaCodecAdapter {

    /* renamed from: f  reason: collision with root package name */
    private static final int f11631f = 0;

    /* renamed from: g  reason: collision with root package name */
    private static final int f11632g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final int f11633h = 2;

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f11634a;

    /* renamed from: b  reason: collision with root package name */
    private final AsynchronousMediaCodecCallback f11635b;

    /* renamed from: c  reason: collision with root package name */
    private final MediaCodecBufferEnqueuer f11636c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f11637d;

    /* renamed from: e  reason: collision with root package name */
    private int f11638e;

    public static final class Factory implements MediaCodecAdapter.Factory {

        /* renamed from: b  reason: collision with root package name */
        private final Supplier<HandlerThread> f11639b;

        /* renamed from: c  reason: collision with root package name */
        private final Supplier<HandlerThread> f11640c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f11641d;

        public Factory(int i2) {
            this(new e(i2), new f(i2));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ HandlerThread f(int i2) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.u(i2));
        }

        /* access modifiers changed from: private */
        public static /* synthetic */ HandlerThread g(int i2) {
            return new HandlerThread(AsynchronousMediaCodecAdapter.v(i2));
        }

        @ChecksSdkIntAtLeast(api = 34)
        private static boolean h(Format format) {
            if (Util.f9646a < 34) {
                return false;
            }
            return MimeTypes.t(format.f3);
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0069  */
        /* renamed from: d */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter a(androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Configuration r7) throws java.io.IOException {
            /*
                r6 = this;
                androidx.media3.exoplayer.mediacodec.MediaCodecInfo r0 = r7.f11684a
                java.lang.String r0 = r0.f11693a
                r1 = 0
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x005f }
                r2.<init>()     // Catch:{ Exception -> 0x005f }
                java.lang.String r3 = "createCodec:"
                r2.append(r3)     // Catch:{ Exception -> 0x005f }
                r2.append(r0)     // Catch:{ Exception -> 0x005f }
                java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x005f }
                androidx.media3.common.util.TraceUtil.a(r2)     // Catch:{ Exception -> 0x005f }
                android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x005f }
                int r2 = r7.f11689f     // Catch:{ Exception -> 0x0033 }
                boolean r3 = r6.f11641d     // Catch:{ Exception -> 0x0033 }
                if (r3 == 0) goto L_0x0035
                androidx.media3.common.Format r3 = r7.f11686c     // Catch:{ Exception -> 0x0033 }
                boolean r3 = h(r3)     // Catch:{ Exception -> 0x0033 }
                if (r3 == 0) goto L_0x0035
                androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecBufferEnqueuer r3 = new androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecBufferEnqueuer     // Catch:{ Exception -> 0x0033 }
                r3.<init>(r0)     // Catch:{ Exception -> 0x0033 }
                r2 = r2 | 4
                goto L_0x0042
            L_0x0033:
                r7 = move-exception
                goto L_0x0061
            L_0x0035:
                androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer r3 = new androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecBufferEnqueuer     // Catch:{ Exception -> 0x0033 }
                com.google.common.base.Supplier<android.os.HandlerThread> r4 = r6.f11640c     // Catch:{ Exception -> 0x0033 }
                java.lang.Object r4 = r4.get()     // Catch:{ Exception -> 0x0033 }
                android.os.HandlerThread r4 = (android.os.HandlerThread) r4     // Catch:{ Exception -> 0x0033 }
                r3.<init>(r0, r4)     // Catch:{ Exception -> 0x0033 }
            L_0x0042:
                androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter r4 = new androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter     // Catch:{ Exception -> 0x0033 }
                com.google.common.base.Supplier<android.os.HandlerThread> r5 = r6.f11639b     // Catch:{ Exception -> 0x0033 }
                java.lang.Object r5 = r5.get()     // Catch:{ Exception -> 0x0033 }
                android.os.HandlerThread r5 = (android.os.HandlerThread) r5     // Catch:{ Exception -> 0x0033 }
                r4.<init>(r0, r5, r3)     // Catch:{ Exception -> 0x0033 }
                androidx.media3.common.util.TraceUtil.c()     // Catch:{ Exception -> 0x005c }
                android.media.MediaFormat r1 = r7.f11685b     // Catch:{ Exception -> 0x005c }
                android.view.Surface r3 = r7.f11687d     // Catch:{ Exception -> 0x005c }
                android.media.MediaCrypto r7 = r7.f11688e     // Catch:{ Exception -> 0x005c }
                r4.x(r1, r3, r7, r2)     // Catch:{ Exception -> 0x005c }
                return r4
            L_0x005c:
                r7 = move-exception
                r1 = r4
                goto L_0x0061
            L_0x005f:
                r7 = move-exception
                r0 = r1
            L_0x0061:
                if (r1 != 0) goto L_0x0069
                if (r0 == 0) goto L_0x006c
                r0.release()
                goto L_0x006c
            L_0x0069:
                r1.a()
            L_0x006c:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter.Factory.a(androidx.media3.exoplayer.mediacodec.MediaCodecAdapter$Configuration):androidx.media3.exoplayer.mediacodec.AsynchronousMediaCodecAdapter");
        }

        public void e(boolean z) {
            this.f11641d = z;
        }

        @VisibleForTesting
        Factory(Supplier<HandlerThread> supplier, Supplier<HandlerThread> supplier2) {
            this.f11639b = supplier;
            this.f11640c = supplier2;
            this.f11641d = true;
        }
    }

    private AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, HandlerThread handlerThread, MediaCodecBufferEnqueuer mediaCodecBufferEnqueuer) {
        this.f11634a = mediaCodec;
        this.f11635b = new AsynchronousMediaCodecCallback(handlerThread);
        this.f11636c = mediaCodecBufferEnqueuer;
        this.f11638e = 0;
    }

    /* access modifiers changed from: private */
    public static String u(int i2) {
        return w(i2, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    /* access modifiers changed from: private */
    public static String v(int i2) {
        return w(i2, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String w(int i2, String str) {
        String str2;
        StringBuilder sb = new StringBuilder(str);
        if (i2 == 1) {
            str2 = "Audio";
        } else if (i2 == 2) {
            str2 = "Video";
        } else {
            sb.append("Unknown(");
            sb.append(i2);
            str2 = ")";
        }
        sb.append(str2);
        return sb.toString();
    }

    /* access modifiers changed from: private */
    public void x(@Nullable MediaFormat mediaFormat, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i2) {
        this.f11635b.h(this.f11634a);
        TraceUtil.a("configureCodec");
        this.f11634a.configure(mediaFormat, surface, mediaCrypto, i2);
        TraceUtil.c();
        this.f11636c.start();
        TraceUtil.a("startCodec");
        this.f11634a.start();
        TraceUtil.c();
        this.f11638e = 1;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j2, long j3) {
        onFrameRenderedListener.a(this, j2, j3);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void A(MediaFormat mediaFormat) {
        this.f11635b.onOutputFormatChanged(this.f11634a, mediaFormat);
    }

    public void a() {
        try {
            if (this.f11638e == 1) {
                this.f11636c.shutdown();
                this.f11635b.p();
            }
            this.f11638e = 2;
            if (!this.f11637d) {
                this.f11634a.release();
                this.f11637d = true;
            }
        } catch (Throwable th) {
            if (!this.f11637d) {
                this.f11634a.release();
                this.f11637d = true;
            }
            throw th;
        }
    }

    public void b(Bundle bundle) {
        this.f11636c.b(bundle);
    }

    @RequiresApi(26)
    public PersistableBundle c() {
        return this.f11634a.getMetrics();
    }

    public void d(int i2, int i3, int i4, long j2, int i5) {
        this.f11636c.d(i2, i3, i4, j2, i5);
    }

    public void e(int i2, int i3, CryptoInfo cryptoInfo, long j2, int i4) {
        this.f11636c.e(i2, i3, cryptoInfo, j2, i4);
    }

    public boolean f() {
        return false;
    }

    public void flush() {
        this.f11636c.flush();
        this.f11634a.flush();
        this.f11635b.e();
        this.f11634a.start();
    }

    public void g(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        this.f11634a.setOnFrameRenderedListener(new d(this, onFrameRenderedListener), handler);
    }

    public MediaFormat h() {
        return this.f11635b.g();
    }

    public void i(int i2, long j2) {
        this.f11634a.releaseOutputBuffer(i2, j2);
    }

    public int j() {
        this.f11636c.a();
        return this.f11635b.c();
    }

    public int k(MediaCodec.BufferInfo bufferInfo) {
        this.f11636c.a();
        return this.f11635b.d(bufferInfo);
    }

    public void l(int i2) {
        this.f11634a.setVideoScalingMode(i2);
    }

    public void m(int i2, boolean z) {
        this.f11634a.releaseOutputBuffer(i2, z);
    }

    @Nullable
    public ByteBuffer n(int i2) {
        return this.f11634a.getInputBuffer(i2);
    }

    public void o(Surface surface) {
        this.f11634a.setOutputSurface(surface);
    }

    @Nullable
    public ByteBuffer p(int i2) {
        return this.f11634a.getOutputBuffer(i2);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void z(MediaCodec.CodecException codecException) {
        this.f11635b.onError(this.f11634a, codecException);
    }
}
