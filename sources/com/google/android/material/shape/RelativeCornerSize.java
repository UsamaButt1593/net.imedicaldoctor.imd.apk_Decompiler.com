package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

public final class RelativeCornerSize implements CornerSize {

    /* renamed from: a  reason: collision with root package name */
    private final float f21820a;

    public RelativeCornerSize(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f21820a = f2;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static RelativeCornerSize b(@NonNull RectF rectF, @NonNull CornerSize cornerSize) {
        return cornerSize instanceof RelativeCornerSize ? (RelativeCornerSize) cornerSize : new RelativeCornerSize(cornerSize.a(rectF) / c(rectF));
    }

    private static float c(@NonNull RectF rectF) {
        return Math.min(rectF.width(), rectF.height());
    }

    public float a(@NonNull RectF rectF) {
        return this.f21820a * c(rectF);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float d() {
        return this.f21820a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RelativeCornerSize) && this.f21820a == ((RelativeCornerSize) obj).f21820a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f21820a)});
    }
}
