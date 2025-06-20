package androidx.media3.exoplayer.image;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderException;

@UnstableApi
public final class ImageDecoderException extends DecoderException {
    public ImageDecoderException(String str) {
        super(str);
    }

    public ImageDecoderException(String str, @Nullable Throwable th) {
        super(str, th);
    }

    public ImageDecoderException(@Nullable Throwable th) {
        super(th);
    }
}
