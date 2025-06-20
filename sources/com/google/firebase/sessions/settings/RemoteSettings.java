package com.google.firebase.sessions.settings;

import androidx.annotation.VisibleForTesting;
import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@SourceDebugExtension({"SMAP\nRemoteSettings.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RemoteSettings.kt\ncom/google/firebase/sessions/settings/RemoteSettings\n+ 2 Mutex.kt\nkotlinx/coroutines/sync/MutexKt\n*L\n1#1,164:1\n107#2,10:165\n*S KotlinDebug\n*F\n+ 1 RemoteSettings.kt\ncom/google/firebase/sessions/settings/RemoteSettings\n*L\n68#1:165,10\n*E\n"})
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u00013B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001fR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010&\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010#\u001a\u0004\b$\u0010%R\u0014\u0010*\u001a\u00020'8\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u0004\u0018\u00010\u00168VX\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010+R\u001f\u0010/\u001a\u0004\u0018\u00010-8VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001d\u0010.R\u0016\u00102\u001a\u0004\u0018\u0001008VX\u0004¢\u0006\u0006\u001a\u0004\b \u00101\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00064"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "Lkotlin/coroutines/CoroutineContext;", "backgroundDispatcher", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "firebaseInstallationsApi", "Lcom/google/firebase/sessions/ApplicationInfo;", "appInfo", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "configsFetcher", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "dataStore", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;Landroidx/datastore/core/DataStore;)V", "", "s", "i", "(Ljava/lang/String;)Ljava/lang/String;", "", "e", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "c", "()Z", "g", "()V", "a", "Lkotlin/coroutines/CoroutineContext;", "b", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "Lcom/google/firebase/sessions/ApplicationInfo;", "d", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "Lcom/google/firebase/sessions/settings/SettingsCache;", "Lkotlin/Lazy;", "h", "()Lcom/google/firebase/sessions/settings/SettingsCache;", "settingsCache", "Lkotlinx/coroutines/sync/Mutex;", "f", "Lkotlinx/coroutines/sync/Mutex;", "fetchInProgress", "()Ljava/lang/Boolean;", "sessionEnabled", "Lkotlin/time/Duration;", "()Lkotlin/time/Duration;", "sessionRestartTimeout", "", "()Ljava/lang/Double;", "samplingRate", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
public final class RemoteSettings implements SettingsProvider {
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final Companion f25152g = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated

    /* renamed from: h  reason: collision with root package name */
    public static final String f25153h = "SessionConfigFetcher";
    @NotNull
    @Deprecated

