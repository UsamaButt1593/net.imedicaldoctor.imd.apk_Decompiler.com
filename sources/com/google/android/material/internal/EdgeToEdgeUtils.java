package com.google.android.material.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import com.google.android.material.color.MaterialColors;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class EdgeToEdgeUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final int f21507a = 128;

    private EdgeToEdgeUtils() {
    }

    public static void a(@NonNull Window window, boolean z) {
        b(window, z, (Integer) null, (Integer) null);
    }

    public static void b(@NonNull Window window, boolean z, @ColorInt @Nullable Integer num, @ColorInt @Nullable Integer num2) {
        boolean z2 = false;
        boolean z3 = num == null || num.intValue() == 0;
        if (num2 == null || num2.intValue() == 0) {
            z2 = true;
        }
        if (z3 || z2) {
            int b2 = MaterialColors.b(window.getContext(), 16842801, ViewCompat.y);
            if (z3) {
                num = Integer.valueOf(b2);
            }
            if (z2) {
                num2 = Integer.valueOf(b2);
            }
        }
        WindowCompat.c(window, !z);
        int d2 = d(window.getContext(), z);
        int c2 = c(window.getContext(), z);
        window.setStatusBarColor(d2);
        window.setNavigationBarColor(c2);
        g(window, e(d2, MaterialColors.q(num.intValue())));
        f(window, e(c2, MaterialColors.q(num2.intValue())));
    }

    @TargetApi(21)
    private static int c(Context context, boolean z) {
        if (z && Build.VERSION.SDK_INT < 27) {
            return ColorUtils.D(MaterialColors.b(context, 16843858, ViewCompat.y), 128);
        }
        if (z) {
            return 0;
        }
        return MaterialColors.b(context, 16843858, ViewCompat.y);
    }

    @TargetApi(21)
    private static int d(Context context, boolean z) {
        if (z && Build.VERSION.SDK_INT < 23) {
            return ColorUtils.D(MaterialColors.b(context, 16843857, ViewCompat.y), 128);
        }
        if (z) {
            return 0;
        }
        return MaterialColors.b(context, 16843857, ViewCompat.y);
    }

    private static boolean e(int i2, boolean z) {
        return MaterialColors.q(i2) || (i2 == 0 && z);
    }

    public static void f(@NonNull Window window, boolean z) {
        WindowCompat.a(window, window.getDecorView()).h(z);
    }

    public static void g(@NonNull Window window, boolean z) {
        WindowCompat.a(window, window.getDecorView()).i(z);
    }
}
