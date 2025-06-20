package com.google.android.material.color.utilities;

import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public class SchemeMonochrome extends DynamicScheme {
    public SchemeMonochrome(Hct hct, boolean z, double d2) {
        super(hct, Variant.MONOCHROME, z, d2, TonalPalette.c(hct.d(), 0.0d), TonalPalette.c(hct.d(), 0.0d), TonalPalette.c(hct.d(), 0.0d), TonalPalette.c(hct.d(), 0.0d), TonalPalette.c(hct.d(), 0.0d));
    }
}
