package androidx.media3.datasource.cache;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.datasource.DataSpec;
import java.io.IOException;
import java.io.InterruptedIOException;

@UnstableApi
public final class CacheWriter {

    /* renamed from: k  reason: collision with root package name */
    public static final int f9973k = 131072;

    /* renamed from: a  reason: collision with root package name */
    private final CacheDataSource f9974a;

    /* renamed from: b  reason: collision with root package name */
    private final Cache f9975b;

    /* renamed from: c  reason: collision with root package name */
    private final DataSpec f9976c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9977d;

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f9978e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final ProgressListener f9979f;

    /* renamed from: g  reason: collision with root package name */
    private long f9980g;

    /* renamed from: h  reason: collision with root package name */
    private long f9981h;

    /* renamed from: i  reason: collision with root package name */
    private long f9982i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f9983j;

    public interface ProgressListener {
        void a(long j2, long j3, long j4);
    }

    public CacheWriter(CacheDataSource cacheDataSource, DataSpec dataSpec, @Nullable byte[] bArr, @Nullable ProgressListener progressListener) {
        this.f9974a = cacheDataSource;
        this.f9975b = cacheDataSource.u();
        this.f9976c = dataSpec;
        this.f9978e = bArr == null ? new byte[131072] : bArr;
        this.f9979f = progressListener;
        this.f9977d = cacheDataSource.v().a(dataSpec);
        this.f9980g = dataSpec.f9785g;
    }

    private long c() {
        long j2 = this.f9981h;
        if (j2 == -1) {
            return -1;
        }
        return j2 - this.f9976c.f9785g;
    }

    private void d(long j2) {
        this.f9982i += j2;
        ProgressListener progressListener = this.f9979f;
        if (progressListener != null) {
            progressListener.a(c(), this.f9982i, j2);
        }
    }

