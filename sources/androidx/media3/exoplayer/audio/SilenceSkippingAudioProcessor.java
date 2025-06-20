package androidx.media3.exoplayer.audio;

import androidx.media3.common.audio.AudioProcessor;
import androidx.media3.common.audio.BaseAudioProcessor;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.nio.ByteBuffer;

@UnstableApi
public final class SilenceSkippingAudioProcessor extends BaseAudioProcessor {
    public static final long A = 100000;
    public static final long B = 2000000;
    @Deprecated
    public static final long C = 20000;
    private static final int D = 0;
    private static final int E = 1;
    private static final int F = 0;
    private static final int G = 1;
    private static final int H = 2;
    private static final int I = 3;
    private static final int J = 1000;
    public static final float x = 0.2f;
    public static final int y = 10;
    public static final short z = 1024;

    /* renamed from: i  reason: collision with root package name */
    private final float f10910i;

    /* renamed from: j  reason: collision with root package name */
    private final short f10911j;

    /* renamed from: k  reason: collision with root package name */
    private final int f10912k;

    /* renamed from: l  reason: collision with root package name */
    private final long f10913l;

    /* renamed from: m  reason: collision with root package name */
    private final long f10914m;

    /* renamed from: n  reason: collision with root package name */
    private AudioProcessor.AudioFormat f10915n;
    private int o;
    private boolean p;
    private int q;
    private long r;
    private int s;
    private byte[] t;
    private int u;
    private int v;
    private byte[] w;

    public SilenceSkippingAudioProcessor() {
        this(A, 0.2f, B, 10, z);
    }

    private void A(int i2, int i3) {
        if (i2 != 0) {
            boolean z2 = true;
            Assertions.a(this.v >= i2);
            if (i3 == 2) {
                int i4 = this.u;
                int i5 = this.v;
                int i6 = i4 + i5;
                byte[] bArr = this.t;
                if (i6 <= bArr.length) {
                    System.arraycopy(bArr, (i4 + i5) - i2, this.w, 0, i2);
                } else {
                    int length = i5 - (bArr.length - i4);
                    if (length >= i2) {
                        System.arraycopy(bArr, length - i2, this.w, 0, i2);
                    } else {
                        int i7 = i2 - length;
                        System.arraycopy(bArr, bArr.length - i7, this.w, 0, i7);
                        System.arraycopy(this.t, 0, this.w, i7, length);
                    }
                }
            } else {
                int i8 = this.u;
                int i9 = i8 + i2;
                byte[] bArr2 = this.t;
                if (i9 <= bArr2.length) {
                    System.arraycopy(bArr2, i8, this.w, 0, i2);
                } else {
                    int length2 = bArr2.length - i8;
                    System.arraycopy(bArr2, i8, this.w, 0, length2);
                    System.arraycopy(this.t, 0, this.w, length2, i2 - length2);
                }
            }
            boolean z3 = i2 % this.o == 0;
            Assertions.b(z3, "sizeToOutput is not aligned to frame size: " + i2);
            if (this.u >= this.t.length) {
                z2 = false;
            }
            Assertions.i(z2);
            y(this.w, i2, i3);
        }
    }

    private void B(ByteBuffer byteBuffer) {
        int limit = byteBuffer.limit();
        byteBuffer.limit(Math.min(limit, byteBuffer.position() + this.t.length));
        int s2 = s(byteBuffer);
        if (s2 == byteBuffer.position()) {
            this.q = 1;
        } else {
            byteBuffer.limit(Math.min(s2, byteBuffer.capacity()));
            x(byteBuffer);
        }
        byteBuffer.limit(limit);
    }

    private static void C(byte[] bArr, int i2, int i3) {
        if (i3 >= 32767) {
            bArr[i2] = -1;
            bArr[i2 + 1] = Byte.MAX_VALUE;
        } else if (i3 <= -32768) {
            bArr[i2] = 0;
            bArr[i2 + 1] = Byte.MIN_VALUE;
        } else {
            bArr[i2] = (byte) (i3 & 255);
            bArr[i2 + 1] = (byte) (i3 >> 8);
        }
    }

