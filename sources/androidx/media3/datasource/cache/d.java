package androidx.media3.datasource.cache;

import java.util.Comparator;

public final /* synthetic */ class d implements Comparator {
    public final int compare(Object obj, Object obj2) {
        return LeastRecentlyUsedCacheEvictor.h((CacheSpan) obj, (CacheSpan) obj2);
    }
}
