package com.google.firebase.sessions;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import com.google.firebase.components.Qualified;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import com.google.firebase.sessions.settings.SessionsSettings;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a0\u0012,\u0012*\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u00050\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "()V", "getComponents", "", "Lcom/google/firebase/components/Component;", "", "kotlin.jvm.PlatformType", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
@Keep
public final class FirebaseSessionsRegistrar implements ComponentRegistrar {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String LIBRARY_NAME = "fire-sessions";
    @NotNull
    private static final Qualified<CoroutineDispatcher> backgroundDispatcher;
    @NotNull
    private static final Qualified<CoroutineDispatcher> blockingDispatcher;
    @NotNull
    private static final Qualified<FirebaseApp> firebaseApp;
    @NotNull
    private static final Qualified<FirebaseInstallationsApi> firebaseInstallationsApi;
    @NotNull
    private static final Qualified<SessionLifecycleServiceBinder> sessionLifecycleServiceBinder;
    @NotNull
    private static final Qualified<SessionsSettings> sessionsSettings;
    @NotNull
    private static final Qualified<TransportFactory> transportFactory;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000b0\u000b0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\r0\r0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u000f0\u000f0\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00110\u00110\u0006X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00130\u00130\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/google/firebase/sessions/FirebaseSessionsRegistrar$Companion;", "", "()V", "LIBRARY_NAME", "", "backgroundDispatcher", "Lcom/google/firebase/components/Qualified;", "Lkotlinx/coroutines/CoroutineDispatcher;", "kotlin.jvm.PlatformType", "blockingDispatcher", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "sessionLifecycleServiceBinder", "Lcom/google/firebase/sessions/SessionLifecycleServiceBinder;", "sessionsSettings", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "transportFactory", "Lcom/google/android/datatransport/TransportFactory;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Qualified<FirebaseApp> b2 = Qualified.b(FirebaseApp.class);
        Intrinsics.o(b2, "unqualified(FirebaseApp::class.java)");
        firebaseApp = b2;
        Qualified<FirebaseInstallationsApi> b3 = Qualified.b(FirebaseInstallationsApi.class);
        Intrinsics.o(b3, "unqualified(FirebaseInstallationsApi::class.java)");
        firebaseInstallationsApi = b3;
        Class<CoroutineDispatcher> cls = CoroutineDispatcher.class;
        Qualified<CoroutineDispatcher> a2 = Qualified.a(Background.class, cls);
        Intrinsics.o(a2, "qualified(Background::cl…neDispatcher::class.java)");
        backgroundDispatcher = a2;
        Qualified<CoroutineDispatcher> a3 = Qualified.a(Blocking.class, cls);
        Intrinsics.o(a3, "qualified(Blocking::clas…neDispatcher::class.java)");
        blockingDispatcher = a3;
        Qualified<TransportFactory> b4 = Qualified.b(TransportFactory.class);
        Intrinsics.o(b4, "unqualified(TransportFactory::class.java)");
        transportFactory = b4;
        Qualified<SessionsSettings> b5 = Qualified.b(SessionsSettings.class);
        Intrinsics.o(b5, "unqualified(SessionsSettings::class.java)");
        sessionsSettings = b5;
        Qualified<SessionLifecycleServiceBinder> b6 = Qualified.b(SessionLifecycleServiceBinder.class);
        Intrinsics.o(b6, "unqualified(SessionLifec…erviceBinder::class.java)");
        sessionLifecycleServiceBinder = b6;
    }

    /* access modifiers changed from: private */
    public static final FirebaseSessions getComponents$lambda$0(ComponentContainer componentContainer) {
        Object h2 = componentContainer.h(firebaseApp);
        Intrinsics.o(h2, "container[firebaseApp]");
        Object h3 = componentContainer.h(sessionsSettings);
        Intrinsics.o(h3, "container[sessionsSettings]");
        Object h4 = componentContainer.h(backgroundDispatcher);
        Intrinsics.o(h4, "container[backgroundDispatcher]");
        Object h5 = componentContainer.h(sessionLifecycleServiceBinder);
        Intrinsics.o(h5, "container[sessionLifecycleServiceBinder]");
        return new FirebaseSessions((FirebaseApp) h2, (SessionsSettings) h3, (CoroutineContext) h4, (SessionLifecycleServiceBinder) h5);
    }

    /* access modifiers changed from: private */
    public static final SessionGenerator getComponents$lambda$1(ComponentContainer componentContainer) {
        return new SessionGenerator(WallClock.f25138a, (Function0) null, 2, (DefaultConstructorMarker) null);
    }

    /* access modifiers changed from: private */
    public static final SessionFirelogPublisher getComponents$lambda$2(ComponentContainer componentContainer) {
        Object h2 = componentContainer.h(firebaseApp);
        Intrinsics.o(h2, "container[firebaseApp]");
        Object h3 = componentContainer.h(firebaseInstallationsApi);
        Intrinsics.o(h3, "container[firebaseInstallationsApi]");
        Object h4 = componentContainer.h(sessionsSettings);
        Intrinsics.o(h4, "container[sessionsSettings]");
        Provider<TransportFactory> b2 = componentContainer.b(transportFactory);
        Intrinsics.o(b2, "container.getProvider(transportFactory)");
        EventGDTLogger eventGDTLogger = new EventGDTLogger(b2);
        Object h5 = componentContainer.h(backgroundDispatcher);
        Intrinsics.o(h5, "container[backgroundDispatcher]");
        return new SessionFirelogPublisherImpl((FirebaseApp) h2, (FirebaseInstallationsApi) h3, (SessionsSettings) h4, eventGDTLogger, (CoroutineContext) h5);
    }

    /* access modifiers changed from: private */
    public static final SessionsSettings getComponents$lambda$3(ComponentContainer componentContainer) {
        Object h2 = componentContainer.h(firebaseApp);
        Intrinsics.o(h2, "container[firebaseApp]");
        Object h3 = componentContainer.h(blockingDispatcher);
        Intrinsics.o(h3, "container[blockingDispatcher]");
        Object h4 = componentContainer.h(backgroundDispatcher);
        Intrinsics.o(h4, "container[backgroundDispatcher]");
        Object h5 = componentContainer.h(firebaseInstallationsApi);
        Intrinsics.o(h5, "container[firebaseInstallationsApi]");
        return new SessionsSettings((FirebaseApp) h2, (CoroutineContext) h3, (CoroutineContext) h4, (FirebaseInstallationsApi) h5);
    }

    /* access modifiers changed from: private */
    public static final SessionDatastore getComponents$lambda$4(ComponentContainer componentContainer) {
        Context n2 = ((FirebaseApp) componentContainer.h(firebaseApp)).n();
        Intrinsics.o(n2, "container[firebaseApp].applicationContext");
        Object h2 = componentContainer.h(backgroundDispatcher);
        Intrinsics.o(h2, "container[backgroundDispatcher]");
        return new SessionDatastoreImpl(n2, (CoroutineContext) h2);
    }

    /* access modifiers changed from: private */
    public static final SessionLifecycleServiceBinder getComponents$lambda$5(ComponentContainer componentContainer) {
        Object h2 = componentContainer.h(firebaseApp);
        Intrinsics.o(h2, "container[firebaseApp]");
        return new SessionLifecycleServiceBinderImpl((FirebaseApp) h2);
    }

    @NotNull
    public List<Component<? extends Object>> getComponents() {
        Component.Builder<FirebaseSessions> h2 = Component.h(FirebaseSessions.class).h(LIBRARY_NAME);
        Qualified<FirebaseApp> qualified = firebaseApp;
        Component.Builder<FirebaseSessions> b2 = h2.b(Dependency.l(qualified));
        Qualified<SessionsSettings> qualified2 = sessionsSettings;
        Component.Builder<FirebaseSessions> b3 = b2.b(Dependency.l(qualified2));
        Qualified<CoroutineDispatcher> qualified3 = backgroundDispatcher;
        Component<FirebaseSessions> d2 = b3.b(Dependency.l(qualified3)).b(Dependency.l(sessionLifecycleServiceBinder)).f(new d()).e().d();
        Component<SessionGenerator> d3 = Component.h(SessionGenerator.class).h("session-generator").f(new e()).d();
        Component.Builder<SessionFirelogPublisher> b4 = Component.h(SessionFirelogPublisher.class).h("session-publisher").b(Dependency.l(qualified));
        Qualified<FirebaseInstallationsApi> qualified4 = firebaseInstallationsApi;
        return CollectionsKt.L(d2, d3, b4.b(Dependency.l(qualified4)).b(Dependency.l(qualified2)).b(Dependency.n(transportFactory)).b(Dependency.l(qualified3)).f(new f()).d(), Component.h(SessionsSettings.class).h("sessions-settings").b(Dependency.l(qualified)).b(Dependency.l(blockingDispatcher)).b(Dependency.l(qualified3)).b(Dependency.l(qualified4)).f(new g()).d(), Component.h(SessionDatastore.class).h("sessions-datastore").b(Dependency.l(qualified)).b(Dependency.l(qualified3)).f(new h()).d(), Component.h(SessionLifecycleServiceBinder.class).h("sessions-service-binder").b(Dependency.l(qualified)).f(new i()).d(), LibraryVersionComponent.b(LIBRARY_NAME, BuildConfig.f25053d));
    }
}
