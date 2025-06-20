package com.google.android.material.color.utilities;

import java.util.function.Function;

public final /* synthetic */ class Z implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MaterialDynamicColors f21301a;

    public /* synthetic */ Z(MaterialDynamicColors materialDynamicColors) {
        this.f21301a = materialDynamicColors;
    }

    public final Object apply(Object obj) {
        return this.f21301a.c3((DynamicScheme) obj);
    }
}
