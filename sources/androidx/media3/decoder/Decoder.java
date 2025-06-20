package androidx.media3.decoder;

import androidx.annotation.Nullable;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.DecoderException;

@UnstableApi
public interface Decoder<I, O, E extends DecoderException> {
    void a();

    @Nullable
    O b() throws DecoderException;

    void c(I i2) throws DecoderException;

    void d(long j2);

    @Nullable
    I f() throws DecoderException;

    void flush();

    String getName();
}
