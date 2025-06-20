package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import java.io.File;

public final class ExternalPreferredCacheDiskCacheFactory extends DiskLruCacheFactory {
    public ExternalPreferredCacheDiskCacheFactory(Context context) {
        this(context, DiskCache.Factory.f18030b, 262144000);
    }

    public ExternalPreferredCacheDiskCacheFactory(Context context, long j2) {
        this(context, DiskCache.Factory.f18030b, j2);
    }

    public ExternalPreferredCacheDiskCacheFactory(final Context context, final String str, long j2) {
        super((DiskLruCacheFactory.CacheDirectoryGetter) new DiskLruCacheFactory.CacheDirectoryGetter() {
            @Nullable
            private File b() {
                File cacheDir = context.getCacheDir();
                if (cacheDir == null) {
                    return null;
                }
                return str != null ? new File(cacheDir, str) : cacheDir;
            }

            public File a() {
                File externalCacheDir;
                File b2 = b();
                if ((b2 == null || !b2.exists()) && (externalCacheDir = context.getExternalCacheDir()) != null && externalCacheDir.canWrite()) {
                    return str != null ? new File(externalCacheDir, str) : externalCacheDir;
                }
                return b2;
            }
        }, j2);
    }
}
