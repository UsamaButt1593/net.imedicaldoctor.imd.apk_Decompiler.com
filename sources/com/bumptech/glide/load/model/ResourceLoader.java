package com.bumptech.glide.load.model;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

public class ResourceLoader<Data> implements ModelLoader<Integer, Data> {

    /* renamed from: c  reason: collision with root package name */
    private static final String f18182c = "ResourceLoader";

    /* renamed from: a  reason: collision with root package name */
    private final ModelLoader<Uri, Data> f18183a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f18184b;

    public static final class AssetFileDescriptorFactory implements ModelLoaderFactory<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f18185a;

        public AssetFileDescriptorFactory(Resources resources) {
            this.f18185a = resources;
        }

        public void a() {
        }

        public ModelLoader<Integer, AssetFileDescriptor> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f18185a, multiModelLoaderFactory.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class FileDescriptorFactory implements ModelLoaderFactory<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f18186a;

        public FileDescriptorFactory(Resources resources) {
            this.f18186a = resources;
        }

        public void a() {
        }

        @NonNull
        public ModelLoader<Integer, ParcelFileDescriptor> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f18186a, multiModelLoaderFactory.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f18187a;

        public StreamFactory(Resources resources) {
            this.f18187a = resources;
        }

        public void a() {
        }

        @NonNull
        public ModelLoader<Integer, InputStream> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f18187a, multiModelLoaderFactory.d(Uri.class, InputStream.class));
        }
    }

    public static class UriFactory implements ModelLoaderFactory<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f18188a;

        public UriFactory(Resources resources) {
            this.f18188a = resources;
        }

        public void a() {
        }

        @NonNull
        public ModelLoader<Integer, Uri> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ResourceLoader(this.f18188a, UnitModelLoader.c());
        }
    }

    public ResourceLoader(Resources resources, ModelLoader<Uri, Data> modelLoader) {
        this.f18184b = resources;
        this.f18183a = modelLoader;
    }

    @Nullable
    private Uri d(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f18184b.getResourcePackageName(num.intValue()) + '/' + this.f18184b.getResourceTypeName(num.intValue()) + '/' + this.f18184b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (!Log.isLoggable(f18182c, 5)) {
                return null;
            }
            Log.w(f18182c, "Received invalid resource id: " + num, e2);
            return null;
        }
    }

    /* renamed from: c */
    public ModelLoader.LoadData<Data> b(@NonNull Integer num, int i2, int i3, @NonNull Options options) {
        Uri d2 = d(num);
        if (d2 == null) {
            return null;
        }
        return this.f18183a.b(d2, i2, i3, options);
    }

    /* renamed from: e */
    public boolean a(@NonNull Integer num) {
        return true;
    }
}
