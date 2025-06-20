package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;
import java.nio.ByteBuffer;

@RequiresApi(api = 28)
public final class ByteBufferBitmapImageDecoderResourceDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapImageDecoderResourceDecoder f18242a = new BitmapImageDecoderResourceDecoder();

    @Nullable
    /* renamed from: c */
    public Resource<Bitmap> b(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull Options options) throws IOException {
        return this.f18242a.d(ImageDecoder.createSource(byteBuffer), i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull Options options) throws IOException {
        return true;
    }
}
