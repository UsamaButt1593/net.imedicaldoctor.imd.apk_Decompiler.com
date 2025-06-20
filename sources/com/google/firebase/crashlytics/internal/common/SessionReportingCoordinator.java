package com.google.firebase.crashlytics.internal.common;

import android.app.ApplicationExitInfo;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.persistence.CrashlyticsReportPersistence;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.send.DataTransportCrashlyticsReportSender;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.concurrent.Executor;

public class SessionReportingCoordinator implements CrashlyticsLifecycleEvents {

    /* renamed from: g  reason: collision with root package name */
    private static final String f23675g = "crash";

    /* renamed from: h  reason: collision with root package name */
    private static final String f23676h = "error";

    /* renamed from: i  reason: collision with root package name */
    private static final int f23677i = 4;

    /* renamed from: j  reason: collision with root package name */
    private static final int f23678j = 8;

    /* renamed from: k  reason: collision with root package name */
    private static final int f23679k = 8192;

    /* renamed from: a  reason: collision with root package name */
    private final CrashlyticsReportDataCapture f23680a;

    /* renamed from: b  reason: collision with root package name */
    private final CrashlyticsReportPersistence f23681b;

    /* renamed from: c  reason: collision with root package name */
    private final DataTransportCrashlyticsReportSender f23682c;

    /* renamed from: d  reason: collision with root package name */
    private final LogFileManager f23683d;

    /* renamed from: e  reason: collision with root package name */
    private final UserMetadata f23684e;

    /* renamed from: f  reason: collision with root package name */
    private final IdManager f23685f;

    SessionReportingCoordinator(CrashlyticsReportDataCapture crashlyticsReportDataCapture, CrashlyticsReportPersistence crashlyticsReportPersistence, DataTransportCrashlyticsReportSender dataTransportCrashlyticsReportSender, LogFileManager logFileManager, UserMetadata userMetadata, IdManager idManager) {
        this.f23680a = crashlyticsReportDataCapture;
        this.f23681b = crashlyticsReportPersistence;
        this.f23682c = dataTransportCrashlyticsReportSender;
        this.f23683d = logFileManager;
        this.f23684e = userMetadata;
        this.f23685f = idManager;
    }

    private CrashlyticsReport.Session.Event g(CrashlyticsReport.Session.Event event) {
        return h(event, this.f23683d, this.f23684e);
    }

    private CrashlyticsReport.Session.Event h(CrashlyticsReport.Session.Event event, LogFileManager logFileManager, UserMetadata userMetadata) {
        CrashlyticsReport.Session.Event.Builder h2 = event.h();
        String c2 = logFileManager.c();
        if (c2 != null) {
            h2.d(CrashlyticsReport.Session.Event.Log.a().b(c2).a());
        } else {
            Logger.f().k("No log data to include with this event.");
        }
        List<CrashlyticsReport.CustomAttribute> r = r(userMetadata.f());
        List<CrashlyticsReport.CustomAttribute> r2 = r(userMetadata.g());
        if (!r.isEmpty() || !r2.isEmpty()) {
            h2.b(event.b().i().e(r).g(r2).a());
        }
        return h2.a();
    }

    private CrashlyticsReport.Session.Event i(CrashlyticsReport.Session.Event event) {
        return j(h(event, this.f23683d, this.f23684e), this.f23684e);
    }

    private CrashlyticsReport.Session.Event j(CrashlyticsReport.Session.Event event, UserMetadata userMetadata) {
        List<CrashlyticsReport.Session.Event.RolloutAssignment> h2 = userMetadata.h();
        if (h2.isEmpty()) {
            return event;
        }
        CrashlyticsReport.Session.Event.Builder h3 = event.h();
        h3.e(CrashlyticsReport.Session.Event.RolloutsState.a().b(h2).a());
        return h3.a();
    }

    @RequiresApi(api = 30)
    private static CrashlyticsReport.ApplicationExitInfo k(ApplicationExitInfo applicationExitInfo) {
        String str = null;
        try {
            InputStream a2 = applicationExitInfo.getTraceInputStream();
            if (a2 != null) {
                str = l(a2);
            }
        } catch (IOException e2) {
            Logger f2 = Logger.f();
            f2.m("Could not get input trace in application exit info: " + applicationExitInfo.toString() + " Error: " + e2);
        }
        return CrashlyticsReport.ApplicationExitInfo.a().c(applicationExitInfo.getImportance()).e(applicationExitInfo.getProcessName()).g(applicationExitInfo.getReason()).i(applicationExitInfo.getTimestamp()).d(applicationExitInfo.getPid()).f(applicationExitInfo.getPss()).h(applicationExitInfo.getRss()).j(str).a();
    }

