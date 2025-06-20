package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

class ResourceCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private final DecodeHelper<?> X;
    private Key X2;
    private int Y;
    private List<ModelLoader<File, ?>> Y2;
    private int Z = -1;
    private int Z2;
    private volatile ModelLoader.LoadData<?> a3;
    private File b3;
    private ResourceCacheKey c3;
    private final DataFetcherGenerator.FetcherReadyCallback s;

    ResourceCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.X = decodeHelper;
        this.s = fetcherReadyCallback;
    }

    private boolean a() {
        return this.Z2 < this.Y2.size();
    }

    public boolean b() {
        List<Key> c2 = this.X.c();
        boolean z = false;
        if (c2.isEmpty()) {
            return false;
        }
        List<Class<?>> m2 = this.X.m();
        if (m2.isEmpty()) {
            if (File.class.equals(this.X.q())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.X.i() + " to " + this.X.q());
        }
        while (true) {
            if (this.Y2 == null || !a()) {
                int i2 = this.Z + 1;
                this.Z = i2;
                if (i2 >= m2.size()) {
                    int i3 = this.Y + 1;
                    this.Y = i3;
                    if (i3 >= c2.size()) {
                        return false;
                    }
                    this.Z = 0;
                }
                Key key = c2.get(this.Y);
                Class cls = m2.get(this.Z);
                Key key2 = key;
                this.c3 = new ResourceCacheKey(this.X.b(), key2, this.X.o(), this.X.s(), this.X.f(), this.X.r(cls), cls, this.X.k());
                File b2 = this.X.d().b(this.c3);
                this.b3 = b2;
                if (b2 != null) {
                    this.X2 = key;
                    this.Y2 = this.X.j(b2);
                    this.Z2 = 0;
                }
            } else {
                this.a3 = null;
                while (!z && a()) {
                    List<ModelLoader<File, ?>> list = this.Y2;
                    int i4 = this.Z2;
                    this.Z2 = i4 + 1;
                    this.a3 = list.get(i4).b(this.b3, this.X.s(), this.X.f(), this.X.k());
                    if (this.a3 != null && this.X.t(this.a3.f18166c.a())) {
                        this.a3.f18166c.e(this.X.l(), this);
                        z = true;
                    }
                }
                return z;
            }
        }
    }

    public void c(@NonNull Exception exc) {
        this.s.a(this.c3, exc, this.a3.f18166c, DataSource.RESOURCE_DISK_CACHE);
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.a3;
        if (loadData != null) {
            loadData.f18166c.cancel();
        }
    }

    public void f(Object obj) {
        this.s.e(this.X2, obj, this.a3.f18166c, DataSource.RESOURCE_DISK_CACHE, this.c3);
    }
}
