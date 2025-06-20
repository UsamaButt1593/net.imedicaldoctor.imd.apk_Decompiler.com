package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public class UncheckedExecutionException extends RuntimeException {
    private static final long s = 0;

    protected UncheckedExecutionException() {
    }

    protected UncheckedExecutionException(@CheckForNull String str) {
        super(str);
    }

    public UncheckedExecutionException(@CheckForNull String str, @CheckForNull Throwable th) {
        super(str, th);
    }

    public UncheckedExecutionException(@CheckForNull Throwable th) {
        super(th);
    }
}
