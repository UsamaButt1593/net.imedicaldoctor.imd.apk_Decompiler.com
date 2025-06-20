package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface FutureCallback<V> {
    void a(@ParametricNullness V v);

    void b(Throwable th);
}
