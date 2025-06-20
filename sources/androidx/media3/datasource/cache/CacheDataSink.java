package androidx.media3.datasource.cache;

import androidx.annotation.Nullable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Log;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.common.util.Util;
import androidx.media3.datasource.DataSink;
import androidx.media3.datasource.DataSpec;
import androidx.media3.datasource.cache.Cache;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@UnstableApi
public final class CacheDataSink implements DataSink {

    /* renamed from: k  reason: collision with root package name */
    public static final long f9917k = 5242880;

    /* renamed from: l  reason: collision with root package name */
    public static final int f9918l = 20480;

    /* renamed from: m  reason: collision with root package name */
    private static final long f9919m = 2097152;

    /* renamed from: n  reason: collision with root package name */
    private static final String f9920n = "CacheDataSink";

    /* renamed from: a  reason: collision with root package name */
    private final Cache f9921a;

    /* renamed from: b  reason: collision with root package name */
    private final long f9922b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9923c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private DataSpec f9924d;

    /* renamed from: e  reason: collision with root package name */
    private long f9925e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private File f9926f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private OutputStream f9927g;

    /* renamed from: h  reason: collision with root package name */
    private long f9928h;

    /* renamed from: i  reason: collision with root package name */
    private long f9929i;

    /* renamed from: j  reason: collision with root package name */
    private ReusableBufferedOutputStream f9930j;

    public static final class CacheDataSinkException extends Cache.CacheException {
        public CacheDataSinkException(IOException iOException) {
            super((Throwable) iOException);
        }
    }

    public static final class Factory implements DataSink.Factory {

        /* renamed from: a  reason: collision with root package name */
        private Cache f9931a;

        /* renamed from: b  reason: collision with root package name */
        private long f9932b = CacheDataSink.f9917k;

        /* renamed from: c  reason: collision with root package name */
        private int f9933c = CacheDataSink.f9918l;

        public DataSink a() {
            return new CacheDataSink((Cache) Assertions.g(this.f9931a), this.f9932b, this.f9933c);
        }

        @CanIgnoreReturnValue
        public Factory b(int i2) {
            this.f9933c = i2;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory c(Cache cache) {
            this.f9931a = cache;
            return this;
        }

        @CanIgnoreReturnValue
        public Factory d(long j2) {
            this.f9932b = j2;
            return this;
        }
    }

    public CacheDataSink(Cache cache, long j2) {
        this(cache, j2, f9918l);
    }

    private void b() throws IOException {
        OutputStream outputStream = this.f9927g;
        if (outputStream != null) {
            try {
                outputStream.flush();
                Util.t(this.f9927g);
                this.f9927g = null;
                this.f9926f = null;
                this.f9921a.n((File) Util.o(this.f9926f), this.f9928h);
            } catch (Throwable th) {
                Util.t(this.f9927g);
                this.f9927g = null;
                this.f9926f = null;
                ((File) Util.o(this.f9926f)).delete();
                throw th;
            }
        }
    }

    private void c(DataSpec dataSpec) throws IOException {
        long j2 = dataSpec.f9786h;
        long j3 = -1;
        if (j2 != -1) {
            j3 = Math.min(j2 - this.f9929i, this.f9925e);
        }
        this.f9926f = this.f9921a.c((String) Util.o(dataSpec.f9787i), dataSpec.f9785g + this.f9929i, j3);
        OutputStream fileOutputStream = new FileOutputStream(this.f9926f);
        if (this.f9923c > 0) {
            ReusableBufferedOutputStream reusableBufferedOutputStream = this.f9930j;
            if (reusableBufferedOutputStream == null) {
                this.f9930j = new ReusableBufferedOutputStream(fileOutputStream, this.f9923c);
            } else {
                reusableBufferedOutputStream.b(fileOutputStream);
            }
            fileOutputStream = this.f9930j;
        }
        this.f9927g = fileOutputStream;
        this.f9928h = 0;
    }

    public void a(DataSpec dataSpec) throws CacheDataSinkException {
        Assertions.g(dataSpec.f9787i);
        if (dataSpec.f9786h != -1 || !dataSpec.d(2)) {
            this.f9924d = dataSpec;
            this.f9925e = dataSpec.d(4) ? this.f9922b : Long.MAX_VALUE;
            this.f9929i = 0;
            try {
                c(dataSpec);
            } catch (IOException e2) {
                throw new CacheDataSinkException(e2);
            }
        } else {
            this.f9924d = null;
        }
    }

    public void close() throws CacheDataSinkException {
        if (this.f9924d != null) {
            try {
                b();
            } catch (IOException e2) {
                throw new CacheDataSinkException(e2);
            }
        }
    }

    public void write(byte[] bArr, int i2, int i3) throws CacheDataSinkException {
        DataSpec dataSpec = this.f9924d;
        if (dataSpec != null) {
            int i4 = 0;
            while (i4 < i3) {
                try {
                    if (this.f9928h == this.f9925e) {
                        b();
                        c(dataSpec);
                    }
                    int min = (int) Math.min((long) (i3 - i4), this.f9925e - this.f9928h);
                    ((OutputStream) Util.o(this.f9927g)).write(bArr, i2 + i4, min);
                    i4 += min;
                    long j2 = (long) min;
                    this.f9928h += j2;
                    this.f9929i += j2;
                } catch (IOException e2) {
                    throw new CacheDataSinkException(e2);
                }
            }
        }
    }

    public CacheDataSink(Cache cache, long j2, int i2) {
        Assertions.j(j2 > 0 || j2 == -1, "fragmentSize must be positive or C.LENGTH_UNSET.");
        int i3 = (j2 > -1 ? 1 : (j2 == -1 ? 0 : -1));
        if (i3 != 0 && j2 < 2097152) {
            Log.n(f9920n, "fragmentSize is below the minimum recommended value of 2097152. This may cause poor cache performance.");
        }
        this.f9921a = (Cache) Assertions.g(cache);
        this.f9922b = i3 == 0 ? Long.MAX_VALUE : j2;
        this.f9923c = i2;
    }
}
