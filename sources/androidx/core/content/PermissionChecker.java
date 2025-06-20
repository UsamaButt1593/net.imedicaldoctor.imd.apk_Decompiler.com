package androidx.core.content;

import android.content.Context;
import android.os.Binder;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.util.ObjectsCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PermissionChecker {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5678a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5679b = -1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5680c = -2;

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionResult {
    }

    private PermissionChecker() {
    }

    public static int a(@NonNull Context context, @NonNull String str) {
        return c(context, str, Binder.getCallingPid(), Binder.getCallingUid(), Binder.getCallingPid() == Process.myPid() ? context.getPackageName() : null);
    }

    public static int b(@NonNull Context context, @NonNull String str, @Nullable String str2) {
        if (Binder.getCallingPid() == Process.myPid()) {
            return -1;
        }
        return c(context, str, Binder.getCallingPid(), Binder.getCallingUid(), str2);
    }

    public static int c(@NonNull Context context, @NonNull String str, int i2, int i3, @Nullable String str2) {
        if (context.checkPermission(str, i2, i3) == -1) {
            return -1;
        }
        String f2 = AppOpsManagerCompat.f(str);
        if (f2 == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i3);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return ((Process.myUid() != i3 || !ObjectsCompat.a(context.getPackageName(), str2)) ? AppOpsManagerCompat.e(context, f2, str2) : AppOpsManagerCompat.a(context, i3, f2, str2)) == 0 ? 0 : -2;
    }

    public static int d(@NonNull Context context, @NonNull String str) {
        return c(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
