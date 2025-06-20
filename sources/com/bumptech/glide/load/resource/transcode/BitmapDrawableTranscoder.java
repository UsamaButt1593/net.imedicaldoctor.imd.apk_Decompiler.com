package com.bumptech.glide.load.resource.transcode;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.LazyBitmapDrawableResource;
import com.bumptech.glide.util.Preconditions;

public class BitmapDrawableTranscoder implements ResourceTranscoder<Bitmap, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f18404a;

    public BitmapDrawableTranscoder(@NonNull Context context) {
        this(context.getResources());
    }

    @Nullable
    public Resource<BitmapDrawable> a(@NonNull Resource<Bitmap> resource, @NonNull Options options) {
        return LazyBitmapDrawableResource.e(this.f18404a, resource);
    }

    public BitmapDrawableTranscoder(@NonNull Resources resources) {
        this.f18404a = (Resources) Preconditions.d(resources);
    }

    @Deprecated
    public BitmapDrawableTranscoder(@NonNull Resources resources, BitmapPool bitmapPool) {
        this(resources);
    }
}
