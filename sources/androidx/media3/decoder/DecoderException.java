package androidx.media3.decoder;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;

@UnstableApi
public class DecoderException extends Exception {
    public DecoderException(String str) {
        super(str);
    }

    public DecoderException(String str, @Nullable Throwable th) {
        super(str, th);
    }

    public DecoderException(@Nullable Throwable th) {
        super(th);
    }
}
