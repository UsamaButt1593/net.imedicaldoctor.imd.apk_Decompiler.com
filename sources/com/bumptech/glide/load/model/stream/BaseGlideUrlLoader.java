package com.bumptech.glide.load.model.stream;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class BaseGlideUrlLoader<Model> implements ModelLoader<Model, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoader<GlideUrl, InputStream> f18201a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final ModelCache<Model, GlideUrl> f18202b;

    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this(modelLoader, (ModelCache) null);
    }

    private static List<Key> c(Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (String glideUrl : collection) {
            arrayList.add(new GlideUrl(glideUrl));
        }
        return arrayList;
    }

    @Nullable
    public ModelLoader.LoadData<InputStream> b(@NonNull Model model, int i2, int i3, @NonNull Options options) {
        ModelCache<Model, GlideUrl> modelCache = this.f18202b;
        GlideUrl b2 = modelCache != null ? modelCache.b(model, i2, i3) : null;
        if (b2 == null) {
            String f2 = f(model, i2, i3, options);
            if (TextUtils.isEmpty(f2)) {
                return null;
            }
            GlideUrl glideUrl = new GlideUrl(f2, e(model, i2, i3, options));
            ModelCache<Model, GlideUrl> modelCache2 = this.f18202b;
            if (modelCache2 != null) {
                modelCache2.c(model, i2, i3, glideUrl);
            }
            b2 = glideUrl;
        }
        List<String> d2 = d(model, i2, i3, options);
        ModelLoader.LoadData<InputStream> b3 = this.f18201a.b(b2, i2, i3, options);
        return (b3 == null || d2.isEmpty()) ? b3 : new ModelLoader.LoadData<>(b3.f18164a, c(d2), b3.f18166c);
    }

    /* access modifiers changed from: protected */
    public List<String> d(Model model, int i2, int i3, Options options) {
        return Collections.emptyList();
    }

    /* access modifiers changed from: protected */
    @Nullable
    public Headers e(Model model, int i2, int i3, Options options) {
        return Headers.f18145b;
    }

    /* access modifiers changed from: protected */
    public abstract String f(Model model, int i2, int i3, Options options);

    protected BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader, @Nullable ModelCache<Model, GlideUrl> modelCache) {
        this.f18201a = modelLoader;
        this.f18202b = modelCache;
    }
}
