package com.google.android.material.sidesheet;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
final class SheetUtils {
    private SheetUtils() {
    }

    static boolean a(float f2, float f3) {
        return Math.abs(f2) > Math.abs(f3);
    }
}
