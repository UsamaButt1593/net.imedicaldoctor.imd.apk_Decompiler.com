package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.mediastore.MediaStoreUtil;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import com.bumptech.glide.signature.ObjectKey;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RequiresApi(29)
public final class QMediaStoreUriLoader<DataT> implements ModelLoader<Uri, DataT> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f18212a;

    /* renamed from: b  reason: collision with root package name */
    private final ModelLoader<File, DataT> f18213b;

    /* renamed from: c  reason: collision with root package name */
    private final ModelLoader<Uri, DataT> f18214c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<DataT> f18215d;

    private static abstract class Factory<DataT> implements ModelLoaderFactory<Uri, DataT> {

        /* renamed from: a  reason: collision with root package name */
        private final Context f18216a;

        /* renamed from: b  reason: collision with root package name */
        private final Class<DataT> f18217b;

        Factory(Context context, Class<DataT> cls) {
            this.f18216a = context;
            this.f18217b = cls;
        }

        public final void a() {
        }

        @NonNull
        public final ModelLoader<Uri, DataT> c(@NonNull MultiModelLoaderFactory multiModelLoaderFactory) {
            return new QMediaStoreUriLoader(this.f18216a, multiModelLoaderFactory.d(File.class, this.f18217b), multiModelLoaderFactory.d(Uri.class, this.f18217b), this.f18217b);
        }
    }

    @RequiresApi(29)
    public static final class FileDescriptorFactory extends Factory<ParcelFileDescriptor> {
        public FileDescriptorFactory(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    @RequiresApi(29)
    public static final class InputStreamFactory extends Factory<InputStream> {
        public InputStreamFactory(Context context) {
            super(context, InputStream.class);
        }
    }

    private static final class QMediaStoreUriFetcher<DataT> implements DataFetcher<DataT> {
        private static final String[] d3 = {"_data"};
        private final ModelLoader<File, DataT> X;
        private final int X2;
        private final ModelLoader<Uri, DataT> Y;
        private final int Y2;
        private final Uri Z;
        private final Options Z2;
        private final Class<DataT> a3;
        private volatile boolean b3;
        @Nullable
        private volatile DataFetcher<DataT> c3;
        private final Context s;

        QMediaStoreUriFetcher(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Uri uri, int i2, int i3, Options options, Class<DataT> cls) {
            this.s = context.getApplicationContext();
            this.X = modelLoader;
            this.Y = modelLoader2;
            this.Z = uri;
            this.X2 = i2;
            this.Y2 = i3;
            this.Z2 = options;
            this.a3 = cls;
        }

        @Nullable
        private ModelLoader.LoadData<DataT> c() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.X.b(h(this.Z), this.X2, this.Y2, this.Z2);
            }
            return this.Y.b(g() ? MediaStore.setRequireOriginal(this.Z) : this.Z, this.X2, this.Y2, this.Z2);
        }

        @Nullable
        private DataFetcher<DataT> f() throws FileNotFoundException {
            ModelLoader.LoadData c2 = c();
            if (c2 != null) {
                return c2.f18166c;
            }
            return null;
        }

        private boolean g() {
            return this.s.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @NonNull
        private File h(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                cursor = this.s.getContentResolver().query(uri, d3, (String) null, (String[]) null, (String) null);
                if (cursor == null || !cursor.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                if (!TextUtils.isEmpty(string)) {
                    File file = new File(string);
                    cursor.close();
                    return file;
                }
                throw new FileNotFoundException("File path was empty in media store for: " + uri);
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        }

        @NonNull
        public Class<DataT> a() {
            return this.a3;
        }

        public void b() {
            DataFetcher<DataT> dataFetcher = this.c3;
            if (dataFetcher != null) {
                dataFetcher.b();
            }
        }

        public void cancel() {
            this.b3 = true;
            DataFetcher<DataT> dataFetcher = this.c3;
            if (dataFetcher != null) {
                dataFetcher.cancel();
            }
        }

        @NonNull
        public DataSource d() {
            return DataSource.LOCAL;
        }

        public void e(@NonNull Priority priority, @NonNull DataFetcher.DataCallback<? super DataT> dataCallback) {
            try {
                DataFetcher<DataT> f2 = f();
                if (f2 == null) {
                    dataCallback.c(new IllegalArgumentException("Failed to build fetcher for: " + this.Z));
                    return;
                }
                this.c3 = f2;
                if (this.b3) {
                    cancel();
                } else {
                    f2.e(priority, dataCallback);
                }
            } catch (FileNotFoundException e2) {
                dataCallback.c(e2);
            }
        }
    }

    QMediaStoreUriLoader(Context context, ModelLoader<File, DataT> modelLoader, ModelLoader<Uri, DataT> modelLoader2, Class<DataT> cls) {
        this.f18212a = context.getApplicationContext();
        this.f18213b = modelLoader;
        this.f18214c = modelLoader2;
        this.f18215d = cls;
    }

    /* renamed from: c */
    public ModelLoader.LoadData<DataT> b(@NonNull Uri uri, int i2, int i3, @NonNull Options options) {
        return new ModelLoader.LoadData<>(new ObjectKey(uri), new QMediaStoreUriFetcher(this.f18212a, this.f18213b, this.f18214c, uri, i2, i3, options, this.f18215d));
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && MediaStoreUtil.b(uri);
    }
}
