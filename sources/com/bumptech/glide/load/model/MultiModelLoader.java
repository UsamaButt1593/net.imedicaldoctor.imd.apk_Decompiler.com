package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.util.Preconditions;
import com.dd.plist.ASCIIPropertyListParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MultiModelLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final List<ModelLoader<Model, Data>> f18171a;

    /* renamed from: b  reason: collision with root package name */
    private final Pools.Pool<List<Throwable>> f18172b;

    static class MultiFetcher<Data> implements DataFetcher<Data>, DataFetcher.DataCallback<Data> {
        private final Pools.Pool<List<Throwable>> X;
        private DataFetcher.DataCallback<? super Data> X2;
        private int Y = 0;
        @Nullable
        private List<Throwable> Y2;
        private Priority Z;
        private boolean Z2;
        private final List<DataFetcher<Data>> s;

        MultiFetcher(@NonNull List<DataFetcher<Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
            this.X = pool;
            Preconditions.c(list);
            this.s = list;
        }

        private void g() {
            if (!this.Z2) {
                if (this.Y < this.s.size() - 1) {
                    this.Y++;
                    e(this.Z, this.X2);
                    return;
                }
                Preconditions.d(this.Y2);
                this.X2.c(new GlideException("Fetch failed", (List<Throwable>) new ArrayList(this.Y2)));
            }
        }

        @NonNull
        public Class<Data> a() {
            return this.s.get(0).a();
        }

        public void b() {
            List<Throwable> list = this.Y2;
            if (list != null) {
                this.X.c(list);
            }
            this.Y2 = null;
            for (DataFetcher<Data> b2 : this.s) {
                b2.b();
            }
        }

        public void c(@NonNull Exception exc) {
            ((List) Preconditions.d(this.Y2)).add(exc);
            g();
        }

        public void cancel() {
            this.Z2 = true;
            for (DataFetcher<Data> cancel : this.s) {
                cancel.cancel();
            }
        }

        @NonNull
        public DataSource d() {
            return this.s.get(0).d();
        }

        public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            this.Z = priority;
            this.X2 = dataCallback;
            this.Y2 = this.X.b();
            this.s.get(this.Y).e(priority, this);
            if (this.Z2) {
                cancel();
            }
        }

        public void f(@Nullable Data data) {
            if (data != null) {
                this.X2.f(data);
            } else {
                g();
            }
        }
    }

    MultiModelLoader(@NonNull List<ModelLoader<Model, Data>> list, @NonNull Pools.Pool<List<Throwable>> pool) {
        this.f18171a = list;
        this.f18172b = pool;
    }

    public boolean a(@NonNull Model model) {
        for (ModelLoader<Model, Data> a2 : this.f18171a) {
            if (a2.a(model)) {
                return true;
            }
        }
        return false;
    }

    public ModelLoader.LoadData<Data> b(@NonNull Model model, int i2, int i3, @NonNull Options options) {
        ModelLoader.LoadData b2;
        int size = this.f18171a.size();
        ArrayList arrayList = new ArrayList(size);
        Key key = null;
        for (int i4 = 0; i4 < size; i4++) {
            ModelLoader modelLoader = this.f18171a.get(i4);
            if (modelLoader.a(model) && (b2 = modelLoader.b(model, i2, i3, options)) != null) {
                key = b2.f18164a;
                arrayList.add(b2.f18166c);
            }
        }
        if (arrayList.isEmpty() || key == null) {
            return null;
        }
        return new ModelLoader.LoadData<>(key, new MultiFetcher(arrayList, this.f18172b));
    }

    public String toString() {
        return "MultiModelLoader{modelLoaders=" + Arrays.toString(this.f18171a.toArray()) + ASCIIPropertyListParser.f18653k;
    }
}
