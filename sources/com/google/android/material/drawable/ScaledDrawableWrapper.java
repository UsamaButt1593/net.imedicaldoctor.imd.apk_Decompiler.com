package com.google.android.material.drawable;

import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.DrawableWrapperCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class ScaledDrawableWrapper extends DrawableWrapperCompat {
    private final int X;
    private final int Y;

    public ScaledDrawableWrapper(@NonNull Drawable drawable, int i2, int i3) {
        super(drawable);
        this.X = i2;
        this.Y = i3;
    }

    public int getIntrinsicHeight() {
        return this.Y;
    }

    public int getIntrinsicWidth() {
        return this.X;
    }
}
