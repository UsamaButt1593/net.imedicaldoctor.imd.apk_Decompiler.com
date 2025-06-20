package com.bumptech.glide.request;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.CheckResult;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.stream.HttpGlideUrlLoader;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import com.bumptech.glide.load.resource.gif.GifOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.CachedHashCodeArrayMap;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;
import java.util.Map;

public abstract class BaseRequestOptions<T extends BaseRequestOptions<T>> implements Cloneable {
    private static final int A3 = 128;
    private static final int B3 = 256;
    private static final int C3 = 512;
    private static final int D3 = 1024;
    private static final int E3 = 2048;
    private static final int F3 = 4096;
    private static final int G3 = 8192;
    private static final int H3 = 16384;
    private static final int I3 = 32768;
    private static final int J3 = 65536;
    private static final int K3 = 131072;
    private static final int L3 = 262144;
    private static final int M3 = 524288;
    private static final int N3 = 1048576;
    private static final int t3 = -1;
    private static final int u3 = 2;
    private static final int v3 = 4;
    private static final int w3 = 8;
    private static final int x3 = 16;
    private static final int y3 = 32;
    private static final int z3 = 64;
    private float X = 1.0f;
    @Nullable
    private Drawable X2;
    @NonNull
    private DiskCacheStrategy Y = DiskCacheStrategy.f17911e;
    private int Y2;
    @NonNull
    private Priority Z = Priority.NORMAL;
    @Nullable
    private Drawable Z2;
    private int a3;
    private boolean b3 = true;
    private int c3 = -1;
    private int d3 = -1;
    @NonNull
    private Key e3 = EmptySignature.c();
    private boolean f3;
    private boolean g3 = true;
    @Nullable
    private Drawable h3;
    private int i3;
    @NonNull
    private Options j3 = new Options();
    @NonNull
    private Map<Class<?>, Transformation<?>> k3 = new CachedHashCodeArrayMap();
    @NonNull
    private Class<?> l3 = Object.class;
    private boolean m3;
    @Nullable
    private Resources.Theme n3;
    private boolean o3;
    private boolean p3;
    private boolean q3;
    private boolean r3 = true;
    private int s;
    private boolean s3;

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T R0(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            r0 = 0
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.j1(r2, r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.R0(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T h1(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            r0 = 1
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.j1(r2, r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.h1(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private T j1(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r1, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r2, boolean r3) {
        /*
            r0 = this;
            if (r3 == 0) goto L_0x0007
            com.bumptech.glide.request.BaseRequestOptions r1 = r0.D1(r1, r2)
            goto L_0x000b
        L_0x0007:
            com.bumptech.glide.request.BaseRequestOptions r1 = r0.W0(r1, r2)
        L_0x000b:
            r2 = 1
            r1.r3 = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.j1(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.Transformation, boolean):com.bumptech.glide.request.BaseRequestOptions");
    }

    private T k1() {
        return this;
    }

    @NonNull
    private T l1() {
        if (!this.m3) {
            return k1();
        }
        throw new IllegalStateException("You cannot modify locked T, consider clone()");
    }

    private boolean w0(int i2) {
        return y0(this.s, i2);
    }

    private static boolean y0(int i2, int i4) {
        return (i2 & i4) != 0;
    }

    @CheckResult
    @NonNull
    public T A(@Nullable Drawable drawable) {
        if (this.o3) {
            return clone().A(drawable);
        }
        this.X2 = drawable;
        this.Y2 = 0;
        this.s = (this.s | 16) & -33;
        return l1();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T A1(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r2) {
        /*
            r1 = this;
            r0 = 1
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.C1(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.A1(com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    @CheckResult
    @NonNull
    public T B(@DrawableRes int i2) {
        if (this.o3) {
            return clone().B(i2);
        }
        this.i3 = i2;
        this.h3 = null;
        this.s = (this.s | 16384) & -8193;
        return l1();
    }

    public final boolean C0() {
        return this.g3;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T C1(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3, boolean r4) {
        /*
            r2 = this;
            boolean r0 = r2.o3
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r2.clone()
            com.bumptech.glide.request.BaseRequestOptions r3 = r0.C1(r3, r4)
            return r3
        L_0x000d:
            com.bumptech.glide.load.resource.bitmap.DrawableTransformation r0 = new com.bumptech.glide.load.resource.bitmap.DrawableTransformation
            r0.<init>(r3, r4)
            java.lang.Class<android.graphics.Bitmap> r1 = android.graphics.Bitmap.class
            r2.H1(r1, r3, r4)
            java.lang.Class<android.graphics.drawable.Drawable> r1 = android.graphics.drawable.Drawable.class
            r2.H1(r1, r0, r4)
            java.lang.Class<android.graphics.drawable.BitmapDrawable> r1 = android.graphics.drawable.BitmapDrawable.class
            com.bumptech.glide.load.Transformation r0 = r0.c()
            r2.H1(r1, r0, r4)
            com.bumptech.glide.load.resource.gif.GifDrawableTransformation r0 = new com.bumptech.glide.load.resource.gif.GifDrawableTransformation
            r0.<init>(r3)
            java.lang.Class<com.bumptech.glide.load.resource.gif.GifDrawable> r3 = com.bumptech.glide.load.resource.gif.GifDrawable.class
            r2.H1(r3, r0, r4)
            com.bumptech.glide.request.BaseRequestOptions r3 = r2.l1()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.C1(com.bumptech.glide.load.Transformation, boolean):com.bumptech.glide.request.BaseRequestOptions");
    }

    @CheckResult
    @NonNull
    public T D(@Nullable Drawable drawable) {
        if (this.o3) {
            return clone().D(drawable);
        }
        this.h3 = drawable;
        this.i3 = 0;
        this.s = (this.s | 8192) & -16385;
        return l1();
    }

    public final boolean D0() {
        return this.f3;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T D1(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            boolean r0 = r1.o3
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.D1(r2, r3)
            return r2
        L_0x000d:
            r1.w(r2)
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.A1(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.D1(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    @CheckResult
    @NonNull
    public T E() {
        return h1(DownsampleStrategy.f18268c, new FitCenter());
    }

    public final boolean E0() {
        return w0(2048);
    }

    @CheckResult
    @NonNull
    public T F(@NonNull DecodeFormat decodeFormat) {
        Preconditions.d(decodeFormat);
        return r1(Downsampler.f18276g, decodeFormat).r1(GifOptions.f18396a, decodeFormat);
    }

    public final boolean F0() {
        return Util.v(this.d3, this.c3);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<Y>, java.lang.Class] */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation<Y>, com.bumptech.glide.load.Transformation] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T F1(@androidx.annotation.NonNull java.lang.Class<Y> r2, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<Y> r3) {
        /*
            r1 = this;
            r0 = 1
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.H1(r2, r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.F1(java.lang.Class, com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    @CheckResult
    @NonNull
    public T G(@IntRange(from = 0) long j2) {
        return r1(VideoDecoder.f18349g, Long.valueOf(j2));
    }

    @NonNull
    public T G0() {
        this.m3 = true;
        return k1();
    }

    @CheckResult
    @NonNull
    public T H0(boolean z) {
        if (this.o3) {
            return clone().H0(z);
        }
        this.q3 = z;
        this.s |= 524288;
        return l1();
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<Y>, java.lang.Object, java.lang.Class] */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation<Y>, com.bumptech.glide.load.Transformation, java.lang.Object] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 2 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T H1(@androidx.annotation.NonNull java.lang.Class<Y> r2, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<Y> r3, boolean r4) {
        /*
            r1 = this;
            boolean r0 = r1.o3
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.H1(r2, r3, r4)
            return r2
        L_0x000d:
            com.bumptech.glide.util.Preconditions.d(r2)
            com.bumptech.glide.util.Preconditions.d(r3)
            java.util.Map<java.lang.Class<?>, com.bumptech.glide.load.Transformation<?>> r0 = r1.k3
            r0.put(r2, r3)
            int r2 = r1.s
            r3 = 1
            r1.g3 = r3
            r0 = 67584(0x10800, float:9.4705E-41)
            r0 = r0 | r2
            r1.s = r0
            r0 = 0
            r1.r3 = r0
            if (r4 == 0) goto L_0x0030
            r4 = 198656(0x30800, float:2.78376E-40)
            r2 = r2 | r4
            r1.s = r2
            r1.f3 = r3
        L_0x0030:
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.l1()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.H1(java.lang.Class, com.bumptech.glide.load.Transformation, boolean):com.bumptech.glide.request.BaseRequestOptions");
    }

    @NonNull
    public final DiskCacheStrategy J() {
        return this.Y;
    }

    public final int K() {
        return this.Y2;
    }

    @CheckResult
    @NonNull
    public T K0() {
        return W0(DownsampleStrategy.f18270e, new CenterCrop());
    }

    @Nullable
    public final Drawable L() {
        return this.X2;
    }

    @CheckResult
    @NonNull
    public T L0() {
        return R0(DownsampleStrategy.f18269d, new CenterInside());
    }

    @Nullable
    public final Drawable M() {
        return this.h3;
    }

    @CheckResult
    @NonNull
    public T M0() {
        return W0(DownsampleStrategy.f18270e, new CircleCrop());
    }

    @CheckResult
    @NonNull
    public T O0() {
        return R0(DownsampleStrategy.f18268c, new FitCenter());
    }

    @CheckResult
    @NonNull
    public T O1(@NonNull Transformation<Bitmap>... transformationArr) {
        if (transformationArr.length > 1) {
            return C1(new MultiTransformation((Transformation<T>[]) transformationArr), true);
        }
        return transformationArr.length == 1 ? A1(transformationArr[0]) : l1();
    }

    public final int Q() {
        return this.i3;
    }

    @CheckResult
    @NonNull
    @Deprecated
    public T R1(@NonNull Transformation<Bitmap>... transformationArr) {
        return C1(new MultiTransformation((Transformation<T>[]) transformationArr), true);
    }

    public final boolean S() {
        return this.q3;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public T S0(@androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r2) {
        /*
            r1 = this;
            r0 = 0
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.C1(r2, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.S0(com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    @CheckResult
    @NonNull
    public T S1(boolean z) {
        if (this.o3) {
            return clone().S1(z);
        }
        this.s3 = z;
        this.s |= 1048576;
        return l1();
    }

    @CheckResult
    @NonNull
    public T T1(boolean z) {
        if (this.o3) {
            return clone().T1(z);
        }
        this.p3 = z;
        this.s |= 262144;
        return l1();
    }

    @NonNull
    public final Options U() {
        return this.j3;
    }

    public final int V() {
        return this.c3;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation, com.bumptech.glide.load.Transformation<android.graphics.Bitmap>] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T W0(@androidx.annotation.NonNull com.bumptech.glide.load.resource.bitmap.DownsampleStrategy r2, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<android.graphics.Bitmap> r3) {
        /*
            r1 = this;
            boolean r0 = r1.o3
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.W0(r2, r3)
            return r2
        L_0x000d:
            r1.w(r2)
            r2 = 0
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.C1(r3, r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.W0(com.bumptech.glide.load.resource.bitmap.DownsampleStrategy, com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    public final int X() {
        return this.d3;
    }

    @Nullable
    public final Drawable Y() {
        return this.Z2;
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Class<Y>, java.lang.Class] */
    /* JADX WARNING: type inference failed for: r3v0, types: [com.bumptech.glide.load.Transformation<Y>, com.bumptech.glide.load.Transformation] */
    /* JADX WARNING: Unknown variable types count: 2 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T Y0(@androidx.annotation.NonNull java.lang.Class<Y> r2, @androidx.annotation.NonNull com.bumptech.glide.load.Transformation<Y> r3) {
        /*
            r1 = this;
            r0 = 0
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.H1(r2, r3, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.Y0(java.lang.Class, com.bumptech.glide.load.Transformation):com.bumptech.glide.request.BaseRequestOptions");
    }

    @CheckResult
    @NonNull
    public T a(@NonNull BaseRequestOptions<?> baseRequestOptions) {
        if (this.o3) {
            return clone().a(baseRequestOptions);
        }
        if (y0(baseRequestOptions.s, 2)) {
            this.X = baseRequestOptions.X;
        }
        if (y0(baseRequestOptions.s, 262144)) {
            this.p3 = baseRequestOptions.p3;
        }
        if (y0(baseRequestOptions.s, 1048576)) {
            this.s3 = baseRequestOptions.s3;
        }
        if (y0(baseRequestOptions.s, 4)) {
            this.Y = baseRequestOptions.Y;
        }
        if (y0(baseRequestOptions.s, 8)) {
            this.Z = baseRequestOptions.Z;
        }
        if (y0(baseRequestOptions.s, 16)) {
            this.X2 = baseRequestOptions.X2;
            this.Y2 = 0;
            this.s &= -33;
        }
        if (y0(baseRequestOptions.s, 32)) {
            this.Y2 = baseRequestOptions.Y2;
            this.X2 = null;
            this.s &= -17;
        }
        if (y0(baseRequestOptions.s, 64)) {
            this.Z2 = baseRequestOptions.Z2;
            this.a3 = 0;
            this.s &= -129;
        }
        if (y0(baseRequestOptions.s, 128)) {
            this.a3 = baseRequestOptions.a3;
            this.Z2 = null;
            this.s &= -65;
        }
        if (y0(baseRequestOptions.s, 256)) {
            this.b3 = baseRequestOptions.b3;
        }
        if (y0(baseRequestOptions.s, 512)) {
            this.d3 = baseRequestOptions.d3;
            this.c3 = baseRequestOptions.c3;
        }
        if (y0(baseRequestOptions.s, 1024)) {
            this.e3 = baseRequestOptions.e3;
        }
        if (y0(baseRequestOptions.s, 4096)) {
            this.l3 = baseRequestOptions.l3;
        }
        if (y0(baseRequestOptions.s, 8192)) {
            this.h3 = baseRequestOptions.h3;
            this.i3 = 0;
            this.s &= -16385;
        }
        if (y0(baseRequestOptions.s, 16384)) {
            this.i3 = baseRequestOptions.i3;
            this.h3 = null;
            this.s &= -8193;
        }
        if (y0(baseRequestOptions.s, 32768)) {
            this.n3 = baseRequestOptions.n3;
        }
        if (y0(baseRequestOptions.s, 65536)) {
            this.g3 = baseRequestOptions.g3;
        }
        if (y0(baseRequestOptions.s, 131072)) {
            this.f3 = baseRequestOptions.f3;
        }
        if (y0(baseRequestOptions.s, 2048)) {
            this.k3.putAll(baseRequestOptions.k3);
            this.r3 = baseRequestOptions.r3;
        }
        if (y0(baseRequestOptions.s, 524288)) {
            this.q3 = baseRequestOptions.q3;
        }
        if (!this.g3) {
            this.k3.clear();
            int i2 = this.s;
            this.f3 = false;
            this.s = i2 & -133121;
            this.r3 = true;
        }
        this.s |= baseRequestOptions.s;
        this.j3.d(baseRequestOptions.j3);
        return l1();
    }

    @NonNull
    public T b() {
        if (!this.m3 || this.o3) {
            this.o3 = true;
            return G0();
        }
        throw new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
    }

    public final int b0() {
        return this.a3;
    }

    @CheckResult
    @NonNull
    public T b1(int i2) {
        return c1(i2, i2);
    }

    @CheckResult
    @NonNull
    public T c() {
        return D1(DownsampleStrategy.f18270e, new CenterCrop());
    }

    @NonNull
    public final Priority c0() {
        return this.Z;
    }

    @CheckResult
    @NonNull
    public T c1(int i2, int i4) {
        if (this.o3) {
            return clone().c1(i2, i4);
        }
        this.d3 = i2;
        this.c3 = i4;
        this.s |= 512;
        return l1();
    }

    @CheckResult
    @NonNull
    public T d() {
        return h1(DownsampleStrategy.f18269d, new CenterInside());
    }

    @CheckResult
    @NonNull
    public T d1(@DrawableRes int i2) {
        if (this.o3) {
            return clone().d1(i2);
        }
        this.a3 = i2;
        this.Z2 = null;
        this.s = (this.s | 128) & -65;
        return l1();
    }

    @CheckResult
    @NonNull
    public T e() {
        return D1(DownsampleStrategy.f18269d, new CircleCrop());
    }

    @CheckResult
    @NonNull
    public T e1(@Nullable Drawable drawable) {
        if (this.o3) {
            return clone().e1(drawable);
        }
        this.Z2 = drawable;
        this.a3 = 0;
        this.s = (this.s | 64) & -129;
        return l1();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BaseRequestOptions)) {
            return false;
        }
        BaseRequestOptions baseRequestOptions = (BaseRequestOptions) obj;
        return Float.compare(baseRequestOptions.X, this.X) == 0 && this.Y2 == baseRequestOptions.Y2 && Util.d(this.X2, baseRequestOptions.X2) && this.a3 == baseRequestOptions.a3 && Util.d(this.Z2, baseRequestOptions.Z2) && this.i3 == baseRequestOptions.i3 && Util.d(this.h3, baseRequestOptions.h3) && this.b3 == baseRequestOptions.b3 && this.c3 == baseRequestOptions.c3 && this.d3 == baseRequestOptions.d3 && this.f3 == baseRequestOptions.f3 && this.g3 == baseRequestOptions.g3 && this.p3 == baseRequestOptions.p3 && this.q3 == baseRequestOptions.q3 && this.Y.equals(baseRequestOptions.Y) && this.Z == baseRequestOptions.Z && this.j3.equals(baseRequestOptions.j3) && this.k3.equals(baseRequestOptions.k3) && this.l3.equals(baseRequestOptions.l3) && Util.d(this.e3, baseRequestOptions.e3) && Util.d(this.n3, baseRequestOptions.n3);
    }

    @NonNull
    public final Class<?> f0() {
        return this.l3;
    }

    @NonNull
    public final Key g0() {
        return this.e3;
    }

    @CheckResult
    @NonNull
    public T g1(@NonNull Priority priority) {
        if (this.o3) {
            return clone().g1(priority);
        }
        this.Z = (Priority) Preconditions.d(priority);
        this.s |= 8;
        return l1();
    }

    public final float h0() {
        return this.X;
    }

    public int hashCode() {
        return Util.p(this.n3, Util.p(this.e3, Util.p(this.l3, Util.p(this.k3, Util.p(this.j3, Util.p(this.Z, Util.p(this.Y, Util.r(this.q3, Util.r(this.p3, Util.r(this.g3, Util.r(this.f3, Util.o(this.d3, Util.o(this.c3, Util.r(this.b3, Util.p(this.h3, Util.o(this.i3, Util.p(this.Z2, Util.o(this.a3, Util.p(this.X2, Util.o(this.Y2, Util.l(this.X)))))))))))))))))))));
    }

    @Nullable
    public final Resources.Theme k0() {
        return this.n3;
    }

    @NonNull
    public final Map<Class<?>, Transformation<?>> l0() {
        return this.k3;
    }

    public final boolean n0() {
        return this.s3;
    }

    public final boolean o0() {
        return this.p3;
    }

    @CheckResult
    /* renamed from: p */
    public T clone() {
        try {
            T t = (BaseRequestOptions) super.clone();
            Options options = new Options();
            t.j3 = options;
            options.d(this.j3);
            CachedHashCodeArrayMap cachedHashCodeArrayMap = new CachedHashCodeArrayMap();
            t.k3 = cachedHashCodeArrayMap;
            cachedHashCodeArrayMap.putAll(this.k3);
            t.m3 = false;
            t.o3 = false;
            return t;
        } catch (CloneNotSupportedException e2) {
            throw new RuntimeException(e2);
        }
    }

    @CheckResult
    @NonNull
    public T q(@NonNull Class<?> cls) {
        if (this.o3) {
            return clone().q(cls);
        }
        this.l3 = (Class) Preconditions.d(cls);
        this.s |= 4096;
        return l1();
    }

    /* access modifiers changed from: protected */
    public boolean q0() {
        return this.o3;
    }

    @CheckResult
    @NonNull
    public T r() {
        return r1(Downsampler.f18280k, Boolean.FALSE);
    }

    public final boolean r0() {
        return w0(4);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.bumptech.glide.load.Option, java.lang.Object, com.bumptech.glide.load.Option<Y>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.CheckResult
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <Y> T r1(@androidx.annotation.NonNull com.bumptech.glide.load.Option<Y> r2, @androidx.annotation.NonNull Y r3) {
        /*
            r1 = this;
            boolean r0 = r1.o3
            if (r0 == 0) goto L_0x000d
            com.bumptech.glide.request.BaseRequestOptions r0 = r1.clone()
            com.bumptech.glide.request.BaseRequestOptions r2 = r0.r1(r2, r3)
            return r2
        L_0x000d:
            com.bumptech.glide.util.Preconditions.d(r2)
            com.bumptech.glide.util.Preconditions.d(r3)
            com.bumptech.glide.load.Options r0 = r1.j3
            r0.e(r2, r3)
            com.bumptech.glide.request.BaseRequestOptions r2 = r1.l1()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.BaseRequestOptions.r1(com.bumptech.glide.load.Option, java.lang.Object):com.bumptech.glide.request.BaseRequestOptions");
    }

    @CheckResult
    @NonNull
    public T s(@NonNull DiskCacheStrategy diskCacheStrategy) {
        if (this.o3) {
            return clone().s(diskCacheStrategy);
        }
        this.Y = (DiskCacheStrategy) Preconditions.d(diskCacheStrategy);
        this.s |= 4;
        return l1();
    }

    public final boolean s0() {
        return this.m3;
    }

    public final boolean t0() {
        return this.b3;
    }

    @CheckResult
    @NonNull
    public T t1(@NonNull Key key) {
        if (this.o3) {
            return clone().t1(key);
        }
        this.e3 = (Key) Preconditions.d(key);
        this.s |= 1024;
        return l1();
    }

    @CheckResult
    @NonNull
    public T u() {
        return r1(GifOptions.f18397b, Boolean.TRUE);
    }

    public final boolean u0() {
        return w0(8);
    }

    @CheckResult
    @NonNull
    public T u1(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.o3) {
            return clone().u1(f2);
        }
        if (f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        }
        this.X = f2;
        this.s |= 2;
        return l1();
    }

    @CheckResult
    @NonNull
    public T v() {
        if (this.o3) {
            return clone().v();
        }
        this.k3.clear();
        int i2 = this.s;
        this.f3 = false;
        this.g3 = false;
        this.s = (i2 & -133121) | 65536;
        this.r3 = true;
        return l1();
    }

    /* access modifiers changed from: package-private */
    public boolean v0() {
        return this.r3;
    }

    @CheckResult
    @NonNull
    public T w(@NonNull DownsampleStrategy downsampleStrategy) {
        return r1(DownsampleStrategy.f18273h, Preconditions.d(downsampleStrategy));
    }

    @CheckResult
    @NonNull
    public T w1(boolean z) {
        if (this.o3) {
            return clone().w1(true);
        }
        this.b3 = !z;
        this.s |= 256;
        return l1();
    }

    @CheckResult
    @NonNull
    public T x(@NonNull Bitmap.CompressFormat compressFormat) {
        return r1(BitmapEncoder.f18236c, Preconditions.d(compressFormat));
    }

    @CheckResult
    @NonNull
    public T y(@IntRange(from = 0, to = 100) int i2) {
        return r1(BitmapEncoder.f18235b, Integer.valueOf(i2));
    }

    @CheckResult
    @NonNull
    public T y1(@Nullable Resources.Theme theme) {
        if (this.o3) {
            return clone().y1(theme);
        }
        this.n3 = theme;
        this.s |= 32768;
        return l1();
    }

    @CheckResult
    @NonNull
    public T z(@DrawableRes int i2) {
        if (this.o3) {
            return clone().z(i2);
        }
        this.Y2 = i2;
        this.X2 = null;
        this.s = (this.s | 32) & -17;
        return l1();
    }

    public final boolean z0() {
        return w0(256);
    }

    @CheckResult
    @NonNull
    public T z1(@IntRange(from = 0) int i2) {
        return r1(HttpGlideUrlLoader.f18203b, Integer.valueOf(i2));
    }
}
