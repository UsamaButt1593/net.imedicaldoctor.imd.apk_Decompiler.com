package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@KeepForSdk
public class WorkSourceUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final int f20396a = Process.myUid();

    /* renamed from: b  reason: collision with root package name */
    private static final Method f20397b;

    /* renamed from: c  reason: collision with root package name */
    private static final Method f20398c;

    /* renamed from: d  reason: collision with root package name */
    private static final Method f20399d;

    /* renamed from: e  reason: collision with root package name */
    private static final Method f20400e;

    /* renamed from: f  reason: collision with root package name */
    private static final Method f20401f;

    /* renamed from: g  reason: collision with root package name */
    private static final Method f20402g;

    /* renamed from: h  reason: collision with root package name */
    private static final Method f20403h;

    /* renamed from: i  reason: collision with root package name */
    private static final Method f20404i;
    @GuardedBy("WorkSourceUtil.class")

    /* renamed from: j  reason: collision with root package name */
    private static Boolean f20405j = null;

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00a9  */
    static {
        /*
            r0 = 2
            r1 = 0
            r2 = 1
            java.lang.String r3 = "add"
            java.lang.Class<android.os.WorkSource> r4 = android.os.WorkSource.class
            int r5 = android.os.Process.myUid()
            f20396a = r5
            r5 = 0
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0019 }
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0019 }
            r6[r1] = r7     // Catch:{ Exception -> 0x0019 }
            java.lang.reflect.Method r6 = r4.getMethod(r3, r6)     // Catch:{ Exception -> 0x0019 }
            goto L_0x001b
        L_0x0019:
            r6 = r5
        L_0x001b:
            f20397b = r6
            boolean r6 = com.google.android.gms.common.util.PlatformVersion.g()
            java.lang.Class<java.lang.String> r7 = java.lang.String.class
            if (r6 == 0) goto L_0x0032
            java.lang.Class[] r6 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0032 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0032 }
            r6[r1] = r8     // Catch:{ Exception -> 0x0032 }
            r6[r2] = r7     // Catch:{ Exception -> 0x0032 }
            java.lang.reflect.Method r3 = r4.getMethod(r3, r6)     // Catch:{ Exception -> 0x0032 }
            goto L_0x0033
        L_0x0032:
            r3 = r5
        L_0x0033:
            f20398c = r3
            java.lang.String r3 = "size"
            java.lang.reflect.Method r3 = r4.getMethod(r3, r5)     // Catch:{ Exception -> 0x003c }
            goto L_0x003d
        L_0x003c:
            r3 = r5
        L_0x003d:
            f20399d = r3
            java.lang.String r3 = "get"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x004c }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x004c }
            r6[r1] = r8     // Catch:{ Exception -> 0x004c }
            java.lang.reflect.Method r3 = r4.getMethod(r3, r6)     // Catch:{ Exception -> 0x004c }
            goto L_0x004e
        L_0x004c:
            r3 = r5
        L_0x004e:
            f20400e = r3
            boolean r3 = com.google.android.gms.common.util.PlatformVersion.g()
            if (r3 == 0) goto L_0x0064
            java.lang.String r3 = "getName"
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ Exception -> 0x0063 }
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x0063 }
            r6[r1] = r8     // Catch:{ Exception -> 0x0063 }
            java.lang.reflect.Method r3 = r4.getMethod(r3, r6)     // Catch:{ Exception -> 0x0063 }
            goto L_0x0065
        L_0x0063:
        L_0x0064:
            r3 = r5
        L_0x0065:
            f20401f = r3
            boolean r3 = com.google.android.gms.common.util.PlatformVersion.o()
            java.lang.String r6 = "WorkSourceUtil"
            if (r3 == 0) goto L_0x007c
            java.lang.String r3 = "createWorkChain"
            java.lang.reflect.Method r3 = r4.getMethod(r3, r5)     // Catch:{ Exception -> 0x0076 }
            goto L_0x007d
        L_0x0076:
            r3 = move-exception
            java.lang.String r8 = "Missing WorkChain API createWorkChain"
            android.util.Log.w(r6, r8, r3)
        L_0x007c:
            r3 = r5
        L_0x007d:
            f20402g = r3
            boolean r3 = com.google.android.gms.common.util.PlatformVersion.o()
            if (r3 == 0) goto L_0x00a0
            java.lang.String r3 = "android.os.WorkSource$WorkChain"
            java.lang.Class r3 = java.lang.Class.forName(r3)     // Catch:{ Exception -> 0x009a }
            java.lang.String r8 = "addNode"
            java.lang.Class[] r0 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x009a }
            java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ Exception -> 0x009a }
            r0[r1] = r9     // Catch:{ Exception -> 0x009a }
            r0[r2] = r7     // Catch:{ Exception -> 0x009a }
            java.lang.reflect.Method r0 = r3.getMethod(r8, r0)     // Catch:{ Exception -> 0x009a }
            goto L_0x00a1
        L_0x009a:
            r0 = move-exception
            java.lang.String r1 = "Missing WorkChain class"
            android.util.Log.w(r6, r1, r0)
        L_0x00a0:
            r0 = r5
        L_0x00a1:
            f20403h = r0
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.o()
            if (r0 == 0) goto L_0x00b3
            java.lang.String r0 = "isEmpty"
            java.lang.reflect.Method r0 = r4.getMethod(r0, r5)     // Catch:{ Exception -> 0x00b3 }
            r0.setAccessible(r2)     // Catch:{ Exception -> 0x00b4 }
            goto L_0x00b4
        L_0x00b3:
            r0 = r5
        L_0x00b4:
            f20404i = r0
            f20405j = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.<clinit>():void");
    }

    private WorkSourceUtil() {
    }

    @KeepForSdk
    public static void a(@NonNull WorkSource workSource, int i2, @NonNull String str) {
        Method method = f20398c;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, new Object[]{Integer.valueOf(i2), str});
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        } else {
            Method method2 = f20397b;
            if (method2 != null) {
                try {
                    method2.invoke(workSource, new Object[]{Integer.valueOf(i2)});
                } catch (Exception e3) {
                    Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e3);
                }
            }
        }
    }

    @NonNull
    @KeepForSdk
    public static WorkSource b(@NonNull Context context, @NonNull String str) {
        String str2;
        if (context == null || context.getPackageManager() == null || str == null) {
            return null;
        }
        try {
            ApplicationInfo c2 = Wrappers.a(context).c(str, 0);
            if (c2 == null) {
                str2 = "Could not get applicationInfo from package: ";
                Log.e("WorkSourceUtil", str2.concat(str));
                return null;
            }
            int i2 = c2.uid;
            WorkSource workSource = new WorkSource();
            a(workSource, i2, str);
            return workSource;
        } catch (PackageManager.NameNotFoundException unused) {
            str2 = "Could not find package: ";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0030 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0031  */
    @androidx.annotation.NonNull
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.os.WorkSource c(@androidx.annotation.NonNull android.content.Context r9, @androidx.annotation.NonNull java.lang.String r10, @androidx.annotation.NonNull java.lang.String r11) {
        /*
            r0 = 1
            r1 = 2
            r2 = 0
            r3 = 0
            java.lang.String r4 = "WorkSourceUtil"
            if (r9 == 0) goto L_0x006f
            android.content.pm.PackageManager r5 = r9.getPackageManager()
            if (r5 == 0) goto L_0x006f
            if (r11 == 0) goto L_0x006f
            if (r10 != 0) goto L_0x0013
            goto L_0x006f
        L_0x0013:
            r5 = -1
            com.google.android.gms.common.wrappers.PackageManagerWrapper r9 = com.google.android.gms.common.wrappers.Wrappers.a(r9)     // Catch:{ NameNotFoundException -> 0x002b }
            android.content.pm.ApplicationInfo r9 = r9.c(r10, r2)     // Catch:{ NameNotFoundException -> 0x002b }
            if (r9 != 0) goto L_0x0028
            java.lang.String r9 = "Could not get applicationInfo from package: "
        L_0x0020:
            java.lang.String r9 = r9.concat(r10)
            android.util.Log.e(r4, r9)
            goto L_0x002e
        L_0x0028:
            int r5 = r9.uid
            goto L_0x002e
        L_0x002b:
            java.lang.String r9 = "Could not find package: "
            goto L_0x0020
        L_0x002e:
            if (r5 >= 0) goto L_0x0031
            return r3
        L_0x0031:
            android.os.WorkSource r9 = new android.os.WorkSource
            r9.<init>()
            java.lang.reflect.Method r6 = f20402g
            if (r6 == 0) goto L_0x006b
            java.lang.reflect.Method r7 = f20403h
            if (r7 != 0) goto L_0x003f
            goto L_0x006b
        L_0x003f:
            java.lang.Object r3 = r6.invoke(r9, r3)     // Catch:{ Exception -> 0x0055 }
            int r6 = f20396a     // Catch:{ Exception -> 0x0055 }
            if (r5 == r6) goto L_0x0057
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x0055 }
            java.lang.Object[] r8 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0055 }
            r8[r2] = r5     // Catch:{ Exception -> 0x0055 }
            r8[r0] = r10     // Catch:{ Exception -> 0x0055 }
            r7.invoke(r3, r8)     // Catch:{ Exception -> 0x0055 }
            goto L_0x0057
        L_0x0055:
            r10 = move-exception
            goto L_0x0065
        L_0x0057:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x0055 }
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0055 }
            r1[r2] = r10     // Catch:{ Exception -> 0x0055 }
            r1[r0] = r11     // Catch:{ Exception -> 0x0055 }
            r7.invoke(r3, r1)     // Catch:{ Exception -> 0x0055 }
            goto L_0x006e
        L_0x0065:
            java.lang.String r11 = "Unable to assign chained blame through WorkSource"
            android.util.Log.w(r4, r11, r10)
            goto L_0x006e
        L_0x006b:
            a(r9, r5, r10)
        L_0x006e:
            return r9
        L_0x006f:
            java.lang.String r9 = "Unexpected null arguments"
            android.util.Log.w(r4, r9)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.WorkSourceUtil.c(android.content.Context, java.lang.String, java.lang.String):android.os.WorkSource");
    }

    @KeepForSdk
    public static int d(@NonNull WorkSource workSource, int i2) {
        Method method = f20400e;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, new Object[]{Integer.valueOf(i2)});
                Preconditions.r(invoke);
                return ((Integer) invoke).intValue();
            } catch (Exception e2) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            }
        }
        return 0;
    }

    @NonNull
    @KeepForSdk
    public static String e(@NonNull WorkSource workSource, int i2) {
        Method method = f20401f;
        if (method == null) {
            return null;
        }
        try {
            return (String) method.invoke(workSource, new Object[]{Integer.valueOf(i2)});
        } catch (Exception e2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            return null;
        }
    }

    @NonNull
    @KeepForSdk
    public static List<String> f(@NonNull WorkSource workSource) {
        ArrayList arrayList = new ArrayList();
        int i2 = workSource == null ? 0 : i(workSource);
        if (i2 != 0) {
            for (int i3 = 0; i3 < i2; i3++) {
                String e2 = e(workSource, i3);
                if (!Strings.b(e2)) {
                    Preconditions.r(e2);
                    arrayList.add(e2);
                }
            }
        }
        return arrayList;
    }

    @KeepForSdk
    public static synchronized boolean g(@NonNull Context context) {
        synchronized (WorkSourceUtil.class) {
            Boolean bool = f20405j;
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                return booleanValue;
            }
            boolean z = false;
            if (context == null) {
                return false;
            }
            if (ContextCompat.a(context, "android.permission.UPDATE_DEVICE_STATS") == 0) {
                z = true;
            }
            f20405j = Boolean.valueOf(z);
            return z;
        }
    }

    @KeepForSdk
    public static boolean h(@NonNull WorkSource workSource) {
        Method method = f20404i;
        if (method != null) {
            try {
                Object invoke = method.invoke(workSource, (Object[]) null);
                Preconditions.r(invoke);
                return ((Boolean) invoke).booleanValue();
            } catch (Exception e2) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e2);
            }
        }
        return i(workSource) == 0;
    }

    @KeepForSdk
    public static int i(@NonNull WorkSource workSource) {
        Method method = f20399d;
        if (method == null) {
            return 0;
        }
        try {
            Object invoke = method.invoke(workSource, (Object[]) null);
            Preconditions.r(invoke);
            return ((Integer) invoke).intValue();
        } catch (Exception e2) {
            Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e2);
            return 0;
        }
    }
}
