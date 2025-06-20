package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

public class BitmapDrawableResource extends DrawableResource<BitmapDrawable> implements Initializable {
    private final BitmapPool X;

    public BitmapDrawableResource(BitmapDrawable bitmapDrawable, BitmapPool bitmapPool) {
        super(bitmapDrawable);
        this.X = bitmapPool;
    }

    public int a() {
        return Util.h(((BitmapDrawable) this.s).getBitmap());
    }

    public void b() {
        ((BitmapDrawable) this.s).getBitmap().prepareToDraw();
    }

    @NonNull
    public Class<BitmapDrawable> c() {
        return BitmapDrawable.class;
    }

    public void recycle() {
        this.X.e(((BitmapDrawable) this.s).getBitmap());
    }
}
