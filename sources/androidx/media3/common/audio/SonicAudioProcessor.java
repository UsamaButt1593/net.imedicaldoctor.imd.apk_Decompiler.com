package androidx.media3.common.audio;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

@UnstableApi
public class SonicAudioProcessor implements AudioProcessor {
    public static final int q = -1;
    private static final float r = 1.0E-4f;
    private static final int s = 1024;

    /* renamed from: b  reason: collision with root package name */
    private int f9414b;

    /* renamed from: c  reason: collision with root package name */
    private float f9415c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    private float f9416d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    private AudioProcessor.AudioFormat f9417e;

    /* renamed from: f  reason: collision with root package name */
    private AudioProcessor.AudioFormat f9418f;

    /* renamed from: g  reason: collision with root package name */
    private AudioProcessor.AudioFormat f9419g;

    /* renamed from: h  reason: collision with root package name */
    private AudioProcessor.AudioFormat f9420h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9421i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private Sonic f9422j;

    /* renamed from: k  reason: collision with root package name */
    private ByteBuffer f9423k;

    /* renamed from: l  reason: collision with root package name */
    private ShortBuffer f9424l;

    /* renamed from: m  reason: collision with root package name */
    private ByteBuffer f9425m;

    /* renamed from: n  reason: collision with root package name */
    private long f9426n;
    private long o;
    private boolean p;

    public SonicAudioProcessor() {
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f9381e;
        this.f9417e = audioFormat;
        this.f9418f = audioFormat;
        this.f9419g = audioFormat;
        this.f9420h = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.f9380a;
        this.f9423k = byteBuffer;
        this.f9424l = byteBuffer.asShortBuffer();
        this.f9425m = byteBuffer;
        this.f9414b = -1;
    }

    public final long a(long j2) {
        if (this.o < PlaybackStateCompat.p3) {
            return (long) (((double) this.f9415c) * ((double) j2));
        }
        long l2 = this.f9426n - ((long) ((Sonic) Assertions.g(this.f9422j)).l());
        int i2 = this.f9420h.f9382a;
        int i3 = this.f9419g.f9382a;
        if (i2 == i3) {
            return Util.c2(j2, l2, this.o);
        }
        return Util.c2(j2, l2 * ((long) i2), this.o * ((long) i3));
    }

    public final boolean b() {
        return this.f9418f.f9382a != -1 && (Math.abs(this.f9415c - 1.0f) >= 1.0E-4f || Math.abs(this.f9416d - 1.0f) >= 1.0E-4f || this.f9418f.f9382a != this.f9417e.f9382a);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f9422j;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean c() {
        /*
            r1 = this;
            boolean r0 = r1.p
            if (r0 == 0) goto L_0x0010
            androidx.media3.common.audio.Sonic r0 = r1.f9422j
            if (r0 == 0) goto L_0x000e
            int r0 = r0.k()
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.common.audio.SonicAudioProcessor.c():boolean");
    }

    public final ByteBuffer d() {
        int k2;
        Sonic sonic = this.f9422j;
        if (sonic != null && (k2 = sonic.k()) > 0) {
            if (this.f9423k.capacity() < k2) {
                ByteBuffer order = ByteBuffer.allocateDirect(k2).order(ByteOrder.nativeOrder());
                this.f9423k = order;
                this.f9424l = order.asShortBuffer();
            } else {
                this.f9423k.clear();
                this.f9424l.clear();
            }
            sonic.j(this.f9424l);
            this.o += (long) k2;
            this.f9423k.limit(k2);
            this.f9425m = this.f9423k;
        }
        ByteBuffer byteBuffer = this.f9425m;
        this.f9425m = AudioProcessor.f9380a;
        return byteBuffer;
    }

    public final void e(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f9426n += (long) remaining;
            ((Sonic) Assertions.g(this.f9422j)).t(asShortBuffer);
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    public final void f() {
        Sonic sonic = this.f9422j;
        if (sonic != null) {
            sonic.s();
        }
        this.p = true;
    }

    public final void flush() {
        if (b()) {
            AudioProcessor.AudioFormat audioFormat = this.f9417e;
            this.f9419g = audioFormat;
            AudioProcessor.AudioFormat audioFormat2 = this.f9418f;
            this.f9420h = audioFormat2;
            if (this.f9421i) {
                this.f9422j = new Sonic(audioFormat.f9382a, audioFormat.f9383b, this.f9415c, this.f9416d, audioFormat2.f9382a);
            } else {
                Sonic sonic = this.f9422j;
                if (sonic != null) {
                    sonic.i();
                }
            }
        }
        this.f9425m = AudioProcessor.f9380a;
        this.f9426n = 0;
        this.o = 0;
        this.p = false;
    }

    public final AudioProcessor.AudioFormat g(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f9384c == 2) {
            int i2 = this.f9414b;
            if (i2 == -1) {
                i2 = audioFormat.f9382a;
            }
            this.f9417e = audioFormat;
            AudioProcessor.AudioFormat audioFormat2 = new AudioProcessor.AudioFormat(i2, audioFormat.f9383b, 2);
            this.f9418f = audioFormat2;
            this.f9421i = true;
            return audioFormat2;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    public final void h(int i2) {
        this.f9414b = i2;
    }

    public final void i(float f2) {
        if (this.f9416d != f2) {
            this.f9416d = f2;
            this.f9421i = true;
        }
    }

    public final void j(float f2) {
        if (this.f9415c != f2) {
            this.f9415c = f2;
            this.f9421i = true;
        }
    }

    public final void reset() {
        this.f9415c = 1.0f;
        this.f9416d = 1.0f;
        AudioProcessor.AudioFormat audioFormat = AudioProcessor.AudioFormat.f9381e;
        this.f9417e = audioFormat;
        this.f9418f = audioFormat;
        this.f9419g = audioFormat;
        this.f9420h = audioFormat;
        ByteBuffer byteBuffer = AudioProcessor.f9380a;
        this.f9423k = byteBuffer;
        this.f9424l = byteBuffer.asShortBuffer();
        this.f9425m = byteBuffer;
        this.f9414b = -1;
        this.f9421i = false;
        this.f9422j = null;
        this.f9426n = 0;
        this.o = 0;
        this.p = false;
    }
}