    private void E(ByteBuffer byteBuffer) {
        int i2;
        int i3;
        boolean z2 = true;
        Assertions.i(this.u < this.t.length);
        int limit = byteBuffer.limit();
        int t2 = t(byteBuffer);
        int position = t2 - byteBuffer.position();
        int i4 = this.u;
        int i5 = this.v;
        int i6 = i4 + i5;
        byte[] bArr = this.t;
        if (i6 < bArr.length) {
            i2 = bArr.length - (i5 + i4);
            i3 = i4 + i5;
        } else {
            int length = i5 - (bArr.length - i4);
            i2 = i4 - length;
            i3 = length;
        }
        boolean z3 = t2 < limit;
        int min = Math.min(position, i2);
        byteBuffer.limit(byteBuffer.position() + min);
        byteBuffer.get(this.t, i3, min);
        int i7 = this.v + min;
        this.v = i7;
        Assertions.i(i7 <= this.t.length);
        if (!z3 || position >= i2) {
            z2 = false;
        }
        z(z2);
        if (z2) {
            this.q = 0;
            this.s = 0;
        }
        byteBuffer.limit(limit);
    }

    private static int F(byte b2, byte b3) {
        return (b2 << 8) | (b3 & 255);
    }

    private int m(float f2) {
        return n((int) f2);
    }

    private int n(int i2) {
        int i3 = this.o;
        return (i2 / i3) * i3;
    }

    private int o(int i2, int i3) {
        int i4 = this.f10912k;
        return i4 + ((((100 - i4) * (i2 * 1000)) / i3) / 1000);
    }

    private int p(int i2, int i3) {
        return (((this.f10912k - 100) * ((i2 * 1000) / i3)) / 1000) + 100;
    }

    private int q(int i2) {
        int r2 = ((r(this.f10914m) - this.s) * this.o) - (this.t.length / 2);
        Assertions.i(r2 >= 0);
        return m(Math.min((((float) i2) * this.f10910i) + 0.5f, (float) r2));
    }

    private int r(long j2) {
        return (int) ((j2 * ((long) this.f10915n.f9382a)) / 1000000);
    }

    private int s(ByteBuffer byteBuffer) {
        for (int limit = byteBuffer.limit() - 1; limit >= byteBuffer.position(); limit -= 2) {
            if (v(byteBuffer.get(limit), byteBuffer.get(limit - 1))) {
                int i2 = this.o;
                return ((limit / i2) * i2) + i2;
            }
        }
        return byteBuffer.position();
    }

    private int t(ByteBuffer byteBuffer) {
        for (int position = byteBuffer.position() + 1; position < byteBuffer.limit(); position += 2) {
            if (v(byteBuffer.get(position), byteBuffer.get(position - 1))) {
                int i2 = this.o;
                return i2 * (position / i2);
            }
        }
        return byteBuffer.limit();
    }

    private boolean v(byte b2, byte b3) {
        return Math.abs(F(b2, b3)) > this.f10911j;
    }

    private void w(byte[] bArr, int i2, int i3) {
        if (i3 != 3) {
            for (int i4 = 0; i4 < i2; i4 += 2) {
                C(bArr, i4, (F(bArr[i4 + 1], bArr[i4]) * (i3 == 0 ? p(i4, i2 - 1) : i3 == 2 ? o(i4, i2 - 1) : this.f10912k)) / 100);
            }
        }
    }

    private void x(ByteBuffer byteBuffer) {
        l(byteBuffer.remaining()).put(byteBuffer).flip();
    }

