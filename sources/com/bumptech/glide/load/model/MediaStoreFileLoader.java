package com.bumptech.glide.load.model;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;

public final class MediaStoreFileLoader implements ModelLoader<Uri, File> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f18155a;

    public static final class Factory implements ModelLoaderFactory<Uri, File> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f18156a;

        public Factory(Context context) {
            this.f18156a = context;
        }

        public void a() {
        }

        @NonNull
        public ModelLoader<Uri, File> c(MultiModelLoaderFactory multiModelLoaderFactory) {
            return new MediaStoreFileLoader(this.f18156a);
        }
    }

    private static class FilePathFetcher implements DataFetcher<File> {
        private static final String[] Y = {"_data"};
        private final Uri X;
        private final Context s;

        FilePathFetcher(Context context, Uri uri) {
            this.s = context;
            this.X = uri;
        }

        @NonNull
        public Class<File> a() {
            return File.class;
        }

        public void b() {
        }

        public void cancel() {
        }

        @NonNull
        public DataSource d() {
            return DataSource.LOCAL;
        }

        public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super File> dataCallback) {
            Cursor query = this.s.getContentResolver().query(this.X, Y, (String) null, (String[]) null, (String) null);
            String str = null;
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        str = query.getString(query.getColumnIndexOrThrow("_data"));
                    }
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(str)) {
                dataCallback.c(new FileNotFoundException("Failed to find file path for: " + this.X));
                return;
            }
            dataCallback.f(new File(str));
        }
    }

    public MediaStoreFileLoader(Context context) {
        this.f18155a = context;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<File> b(@NonNull Uri uri, int i2, int i3, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), new FilePathFetcher(this.f18155a, uri));
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return MediaStoreUtil.b(uri);
    }
}
