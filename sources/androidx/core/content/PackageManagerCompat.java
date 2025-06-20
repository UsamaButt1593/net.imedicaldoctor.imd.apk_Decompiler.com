package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.concurrent.futures.ResolvableFuture;
import androidx.core.os.UserManagerCompat;
import com.google.common.util.concurrent.ListenableFuture;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.concurrent.Executors;

public final class PackageManagerCompat {
    @RestrictTo({RestrictTo.Scope.LIBRARY})

    /* renamed from: a  reason: collision with root package name */
    public static final String f5676a = "PackageManagerCompat";
    @SuppressLint({"ActionValue"})

    /* renamed from: b  reason: collision with root package name */
    public static final String f5677b = "android.intent.action.AUTO_REVOKE_PERMISSIONS";

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        static boolean a(@NonNull Context context) {
            return !context.getPackageManager().isAutoRevokeWhitelisted();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface UnusedAppRestrictionsStatus {
    }

    private PackageManagerCompat() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean a(@NonNull PackageManager packageManager) {
        int i2 = Build.VERSION.SDK_INT;
        return (i2 >= 30) || ((i2 >= 23 && i2 < 30) && (b(packageManager) != null));
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static String b(@NonNull PackageManager packageManager) {
        String str = null;
        for (ResolveInfo resolveInfo : packageManager.queryIntentActivities(new Intent(f5677b).setData(Uri.fromParts("package", "com.example", (String) null)), 0)) {
            String str2 = resolveInfo.activityInfo.packageName;
            if (packageManager.checkPermission("android.permission.PACKAGE_VERIFICATION_AGENT", str2) == 0) {
                if (str != null) {
                    return str;
                }
                str = str2;
            }
        }
        return str;
    }

    @NonNull
    public static ListenableFuture<Integer> c(@NonNull Context context) {
        int i2;
        ResolvableFuture w = ResolvableFuture.w();
        if (!UserManagerCompat.a(context)) {
            w.q(0);
            Log.e(f5676a, "User is in locked direct boot mode");
            return w;
        } else if (!a(context.getPackageManager())) {
            w.q(1);
            return w;
        } else {
            int i3 = context.getApplicationInfo().targetSdkVersion;
            if (i3 < 30) {
                w.q(0);
                Log.e(f5676a, "Target SDK version below API 30");
                return w;
            }
            int i4 = Build.VERSION.SDK_INT;
            int i5 = 2;
            int i6 = 4;
            if (i4 >= 31) {
                if (Api30Impl.a(context)) {
                    if (i3 >= 31) {
                        i6 = 5;
                    }
                    i2 = Integer.valueOf(i6);
                } else {
                    i2 = 2;
                }
                w.q(i2);
                return w;
            } else if (i4 == 30) {
                if (Api30Impl.a(context)) {
                    i5 = 4;
                }
                w.q(Integer.valueOf(i5));
                return w;
            } else {
                UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection = new UnusedAppRestrictionsBackportServiceConnection(context);
                w.a0(new w(unusedAppRestrictionsBackportServiceConnection), Executors.newSingleThreadExecutor());
                unusedAppRestrictionsBackportServiceConnection.a(w);
                return w;
            }
        }
    }
}
