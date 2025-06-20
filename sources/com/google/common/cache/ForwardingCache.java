package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import javax.annotation.CheckForNull;

@GwtIncompatible
@ElementTypesAreNonnullByDefault
public abstract class ForwardingCache<K, V> extends ForwardingObject implements Cache<K, V> {

    public static abstract class SimpleForwardingCache<K, V> extends ForwardingCache<K, V> {
        private final Cache<K, V> s;

        protected SimpleForwardingCache(Cache<K, V> cache) {
            this.s = (Cache) Preconditions.E(cache);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a1 */
        public final Cache<K, V> Z0() {
            return this.s;
        }
    }

    protected ForwardingCache() {
    }

    @CheckForNull
    public V O(Object obj) {
        return Z0().O(obj);
    }

    public ImmutableMap<K, V> Q0(Iterable<? extends Object> iterable) {
        return Z0().Q0(iterable);
    }

    public V R(K k2, Callable<? extends V> callable) throws ExecutionException {
        return Z0().R(k2, callable);
    }

    public void T(Iterable<? extends Object> iterable) {
        Z0().T(iterable);
    }

    public void U0(Object obj) {
        Z0().U0(obj);
    }

    public CacheStats V0() {
        return Z0().V0();
    }

    public void X0() {
        Z0().X0();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a1 */
    public abstract Cache<K, V> Z0();

    public ConcurrentMap<K, V> g() {
        return Z0().g();
    }

    public void o() {
        Z0().o();
    }

    public void put(K k2, V v) {
        Z0().put(k2, v);
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        Z0().putAll(map);
    }

    public long size() {
        return Z0().size();
    }
}
