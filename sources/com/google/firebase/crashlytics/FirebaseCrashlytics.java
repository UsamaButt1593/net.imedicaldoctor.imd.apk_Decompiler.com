package com.google.firebase.crashlytics;

import android.content.Context;
import android.content.pm.PackageManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy;
import com.google.firebase.crashlytics.internal.DevelopmentPlatformProvider;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.RemoteConfigDeferredProxy;
import com.google.firebase.crashlytics.internal.common.AppData;
import com.google.firebase.crashlytics.internal.common.BuildIdInfo;
import com.google.firebase.crashlytics.internal.common.CommonUtils;
import com.google.firebase.crashlytics.internal.common.CrashlyticsAppQualitySessionsSubscriber;
import com.google.firebase.crashlytics.internal.common.CrashlyticsCore;
import com.google.firebase.crashlytics.internal.common.DataCollectionArbiter;
import com.google.firebase.crashlytics.internal.common.ExecutorUtils;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.google.firebase.crashlytics.internal.network.HttpRequestFactory;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsController;
import com.google.firebase.inject.Deferred;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.interop.FirebaseRemoteConfigInterop;
import com.google.firebase.sessions.api.FirebaseSessionsDependencies;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class FirebaseCrashlytics {

    /* renamed from: b  reason: collision with root package name */
    static final String f23481b = "clx";

    /* renamed from: c  reason: collision with root package name */
    static final String f23482c = "crash";

    /* renamed from: d  reason: collision with root package name */
    static final int f23483d = 500;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    final CrashlyticsCore f23484a;

    private FirebaseCrashlytics(@NonNull CrashlyticsCore crashlyticsCore) {
        this.f23484a = crashlyticsCore;
    }

    @NonNull
    public static FirebaseCrashlytics d() {
        FirebaseCrashlytics firebaseCrashlytics = (FirebaseCrashlytics) FirebaseApp.p().l(FirebaseCrashlytics.class);
        if (firebaseCrashlytics != null) {
            return firebaseCrashlytics;
        }
        throw new NullPointerException("FirebaseCrashlytics component is not present.");
    }

    @Nullable
    static FirebaseCrashlytics e(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseInstallationsApi firebaseInstallationsApi, @NonNull Deferred<CrashlyticsNativeComponent> deferred, @NonNull Deferred<AnalyticsConnector> deferred2, @NonNull Deferred<FirebaseRemoteConfigInterop> deferred3) {
        Context n2 = firebaseApp.n();
        String packageName = n2.getPackageName();
        Logger f2 = Logger.f();
        f2.g("Initializing Firebase Crashlytics " + CrashlyticsCore.m() + " for " + packageName);
        FileStore fileStore = new FileStore(n2);
        DataCollectionArbiter dataCollectionArbiter = new DataCollectionArbiter(firebaseApp);
        IdManager idManager = new IdManager(n2, packageName, firebaseInstallationsApi, dataCollectionArbiter);
        CrashlyticsNativeComponentDeferredProxy crashlyticsNativeComponentDeferredProxy = new CrashlyticsNativeComponentDeferredProxy(deferred);
        AnalyticsDeferredProxy analyticsDeferredProxy = new AnalyticsDeferredProxy(deferred2);
        ExecutorService c2 = ExecutorUtils.c("Crashlytics Exception Handler");
        CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber = new CrashlyticsAppQualitySessionsSubscriber(dataCollectionArbiter, fileStore);
        FirebaseSessionsDependencies.e(crashlyticsAppQualitySessionsSubscriber);
        RemoteConfigDeferredProxy remoteConfigDeferredProxy = new RemoteConfigDeferredProxy(deferred3);
        CrashlyticsCore crashlyticsCore = r4;
        IdManager idManager2 = idManager;
        CrashlyticsCore crashlyticsCore2 = new CrashlyticsCore(firebaseApp, idManager, crashlyticsNativeComponentDeferredProxy, dataCollectionArbiter, analyticsDeferredProxy.e(), analyticsDeferredProxy.d(), fileStore, c2, crashlyticsAppQualitySessionsSubscriber, remoteConfigDeferredProxy);
        String j2 = firebaseApp.s().j();
        String n3 = CommonUtils.n(n2);
        List<BuildIdInfo> j3 = CommonUtils.j(n2);
        Logger f3 = Logger.f();
        f3.b("Mapping file ID is: " + n3);
        for (BuildIdInfo next : j3) {
            Logger.f().b(String.format("Build id for %s on %s: %s", new Object[]{next.c(), next.a(), next.b()}));
        }
        DataCollectionArbiter dataCollectionArbiter2 = dataCollectionArbiter;
        try {
            AppData a2 = AppData.a(n2, idManager2, j2, n3, j3, new DevelopmentPlatformProvider(n2));
            Logger f4 = Logger.f();
            f4.k("Installer package name is: " + a2.f23531d);
            ExecutorService c3 = ExecutorUtils.c("com.google.firebase.crashlytics.startup");
            final SettingsController l2 = SettingsController.l(n2, j2, idManager2, new HttpRequestFactory(), a2.f23533f, a2.f23534g, fileStore, dataCollectionArbiter2);
            l2.p(c3).n(c3, new Continuation<Void, Object>() {
                public Object a(@NonNull Task<Void> task) throws Exception {
                    if (task.v()) {
                        return null;
                    }
                    Logger.f().e("Error fetching settings.", task.q());
                    return null;
                }
            });
            final CrashlyticsCore crashlyticsCore3 = crashlyticsCore;
            final boolean t = crashlyticsCore3.t(a2, l2);
            Tasks.d(c3, new Callable<Void>() {
                /* renamed from: a */
                public Void call() throws Exception {
                    if (!t) {
                        return null;
                    }
                    crashlyticsCore3.j(l2);
                    return null;
                }
            });
            return new FirebaseCrashlytics(crashlyticsCore3);
        } catch (PackageManager.NameNotFoundException e2) {
            Logger.f().e("Error retrieving app package info.", e2);
            return null;
        }
    }

    @NonNull
    public Task<Boolean> a() {
        return this.f23484a.e();
    }

    public void b() {
        this.f23484a.f();
    }

    public boolean c() {
        return this.f23484a.g();
    }

    public void f(@NonNull String str) {
        this.f23484a.o(str);
    }

    public void g(@NonNull Throwable th) {
        if (th == null) {
            Logger.f().m("A null value was passed to recordException. Ignoring.");
        } else {
            this.f23484a.p(th);
        }
    }

    public void h() {
        this.f23484a.u();
    }

    public void i(@Nullable Boolean bool) {
        this.f23484a.v(bool);
    }

    public void j(boolean z) {
        this.f23484a.v(Boolean.valueOf(z));
    }

    public void k(@NonNull String str, double d2) {
        this.f23484a.w(str, Double.toString(d2));
    }

    public void l(@NonNull String str, float f2) {
        this.f23484a.w(str, Float.toString(f2));
    }

    public void m(@NonNull String str, int i2) {
        this.f23484a.w(str, Integer.toString(i2));
    }

    public void n(@NonNull String str, long j2) {
        this.f23484a.w(str, Long.toString(j2));
    }

    public void o(@NonNull String str, @NonNull String str2) {
        this.f23484a.w(str, str2);
    }

    public void p(@NonNull String str, boolean z) {
        this.f23484a.w(str, Boolean.toString(z));
    }

    public void q(@NonNull CustomKeysAndValues customKeysAndValues) {
        this.f23484a.x(customKeysAndValues.f23479a);
    }

    public void r(@NonNull String str) {
        this.f23484a.z(str);
    }
}
