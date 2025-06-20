package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool implements BitmapPool {

    /* renamed from: k  reason: collision with root package name */
    private static final String f17997k = "LruBitmapPool";

    /* renamed from: l  reason: collision with root package name */
    private static final Bitmap.Config f17998l = Bitmap.Config.ARGB_8888;

    /* renamed from: a  reason: collision with root package name */
    private final LruPoolStrategy f17999a;

    /* renamed from: b  reason: collision with root package name */
    private final Set<Bitmap.Config> f18000b;

    /* renamed from: c  reason: collision with root package name */
    private final long f18001c;

    /* renamed from: d  reason: collision with root package name */
    private final BitmapTracker f18002d;

    /* renamed from: e  reason: collision with root package name */
    private long f18003e;

    /* renamed from: f  reason: collision with root package name */
    private long f18004f;

    /* renamed from: g  reason: collision with root package name */
    private int f18005g;

    /* renamed from: h  reason: collision with root package name */
    private int f18006h;

    /* renamed from: i  reason: collision with root package name */
    private int f18007i;

    /* renamed from: j  reason: collision with root package name */
    private int f18008j;

    private interface BitmapTracker {
        void a(Bitmap bitmap);

        void b(Bitmap bitmap);
    }

    private static final class NullBitmapTracker implements BitmapTracker {
        NullBitmapTracker() {
        }

        public void a(Bitmap bitmap) {
        }

        public void b(Bitmap bitmap) {
        }
    }

    private static class ThrowingBitmapTracker implements BitmapTracker {

        /* renamed from: a  reason: collision with root package name */
        private final Set<Bitmap> f18009a = Collections.synchronizedSet(new HashSet());

        private ThrowingBitmapTracker() {
        }

        public void a(Bitmap bitmap) {
            if (this.f18009a.contains(bitmap)) {
                this.f18009a.remove(bitmap);
                return;
            }
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }

        public void b(Bitmap bitmap) {
            if (!this.f18009a.contains(bitmap)) {
                this.f18009a.add(bitmap);
                return;
            }
            throw new IllegalStateException("Can't add already added bitmap: " + bitmap + " [" + bitmap.getWidth() + "x" + bitmap.getHeight() + "]");
        }
    }

    public LruBitmapPool(long j2) {
        this(j2, p(), o());
    }

    @TargetApi(26)
    private static void h(Bitmap.Config config) {
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
    }

    @NonNull
    private static Bitmap i(int i2, int i3, @Nullable Bitmap.Config config) {
        if (config == null) {
            config = f17998l;
        }
        return Bitmap.createBitmap(i2, i3, config);
    }

    private void j() {
        if (Log.isLoggable(f17997k, 2)) {
            k();
        }
    }

    private void k() {
        Log.v(f17997k, "Hits=" + this.f18005g + ", misses=" + this.f18006h + ", puts=" + this.f18007i + ", evictions=" + this.f18008j + ", currentSize=" + this.f18004f + ", maxSize=" + this.f18003e + "\nStrategy=" + this.f17999a);
    }

    private void l() {
        v(this.f18003e);
    }

    @TargetApi(26)
    private static Set<Bitmap.Config> o() {
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i2 = Build.VERSION.SDK_INT;
        hashSet.add((Object) null);
        if (i2 >= 26) {
            hashSet.remove(Bitmap.Config.HARDWARE);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private static LruPoolStrategy p() {
        return new SizeConfigStrategy();
    }

    @Nullable
    private synchronized Bitmap q(int i2, int i3, @Nullable Bitmap.Config config) {
        Bitmap f2;
        try {
            h(config);
            f2 = this.f17999a.f(i2, i3, config != null ? config : f17998l);
            if (f2 == null) {
                if (Log.isLoggable(f17997k, 3)) {
                    Log.d(f17997k, "Missing bitmap=" + this.f17999a.a(i2, i3, config));
                }
                this.f18006h++;
            } else {
                this.f18005g++;
                this.f18004f -= (long) this.f17999a.b(f2);
                this.f18002d.a(f2);
                u(f2);
            }
            if (Log.isLoggable(f17997k, 2)) {
                Log.v(f17997k, "Get bitmap=" + this.f17999a.a(i2, i3, config));
            }
            j();
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return f2;
    }

    @TargetApi(19)
    private static void s(Bitmap bitmap) {
        bitmap.setPremultiplied(true);
    }

    private static void u(Bitmap bitmap) {
        bitmap.setHasAlpha(true);
        s(bitmap);
    }

    private synchronized void v(long j2) {
        while (this.f18004f > j2) {
            try {
                Bitmap removeLast = this.f17999a.removeLast();
                if (removeLast == null) {
                    if (Log.isLoggable(f17997k, 5)) {
                        Log.w(f17997k, "Size mismatch, resetting");
                        k();
                    }
                    this.f18004f = 0;
                    return;
                }
                this.f18002d.a(removeLast);
                this.f18004f -= (long) this.f17999a.b(removeLast);
                this.f18008j++;
                if (Log.isLoggable(f17997k, 3)) {
                    Log.d(f17997k, "Evicting bitmap=" + this.f17999a.c(removeLast));
                }
                j();
                removeLast.recycle();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
    }

    public long a() {
        return this.f18003e;
    }

    @SuppressLint({"InlinedApi"})
    public void b(int i2) {
        if (Log.isLoggable(f17997k, 3)) {
            Log.d(f17997k, "trimMemory, level=" + i2);
        }
        if (i2 >= 40 || (Build.VERSION.SDK_INT >= 23 && i2 >= 20)) {
            c();
        } else if (i2 >= 20 || i2 == 15) {
            v(a() / 2);
        }
    }

    public void c() {
        if (Log.isLoggable(f17997k, 3)) {
            Log.d(f17997k, "clearMemory");
        }
        v(0);
    }

    public synchronized void d(float f2) {
        this.f18003e = (long) Math.round(((float) this.f18001c) * f2);
        l();
    }

    public synchronized void e(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && ((long) this.f17999a.b(bitmap)) <= this.f18003e) {
                        if (this.f18000b.contains(bitmap.getConfig())) {
                            int b2 = this.f17999a.b(bitmap);
                            this.f17999a.e(bitmap);
                            this.f18002d.b(bitmap);
                            this.f18007i++;
                            this.f18004f += (long) b2;
                            if (Log.isLoggable(f17997k, 2)) {
                                Log.v(f17997k, "Put bitmap in pool=" + this.f17999a.c(bitmap));
                            }
                            j();
                            l();
                            return;
                        }
                    }
                    if (Log.isLoggable(f17997k, 2)) {
                        Log.v(f17997k, "Reject bitmap from pool, bitmap: " + this.f17999a.c(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.f18000b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            } catch (Throwable th) {
                throw th;
            }
        } else {
            throw new NullPointerException("Bitmap must not be null");
        }
    }

    @NonNull
    public Bitmap f(int i2, int i3, Bitmap.Config config) {
        Bitmap q = q(i2, i3, config);
        if (q == null) {
            return i(i2, i3, config);
        }
        q.eraseColor(0);
        return q;
    }

    @NonNull
    public Bitmap g(int i2, int i3, Bitmap.Config config) {
        Bitmap q = q(i2, i3, config);
        return q == null ? i(i2, i3, config) : q;
    }

    public long m() {
        return (long) this.f18008j;
    }

    public long n() {
        return this.f18004f;
    }

    public long r() {
        return (long) this.f18005g;
    }

    public long t() {
        return (long) this.f18006h;
    }

    LruBitmapPool(long j2, LruPoolStrategy lruPoolStrategy, Set<Bitmap.Config> set) {
        this.f18001c = j2;
        this.f18003e = j2;
        this.f17999a = lruPoolStrategy;
        this.f18000b = set;
        this.f18002d = new NullBitmapTracker();
    }

    public LruBitmapPool(long j2, Set<Bitmap.Config> set) {
        this(j2, p(), set);
    }
}
