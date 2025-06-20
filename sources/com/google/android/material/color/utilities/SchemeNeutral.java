package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SchemeNeutral extends DynamicScheme {
    public SchemeNeutral(Hct hct, boolean z, double d2) {
        super(hct, Variant.NEUTRAL, z, d2, TonalPalette.c(hct.d(), 12.0d), TonalPalette.c(hct.d(), 8.0d), TonalPalette.c(hct.d(), 16.0d), TonalPalette.c(hct.d(), 2.0d), TonalPalette.c(hct.d(), 2.0d));
    }
}
