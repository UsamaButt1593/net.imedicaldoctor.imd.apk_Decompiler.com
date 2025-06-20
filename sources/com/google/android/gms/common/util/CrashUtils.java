package com.google.android.gms.common.util;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

@KeepForSdk
public final class CrashUtils {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f20360a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    @ResultIgnorabilityUnspecified
    @KeepForSdk
    public static boolean a(@NonNull Context context, @NonNull Throwable th) {
        try {
            Preconditions.r(context);
            Preconditions.r(th);
            return false;
        } catch (Exception e2) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e2);
            return false;
        }
    }
}
