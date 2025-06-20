package androidx.core.content.res;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DoNotInline;
import androidx.annotation.DrawableRes;
import androidx.annotation.FontRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.util.ObjectsCompat;
import androidx.core.util.Preconditions;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.WeakHashMap;

public final class ResourcesCompat {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5785a = "ResourcesCompat";

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f5786b = new ThreadLocal<>();
    @GuardedBy("sColorStateCacheLock")

    /* renamed from: c  reason: collision with root package name */
    private static final WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> f5787c = new WeakHashMap<>(0);

    /* renamed from: d  reason: collision with root package name */
    private static final Object f5788d = new Object();
    @AnyRes

    /* renamed from: e  reason: collision with root package name */
    public static final int f5789e = 0;

    @RequiresApi(21)
    static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        static Drawable a(Resources resources, int i2, Resources.Theme theme) {
            return resources.getDrawable(i2, theme);
        }

        @DoNotInline
        static Drawable b(Resources resources, int i2, int i3, Resources.Theme theme) {
            return resources.getDrawableForDensity(i2, i3, theme);
        }
    }

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static int a(Resources resources, int i2, Resources.Theme theme) {
            return resources.getColor(i2, theme);
        }

        @DoNotInline
        @NonNull
        static ColorStateList b(@NonNull Resources resources, @ColorRes int i2, @Nullable Resources.Theme theme) {
            return resources.getColorStateList(i2, theme);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static float a(@NonNull Resources resources, @DimenRes int i2) {
            return resources.getFloat(i2);
        }
    }

    private static class ColorStateListCacheEntry {

        /* renamed from: a  reason: collision with root package name */
        final ColorStateList f5790a;

        /* renamed from: b  reason: collision with root package name */
        final Configuration f5791b;

        /* renamed from: c  reason: collision with root package name */
        final int f5792c;

        ColorStateListCacheEntry(@NonNull ColorStateList colorStateList, @NonNull Configuration configuration, @Nullable Resources.Theme theme) {
            this.f5790a = colorStateList;
            this.f5791b = configuration;
            this.f5792c = theme == null ? 0 : theme.hashCode();
        }
    }

    private static final class ColorStateListCacheKey {

        /* renamed from: a  reason: collision with root package name */
        final Resources f5793a;

        /* renamed from: b  reason: collision with root package name */
        final Resources.Theme f5794b;

        ColorStateListCacheKey(@NonNull Resources resources, @Nullable Resources.Theme theme) {
            this.f5793a = resources;
            this.f5794b = theme;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ColorStateListCacheKey.class != obj.getClass()) {
                return false;
            }
            ColorStateListCacheKey colorStateListCacheKey = (ColorStateListCacheKey) obj;
            return this.f5793a.equals(colorStateListCacheKey.f5793a) && ObjectsCompat.a(this.f5794b, colorStateListCacheKey.f5794b);
        }

        public int hashCode() {
            return ObjectsCompat.b(this.f5793a, this.f5794b);
        }
    }

    public static abstract class FontCallback {
        @NonNull
        @RestrictTo({RestrictTo.Scope.LIBRARY})
        public static Handler e(@Nullable Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void c(int i2, @Nullable Handler handler) {
            e(handler).post(new b(this, i2));
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public final void d(@NonNull Typeface typeface, @Nullable Handler handler) {
            e(handler).post(new a(this, typeface));
        }

        /* renamed from: h */
        public abstract void f(int i2);

        /* renamed from: i */
        public abstract void g(@NonNull Typeface typeface);
    }

    public static final class ThemeCompat {

        @RequiresApi(23)
        static class Api23Impl {

            /* renamed from: a  reason: collision with root package name */
            private static final Object f5795a = new Object();

            /* renamed from: b  reason: collision with root package name */
            private static Method f5796b;

            /* renamed from: c  reason: collision with root package name */
            private static boolean f5797c;

            private Api23Impl() {
            }

            @SuppressLint({"BanUncheckedReflection"})
            static void a(@NonNull Resources.Theme theme) {
                synchronized (f5795a) {
                    if (!f5797c) {
                        try {
                            Method declaredMethod = Resources.Theme.class.getDeclaredMethod("rebase", (Class[]) null);
                            f5796b = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e2) {
                            Log.i(ResourcesCompat.f5785a, "Failed to retrieve rebase() method", e2);
                        }
                        f5797c = true;
                    }
                    Method method = f5796b;
                    if (method != null) {
                        try {
                            method.invoke(theme, (Object[]) null);
                        } catch (IllegalAccessException | InvocationTargetException e3) {
                            Log.i(ResourcesCompat.f5785a, "Failed to invoke rebase() method via reflection", e3);
                            f5796b = null;
                        }
                    }
                }
            }
        }

        @RequiresApi(29)
        static class Api29Impl {
            private Api29Impl() {
            }

            @DoNotInline
            static void a(@NonNull Resources.Theme theme) {
                theme.rebase();
            }
        }

        private ThemeCompat() {
        }

        public static void a(@NonNull Resources.Theme theme) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                Api29Impl.a(theme);
            } else if (i2 >= 23) {
                Api23Impl.a(theme);
            }
        }
    }

    private ResourcesCompat() {
    }

    private static void a(@NonNull ColorStateListCacheKey colorStateListCacheKey, @ColorRes int i2, @NonNull ColorStateList colorStateList, @Nullable Resources.Theme theme) {
        synchronized (f5788d) {
            try {
                WeakHashMap<ColorStateListCacheKey, SparseArray<ColorStateListCacheEntry>> weakHashMap = f5787c;
                SparseArray sparseArray = weakHashMap.get(colorStateListCacheKey);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(colorStateListCacheKey, sparseArray);
                }
                sparseArray.append(i2, new ColorStateListCacheEntry(colorStateList, colorStateListCacheKey.f5793a.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void b(@NonNull Resources.Theme theme) {
        synchronized (f5788d) {
            try {
                Iterator<ColorStateListCacheKey> it2 = f5787c.keySet().iterator();
                while (it2.hasNext()) {
                    ColorStateListCacheKey next = it2.next();
                    if (next != null && theme.equals(next.f5794b)) {
                        it2.remove();
                    }
                }
            } finally {
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003c, code lost:
        if (r2.f5792c == r5.hashCode()) goto L_0x003e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0046, code lost:
        return null;
     */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.content.res.ColorStateList c(@androidx.annotation.NonNull androidx.core.content.res.ResourcesCompat.ColorStateListCacheKey r5, @androidx.annotation.ColorRes int r6) {
        /*
            java.lang.Object r0 = f5788d
            monitor-enter(r0)
            java.util.WeakHashMap<androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey, android.util.SparseArray<androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry>> r1 = f5787c     // Catch:{ all -> 0x0032 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x0032 }
            android.util.SparseArray r1 = (android.util.SparseArray) r1     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0045
            int r2 = r1.size()     // Catch:{ all -> 0x0032 }
            if (r2 <= 0) goto L_0x0045
            java.lang.Object r2 = r1.get(r6)     // Catch:{ all -> 0x0032 }
            androidx.core.content.res.ResourcesCompat$ColorStateListCacheEntry r2 = (androidx.core.content.res.ResourcesCompat.ColorStateListCacheEntry) r2     // Catch:{ all -> 0x0032 }
            if (r2 == 0) goto L_0x0045
            android.content.res.Configuration r3 = r2.f5791b     // Catch:{ all -> 0x0032 }
            android.content.res.Resources r4 = r5.f5793a     // Catch:{ all -> 0x0032 }
            android.content.res.Configuration r4 = r4.getConfiguration()     // Catch:{ all -> 0x0032 }
            boolean r3 = r3.equals(r4)     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x0042
            android.content.res.Resources$Theme r5 = r5.f5794b     // Catch:{ all -> 0x0032 }
            if (r5 != 0) goto L_0x0034
            int r3 = r2.f5792c     // Catch:{ all -> 0x0032 }
            if (r3 == 0) goto L_0x003e
            goto L_0x0034
        L_0x0032:
            r5 = move-exception
            goto L_0x0048
        L_0x0034:
            if (r5 == 0) goto L_0x0042
            int r3 = r2.f5792c     // Catch:{ all -> 0x0032 }
            int r5 = r5.hashCode()     // Catch:{ all -> 0x0032 }
            if (r3 != r5) goto L_0x0042
        L_0x003e:
            android.content.res.ColorStateList r5 = r2.f5790a     // Catch:{ all -> 0x0032 }
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            return r5
        L_0x0042:
            r1.remove(r6)     // Catch:{ all -> 0x0032 }
        L_0x0045:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            r5 = 0
            return r5
        L_0x0048:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.c(androidx.core.content.res.ResourcesCompat$ColorStateListCacheKey, int):android.content.res.ColorStateList");
    }

    @Nullable
    public static Typeface d(@NonNull Context context, @FontRes int i2) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return p(context, i2, new TypedValue(), 0, (FontCallback) null, (Handler) null, false, true);
    }

    @ColorInt
    public static int e(@NonNull Resources resources, @ColorRes int i2, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Build.VERSION.SDK_INT >= 23 ? Api23Impl.a(resources, i2, theme) : resources.getColor(i2);
    }

    @Nullable
    public static ColorStateList f(@NonNull Resources resources, @ColorRes int i2, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        ColorStateListCacheKey colorStateListCacheKey = new ColorStateListCacheKey(resources, theme);
        ColorStateList c2 = c(colorStateListCacheKey, i2);
        if (c2 != null) {
            return c2;
        }
        ColorStateList n2 = n(resources, i2, theme);
        if (n2 == null) {
            return Build.VERSION.SDK_INT >= 23 ? Api23Impl.b(resources, i2, theme) : resources.getColorStateList(i2);
        }
        a(colorStateListCacheKey, i2, n2, theme);
        return n2;
    }

    @Nullable
    public static Drawable g(@NonNull Resources resources, @DrawableRes int i2, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.a(resources, i2, theme);
    }

    @Nullable
    public static Drawable h(@NonNull Resources resources, @DrawableRes int i2, int i3, @Nullable Resources.Theme theme) throws Resources.NotFoundException {
        return Api21Impl.b(resources, i2, i3, theme);
    }

    public static float i(@NonNull Resources resources, @DimenRes int i2) {
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.a(resources, i2);
        }
        TypedValue m2 = m();
        resources.getValue(i2, m2, true);
        if (m2.type == 4) {
            return m2.getFloat();
        }
        throw new Resources.NotFoundException("Resource ID #0x" + Integer.toHexString(i2) + " type #0x" + Integer.toHexString(m2.type) + " is not valid");
    }

    @Nullable
    public static Typeface j(@NonNull Context context, @FontRes int i2) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return p(context, i2, new TypedValue(), 0, (FontCallback) null, (Handler) null, false, false);
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static Typeface k(@NonNull Context context, @FontRes int i2, @NonNull TypedValue typedValue, int i3, @Nullable FontCallback fontCallback) throws Resources.NotFoundException {
        if (context.isRestricted()) {
            return null;
        }
        return p(context, i2, typedValue, i3, fontCallback, (Handler) null, true, false);
    }

    public static void l(@NonNull Context context, @FontRes int i2, @NonNull FontCallback fontCallback, @Nullable Handler handler) throws Resources.NotFoundException {
        Preconditions.l(fontCallback);
        if (context.isRestricted()) {
            fontCallback.c(-4, handler);
            return;
        }
        p(context, i2, new TypedValue(), 0, fontCallback, handler, false, false);
    }

    @NonNull
    private static TypedValue m() {
        ThreadLocal<TypedValue> threadLocal = f5786b;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    @Nullable
    private static ColorStateList n(Resources resources, int i2, @Nullable Resources.Theme theme) {
        if (o(resources, i2)) {
            return null;
        }
        try {
            return ColorStateListInflaterCompat.a(resources, resources.getXml(i2), theme);
        } catch (Exception e2) {
            Log.w(f5785a, "Failed to inflate ColorStateList, leaving it to the framework", e2);
            return null;
        }
    }

    private static boolean o(@NonNull Resources resources, @ColorRes int i2) {
        TypedValue m2 = m();
        resources.getValue(i2, m2, true);
        int i3 = m2.type;
        return i3 >= 28 && i3 <= 31;
    }

    private static Typeface p(@NonNull Context context, int i2, @NonNull TypedValue typedValue, int i3, @Nullable FontCallback fontCallback, @Nullable Handler handler, boolean z, boolean z2) {
        Resources resources = context.getResources();
        int i4 = i2;
        resources.getValue(i2, typedValue, true);
        Typeface q = q(context, resources, typedValue, i2, i3, fontCallback, handler, z, z2);
        if (q != null || fontCallback != null || z2) {
            return q;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i2) + " could not be retrieved.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.graphics.Typeface q(@androidx.annotation.NonNull android.content.Context r16, android.content.res.Resources r17, @androidx.annotation.NonNull android.util.TypedValue r18, int r19, int r20, @androidx.annotation.Nullable androidx.core.content.res.ResourcesCompat.FontCallback r21, @androidx.annotation.Nullable android.os.Handler r22, boolean r23, boolean r24) {
        /*
            r0 = r17
            r1 = r18
            r4 = r19
            r11 = r21
            r12 = r22
            java.lang.String r13 = "ResourcesCompat"
            java.lang.CharSequence r2 = r1.string
            if (r2 == 0) goto L_0x00ba
            java.lang.String r14 = r2.toString()
            java.lang.String r2 = "res/"
            boolean r2 = r14.startsWith(r2)
            r15 = 0
            r10 = -3
            if (r2 != 0) goto L_0x0024
            if (r11 == 0) goto L_0x0023
            r11.c(r10, r12)
        L_0x0023:
            return r15
        L_0x0024:
            int r2 = r1.assetCookie
            r7 = r20
            android.graphics.Typeface r2 = androidx.core.graphics.TypefaceCompat.k(r0, r4, r14, r2, r7)
            if (r2 == 0) goto L_0x0034
            if (r11 == 0) goto L_0x0033
            r11.d(r2, r12)
        L_0x0033:
            return r2
        L_0x0034:
            if (r24 == 0) goto L_0x0037
            return r15
        L_0x0037:
            java.lang.String r2 = r14.toLowerCase()     // Catch:{ XmlPullParserException -> 0x005b, IOException -> 0x0058 }
            java.lang.String r3 = ".xml"
            boolean r2 = r2.endsWith(r3)     // Catch:{ XmlPullParserException -> 0x005b, IOException -> 0x0058 }
            if (r2 == 0) goto L_0x007a
            android.content.res.XmlResourceParser r2 = r0.getXml(r4)     // Catch:{ XmlPullParserException -> 0x005b, IOException -> 0x0058 }
            androidx.core.content.res.FontResourcesParserCompat$FamilyResourceEntry r2 = androidx.core.content.res.FontResourcesParserCompat.b(r2, r0)     // Catch:{ XmlPullParserException -> 0x005b, IOException -> 0x0058 }
            if (r2 != 0) goto L_0x005f
            java.lang.String r0 = "Failed to find font-family tag"
            android.util.Log.e(r13, r0)     // Catch:{ XmlPullParserException -> 0x005b, IOException -> 0x0058 }
            if (r11 == 0) goto L_0x005e
            r11.c(r10, r12)     // Catch:{ XmlPullParserException -> 0x005b, IOException -> 0x0058 }
            goto L_0x005e
        L_0x0058:
            r0 = move-exception
            r15 = -3
            goto L_0x0096
        L_0x005b:
            r0 = move-exception
            r15 = -3
            goto L_0x00ab
        L_0x005e:
            return r15
        L_0x005f:
            int r6 = r1.assetCookie     // Catch:{ XmlPullParserException -> 0x005b, IOException -> 0x0058 }
            r1 = r16
            r3 = r17
            r4 = r19
            r5 = r14
            r7 = r20
            r8 = r21
            r9 = r22
            r15 = -3
            r10 = r23
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.f(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ XmlPullParserException -> 0x0078, IOException -> 0x0076 }
            return r0
        L_0x0076:
            r0 = move-exception
            goto L_0x0096
        L_0x0078:
            r0 = move-exception
            goto L_0x00ab
        L_0x007a:
            r15 = -3
            int r5 = r1.assetCookie     // Catch:{ XmlPullParserException -> 0x0078, IOException -> 0x0076 }
            r1 = r16
            r2 = r17
            r3 = r19
            r4 = r14
            r6 = r20
            android.graphics.Typeface r0 = androidx.core.graphics.TypefaceCompat.h(r1, r2, r3, r4, r5, r6)     // Catch:{ XmlPullParserException -> 0x0078, IOException -> 0x0076 }
            if (r11 == 0) goto L_0x0095
            if (r0 == 0) goto L_0x0092
            r11.d(r0, r12)     // Catch:{ XmlPullParserException -> 0x0078, IOException -> 0x0076 }
            goto L_0x0095
        L_0x0092:
            r11.c(r15, r12)     // Catch:{ XmlPullParserException -> 0x0078, IOException -> 0x0076 }
        L_0x0095:
            return r0
        L_0x0096:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to read xml resource "
        L_0x009d:
            r1.append(r2)
            r1.append(r14)
            java.lang.String r1 = r1.toString()
            android.util.Log.e(r13, r1, r0)
            goto L_0x00b3
        L_0x00ab:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Failed to parse xml resource "
            goto L_0x009d
        L_0x00b3:
            if (r11 == 0) goto L_0x00b8
            r11.c(r15, r12)
        L_0x00b8:
            r1 = 0
            return r1
        L_0x00ba:
            android.content.res.Resources$NotFoundException r2 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = "Resource \""
            r3.append(r5)
            java.lang.String r0 = r0.getResourceName(r4)
            r3.append(r0)
            java.lang.String r0 = "\" ("
            r3.append(r0)
            java.lang.String r0 = java.lang.Integer.toHexString(r19)
            r3.append(r0)
            java.lang.String r0 = ") is not a Font: "
            r3.append(r0)
            r3.append(r1)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.ResourcesCompat.q(android.content.Context, android.content.res.Resources, android.util.TypedValue, int, int, androidx.core.content.res.ResourcesCompat$FontCallback, android.os.Handler, boolean, boolean):android.graphics.Typeface");
    }
}
