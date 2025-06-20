package androidx.core.net;

import androidx.annotation.NonNull;

public class ParseException extends RuntimeException {
    @NonNull
    public final String s;

    ParseException(@NonNull String str) {
        super(str);
        this.s = str;
    }
}
