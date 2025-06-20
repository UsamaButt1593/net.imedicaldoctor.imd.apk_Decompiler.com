package com.bumptech.glide.load.resource.gif;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.resource.drawable.DrawableResource;

public class GifDrawableResource extends DrawableResource<GifDrawable> implements Initializable {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    public int a() {
        return ((GifDrawable) this.s).m();
    }

    public void b() {
        ((GifDrawable) this.s).h().prepareToDraw();
    }

    @NonNull
    public Class<GifDrawable> c() {
        return GifDrawable.class;
    }

    public void recycle() {
        ((GifDrawable) this.s).stop();
        ((GifDrawable) this.s).p();
    }
}
