package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
abstract class AbstractHasher implements Hasher {
    AbstractHasher() {
    }

    @CanIgnoreReturnValue
    public final Hasher a(double d2) {
        return f(Double.doubleToRawLongBits(d2));
    }

    @CanIgnoreReturnValue
    public Hasher b(short s) {
        h((byte) s);
        h((byte) (s >>> 8));
        return this;
    }

    @CanIgnoreReturnValue
    public final Hasher c(boolean z) {
        return h(z ? (byte) 1 : 0);
    }

    @CanIgnoreReturnValue
    public final Hasher d(float f2) {
        return e(Float.floatToRawIntBits(f2));
    }

    @CanIgnoreReturnValue
    public Hasher e(int i2) {
        h((byte) i2);
        h((byte) (i2 >>> 8));
        h((byte) (i2 >>> 16));
        h((byte) (i2 >>> 24));
        return this;
    }

    @CanIgnoreReturnValue
    public Hasher f(long j2) {
        for (int i2 = 0; i2 < 64; i2 += 8) {
            h((byte) ((int) (j2 >>> i2)));
        }
        return this;
    }

    @CanIgnoreReturnValue
    public Hasher g(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    public /* bridge */ /* synthetic */ PrimitiveSink h(byte b2) {
        return h(b2);
    }

    @CanIgnoreReturnValue
    public Hasher i(CharSequence charSequence) {
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            k(charSequence.charAt(i2));
        }
        return this;
    }

    @CanIgnoreReturnValue
    public Hasher j(byte[] bArr, int i2, int i3) {
        Preconditions.f0(i2, i2 + i3, bArr.length);
        for (int i4 = 0; i4 < i3; i4++) {
            h(bArr[i2 + i4]);
        }
        return this;
    }

    @CanIgnoreReturnValue
    public Hasher k(char c2) {
        h((byte) c2);
        h((byte) (c2 >>> 8));
        return this;
    }

    @CanIgnoreReturnValue
    public Hasher l(ByteBuffer byteBuffer) {
        if (byteBuffer.hasArray()) {
            j(byteBuffer.array(), byteBuffer.arrayOffset() + byteBuffer.position(), byteBuffer.remaining());
            Java8Compatibility.d(byteBuffer, byteBuffer.limit());
        } else {
            for (int remaining = byteBuffer.remaining(); remaining > 0; remaining--) {
                h(byteBuffer.get());
            }
        }
        return this;
    }

    @CanIgnoreReturnValue
    public Hasher m(CharSequence charSequence, Charset charset) {
        return g(charSequence.toString().getBytes(charset));
    }

    @CanIgnoreReturnValue
    public <T> Hasher n(@ParametricNullness T t, Funnel<? super T> funnel) {
        funnel.s0(t, this);
        return this;
    }
}
