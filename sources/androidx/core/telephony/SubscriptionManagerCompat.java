package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.core.content.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RequiresApi(22)
public class SubscriptionManagerCompat {

    /* renamed from: a  reason: collision with root package name */
    private static Method f6153a;

    @RequiresApi(29)
    private static class Api29Impl {
        private Api29Impl() {
        }

        @DoNotInline
        static int a(int i2) {
            return SubscriptionManager.getSlotIndex(i2);
        }
    }

    private SubscriptionManagerCompat() {
    }

    public static int a(int i2) {
        Method declaredMethod;
        if (i2 == -1) {
            return -1;
        }
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 29) {
            return Api29Impl.a(i2);
        }
        try {
            if (f6153a == null) {
                if (i3 >= 26) {
                    declaredMethod = a.a().getDeclaredMethod("getSlotIndex", new Class[]{Integer.TYPE});
                } else {
                    declaredMethod = a.a().getDeclaredMethod("getSlotId", new Class[]{Integer.TYPE});
                }
                f6153a = declaredMethod;
                f6153a.setAccessible(true);
            }
            Integer num = (Integer) f6153a.invoke((Object) null, new Object[]{Integer.valueOf(i2)});
            if (num != null) {
                return num.intValue();
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return -1;
    }
}
