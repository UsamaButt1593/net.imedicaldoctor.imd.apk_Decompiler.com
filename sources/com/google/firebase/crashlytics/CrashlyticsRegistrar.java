package com.google.firebase.crashlytics;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.remoteconfig.interop.FirebaseRemoteConfigInterop;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import com.google.firebase.sessions.api.SessionSubscriber;
import java.util.Arrays;
import java.util.List;

public class CrashlyticsRegistrar implements ComponentRegistrar {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23478a = "fire-cls";

    static {
        FirebaseSessionsDependencies.a(SessionSubscriber.Name.CRASHLYTICS);
    }

    /* access modifiers changed from: private */
    public FirebaseCrashlytics b(ComponentContainer componentContainer) {
        return FirebaseCrashlytics.e((FirebaseApp) componentContainer.a(FirebaseApp.class), (FirebaseInstallationsApi) componentContainer.a(FirebaseInstallationsApi.class), componentContainer.k(CrashlyticsNativeComponent.class), componentContainer.k(AnalyticsConnector.class), componentContainer.k(FirebaseRemoteConfigInterop.class));
    }

    public List<Component<?>> getComponents() {
        return Arrays.asList(new Component[]{Component.h(FirebaseCrashlytics.class).h(f23478a).b(Dependency.m(FirebaseApp.class)).b(Dependency.m(FirebaseInstallationsApi.class)).b(Dependency.b(CrashlyticsNativeComponent.class)).b(Dependency.b(AnalyticsConnector.class)).b(Dependency.b(FirebaseRemoteConfigInterop.class)).f(new d(this)).e().d(), LibraryVersionComponent.b(f23478a, BuildConfig.f23471d)});
    }
}
