package com.bumptech.glide.load.model;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileLoader<Data> implements ModelLoader<File, Data> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f18133b = "FileLoader";

    /* renamed from: a  reason: collision with root package name */
    private final FileOpener<Data> f18134a;

    public static class Factory<Data> implements ModelLoaderFactory<File, Data> {

        /* renamed from: a  reason: collision with root package name */
        private final FileOpener<Data> f18135a;

        public Factory(FileOpener<Data> fileOpener) {
            this.f18135a = fileOpener;
        }

        public final void a() {
        }

        @NonNull
        public final ModelLoader<File, Data> c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new FileLoader(this.f18135a);
        }
    }

    public static class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory() {
            super(new FileOpener<ParcelFileDescriptor>() {
                public Class<ParcelFileDescriptor> a() {
                    return ParcelFileDescriptor.class;
                }

                /* renamed from: d */
                public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                    parcelFileDescriptor.close();
                }

                /* renamed from: e */
                public ParcelFileDescriptor c(File file) throws FileNotFoundException {
                    return ParcelFileDescriptor.open(file, 268435456);
                }
            });
        }
    }

    private static final class FileFetcher<Data> implements DataFetcher<Data> {
        private final FileOpener<Data> X;
        private Data Y;
        private final File s;

        FileFetcher(File file, FileOpener<Data> fileOpener) {
            this.s = file;
            this.X = fileOpener;
        }

        @NonNull
        public Class<Data> a() {
            return this.X.a();
        }

        public void b() {
            Data data = this.Y;
            if (data != null) {
                try {
                    this.X.b(data);
                } catch (IOException unused) {
                }
            }
        }

        public void cancel() {
        }

        @NonNull
        public DataSource d() {
            return DataSource.LOCAL;
        }

        public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            try {
                Data c2 = this.X.c(this.s);
                this.Y = c2;
                dataCallback.f(c2);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable(FileLoader.f18133b, 3)) {
                    Log.d(FileLoader.f18133b, "Failed to open file", e2);
                }
                dataCallback.c(e2);
            }
        }
    }

    public interface FileOpener<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(File file) throws FileNotFoundException;
    }

    public static class StreamFactory extends Factory<InputStream> {
        public StreamFactory() {
            super(new FileOpener<InputStream>() {
                public Class<InputStream> a() {
                    return InputStream.class;
                }

                /* renamed from: d */
                public void b(InputStream inputStream) throws IOException {
                    inputStream.close();
                }

                /* renamed from: e */
                public InputStream c(File file) throws FileNotFoundException {
                    return new FileInputStream(file);
                }
            });
        }
    }

    public FileLoader(FileOpener<Data> fileOpener) {
        this.f18134a = fileOpener;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<Data> b(@NonNull File file, int i2, int i3, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(file), new FileFetcher(file, this.f18134a));
    }

    /* renamed from: d */
    public boolean a(@NonNull File file) {
        return true;
    }
}
