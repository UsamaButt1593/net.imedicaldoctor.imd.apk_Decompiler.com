package com.google.android.material.drawable;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class DrawableUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final int f21408a = -1;

    /* renamed from: b  reason: collision with root package name */
    private static final int f21409b = -1;

    /* renamed from: c  reason: collision with root package name */
    private static final int f21410c = -1;

    @RequiresApi(21)
    private static class OutlineCompatL {
        private OutlineCompatL() {
        }

        @DoNotInline
        static void a(@NonNull Outline outline, @NonNull Path path) {
            outline.setConvexPath(path);
        }
    }

    @RequiresApi(30)
    private static class OutlineCompatR {
        private OutlineCompatR() {
        }

        @DoNotInline
        static void a(@NonNull Outline outline, @NonNull Path path) {
            outline.setPath(path);
        }
    }

    private DrawableUtils() {
    }

    @Nullable
    public static Drawable a(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        return b(drawable, drawable2, -1, -1);
    }

    @Nullable
    public static Drawable b(@Nullable Drawable drawable, @Nullable Drawable drawable2, @Px int i2, @Px int i3) {
        if (drawable == null) {
            return drawable2;
        }
        if (drawable2 == null) {
            return drawable;
        }
        boolean z = (i2 == -1 || i3 == -1) ? false : true;
        if (i2 == -1) {
            i2 = i(drawable, drawable2);
        }
        if (i3 == -1) {
            i3 = h(drawable, drawable2);
        }
        if (i2 > drawable.getIntrinsicWidth() || i3 > drawable.getIntrinsicHeight()) {
            float f2 = ((float) i2) / ((float) i3);
            if (f2 >= ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight())) {
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int i4 = intrinsicWidth;
                i3 = (int) (((float) intrinsicWidth) / f2);
                i2 = i4;
            } else {
                i3 = drawable.getIntrinsicHeight();
                i2 = (int) (f2 * ((float) i3));
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{drawable, drawable2});
            layerDrawable.setLayerSize(1, i2, i3);
            layerDrawable.setLayerGravity(1, 17);
            return layerDrawable;
        }
        if (z) {
            drawable2 = new ScaledDrawableWrapper(drawable2, i2, i3);
        }
        LayerDrawable layerDrawable2 = new LayerDrawable(new Drawable[]{drawable, drawable2});
        int max = Math.max((drawable.getIntrinsicWidth() - i2) / 2, 0);
        int max2 = Math.max((drawable.getIntrinsicHeight() - i3) / 2, 0);
        LayerDrawable layerDrawable3 = layerDrawable2;
        layerDrawable3.setLayerInset(1, max, max2, max, max2);
        return layerDrawable3;
    }

    @Nullable
    public static Drawable c(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        return e(drawable, colorStateList, mode, false);
    }

    @Nullable
    public static Drawable d(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        return e(drawable, colorStateList, mode, Build.VERSION.SDK_INT < 23);
    }

    @Nullable
    private static Drawable e(@Nullable Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, boolean z) {
        if (drawable == null) {
            return null;
        }
        if (colorStateList != null) {
            drawable = DrawableCompat.r(drawable).mutate();
            if (mode != null) {
                DrawableCompat.p(drawable, mode);
            }
        } else if (z) {
            drawable.mutate();
        }
        return drawable;
    }

    @NonNull
    public static int[] f(@NonNull int[] iArr) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            if (i3 == 16842912) {
                return iArr;
            }
            if (i3 == 0) {
                int[] iArr2 = (int[]) iArr.clone();
                iArr2[i2] = 16842912;
                return iArr2;
            }
        }
        int[] copyOf = Arrays.copyOf(iArr, iArr.length + 1);
        copyOf[iArr.length] = 16842912;
        return copyOf;
    }

    @Nullable
    public static ColorStateList g(@Nullable Drawable drawable) {
        if (drawable instanceof ColorDrawable) {
            return ColorStateList.valueOf(((ColorDrawable) drawable).getColor());
        }
        if (Build.VERSION.SDK_INT < 29 || !c.a(drawable)) {
            return null;
        }
        return d.a(drawable).getColorStateList();
    }

    private static int h(@NonNull Drawable drawable, @NonNull Drawable drawable2) {
        int intrinsicHeight = drawable2.getIntrinsicHeight();
        return intrinsicHeight != -1 ? intrinsicHeight : drawable.getIntrinsicHeight();
    }

    private static int i(@NonNull Drawable drawable, @NonNull Drawable drawable2) {
        int intrinsicWidth = drawable2.getIntrinsicWidth();
        return intrinsicWidth != -1 ? intrinsicWidth : drawable.getIntrinsicWidth();
    }

    @NonNull
    public static int[] j(@NonNull int[] iArr) {
        int[] iArr2 = new int[iArr.length];
        int i2 = 0;
        for (int i3 : iArr) {
            if (i3 != 16842912) {
                iArr2[i2] = i3;
                i2++;
            }
        }
        return iArr2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0043 A[Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0014 A[Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }] */
    @androidx.annotation.NonNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.util.AttributeSet k(@androidx.annotation.NonNull android.content.Context r3, @androidx.annotation.XmlRes int r4, @androidx.annotation.NonNull java.lang.CharSequence r5) {
        /*
            android.content.res.Resources r3 = r3.getResources()     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            android.content.res.XmlResourceParser r3 = r3.getXml(r4)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
        L_0x0008:
            int r0 = r3.next()     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            r1 = 2
            if (r0 == r1) goto L_0x0012
            r2 = 1
            if (r0 != r2) goto L_0x0008
        L_0x0012:
            if (r0 != r1) goto L_0x0043
            java.lang.String r0 = r3.getName()     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            boolean r0 = android.text.TextUtils.equals(r0, r5)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            if (r0 == 0) goto L_0x0027
            android.util.AttributeSet r3 = android.util.Xml.asAttributeSet(r3)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            return r3
        L_0x0023:
            r3 = move-exception
            goto L_0x004b
        L_0x0025:
            r3 = move-exception
            goto L_0x004b
        L_0x0027:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            r0.<init>()     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            java.lang.String r1 = "Must have a <"
            r0.append(r1)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            r0.append(r5)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            java.lang.String r5 = "> start tag"
            r0.append(r5)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            java.lang.String r5 = r0.toString()     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            r3.<init>(r5)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            throw r3     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
        L_0x0043:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            java.lang.String r5 = "No start tag found"
            r3.<init>(r5)     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
            throw r3     // Catch:{ XmlPullParserException -> 0x0025, IOException -> 0x0023 }
        L_0x004b:
            android.content.res.Resources$NotFoundException r5 = new android.content.res.Resources$NotFoundException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Can't load badge resource ID #0x"
            r0.append(r1)
            java.lang.String r4 = java.lang.Integer.toHexString(r4)
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            r5.<init>(r4)
            r5.initCause(r3)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.drawable.DrawableUtils.k(android.content.Context, int, java.lang.CharSequence):android.util.AttributeSet");
    }

    public static void l(@NonNull Outline outline, @NonNull Path path) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            OutlineCompatR.a(outline, path);
        } else if (i2 >= 29) {
            try {
                OutlineCompatL.a(outline, path);
            } catch (IllegalArgumentException unused) {
            }
        } else if (path.isConvex()) {
            OutlineCompatL.a(outline, path);
        }
    }

    @TargetApi(21)
    public static void m(@Nullable RippleDrawable rippleDrawable, int i2) {
        if (Build.VERSION.SDK_INT >= 23) {
            rippleDrawable.setRadius(i2);
            return;
        }
        Class<RippleDrawable> cls = RippleDrawable.class;
        try {
            cls.getDeclaredMethod("setMaxRadius", new Class[]{Integer.TYPE}).invoke(rippleDrawable, new Object[]{Integer.valueOf(i2)});
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e2) {
            throw new IllegalStateException("Couldn't set RippleDrawable radius", e2);
        }
    }

    public static void n(@NonNull Drawable drawable, @ColorInt int i2) {
        boolean z = i2 != 0;
        if (Build.VERSION.SDK_INT == 21) {
            if (z) {
                drawable.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
            } else {
                drawable.setColorFilter((ColorFilter) null);
            }
        } else if (z) {
            DrawableCompat.n(drawable, i2);
        } else {
            DrawableCompat.o(drawable, (ColorStateList) null);
        }
    }

    @Nullable
    public static PorterDuffColorFilter o(@NonNull Drawable drawable, @Nullable ColorStateList colorStateList, @Nullable PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }
}
