package androidx.media3.ui;

import android.graphics.Color;
import androidx.annotation.ColorInt;
import androidx.media3.common.util.Util;

final class HtmlUtils {
    private HtmlUtils() {
    }

    public static String a(String str) {
        return "." + str + ",." + str + " *";
    }

    public static String b(@ColorInt int i2) {
        return Util.S("rgba(%d,%d,%d,%.3f)", Integer.valueOf(Color.red(i2)), Integer.valueOf(Color.green(i2)), Integer.valueOf(Color.blue(i2)), Double.valueOf(((double) Color.alpha(i2)) / 255.0d));
    }
}
