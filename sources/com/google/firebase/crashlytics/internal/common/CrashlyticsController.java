package com.google.firebase.crashlytics.internal.common;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.common.CrashlyticsUncaughtExceptionHandler;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.Settings;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

class CrashlyticsController {
    private static final String A = "Crashlytics Android SDK/%s";
    private static final String B = "com.crashlytics.version-control-info";
    private static final String C = "version-control-info.textproto";
    private static final String D = "META-INF/";
    static final String t = "fatal";
    static final String u = "timestamp";
    static final String v = "_ae";
    static final String w = ".ae";
    static final FilenameFilter x = new e();
    static final String y = "native-sessions";
    static final int z = 1;

    /* renamed from: a  reason: collision with root package name */
    private final Context f23584a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final DataCollectionArbiter f23585b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final CrashlyticsFileMarker f23586c;

    /* renamed from: d  reason: collision with root package name */
    private final UserMetadata f23587d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final CrashlyticsBackgroundWorker f23588e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public final IdManager f23589f;

    /* renamed from: g  reason: collision with root package name */
    private final FileStore f23590g;

    /* renamed from: h  reason: collision with root package name */
    private final AppData f23591h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public final LogFileManager f23592i;

    /* renamed from: j  reason: collision with root package name */
    private final CrashlyticsNativeComponent f23593j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public final AnalyticsEventLogger f23594k;

    /* renamed from: l  reason: collision with root package name */
    private final CrashlyticsAppQualitySessionsSubscriber f23595l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final SessionReportingCoordinator f23596m;

    /* renamed from: n  reason: collision with root package name */
    private CrashlyticsUncaughtExceptionHandler f23597n;
    private SettingsProvider o = null;
    final TaskCompletionSource<Boolean> p = new TaskCompletionSource<>();
    final TaskCompletionSource<Boolean> q = new TaskCompletionSource<>();
    final TaskCompletionSource<Void> r = new TaskCompletionSource<>();
    final AtomicBoolean s = new AtomicBoolean(false);

    CrashlyticsController(Context context, CrashlyticsBackgroundWorker crashlyticsBackgroundWorker, IdManager idManager, DataCollectionArbiter dataCollectionArbiter, FileStore fileStore, CrashlyticsFileMarker crashlyticsFileMarker, AppData appData, UserMetadata userMetadata, LogFileManager logFileManager, SessionReportingCoordinator sessionReportingCoordinator, CrashlyticsNativeComponent crashlyticsNativeComponent, AnalyticsEventLogger analyticsEventLogger, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber) {
        this.f23584a = context;
        this.f23588e = crashlyticsBackgroundWorker;
        this.f23589f = idManager;
        this.f23585b = dataCollectionArbiter;
        this.f23590g = fileStore;
        this.f23586c = crashlyticsFileMarker;
        this.f23591h = appData;
        this.f23587d = userMetadata;
        this.f23592i = logFileManager;
        this.f23593j = crashlyticsNativeComponent;
        this.f23594k = analyticsEventLogger;
        this.f23595l = crashlyticsAppQualitySessionsSubscriber;
        this.f23596m = sessionReportingCoordinator;
    }

    private void A(String str) {
        Logger f2 = Logger.f();
        f2.k("Finalizing native report for session " + str);
        NativeSessionFileProvider a2 = this.f23593j.a(str);
        File f3 = a2.f();
        CrashlyticsReport.ApplicationExitInfo d2 = a2.d();
        if (T(str, f3, d2)) {
            Logger.f().m("No native core present");
            return;
        }
        long lastModified = f3.lastModified();
        LogFileManager logFileManager = new LogFileManager(this.f23590g, str);
        File l2 = this.f23590g.l(str);
        if (!l2.isDirectory()) {
            Logger.f().m("Couldn't create directory to store native session files, aborting.");
            return;
        }
        y(lastModified);
        List<NativeSessionFile> G = G(a2, str, this.f23590g, logFileManager.b());
        NativeSessionFileGzipper.b(l2, G);
        Logger.f().b("CrashlyticsController#finalizePreviousNativeSession");
        this.f23596m.o(str, G, d2);
        logFileManager.a();
    }

