package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ClampedCornerSize implements CornerSize {

    /* renamed from: a  reason: collision with root package name */
    private final float f21794a;

    public ClampedCornerSize(float f2) {
        this.f21794a = f2;
    }

    @NonNull
    public static ClampedCornerSize b(@NonNull AbsoluteCornerSize absoluteCornerSize) {
        return new ClampedCornerSize(absoluteCornerSize.b());
    }

    private static float c(@NonNull RectF rectF) {
        return Math.min(rectF.width() / 2.0f, rectF.height() / 2.0f);
    }

    public float a(@NonNull RectF rectF) {
        return Math.min(this.f21794a, c(rectF));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ClampedCornerSize) && this.f21794a == ((ClampedCornerSize) obj).f21794a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f21794a)});
    }
}
