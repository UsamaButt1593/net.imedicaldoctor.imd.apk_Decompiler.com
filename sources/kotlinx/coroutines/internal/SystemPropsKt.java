package kotlinx.coroutines.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"kotlinx/coroutines/internal/SystemPropsKt__SystemPropsKt", "kotlinx/coroutines/internal/SystemPropsKt__SystemProps_commonKt"}, k = 4, mv = {1, 6, 0}, xi = 48)
public final class SystemPropsKt {
    public static final int a() {
        return SystemPropsKt__SystemPropsKt.a();
    }

    public static final int b(@NotNull String str, int i2, int i3, int i4) {
        return SystemPropsKt__SystemProps_commonKt.a(str, i2, i3, i4);
    }

    public static final long c(@NotNull String str, long j2, long j3, long j4) {
        return SystemPropsKt__SystemProps_commonKt.b(str, j2, j3, j4);
    }

    @Nullable
    public static final String d(@NotNull String str) {
        return SystemPropsKt__SystemPropsKt.b(str);
    }

    public static final boolean e(@NotNull String str, boolean z) {
        return SystemPropsKt__SystemProps_commonKt.c(str, z);
    }
}
