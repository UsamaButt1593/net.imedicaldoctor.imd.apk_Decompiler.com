package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SchemeTonalSpot extends DynamicScheme {
    public SchemeTonalSpot(Hct hct, boolean z, double d2) {
        super(hct, Variant.TONAL_SPOT, z, d2, TonalPalette.c(hct.d(), 36.0d), TonalPalette.c(hct.d(), 16.0d), TonalPalette.c(MathUtils.g(hct.d() + 60.0d), 24.0d), TonalPalette.c(hct.d(), 6.0d), TonalPalette.c(hct.d(), 8.0d));
    }
}
