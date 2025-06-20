package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.util.Pools;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DecodeJob;
import com.bumptech.glide.load.engine.EngineResource;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Executors;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.pool.FactoryPools;
import java.util.Map;
import java.util.concurrent.Executor;

public class Engine implements EngineJobListener, MemoryCache.ResourceRemovedListener, EngineResource.ResourceListener {

    /* renamed from: i  reason: collision with root package name */
    private static final String f17912i = "Engine";

    /* renamed from: j  reason: collision with root package name */
    private static final int f17913j = 150;

    /* renamed from: k  reason: collision with root package name */
    private static final boolean f17914k = Log.isLoggable(f17912i, 2);

    /* renamed from: a  reason: collision with root package name */
    private final Jobs f17915a;

    /* renamed from: b  reason: collision with root package name */
    private final EngineKeyFactory f17916b;

    /* renamed from: c  reason: collision with root package name */
    private final MemoryCache f17917c;

    /* renamed from: d  reason: collision with root package name */
    private final EngineJobFactory f17918d;

    /* renamed from: e  reason: collision with root package name */
    private final ResourceRecycler f17919e;

    /* renamed from: f  reason: collision with root package name */
    private final LazyDiskCacheProvider f17920f;

    /* renamed from: g  reason: collision with root package name */
    private final DecodeJobFactory f17921g;

    /* renamed from: h  reason: collision with root package name */
    private final ActiveResources f17922h;

    @VisibleForTesting
    static class DecodeJobFactory {

        /* renamed from: a  reason: collision with root package name */
        final DecodeJob.DiskCacheProvider f17923a;

        /* renamed from: b  reason: collision with root package name */
        final Pools.Pool<DecodeJob<?>> f17924b = FactoryPools.e(Engine.f17913j, new FactoryPools.Factory<DecodeJob<?>>() {
            /* renamed from: b */
            public DecodeJob<?> a() {
                DecodeJobFactory decodeJobFactory = DecodeJobFactory.this;
                return new DecodeJob<>(decodeJobFactory.f17923a, decodeJobFactory.f17924b);
            }
        });

        /* renamed from: c  reason: collision with root package name */
        private int f17925c;

        DecodeJobFactory(DecodeJob.DiskCacheProvider diskCacheProvider) {
            this.f17923a = diskCacheProvider;
        }

        /* access modifiers changed from: package-private */
        public <R> DecodeJob<R> a(GlideContext glideContext, Object obj, EngineKey engineKey, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, boolean z3, Options options, DecodeJob.Callback<R> callback) {
            DecodeJob decodeJob = (DecodeJob) Preconditions.d(this.f17924b.b());
            int i4 = this.f17925c;
            int i5 = i4;
            this.f17925c = i4 + 1;
            return decodeJob.o(glideContext, obj, engineKey, key, i2, i3, cls, cls2, priority, diskCacheStrategy, map, z, z2, z3, options, callback, i5);
        }
    }

    @VisibleForTesting
    static class EngineJobFactory {

        /* renamed from: a  reason: collision with root package name */
        final GlideExecutor f17927a;

        /* renamed from: b  reason: collision with root package name */
        final GlideExecutor f17928b;

        /* renamed from: c  reason: collision with root package name */
        final GlideExecutor f17929c;

        /* renamed from: d  reason: collision with root package name */
        final GlideExecutor f17930d;

        /* renamed from: e  reason: collision with root package name */
        final EngineJobListener f17931e;

        /* renamed from: f  reason: collision with root package name */
        final EngineResource.ResourceListener f17932f;

        /* renamed from: g  reason: collision with root package name */
        final Pools.Pool<EngineJob<?>> f17933g = FactoryPools.e(Engine.f17913j, new FactoryPools.Factory<EngineJob<?>>() {
            /* renamed from: b */
            public EngineJob<?> a() {
                EngineJobFactory engineJobFactory = EngineJobFactory.this;
                return new EngineJob(engineJobFactory.f17927a, engineJobFactory.f17928b, engineJobFactory.f17929c, engineJobFactory.f17930d, engineJobFactory.f17931e, engineJobFactory.f17932f, engineJobFactory.f17933g);
            }
        });

