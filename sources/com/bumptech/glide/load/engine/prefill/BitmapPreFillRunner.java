package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

final class BitmapPreFillRunner implements Runnable {
    @VisibleForTesting
    static final String b3 = "PreFillRunner";
    private static final Clock c3 = new Clock();
    static final long d3 = 32;
    static final long e3 = 40;
    static final int f3 = 4;
    static final long g3 = TimeUnit.SECONDS.toMillis(1);
    private final MemoryCache X;
    private final Set<PreFillType> X2;
    private final PreFillQueue Y;
    private final Handler Y2;
    private final Clock Z;
    private long Z2;
    private boolean a3;
    private final BitmapPool s;

    @VisibleForTesting
    static class Clock {
        Clock() {
        }

        /* access modifiers changed from: package-private */
        public long a() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    private static final class UniqueKey implements Key {
        UniqueKey() {
        }

        public void a(@NonNull MessageDigest messageDigest) {
            throw new UnsupportedOperationException();
        }
    }

    public BitmapPreFillRunner(BitmapPool bitmapPool, MemoryCache memoryCache, PreFillQueue preFillQueue) {
        this(bitmapPool, memoryCache, preFillQueue, c3, new Handler(Looper.getMainLooper()));
    }

    private long c() {
        return this.X.a() - this.X.e();
    }

    private long d() {
        long j2 = this.Z2;
        this.Z2 = Math.min(4 * j2, g3);
        return j2;
    }

    private boolean e(long j2) {
        return this.Z.a() - j2 >= 32;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean a() {
        Bitmap bitmap;
        long a2 = this.Z.a();
        while (!this.Y.b() && !e(a2)) {
            PreFillType c2 = this.Y.c();
            if (!this.X2.contains(c2)) {
                this.X2.add(c2);
                bitmap = this.s.g(c2.d(), c2.b(), c2.a());
            } else {
                bitmap = Bitmap.createBitmap(c2.d(), c2.b(), c2.a());
            }
            int h2 = Util.h(bitmap);
            if (c() >= ((long) h2)) {
                this.X.f(new UniqueKey(), BitmapResource.e(bitmap, this.s));
            } else {
                this.s.e(bitmap);
            }
            if (Log.isLoggable(b3, 3)) {
                Log.d(b3, "allocated [" + c2.d() + "x" + c2.b() + "] " + c2.a() + " size: " + h2);
            }
        }
        return !this.a3 && !this.Y.b();
    }

    public void b() {
        this.a3 = true;
    }

    public void run() {
        if (a()) {
            this.Y2.postDelayed(this, d());
        }
    }

    @VisibleForTesting
    BitmapPreFillRunner(BitmapPool bitmapPool, MemoryCache memoryCache, PreFillQueue preFillQueue, Clock clock, Handler handler) {
        this.X2 = new HashSet();
        this.Z2 = e3;
        this.s = bitmapPool;
        this.X = memoryCache;
        this.Y = preFillQueue;
        this.Z = clock;
        this.Y2 = handler;
    }
}
