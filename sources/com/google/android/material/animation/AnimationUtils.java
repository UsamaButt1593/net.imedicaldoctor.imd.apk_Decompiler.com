package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class AnimationUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final TimeInterpolator f20766a = new LinearInterpolator();

    /* renamed from: b  reason: collision with root package name */
    public static final TimeInterpolator f20767b = new FastOutSlowInInterpolator();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f20768c = new FastOutLinearInInterpolator();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f20769d = new LinearOutSlowInInterpolator();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f20770e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static float b(float f2, float f3, float f4, float f5, float f6) {
        if (f6 <= f4) {
            return f2;
        }
        return f6 >= f5 ? f3 : a(f2, f3, (f6 - f4) / (f5 - f4));
    }

    public static int c(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * ((float) (i3 - i2)));
    }
}
