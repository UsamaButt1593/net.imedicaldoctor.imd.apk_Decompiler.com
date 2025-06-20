package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

public final class InternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public InternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.f18030b, 262144000);
    }

    public InternalCacheDiskCacheFactory(Context context, long j2) {
        this(context, DiskCache.Factory.f18030b, j2);
    }

    public InternalCacheDiskCacheFactory(final Context context, final String str, long j2) {
        super((DiskLruCacheFactory.CacheDirectoryGetter) new DiskLruCacheFactory.CacheDirectoryGetter() {
            public File a() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }
        }, j2);
    }
}
