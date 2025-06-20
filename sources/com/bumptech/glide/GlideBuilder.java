package com.bumptech.glide;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.os.BuildCompat;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPoolAdapter;
import com.bumptech.glide.load.engine.bitmap_recycle.LruArrayPool;
import com.bumptech.glide.load.engine.bitmap_recycle.LruBitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.load.engine.cache.LruResourceCache;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemorySizeCalculator;
import com.bumptech.glide.load.engine.executor.GlideExecutor;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.DefaultConnectivityMonitorFactory;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.util.Preconditions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class GlideBuilder {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Class<?>, TransitionOptions<?, ?>> f17596a = new ArrayMap();

    /* renamed from: b  reason: collision with root package name */
    private Engine f17597b;

    /* renamed from: c  reason: collision with root package name */
    private BitmapPool f17598c;

    /* renamed from: d  reason: collision with root package name */
    private ArrayPool f17599d;

    /* renamed from: e  reason: collision with root package name */
    private MemoryCache f17600e;

    /* renamed from: f  reason: collision with root package name */
    private GlideExecutor f17601f;

    /* renamed from: g  reason: collision with root package name */
    private GlideExecutor f17602g;

    /* renamed from: h  reason: collision with root package name */
    private DiskCache.Factory f17603h;

    /* renamed from: i  reason: collision with root package name */
    private MemorySizeCalculator f17604i;

    /* renamed from: j  reason: collision with root package name */
    private ConnectivityMonitorFactory f17605j;

    /* renamed from: k  reason: collision with root package name */
    private int f17606k = 4;

    /* renamed from: l  reason: collision with root package name */
    private Glide.RequestOptionsFactory f17607l = new Glide.RequestOptionsFactory() {
        @NonNull
        public RequestOptions build() {
            return new RequestOptions();
        }
    };
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private RequestManagerRetriever.RequestManagerFactory f17608m;

    /* renamed from: n  reason: collision with root package name */
    private GlideExecutor f17609n;
    private boolean o;
    @Nullable
    private List<RequestListener<Object>> p;
    private boolean q;
    private boolean r;

    @NonNull
    public GlideBuilder a(@NonNull RequestListener<Object> requestListener) {
        if (this.p == null) {
            this.p = new ArrayList();
        }
        this.p.add(requestListener);
        return this;
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Glide b(@NonNull Context context) {
        Context context2 = context;
        if (this.f17601f == null) {
            this.f17601f = GlideExecutor.k();
        }
        if (this.f17602g == null) {
            this.f17602g = GlideExecutor.f();
        }
        if (this.f17609n == null) {
            this.f17609n = GlideExecutor.c();
        }
        if (this.f17604i == null) {
            this.f17604i = new MemorySizeCalculator.Builder(context2).a();
        }
        if (this.f17605j == null) {
            this.f17605j = new DefaultConnectivityMonitorFactory();
        }
        if (this.f17598c == null) {
            int b2 = this.f17604i.b();
            if (b2 > 0) {
                this.f17598c = new LruBitmapPool((long) b2);
            } else {
                this.f17598c = new BitmapPoolAdapter();
            }
        }
        if (this.f17599d == null) {
            this.f17599d = new LruArrayPool(this.f17604i.a());
        }
        if (this.f17600e == null) {
            this.f17600e = new LruResourceCache((long) this.f17604i.d());
        }
        if (this.f17603h == null) {
            this.f17603h = new InternalCacheDiskCacheFactory(context2);
        }
        if (this.f17597b == null) {
            this.f17597b = new Engine(this.f17600e, this.f17603h, this.f17602g, this.f17601f, GlideExecutor.n(), this.f17609n, this.o);
        }
        List<RequestListener<Object>> list = this.p;
        this.p = list == null ? Collections.emptyList() : Collections.unmodifiableList(list);
        return new Glide(context, this.f17597b, this.f17600e, this.f17598c, this.f17599d, new RequestManagerRetriever(this.f17608m), this.f17605j, this.f17606k, this.f17607l, this.f17596a, this.p, this.q, this.r);
    }

    @NonNull
    public GlideBuilder c(@Nullable GlideExecutor glideExecutor) {
        this.f17609n = glideExecutor;
        return this;
    }

    @NonNull
    public GlideBuilder d(@Nullable ArrayPool arrayPool) {
        this.f17599d = arrayPool;
        return this;
    }

    @NonNull
    public GlideBuilder e(@Nullable BitmapPool bitmapPool) {
        this.f17598c = bitmapPool;
        return this;
    }

    @NonNull
    public GlideBuilder f(@Nullable ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.f17605j = connectivityMonitorFactory;
        return this;
    }

    @NonNull
    public GlideBuilder g(@NonNull Glide.RequestOptionsFactory requestOptionsFactory) {
        this.f17607l = (Glide.RequestOptionsFactory) Preconditions.d(requestOptionsFactory);
        return this;
    }

    @NonNull
    public GlideBuilder h(@Nullable final RequestOptions requestOptions) {
        return g(new Glide.RequestOptionsFactory() {
            @NonNull
            public RequestOptions build() {
                RequestOptions requestOptions = requestOptions;
                return requestOptions != null ? requestOptions : new RequestOptions();
            }
        });
    }

    @NonNull
    public <T> GlideBuilder i(@NonNull Class<T> cls, @Nullable TransitionOptions<?, T> transitionOptions) {
        this.f17596a.put(cls, transitionOptions);
        return this;
    }

    @NonNull
    public GlideBuilder j(@Nullable DiskCache.Factory factory) {
        this.f17603h = factory;
        return this;
    }

    @NonNull
    public GlideBuilder k(@Nullable GlideExecutor glideExecutor) {
        this.f17602g = glideExecutor;
        return this;
    }

    /* access modifiers changed from: package-private */
    public GlideBuilder l(Engine engine) {
        this.f17597b = engine;
        return this;
    }

    public GlideBuilder m(boolean z) {
        if (!BuildCompat.g()) {
            return this;
        }
        this.r = z;
        return this;
    }

    @NonNull
    public GlideBuilder n(boolean z) {
        this.o = z;
        return this;
    }

    @NonNull
    public GlideBuilder o(int i2) {
        if (i2 < 2 || i2 > 6) {
            throw new IllegalArgumentException("Log level must be one of Log.VERBOSE, Log.DEBUG, Log.INFO, Log.WARN, or Log.ERROR");
        }
        this.f17606k = i2;
        return this;
    }

    public GlideBuilder p(boolean z) {
        this.q = z;
        return this;
    }

    @NonNull
    public GlideBuilder q(@Nullable MemoryCache memoryCache) {
        this.f17600e = memoryCache;
        return this;
    }

    @NonNull
    public GlideBuilder r(@NonNull MemorySizeCalculator.Builder builder) {
        return s(builder.a());
    }

    @NonNull
    public GlideBuilder s(@Nullable MemorySizeCalculator memorySizeCalculator) {
        this.f17604i = memorySizeCalculator;
        return this;
    }

    /* access modifiers changed from: package-private */
    public void t(@Nullable RequestManagerRetriever.RequestManagerFactory requestManagerFactory) {
        this.f17608m = requestManagerFactory;
    }

    @Deprecated
    public GlideBuilder u(@Nullable GlideExecutor glideExecutor) {
        return v(glideExecutor);
    }

    @NonNull
    public GlideBuilder v(@Nullable GlideExecutor glideExecutor) {
        this.f17601f = glideExecutor;
        return this;
    }
}
