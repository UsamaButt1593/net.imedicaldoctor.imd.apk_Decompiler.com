package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import java.io.IOException;

public class BitmapDrawableDecoder<DataType> implements ResourceDecoder<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final ResourceDecoder<DataType, Bitmap> f18230a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f18231b;

    public BitmapDrawableDecoder(Context context, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this(context.getResources(), resourceDecoder);
    }

    public boolean a(@NonNull DataType datatype, @NonNull Options options) throws IOException {
        return this.f18230a.a(datatype, options);
    }

    public Resource<BitmapDrawable> b(@NonNull DataType datatype, int i2, int i3, @NonNull Options options) throws IOException {
        return LazyBitmapDrawableResource.e(this.f18231b, this.f18230a.b(datatype, i2, i3, options));
    }

    public BitmapDrawableDecoder(@NonNull Resources resources, @NonNull ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this.f18231b = (Resources) Preconditions.d(resources);
        this.f18230a = (ResourceDecoder) Preconditions.d(resourceDecoder);
    }

    @Deprecated
    public BitmapDrawableDecoder(Resources resources, BitmapPool bitmapPool, ResourceDecoder<DataType, Bitmap> resourceDecoder) {
        this(resources, resourceDecoder);
    }
}
