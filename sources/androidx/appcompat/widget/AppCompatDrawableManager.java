package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import androidx.annotation.ColorInt;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class AppCompatDrawableManager {

    /* renamed from: b  reason: collision with root package name */
    private static final String f3074b = "AppCompatDrawableManag";

    /* renamed from: c  reason: collision with root package name */
    private static final boolean f3075c = false;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final PorterDuff.Mode f3076d = PorterDuff.Mode.SRC_IN;

    /* renamed from: e  reason: collision with root package name */
    private static AppCompatDrawableManager f3077e;

    /* renamed from: a  reason: collision with root package name */
    private ResourceManagerInternal f3078a;

    public static synchronized AppCompatDrawableManager b() {
        AppCompatDrawableManager appCompatDrawableManager;
        synchronized (AppCompatDrawableManager.class) {
            try {
                if (f3077e == null) {
                    i();
                }
                appCompatDrawableManager = f3077e;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return appCompatDrawableManager;
    }

    public static synchronized PorterDuffColorFilter e(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter l2;
        synchronized (AppCompatDrawableManager.class) {
            l2 = ResourceManagerInternal.l(i2, mode);
        }
        return l2;
    }

    public static synchronized void i() {
        synchronized (AppCompatDrawableManager.class) {
            if (f3077e == null) {
                AppCompatDrawableManager appCompatDrawableManager = new AppCompatDrawableManager();
                f3077e = appCompatDrawableManager;
                appCompatDrawableManager.f3078a = ResourceManagerInternal.h();
                f3077e.f3078a.u(new ResourceManagerInternal.ResourceManagerHooks() {

                    /* renamed from: a  reason: collision with root package name */
                    private final int[] f3079a = {R.drawable.y0, R.drawable.w0, R.drawable.f2595a};

                    /* renamed from: b  reason: collision with root package name */
                    private final int[] f3080b = {R.drawable.y, R.drawable.h0, R.drawable.F, R.drawable.A, R.drawable.B, R.drawable.E, R.drawable.D};

                    /* renamed from: c  reason: collision with root package name */
                    private final int[] f3081c = {R.drawable.v0, R.drawable.x0, R.drawable.r, R.drawable.r0, R.drawable.s0, R.drawable.t0, R.drawable.u0};

                    /* renamed from: d  reason: collision with root package name */
                    private final int[] f3082d = {R.drawable.X, R.drawable.p, R.drawable.W};

                    /* renamed from: e  reason: collision with root package name */
                    private final int[] f3083e = {R.drawable.p0, R.drawable.z0};

                    /* renamed from: f  reason: collision with root package name */
                    private final int[] f3084f = {R.drawable.f2598d, R.drawable.f2604j, R.drawable.f2599e, R.drawable.f2605k};

                    private boolean f(int[] iArr, int i2) {
                        for (int i3 : iArr) {
                            if (i3 == i2) {
                                return true;
                            }
                        }
                        return false;
                    }

                    private ColorStateList g(@NonNull Context context) {
                        return h(context, 0);
                    }

                    private ColorStateList h(@NonNull Context context, @ColorInt int i2) {
                        int d2 = ThemeUtils.d(context, R.attr.G0);
                        int c2 = ThemeUtils.c(context, R.attr.E0);
                        return new ColorStateList(new int[][]{ThemeUtils.f3296c, ThemeUtils.f3299f, ThemeUtils.f3297d, ThemeUtils.f3303j}, new int[]{c2, ColorUtils.v(d2, i2), ColorUtils.v(d2, i2), i2});
                    }

                    private ColorStateList i(@NonNull Context context) {
                        return h(context, ThemeUtils.d(context, R.attr.C0));
                    }

                    private ColorStateList j(@NonNull Context context) {
                        return h(context, ThemeUtils.d(context, R.attr.E0));
                    }

                    private ColorStateList k(Context context) {
                        int[][] iArr = new int[3][];
                        int[] iArr2 = new int[3];
                        int i2 = R.attr.L0;
                        ColorStateList f2 = ThemeUtils.f(context, i2);
                        if (f2 == null || !f2.isStateful()) {
                            iArr[0] = ThemeUtils.f3296c;
                            iArr2[0] = ThemeUtils.c(context, i2);
                            iArr[1] = ThemeUtils.f3300g;
                            iArr2[1] = ThemeUtils.d(context, R.attr.F0);
                            iArr[2] = ThemeUtils.f3303j;
                            iArr2[2] = ThemeUtils.d(context, i2);
                        } else {
                            int[] iArr3 = ThemeUtils.f3296c;
                            iArr[0] = iArr3;
                            iArr2[0] = f2.getColorForState(iArr3, 0);
                            iArr[1] = ThemeUtils.f3300g;
                            iArr2[1] = ThemeUtils.d(context, R.attr.F0);
                            iArr[2] = ThemeUtils.f3303j;
                            iArr2[2] = f2.getDefaultColor();
                        }
                        return new ColorStateList(iArr, iArr2);
                    }

                    private LayerDrawable l(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, @DimenRes int i2) {
                        BitmapDrawable bitmapDrawable;
                        BitmapDrawable bitmapDrawable2;
                        BitmapDrawable bitmapDrawable3;
                        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i2);
                        Drawable j2 = resourceManagerInternal.j(context, R.drawable.l0);
                        Drawable j3 = resourceManagerInternal.j(context, R.drawable.m0);
                        if ((j2 instanceof BitmapDrawable) && j2.getIntrinsicWidth() == dimensionPixelSize && j2.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable2 = (BitmapDrawable) j2;
                            bitmapDrawable = new BitmapDrawable(bitmapDrawable2.getBitmap());
                        } else {
                            Bitmap createBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas = new Canvas(createBitmap);
                            j2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            j2.draw(canvas);
                            bitmapDrawable2 = new BitmapDrawable(createBitmap);
                            bitmapDrawable = new BitmapDrawable(createBitmap);
                        }
                        bitmapDrawable.setTileModeX(Shader.TileMode.REPEAT);
                        if ((j3 instanceof BitmapDrawable) && j3.getIntrinsicWidth() == dimensionPixelSize && j3.getIntrinsicHeight() == dimensionPixelSize) {
                            bitmapDrawable3 = (BitmapDrawable) j3;
                        } else {
                            Bitmap createBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
                            Canvas canvas2 = new Canvas(createBitmap2);
                            j3.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
                            j3.draw(canvas2);
                            bitmapDrawable3 = new BitmapDrawable(createBitmap2);
                        }
                        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable2, bitmapDrawable3, bitmapDrawable});
                        layerDrawable.setId(0, 16908288);
                        layerDrawable.setId(1, 16908303);
                        layerDrawable.setId(2, 16908301);
                        return layerDrawable;
                    }

                    private void m(Drawable drawable, int i2, PorterDuff.Mode mode) {
                        Drawable mutate = drawable.mutate();
                        if (mode == null) {
                            mode = AppCompatDrawableManager.f3076d;
                        }
                        mutate.setColorFilter(AppCompatDrawableManager.e(i2, mode));
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:19:0x0052  */
                    /* JADX WARNING: Removed duplicated region for block: B:23:0x0067 A[RETURN] */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean a(@androidx.annotation.NonNull android.content.Context r7, int r8, @androidx.annotation.NonNull android.graphics.drawable.Drawable r9) {
                        /*
                            r6 = this;
                            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.AppCompatDrawableManager.f3076d
                            int[] r1 = r6.f3079a
                            boolean r1 = r6.f(r1, r8)
                            r2 = 1
                            r3 = 0
                            r4 = -1
                            if (r1 == 0) goto L_0x0015
                            int r8 = androidx.appcompat.R.attr.H0
                        L_0x0011:
                            r1 = r0
                        L_0x0012:
                            r0 = -1
                            r5 = 1
                            goto L_0x0050
                        L_0x0015:
                            int[] r1 = r6.f3081c
                            boolean r1 = r6.f(r1, r8)
                            if (r1 == 0) goto L_0x0020
                            int r8 = androidx.appcompat.R.attr.F0
                            goto L_0x0011
                        L_0x0020:
                            int[] r1 = r6.f3082d
                            boolean r1 = r6.f(r1, r8)
                            r5 = 16842801(0x1010031, float:2.3693695E-38)
                            if (r1 == 0) goto L_0x0032
                            android.graphics.PorterDuff$Mode r0 = android.graphics.PorterDuff.Mode.MULTIPLY
                        L_0x002d:
                            r1 = r0
                            r8 = 16842801(0x1010031, float:2.3693695E-38)
                            goto L_0x0012
                        L_0x0032:
                            int r1 = androidx.appcompat.R.drawable.L
                            if (r8 != r1) goto L_0x0047
                            r8 = 1109603123(0x42233333, float:40.8)
                            int r8 = java.lang.Math.round(r8)
                            r1 = 16842800(0x1010030, float:2.3693693E-38)
                            r1 = r0
                            r5 = 1
                            r0 = r8
                            r8 = 16842800(0x1010030, float:2.3693693E-38)
                            goto L_0x0050
                        L_0x0047:
                            int r1 = androidx.appcompat.R.drawable.t
                            if (r8 != r1) goto L_0x004c
                            goto L_0x002d
                        L_0x004c:
                            r1 = r0
                            r8 = 0
                            r0 = -1
                            r5 = 0
                        L_0x0050:
                            if (r5 == 0) goto L_0x0067
                            android.graphics.drawable.Drawable r9 = r9.mutate()
                            int r7 = androidx.appcompat.widget.ThemeUtils.d(r7, r8)
                            android.graphics.PorterDuffColorFilter r7 = androidx.appcompat.widget.AppCompatDrawableManager.e(r7, r1)
                            r9.setColorFilter(r7)
                            if (r0 == r4) goto L_0x0066
                            r9.setAlpha(r0)
                        L_0x0066:
                            return r2
                        L_0x0067:
                            return r3
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatDrawableManager.AnonymousClass1.a(android.content.Context, int, android.graphics.drawable.Drawable):boolean");
                    }

                    public PorterDuff.Mode b(int i2) {
                        if (i2 == R.drawable.n0) {
                            return PorterDuff.Mode.MULTIPLY;
                        }
                        return null;
                    }

                    public Drawable c(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, int i2) {
                        int i3;
                        if (i2 == R.drawable.q) {
                            return new LayerDrawable(new Drawable[]{resourceManagerInternal.j(context, R.drawable.p), resourceManagerInternal.j(context, R.drawable.r)});
                        }
                        if (i2 == R.drawable.Z) {
                            i3 = R.dimen.h0;
                        } else if (i2 == R.drawable.Y) {
                            i3 = R.dimen.i0;
                        } else if (i2 != R.drawable.a0) {
                            return null;
                        } else {
                            i3 = R.dimen.j0;
                        }
                        return l(resourceManagerInternal, context, i3);
                    }

                    public ColorStateList d(@NonNull Context context, int i2) {
                        if (i2 == R.drawable.u) {
                            return AppCompatResources.a(context, R.color.v);
                        }
                        if (i2 == R.drawable.o0) {
                            return AppCompatResources.a(context, R.color.y);
                        }
                        if (i2 == R.drawable.n0) {
                            return k(context);
                        }
                        if (i2 == R.drawable.f2603i) {
                            return j(context);
                        }
                        if (i2 == R.drawable.f2597c) {
                            return g(context);
                        }
                        if (i2 == R.drawable.f2602h) {
                            return i(context);
                        }
                        if (i2 == R.drawable.j0 || i2 == R.drawable.k0) {
                            return AppCompatResources.a(context, R.color.x);
                        }
                        if (f(this.f3080b, i2)) {
                            return ThemeUtils.f(context, R.attr.H0);
                        }
                        if (f(this.f3083e, i2)) {
                            return AppCompatResources.a(context, R.color.u);
                        }
                        if (f(this.f3084f, i2)) {
                            return AppCompatResources.a(context, R.color.t);
                        }
                        if (i2 == R.drawable.g0) {
                            return AppCompatResources.a(context, R.color.w);
                        }
                        return null;
                    }

                    public boolean e(@NonNull Context context, int i2, @NonNull Drawable drawable) {
                        Drawable findDrawableByLayerId;
                        int d2;
                        if (i2 == R.drawable.i0) {
                            LayerDrawable layerDrawable = (LayerDrawable) drawable;
                            Drawable findDrawableByLayerId2 = layerDrawable.findDrawableByLayerId(16908288);
                            int i3 = R.attr.H0;
                            m(findDrawableByLayerId2, ThemeUtils.d(context, i3), AppCompatDrawableManager.f3076d);
                            m(layerDrawable.findDrawableByLayerId(16908303), ThemeUtils.d(context, i3), AppCompatDrawableManager.f3076d);
                            findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908301);
                            d2 = ThemeUtils.d(context, R.attr.F0);
                        } else if (i2 != R.drawable.Z && i2 != R.drawable.Y && i2 != R.drawable.a0) {
                            return false;
                        } else {
                            LayerDrawable layerDrawable2 = (LayerDrawable) drawable;
                            m(layerDrawable2.findDrawableByLayerId(16908288), ThemeUtils.c(context, R.attr.H0), AppCompatDrawableManager.f3076d);
                            Drawable findDrawableByLayerId3 = layerDrawable2.findDrawableByLayerId(16908303);
                            int i4 = R.attr.F0;
                            m(findDrawableByLayerId3, ThemeUtils.d(context, i4), AppCompatDrawableManager.f3076d);
                            findDrawableByLayerId = layerDrawable2.findDrawableByLayerId(16908301);
                            d2 = ThemeUtils.d(context, i4);
                        }
                        m(findDrawableByLayerId, d2, AppCompatDrawableManager.f3076d);
                        return true;
                    }
                });
            }
        }
    }

    static void j(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        ResourceManagerInternal.w(drawable, tintInfo, iArr);
    }

    public synchronized Drawable c(@NonNull Context context, @DrawableRes int i2) {
        return this.f3078a.j(context, i2);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable d(@NonNull Context context, @DrawableRes int i2, boolean z) {
        return this.f3078a.k(context, i2, z);
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList f(@NonNull Context context, @DrawableRes int i2) {
        return this.f3078a.m(context, i2);
    }

    public synchronized void g(@NonNull Context context) {
        this.f3078a.s(context);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable h(@NonNull Context context, @NonNull VectorEnabledTintResources vectorEnabledTintResources, @DrawableRes int i2) {
        return this.f3078a.t(context, vectorEnabledTintResources, i2);
    }

    /* access modifiers changed from: package-private */
    public boolean k(@NonNull Context context, @DrawableRes int i2, @NonNull Drawable drawable) {
        return this.f3078a.x(context, i2, drawable);
    }
}
