package androidx.media3.exoplayer.drm;

import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class UnsupportedDrmException extends Exception {
    public static final int X = 1;
    public static final int Y = 2;
    public final int s;

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Reason {
    }

    public UnsupportedDrmException(int i2) {
        this.s = i2;
    }

    public UnsupportedDrmException(int i2, Exception exc) {
        super(exc);
        this.s = i2;
    }
}
