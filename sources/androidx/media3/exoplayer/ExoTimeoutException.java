package androidx.media3.exoplayer;

import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class ExoTimeoutException extends RuntimeException {
    public static final int X = 0;
    public static final int X2 = 3;
    public static final int Y = 1;
    public static final int Z = 2;
    public final int s;

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface TimeoutOperation {
    }

    public ExoTimeoutException(int i2) {
        super(a(i2));
        this.s = i2;
    }

    private static String a(int i2) {
        if (i2 == 1) {
            return "Player release timed out.";
        }
        if (i2 != 2) {
            return i2 != 3 ? "Undefined timeout." : "Detaching surface timed out.";
        }
        return "Setting foreground mode timed out.";
    }
}
