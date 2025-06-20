package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface AsyncFunction<I, O> {
    ListenableFuture<O> apply(@ParametricNullness I i2) throws Exception;
}
