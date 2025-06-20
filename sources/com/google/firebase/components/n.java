package com.google.firebase.components;

import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class n implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRegistrar f23438a;

    public /* synthetic */ n(ComponentRegistrar componentRegistrar) {
        this.f23438a = componentRegistrar;
    }

    public final Object get() {
        return ComponentRuntime.Builder.f(this.f23438a);
    }
}
