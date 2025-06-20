package androidx.media3.common.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

@UnstableApi
public final class AudioMixingUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final float f9372a = -1.0f;

    /* renamed from: b  reason: collision with root package name */
    private static final float f9373b = 1.0f;

    private AudioMixingUtil() {
    }

    public static boolean a(AudioProcessor.AudioFormat audioFormat) {
        if (audioFormat.f9382a == -1 || audioFormat.f9383b == -1) {
            return false;
        }
        int i2 = audioFormat.f9384c;
        return i2 == 2 || i2 == 4;
    }

    public static boolean b(AudioProcessor.AudioFormat audioFormat, AudioProcessor.AudioFormat audioFormat2) {
        return audioFormat.f9382a == audioFormat2.f9382a && a(audioFormat) && a(audioFormat2);
    }

    private static float c(float f2) {
        return Util.v(f2 * ((float) (f2 < 0.0f ? 32768 : 32767)), -32768.0f, 32767.0f);
    }

    private static float d(ByteBuffer byteBuffer, boolean z, boolean z2) {
        return z2 ? z ? (float) byteBuffer.getShort() : c(byteBuffer.getFloat()) : z ? e(byteBuffer.getShort()) : byteBuffer.getFloat();
    }

    private static float e(short s) {
        return ((float) s) / ((float) (s < 0 ? 32768 : 32767));
    }

    public static ByteBuffer f(ByteBuffer byteBuffer, AudioProcessor.AudioFormat audioFormat, ByteBuffer byteBuffer2, AudioProcessor.AudioFormat audioFormat2, ChannelMixingMatrix channelMixingMatrix, int i2, boolean z) {
        boolean z2;
        AudioProcessor.AudioFormat audioFormat3;
        ByteBuffer byteBuffer3 = byteBuffer2;
        boolean z3 = true;
        if (audioFormat.f9384c == 2) {
            audioFormat3 = audioFormat2;
            z2 = true;
        } else {
            audioFormat3 = audioFormat2;
            z2 = false;
        }
        if (audioFormat3.f9384c != 2) {
            z3 = false;
        }
        int d2 = channelMixingMatrix.d();
        int f2 = channelMixingMatrix.f();
        float[] fArr = new float[d2];
        float[] fArr2 = new float[f2];
        int i3 = i2;
        for (int i4 = 0; i4 < i3; i4++) {
            if (z) {
                int position = byteBuffer2.position();
                for (int i5 = 0; i5 < f2; i5++) {
                    fArr2[i5] = d(byteBuffer3, z3, z3);
                }
                byteBuffer3.position(position);
            }
            int i6 = 0;
            while (true) {
                ByteBuffer byteBuffer4 = byteBuffer;
                if (i6 >= d2) {
                    break;
                }
                fArr[i6] = d(byteBuffer4, z2, z3);
                i6++;
            }
            for (int i7 = 0; i7 < f2; i7++) {
                for (int i8 = 0; i8 < d2; i8++) {
                    fArr2[i7] = fArr2[i7] + (fArr[i8] * channelMixingMatrix.e(i8, i7));
                }
                ChannelMixingMatrix channelMixingMatrix2 = channelMixingMatrix;
                if (z3) {
                    byteBuffer3.putShort((short) ((int) Util.v(fArr2[i7], -32768.0f, 32767.0f)));
                } else {
                    byteBuffer3.putFloat(Util.v(fArr2[i7], f9372a, 1.0f));
                }
                fArr2[i7] = 0.0f;
            }
            ChannelMixingMatrix channelMixingMatrix3 = channelMixingMatrix;
        }
        return byteBuffer3;
    }
}
