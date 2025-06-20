package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f18232a;

    /* renamed from: b  reason: collision with root package name */
    private final ResourceEncoder<Bitmap> f18233b;

    public BitmapDrawableEncoder(BitmapPool bitmapPool, ResourceEncoder<Bitmap> resourceEncoder) {
        this.f18232a = bitmapPool;
        this.f18233b = resourceEncoder;
    }

    @NonNull
    public EncodeStrategy b(@NonNull Options options) {
        return this.f18233b.b(options);
    }

    /* renamed from: c */
    public boolean a(@NonNull Resource<BitmapDrawable> resource, @NonNull File file, @NonNull Options options) {
        return this.f18233b.a(new BitmapResource(resource.get().getBitmap(), this.f18232a), file, options);
    }
}