        EngineJobFactory(GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, EngineJobListener engineJobListener, EngineResource.ResourceListener resourceListener) {
            this.f17927a = glideExecutor;
            this.f17928b = glideExecutor2;
            this.f17929c = glideExecutor3;
            this.f17930d = glideExecutor4;
            this.f17931e = engineJobListener;
            this.f17932f = resourceListener;
        }

        /* access modifiers changed from: package-private */
        public <R> EngineJob<R> a(Key key, boolean z, boolean z2, boolean z3, boolean z4) {
            return ((EngineJob) Preconditions.d(this.f17933g.b())).l(key, z, z2, z3, z4);
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public void b() {
            Executors.c(this.f17927a);
            Executors.c(this.f17928b);
            Executors.c(this.f17929c);
            Executors.c(this.f17930d);
        }
    }

    private static class LazyDiskCacheProvider implements DecodeJob.DiskCacheProvider {

        /* renamed from: a  reason: collision with root package name */
        private final DiskCache.Factory f17935a;

        /* renamed from: b  reason: collision with root package name */
        private volatile DiskCache f17936b;

        LazyDiskCacheProvider(DiskCache.Factory factory) {
            this.f17935a = factory;
        }

        public DiskCache a() {
            if (this.f17936b == null) {
                synchronized (this) {
                    try {
                        if (this.f17936b == null) {
                            this.f17936b = this.f17935a.build();
                        }
                        if (this.f17936b == null) {
                            this.f17936b = new DiskCacheAdapter();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
            return this.f17936b;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public synchronized void b() {
            if (this.f17936b != null) {
                this.f17936b.clear();
            }
        }
    }

    public class LoadStatus {

        /* renamed from: a  reason: collision with root package name */
        private final EngineJob<?> f17937a;

        /* renamed from: b  reason: collision with root package name */
        private final ResourceCallback f17938b;

        LoadStatus(ResourceCallback resourceCallback, EngineJob<?> engineJob) {
            this.f17938b = resourceCallback;
            this.f17937a = engineJob;
        }

        public void a() {
            synchronized (Engine.this) {
                this.f17937a.s(this.f17938b);
            }
        }
    }

    @VisibleForTesting
    Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, Jobs jobs, EngineKeyFactory engineKeyFactory, ActiveResources activeResources, EngineJobFactory engineJobFactory, DecodeJobFactory decodeJobFactory, ResourceRecycler resourceRecycler, boolean z) {
        this.f17917c = memoryCache;
        DiskCache.Factory factory2 = factory;
        LazyDiskCacheProvider lazyDiskCacheProvider = new LazyDiskCacheProvider(factory);
        this.f17920f = lazyDiskCacheProvider;
        ActiveResources activeResources2 = activeResources == null ? new ActiveResources(z) : activeResources;
        this.f17922h = activeResources2;
        activeResources2.g(this);
        this.f17916b = engineKeyFactory == null ? new EngineKeyFactory() : engineKeyFactory;
        this.f17915a = jobs == null ? new Jobs() : jobs;
        this.f17918d = engineJobFactory == null ? new EngineJobFactory(glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, this, this) : engineJobFactory;
        this.f17921g = decodeJobFactory == null ? new DecodeJobFactory(lazyDiskCacheProvider) : decodeJobFactory;
        this.f17919e = resourceRecycler == null ? new ResourceRecycler() : resourceRecycler;
        memoryCache.h(this);
    }

    private EngineResource<?> f(Key key) {
        Resource<?> g2 = this.f17917c.g(key);
        if (g2 == null) {
            return null;
        }
        return g2 instanceof EngineResource ? (EngineResource) g2 : new EngineResource<>(g2, true, true, key, this);
    }

    @Nullable
    private EngineResource<?> h(Key key) {
        EngineResource<?> e2 = this.f17922h.e(key);
        if (e2 != null) {
            e2.b();
        }
        return e2;
    }

    private EngineResource<?> i(Key key) {
        EngineResource<?> f2 = f(key);
        if (f2 != null) {
            f2.b();
            this.f17922h.a(key, f2);
        }
        return f2;
    }

    @Nullable
    private EngineResource<?> j(EngineKey engineKey, boolean z, long j2) {
        if (!z) {
            return null;
        }
        EngineResource<?> h2 = h(engineKey);
        if (h2 != null) {
            if (f17914k) {
                k("Loaded resource from active resources", j2, engineKey);
            }
            return h2;
        }
        EngineResource<?> i2 = i(engineKey);
        if (i2 == null) {
            return null;
        }
        if (f17914k) {
            k("Loaded resource from cache", j2, engineKey);
        }
        return i2;
    }

    private static void k(String str, long j2, Key key) {
        Log.v(f17912i, str + " in " + LogTime.a(j2) + "ms, key: " + key);
    }

    private <R> LoadStatus n(GlideContext glideContext, Object obj, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor, EngineKey engineKey, long j2) {
        ResourceCallback resourceCallback2 = resourceCallback;
        Executor executor2 = executor;
        EngineKey engineKey2 = engineKey;
        long j3 = j2;
        EngineJob<?> a2 = this.f17915a.a(engineKey2, z6);
        if (a2 != null) {
            a2.e(resourceCallback2, executor2);
            if (f17914k) {
                k("Added to existing load", j3, engineKey2);
            }
            return new LoadStatus(resourceCallback2, a2);
        }
        EngineJob a3 = this.f17918d.a(engineKey, z3, z4, z5, z6);
        EngineJob engineJob = a3;
        EngineKey engineKey3 = engineKey2;
        DecodeJob<R> a4 = this.f17921g.a(glideContext, obj, engineKey, key, i2, i3, cls, cls2, priority, diskCacheStrategy, map, z, z2, z6, options, a3);
        this.f17915a.d(engineKey3, engineJob);
        EngineJob engineJob2 = engineJob;
        EngineKey engineKey4 = engineKey3;
        ResourceCallback resourceCallback3 = resourceCallback;
        engineJob2.e(resourceCallback3, executor);
        engineJob2.t(a4);
        if (f17914k) {
            k("Started new load", j2, engineKey4);
        }
        return new LoadStatus(resourceCallback3, engineJob2);
    }

    public void a(@NonNull Resource<?> resource) {
        this.f17919e.a(resource, true);
    }

    public synchronized void b(EngineJob<?> engineJob, Key key, EngineResource<?> engineResource) {
        if (engineResource != null) {
            try {
                if (engineResource.e()) {
                    this.f17922h.a(key, engineResource);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        this.f17915a.e(key, engineJob);
    }

    public synchronized void c(EngineJob<?> engineJob, Key key) {
        this.f17915a.e(key, engineJob);
    }

    public void d(Key key, EngineResource<?> engineResource) {
        this.f17922h.d(key);
        if (engineResource.e()) {
            this.f17917c.f(key, engineResource);
        } else {
            this.f17919e.a(engineResource, false);
        }
    }

    public void e() {
        this.f17920f.a().clear();
    }

    public <R> LoadStatus g(GlideContext glideContext, Object obj, Key key, int i2, int i3, Class<?> cls, Class<R> cls2, Priority priority, DiskCacheStrategy diskCacheStrategy, Map<Class<?>, Transformation<?>> map, boolean z, boolean z2, Options options, boolean z3, boolean z4, boolean z5, boolean z6, ResourceCallback resourceCallback, Executor executor) {
        long b2 = f17914k ? LogTime.b() : 0;
        EngineKey a2 = this.f17916b.a(obj, key, i2, i3, map, cls, cls2, options);
        synchronized (this) {
            try {
                EngineResource<?> j2 = j(a2, z3, b2);
                if (j2 == null) {
                    LoadStatus n2 = n(glideContext, obj, key, i2, i3, cls, cls2, priority, diskCacheStrategy, map, z, z2, options, z3, z4, z5, z6, resourceCallback, executor, a2, b2);
                    return n2;
                }
                resourceCallback.c(j2, DataSource.MEMORY_CACHE);
                return null;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public void l(Resource<?> resource) {
        if (resource instanceof EngineResource) {
            ((EngineResource) resource).f();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    @VisibleForTesting
    public void m() {
        this.f17918d.b();
        this.f17920f.b();
        this.f17922h.h();
    }

    public Engine(MemoryCache memoryCache, DiskCache.Factory factory, GlideExecutor glideExecutor, GlideExecutor glideExecutor2, GlideExecutor glideExecutor3, GlideExecutor glideExecutor4, boolean z) {
        this(memoryCache, factory, glideExecutor, glideExecutor2, glideExecutor3, glideExecutor4, (Jobs) null, (EngineKeyFactory) null, (ActiveResources) null, (EngineJobFactory) null, (DecodeJobFactory) null, (ResourceRecycler) null, z);
    }
}
