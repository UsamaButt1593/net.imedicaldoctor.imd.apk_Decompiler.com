package androidx.media3.common.text;

import androidx.media3.common.util.UnstableApi;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@UnstableApi
public final class TextAnnotation {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9480a = -1;

    /* renamed from: b  reason: collision with root package name */
    public static final int f9481b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f9482c = 2;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Position {
    }

    private TextAnnotation() {
    }
}
