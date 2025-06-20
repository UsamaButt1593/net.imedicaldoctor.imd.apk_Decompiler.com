package com.bumptech.glide.load.engine.cache;

import android.util.Log;
import com.bumptech.glide.disklrucache.DiskLruCache;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache;
import java.io.File;
import java.io.IOException;

public class DiskLruCacheWrapper implements DiskCache {

    /* renamed from: f  reason: collision with root package name */
    private static final String f18042f = "DiskLruCacheWrapper";

    /* renamed from: g  reason: collision with root package name */
    private static final int f18043g = 1;

    /* renamed from: h  reason: collision with root package name */
    private static final int f18044h = 1;

    /* renamed from: i  reason: collision with root package name */
    private static DiskLruCacheWrapper f18045i;

    /* renamed from: a  reason: collision with root package name */
    private final SafeKeyGenerator f18046a;

    /* renamed from: b  reason: collision with root package name */
    private final File f18047b;

    /* renamed from: c  reason: collision with root package name */
    private final long f18048c;

    /* renamed from: d  reason: collision with root package name */
    private final DiskCacheWriteLocker f18049d = new DiskCacheWriteLocker();

    /* renamed from: e  reason: collision with root package name */
    private DiskLruCache f18050e;

    @Deprecated
    protected DiskLruCacheWrapper(File file, long j2) {
        this.f18047b = file;
        this.f18048c = j2;
        this.f18046a = new SafeKeyGenerator();
    }

    public static DiskCache d(File file, long j2) {
        return new DiskLruCacheWrapper(file, j2);
    }

    @Deprecated
    public static synchronized DiskCache e(File file, long j2) {
        DiskLruCacheWrapper diskLruCacheWrapper;
        synchronized (DiskLruCacheWrapper.class) {
            try {
                if (f18045i == null) {
                    f18045i = new DiskLruCacheWrapper(file, j2);
                }
                diskLruCacheWrapper = f18045i;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return diskLruCacheWrapper;
    }

    private synchronized DiskLruCache f() throws IOException {
        try {
            if (this.f18050e == null) {
                this.f18050e = DiskLruCache.H(this.f18047b, 1, 1, this.f18048c);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f18050e;
    }

    private synchronized void g() {
        this.f18050e = null;
    }

    public void a(Key key, DiskCache.Writer writer) {
        DiskLruCache.Editor v;
        String b2 = this.f18046a.b(key);
        this.f18049d.a(b2);
        try {
            if (Log.isLoggable(f18042f, 2)) {
                Log.v(f18042f, "Put: Obtained: " + b2 + " for for Key: " + key);
            }
            try {
                DiskLruCache f2 = f();
                if (f2.y(b2) == null) {
                    v = f2.v(b2);
                    if (v != null) {
                        if (writer.a(v.f(0))) {
                            v.e();
                        }
                        v.b();
                        this.f18049d.b(b2);
                        return;
                    }
                    throw new IllegalStateException("Had two simultaneous puts for: " + b2);
                }
            } catch (IOException e2) {
                if (Log.isLoggable(f18042f, 5)) {
                    Log.w(f18042f, "Unable to put to disk cache", e2);
                }
            } catch (Throwable th) {
                v.b();
                throw th;
            }
        } finally {
            this.f18049d.b(b2);
        }
    }

    public File b(Key key) {
        String b2 = this.f18046a.b(key);
        if (Log.isLoggable(f18042f, 2)) {
            Log.v(f18042f, "Get: Obtained: " + b2 + " for for Key: " + key);
        }
        try {
            DiskLruCache.Value y = f().y(b2);
            if (y != null) {
                return y.b(0);
            }
            return null;
        } catch (IOException e2) {
            if (!Log.isLoggable(f18042f, 5)) {
                return null;
            }
            Log.w(f18042f, "Unable to get from disk cache", e2);
            return null;
        }
    }

    public void c(Key key) {
        try {
            f().O(this.f18046a.b(key));
        } catch (IOException e2) {
            if (Log.isLoggable(f18042f, 5)) {
                Log.w(f18042f, "Unable to delete from disk cache", e2);
            }
        }
    }

    public synchronized void clear() {
        try {
            f().t();
        } catch (IOException e2) {
            try {
                if (Log.isLoggable(f18042f, 5)) {
                    Log.w(f18042f, "Unable to clear disk cache or disk cache cleared externally", e2);
                }
            } catch (Throwable th) {
                g();
                throw th;
            }
        }
        g();
    }
}
