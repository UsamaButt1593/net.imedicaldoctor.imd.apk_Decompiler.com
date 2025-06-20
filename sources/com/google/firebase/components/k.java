package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class k implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRuntime f23436a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Component f23437b;

    public /* synthetic */ k(ComponentRuntime componentRuntime, Component component) {
        this.f23436a = componentRuntime;
        this.f23437b = component;
    }

    public final Object get() {
        return this.f23436a.w(this.f23437b);
    }
}
