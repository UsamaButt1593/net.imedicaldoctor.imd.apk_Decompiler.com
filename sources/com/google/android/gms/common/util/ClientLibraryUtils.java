package com.google.android.gms.common.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.Wrappers;

@KeepForSdk
public class ClientLibraryUtils {
    private ClientLibraryUtils() {
    }

    @KeepForSdk
    public static int a(@NonNull Context context, @NonNull String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        PackageInfo b2 = b(context, str);
        if (b2 == null || (applicationInfo = b2.applicationInfo) == null || (bundle = applicationInfo.metaData) == null) {
            return -1;
        }
        return bundle.getInt("com.google.android.gms.version", -1);
    }

    @KeepForSdk
    @Nullable
    public static PackageInfo b(@NonNull Context context, @NonNull String str) {
        try {
            return Wrappers.a(context).f(str, 128);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @KeepForSdk
    public static boolean c() {
        return false;
    }
}
