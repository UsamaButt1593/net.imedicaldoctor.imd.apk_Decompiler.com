package com.google.firebase.crashlytics.internal;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class d implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsRemoteConfigListener f23694a;

    public /* synthetic */ d(CrashlyticsRemoteConfigListener crashlyticsRemoteConfigListener) {
        this.f23694a = crashlyticsRemoteConfigListener;
    }

    public final void a(Provider provider) {
        RemoteConfigDeferredProxy.b(this.f23694a, provider);
    }
}
