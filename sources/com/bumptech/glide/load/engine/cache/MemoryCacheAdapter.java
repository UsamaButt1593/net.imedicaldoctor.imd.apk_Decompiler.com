package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;

public class MemoryCacheAdapter implements MemoryCache {

    /* renamed from: a  reason: collision with root package name */
    private MemoryCache.ResourceRemovedListener f18058a;

    public long a() {
        return 0;
    }

    public void b(int i2) {
    }

    public void c() {
    }

    public void d(float f2) {
    }

    public long e() {
        return 0;
    }

    @Nullable
    public Resource<?> f(@NonNull Key key, @Nullable Resource<?> resource) {
        if (resource == null) {
            return null;
        }
        this.f18058a.a(resource);
        return null;
    }

    @Nullable
    public Resource<?> g(@NonNull Key key) {
        return null;
    }

    public void h(@NonNull MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.f18058a = resourceRemovedListener;
    }
}
