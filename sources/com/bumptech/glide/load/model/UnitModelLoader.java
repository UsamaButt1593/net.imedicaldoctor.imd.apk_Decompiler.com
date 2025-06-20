package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;

public class UnitModelLoader<Model> implements ModelLoader<Model, Model> {

    /* renamed from: a  reason: collision with root package name */
    private static final UnitModelLoader<?> f18192a = new UnitModelLoader<>();

    public static class Factory<Model> implements ModelLoaderFactory<Model, Model> {

        /* renamed from: a  reason: collision with root package name */
        private static final Factory<?> f18193a = new Factory<>();

        public static <T> Factory<T> b() {
            return f18193a;
        }

        public void a() {
        }

        @NonNull
        public ModelLoader<Model, Model> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return UnitModelLoader.c();
        }
    }

    private static class UnitFetcher<Model> implements DataFetcher<Model> {
        private final Model s;

        UnitFetcher(Model model) {
            this.s = model;
        }

        @NonNull
        public Class<Model> a() {
            return this.s.getClass();
        }

        public void b() {
        }

        public void cancel() {
        }

        @NonNull
        public DataSource d() {
            return DataSource.LOCAL;
        }

        public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Model> dataCallback) {
            dataCallback.f(this.s);
        }
    }

    public static <T> UnitModelLoader<T> c() {
        return f18192a;
    }

    public boolean a(@NonNull Model model) {
        return true;
    }

    public ModelLoader.LoadData<Model> b(@NonNull Model model, int i2, int i3, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new UnitFetcher(model));
    }
}
