package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SchemeFruitSalad extends DynamicScheme {
    public SchemeFruitSalad(Hct hct, boolean z, double d2) {
        super(hct, Variant.FRUIT_SALAD, z, d2, TonalPalette.c(MathUtils.g(hct.d() - 50.0d), 48.0d), TonalPalette.c(MathUtils.g(hct.d() - 50.0d), 36.0d), TonalPalette.c(hct.d(), 36.0d), TonalPalette.c(hct.d(), 10.0d), TonalPalette.c(hct.d(), 16.0d));
    }
}
