package com.google.android.material.color.utilities;

import java.util.function.Function;

public final /* synthetic */ class m2 implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TemperatureCache f21315a;

    public /* synthetic */ m2(TemperatureCache temperatureCache) {
        this.f21315a = temperatureCache;
    }

    public final Object apply(Object obj) {
        return this.f21315a.l((Hct) obj);
    }
}