    @RequiresApi(api = 19)
    @VisibleForTesting
    public static String l(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
            }
            byteArrayOutputStream.write(bArr, 0, read);
        }
    }

    public static SessionReportingCoordinator m(Context context, IdManager idManager, FileStore fileStore, AppData appData, LogFileManager logFileManager, UserMetadata userMetadata, StackTraceTrimmingStrategy stackTraceTrimmingStrategy, SettingsProvider settingsProvider, OnDemandCounter onDemandCounter, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber) {
        SettingsProvider settingsProvider2 = settingsProvider;
        FileStore fileStore2 = fileStore;
        Context context2 = context;
        return new SessionReportingCoordinator(new CrashlyticsReportDataCapture(context, idManager, appData, stackTraceTrimmingStrategy, settingsProvider), new CrashlyticsReportPersistence(fileStore, settingsProvider2, crashlyticsAppQualitySessionsSubscriber), DataTransportCrashlyticsReportSender.b(context, settingsProvider2, onDemandCounter), logFileManager, userMetadata, idManager);
    }

    private CrashlyticsReportWithSessionId n(CrashlyticsReportWithSessionId crashlyticsReportWithSessionId) {
        if (crashlyticsReportWithSessionId.b().h() != null && crashlyticsReportWithSessionId.b().g() != null) {
            return crashlyticsReportWithSessionId;
        }
        FirebaseInstallationId d2 = this.f23685f.d(true);
        return CrashlyticsReportWithSessionId.a(crashlyticsReportWithSessionId.b().u(d2.f()).t(d2.e()), crashlyticsReportWithSessionId.d(), crashlyticsReportWithSessionId.c());
    }

    @RequiresApi(api = 30)
    @Nullable
    private ApplicationExitInfo q(String str, List<ApplicationExitInfo> list) {
        long q = this.f23681b.q(str);
        for (ApplicationExitInfo a2 : list) {
            ApplicationExitInfo a3 = g.a(a2);
            if (a3.getTimestamp() < q) {
                return null;
            }
            if (a3.getReason() == 6) {
                return a3;
            }
        }
        return null;
    }

    @NonNull
    private static List<CrashlyticsReport.CustomAttribute> r(@NonNull Map<String, String> map) {
        ArrayList arrayList = new ArrayList();
        arrayList.ensureCapacity(map.size());
        for (Map.Entry next : map.entrySet()) {
            arrayList.add(CrashlyticsReport.CustomAttribute.a().b((String) next.getKey()).c((String) next.getValue()).a());
        }
        Collections.sort(arrayList, new q());
        return Collections.unmodifiableList(arrayList);
    }

    /* access modifiers changed from: private */
    public boolean v(@NonNull Task<CrashlyticsReportWithSessionId> task) {
        if (task.v()) {
            CrashlyticsReportWithSessionId r = task.r();
            Logger f2 = Logger.f();
            f2.b("Crashlytics report successfully enqueued to DataTransport: " + r.d());
            File c2 = r.c();
            if (c2.delete()) {
                Logger f3 = Logger.f();
                f3.b("Deleted report file: " + c2.getPath());
                return true;
            }
            Logger f4 = Logger.f();
            f4.m("Crashlytics could not delete report file: " + c2.getPath());
            return true;
        }
        Logger.f().n("Crashlytics report could not be enqueued to DataTransport", task.q());
        return false;
    }

    private void w(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, @NonNull String str2, long j2, boolean z) {
        boolean equals = str2.equals(f23675g);
        CrashlyticsReport.Session.Event d2 = this.f23680a.d(th, thread, str2, j2, 4, 8, z);
        String str3 = str;
        this.f23681b.z(i(d2), str, equals);
    }

    public void A() {
        this.f23681b.i();
    }

    public Task<Void> B(@NonNull Executor executor) {
        return C(executor, (String) null);
    }

    public Task<Void> C(@NonNull Executor executor, @Nullable String str) {
        List<CrashlyticsReportWithSessionId> w = this.f23681b.w();
        ArrayList arrayList = new ArrayList();
        for (CrashlyticsReportWithSessionId next : w) {
            if (str == null || str.equals(next.d())) {
                arrayList.add(this.f23682c.c(n(next), str != null).n(executor, new r(this)));
            }
        }
        return Tasks.h(arrayList);
    }

    public void a(String str, String str2) {
        this.f23684e.o(str, str2);
    }

    public void b(@NonNull String str, long j2) {
        this.f23681b.A(this.f23680a.e(str, j2));
    }

    public void c(long j2, String str) {
        this.f23683d.g(j2, str);
    }

    public void d(String str) {
        this.f23684e.s(str);
    }

    public void o(@NonNull String str, @NonNull List<NativeSessionFile> list, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        Logger.f().b("SessionReportingCoordinator#finalizeSessionWithNativeEvent");
        ArrayList arrayList = new ArrayList();
        for (NativeSessionFile b2 : list) {
            CrashlyticsReport.FilesPayload.File b3 = b2.b();
            if (b3 != null) {
                arrayList.add(b3);
            }
        }
        this.f23681b.l(str, CrashlyticsReport.FilesPayload.a().b(Collections.unmodifiableList(arrayList)).a(), applicationExitInfo);
    }

    public void p(long j2, @Nullable String str) {
        this.f23681b.k(str, j2);
    }

    public boolean s() {
        return this.f23681b.r();
    }

    public SortedSet<String> u() {
        return this.f23681b.p();
    }

    public void x(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, long j2) {
        Logger f2 = Logger.f();
        f2.k("Persisting fatal event for session " + str);
        w(th, thread, str, f23675g, j2, true);
    }

    public void y(@NonNull Throwable th, @NonNull Thread thread, @NonNull String str, long j2) {
        Logger f2 = Logger.f();
        f2.k("Persisting non-fatal event for session " + str);
        w(th, thread, str, "error", j2, false);
    }

    @RequiresApi(api = 30)
    public void z(String str, List<ApplicationExitInfo> list, LogFileManager logFileManager, UserMetadata userMetadata) {
        ApplicationExitInfo q = q(str, list);
        if (q == null) {
            Logger f2 = Logger.f();
            f2.k("No relevant ApplicationExitInfo occurred during session: " + str);
            return;
        }
        CrashlyticsReport.Session.Event c2 = this.f23680a.c(k(q));
        Logger f3 = Logger.f();
        f3.b("Persisting anr for session " + str);
        this.f23681b.z(j(h(c2, logFileManager, userMetadata), userMetadata), str, true);
    }
}
