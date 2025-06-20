package com.bumptech.glide.load.model;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferFileLoader implements ModelLoader<File, ByteBuffer> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f18127a = "ByteBufferFileLoader";

    private static final class ByteBufferFetcher implements DataFetcher<ByteBuffer> {
        private final File s;

        ByteBufferFetcher(File file) {
            this.s = file;
        }

        @NonNull
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        public void b() {
        }

        public void cancel() {
        }

        @NonNull
        public DataSource d() {
            return DataSource.LOCAL;
        }

        public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super ByteBuffer> dataCallback) {
            try {
                dataCallback.f(ByteBufferUtil.a(this.s));
            } catch (IOException e2) {
                if (Log.isLoggable(ByteBufferFileLoader.f18127a, 3)) {
                    Log.d(ByteBufferFileLoader.f18127a, "Failed to obtain ByteBuffer for file", e2);
                }
                dataCallback.c(e2);
            }
        }
    }

    public static class Factory implements ModelLoaderFactory<File, ByteBuffer> {
        public void a() {
        }

        @NonNull
        public ModelLoader<File, ByteBuffer> c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new ByteBufferFileLoader();
        }
    }

    /* renamed from: c */
    public ModelLoader.LoadData<ByteBuffer> b(@NonNull File file, int i2, int i3, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(file), new ByteBufferFetcher(file));
    }

    /* renamed from: d */
    public boolean a(@NonNull File file) {
        return true;
    }
}
