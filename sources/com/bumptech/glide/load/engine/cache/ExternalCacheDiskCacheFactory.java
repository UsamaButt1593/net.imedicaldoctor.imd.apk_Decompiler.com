package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

@Deprecated
public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.f18030b, DiskCache.Factory.f18029a);
    }

    public ExternalCacheDiskCacheFactory(Context context, int i2) {
        this(context, DiskCache.Factory.f18030b, i2);
    }

    public ExternalCacheDiskCacheFactory(final Context context, final String str, int i2) {
        super((DiskLruCacheFactory.CacheDirectoryGetter) new DiskLruCacheFactory.CacheDirectoryGetter() {
            public File a() {
                File externalCacheDir = context.getExternalCacheDir();
                if (externalCacheDir == null) {
                    return null;
                }
                return str != null ? new File(externalCacheDir, str) : externalCacheDir;
            }
        }, (long) i2);
    }
}
