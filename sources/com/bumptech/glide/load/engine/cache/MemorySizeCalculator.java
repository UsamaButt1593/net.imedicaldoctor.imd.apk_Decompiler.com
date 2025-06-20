package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;

public final class MemorySizeCalculator {

    /* renamed from: e  reason: collision with root package name */
    private static final String f18059e = "MemorySizeCalculator";
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    static final int f18060f = 4;

    /* renamed from: g  reason: collision with root package name */
    private static final int f18061g = 2;

    /* renamed from: a  reason: collision with root package name */
    private final int f18062a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18063b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f18064c;

    /* renamed from: d  reason: collision with root package name */
    private final int f18065d;

    public static final class Builder {
        @VisibleForTesting

        /* renamed from: i  reason: collision with root package name */
        static final int f18066i = 2;

        /* renamed from: j  reason: collision with root package name */
        static final int f18067j = (Build.VERSION.SDK_INT < 26 ? 4 : 1);

        /* renamed from: k  reason: collision with root package name */
        static final float f18068k = 0.4f;

        /* renamed from: l  reason: collision with root package name */
        static final float f18069l = 0.33f;

        /* renamed from: m  reason: collision with root package name */
        static final int f18070m = 4194304;

        /* renamed from: a  reason: collision with root package name */
        final Context f18071a;

        /* renamed from: b  reason: collision with root package name */
        ActivityManager f18072b;

        /* renamed from: c  reason: collision with root package name */
        ScreenDimensions f18073c;

        /* renamed from: d  reason: collision with root package name */
        float f18074d = 2.0f;

        /* renamed from: e  reason: collision with root package name */
        float f18075e = ((float) f18067j);

        /* renamed from: f  reason: collision with root package name */
        float f18076f = f18068k;

        /* renamed from: g  reason: collision with root package name */
        float f18077g = f18069l;

        /* renamed from: h  reason: collision with root package name */
        int f18078h = 4194304;

        public Builder(Context context) {
            this.f18071a = context;
            this.f18072b = (ActivityManager) context.getSystemService("activity");
            this.f18073c = new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT >= 26 && MemorySizeCalculator.e(this.f18072b)) {
                this.f18075e = 0.0f;
            }
        }

        public MemorySizeCalculator a() {
            return new MemorySizeCalculator(this);
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public Builder b(ActivityManager activityManager) {
            this.f18072b = activityManager;
            return this;
        }

        public Builder c(int i2) {
            this.f18078h = i2;
            return this;
        }

        public Builder d(float f2) {
            Preconditions.a(f2 >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.f18075e = f2;
            return this;
        }

        public Builder e(float f2) {
            Preconditions.a(f2 >= 0.0f && f2 <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.f18077g = f2;
            return this;
        }

        public Builder f(float f2) {
            Preconditions.a(f2 >= 0.0f && f2 <= 1.0f, "Size multiplier must be between 0 and 1");
            this.f18076f = f2;
            return this;
        }

        public Builder g(float f2) {
            Preconditions.a(f2 >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.f18074d = f2;
            return this;
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public Builder h(ScreenDimensions screenDimensions) {
            this.f18073c = screenDimensions;
            return this;
        }
    }

    private static final class DisplayMetricsScreenDimensions implements ScreenDimensions {

        /* renamed from: a  reason: collision with root package name */
        private final DisplayMetrics f18079a;

        DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.f18079a = displayMetrics;
        }

        public int a() {
            return this.f18079a.heightPixels;
        }

        public int b() {
            return this.f18079a.widthPixels;
        }
    }

    interface ScreenDimensions {
        int a();

        int b();
    }

    MemorySizeCalculator(Builder builder) {
        this.f18064c = builder.f18071a;
        int i2 = e(builder.f18072b) ? builder.f18078h / 2 : builder.f18078h;
        this.f18065d = i2;
        int c2 = c(builder.f18072b, builder.f18076f, builder.f18077g);
        float b2 = (float) (builder.f18073c.b() * builder.f18073c.a() * 4);
        int round = Math.round(builder.f18075e * b2);
        int round2 = Math.round(b2 * builder.f18074d);
        int i3 = c2 - i2;
        int i4 = round2 + round;
        if (i4 <= i3) {
            this.f18063b = round2;
            this.f18062a = round;
        } else {
            float f2 = (float) i3;
            float f3 = builder.f18075e;
            float f4 = builder.f18074d;
            float f5 = f2 / (f3 + f4);
            this.f18063b = Math.round(f4 * f5);
            this.f18062a = Math.round(f5 * builder.f18075e);
        }
        if (Log.isLoggable(f18059e, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.f18063b));
            sb.append(", pool size: ");
            sb.append(f(this.f18062a));
            sb.append(", byte array size: ");
            sb.append(f(i2));
            sb.append(", memory class limited? ");
            sb.append(i4 > c2);
            sb.append(", max size: ");
            sb.append(f(c2));
            sb.append(", memoryClass: ");
            sb.append(builder.f18072b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(builder.f18072b));
            Log.d(f18059e, sb.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f2, float f3) {
        boolean e2 = e(activityManager);
        float memoryClass = (float) (activityManager.getMemoryClass() * 1048576);
        if (e2) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    @TargetApi(19)
    static boolean e(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }

    private String f(int i2) {
        return Formatter.formatFileSize(this.f18064c, (long) i2);
    }

    public int a() {
        return this.f18065d;
    }

    public int b() {
        return this.f18062a;
    }

    public int d() {
        return this.f18063b;
    }
}
