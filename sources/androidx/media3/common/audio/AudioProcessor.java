package androidx.media3.common.audio;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.google.common.base.Objects;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.apache.commons.lang3.StringUtils;

@UnstableApi
public interface AudioProcessor {

    /* renamed from: a  reason: collision with root package name */
    public static final ByteBuffer f9380a = ByteBuffer.allocateDirect(0).order(ByteOrder.nativeOrder());

    public static final class AudioFormat {

        /* renamed from: e  reason: collision with root package name */
        public static final AudioFormat f9381e = new AudioFormat(-1, -1, -1);

        /* renamed from: a  reason: collision with root package name */
        public final int f9382a;

        /* renamed from: b  reason: collision with root package name */
        public final int f9383b;

        /* renamed from: c  reason: collision with root package name */
        public final int f9384c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9385d;

        public AudioFormat(int i2, int i3, int i4) {
            this.f9382a = i2;
            this.f9383b = i3;
            this.f9384c = i4;
            this.f9385d = Util.i1(i4) ? Util.F0(i4, i3) : -1;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AudioFormat)) {
                return false;
            }
            AudioFormat audioFormat = (AudioFormat) obj;
            return this.f9382a == audioFormat.f9382a && this.f9383b == audioFormat.f9383b && this.f9384c == audioFormat.f9384c;
        }

        public int hashCode() {
            return Objects.b(Integer.valueOf(this.f9382a), Integer.valueOf(this.f9383b), Integer.valueOf(this.f9384c));
        }

        public String toString() {
            return "AudioFormat[sampleRate=" + this.f9382a + ", channelCount=" + this.f9383b + ", encoding=" + this.f9384c + ']';
        }

        public AudioFormat(Format format) {
            this(format.t3, format.s3, format.u3);
        }
    }

    public static final class UnhandledAudioFormatException extends Exception {
        public final AudioFormat s;

        public UnhandledAudioFormatException(AudioFormat audioFormat) {
            this("Unhandled input format:", audioFormat);
        }

        public UnhandledAudioFormatException(String str, AudioFormat audioFormat) {
            super(str + StringUtils.SPACE + audioFormat);
            this.s = audioFormat;
        }
    }

    boolean b();

    boolean c();

    ByteBuffer d();

    void e(ByteBuffer byteBuffer);

    void f();

    void flush();

    AudioFormat g(AudioFormat audioFormat) throws UnhandledAudioFormatException;

    void reset();
}
