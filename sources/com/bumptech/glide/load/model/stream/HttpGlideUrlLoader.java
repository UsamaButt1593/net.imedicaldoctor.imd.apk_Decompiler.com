package com.bumptech.glide.load.model.stream;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media3.exoplayer.DefaultLoadControl;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.HttpUrlFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;

public class HttpGlideUrlLoader implements ModelLoader<GlideUrl, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    public static final Option<Integer> f18203b = Option.g("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", Integer.valueOf(DefaultLoadControl.o));
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final ModelCache<GlideUrl, GlideUrl> f18204a;

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ModelCache<GlideUrl, GlideUrl> f18205a = new ModelCache<>(500);

        public void a() {
        }

        @NonNull
        public ModelLoader<GlideUrl, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpGlideUrlLoader(this.f18205a);
        }
    }

    public HttpGlideUrlLoader() {
        this((ModelCache<GlideUrl, GlideUrl>) null);
    }

    /* renamed from: c */
    public ModelLoader.LoadData<InputStream> b(@NonNull GlideUrl glideUrl, int i2, int i3, @NonNull Options options) {
        ModelCache<GlideUrl, GlideUrl> modelCache = this.f18204a;
        if (modelCache != null) {
            GlideUrl b2 = modelCache.b(glideUrl, 0, 0);
            if (b2 == null) {
                this.f18204a.c(glideUrl, 0, 0, glideUrl);
            } else {
                glideUrl = b2;
            }
        }
        return new ModelLoader.LoadData<>(glideUrl, new HttpUrlFetcher(glideUrl, ((Integer) options.c(f18203b)).intValue()));
    }

    /* renamed from: d */
    public boolean a(@NonNull GlideUrl glideUrl) {
        return true;
    }

    public HttpGlideUrlLoader(@Nullable ModelCache<GlideUrl, GlideUrl> modelCache) {
        this.f18204a = modelCache;
    }
}
