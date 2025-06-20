package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a3\u0010\t\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\t\u0010\n\u001a3\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u000b2\b\b\u0002\u0010\u0007\u001a\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", "propertyName", "", "defaultValue", "c", "(Ljava/lang/String;Z)Z", "", "minValue", "maxValue", "a", "(Ljava/lang/String;III)I", "", "b", "(Ljava/lang/String;JJJ)J", "kotlinx-coroutines-core"}, k = 5, mv = {1, 6, 0}, xs = "kotlinx/coroutines/internal/SystemPropsKt")
final /* synthetic */ class SystemPropsKt__SystemProps_commonKt {
    public static final int a(@NotNull String str, int i2, int i3, int i4) {
        return (int) SystemPropsKt.c(str, (long) i2, (long) i3, (long) i4);
    }

    public static final long b(@NotNull String str, long j2, long j3, long j4) {
        String d2 = SystemPropsKt.d(str);
        if (d2 == null) {
            return j2;
        }
        Long Z0 = StringsKt.Z0(d2);
        if (Z0 != null) {
            long longValue = Z0.longValue();
            if (j3 <= longValue && longValue <= j4) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j3 + ".." + j4 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + d2 + '\'').toString());
    }

    public static final boolean c(@NotNull String str, boolean z) {
        String d2 = SystemPropsKt.d(str);
        return d2 != null ? Boolean.parseBoolean(d2) : z;
    }

    public static /* synthetic */ int d(String str, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i3 = 1;
        }
        if ((i5 & 8) != 0) {
            i4 = Integer.MAX_VALUE;
        }
        return SystemPropsKt.b(str, i2, i3, i4);
    }

    public static /* synthetic */ long e(String str, long j2, long j3, long j4, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            j3 = 1;
        }
        long j5 = j3;
        if ((i2 & 8) != 0) {
            j4 = Long.MAX_VALUE;
        }
        return SystemPropsKt.c(str, j2, j5, j4);
    }
}
