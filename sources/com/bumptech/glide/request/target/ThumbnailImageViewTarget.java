package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;

public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
    public ThumbnailImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* access modifiers changed from: protected */
    public abstract Drawable A(T t);

    /* access modifiers changed from: protected */
    public void y(@Nullable T t) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.X).getLayoutParams();
        Drawable A = A(t);
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            A = new FixedSizeDrawable(A, layoutParams.width, layoutParams.height);
        }
        ((ImageView) this.X).setImageDrawable(A);
    }

    @Deprecated
    public ThumbnailImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
