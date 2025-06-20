package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.util.Util;

public abstract class CustomTarget<T> implements Target<T> {
    private final int X;
    @Nullable
    private Request Y;
    private final int s;

    public CustomTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public void a() {
    }

    public void b() {
    }

    public final void c(@NonNull SizeReadyCallback sizeReadyCallback) {
    }

    public void d() {
    }

    public final void j(@Nullable Request request) {
        this.Y = request;
    }

    public void k(@Nullable Drawable drawable) {
    }

    public void p(@Nullable Drawable drawable) {
    }

    @Nullable
    public final Request q() {
        return this.Y;
    }

    public final void s(@NonNull SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.e(this.s, this.X);
    }

    public CustomTarget(int i2, int i3) {
        if (Util.v(i2, i3)) {
            this.s = i2;
            this.X = i3;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i2 + " and height: " + i3);
    }
}
