package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.File;
import java.io.InputStream;

public class StringLoader<Data> implements ModelLoader<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoader<Uri, Data> f18191a;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<String, AssetFileDescriptor> {
        public void a() {
        }

        public ModelLoader<String, AssetFileDescriptor> c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<String, ParcelFileDescriptor> {
        public void a() {
        }

        @NonNull
        public ModelLoader<String, ParcelFileDescriptor> c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<String, InputStream> {
        public void a() {
        }

        @NonNull
        public ModelLoader<String, InputStream> c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new StringLoader(multiModelLoaderFactory.d(Uri.class, InputStream.class));
        }
    }

    public StringLoader(ModelLoader<Uri, Data> modelLoader) {
        this.f18191a = modelLoader;
    }

    @Nullable
    private static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) != '/') {
            Uri parse = Uri.parse(str);
            if (parse.getScheme() != null) {
                return parse;
            }
        }
        return f(str);
    }

    private static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    /* renamed from: c */
    public ModelLoader.LoadData<Data> b(@NonNull String str, int i2, int i3, @NonNull Options options) {
        Uri e2 = e(str);
        if (e2 == null || !this.f18191a.a(e2)) {
            return null;
        }
        return this.f18191a.b(e2, i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(@NonNull String str) {
        return true;
    }
}
