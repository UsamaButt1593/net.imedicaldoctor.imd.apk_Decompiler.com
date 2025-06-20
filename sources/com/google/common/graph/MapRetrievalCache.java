package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
final class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {
    @CheckForNull

    /* renamed from: c  reason: collision with root package name */
    private volatile transient CacheEntry<K, V> f22624c;
    @CheckForNull

    /* renamed from: d  reason: collision with root package name */
    private volatile transient CacheEntry<K, V> f22625d;

    private static final class CacheEntry<K, V> {

        /* renamed from: a  reason: collision with root package name */
        final K f22626a;

        /* renamed from: b  reason: collision with root package name */
        final V f22627b;

        CacheEntry(K k2, V v) {
            this.f22626a = k2;
            this.f22627b = v;
        }
    }

    MapRetrievalCache(Map<K, V> map) {
        super(map);
    }

    private void l(CacheEntry<K, V> cacheEntry) {
        this.f22625d = this.f22624c;
        this.f22624c = cacheEntry;
    }

    private void m(K k2, V v) {
        l(new CacheEntry(k2, v));
    }

    /* access modifiers changed from: package-private */
    public void d() {
        super.d();
        this.f22624c = null;
        this.f22625d = null;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public V f(Object obj) {
        Preconditions.E(obj);
        V g2 = g(obj);
        if (g2 != null) {
            return g2;
        }
        V h2 = h(obj);
        if (h2 != null) {
            m(obj, h2);
        }
        return h2;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public V g(@CheckForNull Object obj) {
        V g2 = super.g(obj);
        if (g2 != null) {
            return g2;
        }
        CacheEntry<K, V> cacheEntry = this.f22624c;
        if (cacheEntry != null && cacheEntry.f22626a == obj) {
            return cacheEntry.f22627b;
        }
        CacheEntry<K, V> cacheEntry2 = this.f22625d;
        if (cacheEntry2 == null || cacheEntry2.f22626a != obj) {
            return null;
        }
        l(cacheEntry2);
        return cacheEntry2.f22627b;
    }
}
