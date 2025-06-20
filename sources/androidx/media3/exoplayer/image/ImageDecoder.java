package androidx.media3.exoplayer.image;

import androidx.annotation.Nullable;
import androidx.media3.common.Format;
import androidx.media3.common.util.UnstableApi;
import androidx.media3.decoder.Decoder;
import androidx.media3.decoder.DecoderException;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.image.BitmapFactoryImageDecoder;

@UnstableApi
public interface ImageDecoder extends Decoder<DecoderInputBuffer, ImageOutputBuffer, ImageDecoderException> {

    public interface Factory {

        /* renamed from: a  reason: collision with root package name */
        public static final Factory f11620a = new BitmapFactoryImageDecoder.Factory();

        ImageDecoder a();

        int b(Format format);
    }

    @Nullable
    ImageOutputBuffer b() throws ImageDecoderException;

    @Nullable
    /* bridge */ /* synthetic */ Object b() throws DecoderException;

    /* bridge */ /* synthetic */ void c(Object obj) throws DecoderException;

    void g(DecoderInputBuffer decoderInputBuffer) throws ImageDecoderException;
}
