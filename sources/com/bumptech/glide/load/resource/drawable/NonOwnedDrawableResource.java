package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.engine.Resource;

final class NonOwnedDrawableResource extends DrawableResource<Drawable> {
    private NonOwnedDrawableResource(Drawable drawable) {
        super(drawable);
    }

    @Nullable
    static Resource<Drawable> e(@Nullable Drawable drawable) {
        if (drawable != null) {
            return new NonOwnedDrawableResource(drawable);
        }
        return null;
    }

    public int a() {
        return Math.max(1, this.s.getIntrinsicWidth() * this.s.getIntrinsicHeight() * 4);
    }

    @NonNull
    public Class<Drawable> c() {
        return this.s.getClass();
    }

    public void recycle() {
    }
}
