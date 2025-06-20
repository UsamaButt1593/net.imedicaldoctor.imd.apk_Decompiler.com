package com.google.android.material.shape;

import androidx.annotation.NonNull;

public final class MarkerEdgeTreatment extends EdgeTreatment {
    private final float s;

    public MarkerEdgeTreatment(float f2) {
        this.s = f2 - 0.001f;
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return true;
    }

    public void b(float f2, float f3, float f4, @NonNull ShapePath shapePath) {
        float sqrt = (float) ((((double) this.s) * Math.sqrt(2.0d)) / 2.0d);
        float sqrt2 = (float) Math.sqrt(Math.pow((double) this.s, 2.0d) - Math.pow((double) sqrt, 2.0d));
        shapePath.q(f3 - sqrt, ((float) (-((((double) this.s) * Math.sqrt(2.0d)) - ((double) this.s)))) + sqrt2);
        shapePath.n(f3, (float) (-((((double) this.s) * Math.sqrt(2.0d)) - ((double) this.s))));
        shapePath.n(f3 + sqrt, ((float) (-((((double) this.s) * Math.sqrt(2.0d)) - ((double) this.s)))) + sqrt2);
    }
}
