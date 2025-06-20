package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.util.List;

class DataCacheGenerator implements DataFetcherGenerator, DataFetcher.DataCallback<Object> {
    private final DecodeHelper<?> X;
    private Key X2;
    private final DataFetcherGenerator.FetcherReadyCallback Y;
    private List<ModelLoader<File, ?>> Y2;
    private int Z;
    private int Z2;
    private volatile ModelLoader.LoadData<?> a3;
    private File b3;
    private final List<Key> s;

    DataCacheGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this(decodeHelper.c(), decodeHelper, fetcherReadyCallback);
    }

    private boolean a() {
        return this.Z2 < this.Y2.size();
    }

    public boolean b() {
        while (true) {
            boolean z = false;
            if (this.Y2 == null || !a()) {
                int i2 = this.Z + 1;
                this.Z = i2;
                if (i2 >= this.s.size()) {
                    return false;
                }
                Key key = this.s.get(this.Z);
                File b2 = this.X.d().b(new DataCacheKey(key, this.X.o()));
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
                    int i3 = this.Z2;
                    this.Z2 = i3 + 1;
                    this.a3 = list.get(i3).b(this.b3, this.X.s(), this.X.f(), this.X.k());
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
        this.Y.a(this.X2, exc, this.a3.f18166c, DataSource.DATA_DISK_CACHE);
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.a3;
        if (loadData != null) {
            loadData.f18166c.cancel();
        }
    }

    public void f(Object obj) {
        this.Y.e(this.X2, obj, this.a3.f18166c, DataSource.DATA_DISK_CACHE, this.X2);
    }

    DataCacheGenerator(List<Key> list, DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.Z = -1;
        this.s = list;
        this.X = decodeHelper;
        this.Y = fetcherReadyCallback;
    }
}
