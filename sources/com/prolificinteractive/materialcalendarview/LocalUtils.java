package com.prolificinteractive.materialcalendarview;

import androidx.core.text.TextUtilsCompat;
import java.util.Locale;

class LocalUtils {
    private LocalUtils() {
    }

    static boolean a() {
        return TextUtilsCompat.a(Locale.getDefault()) == 1;
    }
}
