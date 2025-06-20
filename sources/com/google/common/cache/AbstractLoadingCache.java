package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutionException;

@ElementTypesAreNonnullByDefault
@GwtIncompatible
public abstract class AbstractLoadingCache<K, V> extends AbstractCache<K, V> implements LoadingCache<K, V> {
    protected AbstractLoadingCache() {
    }

    @CanIgnoreReturnValue
    public V H(K k2) {
        try {
            return get(k2);
        } catch (ExecutionException e2) {
            throw new UncheckedExecutionException(e2.getCause());
        }
    }

    public final V apply(K k2) {
        return H(k2);
    }

    public ImmutableMap<K, V> e0(Iterable<? extends K> iterable) throws ExecutionException {
        LinkedHashMap c0 = Maps.c0();
        for (Object next : iterable) {
            if (!c0.containsKey(next)) {
                c0.put(next, get(next));
            }
        }
        return ImmutableMap.g(c0);
    }

    public void x0(K k2) {
        throw new UnsupportedOperationException();
    }
}
