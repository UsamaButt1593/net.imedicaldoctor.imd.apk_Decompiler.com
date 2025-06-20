package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class i implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRegistrar f23435a;

    public /* synthetic */ i(ComponentRegistrar componentRegistrar) {
        this.f23435a = componentRegistrar;
    }

    public final Object get() {
        return ComponentRuntime.z(this.f23435a);
    }
}
