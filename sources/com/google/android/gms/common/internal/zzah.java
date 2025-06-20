package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.errorprone.annotations.concurrent.GuardedBy;

public final class zzah {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f20299a = new Object();
    @GuardedBy("lock")

    /* renamed from: b  reason: collision with root package name */
    private static boolean f20300b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static String f20301c;

    /* renamed from: d  reason: collision with root package name */
    private static int f20302d;

    public static int a(Context context) {
        c(context);
        return f20302d;
    }

    @Nullable
    public static String b(Context context) {
        c(context);
        return f20301c;
    }

    private static void c(Context context) {
        synchronized (f20299a) {
            try {
                if (!f20300b) {
                    f20300b = true;
                    Bundle bundle = Wrappers.a(context).c(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        f20301c = bundle.getString("com.google.app.id");
                        f20302d = bundle.getInt("com.google.android.gms.version");
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("MetadataValueReader", "This should never happen.", e2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
