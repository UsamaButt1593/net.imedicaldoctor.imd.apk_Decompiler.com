package androidx.core.content.pm;

import android.annotation.SuppressLint;
import android.content.pm.PermissionInfo;
import android.os.Build;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class PermissionInfoCompat {

    @RequiresApi(28)
    static class Api28Impl {
        private Api28Impl() {
        }

        @DoNotInline
        static int a(PermissionInfo permissionInfo) {
            return permissionInfo.getProtection();
        }

        @DoNotInline
        static int b(PermissionInfo permissionInfo) {
            return permissionInfo.getProtectionFlags();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Protection {
    }

    @SuppressLint({"UniqueConstants"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ProtectionFlags {
    }

    private PermissionInfoCompat() {
    }

    @SuppressLint({"WrongConstant"})
    public static int a(@NonNull PermissionInfo permissionInfo) {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.a(permissionInfo) : permissionInfo.protectionLevel & 15;
    }

    @SuppressLint({"WrongConstant"})
    public static int b(@NonNull PermissionInfo permissionInfo) {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.b(permissionInfo) : permissionInfo.protectionLevel & -16;
    }
}
