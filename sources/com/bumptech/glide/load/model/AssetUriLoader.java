package com.bumptech.glide.load.model;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.StreamAssetPathFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.itextpdf.text.Annotation;
import java.io.InputStream;

public class AssetUriLoader<Data> implements ModelLoader<Uri, Data> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f18116c = "android_asset";

    /* renamed from: d  reason: collision with root package name */
    private static final String f18117d = "file:///android_asset/";

    /* renamed from: e  reason: collision with root package name */
    private static final int f18118e = 22;

    /* renamed from: a  reason: collision with root package name */
    private final AssetManager f18119a;

    /* renamed from: b  reason: collision with root package name */
    private final AssetFetcherFactory<Data> f18120b;

    public interface AssetFetcherFactory<Data> {
        DataFetcher<Data> b(AssetManager assetManager, String str);
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Uri, ParcelFileDescriptor>, AssetFetcherFactory<ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f18121a;

        public FileDescriptorFactory(AssetManager assetManager) {
            this.f18121a = assetManager;
        }

        public void a() {
        }

        public DataFetcher<ParcelFileDescriptor> b(AssetManager assetManager, String str) {
            return new FileDescriptorAssetPathFetcher(assetManager, str);
        }

        @NonNull
        public ModelLoader<Uri, ParcelFileDescriptor> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f18121a, this);
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<Uri, InputStream>, AssetFetcherFactory<InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final AssetManager f18122a;

        public StreamFactory(AssetManager assetManager) {
            this.f18122a = assetManager;
        }

        public void a() {
        }

        public DataFetcher<InputStream> b(AssetManager assetManager, String str) {
            return new StreamAssetPathFetcher(assetManager, str);
        }

        @NonNull
        public ModelLoader<Uri, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new AssetUriLoader(this.f18122a, this);
        }
    }

    public AssetUriLoader(AssetManager assetManager, AssetFetcherFactory<Data> assetFetcherFactory) {
        this.f18119a = assetManager;
        this.f18120b = assetFetcherFactory;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<Data> b(@NonNull Uri uri, int i2, int i3, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), this.f18120b.b(this.f18119a, uri.toString().substring(f18118e)));
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return Annotation.k3.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && f18116c.equals(uri.getPathSegments().get(0));
    }
}
