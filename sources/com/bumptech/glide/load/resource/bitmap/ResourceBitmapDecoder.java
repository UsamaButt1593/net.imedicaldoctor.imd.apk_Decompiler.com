package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;

public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final ResourceDrawableDecoder f18321a;

    /* renamed from: b  reason: collision with root package name */
    private final BitmapPool f18322b;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool) {
        this.f18321a = resourceDrawableDecoder;
        this.f18322b = bitmapPool;
    }

    @Nullable
    /* renamed from: c */
    public Resource<Bitmap> b(@NonNull Uri uri, int i2, int i3, @NonNull Options options) {
        Resource<Drawable> c2 = this.f18321a.b(uri, i2, i3, options);
        if (c2 == null) {
            return null;
        }
        return DrawableToBitmapConverter.a(this.f18322b, c2.get(), i2, i3);
    }

    /* renamed from: d */
    public boolean a(@NonNull Uri uri, @NonNull Options options) {
        return "android.resource".equals(uri.getScheme());
    }
}
