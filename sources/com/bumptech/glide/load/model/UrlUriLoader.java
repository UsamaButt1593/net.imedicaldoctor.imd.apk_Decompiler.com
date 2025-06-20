package com.bumptech.glide.load.model;

import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UrlUriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f18199b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{"http", "https"})));

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoader<GlideUrl, Data> f18200a;

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream> {
        public void a() {
        }

        @NonNull
        public ModelLoader<Uri, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UrlUriLoader(multiModelLoaderFactory.d(GlideUrl.class, InputStream.class));
        }
    }

    public UrlUriLoader(ModelLoader<GlideUrl, Data> modelLoader) {
        this.f18200a = modelLoader;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<Data> b(@NonNull Uri uri, int i2, int i3, @NonNull Options options) {
        return this.f18200a.b(new GlideUrl(uri.toString()), i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return f18199b.contains(uri.getScheme());
    }
}
