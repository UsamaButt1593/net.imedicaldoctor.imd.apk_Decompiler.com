package com.bumptech.glide.load.engine.cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;

public interface MemoryCache {

    public interface ResourceRemovedListener {
        void a(@NonNull Resource<?> resource);
    }

    long a();

    void b(int i2);

    void c();

    void d(float f2);

    long e();

    @Nullable
    Resource<?> f(@NonNull Key key, @Nullable Resource<?> resource);

    @Nullable
    Resource<?> g(@NonNull Key key);

    void h(@NonNull ResourceRemovedListener resourceRemovedListener);
}
