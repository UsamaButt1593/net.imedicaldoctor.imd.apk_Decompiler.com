package com.google.android.material.color;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.utilities.Blend;
import com.google.android.material.color.utilities.Hct;
import com.google.android.material.resources.MaterialAttributes;

public class MaterialColors {

    /* renamed from: a  reason: collision with root package name */
    public static final float f21128a = 1.0f;

    /* renamed from: b  reason: collision with root package name */
    public static final float f21129b = 0.54f;

    /* renamed from: c  reason: collision with root package name */
    public static final float f21130c = 0.38f;

    /* renamed from: d  reason: collision with root package name */
    public static final float f21131d = 0.32f;

    /* renamed from: e  reason: collision with root package name */
    public static final float f21132e = 0.12f;

    /* renamed from: f  reason: collision with root package name */
    private static final int f21133f = 40;

    /* renamed from: g  reason: collision with root package name */
    private static final int f21134g = 100;

    /* renamed from: h  reason: collision with root package name */
    private static final int f21135h = 90;

    /* renamed from: i  reason: collision with root package name */
    private static final int f21136i = 10;

    /* renamed from: j  reason: collision with root package name */
    private static final int f21137j = 94;

    /* renamed from: k  reason: collision with root package name */
    private static final int f21138k = 92;

    /* renamed from: l  reason: collision with root package name */
    private static final int f21139l = 80;

    /* renamed from: m  reason: collision with root package name */
    private static final int f21140m = 20;

    /* renamed from: n  reason: collision with root package name */
    private static final int f21141n = 30;
    private static final int o = 90;
    private static final int p = 12;
    private static final int q = 17;
    private static final int r = 6;

    private MaterialColors() {
    }

    @ColorInt
    public static int a(@ColorInt int i2, @IntRange(from = 0, to = 255) int i3) {
        return ColorUtils.D(i2, (Color.alpha(i2) * i3) / 255);
    }

    @ColorInt
    public static int b(@NonNull Context context, @AttrRes int i2, @ColorInt int i3) {
        Integer f2 = f(context, i2);
        return f2 != null ? f2.intValue() : i3;
    }

    @ColorInt
    public static int c(Context context, @AttrRes int i2, String str) {
        return w(context, MaterialAttributes.i(context, i2, str));
    }

    @ColorInt
    public static int d(@NonNull View view, @AttrRes int i2) {
        return w(view.getContext(), MaterialAttributes.j(view, i2));
    }

    @ColorInt
    public static int e(@NonNull View view, @AttrRes int i2, @ColorInt int i3) {
        return b(view.getContext(), i2, i3);
    }

    @ColorInt
    @Nullable
    public static Integer f(@NonNull Context context, @AttrRes int i2) {
        TypedValue a2 = MaterialAttributes.a(context, i2);
        if (a2 != null) {
            return Integer.valueOf(w(context, a2));
        }
        return null;
    }

    @ColorInt
    private static int g(@ColorInt int i2, @IntRange(from = 0, to = 100) int i3) {
        Hct b2 = Hct.b(i2);
        b2.j((double) i3);
        return b2.k();
    }

    @ColorInt
    private static int h(@ColorInt int i2, @IntRange(from = 0, to = 100) int i3, int i4) {
        Hct b2 = Hct.b(g(i2, i3));
        b2.g((double) i4);
        return b2.k();
    }

    @NonNull
    public static ColorRoles i(@ColorInt int i2, boolean z) {
        return z ? new ColorRoles(g(i2, 40), g(i2, 100), g(i2, 90), g(i2, 10)) : new ColorRoles(g(i2, 80), g(i2, 20), g(i2, 30), g(i2, 90));
    }

    @NonNull
    public static ColorRoles j(@NonNull Context context, @ColorInt int i2) {
        return i(i2, r(context));
    }

    @NonNull
    public static ColorStateList k(@NonNull Context context, @AttrRes int i2, @NonNull ColorStateList colorStateList) {
        TypedValue a2 = MaterialAttributes.a(context, i2);
        ColorStateList x = a2 != null ? x(context, a2) : null;
        return x == null ? colorStateList : x;
    }

    @Nullable
    public static ColorStateList l(@NonNull Context context, @AttrRes int i2) {
        TypedValue a2 = MaterialAttributes.a(context, i2);
        if (a2 == null) {
            return null;
        }
        int i3 = a2.resourceId;
        if (i3 != 0) {
            return ContextCompat.h(context, i3);
        }
        int i4 = a2.data;
        if (i4 != 0) {
            return ColorStateList.valueOf(i4);
        }
        return null;
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int m(@NonNull Context context, @ColorInt int i2) {
        return h(i2, r(context) ? 94 : 12, 6);
    }

    @ColorInt
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static int n(@NonNull Context context, @ColorInt int i2) {
        return h(i2, r(context) ? 92 : 17, 6);
    }

    @ColorInt
    public static int o(@ColorInt int i2, @ColorInt int i3) {
        return Blend.b(i2, i3);
    }

    @ColorInt
    public static int p(@NonNull Context context, @ColorInt int i2) {
        return o(i2, c(context, R.attr.R3, MaterialColors.class.getCanonicalName()));
    }

    public static boolean q(@ColorInt int i2) {
        return i2 != 0 && ColorUtils.n(i2) > 0.5d;
    }

    static boolean r(@NonNull Context context) {
        return MaterialAttributes.b(context, R.attr.v9, true);
    }

    @ColorInt
    public static int s(@ColorInt int i2, @ColorInt int i3) {
        return ColorUtils.v(i3, i2);
    }

    @ColorInt
    public static int t(@ColorInt int i2, @ColorInt int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return s(i2, ColorUtils.D(i3, Math.round(((float) Color.alpha(i3)) * f2)));
    }

    @ColorInt
    public static int u(@NonNull View view, @AttrRes int i2, @AttrRes int i3) {
        return v(view, i2, i3, 1.0f);
    }

    @ColorInt
    public static int v(@NonNull View view, @AttrRes int i2, @AttrRes int i3, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        return t(d(view, i2), d(view, i3), f2);
    }

    private static int w(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i2 = typedValue.resourceId;
        return i2 != 0 ? ContextCompat.g(context, i2) : typedValue.data;
    }

    private static ColorStateList x(@NonNull Context context, @NonNull TypedValue typedValue) {
        int i2 = typedValue.resourceId;
        return i2 != 0 ? ContextCompat.h(context, i2) : ColorStateList.valueOf(typedValue.data);
    }
}
