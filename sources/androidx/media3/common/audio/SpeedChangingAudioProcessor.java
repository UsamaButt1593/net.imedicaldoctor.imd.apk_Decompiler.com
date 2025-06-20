package androidx.media3.common.audio;

import androidx.media3.common.C;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

@UnstableApi
public final class SpeedChangingAudioProcessor extends BaseAudioProcessor {

    /* renamed from: i  reason: collision with root package name */
    private final SpeedProvider f9427i;

    /* renamed from: j  reason: collision with root package name */
    private final SonicAudioProcessor f9428j = new SonicAudioProcessor();

    /* renamed from: k  reason: collision with root package name */
    private float f9429k = 1.0f;

    /* renamed from: l  reason: collision with root package name */
    private long f9430l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f9431m;

    public SpeedChangingAudioProcessor(SpeedProvider speedProvider) {
        this.f9427i = speedProvider;
    }

    private boolean m() {
        return this.f9429k != 1.0f;
    }

    public boolean c() {
        return super.c() && this.f9428j.c();
    }

    public ByteBuffer d() {
        return m() ? this.f9428j.d() : super.d();
    }

    public void e(ByteBuffer byteBuffer) {
        int i2;
        ByteBuffer byteBuffer2 = byteBuffer;
        long j2 = this.f9430l;
        AudioProcessor.AudioFormat audioFormat = this.f9386b;
        long c2 = Util.c2(j2, 1000000, ((long) audioFormat.f9382a) * ((long) audioFormat.f9385d));
        float a2 = this.f9427i.a(c2);
        if (a2 != this.f9429k) {
            this.f9429k = a2;
            if (m()) {
                this.f9428j.j(a2);
                this.f9428j.i(a2);
            }
            flush();
        }
        int limit = byteBuffer.limit();
        long b2 = this.f9427i.b(c2);
        if (b2 != C.f9084b) {
            long j3 = b2 - c2;
            AudioProcessor.AudioFormat audioFormat2 = this.f9386b;
            i2 = (int) Util.c2(j3, ((long) audioFormat2.f9382a) * ((long) audioFormat2.f9385d), 1000000);
            int i3 = this.f9386b.f9385d;
            int i4 = i3 - (i2 % i3);
            if (i4 != i3) {
                i2 += i4;
            }
            byteBuffer2.limit(Math.min(limit, byteBuffer.position() + i2));
        } else {
            i2 = -1;
        }
        long position = (long) byteBuffer.position();
        if (m()) {
            this.f9428j.e(byteBuffer2);
            if (i2 != -1 && ((long) byteBuffer.position()) - position == ((long) i2)) {
                this.f9428j.f();
                this.f9431m = true;
            }
        } else {
            ByteBuffer l2 = l(byteBuffer.remaining());
            if (byteBuffer.hasRemaining()) {
                l2.put(byteBuffer2);
            }
            l2.flip();
        }
        this.f9430l += ((long) byteBuffer.position()) - position;
        byteBuffer2.limit(limit);
    }

    public AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        return this.f9428j.g(audioFormat);
    }

    /* access modifiers changed from: protected */
    public void i() {
        this.f9428j.flush();
        this.f9431m = false;
    }

    /* access modifiers changed from: protected */
    public void j() {
        if (!this.f9431m) {
            this.f9428j.f();
            this.f9431m = true;
        }
    }

    /* access modifiers changed from: protected */
    public void k() {
        this.f9429k = 1.0f;
        this.f9430l = 0;
        this.f9428j.reset();
        this.f9431m = false;
    }
}
