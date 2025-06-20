package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public interface LineProcessor<T> {
    @ParametricNullness
    T a();

    @CanIgnoreReturnValue
    boolean b(String str) throws IOException;
}
