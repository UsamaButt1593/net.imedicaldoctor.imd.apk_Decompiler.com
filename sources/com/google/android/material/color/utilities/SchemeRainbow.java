package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SchemeRainbow extends DynamicScheme {
    public SchemeRainbow(Hct hct, boolean z, double d2) {
        super(hct, Variant.RAINBOW, z, d2, TonalPalette.c(hct.d(), 48.0d), TonalPalette.c(hct.d(), 16.0d), TonalPalette.c(MathUtils.g(hct.d() + 60.0d), 24.0d), TonalPalette.c(hct.d(), 0.0d), TonalPalette.c(hct.d(), 0.0d));
    }
}
