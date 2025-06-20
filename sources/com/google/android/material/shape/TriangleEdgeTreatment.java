package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean X;
    private final float s;

    public TriangleEdgeTreatment(float f2, boolean z) {
        this.s = f2;
        this.X = z;
    }

    public void b(float f2, float f3, float f4, @NonNull ShapePath shapePath) {
        if (this.X) {
            shapePath.n(f3 - (this.s * f4), 0.0f);
            float f5 = this.s;
            shapePath.o(f3, f5 * f4, (f5 * f4) + f3, 0.0f);
            shapePath.n(f2, 0.0f);
            return;
        }
        float f6 = this.s;
        shapePath.o(f3 - (f6 * f4), 0.0f, f3, (-f6) * f4);
        shapePath.o(f3 + (this.s * f4), 0.0f, f2, 0.0f);
    }
}
