package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.util.LruCache;

public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {

    /* renamed from: e  reason: collision with root package name */
    private MemoryCache.ResourceRemovedListener f18057e;

    public LruResourceCache(long j2) {
        super(j2);
    }

    @SuppressLint({"InlinedApi"})
    public void b(int i2) {
        if (i2 >= 40) {
            c();
        } else if (i2 >= 20 || i2 == 15) {
            q(a() / 2);
        }
    }

    @Nullable
    public /* bridge */ /* synthetic */ Resource f(@NonNull Key key, @Nullable Resource resource) {
        return (Resource) super.o(key, resource);
    }

    @Nullable
    public /* bridge */ /* synthetic */ Resource g(@NonNull Key key) {
        return (Resource) super.p(key);
    }

    public void h(@NonNull MemoryCache.ResourceRemovedListener resourceRemovedListener) {
        this.f18057e = resourceRemovedListener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: r */
    public int m(@Nullable Resource<?> resource) {
        return resource == null ? super.m(null) : resource.a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: s */
    public void n(@NonNull Key key, @Nullable Resource<?> resource) {
        MemoryCache.ResourceRemovedListener resourceRemovedListener = this.f18057e;
        if (resourceRemovedListener != null && resource != null) {
            resourceRemovedListener.a(resource);
        }
    }
}
