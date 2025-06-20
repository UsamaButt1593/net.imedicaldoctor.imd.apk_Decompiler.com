package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.data.mediastore.ThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.InputStream;

public class MediaStoreImageThumbLoader implements ModelLoader<Uri, InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f18208a;

    public static class Factory implements ModelLoaderFactory<Uri, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f18209a;

        public Factory(Context context) {
            this.f18209a = context;
        }

        public void a() {
        }

        @NonNull
        public ModelLoader<Uri, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreImageThumbLoader(this.f18209a);
        }
    }

    public MediaStoreImageThumbLoader(Context context) {
        this.f18208a = context.getApplicationContext();
    }

    /* renamed from: c */
    public ModelLoader.LoadData<InputStream> b(@NonNull Uri uri, int i2, int i3, @NonNull Options options) {
        if (MediaStoreUtil.d(i2, i3)) {
            return new ModelLoader.LoadData<>(new ObjectKey(uri), ThumbFetcher.f(this.f18208a, uri));
        }
        return null;
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return MediaStoreUtil.a(uri);
    }
}
