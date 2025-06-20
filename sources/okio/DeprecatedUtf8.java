package okio;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lokio/-DeprecatedUtf8;", "", "<init>", "()V", "", "string", "", "a", "(Ljava/lang/String;)J", "", "beginIndex", "endIndex", "b", "(Ljava/lang/String;II)J", "okio"}, k = 1, mv = {1, 5, 1})
@Deprecated(message = "changed in Okio 2.x")
/* renamed from: okio.-DeprecatedUtf8  reason: invalid class name */
public final class DeprecatedUtf8 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final DeprecatedUtf8 f31339a = new DeprecatedUtf8();

    private DeprecatedUtf8() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.utf8Size()", imports = {"okio.utf8Size"}))
    public final long a(@NotNull String str) {
        Intrinsics.p(str, TypedValues.Custom.f3952e);
        return Utf8.l(str, 0, 0, 3, (Object) null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "string.utf8Size(beginIndex, endIndex)", imports = {"okio.utf8Size"}))
    public final long b(@NotNull String str, int i2, int i3) {
        Intrinsics.p(str, TypedValues.Custom.f3952e);
        return Utf8.k(str, i2, i3);
    }
}
