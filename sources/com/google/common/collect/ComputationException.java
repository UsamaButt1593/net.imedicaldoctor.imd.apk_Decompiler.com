package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@Deprecated
public class ComputationException extends RuntimeException {
    private static final long s = 0;

    public ComputationException(@CheckForNull Throwable th) {
        super(th);
    }
}
