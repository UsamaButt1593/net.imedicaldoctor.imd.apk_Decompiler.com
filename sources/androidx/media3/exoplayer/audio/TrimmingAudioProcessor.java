package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.BaseAudioProcessor;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

final class TrimmingAudioProcessor extends BaseAudioProcessor {
    private static final int p = 2;

    /* renamed from: i  reason: collision with root package name */
    private int f10932i;

    /* renamed from: j  reason: collision with root package name */
    private int f10933j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f10934k;

    /* renamed from: l  reason: collision with root package name */
    private int f10935l;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f10936m = Util.f9651f;

    /* renamed from: n  reason: collision with root package name */
    private int f10937n;
    private long o;

    public boolean c() {
        return super.c() && this.f10937n == 0;
    }

    public ByteBuffer d() {
        int i2;
        if (super.c() && (i2 = this.f10937n) > 0) {
            l(i2).put(this.f10936m, 0, this.f10937n).flip();
            this.f10937n = 0;
        }
        return super.d();
    }

    public void e(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit();
        int i2 = limit - position;
        if (i2 != 0) {
            int min = Math.min(i2, this.f10935l);
            this.o += (long) (min / this.f9386b.f9385d);
            this.f10935l -= min;
            byteBuffer.position(position + min);
            if (this.f10935l <= 0) {
                int i3 = i2 - min;
                int length = (this.f10937n + i3) - this.f10936m.length;
                ByteBuffer l2 = l(length);
                int w = Util.w(length, 0, this.f10937n);
                l2.put(this.f10936m, 0, w);
                int w2 = Util.w(length - w, 0, i3);
                byteBuffer.limit(byteBuffer.position() + w2);
                l2.put(byteBuffer);
                byteBuffer.limit(limit);
                int i4 = i3 - w2;
                int i5 = this.f10937n - w;
                this.f10937n = i5;
                byte[] bArr = this.f10936m;
                System.arraycopy(bArr, w, bArr, 0, i5);
                byteBuffer.get(this.f10936m, this.f10937n, i4);
                this.f10937n += i4;
                l2.flip();
            }
        }
    }

    public AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f9384c == 2) {
            this.f10934k = true;
            return (this.f10932i == 0 && this.f10933j == 0) ? AudioProcessor.AudioFormat.f9381e : audioFormat;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    /* access modifiers changed from: protected */
    public void i() {
        if (this.f10934k) {
            this.f10934k = false;
            int i2 = this.f10933j;
            int i3 = this.f9386b.f9385d;
            this.f10936m = new byte[(i2 * i3)];
            this.f10935l = this.f10932i * i3;
        }
        this.f10937n = 0;
    }

    /* access modifiers changed from: protected */
    public void j() {
        if (this.f10934k) {
            int i2 = this.f10937n;
            if (i2 > 0) {
                this.o += (long) (i2 / this.f9386b.f9385d);
            }
            this.f10937n = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void k() {
        this.f10936m = Util.f9651f;
    }

    public long m() {
        return this.o;
    }

    public void n() {
        this.o = 0;
    }

    public void o(int i2, int i3) {
        this.f10932i = i2;
        this.f10933j = i3;
    }
}
