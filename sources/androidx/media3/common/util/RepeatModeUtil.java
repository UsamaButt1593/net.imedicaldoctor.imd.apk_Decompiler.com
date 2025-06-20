package androidx.media3.common.util;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class RepeatModeUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9617a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f9618b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f9619c = 2;

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RepeatToggleModes {
    }

    private RepeatModeUtil() {
    }

    public static int a(int i2, int i3) {
        for (int i4 = 1; i4 <= 2; i4++) {
            int i5 = (i2 + i4) % 3;
            if (b(i5, i3)) {
                return i5;
            }
        }
        return i2;
    }

    public static boolean b(int i2, int i3) {
        if (i2 != 0) {
            return i2 != 1 ? i2 == 2 && (i3 & 2) != 0 : (i3 & 1) != 0;
        }
        return true;
    }
}
