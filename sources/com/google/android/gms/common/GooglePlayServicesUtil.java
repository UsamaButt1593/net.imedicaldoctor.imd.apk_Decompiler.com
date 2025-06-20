package com.google.android.gms.common;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.HideFirstParty;
import com.google.android.gms.common.internal.zag;
import com.google.android.gms.common.util.VisibleForTesting;

public final class GooglePlayServicesUtil extends GooglePlayServicesUtilLight {
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    public static final String f19879k = "GooglePlayServicesErrorDialog";
    @Deprecated

    /* renamed from: l  reason: collision with root package name */
    public static final int f19880l = GooglePlayServicesUtilLight.f19883a;
    @NonNull
    @Deprecated

    /* renamed from: m  reason: collision with root package name */
    public static final String f19881m = "com.google.android.gms";
    @NonNull

    /* renamed from: n  reason: collision with root package name */
    public static final String f19882n = "com.android.vending";

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static void A(int i2, @NonNull Context context) {
        GoogleApiAvailability x = GoogleApiAvailability.x();
        if (GooglePlayServicesUtilLight.o(context, i2) || GooglePlayServicesUtilLight.p(context, i2)) {
            x.J(context);
        } else {
            x.C(context, i2);
        }
    }

    @NonNull
    @Deprecated
    public static PendingIntent f(int i2, @NonNull Context context, int i3) {
        return GooglePlayServicesUtilLight.f(i2, context, i3);
    }

    @NonNull
    @Deprecated
    @VisibleForTesting
    public static String g(int i2) {
        return GooglePlayServicesUtilLight.g(i2);
    }

    @NonNull
    public static Context i(@NonNull Context context) {
        return GooglePlayServicesUtilLight.i(context);
    }

    @NonNull
    public static Resources j(@NonNull Context context) {
        return GooglePlayServicesUtilLight.j(context);
    }

    @Deprecated
    @HideFirstParty
    public static int l(@NonNull Context context) {
        return GooglePlayServicesUtilLight.l(context);
    }

    @KeepForSdk
    @Deprecated
    public static int m(@NonNull Context context, int i2) {
        return GooglePlayServicesUtilLight.m(context, i2);
    }

    @Deprecated
    public static boolean s(int i2) {
        return GooglePlayServicesUtilLight.s(i2);
    }

    @Deprecated
    @Nullable
    public static Dialog v(int i2, @NonNull Activity activity, int i3) {
        return w(i2, activity, i3, (DialogInterface.OnCancelListener) null);
    }

    @Deprecated
    @Nullable
    public static Dialog w(int i2, @NonNull Activity activity, int i3, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.o(activity, i2)) {
            i2 = 18;
        }
        return GoogleApiAvailability.x().t(activity, i2, i3, onCancelListener);
    }

    @Deprecated
    public static boolean x(int i2, @NonNull Activity activity, int i3) {
        return y(i2, activity, i3, (DialogInterface.OnCancelListener) null);
    }

    @Deprecated
    public static boolean y(int i2, @NonNull Activity activity, int i3, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        return z(i2, activity, (Fragment) null, i3, onCancelListener);
    }

    public static boolean z(int i2, @NonNull Activity activity, @Nullable Fragment fragment, int i3, @Nullable DialogInterface.OnCancelListener onCancelListener) {
        if (true == GooglePlayServicesUtilLight.o(activity, i2)) {
            i2 = 18;
        }
        GoogleApiAvailability x = GoogleApiAvailability.x();
        if (fragment == null) {
            return x.B(activity, i2, i3, onCancelListener);
        }
        Dialog E = x.E(activity, i2, zag.c(fragment, GoogleApiAvailability.x().e(activity, i2, "d"), i3), onCancelListener);
        if (E == null) {
            return false;
        }
        x.H(activity, E, f19879k, onCancelListener);
        return true;
    }
}
