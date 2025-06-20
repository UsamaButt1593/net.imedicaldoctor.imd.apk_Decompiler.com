package com.bumptech.glide.load.model.stream;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class HttpUriLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f18206b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoader<GlideUrl, InputStream> f18207a;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {
        public void a() {
        }

        @NonNull
        public ModelLoader<Uri, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new HttpUriLoader(multiModelLoaderFactory.d(GlideUrl.class, InputStream.class));
        }
    }

    public HttpUriLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this.f18207a = modelLoader;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<InputStream> b(@NonNull Uri uri, int i2, int i3, @NonNull Options options) {
        return this.f18207a.b(new GlideUrl(uri.toString()), i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return f18206b.contains(uri.getScheme());
    }
}
