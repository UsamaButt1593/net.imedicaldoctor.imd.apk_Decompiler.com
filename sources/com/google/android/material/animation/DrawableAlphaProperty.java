package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.WeakHashMap;

public class DrawableAlphaProperty extends Property<Drawable, Integer> {

    /* renamed from: b  reason: collision with root package name */
    public static final Property<Drawable, Integer> f20773b = new DrawableAlphaProperty();

    /* renamed from: a  reason: collision with root package name */
    private final WeakHashMap<Drawable, Integer> f20774a = new WeakHashMap<>();

    private DrawableAlphaProperty() {
        super(Integer.class, "drawableAlphaCompat");
    }

    @Nullable
    /* renamed from: a */
    public Integer get(@NonNull Drawable drawable) {
        return Integer.valueOf(drawable.getAlpha());
    }

    /* renamed from: b */
    public void set(@NonNull Drawable drawable, @NonNull Integer num) {
        drawable.setAlpha(num.intValue());
    }
}
