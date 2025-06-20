package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.ByteBufferUtil;
import java.io.IOException;
import java.io.InputStream;

@RequiresApi(api = 28)
public final class InputStreamBitmapImageDecoderResourceDecoder implements ResourceDecoder<InputStream, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapImageDecoderResourceDecoder f18319a = new BitmapImageDecoderResourceDecoder();

    @Nullable
    /* renamed from: c */
    public Resource<Bitmap> b(@NonNull InputStream inputStream, int i2, int i3, @NonNull Options options) throws IOException {
        return this.f18319a.d(ImageDecoder.createSource(ByteBufferUtil.b(inputStream)), i2, i3, options);
    }

    /* renamed from: d */
    public boolean a(@NonNull InputStream inputStream, @NonNull Options options) throws IOException {
        return true;
    }
}
