package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.BaseAudioProcessor;
import androidx.media3.common.util.Util;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;

final class ToFloatPcmAudioProcessor extends BaseAudioProcessor {

    /* renamed from: i  reason: collision with root package name */
    private static final int f10930i = Float.floatToIntBits(Float.NaN);

    /* renamed from: j  reason: collision with root package name */
    private static final double f10931j = 4.656612875245797E-10d;

    ToFloatPcmAudioProcessor() {
    }

    private static void m(int i2, ByteBuffer byteBuffer) {
        int floatToIntBits = Float.floatToIntBits((float) (((double) i2) * f10931j));
        if (floatToIntBits == f10930i) {
            floatToIntBits = Float.floatToIntBits(0.0f);
        }
        byteBuffer.putInt(floatToIntBits);
    }

    public void e(ByteBuffer byteBuffer) {
        ByteBuffer byteBuffer2;
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        int i3 = this.f9386b.f9384c;
        if (i3 == 21) {
            byteBuffer2 = l((i2 / 3) * 4);
            while (position < limit) {
                m(((byteBuffer.get(position) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position + 2) & 255) << Ascii.B), byteBuffer2);
                position += 3;
            }
        } else if (i3 == 22) {
            byteBuffer2 = l(i2);
            while (position < limit) {
                m((byteBuffer.get(position) & 255) | ((byteBuffer.get(position + 1) & 255) << 8) | ((byteBuffer.get(position + 2) & 255) << 16) | ((byteBuffer.get(position + 3) & 255) << Ascii.B), byteBuffer2);
                position += 4;
            }
        } else if (i3 == 1342177280) {
            byteBuffer2 = l((i2 / 3) * 4);
            while (position < limit) {
                m(((byteBuffer.get(position + 2) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position) & 255) << Ascii.B), byteBuffer2);
                position += 3;
            }
        } else if (i3 == 1610612736) {
            byteBuffer2 = l(i2);
            while (position < limit) {
                m((byteBuffer.get(position + 3) & 255) | ((byteBuffer.get(position + 2) & 255) << 8) | ((byteBuffer.get(position + 1) & 255) << 16) | ((byteBuffer.get(position) & 255) << Ascii.B), byteBuffer2);
                position += 4;
            }
        } else {
            throw new IllegalStateException();
        }
        byteBuffer.position(byteBuffer.limit());
        byteBuffer2.flip();
    }

    public AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int i2 = audioFormat.f9384c;
        if (Util.h1(i2)) {
            return i2 != 4 ? new AudioProcessor.AudioFormat(audioFormat.f9382a, audioFormat.f9383b, 4) : AudioProcessor.AudioFormat.f9381e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }
}
