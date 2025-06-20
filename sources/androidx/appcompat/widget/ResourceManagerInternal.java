package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat;
import androidx.appcompat.resources.Compatibility;
import androidx.appcompat.resources.R;
import androidx.collection.LongSparseArray;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ResourceManagerInternal {

    /* renamed from: h  reason: collision with root package name */
    private static final String f3224h = "ResourceManagerInternal";

    /* renamed from: i  reason: collision with root package name */
    private static final boolean f3225i = false;

    /* renamed from: j  reason: collision with root package name */
    private static final PorterDuff.Mode f3226j = PorterDuff.Mode.SRC_IN;

    /* renamed from: k  reason: collision with root package name */
    private static final String f3227k = "appcompat_skip_skip";

    /* renamed from: l  reason: collision with root package name */
    private static final String f3228l = "android.graphics.drawable.VectorDrawable";

    /* renamed from: m  reason: collision with root package name */
    private static ResourceManagerInternal f3229m;

    /* renamed from: n  reason: collision with root package name */
    private static final ColorFilterLruCache f3230n = new ColorFilterLruCache(6);

    /* renamed from: a  reason: collision with root package name */
    private WeakHashMap<Context, SparseArrayCompat<ColorStateList>> f3231a;

    /* renamed from: b  reason: collision with root package name */
    private SimpleArrayMap<String, InflateDelegate> f3232b;

    /* renamed from: c  reason: collision with root package name */
    private SparseArrayCompat<String> f3233c;

    /* renamed from: d  reason: collision with root package name */
    private final WeakHashMap<Context, LongSparseArray<WeakReference<Drawable.ConstantState>>> f3234d = new WeakHashMap<>(0);

    /* renamed from: e  reason: collision with root package name */
    private TypedValue f3235e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3236f;

    /* renamed from: g  reason: collision with root package name */
    private ResourceManagerHooks f3237g;

    static class AsldcInflateDelegate implements InflateDelegate {
        AsldcInflateDelegate() {
        }

        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return AnimatedStateListDrawableCompat.C(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e2);
                return null;
            }
        }
    }

    private static class AvdcInflateDelegate implements InflateDelegate {
        AvdcInflateDelegate() {
        }

        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return AnimatedVectorDrawableCompat.f(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e2);
                return null;
            }
        }
    }

    private static class ColorFilterLruCache extends LruCache<Integer, PorterDuffColorFilter> {
        public ColorFilterLruCache(int i2) {
            super(i2);
        }

        private static int b(int i2, PorterDuff.Mode mode) {
            return ((i2 + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter c(int i2, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(b(i2, mode)));
        }

        /* access modifiers changed from: package-private */
        public PorterDuffColorFilter d(int i2, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(b(i2, mode)), porterDuffColorFilter);
        }
    }

    static class DrawableDelegate implements InflateDelegate {
        DrawableDelegate() {
        }

        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            String classAttribute = attributeSet.getClassAttribute();
            if (classAttribute != null) {
                try {
                    Drawable drawable = (Drawable) DrawableDelegate.class.getClassLoader().loadClass(classAttribute).asSubclass(Drawable.class).getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
                    Compatibility.Api21Impl.c(drawable, context.getResources(), xmlPullParser, attributeSet, theme);
                    return drawable;
                } catch (Exception e2) {
                    Log.e("DrawableDelegate", "Exception while inflating <drawable>", e2);
                }
            }
            return null;
        }
    }

    private interface InflateDelegate {
        Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public interface ResourceManagerHooks {
        boolean a(@NonNull Context context, @DrawableRes int i2, @NonNull Drawable drawable);

        @Nullable
        PorterDuff.Mode b(int i2);

        @Nullable
        Drawable c(@NonNull ResourceManagerInternal resourceManagerInternal, @NonNull Context context, @DrawableRes int i2);

        @Nullable
        ColorStateList d(@NonNull Context context, @DrawableRes int i2);

        boolean e(@NonNull Context context, @DrawableRes int i2, @NonNull Drawable drawable);
    }

    private static class VdcInflateDelegate implements InflateDelegate {
        VdcInflateDelegate() {
        }

        public Drawable a(@NonNull Context context, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) {
            try {
                return VectorDrawableCompat.f(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e2) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e2);
                return null;
            }
        }
    }

    private void a(@NonNull String str, @NonNull InflateDelegate inflateDelegate) {
        if (this.f3232b == null) {
            this.f3232b = new SimpleArrayMap<>();
        }
        this.f3232b.put(str, inflateDelegate);
    }

    private synchronized boolean b(@NonNull Context context, long j2, @NonNull Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            LongSparseArray longSparseArray = this.f3234d.get(context);
            if (longSparseArray == null) {
                longSparseArray = new LongSparseArray();
                this.f3234d.put(context, longSparseArray);
            }
            longSparseArray.p(j2, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    private void c(@NonNull Context context, @DrawableRes int i2, @NonNull ColorStateList colorStateList) {
        if (this.f3231a == null) {
            this.f3231a = new WeakHashMap<>();
        }
        SparseArrayCompat sparseArrayCompat = this.f3231a.get(context);
        if (sparseArrayCompat == null) {
            sparseArrayCompat = new SparseArrayCompat();
            this.f3231a.put(context, sparseArrayCompat);
        }
        sparseArrayCompat.a(i2, colorStateList);
    }

    private void d(@NonNull Context context) {
        if (!this.f3236f) {
            this.f3236f = true;
            Drawable j2 = j(context, R.drawable.f2889a);
            if (j2 == null || !q(j2)) {
                this.f3236f = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    private static long e(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable f(@NonNull Context context, @DrawableRes int i2) {
        if (this.f3235e == null) {
            this.f3235e = new TypedValue();
        }
        TypedValue typedValue = this.f3235e;
        context.getResources().getValue(i2, typedValue, true);
        long e2 = e(typedValue);
        Drawable i3 = i(context, e2);
        if (i3 != null) {
            return i3;
        }
        ResourceManagerHooks resourceManagerHooks = this.f3237g;
        Drawable c2 = resourceManagerHooks == null ? null : resourceManagerHooks.c(this, context, i2);
        if (c2 != null) {
            c2.setChangingConfigurations(typedValue.changingConfigurations);
            b(context, e2, c2);
        }
        return c2;
    }

    private static PorterDuffColorFilter g(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return l(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized ResourceManagerInternal h() {
        ResourceManagerInternal resourceManagerInternal;
        synchronized (ResourceManagerInternal.class) {
            try {
                if (f3229m == null) {
                    ResourceManagerInternal resourceManagerInternal2 = new ResourceManagerInternal();
                    f3229m = resourceManagerInternal2;
                    p(resourceManagerInternal2);
                }
                resourceManagerInternal = f3229m;
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return resourceManagerInternal;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.graphics.drawable.Drawable i(@androidx.annotation.NonNull android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, androidx.collection.LongSparseArray<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.f3234d     // Catch:{ all -> 0x0028 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0028 }
            androidx.collection.LongSparseArray r0 = (androidx.collection.LongSparseArray) r0     // Catch:{ all -> 0x0028 }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.h(r5)     // Catch:{ all -> 0x0028 }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x002d
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x0028 }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x0028 }
            if (r2 == 0) goto L_0x002a
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x0028 }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x0028 }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r4 = move-exception
            goto L_0x002f
        L_0x002a:
            r0.s(r5)     // Catch:{ all -> 0x0028 }
        L_0x002d:
            monitor-exit(r3)
            return r1
        L_0x002f:
            monitor-exit(r3)     // Catch:{ all -> 0x0028 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.i(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    public static synchronized PorterDuffColorFilter l(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter c2;
        synchronized (ResourceManagerInternal.class) {
            ColorFilterLruCache colorFilterLruCache = f3230n;
            c2 = colorFilterLruCache.c(i2, mode);
            if (c2 == null) {
                c2 = new PorterDuffColorFilter(i2, mode);
                colorFilterLruCache.d(i2, mode, c2);
            }
        }
        return c2;
    }

    private ColorStateList n(@NonNull Context context, @DrawableRes int i2) {
        SparseArrayCompat sparseArrayCompat;
        WeakHashMap<Context, SparseArrayCompat<ColorStateList>> weakHashMap = this.f3231a;
        if (weakHashMap == null || (sparseArrayCompat = weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) sparseArrayCompat.h(i2);
    }

    private static void p(@NonNull ResourceManagerInternal resourceManagerInternal) {
        if (Build.VERSION.SDK_INT < 24) {
            resourceManagerInternal.a("vector", new VdcInflateDelegate());
            resourceManagerInternal.a("animated-vector", new AvdcInflateDelegate());
            resourceManagerInternal.a("animated-selector", new AsldcInflateDelegate());
            resourceManagerInternal.a("drawable", new DrawableDelegate());
        }
    }

    private static boolean q(@NonNull Drawable drawable) {
        return (drawable instanceof VectorDrawableCompat) || f3228l.equals(drawable.getClass().getName());
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0073 A[Catch:{ Exception -> 0x008f }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x009c A[Catch:{ Exception -> 0x008f }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable r(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.DrawableRes int r12) {
        /*
            r10 = this;
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate> r0 = r10.f3232b
            r1 = 0
            if (r0 == 0) goto L_0x00b3
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b3
            androidx.collection.SparseArrayCompat<java.lang.String> r0 = r10.f3233c
            java.lang.String r2 = "appcompat_skip_skip"
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.h(r12)
            java.lang.String r0 = (java.lang.String) r0
            boolean r3 = r2.equals(r0)
            if (r3 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate> r3 = r10.f3232b
            java.lang.Object r0 = r3.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            androidx.collection.SparseArrayCompat r0 = new androidx.collection.SparseArrayCompat
            r0.<init>()
            r10.f3233c = r0
        L_0x002f:
            android.util.TypedValue r0 = r10.f3235e
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r10.f3235e = r0
        L_0x003a:
            android.util.TypedValue r0 = r10.f3235e
            android.content.res.Resources r1 = r11.getResources()
            r3 = 1
            r1.getValue(r12, r0, r3)
            long r4 = e(r0)
            android.graphics.drawable.Drawable r6 = r10.i(r11, r4)
            if (r6 == 0) goto L_0x004f
            return r6
        L_0x004f:
            java.lang.CharSequence r7 = r0.string
            if (r7 == 0) goto L_0x00ab
            java.lang.String r7 = r7.toString()
            java.lang.String r8 = ".xml"
            boolean r7 = r7.endsWith(r8)
            if (r7 == 0) goto L_0x00ab
            android.content.res.XmlResourceParser r1 = r1.getXml(r12)     // Catch:{ Exception -> 0x008f }
            android.util.AttributeSet r7 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x008f }
        L_0x0067:
            int r8 = r1.next()     // Catch:{ Exception -> 0x008f }
            r9 = 2
            if (r8 == r9) goto L_0x0071
            if (r8 == r3) goto L_0x0071
            goto L_0x0067
        L_0x0071:
            if (r8 != r9) goto L_0x009c
            java.lang.String r3 = r1.getName()     // Catch:{ Exception -> 0x008f }
            androidx.collection.SparseArrayCompat<java.lang.String> r8 = r10.f3233c     // Catch:{ Exception -> 0x008f }
            r8.a(r12, r3)     // Catch:{ Exception -> 0x008f }
            androidx.collection.SimpleArrayMap<java.lang.String, androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate> r8 = r10.f3232b     // Catch:{ Exception -> 0x008f }
            java.lang.Object r3 = r8.get(r3)     // Catch:{ Exception -> 0x008f }
            androidx.appcompat.widget.ResourceManagerInternal$InflateDelegate r3 = (androidx.appcompat.widget.ResourceManagerInternal.InflateDelegate) r3     // Catch:{ Exception -> 0x008f }
            if (r3 == 0) goto L_0x0091
            android.content.res.Resources$Theme r8 = r11.getTheme()     // Catch:{ Exception -> 0x008f }
            android.graphics.drawable.Drawable r6 = r3.a(r11, r1, r7, r8)     // Catch:{ Exception -> 0x008f }
            goto L_0x0091
        L_0x008f:
            r11 = move-exception
            goto L_0x00a4
        L_0x0091:
            if (r6 == 0) goto L_0x00ab
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x008f }
            r6.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x008f }
            r10.b(r11, r4, r6)     // Catch:{ Exception -> 0x008f }
            goto L_0x00ab
        L_0x009c:
            org.xmlpull.v1.XmlPullParserException r11 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x008f }
            java.lang.String r0 = "No start tag found"
            r11.<init>(r0)     // Catch:{ Exception -> 0x008f }
            throw r11     // Catch:{ Exception -> 0x008f }
        L_0x00a4:
            java.lang.String r0 = "ResourceManagerInternal"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r11)
        L_0x00ab:
            if (r6 != 0) goto L_0x00b2
            androidx.collection.SparseArrayCompat<java.lang.String> r11 = r10.f3233c
            r11.a(r12, r2)
        L_0x00b2:
            return r6
        L_0x00b3:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ResourceManagerInternal.r(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    private Drawable v(@NonNull Context context, @DrawableRes int i2, boolean z, @NonNull Drawable drawable) {
        ColorStateList m2 = m(context, i2);
        if (m2 != null) {
            Drawable r = DrawableCompat.r(drawable.mutate());
            DrawableCompat.o(r, m2);
            PorterDuff.Mode o = o(i2);
            if (o == null) {
                return r;
            }
            DrawableCompat.p(r, o);
            return r;
        }
        ResourceManagerHooks resourceManagerHooks = this.f3237g;
        if ((resourceManagerHooks == null || !resourceManagerHooks.e(context, i2, drawable)) && !x(context, i2, drawable) && z) {
            return null;
        }
        return drawable;
    }

    static void w(Drawable drawable, TintInfo tintInfo, int[] iArr) {
        int[] state = drawable.getState();
        if (drawable.mutate() == drawable) {
            if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
                drawable.setState(new int[0]);
                drawable.setState(state);
            }
            boolean z = tintInfo.f3315d;
            if (z || tintInfo.f3314c) {
                drawable.setColorFilter(g(z ? tintInfo.f3312a : null, tintInfo.f3314c ? tintInfo.f3313b : f3226j, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d(f3224h, "Mutated drawable is not the same instance as the input.");
    }

    public synchronized Drawable j(@NonNull Context context, @DrawableRes int i2) {
        return k(context, i2, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable k(@NonNull Context context, @DrawableRes int i2, boolean z) {
        Drawable r;
        try {
            d(context);
            r = r(context, i2);
            if (r == null) {
                r = f(context, i2);
            }
            if (r == null) {
                r = ContextCompat.l(context, i2);
            }
            if (r != null) {
                r = v(context, i2, z, r);
            }
            if (r != null) {
                DrawableUtils.b(r);
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return r;
    }

    /* access modifiers changed from: package-private */
    public synchronized ColorStateList m(@NonNull Context context, @DrawableRes int i2) {
        ColorStateList n2;
        n2 = n(context, i2);
        if (n2 == null) {
            ResourceManagerHooks resourceManagerHooks = this.f3237g;
            n2 = resourceManagerHooks == null ? null : resourceManagerHooks.d(context, i2);
            if (n2 != null) {
                c(context, i2, n2);
            }
        }
        return n2;
    }

    /* access modifiers changed from: package-private */
    public PorterDuff.Mode o(int i2) {
        ResourceManagerHooks resourceManagerHooks = this.f3237g;
        if (resourceManagerHooks == null) {
            return null;
        }
        return resourceManagerHooks.b(i2);
    }

    public synchronized void s(@NonNull Context context) {
        LongSparseArray longSparseArray = this.f3234d.get(context);
        if (longSparseArray != null) {
            longSparseArray.b();
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized Drawable t(@NonNull Context context, @NonNull VectorEnabledTintResources vectorEnabledTintResources, @DrawableRes int i2) {
        try {
            Drawable r = r(context, i2);
            if (r == null) {
                r = vectorEnabledTintResources.a(i2);
            }
            if (r == null) {
                return null;
            }
            return v(context, i2, false, r);
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    public synchronized void u(ResourceManagerHooks resourceManagerHooks) {
        this.f3237g = resourceManagerHooks;
    }

    /* access modifiers changed from: package-private */
    public boolean x(@NonNull Context context, @DrawableRes int i2, @NonNull Drawable drawable) {
        ResourceManagerHooks resourceManagerHooks = this.f3237g;
        return resourceManagerHooks != null && resourceManagerHooks.a(context, i2, drawable);
    }
}
