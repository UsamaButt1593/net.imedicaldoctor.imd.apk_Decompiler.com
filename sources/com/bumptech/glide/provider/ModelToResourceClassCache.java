package com.bumptech.glide.provider;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.bumptech.glide.util.MultiClassKey;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class ModelToResourceClassCache {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<MultiClassKey> f18435a = new AtomicReference<>();

    /* renamed from: b  reason: collision with root package name */
    private final ArrayMap<MultiClassKey, List<Class<?>>> f18436b = new ArrayMap<>();

    public void a() {
        synchronized (this.f18436b) {
            this.f18436b.clear();
        }
    }

    @Nullable
    public List<Class<?>> b(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3) {
        List<Class<?>> list;
        MultiClassKey andSet = this.f18435a.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new MultiClassKey(cls, cls2, cls3);
        } else {
            andSet.b(cls, cls2, cls3);
        }
        synchronized (this.f18436b) {
            list = this.f18436b.get(andSet);
        }
        this.f18435a.set(andSet);
        return list;
    }

    public void c(@NonNull Class<?> cls, @NonNull Class<?> cls2, @NonNull Class<?> cls3, @NonNull List<Class<?>> list) {
        synchronized (this.f18436b) {
            this.f18436b.put(new MultiClassKey(cls, cls2, cls3), list);
        }
    }
}
