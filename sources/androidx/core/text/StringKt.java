package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u001a\u0014\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\b¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"", "a", "(Ljava/lang/String;)Ljava/lang/String;", "core-ktx_release"}, k = 2, mv = {1, 8, 0})
public final class StringKt {
    @NotNull
    public static final String a(@NotNull String str) {
        return TextUtils.htmlEncode(str);
    }
}
