package androidx.core.text;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

public final class TextUtilsCompat {
    private TextUtilsCompat() {
    }

    public static int a(@Nullable Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }

    @NonNull
    public static String b(@NonNull String str) {
        return TextUtils.htmlEncode(str);
    }
}