    private void y(byte[] bArr, int i2, int i3) {
        boolean z2 = i2 % this.o == 0;
        Assertions.b(z2, "byteOutput size is not aligned to frame size " + i2);
        w(bArr, i2, i3);
        l(i2).put(bArr, 0, i2).flip();
    }

    private void z(boolean z2) {
        int i2;
        int i3;
        int i4 = this.v;
        byte[] bArr = this.t;
        if (i4 == bArr.length || z2) {
            boolean z3 = false;
            if (this.s == 0) {
                if (z2) {
                    A(i4, 3);
                    i2 = i4;
                } else {
                    Assertions.i(i4 >= bArr.length / 2);
                    i2 = this.t.length / 2;
                    A(i2, 0);
                }
                i3 = i2;
            } else if (z2) {
                int length = i4 - (bArr.length / 2);
                int length2 = (bArr.length / 2) + length;
                int q2 = q(length) + (this.t.length / 2);
                A(q2, 2);
                int i5 = length2;
                i3 = q2;
                i2 = i5;
            } else {
                i2 = i4 - (bArr.length / 2);
                i3 = q(i2);
                A(i3, 1);
            }
            Assertions.j(i2 % this.o == 0, "bytesConsumed is not aligned to frame size: %s" + i2);
            if (i4 >= i3) {
                z3 = true;
            }
            Assertions.i(z3);
            this.v -= i2;
            int i6 = this.u + i2;
            this.u = i6;
            this.u = i6 % this.t.length;
            int i7 = this.s;
            int i8 = this.o;
            this.s = i7 + (i3 / i8);
            this.r += (long) ((i2 - i3) / i8);
        }
    }

    public void D(boolean z2) {
        this.p = z2;
    }

    public boolean b() {
        return this.f10915n.f9382a != -1 && this.p;
    }

    public void e(ByteBuffer byteBuffer) {
        while (byteBuffer.hasRemaining() && !a()) {
            int i2 = this.q;
            if (i2 == 0) {
                B(byteBuffer);
            } else if (i2 == 1) {
                E(byteBuffer);
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: protected */
    public AudioProcessor.AudioFormat h(AudioProcessor.AudioFormat audioFormat) throws AudioProcessor.UnhandledAudioFormatException {
        if (audioFormat.f9384c == 2) {
            this.f10915n = audioFormat;
            this.o = audioFormat.f9383b * 2;
            return audioFormat;
        }
        throw new AudioProcessor.UnhandledAudioFormatException(audioFormat);
    }

    public void i() {
        int n2;
        if (b() && this.t.length != (n2 = n(r(this.f10913l) / 2) * 2)) {
            this.t = new byte[n2];
            this.w = new byte[n2];
        }
        this.q = 0;
        this.r = 0;
        this.s = 0;
        this.u = 0;
        this.v = 0;
    }

    public void j() {
        if (this.v > 0) {
            z(true);
            this.s = 0;
        }
    }

    public void k() {
        this.p = false;
        this.f10915n = AudioProcessor.AudioFormat.f9381e;
        byte[] bArr = Util.f9651f;
        this.t = bArr;
        this.w = bArr;
    }

    public long u() {
        return this.r;
    }

    public SilenceSkippingAudioProcessor(long j2, float f2, long j3, int i2, short s2) {
        boolean z2 = false;
        this.s = 0;
        this.u = 0;
        this.v = 0;
        if (f2 >= 0.0f && f2 <= 1.0f) {
            z2 = true;
        }
        Assertions.a(z2);
        this.f10913l = j2;
        this.f10910i = f2;
        this.f10914m = j3;
        this.f10912k = i2;
        this.f10911j = s2;
        this.f10915n = AudioProcessor.AudioFormat.f9381e;
        byte[] bArr = Util.f9651f;
        this.t = bArr;
        this.w = bArr;
    }

    @Deprecated
    public SilenceSkippingAudioProcessor(long j2, long j3, short s2) {
        this(j2, ((float) j3) / ((float) j2), j2, 0, s2);
    }
}
