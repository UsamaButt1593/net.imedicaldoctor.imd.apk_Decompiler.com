package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.CheckForNull;

@GwtCompatible
@ElementTypesAreNonnullByDefault
@J2ktIncompatible
public final class AtomicLongMap<K> implements Serializable {
    @CheckForNull
    @LazyInit
    private transient Map<K, Long> X;
    private final ConcurrentHashMap<K, AtomicLong> s;

    private AtomicLongMap(ConcurrentHashMap<K, AtomicLong> concurrentHashMap) {
        this.s = (ConcurrentHashMap) Preconditions.E(concurrentHashMap);
    }

    public static <K> AtomicLongMap<K> e() {
        return new AtomicLongMap<>(new ConcurrentHashMap());
    }

    public static <K> AtomicLongMap<K> f(Map<? extends K, ? extends Long> map) {
        AtomicLongMap<K> e2 = e();
        e2.p(map);
        return e2;
    }

    private Map<K, Long> g() {
        return Collections.unmodifiableMap(Maps.B0(this.s, new Function<AtomicLong, Long>(this) {
            /* renamed from: a */
            public Long apply(AtomicLong atomicLong) {
                return Long.valueOf(atomicLong.get());
            }
        }));
    }

    @CanIgnoreReturnValue
    public long a(K k2, long j2) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.s.get(k2);
            if (atomicLong == null && (atomicLong = this.s.putIfAbsent(k2, new AtomicLong(j2))) == null) {
                return j2;
            }
            while (true) {
                long j3 = atomicLong.get();
                if (j3 != 0) {
                    long j4 = j3 + j2;
                    if (atomicLong.compareAndSet(j3, j4)) {
                        return j4;
                    }
                }
            }
        } while (!this.s.replace(k2, atomicLong, new AtomicLong(j2)));
        return j2;
    }

    public Map<K, Long> b() {
        Map<K, Long> map = this.X;
        if (map != null) {
            return map;
        }
        Map<K, Long> g2 = g();
        this.X = g2;
        return g2;
    }

    public void c() {
        this.s.clear();
    }

    public boolean d(Object obj) {
        return this.s.containsKey(obj);
    }

    @CanIgnoreReturnValue
    public long h(K k2) {
        return a(k2, -1);
    }

    public long i(K k2) {
        AtomicLong atomicLong = this.s.get(k2);
        if (atomicLong == null) {
            return 0;
        }
        return atomicLong.get();
    }

    @CanIgnoreReturnValue
    public long j(K k2, long j2) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.s.get(k2);
            if (atomicLong == null && (atomicLong = this.s.putIfAbsent(k2, new AtomicLong(j2))) == null) {
                return 0;
            }
            while (true) {
                long j3 = atomicLong.get();
                if (j3 != 0) {
                    if (atomicLong.compareAndSet(j3, j3 + j2)) {
                        return j3;
                    }
                }
            }
        } while (!this.s.replace(k2, atomicLong, new AtomicLong(j2)));
        return 0;
    }

    @CanIgnoreReturnValue
    public long k(K k2) {
        return j(k2, -1);
    }

    @CanIgnoreReturnValue
    public long l(K k2) {
        return j(k2, 1);
    }

    @CanIgnoreReturnValue
    public long m(K k2) {
        return a(k2, 1);
    }

    public boolean n() {
        return this.s.isEmpty();
    }

    @CanIgnoreReturnValue
    public long o(K k2, long j2) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.s.get(k2);
            if (atomicLong == null && (atomicLong = this.s.putIfAbsent(k2, new AtomicLong(j2))) == null) {
                return 0;
            }
            while (true) {
                long j3 = atomicLong.get();
                if (j3 != 0) {
                    if (atomicLong.compareAndSet(j3, j2)) {
                        return j3;
                    }
                }
            }
        } while (!this.s.replace(k2, atomicLong, new AtomicLong(j2)));
        return 0;
    }

    public void p(Map<? extends K, ? extends Long> map) {
        for (Map.Entry next : map.entrySet()) {
            o(next.getKey(), ((Long) next.getValue()).longValue());
        }
    }

    /* access modifiers changed from: package-private */
    public long q(K k2, long j2) {
        AtomicLong atomicLong;
        do {
            atomicLong = this.s.get(k2);
            if (atomicLong == null && (atomicLong = this.s.putIfAbsent(k2, new AtomicLong(j2))) == null) {
                return 0;
            }
            long j3 = atomicLong.get();
            if (j3 != 0) {
                return j3;
            }
        } while (!this.s.replace(k2, atomicLong, new AtomicLong(j2)));
        return 0;
    }

    @CanIgnoreReturnValue
    public long r(K k2) {
        long j2;
        AtomicLong atomicLong = this.s.get(k2);
        if (atomicLong == null) {
            return 0;
        }
        do {
            j2 = atomicLong.get();
            if (j2 == 0 || atomicLong.compareAndSet(j2, 0)) {
                this.s.remove(k2, atomicLong);
            }
            j2 = atomicLong.get();
            break;
        } while (atomicLong.compareAndSet(j2, 0));
        this.s.remove(k2, atomicLong);
        return j2;
    }

    /* access modifiers changed from: package-private */
    public boolean s(K k2, long j2) {
        AtomicLong atomicLong = this.s.get(k2);
        if (atomicLong == null) {
            return false;
        }
        long j3 = atomicLong.get();
        if (j3 != j2) {
            return false;
        }
        if (j3 != 0 && !atomicLong.compareAndSet(j3, 0)) {
            return false;
        }
        this.s.remove(k2, atomicLong);
        return true;
    }

    public void t() {
        Iterator<Map.Entry<K, AtomicLong>> it2 = this.s.entrySet().iterator();
        while (it2.hasNext()) {
            AtomicLong atomicLong = (AtomicLong) it2.next().getValue();
            if (atomicLong != null && atomicLong.get() == 0) {
                it2.remove();
            }
        }
    }

    public String toString() {
        return this.s.toString();
    }

    @CanIgnoreReturnValue
    public boolean u(K k2) {
        return s(k2, 0);
    }

    /* access modifiers changed from: package-private */
    public boolean v(K k2, long j2, long j3) {
        if (j2 == 0) {
            return q(k2, j3) == 0;
        }
        AtomicLong atomicLong = this.s.get(k2);
        if (atomicLong == null) {
            return false;
        }
        return atomicLong.compareAndSet(j2, j3);
    }

    public int w() {
        return this.s.size();
    }

    public long x() {
        long j2 = 0;
        for (AtomicLong atomicLong : this.s.values()) {
            j2 += atomicLong.get();
        }
        return j2;
    }
}
