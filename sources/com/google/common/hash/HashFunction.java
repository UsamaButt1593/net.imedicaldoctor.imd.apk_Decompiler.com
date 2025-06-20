package com.google.common.hash;

import com.google.errorprone.annotations.Immutable;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
@Immutable
public interface HashFunction {
    HashCode a(byte[] bArr);

    Hasher b();

    HashCode c(int i2);

    <T> HashCode d(@ParametricNullness T t, Funnel<? super T> funnel);

    HashCode e(CharSequence charSequence, Charset charset);

    HashCode f(ByteBuffer byteBuffer);

    HashCode g(CharSequence charSequence);

    int h();

    HashCode i(long j2);

    HashCode j(byte[] bArr, int i2, int i3);

    Hasher k(int i2);
}
