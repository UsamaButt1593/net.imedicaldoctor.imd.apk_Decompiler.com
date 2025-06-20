package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.GoogleSignatureVerifier;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
public final class UidVerifier {
    private UidVerifier() {
    }

    @KeepForSdk
    public static boolean a(@NonNull Context context, int i2) {
        if (!b(context, i2, "com.google.android.gms")) {
            return false;
        }
        try {
            return GoogleSignatureVerifier.a(context).b(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException unused) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return false;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return false;
        }
    }

    @TargetApi(19)
    @KeepForSdk
    public static boolean b(@NonNull Context context, int i2, @NonNull String str) {
        return Wrappers.a(context).h(i2, str);
    }
}
