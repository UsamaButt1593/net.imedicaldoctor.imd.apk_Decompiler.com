package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
@Beta
public interface PrimitiveSink {
    @CanIgnoreReturnValue
    PrimitiveSink a(double d2);

    @CanIgnoreReturnValue
    PrimitiveSink b(short s);

    @CanIgnoreReturnValue
    PrimitiveSink c(boolean z);

    @CanIgnoreReturnValue
    PrimitiveSink d(float f2);

    @CanIgnoreReturnValue
    PrimitiveSink e(int i2);

    @CanIgnoreReturnValue
    PrimitiveSink f(long j2);

    @CanIgnoreReturnValue
    PrimitiveSink g(byte[] bArr);

    @CanIgnoreReturnValue
    PrimitiveSink h(byte b2);

    @CanIgnoreReturnValue
    PrimitiveSink i(CharSequence charSequence);

    @CanIgnoreReturnValue
    PrimitiveSink j(byte[] bArr, int i2, int i3);

    @CanIgnoreReturnValue
    PrimitiveSink k(char c2);

    @CanIgnoreReturnValue
    PrimitiveSink l(ByteBuffer byteBuffer);

    @CanIgnoreReturnValue
    PrimitiveSink m(CharSequence charSequence, Charset charset);
}
