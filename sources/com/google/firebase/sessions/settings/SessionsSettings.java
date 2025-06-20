package com.google.firebase.sessions.settings;

import android.content.Context;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.datastore.preferences.PreferenceDataStoreDelegateKt;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.SessionDataStoreConfigs;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference2Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KProperty;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\b\u0000\u0018\u0000 '2\u00020\u0001:\u0001)B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006B1\b\u0012\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0005\u0010\u0010B)\b\u0016\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0005\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001d\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0013\u0010\u001e\u001a\u00020\u001dH@ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010!R\u0011\u0010%\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010\u0015\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\"\u0010&R\u001a\u0010\u001a\u001a\u00020\u00198Fø\u0001\u0001ø\u0001\u0000ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b'\u0010(\u0002\u000f\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!¨\u0006*"}, d2 = {"Lcom/google/firebase/sessions/settings/SessionsSettings;", "", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "localOverrideSettings", "remoteSettings", "<init>", "(Lcom/google/firebase/sessions/settings/SettingsProvider;Lcom/google/firebase/sessions/settings/SettingsProvider;)V", "Landroid/content/Context;", "context", "Lkotlin/coroutines/CoroutineContext;", "blockingDispatcher", "backgroundDispatcher", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "firebaseInstallationsApi", "Lcom/google/firebase/sessions/ApplicationInfo;", "appInfo", "(Landroid/content/Context;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;)V", "Lcom/google/firebase/FirebaseApp;", "firebaseApp", "(Lcom/google/firebase/FirebaseApp;Lkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;)V", "", "samplingRate", "", "e", "(D)Z", "Lkotlin/time/Duration;", "sessionRestartTimeout", "f", "(J)Z", "", "g", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "b", "d", "()Z", "sessionsEnabled", "()D", "c", "()J", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class SessionsSettings {
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public static final Companion f25172c = new Companion((DefaultConstructorMarker) null);
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private static final String f25173d = "SessionsSettings";
    /* access modifiers changed from: private */
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public static final ReadOnlyProperty<Context, DataStore<Preferences>> f25174e = PreferenceDataStoreDelegateKt.b(SessionDataStoreConfigs.f25075a.b(), new ReplaceFileCorruptionHandler(SessionsSettings$Companion$dataStore$2.X), (Function1) null, (CoroutineScope) null, 12, (Object) null);
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SettingsProvider f25175a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final SettingsProvider f25176b;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R%\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005*\u00020\u00048BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00108\u0002XT¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/google/firebase/sessions/settings/SessionsSettings$Companion;", "", "<init>", "()V", "Landroid/content/Context;", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "dataStore$delegate", "Lkotlin/properties/ReadOnlyProperty;", "b", "(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", "dataStore", "Lcom/google/firebase/sessions/settings/SessionsSettings;", "c", "()Lcom/google/firebase/sessions/settings/SessionsSettings;", "instance", "", "TAG", "Ljava/lang/String;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ KProperty<Object>[] f25177a = {Reflection.v(new PropertyReference2Impl(Companion.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final DataStore<Preferences> b(Context context) {
            return (DataStore) SessionsSettings.f25174e.a(context, f25177a[0]);
        }

        @NotNull
        public final SessionsSettings c() {
            Object l2 = FirebaseKt.c(Firebase.f23274a).l(SessionsSettings.class);
            Intrinsics.o(l2, "Firebase.app[SessionsSettings::class.java]");
            return (SessionsSettings) l2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private SessionsSettings(Context context, CoroutineContext coroutineContext, CoroutineContext coroutineContext2, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo applicationInfo) {
        this(new LocalOverrideSettings(context), new RemoteSettings(coroutineContext2, firebaseInstallationsApi, applicationInfo, new RemoteSettingsFetcher(applicationInfo, coroutineContext, (String) null, 4, (DefaultConstructorMarker) null), f25172c.b(context)));
    }

    private final boolean e(double d2) {
        return 0.0d <= d2 && d2 <= 1.0d;
    }

    private final boolean f(long j2) {
        return Duration.k0(j2) && Duration.e0(j2);
    }

    public final double b() {
        Double d2 = this.f25175a.d();
        if (d2 != null) {
            double doubleValue = d2.doubleValue();
            if (e(doubleValue)) {
                return doubleValue;
            }
        }
        Double d3 = this.f25176b.d();
        if (d3 == null) {
            return 1.0d;
        }
        double doubleValue2 = d3.doubleValue();
        if (e(doubleValue2)) {
            return doubleValue2;
        }
        return 1.0d;
    }

    public final long c() {
        Duration b2 = this.f25175a.b();
        if (b2 != null) {
            long R0 = b2.R0();
            if (f(R0)) {
                return R0;
            }
        }
        Duration b3 = this.f25176b.b();
        if (b3 != null) {
            long R02 = b3.R0();
            if (f(R02)) {
                return R02;
            }
        }
        Duration.Companion companion = Duration.X;
        return DurationKt.m0(30, DurationUnit.MINUTES);
    }

    public final boolean d() {
        Boolean a2 = this.f25175a.a();
        if (a2 != null) {
            return a2.booleanValue();
        }
        Boolean a3 = this.f25176b.a();
        if (a3 != null) {
            return a3.booleanValue();
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object g(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1 r0 = (com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1) r0
            int r1 = r0.Z2
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.Z2 = r1
            goto L_0x0018
        L_0x0013:
            com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1 r0 = new com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1
            r0.<init>(r5, r6)
        L_0x0018:
            java.lang.Object r6 = r0.X2
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r2 = r0.Z2
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.n(r6)
            goto L_0x005b
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0034:
            java.lang.Object r2 = r0.Z
            com.google.firebase.sessions.settings.SessionsSettings r2 = (com.google.firebase.sessions.settings.SessionsSettings) r2
            kotlin.ResultKt.n(r6)
            goto L_0x004d
        L_0x003c:
            kotlin.ResultKt.n(r6)
            com.google.firebase.sessions.settings.SettingsProvider r6 = r5.f25175a
            r0.Z = r5
            r0.Z2 = r4
            java.lang.Object r6 = r6.e(r0)
            if (r6 != r1) goto L_0x004c
            return r1
        L_0x004c:
            r2 = r5
        L_0x004d:
            com.google.firebase.sessions.settings.SettingsProvider r6 = r2.f25176b
            r2 = 0
            r0.Z = r2
            r0.Z2 = r3
            java.lang.Object r6 = r6.e(r0)
            if (r6 != r1) goto L_0x005b
            return r1
        L_0x005b:
            kotlin.Unit r6 = kotlin.Unit.f28779a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SessionsSettings.g(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public SessionsSettings(@org.jetbrains.annotations.NotNull com.google.firebase.FirebaseApp r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.CoroutineContext r10, @org.jetbrains.annotations.NotNull com.google.firebase.installations.FirebaseInstallationsApi r11) {
        /*
            r7 = this;
            java.lang.String r0 = "firebaseApp"
            kotlin.jvm.internal.Intrinsics.p(r8, r0)
            java.lang.String r0 = "blockingDispatcher"
            kotlin.jvm.internal.Intrinsics.p(r9, r0)
            java.lang.String r0 = "backgroundDispatcher"
            kotlin.jvm.internal.Intrinsics.p(r10, r0)
            java.lang.String r0 = "firebaseInstallationsApi"
            kotlin.jvm.internal.Intrinsics.p(r11, r0)
            android.content.Context r2 = r8.n()
            java.lang.String r0 = "firebaseApp.applicationContext"
            kotlin.jvm.internal.Intrinsics.o(r2, r0)
            com.google.firebase.sessions.SessionEvents r0 = com.google.firebase.sessions.SessionEvents.f25098a
            com.google.firebase.sessions.ApplicationInfo r6 = r0.c(r8)
            r1 = r7
            r3 = r9
            r4 = r10
            r5 = r11
            r1.<init>(r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SessionsSettings.<init>(com.google.firebase.FirebaseApp, kotlin.coroutines.CoroutineContext, kotlin.coroutines.CoroutineContext, com.google.firebase.installations.FirebaseInstallationsApi):void");
    }

    public SessionsSettings(@NotNull SettingsProvider settingsProvider, @NotNull SettingsProvider settingsProvider2) {
        Intrinsics.p(settingsProvider, "localOverrideSettings");
        Intrinsics.p(settingsProvider2, "remoteSettings");
        this.f25175a = settingsProvider;
        this.f25176b = settingsProvider2;
    }
}
