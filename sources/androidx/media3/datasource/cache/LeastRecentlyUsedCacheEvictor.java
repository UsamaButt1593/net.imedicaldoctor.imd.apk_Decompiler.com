package androidx.media3.datasource.cache;

import androidx.media3.common.util.UnstableApi;
import java.util.TreeSet;

@UnstableApi
public final class LeastRecentlyUsedCacheEvictor implements CacheEvictor {

    /* renamed from: a  reason: collision with root package name */
    private final long f10032a;

    /* renamed from: b  reason: collision with root package name */
    private final TreeSet<CacheSpan> f10033b = new TreeSet<>(new d());

    /* renamed from: c  reason: collision with root package name */
    private long f10034c;

    public LeastRecentlyUsedCacheEvictor(long j2) {
        this.f10032a = j2;
    }

    /* access modifiers changed from: private */
    public static int h(CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        long j2 = cacheSpan.Y2;
        long j3 = cacheSpan2.Y2;
        if (j2 - j3 == 0) {
            return cacheSpan.compareTo(cacheSpan2);
        }
        return j2 < j3 ? -1 : 1;
    }

    private void i(Cache cache, long j2) {
        while (this.f10034c + j2 > this.f10032a && !this.f10033b.isEmpty()) {
            cache.h(this.f10033b.first());
        }
    }

    public void a(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2) {
        d(cache, cacheSpan);
        c(cache, cacheSpan2);
    }

    public void b(Cache cache, String str, long j2, long j3) {
        if (j3 != -1) {
            i(cache, j3);
        }
    }

    public void c(Cache cache, CacheSpan cacheSpan) {
        this.f10033b.add(cacheSpan);
        this.f10034c += cacheSpan.Y;
        i(cache, 0);
    }

    public void d(Cache cache, CacheSpan cacheSpan) {
        this.f10033b.remove(cacheSpan);
        this.f10034c -= cacheSpan.Y;
    }

    public void e() {
    }

    public boolean f() {
        return true;
    }
}
