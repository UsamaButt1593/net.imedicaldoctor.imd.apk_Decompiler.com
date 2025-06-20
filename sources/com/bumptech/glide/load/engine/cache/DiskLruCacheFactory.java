package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;

public class DiskLruCacheFactory implements DiskCache.Factory {

    /* renamed from: c  reason: collision with root package name */
    private final long f18037c;

    /* renamed from: d  reason: collision with root package name */
    private final CacheDirectoryGetter f18038d;

    public interface CacheDirectoryGetter {
        File a();
    }

    public DiskLruCacheFactory(CacheDirectoryGetter cacheDirectoryGetter, long j2) {
        this.f18037c = j2;
        this.f18038d = cacheDirectoryGetter;
    }

    public DiskCache build() {
        File a2 = this.f18038d.a();
        if (a2 == null) {
            return null;
        }
        if (a2.mkdirs() || (a2.exists() && a2.isDirectory())) {
            return DiskLruCacheWrapper.d(a2, this.f18037c);
        }
        return null;
    }

    public DiskLruCacheFactory(final String str, long j2) {
        this((CacheDirectoryGetter) new CacheDirectoryGetter() {
            public File a() {
                return new File(str);
            }
        }, j2);
    }

    public DiskLruCacheFactory(final String str, final String str2, long j2) {
        this((CacheDirectoryGetter) new CacheDirectoryGetter() {
            public File a() {
                return new File(str, str2);
            }
        }, j2);
    }
}
