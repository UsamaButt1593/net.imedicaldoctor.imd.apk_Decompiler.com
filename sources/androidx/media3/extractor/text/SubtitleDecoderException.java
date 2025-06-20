package androidx.media3.extractor.text;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderException;

@UnstableApi
public class SubtitleDecoderException extends DecoderException {
    public SubtitleDecoderException(String str) {
        super(str);
    }

    public SubtitleDecoderException(String str, @Nullable Throwable th) {
        super(str, th);
    }

    public SubtitleDecoderException(@Nullable Throwable th) {
        super(th);
    }
}
