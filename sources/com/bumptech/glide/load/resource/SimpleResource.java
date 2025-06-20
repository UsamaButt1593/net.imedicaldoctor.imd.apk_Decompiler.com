package com.bumptech.glide.load.resource;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

public class SimpleResource<T> implements Resource<T> {
    protected final T s;

    public SimpleResource(@NonNull T t) {
        this.s = Preconditions.d(t);
    }

    public final int a() {
        return 1;
    }

    @NonNull
    public Class<T> c() {
        return this.s.getClass();
    }

    @NonNull
    public final T get() {
        return this.s;
    }

    public void recycle() {
    }
}
