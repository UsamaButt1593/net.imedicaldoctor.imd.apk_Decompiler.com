package androidx.core.telephony;

import android.annotation.SuppressLint;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RequiresPermission;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TelephonyManagerCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Method f6154a;

    /* renamed from: b  reason: collision with root package name */
    private static Method f6155b;

    @RequiresApi(23)
    private static class Api23Impl {
        private Api23Impl() {
        }

        @DoNotInline
        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission("android.permission.READ_PHONE_STATE")
        static String a(TelephonyManager telephonyManager, int i2) {
            return telephonyManager.getDeviceId(i2);
        }
    }

    @RequiresApi(26)
    private static class Api26Impl {
        private Api26Impl() {
        }

        @DoNotInline
        @SuppressLint({"MissingPermission"})
        @Nullable
        @RequiresPermission("android.permission.READ_PHONE_STATE")
        static String a(TelephonyManager telephonyManager) {
            return telephonyManager.getImei();
        }
    }

    @RequiresApi(30)
    private static class Api30Impl {
        private Api30Impl() {
        }

        @DoNotInline
        static int a(TelephonyManager telephonyManager) {
            return telephonyManager.getSubscriptionId();
        }
    }

    private TelephonyManagerCompat() {
    }

    @RequiresPermission("android.permission.READ_PHONE_STATE")
    @SuppressLint({"MissingPermission"})
    @Nullable
    public static String a(@NonNull TelephonyManager telephonyManager) {
        int b2;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 26) {
            return Api26Impl.a(telephonyManager);
        }
        if (i2 < 22 || (b2 = b(telephonyManager)) == Integer.MAX_VALUE || b2 == -1) {
            return telephonyManager.getDeviceId();
        }
        int a2 = SubscriptionManagerCompat.a(b2);
        if (i2 >= 23) {
            return Api23Impl.a(telephonyManager, a2);
        }
        try {
            if (f6154a == null) {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getDeviceId", new Class[]{Integer.TYPE});
                f6154a = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            return (String) f6154a.invoke(telephonyManager, new Object[]{Integer.valueOf(a2)});
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return null;
        }
    }

    @SuppressLint({"SoonBlockedPrivateApi"})
    public static int b(@NonNull TelephonyManager telephonyManager) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 30) {
            return Api30Impl.a(telephonyManager);
        }
        if (i2 < 22) {
            return Integer.MAX_VALUE;
        }
        try {
            if (f6155b == null) {
                Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getSubId", (Class[]) null);
                f6155b = declaredMethod;
                declaredMethod.setAccessible(true);
            }
            Integer num = (Integer) f6155b.invoke(telephonyManager, (Object[]) null);
            if (num == null || num.intValue() == -1) {
                return Integer.MAX_VALUE;
            }
            return num.intValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return Integer.MAX_VALUE;
        }
    }
}
