package com.google.firebase.crashlytics;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class c implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AnalyticsDeferredProxy f23489a;

    public /* synthetic */ c(AnalyticsDeferredProxy analyticsDeferredProxy) {
        this.f23489a = analyticsDeferredProxy;
    }

    public final void a(Provider provider) {
        this.f23489a.i(provider);
    }
}
