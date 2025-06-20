package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import com.google.firebase.crashlytics.BuildConfig;
import com.google.firebase.crashlytics.internal.ProcessDetailsProvider;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.StackTraceTrimmingStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.TrimmedThrowableData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CrashlyticsReportDataCapture {

    /* renamed from: g  reason: collision with root package name */
    private static final Map<String, Integer> f23623g;

    /* renamed from: h  reason: collision with root package name */
    static final String f23624h = String.format(Locale.US, "Crashlytics Android SDK/%s", new Object[]{BuildConfig.f23471d});

    /* renamed from: i  reason: collision with root package name */
    static final int f23625i = 3;

    /* renamed from: j  reason: collision with root package name */
    static final int f23626j = 4;

    /* renamed from: k  reason: collision with root package name */
    static final int f23627k = 3;

    /* renamed from: l  reason: collision with root package name */
    static final String f23628l = "0";

    /* renamed from: a  reason: collision with root package name */
    private final Context f23629a;

    /* renamed from: b  reason: collision with root package name */
    private final IdManager f23630b;

    /* renamed from: c  reason: collision with root package name */
    private final AppData f23631c;

    /* renamed from: d  reason: collision with root package name */
    private final StackTraceTrimmingStrategy f23632d;

    /* renamed from: e  reason: collision with root package name */
    private final SettingsProvider f23633e;

    /* renamed from: f  reason: collision with root package name */
    private final ProcessDetailsProvider f23634f = ProcessDetailsProvider.f23508a;

    static {
        HashMap hashMap = new HashMap();
        f23623g = hashMap;
        hashMap.put("armeabi", 5);
        hashMap.put("armeabi-v7a", 6);
        hashMap.put("arm64-v8a", 9);
        hashMap.put("x86", 0);
        hashMap.put("x86_64", 1);
    }

    public CrashlyticsReportDataCapture(Context context, IdManager idManager, AppData appData, StackTraceTrimmingStrategy stackTraceTrimmingStrategy, SettingsProvider settingsProvider) {
        this.f23629a = context;
        this.f23630b = idManager;
        this.f23631c = appData;
        this.f23632d = stackTraceTrimmingStrategy;
        this.f23633e = settingsProvider;
    }

    private CrashlyticsReport.Session.Event.Application.ProcessDetails A(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        return this.f23634f.c(applicationExitInfo.e(), applicationExitInfo.d(), applicationExitInfo.c());
    }

    private CrashlyticsReport.ApplicationExitInfo a(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        List list;
        if (!this.f23633e.b().f24264b.f24273c || this.f23631c.f23530c.size() <= 0) {
            list = null;
        } else {
            ArrayList arrayList = new ArrayList();
            for (BuildIdInfo next : this.f23631c.f23530c) {
                arrayList.add(CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.a().d(next.c()).b(next.a()).c(next.b()).a());
            }
            list = Collections.unmodifiableList(arrayList);
        }
        return CrashlyticsReport.ApplicationExitInfo.a().c(applicationExitInfo.c()).e(applicationExitInfo.e()).g(applicationExitInfo.g()).i(applicationExitInfo.i()).d(applicationExitInfo.d()).f(applicationExitInfo.f()).h(applicationExitInfo.h()).j(applicationExitInfo.j()).b(list).a();
    }

    private CrashlyticsReport.Builder b() {
        return CrashlyticsReport.b().l(BuildConfig.f23471d).h(this.f23631c.f23528a).i(this.f23630b.a().c()).g(this.f23630b.a().e()).f(this.f23630b.a().d()).d(this.f23631c.f23533f).e(this.f23631c.f23534g).k(4);
    }

    private static long f(long j2) {
        if (j2 > 0) {
            return j2;
        }
        return 0;
    }

    private static int g() {
        Integer num;
        String str = Build.CPU_ABI;
        if (!TextUtils.isEmpty(str) && (num = f23623g.get(str.toLowerCase(Locale.US))) != null) {
            return num.intValue();
        }
        return 7;
    }

    private CrashlyticsReport.Session.Event.Application.Execution.BinaryImage h() {
        return CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.a().b(0).d(0).c(this.f23631c.f23532e).e(this.f23631c.f23529b).a();
    }

    private List<CrashlyticsReport.Session.Event.Application.Execution.BinaryImage> i() {
        return Collections.singletonList(h());
    }

    private CrashlyticsReport.Session.Event.Application j(int i2, CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        return CrashlyticsReport.Session.Event.Application.a().c(Boolean.valueOf(applicationExitInfo.c() != 100)).d(A(applicationExitInfo)).h(i2).f(o(applicationExitInfo)).a();
    }

    private CrashlyticsReport.Session.Event.Application k(int i2, TrimmedThrowableData trimmedThrowableData, Thread thread, int i3, int i4, boolean z) {
        Boolean bool;
        CrashlyticsReport.Session.Event.Application.ProcessDetails g2 = this.f23634f.g(this.f23629a);
        if (g2.b() > 0) {
            bool = Boolean.valueOf(g2.b() != 100);
        } else {
            bool = null;
        }
        return CrashlyticsReport.Session.Event.Application.a().c(bool).d(g2).b(this.f23634f.f(this.f23629a)).h(i2).f(p(trimmedThrowableData, thread, i3, i4, z)).a();
    }

    private CrashlyticsReport.Session.Event.Device l(int i2) {
        BatteryState a2 = BatteryState.a(this.f23629a);
        Float b2 = a2.b();
        Double valueOf = b2 != null ? Double.valueOf(b2.doubleValue()) : null;
        int c2 = a2.c();
        boolean o = CommonUtils.o(this.f23629a);
        return CrashlyticsReport.Session.Event.Device.a().b(valueOf).c(c2).f(o).e(i2).g(f(CommonUtils.b(this.f23629a) - CommonUtils.a(this.f23629a))).d(CommonUtils.c(Environment.getDataDirectory().getPath())).a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Exception m(TrimmedThrowableData trimmedThrowableData, int i2, int i3) {
        return n(trimmedThrowableData, i2, i3, 0);
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Exception n(TrimmedThrowableData trimmedThrowableData, int i2, int i3, int i4) {
        String str = trimmedThrowableData.f24318b;
        String str2 = trimmedThrowableData.f24317a;
        StackTraceElement[] stackTraceElementArr = trimmedThrowableData.f24319c;
        int i5 = 0;
        if (stackTraceElementArr == null) {
            stackTraceElementArr = new StackTraceElement[0];
        }
        TrimmedThrowableData trimmedThrowableData2 = trimmedThrowableData.f24320d;
        if (i4 >= i3) {
            TrimmedThrowableData trimmedThrowableData3 = trimmedThrowableData2;
            while (trimmedThrowableData3 != null) {
                trimmedThrowableData3 = trimmedThrowableData3.f24320d;
                i5++;
            }
        }
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder d2 = CrashlyticsReport.Session.Event.Application.Execution.Exception.a().f(str).e(str2).c(r(stackTraceElementArr, i2)).d(i5);
        if (trimmedThrowableData2 != null && i5 == 0) {
            d2.b(n(trimmedThrowableData2, i2, i3, i4 + 1));
        }
        return d2.a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution o(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        return CrashlyticsReport.Session.Event.Application.Execution.a().b(applicationExitInfo).e(w()).c(i()).a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution p(TrimmedThrowableData trimmedThrowableData, Thread thread, int i2, int i3, boolean z) {
        return CrashlyticsReport.Session.Event.Application.Execution.a().f(z(trimmedThrowableData, thread, i2, z)).d(m(trimmedThrowableData, i2, i3)).e(w()).c(i()).a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame q(StackTraceElement stackTraceElement, CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder builder) {
        long j2 = 0;
        long max = stackTraceElement.isNativeMethod() ? Math.max((long) stackTraceElement.getLineNumber(), 0) : 0;
        String str = stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName();
        String fileName = stackTraceElement.getFileName();
        if (!stackTraceElement.isNativeMethod() && stackTraceElement.getLineNumber() > 0) {
            j2 = (long) stackTraceElement.getLineNumber();
        }
        return builder.e(max).f(str).b(fileName).d(j2).a();
    }

    private List<CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame> r(StackTraceElement[] stackTraceElementArr, int i2) {
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement q : stackTraceElementArr) {
            arrayList.add(q(q, CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.a().c(i2)));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private CrashlyticsReport.Session.Application s() {
        return CrashlyticsReport.Session.Application.a().e(this.f23630b.f()).h(this.f23631c.f23533f).d(this.f23631c.f23534g).f(this.f23630b.a().c()).b(this.f23631c.f23535h.d()).c(this.f23631c.f23535h.e()).a();
    }

    private CrashlyticsReport.Session t(String str, long j2) {
        return CrashlyticsReport.Session.a().m(j2).j(str).h(f23624h).b(s()).l(v()).e(u()).i(3).a();
    }

    private CrashlyticsReport.Session.Device u() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        int g2 = g();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        long b2 = CommonUtils.b(this.f23629a);
        long blockCount = ((long) statFs.getBlockCount()) * ((long) statFs.getBlockSize());
        boolean x = CommonUtils.x();
        int l2 = CommonUtils.l();
        String str = Build.MANUFACTURER;
        return CrashlyticsReport.Session.Device.a().b(g2).f(Build.MODEL).c(availableProcessors).h(b2).d(blockCount).i(x).j(l2).e(str).g(Build.PRODUCT).a();
    }

    private CrashlyticsReport.Session.OperatingSystem v() {
        return CrashlyticsReport.Session.OperatingSystem.a().d(3).e(Build.VERSION.RELEASE).b(Build.VERSION.CODENAME).c(CommonUtils.z()).a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Signal w() {
        return CrashlyticsReport.Session.Event.Application.Execution.Signal.a().d(f23628l).c(f23628l).b(0).a();
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread x(Thread thread, StackTraceElement[] stackTraceElementArr) {
        return y(thread, stackTraceElementArr, 0);
    }

    private CrashlyticsReport.Session.Event.Application.Execution.Thread y(Thread thread, StackTraceElement[] stackTraceElementArr, int i2) {
        return CrashlyticsReport.Session.Event.Application.Execution.Thread.a().d(thread.getName()).c(i2).b(r(stackTraceElementArr, i2)).a();
    }

    private List<CrashlyticsReport.Session.Event.Application.Execution.Thread> z(TrimmedThrowableData trimmedThrowableData, Thread thread, int i2, boolean z) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(y(thread, trimmedThrowableData.f24319c, i2));
        if (z) {
            for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
                Thread thread2 = (Thread) next.getKey();
                if (!thread2.equals(thread)) {
                    arrayList.add(x(thread2, this.f23632d.a((StackTraceElement[]) next.getValue())));
                }
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public CrashlyticsReport.Session.Event c(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        int i2 = this.f23629a.getResources().getConfiguration().orientation;
        return CrashlyticsReport.Session.Event.a().g("anr").f(applicationExitInfo.i()).b(j(i2, a(applicationExitInfo))).c(l(i2)).a();
    }

    public CrashlyticsReport.Session.Event d(Throwable th, Thread thread, String str, long j2, int i2, int i3, boolean z) {
        int i4 = this.f23629a.getResources().getConfiguration().orientation;
        Throwable th2 = th;
        String str2 = str;
        long j3 = j2;
        return CrashlyticsReport.Session.Event.a().g(str).f(j2).b(k(i4, TrimmedThrowableData.a(th, this.f23632d), thread, i2, i3, z)).c(l(i4)).a();
    }

    public CrashlyticsReport e(String str, long j2) {
        return b().m(t(str, j2)).a();
    }
}
