package com.google.firebase.components;

import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* renamed from: com.google.firebase.components.r  reason: case insensitive filesystem */
public final /* synthetic */ class C0482r implements Deferred.DeferredHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Deferred.DeferredHandler f23439a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Deferred.DeferredHandler f23440b;

    public /* synthetic */ C0482r(Deferred.DeferredHandler deferredHandler, Deferred.DeferredHandler deferredHandler2) {
        this.f23439a = deferredHandler;
        this.f23440b = deferredHandler2;
    }

    public final void a(Provider provider) {
        OptionalProvider.h(this.f23439a, this.f23440b, provider);
    }
}
