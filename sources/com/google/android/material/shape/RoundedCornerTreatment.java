package com.google.android.material.shape;

import androidx.annotation.NonNull;

public class RoundedCornerTreatment extends CornerTreatment {

    /* renamed from: a  reason: collision with root package name */
    float f21821a;

    public RoundedCornerTreatment() {
        this.f21821a = -1.0f;
    }

    public void b(@NonNull ShapePath shapePath, float f2, float f3, float f4) {
        shapePath.r(0.0f, f4 * f3, 180.0f, 180.0f - f2);
        float f5 = f4 * 2.0f * f3;
        shapePath.a(0.0f, 0.0f, f5, f5, 180.0f, f2);
    }

    @Deprecated
    public RoundedCornerTreatment(float f2) {
        this.f21821a = f2;
    }
}
