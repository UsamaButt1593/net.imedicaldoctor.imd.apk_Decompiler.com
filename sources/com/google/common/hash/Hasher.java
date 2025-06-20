package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
@Beta
public interface Hasher extends PrimitiveSink {
    @CanIgnoreReturnValue
    Hasher a(double d2);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink a(double d2);

    @CanIgnoreReturnValue
    Hasher b(short s);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink b(short s);

    @CanIgnoreReturnValue
    Hasher c(boolean z);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink c(boolean z);

    @CanIgnoreReturnValue
    Hasher d(float f2);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink d(float f2);

    @CanIgnoreReturnValue
    Hasher e(int i2);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink e(int i2);

    @CanIgnoreReturnValue
    Hasher f(long j2);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink f(long j2);

    @CanIgnoreReturnValue
    Hasher g(byte[] bArr);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink g(byte[] bArr);

    @CanIgnoreReturnValue
    Hasher h(byte b2);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink h(byte b2);

    @Deprecated
    int hashCode();

    @CanIgnoreReturnValue
    Hasher i(CharSequence charSequence);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink i(CharSequence charSequence);

    @CanIgnoreReturnValue
    Hasher j(byte[] bArr, int i2, int i3);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink j(byte[] bArr, int i2, int i3);

    @CanIgnoreReturnValue
    Hasher k(char c2);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink k(char c2);

    @CanIgnoreReturnValue
    Hasher l(ByteBuffer byteBuffer);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink l(ByteBuffer byteBuffer);

    @CanIgnoreReturnValue
    Hasher m(CharSequence charSequence, Charset charset);

    @CanIgnoreReturnValue
    /* bridge */ /* synthetic */ PrimitiveSink m(CharSequence charSequence, Charset charset);

    @CanIgnoreReturnValue
    <T> Hasher n(@ParametricNullness T t, Funnel<? super T> funnel);

    HashCode o();
}
