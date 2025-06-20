package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

public final class GifFrameResourceDecoder implements ResourceDecoder<GifDecoder, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f18395a;

    public GifFrameResourceDecoder(BitmapPool bitmapPool) {
        this.f18395a = bitmapPool;
    }

    /* renamed from: c */
    public Resource<Bitmap> b(@NonNull GifDecoder gifDecoder, int i2, int i3, @NonNull Options options) {
        return BitmapResource.e(gifDecoder.f(), this.f18395a);
    }

    /* renamed from: d */
    public boolean a(@NonNull GifDecoder gifDecoder, @NonNull Options options) {
        return true;
    }
}