    private void e(long j2) {
        if (this.f9981h != j2) {
            this.f9981h = j2;
            ProgressListener progressListener = this.f9979f;
            if (progressListener != null) {
                progressListener.a(c(), this.f9982i, 0);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f A[Catch:{ IOException -> 0x0068 }] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0085 A[Catch:{ IOException -> 0x0068 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long f(long r10, long r12) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r10 + r12
            long r2 = r9.f9981h
            r4 = 1
            r5 = 0
            r6 = -1
            int r8 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r8 == 0) goto L_0x0013
            int r0 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r0 = 0
            goto L_0x0014
        L_0x0013:
            r0 = 1
        L_0x0014:
            int r1 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x0036
            androidx.media3.datasource.DataSpec r1 = r9.f9976c
            androidx.media3.datasource.DataSpec$Builder r1 = r1.a()
            androidx.media3.datasource.DataSpec$Builder r1 = r1.i(r10)
            androidx.media3.datasource.DataSpec$Builder r12 = r1.h(r12)
            androidx.media3.datasource.DataSpec r12 = r12.a()
            androidx.media3.datasource.cache.CacheDataSource r13 = r9.f9974a     // Catch:{ IOException -> 0x0031 }
            long r12 = r13.a(r12)     // Catch:{ IOException -> 0x0031 }
            goto L_0x0038
        L_0x0031:
            androidx.media3.datasource.cache.CacheDataSource r12 = r9.f9974a
            androidx.media3.datasource.DataSourceUtil.a(r12)
        L_0x0036:
            r12 = r6
            r4 = 0
        L_0x0038:
            if (r4 != 0) goto L_0x005d
            r9.g()
            androidx.media3.datasource.DataSpec r12 = r9.f9976c
            androidx.media3.datasource.DataSpec$Builder r12 = r12.a()
            androidx.media3.datasource.DataSpec$Builder r12 = r12.i(r10)
            androidx.media3.datasource.DataSpec$Builder r12 = r12.h(r6)
            androidx.media3.datasource.DataSpec r12 = r12.a()
            androidx.media3.datasource.cache.CacheDataSource r13 = r9.f9974a     // Catch:{ IOException -> 0x0056 }
            long r12 = r13.a(r12)     // Catch:{ IOException -> 0x0056 }
            goto L_0x005d
        L_0x0056:
            r10 = move-exception
            androidx.media3.datasource.cache.CacheDataSource r11 = r9.f9974a
            androidx.media3.datasource.DataSourceUtil.a(r11)
            throw r10
        L_0x005d:
            if (r0 == 0) goto L_0x006a
            int r1 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r1 == 0) goto L_0x006a
            long r12 = r12 + r10
            r9.e(r12)     // Catch:{ IOException -> 0x0068 }
            goto L_0x006a
        L_0x0068:
            r10 = move-exception
            goto L_0x008b
        L_0x006a:
            r12 = 0
            r13 = 0
        L_0x006c:
            r1 = -1
            if (r12 == r1) goto L_0x0083
            r9.g()     // Catch:{ IOException -> 0x0068 }
            androidx.media3.datasource.cache.CacheDataSource r12 = r9.f9974a     // Catch:{ IOException -> 0x0068 }
            byte[] r2 = r9.f9978e     // Catch:{ IOException -> 0x0068 }
            int r3 = r2.length     // Catch:{ IOException -> 0x0068 }
            int r12 = r12.read(r2, r5, r3)     // Catch:{ IOException -> 0x0068 }
            if (r12 == r1) goto L_0x006c
            long r1 = (long) r12     // Catch:{ IOException -> 0x0068 }
            r9.d(r1)     // Catch:{ IOException -> 0x0068 }
            int r13 = r13 + r12
            goto L_0x006c
        L_0x0083:
            if (r0 == 0) goto L_0x0091
            long r0 = (long) r13     // Catch:{ IOException -> 0x0068 }
            long r10 = r10 + r0
            r9.e(r10)     // Catch:{ IOException -> 0x0068 }
            goto L_0x0091
        L_0x008b:
            androidx.media3.datasource.cache.CacheDataSource r11 = r9.f9974a
            androidx.media3.datasource.DataSourceUtil.a(r11)
            throw r10
        L_0x0091:
            androidx.media3.datasource.cache.CacheDataSource r10 = r9.f9974a
            r10.close()
            long r10 = (long) r13
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.datasource.cache.CacheWriter.f(long, long):long");
    }

    private void g() throws InterruptedIOException {
        if (this.f9983j) {
            throw new InterruptedIOException();
        }
    }

    @WorkerThread
    public void a() throws IOException {
        long j2;
        g();
        Cache cache = this.f9975b;
        String str = this.f9977d;
        DataSpec dataSpec = this.f9976c;
        this.f9982i = cache.f(str, dataSpec.f9785g, dataSpec.f9786h);
        DataSpec dataSpec2 = this.f9976c;
        long j3 = dataSpec2.f9786h;
        if (j3 != -1) {
            this.f9981h = dataSpec2.f9785g + j3;
        } else {
            long a2 = c.a(this.f9975b.e(this.f9977d));
            if (a2 == -1) {
                a2 = -1;
            }
            this.f9981h = a2;
        }
        ProgressListener progressListener = this.f9979f;
        if (progressListener != null) {
            progressListener.a(c(), this.f9982i, 0);
        }
        while (true) {
            long j4 = this.f9981h;
            if (j4 == -1 || this.f9980g < j4) {
                g();
                long j5 = this.f9981h;
                long k2 = this.f9975b.k(this.f9977d, this.f9980g, j5 == -1 ? Long.MAX_VALUE : j5 - this.f9980g);
                if (k2 > 0) {
                    j2 = this.f9980g;
                } else {
                    long j6 = -k2;
                    if (j6 == Long.MAX_VALUE) {
                        j6 = -1;
                    }
                    j2 = this.f9980g;
                    k2 = f(j2, j6);
                }
                this.f9980g = j2 + k2;
            } else {
                return;
            }
        }
    }

    public void b() {
        this.f9983j = true;
    }
}
