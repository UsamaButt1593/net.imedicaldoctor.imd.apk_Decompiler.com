package androidx.media3.datasource;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import com.itextpdf.text.Annotation;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

@UnstableApi
public final class ContentDataSource extends BaseDataSource {

    /* renamed from: f  reason: collision with root package name */
    private final ContentResolver f9761f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Uri f9762g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private AssetFileDescriptor f9763h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private FileInputStream f9764i;

    /* renamed from: j  reason: collision with root package name */
    private long f9765j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f9766k;

    public static class ContentDataSourceException extends DataSourceException {
        @Deprecated
        public ContentDataSourceException(IOException iOException) {
            this(iOException, 2000);
        }

        public ContentDataSourceException(@Nullable IOException iOException, int i2) {
            super((Throwable) iOException, i2);
        }
    }

    public ContentDataSource(Context context) {
        super(false);
        this.f9761f = context.getContentResolver();
    }

    public long a(DataSpec dataSpec) throws ContentDataSourceException {
        AssetFileDescriptor assetFileDescriptor;
        DataSpec dataSpec2 = dataSpec;
        int i2 = 2000;
        try {
            Uri normalizeScheme = dataSpec2.f9779a.normalizeScheme();
            this.f9762g = normalizeScheme;
            v(dataSpec);
            if (Annotation.i3.equals(normalizeScheme.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                assetFileDescriptor = this.f9761f.openTypedAssetFileDescriptor(normalizeScheme, "*/*", bundle);
            } else {
                assetFileDescriptor = this.f9761f.openAssetFileDescriptor(normalizeScheme, "r");
            }
            this.f9763h = assetFileDescriptor;
            if (assetFileDescriptor != null) {
                long length = assetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptor.getFileDescriptor());
                this.f9764i = fileInputStream;
                int i3 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
                if (i3 != 0) {
                    if (dataSpec2.f9785g > length) {
                        throw new ContentDataSourceException((IOException) null, 2008);
                    }
                }
                long startOffset = assetFileDescriptor.getStartOffset();
                long j2 = length;
                long skip = fileInputStream.skip(dataSpec2.f9785g + startOffset) - startOffset;
                if (skip == dataSpec2.f9785g) {
                    if (i3 == 0) {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        if (size == 0) {
                            this.f9765j = -1;
                        } else {
                            long position = size - channel.position();
                            this.f9765j = position;
                            if (position < 0) {
                                throw new ContentDataSourceException((IOException) null, 2008);
                            }
                        }
                    } else {
                        long j3 = j2 - skip;
                        this.f9765j = j3;
                        if (j3 < 0) {
                            throw new ContentDataSourceException((IOException) null, 2008);
                        }
                    }
                    long j4 = dataSpec2.f9786h;
                    if (j4 != -1) {
                        long j5 = this.f9765j;
                        if (j5 != -1) {
                            j4 = Math.min(j5, j4);
                        }
                        this.f9765j = j4;
                    }
                    this.f9766k = true;
                    w(dataSpec);
                    long j6 = dataSpec2.f9786h;
                    return j6 != -1 ? j6 : this.f9765j;
                }
                throw new ContentDataSourceException((IOException) null, 2008);
            }
            throw new ContentDataSourceException(new IOException("Could not open file descriptor for: " + normalizeScheme), 2000);
        } catch (ContentDataSourceException e2) {
            throw e2;
        } catch (IOException e3) {
            if (e3 instanceof FileNotFoundException) {
                i2 = PlaybackException.f3;
            }
            throw new ContentDataSourceException(e3, i2);
        }
    }

    @Nullable
    public Uri c() {
        return this.f9762g;
    }

    public void close() throws ContentDataSourceException {
        this.f9762g = null;
        try {
            FileInputStream fileInputStream = this.f9764i;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.f9764i = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.f9763h;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.f9763h = null;
                if (this.f9766k) {
                    this.f9766k = false;
                    u();
                }
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2, 2000);
            } catch (Throwable th) {
                this.f9763h = null;
                if (this.f9766k) {
                    this.f9766k = false;
                    u();
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new ContentDataSourceException(e3, 2000);
        } catch (Throwable th2) {
            this.f9764i = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.f9763h;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.f9763h = null;
                if (this.f9766k) {
                    this.f9766k = false;
                    u();
                }
                throw th2;
            } catch (IOException e4) {
                throw new ContentDataSourceException(e4, 2000);
            } catch (Throwable th3) {
                this.f9763h = null;
                if (this.f9766k) {
                    this.f9766k = false;
                    u();
                }
                throw th3;
            }
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws ContentDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f9765j;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, (long) i3);
            } catch (IOException e2) {
                throw new ContentDataSourceException(e2, 2000);
            }
        }
        int read = ((FileInputStream) Util.o(this.f9764i)).read(bArr, i2, i3);
        if (read == -1) {
            return -1;
        }
        long j3 = this.f9765j;
        if (j3 != -1) {
            this.f9765j = j3 - ((long) read);
        }
        t(read);
        return read;
    }
}
