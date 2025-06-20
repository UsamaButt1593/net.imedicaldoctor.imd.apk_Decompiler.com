package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;

@Deprecated
public abstract class BaseTarget<Z> implements Target<Z> {
    private Request s;

    public void a() {
    }

    public void b() {
    }

    public void d() {
    }

    public void j(@Nullable Request request) {
        this.s = request;
    }

    public void k(@Nullable Drawable drawable) {
    }

    public void p(@Nullable Drawable drawable) {
    }

    @Nullable
    public Request q() {
        return this.s;
    }

    public void r(@Nullable Drawable drawable) {
    }
}
