package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Arrays;

public final class AbsoluteCornerSize implements CornerSize {

    /* renamed from: a  reason: collision with root package name */
    private final float f21791a;

    public AbsoluteCornerSize(float f2) {
        this.f21791a = f2;
    }

    public float a(@NonNull RectF rectF) {
        return this.f21791a;
    }

    public float b() {
        return this.f21791a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbsoluteCornerSize) && this.f21791a == ((AbsoluteCornerSize) obj).f21791a;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.f21791a)});
    }
}
