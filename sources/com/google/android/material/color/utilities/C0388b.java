package com.google.android.material.color.utilities;

import java.util.function.Function;

/* renamed from: com.google.android.material.color.utilities.b  reason: case insensitive filesystem */
public final /* synthetic */ class C0388b implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TonalPalette f21303a;

    public /* synthetic */ C0388b(TonalPalette tonalPalette) {
        this.f21303a = tonalPalette;
    }

    public final Object apply(Object obj) {
        return DynamicColor.k(this.f21303a, (DynamicScheme) obj);
    }
}
