package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
@Immutable
abstract class AbstractHashFunction implements HashFunction {
    AbstractHashFunction() {
    }

    public HashCode a(byte[] bArr) {
        return j(bArr, 0, bArr.length);
    }

    public HashCode c(int i2) {
        return k(4).e(i2).o();
    }

    public <T> HashCode d(@ParametricNullness T t, Funnel<? super T> funnel) {
        return b().n(t, funnel).o();
    }

    public HashCode e(CharSequence charSequence, Charset charset) {
        return b().m(charSequence, charset).o();
    }

    public HashCode f(ByteBuffer byteBuffer) {
        return k(byteBuffer.remaining()).l(byteBuffer).o();
    }

    public HashCode g(CharSequence charSequence) {
        return k(charSequence.length() * 2).i(charSequence).o();
    }

    public HashCode i(long j2) {
        return k(8).f(j2).o();
    }

    public HashCode j(byte[] bArr, int i2, int i3) {
        Preconditions.f0(i2, i2 + i3, bArr.length);
        return k(i3).j(bArr, i2, i3).o();
    }

    public Hasher k(int i2) {
        Preconditions.k(i2 >= 0, "expectedInputSize must be >= 0 but was %s", i2);
        return b();
    }
}
