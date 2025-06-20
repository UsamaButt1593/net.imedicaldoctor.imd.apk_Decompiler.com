package androidx.media3.datasource;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.media3.common.PlaybackException;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

@UnstableApi
public final class RawResourceDataSource extends BaseDataSource {
    @Deprecated

    /* renamed from: l  reason: collision with root package name */
    public static final String f9887l = "rawresource";

    /* renamed from: f  reason: collision with root package name */
    private final Context f9888f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private DataSpec f9889g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private AssetFileDescriptor f9890h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private InputStream f9891i;

    /* renamed from: j  reason: collision with root package name */
    private long f9892j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f9893k;

    public static class RawResourceDataSourceException extends DataSourceException {
        @Deprecated
        public RawResourceDataSourceException(String str) {
            super(str, (Throwable) null, 2000);
        }

        public RawResourceDataSourceException(@Nullable String str, @Nullable Throwable th, int i2) {
            super(str, th, i2);
        }

        @Deprecated
        public RawResourceDataSourceException(Throwable th) {
            super(th, 2000);
        }
    }

    public RawResourceDataSource(Context context) {
        super(false);
        this.f9888f = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i2) {
        return Uri.parse("rawresource:///" + i2);
    }

    private static AssetFileDescriptor x(Context context, DataSpec dataSpec) throws RawResourceDataSourceException {
        Resources resources;
        int i2;
        Uri normalizeScheme = dataSpec.f9779a.normalizeScheme();
        if (TextUtils.equals(f9887l, normalizeScheme.getScheme()) || (TextUtils.equals("android.resource", normalizeScheme.getScheme()) && normalizeScheme.getPathSegments().size() == 1 && ((String) Assertions.g(normalizeScheme.getLastPathSegment())).matches("\\d+"))) {
            resources = context.getResources();
            try {
                i2 = Integer.parseInt((String) Assertions.g(normalizeScheme.getLastPathSegment()));
            } catch (NumberFormatException unused) {
                throw new RawResourceDataSourceException("Resource identifier must be an integer.", (Throwable) null, 1004);
            }
        } else if (TextUtils.equals("android.resource", normalizeScheme.getScheme())) {
            String str = (String) Assertions.g(normalizeScheme.getPath());
            if (str.startsWith("/")) {
                str = str.substring(1);
            }
            String packageName = TextUtils.isEmpty(normalizeScheme.getHost()) ? context.getPackageName() : normalizeScheme.getHost();
            if (packageName.equals(context.getPackageName())) {
                resources = context.getResources();
            } else {
                try {
                    resources = context.getPackageManager().getResourcesForApplication(packageName);
                } catch (PackageManager.NameNotFoundException e2) {
                    throw new RawResourceDataSourceException("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e2, PlaybackException.f3);
                }
            }
            i2 = resources.getIdentifier(packageName + ":" + str, "raw", (String) null);
            if (i2 == 0) {
                throw new RawResourceDataSourceException("Resource not found.", (Throwable) null, PlaybackException.f3);
            }
        } else {
            throw new RawResourceDataSourceException("Unsupported URI scheme (" + normalizeScheme.getScheme() + "). Only " + "android.resource" + " is supported.", (Throwable) null, 1004);
        }
        try {
            AssetFileDescriptor openRawResourceFd = resources.openRawResourceFd(i2);
            if (openRawResourceFd != null) {
                return openRawResourceFd;
            }
            throw new RawResourceDataSourceException("Resource is compressed: " + normalizeScheme, (Throwable) null, 2000);
        } catch (Resources.NotFoundException e3) {
            throw new RawResourceDataSourceException((String) null, e3, PlaybackException.f3);
        }
    }

    public long a(DataSpec dataSpec) throws RawResourceDataSourceException {
        this.f9889g = dataSpec;
        v(dataSpec);
        AssetFileDescriptor x = x(this.f9888f, dataSpec);
        this.f9890h = x;
        long length = x.getLength();
        FileInputStream fileInputStream = new FileInputStream(this.f9890h.getFileDescriptor());
        this.f9891i = fileInputStream;
        int i2 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
        if (i2 != 0) {
            try {
                if (dataSpec.f9785g > length) {
                    throw new RawResourceDataSourceException((String) null, (Throwable) null, 2008);
                }
            } catch (RawResourceDataSourceException e2) {
                throw e2;
            } catch (IOException e3) {
                throw new RawResourceDataSourceException((String) null, e3, 2000);
            }
        }
        long startOffset = this.f9890h.getStartOffset();
        long skip = fileInputStream.skip(dataSpec.f9785g + startOffset) - startOffset;
        if (skip == dataSpec.f9785g) {
            if (i2 == 0) {
                FileChannel channel = fileInputStream.getChannel();
                if (channel.size() == 0) {
                    this.f9892j = -1;
                } else {
                    long size = channel.size() - channel.position();
                    this.f9892j = size;
                    if (size < 0) {
                        throw new RawResourceDataSourceException((String) null, (Throwable) null, 2008);
                    }
                }
            } else {
                long j2 = length - skip;
                this.f9892j = j2;
                if (j2 < 0) {
                    throw new DataSourceException(2008);
                }
            }
            long j3 = dataSpec.f9786h;
            if (j3 != -1) {
                long j4 = this.f9892j;
                if (j4 != -1) {
                    j3 = Math.min(j4, j3);
                }
                this.f9892j = j3;
            }
            this.f9893k = true;
            w(dataSpec);
            long j5 = dataSpec.f9786h;
            return j5 != -1 ? j5 : this.f9892j;
        }
        throw new RawResourceDataSourceException((String) null, (Throwable) null, 2008);
    }

    @Nullable
    public Uri c() {
        DataSpec dataSpec = this.f9889g;
        if (dataSpec != null) {
            return dataSpec.f9779a;
        }
        return null;
    }

    public void close() throws RawResourceDataSourceException {
        this.f9889g = null;
        try {
            InputStream inputStream = this.f9891i;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f9891i = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.f9890h;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.f9890h = null;
                if (this.f9893k) {
                    this.f9893k = false;
                    u();
                }
            } catch (IOException e2) {
                throw new RawResourceDataSourceException((String) null, e2, 2000);
            } catch (Throwable th) {
                this.f9890h = null;
                if (this.f9893k) {
                    this.f9893k = false;
                    u();
                }
                throw th;
            }
        } catch (IOException e3) {
            throw new RawResourceDataSourceException((String) null, e3, 2000);
        } catch (Throwable th2) {
            this.f9891i = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.f9890h;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.f9890h = null;
                if (this.f9893k) {
                    this.f9893k = false;
                    u();
                }
                throw th2;
            } catch (IOException e4) {
                throw new RawResourceDataSourceException((String) null, e4, 2000);
            } catch (Throwable th3) {
                this.f9890h = null;
                if (this.f9893k) {
                    this.f9893k = false;
                    u();
                }
                throw th3;
            }
        }
    }

    public int read(byte[] bArr, int i2, int i3) throws RawResourceDataSourceException {
        if (i3 == 0) {
            return 0;
        }
        long j2 = this.f9892j;
        if (j2 == 0) {
            return -1;
        }
        if (j2 != -1) {
            try {
                i3 = (int) Math.min(j2, (long) i3);
            } catch (IOException e2) {
                throw new RawResourceDataSourceException((String) null, e2, 2000);
            }
        }
        int read = ((InputStream) Util.o(this.f9891i)).read(bArr, i2, i3);
        if (read != -1) {
            long j3 = this.f9892j;
            if (j3 != -1) {
                this.f9892j = j3 - ((long) read);
            }
            t(read);
            return read;
        } else if (this.f9892j == -1) {
            return -1;
        } else {
            throw new RawResourceDataSourceException("End of stream reached having not read sufficient data.", new EOFException(), 2000);
        }
    }
}
