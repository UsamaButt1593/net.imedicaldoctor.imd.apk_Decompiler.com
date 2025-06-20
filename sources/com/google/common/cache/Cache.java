package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import com.google.errorprone.annotations.DoNotMock;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@DoNotMock("Use CacheBuilder.newBuilder().build()")
public interface Cache<K, V> {
    @CanIgnoreReturnValue
    @CheckForNull
    V O(@CompatibleWith("K") Object obj);

    ImmutableMap<K, V> Q0(Iterable<? extends Object> iterable);

    @CanIgnoreReturnValue
    V R(K k2, Callable<? extends V> callable) throws ExecutionException;

    void T(Iterable<? extends Object> iterable);

    void U0(@CompatibleWith("K") Object obj);

    CacheStats V0();

    void X0();

    ConcurrentMap<K, V> g();

    void o();

    void put(K k2, V v);

    void putAll(Map<? extends K, ? extends V> map);

    long size();
}
