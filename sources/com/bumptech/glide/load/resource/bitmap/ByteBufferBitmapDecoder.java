package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferBitmapDecoder implements ResourceDecoder<ByteBuffer, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Downsampler f18241a;

    public ByteBufferBitmapDecoder(Downsampler downsampler) {
        this.f18241a = downsampler;
    }

    /* renamed from: c */
    public Resource<Bitmap> b(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull Options options) throws IOException {
        return this.f18241a.f(ByteBufferUtil.f(byteBuffer), i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull Options options) {
        return this.f18241a.q(byteBuffer);
    }
}
