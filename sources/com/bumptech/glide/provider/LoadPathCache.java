package com.bumptech.glide.provider;

import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.DecodePath;
import com.bumptech.glide.load.engine.LoadPath;
import com.bumptech.glide.load.resource.transcode.UnitTranscoder;
import com.bumptech.glide.util.MultiClassKey;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class LoadPathCache {

    /* renamed from: c  reason: collision with root package name */
    private static final LoadPath<?, ?, ?> f18432c;

    /* renamed from: a  reason: collision with root package name */
    private final ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> f18433a = new ArrayMap<>();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicReference<MultiClassKey> f18434b = new AtomicReference<>();

    static {
        Class<Object> cls = Object.class;
        Class<Object> cls2 = Object.class;
        Class<Object> cls3 = Object.class;
        f18432c = new LoadPath(cls, cls2, cls3, Collections.singletonList(new DecodePath(Object.class, Object.class, Object.class, Collections.emptyList(), new UnitTranscoder(), (Pools.Pool<List<Throwable>>) null)), (Pools.Pool<List<Throwable>>) null);
    }

    private MultiClassKey b(Class<?> cls, Class<?> cls2, Class<?> cls3) {
        MultiClassKey andSet = this.f18434b.getAndSet((Object) null);
        if (andSet == null) {
            andSet = new MultiClassKey();
        }
        andSet.b(cls, cls2, cls3);
        return andSet;
    }

    @Nullable
    public <Data, TResource, Transcode> LoadPath<Data, TResource, Transcode> a(Class<Data> cls, Class<TResource> cls2, Class<Transcode> cls3) {
        LoadPath<Data, TResource, Transcode> loadPath;
        MultiClassKey b2 = b(cls, cls2, cls3);
        synchronized (this.f18433a) {
            loadPath = this.f18433a.get(b2);
        }
        this.f18434b.set(b2);
        return loadPath;
    }

    public boolean c(@Nullable LoadPath<?, ?, ?> loadPath) {
        return f18432c.equals(loadPath);
    }

    public void d(Class<?> cls, Class<?> cls2, Class<?> cls3, @Nullable LoadPath<?, ?, ?> loadPath) {
        synchronized (this.f18433a) {
            ArrayMap<MultiClassKey, LoadPath<?, ?, ?>> arrayMap = this.f18433a;
            MultiClassKey multiClassKey = new MultiClassKey(cls, cls2, cls3);
            if (loadPath == null) {
                loadPath = f18432c;
            }
            arrayMap.put(multiClassKey, loadPath);
        }
    }
}
