package com.google.android.gms.common.util;

import android.os.Build;
import androidx.annotation.ChecksSdkIntAtLeast;
import androidx.core.os.BuildCompat;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class PlatformVersion {
    private PlatformVersion() {
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 11)
    public static boolean a() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 12)
    public static boolean b() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 14)
    public static boolean c() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 15)
    public static boolean d() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 16)
    public static boolean e() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 17)
    public static boolean f() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 18)
    public static boolean g() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 19)
    public static boolean h() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 20)
    public static boolean i() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 21)
    public static boolean j() {
        return true;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 22)
    public static boolean k() {
        return Build.VERSION.SDK_INT >= 22;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 23)
    public static boolean l() {
        return Build.VERSION.SDK_INT >= 23;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 24)
    public static boolean m() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 26)
    public static boolean n() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 28)
    public static boolean o() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 29)
    public static boolean p() {
        return Build.VERSION.SDK_INT >= 29;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 30)
    public static boolean q() {
        return Build.VERSION.SDK_INT >= 30;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 31)
    public static boolean r() {
        return Build.VERSION.SDK_INT >= 31;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 32)
    public static boolean s() {
        return Build.VERSION.SDK_INT >= 32;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 33)
    public static boolean t() {
        return Build.VERSION.SDK_INT >= 33;
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 33, codename = "UpsideDownCake")
    public static boolean u() {
        if (!t()) {
            return false;
        }
        return BuildCompat.l();
    }

    @KeepForSdk
    @ChecksSdkIntAtLeast(api = 34, codename = "VanillaIceCream")
    public static boolean v() {
        if (!u()) {
            return false;
        }
        return BuildCompat.m();
    }
}
