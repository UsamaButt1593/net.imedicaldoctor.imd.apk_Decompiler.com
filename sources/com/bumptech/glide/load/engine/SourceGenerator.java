package com.bumptech.glide.load.engine;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.LogTime;
import java.util.Collections;
import java.util.List;

class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {
    private static final String a3 = "SourceGenerator";
    private final DataFetcherGenerator.FetcherReadyCallback X;
    private Object X2;
    private int Y;
    private volatile ModelLoader.LoadData<?> Y2;
    private DataCacheGenerator Z;
    private DataCacheKey Z2;
    private final DecodeHelper<?> s;

    SourceGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.s = decodeHelper;
        this.X = fetcherReadyCallback;
    }

    /* JADX INFO: finally extract failed */
    private void d(Object obj) {
        long b2 = LogTime.b();
        try {
            Encoder<X> p = this.s.p(obj);
            DataCacheWriter dataCacheWriter = new DataCacheWriter(p, obj, this.s.k());
            this.Z2 = new DataCacheKey(this.Y2.f18164a, this.s.o());
            this.s.d().a(this.Z2, dataCacheWriter);
            if (Log.isLoggable(a3, 2)) {
                Log.v(a3, "Finished encoding source to cache, key: " + this.Z2 + ", data: " + obj + ", encoder: " + p + ", duration: " + LogTime.a(b2));
            }
            this.Y2.f18166c.b();
            this.Z = new DataCacheGenerator(Collections.singletonList(this.Y2.f18164a), this.s, this);
        } catch (Throwable th) {
            this.Y2.f18166c.b();
            throw th;
        }
    }

    private boolean f() {
        return this.Y < this.s.g().size();
    }

    private void j(final ModelLoader.LoadData<?> loadData) {
        this.Y2.f18166c.e(this.s.l(), new DataFetcher.DataCallback<Object>() {
            public void c(@NonNull Exception exc) {
                if (SourceGenerator.this.g(loadData)) {
                    SourceGenerator.this.i(loadData, exc);
                }
            }

            public void f(@Nullable Object obj) {
                if (SourceGenerator.this.g(loadData)) {
                    SourceGenerator.this.h(loadData, obj);
                }
            }
        });
    }

    public void a(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.X.a(key, exc, dataFetcher, this.Y2.f18166c.d());
    }

    public boolean b() {
        Object obj = this.X2;
        if (obj != null) {
            this.X2 = null;
            d(obj);
        }
        DataCacheGenerator dataCacheGenerator = this.Z;
        if (dataCacheGenerator != null && dataCacheGenerator.b()) {
            return true;
        }
        this.Z = null;
        this.Y2 = null;
        boolean z = false;
        while (!z && f()) {
            List<ModelLoader.LoadData<?>> g2 = this.s.g();
            int i2 = this.Y;
            this.Y = i2 + 1;
            this.Y2 = g2.get(i2);
            if (this.Y2 != null && (this.s.e().c(this.Y2.f18166c.d()) || this.s.t(this.Y2.f18166c.a()))) {
                j(this.Y2);
                z = true;
            }
        }
        return z;
    }

    public void c() {
        throw new UnsupportedOperationException();
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData = this.Y2;
        if (loadData != null) {
            loadData.f18166c.cancel();
        }
    }

    public void e(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.X.e(key, obj, dataFetcher, this.Y2.f18166c.d(), key);
    }

    /* access modifiers changed from: package-private */
    public boolean g(ModelLoader.LoadData<?> loadData) {
        ModelLoader.LoadData<?> loadData2 = this.Y2;
        return loadData2 != null && loadData2 == loadData;
    }

    /* access modifiers changed from: package-private */
    public void h(ModelLoader.LoadData<?> loadData, Object obj) {
        DiskCacheStrategy e2 = this.s.e();
        if (obj == null || !e2.c(loadData.f18166c.d())) {
            DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.X;
            Key key = loadData.f18164a;
            DataFetcher<Data> dataFetcher = loadData.f18166c;
            fetcherReadyCallback.e(key, obj, dataFetcher, dataFetcher.d(), this.Z2);
            return;
        }
        this.X2 = obj;
        this.X.c();
    }

    /* access modifiers changed from: package-private */
    public void i(ModelLoader.LoadData<?> loadData, @NonNull Exception exc) {
        DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback = this.X;
        DataCacheKey dataCacheKey = this.Z2;
        DataFetcher<Data> dataFetcher = loadData.f18166c;
        fetcherReadyCallback.a(dataCacheKey, exc, dataFetcher, dataFetcher.d());
    }
}
