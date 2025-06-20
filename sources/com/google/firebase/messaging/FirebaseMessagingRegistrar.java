package com.google.firebase.messaging;

import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.FirebaseApp;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.datatransport.TransportBackend;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.Arrays;
import java.util.List;

@KeepForSdk
@Keep
public class FirebaseMessagingRegistrar implements ComponentRegistrar {
    private static final String LIBRARY_NAME = "fire-fcm";

    /* access modifiers changed from: private */
    public static /* synthetic */ FirebaseMessaging lambda$getComponents$0(Qualified qualified, ComponentContainer componentContainer) {
        return new FirebaseMessaging((FirebaseApp) componentContainer.a(FirebaseApp.class), (FirebaseInstanceIdInternal) componentContainer.a(FirebaseInstanceIdInternal.class), componentContainer.c(UserAgentPublisher.class), componentContainer.c(HeartBeatInfo.class), (FirebaseInstallationsApi) componentContainer.a(FirebaseInstallationsApi.class), componentContainer.b(qualified), (Subscriber) componentContainer.a(Subscriber.class));
    }

    @Keep
    public List<Component<?>> getComponents() {
        Qualified<TransportFactory> a2 = Qualified.a(TransportBackend.class, TransportFactory.class);
        return Arrays.asList(new Component[]{Component.h(FirebaseMessaging.class).h(LIBRARY_NAME).b(Dependency.m(FirebaseApp.class)).b(Dependency.i(FirebaseInstanceIdInternal.class)).b(Dependency.k(UserAgentPublisher.class)).b(Dependency.k(HeartBeatInfo.class)).b(Dependency.m(FirebaseInstallationsApi.class)).b(Dependency.j(a2)).b(Dependency.m(Subscriber.class)).f(new y(a2)).c().d(), LibraryVersionComponent.b(LIBRARY_NAME, BuildConfig.f24654d)});
    }
}
