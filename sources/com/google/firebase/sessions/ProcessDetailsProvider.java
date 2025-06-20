package com.google.firebase.sessions;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.google.android.gms.common.util.ProcessUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J5\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcom/google/firebase/sessions/ProcessDetailsProvider;", "", "<init>", "()V", "", "processName", "", "pid", "importance", "", "isDefaultProcess", "Lcom/google/firebase/sessions/ProcessDetails;", "a", "(Ljava/lang/String;IIZ)Lcom/google/firebase/sessions/ProcessDetails;", "Landroid/content/Context;", "context", "", "c", "(Landroid/content/Context;)Ljava/util/List;", "d", "(Landroid/content/Context;)Lcom/google/firebase/sessions/ProcessDetails;", "e", "()Ljava/lang/String;", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0})
@SourceDebugExtension({"SMAP\nProcessDetailsProvider.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ProcessDetailsProvider.kt\ncom/google/firebase/sessions/ProcessDetailsProvider\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,96:1\n766#2:97\n857#2,2:98\n1549#2:100\n1620#2,3:101\n1#3:104\n*S KotlinDebug\n*F\n+ 1 ProcessDetailsProvider.kt\ncom/google/firebase/sessions/ProcessDetailsProvider\n*L\n41#1:97\n41#1:98,2\n45#1:100\n45#1:101,3\n*E\n"})
public final class ProcessDetailsProvider {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final ProcessDetailsProvider f25074a = new ProcessDetailsProvider();

    private ProcessDetailsProvider() {
    }

    private final ProcessDetails a(String str, int i2, int i3, boolean z) {
        return new ProcessDetails(str, i2, i3, z);
    }

    static /* synthetic */ ProcessDetails b(ProcessDetailsProvider processDetailsProvider, String str, int i2, int i3, boolean z, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        if ((i4 & 8) != 0) {
            z = false;
        }
        return processDetailsProvider.a(str, i2, i3, z);
    }

    @NotNull
    public final List<ProcessDetails> c(@NotNull Context context) {
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
            String str2 = runningAppProcessInfo.processName;
            Intrinsics.o(str2, "runningAppProcessInfo.processName");
            arrayList2.add(new ProcessDetails(str2, runningAppProcessInfo.pid, runningAppProcessInfo.importance, Intrinsics.g(runningAppProcessInfo.processName, str)));
        }
        return arrayList2;
    }

    @NotNull
    public final ProcessDetails d(@NotNull Context context) {
        T t;
        Intrinsics.p(context, "context");
        int myPid = Process.myPid();
        Iterator<T> it2 = c(context).iterator();
        while (true) {
            if (!it2.hasNext()) {
                t = null;
                break;
            }
            t = it2.next();
            if (((ProcessDetails) t).h() == myPid) {
                break;
            }
        }
        ProcessDetails processDetails = (ProcessDetails) t;
        if (processDetails != null) {
            return processDetails;
        }
        return b(this, e(), myPid, 0, false, 12, (Object) null);
    }

    @NotNull
    public final String e() {
        String a2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            String a3 = Process.myProcessName();
            Intrinsics.o(a3, "myProcessName()");
            return a3;
        } else if (i2 >= 28 && (a2 = Application.getProcessName()) != null) {
            return a2;
        } else {
            String a4 = ProcessUtils.a();
            return a4 != null ? a4 : "";
        }
    }
}
