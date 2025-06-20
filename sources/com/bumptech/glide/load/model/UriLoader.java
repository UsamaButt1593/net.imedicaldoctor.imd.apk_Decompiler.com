package com.bumptech.glide.load.model;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.AssetFileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.data.StreamLocalUriFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.itextpdf.text.Annotation;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class UriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: b  reason: collision with root package name */
    private static final Set<String> f18194b = Collections.unmodifiableSet(new HashSet(Arrays.asList(new String[]{Annotation.k3, "android.resource", Annotation.i3})));

    /* renamed from: a  reason: collision with root package name */
    private final LocalUriFetcherFactory<Data> f18195a;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Uri, AssetFileDescriptor>, LocalUriFetcherFactory<AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f18196a;

        public AssetFileDescriptorFactory(ContentResolver contentResolver) {
            this.f18196a = contentResolver;
        }

        public void a() {
        }

        public DataFetcher<AssetFileDescriptor> b(Uri uri) {
            return new AssetFileDescriptorLocalUriFetcher(this.f18196a, uri);
        }

        public ModelLoader<Uri, AssetFileDescriptor> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, LocalUriFetcherFactory<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f18197a;

        public FileDescriptorFactory(ContentResolver contentResolver) {
            this.f18197a = contentResolver;
        }

        public void a() {
        }

        public DataFetcher<ParcelFileDescriptor> b(Uri uri) {
            return new FileDescriptorLocalUriFetcher(this.f18197a, uri);
        }

        @NonNull
        public ModelLoader<Uri, ParcelFileDescriptor> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    public interface LocalUriFetcherFactory<Data> {
        DataFetcher<Data> b(Uri uri);
    }

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, LocalUriFetcherFactory<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final ContentResolver f18198a;

        public StreamFactory(ContentResolver contentResolver) {
            this.f18198a = contentResolver;
        }

        public void a() {
        }

        public DataFetcher<InputStream> b(Uri uri) {
            return new StreamLocalUriFetcher(this.f18198a, uri);
        }

        @NonNull
        public ModelLoader<Uri, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new UriLoader(this);
        }
    }

    public UriLoader(LocalUriFetcherFactory<Data> localUriFetcherFactory) {
        this.f18195a = localUriFetcherFactory;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<Data> b(@NonNull Uri uri, int i2, int i3, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), this.f18195a.b(uri));
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return f18194b.contains(uri.getScheme());
    }
}
