package com.google.firebase.crashlytics;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final /* synthetic */ class d implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsRegistrar f23490a;

    public /* synthetic */ d(CrashlyticsRegistrar crashlyticsRegistrar) {
        this.f23490a = crashlyticsRegistrar;
    }

    public final Object a(ComponentContainer componentContainer) {
        return this.f23490a.b(componentContainer);
    }
}