    private static boolean C() {
        try {
            Class.forName("com.google.firebase.crash.FirebaseCrash");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private Context D() {
        return this.f23584a;
    }

    /* access modifiers changed from: private */
    @Nullable
    public String E() {
        SortedSet<String> u2 = this.f23596m.u();
        if (!u2.isEmpty()) {
            return u2.first();
        }
        return null;
    }

    private static long F() {
        return I(System.currentTimeMillis());
    }

    @NonNull
    static List<NativeSessionFile> G(NativeSessionFileProvider nativeSessionFileProvider, String str, FileStore fileStore, byte[] bArr) {
        File r2 = fileStore.r(str, UserMetadata.f23741h);
        File r3 = fileStore.r(str, UserMetadata.f23742i);
        File r4 = fileStore.r(str, UserMetadata.f23744k);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new BytesBackedNativeSessionFile("logs_file", "logs", bArr));
        arrayList.add(new FileBackedNativeSessionFile("crash_meta_file", TtmlNode.y, nativeSessionFileProvider.h()));
        arrayList.add(new FileBackedNativeSessionFile("session_meta_file", "session", nativeSessionFileProvider.g()));
        arrayList.add(new FileBackedNativeSessionFile("app_meta_file", "app", nativeSessionFileProvider.a()));
        arrayList.add(new FileBackedNativeSessionFile("device_meta_file", "device", nativeSessionFileProvider.c()));
        arrayList.add(new FileBackedNativeSessionFile("os_meta_file", "os", nativeSessionFileProvider.b()));
        arrayList.add(U(nativeSessionFileProvider));
        arrayList.add(new FileBackedNativeSessionFile("user_meta_file", "user", r2));
        arrayList.add(new FileBackedNativeSessionFile("keys_file", UserMetadata.f23742i, r3));
        arrayList.add(new FileBackedNativeSessionFile("rollouts_file", "rollouts", r4));
        return arrayList;
    }

    private InputStream H(String str) {
        ClassLoader classLoader = getClass().getClassLoader();
        if (classLoader == null) {
            Logger.f().m("Couldn't get Class Loader");
            return null;
        }
        InputStream resourceAsStream = classLoader.getResourceAsStream(str);
        if (resourceAsStream != null) {
            return resourceAsStream;
        }
        Logger.f().g("No version control information found");
        return null;
    }

    /* access modifiers changed from: private */
    public static long I(long j2) {
        return j2 / 1000;
    }

    private Task<Void> Q(final long j2) {
        if (C()) {
            Logger.f().m("Skipping logging Crashlytics event to Firebase, FirebaseCrash exists");
            return Tasks.g(null);
        }
        Logger.f().b("Logging app exception event to Firebase Analytics");
        return Tasks.d(new ScheduledThreadPoolExecutor(1), new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                Bundle bundle = new Bundle();
                bundle.putInt(CrashlyticsController.t, 1);
                bundle.putLong(CrashlyticsController.u, j2);
                CrashlyticsController.this.f23594k.a(CrashlyticsController.v, bundle);
                return null;
            }
        });
    }

    /* access modifiers changed from: private */
    public Task<Void> R() {
        ArrayList arrayList = new ArrayList();
        for (File next : P()) {
            try {
                arrayList.add(Q(Long.parseLong(next.getName().substring(3))));
            } catch (NumberFormatException unused) {
                Logger f2 = Logger.f();
                f2.m("Could not parse app exception timestamp from file " + next.getName());
            }
            next.delete();
        }
        return Tasks.h(arrayList);
    }

    private static boolean T(String str, File file, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        if (file == null || !file.exists()) {
            Logger f2 = Logger.f();
            f2.m("No minidump data found for session " + str);
        }
        if (applicationExitInfo == null) {
            Logger f3 = Logger.f();
            f3.g("No Tombstones data found for session " + str);
        }
        return (file == null || !file.exists()) && applicationExitInfo == null;
    }

    private static NativeSessionFile U(NativeSessionFileProvider nativeSessionFileProvider) {
        File f2 = nativeSessionFileProvider.f();
        if (f2 != null && f2.exists()) {
            return new FileBackedNativeSessionFile("minidump_file", "minidump", f2);
        }
        return new BytesBackedNativeSessionFile("minidump_file", "minidump", new byte[]{0});
    }

    private static byte[] W(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    private Task<Boolean> e0() {
        if (this.f23585b.d()) {
            Logger.f().b("Automatic data collection is enabled. Allowing upload.");
            this.p.e(Boolean.FALSE);
            return Tasks.g(Boolean.TRUE);
        }
        Logger.f().b("Automatic data collection is disabled.");
        Logger.f().k("Notifying that unsent reports are available.");
        this.p.e(Boolean.TRUE);
        Task<TContinuationResult> w2 = this.f23585b.j().w(new SuccessContinuation<Void, Boolean>() {
            @NonNull
            /* renamed from: b */
            public Task<Boolean> a(@Nullable Void voidR) throws Exception {
                return Tasks.g(Boolean.TRUE);
            }
        });
        Logger.f().b("Waiting for send/deleteUnsentReports to be called.");
        return Utils.n(w2, this.q.a());
    }

    private void f0(String str) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            List a2 = ((ActivityManager) this.f23584a.getSystemService("activity")).getHistoricalProcessExitReasons((String) null, 0, 0);
            if (a2.size() != 0) {
                this.f23596m.z(str, a2, new LogFileManager(this.f23590g, str), UserMetadata.l(str, this.f23590g, this.f23588e));
                return;
            }
            Logger f2 = Logger.f();
            f2.k("No ApplicationExitInfo available. Session: " + str);
            return;
        }
        Logger f3 = Logger.f();
        f3.k("ANR feature enabled, but device is API " + i2);
    }

    private static StaticSessionData.AppData p(IdManager idManager, AppData appData) {
        return StaticSessionData.AppData.b(idManager.f(), appData.f23533f, appData.f23534g, idManager.a().c(), DeliveryMechanism.b(appData.f23531d).c(), appData.f23535h);
    }

    private static StaticSessionData.DeviceData q(Context context) {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return StaticSessionData.DeviceData.c(CommonUtils.k(), Build.MODEL, Runtime.getRuntime().availableProcessors(), CommonUtils.b(context), ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize()), CommonUtils.x(), CommonUtils.l(), Build.MANUFACTURER, Build.PRODUCT);
    }

    private static StaticSessionData.OsData r() {
        return StaticSessionData.OsData.a(Build.VERSION.RELEASE, Build.VERSION.CODENAME, CommonUtils.z());
    }

    /* access modifiers changed from: private */
    public static void s(List<File> list) {
        for (File delete : list) {
            delete.delete();
        }
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [int, boolean] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void w(boolean r4, com.google.firebase.crashlytics.internal.settings.SettingsProvider r5) {
        /*
            r3 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator r1 = r3.f23596m
            java.util.SortedSet r1 = r1.u()
            r0.<init>(r1)
            int r1 = r0.size()
            if (r1 > r4) goto L_0x001b
            com.google.firebase.crashlytics.internal.Logger r4 = com.google.firebase.crashlytics.internal.Logger.f()
            java.lang.String r5 = "No open sessions to be closed."
            r4.k(r5)
            return
        L_0x001b:
            java.lang.Object r1 = r0.get(r4)
            java.lang.String r1 = (java.lang.String) r1
            com.google.firebase.crashlytics.internal.settings.Settings r5 = r5.b()
            com.google.firebase.crashlytics.internal.settings.Settings$FeatureFlagData r5 = r5.f24264b
            boolean r5 = r5.f24272b
            if (r5 == 0) goto L_0x002f
            r3.f0(r1)
            goto L_0x0038
        L_0x002f:
            com.google.firebase.crashlytics.internal.Logger r5 = com.google.firebase.crashlytics.internal.Logger.f()
            java.lang.String r2 = "ANR feature disabled."
            r5.k(r2)
        L_0x0038:
            com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent r5 = r3.f23593j
            boolean r5 = r5.d(r1)
            if (r5 == 0) goto L_0x0043
            r3.A(r1)
        L_0x0043:
            if (r4 == 0) goto L_0x004d
            r4 = 0
            java.lang.Object r4 = r0.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            goto L_0x0054
        L_0x004d:
            com.google.firebase.crashlytics.internal.common.CrashlyticsAppQualitySessionsSubscriber r4 = r3.f23595l
            r5 = 0
            r4.e(r5)
            r4 = r5
        L_0x0054:
            com.google.firebase.crashlytics.internal.common.SessionReportingCoordinator r5 = r3.f23596m
            long r0 = F()
            r5.p(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.common.CrashlyticsController.w(boolean, com.google.firebase.crashlytics.internal.settings.SettingsProvider):void");
    }

    /* access modifiers changed from: private */
    public void x(String str, Boolean bool) {
        long F = F();
        Logger f2 = Logger.f();
        f2.b("Opening a new session with ID " + str);
        String format = String.format(Locale.US, A, new Object[]{CrashlyticsCore.m()});
        StaticSessionData.AppData p2 = p(this.f23589f, this.f23591h);
        StaticSessionData.OsData r2 = r();
        StaticSessionData.DeviceData q2 = q(this.f23584a);
        this.f23593j.c(str, format, F, StaticSessionData.b(p2, r2, q2));
        if (bool.booleanValue() && str != null) {
            this.f23587d.r(str);
        }
        this.f23592i.e(str);
        this.f23595l.e(str);
        this.f23596m.b(str, F);
    }

    /* access modifiers changed from: private */
    public void y(long j2) {
        try {
            FileStore fileStore = this.f23590g;
            if (!fileStore.h(w + j2).createNewFile()) {
                throw new IOException("Create new file failed.");
            }
        } catch (IOException e2) {
            Logger.f().n("Could not create app exception marker file.", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean B(SettingsProvider settingsProvider) {
        this.f23588e.b();
        if (N()) {
            Logger.f().m("Skipping session finalization because a crash has already occurred.");
            return false;
        }
        Logger.f().k("Finalizing previously open sessions.");
        try {
            w(true, settingsProvider);
            Logger.f().k("Closed all previously open sessions.");
            return true;
        } catch (Exception e2) {
            Logger.f().e("Unable to finalize previously open sessions.", e2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public UserMetadata J() {
        return this.f23587d;
    }

    /* access modifiers changed from: package-private */
    public String K() throws IOException {
        InputStream H = H("META-INF/version-control-info.textproto");
        if (H == null) {
            return null;
        }
        Logger.f().b("Read version control info");
        return Base64.encodeToString(W(H), 0);
    }

    /* access modifiers changed from: package-private */
    public void L(@NonNull SettingsProvider settingsProvider, @NonNull Thread thread, @NonNull Throwable th) {
        M(settingsProvider, thread, th, false);
    }

    /* access modifiers changed from: package-private */
    public synchronized void M(@NonNull SettingsProvider settingsProvider, @NonNull Thread thread, @NonNull Throwable th, boolean z2) {
        Logger f2 = Logger.f();
        f2.b("Handling uncaught exception \"" + th + "\" from thread " + thread.getName());
        final long currentTimeMillis = System.currentTimeMillis();
        final Throwable th2 = th;
        final Thread thread2 = thread;
        final SettingsProvider settingsProvider2 = settingsProvider;
        final boolean z3 = z2;
        try {
            Utils.f(this.f23588e.i(new Callable<Task<Void>>() {
                /* renamed from: a */
                public Task<Void> call() throws Exception {
                    long b2 = CrashlyticsController.I(currentTimeMillis);
                    final String c2 = CrashlyticsController.this.E();
                    if (c2 == null) {
                        Logger.f().d("Tried to write a fatal exception while no session was open.");
                        return Tasks.g(null);
                    }
                    CrashlyticsController.this.f23586c.a();
                    CrashlyticsController.this.f23596m.x(th2, thread2, c2, b2);
                    CrashlyticsController.this.y(currentTimeMillis);
                    CrashlyticsController.this.v(settingsProvider2);
                    CrashlyticsController.this.x(new CLSUUID(CrashlyticsController.this.f23589f).toString(), Boolean.valueOf(z3));
                    if (!CrashlyticsController.this.f23585b.d()) {
                        return Tasks.g(null);
                    }
                    final Executor c3 = CrashlyticsController.this.f23588e.c();
                    return settingsProvider2.a().x(c3, new SuccessContinuation<Settings, Void>() {
                        @NonNull
                        /* renamed from: b */
                        public Task<Void> a(@Nullable Settings settings) throws Exception {
                            String str = null;
                            if (settings == null) {
                                Logger.f().m("Received null app settings, cannot send reports at crash time.");
                                return Tasks.g(null);
                            }
                            Task n2 = CrashlyticsController.this.R();
                            SessionReportingCoordinator h2 = CrashlyticsController.this.f23596m;
                            Executor executor = c3;
                            if (z3) {
                                str = c2;
                            }
                            return Tasks.i(n2, h2.C(executor, str));
                        }
                    });
                }
            }));
        } catch (TimeoutException unused) {
            Logger.f().d("Cannot send reports. Timed out while fetching settings.");
        } catch (Exception e2) {
            Logger.f().e("Error handling uncaught exception", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean N() {
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = this.f23597n;
        return crashlyticsUncaughtExceptionHandler != null && crashlyticsUncaughtExceptionHandler.a();
    }

    /* access modifiers changed from: package-private */
    public List<File> P() {
        return this.f23590g.i(x);
    }

    /* access modifiers changed from: package-private */
    public void S(Thread thread, Throwable th) {
        SettingsProvider settingsProvider = this.o;
        if (settingsProvider == null) {
            Logger.f().m("settingsProvider not set");
        } else {
            M(settingsProvider, thread, th, true);
        }
    }

    /* access modifiers changed from: package-private */
    public void V(final String str) {
        this.f23588e.h(new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                CrashlyticsController.this.x(str, Boolean.FALSE);
                return null;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void X() {
        try {
            String K = K();
            if (K != null) {
                b0(B, K);
                Logger.f().g("Saved version control info");
            }
        } catch (IOException e2) {
            Logger.f().n("Unable to save version control info", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public Task<Void> Y() {
        this.q.e(Boolean.TRUE);
        return this.r.a();
    }

    /* access modifiers changed from: package-private */
    public void Z(String str, String str2) {
        try {
            this.f23587d.o(str, str2);
        } catch (IllegalArgumentException e2) {
            Context context = this.f23584a;
            if (context == null || !CommonUtils.v(context)) {
                Logger.f().d("Attempting to set custom attribute with null key, ignoring.");
                return;
            }
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public void a0(Map<String, String> map) {
        this.f23587d.p(map);
    }

    /* access modifiers changed from: package-private */
    public void b0(String str, String str2) {
        try {
            this.f23587d.q(str, str2);
        } catch (IllegalArgumentException e2) {
            Context context = this.f23584a;
            if (context == null || !CommonUtils.v(context)) {
                Logger.f().d("Attempting to set custom attribute with null key, ignoring.");
                return;
            }
            throw e2;
        }
    }

    /* access modifiers changed from: package-private */
    public void c0(String str) {
        this.f23587d.s(str);
    }

    /* access modifiers changed from: package-private */
    @SuppressLint({"TaskMainThread"})
    public Task<Void> d0(final Task<Settings> task) {
        if (!this.f23596m.s()) {
            Logger.f().k("No crash reports are available to be sent.");
            this.p.e(Boolean.FALSE);
            return Tasks.g(null);
        }
        Logger.f().k("Crash reports are available to be sent.");
        return e0().w(new SuccessContinuation<Boolean, Void>() {
            @NonNull
            /* renamed from: b */
            public Task<Void> a(@Nullable final Boolean bool) throws Exception {
                return CrashlyticsController.this.f23588e.i(new Callable<Task<Void>>() {
                    /* renamed from: a */
                    public Task<Void> call() throws Exception {
                        if (!bool.booleanValue()) {
                            Logger.f().k("Deleting cached crash reports...");
                            CrashlyticsController.s(CrashlyticsController.this.P());
                            CrashlyticsController.this.f23596m.A();
                            CrashlyticsController.this.r.e(null);
                            return Tasks.g(null);
                        }
                        Logger.f().b("Sending cached crash reports...");
                        CrashlyticsController.this.f23585b.c(bool.booleanValue());
                        final Executor c2 = CrashlyticsController.this.f23588e.c();
                        return task.x(c2, new SuccessContinuation<Settings, Void>() {
                            @NonNull
                            /* renamed from: b */
                            public Task<Void> a(@Nullable Settings settings) throws Exception {
                                if (settings == null) {
                                    Logger.f().m("Received null app settings at app startup. Cannot send cached reports");
                                } else {
                                    Task unused = CrashlyticsController.this.R();
                                    CrashlyticsController.this.f23596m.B(c2);
                                    CrashlyticsController.this.r.e(null);
                                }
                                return Tasks.g(null);
                            }
                        });
                    }
                });
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void g0(@NonNull Thread thread, @NonNull Throwable th) {
        final long currentTimeMillis = System.currentTimeMillis();
        final Throwable th2 = th;
        final Thread thread2 = thread;
        this.f23588e.g(new Runnable() {
            public void run() {
                if (!CrashlyticsController.this.N()) {
                    long b2 = CrashlyticsController.I(currentTimeMillis);
                    String c2 = CrashlyticsController.this.E();
                    if (c2 == null) {
                        Logger.f().m("Tried to write a non-fatal exception while no session was open.");
                    } else {
                        CrashlyticsController.this.f23596m.y(th2, thread2, c2, b2);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void h0(final long j2, final String str) {
        this.f23588e.h(new Callable<Void>() {
            /* renamed from: a */
            public Void call() throws Exception {
                if (CrashlyticsController.this.N()) {
                    return null;
                }
                CrashlyticsController.this.f23592i.g(j2, str);
                return null;
            }
        });
    }

    /* access modifiers changed from: package-private */
    @NonNull
    public Task<Boolean> o() {
        if (this.s.compareAndSet(false, true)) {
            return this.p.a();
        }
        Logger.f().m("checkForUnsentReports should only be called once per execution.");
        return Tasks.g(Boolean.FALSE);
    }

    /* access modifiers changed from: package-private */
    public Task<Void> t() {
        this.q.e(Boolean.FALSE);
        return this.r.a();
    }

    /* access modifiers changed from: package-private */
    public boolean u() {
        if (!this.f23586c.c()) {
            String E = E();
            return E != null && this.f23593j.d(E);
        }
        Logger.f().k("Found previous crash marker.");
        this.f23586c.d();
        return true;
    }

    /* access modifiers changed from: package-private */
    public void v(SettingsProvider settingsProvider) {
        w(false, settingsProvider);
    }

    /* access modifiers changed from: package-private */
    public void z(String str, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, SettingsProvider settingsProvider) {
        this.o = settingsProvider;
        V(str);
        CrashlyticsUncaughtExceptionHandler crashlyticsUncaughtExceptionHandler = new CrashlyticsUncaughtExceptionHandler(new CrashlyticsUncaughtExceptionHandler.CrashListener() {
            public void a(@NonNull SettingsProvider settingsProvider, @NonNull Thread thread, @NonNull Throwable th) {
                CrashlyticsController.this.L(settingsProvider, thread, th);
            }
        }, settingsProvider, uncaughtExceptionHandler, this.f23593j);
        this.f23597n = crashlyticsUncaughtExceptionHandler;
        Thread.setDefaultUncaughtExceptionHandler(crashlyticsUncaughtExceptionHandler);
    }
}
