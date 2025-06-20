package androidx.media3.common.util;

import android.os.Bundle;
import android.os.IBinder;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@UnstableApi
public final class BundleUtil {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9499a = "BundleUtil";
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static Method f9500b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private static Method f9501c;

    private BundleUtil() {
    }

    @Nullable
    public static IBinder a(Bundle bundle, @Nullable String str) {
        return Util.f9646a >= 18 ? bundle.getBinder(str) : b(bundle, str);
    }

    @Nullable
    private static IBinder b(Bundle bundle, @Nullable String str) {
        String str2;
        Method method = f9500b;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("getIBinder", new Class[]{String.class});
                f9500b = method2;
                method2.setAccessible(true);
                method = f9500b;
            } catch (NoSuchMethodException e2) {
                e = e2;
                str2 = "Failed to retrieve getIBinder method";
                Log.i(f9499a, str2, e);
                return null;
            }
        }
        try {
            return (IBinder) method.invoke(bundle, new Object[]{str});
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
            e = e3;
            str2 = "Failed to invoke getIBinder via reflection";
            Log.i(f9499a, str2, e);
            return null;
        }
    }

    public static void c(Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        if (Util.f9646a >= 18) {
            bundle.putBinder(str, iBinder);
        } else {
            d(bundle, str, iBinder);
        }
    }

    private static void d(Bundle bundle, @Nullable String str, @Nullable IBinder iBinder) {
        Method method = f9501c;
        if (method == null) {
            try {
                Method method2 = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                f9501c = method2;
                method2.setAccessible(true);
                method = f9501c;
            } catch (NoSuchMethodException e2) {
                Log.i(f9499a, "Failed to retrieve putIBinder method", e2);
                return;
            }
        }
        try {
            method.invoke(bundle, new Object[]{str, iBinder});
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e3) {
            Log.i(f9499a, "Failed to invoke putIBinder via reflection", e3);
        }
    }
}
