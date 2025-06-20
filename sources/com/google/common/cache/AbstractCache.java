package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    public static final class SimpleStatsCounter implements StatsCounter {

        /* renamed from: a  reason: collision with root package name */
        private final LongAddable f22303a = LongAddables.a();

        /* renamed from: b  reason: collision with root package name */
        private final LongAddable f22304b = LongAddables.a();

        /* renamed from: c  reason: collision with root package name */
        private final LongAddable f22305c = LongAddables.a();

        /* renamed from: d  reason: collision with root package name */
        private final LongAddable f22306d = LongAddables.a();

        /* renamed from: e  reason: collision with root package name */
        private final LongAddable f22307e = LongAddables.a();

        /* renamed from: f  reason: collision with root package name */
        private final LongAddable f22308f = LongAddables.a();

        private static long h(long j2) {
            if (j2 >= 0) {
                return j2;
            }
            return Long.MAX_VALUE;
        }

        public void a() {
            this.f22308f.b();
        }

        public void b(int i2) {
            this.f22303a.a((long) i2);
        }

        public void c(int i2) {
            this.f22304b.a((long) i2);
        }

        public void d(long j2) {
            this.f22306d.b();
            this.f22307e.a(j2);
        }

        public void e(long j2) {
            this.f22305c.b();
            this.f22307e.a(j2);
        }

        public CacheStats f() {
            return new CacheStats(h(this.f22303a.c()), h(this.f22304b.c()), h(this.f22305c.c()), h(this.f22306d.c()), h(this.f22307e.c()), h(this.f22308f.c()));
        }

        public void g(StatsCounter statsCounter) {
            CacheStats f2 = statsCounter.f();
            this.f22303a.a(f2.c());
            this.f22304b.a(f2.j());
            this.f22305c.a(f2.h());
            this.f22306d.a(f2.f());
            this.f22307e.a(f2.n());
            this.f22308f.a(f2.b());
        }
    }

    public interface StatsCounter {
        void a();

        void b(int i2);

        void c(int i2);

        void d(long j2);

        void e(long j2);

        CacheStats f();
    }

    protected AbstractCache() {
    }

    public ImmutableMap<K, V> Q0(Iterable<? extends Object> iterable) {
        Object O;
        LinkedHashMap c0 = Maps.c0();
        for (Object next : iterable) {
            if (!c0.containsKey(next) && (O = O(next)) != null) {
                c0.put(next, O);
            }
        }
        return ImmutableMap.g(c0);
    }

    public V R(K k2, Callable<? extends V> callable) throws ExecutionException {
        throw new UnsupportedOperationException();
    }

    public void T(Iterable<? extends Object> iterable) {
        for (Object U0 : iterable) {
            U0(U0);
        }
    }

    public void U0(Object obj) {
        throw new UnsupportedOperationException();
    }

    public CacheStats V0() {
        throw new UnsupportedOperationException();
    }

    public void X0() {
        throw new UnsupportedOperationException();
    }

    public ConcurrentMap<K, V> g() {
        throw new UnsupportedOperationException();
    }

    public void o() {
    }

    public void put(K k2, V v) {
        throw new UnsupportedOperationException();
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry next : map.entrySet()) {
            put(next.getKey(), next.getValue());
        }
    }

    public long size() {
        throw new UnsupportedOperationException();
    }
}
