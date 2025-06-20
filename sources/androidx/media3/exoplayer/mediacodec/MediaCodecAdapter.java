package androidx.media3.exoplayer.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.Surface;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.CryptoInfo;
import java.io.IOException;
import java.nio.ByteBuffer;

@UnstableApi
public interface MediaCodecAdapter {

    public static final class Configuration {

        /* renamed from: a  reason: collision with root package name */
        public final MediaCodecInfo f11684a;

        /* renamed from: b  reason: collision with root package name */
        public final MediaFormat f11685b;

        /* renamed from: c  reason: collision with root package name */
        public final Format f11686c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        public final Surface f11687d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        public final MediaCrypto f11688e;

        /* renamed from: f  reason: collision with root package name */
        public final int f11689f;

        private Configuration(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, Format format, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto, int i2) {
            this.f11684a = mediaCodecInfo;
            this.f11685b = mediaFormat;
            this.f11686c = format;
            this.f11687d = surface;
            this.f11688e = mediaCrypto;
            this.f11689f = i2;
        }

        public static Configuration a(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, Format format, @Nullable MediaCrypto mediaCrypto) {
            return new Configuration(mediaCodecInfo, mediaFormat, format, (Surface) null, mediaCrypto, 0);
        }

        public static Configuration b(MediaCodecInfo mediaCodecInfo, MediaFormat mediaFormat, Format format, @Nullable Surface surface, @Nullable MediaCrypto mediaCrypto) {
            return new Configuration(mediaCodecInfo, mediaFormat, format, surface, mediaCrypto, 0);
        }
    }

    public interface Factory {
        @Deprecated

        /* renamed from: a  reason: collision with root package name */
        public static final Factory f11690a = new DefaultMediaCodecAdapterFactory();

        MediaCodecAdapter a(Configuration configuration) throws IOException;
    }

    public interface OnFrameRenderedListener {
        void a(MediaCodecAdapter mediaCodecAdapter, long j2, long j3);
    }

    void a();

    @RequiresApi(19)
    void b(Bundle bundle);

    @RequiresApi(26)
    PersistableBundle c();

    void d(int i2, int i3, int i4, long j2, int i5);

    void e(int i2, int i3, CryptoInfo cryptoInfo, long j2, int i4);

    boolean f();

    void flush();

    @RequiresApi(23)
    void g(OnFrameRenderedListener onFrameRenderedListener, Handler handler);

    MediaFormat h();

    @RequiresApi(21)
    void i(int i2, long j2);

    int j();

    int k(MediaCodec.BufferInfo bufferInfo);

    void l(int i2);

    void m(int i2, boolean z);

    @Nullable
    ByteBuffer n(int i2);

    @RequiresApi(23)
    void o(Surface surface);

    @Nullable
    ByteBuffer p(int i2);
}
