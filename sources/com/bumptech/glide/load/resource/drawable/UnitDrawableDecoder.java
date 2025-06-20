package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;

public class UnitDrawableDecoder implements ResourceDecoder<Drawable, Drawable> {
    @Nullable
    /* renamed from: c */
    public Resource<Drawable> b(@NonNull Drawable drawable, int i2, int i3, @NonNull Options options) {
        return NonOwnedDrawableResource.e(drawable);
    }

    /* renamed from: d */
    public boolean a(@NonNull Drawable drawable, @NonNull Options options) {
        return true;
    }
}
