package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class CutCornerTreatment extends CornerTreatment {

    /* renamed from: a  reason: collision with root package name */
    float f21795a;

    public CutCornerTreatment() {
        this.f21795a = -1.0f;
    }

    public void b(@NonNull ShapePath shapePath, float f2, float f3, float f4) {
        shapePath.r(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        double d2 = (double) f4;
        double d3 = (double) f3;
        shapePath.n((float) (Math.sin(Math.toRadians((double) f2)) * d2 * d3), (float) (Math.sin(Math.toRadians((double) (90.0f - f2))) * d2 * d3));
    }

    @Deprecated
    public CutCornerTreatment(float f2) {
        this.f21795a = f2;
    }
}
