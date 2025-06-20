package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.CryptoInfo;

@RequiresApi(23)
@UnstableApi
class SynchronousMediaCodecBufferEnqueuer implements MediaCodecBufferEnqueuer {

    /* renamed from: a  reason: collision with root package name */
    private final MediaCodec f11733a;

    public SynchronousMediaCodecBufferEnqueuer(MediaCodec mediaCodec) {
        this.f11733a = mediaCodec;
    }

    public void a() {
    }

    public void b(Bundle bundle) {
        this.f11733a.setParameters(bundle);
    }

    public void c() {
    }

    public void d(int i2, int i3, int i4, long j2, int i5) {
        this.f11733a.queueInputBuffer(i2, i3, i4, j2, i5);
    }

    public void e(int i2, int i3, CryptoInfo cryptoInfo, long j2, int i4) {
        this.f11733a.queueSecureInputBuffer(i2, i3, cryptoInfo.a(), j2, i4);
    }

    public void flush() {
    }

    public void shutdown() {
    }

    public void start() {
    }
}
