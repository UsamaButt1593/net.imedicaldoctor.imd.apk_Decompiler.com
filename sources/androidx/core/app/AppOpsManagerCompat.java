package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public final class AppOpsManagerCompat {

    /* renamed from: a  reason: collision with root package name */
    public static final int f5230a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static final int f5231b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f5232c = 2;

    /* renamed from: d  reason: collision with root package name */
    public static final int f5233d = 3;

    @RequiresApi(23)
    static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        static <T> T a(Context context, Class<T> cls) {
            return context.getSystemService(cls);
        }

        @DoNotInline
        static int b(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOp(str, str2);
        }

        @DoNotInline
        static int c(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }

        @DoNotInline
        static String d(String str) {
            return AppOpsManager.permissionToOp(str);
        }
    }

    @RequiresApi(29)
    static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static int a(@Nullable AppOpsManager appOpsManager, @NonNull String str, int i2, @NonNull String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i2, str2);
        }

        @DoNotInline
        @NonNull
        static String b(@NonNull Context context) {
            return context.getOpPackageName();
        }

        @DoNotInline
        @Nullable
        static AppOpsManager c(@NonNull Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    private AppOpsManagerCompat() {
    }

    public static int a(@NonNull Context context, int i2, @NonNull String str, @NonNull String str2) {
        if (Build.VERSION.SDK_INT < 29) {
            return e(context, str, str2);
        }
        AppOpsManager c2 = Api29Impl.c(context);
        int a2 = Api29Impl.a(c2, str, Binder.getCallingUid(), str2);
        return a2 != 0 ? a2 : Api29Impl.a(c2, str, i2, Api29Impl.b(context));
    }

    public static int b(@NonNull Context context, @NonNull String str, int i2, @NonNull String str2) {
        return ((AppOpsManager) context.getSystemService("appops")).noteOp(str, i2, str2);
    }

    public static int c(@NonNull Context context, @NonNull String str, int i2, @NonNull String str2) {
        return ((AppOpsManager) context.getSystemService("appops")).noteOpNoThrow(str, i2, str2);
    }

    public static int d(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.b((AppOpsManager) Api23Impl.a(context, AppOpsManager.class), str, str2);
        }
        return 1;
    }

    public static int e(@NonNull Context context, @NonNull String str, @NonNull String str2) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.c((AppOpsManager) Api23Impl.a(context, AppOpsManager.class), str, str2);
        }
        return 1;
    }

    @Nullable
    public static String f(@NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.d(str);
        }
        return null;
    }
}
