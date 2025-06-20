package com.google.firebase.crashlytics.internal;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class a implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsNativeComponentDeferredProxy f23510a;

    public /* synthetic */ a(CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy) {
        this.f23510a = crashlyticsNativeComponentDeferredProxy;
    }

    public final void a(Provider provider) {
        this.f23510a.g(provider);
    }
}
