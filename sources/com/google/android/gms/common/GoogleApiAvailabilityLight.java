package com.google.android.gms.common;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media3.common.C;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.common.zzd;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

@ShowFirstParty
@KeepForSdk
public class GoogleApiAvailabilityLight {
    @KeepForSdk

    /* renamed from: a  reason: collision with root package name */
    public static final int f19873a = GooglePlayServicesUtilLight.f19883a;
    @NonNull
    @KeepForSdk

    /* renamed from: b  reason: collision with root package name */
    public static final String f19874b = "com.google.android.gms";
    @NonNull
    @KeepForSdk

    /* renamed from: c  reason: collision with root package name */
    public static final String f19875c = "com.android.vending";
    @KeepForSdk

    /* renamed from: d  reason: collision with root package name */
    static final String f19876d = "d";
    @KeepForSdk

    /* renamed from: e  reason: collision with root package name */
    static final String f19877e = "n";

    /* renamed from: f  reason: collision with root package name */
    private static final GoogleApiAvailabilityLight f19878f = new GoogleApiAvailabilityLight();

    @KeepForSdk
    GoogleApiAvailabilityLight() {
    }

    @ShowFirstParty
    @NonNull
    @KeepForSdk
    public static GoogleApiAvailabilityLight i() {
        return f19878f;
    }

    @KeepForSdk
    public void a(@NonNull Context context) {
        GooglePlayServicesUtilLight.a(context);
    }

    @ShowFirstParty
    @KeepForSdk
    public int b(@NonNull Context context) {
        return GooglePlayServicesUtilLight.d(context);
    }

    @ShowFirstParty
    @KeepForSdk
    public int c(@NonNull Context context) {
        return GooglePlayServicesUtilLight.e(context);
    }

    @ShowFirstParty
    @Nullable
    @KeepForSdk
    @Deprecated
    public Intent d(int i2) {
        return e((Context) null, i2, (String) null);
    }

    @ShowFirstParty
    @KeepForSdk
    @Nullable
    public Intent e(@Nullable Context context, int i2, @Nullable String str) {
        if (i2 == 1 || i2 == 2) {
            if (context == null || !DeviceProperties.m(context)) {
                StringBuilder sb = new StringBuilder();
                sb.append("gcore_");
                sb.append(f19873a);
                sb.append("-");
                if (!TextUtils.isEmpty(str)) {
                    sb.append(str);
                }
                sb.append("-");
                if (context != null) {
                    sb.append(context.getPackageName());
                }
                sb.append("-");
                if (context != null) {
                    try {
                        sb.append(Wrappers.a(context).f(context.getPackageName(), 0).versionCode);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                String sb2 = sb.toString();
                Intent intent = new Intent("android.intent.action.VIEW");
                Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
                if (!TextUtils.isEmpty(sb2)) {
                    appendQueryParameter.appendQueryParameter("pcampaignid", sb2);
                }
                intent.setData(appendQueryParameter.build());
                intent.setPackage("com.android.vending");
                intent.addFlags(524288);
                return intent;
            }
            Intent intent2 = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
            intent2.setPackage("com.google.android.wearable.app");
            return intent2;
        } else if (i2 != 3) {
            return null;
        } else {
            Uri fromParts = Uri.fromParts("package", "com.google.android.gms", (String) null);
            Intent intent3 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent3.setData(fromParts);
            return intent3;
        }
    }

    @KeepForSdk
    @Nullable
    public PendingIntent f(@NonNull Context context, int i2, int i3) {
        return g(context, i2, i3, (String) null);
    }

    @ShowFirstParty
    @KeepForSdk
    @Nullable
    public PendingIntent g(@NonNull Context context, int i2, int i3, @Nullable String str) {
        Intent e2 = e(context, i2, str);
        if (e2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i3, e2, zzd.zza | C.S0);
    }

    @NonNull
    @KeepForSdk
    public String h(int i2) {
        return GooglePlayServicesUtilLight.g(i2);
    }

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    @HideFirstParty
    public int j(@NonNull Context context) {
        return k(context, f19873a);
    }

    @KeepForSdk
    public int k(@NonNull Context context, int i2) {
        int m2 = GooglePlayServicesUtilLight.m(context, i2);
        if (GooglePlayServicesUtilLight.o(context, m2)) {
            return 18;
        }
        return m2;
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean l(@NonNull Context context, int i2) {
        return GooglePlayServicesUtilLight.o(context, i2);
    }

    @ShowFirstParty
    @KeepForSdk
    public boolean m(@NonNull Context context, int i2) {
        return GooglePlayServicesUtilLight.p(context, i2);
    }

    @KeepForSdk
    public boolean n(@NonNull Context context, @NonNull String str) {
        return GooglePlayServicesUtilLight.u(context, str);
    }

    @KeepForSdk
    public boolean o(int i2) {
        return GooglePlayServicesUtilLight.s(i2);
    }

    @KeepForSdk
    public void p(@NonNull Context context, int i2) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        GooglePlayServicesUtilLight.c(context, i2);
    }
}
