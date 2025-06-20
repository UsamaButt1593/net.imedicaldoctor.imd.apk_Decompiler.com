package androidx.media3.datasource.cache;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import androidx.media3.common.util.UnstableApi;
import java.io.File;
import java.io.IOException;
import java.util.NavigableSet;
import java.util.Set;

@UnstableApi
public interface Cache {

    /* renamed from: a  reason: collision with root package name */
    public static final long f9916a = -1;

    public static class CacheException extends IOException {
        public CacheException(String str) {
            super(str);
        }

        public CacheException(String str, Throwable th) {
            super(str, th);
        }

        public CacheException(Throwable th) {
            super(th);
        }
    }

    public interface Listener {
        void a(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2);

        void c(Cache cache, CacheSpan cacheSpan);

        void d(Cache cache, CacheSpan cacheSpan);
    }

    @WorkerThread
    void a();

    long b();

    @WorkerThread
    File c(String str, long j2, long j3) throws CacheException;

    void d(CacheSpan cacheSpan);

    ContentMetadata e(String str);

    long f(String str, long j2, long j3);

    void g(String str, Listener listener);

    @WorkerThread
    void h(CacheSpan cacheSpan);

    @WorkerThread
    @Nullable
    CacheSpan i(String str, long j2, long j3) throws CacheException;

    NavigableSet<CacheSpan> j(String str, Listener listener);

    long k(String str, long j2, long j3);

    @WorkerThread
    CacheSpan l(String str, long j2, long j3) throws InterruptedException, CacheException;

    Set<String> m();

    @WorkerThread
    void n(File file, long j2) throws CacheException;

    @WorkerThread
    void o(String str);

    @WorkerThread
    void p(String str, ContentMetadataMutations contentMetadataMutations) throws CacheException;

    long q();

    boolean r(String str, long j2, long j3);

    NavigableSet<CacheSpan> s(String str);
}
