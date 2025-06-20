package androidx.media3.common.audio;

import android.util.SparseArray;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import java.nio.ByteBuffer;

@UnstableApi
public final class ChannelMixingAudioProcessor extends BaseAudioProcessor {

    /* renamed from: i  reason: collision with root package name */
    private final SparseArray<ChannelMixingMatrix> f9393i = new SparseArray<>();

    public void e(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining() / this.f9386b.f9385d;
        ByteBuffer l2 = l(this.f9387c.f9385d * remaining);
        ByteBuffer byteBuffer2 = byteBuffer;
        ByteBuffer byteBuffer3 = l2;
        AudioMixingUtil.f(byteBuffer2, this.f9386b, byteBuffer3, this.f9387c, (ChannelMixingMatrix) Assertions.k(this.f9393i.get(this.f9386b.f9383b)), remaining, false);
        l2.flip();
    }

    /* access modifiers changed from: protected */
    public AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f9384c == 2) {
            ChannelMixingMatrix channelMixingMatrix = this.f9393i.get(audioFormat.f9383b);
            if (channelMixingMatrix != null) {
                return channelMixingMatrix.i() ? AudioProcessor.AudioFormat.f9381e : new AudioProcessor.AudioFormat(audioFormat.f9382a, channelMixingMatrix.f(), 2);
            }
            throw new AudioProcessor.UnhandledAudioFormatException("No mixing matrix for input channel count", audioFormat);
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    public void m(ChannelMixingMatrix channelMixingMatrix) {
        this.f9393i.put(channelMixingMatrix.d(), channelMixingMatrix);
    }
}
