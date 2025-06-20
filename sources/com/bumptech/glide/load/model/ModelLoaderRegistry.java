package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModelLoaderRegistry {

    /* renamed from: a  reason: collision with root package name */
    private final MultiModelLoaderFactory f18167a;

    /* renamed from: b  reason: collision with root package name */
    private final ModelLoaderCache f18168b;

    private static class ModelLoaderCache {

        /* renamed from: a  reason: collision with root package name */
        private final Map<Class<?>, Entry<?>> f18169a = new HashMap();

        private static class Entry<Model> {

            /* renamed from: a  reason: collision with root package name */
            final List<ModelLoader<Model, ?>> f18170a;

            public Entry(List<ModelLoader<Model, ?>> list) {
                this.f18170a = list;
            }
        }

        ModelLoaderCache() {
        }

        public void a() {
            this.f18169a.clear();
        }

        @Nullable
        public <Model> List<ModelLoader<Model, ?>> b(Class<Model> cls) {
            Entry entry = this.f18169a.get(cls);
            if (entry == null) {
                return null;
            }
            return entry.f18170a;
        }

        public <Model> void c(Class<Model> cls, List<ModelLoader<Model, ?>> list) {
            if (this.f18169a.put(cls, new Entry(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
    }

    public ModelLoaderRegistry(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(new MultiModelLoaderFactory(pool));
    }

    @NonNull
    private static <A> Class<A> c(@NonNull A a2) {
        return a2.getClass();
    }

    @NonNull
    private synchronized <A> List<ModelLoader<A, ?>> f(@NonNull Class<A> cls) {
        List<ModelLoader<A, ?>> b2;
        b2 = this.f18168b.b(cls);
        if (b2 == null) {
            b2 = Collections.unmodifiableList(this.f18167a.e(cls));
            this.f18168b.c(cls, b2);
        }
        return b2;
    }

    private <Model, Data> void j(@NonNull List<ModelLoaderFactory<? extends Model, ? extends Data>> list) {
        for (ModelLoaderFactory<? extends Model, ? extends Data> a2 : list) {
            a2.a();
        }
    }

    public synchronized <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f18167a.b(cls, cls2, modelLoaderFactory);
        this.f18168b.a();
    }

    public synchronized <Model, Data> ModelLoader<Model, Data> b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        return this.f18167a.d(cls, cls2);
    }

    @NonNull
    public synchronized List<Class<?>> d(@NonNull Class<?> cls) {
        return this.f18167a.g(cls);
    }

    @NonNull
    public <A> List<ModelLoader<A, ?>> e(@NonNull A a2) {
        List f2 = f(c(a2));
        if (!f2.isEmpty()) {
            int size = f2.size();
            List<ModelLoader<A, ?>> emptyList = Collections.emptyList();
            boolean z = true;
            for (int i2 = 0; i2 < size; i2++) {
                ModelLoader modelLoader = (ModelLoader) f2.get(i2);
                if (modelLoader.a(a2)) {
                    if (z) {
                        emptyList = new ArrayList<>(size - i2);
                        z = false;
                    }
                    emptyList.add(modelLoader);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new Registry.NoModelLoaderAvailableException(a2, f2);
        }
        throw new Registry.NoModelLoaderAvailableException(a2);
    }

    public synchronized <Model, Data> void g(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        this.f18167a.i(cls, cls2, modelLoaderFactory);
        this.f18168b.a();
    }

    public synchronized <Model, Data> void h(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        j(this.f18167a.j(cls, cls2));
        this.f18168b.a();
    }

    public synchronized <Model, Data> void i(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        j(this.f18167a.k(cls, cls2, modelLoaderFactory));
        this.f18168b.a();
    }

    private ModelLoaderRegistry(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
        this.f18168b = new ModelLoaderCache();
        this.f18167a = multiModelLoaderFactory;
    }
}
