package com.bumptech.glide.load.resource.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.Preconditions;

public abstract class DrawableResource<T extends Drawable> implements Resource<T>, Initializable {
    protected final T s;

    public DrawableResource(T t) {
        this.s = (Drawable) Preconditions.d(t);
    }

    public void b() {
        Bitmap h2;
        T t = this.s;
        if (t instanceof BitmapDrawable) {
            h2 = ((BitmapDrawable) t).getBitmap();
        } else if (t instanceof GifDrawable) {
            h2 = ((GifDrawable) t).h();
        } else {
            return;
        }
        h2.prepareToDraw();
    }

    @NonNull
    /* renamed from: d */
    public final T get() {
        Drawable.ConstantState constantState = this.s.getConstantState();
        return constantState == null ? this.s : constantState.newDrawable();
    }
}
