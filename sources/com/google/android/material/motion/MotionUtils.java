package com.google.android.material.motion;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.TypedValue;
import android.view.animation.AnimationUtils;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.core.graphics.PathParser;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.google.android.material.resources.MaterialAttributes;

public class MotionUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21620a = "cubic-bezier";

    /* renamed from: b  reason: collision with root package name */
    private static final String f21621b = "path";

    /* renamed from: c  reason: collision with root package name */
    private static final String f21622c = "(";

    /* renamed from: d  reason: collision with root package name */
    private static final String f21623d = ")";

    private MotionUtils() {
    }

    private static float a(String[] strArr, int i2) {
        float parseFloat = Float.parseFloat(strArr[i2]);
        if (parseFloat >= 0.0f && parseFloat <= 1.0f) {
            return parseFloat;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + parseFloat);
    }

    private static String b(String str, String str2) {
        return str.substring(str2.length() + 1, str.length() - 1);
    }

    private static TimeInterpolator c(String str) {
        if (e(str, f21620a)) {
            String[] split = b(str, f21620a).split(",");
            if (split.length == 4) {
                return PathInterpolatorCompat.b(a(split, 0), a(split, 1), a(split, 2), a(split, 3));
            }
            throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + split.length);
        } else if (e(str, "path")) {
            return PathInterpolatorCompat.c(PathParser.e(b(str, "path")));
        } else {
            throw new IllegalArgumentException("Invalid motion easing type: " + str);
        }
    }

    private static boolean d(String str) {
        return e(str, f21620a) || e(str, "path");
    }

    private static boolean e(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append(f21622c);
        return str.startsWith(sb.toString()) && str.endsWith(f21623d);
    }

    public static int f(@NonNull Context context, @AttrRes int i2, int i3) {
        return MaterialAttributes.e(context, i2, i3);
    }

    @NonNull
    public static TimeInterpolator g(@NonNull Context context, @AttrRes int i2, @NonNull TimeInterpolator timeInterpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i2, typedValue, true)) {
            return timeInterpolator;
        }
        if (typedValue.type == 3) {
            String valueOf = String.valueOf(typedValue.string);
            return d(valueOf) ? c(valueOf) : AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
    }
}
