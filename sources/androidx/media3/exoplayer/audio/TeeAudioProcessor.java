package androidx.media3.exoplayer.audio;

import androidx.annotation.Nullable;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.BaseAudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.WavUtil;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

@UnstableApi
public final class TeeAudioProcessor extends BaseAudioProcessor {

    /* renamed from: i  reason: collision with root package name */
    private final AudioBufferSink f10916i;

    public interface AudioBufferSink {
        void a(ByteBuffer byteBuffer);

        void b(int i2, int i3, int i4);
    }

    public static final class WavFileAudioBufferSink implements AudioBufferSink {

        /* renamed from: j  reason: collision with root package name */
        private static final String f10917j = "WaveFileAudioBufferSink";

        /* renamed from: k  reason: collision with root package name */
        private static final int f10918k = 4;

        /* renamed from: l  reason: collision with root package name */
        private static final int f10919l = 40;

        /* renamed from: m  reason: collision with root package name */
        private static final int f10920m = 44;

        /* renamed from: a  reason: collision with root package name */
        private final String f10921a;

        /* renamed from: b  reason: collision with root package name */
        private final byte[] f10922b;

        /* renamed from: c  reason: collision with root package name */
        private final ByteBuffer f10923c;

        /* renamed from: d  reason: collision with root package name */
        private int f10924d;

        /* renamed from: e  reason: collision with root package name */
        private int f10925e;

        /* renamed from: f  reason: collision with root package name */
        private int f10926f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private RandomAccessFile f10927g;

        /* renamed from: h  reason: collision with root package name */
        private int f10928h;

        /* renamed from: i  reason: collision with root package name */
        private int f10929i;

        public WavFileAudioBufferSink(String str) {
            this.f10921a = str;
            byte[] bArr = new byte[1024];
            this.f10922b = bArr;
            this.f10923c = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        }

        private String c() {
            String str = this.f10921a;
            int i2 = this.f10928h;
            this.f10928h = i2 + 1;
            return Util.S("%s-%04d.wav", str, Integer.valueOf(i2));
        }

        private void d() throws IOException {
            if (this.f10927g == null) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(c(), "rw");
                g(randomAccessFile);
                this.f10927g = randomAccessFile;
                this.f10929i = 44;
            }
        }

        private void e() throws IOException {
            RandomAccessFile randomAccessFile = this.f10927g;
            if (randomAccessFile != null) {
                try {
                    this.f10923c.clear();
                    this.f10923c.putInt(this.f10929i - 8);
                    randomAccessFile.seek(4);
                    randomAccessFile.write(this.f10922b, 0, 4);
                    this.f10923c.clear();
                    this.f10923c.putInt(this.f10929i - 44);
                    randomAccessFile.seek(40);
                    randomAccessFile.write(this.f10922b, 0, 4);
                } catch (IOException e2) {
                    Log.o(f10917j, "Error updating file size", e2);
                }
                try {
                    randomAccessFile.close();
                } finally {
                    this.f10927g = null;
                }
            }
        }

        private void f(ByteBuffer byteBuffer) throws IOException {
            RandomAccessFile randomAccessFile = (RandomAccessFile) Assertions.g(this.f10927g);
            while (byteBuffer.hasRemaining()) {
                int min = Math.min(byteBuffer.remaining(), this.f10922b.length);
                byteBuffer.get(this.f10922b, 0, min);
                randomAccessFile.write(this.f10922b, 0, min);
                this.f10929i += min;
            }
        }

        private void g(RandomAccessFile randomAccessFile) throws IOException {
            randomAccessFile.writeInt(WavUtil.f13168a);
            randomAccessFile.writeInt(-1);
            randomAccessFile.writeInt(WavUtil.f13169b);
            randomAccessFile.writeInt(WavUtil.f13170c);
            this.f10923c.clear();
            this.f10923c.putInt(16);
            this.f10923c.putShort((short) WavUtil.b(this.f10926f));
            this.f10923c.putShort((short) this.f10925e);
            this.f10923c.putInt(this.f10924d);
            int F0 = Util.F0(this.f10926f, this.f10925e);
            this.f10923c.putInt(this.f10924d * F0);
            this.f10923c.putShort((short) F0);
            this.f10923c.putShort((short) ((F0 * 8) / this.f10925e));
            randomAccessFile.write(this.f10922b, 0, this.f10923c.position());
            randomAccessFile.writeInt(1684108385);
            randomAccessFile.writeInt(-1);
        }

        public void a(ByteBuffer byteBuffer) {
            try {
                d();
                f(byteBuffer);
            } catch (IOException e2) {
                Log.e(f10917j, "Error writing data", e2);
            }
        }

        public void b(int i2, int i3, int i4) {
            try {
                e();
            } catch (IOException e2) {
                Log.e(f10917j, "Error resetting", e2);
            }
            this.f10924d = i2;
            this.f10925e = i3;
            this.f10926f = i4;
        }
    }

    public TeeAudioProcessor(AudioBufferSink audioBufferSink) {
        this.f10916i = (AudioBufferSink) Assertions.g(audioBufferSink);
    }

    private void m() {
        if (b()) {
            AudioBufferSink audioBufferSink = this.f10916i;
            AudioProcessor.AudioFormat audioFormat = this.f9386b;
            audioBufferSink.b(audioFormat.f9382a, audioFormat.f9383b, audioFormat.f9384c);
        }
    }

    public void e(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        if (remaining != 0) {
            this.f10916i.a(Util.M(byteBuffer));
            l(remaining).put(byteBuffer).flip();
        }
    }

    public AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) {
        return audioFormat;
    }

    /* access modifiers changed from: protected */
    public void i() {
        m();
    }

    /* access modifiers changed from: protected */
    public void j() {
        m();
    }

    /* access modifiers changed from: protected */
    public void k() {
        m();
    }
}
