package com.google.android.material.ripple;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Log;
import android.util.StateSet;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.annotation.ColorInt;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class RippleUtils {
    @ChecksSdkIntAtLeast(api = 21)

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f21729a = true;

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f21730b = {16842919};

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f21731c = {16843623, 16842908};

    /* renamed from: d  reason: collision with root package name */
    private static final int[] f21732d = {16842908};

    /* renamed from: e  reason: collision with root package name */
    private static final int[] f21733e = {16843623};

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f21734f = {16842913, 16842919};

    /* renamed from: g  reason: collision with root package name */
    private static final int[] f21735g = {16842913, 16843623, 16842908};

    /* renamed from: h  reason: collision with root package name */
    private static final int[] f21736h = {16842913, 16842908};

    /* renamed from: i  reason: collision with root package name */
    private static final int[] f21737i = {16842913, 16843623};

    /* renamed from: j  reason: collision with root package name */
    private static final int[] f21738j = {16842913};

    /* renamed from: k  reason: collision with root package name */
    private static final int[] f21739k = {16842910, 16842919};
    @VisibleForTesting

    /* renamed from: l  reason: collision with root package name */
    static final String f21740l = RippleUtils.class.getSimpleName();
    @VisibleForTesting

    /* renamed from: m  reason: collision with root package name */
    static final String f21741m = "Use a non-transparent color for the default color as it will be used to finish ripple animations.";

    @RequiresApi(21)
    private static class RippleUtilsLollipop {
        private RippleUtilsLollipop() {
        }

        /* access modifiers changed from: private */
        @DoNotInline
        public static Drawable b(@NonNull Context context, @Px int i2) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(-1);
            gradientDrawable.setShape(1);
            return new RippleDrawable(MaterialColors.k(context, R.attr.q3, ColorStateList.valueOf(0)), (Drawable) null, new InsetDrawable(gradientDrawable, i2, i2, i2, i2));
        }
    }

    private RippleUtils() {
    }

    @NonNull
    public static ColorStateList a(@Nullable ColorStateList colorStateList) {
        if (f21729a) {
            int[] iArr = f21732d;
            return new ColorStateList(new int[][]{f21738j, iArr, StateSet.NOTHING}, new int[]{d(colorStateList, f21734f), d(colorStateList, iArr), d(colorStateList, f21730b)});
        }
        int[] iArr2 = f21734f;
        int[] iArr3 = f21735g;
        int[] iArr4 = f21736h;
        int[] iArr5 = f21737i;
        int[] iArr6 = f21730b;
        int[] iArr7 = f21731c;
        int[] iArr8 = f21732d;
        int[] iArr9 = f21733e;
        return new ColorStateList(new int[][]{iArr2, iArr3, iArr4, iArr5, f21738j, iArr6, iArr7, iArr8, iArr9, StateSet.NOTHING}, new int[]{d(colorStateList, iArr2), d(colorStateList, iArr3), d(colorStateList, iArr4), d(colorStateList, iArr5), 0, d(colorStateList, iArr6), d(colorStateList, iArr7), d(colorStateList, iArr8), d(colorStateList, iArr9), 0});
    }

    @RequiresApi(21)
    @NonNull
    public static Drawable b(@NonNull Context context, @Px int i2) {
        return RippleUtilsLollipop.b(context, i2);
    }

    @TargetApi(21)
    @ColorInt
    private static int c(@ColorInt int i2) {
        return ColorUtils.D(i2, Math.min(Color.alpha(i2) * 2, 255));
    }

    @ColorInt
    private static int d(@Nullable ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f21729a ? c(colorForState) : colorForState;
    }

    @NonNull
    public static ColorStateList e(@Nullable ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 22 && i2 <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f21739k, 0)) != 0) {
            Log.w(f21740l, f21741m);
        }
        return colorStateList;
    }

    public static boolean f(@NonNull int[] iArr) {
        boolean z = false;
        boolean z2 = false;
        for (int i2 : iArr) {
            if (i2 == 16842910) {
                z = true;
            } else if (i2 == 16842908 || i2 == 16842919 || i2 == 16843623) {
                z2 = true;
            }
        }
        return z && z2;
    }
}
