package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;
import androidx.core.graphics.ColorUtils;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ThemeUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f3294a = "ThemeUtils";

    /* renamed from: b  reason: collision with root package name */
    private static final ThreadLocal<TypedValue> f3295b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    static final int[] f3296c = {-16842910};

    /* renamed from: d  reason: collision with root package name */
    static final int[] f3297d = {16842908};

    /* renamed from: e  reason: collision with root package name */
    static final int[] f3298e = {16843518};

    /* renamed from: f  reason: collision with root package name */
    static final int[] f3299f = {16842919};

    /* renamed from: g  reason: collision with root package name */
    static final int[] f3300g = {16842912};

    /* renamed from: h  reason: collision with root package name */
    static final int[] f3301h = {16842913};

    /* renamed from: i  reason: collision with root package name */
    static final int[] f3302i = {-16842919, -16842908};

    /* renamed from: j  reason: collision with root package name */
    static final int[] f3303j = new int[0];

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f3304k = new int[1];

    private ThemeUtils() {
    }

    public static void a(@NonNull View view, @NonNull Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.S0);
        try {
            if (!obtainStyledAttributes.hasValue(R.styleable.g3)) {
                Log.e(f3294a, "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    @NonNull
    public static ColorStateList b(int i2, int i3) {
        return new ColorStateList(new int[][]{f3296c, f3303j}, new int[]{i3, i2});
    }

    public static int c(@NonNull Context context, int i2) {
        ColorStateList f2 = f(context, i2);
        if (f2 != null && f2.isStateful()) {
            return f2.getColorForState(f3296c, f2.getDefaultColor());
        }
        TypedValue g2 = g();
        context.getTheme().resolveAttribute(16842803, g2, true);
        return e(context, i2, g2.getFloat());
    }

    public static int d(@NonNull Context context, int i2) {
        int[] iArr = f3304k;
        iArr[0] = i2;
        TintTypedArray F = TintTypedArray.F(context, (AttributeSet) null, iArr);
        try {
            return F.c(0, 0);
        } finally {
            F.I();
        }
    }

    static int e(@NonNull Context context, int i2, float f2) {
        int d2 = d(context, i2);
        return ColorUtils.D(d2, Math.round(((float) Color.alpha(d2)) * f2));
    }

    @Nullable
    public static ColorStateList f(@NonNull Context context, int i2) {
        int[] iArr = f3304k;
        iArr[0] = i2;
        TintTypedArray F = TintTypedArray.F(context, (AttributeSet) null, iArr);
        try {
            return F.d(0);
        } finally {
            F.I();
        }
    }

    private static TypedValue g() {
        ThreadLocal<TypedValue> threadLocal = f3295b;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }
}
