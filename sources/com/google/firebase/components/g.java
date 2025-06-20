package com.google.firebase.components;

import com.google.firebase.inject.Provider;

public final /* synthetic */ class g implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f23434a;

    public /* synthetic */ g(String str) {
        this.f23434a = str;
    }

    public final Object get() {
        return ComponentDiscovery.e(this.f23434a);
    }
}
