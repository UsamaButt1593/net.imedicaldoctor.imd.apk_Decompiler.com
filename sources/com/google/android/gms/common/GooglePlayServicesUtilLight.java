package com.google.android.gms.common;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.UidVerifier;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.errorprone.annotations.InlineMe;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import com.itextpdf.text.pdf.PdfBoolean;
import java.util.concurrent.atomic.AtomicBoolean;

@ShowFirstParty
@KeepForSdk
public class GooglePlayServicesUtilLight {
    @KeepForSdk
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final int f19883a = 12451000;
    @NonNull
    @KeepForSdk
    @Deprecated

    /* renamed from: b  reason: collision with root package name */
    public static final String f19884b = "com.google.android.gms";
    @NonNull
    @KeepForSdk

    /* renamed from: c  reason: collision with root package name */
    public static final String f19885c = "com.google.android.play.games";
    @NonNull
    @KeepForSdk

    /* renamed from: d  reason: collision with root package name */
    public static final String f19886d = "com.android.vending";
    @KeepForSdk

    /* renamed from: e  reason: collision with root package name */
    static final int f19887e = 39789;
    @KeepForSdk

    /* renamed from: f  reason: collision with root package name */
    static final int f19888f = 10436;
    @KeepForSdk
    @Deprecated

    /* renamed from: g  reason: collision with root package name */
    static final AtomicBoolean f19889g = new AtomicBoolean();

    /* renamed from: h  reason: collision with root package name */
    private static boolean f19890h = false;
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    static boolean f19891i = false;

    /* renamed from: j  reason: collision with root package name */
    private static final AtomicBoolean f19892j = new AtomicBoolean();

    @KeepForSdk
    GooglePlayServicesUtilLight() {
    }

