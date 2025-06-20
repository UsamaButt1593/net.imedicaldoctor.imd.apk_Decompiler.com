package com.google.android.gms.stats;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@ShowFirstParty
@KeepForSdk
@Retention(RetentionPolicy.SOURCE)
public @interface CodePackage {
    @NonNull
    @KeepForSdk

    /* renamed from: m  reason: collision with root package name */
    public static final String f20502m = "COMMON";
    @NonNull
    @KeepForSdk

    /* renamed from: n  reason: collision with root package name */
    public static final String f20503n = "FITNESS";
    @NonNull
    @KeepForSdk
    public static final String o = "DRIVE";
    @NonNull
    @KeepForSdk
    public static final String p = "GCM";
    @NonNull
    @KeepForSdk
    public static final String q = "LOCATION_SHARING";
    @NonNull
    @KeepForSdk
    public static final String r = "LOCATION";
    @NonNull
    @KeepForSdk
    public static final String s = "OTA";
    @NonNull
    @KeepForSdk
    public static final String t = "SECURITY";
    @NonNull
    @KeepForSdk
    public static final String u = "REMINDERS";
    @NonNull
    @KeepForSdk
    public static final String v = "ICING";
}
