package androidx.media3.exoplayer.audio;

import android.util.SparseArray;
import androidx.annotation.FloatRange;
import androidx.media3.common.audio.AudioMixingUtil;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.ChannelMixingMatrix;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.exoplayer.audio.TeeAudioProcessor;
import com.google.common.base.Preconditions;
import java.nio.ByteBuffer;

@UnstableApi
public class WaveformAudioBufferSink implements TeeAudioProcessor.AudioBufferSink {

    /* renamed from: a  reason: collision with root package name */
    private final int f10938a;

    /* renamed from: b  reason: collision with root package name */
    private final Listener f10939b;

    /* renamed from: c  reason: collision with root package name */
    private final SparseArray<WaveformBar> f10940c;

    /* renamed from: d  reason: collision with root package name */
    private final ByteBuffer f10941d;

    /* renamed from: e  reason: collision with root package name */
    private AudioProcessor.AudioFormat f10942e;

    /* renamed from: f  reason: collision with root package name */
    private AudioProcessor.AudioFormat f10943f;

    /* renamed from: g  reason: collision with root package name */
    private ChannelMixingMatrix f10944g;

    /* renamed from: h  reason: collision with root package name */
    private int f10945h;

    public interface Listener {
        void a(int i2, WaveformBar waveformBar);
    }

    public static class WaveformBar {

        /* renamed from: a  reason: collision with root package name */
        private float f10946a = 1.0f;

        /* renamed from: b  reason: collision with root package name */
        private float f10947b = -1.0f;

        /* renamed from: c  reason: collision with root package name */
        private double f10948c;

        /* renamed from: d  reason: collision with root package name */
        private int f10949d;

        public void a(@FloatRange(from = -1.0d, to = 1.0d) float f2) {
            Preconditions.d(f2 >= -1.0f && f2 <= 1.0f);
            this.f10946a = Math.min(this.f10946a, f2);
            this.f10947b = Math.max(this.f10947b, f2);
            double d2 = (double) f2;
            this.f10948c += d2 * d2;
            this.f10949d++;
        }

        public double b() {
            return (double) this.f10947b;
        }

        public double c() {
            return (double) this.f10946a;
        }

        public double d() {
            return Math.sqrt(this.f10948c / ((double) this.f10949d));
        }

        public int e() {
            return this.f10949d;
        }
    }

    public WaveformAudioBufferSink(int i2, int i3, Listener listener) {
        this.f10938a = i2;
        this.f10939b = listener;
        this.f10941d = ByteBuffer.allocate(Util.F0(4, i3));
        this.f10940c = new SparseArray<>(i3);
        for (int i4 = 0; i4 < i3; i4++) {
            this.f10940c.append(i4, new WaveformBar());
        }
    }

    public void a(ByteBuffer byteBuffer) {
        Assertions.k(this.f10942e);
        Assertions.k(this.f10943f);
        Assertions.k(this.f10944g);
        while (byteBuffer.hasRemaining()) {
            this.f10941d.rewind();
            AudioMixingUtil.f(byteBuffer, this.f10942e, this.f10941d, this.f10943f, this.f10944g, 1, false);
            this.f10941d.rewind();
            for (int i2 = 0; i2 < this.f10940c.size(); i2++) {
                WaveformBar waveformBar = this.f10940c.get(i2);
                waveformBar.a(this.f10941d.getFloat());
                if (waveformBar.e() >= this.f10945h) {
                    this.f10939b.a(i2, waveformBar);
                    this.f10940c.put(i2, new WaveformBar());
                }
            }
        }
    }

    public void b(int i2, int i3, int i4) {
        this.f10945h = i2 / this.f10938a;
        this.f10942e = new AudioProcessor.AudioFormat(i2, i3, i4);
        this.f10943f = new AudioProcessor.AudioFormat(i2, this.f10940c.size(), 4);
        this.f10944g = ChannelMixingMatrix.b(i3, this.f10940c.size());
    }
}
