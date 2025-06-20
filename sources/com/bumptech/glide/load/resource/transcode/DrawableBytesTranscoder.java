package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f18405a;

    /* renamed from: b  reason: collision with root package name */
    private final ResourceTranscoder<Bitmap, byte[]> f18406b;

    /* renamed from: c  reason: collision with root package name */
    private final ResourceTranscoder<GifDrawable, byte[]> f18407c;

    public DrawableBytesTranscoder(@NonNull BitmapPool bitmapPool, @NonNull ResourceTranscoder<Bitmap, byte[]> resourceTranscoder, @NonNull ResourceTranscoder<GifDrawable, byte[]> resourceTranscoder2) {
        this.f18405a = bitmapPool;
        this.f18406b = resourceTranscoder;
        this.f18407c = resourceTranscoder2;
    }

    @NonNull
    private static Resource<GifDrawable> b(@NonNull Resource<Drawable> resource) {
        return resource;
    }

    @Nullable
    public Resource<byte[]> a(@NonNull Resource<Drawable> resource, @NonNull Options options) {
        Drawable drawable = resource.get();
        if (drawable instanceof BitmapDrawable) {
            return this.f18406b.a(BitmapResource.e(((BitmapDrawable) drawable).getBitmap(), this.f18405a), options);
        }
        if (drawable instanceof GifDrawable) {
            return this.f18407c.a(b(resource), options);
        }
        return null;
    }
}
