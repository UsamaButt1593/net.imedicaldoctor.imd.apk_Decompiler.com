package androidx.media3.datasource;

import android.net.Uri;
import android.system.ErrnoException;
import android.system.OsConstants;
import android.text.TextUtils;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSource;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

@UnstableApi
public final class FileDataSource extends BaseDataSource {
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private RandomAccessFile f9836f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Uri f9837g;

    /* renamed from: h  reason: collision with root package name */
    private long f9838h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f9839i;

    @RequiresApi(21)
    private static final class Api21 {
        private Api21() {
        }

        /* access modifiers changed from: private */
        @DoNotInline
        public static boolean b(@Nullable Throwable th) {
            return (th instanceof ErrnoException) && ((ErrnoException) th).errno == OsConstants.EACCES;
        }
    }

    public static final class Factory implements DataSource.Factory {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        private TransferListener f9840a;

        /* renamed from: c */
        public FileDataSource a() {
            FileDataSource fileDataSource = new FileDataSource();
            TransferListener transferListener = this.f9840a;
            if (transferListener != null) {
                fileDataSource.e(transferListener);
            }
            return fileDataSource;
        }

        @CanIgnoreReturnValue
        public Factory d(@Nullable TransferListener transferListener) {
            this.f9840a = transferListener;
            return this;
        }
    }

    public static class FileDataSourceException extends DataSourceException {
        @Deprecated
        public FileDataSourceException(Exception exc) {
            super((Throwable) exc, 2000);
        }

        @Deprecated
        public FileDataSourceException(String str, IOException iOException) {
            super(str, iOException, 2000);
        }

        public FileDataSourceException(@Nullable String str, @Nullable Throwable th, int i2) {
            super(str, th, i2);
        }

        public FileDataSourceException(Throwable th, int i2) {
            super(th, i2);
        }
    }

    public FileDataSource() {
        super(false);
    }

    private static RandomAccessFile x(Uri uri) throws FileDataSourceException {
        int i2 = PlaybackException.g3;
        try {
            return new RandomAccessFile((String) Assertions.g(uri.getPath()), "r");
        } catch (FileNotFoundException e2) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new FileDataSourceException(String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", new Object[]{uri.getPath(), uri.getQuery(), uri.getFragment()}), e2, 1004);
            }
            if (Util.f9646a < 21 || !Api21.b(e2.getCause())) {
                i2 = PlaybackException.f3;
            }
            throw new FileDataSourceException((Throwable) e2, i2);
        } catch (SecurityException e3) {
            throw new FileDataSourceException((Throwable) e3, (int) PlaybackException.g3);
        } catch (RuntimeException e4) {
            throw new FileDataSourceException((Throwable) e4, 2000);
        }
    }

    public long a(DataSpec dataSpec) throws FileDataSourceException {
        Uri uri = dataSpec.f9779a;
        this.f9837g = uri;
        v(dataSpec);
        RandomAccessFile x = x(uri);
        this.f9836f = x;
        try {
            x.seek(dataSpec.f9785g);
            long j2 = dataSpec.f9786h;
            if (j2 == -1) {
                j2 = this.f9836f.length() - dataSpec.f9785g;
            }
            this.f9838h = j2;
            if (j2 >= 0) {
                this.f9839i = true;
                w(dataSpec);
                return this.f9838h;
            }
            throw new FileDataSourceException((String) null, (Throwable) null, 2008);
        } catch (IOException e2) {
            throw new FileDataSourceException((Throwable) e2, 2000);
        }
    }

    @Nullable
    public Uri c() {
        return this.f9837g;
    }

    public void close() throws FileDataSourceException {
        this.f9837g = null;
        try {
            RandomAccessFile randomAccessFile = this.f9836f;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.f9836f = null;
            if (this.f9839i) {
                this.f9839i = false;
                u();
            }
        } catch (IOException e2) {
            throw new FileDataSourceException((Throwable) e2, 2000);
        } catch (Throwable th) {
            this.f9836f = null;
            if (this.f9839i) {
                this.f9839i = false;
                u();
            }
            throw th;
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws FileDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        if (this.f9838h == 0) {
            return -1;
        }
        try {
            int read = ((RandomAccessFile) Util.o(this.f9836f)).read(bArr, i2, (int) Math.min(this.f9838h, (long) i3));
            if (read > 0) {
                this.f9838h -= (long) read;
                t(read);
            }
            return read;
        } catch (IOException e2) {
            throw new FileDataSourceException((Throwable) e2, 2000);
        }
    }
}
