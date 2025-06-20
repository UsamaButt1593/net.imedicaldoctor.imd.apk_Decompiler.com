package androidx.media3.exoplayer.mediacodec;

import android.os.Bundle;
import androidx.annotation.RequiresApi;
import androidx.media3.decoder.CryptoInfo;

interface MediaCodecBufferEnqueuer {
    void a();

    @RequiresApi(19)
    void b(Bundle bundle);

    void c() throws InterruptedException;

    void d(int i2, int i3, int i4, long j2, int i5);

    void e(int i2, int i3, CryptoInfo cryptoInfo, long j2, int i4);

    void flush();

    void shutdown();

    void start();
}
