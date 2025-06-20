package com.bumptech.glide.load.model.stream;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import java.net.URL;

public class UrlLoader implements ModelLoader<URL, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoader<GlideUrl, InputStream> f18218a;

    public static class StreamFactory implements ModelLoaderFactory<URL, InputStream> {
        public void a() {
        }

        @NonNull
        public ModelLoader<URL, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlLoader(multiModelLoaderFactory.d(GlideUrl.class, InputStream.class));
        }
    }

    public UrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.f18218a = modelLoader;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<InputStream> b(@NonNull URL url, int i2, int i3, @NonNull Options options) {
        return this.f18218a.b(new GlideUrl(url), i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(@NonNull URL url) {
        return true;
    }
}
