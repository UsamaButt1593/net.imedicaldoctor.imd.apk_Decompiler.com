package androidx.core.view;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

@Deprecated
public final class MarginLayoutParamsCompat {
    private MarginLayoutParamsCompat() {
    }

    @Deprecated
    public static int a(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        int layoutDirection = marginLayoutParams.getLayoutDirection();
        if (layoutDirection == 0 || layoutDirection == 1) {
            return layoutDirection;
        }
        return 0;
    }

    @Deprecated
    public static int b(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginEnd();
    }

    @Deprecated
    public static int c(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.getMarginStart();
    }

    @Deprecated
    public static boolean d(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return marginLayoutParams.isMarginRelative();
    }

    @Deprecated
    public static void e(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
        marginLayoutParams.resolveLayoutDirection(i2);
    }

    @Deprecated
    public static void f(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
        marginLayoutParams.setLayoutDirection(i2);
    }

    @Deprecated
    public static void g(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
        marginLayoutParams.setMarginEnd(i2);
    }

    @Deprecated
    public static void h(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i2) {
        marginLayoutParams.setMarginStart(i2);
    }
}
