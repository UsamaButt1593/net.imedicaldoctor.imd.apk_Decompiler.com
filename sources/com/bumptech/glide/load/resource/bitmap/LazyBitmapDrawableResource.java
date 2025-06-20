package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;

public final class LazyBitmapDrawableResource implements Resource<BitmapDrawable>, Initializable {
    private final Resource<Bitmap> X;
    private final Resources s;

    private LazyBitmapDrawableResource(@NonNull Resources resources, @NonNull Resource<Bitmap> resource) {
        this.s = (Resources) Preconditions.d(resources);
        this.X = (Resource) Preconditions.d(resource);
    }

    @Nullable
    public static Resource<BitmapDrawable> e(@NonNull Resources resources, @Nullable Resource<Bitmap> resource) {
        if (resource == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(resources, resource);
    }

    @Deprecated
    public static LazyBitmapDrawableResource f(Context context, Bitmap bitmap) {
        return (LazyBitmapDrawableResource) e(context.getResources(), BitmapResource.e(bitmap, Glide.d(context).g()));
    }

    @Deprecated
    public static LazyBitmapDrawableResource g(Resources resources, BitmapPool bitmapPool, Bitmap bitmap) {
        return (LazyBitmapDrawableResource) e(resources, BitmapResource.e(bitmap, bitmapPool));
    }

    public int a() {
        return this.X.a();
    }

    public void b() {
        Resource<Bitmap> resource = this.X;
        if (resource instanceof Initializable) {
            ((Initializable) resource).b();
        }
    }

    @NonNull
    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }

    @NonNull
    /* renamed from: d */
    public BitmapDrawable get() {
        return new BitmapDrawable(this.s, this.X.get());
    }

    public void recycle() {
        this.X.recycle();
    }
}
