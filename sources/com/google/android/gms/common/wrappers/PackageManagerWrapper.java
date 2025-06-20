package com.google.android.gms.common.wrappers;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

@KeepForSdk
public class PackageManagerWrapper {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    protected final Context f20409a;

    public PackageManagerWrapper(@NonNull Context context) {
        this.f20409a = context;
    }

    @KeepForSdk
    public int a(@NonNull String str) {
        return this.f20409a.checkCallingOrSelfPermission(str);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public int b(@NonNull String str, @NonNull String str2) {
        return this.f20409a.getPackageManager().checkPermission(str, str2);
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public ApplicationInfo c(@NonNull String str, int i2) throws PackageManager.NameNotFoundException {
        return this.f20409a.getPackageManager().getApplicationInfo(str, i2);
    }

    @NonNull
    @KeepForSdk
    public CharSequence d(@NonNull String str) throws PackageManager.NameNotFoundException {
        Context context = this.f20409a;
        return context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(str, 0));
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public Pair<CharSequence, Drawable> e(@NonNull String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo = this.f20409a.getPackageManager().getApplicationInfo(str, 0);
        return Pair.a(this.f20409a.getPackageManager().getApplicationLabel(applicationInfo), this.f20409a.getPackageManager().getApplicationIcon(applicationInfo));
    }

    @ResultIgnorabilityUnspecified
    @NonNull
    @KeepForSdk
    public PackageInfo f(@NonNull String str, int i2) throws PackageManager.NameNotFoundException {
        return this.f20409a.getPackageManager().getPackageInfo(str, i2);
    }

    @KeepForSdk
    public boolean g() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return InstantApps.a(this.f20409a);
        }
        if (!PlatformVersion.n() || (nameForUid = this.f20409a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.f20409a.getPackageManager().isInstantApp(nameForUid);
    }

    @TargetApi(19)
    public final boolean h(int i2, @NonNull String str) {
        if (PlatformVersion.h()) {
            try {
                AppOpsManager appOpsManager = (AppOpsManager) this.f20409a.getSystemService("appops");
                if (appOpsManager != null) {
                    appOpsManager.checkPackage(i2, str);
                    return true;
                }
                throw new NullPointerException("context.getSystemService(Context.APP_OPS_SERVICE) is null");
            } catch (SecurityException unused) {
                return false;
            }
        } else {
            String[] packagesForUid = this.f20409a.getPackageManager().getPackagesForUid(i2);
            if (!(str == null || packagesForUid == null)) {
                for (String equals : packagesForUid) {
                    if (str.equals(equals)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}
