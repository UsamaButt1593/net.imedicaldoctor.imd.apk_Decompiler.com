package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.DoNotMock;
import java.io.IOException;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
@DoNotMock("Implement it normally")
public interface ByteProcessor<T> {
    @ParametricNullness
    T a();

    @CanIgnoreReturnValue
    boolean b(byte[] bArr, int i2, int i3) throws IOException;
}
