package androidx.core.text;

import android.text.TextUtils;
import java.util.Locale;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\"\u0016\u0010\u0004\u001a\u00020\u0001*\u00020\u00008Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Ljava/util/Locale;", "", "a", "(Ljava/util/Locale;)I", "layoutDirection", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class LocaleKt {
    public static final int a(@NotNull Locale locale) {
        return TextUtils.getLayoutDirectionFromLocale(locale);
    }
}
