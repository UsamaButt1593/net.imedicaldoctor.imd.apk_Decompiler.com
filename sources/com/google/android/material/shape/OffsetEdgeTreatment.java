package com.google.android.material.shape;

import androidx.annotation.NonNull;

public final class OffsetEdgeTreatment extends EdgeTreatment {
    private final float X;
    private final EdgeTreatment s;

    public OffsetEdgeTreatment(@NonNull EdgeTreatment edgeTreatment, float f2) {
        this.s = edgeTreatment;
        this.X = f2;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.s.a();
    }

    public void b(float f2, float f3, float f4, @NonNull ShapePath shapePath) {
        this.s.b(f2, f3 - this.X, f4, shapePath);
    }
}
