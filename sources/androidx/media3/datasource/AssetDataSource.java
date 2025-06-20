package androidx.media3.datasource;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

@UnstableApi
public final class AssetDataSource extends BaseDataSource {

    /* renamed from: f  reason: collision with root package name */
    private final AssetManager f9743f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Uri f9744g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private InputStream f9745h;

    /* renamed from: i  reason: collision with root package name */
    private long f9746i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f9747j;

    public static final class AssetDataSourceException extends DataSourceException {
        @Deprecated
        public AssetDataSourceException(IOException iOException) {
            super((Throwable) iOException, 2000);
        }

        public AssetDataSourceException(@Nullable Throwable th, int i2) {
            super(th, i2);
        }
    }

    public AssetDataSource(Context context) {
        super(false);
        this.f9743f = context.getAssets();
    }

    public long a(DataSpec dataSpec) throws AssetDataSourceException {
        try {
            Uri uri = dataSpec.f9779a;
            this.f9744g = uri;
            String str = (String) Assertions.g(uri.getPath());
            if (str.startsWith("/android_asset/")) {
                str = str.substring(15);
            } else if (str.startsWith("/")) {
                str = str.substring(1);
            }
            v(dataSpec);
            InputStream open = this.f9743f.open(str, 1);
            this.f9745h = open;
            if (open.skip(dataSpec.f9785g) >= dataSpec.f9785g) {
                long j2 = dataSpec.f9786h;
                if (j2 != -1) {
                    this.f9746i = j2;
                } else {
                    long available = (long) this.f9745h.available();
                    this.f9746i = available;
                    if (available == 2147483647L) {
                        this.f9746i = -1;
                    }
                }
                this.f9747j = true;
                w(dataSpec);
                return this.f9746i;
            }
            throw new AssetDataSourceException((Throwable) null, 2008);
        } catch (AssetDataSourceException e2) {
            throw e2;
        } catch (IOException e3) {
            throw new AssetDataSourceException(e3, e3 instanceof FileNotFoundException ? PlaybackException.f3 : 2000);
        }
    }

    @Nullable
    public Uri c() {
        return this.f9744g;
    }

    public void close() throws AssetDataSourceException {
        this.f9744g = null;
        try {
            InputStream inputStream = this.f9745h;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f9745h = null;
            if (this.f9747j) {
                this.f9747j = false;
                u();
            }
        } catch (IOException e2) {
            throw new AssetDataSourceException(e2, 2000);
        } catch (Throwable th) {
            this.f9745h = null;
            if (this.f9747j) {
                this.f9747j = false;
                u();
            }
            throw th;
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws AssetDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f9746i;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, (long) i3);
            } catch (IOException e2) {
                throw new AssetDataSourceException(e2, 2000);
            }
        }
        int read = ((InputStream) Util.o(this.f9745h)).read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        long j3 = this.f9746i;
        if (j3 != -1) {
            this.f9746i = j3 - ((long) read);
        }
        t(read);
        return read;
    }
}