    /* renamed from: i  reason: collision with root package name */
    public static final String f25154i = "/";
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final CoroutineContext f25155a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseInstallationsApi f25156b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    private final ApplicationInfo f25157c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    private final CrashlyticsSettingsFetcher f25158d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    private final Lazy f25159e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    private final Mutex f25160f = MutexKt.b(false, 1, (Object) null);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings$Companion;", "", "()V", "FORWARD_SLASH_STRING", "", "TAG", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RemoteSettings(@NotNull CoroutineContext coroutineContext, @NotNull FirebaseInstallationsApi firebaseInstallationsApi, @NotNull ApplicationInfo applicationInfo, @NotNull CrashlyticsSettingsFetcher crashlyticsSettingsFetcher, @NotNull DataStore<Preferences> dataStore) {
        Intrinsics.p(coroutineContext, "backgroundDispatcher");
        Intrinsics.p(firebaseInstallationsApi, "firebaseInstallationsApi");
        Intrinsics.p(applicationInfo, "appInfo");
        Intrinsics.p(crashlyticsSettingsFetcher, "configsFetcher");
        Intrinsics.p(dataStore, "dataStore");
        this.f25155a = coroutineContext;
        this.f25156b = firebaseInstallationsApi;
        this.f25157c = applicationInfo;
        this.f25158d = crashlyticsSettingsFetcher;
        this.f25159e = LazyKt.c(new RemoteSettings$settingsCache$2(dataStore));
    }

    /* access modifiers changed from: private */
    public final SettingsCache h() {
        return (SettingsCache) this.f25159e.getValue();
    }

    private final String i(String str) {
        return new Regex("/").m(str, "");
    }

    @Nullable
    public Boolean a() {
        return h().m();
    }

    @Nullable
    public Duration b() {
        Integer k2 = h().k();
        if (k2 == null) {
            return null;
        }
        Duration.Companion companion = Duration.X;
        return Duration.g(DurationKt.m0(k2.intValue(), DurationUnit.SECONDS));
    }

    public boolean c() {
        return h().i();
    }

    @Nullable
    public Double d() {
        return h().l();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a2 A[SYNTHETIC, Splitter:B:43:0x00a2] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object e(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            boolean r6 = r0 instanceof com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1
            if (r6 == 0) goto L_0x001b
            r6 = r0
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1 r6 = (com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1) r6
            int r7 = r6.a3
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = r7 & r8
            if (r9 == 0) goto L_0x001b
            int r7 = r7 - r8
            r6.a3 = r7
            goto L_0x0020
        L_0x001b:
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1 r6 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1
            r6.<init>(r1, r0)
        L_0x0020:
            java.lang.Object r0 = r6.Y2
            java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.l()
            int r8 = r6.a3
            java.lang.String r9 = "SessionConfigFetcher"
            r10 = 0
            if (r8 == 0) goto L_0x0064
            if (r8 == r5) goto L_0x0058
            if (r8 == r4) goto L_0x0049
            if (r8 != r3) goto L_0x0041
            java.lang.Object r2 = r6.Z
            kotlinx.coroutines.sync.Mutex r2 = (kotlinx.coroutines.sync.Mutex) r2
            kotlin.ResultKt.n(r0)     // Catch:{ all -> 0x003d }
            r5 = r10
            goto L_0x0157
        L_0x003d:
            r0 = move-exception
        L_0x003e:
            r3 = r10
            goto L_0x0163
        L_0x0041:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0049:
            java.lang.Object r8 = r6.X2
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r11 = r6.Z
            com.google.firebase.sessions.settings.RemoteSettings r11 = (com.google.firebase.sessions.settings.RemoteSettings) r11
            kotlin.ResultKt.n(r0)     // Catch:{ all -> 0x0055 }
            goto L_0x00b3
        L_0x0055:
            r0 = move-exception
            r2 = r8
            goto L_0x003e
        L_0x0058:
            java.lang.Object r8 = r6.X2
            kotlinx.coroutines.sync.Mutex r8 = (kotlinx.coroutines.sync.Mutex) r8
            java.lang.Object r11 = r6.Z
            com.google.firebase.sessions.settings.RemoteSettings r11 = (com.google.firebase.sessions.settings.RemoteSettings) r11
            kotlin.ResultKt.n(r0)
            goto L_0x008d
        L_0x0064:
            kotlin.ResultKt.n(r0)
            kotlinx.coroutines.sync.Mutex r0 = r1.f25160f
            boolean r0 = r0.b()
            if (r0 != 0) goto L_0x007c
            com.google.firebase.sessions.settings.SettingsCache r0 = r16.h()
            boolean r0 = r0.i()
            if (r0 != 0) goto L_0x007c
            kotlin.Unit r0 = kotlin.Unit.f28779a
            return r0
        L_0x007c:
            kotlinx.coroutines.sync.Mutex r0 = r1.f25160f
            r6.Z = r1
            r6.X2 = r0
            r6.a3 = r5
            java.lang.Object r8 = r0.c(r10, r6)
            if (r8 != r7) goto L_0x008b
            return r7
        L_0x008b:
            r8 = r0
            r11 = r1
        L_0x008d:
            com.google.firebase.sessions.settings.SettingsCache r0 = r11.h()     // Catch:{ all -> 0x0160 }
            boolean r0 = r0.i()     // Catch:{ all -> 0x0160 }
            if (r0 != 0) goto L_0x00a2
            java.lang.String r0 = "Remote settings cache not expired. Using cached values."
            android.util.Log.d(r9, r0)     // Catch:{ all -> 0x0055 }
            kotlin.Unit r0 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0055 }
            r8.d(r10)
            return r0
        L_0x00a2:
            com.google.firebase.sessions.InstallationId$Companion r0 = com.google.firebase.sessions.InstallationId.f25066c     // Catch:{ all -> 0x0160 }
            com.google.firebase.installations.FirebaseInstallationsApi r12 = r11.f25156b     // Catch:{ all -> 0x0160 }
            r6.Z = r11     // Catch:{ all -> 0x0160 }
            r6.X2 = r8     // Catch:{ all -> 0x0160 }
            r6.a3 = r4     // Catch:{ all -> 0x0160 }
            java.lang.Object r0 = r0.a(r12, r6)     // Catch:{ all -> 0x0160 }
            if (r0 != r7) goto L_0x00b3
            return r7
        L_0x00b3:
            com.google.firebase.sessions.InstallationId r0 = (com.google.firebase.sessions.InstallationId) r0     // Catch:{ all -> 0x0160 }
            java.lang.String r0 = r0.b()     // Catch:{ all -> 0x0160 }
            java.lang.String r12 = ""
            boolean r12 = kotlin.jvm.internal.Intrinsics.g(r0, r12)     // Catch:{ all -> 0x0160 }
            if (r12 == 0) goto L_0x00cc
            java.lang.String r0 = "Error getting Firebase Installation ID. Skipping this Session Event."
            android.util.Log.w(r9, r0)     // Catch:{ all -> 0x0055 }
            kotlin.Unit r0 = kotlin.Unit.f28779a     // Catch:{ all -> 0x0055 }
            r8.d(r10)
            return r0
        L_0x00cc:
            java.lang.String r12 = "X-Crashlytics-Installation-ID"
            kotlin.Pair r0 = kotlin.TuplesKt.a(r12, r0)     // Catch:{ all -> 0x0160 }
            java.lang.String r12 = "X-Crashlytics-Device-Model"
            kotlin.jvm.internal.StringCompanionObject r13 = kotlin.jvm.internal.StringCompanionObject.f28971a     // Catch:{ all -> 0x0160 }
            java.lang.String r13 = "%s/%s"
            java.lang.Object[] r14 = new java.lang.Object[r4]     // Catch:{ all -> 0x0160 }
            java.lang.String r15 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0160 }
            r14[r2] = r15     // Catch:{ all -> 0x0160 }
            java.lang.String r15 = android.os.Build.MODEL     // Catch:{ all -> 0x0160 }
            r14[r5] = r15     // Catch:{ all -> 0x0160 }
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r4)     // Catch:{ all -> 0x0160 }
            java.lang.String r13 = java.lang.String.format(r13, r14)     // Catch:{ all -> 0x0160 }
            java.lang.String r14 = "format(format, *args)"
            kotlin.jvm.internal.Intrinsics.o(r13, r14)     // Catch:{ all -> 0x0160 }
            java.lang.String r13 = r11.i(r13)     // Catch:{ all -> 0x0160 }
            kotlin.Pair r12 = kotlin.TuplesKt.a(r12, r13)     // Catch:{ all -> 0x0160 }
            java.lang.String r13 = "X-Crashlytics-OS-Build-Version"
            java.lang.String r14 = android.os.Build.VERSION.INCREMENTAL     // Catch:{ all -> 0x0160 }
            java.lang.String r15 = "INCREMENTAL"
            kotlin.jvm.internal.Intrinsics.o(r14, r15)     // Catch:{ all -> 0x0160 }
            java.lang.String r14 = r11.i(r14)     // Catch:{ all -> 0x0160 }
            kotlin.Pair r13 = kotlin.TuplesKt.a(r13, r14)     // Catch:{ all -> 0x0160 }
            java.lang.String r14 = "X-Crashlytics-OS-Display-Version"
            java.lang.String r15 = android.os.Build.VERSION.RELEASE     // Catch:{ all -> 0x0160 }
            java.lang.String r10 = "RELEASE"
            kotlin.jvm.internal.Intrinsics.o(r15, r10)     // Catch:{ all -> 0x0160 }
            java.lang.String r10 = r11.i(r15)     // Catch:{ all -> 0x0160 }
            kotlin.Pair r10 = kotlin.TuplesKt.a(r14, r10)     // Catch:{ all -> 0x0160 }
            java.lang.String r14 = "X-Crashlytics-API-Client-Version"
            com.google.firebase.sessions.ApplicationInfo r15 = r11.f25157c     // Catch:{ all -> 0x0160 }
            java.lang.String r15 = r15.n()     // Catch:{ all -> 0x0160 }
            kotlin.Pair r14 = kotlin.TuplesKt.a(r14, r15)     // Catch:{ all -> 0x0160 }
            r15 = 5
            kotlin.Pair[] r15 = new kotlin.Pair[r15]     // Catch:{ all -> 0x0160 }
            r15[r2] = r0     // Catch:{ all -> 0x0160 }
            r15[r5] = r12     // Catch:{ all -> 0x0160 }
            r15[r4] = r13     // Catch:{ all -> 0x0160 }
            r15[r3] = r10     // Catch:{ all -> 0x0160 }
            r0 = 4
            r15[r0] = r14     // Catch:{ all -> 0x0160 }
            java.util.Map r0 = kotlin.collections.MapsKt.W(r15)     // Catch:{ all -> 0x0160 }
            java.lang.String r2 = "Fetching settings from server."
            android.util.Log.d(r9, r2)     // Catch:{ all -> 0x0160 }
            com.google.firebase.sessions.settings.CrashlyticsSettingsFetcher r2 = r11.f25158d     // Catch:{ all -> 0x0160 }
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1 r4 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$1     // Catch:{ all -> 0x0160 }
            r5 = 0
            r4.<init>(r11, r5)     // Catch:{ all -> 0x0160 }
            com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2 r9 = new com.google.firebase.sessions.settings.RemoteSettings$updateSettings$2$2     // Catch:{ all -> 0x0160 }
            r9.<init>(r5)     // Catch:{ all -> 0x0160 }
            r6.Z = r8     // Catch:{ all -> 0x0160 }
            r6.X2 = r5     // Catch:{ all -> 0x0160 }
            r6.a3 = r3     // Catch:{ all -> 0x0160 }
            java.lang.Object r0 = r2.a(r0, r4, r9, r6)     // Catch:{ all -> 0x0160 }
            if (r0 != r7) goto L_0x0156
            return r7
        L_0x0156:
            r2 = r8
        L_0x0157:
            kotlin.Unit r0 = kotlin.Unit.f28779a     // Catch:{ all -> 0x015d }
            r2.d(r5)
            return r0
        L_0x015d:
            r0 = move-exception
        L_0x015e:
            r3 = 0
            goto L_0x0163
        L_0x0160:
            r0 = move-exception
            r2 = r8
            goto L_0x015e
        L_0x0163:
            r2.d(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings.e(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @VisibleForTesting
    public final void g() {
        Job unused = BuildersKt__Builders_commonKt.f(CoroutineScopeKt.a(this.f25155a), (CoroutineContext) null, (CoroutineStart) null, new RemoteSettings$clearCachedSettings$1(this, (Continuation<? super RemoteSettings$clearCachedSettings$1>) null), 3, (Object) null);
    }
}
