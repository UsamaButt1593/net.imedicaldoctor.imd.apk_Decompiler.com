package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class LruCache<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    private final Map<T, Y> f18532a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    private final long f18533b;

    /* renamed from: c  reason: collision with root package name */
    private long f18534c;

    /* renamed from: d  reason: collision with root package name */
    private long f18535d;

    public LruCache(long j2) {
        this.f18533b = j2;
        this.f18534c = j2;
    }

    private void j() {
        q(this.f18534c);
    }

    public synchronized long a() {
        return this.f18534c;
    }

    public void c() {
        q(0);
    }

    public synchronized void d(float f2) {
        if (f2 >= 0.0f) {
            this.f18534c = (long) Math.round(((float) this.f18533b) * f2);
            j();
        } else {
            throw new IllegalArgumentException("Multiplier must be >= 0");
        }
    }

    public synchronized long e() {
        return this.f18535d;
    }

    public synchronized boolean i(@NonNull T t) {
        return this.f18532a.containsKey(t);
    }

    @Nullable
    public synchronized Y k(@NonNull T t) {
        return this.f18532a.get(t);
    }

    /* access modifiers changed from: protected */
    public synchronized int l() {
        return this.f18532a.size();
    }

    /* access modifiers changed from: protected */
    public int m(@Nullable Y y) {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void n(@NonNull T t, @Nullable Y y) {
    }

    @Nullable
    public synchronized Y o(@NonNull T t, @Nullable Y y) {
        long m2 = (long) m(y);
        if (m2 >= this.f18534c) {
            n(t, y);
            return null;
        }
        if (y != null) {
            this.f18535d += m2;
        }
        Y put = this.f18532a.put(t, y);
        if (put != null) {
            this.f18535d -= (long) m(put);
            if (!put.equals(y)) {
                n(t, put);
            }
        }
        j();
        return put;
    }

    @Nullable
    public synchronized Y p(@NonNull T t) {
        Y remove;
        remove = this.f18532a.remove(t);
        if (remove != null) {
            this.f18535d -= (long) m(remove);
        }
        return remove;
    }

    /* access modifiers changed from: protected */
    public synchronized void q(long j2) {
        while (this.f18535d > j2) {
            Iterator<Map.Entry<T, Y>> it2 = this.f18532a.entrySet().iterator();
            Map.Entry next = it2.next();
            Object value = next.getValue();
            this.f18535d -= (long) m(value);
            Object key = next.getKey();
            it2.remove();
            n(key, value);
        }
    }
}
