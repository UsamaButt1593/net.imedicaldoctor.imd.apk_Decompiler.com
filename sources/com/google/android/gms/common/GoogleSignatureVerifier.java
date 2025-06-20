package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.Set;
import javax.annotation.Nullable;

@RestrictedInheritance(allowedOnPath = ".*java.*/com/google/android/gms/common/testing/.*", explanation = "Sub classing of GMS Core's APIs are restricted to testing fakes.", link = "go/gmscore-restrictedinheritance")
@ShowFirstParty
@KeepForSdk
@CheckReturnValue
public class GoogleSignatureVerifier {
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static GoogleSignatureVerifier f19893c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static volatile Set f19894d;

    /* renamed from: a  reason: collision with root package name */
    private final Context f19895a;

    /* renamed from: b  reason: collision with root package name */
    private volatile String f19896b;

    public GoogleSignatureVerifier(@NonNull Context context) {
        this.f19895a = context.getApplicationContext();
    }

    @NonNull
    @KeepForSdk
    public static GoogleSignatureVerifier a(@NonNull Context context) {
        Preconditions.r(context);
        synchronized (GoogleSignatureVerifier.class) {
            try {
                if (f19893c == null) {
                    zzn.e(context);
                    f19893c = new GoogleSignatureVerifier(context);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return f19893c;
    }

    @Nullable
    static final zzj e(PackageInfo packageInfo, zzj... zzjArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr != null) {
            if (signatureArr.length != 1) {
                Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
                return null;
            }
            zzk zzk = new zzk(packageInfo.signatures[0].toByteArray());
            for (int i2 = 0; i2 < zzjArr.length; i2++) {
                if (zzjArr[i2].equals(zzk)) {
                    return zzjArr[i2];
                }
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0045 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean f(@androidx.annotation.NonNull android.content.pm.PackageInfo r4, boolean r5) {
        /*
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0027
            if (r4 == 0) goto L_0x0029
            java.lang.String r2 = "com.android.vending"
            java.lang.String r3 = r4.packageName
            boolean r2 = r2.equals(r3)
            if (r2 != 0) goto L_0x001a
            java.lang.String r2 = r4.packageName
            java.lang.String r3 = "com.google.android.gms"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0027
        L_0x001a:
            android.content.pm.ApplicationInfo r5 = r4.applicationInfo
            if (r5 != 0) goto L_0x0020
        L_0x001e:
            r5 = 0
            goto L_0x0027
        L_0x0020:
            int r5 = r5.flags
            r5 = r5 & 129(0x81, float:1.81E-43)
            if (r5 == 0) goto L_0x001e
            r5 = 1
        L_0x0027:
            r2 = r4
            goto L_0x002a
        L_0x0029:
            r2 = 0
        L_0x002a:
            if (r4 == 0) goto L_0x0046
            android.content.pm.Signature[] r4 = r2.signatures
            if (r4 == 0) goto L_0x0046
            com.google.android.gms.common.zzj[] r4 = com.google.android.gms.common.zzm.f20425a
            if (r5 == 0) goto L_0x0039
            com.google.android.gms.common.zzj r4 = e(r2, r4)
            goto L_0x0043
        L_0x0039:
            r4 = r4[r1]
            com.google.android.gms.common.zzj[] r5 = new com.google.android.gms.common.zzj[r0]
            r5[r1] = r4
            com.google.android.gms.common.zzj r4 = e(r2, r5)
        L_0x0043:
            if (r4 == 0) goto L_0x0046
            return r0
        L_0x0046:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.GoogleSignatureVerifier.f(android.content.pm.PackageInfo, boolean):boolean");
    }

    @SuppressLint({"PackageManagerGetSignatures"})
    private final zzx g(@Nullable String str, boolean z, boolean z2) {
        zzx zzx;
        ApplicationInfo applicationInfo;
        String str2 = "null pkg";
        if (str == null) {
            return zzx.c(str2);
        }
        if (str.equals(this.f19896b)) {
            return zzx.b();
        }
        if (zzn.g()) {
            zzx = zzn.b(str, GooglePlayServicesUtilLight.k(this.f19895a), false, false);
        } else {
            try {
                PackageInfo packageInfo = this.f19895a.getPackageManager().getPackageInfo(str, 64);
                boolean k2 = GooglePlayServicesUtilLight.k(this.f19895a);
                if (packageInfo != null) {
                    Signature[] signatureArr = packageInfo.signatures;
                    if (signatureArr == null || signatureArr.length != 1) {
                        str2 = "single cert required";
                    } else {
                        zzk zzk = new zzk(packageInfo.signatures[0].toByteArray());
                        String str3 = packageInfo.packageName;
                        zzx a2 = zzn.a(str3, zzk, k2, false);
                        if (!a2.f20435a || (applicationInfo = packageInfo.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !zzn.a(str3, zzk, false, true).f20435a) {
                            zzx = a2;
                        } else {
                            str2 = "debuggable release cert app rejected";
                        }
                    }
                }
                zzx = zzx.c(str2);
            } catch (PackageManager.NameNotFoundException e2) {
                return zzx.d("no pkg ".concat(str), e2);
            }
        }
        if (zzx.f20435a) {
            this.f19896b = str;
        }
        return zzx;
    }

    @KeepForSdk
    public boolean b(@NonNull PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (f(packageInfo, false)) {
            return true;
        }
        if (f(packageInfo, true)) {
            if (GooglePlayServicesUtilLight.k(this.f19895a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean c(@Nullable String str) {
        zzx g2 = g(str, false, false);
        g2.e();
        return g2.f20435a;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean d(int i2) {
        zzx zzx;
        int length;
        String[] packagesForUid = this.f19895a.getPackageManager().getPackagesForUid(i2);
        if (packagesForUid != null && (length = packagesForUid.length) != 0) {
            zzx = null;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    Preconditions.r(zzx);
                    break;
                }
                zzx = g(packagesForUid[i3], false, false);
                if (zzx.f20435a) {
                    break;
                }
                i3++;
            }
        } else {
            zzx = zzx.c("no pkgs");
        }
        zzx.e();
        return zzx.f20435a;
    }
}
