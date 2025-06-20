package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;

public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {
    @Nullable
    private Animatable c3;

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    private void x(@Nullable Z z) {
        if (z instanceof Animatable) {
            Animatable animatable = (Animatable) z;
            this.c3 = animatable;
            animatable.start();
            return;
        }
        this.c3 = null;
    }

    private void z(@Nullable Z z) {
        y(z);
        x(z);
    }

    public void a() {
        Animatable animatable = this.c3;
        if (animatable != null) {
            animatable.start();
        }
    }

    public void d() {
        Animatable animatable = this.c3;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public void e(@NonNull Z z, @Nullable Transition<? super Z> transition) {
        if (transition == null || !transition.a(z, this)) {
            z(z);
        } else {
            x(z);
        }
    }

    public void f(Drawable drawable) {
        ((ImageView) this.X).setImageDrawable(drawable);
    }

    @Nullable
    public Drawable h() {
        return ((ImageView) this.X).getDrawable();
    }

    public void k(@Nullable Drawable drawable) {
        super.k(drawable);
        z((Object) null);
        f(drawable);
    }

    public void p(@Nullable Drawable drawable) {
        super.p(drawable);
        z((Object) null);
        f(drawable);
    }

    public void r(@Nullable Drawable drawable) {
        super.r(drawable);
        Animatable animatable = this.c3;
        if (animatable != null) {
            animatable.stop();
        }
        z((Object) null);
        f(drawable);
    }

    /* access modifiers changed from: protected */
    public abstract void y(@Nullable Z z);

    @Deprecated
    public ImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
