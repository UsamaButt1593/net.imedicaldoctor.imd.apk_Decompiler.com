package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.BuildConfig;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.RemoteConfigDeferredProxy;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CrashlyticsCore {
    private static final String A = "initialization_marker";
    static final String B = "crash_marker";
    private static final String s = "The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin";
    static final int t = 1024;
    static final int u = 10;
    static final String v = "com.crashlytics.RequireBuildId";
    static final boolean w = true;
    static final int x = 3;
    private static final String y = "com.crashlytics.on-demand.recorded-exceptions";
    private static final String z = "com.crashlytics.on-demand.dropped-exceptions";

    /* renamed from: a  reason: collision with root package name */
    private final Context f23607a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseApp f23608b;

    /* renamed from: c  reason: collision with root package name */
    private final DataCollectionArbiter f23609c;

    /* renamed from: d  reason: collision with root package name */
    private final OnDemandCounter f23610d = new OnDemandCounter();

    /* renamed from: e  reason: collision with root package name */
    private final long f23611e = System.currentTimeMillis();
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public CrashlyticsFileMarker f23612f;

    /* renamed from: g  reason: collision with root package name */
    private CrashlyticsFileMarker f23613g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f23614h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public CrashlyticsController f23615i;

    /* renamed from: j  reason: collision with root package name */
    private final IdManager f23616j;

    /* renamed from: k  reason: collision with root package name */
    private final FileStore f23617k;
    @VisibleForTesting

    /* renamed from: l  reason: collision with root package name */
    public final BreadcrumbSource f23618l;

    /* renamed from: m  reason: collision with root package name */
    private final AnalyticsEventLogger f23619m;

    /* renamed from: n  reason: collision with root package name */
    private final ExecutorService f23620n;
    private final CrashlyticsBackgroundWorker o;
    private final CrashlyticsAppQualitySessionsSubscriber p;
    private final CrashlyticsNativeComponent q;
    private final RemoteConfigDeferredProxy r;

    public CrashlyticsCore(FirebaseApp firebaseApp, IdManager idManager, CrashlyticsNativeComponent crashlyticsNativeComponent, DataCollectionArbiter dataCollectionArbiter, BreadcrumbSource breadcrumbSource, AnalyticsEventLogger analyticsEventLogger, FileStore fileStore, ExecutorService executorService, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber, RemoteConfigDeferredProxy remoteConfigDeferredProxy) {
        this.f23608b = firebaseApp;
        this.f23609c = dataCollectionArbiter;
        this.f23607a = firebaseApp.n();
        this.f23616j = idManager;
        this.q = crashlyticsNativeComponent;
        this.f23618l = breadcrumbSource;
        this.f23619m = analyticsEventLogger;
        this.f23620n = executorService;
        this.f23617k = fileStore;
        this.o = new CrashlyticsBackgroundWorker(executorService);
        this.p = crashlyticsAppQualitySessionsSubscriber;
        this.r = remoteConfigDeferredProxy;
    }

    private void d() {
        boolean z2;
        try {
            z2 = Boolean.TRUE.equals((Boolean) Utils.f(this.o.h(new Callable<Boolean>() {
                /* renamed from: a */
                public Boolean call() throws Exception {
                    return Boolean.valueOf(CrashlyticsCore.this.f23615i.u());
                }
            })));
        } catch (Exception unused) {
            z2 = false;
        }
        this.f23614h = z2;
    }

    /* access modifiers changed from: private */
    @CanIgnoreReturnValue
    public Task<Void> i(SettingsProvider settingsProvider) {
        s();
        try {
            this.f23618l.a(new f(this));
            this.f23615i.X();
            if (!settingsProvider.b().f24264b.f24271a) {
                Logger.f().b("Collection of crash reports disabled in Crashlytics settings.");
                return Tasks.f(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.f23615i.B(settingsProvider)) {
                Logger.f().m("Previous sessions could not be finalized.");
            }
            Task<Void> d0 = this.f23615i.d0(settingsProvider.a());
            r();
            return d0;
        } catch (Exception e2) {
            Logger.f().e("Crashlytics encountered a problem during asynchronous initialization.", e2);
            return Tasks.f(e2);
        } finally {
            r();
        }
    }

    private void k(final SettingsProvider settingsProvider) {
        String str;
        Logger logger;
        Future<?> submit = this.f23620n.submit(new Runnable() {
            public void run() {
                Task unused = CrashlyticsCore.this.i(settingsProvider);
            }
        });
        Logger.f().b("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(3, TimeUnit.SECONDS);
            return;
        } catch (InterruptedException e2) {
            e = e2;
            logger = Logger.f();
            str = "Crashlytics was interrupted during initialization.";
        } catch (ExecutionException e3) {
            e = e3;
            logger = Logger.f();
            str = "Crashlytics encountered a problem during initialization.";
        } catch (TimeoutException e4) {
            e = e4;
            logger = Logger.f();
            str = "Crashlytics timed out during initialization.";
        }
        logger.e(str, e);
    }

    public static String m() {
        return BuildConfig.f23471d;
    }

    static boolean n(String str, boolean z2) {
        if (!z2) {
            Logger.f().k("Configured not to require a build ID.");
            return true;
        } else if (!TextUtils.isEmpty(str)) {
            return true;
        } else {
            Log.e(Logger.f23504c, ".");
            Log.e(Logger.f23504c, ".     |  | ");
            Log.e(Logger.f23504c, ".     |  |");
            Log.e(Logger.f23504c, ".     |  |");
            Log.e(Logger.f23504c, ".   \\ |  | /");
            Log.e(Logger.f23504c, ".    \\    /");
            Log.e(Logger.f23504c, ".     \\  /");
            Log.e(Logger.f23504c, ".      \\/");
            Log.e(Logger.f23504c, ".");
            Log.e(Logger.f23504c, s);
            Log.e(Logger.f23504c, ".");
            Log.e(Logger.f23504c, ".      /\\");
            Log.e(Logger.f23504c, ".     /  \\");
            Log.e(Logger.f23504c, ".    /    \\");
            Log.e(Logger.f23504c, ".   / |  | \\");
            Log.e(Logger.f23504c, ".     |  |");
            Log.e(Logger.f23504c, ".     |  |");
            Log.e(Logger.f23504c, ".     |  |");
            Log.e(Logger.f23504c, ".");
            return false;
        }
    }

    @NonNull
    public Task<Boolean> e() {
        return this.f23615i.o();
    }

    public Task<Void> f() {
        return this.f23615i.t();
    }

    public boolean g() {
        return this.f23614h;
    }

    /* access modifiers changed from: package-private */
    public boolean h() {
        return this.f23612f.c();
    }

    @CanIgnoreReturnValue
    public Task<Void> j(final SettingsProvider settingsProvider) {
        return Utils.h(this.f23620n, new Callable<Task<Void>>() {
            /* renamed from: a */
            public Task<Void> call() throws Exception {
                return CrashlyticsCore.this.i(settingsProvider);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public CrashlyticsController l() {
        return this.f23615i;
    }

    public void o(String str) {
        this.f23615i.h0(System.currentTimeMillis() - this.f23611e, str);
    }

    public void p(@NonNull Throwable th) {
        this.f23615i.g0(Thread.currentThread(), th);
    }

    public void q(Throwable th) {
        Logger f2 = Logger.f();
        f2.b("Recorded on-demand fatal events: " + this.f23610d.b());
        Logger f3 = Logger.f();
        f3.b("Dropped on-demand fatal events: " + this.f23610d.a());
        this.f23615i.b0(y, Integer.toString(this.f23610d.b()));
        this.f23615i.b0(z, Integer.toString(this.f23610d.a()));
        this.f23615i.S(Thread.currentThread(), th);
    }

    /* access modifiers changed from: package-private */
    public void r() {
        this.o.h(new Callable<Boolean>() {
            /* renamed from: a */
            public Boolean call() throws Exception {
                try {
                    boolean d2 = CrashlyticsCore.this.f23612f.d();
                    if (!d2) {
                        Logger.f().m("Initialization marker file was not properly removed.");
                    }
                    return Boolean.valueOf(d2);
                } catch (Exception e2) {
                    Logger.f().e("Problem encountered deleting Crashlytics initialization marker.", e2);
                    return Boolean.FALSE;
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void s() {
        this.o.b();
        this.f23612f.a();
        Logger.f().k("Initialization marker file was created.");
    }

    public boolean t(AppData appData, SettingsProvider settingsProvider) {
        SettingsProvider settingsProvider2 = settingsProvider;
        if (n(appData.f23529b, CommonUtils.i(this.f23607a, v, true))) {
            String clsuuid = new CLSUUID(this.f23616j).toString();
            try {
                this.f23613g = new CrashlyticsFileMarker(B, this.f23617k);
                this.f23612f = new CrashlyticsFileMarker(A, this.f23617k);
                UserMetadata userMetadata = new UserMetadata(clsuuid, this.f23617k, this.o);
                LogFileManager logFileManager = new LogFileManager(this.f23617k);
                MiddleOutFallbackStrategy middleOutFallbackStrategy = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
                this.r.c(userMetadata);
                Context context = this.f23607a;
                IdManager idManager = this.f23616j;
                FileStore fileStore = this.f23617k;
                OnDemandCounter onDemandCounter = this.f23610d;
                OnDemandCounter onDemandCounter2 = onDemandCounter;
                UserMetadata userMetadata2 = userMetadata;
                SessionReportingCoordinator m2 = SessionReportingCoordinator.m(context, idManager, fileStore, appData, logFileManager, userMetadata, middleOutFallbackStrategy, settingsProvider, onDemandCounter2, this.p);
                Context context2 = this.f23607a;
                CrashlyticsBackgroundWorker crashlyticsBackgroundWorker = this.o;
                IdManager idManager2 = this.f23616j;
                DataCollectionArbiter dataCollectionArbiter = this.f23609c;
                FileStore fileStore2 = this.f23617k;
                CrashlyticsFileMarker crashlyticsFileMarker = this.f23613g;
                this.f23615i = new CrashlyticsController(context2, crashlyticsBackgroundWorker, idManager2, dataCollectionArbiter, fileStore2, crashlyticsFileMarker, appData, userMetadata2, logFileManager, m2, this.q, this.f23619m, this.p);
                boolean h2 = h();
                d();
                this.f23615i.z(clsuuid, Thread.getDefaultUncaughtExceptionHandler(), settingsProvider2);
                if (!h2 || !CommonUtils.d(this.f23607a)) {
                    Logger.f().b("Successfully configured exception handler.");
                    return true;
                }
                Logger.f().b("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                k(settingsProvider2);
                return false;
            } catch (Exception e2) {
                Logger.f().e("Crashlytics was not started due to an exception during initialization", e2);
                this.f23615i = null;
                return false;
            }
        } else {
            throw new IllegalStateException(s);
        }
    }

    public Task<Void> u() {
        return this.f23615i.Y();
    }

    public void v(@Nullable Boolean bool) {
        this.f23609c.h(bool);
    }

    public void w(String str, String str2) {
        this.f23615i.Z(str, str2);
    }

    public void x(Map<String, String> map) {
        this.f23615i.a0(map);
    }

    public void y(String str, String str2) {
        this.f23615i.b0(str, str2);
    }

    public void z(String str) {
        this.f23615i.c0(str);
    }
}
