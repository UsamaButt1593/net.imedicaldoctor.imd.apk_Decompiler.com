package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import java.util.Arrays;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class AdjustedCornerSize implements CornerSize {

    /* renamed from: a  reason: collision with root package name */
    private final CornerSize f21792a;

    /* renamed from: b  reason: collision with root package name */
    private final float f21793b;

    public AdjustedCornerSize(float f2, @NonNull CornerSize cornerSize) {
        while (cornerSize instanceof AdjustedCornerSize) {
            cornerSize = ((AdjustedCornerSize) cornerSize).f21792a;
            f2 += ((AdjustedCornerSize) cornerSize).f21793b;
        }
        this.f21792a = cornerSize;
        this.f21793b = f2;
    }

    public float a(@NonNull RectF rectF) {
        return Math.max(0.0f, this.f21792a.a(rectF) + this.f21793b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdjustedCornerSize)) {
            return false;
        }
        AdjustedCornerSize adjustedCornerSize = (AdjustedCornerSize) obj;
        return this.f21792a.equals(adjustedCornerSize.f21792a) && this.f21793b == adjustedCornerSize.f21793b;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f21792a, Float.valueOf(this.f21793b)});
    }
}