    @KeepForSdk
    @Deprecated
    public static void a(@NonNull Context context) {
        if (!f19889g.getAndSet(true)) {
            try {
                NotificationManager notificationManager = (NotificationManager) context.getSystemService("notification");
                if (notificationManager != null) {
                    notificationManager.cancel(f19888f);
                }
            } catch (SecurityException e2) {
                Log.d("GooglePlayServicesUtil", "Suppressing Security Exception %s in cancelAvailabilityErrorNotifications.", e2);
            }
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public static void b() {
        f19892j.set(true);
    }

    @KeepForSdk
    @Deprecated
    public static void c(@NonNull Context context, int i2) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int k2 = GoogleApiAvailabilityLight.i().k(context, i2);
        if (k2 != 0) {
            Intent e2 = GoogleApiAvailabilityLight.i().e(context, k2, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + k2);
            if (e2 == null) {
                throw new GooglePlayServicesNotAvailableException(k2);
            }
            throw new GooglePlayServicesRepairableException(k2, "Google Play Services not available", e2);
        }
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static int d(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static int e(@NonNull Context context) {
        Preconditions.x(true);
        return ClientLibraryUtils.a(context, context.getPackageName());
    }

    @InlineMe(imports = {"com.google.android.gms.common.GoogleApiAvailabilityLight"}, replacement = "GoogleApiAvailabilityLight.getInstance().getErrorResolutionPendingIntent(context, errorCode, requestCode)")
    @Nullable
    @KeepForSdk
    @Deprecated
    public static PendingIntent f(int i2, @NonNull Context context, int i3) {
        return GoogleApiAvailabilityLight.i().f(context, i2, i3);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static String g(int i2) {
        return ConnectionResult.Q(i2);
    }

    @InlineMe(imports = {"com.google.android.gms.common.GoogleApiAvailabilityLight"}, replacement = "GoogleApiAvailabilityLight.getInstance().getErrorResolutionIntent(null, errorCode, null)")
    @ShowFirstParty
    @Nullable
    @KeepForSdk
    @Deprecated
    public static Intent h(int i2) {
        return GoogleApiAvailabilityLight.i().e((Context) null, i2, (String) null);
    }

    @KeepForSdk
    @Nullable
    public static Context i(@NonNull Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @KeepForSdk
    @Nullable
    public static Resources j(@NonNull Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @ShowFirstParty
    @KeepForSdk
    public static boolean k(@NonNull Context context) {
        if (!f19891i) {
            try {
                PackageInfo f2 = Wrappers.a(context).f("com.google.android.gms", 64);
                GoogleSignatureVerifier.a(context);
                if (f2 == null || GoogleSignatureVerifier.f(f2, false) || !GoogleSignatureVerifier.f(f2, true)) {
                    f19890h = false;
                } else {
                    f19890h = true;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e2);
            } catch (Throwable th) {
                f19891i = true;
                throw th;
            }
            f19891i = true;
        }
        return f19890h || !DeviceProperties.k();
    }

    @HideFirstParty
    @ResultIgnorabilityUnspecified
    @KeepForSdk
    @Deprecated
    public static int l(@NonNull Context context) {
        return m(context, f19883a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0093  */
    @com.google.android.gms.common.annotation.KeepForSdk
    @java.lang.Deprecated
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m(@androidx.annotation.NonNull android.content.Context r10, int r11) {
        /*
            java.lang.String r0 = "GooglePlayServicesUtil"
            android.content.res.Resources r1 = r10.getResources()     // Catch:{ all -> 0x000c }
            int r2 = com.google.android.gms.common.R.string.f19905a     // Catch:{ all -> 0x000c }
            r1.getString(r2)     // Catch:{ all -> 0x000c }
            goto L_0x0011
        L_0x000c:
            java.lang.String r1 = "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included."
            android.util.Log.e(r0, r1)
        L_0x0011:
            java.lang.String r1 = r10.getPackageName()
            java.lang.String r2 = "com.google.android.gms"
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L_0x003d
            java.util.concurrent.atomic.AtomicBoolean r1 = f19892j
            boolean r1 = r1.get()
            if (r1 == 0) goto L_0x0026
            goto L_0x003d
        L_0x0026:
            int r1 = com.google.android.gms.common.internal.zzah.a(r10)
            if (r1 == 0) goto L_0x0037
            int r3 = f19883a
            if (r1 != r3) goto L_0x0031
            goto L_0x003d
        L_0x0031:
            com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException r10 = new com.google.android.gms.common.GooglePlayServicesIncorrectManifestValueException
            r10.<init>(r1)
            throw r10
        L_0x0037:
            com.google.android.gms.common.GooglePlayServicesMissingManifestValueException r10 = new com.google.android.gms.common.GooglePlayServicesMissingManifestValueException
            r10.<init>()
            throw r10
        L_0x003d:
            boolean r1 = com.google.android.gms.common.util.DeviceProperties.m(r10)
            r3 = 1
            r4 = 0
            if (r1 != 0) goto L_0x004d
            boolean r1 = com.google.android.gms.common.util.DeviceProperties.p(r10)
            if (r1 != 0) goto L_0x004d
            r1 = 1
            goto L_0x004e
        L_0x004d:
            r1 = 0
        L_0x004e:
            if (r11 < 0) goto L_0x0052
            r5 = 1
            goto L_0x0053
        L_0x0052:
            r5 = 0
        L_0x0053:
            com.google.android.gms.common.internal.Preconditions.a(r5)
            java.lang.String r5 = r10.getPackageName()
            android.content.pm.PackageManager r6 = r10.getPackageManager()
            r7 = 9
            if (r1 == 0) goto L_0x007c
            java.lang.String r8 = "com.android.vending"
            r9 = 8256(0x2040, float:1.1569E-41)
            android.content.pm.PackageInfo r8 = r6.getPackageInfo(r8, r9)     // Catch:{ NameNotFoundException -> 0x006b }
            goto L_0x007d
        L_0x006b:
            java.lang.String r10 = java.lang.String.valueOf(r5)
            java.lang.String r11 = " requires the Google Play Store, but it is missing."
        L_0x0071:
            java.lang.String r10 = r10.concat(r11)
            android.util.Log.w(r0, r10)
            r3 = 9
            goto L_0x011e
        L_0x007c:
            r8 = 0
        L_0x007d:
            r9 = 64
            android.content.pm.PackageInfo r9 = r6.getPackageInfo(r2, r9)     // Catch:{ NameNotFoundException -> 0x0111 }
            com.google.android.gms.common.GoogleSignatureVerifier.a(r10)
            boolean r10 = com.google.android.gms.common.GoogleSignatureVerifier.f(r9, r3)
            if (r10 != 0) goto L_0x0093
            java.lang.String r10 = java.lang.String.valueOf(r5)
            java.lang.String r11 = " requires Google Play services, but their signature is invalid."
            goto L_0x0071
        L_0x0093:
            if (r1 == 0) goto L_0x00a5
            com.google.android.gms.common.internal.Preconditions.r(r8)
            boolean r10 = com.google.android.gms.common.GoogleSignatureVerifier.f(r8, r3)
            if (r10 != 0) goto L_0x00a5
            java.lang.String r10 = java.lang.String.valueOf(r5)
            java.lang.String r11 = " requires Google Play Store, but its signature is invalid."
            goto L_0x0071
        L_0x00a5:
            if (r1 == 0) goto L_0x00be
            if (r8 == 0) goto L_0x00be
            android.content.pm.Signature[] r10 = r8.signatures
            r10 = r10[r4]
            android.content.pm.Signature[] r1 = r9.signatures
            r1 = r1[r4]
            boolean r10 = r10.equals(r1)
            if (r10 != 0) goto L_0x00be
            java.lang.String r10 = java.lang.String.valueOf(r5)
            java.lang.String r11 = " requires Google Play Store, but its signature doesn't match that of Google Play services."
            goto L_0x0071
        L_0x00be:
            int r10 = r9.versionCode
            int r10 = com.google.android.gms.common.util.zza.a(r10)
            int r1 = com.google.android.gms.common.util.zza.a(r11)
            if (r10 >= r1) goto L_0x00f2
            int r10 = r9.versionCode
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Google Play services out of date for "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r2 = ".  Requires "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = " but found "
            r1.append(r11)
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            android.util.Log.w(r0, r10)
            r3 = 2
            goto L_0x011e
        L_0x00f2:
            android.content.pm.ApplicationInfo r10 = r9.applicationInfo
            if (r10 != 0) goto L_0x010a
            android.content.pm.ApplicationInfo r10 = r6.getApplicationInfo(r2, r4)     // Catch:{ NameNotFoundException -> 0x00fb }
            goto L_0x010a
        L_0x00fb:
            r10 = move-exception
            java.lang.String r11 = java.lang.String.valueOf(r5)
            java.lang.String r1 = " requires Google Play services, but they're missing when getting application info."
            java.lang.String r11 = r11.concat(r1)
            android.util.Log.wtf(r0, r11, r10)
            goto L_0x011e
        L_0x010a:
            boolean r10 = r10.enabled
            if (r10 != 0) goto L_0x0110
            r3 = 3
            goto L_0x011e
        L_0x0110:
            return r4
        L_0x0111:
            java.lang.String r10 = java.lang.String.valueOf(r5)
            java.lang.String r11 = " requires Google Play services, but they are missing."
            java.lang.String r10 = r10.concat(r11)
            android.util.Log.w(r0, r10)
        L_0x011e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GooglePlayServicesUtilLight.m(android.content.Context, int):int");
    }

    @InlineMe(imports = {"com.google.android.gms.common.util.UidVerifier"}, replacement = "UidVerifier.isGooglePlayServicesUid(context, uid)")
    @KeepForSdk
    @Deprecated
    public static boolean n(@NonNull Context context, int i2) {
        return UidVerifier.a(context, i2);
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static boolean o(@NonNull Context context, int i2) {
        if (i2 == 18) {
            return true;
        }
        if (i2 == 1) {
            return u(context, "com.google.android.gms");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static boolean p(@NonNull Context context, int i2) {
        if (i2 == 9) {
            return u(context, "com.android.vending");
        }
        return false;
    }

    @TargetApi(18)
    @KeepForSdk
    public static boolean q(@NonNull Context context) {
        if (!PlatformVersion.g()) {
            return false;
        }
        Object systemService = context.getSystemService("user");
        Preconditions.r(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && PdfBoolean.l3.equals(applicationRestrictions.getString("restricted_profile"));
    }

    @InlineMe(imports = {"com.google.android.gms.common.util.DeviceProperties"}, replacement = "DeviceProperties.isSidewinder(context)")
    @ShowFirstParty
    @KeepForSdk
    @Deprecated
    public static boolean r(@NonNull Context context) {
        return DeviceProperties.g(context);
    }

    @KeepForSdk
    @Deprecated
    public static boolean s(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 9;
    }

    @InlineMe(imports = {"com.google.android.gms.common.util.UidVerifier"}, replacement = "UidVerifier.uidHasPackageName(context, uid, packageName)")
    @TargetApi(19)
    @KeepForSdk
    @Deprecated
    public static boolean t(@NonNull Context context, int i2, @NonNull String str) {
        return UidVerifier.b(context, i2, str);
    }

    @TargetApi(21)
    static boolean u(Context context, String str) {
        boolean equals = str.equals("com.google.android.gms");
        if (PlatformVersion.j()) {
            try {
                for (PackageInstaller.SessionInfo appPackageName : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(appPackageName.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
            if (equals) {
                return applicationInfo.enabled;
            }
            return applicationInfo.enabled && !q(context);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
    }
}
