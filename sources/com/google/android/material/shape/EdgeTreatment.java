package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class EdgeTreatment {
    /* access modifiers changed from: package-private */
    public boolean a() {
        return false;
    }

    public void b(float f2, float f3, float f4, @NonNull ShapePath shapePath) {
        shapePath.n(f2, 0.0f);
    }

    @Deprecated
    public void c(float f2, float f3, @NonNull ShapePath shapePath) {
        b(f2, f2 / 2.0f, f3, shapePath);
    }
}
