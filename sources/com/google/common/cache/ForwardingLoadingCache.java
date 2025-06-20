package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ExecutionException;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingLoadingCache<K, V> extends ForwardingCache<K, V> implements LoadingCache<K, V> {

    public static abstract class SimpleForwardingLoadingCache<K, V> extends ForwardingLoadingCache<K, V> {
        private final LoadingCache<K, V> s;

        protected SimpleForwardingLoadingCache(LoadingCache<K, V> loadingCache) {
            this.s = (LoadingCache) Preconditions.E(loadingCache);
        }

        /* access modifiers changed from: protected */
        /* renamed from: f1 */
        public final LoadingCache<K, V> a1() {
            return this.s;
        }
    }

    protected ForwardingLoadingCache() {
    }

    @CanIgnoreReturnValue
    public V H(K k2) {
        return a1().H(k2);
    }

    public V apply(K k2) {
        return a1().apply(k2);
    }

    @CanIgnoreReturnValue
    public ImmutableMap<K, V> e0(Iterable<? extends K> iterable) throws ExecutionException {
        return a1().e0(iterable);
    }

    /* access modifiers changed from: protected */
    /* renamed from: f1 */
    public abstract LoadingCache<K, V> a1();

    @CanIgnoreReturnValue
    public V get(K k2) throws ExecutionException {
        return a1().get(k2);
    }

    public void x0(K k2) {
        a1().x0(k2);
    }
}
