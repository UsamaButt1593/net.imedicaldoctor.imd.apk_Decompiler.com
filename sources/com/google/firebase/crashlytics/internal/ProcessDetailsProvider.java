package com.google.firebase.crashlytics.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\r\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ5\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00042\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/firebase/crashlytics/internal/ProcessDetailsProvider;", "", "<init>", "()V", "", "h", "()Ljava/lang/String;", "Landroid/content/Context;", "context", "", "Lcom/google/firebase/crashlytics/internal/model/CrashlyticsReport$Session$Event$Application$ProcessDetails;", "f", "(Landroid/content/Context;)Ljava/util/List;", "g", "(Landroid/content/Context;)Lcom/google/firebase/crashlytics/internal/model/CrashlyticsReport$Session$Event$Application$ProcessDetails;", "processName", "", "pid", "importance", "", "isDefaultProcess", "d", "(Ljava/lang/String;IIZ)Lcom/google/firebase/crashlytics/internal/model/CrashlyticsReport$Session$Event$Application$ProcessDetails;", "com.google.firebase-firebase-crashlytics"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nProcessDetailsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessDetailsProvider.kt\ncom/google/firebase/crashlytics/internal/ProcessDetailsProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,92:1\n766#2:93\n857#2,2:94\n1549#2:96\n1620#2,3:97\n1#3:100\n*S KotlinDebug\n*F\n+ 1 ProcessDetailsProvider.kt\ncom/google/firebase/crashlytics/internal/ProcessDetailsProvider\n*L\n41#1:93\n41#1:94,2\n45#1:96\n45#1:97,3\n*E\n"})
public final class ProcessDetailsProvider {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final ProcessDetailsProvider f23508a = new ProcessDetailsProvider();

    private ProcessDetailsProvider() {
    }

    public static /* synthetic */ CrashlyticsReport.Session.Event.Application.ProcessDetails e(ProcessDetailsProvider processDetailsProvider, String str, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        if ((i4 & 8) != 0) {
            z = false;
        }
        return processDetailsProvider.d(str, i2, i3, z);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0016, code lost:
        r0 = android.app.Application.getProcessName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String h() {
        /*
            r3 = this;
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            if (r0 < r1) goto L_0x0010
            java.lang.String r0 = android.os.Process.myProcessName()
            java.lang.String r1 = "{\n      Process.myProcessName()\n    }"
            kotlin.jvm.internal.Intrinsics.o(r0, r1)
            goto L_0x001d
        L_0x0010:
            r1 = 28
            java.lang.String r2 = ""
            if (r0 < r1) goto L_0x001c
            java.lang.String r0 = android.app.Application.getProcessName()
            if (r0 != 0) goto L_0x001d
        L_0x001c:
            r0 = r2
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.ProcessDetailsProvider.h():java.lang.String");
    }

    @NotNull
    @JvmOverloads
    public final CrashlyticsReport.Session.Event.Application.ProcessDetails a(@NotNull String str) {
        Intrinsics.p(str, "processName");
        return e(this, str, 0, 0, false, 14, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final CrashlyticsReport.Session.Event.Application.ProcessDetails b(@NotNull String str, int i2) {
        Intrinsics.p(str, "processName");
        return e(this, str, i2, 0, false, 12, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final CrashlyticsReport.Session.Event.Application.ProcessDetails c(@NotNull String str, int i2, int i3) {
        Intrinsics.p(str, "processName");
        return e(this, str, i2, i3, false, 8, (Object) null);
    }

    @NotNull
    @JvmOverloads
    public final CrashlyticsReport.Session.Event.Application.ProcessDetails d(@NotNull String str, int i2, int i3, boolean z) {
        Intrinsics.p(str, "processName");
        CrashlyticsReport.Session.Event.Application.ProcessDetails a2 = CrashlyticsReport.Session.Event.Application.ProcessDetails.a().e(str).d(i2).c(i3).b(z).a();
        Intrinsics.o(a2, "builder()\n      .setProc…ltProcess)\n      .build()");
        return a2;
    }

    @NotNull
    public final List<CrashlyticsReport.Session.Event.Application.ProcessDetails> f(@NotNull Context context) {
        Intrinsics.p(context, "context");
        int i2 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        List<ActivityManager.RunningAppProcessInfo> list = null;
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        if (activityManager != null) {
            list = activityManager.getRunningAppProcesses();
        }
        if (list == null) {
            list = CollectionsKt.E();
        }
        List<T> p2 = CollectionsKt.p2(list);
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList = new ArrayList<>();
        for (T next : p2) {
            if (((ActivityManager.RunningAppProcessInfo) next).uid == i2) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.Y(arrayList, 10));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList) {
            arrayList2.add(CrashlyticsReport.Session.Event.Application.ProcessDetails.a().e(runningAppProcessInfo.processName).d(runningAppProcessInfo.pid).c(runningAppProcessInfo.importance).b(Intrinsics.g(runningAppProcessInfo.processName, str)).a());
        }
        return arrayList2;
    }

    @NotNull
    public final CrashlyticsReport.Session.Event.Application.ProcessDetails g(@NotNull Context context) {
        T t;
        Intrinsics.p(context, "context");
        int myPid = Process.myPid();
        Iterator<T> it2 = f(context).iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (((CrashlyticsReport.Session.Event.Application.ProcessDetails) t).c() == myPid) {
                break;
            }
        }
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = (CrashlyticsReport.Session.Event.Application.ProcessDetails) t;
        if (processDetails != null) {
            return processDetails;
        }
        return e(this, h(), myPid, 0, false, 12, (Object) null);
    }
}
