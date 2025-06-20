package androidx.media3.common;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import java.io.IOException;

@UnstableApi
public class ParserException extends IOException {
    public final int X;
    public final boolean s;

    protected ParserException(@Nullable String str, @Nullable Throwable th, boolean z, int i2) {
        super(str, th);
        this.s = z;
        this.X = i2;
    }

    public static ParserException a(@Nullable String str, @Nullable Throwable th) {
        return new ParserException(str, th, true, 1);
    }

    public static ParserException b(@Nullable String str, @Nullable Throwable th) {
        return new ParserException(str, th, true, 0);
    }

    public static ParserException c(@Nullable String str, @Nullable Throwable th) {
        return new ParserException(str, th, true, 4);
    }

    public static ParserException d(@Nullable String str, @Nullable Throwable th) {
        return new ParserException(str, th, false, 4);
    }

    public static ParserException e(@Nullable String str) {
        return new ParserException(str, (Throwable) null, false, 1);
    }

    @Nullable
    public String getMessage() {
        return super.getMessage() + "{contentIsMalformed=" + this.s + ", dataType=" + this.X + "}";
    }
}
