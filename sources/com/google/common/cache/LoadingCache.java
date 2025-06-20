package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface LoadingCache<K, V> extends Cache<K, V>, Function<K, V> {
    @CanIgnoreReturnValue
    V H(K k2);

    @Deprecated
    V apply(K k2);

    @CanIgnoreReturnValue
    ImmutableMap<K, V> e0(Iterable<? extends K> iterable) throws ExecutionException;

    ConcurrentMap<K, V> g();

    @CanIgnoreReturnValue
    V get(K k2) throws ExecutionException;

    void x0(K k2);
}
