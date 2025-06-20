package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.remoteconfig.interop.FirebaseRemoteConfigInterop;

public class RemoteConfigDeferredProxy {

    /* renamed from: a  reason: collision with root package name */
    private final Deferred<FirebaseRemoteConfigInterop> f23509a;

    public RemoteConfigDeferredProxy(Deferred<FirebaseRemoteConfigInterop> deferred) {
        this.f23509a = deferred;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void b(CrashlyticsRemoteConfigListener crashlyticsRemoteConfigListener, Provider provider) {
        ((FirebaseRemoteConfigInterop) provider.get()).a("firebase", crashlyticsRemoteConfigListener);
        Logger.f().b("Registering RemoteConfig Rollouts subscriber");
    }

    public void c(UserMetadata userMetadata) {
        if (userMetadata == null) {
            Logger.f().m("Didn't successfully register with UserMetadata for rollouts listener");
            return;
        }
        this.f23509a.a(new d(new CrashlyticsRemoteConfigListener(userMetadata)));
    }
}
