package androidx.media3.common.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.Nonnull;
import javax.annotation.meta.TypeQualifierDefault;
import javax.annotation.meta.When;

@UnstableApi
@TypeQualifierDefault({ElementType.TYPE_USE})
@Nonnull(when = When.X)
@Retention(RetentionPolicy.CLASS)
public @interface UnknownNull {
}
