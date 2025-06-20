package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.Registry;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MultiModelLoaderFactory {

    /* renamed from: e  reason: collision with root package name */
    private static final Factory f18173e = new Factory();

    /* renamed from: f  reason: collision with root package name */
    private static final ModelLoader<Object, Object> f18174f = new EmptyModelLoader();

    /* renamed from: a  reason: collision with root package name */
    private final List<Entry<?, ?>> f18175a;

    /* renamed from: b  reason: collision with root package name */
    private final Factory f18176b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<Entry<?, ?>> f18177c;

    /* renamed from: d  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f18178d;

    private static class EmptyModelLoader implements ModelLoader<Object, Object> {
        EmptyModelLoader() {
        }

        public boolean a(@NonNull Object obj) {
            return false;
        }

        @Nullable
        public ModelLoader.LoadData<Object> b(@NonNull Object obj, int i2, int i3, @NonNull Options options) {
            return null;
        }
    }

    private static class Entry<Model, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final Class<Model> f18179a;

        /* renamed from: b  reason: collision with root package name */
        final Class<Data> f18180b;

        /* renamed from: c  reason: collision with root package name */
        final ModelLoaderFactory<? extends Model, ? extends Data> f18181c;

        public Entry(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
            this.f18179a = cls;
            this.f18180b = cls2;
            this.f18181c = modelLoaderFactory;
        }

        public boolean a(@NonNull Class<?> cls) {
            return this.f18179a.isAssignableFrom(cls);
        }

        public boolean b(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return a(cls) && this.f18180b.isAssignableFrom(cls2);
        }
    }

    static class Factory {
        Factory() {
        }

        @NonNull
        public <Model, Data> MultiModelLoader<Model, Data> a(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            return new MultiModelLoader<>(list, pool);
        }
    }

    public MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool) {
        this(pool, f18173e);
    }

    private <Model, Data> void a(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory, boolean z) {
        Entry entry = new Entry(cls, cls2, modelLoaderFactory);
        List<Entry<?, ?>> list = this.f18175a;
        list.add(z ? list.size() : 0, entry);
    }

    @NonNull
    private <Model, Data> ModelLoader<Model, Data> c(@NonNull Entry<?, ?> entry) {
        return (ModelLoader) Preconditions.d(entry.f18181c.c(this));
    }

    @NonNull
    private static <Model, Data> ModelLoader<Model, Data> f() {
        return f18174f;
    }

    @NonNull
    private <Model, Data> ModelLoaderFactory<Model, Data> h(@NonNull Entry<?, ?> entry) {
        return entry.f18181c;
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> void b(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        a(cls, cls2, modelLoaderFactory, true);
    }

    @NonNull
    public synchronized <Model, Data> ModelLoader<Model, Data> d(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        try {
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (Entry next : this.f18175a) {
                if (this.f18177c.contains(next)) {
                    z = true;
                } else if (next.b(cls, cls2)) {
                    this.f18177c.add(next);
                    arrayList.add(c(next));
                    this.f18177c.remove(next);
                }
            }
            if (arrayList.size() > 1) {
                return this.f18176b.a(arrayList, this.f18178d);
            } else if (arrayList.size() == 1) {
                return (ModelLoader) arrayList.get(0);
            } else if (z) {
                return f();
            } else {
                throw new Registry.NoModelLoaderAvailableException((Class<?>) cls, (Class<?>) cls2);
            }
        } catch (Throwable th) {
            this.f18177c.clear();
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model> List<ModelLoader<Model, ?>> e(@NonNull Class<Model> cls) {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            for (Entry next : this.f18175a) {
                if (!this.f18177c.contains(next)) {
                    if (next.a(cls)) {
                        this.f18177c.add(next);
                        arrayList.add(c(next));
                        this.f18177c.remove(next);
                    }
                }
            }
        } catch (Throwable th) {
            this.f18177c.clear();
            throw th;
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public synchronized List<Class<?>> g(@NonNull Class<?> cls) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (Entry next : this.f18175a) {
            if (!arrayList.contains(next.f18180b) && next.a(cls)) {
                arrayList.add(next.f18180b);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public synchronized <Model, Data> void i(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        a(cls, cls2, modelLoaderFactory, false);
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> j(@NonNull Class<Model> cls, @NonNull Class<Data> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        Iterator<Entry<?, ?>> it2 = this.f18175a.iterator();
        while (it2.hasNext()) {
            Entry next = it2.next();
            if (next.b(cls, cls2)) {
                it2.remove();
                arrayList.add(h(next));
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public synchronized <Model, Data> List<ModelLoaderFactory<? extends Model, ? extends Data>> k(@NonNull Class<Model> cls, @NonNull Class<Data> cls2, @NonNull ModelLoaderFactory<? extends Model, ? extends Data> modelLoaderFactory) {
        List<ModelLoaderFactory<? extends Model, ? extends Data>> j2;
        j2 = j(cls, cls2);
        b(cls, cls2, modelLoaderFactory);
        return j2;
    }

    @VisibleForTesting
    MultiModelLoaderFactory(@NonNull Pools.Pool<List<Throwable>> pool, @NonNull Factory factory) {
        this.f18175a = new ArrayList();
        this.f18177c = new HashSet();
        this.f18178d = pool;
        this.f18176b = factory;
    }
}
