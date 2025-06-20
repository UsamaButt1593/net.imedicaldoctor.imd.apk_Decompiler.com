package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.TraceUtil;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.decoder.CryptoInfo;
import androidx.media3.exoplayer.mediacodec.MediaCodecAdapter;
import java.io.IOException;
import java.nio.ByteBuffer;

@UnstableApi
public final class SynchronousMediaCodecAdapter implements MediaCodecAdapter {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f11730a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private ByteBuffer[] f11731b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private ByteBuffer[] f11732c;

    public static class Factory implements MediaCodecAdapter.Factory {
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0033  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.media3.exoplayer.mediacodec.MediaCodecAdapter a(androidx.media3.exoplayer.mediacodec.MediaCodecAdapter.Configuration r6) throws java.io.IOException {
            /*
                r5 = this;
                r0 = 0
                android.media.MediaCodec r1 = r5.b(r6)     // Catch:{ IOException -> 0x0030, RuntimeException -> 0x002e }
                java.lang.String r2 = "configureCodec"
                androidx.media3.common.util.TraceUtil.a(r2)     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x0029 }
                android.media.MediaFormat r2 = r6.f11685b     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x0029 }
                android.view.Surface r3 = r6.f11687d     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x0029 }
                android.media.MediaCrypto r4 = r6.f11688e     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x0029 }
                int r6 = r6.f11689f     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x0029 }
                r1.configure(r2, r3, r4, r6)     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x0029 }
                androidx.media3.common.util.TraceUtil.c()     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x0029 }
                java.lang.String r6 = "startCodec"
                androidx.media3.common.util.TraceUtil.a(r6)     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x0029 }
                r1.start()     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x0029 }
                androidx.media3.common.util.TraceUtil.c()     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x0029 }
                androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecAdapter r6 = new androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecAdapter     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x0029 }
                r6.<init>(r1)     // Catch:{ IOException -> 0x002c, RuntimeException -> 0x0029 }
                return r6
            L_0x0029:
                r6 = move-exception
            L_0x002a:
                r0 = r1
                goto L_0x0031
            L_0x002c:
                r6 = move-exception
                goto L_0x002a
            L_0x002e:
                r6 = move-exception
                goto L_0x0031
            L_0x0030:
                r6 = move-exception
            L_0x0031:
                if (r0 == 0) goto L_0x0036
                r0.release()
            L_0x0036:
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.mediacodec.SynchronousMediaCodecAdapter.Factory.a(androidx.media3.exoplayer.mediacodec.MediaCodecAdapter$Configuration):androidx.media3.exoplayer.mediacodec.MediaCodecAdapter");
        }

        /* access modifiers changed from: protected */
        public MediaCodec b(MediaCodecAdapter.Configuration configuration) throws IOException {
            Assertions.g(configuration.f11684a);
            String str = configuration.f11684a.f11693a;
            TraceUtil.a("createCodec:" + str);
            MediaCodec createByCodecName = MediaCodec.createByCodecName(str);
            TraceUtil.c();
            return createByCodecName;
        }
    }

    private SynchronousMediaCodecAdapter(MediaCodec mediaCodec) {
        this.f11730a = mediaCodec;
        if (Util.f9646a < 21) {
            this.f11731b = mediaCodec.getInputBuffers();
            this.f11732c = mediaCodec.getOutputBuffers();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, MediaCodec mediaCodec, long j2, long j3) {
        onFrameRenderedListener.a(this, j2, j3);
    }

    public void a() {
        this.f11731b = null;
        this.f11732c = null;
        this.f11730a.release();
    }

    @RequiresApi(19)
    public void b(Bundle bundle) {
        this.f11730a.setParameters(bundle);
    }

    @RequiresApi(26)
    public PersistableBundle c() {
        return this.f11730a.getMetrics();
    }

    public void d(int i2, int i3, int i4, long j2, int i5) {
        this.f11730a.queueInputBuffer(i2, i3, i4, j2, i5);
    }

    public void e(int i2, int i3, CryptoInfo cryptoInfo, long j2, int i4) {
        this.f11730a.queueSecureInputBuffer(i2, i3, cryptoInfo.a(), j2, i4);
    }

    public boolean f() {
        return false;
    }

    public void flush() {
        this.f11730a.flush();
    }

    @RequiresApi(23)
    public void g(MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, Handler handler) {
        this.f11730a.setOnFrameRenderedListener(new B(this, onFrameRenderedListener), handler);
    }

    public MediaFormat h() {
        return this.f11730a.getOutputFormat();
    }

    @RequiresApi(21)
    public void i(int i2, long j2) {
        this.f11730a.releaseOutputBuffer(i2, j2);
    }

    public int j() {
        return this.f11730a.dequeueInputBuffer(0);
    }

    public int k(MediaCodec.BufferInfo bufferInfo) {
        int dequeueOutputBuffer;
        do {
            dequeueOutputBuffer = this.f11730a.dequeueOutputBuffer(bufferInfo, 0);
            if (dequeueOutputBuffer == -3 && Util.f9646a < 21) {
                this.f11732c = this.f11730a.getOutputBuffers();
                continue;
            }
        } while (dequeueOutputBuffer == -3);
        return dequeueOutputBuffer;
    }

    public void l(int i2) {
        this.f11730a.setVideoScalingMode(i2);
    }

    public void m(int i2, boolean z) {
        this.f11730a.releaseOutputBuffer(i2, z);
    }

    @Nullable
    public ByteBuffer n(int i2) {
        return Util.f9646a >= 21 ? this.f11730a.getInputBuffer(i2) : ((ByteBuffer[]) Util.o(this.f11731b))[i2];
    }

    @RequiresApi(23)
    public void o(Surface surface) {
        this.f11730a.setOutputSurface(surface);
    }

    @Nullable
    public ByteBuffer p(int i2) {
        return Util.f9646a >= 21 ? this.f11730a.getOutputBuffer(i2) : ((ByteBuffer[]) Util.o(this.f11732c))[i2];
    }
}
