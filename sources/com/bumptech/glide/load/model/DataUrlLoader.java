package com.bumptech.glide.load.model;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class DataUrlLoader<Model, Data> implements ModelLoader<Model, Data> {

    /* renamed from: b  reason: collision with root package name */
    private static final String f18128b = "data:image";

    /* renamed from: c  reason: collision with root package name */
    private static final String f18129c = ";base64";

    /* renamed from: a  reason: collision with root package name */
    private final DataDecoder<Data> f18130a;

    public interface DataDecoder<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data decode(String str) throws IllegalArgumentException;
    }

    private static final class DataUriFetcher<Data> implements DataFetcher<Data> {
        private final DataDecoder<Data> X;
        private Data Y;
        private final String s;

        DataUriFetcher(String str, DataDecoder<Data> dataDecoder) {
            this.s = str;
            this.X = dataDecoder;
        }

        @NonNull
        public Class<Data> a() {
            return this.X.a();
        }

        public void b() {
            try {
                this.X.b(this.Y);
            } catch (IOException unused) {
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
                Data decode = this.X.decode(this.s);
                this.Y = decode;
                dataCallback.f(decode);
            } catch (IllegalArgumentException e2) {
                dataCallback.c(e2);
            }
        }
    }

    public static final class StreamFactory<Model> implements ModelLoaderFactory<Model, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final DataDecoder<InputStream> f18131a = new DataDecoder<InputStream>() {
            public Class<InputStream> a() {
                return InputStream.class;
            }

            /* renamed from: c */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            /* renamed from: d */
            public InputStream decode(String str) {
                if (str.startsWith(DataUrlLoader.f18128b)) {
                    int indexOf = str.indexOf(44);
                    if (indexOf == -1) {
                        throw new IllegalArgumentException("Missing comma in data URL.");
                    } else if (str.substring(0, indexOf).endsWith(DataUrlLoader.f18129c)) {
                        return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                    } else {
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                } else {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
            }
        };

        public void a() {
        }

        @NonNull
        public ModelLoader<Model, InputStream> c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new DataUrlLoader(this.f18131a);
        }
    }

    public DataUrlLoader(DataDecoder<Data> dataDecoder) {
        this.f18130a = dataDecoder;
    }

    public boolean a(@NonNull Model model) {
        return model.toString().startsWith(f18128b);
    }

    public ModelLoader.LoadData<Data> b(@NonNull Model model, int i2, int i3, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(model), new DataUriFetcher(model.toString(), this.f18130a));
    }
}
