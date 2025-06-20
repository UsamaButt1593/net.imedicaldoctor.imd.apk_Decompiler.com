package com.google.android.material.shape;

import android.graphics.RectF;
import androidx.annotation.NonNull;

public class CornerTreatment {
    @Deprecated
    public void a(float f2, float f3, @NonNull ShapePath shapePath) {
    }

    public void b(@NonNull ShapePath shapePath, float f2, float f3, float f4) {
        a(f2, f3, shapePath);
    }

    public void c(@NonNull ShapePath shapePath, float f2, float f3, @NonNull RectF rectF, @NonNull CornerSize cornerSize) {
        b(shapePath, f2, f3, cornerSize.a(rectF));
    }
}
