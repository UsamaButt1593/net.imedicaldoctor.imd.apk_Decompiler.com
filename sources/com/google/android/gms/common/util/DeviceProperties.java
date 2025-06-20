package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.hardware.SensorManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.apps.common.proguard.SideEffectFree;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class DeviceProperties {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f20362a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f20363b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f20364c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f20365d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static Boolean f20366e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private static Boolean f20367f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f20368g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f20369h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private static Boolean f20370i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private static Boolean f20371j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private static Boolean f20372k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private static Boolean f20373l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private static Boolean f20374m;
    @Nullable

    /* renamed from: n  reason: collision with root package name */
    private static Boolean f20375n;

    private DeviceProperties() {
    }

    @KeepForSdk
    public static boolean a(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f20371j == null) {
            boolean z = false;
            if (PlatformVersion.n() && packageManager.hasSystemFeature("android.hardware.type.automotive")) {
                z = true;
            }
            f20371j = Boolean.valueOf(z);
        }
        return f20371j.booleanValue();
    }

    @KeepForSdk
    public static boolean b(@NonNull Context context) {
        if (f20374m == null) {
            boolean z = false;
            if (PlatformVersion.q() && context.getPackageManager().hasSystemFeature("com.google.android.play.feature.HPE_EXPERIENCE")) {
                z = true;
            }
            f20374m = Boolean.valueOf(z);
        }
        return f20374m.booleanValue();
    }

    @KeepForSdk
    public static boolean c(@NonNull Context context) {
        if (f20364c == null) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            boolean z = false;
            if (!(!PlatformVersion.q() || sensorManager == null || sensorManager.getDefaultSensor(36) == null)) {
                z = true;
            }
            f20364c = Boolean.valueOf(z);
        }
        return f20364c.booleanValue();
    }

    @KeepForSdk
    public static boolean d(@NonNull Context context) {
        if (f20368g == null) {
            PackageManager packageManager = context.getPackageManager();
            boolean z = false;
            if (packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services")) {
                z = true;
            }
            f20368g = Boolean.valueOf(z);
        }
        return f20368g.booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006c, code lost:
        if (n(r4) == false) goto L_0x0070;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean e(@androidx.annotation.NonNull android.content.Context r4) {
        /*
            java.lang.Boolean r0 = f20362a
            if (r0 != 0) goto L_0x0076
            boolean r0 = c(r4)
            r1 = 1
            if (r0 != 0) goto L_0x0070
            boolean r0 = h(r4)
            r2 = 0
            if (r0 != 0) goto L_0x006f
            boolean r0 = l(r4)
            if (r0 != 0) goto L_0x006f
            boolean r0 = p(r4)
            if (r0 != 0) goto L_0x006f
            java.lang.Boolean r0 = f20370i
            if (r0 != 0) goto L_0x0032
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            java.lang.String r3 = "org.chromium.arc"
            boolean r0 = r0.hasSystemFeature(r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            f20370i = r0
        L_0x0032:
            java.lang.Boolean r0 = f20370i
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x006f
            boolean r0 = a(r4)
            if (r0 != 0) goto L_0x006f
            boolean r0 = j(r4)
            if (r0 != 0) goto L_0x006f
            java.lang.Boolean r0 = f20373l
            if (r0 != 0) goto L_0x005a
            android.content.pm.PackageManager r0 = r4.getPackageManager()
            java.lang.String r3 = "com.google.android.feature.AMATI_EXPERIENCE"
            boolean r0 = r0.hasSystemFeature(r3)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            f20373l = r0
        L_0x005a:
            java.lang.Boolean r0 = f20373l
            boolean r0 = r0.booleanValue()
            if (r0 != 0) goto L_0x006f
            boolean r0 = b(r4)
            if (r0 != 0) goto L_0x006f
            boolean r4 = n(r4)
            if (r4 != 0) goto L_0x006f
            goto L_0x0070
        L_0x006f:
            r1 = 0
        L_0x0070:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)
            f20362a = r4
        L_0x0076:
            java.lang.Boolean r4 = f20362a
            boolean r4 = r4.booleanValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.DeviceProperties.e(android.content.Context):boolean");
    }

    @KeepForSdk
    public static boolean f(@NonNull Context context) {
        return q(context.getResources());
    }

    @TargetApi(21)
    @KeepForSdk
    public static boolean g(@NonNull Context context) {
        return o(context);
    }

    @KeepForSdk
    public static boolean h(@NonNull Context context) {
        return i(context.getResources());
    }

    @KeepForSdk
    public static boolean i(@NonNull Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (f20363b == null) {
            if ((resources.getConfiguration().screenLayout & 15) > 3 || q(resources)) {
                z = true;
            }
            f20363b = Boolean.valueOf(z);
        }
        return f20363b.booleanValue();
    }

    @KeepForSdk
    public static boolean j(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f20372k == null) {
            boolean z = true;
            if (!packageManager.hasSystemFeature("com.google.android.tv") && !packageManager.hasSystemFeature("android.hardware.type.television") && !packageManager.hasSystemFeature("android.software.leanback")) {
                z = false;
            }
            f20372k = Boolean.valueOf(z);
        }
        return f20372k.booleanValue();
    }

    @KeepForSdk
    public static boolean k() {
        int i2 = GooglePlayServicesUtilLight.f19883a;
        return "user".equals(Build.TYPE);
    }

    @SideEffectFree
    @TargetApi(20)
    @KeepForSdk
    public static boolean l(@NonNull Context context) {
        return r(context.getPackageManager());
    }

    @TargetApi(26)
    @KeepForSdk
    public static boolean m(@NonNull Context context) {
        if (l(context) && !PlatformVersion.m()) {
            return true;
        }
        if (o(context)) {
            return !PlatformVersion.n() || PlatformVersion.q();
        }
        return false;
    }

    @KeepForSdk
    public static boolean n(@NonNull Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (f20375n == null) {
            f20375n = Boolean.valueOf(packageManager.hasSystemFeature("android.software.xr.immersive"));
        }
        return f20375n.booleanValue();
    }

    @TargetApi(21)
    public static boolean o(@NonNull Context context) {
        if (f20367f == null) {
            boolean z = false;
            if (PlatformVersion.j() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z = true;
            }
            f20367f = Boolean.valueOf(z);
        }
        return f20367f.booleanValue();
    }

    public static boolean p(@NonNull Context context) {
        if (f20369h == null) {
            boolean z = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z = false;
            }
            f20369h = Boolean.valueOf(z);
        }
        return f20369h.booleanValue();
    }

    public static boolean q(@NonNull Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (f20365d == null) {
            Configuration configuration = resources.getConfiguration();
            if ((configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600) {
                z = true;
            }
            f20365d = Boolean.valueOf(z);
        }
        return f20365d.booleanValue();
    }

    @SideEffectFree
    @TargetApi(20)
    public static boolean r(@NonNull PackageManager packageManager) {
        if (f20366e == null) {
            boolean z = false;
            if (PlatformVersion.i() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z = true;
            }
            f20366e = Boolean.valueOf(z);
        }
        return f20366e.booleanValue();
    }
}
