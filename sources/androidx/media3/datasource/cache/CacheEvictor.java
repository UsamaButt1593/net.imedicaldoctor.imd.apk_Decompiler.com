package androidx.media3.datasource.cache;

import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.cache.Cache;

@UnstableApi
public interface CacheEvictor extends Cache.Listener {
    void b(Cache cache, String str, long j2, long j3);

    void e();

    boolean f();
}
