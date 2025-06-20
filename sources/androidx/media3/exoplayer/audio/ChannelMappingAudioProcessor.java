package androidx.media3.exoplayer.audio;

import androidx.annotation.Nullable;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.BaseAudioProcessor;
import androidx.media3.common.util.Assertions;
import java.nio.ByteBuffer;

final class ChannelMappingAudioProcessor extends BaseAudioProcessor {
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private int[] f10825i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private int[] f10826j;

    ChannelMappingAudioProcessor() {
    }

    public void e(ByteBuffer byteBuffer) {
        int[] iArr = (int[]) Assertions.g(this.f10826j);
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        ByteBuffer l2 = l(((limit - position) / this.f9386b.f9385d) * this.f9387c.f9385d);
        while (position < limit) {
            for (int i2 : iArr) {
                l2.putShort(byteBuffer.getShort((i2 * 2) + position));
            }
            position += this.f9386b.f9385d;
        }
        byteBuffer.position(limit);
        l2.flip();
    }

    public AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        int[] iArr = this.f10825i;
        if (iArr == null) {
            return AudioProcessor.AudioFormat.f9381e;
        }
        if (audioFormat.f9384c == 2) {
            boolean z = audioFormat.f9383b != iArr.length;
            int i2 = 0;
            while (i2 < iArr.length) {
                int i3 = iArr[i2];
                if (i3 < audioFormat.f9383b) {
                    z |= i3 != i2;
                    i2++;
                } else {
                    throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
                }
            }
            return z ? new AudioProcessor.AudioFormat(audioFormat.f9382a, iArr.length, 2) : AudioProcessor.AudioFormat.f9381e;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    /* access modifiers changed from: protected */
    public void i() {
        this.f10826j = this.f10825i;
    }

    /* access modifiers changed from: protected */
    public void k() {
        this.f10826j = null;
        this.f10825i = null;
    }

    public void m(@Nullable int[] iArr) {
        this.f10825i = iArr;
    }
}
