package androidx.media3.datasource;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.BitmapLoader;
import androidx.media3.common.util.C0177a;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import androidx.media3.datasource.DefaultDataSource;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@UnstableApi
public final class DataSourceBitmapLoader implements BitmapLoader {

    /* renamed from: d  reason: collision with root package name */
    public static final Supplier<ListeningExecutorService> f9772d = Suppliers.b(new C0195d());

    /* renamed from: a  reason: collision with root package name */
    private final ListeningExecutorService f9773a;

    /* renamed from: b  reason: collision with root package name */
    private final DataSource.Factory f9774b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final BitmapFactory.Options f9775c;

    public DataSourceBitmapLoader(Context context) {
        this((ListeningExecutorService) Assertions.k(f9772d.get()), new DefaultDataSource.Factory(context));
    }

    private static Bitmap h(byte[] bArr, @Nullable BitmapFactory.Options options) throws IOException {
        boolean z = false;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        if (decodeByteArray != null) {
            z = true;
        }
        Assertions.b(z, "Could not decode image data");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        try {
            ExifInterface exifInterface = new ExifInterface((InputStream) byteArrayInputStream);
            byteArrayInputStream.close();
            int B = exifInterface.B();
            if (B == 0) {
                return decodeByteArray;
            }
            Matrix matrix = new Matrix();
            matrix.postRotate((float) B);
            return Bitmap.createBitmap(decodeByteArray, 0, 0, decodeByteArray.getWidth(), decodeByteArray.getHeight(), matrix, false);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Bitmap i(byte[] bArr) throws Exception {
        return h(bArr, this.f9775c);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Bitmap j(Uri uri) throws Exception {
        return l(this.f9774b.a(), uri, this.f9775c);
    }

    private static Bitmap l(DataSource dataSource, Uri uri, @Nullable BitmapFactory.Options options) throws IOException {
        try {
            dataSource.a(new DataSpec(uri));
            return h(DataSourceUtil.c(dataSource), options);
        } finally {
            dataSource.close();
        }
    }

    public ListenableFuture<Bitmap> a(Uri uri) {
        return this.f9773a.submit(new C0197f(this, uri));
    }

    public boolean b(String str) {
        return Util.g1(str);
    }

    public ListenableFuture<Bitmap> c(byte[] bArr) {
        return this.f9773a.submit(new C0196e(this, bArr));
    }

    public /* synthetic */ ListenableFuture d(MediaMetadata mediaMetadata) {
        return C0177a.a(this, mediaMetadata);
    }

    public DataSourceBitmapLoader(ListeningExecutorService listeningExecutorService, DataSource.Factory factory) {
        this(listeningExecutorService, factory, (BitmapFactory.Options) null);
    }

    public DataSourceBitmapLoader(ListeningExecutorService listeningExecutorService, DataSource.Factory factory, @Nullable BitmapFactory.Options options) {
        this.f9773a = listeningExecutorService;
        this.f9774b = factory;
        this.f9775c = options;
    }
}
