package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteArrayLoader<Data> implements ModelLoader<byte[], Data> {

    /* renamed from: a  reason: collision with root package name */
    private final Converter<Data> f18123a;

    public static class ByteBufferFactory implements ModelLoaderFactory<byte[], ByteBuffer> {
        public void a() {
        }

        @NonNull
        public ModelLoader<byte[], ByteBuffer> c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Converter<ByteBuffer>() {
                public Class<ByteBuffer> a() {
                    return ByteBuffer.class;
                }

                /* renamed from: c */
                public ByteBuffer b(byte[] bArr) {
                    return ByteBuffer.wrap(bArr);
                }
            });
        }
    }

    public interface Converter<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    private static class Fetcher<Data> implements DataFetcher<Data> {
        private final Converter<Data> X;
        private final byte[] s;

        Fetcher(byte[] bArr, Converter<Data> converter) {
            this.s = bArr;
            this.X = converter;
        }

        @NonNull
        public Class<Data> a() {
            return this.X.a();
        }

        public void b() {
        }

        public void cancel() {
        }

        @NonNull
        public DataSource d() {
            return DataSource.LOCAL;
        }

        public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super Data> dataCallback) {
            dataCallback.f(this.X.b(this.s));
        }
    }

    public static class StreamFactory implements ModelLoaderFactory<byte[], InputStream> {
        public void a() {
        }

        @NonNull
        public ModelLoader<byte[], InputStream> c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteArrayLoader(new Converter<InputStream>() {
                public Class<InputStream> a() {
                    return InputStream.class;
                }

                /* renamed from: c */
                public InputStream b(byte[] bArr) {
                    return new ByteArrayInputStream(bArr);
                }
            });
        }
    }

    public ByteArrayLoader(Converter<Data> converter) {
        this.f18123a = converter;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<Data> b(@NonNull byte[] bArr, int i2, int i3, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(bArr), new Fetcher(bArr, this.f18123a));
    }

    /* renamed from: d */
    public boolean a(@NonNull byte[] bArr) {
        return true;
    }
}
