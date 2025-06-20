package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public class ExecutionError extends Error {
    private static final long s = 0;

    protected ExecutionError() {
    }

    public ExecutionError(@CheckForNull Error error) {
        super(error);
    }

    protected ExecutionError(@CheckForNull String str) {
        super(str);
    }

    public ExecutionError(@CheckForNull String str, @CheckForNull Error error) {
        super(str, error);
    }
}
