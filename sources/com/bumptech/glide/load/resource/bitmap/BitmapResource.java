package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

public class BitmapResource implements Resource<Bitmap>, Initializable {
    private final BitmapPool X;
    private final Bitmap s;

    public BitmapResource(@NonNull Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        this.s = (Bitmap) Preconditions.e(bitmap, "Bitmap must not be null");
        this.X = (BitmapPool) Preconditions.e(bitmapPool, "BitmapPool must not be null");
    }

    @Nullable
    public static BitmapResource e(@Nullable Bitmap bitmap, @NonNull BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    public int a() {
        return Util.h(this.s);
    }

    public void b() {
        this.s.prepareToDraw();
    }

    @NonNull
    public Class<Bitmap> c() {
        return Bitmap.class;
    }

    @NonNull
    /* renamed from: d */
    public Bitmap get() {
        return this.s;
    }

    public void recycle() {
        this.X.e(this.s);
    }
}
