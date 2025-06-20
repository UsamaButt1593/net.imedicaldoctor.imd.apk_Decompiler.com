package com.google.common.graph;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
class MapIteratorCache<K, V> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Map<K, V> f22622a;
    /* access modifiers changed from: private */
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    public volatile transient Map.Entry<K, V> f22623b;

    MapIteratorCache(Map<K, V> map) {
        this.f22622a = (Map) Preconditions.E(map);
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        d();
        this.f22622a.clear();
    }

    /* access modifiers changed from: package-private */
    public void d() {
        this.f22623b = null;
    }

    /* access modifiers changed from: package-private */
    public final boolean e(@CheckForNull Object obj) {
        return g(obj) != null || this.f22622a.containsKey(obj);
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public V f(Object obj) {
        Preconditions.E(obj);
        V g2 = g(obj);
        return g2 == null ? h(obj) : g2;
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public V g(@CheckForNull Object obj) {
        Map.Entry<K, V> entry = this.f22623b;
        if (entry == null || entry.getKey() != obj) {
            return null;
        }
        return entry.getValue();
    }

    /* access modifiers changed from: package-private */
    @CheckForNull
    public final V h(Object obj) {
        Preconditions.E(obj);
        return this.f22622a.get(obj);
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @CheckForNull
    public final V i(K k2, V v) {
        Preconditions.E(k2);
        Preconditions.E(v);
        d();
        return this.f22622a.put(k2, v);
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @CheckForNull
    public final V j(Object obj) {
        Preconditions.E(obj);
        d();
        return this.f22622a.remove(obj);
    }

    /* access modifiers changed from: package-private */
    public final Set<K> k() {
        return new AbstractSet<K>() {
            /* renamed from: b */
            public UnmodifiableIterator<K> iterator() {
                final Iterator it2 = MapIteratorCache.this.f22622a.entrySet().iterator();
                return new UnmodifiableIterator<K>() {
                    public boolean hasNext() {
                        return it2.hasNext();
                    }

                    public K next() {
                        Map.Entry entry = (Map.Entry) it2.next();
                        Map.Entry unused = MapIteratorCache.this.f22623b = entry;
                        return entry.getKey();
                    }
                };
            }

            public boolean contains(@CheckForNull Object obj) {
                return MapIteratorCache.this.e(obj);
            }

            public int size() {
                return MapIteratorCache.this.f22622a.size();
            }
        };
    }
}
