package androidx.media3.common.audio;

import androidx.annotation.Nullable;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@UnstableApi
public final class AudioProcessingPipeline {

    /* renamed from: a  reason: collision with root package name */
    private final ImmutableList<AudioProcessor> f9374a;

    /* renamed from: b  reason: collision with root package name */
    private final List<AudioProcessor> f9375b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    private ByteBuffer[] f9376c = new ByteBuffer[0];

    /* renamed from: d  reason: collision with root package name */
    private AudioProcessor.AudioFormat f9377d;

    /* renamed from: e  reason: collision with root package name */
    private AudioProcessor.AudioFormat f9378e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f9379f;

    public AudioProcessingPipeline(ImmutableList<AudioProcessor> immutableList) {
        this.f9374a = immutableList;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f9381e;
        this.f9377d = audioFormat;
        this.f9378e = audioFormat;
        this.f9379f = false;
    }

    private int c() {
        return this.f9376c.length - 1;
    }

    private void h(ByteBuffer byteBuffer) {
        boolean z;
        for (boolean z2 = true; z2; z2 = z) {
            z = false;
            int i2 = 0;
            while (i2 <= c()) {
                if (!this.f9376c[i2].hasRemaining()) {
                    AudioProcessor audioProcessor = this.f9375b.get(i2);
                    if (!audioProcessor.c()) {
                        ByteBuffer byteBuffer2 = i2 > 0 ? this.f9376c[i2 - 1] : byteBuffer.hasRemaining() ? byteBuffer : AudioProcessor.f9380a;
                        audioProcessor.e(byteBuffer2);
                        this.f9376c[i2] = audioProcessor.d();
                        z |= ((long) byteBuffer2.remaining()) - ((long) byteBuffer2.remaining()) > 0 || this.f9376c[i2].hasRemaining();
                    } else if (!this.f9376c[i2].hasRemaining() && i2 < c()) {
                        this.f9375b.get(i2 + 1).f();
                    }
                }
                i2++;
            }
        }
    }

    @CanIgnoreReturnValue
    public AudioProcessor.AudioFormat a(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (!audioFormat.equals(AudioProcessor.AudioFormat.f9381e)) {
            for (int i2 = 0; i2 < this.f9374a.size(); i2++) {
                AudioProcessor audioProcessor = this.f9374a.get(i2);
                AudioProcessor.AudioFormat g2 = audioProcessor.g(audioFormat);
                if (audioProcessor.b()) {
                    Assertions.i(!g2.equals(AudioProcessor.AudioFormat.f9381e));
                    audioFormat = g2;
                }
            }
            this.f9378e = audioFormat;
            return audioFormat;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    public void b() {
        this.f9375b.clear();
        this.f9377d = this.f9378e;
        this.f9379f = false;
        for (int i2 = 0; i2 < this.f9374a.size(); i2++) {
            AudioProcessor audioProcessor = this.f9374a.get(i2);
            audioProcessor.flush();
            if (audioProcessor.b()) {
                this.f9375b.add(audioProcessor);
            }
        }
        this.f9376c = new ByteBuffer[this.f9375b.size()];
        for (int i3 = 0; i3 <= c(); i3++) {
            this.f9376c[i3] = this.f9375b.get(i3).d();
        }
    }

    public ByteBuffer d() {
        if (!g()) {
            return AudioProcessor.f9380a;
        }
        ByteBuffer byteBuffer = this.f9376c[c()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        h(AudioProcessor.f9380a);
        return this.f9376c[c()];
    }

    public AudioProcessor.AudioFormat e() {
        return this.f9377d;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioProcessingPipeline)) {
            return false;
        }
        AudioProcessingPipeline audioProcessingPipeline = (AudioProcessingPipeline) obj;
        if (this.f9374a.size() != audioProcessingPipeline.f9374a.size()) {
            return false;
        }
        for (int i2 = 0; i2 < this.f9374a.size(); i2++) {
            if (this.f9374a.get(i2) != audioProcessingPipeline.f9374a.get(i2)) {
                return false;
            }
        }
        return true;
    }

    public boolean f() {
        return this.f9379f && this.f9375b.get(c()).c() && !this.f9376c[c()].hasRemaining();
    }

    public boolean g() {
        return !this.f9375b.isEmpty();
    }

    public int hashCode() {
        return this.f9374a.hashCode();
    }

    public void i() {
        if (g() && !this.f9379f) {
            this.f9379f = true;
            this.f9375b.get(0).f();
        }
    }

    public void j(ByteBuffer byteBuffer) {
        if (g() && !this.f9379f) {
            h(byteBuffer);
        }
    }

    public void k() {
        for (int i2 = 0; i2 < this.f9374a.size(); i2++) {
            AudioProcessor audioProcessor = this.f9374a.get(i2);
            audioProcessor.flush();
            audioProcessor.reset();
        }
        this.f9376c = new ByteBuffer[0];
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f9381e;
        this.f9377d = audioFormat;
        this.f9378e = audioFormat;
        this.f9379f = false;
    }
}
